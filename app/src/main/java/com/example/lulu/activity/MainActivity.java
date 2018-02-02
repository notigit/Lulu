package com.example.lulu.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.lulu.R;
import com.example.lulu.mvp.model.TiYanModel;
import com.example.lulu.mvp.presenter.TiYanPresenter;
import com.example.lulu.mvp.view.TiYanView;

public class MainActivity extends AppCompatActivity implements TiYanView {
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.frameLayout);

        TiYanPresenter tiYanPresenter = new TiYanPresenter();
        tiYanPresenter.attachView(this);
        tiYanPresenter.getTiYan("6862", "DwJMdPwkbpBaGBlURqc1U1D1EklmmLxX");
    }

    @Override
    public void showSuccess(TiYanModel model) {
        Log.e("TAG", "showSuccess: ");
    }

    @Override
    public void showFail(TiYanModel model) {
        Log.e("TAG", "showFail: ");
    }
}
