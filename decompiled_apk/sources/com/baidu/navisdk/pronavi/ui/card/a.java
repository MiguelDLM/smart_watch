package com.baidu.navisdk.pronavi.ui.card;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.bluetooth.BNBluetoothAudio;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.i;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.j;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNBaseDialog;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.utils.a;

/* loaded from: classes7.dex */
public class a extends j implements View.OnClickListener {
    private View e;
    private TextView f;
    private TextView g;
    private TextView h;
    private View i;
    private final com.baidu.navisdk.util.worker.f<String, String> j = new C0349a(this, "dismissBtPhoneDialog", null);

    /* renamed from: com.baidu.navisdk.pronavi.ui.card.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0349a extends com.baidu.navisdk.util.worker.f<String, String> {
        public C0349a(a aVar, String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().o();
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMBluetoothSettingCard", "onAnimationEnd: ");
            }
            if (a.this.e != null) {
                a.this.e.clearAnimation();
            }
            i.g().b(1010);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes7.dex */
    public class c implements BNBluetoothAudio.g {
        public c() {
        }

        @Override // com.baidu.navisdk.bluetooth.BNBluetoothAudio.g
        public void a(int i) {
            a.this.c(2);
        }

        @Override // com.baidu.navisdk.bluetooth.BNBluetoothAudio.g
        public void a(int i, int i2) {
            a.this.b(2);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements BNBaseDialog.OnNaviClickListener {

        /* renamed from: com.baidu.navisdk.pronavi.ui.card.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0350a implements BNBluetoothAudio.g {
            public C0350a() {
            }

            @Override // com.baidu.navisdk.bluetooth.BNBluetoothAudio.g
            public void a(int i) {
                a.this.c(1);
            }

            @Override // com.baidu.navisdk.bluetooth.BNBluetoothAudio.g
            public void a(int i, int i2) {
                a.this.b(i);
            }
        }

        public d() {
        }

        @Override // com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener
        public void onClick() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.a.3", "2", null, "3");
            com.baidu.navisdk.ui.routeguide.b.V().r().l();
            a.this.q();
            BNCommSettingManager.getInstance().setBluetoothChannelMode(1);
            com.baidu.navisdk.bluetooth.b.i().a(1, new C0350a());
        }
    }

    /* loaded from: classes7.dex */
    public class e implements DialogInterface.OnDismissListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            a.this.n();
            a.this.a(BNCommSettingManager.getInstance().getBluetoothChannelMode());
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) a.this.j, true);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements BNBluetoothAudio.g {
        public f() {
        }

        @Override // com.baidu.navisdk.bluetooth.BNBluetoothAudio.g
        public void a(int i) {
            a.this.c(0);
        }

        @Override // com.baidu.navisdk.bluetooth.BNBluetoothAudio.g
        public void a(int i, int i2) {
            a.this.b(0);
        }
    }

    public a(Context context) {
        this.b = context;
        this.f8808a = 1010;
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        i.g().b(1010);
    }

    private void r() {
        View a2 = com.baidu.navisdk.ui.util.b.a(this.b, R.layout.nsdk_layout_rg_bluetooth_controller_panel);
        this.e = a2;
        a2.setOnClickListener(this);
        this.i = this.e.findViewById(R.id.bluetooth_panel_layout_bottom);
        this.f = (TextView) this.e.findViewById(R.id.bluetooth_default_play_text);
        this.g = (TextView) this.e.findViewById(R.id.bluetooth_phone_play_text);
        this.h = (TextView) this.e.findViewById(R.id.bluetooth_speaker_play_text);
        this.e.findViewById(R.id.bluetooth_default_layout).setOnClickListener(this);
        this.e.findViewById(R.id.bluetooth_phone_layout).setOnClickListener(this);
        if (!com.baidu.navisdk.bluetooth.a.a()) {
            this.e.findViewById(R.id.bluetooth_speaker_layout).setVisibility(8);
        } else {
            this.e.findViewById(R.id.bluetooth_speaker_layout).setOnClickListener(this);
        }
        a(com.baidu.navisdk.ui.util.b.b());
        a(BNCommSettingManager.getInstance().getBluetoothChannelMode());
    }

    private void s() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.b("RGMMBluetoothSettingCard", "onDefaultPlaySelected");
        }
        this.f.setSelected(true);
        this.g.setSelected(false);
        this.h.setSelected(false);
    }

    private void t() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.b("RGMMBluetoothSettingCard", "onPhonePlaySelected");
        }
        this.f.setSelected(false);
        this.g.setSelected(true);
        this.h.setSelected(false);
    }

    private void u() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.b("RGMMBluetoothSettingCard", "onSpeakerPlaySelected");
        }
        this.f.setSelected(false);
        this.g.setSelected(false);
        this.h.setSelected(true);
    }

    private void v() {
        if (com.baidu.navisdk.util.common.d.h) {
            TipTool.onCreateToastDialog(this.b, R.string.nsdk_bluetooth_panel_switch_when_calling);
            return;
        }
        if (BNCommSettingManager.getInstance().getBluetoothChannelMode() == 0) {
            n();
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("b.a.1", "1", null, "3");
        q();
        com.baidu.navisdk.ui.routeguide.b.V().r().l();
        BNCommSettingManager.getInstance().setBluetoothChannelMode(0);
        com.baidu.navisdk.bluetooth.b.i().a(0, new f());
    }

    private void w() {
        if (com.baidu.navisdk.util.common.d.h) {
            TipTool.onCreateToastDialog(this.b, R.string.nsdk_bluetooth_panel_switch_when_calling);
            return;
        }
        if (BNCommSettingManager.getInstance().getBluetoothChannelMode() == 1) {
            n();
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("b.a.1", "2", null, "3");
        com.baidu.navisdk.util.statistic.userop.b.r().a("b.a.3", "1", null, "3");
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a((BNBaseDialog.OnNaviClickListener) new d(), (DialogInterface.OnDismissListener) new e(), true);
        com.baidu.navisdk.util.worker.c.a().a(this.j, new com.baidu.navisdk.util.worker.e(2, 0), 30000L);
        o();
    }

    private void x() {
        if (com.baidu.navisdk.util.common.d.h) {
            TipTool.onCreateToastDialog(this.b, R.string.nsdk_bluetooth_panel_switch_when_calling);
            return;
        }
        if (BNCommSettingManager.getInstance().getBluetoothChannelMode() == 2) {
            n();
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("b.a.1", "3", null, "3");
        q();
        com.baidu.navisdk.ui.routeguide.b.V().r().l();
        BNCommSettingManager.getInstance().setBluetoothChannelMode(2);
        com.baidu.navisdk.bluetooth.b.i().a(2, new c());
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public RelativeLayout.LayoutParams d() {
        int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_toolbox_margin_left);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (x.b().s2()) {
            layoutParams.setMargins(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        } else {
            layoutParams.setMargins(x.b().V(), dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        }
        layoutParams.addRule(12);
        return layoutParams;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public View e() {
        return this.e;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void h() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.j, com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void k() {
        super.k();
        if (this.i != null) {
            this.i.startAnimation(com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_IN, 0L, 300L));
            this.i.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.bluetooth_default_layout) {
            v();
            return;
        }
        if (id == R.id.bluetooth_phone_layout) {
            w();
        } else if (id == R.id.bluetooth_speaker_layout) {
            x();
        } else {
            p();
        }
    }

    public void p() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMBluetoothSettingCard", "hideOnAnimation: ");
        }
        Animation a2 = com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_OUT, 0L, 500L);
        a2.setFillAfter(true);
        a2.setAnimationListener(new b());
        View view = this.e;
        if (view != null) {
            view.startAnimation(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        Drawable f2 = com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_bluetooth);
        x.b().j(112).z(100).b(f2).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_bluetooth_panel_notification_fail_text)).y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        Drawable f2 = com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_bluetooth);
        x.b().j(112).z(100).b(f2).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_bluetooth_panel_notification_success_text)).y();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void a(boolean z) {
        int parseColor;
        int parseColor2;
        super.a(z);
        View view = this.i;
        if (view != null) {
            view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_layout_route_sort_background));
        }
        int b2 = com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_bg_d_mm);
        this.e.findViewById(R.id.bnav_rg_menu_bluetooth_split_1).setBackgroundColor(b2);
        this.e.findViewById(R.id.bnav_rg_menu_bluetooth_split_0).setBackgroundColor(b2);
        this.e.findViewById(R.id.bluetooth_panel_line_1).setBackgroundColor(b2);
        ColorStateList colorStateList = JarUtils.getResources().getColorStateList(R.drawable.nsdk_rg_bluetooth_panel_text_selector);
        if (z) {
            parseColor = Color.parseColor("#666666");
            parseColor2 = Color.parseColor("#333333");
        } else {
            parseColor = Color.parseColor("#a5acb2");
            parseColor2 = Color.parseColor("#ffffff");
        }
        ((TextView) this.e.findViewById(R.id.bluetooth_default_play_sub_title)).setTextColor(parseColor);
        ((TextView) this.e.findViewById(R.id.bluetooth_phone_play_sub_title)).setTextColor(parseColor);
        ((TextView) this.e.findViewById(R.id.bluetooth_speaker_play_sub_title)).setTextColor(parseColor);
        ((TextView) this.e.findViewById(R.id.bluetooth_bottom_panel_title)).setTextColor(parseColor2);
        this.f.setTextColor(colorStateList);
        this.g.setTextColor(colorStateList);
        this.h.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i == 0) {
            s();
            return;
        }
        if (i == 1) {
            t();
        } else if (i != 2) {
            s();
        } else {
            u();
        }
    }
}
