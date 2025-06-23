package com.baidu.mshield.x6.e;

import android.content.Context;
import android.os.Process;

/* loaded from: classes7.dex */
public class k {
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
                f.a(th);
                return false;
            }
        }
        return true;
    }
}
