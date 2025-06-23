package com.baidu.navisdk.module.vehiclemanager;

import XXO0.oIX0oI;
import android.os.Bundle;
import com.baidu.navisdk.util.common.LogUtil;
import com.kwad.components.offline.api.IOfflineCompo;

/* loaded from: classes7.dex */
public class a {
    public static String a(int i) {
        String str;
        switch (i) {
            case 1:
                str = "crash后恢复";
                break;
            case 2:
                str = "open api";
                break;
            case 3:
                str = "2框页";
                break;
            case 4:
                str = "前置算路";
                break;
            case 5:
                str = "路线结果页";
                break;
            case 6:
                str = "开启专业导航";
                break;
            case 7:
                str = "算路接口";
                break;
            case 8:
                str = "路况预测算路";
                break;
            case 9:
            default:
                str = "未知入口";
                break;
            case 10:
                str = "通勤";
                break;
            case 11:
                str = "极速导航";
                break;
        }
        return str + "设置tripmode";
    }

    public static String b(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "未知车辆" : "货车" : "摩托车" : "小轿车";
    }

    public static void a(Bundle bundle, int i) {
        if (LogUtil.LOGGABLE) {
            int i2 = (bundle == null || !bundle.containsKey("vehicleType")) ? IOfflineCompo.Priority.HIGHEST : bundle.getInt("vehicleType");
            LogUtil.e("Vehicle", "checkCalcRouteVehicleType 引擎返回: " + i2 + oIX0oI.I0Io.f4096II0xO0 + b(i2) + "), 上层的：" + i + oIX0oI.I0Io.f4096II0xO0 + b(i) + oIX0oI.I0Io.f4095I0Io);
        }
    }
}
