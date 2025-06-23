package com.sma.smartv3.initializer;

import android.app.Application;
import com.baidu.mapapi.SDKInitializer;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class oO implements com.bestmafen.androidbase.base.II0xO0 {

    /* renamed from: Oo, reason: collision with root package name */
    public static Application f20930Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oO f20931XO = new oO();

    @XO0.XO(tag = XoI0Ixx0.f24489xoIox)
    public final void II0xO0(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onPrivacyAgree");
        Application application = f20930Oo;
        if (application == null) {
            IIX0o.XOxIOxOx("app");
            application = null;
        }
        SDKInitializer.setAgreePrivacy(application, true);
        Application application2 = f20930Oo;
        if (application2 == null) {
            IIX0o.XOxIOxOx("app");
            application2 = null;
        }
        SDKInitializer.initialize(application2);
        SDKInitializer.setHttpsEnable(true);
        com.sma.smartv3.util.x0xO0oo.II0xO0(XoI0Ixx0.f24367IXxxXO, null, 2, null);
    }

    @Override // com.bestmafen.androidbase.base.II0xO0
    public void oIX0oI(@OXOo.OOXIXo Application app) {
        IIX0o.x0xO0oo(app, "app");
        XO0.II0xO0.oxoX().x0XOIxOo(this);
        f20930Oo = app;
        if (Xo0.f24349oIX0oI.oIX0oI().getBoolean(XoI0Ixx0.f24489xoIox, false)) {
            LogUtils.d("baidu map initialize");
            II0xO0(new Object());
        }
    }
}
