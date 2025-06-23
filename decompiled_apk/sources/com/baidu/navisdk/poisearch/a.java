package com.baidu.navisdk.poisearch;

import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.p0;

/* loaded from: classes7.dex */
public class a {
    private static final String b = "a";

    /* renamed from: a, reason: collision with root package name */
    private p0 f7633a;

    public void a(p0.b bVar) {
        LogUtil.e(b, "startNewTimer: --> ");
        a();
        p0 p0Var = new p0();
        this.f7633a = p0Var;
        if (bVar != null) {
            p0Var.a(bVar);
        }
        this.f7633a.a(40);
    }

    public void a() {
        LogUtil.e(b, "cancelTimer: --> ");
        p0 p0Var = this.f7633a;
        if (p0Var != null) {
            p0Var.a();
        }
    }
}
