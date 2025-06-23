package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9885a;

    public c(b bVar) {
        this.f9885a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.a aVar;
        b.a aVar2;
        aVar = this.f9885a.g;
        if (aVar != null) {
            aVar2 = this.f9885a.g;
            aVar2.a();
        }
        this.f9885a.dismiss();
    }
}
