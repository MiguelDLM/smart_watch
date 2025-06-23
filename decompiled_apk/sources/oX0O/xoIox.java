package oX0O;

import android.util.Log;

/* loaded from: classes6.dex */
public class xoIox {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f32101II0xO0 = "skin-support";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static boolean f32102oIX0oI = false;

    public static void I0Io(String str) {
        Log.i(f32101II0xO0, str);
    }

    public static void II0xO0(String str, String str2) {
        if (f32102oIX0oI) {
            Log.i(f32101II0xO0, str + ": " + str2);
        }
    }

    public static void oIX0oI(String str) {
        if (f32102oIX0oI) {
            Log.i(f32101II0xO0, str);
        }
    }

    public static void oxoX(String str, String str2) {
        Log.i(f32101II0xO0, str + ": " + str2);
    }
}
