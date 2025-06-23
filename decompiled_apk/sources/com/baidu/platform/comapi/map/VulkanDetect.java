package com.baidu.platform.comapi.map;

import android.view.Surface;

/* loaded from: classes8.dex */
class VulkanDetect {
    public static native long getNativeWindow(Surface surface);

    public static native boolean isSupportedVulkan();

    public static native void releaseNativeWindow(long j);
}
