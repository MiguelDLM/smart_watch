package com.baidu.navisdk.pronavi.hd.hdnavi;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.navisdk.embed.R;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class d extends com.baidu.navisdk.ui.routeguide.widget.d {
    public com.baidu.navisdk.framework.interfaces.pronavi.hd.d i;
    public ImageView j;
    public ImageView k;
    private View l;

    /* loaded from: classes7.dex */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d.this.n0().a();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d.this.n0().b();
        }
    }

    public d(@oOoXoXO Context context, @oOoXoXO ViewGroup viewGroup) {
        super(context, viewGroup);
        a(viewGroup);
    }

    public final void a(@OOXIXo com.baidu.navisdk.framework.interfaces.pronavi.hd.d dVar) {
        IIX0o.x0xO0oo(dVar, "<set-?>");
        this.i = dVar;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        View view = this.l;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.interfaces.pronavi.hd.d n0() {
        com.baidu.navisdk.framework.interfaces.pronavi.hd.d dVar = this.i;
        if (dVar == null) {
            IIX0o.XOxIOxOx("mViewClickListener");
        }
        return dVar;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        View view = this.l;
        if (view != null) {
            view.setVisibility(0);
        }
        return super.y();
    }

    public final void a(@oOoXoXO View view) {
        if (view != null) {
            this.l = view.findViewById(R.id.bnav_rg_hd_upper_ui_root_ly);
            View findViewById = view.findViewById(R.id.bnav_rg_hd_full_btn);
            IIX0o.oO(findViewById, "findViewById(R.id.bnav_rg_hd_full_btn)");
            ImageView imageView = (ImageView) findViewById;
            this.j = imageView;
            if (imageView == null) {
                IIX0o.XOxIOxOx("fullViewBtn");
            }
            imageView.setOnClickListener(new a());
            View findViewById2 = view.findViewById(R.id.bnav_rg_hd_close_btn);
            IIX0o.oO(findViewById2, "findViewById(R.id.bnav_rg_hd_close_btn)");
            ImageView imageView2 = (ImageView) findViewById2;
            this.k = imageView2;
            if (imageView2 == null) {
                IIX0o.XOxIOxOx("closeBtn");
            }
            imageView2.setOnClickListener(new b());
            a(com.baidu.navisdk.ui.util.b.c());
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(@oOoXoXO ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        if (this.l != null) {
            ImageView imageView = this.j;
            if (imageView == null) {
                IIX0o.XOxIOxOx("fullViewBtn");
            }
            com.baidu.navisdk.ui.util.b.a(imageView, R.drawable.bnav_ic_hd_full);
            ImageView imageView2 = this.k;
            if (imageView2 == null) {
                IIX0o.XOxIOxOx("closeBtn");
            }
            com.baidu.navisdk.ui.util.b.a(imageView2, R.drawable.bnav_ic_hd_multi_close);
        }
    }
}
