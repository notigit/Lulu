package com.example.lulu.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.lulu.R;
import com.example.lulu.fragment.MyFragment;
import com.example.lulu.fragment.SortFragment;
import com.example.lulu.fragment.TiYanFragment;
import com.example.lulu.fragment.VipFragment;
import com.example.lulu.fragment.YiRenFragment;
import com.example.lulu.mvp.model.TiYanModel;
import com.example.lulu.mvp.presenter.TiYanPresenter;
import com.example.lulu.mvp.view.TiYanView;
import com.example.lulu.picasso.PicassoUtils;
import com.example.lulu.view.ImageViewPlus;

public class MainActivity extends AppCompatActivity implements TiYanView {
//    TextView titleTv;
    FrameLayout frameLayout;
    RadioGroup radioGroup;
    RadioButton tiYanRb, vipRb, sortRb, yiRenRb, myRb;
    private TiYanFragment tiYanFragment;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        titleTv = findViewById(R.id.titleTv);
        frameLayout = findViewById(R.id.frameLayout);
        radioGroup = findViewById(R.id.radioGroup);
        tiYanRb = findViewById(R.id.tiYanRb);
        vipRb = findViewById(R.id.vipRb);
        sortRb = findViewById(R.id.sortRb);
        yiRenRb = findViewById(R.id.yiRenRb);
        myRb = findViewById(R.id.myRb);
        tiYanFragment = new TiYanFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, tiYanFragment).commit();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.tiYanRb:
//                        titleTv.setText("体验区");
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, tiYanFragment).commit();
                        break;
                    case R.id.vipRb:
//                        titleTv.setText("会员区");
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new VipFragment()).commit();
                        break;
                    case R.id.sortRb:
//                        titleTv.setText("分类");
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new SortFragment()).commit();
                        break;
                    case R.id.yiRenRb:
//                        titleTv.setText("艺人");
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new YiRenFragment()).commit();
                        break;
                    case R.id.myRb:
//                        titleTv.setText("我的");
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new MyFragment()).commit();
                        break;
                }
            }
        });
        //网络
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
