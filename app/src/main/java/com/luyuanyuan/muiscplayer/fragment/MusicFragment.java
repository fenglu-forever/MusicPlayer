package com.luyuanyuan.muiscplayer.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.luyuanyuan.muiscplayer.R;
import com.luyuanyuan.muiscplayer.adapter.MusicAdapter;
import com.luyuanyuan.muiscplayer.util.MusicUtil;


public class MusicFragment extends Fragment {
    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_music, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        initAdapters();
    }

    private void initViews() {
        mListView = getView().findViewById(R.id.listView);
    }

    private void initAdapters() {
        mListView.setAdapter(new MusicAdapter(getActivity(), MusicUtil.getMusicList()));
    }
}
