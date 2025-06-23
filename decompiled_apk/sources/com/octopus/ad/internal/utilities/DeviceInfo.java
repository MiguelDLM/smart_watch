package com.octopus.ad.internal.utilities;

import XXO0.oIX0oI;
import android.content.Context;
import android.os.Build;
import com.octopus.ad.R;
import com.octopus.ad.internal.xoIox;
import com.octopus.ad.model.e;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import o0IXXIx.x0XOIxOo;
import x0.x0o;
import x0.xII;

/* loaded from: classes11.dex */
public class DeviceInfo {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static String f18658IIXOooo = null;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f18659IXxxXO = 1;

    /* renamed from: OxI, reason: collision with root package name */
    public static DeviceInfo f18660OxI = null;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static String f18661Oxx0xo = "SDK_UID_KEY";

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static String f18662OxxIIOOXO = null;

    /* renamed from: o00, reason: collision with root package name */
    public static String f18663o00 = null;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static String f18664oI0IIXIo = "SDK_UID_KEY_NEW";

    /* renamed from: xoXoI, reason: collision with root package name */
    public static String f18665xoXoI;

    /* renamed from: I0Io, reason: collision with root package name */
    public String f18666I0Io;

    /* renamed from: Oo, reason: collision with root package name */
    public String f18670Oo;

    /* renamed from: oO, reason: collision with root package name */
    public String f18675oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public String f18676oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public String f18677ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public String f18679x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public boolean f18680x0xO0oo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f18674oIX0oI = null;

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f18668II0xO0 = false;

    /* renamed from: oxoX, reason: collision with root package name */
    public final String f18678oxoX = Build.VERSION.SDK_INT + " (" + Build.VERSION.RELEASE + oIX0oI.I0Io.f4095I0Io;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public e.b f18672X0o0xo = e.b.DEVICE_OTHER;

    /* renamed from: XO, reason: collision with root package name */
    public final String f18673XO = Build.BRAND;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final String f18671Oxx0IOOO = Build.MODEL;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final String f18667II0XooXoX = Build.MANUFACTURER;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public String f18682xxIXOIIO = null;

    /* renamed from: xoIox, reason: collision with root package name */
    public String f18681xoIox = null;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public final String f18669OOXIXo = Locale.getDefault().getLanguage();

    static {
        try {
            System.loadLibrary("octopus");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        f18660OxI = null;
    }

    public static DeviceInfo oxoX() {
        DeviceInfo deviceInfo;
        synchronized (DeviceInfo.class) {
            try {
                if (f18660OxI == null) {
                    f18660OxI = new DeviceInfo();
                    oIX0oI.ooXIXxIX(oIX0oI.f18685II0xO0, oIX0oI.xxIXOIIO(R.string.init));
                    f18662OxxIIOOXO = xoIox.oIX0oI().f19082x0xO0oo.getResources().getDisplayMetrics().density + "";
                    f18658IIXOooo = xoIox.oIX0oI().f19082x0xO0oo.getResources().getDisplayMetrics().densityDpi + "";
                    f18665xoXoI = x0XOIxOo.IXxxXO(xoIox.oIX0oI().f19082x0xO0oo);
                    f18663o00 = x0XOIxOo.XO();
                }
                deviceInfo = f18660OxI;
            } catch (Throwable th) {
                throw th;
            }
        }
        return deviceInfo;
    }

    public void I0Io(Context context) {
        String II0xO02 = II0xO0();
        String oIX0oI2 = oIX0oI();
        String str = x0o.OOXIXo(this.f18673XO + "_" + this.f18671Oxx0IOOO + "_" + x0XOIxOo.OOXIXo(context) + "_1_" + II0xO02 + "_" + oIX0oI2) + "_1_" + II0xO02 + "_" + oIX0oI2;
        this.f18674oIX0oI = str;
        xII.ooOOo0oXI(context, f18664oI0IIXIo, str);
    }

    public final String II0xO0() {
        Random random = new Random();
        return "" + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0045 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:3:0x0007, B:6:0x0025, B:13:0x0045, B:15:0x005d, B:17:0x006d, B:22:0x0081, B:24:0x0087, B:25:0x0097, B:27:0x0040), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0081 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:3:0x0007, B:6:0x0025, B:13:0x0045, B:15:0x005d, B:17:0x006d, B:22:0x0081, B:24:0x0087, B:25:0x0097, B:27:0x0040), top: B:2:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void X0o0xo(android.content.Context r12) {
        /*
            r11 = this;
            java.lang.String r0 = "0"
            java.lang.String r1 = "OctopusAd"
            java.lang.String r2 = "SystemMarkStatus"
            r3 = 0
            int r4 = x0.xII.xoIox(r12, r2, r3)     // Catch: java.lang.Throwable -> L35
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            r5.<init>()     // Catch: java.lang.Throwable -> L35
            java.lang.String r6 = "getMarks status= "
            r5.append(r6)     // Catch: java.lang.Throwable -> L35
            r5.append(r4)     // Catch: java.lang.Throwable -> L35
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L35
            android.util.Log.e(r1, r5)     // Catch: java.lang.Throwable -> L35
            java.lang.String r5 = "SystemMarkStatusExpireTime"
            r6 = 3
            r7 = 1
            if (r4 != r7) goto L38
            x0.xII.oO(r12, r2, r6)     // Catch: java.lang.Throwable -> L35
            long r8 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L35
            java.lang.Long r4 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L35
            x0.xII.ooOOo0oXI(r12, r5, r4)     // Catch: java.lang.Throwable -> L35
            r4 = 3
            goto L38
        L35:
            r12 = move-exception
            goto Lc1
        L38:
            r8 = 2
            if (r4 == 0) goto L40
            if (r4 != r8) goto L3e
            goto L40
        L3e:
            r7 = r4
            goto L43
        L40:
            x0.xII.oO(r12, r2, r7)     // Catch: java.lang.Throwable -> L35
        L43:
            if (r7 != r6) goto L81
            long r6 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> L35
            java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Throwable -> L35
            java.lang.Object r4 = x0.xII.oxoX(r12, r5, r4)     // Catch: java.lang.Throwable -> L35
            java.lang.Long r4 = (java.lang.Long) r4     // Catch: java.lang.Throwable -> L35
            long r6 = r4.longValue()     // Catch: java.lang.Throwable -> L35
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L80
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L35
            long r8 = r4.longValue()     // Catch: java.lang.Throwable -> L35
            long r6 = r6 - r8
            r8 = -1702967296(0xffffffff9a7ec800, double:NaN)
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 <= 0) goto L80
            x0.xII.oO(r12, r2, r3)     // Catch: java.lang.Throwable -> L35
            long r2 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> L35
            java.lang.Long r0 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> L35
            x0.xII.ooOOo0oXI(r12, r5, r0)     // Catch: java.lang.Throwable -> L35
            java.lang.String r12 = "bootMark expireTime= null and status = 0"
            android.util.Log.d(r1, r12)     // Catch: java.lang.Throwable -> L35
        L80:
            return
        L81:
            java.lang.String r0 = r11.getBootMark()     // Catch: java.lang.Throwable -> L35
            if (r0 == 0) goto L97
            int r4 = r0.length()     // Catch: java.lang.Throwable -> L35
            r5 = 36
            int r4 = java.lang.Math.min(r5, r4)     // Catch: java.lang.Throwable -> L35
            java.lang.String r0 = r0.substring(r3, r4)     // Catch: java.lang.Throwable -> L35
            r11.f18676oOoXoXO = r0     // Catch: java.lang.Throwable -> L35
        L97:
            java.lang.String r0 = r11.getUpdateMark()     // Catch: java.lang.Throwable -> L35
            r11.f18677ooOOo0oXI = r0     // Catch: java.lang.Throwable -> L35
            x0.xII.oO(r12, r2, r8)     // Catch: java.lang.Throwable -> L35
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            r12.<init>()     // Catch: java.lang.Throwable -> L35
            java.lang.String r0 = "bootMark = "
            r12.append(r0)     // Catch: java.lang.Throwable -> L35
            java.lang.String r0 = r11.f18676oOoXoXO     // Catch: java.lang.Throwable -> L35
            r12.append(r0)     // Catch: java.lang.Throwable -> L35
            java.lang.String r0 = ",updateMark = "
            r12.append(r0)     // Catch: java.lang.Throwable -> L35
            java.lang.String r0 = r11.f18677ooOOo0oXI     // Catch: java.lang.Throwable -> L35
            r12.append(r0)     // Catch: java.lang.Throwable -> L35
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> L35
            android.util.Log.e(r1, r12)     // Catch: java.lang.Throwable -> L35
            goto Ldc
        Lc1:
            r12.printStackTrace()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Exception："
            r0.append(r2)
            java.lang.String r12 = r12.getMessage()
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            android.util.Log.d(r1, r12)
        Ldc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.octopus.ad.internal.utilities.DeviceInfo.X0o0xo(android.content.Context):void");
    }

    public native String getBootMark();

    public native String getUpdateMark();

    public final String oIX0oI() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.clear();
        calendar.set(2020, 0, 1, 0, 0, 0);
        return String.valueOf(System.currentTimeMillis() - calendar.getTimeInMillis());
    }
}
