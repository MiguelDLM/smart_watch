package com.baidu.platform.comapi.bikenavi.widget;

import android.widget.ImageView;
import com.baidu.platform.comapi.bikenavi.widget.CustomScrollView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class e implements CustomScrollView.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9563a;

    public e(a aVar) {
        this.f9563a = aVar;
    }

    @Override // com.baidu.platform.comapi.bikenavi.widget.CustomScrollView.b
    public void a(int i) {
    }

    @Override // com.baidu.platform.comapi.bikenavi.widget.CustomScrollView.b
    public void a(com.baidu.platform.comapi.wnplatform.o.b bVar, com.baidu.platform.comapi.wnplatform.o.b bVar2) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        if (bVar == bVar2) {
            return;
        }
        int i = f.f9564a[bVar2.ordinal()];
        if (i == 1) {
            imageView = this.f9563a.v;
            imageView.setVisibility(8);
            imageView2 = this.f9563a.w;
            imageView2.setVisibility(0);
            this.f9563a.b(true);
            return;
        }
        if (i != 2) {
            return;
        }
        imageView3 = this.f9563a.v;
        imageView3.setVisibility(0);
        imageView4 = this.f9563a.w;
        imageView4.setVisibility(8);
        this.f9563a.b(false);
    }
}
