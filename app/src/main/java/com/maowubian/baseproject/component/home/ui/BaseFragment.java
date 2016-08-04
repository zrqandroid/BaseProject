package com.maowubian.baseproject.component.home.ui;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * Created by zhuruqiao on 16/8/3.
 */
public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment {
    public Context mContext;
    public T binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,getLayout(), null, false);
        initView(binding);
        return binding.getRoot();
    }

    protected abstract void initView(T binding);

    public abstract int getLayout();
}
