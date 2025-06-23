package com.baidu.platform.comapi.walknavi.widget.a;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class ah implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ z f9851a;

    public ah(z zVar) {
        this.f9851a = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f9851a.d != null) {
            this.f9851a.d.w();
        }
    }
}
