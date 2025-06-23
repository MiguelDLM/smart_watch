package com.baidu.platform.comapi.wnplatform.p;

import android.content.Context;
import android.os.Handler;
import java.io.BufferedReader;

/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static String f9952a = "d";
    private static String b;
    private static Handler c = new Handler();
    private static int d = 0;
    private static int e = 0;
    private static BufferedReader f = null;

    public static void a(Context context) {
        try {
            d = 0;
            e = 0;
            BufferedReader bufferedReader = f;
            if (bufferedReader != null) {
                bufferedReader.close();
                f = null;
            }
        } catch (Exception unused) {
        }
    }
}
