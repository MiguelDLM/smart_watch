package com.tencent.open.web.security;

import XxXX.X0o0xo;
import android.content.Context;
import java.io.File;
import xIxooxXX.oIX0oI;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class JniInterface {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static boolean f26980oIX0oI = false;

    public static native boolean BackSpaceChar(boolean z, int i);

    public static native boolean clearAllPWD();

    public static native String getPWDKeyToMD5(String str);

    public static native boolean insetTextToArray(int i, String str, int i2);

    public static void oIX0oI() {
        if (f26980oIX0oI) {
            return;
        }
        try {
            Context oIX0oI2 = X0o0xo.oIX0oI();
            if (oIX0oI2 != null) {
                if (new File(oIX0oI2.getFilesDir().toString() + "/" + oIX0oI.f34414xoIox).exists()) {
                    System.load(oIX0oI2.getFilesDir().toString() + "/" + oIX0oI.f34414xoIox);
                    f26980oIX0oI = true;
                    xxIXOIIO.oOoXoXO("openSDK_LOG.JniInterface", "-->load lib success:" + oIX0oI.f34414xoIox);
                } else {
                    xxIXOIIO.oOoXoXO("openSDK_LOG.JniInterface", "-->fail, because so is not exists:" + oIX0oI.f34414xoIox);
                }
            } else {
                xxIXOIIO.oOoXoXO("openSDK_LOG.JniInterface", "-->load lib fail, because context is null:" + oIX0oI.f34414xoIox);
            }
        } catch (Throwable th) {
            xxIXOIIO.xxIXOIIO("openSDK_LOG.JniInterface", "-->load lib error:" + oIX0oI.f34414xoIox, th);
        }
    }
}
