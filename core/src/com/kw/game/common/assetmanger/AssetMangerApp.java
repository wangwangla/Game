package com.kw.game.common.assetmanger;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;

public class AssetMangerApp extends AssetManager {
    public AssetMangerApp() {
    }

    public AssetMangerApp(FileHandleResolver resolver) {
        super(resolver);
    }

    public AssetMangerApp(FileHandleResolver resolver, boolean defaultLoaders) {
        super(resolver, defaultLoaders);
    }

    @Override
    public synchronized <T> void load(String fileName, Class<T> type) {
        if(isLoaded(fileName)) return;
        if(!getFileHandleResolver().resolve(fileName).exists()) return;
        super.load(fileName, type);
    }

    @Override
    public synchronized <T> void load(String fileName, Class<T> type, AssetLoaderParameters<T> parameter) {
        if(isLoaded(fileName)) return;
        if(!getFileHandleResolver().resolve(fileName).exists()) return;
        super.load(fileName, type, parameter);
    }

    @Override
    public synchronized void unload(String fileName) {
        if(isLoaded(fileName)) {
            super.unload(fileName);
        }
    }

    public <T> void loadImmediately(String fileName, Class<T> type){
        if(isLoaded(fileName)) return;
        if(!getFileHandleResolver().resolve(fileName).exists()) return;
        super.load(fileName,type);
        finishLoading();
    }
    public <T> void loadImmediately(String fileName, Class<T> type, AssetLoaderParameters parameters){
        if(isLoaded(fileName)) return;
        if(!getFileHandleResolver().resolve(fileName).exists()) return;
        super.load(fileName,type,parameters);
        finishLoading();
    }
}
