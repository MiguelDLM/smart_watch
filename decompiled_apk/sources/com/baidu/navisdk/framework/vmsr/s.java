package com.baidu.navisdk.framework.vmsr;

import android.content.Context;
import android.view.KeyEvent;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class s implements m {

    /* renamed from: a, reason: collision with root package name */
    private n f6855a;
    private c b;
    private m c;

    public s(Context context) {
        this.f6855a = new n(context);
        this.b = new c(context);
    }

    public c a() {
        return this.b;
    }

    public n b() {
        return this.f6855a;
    }

    public float c() {
        n nVar = this.f6855a;
        if (nVar != null) {
            return nVar.f();
        }
        c cVar = this.b;
        if (cVar != null) {
            return cVar.f();
        }
        return 0.0f;
    }

    public void d() {
        n nVar = this.f6855a;
        if (nVar != null) {
            nVar.k();
        }
        c cVar = this.b;
        if (cVar != null) {
            cVar.k();
        }
    }

    public void e() {
        n nVar = this.f6855a;
        if (nVar != null) {
            nVar.l();
        }
        c cVar = this.b;
        if (cVar != null) {
            cVar.l();
        }
    }

    public boolean f() {
        n nVar = this.f6855a;
        if (nVar != null) {
            nVar.o();
        }
        c cVar = this.b;
        if (cVar != null && this.f6855a.c && !cVar.w()) {
            this.b.o();
            return true;
        }
        this.b = null;
        return true;
    }

    public void g() {
        n nVar = this.f6855a;
        if (nVar != null) {
            nVar.q();
        }
        if (this.b != null && !this.f6855a.a()) {
            this.b.q();
        }
    }

    public boolean h() {
        n nVar = this.f6855a;
        if (nVar != null) {
            nVar.x();
        }
        c cVar = this.b;
        if (cVar != null) {
            cVar.x();
            return true;
        }
        return true;
    }

    public void i() {
        n nVar = this.f6855a;
        if (nVar != null) {
            nVar.s();
        }
        c cVar = this.b;
        if (cVar != null) {
            cVar.s();
        }
    }

    public void j() {
        this.c = null;
        n nVar = this.f6855a;
        if (nVar != null) {
            nVar.t();
        }
        c cVar = this.b;
        if (cVar != null) {
            cVar.t();
        }
    }

    public void a(float f, float f2, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "onGpsChange speed:" + f + "accuracy:" + f2);
        }
        n nVar = this.f6855a;
        if (nVar != null) {
            nVar.a(f, f2, i);
        }
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(f, f2, i);
        }
    }

    @Override // com.baidu.navisdk.framework.vmsr.m
    public void b(int i) {
        m mVar = this.c;
        if (mVar != null) {
            mVar.b(i);
        }
    }

    public void a(int i, KeyEvent keyEvent) {
        n nVar = this.f6855a;
        if (nVar != null) {
            nVar.a(i, keyEvent);
        }
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(i, keyEvent);
        }
    }

    public void a(m mVar) {
        this.c = mVar;
        n nVar = this.f6855a;
        if (nVar != null) {
            nVar.a(this);
        }
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    @Override // com.baidu.navisdk.framework.vmsr.m
    public void a(boolean z, float f) {
        m mVar = this.c;
        if (mVar != null) {
            mVar.a(z, f);
        }
    }

    @Override // com.baidu.navisdk.framework.vmsr.m
    public void a(int i) {
        m mVar = this.c;
        boolean a2 = this.f6855a.a();
        if (!a2) {
            if (i == 2) {
                i = 128;
            } else if (i == 4) {
                i = 256;
            } else if (i == 8) {
                i = 512;
            } else if (i == 16) {
                i = 1024;
            } else if (i == 32) {
                i = 2048;
            }
        }
        if (mVar != null) {
            mVar.a(i);
        }
        c cVar = this.b;
        if (cVar == null || this.f6855a == null || !a2) {
            return;
        }
        cVar.s();
    }

    @Override // com.baidu.navisdk.framework.vmsr.m
    public void a(int i, int i2) {
        m mVar = this.c;
        if (mVar != null) {
            mVar.a(i, i2);
        }
    }

    @Override // com.baidu.navisdk.framework.vmsr.m
    public void a(int i, String str) {
        m mVar = this.c;
        if (mVar != null) {
            mVar.a(i, str);
        }
    }

    @Override // com.baidu.navisdk.framework.vmsr.m
    public void a(int i, String str, String str2, String str3) {
        m mVar = this.c;
        if (mVar != null) {
            mVar.a(i, str, str2, str3);
        }
    }

    @Override // com.baidu.navisdk.framework.vmsr.m
    public void a(int i, boolean z) {
        c cVar;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "onSysReady sys:" + i + ", isReady:" + z);
        }
        if (i == 1) {
            if (z) {
                c cVar2 = this.b;
                if (cVar2 != null) {
                    cVar2.s();
                    return;
                }
                return;
            }
            n nVar = this.f6855a;
            if (nVar == null || !nVar.i() || (cVar = this.b) == null) {
                return;
            }
            cVar.q();
        }
    }
}
