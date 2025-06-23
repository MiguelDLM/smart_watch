package com.baidu.navisdk.ui.routeguide.widget.volume;

import android.R;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.module.pronavi.model.h;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.f;
import com.baidu.navisdk.util.worker.g;

/* loaded from: classes8.dex */
public class a extends com.baidu.navisdk.ui.routeguide.widget.volume.c {
    private static final String j = "a";
    private RelativeLayout b;
    private LinearLayout c;
    private ProgressBar d;
    private ImageView e;
    private TextView f;
    private TextView g;
    private View h;
    private f<String, String> i;

    /* renamed from: com.baidu.navisdk.ui.routeguide.widget.volume.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnClickListenerC0488a implements View.OnClickListener {
        public ViewOnClickListenerC0488a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.worker.c.a().a((g) a.this.i, false);
            a.this.dismiss();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null) {
                return;
            }
            com.baidu.navisdk.util.worker.c.a().a((g) a.this.i, false);
            a.this.dismiss();
            a.this.a(1);
        }
    }

    /* loaded from: classes8.dex */
    public class c extends f<String, String> {
        public c(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            a.this.dismiss();
            if (a.this.b == null) {
                return null;
            }
            a.this.b.setVisibility(8);
            return null;
        }
    }

    public a(Activity activity) {
        super(activity, R.style.Theme.Translucent.NoTitleBar);
        this.f = null;
        this.h = null;
        this.i = new c("mDisappearVolumeTask-" + a.class.getSimpleName(), null);
        requestWindowFeature(1);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
            window.clearFlags(2);
        }
        try {
            setContentView(JarUtils.inflate(activity, com.baidu.navisdk.embed.R.layout.nsdk_layout_volume_bluetooth_dialog, null));
            setCanceledOnTouchOutside(false);
            setCancelable(true);
            this.b = (RelativeLayout) findViewById(com.baidu.navisdk.embed.R.id.navi_rg_rl_volume);
            this.d = (ProgressBar) findViewById(com.baidu.navisdk.embed.R.id.navi_rg_pg_volume);
            this.e = (ImageView) findViewById(com.baidu.navisdk.embed.R.id.bnav_rg_volume_icon);
            this.c = (LinearLayout) findViewById(com.baidu.navisdk.embed.R.id.navi_rg_ll_volume);
            this.h = findViewById(com.baidu.navisdk.embed.R.id.navi_rg_pg_volume_split_line);
            this.f = (TextView) findViewById(com.baidu.navisdk.embed.R.id.navi_rg_volume_describe_tv);
            this.g = (TextView) findViewById(com.baidu.navisdk.embed.R.id.volume_blue_title);
            b();
            a(com.baidu.navisdk.ui.util.b.b());
            this.b.setOnClickListener(new ViewOnClickListenerC0488a());
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        com.baidu.navisdk.util.worker.c.a().a((g) this.i, false);
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

    private void b() {
        TextView textView = this.f;
        if (textView == null) {
            return;
        }
        textView.setOnClickListener(new b());
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.volume.c
    public void a(int i, int i2, int i3, int i4, boolean z, int i5, int i6) {
        int dip2px;
        int V;
        int dip2px2;
        LinearLayout linearLayout = this.c;
        if (linearLayout == null || this.e == null || this.d == null) {
            return;
        }
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
            if (i5 > 0 && i6 > 0) {
                dip2px = ScreenUtil.getInstance().dip2px(8) + i5 + i6;
            } else {
                dip2px = ScreenUtil.getInstance().dip2px(160);
            }
            layoutParams2.setMargins(ScreenUtil.getInstance().dip2px(58), dip2px, ScreenUtil.getInstance().dip2px(58), 0);
            this.c.setLayoutParams(layoutParams2);
        }
        com.baidu.navisdk.util.worker.c.a().a((g) this.i, false);
        if (i == 0) {
            ImageView imageView = this.e;
            if (imageView != null) {
                imageView.setImageDrawable(com.baidu.navisdk.ui.util.b.f(com.baidu.navisdk.embed.R.drawable.nsdk_bluetooth_volume_icon_2));
            }
        } else {
            ImageView imageView2 = this.e;
            if (imageView2 != null) {
                imageView2.setImageDrawable(com.baidu.navisdk.ui.util.b.f(com.baidu.navisdk.embed.R.drawable.nsdk_bluetooth_volume_icon_1));
            }
        }
        String str = j;
        StringBuilder sb = new StringBuilder();
        sb.append("curSystemVolume = ");
        sb.append(i);
        sb.append(", maxSystemVolume = ");
        sb.append(i3);
        sb.append(", curSystemVolume * 100 / maxSystemVolume = ");
        int i7 = (i * 100) / i3;
        sb.append(i7);
        LogUtil.e(str, sb.toString());
        this.d.setProgress(i7);
        this.b.setVisibility(0);
        com.baidu.navisdk.util.worker.c.a().a(this.i, new com.baidu.navisdk.util.worker.e(99, 0), 3000L);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.volume.c
    public void a(int i, int i2, int i3) {
        int dip2px;
        int V;
        int dip2px2;
        if (2 == i) {
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
        if (i2 > 0 && i3 > 0) {
            dip2px = ScreenUtil.getInstance().dip2px(8) + i2 + i3;
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
        View view = this.h;
        if (view != null) {
            if (z) {
                view.setBackgroundColor(Color.parseColor("#d6d6d6"));
            } else {
                view.setBackgroundColor(Color.parseColor("#2b2d31"));
            }
        }
        TextView textView = this.g;
        if (textView != null) {
            if (z) {
                textView.setTextColor(Color.parseColor("#000000"));
            } else {
                textView.setTextColor(Color.parseColor("#ffffff"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i == 1) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.r.3", "1", null, null);
        } else if (i == 2) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.r.3", "2", null, null);
        }
        x.b().w(i);
    }
}
