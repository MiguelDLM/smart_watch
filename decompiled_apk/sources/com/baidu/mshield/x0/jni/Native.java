package com.baidu.mshield.x0.jni;

import com.baidu.mshield.b.c.a;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.mshield.x0.b.d;
import com.baidu.mshield.x6.e.j;

/* loaded from: classes7.dex */
public class Native {
    public static String doExecNonStaticMethod(String str, String str2, String str3, String str4) {
        try {
            return j.b(str, str2, str3, str4);
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public static String doExecStaticMethod(String str, String str2, String str3, String str4) {
        try {
            return j.a(str, str2, str3, str4);
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public static String nsctl(String str, int i) {
        a.b("native shell, cmd: " + str + ", max: " + i);
        try {
            if (!d.a(EngineImpl.mContext, "plc62", false)) {
                return null;
            }
            if (new com.baidu.mshield.x0.j.a(EngineImpl.mContext).p() == 1) {
                return "#NULL";
            }
            return null;
        } catch (Throwable th) {
            d.a(th);
            return "#NULL";
        }
    }
}
