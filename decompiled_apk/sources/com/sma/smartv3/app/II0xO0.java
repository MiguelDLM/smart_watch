package com.sma.smartv3.app;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.blankj.utilcode.util.AppUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.initializer.X0o0xo;
import com.sma.smartv3.ui.main.BaseMainActivity;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.x0xO0oo;
import com.szabh.smable3.component.BleConnector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class II0xO0 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OOXIXo
    public static final String f19810IIXOooo = "lastDate";

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f19811OxxIIOOXO = new oIX0oI(null);

    /* renamed from: o00, reason: collision with root package name */
    public static final int f19812o00 = 3;

    /* renamed from: xoXoI, reason: collision with root package name */
    @OOXIXo
    public static final String f19813xoXoI = "openCountToday";

    /* renamed from: IXxxXO, reason: collision with root package name */
    @oOoXoXO
    public String f19814IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public final String f19815Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f19816Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final Context f19817XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f19818oI0IIXIo;

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public final void II0xO0() {
            Xo0.f24349oIX0oI.II0xO0().put(II0xO0.f19813xoXoI, 0);
        }

        public final int oIX0oI() {
            return Xo0.f24349oIX0oI.II0xO0().getInt(II0xO0.f19813xoXoI, 0);
        }

        public oIX0oI() {
        }
    }

    public II0xO0(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        this.f19817XO = context;
        this.f19815Oo = "AppLifecycle";
    }

    public static final void oxoX(II0xO0 this$0, Activity activity) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(activity, "$activity");
        this$0.f19818oI0IIXIo = AppUtils.isAppForeground();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.f19815Oo + " onStopped -> " + activity.getClass().getSimpleName() + TokenParser.SP + this$0.f19818oI0IIXIo);
    }

    public final void I0Io() {
        Xo0 xo0 = Xo0.f24349oIX0oI;
        this.f19814IXxxXO = xo0.II0xO0().getString(f19810IIXOooo);
        this.f19816Oxx0xo = xo0.II0xO0().getInt(f19813xoXoI, 0);
    }

    public final String II0xO0() {
        String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        IIX0o.oO(format, "format(...)");
        return format;
    }

    public final void X0o0xo() {
        Xo0 xo0 = Xo0.f24349oIX0oI;
        xo0.II0xO0().put(f19810IIXOooo, II0xO0());
        xo0.II0xO0().put(f19813xoXoI, this.f19816Oxx0xo);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@OOXIXo Activity activity, @oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(activity, "activity");
        if (activity instanceof BaseMainActivity) {
            this.f19818oI0IIXIo = false;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        I0Io();
        if (activity instanceof BaseMainActivity) {
            if (!this.f19818oI0IIXIo) {
                String II0xO02 = II0xO0();
                if (!IIX0o.Oxx0IOOO(II0xO02, this.f19814IXxxXO)) {
                    this.f19816Oxx0xo = 1;
                    this.f19814IXxxXO = II0xO02;
                } else {
                    this.f19816Oxx0xo++;
                }
                X0o0xo();
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                oix0oi.oIX0oI(this.f19815Oo + " onResumed -> " + this.f19816Oxx0xo + " times");
                int i = this.f19816Oxx0xo;
                if ((i == 1 || i == 3) && ProjectManager.f19822oIX0oI.xx0X0()) {
                    X0o0xo x0o0xo = X0o0xo.f20928XO;
                    if (!x0o0xo.XO() && this.f19816Oxx0xo == 3 && BleConnector.INSTANCE.isBound()) {
                        x0o0xo.X0o0xo();
                    }
                    oix0oi.oIX0oI(this.f19815Oo + " onResumed -> Ad state change");
                    x0xO0oo.II0xO0(x0xO0oo.f24576IoIOOxIIo, null, 2, null);
                }
            }
            this.f19818oI0IIXIo = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@OOXIXo Activity activity, @OOXIXo Bundle outState) {
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@OOXIXo final Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        boolean isAppForeground = AppUtils.isAppForeground();
        this.f19818oI0IIXIo = isAppForeground;
        if (isAppForeground) {
            new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.app.oIX0oI
                @Override // java.lang.Runnable
                public final void run() {
                    II0xO0.oxoX(II0xO0.this, activity);
                }
            }, 1000L);
        }
    }
}
