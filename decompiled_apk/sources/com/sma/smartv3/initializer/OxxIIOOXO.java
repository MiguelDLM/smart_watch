package com.sma.smartv3.initializer;

import android.app.Application;
import com.sma.androidnetworklib.HttpLoggingInterceptor;
import com.sma.smartv3.util.UtilsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class OxxIIOOXO implements com.bestmafen.androidbase.base.II0xO0 {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final OxxIIOOXO f20891XO = new OxxIIOOXO();

    public static final void I0Io(String str) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("Http: " + str);
    }

    @Override // com.bestmafen.androidbase.base.II0xO0
    public void oIX0oI(@OXOo.OOXIXo Application app) {
        IIX0o.x0xO0oo(app, "app");
        com.sma.androidnetworklib.oIX0oI.f19697oIX0oI.II0xO0(app, UtilsKt.IO(app), HttpLoggingInterceptor.Level.CUSTOM, new HttpLoggingInterceptor.oIX0oI() { // from class: com.sma.smartv3.initializer.oI0IIXIo
            @Override // com.sma.androidnetworklib.HttpLoggingInterceptor.oIX0oI
            public final void log(String str) {
                OxxIIOOXO.I0Io(str);
            }
        });
    }
}
