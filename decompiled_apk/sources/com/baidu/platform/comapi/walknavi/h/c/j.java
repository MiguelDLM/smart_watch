package com.baidu.platform.comapi.walknavi.h.c;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class j implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f9782a;

    public j(c cVar) {
        this.f9782a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        Context context;
        RelativeLayout relativeLayout2;
        if (com.baidu.platform.comapi.walknavi.b.a().Q() == 4) {
            this.f9782a.c.setChecked(false);
        } else if (com.baidu.platform.comapi.walknavi.b.a().O().a("WALKNAVI_VOICE_ON_OFF", true)) {
            this.f9782a.c.setChecked(true);
        } else {
            this.f9782a.c.setChecked(false);
        }
        if (com.baidu.platform.comapi.walknavi.b.a().O().a("WALKNAVI_STREET_POI_ON_OFF", true)) {
            this.f9782a.d.setChecked(true);
        } else {
            this.f9782a.d.setChecked(false);
        }
        if (com.baidu.platform.comapi.walknavi.b.a().O().a("WALKNAVI_THREED_MAP_ON_OFF", true)) {
            this.f9782a.e.setChecked(true);
        } else {
            this.f9782a.e.setChecked(false);
        }
        try {
            context = this.f9782a.l;
            Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(context, R.anim.wsdk_anim_rg_down_in);
            relativeLayout2 = this.f9782a.J;
            relativeLayout2.setAnimation(c);
        } catch (Exception unused) {
        }
        relativeLayout = this.f9782a.J;
        relativeLayout.setVisibility(0);
    }
}
