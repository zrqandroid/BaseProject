package com.maowubian.baseproject.component.music.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.maowubian.baseproject.R;
import com.maowubian.baseproject.databinding.MusicItemBinding;

/**
 * Created by zhuruqiao on 16/8/5.
 */
public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.MusicListHolder> {

    private Context mContext;
    private LayoutInflater inflater;
    public MusicListAdapter(Context mContext){
        this.mContext=mContext;
        inflater = LayoutInflater.from(mContext);
    }


    @Override
    public MusicListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MusicItemBinding dataBinding = DataBindingUtil.inflate(inflater, R.layout.item_music, parent, true);
        return new MusicListHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(MusicListHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 100;
    }

    public static class MusicListHolder extends RecyclerView.ViewHolder {

        public MusicItemBinding binding;

        public MusicListHolder(MusicItemBinding dataBinding) {
            super(dataBinding.getRoot());
            binding = dataBinding;

        }
    }
}
