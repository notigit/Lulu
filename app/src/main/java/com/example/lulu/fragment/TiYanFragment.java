package com.example.lulu.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.example.lulu.R;
import com.example.lulu.adapter.CommonAdapter;
import com.example.lulu.adapter.SpaceItemDecoration;
import com.example.lulu.adapter.ViewHolder;
import com.example.lulu.picasso.PicassoUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/2/2.
 */

public class TiYanFragment extends Fragment {
    RecyclerView recyclerView;
    ConvenientBanner convenientBanner;
    List<String> mList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tiyan, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        convenientBanner = view.findViewById(R.id.convenientBanner);
        recyclerView.setHasFixedSize(true);
        for (int i = 0; i < 100; i++) {
            mList.add(i+"这是一条描述");
        }
        initBanner();
        recyclerView.addItemDecoration(new SpaceItemDecoration(10));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        CommonAdapter<String> commonAdapter = new CommonAdapter<String>(getActivity(),R.layout.tiyan_item,mList) {
            @Override
            public void convert(ViewHolder holder, String s) {
                holder.setText(R.id.describeTv,s);
            }
        };
        recyclerView.setAdapter(commonAdapter);
        return view;
    }

    private void initBanner() {
        //开始自动翻页
        convenientBanner.startTurning(4000);
//        convenientBanner.setPageTransformer(new AccordionTransformer());
        List<String> imgList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            imgList.add("http://img.i.cacf.cn/avatar/1712/18/aa47952504a00c6ef0776f81240a1914.png!360360");
        }
        convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, imgList).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);

    }
    class NetworkImageHolderView implements Holder<String> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return imageView;
        }
        @Override
        public void UpdateUI(Context context, int position, String data) {
            PicassoUtils.loadPic(getActivity(), data, imageView);
        }
    }
}
