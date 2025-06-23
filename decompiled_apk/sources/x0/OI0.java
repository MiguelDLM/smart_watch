package x0;

import android.content.Context;
import android.text.TextUtils;
import com.octopus.ad.internal.Oxx0IOOO;
import com.octopus.ad.internal.xoIox;
import com.octopus.ad.model.II0xO0;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* loaded from: classes11.dex */
public class OI0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public static String f33681I0Io = ".AD_CLK_PT_UP_X.";

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static String f33682II0XooXoX = ".SCRN_CLK_PT_UP_Y.";

    /* renamed from: II0xO0, reason: collision with root package name */
    public static String f33683II0xO0 = ".AD_CLK_PT_DOWN_Y.";

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static String f33684IIXOooo = "__CLT-999__";

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static String f33685IXxxXO = ".EVENT_TS_START.";

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static String f33686O0xOxO = "${WIN_BIDDER}";

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static String f33687OOXIXo = ".AD_CLK_PT_DOWN_Y_DP.";

    /* renamed from: Oo, reason: collision with root package name */
    public static String f33688Oo = ".SCRN_CLK_PT_UP_Y_DP.";

    /* renamed from: OxI, reason: collision with root package name */
    public static String f33689OxI = "${LOSS_REASON}";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static String f33690Oxx0IOOO = ".SCRN_CLK_PT_UP_X.";

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static String f33691Oxx0xo = ".EVENT_TS_END.";

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static String f33692OxxIIOOXO = "__CLT__";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static String f33693X0o0xo = ".SCRN_CLK_PT_DOWN_X.";

    /* renamed from: XO, reason: collision with root package name */
    public static String f33694XO = ".SCRN_CLK_PT_DOWN_Y.";

    /* renamed from: o00, reason: collision with root package name */
    public static String f33695o00 = "${WIN_PRICE}";

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static String f33696oI0IIXIo = ".VIDEO_DURATION.";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static String f33697oIX0oI = ".AD_CLK_PT_DOWN_X.";

    /* renamed from: oO, reason: collision with root package name */
    public static String f33698oO = ".SCRN_CLK_PT_DOWN_Y_DP.";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static String f33699oOoXoXO = ".AD_CLK_PT_UP_X_DP.";

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static String f33700ooOOo0oXI = ".AD_CLK_PT_UP_Y_DP.";

    /* renamed from: oxoX, reason: collision with root package name */
    public static String f33701oxoX = ".AD_CLK_PT_UP_Y.";

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static String f33702x0XOIxOo = ".SCRN_CLK_PT_DOWN_X_DP.";

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static String f33703x0xO0oo = ".SCRN_CLK_PT_UP_X_DP.";

    /* renamed from: xoIox, reason: collision with root package name */
    public static String f33704xoIox = ".AD_CLK_PT_DOWN_X_DP.";

    /* renamed from: xoXoI, reason: collision with root package name */
    public static String f33705xoXoI = "${SECOND_PRICE}";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static String f33706xxIXOIIO = ".UTC_TS.";

    /* loaded from: classes11.dex */
    public static class oIX0oI implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public InetAddress f33707Oo;

        /* renamed from: XO, reason: collision with root package name */
        public String f33708XO;

        public oIX0oI(String str) {
            this.f33708XO = str;
        }

        public synchronized void II0xO0(InetAddress inetAddress) {
            this.f33707Oo = inetAddress;
        }

        public synchronized InetAddress oIX0oI() {
            return this.f33707Oo;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                II0xO0(InetAddress.getByName(this.f33708XO));
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }

    public static String I0Io(String str, int i, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (str.contains(f33695o00)) {
                str = str.replace(f33695o00, i + "");
            }
            if (str.contains(f33689OxI) && !TextUtils.isEmpty(str2)) {
                str = str.replace(f33689OxI, str2);
            }
            if (str.contains(f33686O0xOxO) && !TextUtils.isEmpty(str3)) {
                return str.replace(f33686O0xOxO, str3);
            }
            return str;
        }
        return str;
    }

    public static void II0XooXoX(II0xO0.xxIXOIIO xxixoiio, String str, String str2, String str3, String str4) {
        String I0Io2 = xxixoiio.I0Io();
        if (!TextUtils.isEmpty(I0Io2)) {
            new Oxx0IOOO(I0Io2).XO();
        }
    }

    public static String II0xO0(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && !str.equals("-999") && !str.equals("0")) {
                return String.valueOf((int) ((((float) Double.parseDouble(str)) / context.getResources().getDisplayMetrics().density) + 0.5f));
            }
            return str;
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    public static void OOXIXo(II0xO0.xxIXOIIO xxixoiio) {
        String Oo2 = xxixoiio.Oo();
        if (!TextUtils.isEmpty(Oo2)) {
            new Oxx0IOOO(Oo2).XO();
        }
    }

    public static String Oxx0IOOO(String str, int i) {
        if (!TextUtils.isEmpty(str) && str.contains(f33705xoXoI)) {
            return str.replace(f33705xoXoI, i + "");
        }
        return str;
    }

    public static String X0o0xo(String str, X0xII0I.II0xO0 iI0xO0, String str2, String str3, String str4, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (i == 2) {
                X0xII0I.II0xO0 iI0xO02 = new X0xII0I.II0xO0();
                if (str.contains(f33692OxxIIOOXO)) {
                    iI0xO02.II0xO0("0");
                    iI0xO02.oxoX("0");
                    iI0xO02.XO("0");
                    iI0xO02.II0XooXoX("0");
                    iI0xO02.xoIox("0");
                    iI0xO02.oOoXoXO("0");
                    iI0xO02.x0XOIxOo("0");
                    iI0xO02.x0xO0oo("0");
                    str = oxoX(str, iI0xO02, str2, str3, str4);
                }
                if (str.contains(f33684IIXOooo)) {
                    iI0xO02.II0xO0("-999");
                    iI0xO02.oxoX("-999");
                    iI0xO02.XO("-999");
                    iI0xO02.II0XooXoX("-999");
                    iI0xO02.xoIox("-999");
                    iI0xO02.oOoXoXO("-999");
                    iI0xO02.x0XOIxOo("-999");
                    iI0xO02.x0xO0oo("-999");
                    str = oxoX(str, iI0xO02, str2, str3, str4);
                }
            } else {
                str = oxoX(str, iI0xO0, str2, str3, str4);
            }
            if (str.contains(f33692OxxIIOOXO)) {
                str = str.replace(f33692OxxIIOOXO, String.valueOf(i));
            }
            if (str.contains(f33684IIXOooo)) {
                str = str.replace(f33684IIXOooo, String.valueOf(i));
            }
            if (str.contains(f33706xxIXOIIO)) {
                str = str.replace(f33706xxIXOIIO, String.valueOf(System.currentTimeMillis()));
            }
            if (str.contains(f33685IXxxXO)) {
                str = str.replace(f33685IXxxXO, str2);
            }
            if (str.contains(f33691Oxx0xo)) {
                str = str.replace(f33691Oxx0xo, str3);
            }
            if (str.contains(f33696oI0IIXIo)) {
                return str.replace(f33696oI0IIXIo, str4);
            }
            return str;
        }
        throw new IllegalArgumentException("url must no null");
    }

    public static String XO(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (!TextUtils.isEmpty(str)) {
            if (str.contains(f33697oIX0oI)) {
                str = str.replace(f33697oIX0oI, str2);
            }
            if (str.contains(f33683II0xO0)) {
                str = str.replace(f33683II0xO0, str3);
            }
            if (str.contains(f33681I0Io)) {
                str = str.replace(f33681I0Io, str2);
            }
            if (str.contains(f33701oxoX)) {
                str = str.replace(f33701oxoX, str3);
            }
            if (str.contains(f33693X0o0xo)) {
                str = str.replace(f33693X0o0xo, str4);
            }
            if (str.contains(f33694XO)) {
                str = str.replace(f33694XO, str5);
            }
            if (str.contains(f33690Oxx0IOOO)) {
                str = str.replace(f33690Oxx0IOOO, str4);
            }
            if (str.contains(f33682II0XooXoX)) {
                str = str.replace(f33682II0XooXoX, str5);
            }
            if (str.contains(f33706xxIXOIIO)) {
                str = str.replace(f33706xxIXOIIO, String.valueOf(System.currentTimeMillis()));
            }
            if (str.contains(f33685IXxxXO)) {
                str = str.replace(f33685IXxxXO, str6);
            }
            if (str.contains(f33691Oxx0xo)) {
                str = str.replace(f33691Oxx0xo, str7);
            }
            if (str.contains(f33696oI0IIXIo)) {
                return str.replace(f33696oI0IIXIo, str8);
            }
            return str;
        }
        throw new IllegalArgumentException("url must no null");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [int, boolean] */
    public static boolean oIX0oI(String str) {
        ?? contains = str.contains(f33697oIX0oI);
        int i = contains;
        if (str.contains(f33683II0xO0)) {
            i = contains + 1;
        }
        int i2 = i;
        if (str.contains(f33681I0Io)) {
            i2 = i + 1;
        }
        int i3 = i2;
        if (str.contains(f33701oxoX)) {
            i3 = i2 + 1;
        }
        int i4 = i3;
        if (str.contains(f33693X0o0xo)) {
            i4 = i3 + 1;
        }
        int i5 = i4;
        if (str.contains(f33694XO)) {
            i5 = i4 + 1;
        }
        int i6 = i5;
        if (str.contains(f33690Oxx0IOOO)) {
            i6 = i5 + 1;
        }
        int i7 = i6;
        if (str.contains(f33682II0XooXoX)) {
            i7 = i6 + 1;
        }
        int i8 = i7;
        if (str.contains(f33706xxIXOIIO)) {
            i8 = i7 + 1;
        }
        if (i8 == 9) {
            return true;
        }
        return false;
    }

    public static void oOoXoXO(II0xO0.xxIXOIIO xxixoiio) {
        String oIX0oI2 = xxixoiio.oIX0oI();
        if (!TextUtils.isEmpty(oIX0oI2)) {
            new Oxx0IOOO(oIX0oI2).XO();
        }
    }

    public static boolean ooOOo0oXI(String str) {
        try {
            oIX0oI oix0oi = new oIX0oI("sv.adintl.cn");
            Thread thread = new Thread(oix0oi);
            thread.start();
            thread.join(1500L);
            if (oix0oi.oIX0oI() == null) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String oxoX(String str, X0xII0I.II0xO0 iI0xO0, String str2, String str3, String str4) {
        if (str.contains(f33697oIX0oI) && !TextUtils.isEmpty(iI0xO0.oIX0oI())) {
            str = str.replace(f33697oIX0oI, iI0xO0.oIX0oI());
        }
        if (str.contains(f33683II0xO0) && !TextUtils.isEmpty(iI0xO0.I0Io())) {
            str = str.replace(f33683II0xO0, iI0xO0.I0Io());
        }
        if (str.contains(f33681I0Io) && !TextUtils.isEmpty(iI0xO0.xxIXOIIO())) {
            str = str.replace(f33681I0Io, iI0xO0.xxIXOIIO());
        }
        if (str.contains(f33701oxoX) && !TextUtils.isEmpty(iI0xO0.OOXIXo())) {
            str = str.replace(f33701oxoX, iI0xO0.OOXIXo());
        }
        if (str.contains(f33693X0o0xo) && !TextUtils.isEmpty(iI0xO0.X0o0xo())) {
            str = str.replace(f33693X0o0xo, iI0xO0.X0o0xo());
        }
        if (str.contains(f33694XO) && !TextUtils.isEmpty(iI0xO0.Oxx0IOOO())) {
            str = str.replace(f33694XO, iI0xO0.Oxx0IOOO());
        }
        if (str.contains(f33690Oxx0IOOO) && !TextUtils.isEmpty(iI0xO0.ooOOo0oXI())) {
            str = str.replace(f33690Oxx0IOOO, iI0xO0.ooOOo0oXI());
        }
        if (str.contains(f33682II0XooXoX) && !TextUtils.isEmpty(iI0xO0.oO())) {
            str = str.replace(f33682II0XooXoX, iI0xO0.oO());
        }
        if (str.contains(f33704xoIox) && !TextUtils.isEmpty(iI0xO0.oIX0oI())) {
            str = str.replace(f33704xoIox, II0xO0(xoIox.oIX0oI().f19082x0xO0oo, iI0xO0.oIX0oI()));
        }
        if (str.contains(f33687OOXIXo) && !TextUtils.isEmpty(iI0xO0.I0Io())) {
            str = str.replace(f33687OOXIXo, II0xO0(xoIox.oIX0oI().f19082x0xO0oo, iI0xO0.I0Io()));
        }
        if (str.contains(f33699oOoXoXO) && !TextUtils.isEmpty(iI0xO0.xxIXOIIO())) {
            str = str.replace(f33699oOoXoXO, II0xO0(xoIox.oIX0oI().f19082x0xO0oo, iI0xO0.xxIXOIIO()));
        }
        if (str.contains(f33700ooOOo0oXI) && !TextUtils.isEmpty(iI0xO0.OOXIXo())) {
            str = str.replace(f33700ooOOo0oXI, II0xO0(xoIox.oIX0oI().f19082x0xO0oo, iI0xO0.OOXIXo()));
        }
        if (str.contains(f33702x0XOIxOo) && !TextUtils.isEmpty(iI0xO0.X0o0xo())) {
            str = str.replace(f33702x0XOIxOo, II0xO0(xoIox.oIX0oI().f19082x0xO0oo, iI0xO0.X0o0xo()));
        }
        if (str.contains(f33698oO) && !TextUtils.isEmpty(iI0xO0.Oxx0IOOO())) {
            str = str.replace(f33698oO, II0xO0(xoIox.oIX0oI().f19082x0xO0oo, iI0xO0.Oxx0IOOO()));
        }
        if (str.contains(f33703x0xO0oo) && !TextUtils.isEmpty(iI0xO0.ooOOo0oXI())) {
            str = str.replace(f33703x0xO0oo, II0xO0(xoIox.oIX0oI().f19082x0xO0oo, iI0xO0.ooOOo0oXI()));
        }
        if (str.contains(f33688Oo) && !TextUtils.isEmpty(iI0xO0.oO())) {
            return str.replace(f33688Oo, II0xO0(xoIox.oIX0oI().f19082x0xO0oo, iI0xO0.oO()));
        }
        return str;
    }

    public static void xoIox(II0xO0.xxIXOIIO xxixoiio) {
        String Oxx0xo2 = xxixoiio.Oxx0xo();
        if (!TextUtils.isEmpty(Oxx0xo2)) {
            new Oxx0IOOO(Oxx0xo2).XO();
        }
    }

    public static void xxIXOIIO(II0xO0.xxIXOIIO xxixoiio) {
        String OxxIIOOXO2 = xxixoiio.OxxIIOOXO();
        if (!TextUtils.isEmpty(OxxIIOOXO2)) {
            new Oxx0IOOO(OxxIIOOXO2).XO();
        }
    }
}
