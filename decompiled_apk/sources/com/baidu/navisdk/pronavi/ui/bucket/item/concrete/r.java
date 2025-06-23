package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.platform.comapi.UIMsg;

/* loaded from: classes7.dex */
public class r extends com.baidu.navisdk.pronavi.ui.bucket.item.a {
    private boolean f;
    private ViewGroup g;
    private View.OnLayoutChangeListener h;

    /* loaded from: classes7.dex */
    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (i8 - i6 != i4 - i2 && r.this.isVisible()) {
                r.this.x();
            }
        }
    }

    public r(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar);
        this.f = false;
    }

    private void w() {
        if (this.h == null) {
            this.h = new a();
        } else {
            y();
        }
        if (getView() != null) {
            getView().addOnLayoutChangeListener(this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("ServiceAreaPanel", "notifyUpdateRoadConditionHeight: ");
        }
        com.baidu.navisdk.pronavi.ui.base.b bVar = this.f7853a;
        if (bVar != null) {
            bVar.j().e("RGBucketGroupComponent").a(UIMsg.MsgDefine.MSG_ONLINE_DOWNLOAD).a();
        }
    }

    private void y() {
        if (this.h != null && getView() != null) {
            getView().removeOnLayoutChangeListener(this.h);
        }
    }

    public void b(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.c()) {
            gVar.c("ServiceAreaPanel", "refreshVisible: " + z);
        }
        this.f = z;
        if (z && isVisible()) {
            return;
        }
        refreshVisible();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        if (l()) {
            return 8;
        }
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().D()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("ServiceAreaPanel", "getVisibility: isYawing");
            }
            return 8;
        }
        if (this.f7853a.N()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("ServiceAreaPanel", "getVisibility: isRoused");
            }
            return 8;
        }
        if (!this.f) {
            return 8;
        }
        return 0;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean e() {
        return false;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean n() {
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean o() {
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onDestroy() {
        y();
        super.onDestroy();
        this.h = null;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onVisibleChange(int i) {
        super.onVisibleChange(i);
        if (i == 0 && this.f7853a.E() && com.baidu.navisdk.ui.routeguide.control.x.b().p2()) {
            this.f7853a.j().e("RGBucketGroupComponent").a(2010).a();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.BrowseMap, RGFSMTable.FsmState.EnlargeRoadmap, RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.NearbySearch, RGFSMTable.FsmState.DynamicLayer, RGFSMTable.FsmState.ArriveDest};
    }

    public ViewGroup v() {
        if (this.g == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("ServiceAreaPanel", "getParentView: mParentView == null");
            }
            refreshVisible();
        }
        return this.g;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public View a(@NonNull ViewGroup viewGroup, int i, @NonNull Context context) {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.g = relativeLayout;
        relativeLayout.setLayoutParams(marginLayoutParams);
        w();
        return this.g;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int a(int i, boolean z) {
        if (i != 2) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_guide_panel_shadow_left);
        }
        return 0;
    }
}
