package com.maowubian.baseproject.utils;

import com.maowubian.baseproject.api.AppContext;

import java.lang.reflect.Field;

/**
 * Created by zhuruqiao on 16/8/4.
 */
public class DimensUtil {


    public static int getStatusbarHeight() {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object o = c.newInstance();
            Field field = c.getField("status_bar_height");
            int i = Integer.parseInt(field.get(o).toString());
            return AppContext.mContext.getResources().getDimensionPixelOffset(i);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
