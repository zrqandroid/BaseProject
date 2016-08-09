package com.maowubian.baseproject.component.music.ui;



import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.maowubian.baseproject.R;
import com.maowubian.baseproject.component.base.BaseActivity;
import com.maowubian.baseproject.databinding.MusicListPageBiding;


public class MusicListActivity extends BaseActivity<MusicListPageBiding> {


    @Override
    protected void init() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示
        dataBinding.collapsingToolbar.setTitle("CollapsingToolbarLayout");
        //通过CollapsingToolbarLayout修改字体颜色
        dataBinding.collapsingToolbar.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        dataBinding.collapsingToolbar.setCollapsedTitleTextColor(Color.GREEN);//设置收缩后Toolbar上字体的颜色
    }

    @Override
    public int getLayout() {
        return R.layout.activity_music_list;
    }


}
