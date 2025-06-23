package com.baidu.platform.comapi.bikenavi.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.R;
import com.baidu.mapapi.bikenavi.controllers.BNavigatorWrapper;
import com.baidu.mapapi.bikenavi.model.BikeNaviDisplayOption;
import com.baidu.mapapi.bikenavi.model.a;

/* loaded from: classes8.dex */
public class h extends com.baidu.platform.comapi.walknavi.h.c.b {

    /* renamed from: a, reason: collision with root package name */
    private Activity f9566a;
    private com.baidu.platform.comapi.bikenavi.c.b b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private View g;
    private RelativeLayout h;
    private a.c i = null;
    private boolean j = false;

    public h(Context context, com.baidu.platform.comapi.bikenavi.c.b bVar, View view) {
        this.f9566a = (Activity) context;
        this.b = bVar;
        a(view);
        e();
    }

    private void b(View view) {
        if (view != null) {
            this.g = view.findViewById(R.id.gps_weak_layout);
            this.c = (ImageView) view.findViewById(R.id.guidance_icon);
            this.d = (TextView) view.findViewById(R.id.guidance_tv);
            this.e = (TextView) view.findViewById(R.id.tv_gps_weak);
            this.f = (TextView) view.findViewById(R.id.tv_gps_hint);
        }
    }

    private void e() {
        BNavigatorWrapper.getWNavigator();
        BikeNaviDisplayOption q = com.baidu.platform.comapi.walknavi.b.a().q();
        if (q != null && q.getBikeNaviTypeface() != null) {
            TextView textView = this.d;
            if (textView != null) {
                textView.setTypeface(q.getBikeNaviTypeface());
            }
            TextView textView2 = this.e;
            if (textView2 != null) {
                textView2.setTypeface(q.getBikeNaviTypeface());
            }
            TextView textView3 = this.f;
            if (textView3 != null) {
                textView3.setTypeface(q.getBikeNaviTypeface());
            }
        }
    }

    public void c() {
        BNavigatorWrapper.getWNavigator();
        BikeNaviDisplayOption q = com.baidu.platform.comapi.walknavi.b.a().q();
        if ((q == null || q.getShowTopLayout()) && this.g.getVisibility() == 8) {
            this.g.setVisibility(0);
            Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(this.f9566a, R.anim.wsdk_anim_comeout);
            this.g.setAnimation(c);
            c.setAnimationListener(new i(this));
            c.start();
        }
    }

    public void d() {
        if (this.g.getVisibility() == 0) {
            Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(this.f9566a, R.anim.wsdk_anim_fadeaway);
            c.setAnimationListener(new j(this));
            this.g.startAnimation(c);
        }
    }

    private void a(View view) {
        this.h = (RelativeLayout) view.findViewById(R.id.rl_bike_top_guide);
        BNavigatorWrapper.getWNavigator();
        BikeNaviDisplayOption q = com.baidu.platform.comapi.walknavi.b.a().q();
        if (q != null && !q.getShowTopLayout()) {
            this.h.setVisibility(8);
        }
        if (q != null && q.isUseCustomTopGuideLayout()) {
            if (!a(q)) {
                b(view);
            }
            this.g.setVisibility(8);
            return;
        }
        b(view);
    }

    private boolean a(BikeNaviDisplayOption bikeNaviDisplayOption) {
        if (bikeNaviDisplayOption == null) {
            Log.e("CustomWNaviView", "Load BikeTopGuide layout failed,BikeNaviDisplayOption is null.");
            return false;
        }
        int topGuideLayout = bikeNaviDisplayOption.getTopGuideLayout();
        if (topGuideLayout == 0) {
            Log.e("CustomWNaviView", "BikeTopGuide layout resource is empty.");
            return false;
        }
        if (this.h == null) {
            Log.e("CustomWNaviView", "BikeTopGuide layout add failed.");
            return false;
        }
        View inflate = LayoutInflater.from(this.f9566a).inflate(topGuideLayout, (ViewGroup) this.h, false);
        if (inflate == null) {
            Log.e("CustomWNaviView", "Load BikeTopGuide layout failed,please checking layout.");
            return false;
        }
        if (!com.baidu.platform.comapi.walknavi.h.d.b.a().a(this.f9566a, 4, topGuideLayout, this)) {
            Log.e("CustomWNaviView", "Parser BikeTopGuide layout failed,please checking layout.");
            return false;
        }
        a.c cVar = this.i;
        if (cVar == null) {
            Log.e("CustomWNaviView", "Parser BikeTopGuide layout failed,missing other keywords like TAG attribute or ID attribute.");
            return false;
        }
        if (!TextUtils.isEmpty(cVar.b()) && !TextUtils.isEmpty(this.i.a()) && !TextUtils.isEmpty(this.i.c()) && !TextUtils.isEmpty(this.i.d()) && !TextUtils.isEmpty(this.i.e())) {
            try {
                this.g = inflate.findViewById(Integer.parseInt(this.i.b().replace("@", "")));
                this.c = (ImageView) inflate.findViewById(Integer.parseInt(this.i.a().replace("@", "")));
                this.d = (TextView) inflate.findViewById(Integer.parseInt(this.i.c().replace("@", "")));
                this.e = (TextView) inflate.findViewById(Integer.parseInt(this.i.d().replace("@", "")));
                TextView textView = (TextView) inflate.findViewById(Integer.parseInt(this.i.e().replace("@", "")));
                this.f = textView;
                if (this.d != null && this.c != null && this.g != null && this.e != null && textView != null) {
                    this.h.removeAllViews();
                    this.h.addView(inflate);
                    this.j = true;
                    return true;
                }
                Log.e("CustomWNaviView", "BikeTopGuide layout control initialize failed,Missing other keywords like TAG attribute or ID attribute.");
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("CustomWNaviView", "BikeTopGuide layout control type error.");
                return false;
            }
        }
        Log.e("CustomWNaviView", "BikeTopGuide layout missing other keywords like TAG attribute or ID attribute.");
        return false;
    }

    public void a(int i, String str) {
        if (i != R.drawable.bn_start_blue && i != R.drawable.bn_gps_blue) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        if (com.baidu.platform.comapi.bikenavi.a.a.f9539a) {
            this.c.setImageDrawable(com.baidu.platform.comapi.wnplatform.p.a.a.b().getDrawable(i));
        } else {
            this.c.setImageResource(i);
        }
        this.d.setText(str);
    }

    public void a(a.c cVar) {
        this.i = cVar;
    }
}
