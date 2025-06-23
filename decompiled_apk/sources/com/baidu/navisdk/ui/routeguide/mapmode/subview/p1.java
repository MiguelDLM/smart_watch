package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;

/* loaded from: classes8.dex */
public class p1 extends com.baidu.navisdk.ui.routeguide.widget.d {
    private LinearLayout i;
    private LinearLayout j;
    private TextView k;
    private LinearLayout l;
    private TextView m;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {

        /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.p1$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0461a extends com.baidu.navisdk.util.worker.f<String, String> {
            public C0461a(String str, String str2) {
                super(str, str2);
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                p1.this.l.setVisibility(8);
                return null;
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p1.this.l.getVisibility() != 0 && !com.baidu.navisdk.util.common.l0.c(com.baidu.navisdk.module.a.h().a().b0)) {
                if (p1.this.m != null) {
                    p1.this.m.setText(com.baidu.navisdk.module.a.h().a().b0);
                }
                p1.this.l.setVisibility(0);
                com.baidu.navisdk.util.worker.c.a().a(new C0461a("initViews-" + a.class.getSimpleName(), null), new com.baidu.navisdk.util.worker.e(2, 0), 3000L);
            }
        }
    }

    public p1(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        p0();
    }

    private void p0() {
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.bnav_rg_user_right_rl);
        this.i = linearLayout;
        if (linearLayout == null) {
            return;
        }
        this.j = (LinearLayout) this.b.findViewById(R.id.user_cur_milea_ll);
        this.k = (TextView) this.b.findViewById(R.id.user_current_milea_tv);
        this.l = (LinearLayout) this.b.findViewById(R.id.user_right_upgrade_tips_ll);
        this.m = (TextView) this.b.findViewById(R.id.user_right_upgrade_tips_tv);
        LinearLayout linearLayout2 = this.i;
        if (linearLayout2 != null && this.l != null) {
            linearLayout2.setVisibility(8);
            this.l.setVisibility(8);
        }
        this.j.setOnClickListener(new a());
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public void n0() {
        LinearLayout linearLayout = this.l;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public void o0() {
        String currentUUID = JNITrajectoryControl.sInstance.getCurrentUUID();
        if (currentUUID == null) {
            return;
        }
        long trajectoryLength = (JNITrajectoryControl.sInstance.getTrajectoryLength(currentUUID) / 1000) + com.baidu.navisdk.module.a.h().a().a0;
        if (this.k != null) {
            String valueOf = String.valueOf(trajectoryLength);
            if (valueOf.length() < 4) {
                this.k.setTextSize(20.0f);
            } else if (valueOf.length() == 4) {
                this.k.setTextSize(16.0f);
            } else {
                this.k.setTextSize(13.0f);
                valueOf = "9999+";
            }
            this.k.setText(valueOf);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (this.i == null) {
            return false;
        }
        if (com.baidu.navisdk.util.common.z.b(this.f9165a) && com.baidu.navisdk.module.pronavi.a.j != 2 && com.baidu.navisdk.module.a.h().a().Z == 1 && !com.baidu.navisdk.util.common.l0.c(com.baidu.navisdk.module.a.h().a().b0)) {
            o0();
        }
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        p0();
    }
}
