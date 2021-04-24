package com.luyuanyuan.muiscplayer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.luyuanyuan.muiscplayer.R;
import com.luyuanyuan.muiscplayer.app.MusicPlayerApp;
import com.luyuanyuan.muiscplayer.util.UiUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UiUtil.setStatusBarColor(getWindow(), getColor(R.color.common_white));
        UiUtil.setNavigationBarColor(getWindow(),getColor(R.color.common_white));
        UiUtil.setLightSystemBar(getWindow());
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            UiUtil.setLightSystemBar(getWindow());
        }
    }
}
