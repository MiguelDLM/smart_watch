package com.baidu.navisdk.pronavi.ui.park.bottom;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.widget.d;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.utils.a;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class c extends d implements View.OnClickListener {
    private ViewGroup i;
    private ViewGroup j;
    private ViewGroup k;
    private ViewGroup l;
    private View m;
    private View n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private FrameLayout s;
    private ImageFilterView t;
    private ImageView u;
    private ImageView v;
    private com.baidu.navisdk.pronavi.ui.park.bottom.b w;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@OOXIXo Animation animation) {
            IIX0o.x0xO0oo(animation, "animation");
            c.this.p0();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@OOXIXo Animation animation) {
            IIX0o.x0xO0oo(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@OOXIXo Animation animation) {
            IIX0o.x0xO0oo(animation, "animation");
        }
    }

    static {
        new a(null);
    }

    public c(@oOoXoXO Context context, @oOoXoXO ViewGroup viewGroup, @oOoXoXO com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        o0();
        a(com.baidu.navisdk.ui.util.b.b());
        n0();
    }

    private final void n0() {
        if (this.k == null) {
            LogUtil.e("RGMMSaveParkView", "initListener return mRouteSearchView is null");
            return;
        }
        ViewGroup viewGroup = this.l;
        IIX0o.ooOOo0oXI(viewGroup);
        viewGroup.setOnClickListener(this);
        View view = this.n;
        IIX0o.ooOOo0oXI(view);
        view.setOnClickListener(this);
        TextView textView = this.o;
        IIX0o.ooOOo0oXI(textView);
        textView.setOnClickListener(this);
        TextView textView2 = this.p;
        IIX0o.ooOOo0oXI(textView2);
        textView2.setOnClickListener(this);
        TextView textView3 = this.q;
        IIX0o.ooOOo0oXI(textView3);
        textView3.setOnClickListener(this);
        TextView textView4 = this.r;
        IIX0o.ooOOo0oXI(textView4);
        textView4.setOnClickListener(this);
        FrameLayout frameLayout = this.s;
        IIX0o.ooOOo0oXI(frameLayout);
        frameLayout.setOnClickListener(this);
        ImageView imageView = this.u;
        IIX0o.ooOOo0oXI(imageView);
        imageView.setOnClickListener(this);
    }

    private final void o0() {
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            return;
        }
        this.i = (ViewGroup) viewGroup.findViewById(R.id.bnav_rg_save_park_panel);
        ViewGroup viewGroup2 = (ViewGroup) this.b.findViewById(R.id.bnav_rg_save_park_container);
        this.j = viewGroup2;
        if (viewGroup2 != null) {
            IIX0o.ooOOo0oXI(viewGroup2);
            viewGroup2.removeAllViews();
        }
        View inflate = JarUtils.inflate(this.f9165a, R.layout.nsdk_layout_rg_mapmode_save_park, null);
        if (inflate != null) {
            this.k = (ViewGroup) inflate;
            if (this.j != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                ViewGroup viewGroup3 = this.k;
                IIX0o.ooOOo0oXI(viewGroup3);
                viewGroup3.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_layout_save_park_panel_background));
                ViewGroup viewGroup4 = this.j;
                IIX0o.ooOOo0oXI(viewGroup4);
                viewGroup4.addView(this.k, layoutParams);
                ViewGroup viewGroup5 = this.k;
                IIX0o.ooOOo0oXI(viewGroup5);
                this.l = (ViewGroup) viewGroup5.findViewById(R.id.save_park_inner_panel);
                ViewGroup viewGroup6 = this.k;
                IIX0o.ooOOo0oXI(viewGroup6);
                this.m = viewGroup6.findViewById(R.id.save_park_top_bg);
                ViewGroup viewGroup7 = this.k;
                IIX0o.ooOOo0oXI(viewGroup7);
                this.n = viewGroup7.findViewById(R.id.save_park_top_container);
                ViewGroup viewGroup8 = this.k;
                IIX0o.ooOOo0oXI(viewGroup8);
                this.o = (TextView) viewGroup8.findViewById(R.id.save_park_location);
                ViewGroup viewGroup9 = this.k;
                IIX0o.ooOOo0oXI(viewGroup9);
                this.p = (TextView) viewGroup9.findViewById(R.id.save_park_time);
                ViewGroup viewGroup10 = this.k;
                IIX0o.ooOOo0oXI(viewGroup10);
                this.s = (FrameLayout) viewGroup10.findViewById(R.id.save_park_icon_container);
                ViewGroup viewGroup11 = this.k;
                IIX0o.ooOOo0oXI(viewGroup11);
                this.t = (ImageFilterView) viewGroup11.findViewById(R.id.save_park_icon);
                ViewGroup viewGroup12 = this.k;
                IIX0o.ooOOo0oXI(viewGroup12);
                this.u = (ImageView) viewGroup12.findViewById(R.id.save_park_delete_icon);
                ViewGroup viewGroup13 = this.k;
                IIX0o.ooOOo0oXI(viewGroup13);
                this.v = (ImageView) viewGroup13.findViewById(R.id.save_park_null_icon);
                ViewGroup viewGroup14 = this.k;
                IIX0o.ooOOo0oXI(viewGroup14);
                this.q = (TextView) viewGroup14.findViewById(R.id.save_park_cancel);
                ViewGroup viewGroup15 = this.k;
                IIX0o.ooOOo0oXI(viewGroup15);
                this.r = (TextView) viewGroup15.findViewById(R.id.save_park_confirm);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0() {
        ViewGroup viewGroup = this.l;
        if (viewGroup != null) {
            IIX0o.ooOOo0oXI(viewGroup);
            viewGroup.setVisibility(8);
        }
        ViewGroup viewGroup2 = this.i;
        if (viewGroup2 != null) {
            IIX0o.ooOOo0oXI(viewGroup2);
            viewGroup2.setVisibility(8);
        }
        ViewGroup viewGroup3 = this.j;
        if (viewGroup3 != null) {
            IIX0o.ooOOo0oXI(viewGroup3);
            viewGroup3.setVisibility(8);
        }
    }

    public final void b(@oOoXoXO ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        o0();
        a(com.baidu.navisdk.ui.util.b.b());
        n0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        com.baidu.navisdk.ui.routeguide.asr.c.n().b(true);
        e0();
        Animation animOut = com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_OUT, 0L, 300L);
        IIX0o.oO(animOut, "animOut");
        animOut.setFillAfter(true);
        animOut.setAnimationListener(new b());
        ViewGroup viewGroup = this.l;
        if (viewGroup != null) {
            IIX0o.ooOOo0oXI(viewGroup);
            viewGroup.startAnimation(animOut);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i0() {
        c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@OOXIXo View v) {
        com.baidu.navisdk.pronavi.ui.park.bottom.b bVar;
        com.baidu.navisdk.pronavi.ui.park.bottom.b bVar2;
        IIX0o.x0xO0oo(v, "v");
        int id = v.getId();
        if (id != R.id.save_park_inner_panel) {
            if (id == R.id.save_park_icon_container) {
                ImageFilterView imageFilterView = this.t;
                if (imageFilterView != null && imageFilterView.getVisibility() == 0) {
                    com.baidu.navisdk.pronavi.ui.park.bottom.b bVar3 = this.w;
                    if (bVar3 != null) {
                        bVar3.d();
                        return;
                    }
                    return;
                }
                ImageView imageView = this.v;
                if (imageView != null && imageView.getVisibility() == 0 && (bVar2 = this.w) != null) {
                    bVar2.c();
                    return;
                }
                return;
            }
            if (id == R.id.save_park_cancel) {
                c();
                com.baidu.navisdk.util.statistic.userop.b.r().a("38.0.24.1476", null, null, null);
                return;
            }
            if (id == R.id.save_park_confirm) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("38.0.21.1475", null, null, null);
                com.baidu.navisdk.pronavi.ui.park.bottom.b bVar4 = this.w;
                if (bVar4 != null) {
                    bVar4.f();
                    return;
                }
                return;
            }
            if (id == R.id.save_park_delete_icon && (bVar = this.w) != null) {
                bVar.e();
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        super.y();
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        TextView textView = this.o;
        if (textView != null) {
            IIX0o.ooOOo0oXI(textView);
            textView.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.bnav_save_park_common_text_color));
        }
        TextView textView2 = this.p;
        if (textView2 != null) {
            IIX0o.ooOOo0oXI(textView2);
            textView2.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.bnav_save_park_common_text_color));
        }
        ImageView imageView = this.v;
        if (imageView != null) {
            IIX0o.ooOOo0oXI(imageView);
            imageView.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_drawable_save_park_icon));
        }
        FrameLayout frameLayout = this.s;
        if (frameLayout != null) {
            IIX0o.ooOOo0oXI(frameLayout);
            frameLayout.setBackground(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_layout_save_park_camera_background));
        }
        TextView textView3 = this.q;
        if (textView3 != null) {
            IIX0o.ooOOo0oXI(textView3);
            textView3.setBackground(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_rg_save_park_cancel_bg));
        }
        TextView textView4 = this.r;
        if (textView4 != null) {
            IIX0o.ooOOo0oXI(textView4);
            textView4.setBackground(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_rg_save_park_confirm_bg));
        }
        ViewGroup viewGroup = this.l;
        if (viewGroup != null) {
            IIX0o.ooOOo0oXI(viewGroup);
            viewGroup.setBackground(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_layout_save_park_panel_background));
        }
        View view = this.m;
        if (view != null) {
            IIX0o.ooOOo0oXI(view);
            view.setBackground(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_layout_save_park_panel_gradient_bg));
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void a(@OOXIXo com.baidu.navisdk.module.park.a saveParkListData) {
        IIX0o.x0xO0oo(saveParkListData, "saveParkListData");
        y();
        com.baidu.navisdk.ui.routeguide.asr.c.n().b(false);
        ViewGroup viewGroup = this.j;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        ViewGroup viewGroup2 = this.i;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
            viewGroup2.setBackgroundDrawable(null);
        }
        ViewGroup viewGroup3 = this.l;
        if (viewGroup3 != null) {
            viewGroup3.startAnimation(com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_IN, 0L, 300L));
            viewGroup3.setVisibility(0);
        }
        TextView textView = this.o;
        if (textView != null) {
            textView.setText("车停在" + saveParkListData.c() + "附近");
        }
        TextView textView2 = this.p;
        if (textView2 != null) {
            textView2.setText(saveParkListData.m());
        }
        if (saveParkListData.f() != null) {
            ImageFilterView imageFilterView = this.t;
            if (imageFilterView != null) {
                imageFilterView.setImageBitmap(saveParkListData.f());
                imageFilterView.setVisibility(0);
                ImageView imageView = this.u;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                ImageView imageView2 = this.v;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
            }
        } else {
            ImageView imageView3 = this.v;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            ImageFilterView imageFilterView2 = this.t;
            if (imageFilterView2 != null) {
                imageFilterView2.setVisibility(8);
            }
            ImageView imageView4 = this.u;
            if (imageView4 != null) {
                imageView4.setVisibility(8);
            }
        }
        a(com.baidu.navisdk.ui.util.b.b());
    }

    public final void a(@OOXIXo com.baidu.navisdk.pronavi.ui.park.bottom.b callBack) {
        IIX0o.x0xO0oo(callBack, "callBack");
        this.w = callBack;
    }
}
