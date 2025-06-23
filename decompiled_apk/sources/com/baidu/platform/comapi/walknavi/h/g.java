package com.baidu.platform.comapi.walknavi.h;

import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AnimationDrawable f9805a;
    final /* synthetic */ b b;

    public g(b bVar, AnimationDrawable animationDrawable) {
        this.b = bVar;
        this.f9805a = animationDrawable;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageView imageView;
        ImageView imageView2;
        if (this.f9805a != null) {
            imageView = this.b.aj;
            if (imageView != null) {
                this.f9805a.stop();
                imageView2 = this.b.aj;
                imageView2.setVisibility(8);
            }
        }
    }
}
