package com.baidu.navisdk.ui.routeguide.widget.volume;

import android.R;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.widget.f;
import com.baidu.navisdk.ui.widget.BNCommonTitleBar;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class e extends f implements View.OnClickListener {
    private int b;
    private BNCommonTitleBar c;
    private ViewGroup d;
    private ViewGroup e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private LinearLayout k;

    public e(Activity activity) {
        super(activity, R.style.Theme.Translucent.NoTitleBar);
        this.b = 0;
        this.c = null;
        if (Build.VERSION.SDK_INT >= 28) {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        try {
            this.e = (ViewGroup) JarUtils.inflate(getContext(), com.baidu.navisdk.embed.R.layout.nsdk_layout_rg_mapmode_bluetooth_usb_guide, null);
        } catch (Exception unused) {
            this.e = null;
        }
        ViewGroup viewGroup = this.e;
        if (viewGroup == null) {
            return;
        }
        setContentView(viewGroup);
        b();
        a();
    }

    private void a() {
        ViewGroup viewGroup = this.d;
        if (viewGroup == null) {
            return;
        }
        viewGroup.findViewById(com.baidu.navisdk.embed.R.id.left_imageview).setOnClickListener(this);
        this.d.setClickable(true);
    }

    private void b() {
        ViewGroup viewGroup = this.e;
        if (viewGroup == null) {
            return;
        }
        try {
            BNCommonTitleBar bNCommonTitleBar = (BNCommonTitleBar) viewGroup.findViewById(com.baidu.navisdk.embed.R.id.title_bar);
            this.c = bNCommonTitleBar;
            if (bNCommonTitleBar != null) {
                bNCommonTitleBar.setMiddleTextVisible(true);
                this.c.setMiddleTextSize(18.0f);
                this.c.setRightTextVisible(false);
            }
            this.d = (ViewGroup) this.e.findViewById(com.baidu.navisdk.embed.R.id.nav_view_bluetooth_usb_guide_panel);
            this.f = (TextView) this.e.findViewById(com.baidu.navisdk.embed.R.id.bnav_rg_bluetooth_usb_guide_problem_discription_tv);
            this.g = (TextView) this.e.findViewById(com.baidu.navisdk.embed.R.id.bnav_rg_bluetooth_usb_guide_fix_discription_tv);
            this.h = (TextView) this.e.findViewById(com.baidu.navisdk.embed.R.id.bnav_rg_bluetooth_usb_guide_still_no_volum_discription_tv);
            this.k = (LinearLayout) this.e.findViewById(com.baidu.navisdk.embed.R.id.bnav_rg_bluetooth_usb_guide_still_no_volum_ll);
            this.i = (TextView) this.e.findViewById(com.baidu.navisdk.embed.R.id.bnav_rg_bluetooth_usb_guide_subtitle_1);
            this.j = (TextView) this.e.findViewById(com.baidu.navisdk.embed.R.id.bnav_rg_bluetooth_usb_guide_subtitle_2);
        } catch (Exception unused) {
        }
    }

    private void c() {
        int i;
        if (com.baidu.navisdk.ui.routeguide.b.V().r().g()) {
            Window window = getWindow();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                i = 0;
            } else {
                i = 754974720;
            }
            window.setStatusBarColor(i);
            if (i2 >= 23) {
                window.getDecorView().setSystemUiVisibility(1280);
                window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 8192);
            } else {
                window.getDecorView().setSystemUiVisibility(1280);
            }
            window.addFlags(Integer.MIN_VALUE);
        }
        if (com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c().b()) {
            View findViewById = findViewById(com.baidu.navisdk.embed.R.id.bnav_rg_bluetooth_usb_guide_scroll);
            if (x.b().e0() == 2) {
                int statusBarHeight = ScreenUtil.getInstance().getStatusBarHeight(getOwnerActivity());
                findViewById.setPadding(statusBarHeight, 0, statusBarHeight, 0);
                ((LinearLayout.LayoutParams) this.c.getLayoutParams()).leftMargin = statusBarHeight;
                ((LinearLayout.LayoutParams) this.c.getLayoutParams()).rightMargin = statusBarHeight;
                this.c.requestLayout();
                return;
            }
            findViewById.setPadding(0, 0, 0, 0);
            ((LinearLayout.LayoutParams) this.c.getLayoutParams()).leftMargin = 0;
            ((LinearLayout.LayoutParams) this.c.getLayoutParams()).rightMargin = 0;
            this.c.requestLayout();
        }
    }

    private void d() {
        if (this.c != null && this.f != null && this.g != null && this.h != null) {
            int i = this.b;
            if (i == 1) {
                this.k.setVisibility(0);
                this.h.setVisibility(0);
                this.i.setText(JarUtils.getResources().getString(com.baidu.navisdk.embed.R.string.nsdk_string_rg_bluetooth_usb_guide_fix));
                this.j.setText(JarUtils.getResources().getString(com.baidu.navisdk.embed.R.string.nsdk_string_rg_bluetooth_usb_guide_still_no_volum));
                this.c.setMiddleText(JarUtils.getResources().getString(com.baidu.navisdk.embed.R.string.nsdk_string_rg_bluetooth_guide));
                this.f.setText(JarUtils.getResources().getString(com.baidu.navisdk.embed.R.string.nsdk_string_rg_bluetooth_guide_problem_discription));
                this.g.setText(JarUtils.getResources().getString(com.baidu.navisdk.embed.R.string.nsdk_string_rg_bluetooth_guide_fix_discription));
                this.h.setText(JarUtils.getResources().getString(com.baidu.navisdk.embed.R.string.nsdk_string_rg_bluetooth_guide_still_no_volum_discription));
                return;
            }
            if (i == 2) {
                this.k.setVisibility(8);
                this.h.setVisibility(8);
                this.c.setMiddleText(JarUtils.getResources().getString(com.baidu.navisdk.embed.R.string.nsdk_string_rg_usb_guide));
                this.f.setText(JarUtils.getResources().getString(com.baidu.navisdk.embed.R.string.nsdk_string_rg_usb_guide_problem_discription));
                this.g.setText(JarUtils.getResources().getString(com.baidu.navisdk.embed.R.string.nsdk_string_rg_usb_guide_fix_discription));
                return;
            }
            if (i == 3) {
                this.k.setVisibility(0);
                this.h.setVisibility(0);
                this.i.setText("导航无声：");
                this.j.setText("导航声音卡顿：");
                this.c.setMiddleText("声音问题说明");
                this.f.setVisibility(8);
                this.g.setText(JarUtils.getResources().getString(com.baidu.navisdk.embed.R.string.nsdk_string_rg_bluetooth_guide_quiet_sub_content_1));
                this.h.setText(JarUtils.getResources().getString(com.baidu.navisdk.embed.R.string.nsdk_string_rg_bluetooth_guide_quiet_sub_content_2));
            }
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        try {
            if (view.getId() == com.baidu.navisdk.embed.R.id.left_imageview) {
                x.b().E0();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        c();
        d();
    }

    public void a(int i) {
        this.b = i;
        show();
    }
}
