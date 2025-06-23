package com.bytedance.pangle;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import java.util.List;

@Keep
/* loaded from: classes8.dex */
public abstract class ZeusPluginStateListener {
    public static final int EVENT_DOWNLOAD_FAILED = 4;
    public static final int EVENT_DOWNLOAD_PROGRESS = 2;
    public static final int EVENT_DOWNLOAD_START = 1;
    public static final int EVENT_DOWNLOAD_SUCCESS = 3;
    public static final int EVENT_INSTALL_FAILED = 7;
    public static final int EVENT_INSTALL_START = 5;
    public static final int EVENT_INSTALL_SUCCESS = 6;
    public static final int EVENT_LOAD_FAILED = 10;
    public static final int EVENT_LOAD_START = 8;
    public static final int EVENT_LOAD_SUCCESS = 9;
    public static final int EVENT_REQUEST_FINISH = 0;
    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    public static void postStateChange(@Nullable final String str, final int i, final Object... objArr) {
        String str2;
        mHandler.post(new Runnable() { // from class: com.bytedance.pangle.ZeusPluginStateListener.1
            @Override // java.lang.Runnable
            public final void run() {
                String str3;
                List<ZeusPluginStateListener> list = i.a().b;
                if (list != null && list.size() > 0) {
                    for (ZeusPluginStateListener zeusPluginStateListener : list) {
                        if (TextUtils.isEmpty(str)) {
                            str3 = "UNKNOWN";
                        } else {
                            str3 = str;
                        }
                        zeusPluginStateListener.onPluginStateChange(str3, i, objArr);
                    }
                }
            }
        });
        List<ZeusPluginStateListener> list = i.a().b;
        if (list != null && list.size() > 0) {
            for (ZeusPluginStateListener zeusPluginStateListener : list) {
                if (TextUtils.isEmpty(str)) {
                    str2 = "UNKNOWN";
                } else {
                    str2 = str;
                }
                zeusPluginStateListener.onStateChangeOnCurThread(str2, i, objArr);
            }
        }
    }

    @Deprecated
    public void onPluginStateChange(String str, int i, Object... objArr) {
    }

    public void onStateChangeOnCurThread(String str, int i, Object... objArr) {
    }
}
