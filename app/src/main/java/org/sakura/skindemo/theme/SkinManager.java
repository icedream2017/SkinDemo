package org.sakura.skindemo.theme;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

import org.sakura.skindemo.R;
import org.sakura.skindemo.utils.LogUtils;

public class SkinManager {

    private static final String TAG = "SkinManager";

    private Context mApplicationContext;
    @ThemeStyle
    private String mCurrentSkinSet = ThemeStyle.DEFAULT;
    @StyleRes
    private int mStyle = 0;
    private OnThemeChangeListener mOnThemeChangeListener;

    private SkinManager() {
        // singleton class.
    }

    private static final class SingletonHolder {
        private static final SkinManager INSTANCE = new SkinManager();
    }

    public static SkinManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(@NonNull Context context) {
        this.mApplicationContext = context;
        loadFromSharedPreference();
    }

    public void setOnThemeChangeListener(OnThemeChangeListener listener) {
        this.mOnThemeChangeListener = listener;
    }

    public String getCurrentSkin() {
        return mCurrentSkinSet;
    }

    @StyleRes
    public int getCurrentStyle() {
        return mStyle;
    }

    public void applyTheme(@ThemeStyle String theme, boolean refresh) {
        mCurrentSkinSet = theme;
        mStyle = R.style.Theme_SkinDemo_Zhongli;
        switch (theme) {
            case ThemeStyle.GANYU:
                mStyle = R.style.Theme_SkinDemo_Ganyu;
                break;
            case ThemeStyle.HUTAO:
                mStyle = R.style.Theme_SkinDemo_Hutao;
                break;
            case ThemeStyle.KEQING:
                mStyle = R.style.Theme_SkinDemo_Keqing;
                break;
            case ThemeStyle.XIANGLING:
                mStyle = R.style.Theme_SkinDemo_Xiangling;
                break;
            case ThemeStyle.XIAO:
                mStyle = R.style.Theme_SkinDemo_Xiao;
                break;
            default:
                break;
        }
        if (mApplicationContext != null) {
            mApplicationContext.setTheme(mStyle);
            saveToSharedPreference();
        }
        if (refresh && mOnThemeChangeListener != null) {
            mOnThemeChangeListener.onThemeChanged(mStyle);
        }
        LogUtils.d(TAG, "theme changed to " + mCurrentSkinSet);
    }

    private void loadFromSharedPreference() {
        SharedPreferences preferences = mApplicationContext.getSharedPreferences("theme", Context.MODE_PRIVATE);
        mCurrentSkinSet = preferences.getString("currentTheme", ThemeStyle.ZHONGLI);
    }

    private void saveToSharedPreference() {
        SharedPreferences preferences = mApplicationContext.getSharedPreferences("theme", Context.MODE_PRIVATE);
        preferences.edit().putString("currentTheme", mCurrentSkinSet).apply();
    }

}
