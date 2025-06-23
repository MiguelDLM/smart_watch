package com.sma.smartv3.initializer;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.tencent.bugly.crashreport.CrashReport;
import java.util.Locale;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class ooOOo0oXI implements com.bestmafen.androidbase.base.II0xO0 {

    /* renamed from: Oo, reason: collision with root package name */
    public static Application f20932Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final ooOOo0oXI f20933XO = new ooOOo0oXI();

    @XO0.XO(tag = XoI0Ixx0.f24489xoIox)
    public final void I0Io(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onPrivacyAgree");
        if (ProjectManager.f19822oIX0oI.OIOoIIOIx()) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("bugly init");
            Application application = f20932Oo;
            Application application2 = null;
            if (application == null) {
                IIX0o.XOxIOxOx("app");
                application = null;
            }
            Application application3 = f20932Oo;
            if (application3 == null) {
                IIX0o.XOxIOxOx("app");
                application3 = null;
            }
            CrashReport.initCrashReport(application, application3.getString(R.string.bugly_appid), false);
            Application application4 = f20932Oo;
            if (application4 == null) {
                IIX0o.XOxIOxOx("app");
            } else {
                application2 = application4;
            }
            CrashReport.setDeviceModel(application2, II0xO0());
        }
    }

    @OXOo.OOXIXo
    public final String II0xO0() {
        try {
            String str = Build.MODEL;
            if (!TextUtils.isEmpty(str)) {
                IIX0o.ooOOo0oXI(str);
                Locale locale = Locale.getDefault();
                IIX0o.oO(locale, "getDefault(...)");
                String lowerCase = str.toLowerCase(locale);
                IIX0o.oO(lowerCase, "toLowerCase(...)");
                return lowerCase;
            }
            return "UNKNOWN";
        } catch (Throwable unused) {
            return "UNKNOWN";
        }
    }

    @Override // com.bestmafen.androidbase.base.II0xO0
    public void oIX0oI(@OXOo.OOXIXo Application app) {
        IIX0o.x0xO0oo(app, "app");
        XO0.II0xO0.oxoX().x0XOIxOo(this);
        f20932Oo = app;
        if (Xo0.f24349oIX0oI.oIX0oI().getBoolean(XoI0Ixx0.f24489xoIox, false)) {
            I0Io(new Object());
        }
    }
}
