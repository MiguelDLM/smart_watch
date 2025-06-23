package com.baidu.platform.comapi.wnplatform.arclayout;

import android.graphics.Outline;
import android.graphics.Path;
import android.view.View;
import android.view.ViewOutlineProvider;

/* loaded from: classes8.dex */
class c extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9892a;

    public c(b bVar) {
        this.f9892a = bVar;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        com.baidu.platform.comapi.wnplatform.arclayout.a.a aVar;
        com.baidu.platform.comapi.wnplatform.arclayout.a.a aVar2;
        aVar = this.f9892a.clipManager;
        if (aVar != null) {
            aVar2 = this.f9892a.clipManager;
            Path a2 = aVar2.a();
            if (a2 != null) {
                try {
                    outline.setConvexPath(a2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
