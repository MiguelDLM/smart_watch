package com.baidu.platform.comapi.walknavi.widget.a;

import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class w implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9879a;

    public w(a aVar) {
        this.f9879a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        relativeLayout = this.f9879a.w;
        if (relativeLayout != null) {
            relativeLayout2 = this.f9879a.w;
            relativeLayout2.setVisibility(0);
        }
    }
}
