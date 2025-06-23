package com.baidu.platform.comapi.walknavi.h.c;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.baidu.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class z implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f9798a;

    public z(c cVar) {
        this.f9798a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        RelativeLayout relativeLayout3;
        context = this.f9798a.l;
        if (context != null) {
            context2 = this.f9798a.l;
            Animation loadAnimation = AnimationUtils.loadAnimation(context2, R.anim.wsdk_anim_rg_down_out);
            relativeLayout = this.f9798a.J;
            relativeLayout.setAnimation(loadAnimation);
            relativeLayout2 = this.f9798a.J;
            relativeLayout2.setVisibility(8);
            relativeLayout3 = this.f9798a.E;
            relativeLayout3.setVisibility(8);
        }
    }
}
