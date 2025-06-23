package com.baidu.navisdk.ui.routeguide.widget.volume;

import android.R;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.navisdk.module.pronavi.model.h;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.f;
import com.baidu.navisdk.util.worker.g;

/* loaded from: classes8.dex */
public class b extends com.baidu.navisdk.ui.routeguide.widget.volume.c {
    private static final String i = "b";
    private RelativeLayout b;
    private LinearLayout c;
    private ProgressBar d;
    private ImageView e;
    private View f;
    private View g;
    private f<String, String> h;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.worker.c.a().a((g) b.this.h, false);
            b.this.dismiss();
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.r.3", "3", null, null);
            x.b().w(3);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.widget.volume.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnClickListenerC0489b implements View.OnClickListener {
        public ViewOnClickListenerC0489b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.worker.c.a().a((g) b.this.h, false);
            b.this.dismiss();
        }
    }

    /* loaded from: classes8.dex */
    public class c extends f<String, String> {
        public c(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            b.this.dismiss();
            if (b.this.b == null) {
                return null;
            }
            b.this.b.setVisibility(8);
            return null;
        }
    }

    public b(Activity activity) {
        super(activity, R.style.Theme.Translucent.NoTitleBar);
        View view = null;
        this.h = new c("mDisapperVolumeTask-" + b.class.getSimpleName(), null);
        try {
            view = JarUtils.inflate(activity, com.baidu.navisdk.embed.R.layout.nsdk_layout_volume_adjust_dialog, null);
        } catch (Exception unused) {
        }
        if (view == null) {
            return;
        }
        setContentView(view);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        this.b = (RelativeLayout) findViewById(com.baidu.navisdk.embed.R.id.navi_rg_rl_volume);
        this.d = (ProgressBar) findViewById(com.baidu.navisdk.embed.R.id.navi_rg_pg_volume);
        this.e = (ImageView) findViewById(com.baidu.navisdk.embed.R.id.bnav_rg_volume_icon);
        this.c = (LinearLayout) findViewById(com.baidu.navisdk.embed.R.id.navi_rg_ll_volume);
        this.f = findViewById(com.baidu.navisdk.embed.R.id.navi_rg_pg_default_volume_split_line);
        View findViewById = findViewById(com.baidu.navisdk.embed.R.id.navi_rg_default_volume_describe_tv);
        this.g = findViewById;
        findViewById.setOnClickListener(new a());
        a(com.baidu.navisdk.ui.util.b.b());
        this.b.setOnClickListener(new ViewOnClickListenerC0489b());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.e()) {
            gVar.g(i, "BNVolumeDefaultDialog dismiss");
        }
        com.baidu.navisdk.util.worker.c.a().a((g) this.h, false);
        super.dismiss();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        dismiss();
        RelativeLayout relativeLayout = this.b;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
    }

    private void b(boolean z) {
        View view = this.f;
        if (view == null || this.g == null) {
            return;
        }
        if (z) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.k.2");
            this.f.setVisibility(0);
            this.g.setVisibility(0);
        } else {
            view.setVisibility(8);
            this.g.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.volume.c
    public void a(int i2, int i3, int i4, int i5, boolean z, int i6, int i7) {
        int dip2px;
        int i8;
        int V;
        int dip2px2;
        LinearLayout linearLayout = this.c;
        if (linearLayout != null && this.e != null && this.d != null) {
            if (2 == h.f7469a) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                if (a()) {
                    V = ScreenUtil.getInstance().dip2px(58) + (x.b().V() / 2);
                    dip2px2 = V;
                } else {
                    V = x.b().V() + ScreenUtil.getInstance().dip2px(58);
                    dip2px2 = ScreenUtil.getInstance().dip2px(58);
                }
                layoutParams.setMargins(V, ScreenUtil.getInstance().dip2px(8), dip2px2, 0);
                this.c.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                if (i6 > 0 && i7 > 0) {
                    dip2px = ScreenUtil.getInstance().dip2px(8) + i6 + i7;
                } else {
                    dip2px = ScreenUtil.getInstance().dip2px(160);
                }
                layoutParams2.setMargins(ScreenUtil.getInstance().dip2px(58), dip2px, ScreenUtil.getInstance().dip2px(58), 0);
                this.c.setLayoutParams(layoutParams2);
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e(i, "curSystemVolume = " + i2 + ", maxSystemVolume = " + i4 + ", curSystemVolume * 100 / maxSystemVolume = " + ((i2 * 100) / i4));
            }
            com.baidu.navisdk.util.worker.c.a().a((g) this.h, false);
            if (i2 == 0) {
                ImageView imageView = this.e;
                if (imageView != null) {
                    imageView.setImageDrawable(com.baidu.navisdk.ui.util.b.f(com.baidu.navisdk.embed.R.drawable.nsdk_drawable_rg_no_voice_icon));
                }
            } else {
                ImageView imageView2 = this.e;
                if (imageView2 != null) {
                    imageView2.setImageDrawable(com.baidu.navisdk.ui.util.b.f(com.baidu.navisdk.embed.R.drawable.nsdk_drawable_rg_voume_icon));
                }
            }
            if (i3 == i4 && z && !com.baidu.navisdk.ui.routeguide.mapmode.a.o5().T1()) {
                b(true);
                i8 = 5000;
            } else {
                b(false);
                i8 = 3000;
            }
            this.d.setProgress((i2 * 100) / i4);
            this.b.setVisibility(0);
            com.baidu.navisdk.util.worker.c.a().a(this.h, new com.baidu.navisdk.util.worker.e(99, 0), i8);
            return;
        }
        if (LogUtil.LOGGABLE) {
            String str = i;
            StringBuilder sb = new StringBuilder();
            sb.append("showVolume,mRGLLVolume is null=");
            sb.append(this.c == null);
            sb.append(",mRGIVVolume is null=");
            sb.append(this.e == null);
            sb.append(",mRGPBVolume is null=");
            sb.append(this.d == null);
            LogUtil.e(str, sb.toString());
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.volume.c
    public void a(int i2, int i3, int i4) {
        int dip2px;
        int V;
        int dip2px2;
        if (2 == i2) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            if (a()) {
                V = ScreenUtil.getInstance().dip2px(58) + (x.b().V() / 2);
                dip2px2 = V;
            } else {
                V = x.b().V() + ScreenUtil.getInstance().dip2px(58);
                dip2px2 = ScreenUtil.getInstance().dip2px(58);
            }
            layoutParams.setMargins(V, ScreenUtil.getInstance().dip2px(8), dip2px2, 0);
            this.c.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        if (i3 > 0 && i4 > 0) {
            dip2px = ScreenUtil.getInstance().dip2px(8) + i3 + i4;
        } else {
            dip2px = ScreenUtil.getInstance().dip2px(160);
        }
        layoutParams2.setMargins(ScreenUtil.getInstance().dip2px(58), dip2px, ScreenUtil.getInstance().dip2px(58), 0);
        this.c.setLayoutParams(layoutParams2);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.volume.c
    public void a(boolean z) {
        LinearLayout linearLayout = this.c;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(com.baidu.navisdk.embed.R.drawable.bnav_common_cp_button_selector));
        }
        View view = this.f;
        if (view != null) {
            if (z) {
                view.setBackgroundColor(Color.parseColor("#d6d6d6"));
            } else {
                view.setBackgroundColor(Color.parseColor("#2b2d31"));
            }
        }
    }
}
