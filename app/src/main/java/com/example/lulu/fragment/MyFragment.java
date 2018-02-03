package com.example.lulu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lulu.R;
import com.example.lulu.picasso.PicassoUtils;
import com.example.lulu.view.ImageViewPlus;

/**
 * Created by Administrator on 2018/2/2.
 */

public class MyFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my,container,false);
        //图片
        ImageViewPlus imageViewPlus = view.findViewById(R.id.imageViewPlus);
        PicassoUtils.loadPic(getActivity(), "http://img.i.cacf.cn/avatar/1712/18/aa47952504a00c6ef0776f81240a1914.png!360360", imageViewPlus);
        return view;
    }
}
