package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.huawei.hms.ads.ck;
import com.huawei.hms.ads.fb;
import java.util.Locale;

/* loaded from: classes10.dex */
public class l {
    private static final String B = "ro.product.locale.region";
    private static final String C = "ro.product.locale";
    public static final String Code = "ro.hw.country";
    private static final String D = "la";
    private static final String F = "eu";
    public static final String I = "CN";
    private static final String L = "uk";
    private static final String S = "UNKNOWN";
    public static final String V = "msc.sys.country";
    private static final String Z = "CountryCodeBean";

    /* renamed from: a, reason: collision with root package name */
    private static final String f17411a = "gb";
    private static final String b = "cn";
    private static final int c = 2;
    private String d;

    public l(Context context) {
        this.d = S;
        Code(context);
        this.d = this.d.toUpperCase(Locale.ENGLISH);
    }

    private void B(Context context) {
        int lastIndexOf;
        String Code2 = bc.Code(B);
        this.d = Code2;
        if (TextUtils.isEmpty(Code2)) {
            String Code3 = bc.Code(C);
            if (!TextUtils.isEmpty(Code3) && (lastIndexOf = Code3.lastIndexOf(HelpFormatter.DEFAULT_OPT_PREFIX)) != -1) {
                this.d = Code3.substring(lastIndexOf + 1);
            }
        }
        if (b.equalsIgnoreCase(this.d)) {
            return;
        }
        this.d = S;
    }

    private void I() {
        String str = this.d;
        if (str == null || str.length() != 2) {
            this.d = S;
        }
    }

    private void V(Context context) {
        String str;
        this.d = bc.Code(ck.Z(context) ? V : Code);
        if (F.equalsIgnoreCase(this.d) || D.equalsIgnoreCase(this.d)) {
            str = S;
        } else {
            if (!L.equalsIgnoreCase(this.d)) {
                I();
                return;
            }
            str = f17411a;
        }
        this.d = str;
    }

    private void Z() {
        String country = Locale.getDefault().getCountry();
        this.d = country;
        if (TextUtils.isEmpty(country)) {
            this.d = S;
        }
    }

    public String Code() {
        if (fb.Code()) {
            fb.Code(Z, "countryCode: %s", this.d);
        }
        return this.d;
    }

    private void Code(Context context) {
        if (context == null) {
            return;
        }
        try {
            V(context);
            if (V()) {
                fb.V(Z, "get issue_country code from VENDOR_COUNTRY");
                return;
            }
            I(context);
            if (V()) {
                fb.V(Z, "get issue_country code from SIM_COUNTRY");
                return;
            }
            if (n.B(context)) {
                fb.V(Z, "pad skip locale get issue_country code from grs ip");
                return;
            }
            Z(context);
            if (V()) {
                fb.V(Z, "get issue_country code from LOCALE_INFO");
            }
        } catch (Throwable unused) {
            fb.I(Z, "get CountryCode error");
        }
    }

    private void I(Context context) {
        Code(context, false);
    }

    private boolean V() {
        return !S.equals(this.d);
    }

    private void Z(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            Z();
        } else {
            B(context);
        }
    }

    private void Code(Context context, boolean z) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        if (telephonyManager != null) {
            this.d = (!z || telephonyManager.getPhoneType() == 2) ? telephonyManager.getSimCountryIso() : telephonyManager.getNetworkCountryIso();
        }
        I();
    }
}
