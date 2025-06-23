package com.baidu.navisdk.module.newguide.settings.viewholder;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.newguide.settings.g;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingExplainSwitchItem;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingNewTextRadioGroup;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class a extends g.b {
    private BNSettingExplainSwitchItem.c b;
    private BNSettingNewTextRadioGroup.a c;
    private View.OnClickListener d;
    private com.baidu.navisdk.module.newguide.settings.i.a e;
    private BNSettingNewTextRadioGroup f;
    private TextView g;
    private BNSettingNewTextRadioGroup h;
    private TextView i;
    private RelativeLayout j;
    private TextView k;
    private TextView l;
    private BNSettingNewTextRadioGroup m;
    private TextView n;
    private Group o;
    private BNSettingExplainSwitchItem p;
    private BNSettingExplainSwitchItem q;
    private ImageView r;
    private BNSettingExplainSwitchItem s;
    private BNSettingExplainSwitchItem t;
    private BNSettingExplainSwitchItem u;
    private BNSettingExplainSwitchItem v;
    private BNSettingExplainSwitchItem w;
    private BNSettingNewTextRadioGroup x;
    public int y;
    public int z;

    /* renamed from: com.baidu.navisdk.module.newguide.settings.viewholder.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0259a implements Observer<Boolean> {
        public C0259a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable Boolean bool) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("AssistFuncGroupItemVie", "POWER_SAVE onChanged: " + bool);
            }
            if (a.this.t != null) {
                a.this.t.setChecked(bool.booleanValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Observer<Boolean> {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable Boolean bool) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("AssistFuncGroupItemVie", "SAVE_PARKING onChanged: " + bool);
            }
            if (a.this.u != null) {
                a.this.u.setChecked(bool.booleanValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Observer<Boolean> {
        public c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable Boolean bool) {
            int i;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("AssistFuncGroupItemVie", "HD_NAVI onChanged: " + bool);
            }
            if (a.this.v != null) {
                a.this.v.setChecked(bool.booleanValue());
            }
            if (a.this.x != null && com.baidu.navisdk.function.b.FUNC_HD_NAVI_SETTING_ITEM.a() && com.baidu.navisdk.module.cloudconfig.f.c().I.c) {
                BNSettingNewTextRadioGroup bNSettingNewTextRadioGroup = a.this.x;
                if (bool.booleanValue()) {
                    i = 0;
                } else {
                    i = 8;
                }
                bNSettingNewTextRadioGroup.setVisibility(i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Observer<Boolean> {
        public d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable Boolean bool) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("AssistFuncGroupItemVie", "NORMAL_HD onChanged: " + bool);
            }
            if (a.this.w != null) {
                a.this.w.setChecked(bool.booleanValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Observer<Boolean> {
        public e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable Boolean bool) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("AssistFuncGroupItemVie", "WECHAT_FOLLOW_CALLING onChanged: " + bool);
            }
            a.this.a(bool.booleanValue());
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Observer<Integer> {
        public f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable Integer num) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("AssistFuncGroupItemVie", "HD_NAVI_SCREEN_TYPE onChanged: " + num);
            }
            if (a.this.x != null) {
                a.this.x.a(num.intValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(com.baidu.navisdk.util.http.b.d().b("normalHdExplainUrl"));
            x.b().h();
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(com.baidu.navisdk.util.http.b.d().b("hdExplainUrl"));
            x.b().h();
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Observer<com.baidu.navisdk.module.newguide.settings.model.c> {
        public i() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable com.baidu.navisdk.module.newguide.settings.model.c cVar) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("AssistFuncGroupItemVie", "BLUETOOTH_PLAY onChanged: " + cVar);
            }
            if (cVar != null) {
                if (a.this.f != null) {
                    a.this.f.a(cVar.f7276a);
                }
                if (a.this.g != null) {
                    a.this.g.setText(cVar.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements Observer<com.baidu.navisdk.module.newguide.settings.model.c> {
        public j() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable com.baidu.navisdk.module.newguide.settings.model.c cVar) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("AssistFuncGroupItemVie", "MUSIC_PLAY onChanged: " + cVar);
            }
            if (cVar != null) {
                if (a.this.h != null) {
                    a.this.h.a(cVar.f7276a);
                }
                if (a.this.i != null) {
                    a.this.i.setText(cVar.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements Observer<com.baidu.navisdk.module.newguide.settings.model.c> {
        public k() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable com.baidu.navisdk.module.newguide.settings.model.c cVar) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("AssistFuncGroupItemVie", "MUSIC_PLAY onChanged: " + cVar);
            }
            if (cVar != null) {
                if (a.this.m != null) {
                    a.this.m.a(cVar.f7276a);
                }
                if (a.this.n != null) {
                    a.this.n.setText(cVar.b);
                }
                if (cVar.f7276a == 0) {
                    com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a();
                } else {
                    com.baidu.navisdk.ui.routeguide.mapmode.a.o5().z3();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements Observer<Boolean> {
        public l() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable Boolean bool) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("AssistFuncGroupItemVie", "PHONE_VOICE_PLAY onChanged: " + bool);
            }
            if (a.this.p != null) {
                a.this.p.setChecked(bool.booleanValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements Observer<Boolean> {
        public m() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable Boolean bool) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("AssistFuncGroupItemVie", "DESTINATION_PARK onChanged: " + bool);
            }
            if (a.this.q != null) {
                a.this.q.setChecked(bool.booleanValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements Observer<Boolean> {
        public n() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable Boolean bool) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("AssistFuncGroupItemVie", "BACKGROUND_FLOAT onChanged: " + bool);
            }
            if (a.this.r != null) {
                a.this.r.setSelected(bool.booleanValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements Observer<Boolean> {
        public o() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable Boolean bool) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("AssistFuncGroupItemVie", "SCENIC_BROADCAST onChanged: " + bool);
            }
            if (a.this.s != null) {
                a.this.s.setChecked(bool.booleanValue());
            }
        }
    }

    public a(View view, View.OnClickListener onClickListener, BNSettingExplainSwitchItem.c cVar, BNSettingNewTextRadioGroup.a aVar, g.a aVar2, com.baidu.navisdk.module.newguide.settings.i.a aVar3) {
        super(5, view, aVar2);
        this.y = 0;
        this.z = 9;
        this.d = onClickListener;
        this.b = cVar;
        this.c = aVar;
        this.e = aVar3;
        e();
        b();
        d();
    }

    private void b() {
        com.baidu.navisdk.module.newguide.settings.i.a aVar = this.e;
        if (aVar != null) {
            com.baidu.navisdk.module.newguide.settings.viewmodel.a I = aVar.I();
            LifecycleOwner J = this.e.J();
            if (I == null || J == null) {
                return;
            }
            I.b(12).observe(J, new i());
            I.b(13).observe(J, new j());
            I.b(24).observe(J, new k());
            I.a(14).observe(J, new l());
            I.a(15).observe(J, new m());
            I.a(22).observe(J, new n());
            I.a(16).observe(J, new o());
            I.a(17).observe(J, new C0259a());
            I.a(31).observe(J, new b());
            I.a(27).observe(J, new c());
            I.a(28).observe(J, new d());
            I.a(23).observe(J, new e());
            I.c(30).observe(J, new f());
        }
    }

    private void c() {
        this.y = 0;
        if (!com.baidu.navisdk.function.b.FUNC_BLUETOOTH_SOUND.a()) {
            a(R.id.nav_bluetooth_group).setVisibility(8);
            this.y++;
        }
        if (!com.baidu.navisdk.function.b.FUNC_POWER_SAVE_MODE.a()) {
            this.y++;
            this.t.setVisibility(8);
            View a2 = a(R.id.bn_rg_setting_group_assist_l5);
            if (a2 != null) {
                a2.setVisibility(8);
            }
        }
        if (!com.baidu.navisdk.module.cloudconfig.f.c().y.f7105a) {
            this.j.setVisibility(8);
        }
        if (!com.baidu.navisdk.function.b.FUNC_HD_NAVI_SETTING_ITEM.a() || com.baidu.navisdk.module.cloudconfig.f.c().I.c) {
            this.y++;
            this.v.setVisibility(8);
            this.x.setVisibility(8);
            View a3 = a(R.id.bn_rg_setting_group_assist_l7);
            if (a3 != null) {
                a3.setVisibility(8);
            }
        }
        if (!com.baidu.navisdk.function.b.FUNC_NORMAL_HD_NAVI_SETTING_ITEM.a() || com.baidu.navisdk.module.cloudconfig.f.c().U.b || !com.baidu.navisdk.module.abtest.model.h.v()) {
            this.y++;
            this.w.setVisibility(8);
            View a4 = a(R.id.nav_normal_hd_layout_group);
            if (a4 != null) {
                a4.setVisibility(8);
            }
        }
        if (!com.baidu.navisdk.function.b.FUNC_PARK.a()) {
            this.y++;
            this.q.setVisibility(8);
            View a5 = a(R.id.bn_rg_setting_group_assist_l3);
            if (a5 != null) {
                a5.setVisibility(8);
            }
        }
        if (!com.baidu.navisdk.function.b.FUNC_SCENIC_SETTING.a()) {
            this.y++;
            this.s.setVisibility(8);
            View a6 = a(R.id.bn_rg_setting_group_assist_l4);
            if (a6 != null) {
                a6.setVisibility(8);
            }
        }
        if (!com.baidu.navisdk.function.b.FUNC_FLOAT_SETTING.a()) {
            this.y++;
            this.o.setVisibility(8);
            View a7 = a(R.id.bn_rg_setting_group_assist_l2);
            if (a7 != null) {
                a7.setVisibility(8);
            }
        }
        if (!com.baidu.navisdk.function.b.FUNC_MUSIC_CONTROL.a()) {
            this.y++;
            this.h.setVisibility(8);
            this.i.setVisibility(8);
            TextView textView = (TextView) a(R.id.nav_music_volume_tv);
            if (textView != null) {
                textView.setVisibility(8);
            }
            View a8 = a(R.id.bn_rg_setting_group_assist_l1);
            if (a8 != null) {
                a8.setVisibility(8);
            }
        }
        if (!com.baidu.navisdk.function.b.FUNC_PHONE_VOICE.a()) {
            this.y++;
            this.p.setVisibility(8);
            View a9 = a(R.id.bn_rg_setting_group_assist_l6);
            if (a9 != null) {
                a9.setVisibility(8);
            }
            View a10 = a(R.id.nav_wechat_follow_calling);
            if (a10 != null) {
                a10.setVisibility(8);
            }
        }
        if (!com.baidu.navisdk.j.d()) {
            this.v.setFuncExplainViewVisibility(8);
            this.w.setFuncExplainViewVisibility(8);
        }
        if (a()) {
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = 0;
            }
            this.itemView.setVisibility(8);
        }
    }

    private void d() {
        this.f.setOnRadioCheckedChangeListener(this.c);
        this.h.setOnRadioCheckedChangeListener(this.c);
        this.m.setOnRadioCheckedChangeListener(this.c);
        this.p.setOnCheckedListener(this.b);
        this.q.setOnCheckedListener(this.b);
        this.s.setOnCheckedListener(this.b);
        this.t.setOnCheckedListener(this.b);
        this.u.setOnCheckedListener(this.b);
        this.v.setOnCheckedListener(this.b);
        this.w.setOnCheckedListener(this.b);
        this.k.setOnClickListener(this.d);
        this.r.setOnClickListener(this.d);
        this.l.setOnClickListener(this.d);
        this.x.setOnRadioCheckedChangeListener(this.c);
        this.w.setFuncExplainClickListener(new g());
        this.v.setFuncExplainClickListener(new h());
    }

    private void e() {
        this.f = (BNSettingNewTextRadioGroup) a(R.id.bn_rg_setting_bluetooth_setting_ly);
        this.g = (TextView) a(R.id.bn_rg_setting_bluetooth_tips_tv);
        this.h = (BNSettingNewTextRadioGroup) a(R.id.nav_view_music_volume_selector_rg);
        this.i = (TextView) a(R.id.tv_music_volume_tips);
        this.o = (Group) a(R.id.nav_float_setting_group);
        this.m = (BNSettingNewTextRadioGroup) a(R.id.nav_bg_float_setting_selector_rg);
        if (!BNCommSettingManager.getInstance().deviceSupportPipMode()) {
            this.m.setVisibility(8);
        }
        this.n = (TextView) a(R.id.nav_float_tips);
        this.p = (BNSettingExplainSwitchItem) a(R.id.nav_calling_play_layout);
        this.q = (BNSettingExplainSwitchItem) a(R.id.nav_park_layout);
        this.r = (ImageView) a(R.id.nav_float_setting_cb);
        this.s = (BNSettingExplainSwitchItem) a(R.id.nav_scenic_setting_layout);
        this.t = (BNSettingExplainSwitchItem) a(R.id.nav_power_saver_setting_layout);
        this.u = (BNSettingExplainSwitchItem) a(R.id.nav_save_parking_setting_layout);
        this.v = (BNSettingExplainSwitchItem) a(R.id.nav_hd_navi_layout);
        this.j = (RelativeLayout) a(R.id.nav_wechat_follow_calling);
        this.k = (TextView) a(R.id.nav_wechat_tips);
        this.l = (TextView) a(R.id.nav_wechat_support);
        this.w = (BNSettingExplainSwitchItem) a(R.id.nav_normal_hd_layout);
        this.x = (BNSettingNewTextRadioGroup) a(R.id.nsdk_rg_hd_map_radio_group);
        c();
        a(com.baidu.navisdk.util.common.c.b());
        f();
    }

    private void f() {
        if (!BNSettingManager.isEnteredNavingSettingPage()) {
            if (com.baidu.navisdk.j.d()) {
                this.v.setRedPointVisibleState(true);
            }
            BNSettingManager.setIsEnteredNavingSettingPage(true);
            return;
        }
        this.v.setRedPointVisibleState(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("AssistFuncGroupItemVie", "jumpToH5--> url = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putInt("h5Type", 0);
        com.baidu.navisdk.framework.b.a(15, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.k.setText(R.string.setting_wechat_tips_support);
            TextView textView = this.k;
            int i2 = R.color.nsdk_rg_setting_page_item_tip;
            com.baidu.navisdk.ui.util.b.a(textView, i2);
            this.k.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.l.setText(R.string.setting_wechat_support);
            com.baidu.navisdk.ui.util.b.a(this.l, i2);
            this.l.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.k.setText(R.string.setting_wechat_tips_nonsupport);
        TextView textView2 = this.k;
        int i3 = R.color.nsdk_ugc_txt_highlight;
        com.baidu.navisdk.ui.util.b.a(textView2, i3);
        Drawable drawable = JarUtils.getResources().getDrawable(R.drawable.bnav_bg_setting_wechat_tips);
        this.k.setCompoundDrawablePadding(JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_5dp));
        this.k.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.l.setText(R.string.setting_wechat_nonsupport);
        com.baidu.navisdk.ui.util.b.a(this.l, i3);
        Drawable drawable2 = JarUtils.getResources().getDrawable(R.drawable.nsdk_drawable_common_ic_setting_right_arrow);
        this.l.setCompoundDrawablePadding(JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_3dp));
        this.l.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable2, (Drawable) null);
    }

    @Override // com.baidu.navisdk.module.newguide.settings.g.b
    public boolean a() {
        if (this.y >= this.z) {
            return true;
        }
        return super.a();
    }
}
