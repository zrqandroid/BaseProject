package com.maowubian.baseproject.component.music.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maowubian.baseproject.R;
import com.maowubian.baseproject.component.music.media.PlayControlImpl;
import com.maowubian.baseproject.component.music.media.PlayControler;
import com.maowubian.baseproject.component.music.media.PlayerEvent;
import com.maowubian.baseproject.component.music.media.data.MusicInfo;
import com.maowubian.baseproject.component.music.media.data.MusicStatus;
import com.maowubian.baseproject.component.music.media.inter.PlayControl;
import com.maowubian.baseproject.databinding.HeadDataBinding;
import com.maowubian.baseproject.databinding.MusicItemBinding;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuruqiao on 16/8/5.
 */
public class MusicListAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private LayoutInflater inflater;
    private List<MusicInfo> musicInfos;
    private HeadDataBinding headDataBinding;

    private static final int HEAD = 0;
    private static final int ITEM = 1;
    private static final int FOOT = 2;


    public MusicListAdapter(Activity mContext, List<MusicInfo> musicInfos) {
        this.mContext = mContext;
        this.musicInfos = musicInfos;
        inflater = LayoutInflater.from(mContext);
        EventBus.getDefault().register(this);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == HEAD) {
            return new HeadHolder((HeadDataBinding) DataBindingUtil.inflate(inflater, R.layout.item_head, parent, true));
        } else {
            return new MusicListHolder((MusicItemBinding) DataBindingUtil.inflate(inflater, R.layout.item_music, parent, true));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            headDataBinding = ((HeadHolder) holder).binding;
        } else {
            MusicItemBinding musicItemBinding = ((MusicListHolder) holder).binding;
            MusicInfo info = musicInfos.get(position - 1);
            info.binding= musicItemBinding;
            musicItemBinding.getRoot().setTag(info);
            musicItemBinding.setInfo(info);
            musicItemBinding.setControl(PlayControler.getInstance());
            MusicInfo musicInfo = PlayControler.getInstance().getCurrentPlayMusic();
            if (musicInfo != null) {
                if (info.id == musicInfo.id) {
                    musicItemBinding.musicProgress.setVisibility(View.VISIBLE);
                    musicItemBinding.setStatus(new MusicStatus());
                } else {
                    musicItemBinding.musicProgress.setVisibility(View.INVISIBLE);

                }
            } else {
                musicItemBinding.musicProgress.setVisibility(View.INVISIBLE);
            }
        }


    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEAD;
        } else {
            return ITEM;
        }
    }

    @Override
    public int getItemCount() {
        return musicInfos.size() + 1;
    }

    public static class MusicListHolder extends RecyclerView.ViewHolder {

        public MusicItemBinding binding;

        public MusicListHolder(MusicItemBinding dataBinding) {
            super(dataBinding.getRoot());
            binding = dataBinding;

        }
    }

    public static class HeadHolder extends RecyclerView.ViewHolder {

        public HeadDataBinding binding;

        public HeadHolder(HeadDataBinding dataBinding) {
            super(dataBinding.getRoot());
            binding = dataBinding;

        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(Integer event) {
        headDataBinding.visualizerView.setVisualizer(PlayControlImpl.getInstance().mVisualizer);
    }
}
