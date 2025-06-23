package com.bytedance.pangle;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;

@Keep
/* loaded from: classes8.dex */
public interface ZeusPluginEventCallback {
    public static final int EVENT_FINISH_INITIALIZATION = 3100;
    public static final int EVENT_FINISH_INSTALLATION = 1100;
    public static final int EVENT_FINISH_LOAD = 2100;
    public static final int EVENT_START_INITIALIZATION = 3000;
    public static final int EVENT_START_INSTALLATION = 1000;
    public static final int EVENT_START_LOAD = 2000;
    public static final int RESULT_FAILED = -1;
    public static final int RESULT_INSTALLATION_FAILED_CHECK_ABI = -5;
    public static final int RESULT_INSTALLATION_FAILED_CHECK_PERMISSION = -4;
    public static final int RESULT_INSTALLATION_FAILED_CHECK_SIGNATURE = -3;
    public static final int RESULT_INSTALLATION_FAILED_COPY_APK = -6;
    public static final int RESULT_INSTALLATION_FAILED_COPY_SO = -7;
    public static final int RESULT_INSTALLATION_FAILED_DEX_OPT = -8;
    public static final int RESULT_INSTALLATION_FAILED_MODIFY_RES = -2;
    public static final int RESULT_SUCCESS = 0;

    void onPluginEvent(int i, int i2, @Nullable String str, int i3, @Nullable Throwable th);
}
