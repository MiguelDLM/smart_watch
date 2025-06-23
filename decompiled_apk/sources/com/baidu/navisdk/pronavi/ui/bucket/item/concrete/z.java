package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.widget.BNVoiceBtn;
import com.baidu.navisdk.util.common.n0;
import com.baidu.navisdk.util.common.o0;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class z extends com.baidu.navisdk.pronavi.ui.bucket.item.a {
    private BNVoiceBtn f;
    private final BNVoiceBtn.XDVoiceBtnCallback g;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            z.this.w();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements o0.b {
        public b() {
        }

        @Override // com.baidu.navisdk.util.common.o0.b
        public void a(int i, boolean z, ArrayList<String> arrayList) {
            if (i == 2 && z && z.this.f != null) {
                z.this.f.updateStatus();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements BNVoiceBtn.XDVoiceBtnCallback {
        public c(z zVar) {
        }

        @Override // com.baidu.navisdk.ui.widget.BNVoiceBtn.XDVoiceBtnCallback
        public boolean isAllowedBtnShow() {
            return true;
        }

        @Override // com.baidu.navisdk.ui.widget.BNVoiceBtn.XDVoiceBtnCallback
        public boolean isSwitchOn() {
            if (com.baidu.navisdk.asr.d.B().t() && com.baidu.navisdk.asr.f.b() && com.baidu.navisdk.ui.routeguide.asr.c.n().a(1) && com.baidu.navisdk.ui.routeguide.asr.c.n().a(9) && !com.baidu.navisdk.asr.d.B().p()) {
                return true;
            }
            return false;
        }
    }

    public z(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar);
        this.g = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.z.3", null, null, "0");
        if (Build.VERSION.SDK_INT >= 23) {
            if (!n0.a(com.baidu.navisdk.framework.a.c().a(), "android.permission.RECORD_AUDIO")) {
                o0.b().a(2, new b());
                return;
            } else {
                com.baidu.navisdk.asr.d.B().A();
                return;
            }
        }
        com.baidu.navisdk.asr.d.B().A();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        if (!com.baidu.navisdk.function.b.FUNC_XIAODU.a() || com.baidu.navisdk.module.cloudconfig.f.c().c.v != 0 || !BNCommSettingManager.getInstance().isShowXiaoDu() || com.baidu.navisdk.module.routeresultbase.framework.utils.b.a() != 0) {
            return 8;
        }
        if (!com.baidu.navisdk.ui.routeguide.asr.c.n().h() && !com.baidu.navisdk.ui.routeguide.asr.c.n().c()) {
            return 8;
        }
        if (com.baidu.navisdk.ui.routeguide.asr.c.n().i()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("XiaoDuBtn", "visibility: isWakeUp");
            }
            return 8;
        }
        if (!com.baidu.navisdk.ui.routeguide.b.V().x()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("XiaoDuBtn", "visibility: not hasCalcRouteOk");
            }
            return 8;
        }
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().D()) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("XiaoDuBtn", "visibility: isYawing");
            }
            return 8;
        }
        if (com.baidu.navisdk.ui.routeguide.asr.c.n().d()) {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("XiaoDuBtn", "visibility: isInAidScene");
            }
            return 8;
        }
        if (i == 2 && this.f7853a.D()) {
            com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar5.d()) {
                gVar5.e("XiaoDuBtn", "visibility: isNormalHDMapShowed:" + i);
            }
            return 8;
        }
        if (!com.baidu.navisdk.ui.routeguide.asr.c.n().g() && !RGFSMTable.FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getCurrentState())) {
            return 8;
        }
        return 0;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public View.OnClickListener getOnClickListener() {
        return new a();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean h() {
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onDestroy() {
        super.onDestroy();
        BNVoiceBtn bNVoiceBtn = this.f;
        if (bNVoiceBtn != null) {
            bNVoiceBtn.stopAni();
            this.f.setBtnCallback(null);
        }
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onVisibleChange(int i) {
        super.onVisibleChange(i);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("XiaoDuBtn", "onVisibleChange: " + i);
        }
        if (i == 0) {
            this.f.startAni();
            this.f.updateStatus();
        } else {
            this.f.stopAni();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.EnlargeRoadmap, RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.NearbySearch, RGFSMTable.FsmState.DynamicLayer, RGFSMTable.FsmState.ArriveDest};
    }

    public void v() {
        BNVoiceBtn bNVoiceBtn = this.f;
        if (bNVoiceBtn != null) {
            bNVoiceBtn.updateStatus();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public View a(@NonNull ViewGroup viewGroup, int i, @NonNull Context context) {
        BNVoiceBtn bNVoiceBtn = (BNVoiceBtn) com.baidu.navisdk.ui.util.b.a(context, R.layout.nsdk_layout_rg_voice_btn_view, viewGroup, false);
        this.f = bNVoiceBtn;
        bNVoiceBtn.setTag("bucket_xd_voice_btn");
        this.f.setBtnCallback(this.g);
        return this.f;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int a(int i, boolean z) {
        if (i != 2) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_4dp);
        }
        return 0;
    }
}
