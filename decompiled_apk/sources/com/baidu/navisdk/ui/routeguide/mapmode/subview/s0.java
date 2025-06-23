package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class s0 extends com.baidu.navisdk.ui.routeguide.widget.d {
    private static String m = "com.baidu.navisdk.ui.routeguide.mapmode.subview.s0";
    private ViewGroup i;
    private View j;
    private TextView k;
    boolean l;

    /* loaded from: classes8.dex */
    public class a implements View.OnTouchListener {
        public a(s0 s0Var) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public s0(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = false;
        com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            this.l = k.F();
        }
        o0();
        a(com.baidu.navisdk.ui.util.b.b());
        n0();
        y(this.l);
    }

    private void n0() {
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.setOnTouchListener(new a(this));
        }
    }

    private void o0() {
        ViewGroup viewGroup;
        if (this.b == null || (viewGroup = this.i) == null) {
            return;
        }
        viewGroup.removeAllViews();
        View inflate = JarUtils.inflate(this.f9165a, R.layout.nsdk_layout_rg_mapmode_common_card, null);
        this.j = inflate;
        this.k = (TextView) inflate.findViewById(R.id.common_card_text);
        if (this.i != null && this.j != null) {
            this.i.addView(this.j, new FrameLayout.LayoutParams(-1, -2));
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        LogUtil.e(m, "hide()");
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (this.l) {
            return false;
        }
        super.y();
        LogUtil.e(m, "show()");
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        TextView textView = this.k;
        if (textView == null) {
            return true;
        }
        textView.setText("卫星信号弱，请谨慎驾驶");
        this.k.setTextColor(-1);
        return true;
    }

    public void y(boolean z) {
        this.l = z;
        if (z) {
            c();
        }
    }
}
