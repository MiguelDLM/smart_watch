package com.baidu.navisdk.pronavi.logic.service.voice;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import android.content.Context;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pageframe.logic.BNLogicService;
import com.baidu.navisdk.pronavi.data.model.i;
import com.baidu.navisdk.pronavi.logic.base.a;
import com.baidu.navisdk.ui.routeguide.module.diyspeak.e;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.common.d;
import com.baidu.navisdk.volume.BNVolumeChangeObserver;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class BNVoiceService<C extends com.baidu.navisdk.pronavi.logic.base.a> extends BNLogicService<C> {
    private BNVolumeChangeObserver k;
    private final X0IIOO l;

    /* loaded from: classes7.dex */
    public static final class a extends Lambda implements oIX0oI<C0325a> {

        /* renamed from: com.baidu.navisdk.pronavi.logic.service.voice.BNVoiceService$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0325a implements BNVolumeChangeObserver.b {
            public C0325a() {
            }

            @Override // com.baidu.navisdk.volume.BNVolumeChangeObserver.b
            public void a(int i) {
                BNVoiceService.this.d(i);
            }
        }

        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final C0325a invoke() {
            return new C0325a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BNVoiceService(@OOXIXo C context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
        this.l = XIxXXX0x0.oIX0oI(new a());
    }

    private final boolean a(int i) {
        return i == 2 || i == 3;
    }

    private final void b(int i, boolean z) {
        p().b().setValue(Integer.valueOf(i));
        if (a(i)) {
            BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
            IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
            bNCommSettingManager.setVoiceMode(i);
            BNCommSettingManager.getInstance().setLastQuietMode(i);
        } else {
            BNCommSettingManager bNCommSettingManager2 = BNCommSettingManager.getInstance();
            IIX0o.oO(bNCommSettingManager2, "BNCommSettingManager.getInstance()");
            bNCommSettingManager2.setVoiceMode(0);
        }
        r();
    }

    private final void c(int i) {
        if (i != 2) {
            if (i != 3) {
                TTSPlayerControl.playXDTTSText(b.h(R.string.nsdk_string_rg_common_notification_close_quiet_voice), 1);
                return;
            } else {
                TTSPlayerControl.playXDTTSText(b.h(R.string.nsdk_string_rg_common_notification_open_just_play_warning_mode_voice), 1);
                return;
            }
        }
        TTSPlayerControl.playXDTTSText(b.h(R.string.nsdk_string_rg_common_notification_open_quiet_mode_voice), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(int i) {
        Integer value = p().a().getValue();
        if (value == null || value.intValue() != i) {
            p().a().setValue(Integer.valueOf(i));
        }
    }

    private final i p() {
        return (i) ((com.baidu.navisdk.pronavi.logic.base.a) this.i).b(i.class);
    }

    private final BNVolumeChangeObserver.b q() {
        return (BNVolumeChangeObserver.b) this.l.getValue();
    }

    private final void r() {
        BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
        IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
        int voiceMode = bNCommSettingManager.getVoiceMode();
        if (voiceMode == 3) {
            e eVar = e.f;
            IIX0o.oO(eVar, "BNDiySpeakManager.mInstance");
            eVar.b(voiceMode);
            return;
        }
        if (voiceMode == 2) {
            e eVar2 = e.f;
            IIX0o.oO(eVar2, "BNDiySpeakManager.mInstance");
            eVar2.b(voiceMode);
            return;
        }
        e eVar3 = e.f;
        IIX0o.oO(eVar3, "BNDiySpeakManager.mInstance");
        int c = eVar3.c();
        if (c == 6) {
            BNCommSettingManager bNCommSettingManager2 = BNCommSettingManager.getInstance();
            IIX0o.oO(bNCommSettingManager2, "BNCommSettingManager.getInstance()");
            eVar3.a(c, bNCommSettingManager2.getDiyCustomModeValue());
        } else {
            IIX0o.oO(eVar3, "BNDiySpeakManager.mInstance");
            eVar3.b(c);
        }
    }

    @Override // com.baidu.navisdk.pageframe.logic.BNLogicService, com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        C mContext = this.i;
        IIX0o.oO(mContext, "mContext");
        d(d.c(((com.baidu.navisdk.pronavi.logic.base.a) mContext).a()));
        C mContext2 = this.i;
        IIX0o.oO(mContext2, "mContext");
        Context a2 = ((com.baidu.navisdk.pronavi.logic.base.a) mContext2).a();
        IIX0o.oO(a2, "mContext.applicationContext");
        BNVolumeChangeObserver bNVolumeChangeObserver = new BNVolumeChangeObserver(a2);
        this.k = bNVolumeChangeObserver;
        bNVolumeChangeObserver.a(q());
    }

    @Override // com.baidu.navisdk.pageframe.logic.BNLogicService, com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        BNVolumeChangeObserver bNVolumeChangeObserver = this.k;
        if (bNVolumeChangeObserver != null) {
            bNVolumeChangeObserver.b();
        }
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "BNVoiceService";
    }

    public void a(int i, boolean z) {
        boolean b = b(i);
        b(i, z);
        if (b) {
            c(i);
        }
    }

    @Override // com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    @oOoXoXO
    public h a(@OOXIXo com.baidu.navisdk.apicenter.a api) {
        IIX0o.x0xO0oo(api, "api");
        if (api.d() != 1) {
            return null;
        }
        a(api.c("paramA"), api.a("paramB", true));
        return null;
    }

    private final boolean b(int i) {
        BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
        IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
        int voiceMode = bNCommSettingManager.getVoiceMode();
        if (voiceMode == i) {
            return false;
        }
        if (!a(voiceMode) || a(i)) {
            return a(i);
        }
        return true;
    }
}
