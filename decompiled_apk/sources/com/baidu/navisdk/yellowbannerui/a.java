package com.baidu.navisdk.yellowbannerui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.yellowtipdata.model.data.d;

/* loaded from: classes8.dex */
public abstract class a implements com.baidu.navisdk.yellowbannerui.interfaces.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f9434a = o();

    private String o() {
        return n() + "-YBannerViewChange";
    }

    @Override // com.baidu.navisdk.yellowbannerui.interfaces.b
    public boolean a() {
        if (!LogUtil.LOGGABLE) {
            return false;
        }
        LogUtil.e(this.f9434a, "isViewAllStatus()");
        return false;
    }

    @Override // com.baidu.navisdk.yellowbannerui.interfaces.b
    public void b() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9434a, "jumpToRcPredictionPage()");
        }
    }

    @Override // com.baidu.navisdk.yellowbannerui.interfaces.b
    public void c() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9434a, "refreshRoute()");
        }
    }

    @Override // com.baidu.navisdk.yellowbannerui.interfaces.b
    public boolean d() {
        return false;
    }

    @Override // com.baidu.navisdk.yellowbannerui.interfaces.b
    public boolean e() {
        return false;
    }

    @Override // com.baidu.navisdk.yellowbannerui.interfaces.b
    public void f() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9434a, "jumpRouteFullViewPage()");
        }
    }

    @Override // com.baidu.navisdk.yellowbannerui.interfaces.b
    public boolean g() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9434a, "isVehicleLimitBtnExplored()");
            return false;
        }
        return false;
    }

    @Override // com.baidu.navisdk.yellowbannerui.interfaces.b
    public void h() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9434a, "gotoPlateAddNativePanel()");
        }
    }

    @Override // com.baidu.navisdk.yellowbannerui.interfaces.b
    public void i() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9434a, "changePrefer()");
        }
    }

    @Override // com.baidu.navisdk.yellowbannerui.interfaces.b
    public boolean isLongDistance() {
        return false;
    }

    @Override // com.baidu.navisdk.yellowbannerui.interfaces.b
    public void j() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9434a, "gotoPassportPage()");
        }
    }

    @Override // com.baidu.navisdk.yellowbannerui.interfaces.b
    public void k() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9434a, "jumpToEtaTab()");
        }
    }

    @Override // com.baidu.navisdk.yellowbannerui.interfaces.b
    public boolean l() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9434a, "isJumpToPlateAddNativePanel()");
            return false;
        }
        return false;
    }

    @Override // com.baidu.navisdk.yellowbannerui.interfaces.b
    public void m() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9434a, "jumpToFavoritePage()");
        }
    }

    public abstract String n();

    @Override // com.baidu.navisdk.yellowbannerui.interfaces.b
    public void a(@NonNull RoutePlanNode routePlanNode, @Nullable Bundle bundle) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9434a, "changeDest() --> routePlanNode = " + routePlanNode + ", extraData = " + bundle);
        }
    }

    @Override // com.baidu.navisdk.yellowbannerui.interfaces.b
    public void b(int i, d dVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9434a, "onYBannerCloseViewClick() --> tipsType = " + i + ", model = " + dVar);
        }
    }

    @Override // com.baidu.navisdk.yellowbannerui.interfaces.b
    public void a(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9434a, "recordGoToCarPlateSettingPageState() --> state = " + z);
        }
    }

    @Override // com.baidu.navisdk.yellowbannerui.interfaces.b
    public void b(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9434a, "onYellowBannerShow " + z);
        }
    }

    @Override // com.baidu.navisdk.yellowbannerui.interfaces.b
    public void a(String str) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9434a, "permitReCalRoute(), permitInfoIds = " + str);
        }
    }

    @Override // com.baidu.navisdk.yellowbannerui.interfaces.b
    public void a(Bundle bundle) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9434a, "jumpRoadOrShowUgcPanel(), bundle = " + bundle);
        }
    }

    @Override // com.baidu.navisdk.yellowbannerui.interfaces.b
    public void a(int i, d dVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9434a, "onYBannerShow() --> tipsType = " + i + ", model = " + dVar);
        }
    }
}
