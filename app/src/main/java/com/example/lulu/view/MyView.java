package com.example.lulu.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.example.lulu.R;

/**
 * Created by Hwaphon on 2016/5/12.
 */
public class MyView extends View {
 
 private Bitmap mBitmap;
 private Drawable mDrawable;
 private Bitmap mSrcBitmap;
 
 private BitmapShader mShader;
 private Paint mPaint;
 
 private int mWidth, mHeight;
 
 private int mRadius;
 private int mCircleX, mCircleY;
 
 private int mBorderColor;
 private Paint mBorderPaint;
 private int mBorderWidth;
 
 public MyView(Context context) {
  this(context, null);
 }
 
 public MyView(Context context, AttributeSet attrs) {
  super(context, attrs);
  TypedArray type = context.obtainStyledAttributes(attrs, R.styleable.MyCustomView);
  mBorderColor = type.getColor(R.styleable.MyCustomView_mborder_color,0);
  mDrawable = type.getDrawable(R.styleable.MyCustomView_msrc);
 
  //将获得的 Drawable 转换成 Bitmap
  BitmapDrawable bitmapDrawable = (BitmapDrawable) mDrawable;
  mBitmap = bitmapDrawable.getBitmap();
 
  mBorderWidth = type.getDimensionPixelSize(R.styleable.MyCustomView_mborder_width, 2);
 }
 
 @Override
 protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
  super.onMeasure(widthMeasureSpec, heightMeasureSpec);
  mWidth = measureWidth(widthMeasureSpec);
  mHeight = measureHeight(heightMeasureSpec);
  int temp = mWidth > mHeight ? mHeight : mWidth;
  mWidth = mHeight = temp;
  initView();
  setMeasuredDimension(mWidth, mHeight);
 }
 
 private int measureHeight(int heightMeasureSpec) {
  int size = MeasureSpec.getSize(heightMeasureSpec);
  int sizeMode = MeasureSpec.getMode(heightMeasureSpec);
  int result = 0;
  if (sizeMode == MeasureSpec.EXACTLY) {
   result = size;
  } else {
   result = 200;
   if (sizeMode == MeasureSpec.AT_MOST) {
    result = Math.min(result, size);
   }
  }
  return result;
 }
 
 private int measureWidth(int widthMeasureSpec) {
  int size = MeasureSpec.getSize(widthMeasureSpec);
  int sizeMode = MeasureSpec.getMode(widthMeasureSpec);
  int result = 0;
  if (sizeMode == MeasureSpec.EXACTLY) {
   result = size;
  } else {
   result = 200;
   if (sizeMode == MeasureSpec.AT_MOST) {
    result = Math.min(result, size);
   }
  }
  return result;
 }
 
 private void initView() {
 
  mSrcBitmap = Bitmap.createScaledBitmap(mBitmap, mWidth, mHeight, false);
  mShader = new BitmapShader(mSrcBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
  mPaint = new Paint();
  mPaint.setShader(mShader);
  mRadius = (mWidth - mBorderWidth * 2) / 2;
  mCircleX = (mWidth) / 2;
  mCircleY = (mHeight) / 2;
 
  mBorderPaint = new Paint();
  mBorderPaint.setStyle(Paint.Style.STROKE);
  mBorderPaint.setStrokeWidth(mBorderWidth);
  mBorderPaint.setColor(mBorderColor);
  mBorderPaint.setStrokeJoin(Paint.Join.ROUND);
  mBorderPaint.setStrokeCap(Paint.Cap.ROUND);
 }
 
 @Override
 protected void onDraw(Canvas canvas) {
  super.onDraw(canvas);
  canvas.drawCircle(mCircleX, mCircleY, mRadius, mPaint);
  canvas.drawCircle(mCircleX, mCircleY, mRadius, mBorderPaint);
 }
}