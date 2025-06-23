package com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class c extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private Context f7539a;
    private C0292c b;
    private d c;

    /* loaded from: classes7.dex */
    public abstract class b {

        /* renamed from: a, reason: collision with root package name */
        private View f7540a;

        private b() {
        }

        public void a(View view) {
            this.f7540a = view;
        }

        public abstract void a(String str);

        public int b() {
            return this.f7540a.getMeasuredWidth();
        }

        public void c() {
            this.f7540a.setVisibility(8);
        }

        public void d() {
            this.f7540a.setVisibility(0);
        }

        public void a(Drawable drawable) {
            this.f7540a.setBackgroundDrawable(drawable);
        }

        public int a() {
            return this.f7540a.getMeasuredHeight();
        }

        public void a(View view, boolean z) {
            if (z) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    public c(Context context) {
        super(context);
        this.f7539a = context;
        a();
    }

    private b e(boolean z) {
        if (z) {
            return this.b;
        }
        return this.c;
    }

    public void a(boolean z, com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a aVar, int i) {
        if (aVar == null) {
            return;
        }
        b e = e(z);
        e.a(a(i, z));
        e.a(a(z, aVar));
        boolean z2 = aVar.e;
        if (z) {
            this.b.b(com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.d(aVar.c));
            this.b.c(com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(aVar.b));
        } else if (z2) {
            this.c.b("");
        } else {
            this.c.b("国道");
        }
        d(z);
    }

    public Bundle b(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("l", 0);
        bundle.putInt("r", c(z));
        bundle.putInt("t", 0);
        bundle.putInt("b", a(z));
        return bundle;
    }

    public int c(boolean z) {
        b e = e(z);
        if (e != null) {
            return e.b();
        }
        return 0;
    }

    public void d(boolean z) {
        C0292c c0292c = this.b;
        if (c0292c != null && this.c != null) {
            if (z) {
                c0292c.d();
                this.c.c();
            } else {
                c0292c.c();
                this.c.d();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends b {
        private TextView c;
        private TextView d;

        private d() {
            super();
        }

        @Override // com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.c.b
        public void a(View view) {
            super.a(view);
            this.c = (TextView) view.findViewById(R.id.guodao_label);
            this.d = (TextView) view.findViewById(R.id.guodao_tx);
        }

        public void b(String str) {
            a(this.c, TextUtils.isEmpty(str));
            this.c.setText(str);
        }

        @Override // com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.c.b
        public void a(String str) {
            this.d.setText(str);
        }
    }

    /* renamed from: com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0292c extends b {
        private TextView c;
        private TextView d;
        private TextView e;

        private C0292c() {
            super();
        }

        @Override // com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.c.b
        public void a(View view) {
            super.a(view);
            this.d = (TextView) view.findViewById(R.id.pass_route_tx);
            this.c = (TextView) view.findViewById(R.id.pass_route_num_tx);
            this.e = (TextView) view.findViewById(R.id.pass_speed_tx);
        }

        public void b(String str) {
            a(this.e, TextUtils.isEmpty(str));
            this.e.setText("限速 " + str + "km/h");
        }

        public void c(String str) {
            a(this.c, TextUtils.isEmpty(str));
            this.c.setText(str + "车道");
        }

        @Override // com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.c.b
        public void a(String str) {
            this.d.setText(str);
        }
    }

    private Drawable a(int i, boolean z) {
        if (i % 2 == 0) {
            if (z) {
                return JarUtils.getResources().getDrawable(R.drawable.nsdk_rr_pass_road_right_big);
            }
            return JarUtils.getResources().getDrawable(R.drawable.nsdk_rr_pass_road_right_small);
        }
        if (z) {
            return JarUtils.getResources().getDrawable(R.drawable.nsdk_rr_pass_road_left_big);
        }
        return JarUtils.getResources().getDrawable(R.drawable.nsdk_rr_pass_road_left_small);
    }

    private String a(boolean z, com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a aVar) {
        if (aVar.e) {
            return com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.b(aVar.f7519a, z);
        }
        return com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(aVar.f7519a, z);
    }

    private void a() {
        ((LayoutInflater) this.f7539a.getSystemService("layout_inflater")).inflate(R.layout.nsdk_layout_rr_navi_pass_route_info, this);
        View findViewById = findViewById(R.id.pass_route_detail_rl);
        C0292c c0292c = new C0292c();
        this.b = c0292c;
        c0292c.a(findViewById);
        View findViewById2 = findViewById(R.id.navi_guodao_rl);
        d dVar = new d();
        this.c = dVar;
        dVar.a(findViewById2);
    }

    public int a(boolean z) {
        b e = e(z);
        if (e != null) {
            return e.a();
        }
        return 0;
    }
}
