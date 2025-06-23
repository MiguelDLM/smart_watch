package com.baidu.navisdk.module.abtest.model;

import android.os.Bundle;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class i extends j {
    private int p;
    private int q;
    private int r;
    private int s;

    public i(com.baidu.navisdk.module.statistics.abtest.a aVar) {
        super(aVar);
        a(aVar.e(3));
    }

    public static i w() {
        return (i) com.baidu.navisdk.framework.interfaces.c.p().a().g(3);
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public void b(Bundle bundle) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ABSwitchRouteData", "parseConfig:" + bundle);
        }
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "ABSwitchRouteData";
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public int n() {
        return 3;
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public int o() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ABSwitchRouteData", "plan:" + super.o());
        }
        return super.o();
    }

    public void s() {
        this.s++;
        d("continueRouteClickedCount", "" + this.s);
    }

    public void t() {
        this.q++;
        d("labelClickedCount", "" + this.q);
    }

    public void u() {
        this.p++;
        d("routeClickedCount", "" + this.p);
    }

    public void v() {
        this.r++;
        d("switchRouteClickedCount", "" + this.r);
    }
}
