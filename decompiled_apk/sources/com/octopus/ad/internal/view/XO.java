package com.octopus.ad.internal.view;

import android.graphics.Canvas;
import com.octopus.ad.internal.view.f;

/* loaded from: classes11.dex */
public class XO extends AdWebView {

    /* renamed from: xXOx, reason: collision with root package name */
    public f f19011xXOx;

    public XO(AdViewImpl adViewImpl, f fVar) {
        super(adViewImpl);
        this.f18913IoOoX = f.f19012Oxx0xo[f.b.STARTING_EXPANDED.ordinal()];
        this.f19011xXOx = fVar;
    }

    @Override // com.octopus.ad.internal.view.AdWebView
    public void XxX0x0xxx() {
        super.XxX0x0xxx();
        this.f19011xXOx.I0Io();
    }

    @Override // com.octopus.ad.internal.view.AdWebView, android.webkit.WebView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
