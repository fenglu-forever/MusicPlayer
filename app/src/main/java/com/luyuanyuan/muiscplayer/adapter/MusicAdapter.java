package com.luyuanyuan.muiscplayer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.luyuanyuan.muiscplayer.R;
import com.luyuanyuan.muiscplayer.entity.Music;

import java.util.List;

public class MusicAdapter extends BaseAdapter {
    private Context mContext;
    private List<Music> mMusicList;
    private LayoutInflater mInflater;

    public MusicAdapter(Context context, List<Music> musicList) {
        mContext = context;
        mMusicList = musicList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mMusicList.size();
    }

    @Override
    public Music getItem(int position) {
        return mMusicList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Music music = mMusicList.get(position);
        View view;
        ViewHolder holder;
        if (convertView == null) {
            view = mInflater.inflate(R.layout.item_music_list, parent, false);
            holder = new ViewHolder();
            holder.tvName = view.findViewById(R.id.tvName);
            holder.tvArtist = view.findViewById(R.id.tvArtist);
            holder.ivMore = view.findViewById(R.id.ivMore);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.tvName.setText(music.getName());
        holder.tvArtist.setText(music.getArtist());
        return view;
    }

    private static class ViewHolder {
        private TextView tvName;
        private TextView tvArtist;
        private ImageView ivMore;
    }
}
