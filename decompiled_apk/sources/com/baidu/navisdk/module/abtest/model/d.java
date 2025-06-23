package com.baidu.navisdk.module.abtest.model;

import android.os.Bundle;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class d extends j {
    public d(com.baidu.navisdk.module.statistics.abtest.a aVar) {
        super(aVar);
    }

    public static d s() {
        com.baidu.navisdk.framework.interfaces.a a2 = com.baidu.navisdk.framework.interfaces.c.p().a();
        if (a2 == null) {
            return null;
        }
        return (d) a2.g(5);
    }

    private void t() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-ABCommuteData", "init");
        }
        com.baidu.navisdk.module.statistics.abtest.a aVar = this.j;
        if (aVar != null) {
            a(aVar.e(5));
        }
    }

    public static boolean u() {
        d s = s();
        if (s == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Statistics-ABCommuteData", "isEnable,true");
            }
            return true;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-ABCommuteData", "isEnable,abCommuteData.getPlan():" + s.o());
        }
        if (s.o() == 1) {
            return true;
        }
        return false;
    }

    public void a(int i, int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-ABCommuteData", "abStatisticsOnGuideStart,source:" + i + ",type:" + i2 + ",this:" + this);
        }
        Bundle bundle = new Bundle();
        JNIGuidanceControl.getInstance().getRemainRouteInfo(bundle);
        int i3 = bundle.getInt("remainDis");
        int i4 = bundle.getInt("remainTime");
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-ABCommuteData", "abStatisticsOnGuideStart,totalPlanDisMeter:" + i3 + ",totalPlanTimeS:" + i4);
        }
        d("type", Long.toString(i2));
        d("source", Long.toString(i));
        d("plan_time", Long.toString(i4));
        d("plan_dis", Long.toString(i3));
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public void b(Bundle bundle) {
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "Statistics-ABCommuteData";
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public int n() {
        return 5;
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    @Deprecated
    public int o() {
        int o = super.o();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-ABCommuteData", "plan_real:" + o);
        }
        if (o != 1 && o != 2) {
            o = 1;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-ABCommuteData", "plan_user:" + o);
        }
        return o;
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public void r() {
        super.r();
        t();
    }

    @Override // com.baidu.navisdk.module.abtest.model.j, com.baidu.navisdk.comapi.statistics.f
    public void b(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-ABCommuteData", "onEvent");
            LogUtil.printCallStack();
        }
        super.b(i);
    }

    public void a(int i, long j) {
        t();
        long trajectoryLength = JNITrajectoryControl.sInstance.getTrajectoryLength(JNITrajectoryControl.sInstance.getCurrentUUID());
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-ABCommuteData", "abStatisticsOnGuideEnd,totalRealDisMeter:" + trajectoryLength + ",type:" + i + ",totalRealTimeMs:" + j + ",this:" + this);
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-ABCommuteData", "onEvent,totalRealTimeMs=" + j);
        }
        d("real_time", Long.toString(j / 1000));
        d("real_dis", Long.toString(trajectoryLength));
    }
}
