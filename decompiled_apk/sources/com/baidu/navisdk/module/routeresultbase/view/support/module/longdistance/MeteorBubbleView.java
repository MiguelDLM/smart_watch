package com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance;

import XXO0.oIX0oI;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.h;

/* loaded from: classes7.dex */
public class MeteorBubbleView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private Context f7525a;
    private LinearLayout b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private LinearLayout h;
    private FrameLayout i;
    private ImageView j;
    private boolean k;

    public MeteorBubbleView(@NonNull Context context, boolean z) {
        super(context);
        this.f7525a = context;
        this.k = z;
        a();
    }

    private void a() {
        LayoutInflater layoutInflater = (LayoutInflater) this.f7525a.getSystemService("layout_inflater");
        if (layoutInflater != null) {
            if (this.k) {
                layoutInflater.inflate(R.layout.nsdk_layout_route_guide_pass_meteor_info, this);
            } else {
                layoutInflater.inflate(R.layout.nsdk_layout_rr_navi_pass_meteor_info, this);
            }
        }
        this.b = (LinearLayout) findViewById(R.id.big_weather_container);
        this.c = (ImageView) findViewById(R.id.big_weather_icon);
        this.d = (TextView) findViewById(R.id.city_name);
        this.e = (TextView) findViewById(R.id.temp);
        this.f = (TextView) findViewById(R.id.weather_describe);
        this.g = (TextView) findViewById(R.id.pavement_describe);
        this.h = (LinearLayout) findViewById(R.id.pavement_info);
        this.i = (FrameLayout) findViewById(R.id.small_weather_container);
        this.j = (ImageView) findViewById(R.id.small_weather_icon);
    }

    private int b(boolean z) {
        FrameLayout frameLayout;
        LinearLayout linearLayout;
        if (z && (linearLayout = this.b) != null) {
            return linearLayout.getMeasuredHeight();
        }
        if (!z && (frameLayout = this.i) != null) {
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
        if (!z && (frameLayout = this.i) != null) {
            return frameLayout.getMeasuredWidth();
        }
        return 0;
    }

    public MeteorBubbleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7525a = context;
        a();
    }

    public MeteorBubbleView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7525a = context;
        a();
    }

    public void a(h hVar, boolean z, int i, boolean z2) {
        if (e.b(hVar)) {
            if (z) {
                this.b.setVisibility(0);
                this.i.setVisibility(8);
                e.a(this.c, hVar, z2);
                boolean z3 = hVar.f6927a == 0 || TextUtils.isEmpty(hVar.e.b) || TextUtils.equals(hVar.e.b, "无名路");
                StringBuilder sb = new StringBuilder();
                if (z3) {
                    sb.append(hVar.c.f6929a);
                } else {
                    String str = hVar.c.f6929a;
                    if (str != null && str.length() > 0 && TextUtils.equals("市", str.substring(str.length() - 1))) {
                        str = str.substring(0, str.length() - 1);
                    }
                    sb.append(hVar.e.b);
                    sb.append(oIX0oI.I0Io.f4096II0xO0);
                    sb.append(str);
                    sb.append("段)");
                    if (sb.length() > 12) {
                        sb.delete(11, sb.length());
                        sb.append("...");
                    }
                }
                this.d.setText(sb.toString());
                if (hVar.e()) {
                    this.f.setTextColor(Color.parseColor("#D0021B"));
                    this.g.setTextColor(Color.parseColor("#D0021B"));
                } else {
                    this.f.setTextColor(Color.parseColor("#333333"));
                    this.g.setTextColor(Color.parseColor("#333333"));
                }
                if (!TextUtils.isEmpty(hVar.f.f6931a) && !hVar.f()) {
                    this.f.setText(String.format("途经时%s", hVar.f.f6931a));
                    this.f.setVisibility(0);
                } else {
                    this.f.setVisibility(8);
                }
                if (TextUtils.isEmpty(hVar.e.e) && TextUtils.isEmpty(hVar.e.d)) {
                    this.g.setVisibility(8);
                } else if (!TextUtils.isEmpty(hVar.e.d)) {
                    this.g.setText(hVar.e.d);
                    this.g.setVisibility(0);
                } else if (!TextUtils.isEmpty(hVar.e.e)) {
                    this.g.setText(hVar.e.e);
                    this.g.setVisibility(0);
                } else {
                    TextView textView = this.g;
                    h.c cVar = hVar.e;
                    textView.setText(String.format("%s %s", cVar.d, cVar.e));
                    this.g.setVisibility(0);
                }
                this.e.setText(hVar.f.b);
                return;
            }
            this.b.setVisibility(8);
            this.i.setVisibility(0);
            if (i % 2 == 0) {
                this.i.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_rr_pass_weather_small_right_bubble));
            } else {
                this.i.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_rr_pass_weather_small_left_bubble));
            }
            e.a(this.j, hVar, z2);
        }
    }

    public Bundle a(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("l", 0);
        bundle.putInt("r", c(z));
        bundle.putInt("t", 0);
        bundle.putInt("b", b(z));
        return bundle;
    }
}
