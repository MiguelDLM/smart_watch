package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class l0 extends com.baidu.navisdk.ui.routeguide.widget.d {
    private static String m = "com.baidu.navisdk.ui.routeguide.mapmode.subview.l0";
    private final String[] i;
    private ViewGroup j;
    private View k;
    private TextView l;

    /* loaded from: classes8.dex */
    public class a implements View.OnTouchListener {
        public a(l0 l0Var) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public l0(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.i = new String[]{"躲避拥堵/", "高速优先/", "不走高速/", "少收费/"};
        this.j = null;
        this.k = null;
        this.l = null;
        p0();
        a(com.baidu.navisdk.ui.util.b.b());
        o0();
    }

    private String n0() {
        StringBuilder sb = new StringBuilder("正在使用");
        try {
            int a2 = com.baidu.navisdk.ui.routeguide.b.V().d().a();
            if (q0() && (a2 & 16) != 0) {
                sb.append(this.i[0]);
            }
            if ((a2 & 2) != 0) {
                sb.append(this.i[1]);
            }
            if ((a2 & 4) != 0) {
                sb.append(this.i[2]);
            }
            if ((a2 & 8) != 0) {
                sb.append(this.i[3]);
            }
            if (sb.toString().equals("正在使用")) {
                sb.append("推荐");
            } else if (sb.toString().length() >= 1) {
                sb = new StringBuilder(sb.substring(0, sb.toString().length() - 1));
            }
            sb.append("方案");
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    private void o0() {
        ViewGroup viewGroup = this.j;
        if (viewGroup != null) {
            viewGroup.setOnTouchListener(new a(this));
        }
    }

    private void p0() {
        ViewGroup viewGroup;
        if (this.b == null || (viewGroup = this.j) == null) {
            return;
        }
        viewGroup.removeAllViews();
        View inflate = JarUtils.inflate(this.f9165a, R.layout.nsdk_layout_rg_mapmode_common_card, null);
        this.k = inflate;
        if (inflate == null) {
            return;
        }
        this.l = (TextView) inflate.findViewById(R.id.common_card_text);
        this.j.addView(this.k, new FrameLayout.LayoutParams(-1, -2));
    }

    private boolean q0() {
        int e = BNRoutePlaner.getInstance().e();
        if (e == 3 || e == 1) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        if (this.f == i) {
            return;
        }
        super.a(viewGroup, i);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        LogUtil.e(m, "hide()");
        ViewGroup viewGroup = this.j;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        super.y();
        LogUtil.e(m, "show()");
        ViewGroup viewGroup = this.j;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        if (this.l != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(n0());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(-1), 4, r0.length() - 2, 33);
            spannableStringBuilder.setSpan(new RelativeSizeSpan(1.05f), 4, r0.length() - 2, 33);
            this.l.setText(spannableStringBuilder);
            return true;
        }
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
    }
}
