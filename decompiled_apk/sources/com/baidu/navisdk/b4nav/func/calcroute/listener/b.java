package com.baidu.navisdk.b4nav.func.calcroute.listener;

import android.os.Bundle;
import android.os.Message;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.model.modelfactory.f;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class b extends com.baidu.navisdk.util.worker.loop.b {

    /* renamed from: a, reason: collision with root package name */
    private a f6574a;

    public void a(a aVar) {
        this.f6574a = aVar;
    }

    @Override // com.baidu.navisdk.comapi.base.d
    public void careAbout() {
        observe(4401);
        observe(4098);
        observe(4415);
        observe(4447);
    }

    @Override // com.baidu.navisdk.util.worker.loop.b
    public void onMessage(Message message) {
        g gVar = g.B4NAV;
        if (gVar.d()) {
            gVar.e("ResultMsgHandler", "onMessage --> what = " + message.what + ", arg1 = " + message.arg1 + ", arg2 = " + message.arg2 + ", object = " + message.obj);
        }
        int i = message.what;
        if (i != 4098) {
            boolean z = false;
            if (i != 4401) {
                if (i != 4415) {
                    if (i == 4447) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("ResultMsgHandler", "NavDrivingCar===Message_Type_RcPredication msg.arg1=" + message.arg1);
                        }
                        a aVar = this.f6574a;
                        if (aVar != null) {
                            if (message.arg1 == 1) {
                                z = true;
                            }
                            aVar.a(1051, Boolean.valueOf(z));
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("ResultMsgHandler", "NavDrivingCar===MSG_NAVI_RC_Change msg.arg1=" + message.arg1);
                }
                a aVar2 = this.f6574a;
                if (aVar2 != null) {
                    if (message.arg1 == 1) {
                        z = true;
                    }
                    aVar2.a(1012, Boolean.valueOf(z));
                    return;
                }
                return;
            }
            if (message.arg2 == 2) {
                Bundle bundle = new Bundle();
                int a2 = BNRoutePlaner.getInstance().a(new ArrayList<>(), bundle);
                LogUtil.e("ResultMsgHandler", "onMessage() subResult=" + a2);
                if (bundle.containsKey("enToastType")) {
                    LogUtil.e("ResultMsgHandler", "onMessage() enToastType=" + bundle.containsKey("enToastType"));
                    f fVar = (f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
                    if (fVar != null && bundle.containsKey("enToastType")) {
                        fVar.h(bundle.getInt("enToastType"));
                    }
                    if (fVar != null && bundle.containsKey("bAvoidRouteType")) {
                        fVar.a(bundle.getBoolean("bAvoidRouteType"));
                    }
                }
                if (bundle.containsKey("enPlanNetMode")) {
                    LogUtil.e("ResultMsgHandler", "onMessage() enPlanNetMode=" + bundle.getInt("enPlanNetMode"));
                    BNRoutePlaner.getInstance().q(bundle.getInt("enPlanNetMode"));
                }
                if (a2 == 1) {
                    BNRoutePlaner.getInstance().g(2);
                    BNRoutePlaner.getInstance().i(1);
                } else if (a2 == 2) {
                    BNRoutePlaner.getInstance().i(2);
                    BNRoutePlaner.getInstance().g(3);
                }
                com.baidu.navisdk.comapi.routeplan.f.c(null, 67);
                BNRoutePlaner.getInstance().a(BNRoutePlaner.getInstance().g(), 67, 0);
                return;
            }
            return;
        }
        LogUtil.e("ResultMsgHandler", "NavDrivingCar===MSG_NAVI_STATUS_CHANGE nMsgType=" + message.arg1);
        if (BNSettingManager.isShowJavaLog()) {
            SDKDebugFileUtil.get(SDKDebugFileUtil.RoutePlan_FILENAME).add("NavDrivingCar===MSG_NAVI_STATUS_CHANGE nMsgType=" + message.arg1);
        }
        int i2 = message.arg1;
        if (i2 == 6) {
            a aVar3 = this.f6574a;
            if (aVar3 != null) {
                aVar3.a(3040);
                return;
            }
            return;
        }
        if (i2 == 2) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("ResultMsgHandler", "NavDrivingCar===MSG_NAVI_STATUS_CHANGE & SUB_NAVI_STATUS_YAWING");
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "驾车页开始偏航...");
            }
            a aVar4 = this.f6574a;
            if (aVar4 != null) {
                aVar4.a(1013);
            }
        }
    }
}
