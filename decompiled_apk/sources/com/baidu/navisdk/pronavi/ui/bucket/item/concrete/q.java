package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;

/* loaded from: classes7.dex */
public class q extends com.baidu.navisdk.pronavi.ui.bucket.item.a {
    private com.baidu.navisdk.pronavi.widget.a f;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q.this.f != null) {
                q.this.f.a();
            }
        }
    }

    public q(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar);
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        if (!com.baidu.navisdk.function.b.FUNC_SCENIC_SETTING.a()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("ScenicBroadcastBtn", "visibility: FUNC_SCENIC_SETTING not enable");
            }
            return 8;
        }
        if (!BNCommSettingManager.getInstance().isScenicBroadcastOpen()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("ScenicBroadcastBtn", "visibility: not isScenicBroadcastOpen");
            }
            return 8;
        }
        if (TextUtils.isEmpty(com.baidu.navisdk.ui.routeguide.model.y.c())) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("ScenicBroadcastBtn", "visibility: no content");
            }
            return 8;
        }
        if (com.baidu.navisdk.ui.routeguide.asr.c.n().i()) {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("ScenicBroadcastBtn", "visibility: isWakeUp");
            }
            return 8;
        }
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().D()) {
            com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar5.d()) {
                gVar5.e("ScenicBroadcastBtn", "visibility: isYawing");
            }
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
        com.baidu.navisdk.pronavi.widget.a aVar = this.f;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onRefreshViewStyle(int i) {
        super.onRefreshViewStyle(i);
        com.baidu.navisdk.pronavi.widget.a aVar = this.f;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.BrowseMap, RGFSMTable.FsmState.EnlargeRoadmap, RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.NaviReady, RGFSMTable.FsmState.NearbySearch, RGFSMTable.FsmState.DynamicLayer, RGFSMTable.FsmState.ArriveDest};
    }

    public boolean v() {
        com.baidu.navisdk.pronavi.widget.a aVar = this.f;
        if (aVar != null && aVar.b()) {
            return true;
        }
        return false;
    }

    public boolean w() {
        com.baidu.navisdk.pronavi.widget.a aVar = this.f;
        if (aVar != null && aVar.c()) {
            return true;
        }
        return false;
    }

    public void x() {
        com.baidu.navisdk.pronavi.widget.a aVar = this.f;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public View a(@NonNull ViewGroup viewGroup, int i, @NonNull Context context) {
        if (this.f == null) {
            this.f = new com.baidu.navisdk.pronavi.widget.a(this.f7853a, R.drawable.nsdk_rg_selector_common_control_btn_bg);
        }
        return this.f.a(viewGroup, i, context);
    }
}
