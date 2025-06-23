package com.baidu.mapapi.map;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f5918a;
    final /* synthetic */ MapView b;

    public x(MapView mapView, View view) {
        this.b = mapView;
        this.f5918a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.removeView(this.f5918a);
    }
}
