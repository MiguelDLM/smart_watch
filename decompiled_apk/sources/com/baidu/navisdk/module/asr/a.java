package com.baidu.navisdk.module.asr;

import com.baidu.navisdk.util.common.x;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f7025a;

    private a() {
    }

    public static a b() {
        if (f7025a == null) {
            f7025a = new a();
        }
        return f7025a;
    }

    public void a(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
        if (gVar.e()) {
            gVar.g("XDVoiceBNAsrCommonManager", "setWakeUpEnable() isEnable : " + z);
        }
        if (x.t()) {
            x.a(3, z);
            if (gVar.e()) {
                gVar.g("XDVoiceBNAsrCommonManager", "setWakeUpEnable() inNavi");
                return;
            }
            return;
        }
        com.baidu.navisdk.framework.interfaces.lightnavi.a i = com.baidu.navisdk.framework.interfaces.c.p().i();
        if (i != null && i.t0()) {
            if (gVar.e()) {
                gVar.g("XDVoiceBNAsrCommonManager", "setWakeUpEnable() inLightNavi");
            }
            i.p(z);
            return;
        }
        com.baidu.navisdk.framework.interfaces.commute.b e = com.baidu.navisdk.framework.interfaces.c.p().e();
        if (e != null && e.d()) {
            e.a(z);
        }
        if (gVar.e()) {
            gVar.g("XDVoiceBNAsrCommonManager", "setWakeUpEnable() inOther");
        }
        com.baidu.navisdk.framework.b.f(z);
    }

    public void a() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
        if (gVar.e()) {
            gVar.g("XDVoiceBNAsrCommonManager", "cancelPanel() ");
        }
        com.baidu.navisdk.framework.b.a();
    }
}
