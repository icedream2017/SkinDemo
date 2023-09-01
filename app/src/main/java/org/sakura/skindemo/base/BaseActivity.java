package org.sakura.skindemo.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

import org.sakura.skindemo.theme.SkinManager;
import org.sakura.skindemo.utils.LogUtils;

public abstract class BaseActivity extends AppCompatActivity {

    protected String mLogTag = "BaseActivity";

    @LayoutRes
    protected int mLayoutId = 0;

    protected abstract void setLogTag();

    protected abstract void setLayout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(SkinManager.getInstance().getCurrentStyle());
        super.onCreate(savedInstanceState);
        setLogTag();
        setLayout();
        LogUtils.d(mLogTag, "onCreate");
        setContentView(mLayoutId);
        SkinManager.getInstance().setOnThemeChangeListener(theme -> recreate());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.d(mLogTag, "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d(mLogTag, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.d(mLogTag, "onResume");
        LogUtils.i(mLogTag, "current theme = " + SkinManager.getInstance().getCurrentSkin());
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.d(mLogTag, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.d(mLogTag, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.d(mLogTag, "onDestroy");
        SkinManager.getInstance().setOnThemeChangeListener(null);
    }

}
