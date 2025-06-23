package com.baidu.platform.comapi.walknavi.widget.a;

import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class am implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ z f9856a;

    public am(z zVar) {
        this.f9856a = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        if (this.f9856a.d != null) {
            relativeLayout = this.f9856a.w;
            relativeLayout.clearAnimation();
            relativeLayout2 = this.f9856a.w;
            relativeLayout2.setVisibility(8);
        }
    }
}
