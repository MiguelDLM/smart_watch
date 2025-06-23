package com.baidu.navisdk.util.common;

import android.app.ActivityManager;
import android.content.Context;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* loaded from: classes8.dex */
public class w {
    public static ActivityManager.MemoryInfo a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MemUtils", "系统总内存:" + (memoryInfo.totalMem / 1048576) + "M");
            LogUtil.e("MemUtils", "系统剩余内存:" + (memoryInfo.availMem / 1048576) + "M");
            StringBuilder sb = new StringBuilder();
            sb.append("系统是否处于低内存运行：");
            sb.append(memoryInfo.lowMemory);
            LogUtil.e("MemUtils", sb.toString());
            LogUtil.e("MemUtils", "系统剩余内存低于" + (memoryInfo.threshold / 1048576) + "M时为低内存运行");
        }
        return memoryInfo;
    }
}
