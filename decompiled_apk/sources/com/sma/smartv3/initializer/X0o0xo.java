package com.sma.smartv3.initializer;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.ad.ADPAdManager;
import com.sma.smartv3.biz.ad.ADPCAdManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class X0o0xo implements com.bestmafen.androidbase.base.II0xO0 {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static boolean f20925IXxxXO = false;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20926Oo = "AdInitializer";

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static Application f20927Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final X0o0xo f20928XO = new X0o0xo();

    public final void I0Io() {
        ADPAdManager aDPAdManager = ADPAdManager.INSTANCE;
        Application application = f20927Oxx0xo;
        if (application == null) {
            IIX0o.XOxIOxOx("app");
            application = null;
        }
        aDPAdManager.initSdk(application, UtilsKt.oI0IIXIo(R.string.adp_app_id));
    }

    public final String II0xO0(Context context) {
        if (context == null) {
            return null;
        }
        Object systemService = context.getSystemService(TTDownloadField.TT_ACTIVITY);
        IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) systemService).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public final void Oxx0IOOO(boolean z) {
        f20925IXxxXO = z;
    }

    public final void X0o0xo() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AdInitializer initAdSdk -> " + f20925IXxxXO);
        if (f20925IXxxXO) {
            return;
        }
        Application application = f20927Oxx0xo;
        Application application2 = null;
        if (application == null) {
            IIX0o.XOxIOxOx("app");
            application = null;
        }
        String packageName = application.getPackageName();
        Application application3 = f20927Oxx0xo;
        if (application3 == null) {
            IIX0o.XOxIOxOx("app");
        } else {
            application2 = application3;
        }
        if (TextUtils.equals(packageName, II0xO0(application2))) {
            ProjectManager projectManager = ProjectManager.f19822oIX0oI;
            if (projectManager.oOo()) {
                oxoX();
            } else if (projectManager.xOOOX()) {
                I0Io();
            }
            f20925IXxxXO = true;
        }
    }

    public final boolean XO() {
        return f20925IXxxXO;
    }

    @Override // com.bestmafen.androidbase.base.II0xO0
    public void oIX0oI(@OXOo.OOXIXo Application app) {
        IIX0o.x0xO0oo(app, "app");
        XO0.II0xO0.oxoX().x0XOIxOo(this);
        f20927Oxx0xo = app;
        boolean z = false;
        if (Xo0.f24349oIX0oI.oIX0oI().getBoolean(XoI0Ixx0.f24489xoIox, false)) {
            ProductManager productManager = ProductManager.f20544oIX0oI;
            if (productManager.XoOxI0ox() || productManager.xIOXX()) {
                z = true;
            }
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AdInitializer init " + z);
            if (z) {
                X0o0xo();
            }
        }
    }

    public final void oxoX() {
        ADPCAdManager aDPCAdManager = ADPCAdManager.INSTANCE;
        Application application = f20927Oxx0xo;
        if (application == null) {
            IIX0o.XOxIOxOx("app");
            application = null;
        }
        aDPCAdManager.initSdk(application, UtilsKt.oI0IIXIo(R.string.adpc_app_id));
    }
}
