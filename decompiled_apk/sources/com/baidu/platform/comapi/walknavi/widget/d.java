package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9886a;

    public d(b bVar) {
        this.f9886a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.a aVar;
        b.a aVar2;
        aVar = this.f9886a.h;
        if (aVar != null) {
            aVar2 = this.f9886a.h;
            aVar2.a();
        }
        this.f9886a.dismiss();
    }
}
