package com.example.lulu.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lulu.R;
import com.example.lulu.mvp.model.TiYanModel;
import com.example.lulu.mvp.presenter.TiYanPresenter;
import com.example.lulu.mvp.view.TiYanView;
import com.example.lulu.picasso.PicassoUtils;

public class MainActivity extends AppCompatActivity implements TiYanView {
    FrameLayout frameLayout;
    RadioGroup radioGroup;
    RadioButton tiYanRb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.frameLayout);
        radioGroup = findViewById(R.id.radioGroup);
        tiYanRb = findViewById(R.id.tiYanRb);
        //网络
        TiYanPresenter tiYanPresenter = new TiYanPresenter();
        tiYanPresenter.attachView(this);
        tiYanPresenter.getTiYan("6862", "DwJMdPwkbpBaGBlURqc1U1D1EklmmLxX");
        //图片
        ImageView imageView = findViewById(R.id.imageView);
        PicassoUtils.loadPic(this,"http://img.i.cacf.cn/avatar/1712/18/aa47952504a00c6ef0776f81240a1914.png!360360",imageView);
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
