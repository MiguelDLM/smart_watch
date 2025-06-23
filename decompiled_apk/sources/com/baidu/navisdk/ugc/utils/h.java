package com.baidu.navisdk.ugc.utils;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private static final com.baidu.navisdk.framework.interfaces.g f8341a;

    @OOXIXo
    private static final com.baidu.navisdk.framework.interfaces.pronavi.b b;

    @OOXIXo
    public static final h c = new h();

    static {
        com.baidu.navisdk.framework.interfaces.g d = com.baidu.navisdk.framework.interfaces.c.p().d();
        IIX0o.oO(d, "BNInterfaceFactory.getIn…).obtainCommonInterface()");
        f8341a = d;
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        IIX0o.oO(h, "BNInterfaceFactory.getIn…btainGuidePageInterface()");
        b = h;
    }

    private h() {
    }

    public final int a() {
        com.baidu.navisdk.framework.interfaces.g gVar = f8341a;
        if (gVar.e()) {
            return gVar.h();
        }
        return 0;
    }

    @OOXIXo
    public final String b() {
        com.baidu.navisdk.framework.interfaces.g gVar = f8341a;
        if (gVar.e()) {
            String Q = gVar.Q();
            IIX0o.oO(Q, "commonInterface.curCityName");
            return Q;
        }
        return "";
    }

    public final boolean c() {
        return b.x0();
    }
}
