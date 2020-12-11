package catalinc.games.breakfree.world;

import catalinc.games.breakfree.world.entities.Ball;
import catalinc.games.breakfree.world.entities.Brick;
import catalinc.games.breakfree.world.entities.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * Handles state, physics and level loading.
 *
 * World data is loaded from {@code assets/game.properties} file.
 */
public class World {
    private Level level;

    private int width;
    private int height;

    private float maxBounceAngle;
    private int maxLives;
    private int maxLevel;

    private Player player;
    private Ball ball;
    private Array<Brick> bricks;

    private final String spriteSheetPath;
    private final String fontPath;

    private final List<Observer> observers;

    private boolean paused;

    public interface Observer {
        void onNotify(Event event);
    }

    public World (String configFilePath) {
        Properties props = new Properties();
        try {
            try (Reader reader = Gdx.files.internal(configFilePath).reader()) {
                props.load(reader);
            }
        } catch (IOException e) {
            throw new RuntimeException("unable to load world configuration: " + e.getMessage());
        }

        width = Integer.parseInt(props.getProperty("game.world.width"));
        height = Integer.parseInt(props.getProperty("game.world.height"));
        maxBounceAngle = MathUtils.degreesToRadians * Integer.parseInt(props.getProperty("game.phys.maxBounceAngle"));
        maxLives = Integer.parseInt(props.getProperty("game.player.maxLives"));
        maxLevel = Integer.parseInt(props.getProperty("game.player.maxLevel"));

        spriteSheetPath = props.getProperty("game.ui.spriteSheet");
        fontPath = props.getProperty("game.ui.font");

        observers = new LinkedList<>();

        player = new Player();
        ball = new Ball();
        bricks = new Array<>();

        paused = false;
    }

    public void loadLevel(int index) {
        level = new Level("levels/level_" + index + ".properties");

        int playerWidth = level.getInt("player.width");
        int playerHeight = level.getInt("player.height");
        float playerSpeed = level.getInt("player.speed");

        player.setSize(playerWidth, playerHeight);
        player.setSpeed(playerSpeed);
        player.setVelocity(0, 0);
        player.setPosition((this.width - playerWidth) / 2, playerHeight);
        if (level.isFirst()) {
            player.setLives(maxLives);
            player.setScore(0);
        }

        int ballWidth = level.getInt("ball.width");
        int ballHeight = level.getInt("ball.height");
        float ballSpeed = level.getFloat("ball.speed");
        float ballDamage = level.getFloat("ball.damage");

        ball.setSize(ballWidth, ballHeight);
        ball.setDamage(ballDamage);
        ball.setSpeed(ballSpeed);
        ball.setVelocity(0, ballSpeed);
        ball.setPosition(player.getX() + (player.getWidth() - ballWidth) / 2, player.getHeight() + ballHeight);

        int brickWidth = level.getInt("brick.width");
        int brickHeight = level.getInt("brick.height");
        float brickStrength = level.getFloat("brick.strength");
        int brickWalls = level.getInt("brick.walls");

        bricks.clear();
        int bricksPerLine = width / brickWidth;
        for (int i = 1; i <= brickWalls; i++) {
            for (int j = 0; j < bricksPerLine; j++) {
                Brick brick = new Brick(
                        j * brickWidth,
                        height - i * brickHeight - brickHeight,
                        brickWidth,
                        brickHeight,
                        brickStrength);
                bricks.add(brick);
            }
        }

        notifyEvent(Event.LEVEL_LOADED);
    }

    public void loadNextLevel() {
        int index = level != null ? level.getIndex() + 1 : 1;
        loadLevel(index);
    }

    public boolean levelCompleted() {
        return player.isAlive() && bricks.size == 0;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void update(float delta) {
        if (paused) return;

        ball.update(delta);

        for (int i = 0; i < bricks.size; i++) {
            Brick brick = bricks.get(i);
            if (brick.collides(ball)) {
                ball.reverseVelocityY();  //撞击之后，改变方向
                brick.takeDamage(ball);
                if (brick.isDestroyed()) {
                    notifyEvent(Event.BRICK_DESTROYED);
                    bricks.removeIndex(i);
                    player.increaseScore(level.getBrickScorePoints());
                } else {
                    notifyEvent(Event.BRICK_HIT);
                }
                if (bricks.size == 0) {
                    notifyEvent(Event.ALL_BRICKS_DESTROYED);
                }
                break;
            }
        }

        if (ball.getY() < 0) {
            notifyEvent(Event.BALL_DROP);
            player.loseOneLife();
            setupNewRound();
            return;
        }

        if (ball.getX() < 0) {
            ball.setX(0);
            ball.reverseVelocityX();
        }

        if (ball.getX() + ball.getWidth() > width) {
            ball.setX(width - ball.getWidth());
            ball.reverseVelocityX();
        }

        if (ball.getY() + ball.getHeight() > height) {
            ball.reverseVelocityY();
        }

        if (player.collides(ball)) {
            notifyEvent(Event.PADDLE_HIT);

            float half = player.getWidth() / 2;
            float relativeIntersectX = player.getX() + half - (ball.getX() + ball.getWidth() / 2);
            float normalizedRelativeIntersectX = relativeIntersectX / half;
            float bounceAngle = normalizedRelativeIntersectX * maxBounceAngle;

            float x = (float) -(ball.getSpeed() * Math.sin(bounceAngle));
            float y = (float) (ball.getSpeed() * Math.cos(bounceAngle));
            ball.setVelocity(x, y);
        }
    }

    public boolean playerLost() {
        return player.isDead();
    }

    public boolean playerWon() {
        return bricks.size == 0 && level.getIndex() == maxLevel;
    }

    public Level getLevel() {
        return level;
    }

    public Player getPlayer() {
        return player;
    }

    public Ball getBall() {
        return ball;
    }

    public Array<Brick> getBricks() {
        return bricks;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getSpriteSheetPath() {
        return spriteSheetPath;
    }

    public String getFontPath() {
        return fontPath;
    }

    public void pause() {
        paused = true;
    }

    public void resume() {
        paused = false;
    }

    public boolean isPaused() {
        return paused;
    }

    private void setupNewRound() {
        player.setVelocity(0, 0);
        player.setPosition((this.width - player.getWidth()) / 2, player.getHeight());
        ball.setVelocity(0, ball.getSpeed());
        ball.setPosition(player.getX() + (player.getWidth() - ball.getWidth()) / 2, player.getHeight() + ball.getHeight());
    }

    private void notifyEvent(Event event) {
        for (Observer observer : observers) {
            observer.onNotify(event);
        }
    }
}
