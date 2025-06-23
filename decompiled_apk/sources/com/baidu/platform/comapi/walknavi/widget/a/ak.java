package com.baidu.platform.comapi.walknavi.widget.a;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class ak implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ z f9854a;

    public ak(z zVar) {
        this.f9854a = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f9854a.d != null) {
            this.f9854a.d.w();
        }
    }
}
