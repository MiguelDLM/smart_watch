package com.baidu.platform.comapi.wnplatform.i;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mapsdkplatform.comapi.map.MessageCenter;
import com.baidu.platform.comapi.walknavi.e.j;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes8.dex */
public class f extends com.baidu.platform.comapi.walknavi.a {
    private static int d;

    /* renamed from: a, reason: collision with root package name */
    private List<a> f9919a;
    private List<b> b;
    private Handler c = new g(this);
    private com.baidu.platform.comapi.wnplatform.k.b e = new h(this);
    private com.baidu.platform.comapi.wnplatform.c.b f = new i(this);

    public static /* synthetic */ int a() {
        int i = d;
        d = i + 1;
        return i;
    }

    private void c() {
        MessageCenter.registMessage(65301, this.c);
        MessageCenter.registMessage(4098, this.c);
        MessageCenter.registMessage(4100, this.c);
        MessageCenter.registMessage(4101, this.c);
        MessageCenter.registMessage(4102, this.c);
        MessageCenter.registMessage(4105, this.c);
        MessageCenter.registMessage(4106, this.c);
        MessageCenter.registMessage(4107, this.c);
        MessageCenter.registMessage(4111, this.c);
        MessageCenter.registMessage(4110, this.c);
        MessageCenter.registMessage(4108, this.c);
        MessageCenter.registMessage(4113, this.c);
    }

    private void d() {
        MessageCenter.unregistMessage(4098, this.c);
        MessageCenter.unregistMessage(4100, this.c);
        MessageCenter.unregistMessage(4101, this.c);
        MessageCenter.unregistMessage(4102, this.c);
        MessageCenter.unregistMessage(4105, this.c);
        MessageCenter.unregistMessage(4106, this.c);
        MessageCenter.unregistMessage(4107, this.c);
        MessageCenter.unregistMessage(4111, this.c);
        MessageCenter.unregistMessage(4110, this.c);
        MessageCenter.unregistMessage(4108, this.c);
        MessageCenter.unregistMessage(4113, this.c);
    }

    private void e() {
        MessageCenter.registMessage(4098, this.c);
        MessageCenter.registMessage(4100, this.c);
        MessageCenter.registMessage(4101, this.c);
        MessageCenter.registMessage(4106, this.c);
        MessageCenter.registMessage(4113, this.c);
    }

    private void f() {
        MessageCenter.unregistMessage(4098, this.c);
        MessageCenter.unregistMessage(4100, this.c);
        MessageCenter.unregistMessage(4101, this.c);
        MessageCenter.unregistMessage(4106, this.c);
        MessageCenter.unregistMessage(4113, this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (com.baidu.platform.comapi.walknavi.b.a().Y() != null) {
            if (com.baidu.platform.comapi.walknavi.b.a().Y().u() > 0.2d) {
                j.a().a();
            } else {
                j.a().b();
            }
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        if (com.baidu.platform.comapi.walknavi.b.a().R() == 3) {
            e();
        } else {
            c();
        }
        int i = com.baidu.platform.comapi.walknavi.h.b.b.f9767a;
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    com.baidu.platform.comapi.walknavi.b.a().aa().a(this.f);
                    com.baidu.platform.comapi.walknavi.b.a().K().d(3);
                }
            } else {
                com.baidu.platform.comapi.walknavi.b.a().K().d(2);
            }
        } else {
            com.baidu.platform.comapi.walknavi.b.a().X().a(this.f);
            com.baidu.platform.comapi.walknavi.b.a().K().d(1);
        }
        com.baidu.platform.comapi.walknavi.b.a().W().a(this.e);
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        if (com.baidu.platform.comapi.walknavi.b.a().R() == 3) {
            f();
        } else {
            d();
        }
        this.c = null;
        this.f9919a = null;
        this.b = null;
        com.baidu.platform.comapi.walknavi.b.a().X().b(this.f);
        this.f = null;
    }

    public void b(a aVar) {
        List<a> list = this.f9919a;
        if (list == null || aVar == null) {
            return;
        }
        list.remove(aVar);
        this.f9919a = null;
    }

    public void a(a aVar) {
        if (this.f9919a == null) {
            this.f9919a = new LinkedList();
        }
        this.f9919a.add(aVar);
    }

    public void b(b bVar) {
        List<b> list = this.b;
        if (list == null || bVar == null) {
            return;
        }
        list.remove(bVar);
        this.b = null;
    }

    public void a(b bVar) {
        if (this.b == null) {
            this.b = new LinkedList();
        }
        this.b.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        List<b> list = this.b;
        if (list == null) {
            return;
        }
        switch (message.arg1) {
            case 2:
                if (list != null) {
                    for (b bVar : list) {
                        if (bVar != null) {
                            bVar.b(message);
                        }
                    }
                }
                j.a().f();
                return;
            case 3:
                if (list != null) {
                    for (b bVar2 : list) {
                        if (bVar2 != null) {
                            bVar2.c(message);
                        }
                    }
                }
                j.a().g();
                return;
            case 4:
                com.baidu.platform.comapi.walknavi.b.a().Z().a(a(1), 1);
                List<b> list2 = this.b;
                if (list2 != null) {
                    for (b bVar3 : list2) {
                        if (bVar3 != null) {
                            bVar3.d(message);
                        }
                    }
                    return;
                }
                return;
            case 5:
                if (list != null) {
                    for (b bVar4 : list) {
                        if (bVar4 != null) {
                            bVar4.e(message);
                        }
                    }
                    return;
                }
                return;
            case 6:
                if (list != null) {
                    for (b bVar5 : list) {
                        if (bVar5 != null) {
                            bVar5.f(message);
                        }
                    }
                    return;
                }
                return;
            case 7:
                if (com.baidu.platform.comapi.walknavi.e.e.c().d()) {
                    j.a().e();
                    return;
                }
                List<b> list3 = this.b;
                if (list3 != null) {
                    for (b bVar6 : list3) {
                        if (bVar6 != null) {
                            bVar6.g(message);
                        }
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private Bundle a(int i) {
        return com.baidu.platform.comapi.walknavi.b.a().K().b(i);
    }
}
