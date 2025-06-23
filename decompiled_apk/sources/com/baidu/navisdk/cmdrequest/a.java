package com.baidu.navisdk.cmdrequest;

import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected f f6680a = new f();
    protected i b;

    public abstract f a();

    public f a(i iVar) {
        this.b = iVar;
        b(iVar);
        f a2 = a();
        this.f6680a = a2;
        if (a2 == null) {
            LogUtil.e("CommandBase", "warning: the command result is null.");
            this.f6680a = new f(-9998);
        }
        f fVar = this.f6680a;
        if (fVar != null && fVar.a()) {
            c();
        } else {
            b();
        }
        return this.f6680a;
    }

    public void b() {
        if (this.b == null || this.f6680a == null) {
            return;
        }
        LogUtil.e("", "------------------------------\nhandler:" + this.b.e + "    \nError=" + this.f6680a.f6693a + "    \nstrdebug:" + this.f6680a.b + "    \nstruser:" + this.f6680a.c);
    }

    public abstract void b(i iVar);

    public void c() {
    }
}
