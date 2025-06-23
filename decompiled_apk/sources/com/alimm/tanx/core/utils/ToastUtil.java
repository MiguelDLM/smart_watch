package com.alimm.tanx.core.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.TanxCoreSdk;

/* loaded from: classes.dex */
public class ToastUtil implements NotConfused {
    public static int LONG_TIME = 3500;
    public static int SHORT_TIME = 2000;
    private static Handler handler = new Handler(Looper.getMainLooper());
    private static Toast mToast;

    private static boolean isMainThread() {
        return Thread.currentThread().getName().equals("main");
    }

    public static void showLongToast(Context context, String str) {
        showToast(context, str, LONG_TIME);
    }

    public static void showShortToast(String str) {
        showShortToast(TanxCoreSdk.getApplication(), str);
    }

    public static void showToast(final Context context, final String str, final int i) {
        handler.post(new Runnable() { // from class: com.alimm.tanx.core.utils.ToastUtil.1
            @Override // java.lang.Runnable
            public void run() {
                Context context2;
                if (TextUtils.isEmpty(str) || (context2 = context) == null) {
                    return;
                }
                Context applicationContext = context2.getApplicationContext();
                Toast unused = ToastUtil.mToast = new Toast(applicationContext);
                View inflate = ((LayoutInflater) applicationContext.getSystemService("layout_inflater")).inflate(R.layout.layout_commont_toast, (ViewGroup) null);
                ToastUtil.mToast.setView(inflate);
                ToastUtil.mToast.setGravity(80, 0, SysUtils.getScreenHeight(context) / 2);
                ToastUtil.mToast.setDuration(i);
                ((TextView) inflate.findViewById(R.id.tv_toast)).setText(str);
                ToastUtil.mToast.show();
            }
        });
    }

    public static Toast showToastImg(String str, int i) {
        return showToastImg(TanxCoreSdk.getApplication(), str, LONG_TIME, i);
    }

    public static void showShortToast(Context context, String str) {
        showToast(context, str, SHORT_TIME);
    }

    public static Toast showToastImg(Context context, String str, int i, int i2) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        mToast = new Toast(applicationContext);
        View inflate = ((LayoutInflater) applicationContext.getSystemService("layout_inflater")).inflate(R.layout.layout_commont_toast_img, (ViewGroup) null);
        mToast.setView(inflate);
        mToast.setGravity(80, 0, SysUtils.getScreenHeight(context) / 2);
        mToast.setDuration(i);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_toast);
        ((ImageView) inflate.findViewById(R.id.iv_img)).setImageResource(i2);
        textView.setText(str);
        mToast.show();
        return mToast;
    }
}
