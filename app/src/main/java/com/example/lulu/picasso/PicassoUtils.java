package com.example.lulu.picasso;

/**
 * ================================================
 * 作    者：jeasonlzy（廖子尧）
 * 版    本：1.0
 * 创建日期：2016/3/28
 * 描    述：我的Github地址  https://github.com/jeasonlzy0216
 * 修订历史：
 * ================================================
 */

import android.app.Activity;
import android.widget.ImageView;

import com.example.lulu.R;
import com.squareup.picasso.Picasso;

public class PicassoUtils {
    public static void loadPic(Activity activity, String path, ImageView imageView) {
        Picasso.with(activity)
                .load(path)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
