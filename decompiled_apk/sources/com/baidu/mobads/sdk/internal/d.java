package com.baidu.mobads.sdk.internal;

import android.util.Log;

/* loaded from: classes7.dex */
public class d {
    public static int a() {
        try {
            return Log.getStackTraceString(new Throwable()).contains(h.b("mvqVQhF4IANbmy4Wui4VTvwoQh7bmgKYugc8mh7GuZR8fh7GuZNKuA7sIANzfvq8uh-MIgF9IA-EUBfb")) ? 1 : 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int b() {
        try {
            return Log.getStackTraceString(new Throwable()).contains(h.b("mvqVQh78XgwCpy4oQh4-IZIETh_8mh7GuZR8fh7GuZNKND-8pgwPmy49uvNz")) ? 1 : 0;
        } catch (Throwable unused) {
            return 0;
        }
    }
}
