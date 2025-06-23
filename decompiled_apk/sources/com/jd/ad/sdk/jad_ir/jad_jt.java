package com.jd.ad.sdk.jad_ir;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* loaded from: classes10.dex */
public final class jad_jt {
    @NonNull
    public static <T> T jad_an(@Nullable T t) {
        t.getClass();
        return t;
    }

    public static String jad_an(Throwable th) {
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static boolean jad_an(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }
}
