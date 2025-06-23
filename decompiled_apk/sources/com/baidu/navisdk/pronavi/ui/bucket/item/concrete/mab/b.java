package com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.pronavi.ui.bucket.config.d;
import com.baidu.navisdk.pronavi.widget.RGImageTextBtn;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public abstract class b extends com.baidu.navisdk.pronavi.ui.bucket.item.c {
    private final String k;
    protected int l;

    public b(com.baidu.navisdk.pronavi.ui.base.b bVar, d dVar, int i, int i2, String str) {
        super(bVar, dVar, i, i2);
        this.l = -1;
        this.k = str;
    }

    public abstract void A();

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public void a(View view) {
        super.a(view);
        com.baidu.navisdk.ui.routeguide.subview.a c = c();
        if (c == null) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(this.k, "onClicked: subViewListener == null");
                return;
            }
            return;
        }
        if (com.baidu.navisdk.ui.util.g.a()) {
            LogUtil.e(this.k, "mRLBridgeSwitch isFastDoubleClick");
        } else {
            if (x.b().l2()) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(this.k, "mRLBridgeSwitch isInterceptReCalRouteForVdrGuide");
                    return;
                }
                return;
            }
            a(c);
        }
    }

    public abstract void a(com.baidu.navisdk.ui.routeguide.subview.a aVar);

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.k, "getVisibility:  " + this.l);
        }
        if (!BNSettingManager.isMainAuxiliaryOrBridgeEnable()) {
            if (gVar.d()) {
                gVar.e(this.k, "getVisibility: isMainAuxiliaryOrBridgeEnable");
            }
            return 8;
        }
        if (a0.I().D()) {
            if (gVar.d()) {
                gVar.e(this.k, "getVisibility: isYawing");
            }
            return 8;
        }
        int i2 = this.l;
        if (i2 != 0 && i2 != -1) {
            if (this.f7853a.N()) {
                if (gVar.d()) {
                    gVar.e(this.k, "getVisibility: isRoused");
                }
                return 8;
            }
            if (this.f7853a.I()) {
                if (gVar.d()) {
                    gVar.e(this.k, "isShowChargeStationList visibility gone: ");
                }
                return 8;
            }
            if (this.f7853a.L()) {
                if (gVar.d()) {
                    gVar.e(this.k, "isShowParkRecList visibility gone: ");
                }
                return 8;
            }
            if (f(this.l)) {
                return 0;
            }
        }
        return 8;
    }

    public abstract int e(int i);

    public abstract boolean f(int i);

    public void g(int i) {
        this.l = e(i);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.k, "update: " + i + ",mCurrentType: " + this.l);
        }
        z();
        refreshVisible();
        String y = y();
        if (!TextUtils.isEmpty(y)) {
            com.baidu.navisdk.util.statistic.userop.b.r().c(y);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void loadBucketItem(ViewGroup viewGroup, int i, Context context) {
        super.loadBucketItem(viewGroup, i, context);
        if (!s()) {
            A();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean n() {
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.ArriveDest, RGFSMTable.FsmState.NaviReady, RGFSMTable.FsmState.IndoorPark, RGFSMTable.FsmState.IndoorParkBrowse, RGFSMTable.FsmState.IndoorParkChoose, RGFSMTable.FsmState.NearbySearch, RGFSMTable.FsmState.DynamicLayer};
    }

    @Nullable
    public abstract String y();

    public abstract void z();

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public void a(com.baidu.navisdk.pronavi.style.i.a aVar) {
        RGImageTextBtn v = v();
        if (v == null || aVar == null) {
            return;
        }
        aVar.a(v.text);
        aVar.a(v);
        if (this.j == null) {
            this.j = new com.baidu.navisdk.pronavi.style.view.a();
        }
        this.j.setImageView(v.icon);
        this.j.setStrTextView(v.text);
        aVar.a("RGAllStyleResId", (String) this.j);
    }
}
