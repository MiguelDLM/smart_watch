package com.baidu.navisdk.ui.routeguide.module.diyspeak;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.widget.EmptyTopLayout;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class l implements com.baidu.navisdk.framework.interfaces.diyspeak.c, View.OnClickListener, com.baidu.navisdk.ui.routeguide.module.diyspeak.c {

    /* renamed from: a, reason: collision with root package name */
    RadioGroup f9018a = null;
    ExpandableListView b = null;
    com.baidu.navisdk.ui.routeguide.module.diyspeak.b c = null;
    TextView d = null;
    ImageView e = null;
    private Activity f = null;
    private i g = null;
    private long h = 0;
    private boolean i = false;
    private boolean j = false;
    private a.InterfaceC0201a k = new d();

    /* loaded from: classes8.dex */
    public class a implements RadioGroup.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            l.this.a(radioGroup, i);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ExpandableListView.OnGroupClickListener {
        public b(l lVar) {
        }

        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ExpandableListView.OnGroupExpandListener {
        public c(l lVar) {
        }

        @Override // android.widget.ExpandableListView.OnGroupExpandListener
        public void onGroupExpand(int i) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("z.1", "" + i, null, null);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements a.InterfaceC0201a {
        public d() {
        }

        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(Object obj) {
            if (obj instanceof m) {
                int i = ((m) obj).f9021a;
                if (i < 100) {
                    BNSettingManager.setDiyVoiceSwitchGuideShow();
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("DiySpeak", "score is low");
                    }
                } else if (SystemClock.elapsedRealtime() - l.this.h < 1000) {
                    l.this.c(i);
                } else if (LogUtil.LOGGABLE) {
                    LogUtil.e("DiySpeak", "showSwitchGuide time out");
                }
                l.this.a(i);
            }
        }
    }

    private void c() {
        e eVar = e.f;
        f a2 = eVar.a();
        if (eVar.e()) {
            a2.d = JNIGuidanceControl.getInstance().getVoiceModeValue(1);
            a2.c = JNIGuidanceControl.getInstance().getVoiceModeValue(0);
            a2.e = JNIGuidanceControl.getInstance().getVoiceModeValue(7);
            a2.g = JNIGuidanceControl.getInstance().getVoiceModeBitCount();
            a2.a();
            if (BNSettingManager.containsKey(SettingParams.Key.NAVI_DIY_CUSTOM_MODE_VALUE)) {
                a2.f = BNSettingManager.getDiyCustomModeValue();
            } else {
                a2.f = a2.c;
            }
        }
        int a3 = eVar.a(true);
        if (a3 == 0) {
            this.f9018a.check(R.id.nav_diy_voice_standard_rb);
            com.baidu.navisdk.ui.routeguide.module.diyspeak.b bVar = this.c;
            if (bVar != null) {
                bVar.a(a2.c);
            }
        } else if (a3 == 1) {
            this.f9018a.check(R.id.nav_diy_voice_simple_rb);
            com.baidu.navisdk.ui.routeguide.module.diyspeak.b bVar2 = this.c;
            if (bVar2 != null) {
                bVar2.a(a2.d);
            }
        } else if (a3 == 6) {
            this.f9018a.check(R.id.nav_diy_voice_custom_rb);
            com.baidu.navisdk.ui.routeguide.module.diyspeak.b bVar3 = this.c;
            if (bVar3 != null) {
                bVar3.a(a2.f);
            }
        } else if (a3 == 7) {
            this.f9018a.check(R.id.nav_diy_voice_detail_rb);
            com.baidu.navisdk.ui.routeguide.module.diyspeak.b bVar4 = this.c;
            if (bVar4 != null) {
                bVar4.a(a2.e);
            }
        }
        if (eVar.e()) {
            b(a3);
        }
        g();
    }

    private void d() {
        this.f9018a.setOnCheckedChangeListener(new a());
        ExpandableListView expandableListView = this.b;
        if (expandableListView != null) {
            expandableListView.setOnGroupClickListener(new b(this));
            this.b.setOnGroupExpandListener(new c(this));
        }
        com.baidu.navisdk.ui.routeguide.module.diyspeak.b bVar = this.c;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    private void e() {
        e eVar = e.f;
        f a2 = eVar.a();
        long a3 = this.c.a();
        a2.f = a3;
        BNSettingManager.setDiyCustomModeValue(a3);
        h();
        if (eVar.c() != 6) {
            BNSettingManager.setDiyVoiceMode(6);
            this.f9018a.check(R.id.nav_diy_voice_custom_rb);
        }
    }

    private void f() {
        Drawable drawable;
        ImageView imageView = this.e;
        if (imageView != null) {
            if (BNCommSettingManager.getInstance().isDiySpeakAutoChangeInMusic()) {
                drawable = JarUtils.getResources().getDrawable(R.drawable.nsdk_set_checkin_icon);
            } else {
                drawable = JarUtils.getResources().getDrawable(R.drawable.nsdk_set_checkout_icon);
            }
            imageView.setImageDrawable(drawable);
        }
    }

    private void g() {
        e eVar = e.f;
        if (!eVar.e()) {
            return;
        }
        f a2 = eVar.a();
        if (!BNSettingManager.isDiyVoiceSwitchGuideHasShowed()) {
            com.baidu.navisdk.framework.message.a.a().a(this.k, m.class, new Class[0]);
            com.baidu.navisdk.framework.message.a.a().a(new m(a2.h), 200);
        }
    }

    private void h() {
        int voiceMode = BNSettingManager.getVoiceMode();
        if (voiceMode == 3) {
            e.f.b(voiceMode);
            return;
        }
        if (voiceMode == 2) {
            e.f.b(voiceMode);
            return;
        }
        e eVar = e.f;
        int c2 = eVar.c();
        if (c2 == 6) {
            eVar.a(c2, BNSettingManager.getDiyCustomModeValue());
        } else {
            eVar.b(c2);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void a(Context context, Bundle bundle) {
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        int id = view.getId();
        if (id == R.id.left_imageview) {
            com.baidu.navisdk.framework.message.a.a().d(new com.baidu.navisdk.framework.message.bean.g("com.baidu.navisdk.BNDiySpeakView", 0));
            return;
        }
        if (id == R.id.nsdk_diy_speak_music_auto_change_img) {
            BNCommSettingManager.getInstance().setDiySpeakMusicAidCount(2);
            boolean isDiySpeakAutoChangeInMusic = BNCommSettingManager.getInstance().isDiySpeakAutoChangeInMusic();
            BNCommSettingManager.getInstance().setDiySpeakAutoChangeInMusic(!isDiySpeakAutoChangeInMusic);
            if (!isDiySpeakAutoChangeInMusic && com.baidu.navisdk.function.b.FUNC_DIY_SPEAK_MUSIC_MONITOR.a()) {
                e.f.b().c();
            } else {
                e.f.b().d();
            }
            com.baidu.navisdk.util.statistic.userop.b r = com.baidu.navisdk.util.statistic.userop.b.r();
            String str2 = "";
            if (!isDiySpeakAutoChangeInMusic) {
                str = "";
            } else {
                str = null;
            }
            if (!isDiySpeakAutoChangeInMusic) {
                str2 = null;
            }
            r.a("3.i.3", str, str2, null);
            f();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onDestroy() {
        com.baidu.navisdk.module.asr.a.b().a(true);
        com.baidu.navisdk.framework.message.a.a().a(this.k);
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onPause() {
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onResume() {
        this.h = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onStart() {
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onStop() {
        i iVar = this.g;
        if (iVar != null && iVar.isShowing()) {
            this.g.dismiss();
        }
        this.g = null;
    }

    private void b(int i) {
        String h;
        this.b.setVisibility(0);
        if (i == 0) {
            h = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_diy_speak_items_standard_tips);
        } else if (i == 1) {
            h = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_diy_speak_items_simple_tips);
        } else if (i == 6) {
            h = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_diy_speak_items_user_define_tips);
        } else if (i != 7) {
            h = "";
        } else {
            h = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_diy_speak_items_detail_tips);
            this.b.setVisibility(8);
        }
        this.d.setText(h);
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public View a(Activity activity, Bundle bundle, View view) {
        this.f = activity;
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout.setOnClickListener(this);
        EmptyTopLayout emptyTopLayout = new EmptyTopLayout(activity);
        emptyTopLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(emptyTopLayout);
        View inflate = JarUtils.inflate(activity, R.layout.nsdk_layout_diy_speak_mode_switch, null);
        inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        inflate.findViewById(R.id.left_imageview).setOnClickListener(this);
        this.f9018a = (RadioGroup) inflate.findViewById(R.id.nav_view_voice_selector_rg);
        e eVar = e.f;
        if (!eVar.e()) {
            this.f9018a.findViewById(R.id.nav_diy_voice_detail_rb).setVisibility(8);
            this.f9018a.findViewById(R.id.nav_diy_voice_custom_rb).setVisibility(8);
            RadioButton radioButton = (RadioButton) this.f9018a.findViewById(R.id.nav_diy_voice_standard_rb);
            radioButton.setBackgroundResource(R.drawable.bnav_selector_diy_speak_radio_group);
            radioButton.setText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_diy_speak_items_detail));
            ((ViewGroup.MarginLayoutParams) radioButton.getLayoutParams()).rightMargin = 0;
        }
        linearLayout.addView(inflate);
        int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_more_setting_menu_item_padding_left);
        if (eVar.e()) {
            this.d = new TextView(activity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = dimensionPixelOffset;
            layoutParams.rightMargin = dimensionPixelOffset;
            layoutParams.bottomMargin = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_8dp);
            this.d.setLayoutParams(layoutParams);
            this.d.setGravity(16);
            this.d.setTextColor(JarUtils.getResources().getColor(R.color.nsdk_cl_text_f));
            this.d.setTextSize(0, com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_12dp));
            linearLayout.addView(this.d);
            View view2 = new View(activity);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
            layoutParams2.leftMargin = dimensionPixelOffset;
            layoutParams2.rightMargin = dimensionPixelOffset;
            view2.setLayoutParams(layoutParams2);
            view2.setBackgroundColor(Color.parseColor("#dddddd"));
            linearLayout.addView(view2);
            this.b = new ExpandableListView(activity);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.leftMargin = dimensionPixelOffset;
            layoutParams3.rightMargin = dimensionPixelOffset;
            this.b.setLayoutParams(layoutParams3);
            ExpandableListView expandableListView = this.b;
            Resources resources = JarUtils.getResources();
            int i = R.drawable.nsdk_drawable_divider_group;
            expandableListView.setDivider(resources.getDrawable(i));
            this.b.setChildDivider(JarUtils.getResources().getDrawable(i));
            this.b.setDividerHeight(1);
            this.b.setSelector(R.drawable.transparent);
            this.b.setGroupIndicator(null);
            com.baidu.navisdk.ui.routeguide.module.diyspeak.b bVar = new com.baidu.navisdk.ui.routeguide.module.diyspeak.b(activity.getApplicationContext());
            this.c = bVar;
            this.b.setAdapter(bVar);
            if (eVar.a().f9003a == null) {
                eVar.a().b();
            }
            this.c.a(eVar.a().f9003a);
            linearLayout.addView(this.b);
            View view3 = new View(activity);
            view3.setBackgroundDrawable(JarUtils.getResources().getDrawable(i));
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 1);
            layoutParams4.leftMargin = dimensionPixelOffset;
            layoutParams4.rightMargin = dimensionPixelOffset;
            view3.setLayoutParams(layoutParams4);
            linearLayout.addView(view3);
        }
        View inflate2 = JarUtils.inflate(activity, R.layout.nsdk_layout_diy_speak_mode_short_mode_switch, null);
        ImageView imageView = (ImageView) inflate2.findViewById(R.id.nsdk_diy_speak_music_auto_change_img);
        this.e = imageView;
        imageView.setOnClickListener(this);
        f();
        if (eVar.e()) {
            inflate2.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ExpandableListView expandableListView2 = this.b;
            if (expandableListView2 != null) {
                expandableListView2.addFooterView(inflate2);
            }
        } else {
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams5.leftMargin = dimensionPixelOffset;
            layoutParams5.rightMargin = dimensionPixelOffset;
            inflate2.setLayoutParams(layoutParams5);
            linearLayout.addView(inflate2);
        }
        c();
        d();
        com.baidu.navisdk.module.asr.a.b().a(false);
        return linearLayout;
    }

    @Override // com.baidu.navisdk.ui.routeguide.module.diyspeak.c
    public void b() {
        this.i = true;
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        String h;
        if (BNSettingManager.isDiyVoiceSwitchGuideHasShowed() || this.i) {
            return;
        }
        com.baidu.navisdk.ui.routeguide.module.diyspeak.a aVar = new com.baidu.navisdk.ui.routeguide.module.diyspeak.a(this.f);
        if (i >= 400) {
            h = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_diy_speak_items_veteran_guide);
            aVar.a(this.f9018a.findViewById(R.id.nav_diy_voice_simple_rb));
        } else if (i > 200) {
            h = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_diy_speak_items_common_guide);
            aVar.a(this.f9018a.findViewById(R.id.nav_diy_voice_custom_rb));
        } else {
            h = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_diy_speak_items_novice_guide);
            aVar.a(this.f9018a.findViewById(R.id.nav_diy_voice_detail_rb));
        }
        aVar.a(h);
        aVar.show();
        BNSettingManager.setDiyVoiceSwitchGuideShow();
    }

    @Override // com.baidu.navisdk.ui.routeguide.module.diyspeak.c
    public void a() {
        this.i = true;
        e();
    }

    @Override // com.baidu.navisdk.ui.routeguide.module.diyspeak.c
    public void a(String str) {
        this.i = true;
        i iVar = new i(this.f);
        this.g = iVar;
        iVar.a(str);
        this.g.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RadioGroup radioGroup, int i) {
        this.i = true;
        e eVar = e.f;
        f a2 = eVar.a();
        if (i == R.id.nav_diy_voice_simple_rb) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("z.0", "0", null, null);
            BNSettingManager.setDiyVoiceMode(1);
            h();
            com.baidu.navisdk.ui.routeguide.module.diyspeak.b bVar = this.c;
            if (bVar != null) {
                bVar.a(a2.d);
            }
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_voice_diy_mode_simple"));
        } else if (i == R.id.nav_diy_voice_standard_rb) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("z.0", "1", null, null);
            BNSettingManager.setDiyVoiceMode(0);
            h();
            com.baidu.navisdk.ui.routeguide.module.diyspeak.b bVar2 = this.c;
            if (bVar2 != null) {
                bVar2.a(a2.c);
            }
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_voice_diy_mode_standard"));
        } else if (i == R.id.nav_diy_voice_detail_rb) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("z.0", "2", null, null);
            BNSettingManager.setDiyVoiceMode(7);
            h();
            com.baidu.navisdk.ui.routeguide.module.diyspeak.b bVar3 = this.c;
            if (bVar3 != null) {
                bVar3.a(a2.e);
            }
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_voice_diy_mode_detail"));
        } else if (i == R.id.nav_diy_voice_custom_rb) {
            this.j = true;
            com.baidu.navisdk.util.statistic.userop.b.r().a("z.0", "3", null, null);
            BNSettingManager.setDiyVoiceMode(6);
            h();
            com.baidu.navisdk.ui.routeguide.module.diyspeak.b bVar4 = this.c;
            if (bVar4 != null) {
                bVar4.a(a2.f);
            }
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_voice_diy_mode_custom"));
        } else if (LogUtil.LOGGABLE) {
            LogUtil.e("DiySpeak", "error ");
        }
        if (eVar.e()) {
            b(eVar.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.j || BNSettingManager.containsKey(SettingParams.Key.NAVI_DIY_CUSTOM_MODE_VALUE)) {
            return;
        }
        f a2 = e.f.a();
        if (i >= 400) {
            a2.f = a2.d;
        } else if (i > 200) {
            a2.f = a2.c;
        } else {
            a2.f = a2.c;
        }
        BNSettingManager.setDiyCustomModeValue(a2.f);
    }
}
