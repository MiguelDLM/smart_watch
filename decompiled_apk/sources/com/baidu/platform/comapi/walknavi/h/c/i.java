package com.baidu.platform.comapi.walknavi.h.c;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class i implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f9781a;

    public i(c cVar) {
        this.f9781a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        context = this.f9781a.l;
        if (context != null) {
            context2 = this.f9781a.l;
            Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(context2, R.anim.wsdk_anim_rg_down_out);
            relativeLayout = this.f9781a.J;
            relativeLayout.setAnimation(c);
            relativeLayout2 = this.f9781a.J;
            relativeLayout2.setVisibility(8);
        }
    }
}
