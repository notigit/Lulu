package com.example.lulu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lulu.R;
import com.example.lulu.adapter.CommonAdapter;
import com.example.lulu.adapter.SpaceItemDecoration;
import com.example.lulu.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/2.
 */

public class VipFragment extends Fragment {
    TextView numTv;
    RecyclerView recyclerView;
    List<String> mList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vip,container,false);
        numTv = view.findViewById(R.id.numTv);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        for (int i = 0; i < 100; i++) {
            mList.add(i+"这是一条描述");
        }
        recyclerView.addItemDecoration(new SpaceItemDecoration(10));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        CommonAdapter<String> commonAdapter = new CommonAdapter<String>(getActivity(),R.layout.vip_item,mList) {
            @Override
            public void convert(ViewHolder holder, String s) {
                holder.setText(R.id.describeTv,s);
            }
        };
        recyclerView.setAdapter(commonAdapter);
        return view;
    }
}
