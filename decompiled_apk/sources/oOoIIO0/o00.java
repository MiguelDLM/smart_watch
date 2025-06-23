package oOoIIO0;

import android.content.Context;
import android.util.TypedValue;
import com.garmin.fit.X0xOO;
import com.goodix.ble.libcomx.ptmodel.PtStep;

/* loaded from: classes11.dex */
public class o00 {

    /* renamed from: I0Io, reason: collision with root package name */
    public final String f32041I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f32042II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f32043oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final o00 f32038oxoX = new o00(X0xOO.f13583O0o0, 50, "320x50_mb");

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final o00 f32035X0o0xo = new o00(468, 60, "468x60_as");

    /* renamed from: XO, reason: collision with root package name */
    public static final o00 f32036XO = new o00(X0xOO.f13583O0o0, 100, "320x100_as");

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final o00 f32034Oxx0IOOO = new o00(PtStep.EVT_JUDGE_UPDATED, 90, "728x90_as");

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final o00 f32032II0XooXoX = new o00(300, 250, "300x250_as");

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final o00 f32040xxIXOIIO = new o00(160, 600, "160x600_as");

    /* renamed from: xoIox, reason: collision with root package name */
    public static final o00 f32039xoIox = new o00(-1, -2, "smart_banner");

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final o00 f32033OOXIXo = new o00(-3, -4, "fluid");

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final o00 f32037oOoXoXO = new o00(-3, 0, "search_v2");

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public o00(int r3, int r4) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = -1
            if (r3 != r1) goto Lb
            java.lang.String r1 = "FULL"
            goto Lf
        Lb:
            java.lang.String r1 = java.lang.String.valueOf(r3)
        Lf:
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            r1 = -2
            if (r4 != r1) goto L1d
            java.lang.String r1 = "AUTO"
            goto L21
        L1d:
            java.lang.String r1 = java.lang.String.valueOf(r4)
        L21:
            r0.append(r1)
            java.lang.String r1 = "_as"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2.<init>(r3, r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: oOoIIO0.o00.<init>(int, int):void");
    }

    public int I0Io() {
        return this.f32043oIX0oI;
    }

    public int II0xO0(Context context) {
        int i = this.f32042II0xO0;
        if (i != -4 && i != -3) {
            if (i != -2) {
                return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
            }
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o00)) {
            return false;
        }
        o00 o00Var = (o00) obj;
        if (this.f32043oIX0oI == o00Var.f32043oIX0oI && this.f32042II0xO0 == o00Var.f32042II0xO0 && this.f32041I0Io.equals(o00Var.f32041I0Io)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f32041I0Io.hashCode();
    }

    public int oIX0oI() {
        return this.f32042II0xO0;
    }

    public int oxoX(Context context) {
        int i = this.f32043oIX0oI;
        if (i == -4 || i == -3) {
            return -1;
        }
        if (i != -1) {
            return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public String toString() {
        return this.f32041I0Io;
    }

    public o00(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i);
        }
        if (i2 < 0 && i2 != -2 && i2 != -4) {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i2);
        }
        this.f32043oIX0oI = i;
        this.f32042II0xO0 = i2;
        this.f32041I0Io = str;
    }
}
