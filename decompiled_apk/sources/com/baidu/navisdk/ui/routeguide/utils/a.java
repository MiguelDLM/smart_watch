package com.baidu.navisdk.ui.routeguide.utils;

import com.baidu.navisdk.util.common.ScreenUtil;
import kotlin.OOXIXo;

@OOXIXo(message = "Use RGScreenConfigUtil")
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final a f9151a = new a();

    private a() {
    }

    public final int a() {
        return com.baidu.navisdk.pronavi.util.a.h.e();
    }

    public final int b() {
        return com.baidu.navisdk.pronavi.util.a.h.a();
    }

    public final int c() {
        return com.baidu.navisdk.pronavi.util.a.h.d();
    }

    public final int d() {
        com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
        int a2 = aVar.a();
        int d = aVar.d();
        if (Math.abs(d - a2) > ScreenUtil.getInstance().dip2px(100)) {
            return d;
        }
        return a2;
    }

    public final int e() {
        com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
        int b = aVar.b();
        int e = aVar.e();
        if (Math.abs(e - b) > ScreenUtil.getInstance().dip2px(100)) {
            return e;
        }
        return b;
    }
}
