package com.baidu.navisdk.module.ugc;

import com.baidu.navisdk.util.common.LogUtil;
import com.garmin.fit.OxXXx0X;

/* loaded from: classes7.dex */
public final class a {
    public static int a(int i) {
        switch (i) {
            case 3104:
                return 85;
            case 3105:
                return 86;
            case 3106:
                return 87;
            case 3107:
                return 88;
            case 3108:
                return 89;
            case 3109:
                return 90;
            case OxXXx0X.f13062Oox /* 3110 */:
                return 91;
            case OxXXx0X.f13023OI0IXox /* 3111 */:
                return 92;
            case OxXXx0X.f13081X00IxOx /* 3112 */:
                return 93;
            case OxXXx0X.f13184oXIoIo /* 3113 */:
                return 94;
            case 3114:
                return 95;
            case 3115:
                return 96;
            default:
                return i;
        }
    }

    public static boolean b(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("UgcEventType", "isTruckUgcEvent: " + i);
        }
        switch (i) {
            case 3104:
            case 3105:
            case 3106:
            case 3107:
            case 3108:
            case 3109:
            case OxXXx0X.f13062Oox /* 3110 */:
            case OxXXx0X.f13023OI0IXox /* 3111 */:
            case OxXXx0X.f13081X00IxOx /* 3112 */:
            case OxXXx0X.f13184oXIoIo /* 3113 */:
            case 3114:
            case 3115:
                return true;
            default:
                return false;
        }
    }
}
