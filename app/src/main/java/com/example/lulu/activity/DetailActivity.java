package com.example.lulu.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.example.lulu.R;
import com.example.lulu.adapter.CommonAdapter;
import com.example.lulu.adapter.SpaceItemDecoration;
import com.example.lulu.adapter.ViewHolder;
import com.example.lulu.picasso.PicassoUtils;
import com.example.lulu.view.RoundImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10264 on 2018/2/3.
 */

public class DetailActivity extends AppCompatActivity {
    RecyclerView recyclerView,commitRecyclerView;
    List<String> mList = new ArrayList<>();
    List<String> commitList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initJietu();
        initCommit();
    }

    private void initCommit() {
        commitRecyclerView = findViewById(R.id.commitRecyclerView);
        commitRecyclerView.setHasFixedSize(true);
        for (int i = 0; i < 10; i++) {
            commitList.add(i+"这是一条描述");
        }
//        commitRecyclerView.addItemDecoration(new SpaceItemDecoration(10));
        commitRecyclerView.setNestedScrollingEnabled(false);
        commitRecyclerView.setLayoutManager(new LinearLayoutManager(DetailActivity.this,LinearLayoutManager.VERTICAL,false));
        CommonAdapter<String> commonAdapter = new CommonAdapter<String>(DetailActivity.this,R.layout.detail_commit_item,commitList) {
            @Override
            public void convert(ViewHolder holder, String s) {
                RoundImageView roundImageView = holder.getView(R.id.roundImageView);
                PicassoUtils.loadPic(DetailActivity.this, "http://img.i.cacf.cn/avatar/1712/18/aa47952504a00c6ef0776f81240a1914.png!360360", roundImageView);
                holder.setText(R.id.nameTv,"名字");
                holder.setText(R.id.distanceTv,"距离");
                holder.setText(R.id.timePlusTv,"时间前");
                holder.setText(R.id.contentTv,"内容");
                holder.setText(R.id.timeTv,"时间");
            }
        };
        commitRecyclerView.setAdapter(commonAdapter);
    }

    private void initJietu() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        for (int i = 0; i < 6; i++) {
            mList.add("http://img.i.cacf.cn/avatar/1712/18/aa47952504a00c6ef0776f81240a1914.png!360360");
        }
        recyclerView.addItemDecoration(new SpaceItemDecoration(2));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new GridLayoutManager(DetailActivity.this,3));
        CommonAdapter<String> commonAdapter = new CommonAdapter<String>(DetailActivity.this,R.layout.detail_jietu_item,mList) {
            @Override
            public void convert(ViewHolder holder, String s) {
                ImageView picIv = holder.getView(R.id.picIv);
                PicassoUtils.loadPic(DetailActivity.this, s, picIv);
            }
        };
        recyclerView.setAdapter(commonAdapter);
    }
}
