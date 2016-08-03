package com.maowubian.baseproject.component.home.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maowubian.baseproject.R;

import java.util.Random;

/**
 * Created by zhuruqiao on 16/8/3.
 */
public class AppFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        int i = new Random().nextInt(3);
        int[] colors={Color.BLUE,Color.GREEN,Color.YELLOW};
        view.setBackgroundColor(colors[i]);
        TextView tv = (TextView) view.findViewById(R.id.tv);
        tv.setText("颜色:"+colors[i]);
        return view;
    }
}
