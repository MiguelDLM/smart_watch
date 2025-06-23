package com.baidu.navisdk.module.newguide.settings.viewholder;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.newguide.settings.g;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingExplainImageItem;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingExplainSelectItem;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingNewTextRadioGroup;

/* loaded from: classes7.dex */
public class d extends g.b {
    private View.OnClickListener b;
    private BNSettingNewTextRadioGroup.a c;
    private com.baidu.navisdk.module.newguide.settings.i.a d;
    private BNSettingNewTextRadioGroup e;
    private BNSettingExplainSelectItem f;
    private BNSettingExplainImageItem g;
    public int h;
    public int i;

    /* loaded from: classes7.dex */
    public class a implements Observer<Integer> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable Integer num) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("NaviVoiceGroupItemVie", "onChanged GUIDE_PLAY: " + num);
            }
            if (d.this.e != null) {
                d.this.e.a(num.intValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Observer<String> {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("NaviVoiceGroupItemVie", "onChanged DIY_PLAY_VOICE: " + str);
            }
            if (d.this.f != null) {
                d.this.f.a(Html.fromHtml(str));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Observer<com.baidu.navisdk.module.newguide.settings.model.d> {
        public c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.baidu.navisdk.module.newguide.settings.model.d dVar) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("NaviVoiceGroupItemVie", "onChanged super voice: " + dVar);
            }
            if (d.this.g != null && dVar != null) {
                d.this.g.setTitle2(dVar.f7277a);
                if (!TextUtils.isEmpty(dVar.b)) {
                    d.this.g.setTipImage(dVar.b);
                } else {
                    d.this.g.setTipImage(dVar.c);
                }
            }
        }
    }

    public d(View view, View.OnClickListener onClickListener, BNSettingNewTextRadioGroup.a aVar, g.a aVar2, com.baidu.navisdk.module.newguide.settings.i.a aVar3) {
        super(3, view, aVar2);
        this.h = 0;
        this.i = 3;
        this.b = onClickListener;
        this.c = aVar;
        this.d = aVar3;
        e();
        b();
        d();
    }

    private void d() {
        this.e.setOnRadioCheckedChangeListener(this.c);
        if (com.baidu.navisdk.function.b.FUNC_DIY_SPEAK.a()) {
            this.f.setOnClickListener(this.b);
        }
        if (com.baidu.navisdk.function.b.FUNC_STAR_VOICE.a()) {
            this.g.setOnClickListener(this.b);
        }
    }

    private void e() {
        this.e = (BNSettingNewTextRadioGroup) a(R.id.nav_view_voice_selector_rg);
        this.f = (BNSettingExplainSelectItem) a(R.id.bnav_rg_menu_broadcast_content_select_layout);
        this.g = (BNSettingExplainImageItem) a(R.id.bn_rg_menu_cur_super_voice_layout);
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
            I.c(10).observe(J, new a());
            I.d(11).observe(J, new b());
            I.g().observe(J, new c());
        }
    }

    private void c() {
        this.h = 0;
        if (!com.baidu.navisdk.function.b.FUNC_VOICE_SELECTOR.a()) {
            a(R.id.voice_selector_group).setVisibility(8);
            this.h++;
        }
        if (!com.baidu.navisdk.function.b.FUNC_DIY_SPEAK.a()) {
            a(R.id.broadcast_content_select_group).setVisibility(8);
            this.h++;
        }
        if (!com.baidu.navisdk.function.b.FUNC_STAR_VOICE.a()) {
            this.g.setVisibility(8);
            a(R.id.bn_rg_setting_group_voice_l2).setVisibility(8);
            this.h++;
        }
        if (a()) {
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = 0;
            }
            this.itemView.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.settings.g.b
    public boolean a() {
        if (this.h >= this.i) {
            return true;
        }
        return super.a();
    }
}
