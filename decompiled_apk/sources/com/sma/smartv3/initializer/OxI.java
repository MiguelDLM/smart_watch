package com.sma.smartv3.initializer;

import android.app.Application;
import com.sma.smartv3.biz.voice.VoiceManager;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class OxI implements com.bestmafen.androidbase.base.II0xO0 {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final OxI f20887XO = new OxI();

    @Override // com.bestmafen.androidbase.base.II0xO0
    public void oIX0oI(@OXOo.OOXIXo Application app) {
        IIX0o.x0xO0oo(app, "app");
        VoiceManager.INSTANCE.init(app);
    }
}
