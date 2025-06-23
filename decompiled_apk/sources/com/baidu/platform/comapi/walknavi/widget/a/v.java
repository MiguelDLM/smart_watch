package com.baidu.platform.comapi.walknavi.widget.a;

import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class v implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9878a;

    public v(a aVar) {
        this.f9878a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        relativeLayout = this.f9878a.h;
        relativeLayout.setVisibility(0);
    }
}
