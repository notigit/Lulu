package com.example.lulu;

import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/2.
 */

public class MyApplication extends Application {
    private static LinkedList<Activity> activityStack = new LinkedList<>();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void addActivity(Activity aty) {
        activityStack.add(aty);
    }

    public void removeActivity(Activity aty) {
        activityStack.remove(aty);
    }

    public static List<Activity> getActivityStack() {
        return activityStack;
    }

    /**
     * 结束所有Activity
     */
    public static void loginOut() {
        for (Activity activity : activityStack) {
            if (activity != null)
                activity.finish();
        }
    }

    /**
     * 结束所有Activity
     */
    public static void loginOutPlus() {
        for (Activity activity : activityStack) {
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /**
     * 结束Activity数量
     */
    public static void popNum(int topNum) {
        for (int i = 0; i < topNum; i++) {
            Activity activity = activityStack.getLast();
            if (activity != null)
                activity.finish();
        }
    }

    /**
     * 结束当前Activity以外的activity
     */
    public static void endPopNum() {
        for (int i = 0; i < activityStack.size() - 1; i++) {
            Activity activity = activityStack.getLast();
            if (activity != null)
                activity.finish();
        }
    }
}
