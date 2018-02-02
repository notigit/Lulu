package com.example.lulu.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lulu.utils.BitmapUtils;

/**
 * Created by Administrator on 2016/8/24.
 */
public class FunctionView extends RelativeLayout {
    LayoutParams layoutParams;

    public FunctionView(Context context) {
        super(context);
        initParams();
    }

    public FunctionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initParams();
    }

    public FunctionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initParams();
    }

    private void initParams() {
        layoutParams = new LayoutParams(BitmapUtils.dp2px(getContext(), 20),
            BitmapUtils.dp2px(getContext(), 20));
        setGravity(Gravity.RIGHT|Gravity.CENTER_VERTICAL);
    }

    public void setTextResource(int id) {
        setText(getResources().getText(id).toString());
    }

    public void setText(String functionText) {
        TextView textView = new TextView(getContext());
        textView.setText(functionText);
        textView.setTextColor(getContext().getResources().getColor(android.R.color.white));
        textView.setTextSize(14);
        textView.setPadding(30, 8, 30, 8);
        addView(textView);
    }

    public void setText(int resId) {
        TextView textView = new TextView(getContext());
        textView.setText(resId);
        textView.setTextSize(14);
        textView.setPadding(30, 8, 30, 8);
        addView(textView);
    }

    public TextView setTextResource(int functionText, int textColor, int size) {
        TextView textView = new TextView(getContext());
        textView.setText(functionText);
        textView.setTextSize(size);
        //textView.setBackgroundResource(R.drawable.rectangle_frame);
        textView.setPadding(30, 8, 30, 0);
        textView.setTextColor(getResources().getColor(textColor));
        addView(textView);
        return textView;
    }

    public TextView setTextResource(String functionText, int textColor, int size) {
        TextView textView = new TextView(getContext());
        textView.setText(functionText);
        textView.setTextSize(size);
        //textView.setBackgroundResource(R.drawable.rectangle_frame);
        //textView.setPadding(30, 8, 30, 8);
        textView.setTextColor(getResources().getColor(textColor));
        addView(textView);
        return textView;
    }

    public void setImageResource(int id) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(id);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        addView(imageView, layoutParams);
    }

}
