package com.luyuanyuan.muiscplayer.util;

import android.database.Cursor;
import android.provider.MediaStore;

import com.luyuanyuan.muiscplayer.app.MusicPlayerApp;
import com.luyuanyuan.muiscplayer.entity.Music;

import java.util.ArrayList;
import java.util.List;

public class MusicUtil {
    public static List<Music> getMusicList() {
        List<Music> musicList = new ArrayList<>();
        Cursor cursor = MusicPlayerApp.getAppContext().getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int isMusic = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.IS_MUSIC));
                if (isMusic == 1) {
                    String name = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME));
                    name = name.replace(".mp3", "");
                    int id = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID));
                    String artist = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
                    String url = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
                    int duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));
                    int size = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE));
                    int albumId = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID));
                    String albumName = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));
                    Music music = new Music();
                    music.setId(id);
                    music.setName(name);
                    music.setArtist(artist);
                    music.setUrl(url);
                    music.setDuration(duration);
                    music.setSize(size);
                    music.setAlbumId(albumId);
                    music.setAlbumName(albumName);
                    musicList.add(music);
                }
            }
            cursor.close();
        }
        return musicList;
    }
}
