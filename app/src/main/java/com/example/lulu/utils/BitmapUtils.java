package com.example.lulu.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by jeff on 2016/5/26.
 */
public class BitmapUtils {
    protected static float sPixelScale = 0.0f;

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(Context context, float dp) {
        if (sPixelScale == 0.0f) {
            sPixelScale = context.getResources().getDisplayMetrics().density;
        }
        return (int) (dp * sPixelScale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dp(Context context, float px) {
        if (sPixelScale == 0.0f) {
            sPixelScale = context.getResources().getDisplayMetrics().density;
        }
        return (int) (px / sPixelScale + 0.5f);
    }

    /**
     * Drawable转化为Bitmap
     */
    public static Bitmap drawableToBitmap(Drawable drawable) {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height,
                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                        : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmap;

    }

    /**
     * Bitmap to Drawable
     *
     * @param bitmap
     * @param mcontext
     * @return
     */
    public static Drawable bitmapToDrawble(Bitmap bitmap, Context mcontext) {
        Drawable drawable = new BitmapDrawable(mcontext.getResources(), bitmap);
        return drawable;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth,
                                            int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }

    public static Bitmap getSmallBitmap(String filePath) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, 480, 800);
        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filePath, options);
    }

    public static String bitmap2StrByBase64(Bitmap bit) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bit.compress(Bitmap.CompressFormat.JPEG, 100, bos);//参数100表示不压缩
        byte[] bytes = bos.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    public static File saveBitmap(Bitmap bm, String filePath) {
        Log.e("fh", "保存图片");
        File f = new File(filePath);
        if (f.exists()) {
            f.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(f);
            bm.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
            Log.i("fh", "已经保存");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return f;
    }

    public static float getScreenWidth(Context context) {

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        DisplayMetrics outMetrics = new DisplayMetrics();

        wm.getDefaultDisplay().getMetrics(outMetrics);

        int mScreenWidth = outMetrics.widthPixels;//屏幕的宽度

        return mScreenWidth;
    }

    public static float getScreenHeight(Context context) {

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        DisplayMetrics outMetrics = new DisplayMetrics();

        wm.getDefaultDisplay().getMetrics(outMetrics);

        return  outMetrics.heightPixels;
    }

    //110,50
    public static Bitmap getRectColors(String[] colors, int width, int height, int borderColor,
                                       int type) {
        if (colors == null || colors.length <= 0) {
            return null;
        }
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        Paint p = new Paint();
        p.setAntiAlias(true);
        int length = colors.length;
        for (int i = 0; i < length; i++) {
            String color = colors[i];
            if (color.length() == 4) {
                if (color.lastIndexOf("f") >= 0) {
                    colors[i] = "#ffffff";
                }
                if (color.lastIndexOf("0") >= 0) {
                    colors[i] = "#000000";
                }
            }
        }
        if (TextUtils.isEmpty(colors[0])) {
            return null;
        }
        p.setColor(Color.parseColor(colors[0]));// 设置红色
        canvas.drawRect(0, 0, width, height, p);
        if (colors.length != 1) {
            p.setColor(Color.parseColor(colors[1]));// 设置灰色
            if (type == 1) {
                canvas.drawRect(width / 2, 0, width, height, p);
            } else if (type == 2) {
                canvas.drawRect(0, height / 2, width, height, p);
            }

        }
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(2);
        p.setColor(borderColor);
        canvas.drawRect(0, 0, width, height, p);
        canvas.save();
        canvas.restore();
        return bitmap;
    }

//    public static Bitmap getRectColors(Context context,String[] colors, int width, int height, int borderColor,
//                                       int type) {
//        Resources resources =context.getResources();
//        if (colors == null || colors.length <= 0||colors[0].length()==0) {
//            return  BitmapFactory.decodeResource(resources,R.drawable.icon_allcolor);
//        }
//        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
//        Canvas canvas = new Canvas(bitmap);
//        Paint p = new Paint();
//        p.setAntiAlias(true);
//        int length = colors.length;
//        for (int i = 0; i < length; i++) {
//            String color = colors[i];
//            if (color.length() == 4) {
//                if (color.lastIndexOf("f") >= 0) {
//                    colors[i] = "#ffffff";
//                }
//                if (color.lastIndexOf("0") >= 0) {
//                    colors[i] = "#000000";
//                }
//            }
//        }
//        if (TextUtils.isEmpty(colors[0])) {
//            return null;
//        }
//        p.setColor(Color.parseColor(colors[0]));// 设置红色
//        canvas.drawRect(0, 0, width, height, p);
//        if (colors.length != 1) {
//            p.setColor(Color.parseColor(colors[1]));// 设置灰色
//            if (type == 1) {
//                canvas.drawRect(width / 2, 0, width, height, p);
//            } else if (type == 2) {
//                canvas.drawRect(0, height / 2, width, height, p);
//            }
//
//        }
//        p.setStyle(Paint.Style.STROKE);
//        p.setStrokeWidth(2);
//        p.setColor(borderColor);
//        canvas.drawRect(0, 0, width, height, p);
//        canvas.save();
//        canvas.restore();
//        return bitmap;
//    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static byte[] bmpToByteArray(final Bitmap bmp, final boolean needRecycle) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, output);
        if (needRecycle) {
            bmp.recycle();
        }

        byte[] result = output.toByteArray();
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Bitmap screenShot(Activity activity, int viewId) {

        View tempView = activity.findViewById(viewId);
        //        View tempView = button;
        tempView.setDrawingCacheEnabled(true);

        Bitmap bitmap = tempView.getDrawingCache();

        return bitmap;

    }


    // 动态改变listView的高度
    public int measureListViewHeight(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return -1;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            int itemHeight = listItem.getMeasuredHeight();
            totalHeight += itemHeight;
        }
        // 减掉底部分割线的高度
        int historyHeight = totalHeight
                + (listView.getDividerHeight() * listAdapter.getCount() - 1);

        return historyHeight;
    }



    /**
     * @param originalColor color, without alpha
     * @param alpha from 0.0 to 1.0
     * @return
     */
    public static String addAlpha(String originalColor, double alpha) {
        long alphaFixed = Math.round(alpha * 255);
        String alphaHex = Long.toHexString(alphaFixed);
        if (alphaHex.length() == 1) {
            alphaHex ="0" + alphaHex;
        }
        originalColor = originalColor.replace("#","#" + alphaHex);


        return originalColor;
    }


    public static final String TAG ="BitmapUtils";
    public static final int PAINT_FLAGS = Paint.DITHER_FLAG | Paint.FILTER_BITMAP_FLAG;
//    public static Bitmap centerCrop(Bitmap recycled, Bitmap toCrop, int width, int height) {
//
//        if (toCrop == null) {
//            return null;
//        } else if (toCrop.getWidth() == width && toCrop.getHeight() == height) {
//            return toCrop;
//        }
//        // From ImageView/Bitmap.createScaledBitmap.
//        final float scale;
//        float dx = 0, dy = 0;
//        Matrix m = new Matrix();
//        if (toCrop.getWidth() * height > width * toCrop.getHeight()) {
//            scale = (float) height / (float) toCrop.getHeight();
//            dx = (width - toCrop.getWidth() * scale) * 0.5f;
//        } else {
//            scale = (float) width / (float) toCrop.getWidth();
//            dy = (height - toCrop.getHeight() * scale) * 0.5f;
//        }
//
//        m.setScale(scale, scale);
//        m.postTranslate((int) (dx + 0.5f), (int) 0);
//        final Bitmap result;
//        if (recycled != null) {
//            result = recycled;
//        } else {
//            result = Bitmap.createBitmap(width, height, getSafeConfig(toCrop));
//        }
//
//        // We don't add or remove alpha, so keep the alpha setting of the Bitmap we were given.
//        TransformationUtils.setAlpha(toCrop, result);
//
//        Canvas canvas = new Canvas(result);
//        Paint paint = new Paint(PAINT_FLAGS);
//        canvas.drawBitmap(toCrop, m, paint);
//        return result;
//    }
    private static Bitmap.Config getSafeConfig(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }
//
//    public static void loadGif(SimpleDraweeView img,String path){
//
//        DraweeController draweeController =
//                Fresco.newDraweeControllerBuilder()
//                       .setUri(path)
//                        .setAutoPlayAnimations(true) // 设置加载图片完成后是否直接进行播放
//                        .build();
//
//        img.setController(draweeController);
//    }

    /**
     * 获取图片的宽和高
     *
     * @param path
     * @return
     */
    public static int[] getImageWidthHeight(String path) {
        BitmapFactory.Options options = new BitmapFactory.Options();

        /**
         * 最关键在此，把options.inJustDecodeBounds = true;
         * 这里再decodeFile()，返回的bitmap为空，但此时调用options.outHeight时，已经包含了图片的高了
         */
        options.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(path, options); // 此时返回的bitmap为null
        /**
         *options.outHeight为原始图片的高
         */
        return new int[]{options.outWidth, options.outHeight};
    }
}
