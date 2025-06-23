package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.BNImageView;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class j1 extends com.baidu.navisdk.ui.routeguide.widget.d {
    private BNImageView i;
    private BNImageView j;
    private TextView k;
    private View l;
    private View m;
    private View n;

    /* loaded from: classes8.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && ((com.baidu.navisdk.ui.routeguide.widget.d) j1.this).c != null) {
                ((com.baidu.navisdk.ui.routeguide.widget.d) j1.this).c.m();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b(j1 j1Var) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && ((com.baidu.navisdk.ui.routeguide.widget.d) j1.this).c != null) {
                ((com.baidu.navisdk.ui.routeguide.widget.d) j1.this).c.d(com.baidu.navisdk.ui.routeguide.model.g.h().d());
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public d(j1 j1Var) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int c = com.baidu.navisdk.ui.routeguide.model.g.h().c();
            if (c == 2) {
                ((com.baidu.navisdk.ui.routeguide.widget.d) j1.this).c.a(view, 1);
            } else if (c == 1) {
                ((com.baidu.navisdk.ui.routeguide.widget.d) j1.this).c.a(view, 0);
            } else if (c == 0) {
                ((com.baidu.navisdk.ui.routeguide.widget.d) j1.this).c.a(view, 2);
            }
        }
    }

    public j1(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar, boolean z) {
        super(context, viewGroup, aVar);
        this.l = null;
        this.m = null;
        this.g = z;
        o0();
    }

    @Nullable
    private Drawable n0() {
        if (j0()) {
            return t(R.drawable.nsdk_rg_selector_common_control_btn_bg);
        }
        if (com.baidu.navisdk.module.newguide.a.e().d()) {
            return t(R.drawable.bnav_rg_setting_page_bg);
        }
        return null;
    }

    private void o0() {
        if (this.i != null) {
            return;
        }
        this.i = (BNImageView) this.b.findViewById(R.id.bnav_rg_cp_anolog_rl);
        this.j = (BNImageView) this.b.findViewById(R.id.bnav_rg_cp_anolog_quit);
        if (j0()) {
            this.k = (TextView) this.b.findViewById(R.id.bnav_rg_cp_anolog_change_speed);
        } else {
            this.k = (TextView) this.b.findViewById(R.id.bnav_rg_cp_anolog_change_speed_land);
        }
        this.l = this.b.findViewById(R.id.nsdk_rg_left_bucket);
        this.m = this.b.findViewById(R.id.nsdk_rg_right_bucket);
        this.n = this.b.findViewById(R.id.bnav_rg_control_panel);
        a(com.baidu.navisdk.ui.util.b.b());
        p0();
        y(!com.baidu.navisdk.ui.routeguide.model.g.h().d());
    }

    private void p0() {
        BNImageView bNImageView = this.j;
        if (bNImageView != null) {
            bNImageView.setOnTouchListener(new a());
            this.j.setOnClickListener(new b(this));
        }
        BNImageView bNImageView2 = this.i;
        if (bNImageView2 != null) {
            bNImageView2.setOnTouchListener(new c());
            this.i.setOnClickListener(new d(this));
        }
        TextView textView = this.k;
        if (textView != null) {
            textView.setOnClickListener(new e());
        }
    }

    private void z(boolean z) {
        int i;
        int i2;
        BNImageView bNImageView = this.i;
        int i3 = 8;
        if (bNImageView != null) {
            if (z && BNSettingManager.isAnalogSwitchButtonVisible()) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            bNImageView.setVisibility(i2);
        }
        BNImageView bNImageView2 = this.j;
        if (bNImageView2 != null) {
            if (z && BNSettingManager.isAnalogQuitButtonVisible()) {
                i = 0;
            } else {
                i = 8;
            }
            bNImageView2.setVisibility(i);
        }
        TextView textView = this.k;
        if (textView != null) {
            if (z && BNSettingManager.isAnalogSpeedButtonVisible()) {
                i3 = 0;
            }
            textView.setVisibility(i3);
            if (z) {
                this.c.a(this.k, com.baidu.navisdk.ui.routeguide.model.g.h().c());
            }
        }
        if (z) {
            a(this.n);
            a(this.l);
            a(this.m);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (this.g) {
            return false;
        }
        z(true);
        return super.y();
    }

    private void a(View view) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_anolog_navi_bottom_margin);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (marginLayoutParams.bottomMargin != dimensionPixelOffset) {
                    marginLayoutParams.bottomMargin = dimensionPixelOffset;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        z(false);
        super.c();
    }

    public void y(boolean z) {
        BNImageView bNImageView = this.i;
        if (bNImageView != null) {
            if (z) {
                bNImageView.setImageDrawable(com.baidu.navisdk.ui.util.b.g(R.drawable.nsdk_drawable_anolog_play));
            } else {
                bNImageView.setImageDrawable(com.baidu.navisdk.ui.util.b.g(R.drawable.nsdk_drawable_anolog_pause));
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        this.i = null;
        if (com.baidu.navisdk.util.common.x.s()) {
            o0();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        if (this.i != null) {
            if (com.baidu.navisdk.ui.routeguide.model.g.h().d()) {
                this.i.setImageDrawable(t(R.drawable.nsdk_drawable_anolog_pause));
            } else {
                this.i.setImageDrawable(t(R.drawable.nsdk_drawable_anolog_play));
            }
            this.i.setBackground(t(R.drawable.nsdk_rg_selector_common_control_btn_bg));
        }
        BNImageView bNImageView = this.j;
        if (bNImageView != null) {
            bNImageView.setBackground(t(R.drawable.nsdk_rg_selector_common_control_btn_bg));
            this.j.setImageDrawable(t(R.drawable.nsdk_drawable_rg_ic_quit));
        }
        TextView textView = this.k;
        if (textView != null) {
            textView.setBackground(n0());
        }
    }
}
