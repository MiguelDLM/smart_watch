package com.baidu.platform.comapi.walknavi.widget;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.R;
import com.baidu.mapapi.walknavi.model.a;

/* loaded from: classes8.dex */
public class e extends com.baidu.platform.comapi.walknavi.h.c.b {

    /* renamed from: a, reason: collision with root package name */
    private Activity f9887a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private a.c e;

    public void a(int i, String str) {
        if (i == R.drawable.wn_gps_blue) {
            this.c.setVisibility(8);
            this.d.setVisibility(4);
        } else {
            this.c.setVisibility(0);
        }
        if (com.baidu.platform.comapi.bikenavi.a.a.f9539a) {
            this.b.setImageDrawable(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.f9887a, i));
        } else {
            this.b.setImageResource(i);
        }
        if ((i == R.drawable.wn_start_blue || i == R.drawable.wn_start_white) && "步行导航开始".equals(str)) {
            this.c.setText("步行导航开始");
        } else {
            this.c.setText(str);
        }
    }

    public void a(a.c cVar) {
        this.e = cVar;
    }
}
