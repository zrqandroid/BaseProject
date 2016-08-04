package com.maowubian.baseproject.component.movie.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.maowubian.baseproject.R;
import com.maowubian.baseproject.api.AppContext;
import com.maowubian.baseproject.component.home.ui.BaseFragment;
import com.maowubian.baseproject.databinding.MovieDataBinding;
import com.maowubian.baseproject.databinding.MusicDataBinding;
import com.maowubian.baseproject.utils.DimensUtil;

/**
 * Created by zhuruqiao on 16/8/4.
 */
public class MovieFragment extends BaseFragment<MovieDataBinding> {

    @Override
    protected void initView(MovieDataBinding binding) {
        binding.space.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, AppContext.statusBarHeight));

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_movie;
    }
}
