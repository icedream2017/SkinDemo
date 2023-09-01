package org.sakura.skindemo;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

import org.sakura.skindemo.theme.SkinManager;
import org.sakura.skindemo.utils.LogUtils;

public class MainApplication extends Application {

    private static Context sApplicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.setDebugMode(true);
        LogUtils.printCurrentStackTrace();
        sApplicationContext = getApplicationContext();
        SkinManager skinManager = SkinManager.getInstance();
        skinManager.init(sApplicationContext);
        skinManager.applyTheme(skinManager.getCurrentSkin(), false);
    }

    public static Context getAppContext() {
        return sApplicationContext;
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
