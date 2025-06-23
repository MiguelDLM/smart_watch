package com.sma.smartv3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.CallSuper;
import androidx.multidex.MultiDex;
import com.bestmafen.androidbase.base.BaseApplication;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.ProcessUtils;
import com.sma.smartv3.app.II0xO0;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.initializer.AGPSInitializer;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.initializer.IIXOooo;
import com.sma.smartv3.initializer.OxI;
import com.sma.smartv3.initializer.OxxIIOOXO;
import com.sma.smartv3.initializer.StockInitializer;
import com.sma.smartv3.initializer.UtilInitializer;
import com.sma.smartv3.initializer.WeatherInitializer;
import com.sma.smartv3.initializer.X0IIOO;
import com.sma.smartv3.initializer.X0o0xo;
import com.sma.smartv3.initializer.o00;
import com.sma.smartv3.initializer.oO;
import com.sma.smartv3.initializer.x0XOIxOo;
import com.sma.smartv3.initializer.x0xO0oo;
import com.sma.smartv3.initializer.xoXoI;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;

@SuppressLint({"Registered"})
/* loaded from: classes12.dex */
public class BaseApp extends BaseApplication {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @oOoXoXO
    public II0xO0 f19721Oxx0xo;

    @Override // com.bestmafen.androidbase.base.BaseApplication
    @CallSuper
    public void II0xO0(@OOXIXo Set<com.bestmafen.androidbase.base.II0xO0> initInitializers) {
        List ooXIXxIX2;
        IIX0o.x0xO0oo(initInitializers, "initInitializers");
        if (IIX0o.Oxx0IOOO(AppUtils.getAppPackageName(), ProcessUtils.getCurrentProcessName())) {
            ProjectManager.f19822oIX0oI.XO(this);
            ooXIXxIX2 = CollectionsKt__CollectionsKt.X00IoxXI(UtilInitializer.f20904XO, x0XOIxOo.f20934XO, x0xO0oo.f20935XO, BleInitializer.f20700XO, WeatherInitializer.f20909XO, AGPSInitializer.f20674XO, oO.f20931XO, OxxIIOOXO.f20891XO, X0IIOO.f20923XO, xoXoI.f20936XO, IIXOooo.f20834XO, StockInitializer.f20895XO, OxI.f20887XO, o00.f20929XO, X0o0xo.f20928XO);
        } else {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        initInitializers.addAll(ooXIXxIX2);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(@OOXIXo Context base) {
        IIX0o.x0xO0oo(base, "base");
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override // com.bestmafen.androidbase.base.BaseApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        II0xO0 iI0xO0 = new II0xO0(this);
        this.f19721Oxx0xo = iI0xO0;
        registerActivityLifecycleCallbacks(iI0xO0);
    }

    @Override // android.app.Application
    public void onTerminate() {
        unregisterActivityLifecycleCallbacks(this.f19721Oxx0xo);
        super.onTerminate();
    }
}
