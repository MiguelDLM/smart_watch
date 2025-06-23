package com.huawei.hms.ads;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.ads.jb;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import java.util.List;

/* loaded from: classes10.dex */
public class jc {
    public static AdEventReport Code(AdContentData adContentData) {
        AdEventReport adEventReport = new AdEventReport();
        if (adContentData != null) {
            adEventReport.Code(adContentData.Z());
            adEventReport.V(adContentData.a());
            adEventReport.B(adContentData.D());
            adEventReport.C(adContentData.M());
            adEventReport.L(adContentData.am());
            adEventReport.Z(adContentData.ap());
            adEventReport.Code(adContentData.aB());
            adEventReport.Z(adContentData.aF());
            adEventReport.b(adContentData.aE());
            adEventReport.c(adContentData.L());
            adEventReport.B(adContentData.aN());
            adEventReport.Code(adContentData.I());
            adEventReport.f(g.Code());
        }
        return adEventReport;
    }

    public static void I(Context context, AdContentData adContentData, String str) {
        AdEventReport Code = Code(adContentData);
        Code.S(str);
        Code(context, com.huawei.openalliance.ad.constant.s.f, Code);
    }

    public static void V(Context context, AdContentData adContentData) {
        Code(context, com.huawei.openalliance.ad.constant.s.e, Code(adContentData));
    }

    public static void Code(Context context, AdContentData adContentData) {
        Code(context, com.huawei.openalliance.ad.constant.s.I, Code(adContentData));
    }

    public static void V(Context context, AdContentData adContentData, jb jbVar) {
        Code(context, adContentData, false, jbVar);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str) {
        Code(context, adContentData, i, i2, (List<String>) null, str);
    }

    public static void V(Context context, AdContentData adContentData, String str) {
        AdEventReport Code = Code(adContentData);
        Code.I(str);
        Code.V(adContentData.aS());
        Code(context, com.huawei.openalliance.ad.constant.s.G, Code);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str, int i3, MaterialClickInfo materialClickInfo, String str2, int[] iArr) {
        Code(context, adContentData, i, i2, str, i3, materialClickInfo, str2, iArr, null);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str, int i3, MaterialClickInfo materialClickInfo, String str2, int[] iArr, jb jbVar) {
        String str3;
        AdEventReport Code = Code(adContentData);
        Code.V(i);
        Code.I(i2);
        if (!com.huawei.openalliance.ad.utils.ad.Code(iArr) && iArr.length > 1) {
            Code.L(Integer.valueOf(iArr[0]));
            Code.a(Integer.valueOf(iArr[1]));
            Code.b(Integer.valueOf(com.huawei.openalliance.ad.utils.bc.L(context)));
        }
        Code.Z(str);
        Code.I(Integer.valueOf(i3));
        Code.D(str2);
        Code(Code, materialClickInfo);
        if (materialClickInfo != null) {
            Code.I(materialClickInfo.F());
            str3 = materialClickInfo.F();
        } else {
            str3 = com.huawei.openalliance.ad.constant.s.B;
        }
        Code.Z(Long.valueOf(com.huawei.openalliance.ad.utils.w.Code()));
        if (jbVar != null) {
            Code.h(jbVar.L());
        }
        Code(context, str3, Code);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str, int i3, String str2) {
        AdEventReport Code = Code(adContentData);
        Code.V(i);
        Code.I(i2);
        Code.Z(str);
        Code.I(Integer.valueOf(i3));
        Code.D(str2);
        Code.Z(Long.valueOf(com.huawei.openalliance.ad.utils.w.Code()));
        Code.f((Integer) 1);
        Code(context, com.huawei.openalliance.ad.constant.s.B, Code);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str, int i3, String str2, int[] iArr) {
        AdEventReport Code = Code(adContentData);
        Code.V(i);
        Code.I(i2);
        Code.Z(str);
        Code.I(Integer.valueOf(i3));
        Code.D(str2);
        if (!com.huawei.openalliance.ad.utils.ad.Code(iArr) && iArr.length > 1) {
            Code.L(Integer.valueOf(iArr[0]));
            Code.a(Integer.valueOf(iArr[1]));
            Code.b(Integer.valueOf(com.huawei.openalliance.ad.utils.bc.L(context)));
        }
        Code.Z(Long.valueOf(com.huawei.openalliance.ad.utils.w.Code()));
        Code.f((Integer) 1);
        Code(context, com.huawei.openalliance.ad.constant.s.B, Code);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str, MaterialClickInfo materialClickInfo, String str2, int[] iArr) {
        AdEventReport Code = Code(adContentData);
        Code.V(i);
        Code.I(i2);
        if (!com.huawei.openalliance.ad.utils.ad.Code(iArr) && iArr.length > 1) {
            Code.L(Integer.valueOf(iArr[0]));
            Code.a(Integer.valueOf(iArr[1]));
            Code.b(Integer.valueOf(com.huawei.openalliance.ad.utils.bc.L(context)));
        }
        Code.Z(str);
        Code.D(str2);
        Code(Code, materialClickInfo);
        Code.Z(Long.valueOf(com.huawei.openalliance.ad.utils.w.Code()));
        Code(context, com.huawei.openalliance.ad.constant.s.B, Code);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str, String str2) {
        MaterialClickInfo materialClickInfo = new MaterialClickInfo();
        materialClickInfo.B(1);
        Code(context, adContentData, i, i2, str, materialClickInfo, str2, new int[0]);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str, String str2, int[] iArr) {
        MaterialClickInfo materialClickInfo = new MaterialClickInfo();
        materialClickInfo.B(1);
        Code(context, adContentData, i, i2, str, materialClickInfo, str2, iArr);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, List<String> list) {
        Code(context, adContentData, i, i2, list, (String) null);
    }

    private static void Code(Context context, AdContentData adContentData, int i, int i2, List<String> list, String str) {
        AdEventReport Code = Code(adContentData);
        Code.V(i);
        Code.I(i2);
        Code.Code(list);
        if (!com.huawei.openalliance.ad.utils.ay.Code(str)) {
            Code.I(str);
        }
        Code(context, com.huawei.openalliance.ad.constant.s.C, Code);
    }

    public static void Code(Context context, AdContentData adContentData, long j, int i) {
        jb.a aVar = new jb.a();
        aVar.Code(Long.valueOf(j)).Code(Integer.valueOf(i));
        Code(context, adContentData, true, aVar.Code());
    }

    public static void Code(Context context, AdContentData adContentData, jb jbVar) {
        Code(context, adContentData, false, jbVar);
    }

    public static void Code(Context context, AdContentData adContentData, jb jbVar, String str) {
        Code(context, adContentData, false, jbVar, str);
    }

    public static void Code(Context context, AdContentData adContentData, MaterialClickInfo materialClickInfo, int i, int i2, String str, int i3, String str2) {
        AdEventReport Code = Code(adContentData);
        Code.V(i);
        Code.I(i2);
        Code.Z(str);
        Code.I(Integer.valueOf(i3));
        Code.D(str2);
        Code.Z(Long.valueOf(com.huawei.openalliance.ad.utils.w.Code()));
        Code(Code, materialClickInfo);
        Code(context, com.huawei.openalliance.ad.constant.s.B, Code);
    }

    public static void Code(Context context, AdContentData adContentData, Integer num) {
        AdEventReport Code = Code(adContentData);
        Code.I(num);
        Code(context, com.huawei.openalliance.ad.constant.s.D, Code);
    }

    public static void Code(Context context, AdContentData adContentData, Integer num, String str) {
        AdEventReport Code = Code(adContentData);
        Code.I(num);
        Code.S(str);
        Code(context, com.huawei.openalliance.ad.constant.s.F, Code);
    }

    public static void Code(Context context, AdContentData adContentData, Long l, Integer num, Integer num2, Long l2, Boolean bool) {
        jb.a aVar = new jb.a();
        aVar.Code(l).Code(num).V(num2).V(l2).Code(bool);
        Code(context, adContentData, false, aVar.Code());
    }

    public static void Code(Context context, AdContentData adContentData, String str) {
        Code(context, adContentData, str, (Long) null, (Boolean) null);
    }

    public static void Code(Context context, AdContentData adContentData, String str, int i, int i2, String str2, int i3, String str3, MaterialClickInfo materialClickInfo) {
        Code(context, adContentData, str, i, i2, str2, i3, str3, null, null, materialClickInfo);
    }

    public static void Code(Context context, AdContentData adContentData, String str, int i, int i2, String str2, int i3, String str3, Long l, Boolean bool, MaterialClickInfo materialClickInfo) {
        AdEventReport Code = Code(adContentData);
        Code.V(i);
        Code.I(i2);
        Code.Z(str2);
        Code.I(Integer.valueOf(i3));
        Code.S(str);
        Code.D(str3);
        Code.Z(l);
        Code.Code(bool);
        Code(Code, materialClickInfo);
        Code(context, com.huawei.openalliance.ad.constant.s.B, Code);
    }

    public static void Code(Context context, AdContentData adContentData, String str, Integer num, Integer num2) {
        Code(context, adContentData, str, num, num2, (Long) null, (Boolean) null);
    }

    public static void Code(Context context, AdContentData adContentData, String str, Integer num, Integer num2, Long l, Boolean bool) {
        AdEventReport Code = Code(adContentData);
        Code.I(str);
        Code.C(num);
        Code.S(num2);
        Code.Z(l);
        Code.Code(bool);
        Code(context, com.huawei.openalliance.ad.constant.s.S, Code);
    }

    public static void Code(Context context, AdContentData adContentData, String str, Long l, Boolean bool) {
        AdEventReport Code = Code(adContentData);
        Code.S(str);
        Code(context, com.huawei.openalliance.ad.constant.s.I, Code);
    }

    public static void Code(Context context, AdContentData adContentData, String str, Long l, Long l2, Integer num, Integer num2) {
        AdEventReport Code = Code(adContentData);
        Code.I(str);
        Code.V(l);
        Code.I(l2);
        Code.Z(num);
        Code.B(num2);
        Code(context, com.huawei.openalliance.ad.constant.s.Z, Code);
    }

    public static void Code(Context context, AdContentData adContentData, String str, Long l, Long l2, Integer num, Integer num2, String str2) {
        AdEventReport Code = Code(adContentData);
        Code.I(str);
        Code.V(l);
        Code.I(l2);
        Code.Z(num);
        Code.B(num2);
        Code.S(str2);
        Code(context, com.huawei.openalliance.ad.constant.s.Z, Code);
    }

    public static void Code(Context context, AdContentData adContentData, String str, String str2, String str3) {
        AdEventReport Code = Code(adContentData);
        if (str != null) {
            Code.S(str);
        } else {
            fb.I(NotificationCompat.CATEGORY_EVENT, "on ad rewarded, customData is null");
        }
        if (str2 != null) {
            Code.F(str2);
        } else {
            fb.I(NotificationCompat.CATEGORY_EVENT, "on ad rewarded, userId is null");
        }
        Code.D(str3);
        Code(context, com.huawei.openalliance.ad.constant.s.b, Code);
    }

    public static void Code(Context context, AdContentData adContentData, List<FeedbackInfo> list, int i) {
        AdEventReport Code = Code(adContentData);
        Code.S(String.valueOf(i));
        Code.V(list);
        Code(context, com.huawei.openalliance.ad.constant.s.w, Code);
    }

    public static void Code(Context context, AdContentData adContentData, boolean z) {
        AdEventReport Code = Code(adContentData);
        Code.I(z);
        Code(context, com.huawei.openalliance.ad.constant.s.j, Code);
    }

    private static void Code(Context context, AdContentData adContentData, boolean z, jb jbVar) {
        Code(context, adContentData, z, jbVar, (String) null);
    }

    private static void Code(Context context, AdContentData adContentData, boolean z, jb jbVar, String str) {
        if (adContentData == null) {
            fb.I("EvtProcessor", "on ad show, ad data is null");
            return;
        }
        AdEventReport Code = Code(adContentData);
        Code.V(z);
        if (jbVar != null) {
            if (jbVar.F() != null) {
                Code.S(jbVar.F());
            }
            if (jbVar.V() != null) {
                Code.Code(jbVar.V());
            }
            if (jbVar.I() != null) {
                Code.V(jbVar.I());
            }
            if (jbVar.Z() != null) {
                Code.I(jbVar.Z());
            }
            if (jbVar.B() != null) {
                Code.D(jbVar.B());
            }
            if (jbVar.C() != null) {
                Code.Z(jbVar.C());
            }
            if (jbVar.S() != null) {
                Code.Code(jbVar.S());
            }
            if (jbVar.D() != null) {
                Code.d(jbVar.D());
            }
            if (jbVar.Code() != null) {
                Code.a(jbVar.Code());
            }
            if (adContentData.F() != null) {
                Code.Code(adContentData.F());
            }
            if (jbVar.L() != null) {
                Code.h(jbVar.L());
            }
        }
        if (!com.huawei.openalliance.ad.utils.ay.Code(str)) {
            Code.I(str);
        }
        Code(context, com.huawei.openalliance.ad.constant.s.V, Code);
    }

    private static void Code(Context context, String str, AdEventReport adEventReport) {
        if (context == null) {
            return;
        }
        com.huawei.openalliance.ad.ipc.h.Code(context, adEventReport.v()).Code(str, com.huawei.openalliance.ad.utils.aa.V(adEventReport), null, null);
    }

    private static void Code(AdEventReport adEventReport, MaterialClickInfo materialClickInfo) {
        if (materialClickInfo != null) {
            adEventReport.F(materialClickInfo.Code());
            adEventReport.D(materialClickInfo.V());
            adEventReport.a(materialClickInfo.I());
            adEventReport.c(materialClickInfo.Z());
            adEventReport.Code(materialClickInfo.S());
            adEventReport.d(materialClickInfo.B());
            adEventReport.e(materialClickInfo.C());
            adEventReport.f(materialClickInfo.a());
            adEventReport.C(materialClickInfo.L());
            adEventReport.B(materialClickInfo.D());
            adEventReport.e(materialClickInfo.b());
            adEventReport.g(materialClickInfo.c());
        }
    }
}
