package com.maowubian.baseproject.component.music.ui;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.maowubian.baseproject.R;
import com.maowubian.baseproject.api.AppContext;
import com.maowubian.baseproject.component.home.ui.BaseFragment;
import com.maowubian.baseproject.component.music.adapter.BannerAdapter;
import com.maowubian.baseproject.component.music.adapter.MusicListAdapter;
import com.maowubian.baseproject.databinding.MusicDataBinding;


/**
 * Created by zhuruqiao on 16/8/4.
 */
public class MusicFragment extends BaseFragment<MusicDataBinding> {


    @Override
    protected void initView(MusicDataBinding binding) {
        binding.banner.setAdapter(new BannerAdapter(mContext));
//        binding.musicList.setLayoutManager(new LinearLayoutManager(mContext));
//        binding.musicList.setAdapter(new MusicListAdapter(mContext));

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_music;
    }
}
