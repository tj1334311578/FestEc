package com.diabin.latte.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.diabin.latte.app.Latte;

/**
 * Created by Administrator on 2017/11/6 0006
 * function:
 */

public class DimenUtil {

    public static int getScreenWidth(){
        final Resources resources= Latte.getApplication().getResources();
        final DisplayMetrics dm=resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight(){
        final Resources resources= Latte.getApplication().getResources();
        final DisplayMetrics dm=resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
