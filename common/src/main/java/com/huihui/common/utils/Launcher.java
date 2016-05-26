package com.huihui.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * Created by YangZhenshan on 2016/5/6.
 */
public class Launcher {
    /**
     * 通过类名启动Activity
     *
     * @param pClass
     */
    public static void openActivity(Activity context, Class<?> pClass) {
        openActivity(context, pClass, null);
    }

    /**
     * 通过类名启动Activity，并且含有Bundle数据
     *
     * @param pClass
     * @param pBundle
     */
    public static  void openActivity(Activity context, Class<?> pClass, Bundle pBundle) {
        openActivity(context, pClass, pBundle, 0);
    }

    /**
     * 通过类名启动Activity，并且含有Bundle数据
     *
     * @param pClass
     * @param pBundle
     * @param requestCode
     */
    public static  void openActivity(Context context, Class<?> pClass, Bundle pBundle, int requestCode) {
        Intent intent = new Intent(context, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        ((Activity)context).startActivityForResult(intent, requestCode);

    }

    /**
     * 通过Action启动Activity
     *
     * @param pAction
     */
    public static  void openActivity(Activity context, String pAction) {
        openActivity(context, pAction, null);
    }

    /**
     * 通过Action启动Activity，并且含有Bundle数据
     *
     * @param pAction
     * @param pBundle
     */
    public static  void openActivity(Activity context, String pAction, Bundle pBundle) {
        openActivity(context, pAction, pBundle, 0);
    }

    /**
     * 通过Action启动Activity，并且含有Bundle数据
     *
     * @param pAction
     * @param pBundle
     * @param requestCode
     */
    public static  void openActivity(Activity context, String pAction, Bundle pBundle, int requestCode) {
        Intent intent = new Intent(pAction);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        context.startActivityForResult(intent, requestCode);
    }

    /**
     * 调用系统编辑短信界面
     * @param context
     * @param phoneNumber
     * @param content
     */
    public static void writeMsg(Activity context, String phoneNumber, String content){
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"
                + phoneNumber));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("sms_body", content);
        context.startActivity(intent);
    }

    /**
     * 调用系统拨号界面
     * @param context
     * @param phoneNumber
     */
    public static void openDial(Activity context, String phoneNumber){
        Uri uri = Uri.parse("tel:" + phoneNumber);
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        context.startActivity(intent);
    }
}
