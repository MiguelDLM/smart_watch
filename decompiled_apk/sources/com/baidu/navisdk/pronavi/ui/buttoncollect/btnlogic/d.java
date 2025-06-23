package com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.view.View;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import kotlin.Triple;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class d extends com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a {

    @OOXIXo
    public static final a b = new a(null);

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        @OOXIXo
        public final Triple<Integer, Integer, Integer> a(int i, boolean z) {
            return a(i, -1, z);
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ Triple a(a aVar, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                z = false;
            }
            return aVar.a(i, i2, z);
        }

        @OOXIXo
        public final Triple<Integer, Integer, Integer> a(int i, int i2, boolean z) {
            if (i == 2) {
                if (i2 != i && !z) {
                    return new Triple<>(Integer.valueOf(R.drawable.nsdk_drawable_rg_cp_voice_quiet_off), Integer.valueOf(R.string.nsdk_voice_mode_quiet_new), Integer.valueOf(R.color.nsdk_cl_text_h));
                }
                return new Triple<>(Integer.valueOf(R.drawable.nsdk_drawable_rg_cp_voice_quiet_red), Integer.valueOf(R.string.nsdk_voice_mode_quiet_new), Integer.valueOf(R.color.bnav_rg_navi_play_quite_color));
            }
            if (i != 3) {
                if (i == i2) {
                    return new Triple<>(Integer.valueOf(R.drawable.nsdk_drawable_rg_cp_voice_open_on), Integer.valueOf(R.string.nsdk_voice_mode_play_new), Integer.valueOf(R.color.nsdk_cl_text_g));
                }
                return new Triple<>(Integer.valueOf(R.drawable.nsdk_drawable_rg_cp_voice_open_off), Integer.valueOf(R.string.nsdk_voice_mode_play_new), Integer.valueOf(R.color.nsdk_cl_text_h));
            }
            if (i2 == i) {
                return new Triple<>(Integer.valueOf(R.drawable.nsdk_drawable_rg_cp_voice_warning_on), Integer.valueOf(R.string.nsdk_voice_mode_warning), Integer.valueOf(R.color.nsdk_cl_text_g));
            }
            return new Triple<>(Integer.valueOf(R.drawable.nsdk_drawable_rg_cp_voice_warning_off), Integer.valueOf(R.string.nsdk_voice_mode_warning), Integer.valueOf(R.color.nsdk_cl_text_h));
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i.a
    public boolean a(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b uiContext, @OOXIXo View view, @oOoXoXO Object obj) {
        int i;
        IIX0o.x0xO0oo(uiContext, "uiContext");
        IIX0o.x0xO0oo(view, "view");
        if (com.baidu.navisdk.ui.util.f.a("rgOnClickNaviPlay")) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGFullBtnLogic", "RGNaviPlayBtnLogic.onClick() -> fast click, return!!!");
            }
            return false;
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b) uiContext.c(com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b.class);
        com.baidu.navisdk.framework.lifecycle.b<Integer> f = bVar != null ? bVar.f() : null;
        if (f == null) {
            return true;
        }
        Integer value = f.getValue();
        if (value != null && value.intValue() == 0) {
            i = 8;
        } else {
            i = 0;
        }
        f.setValue(i);
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a
    public void g() {
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i.b
    public boolean a(@oOoXoXO com.baidu.navisdk.pronavi.ui.base.b bVar) {
        if (bVar == null || !bVar.C()) {
            return BNSettingManager.isVoiceButtonVisible();
        }
        return false;
    }
}
