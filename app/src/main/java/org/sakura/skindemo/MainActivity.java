package org.sakura.skindemo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

import org.sakura.skindemo.adapter.SkinListAdapter;
import org.sakura.skindemo.base.BaseActivity;
import org.sakura.skindemo.theme.SkinManager;
import org.sakura.skindemo.theme.ThemeStyle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

//    private QMUISkinManager skinManager;

    private Button confirmButton;
    private Button openDialogButton;
    private Spinner skinList;

    @Override
    protected void setLogTag() {
        mLogTag = TAG;
    }

    @Override
    protected void setLayout() {
        mLayoutId = R.layout.activity_main;
    }

    private void initView() {
        confirmButton = findViewById(R.id.button_confirm);
        openDialogButton = findViewById(R.id.button_open_dialog);
        skinList = findViewById(R.id.list_skin);
        SkinListAdapter skinListAdapter = new SkinListAdapter(this, getSkinListData());
        skinList.setAdapter(skinListAdapter);
        skinList.setSelection(skinListAdapter.getPositionByItem(SkinManager.getInstance().getCurrentSkin()));
        confirmButton.setOnClickListener(v -> confirmChangeSkin());
    }

    private void confirmChangeSkin() {
        String selectTheme = skinList.getSelectedItem().toString();
        SkinManager.getInstance().applyTheme(selectTheme, true);
    }

    private List<String> getSkinListData() {
        List<String> list = new ArrayList<>();
        list.add(ThemeStyle.GANYU);
        list.add(ThemeStyle.HUTAO);
        list.add(ThemeStyle.KEQING);
        list.add(ThemeStyle.XIANGLING);
        list.add(ThemeStyle.XIAO);
        list.add(ThemeStyle.ZHONGLI);
        return list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
//        LayoutInflater inflater = LayoutInflater.from(this);
//        LayoutInflaterCompat.setFactory2();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}