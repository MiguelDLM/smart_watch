package com.baidu.navisdk.module.newguide.settings.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.j;
import com.baidu.navisdk.module.newguide.settings.g;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingExplainSwitchItem;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingNewTextRadioGroup;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class c extends g.b {
    private BNSettingExplainSwitchItem.c b;
    private BNSettingNewTextRadioGroup.a c;
    private com.baidu.navisdk.module.newguide.settings.i.a d;
    private BNSettingNewTextRadioGroup e;
    private BNSettingNewTextRadioGroup f;
    private BNSettingNewTextRadioGroup g;
    private BNSettingExplainSwitchItem h;
    public int i;
    public int j;

    /* loaded from: classes7.dex */
    public class a implements Observer<Integer> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable Integer num) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("NaviShowGroupItemVie", "GUIDE_ANGLE onChanged: " + num);
            }
            if (c.this.e != null) {
                c.this.e.a(num.intValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Observer<Integer> {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable Integer num) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("NaviShowGroupItemVie", "DAY_NIGHT_MODE onChanged: " + num);
            }
            if (c.this.f != null) {
                c.this.f.a(num.intValue());
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.newguide.settings.viewholder.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0261c implements Observer<Integer> {
        public C0261c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable Integer num) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("NaviShowGroupItemVie", "SCREEN_ORIENTATION onChanged: " + num);
            }
            if (c.this.g != null) {
                c.this.g.a(num.intValue());
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
                gVar.e("NaviShowGroupItemVie", "MAP_SCALE onChanged: " + bool);
            }
            if (c.this.h != null) {
                c.this.h.setChecked(bool.booleanValue());
            }
        }
    }

    public c(View view, BNSettingExplainSwitchItem.c cVar, BNSettingNewTextRadioGroup.a aVar, g.a aVar2, com.baidu.navisdk.module.newguide.settings.i.a aVar3) {
        super(4, view, aVar2);
        this.i = 0;
        this.j = 4;
        this.b = cVar;
        this.c = aVar;
        this.d = aVar3;
        e();
        b();
        d();
    }

    private void e() {
        this.e = (BNSettingNewTextRadioGroup) a(R.id.nsdk_rg_nav_guide_angle_radio_group);
        this.f = (BNSettingNewTextRadioGroup) a(R.id.nav_view_night_mode_selector_rg);
        this.g = (BNSettingNewTextRadioGroup) a(R.id.bn_rg_setting_screen_orientation_group);
        this.h = (BNSettingExplainSwitchItem) a(R.id.nav_scale_layout);
        if (j.c()) {
            this.e.setChildRadioContents(JarUtils.getResources().getTextArray(R.array.rg_setting_nav_guide_angle_item_auto));
        }
        c();
    }

    private void b() {
        com.baidu.navisdk.module.newguide.settings.i.a aVar = this.d;
        if (aVar != null) {
            com.baidu.navisdk.module.newguide.settings.viewmodel.a I = aVar.I();
            LifecycleOwner J = this.d.J();
            if (I == null || J == null) {
                return;
            }
            I.c(6).observe(J, new a());
            I.c(7).observe(J, new b());
            I.c(8).observe(J, new C0261c());
            I.a(9).observe(J, new d());
        }
    }

    private void c() {
        if (!com.baidu.navisdk.function.b.FUNC_ORIENTATION_CHANGE_BTN.a()) {
            a(R.id.nsdk_rg_nav_show_screen_orientation_group).setVisibility(8);
            this.i++;
        }
        if (!com.baidu.navisdk.function.b.FUNC_NAVI_ANGLE.a()) {
            a(R.id.nsdk_rg_nav_show_guide_angle_group).setVisibility(8);
            this.i++;
        }
        if (!com.baidu.navisdk.function.b.FUNC_DAY_NIGHT.a()) {
            a(R.id.nsdk_rg_nav_show_day_night_group).setVisibility(8);
            this.i++;
        }
        if (!com.baidu.navisdk.function.b.FUNC_NAVI_SCALE.a()) {
            a(R.id.nav_scale_layout).setVisibility(8);
            a(R.id.bn_rg_setting_group_show_l3).setVisibility(8);
            this.i++;
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
        this.e.setOnRadioCheckedChangeListener(this.c);
        this.f.setOnRadioCheckedChangeListener(this.c);
        if (com.baidu.navisdk.function.b.FUNC_ORIENTATION_CHANGE_BTN.a()) {
            this.g.setOnRadioCheckedChangeListener(this.c);
        }
        this.h.setOnCheckedListener(this.b);
    }

    @Override // com.baidu.navisdk.module.newguide.settings.g.b
    public boolean a() {
        if (this.i >= this.j) {
            return true;
        }
        return super.a();
    }
}
