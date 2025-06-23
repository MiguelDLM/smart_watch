package com.baidu.platform.comapi.walknavi.widget.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class aa implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ z f9844a;

    public aa(z zVar) {
        this.f9844a = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ViewGroup viewGroup;
        RelativeLayout relativeLayout3;
        ViewGroup viewGroup2;
        RelativeLayout relativeLayout4;
        Context context;
        RelativeLayout relativeLayout5;
        ViewGroup viewGroup3;
        RelativeLayout relativeLayout6;
        RelativeLayout relativeLayout7;
        RelativeLayout relativeLayout8;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        relativeLayout = this.f9844a.v;
        if (relativeLayout != null) {
            relativeLayout2 = this.f9844a.v;
            if (relativeLayout2.getParent() != null) {
                viewGroup2 = this.f9844a.e;
                relativeLayout4 = this.f9844a.v;
                viewGroup2.removeView(relativeLayout4);
            }
            viewGroup = this.f9844a.e;
            relativeLayout3 = this.f9844a.v;
            viewGroup.addView(relativeLayout3);
            return;
        }
        z zVar = this.f9844a;
        context = zVar.c;
        zVar.v = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.wsdk_layout_indoor_poi_panel, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout5 = this.f9844a.v;
        relativeLayout5.setLayoutParams(layoutParams);
        viewGroup3 = this.f9844a.e;
        relativeLayout6 = this.f9844a.v;
        viewGroup3.addView(relativeLayout6);
        relativeLayout7 = this.f9844a.v;
        relativeLayout7.setOnClickListener(new ab(this));
        relativeLayout8 = this.f9844a.v;
        RelativeLayout relativeLayout9 = (RelativeLayout) relativeLayout8.findViewById(R.id.ar_indoor_poi_skin_switch_panel);
        context2 = this.f9844a.c;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, com.baidu.platform.comapi.wnplatform.p.h.a(context2, 270));
        context3 = this.f9844a.c;
        context4 = this.f9844a.c;
        int c = ((int) (com.baidu.platform.comapi.wnplatform.p.h.c(context3) * 0.5d)) - ((int) (com.baidu.platform.comapi.wnplatform.p.h.a(context4, 270) * 0.5d));
        context5 = this.f9844a.c;
        int a2 = com.baidu.platform.comapi.wnplatform.p.h.a(context5, 7);
        context6 = this.f9844a.c;
        layoutParams2.setMargins(a2, 0, com.baidu.platform.comapi.wnplatform.p.h.a(context6, 7), c);
        layoutParams2.addRule(12);
        relativeLayout9.setLayoutParams(layoutParams2);
    }
}
