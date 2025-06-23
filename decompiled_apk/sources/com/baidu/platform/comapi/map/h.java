package com.baidu.platform.comapi.map;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class h implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GLTextureView f9662a;

    public h(GLTextureView gLTextureView) {
        this.f9662a = gLTextureView;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        GLTextureView gLTextureView = this.f9662a;
        gLTextureView.onSurfaceTextureSizeChanged(gLTextureView.getSurfaceTexture(), i3 - i, i4 - i2);
    }
}
