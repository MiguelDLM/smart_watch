package com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class b extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private Context f7538a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private ImageView i;
    private View j;
    private RelativeLayout k;
    private LinearLayout l;

    public b(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.k = null;
        this.l = null;
        this.f7538a = context;
        b();
    }

    private void b() {
        ((LayoutInflater) this.f7538a.getSystemService("layout_inflater")).inflate(R.layout.nsdk_layout_rr_navi_pass_city_info, this);
        this.b = (TextView) findViewById(R.id.pass_city_tx);
        this.d = (TextView) findViewById(R.id.total_dis_tx);
        this.e = (TextView) findViewById(R.id.total_time_tx);
        this.f = (TextView) findViewById(R.id.climate_tx);
        this.k = (RelativeLayout) findViewById(R.id.detail_pass_city_rl);
        this.l = (LinearLayout) findViewById(R.id.short_pass_rl);
        this.h = (TextView) findViewById(R.id.line_tx);
        this.c = (TextView) findViewById(R.id.short_pass_city_tx);
        this.j = (ImageView) findViewById(R.id.climate_img);
        this.i = (ImageView) findViewById(R.id.detail_climate_img);
        this.g = (TextView) findViewById(R.id.temprature_tx);
    }

    private void f(String str) {
        TextView textView = this.c;
        if (textView != null && str != null) {
            textView.setText(str);
        }
    }

    public void a(String str) {
        TextView textView = this.f;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    public void c(String str) {
        TextView textView = this.b;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    public void d(String str) {
        TextView textView = this.e;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    public void e(String str) {
        TextView textView = this.g;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    private int c(boolean z) {
        LinearLayout linearLayout;
        RelativeLayout relativeLayout;
        if (z && (relativeLayout = this.k) != null) {
            return relativeLayout.getMeasuredHeight();
        }
        if (z || (linearLayout = this.l) == null) {
            return 0;
        }
        return linearLayout.getMeasuredHeight();
    }

    private int d(boolean z) {
        LinearLayout linearLayout;
        RelativeLayout relativeLayout;
        if (z && (relativeLayout = this.k) != null) {
            return relativeLayout.getMeasuredWidth();
        }
        if (z || (linearLayout = this.l) == null) {
            return 0;
        }
        return linearLayout.getMeasuredWidth();
    }

    private void e(boolean z) {
        TextView textView = this.g;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
        TextView textView2 = this.f;
        if (textView2 != null) {
            textView2.setVisibility(z ? 0 : 8);
        }
        TextView textView3 = this.h;
        if (textView3 != null) {
            textView3.setVisibility(z ? 0 : 8);
        }
    }

    public void a() {
        TextView textView = this.h;
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = -2;
            this.h.setLayoutParams(layoutParams);
        }
    }

    public void a(boolean z, com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a aVar, int i) {
        if (aVar == null) {
            return;
        }
        if (z) {
            c(aVar.f7513a);
            b(com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.b(aVar.c));
            d(com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.d(aVar.d));
            a(aVar.g);
            e(aVar.h);
            if (i % 2 == 0) {
                this.k.setBackgroundDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_rr_pass_road_right_big));
            } else {
                this.k.setBackgroundDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_rr_pass_road_left_big));
            }
        } else {
            f(aVar.f7513a);
            if (i % 2 == 0) {
                this.l.setBackgroundDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_rr_pass_road_right_small));
            } else {
                this.l.setBackgroundDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_rr_pass_road_left_small));
            }
        }
        e(false);
        b(z);
    }

    public void b(String str) {
        TextView textView = this.d;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    public void b(boolean z) {
        RelativeLayout relativeLayout = this.k;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(z ? 0 : 8);
        }
        LinearLayout linearLayout = this.l;
        if (linearLayout != null) {
            linearLayout.setVisibility(z ? 8 : 0);
        }
    }

    public Bundle a(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("l", 0);
        bundle.putInt("r", d(z));
        bundle.putInt("t", 0);
        bundle.putInt("b", c(z));
        return bundle;
    }
}
