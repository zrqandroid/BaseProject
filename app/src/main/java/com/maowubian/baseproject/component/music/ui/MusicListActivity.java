package com.maowubian.baseproject.component.music.ui;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.maowubian.baseproject.R;
import com.maowubian.baseproject.component.base.BaseActivity;
import com.maowubian.baseproject.component.music.adapter.MusicListAdapter;
import com.maowubian.baseproject.component.music.media.MediaUtils;
import com.maowubian.baseproject.component.music.media.data.MusicInfo;
import com.maowubian.baseproject.databinding.MusicListPageBiding;
import com.orhanobut.logger.Logger;

import org.apache.commons.codec.binary.Hex;

import java.util.ArrayList;
import java.util.List;


public class MusicListActivity extends BaseActivity<MusicListPageBiding> {

    private static final String TITLE = "title";
    private int distance = 0;


    private List<MusicInfo> musicInfos;

    public static void start(Context mContext, String title) {

        Intent intent = new Intent(mContext, MusicListActivity.class);
        intent.putExtra(TITLE, title);
        mContext.startActivity(intent);
    }

    @Override
    protected void init() {
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        Intent intent = getIntent();
        String title = intent.getStringExtra(TITLE);
        musicInfos = MediaUtils.getLocalMusicList();
        dataBinding.title.setText(title);
        dataBinding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        dataBinding.musicInfoList.setLayoutManager(new LinearLayoutManager(mContext));
        dataBinding.musicInfoList.setAdapter(new MusicListAdapter(mContext, musicInfos));
        dataBinding.musicInfoList.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                distance+=dy;
                if (distance<256){
                    int color;
                    int i1 = distance % 256;
                    if (i1<=9){
                        color= Color.parseColor("#0"+i1+"81c2d6");

                    }else if (i1<=99){
                        color= Color.parseColor("#"+i1+"81c2d6");

                    }else {
                        String s = Integer.toHexString(i1);
                        color= Color.parseColor("#"+s+"81c2d6");
                    }

                    dataBinding.titleContainer.setBackgroundColor(color);
                }else if (distance>=256){
                    int i = Color.parseColor("#81c2d6");
                    dataBinding.titleContainer.setBackgroundColor(i);
                }

            }
        });
    }


    @Override
    public int getLayout() {
        return R.layout.activity_music_list;
    }


}
