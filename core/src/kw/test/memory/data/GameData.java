package kw.test.memory.data;

import java.util.ArrayList;
import java.util.HashMap;

public class GameData {
    public HashMap<Integer,int[]> hashMap;
    public int num = 0;
    public int step = 0;
    public GameData(){
        hashMap = new HashMap<>();
        hashMap.put(4,new int[]{2,2});
        hashMap.put(8,new int[]{4,2});
        hashMap.put(12,new int[]{3,4});
        hashMap.put(16,new int[]{4,4});
        hashMap.put(18,new int[]{3,6});
        hashMap.put(20,new int[]{4,5});
        hashMap.put(25,new int[]{5,5});
        hashMap.put(30,new int[]{5,6});
    }

    public int[] getHashMap(int num) {
        if (hashMap.containsKey(num)) {
            return hashMap.get(num);
        }
        setNum(4);  // 更新值
        return hashMap.get(4);
    }

    public ArrayList<Integer> getIcon(int num) {
        ArrayList<Integer> icon = new ArrayList();
        ArrayList<Integer> iconShuffle = new ArrayList();

        for (int i = 0; i < num/2; i++) {
            icon.add(i);
            icon.add(i);
        }

        for (int i = 0; i < num; i++) {
            Integer remove = icon.remove((int) Math.floor(Math.random() * icon.size()));
            iconShuffle.add(remove);
        }

        for (Integer integer : iconShuffle) {
            System.out.println(integer);
        }
        return iconShuffle;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void addNum() {
        this.step++;
    }

    public int getStep() {
        return step;
    }
}
