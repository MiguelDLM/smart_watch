package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class h0 extends com.baidu.navisdk.ui.routeguide.widget.d {
    private ViewGroup i;
    private View j;
    private TextView k;
    private TextView l;
    private TextView m;
    private View n;
    private View o;
    private Handler p;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h0.this.p0();
            h0.this.p = null;
            com.baidu.navisdk.module.pronavi.model.j.b().b = false;
            com.baidu.navisdk.module.offscreen.a.m().h();
            com.baidu.navisdk.ui.routeguide.control.x.b().a(1, false);
            com.baidu.navisdk.module.offscreen.a.m().c = true;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h0.this.p0();
            h0.this.p = null;
            com.baidu.navisdk.module.offscreen.a.i = false;
            com.baidu.navisdk.module.offscreen.a.a("offScreen", "click canele");
            com.baidu.navisdk.module.offscreen.a.n();
            com.baidu.navisdk.module.pronavi.model.j.b().b = false;
            com.baidu.navisdk.ui.routeguide.control.x.b().a(1, false);
        }
    }

    /* loaded from: classes8.dex */
    public class c extends com.baidu.navisdk.util.worker.loop.a {
        public c(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        com.baidu.navisdk.module.pronavi.model.j.b().b = false;
                        return;
                    }
                    return;
                } else {
                    if (com.baidu.navisdk.module.offscreen.a.h) {
                        com.baidu.navisdk.module.offscreen.a.a("offScreen", "MSG_STOP_COUNT, return not legal");
                        return;
                    }
                    com.baidu.navisdk.module.offscreen.a.i = false;
                    com.baidu.navisdk.module.offscreen.a.a("offScreen", "MSG_STOP_COUNT");
                    com.baidu.navisdk.module.pronavi.model.j.b().b = false;
                    com.baidu.navisdk.ui.routeguide.control.x.b().a(1, false);
                    return;
                }
            }
            if (com.baidu.navisdk.module.pronavi.model.j.b().c <= 0) {
                if (h0.this.p != null) {
                    h0.this.p.sendEmptyMessage(2);
                }
            } else if (h0.this.p != null) {
                h0.this.p.sendEmptyMessageDelayed(1, 1000L);
                com.baidu.navisdk.module.pronavi.model.j.b().c--;
            }
        }
    }

    public h0(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.p = null;
        s0();
        a(com.baidu.navisdk.ui.util.b.b());
        r0();
        q0();
    }

    private void o0() {
        Handler handler = this.p;
        if (handler != null) {
            handler.removeMessages(1);
            this.p.removeMessages(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        Handler handler = this.p;
        if (handler != null) {
            handler.removeMessages(2);
            this.p.removeMessages(1);
        }
    }

    private void q0() {
        this.p = null;
        this.p = new c("MMOSV");
    }

    private void r0() {
        TextView textView = this.l;
        if (textView != null) {
            textView.setOnClickListener(new a());
        }
        TextView textView2 = this.m;
        if (textView2 != null) {
            textView2.setOnClickListener(new b());
        }
    }

    private void s0() {
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.bnav_rg_off_screen_container);
        this.i = viewGroup2;
        if (viewGroup2 == null) {
            return;
        }
        viewGroup2.removeAllViews();
        View inflate = JarUtils.inflate(this.f9165a, R.layout.nsdk_layout_rg_off_screen_view, null);
        this.j = inflate;
        if (this.i != null && inflate != null) {
            this.i.addView(this.j, new FrameLayout.LayoutParams(-1, -1));
            this.n = this.b.findViewById(R.id.ll_off_screen_item);
            this.o = this.b.findViewById(R.id.bnav_rg_common_divider_off_screen);
            this.k = (TextView) this.b.findViewById(R.id.nsdk_rg_off_screen_tip_tx);
            this.l = (TextView) this.b.findViewById(R.id.nsdk_rg_off_screen_enter_tx);
            this.m = (TextView) this.b.findViewById(R.id.nsdk_rg_off_screen_cancel);
        }
    }

    private void t0() {
        if (com.baidu.navisdk.module.pronavi.model.j.b().f7471a) {
            com.baidu.navisdk.module.pronavi.model.j.b().f7471a = false;
            if (com.baidu.navisdk.module.pronavi.model.j.b().b) {
                return;
            }
            o0();
            com.baidu.navisdk.module.pronavi.model.j.b().c = 5;
            q0();
            com.baidu.navisdk.module.offscreen.a.a("offScreen", "start count down");
            com.baidu.navisdk.module.pronavi.model.j.b().b = true;
            this.p.sendEmptyMessage(1);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        if (this.j != null) {
            this.i.setVisibility(8);
            this.j.setVisibility(8);
        }
    }

    public void n0() {
        o0();
        this.p = null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (!com.baidu.navisdk.module.pronavi.model.j.b().f7471a) {
            return false;
        }
        com.baidu.navisdk.module.offscreen.a.a("offScreen", " rgmmoffscreen view show");
        super.y();
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        View view = this.j;
        if (view != null) {
            view.setVisibility(0);
        }
        t0();
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        View view = this.n;
        if (view != null) {
            view.setBackgroundColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_bg_d));
        }
        View view2 = this.o;
        if (view2 != null) {
            view2.setBackgroundColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_bg_b));
        }
        TextView textView = this.k;
        if (textView != null) {
            textView.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_text_a));
        }
        TextView textView2 = this.l;
        if (textView2 != null) {
            textView2.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_text_e));
            this.l.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_common_button_selector));
        }
        TextView textView3 = this.m;
        if (textView3 != null) {
            textView3.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_text_a));
            this.m.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_lineframe_button_selector));
        }
    }
}
