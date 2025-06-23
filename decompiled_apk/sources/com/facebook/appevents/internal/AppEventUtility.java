package com.facebook.appevents.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes8.dex */
public final class AppEventUtility {

    @OOXIXo
    public static final AppEventUtility INSTANCE = new AppEventUtility();

    @OOXIXo
    private static final String PRICE_REGEX = "[-+]*\\d+([.,]\\d+)*([.,]\\d+)?";

    private AppEventUtility() {
    }

    @x0XOIxOo
    public static final void assertIsMainThread() {
    }

    @x0XOIxOo
    public static final void assertIsNotMainThread() {
    }

    @x0XOIxOo
    @OOXIXo
    public static final String bytesToHex(@OOXIXo byte[] bytes) {
        IIX0o.x0xO0oo(bytes, "bytes");
        StringBuffer stringBuffer = new StringBuffer();
        int length = bytes.length;
        int i = 0;
        while (i < length) {
            byte b = bytes[i];
            i++;
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
            IIX0o.oO(format, "java.lang.String.format(format, *args)");
            stringBuffer.append(format);
        }
        String stringBuffer2 = stringBuffer.toString();
        IIX0o.oO(stringBuffer2, "sb.toString()");
        return stringBuffer2;
    }

    @x0XOIxOo
    @OOXIXo
    public static final String getAppVersion() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        try {
            String str = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName;
            IIX0o.oO(str, "{\n      val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)\n      packageInfo.versionName\n    }");
            return str;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    @x0XOIxOo
    @oOoXoXO
    public static final View getRootView(@oOoXoXO Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(AppEventUtility.class) || activity == null) {
            return null;
        }
        try {
            Window window = activity.getWindow();
            if (window == null) {
                return null;
            }
            return window.getDecorView().getRootView();
        } catch (Exception unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventUtility.class);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
    
        if (kotlin.text.OxI.IOOoXo0Ix(r0, "generic", false, 2, null) == false) goto L18;
     */
    @XO0OX.x0XOIxOo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean isEmulator() {
        /*
            java.lang.String r0 = android.os.Build.FINGERPRINT
            java.lang.String r1 = "FINGERPRINT"
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            java.lang.String r2 = "generic"
            r3 = 0
            r4 = 2
            r5 = 0
            boolean r6 = kotlin.text.OxI.IOOoXo0Ix(r0, r2, r3, r4, r5)
            if (r6 != 0) goto L74
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            java.lang.String r1 = "unknown"
            boolean r0 = kotlin.text.OxI.IOOoXo0Ix(r0, r1, r3, r4, r5)
            if (r0 != 0) goto L74
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r1 = "MODEL"
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            java.lang.String r6 = "google_sdk"
            boolean r7 = kotlin.text.StringsKt__StringsKt.o00xOoIO(r0, r6, r3, r4, r5)
            if (r7 != 0) goto L74
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            java.lang.String r7 = "Emulator"
            boolean r7 = kotlin.text.StringsKt__StringsKt.o00xOoIO(r0, r7, r3, r4, r5)
            if (r7 != 0) goto L74
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            java.lang.String r1 = "Android SDK built for x86"
            boolean r0 = kotlin.text.StringsKt__StringsKt.o00xOoIO(r0, r1, r3, r4, r5)
            if (r0 != 0) goto L74
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.lang.String r1 = "MANUFACTURER"
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            java.lang.String r1 = "Genymotion"
            boolean r0 = kotlin.text.StringsKt__StringsKt.o00xOoIO(r0, r1, r3, r4, r5)
            if (r0 != 0) goto L74
            java.lang.String r0 = android.os.Build.BRAND
            java.lang.String r1 = "BRAND"
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            boolean r0 = kotlin.text.OxI.IOOoXo0Ix(r0, r2, r3, r4, r5)
            if (r0 == 0) goto L6c
            java.lang.String r0 = android.os.Build.DEVICE
            java.lang.String r1 = "DEVICE"
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            boolean r0 = kotlin.text.OxI.IOOoXo0Ix(r0, r2, r3, r4, r5)
            if (r0 != 0) goto L74
        L6c:
            java.lang.String r0 = android.os.Build.PRODUCT
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r6, r0)
            if (r0 == 0) goto L75
        L74:
            r3 = 1
        L75:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.AppEventUtility.isEmulator():boolean");
    }

    @x0XOIxOo
    private static final boolean isMainThread() {
        return IIX0o.Oxx0IOOO(Looper.myLooper(), Looper.getMainLooper());
    }

    @x0XOIxOo
    public static final double normalizePrice(@oOoXoXO String str) {
        try {
            Matcher matcher = Pattern.compile(PRICE_REGEX, 8).matcher(str);
            if (!matcher.find()) {
                return XIXIX.OOXIXo.f3760XO;
            }
            String group = matcher.group(0);
            Utility utility = Utility.INSTANCE;
            return NumberFormat.getNumberInstance(Utility.getCurrentLocale()).parse(group).doubleValue();
        } catch (ParseException unused) {
            return XIXIX.OOXIXo.f3760XO;
        }
    }
}
