package com.baidu.navisdk.ui.widget.debug;

import android.app.Activity;
import android.content.Intent;

/* loaded from: classes8.dex */
public class ActivityResultUtil {
    private static ActivityResultUtil mInstance;
    private Callback mCallback;

    /* loaded from: classes8.dex */
    public interface Callback {
        void onActivityForResult(int i, int i2, Intent intent);
    }

    private ActivityResultUtil() {
    }

    public static ActivityResultUtil getInstance() {
        if (mInstance == null) {
            mInstance = new ActivityResultUtil();
        }
        return mInstance;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onActivityForResult(i, i2, intent);
        }
        this.mCallback = null;
    }

    public void startActivityForResult(Activity activity, Intent intent, int i, Callback callback) {
        if (activity == null) {
            return;
        }
        this.mCallback = callback;
        activity.startActivityForResult(intent, i);
    }
}
