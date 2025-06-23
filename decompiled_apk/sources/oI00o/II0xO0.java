package oI00o;

import android.content.Context;
import android.util.Log;
import android.util.TypedValue;

/* loaded from: classes6.dex */
public class II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public static long f31349I0Io = 0;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static boolean f31350II0xO0 = false;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f31351oIX0oI = "CZXing >>> ";

    public static void I0Io(String str) {
        if (f31350II0xO0) {
            Log.e(f31351oIX0oI, str);
        }
    }

    public static int II0XooXoX(Context context, float f) {
        return (int) TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }

    public static int II0xO0(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static void Oxx0IOOO(boolean z) {
        f31350II0xO0 = z;
    }

    public static boolean X0o0xo() {
        return f31350II0xO0;
    }

    public static void XO() {
        long currentTimeMillis = System.currentTimeMillis();
        Log.e("time:", (currentTimeMillis - f31349I0Io) + "");
        f31349I0Io = currentTimeMillis;
    }

    public static void oIX0oI(String str) {
        if (f31350II0xO0) {
            Log.d(f31351oIX0oI, str);
        }
    }

    public static void oxoX(String str) {
        if (f31350II0xO0) {
            Log.d(f31351oIX0oI, str);
        }
    }

    public static void xxIXOIIO(String str) {
        if (f31350II0xO0) {
            Log.w(f31351oIX0oI, str);
        }
    }
}
