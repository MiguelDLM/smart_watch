package com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.navimageloader.b;

/* loaded from: classes7.dex */
public class CarPassWeatherView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private Context f7536a;
    private LinearLayout b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private FrameLayout f;
    private ImageView g;

    public CarPassWeatherView(Context context) {
        super(context);
        this.f7536a = context;
        a();
    }

    private void a() {
        LayoutInflater layoutInflater = (LayoutInflater) this.f7536a.getSystemService("layout_inflater");
        if (layoutInflater != null) {
            layoutInflater.inflate(R.layout.nsdk_layout_rr_navi_pass_weather_info, this);
        }
        this.b = (LinearLayout) findViewById(R.id.big_weather_container);
        this.c = (ImageView) findViewById(R.id.big_weather_icon);
        this.d = (TextView) findViewById(R.id.city_name);
        this.e = (TextView) findViewById(R.id.weather_describe);
        this.f = (FrameLayout) findViewById(R.id.small_weather_container);
        this.g = (ImageView) findViewById(R.id.small_weather_icon);
    }

    private int b(boolean z) {
        FrameLayout frameLayout;
        LinearLayout linearLayout;
        if (z && (linearLayout = this.b) != null) {
            return linearLayout.getMeasuredHeight();
        }
        if (!z && (frameLayout = this.f) != null) {
            return frameLayout.getMeasuredHeight();
        }
        return 0;
    }

    private int c(boolean z) {
        FrameLayout frameLayout;
        LinearLayout linearLayout;
        if (z && (linearLayout = this.b) != null) {
            return linearLayout.getMeasuredWidth();
        }
        if (!z && (frameLayout = this.f) != null) {
            return frameLayout.getMeasuredWidth();
        }
        return 0;
    }

    public CarPassWeatherView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7536a = context;
        a();
    }

    public CarPassWeatherView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7536a = context;
        a();
    }

    public void a(com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a aVar, boolean z, int i) {
        if (aVar == null || !com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.e.a(aVar.g)) {
            return;
        }
        if (z) {
            this.b.setVisibility(0);
            this.f.setVisibility(8);
            a(this.c, aVar.i, com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.e.a(aVar.g, true));
            this.d.setText(aVar.f7513a);
            this.e.setText("途经时" + aVar.g + " " + aVar.h);
            return;
        }
        this.b.setVisibility(8);
        this.f.setVisibility(0);
        if (i % 2 != 0) {
            this.f.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_rr_pass_weather_small_right_bubble));
        } else {
            this.f.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_rr_pass_weather_small_left_bubble));
        }
        a(this.g, aVar.i, com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.e.a(aVar.g, true));
    }

    public Bundle a(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("l", 0);
        bundle.putInt("r", c(z));
        bundle.putInt("t", 0);
        bundle.putInt("b", b(z));
        return bundle;
    }

    private void a(ImageView imageView, String str, int i) {
        com.baidu.navisdk.util.navimageloader.c.d().a(str, imageView, new b.C0502b().a(i).b(i).a());
    }
}
