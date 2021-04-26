package com.luyuanyuan.muiscplayer.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.luyuanyuan.muiscplayer.R;
import com.luyuanyuan.muiscplayer.adapter.MusicCategoryAdapter;
import com.luyuanyuan.muiscplayer.app.MusicPlayerApp;
import com.luyuanyuan.muiscplayer.fragment.AlbumFragment;
import com.luyuanyuan.muiscplayer.fragment.CollectFragment;
import com.luyuanyuan.muiscplayer.fragment.MusicFragment;
import com.luyuanyuan.muiscplayer.util.UiUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private RadioButton mMusicRadio;
    private RadioButton mAlbumRadio;
    private RadioButton mCollectRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UiUtil.setStatusBarColor(getWindow(), getColor(R.color.common_white));
        UiUtil.setNavigationBarColor(getWindow(), getColor(R.color.common_white));
        UiUtil.setLightSystemBar(getWindow());
        initViews();
        initListeners();
        initAdapters();
    }

    private void initViews() {
        mViewPager = findViewById(R.id.viewPager);
        mRadioGroup = findViewById(R.id.radioGroup);
        mMusicRadio = findViewById(R.id.rbtnMusic);
        mAlbumRadio = findViewById(R.id.rbtnAlbum);
        mCollectRadio = findViewById(R.id.rbtnCollect);
    }

    private void initListeners() {
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mMusicRadio.setChecked(true);
                        break;
                    case 1:
                        mAlbumRadio.setChecked(true);
                        break;
                    case 2:
                        mCollectRadio.setChecked(true);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbtnMusic:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.rbtnAlbum:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.rbtnCollect:
                        mViewPager.setCurrentItem(2);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void initAdapters() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new MusicFragment());
        fragments.add(new AlbumFragment());
        fragments.add(new CollectFragment());
        mViewPager.setAdapter(new MusicCategoryAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT, fragments));
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            UiUtil.setLightSystemBar(getWindow());
        }
    }
}
