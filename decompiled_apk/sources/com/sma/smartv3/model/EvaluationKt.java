package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nEvaluation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Evaluation.kt\ncom/sma/smartv3/model/EvaluationKt\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,94:1\n93#2,2:95\n90#2:97\n86#2,2:98\n*S KotlinDebug\n*F\n+ 1 Evaluation.kt\ncom/sma/smartv3/model/EvaluationKt\n*L\n19#1:95,2\n19#1:97\n40#1:98,2\n*E\n"})
/* loaded from: classes12.dex */
public final class EvaluationKt {
    public static final boolean isShowEvaluationDialog() {
        Xo0 xo0 = Xo0.f24349oIX0oI;
        SPUtils oIX0oI2 = xo0.oIX0oI();
        Object fromJson = new Gson().fromJson(oIX0oI2.getString(XoI0Ixx0.f24374Ix00oIoI + '_' + EvaluationTimeData.class.getName()), (Class<Object>) EvaluationTimeData.class);
        if (fromJson == null) {
            fromJson = EvaluationTimeData.class.newInstance();
        }
        EvaluationTimeData evaluationTimeData = (EvaluationTimeData) fromJson;
        long specialProcessingTime = specialProcessingTime(XoI0Ixx0.f24380O0IxXx);
        long specialProcessingTime2 = specialProcessingTime(XoI0Ixx0.f24372IoXIXo);
        long specialProcessingTime3 = specialProcessingTime(XoI0Ixx0.f24497xxOXOOoIX);
        if (!evaluationTimeData.getNoShowPop() && !ProductManager.f20544oIX0oI.xIXOoI()) {
            if (evaluationTimeData.getTime() == 0 && evaluationTimeData.getVersionCode() == 0 && timeGreaterThan(specialProcessingTime, 15) && timeGreaterThan(specialProcessingTime2, 15) && timeGreaterThan(specialProcessingTime3, 15)) {
                xo0.oIX0oI().put(XoI0Ixx0.f24374Ix00oIoI + '_' + EvaluationTimeData.class.getName(), new Gson().toJson(new EvaluationTimeData(System.currentTimeMillis(), AppUtils.getAppVersionCode(), 0L, false, 12, null)));
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("isShowEvaluationDialog   showTime");
                return true;
            }
            if (evaluationTimeData.getVersionCode() < AppUtils.getAppVersionCode()) {
                long currentTimeMillis = System.currentTimeMillis();
                xo0.oIX0oI().remove(XoI0Ixx0.f24374Ix00oIoI);
                xo0.oIX0oI().put(XoI0Ixx0.f24380O0IxXx, currentTimeMillis);
                xo0.oIX0oI().put(XoI0Ixx0.f24372IoXIXo, currentTimeMillis);
                xo0.oIX0oI().put(XoI0Ixx0.f24497xxOXOOoIX, currentTimeMillis);
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("isShowEvaluationDialog   replaceTime");
            }
            return false;
        }
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.xIXOoI()) {
            xo0.oIX0oI().remove(XoI0Ixx0.f24374Ix00oIoI);
            xo0.oIX0oI().remove(XoI0Ixx0.f24380O0IxXx);
            xo0.oIX0oI().remove(XoI0Ixx0.f24372IoXIXo);
            xo0.oIX0oI().remove(XoI0Ixx0.f24497xxOXOOoIX);
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("isShowEvaluationDialog  noShowPop  " + evaluationTimeData.getNoShowPop() + " || " + productManager.xIXOoI() + TokenParser.SP);
        return false;
    }

    public static final void putConnectionTimeoutTime() {
        Xo0.f24349oIX0oI.oIX0oI().put(XoI0Ixx0.f24380O0IxXx, System.currentTimeMillis());
    }

    public static final void putDialFailureTime() {
        Xo0.f24349oIX0oI.oIX0oI().put(XoI0Ixx0.f24372IoXIXo, System.currentTimeMillis());
    }

    public static final void putOtaFailureTime() {
        Xo0.f24349oIX0oI.oIX0oI().put(XoI0Ixx0.f24497xxOXOOoIX, System.currentTimeMillis());
    }

    public static final long specialProcessingTime(@OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        Xo0 xo0 = Xo0.f24349oIX0oI;
        long j = xo0.oIX0oI().getLong(key, 0L);
        if (j == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            xo0.oIX0oI().put(key, currentTimeMillis);
            return currentTimeMillis;
        }
        return j;
    }

    private static final boolean timeGreaterThan(long j, int i) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        if (currentTimeMillis < 0 || currentTimeMillis <= i * 86400000) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean timeGreaterThan$default(long j, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 3;
        }
        return timeGreaterThan(j, i);
    }
}
