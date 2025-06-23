package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import OXOo.oOoXoXO;
import android.view.View;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;

/* loaded from: classes7.dex */
public class i extends com.baidu.navisdk.pronavi.ui.bucket.item.b {

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.y();
        }
    }

    public i(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar, R.drawable.nsdk_drawable_navi_safeguard_icon, R.drawable.nsdk_drawable_navi_safeguard_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("NaviSafeguardBtn", "showNaviSafeguardTip: ");
        }
        this.f7853a.j().e("RGBubbleComponent").a(3002).a((Object) 1).a();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("NaviSafeguardBtn", "visibility: " + i);
        }
        if (!b(i)) {
            return 8;
        }
        if (!com.baidu.navisdk.module.navisafeguard.a.c().a()) {
            if (gVar.d()) {
                gVar.e("NaviSafeguardBtn", "visibility: not isSafeguarding ");
            }
            return 8;
        }
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().D()) {
            if (gVar.d()) {
                gVar.e("NaviSafeguardBtn", "visibility: isYawing");
            }
            return 8;
        }
        return 0;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    @oOoXoXO
    public View.OnClickListener getOnClickListener() {
        return new a();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.BrowseMap, RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.NaviReady, RGFSMTable.FsmState.NearbySearch, RGFSMTable.FsmState.DynamicLayer, RGFSMTable.FsmState.ArriveDest};
    }
}
