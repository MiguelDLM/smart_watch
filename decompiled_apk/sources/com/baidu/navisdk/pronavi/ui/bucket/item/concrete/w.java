package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.widget.RGImageTextBtn;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class w extends com.baidu.navisdk.pronavi.ui.bucket.item.a implements View.OnClickListener {
    private RGImageTextBtn f;
    private View g;
    private RGImageTextBtn h;
    private RGImageTextBtn i;
    private RGImageTextBtn j;
    private com.baidu.navisdk.pronavi.style.i.a k;
    private com.baidu.navisdk.pronavi.style.i.a l;
    protected com.baidu.navisdk.pronavi.style.view.a m;
    protected com.baidu.navisdk.pronavi.style.view.a n;
    protected com.baidu.navisdk.pronavi.style.view.a o;
    protected com.baidu.navisdk.pronavi.style.view.a p;

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.pronavi.style.c {
        public a(Integer... numArr) {
            super(numArr);
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        @OOXIXo
        public String a() {
            return "RGBucketItem" + w.this.getId() + HelpFormatter.DEFAULT_OPT_PREFIX + ((com.baidu.navisdk.pronavi.ui.bucket.item.a) w.this).c;
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void b(String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(w.this.d(), "useDefaultStyle: ");
            }
            if (TextUtils.isEmpty(str) || str.equals("CurVoicePlayMode")) {
                w.this.B();
                w.this.A();
            }
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void c() {
            if (w.this.f != null) {
                a(w.this.f);
                a(w.this.f.text);
                w wVar = w.this;
                if (wVar.m == null) {
                    wVar.m = new com.baidu.navisdk.pronavi.style.view.a();
                }
                w wVar2 = w.this;
                wVar2.m.setImageView(wVar2.f.icon);
                w wVar3 = w.this;
                wVar3.m.setStrTextView(wVar3.f.text);
                a("CurVoicePlayMode", (String) w.this.m);
            }
        }

        @Override // com.baidu.navisdk.pronavi.style.c
        @oOoXoXO
        public String d(@oOoXoXO String str) {
            if ("CurVoicePlayMode".equals(str)) {
                int voiceMode = BNCommSettingManager.getInstance().getVoiceMode();
                if (voiceMode != 0 && voiceMode != 1) {
                    if (voiceMode != 2) {
                        if (voiceMode != 3) {
                            return str;
                        }
                        return "CurJustWarning";
                    }
                    return "CurVoiceQuiet";
                }
                return "CurVoicePlay";
            }
            return str;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.pronavi.style.c {
        public b(Integer... numArr) {
            super(numArr);
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        @OOXIXo
        public String a() {
            return "RGBucketItem" + w.this.getId() + "panel-" + ((com.baidu.navisdk.pronavi.ui.bucket.item.a) w.this).c;
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void b(String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(w.this.d(), "registerVoiceSettingPanelStyleChangeHelper useDefaultStyle: ");
            }
            w.this.z();
            w.this.y();
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void c() {
            if (w.this.h != null && w.this.j != null && w.this.i != null) {
                w wVar = w.this;
                if (wVar.n == null) {
                    wVar.n = new com.baidu.navisdk.pronavi.style.view.a();
                }
                w wVar2 = w.this;
                wVar2.n.setBgView(wVar2.h);
                w wVar3 = w.this;
                wVar3.n.setImageView(wVar3.h.icon);
                w wVar4 = w.this;
                wVar4.n.setColorTextView(wVar4.h.text);
                a("VoiceModePanelWarn", (String) w.this.n);
                w wVar5 = w.this;
                if (wVar5.o == null) {
                    wVar5.o = new com.baidu.navisdk.pronavi.style.view.a();
                }
                w wVar6 = w.this;
                wVar6.o.setBgView(wVar6.i);
                w wVar7 = w.this;
                wVar7.o.setImageView(wVar7.i.icon);
                w wVar8 = w.this;
                wVar8.o.setColorTextView(wVar8.i.text);
                a("VoiceModePanelQuiet", (String) w.this.o);
                w wVar9 = w.this;
                if (wVar9.p == null) {
                    wVar9.p = new com.baidu.navisdk.pronavi.style.view.a();
                }
                w wVar10 = w.this;
                wVar10.p.setBgView(wVar10.j);
                w wVar11 = w.this;
                wVar11.p.setImageView(wVar11.j.icon);
                w wVar12 = w.this;
                wVar12.p.setColorTextView(wVar12.j.text);
                a("VoiceModePanelPlay", (String) w.this.p);
            }
        }

        @Override // com.baidu.navisdk.pronavi.style.c
        @oOoXoXO
        public String d(@oOoXoXO String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int voiceMode = BNCommSettingManager.getInstance().getVoiceMode();
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -189273531:
                    if (str.equals("VoiceModePanelQuiet")) {
                        c = 0;
                        break;
                    }
                    break;
                case 548045059:
                    if (str.equals("VoiceModePanelPlay")) {
                        c = 1;
                        break;
                    }
                    break;
                case 548243541:
                    if (str.equals("VoiceModePanelWarn")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (voiceMode == 2) {
                        return "VoiceModePanelQuietOn";
                    }
                    return "VoiceModePanelQuietOff";
                case 1:
                    if (voiceMode != 0 && voiceMode != 1) {
                        return "VoiceModePanelPlayOff";
                    }
                    return "VoiceModePanelPlayOn";
                case 2:
                    if (voiceMode == 3) {
                        return "VoiceModePanelWarnOn";
                    }
                    return "VoiceModePanelWarnOff";
                default:
                    return str;
            }
        }
    }

    public w(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        RGImageTextBtn rGImageTextBtn = this.f;
        if (rGImageTextBtn != null) {
            rGImageTextBtn.setBg(R.drawable.nsdk_rg_selector_common_control_btn_bg);
            this.f.setTextColor(R.color.nsdk_cl_text_h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (this.f != null) {
            int voiceMode = BNCommSettingManager.getInstance().getVoiceMode();
            if (voiceMode != 0 && voiceMode != 1) {
                if (voiceMode != 2) {
                    if (voiceMode == 3) {
                        this.f.setIcon(R.drawable.nsdk_drawable_rg_cp_voice_warning_off);
                        this.f.setTextContent(R.string.nsdk_voice_mode_warning);
                        return;
                    }
                    return;
                }
                this.f.setIcon(R.drawable.nsdk_drawable_rg_cp_voice_quiet_off);
                this.f.setTextContent(R.string.nsdk_voice_mode_quiet);
                return;
            }
            this.f.setIcon(R.drawable.nsdk_drawable_rg_cp_voice_open_off);
            this.f.setTextContent(R.string.nsdk_voice_mode_play);
        }
    }

    private void C() {
        if (!BNSettingManager.isVoiceButtonVisible()) {
            return;
        }
        this.f.setVisibility(8);
        D();
        this.g.setVisibility(0);
        com.baidu.navisdk.ui.routeguide.control.x.b().a(0L);
        com.baidu.navisdk.ui.routeguide.control.x.b().C0 = true;
    }

    private void D() {
        com.baidu.navisdk.pronavi.style.i.a aVar = this.l;
        if (aVar != null) {
            aVar.a("VoicePlayModePanel");
        } else {
            z();
        }
    }

    private void w() {
        String str;
        int voiceMode = BNCommSettingManager.getInstance().getVoiceMode();
        int i = 2;
        if (voiceMode == 2) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.7.2", "0", null, "3");
            str = "asr_e_c_voice_mode_play";
            i = 0;
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.7.2", "1", null, "3");
            str = "asr_e_c_voice_mode_quiet";
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("VoiceModeBtn", "fastSwitchVoicePlay currentVoiceMode: " + voiceMode + ", setMode:" + i);
        }
        com.baidu.navisdk.ui.routeguide.subview.a w = this.f7853a.w();
        if (w != null) {
            w.a(6, 0, i, null);
            b(true);
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b(str));
        }
    }

    private void x() {
        com.baidu.navisdk.pronavi.style.i.a aVar = this.k;
        if (aVar != null) {
            aVar.a("CurVoicePlayMode");
        } else {
            B();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        RGImageTextBtn rGImageTextBtn = this.j;
        if (rGImageTextBtn != null && this.i != null && this.h != null) {
            rGImageTextBtn.setBg(R.drawable.nsdk_rg_cp_voice_right_btn_bg);
            this.i.setBg(R.drawable.nsdk_rg_cp_voice_middle_btn_bg);
            this.h.setBg(R.drawable.nsdk_rg_cp_voice_left_btn_bg);
        } else {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("VoiceModeBtn", "setPanelVoiceItemBgDefaultStyle-> view == null!!");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.j != null && this.i != null && this.h != null) {
            int voiceMode = BNCommSettingManager.getInstance().getVoiceMode();
            if (voiceMode != 0 && voiceMode != 1) {
                if (voiceMode != 2) {
                    if (voiceMode == 3) {
                        this.h.setIcon(R.drawable.nsdk_drawable_rg_cp_voice_warning_on);
                        this.h.setTextColor(R.color.nsdk_cl_text_g);
                        this.i.setIcon(R.drawable.nsdk_drawable_rg_cp_voice_quiet_off);
                        RGImageTextBtn rGImageTextBtn = this.i;
                        int i = R.color.nsdk_cl_text_h;
                        rGImageTextBtn.setTextColor(i);
                        this.j.setIcon(R.drawable.nsdk_drawable_rg_cp_voice_open_off);
                        this.j.setTextColor(i);
                        return;
                    }
                    return;
                }
                this.h.setIcon(R.drawable.nsdk_drawable_rg_cp_voice_warning_off);
                RGImageTextBtn rGImageTextBtn2 = this.h;
                int i2 = R.color.nsdk_cl_text_h;
                rGImageTextBtn2.setTextColor(i2);
                this.i.setIcon(R.drawable.nsdk_drawable_rg_cp_voice_quiet_on);
                this.i.setTextColor(R.color.nsdk_cl_text_g);
                this.j.setIcon(R.drawable.nsdk_drawable_rg_cp_voice_open_off);
                this.j.setTextColor(i2);
                return;
            }
            this.h.setIcon(R.drawable.nsdk_drawable_rg_cp_voice_warning_off);
            RGImageTextBtn rGImageTextBtn3 = this.h;
            int i3 = R.color.nsdk_cl_text_h;
            rGImageTextBtn3.setTextColor(i3);
            this.i.setIcon(R.drawable.nsdk_drawable_rg_cp_voice_quiet_off);
            this.i.setTextColor(i3);
            this.j.setIcon(R.drawable.nsdk_drawable_rg_cp_voice_open_on);
            this.j.setTextColor(R.color.nsdk_cl_text_g);
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("VoiceModeBtn", "setPanelVoiceItemDefaultStyle-> view == null!!");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.bnav_rg_cp_voice_mode_btn) {
            if (com.baidu.navisdk.function.b.FUNC_VOICE_PLAYER_BTN_FAST_SWITCH.a()) {
                w();
                return;
            } else {
                com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.7.1");
                C();
                return;
            }
        }
        if (id == R.id.bnav_rg_cp_voice_play_warning) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.7.2", "2", null, "3");
            com.baidu.navisdk.ui.routeguide.subview.a w = this.f7853a.w();
            if (w != null) {
                w.a(6, 0, 3, null);
                b(true);
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_voice_mode_justwarning"));
                return;
            }
            return;
        }
        if (id == R.id.bnav_rg_cp_voice_quiet) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.7.2", "1", null, "3");
            com.baidu.navisdk.ui.routeguide.subview.a w2 = this.f7853a.w();
            if (w2 != null) {
                w2.a(6, 0, 2, null);
                b(true);
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_voice_mode_quiet"));
                return;
            }
            return;
        }
        if (id == R.id.bnav_rg_cp_voice_open) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.7.2", "0", null, "3");
            com.baidu.navisdk.ui.routeguide.subview.a w3 = this.f7853a.w();
            if (w3 != null) {
                w3.a(6, 0, 0, null);
                b(true);
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_voice_mode_play"));
            }
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onDestroy() {
        super.onDestroy();
        this.m = null;
        this.p = null;
        this.o = null;
        this.n = null;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onRefreshViewStyle(int i) {
        super.onRefreshViewStyle(i);
        RGImageTextBtn rGImageTextBtn = this.f;
        if (rGImageTextBtn != null) {
            rGImageTextBtn.a(i);
        }
        RGImageTextBtn rGImageTextBtn2 = this.h;
        if (rGImageTextBtn2 != null) {
            rGImageTextBtn2.a(i);
        }
        RGImageTextBtn rGImageTextBtn3 = this.i;
        if (rGImageTextBtn3 != null) {
            rGImageTextBtn3.a(i);
        }
        RGImageTextBtn rGImageTextBtn4 = this.j;
        if (rGImageTextBtn4 != null) {
            rGImageTextBtn4.a(i);
        }
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onVisibleChange(int i) {
        super.onVisibleChange(i);
        if (i == 8) {
            b(false);
        } else if (i == 0) {
            x();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.SimpleGuide, RGFSMTable.FsmState.EnlargeRoadmap, RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.NaviReady, RGFSMTable.FsmState.NearbySearch, RGFSMTable.FsmState.DynamicLayer, RGFSMTable.FsmState.ArriveDest};
    }

    public void v() {
        View view = this.g;
        if (view != null && view.getVisibility() == 0) {
            b(false);
        }
    }

    private void b(boolean z) {
        View view = this.g;
        if (view != null) {
            view.setVisibility(8);
        }
        RGImageTextBtn rGImageTextBtn = this.f;
        if (rGImageTextBtn != null) {
            rGImageTextBtn.setVisibility(0);
        }
        if (z) {
            x();
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().C0 = false;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public View a(@NonNull ViewGroup viewGroup, int i, @NonNull Context context) {
        View a2 = com.baidu.navisdk.ui.util.b.a(context, R.layout.nsdk_layout_rg_voice_play_mode, viewGroup, false);
        this.f = (RGImageTextBtn) a2.findViewById(R.id.bnav_rg_cp_voice_mode_btn);
        this.g = a2.findViewById(R.id.bnav_rg_cp_voice_mode_panel);
        this.h = (RGImageTextBtn) a2.findViewById(R.id.bnav_rg_cp_voice_play_warning);
        this.i = (RGImageTextBtn) a2.findViewById(R.id.bnav_rg_cp_voice_quiet);
        this.j = (RGImageTextBtn) a2.findViewById(R.id.bnav_rg_cp_voice_open);
        this.f.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        b(true);
        onRefreshViewStyle(i);
        t();
        b(1);
        return a2;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        return (BNSettingManager.isVoiceButtonVisible() && !this.f7853a.N()) ? 0 : 8;
    }

    private void b(Integer... numArr) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(d(), "registerVoiceSettingPanelStyleChangeHelper: " + Arrays.toString(numArr));
        }
        if (this.l == null) {
            this.l = new b(numArr);
        }
        com.baidu.navisdk.pronavi.style.f.b.a("VoicePlayModePanel", this.l);
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public void a(boolean z) {
        super.a(z);
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean a(Integer... numArr) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(d(), "registerStyleChangeHelper: " + Arrays.toString(numArr));
        }
        if (this.k == null) {
            this.k = new a(numArr);
        }
        com.baidu.navisdk.pronavi.style.f.b.a(this.k, "RGCommonWidget", "CurVoicePlayMode");
        return true;
    }
}
