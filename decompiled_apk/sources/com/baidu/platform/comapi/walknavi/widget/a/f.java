package com.baidu.platform.comapi.walknavi.widget.a;

import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class f implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9862a;

    public f(a aVar) {
        this.f9862a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        boolean z;
        RelativeLayout relativeLayout2;
        com.baidu.platform.comapi.walknavi.b.a().O().b("six_dof_ar_new_guide", false);
        relativeLayout = this.f9862a.u;
        if (relativeLayout != null) {
            relativeLayout2 = this.f9862a.u;
            relativeLayout2.setVisibility(8);
        }
        z = this.f9862a.v;
        if (!z) {
            this.f9862a.b(true);
        }
    }
}
