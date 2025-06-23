package com.sma.smartv3;

import OXOo.OOXIXo;
import android.annotation.SuppressLint;
import com.bestmafen.androidbase.base.II0xO0;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.ProcessUtils;
import com.sma.smartv3.initializer.Oxx0xo;
import com.sma.smartv3.initializer.ooOOo0oXI;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;

@SuppressLint({"Registered"})
/* loaded from: classes12.dex */
public final class NApp extends App {
    @Override // com.sma.smartv3.BaseApp, com.bestmafen.androidbase.base.BaseApplication
    public void II0xO0(@OOXIXo Set<II0xO0> initInitializers) {
        List ooXIXxIX2;
        IIX0o.x0xO0oo(initInitializers, "initInitializers");
        super.II0xO0(initInitializers);
        if (IIX0o.Oxx0IOOO(AppUtils.getAppPackageName(), ProcessUtils.getCurrentProcessName())) {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.X00IoxXI(Oxx0xo.f20889XO, ooOOo0oXI.f20933XO);
        } else {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        initInitializers.addAll(ooXIXxIX2);
    }
}
