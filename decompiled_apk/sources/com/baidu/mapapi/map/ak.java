package com.baidu.mapapi.map;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ak implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f5887a;
    final /* synthetic */ TextureMapView b;

    public ak(TextureMapView textureMapView, View view) {
        this.b = textureMapView;
        this.f5887a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.removeView(this.f5887a);
    }
}
