package com.baidu.sec.privacy.d;

import android.content.Context;
import android.os.Process;

/* loaded from: classes8.dex */
public class f {
    public static boolean a(Context context, String[] strArr) {
        if (strArr != null) {
            try {
                for (String str : strArr) {
                    if (context.checkPermission(str, Process.myPid(), Process.myUid()) == -1) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                c.a(th);
                return false;
            }
        }
        return true;
    }
}
