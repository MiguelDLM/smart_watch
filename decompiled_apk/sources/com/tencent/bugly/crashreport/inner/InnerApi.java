package com.tencent.bugly.crashreport.inner;

import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.au;
import java.util.Map;

/* loaded from: classes13.dex */
public class InnerApi {
    public static void postCocos2dxCrashAsync(int i, String str, String str2, String str3) {
        if (str != null && str2 != null && str3 != null) {
            if (i != 5 && i != 6) {
                al.e("post cocos2d-x fail category illeagle: %d", Integer.valueOf(i));
                return;
            } else {
                al.a("post cocos2d-x crash %s %s", str, str2);
                au.a(Thread.currentThread(), i, str, str2, str3, null);
                return;
            }
        }
        al.e("post cocos2d-x fail args null", new Object[0]);
    }

    public static void postH5CrashAsync(Thread thread, String str, String str2, String str3, Map<String, String> map) {
        if (str != null && str2 != null && str3 != null) {
            al.a("post h5 crash %s %s", str, str2);
            au.a(thread, 8, str, str2, str3, map);
        } else {
            al.e("post h5 fail args null", new Object[0]);
        }
    }

    public static void postU3dCrashAsync(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            al.e("post u3d fail args null", new Object[0]);
        }
        al.a("post u3d crash %s %s", str, str2);
        au.a(Thread.currentThread(), 4, str, str2, str3, null);
    }
}
