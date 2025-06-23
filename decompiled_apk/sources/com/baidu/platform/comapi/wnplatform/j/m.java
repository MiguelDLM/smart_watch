package com.baidu.platform.comapi.wnplatform.j;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class m extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f9930a;

    public m(l lVar) {
        this.f9930a = lVar;
    }

    @Override // android.os.Handler
    @SuppressLint({"HandlerLeak"})
    public void handleMessage(Message message) {
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        e eVar;
        e eVar2;
        List list6;
        List list7;
        List list8;
        e eVar3;
        e eVar4;
        List list9;
        List list10;
        int i;
        Bundle a2;
        int i2;
        List list11;
        List list12;
        List list13;
        int i3;
        Bundle a3;
        int i4;
        com.baidu.platform.comapi.wnplatform.d.a.b("WRoutePlaner", "msg.arg1" + message.arg1 + "; msg.what" + message.what);
        int i5 = message.what;
        if (i5 == 4099) {
            int i6 = message.arg1;
            int i7 = message.arg2;
            if (i6 == 0) {
                Bundle bundle = new Bundle();
                if (com.baidu.platform.comapi.walknavi.b.a().K().c(bundle)) {
                    com.baidu.platform.comapi.wnplatform.model.f.a().a(message.what, 0, 0, bundle);
                }
            }
            if (i6 == 0 && com.baidu.platform.comapi.wnplatform.f.a().c()) {
                if (com.baidu.platform.comapi.walknavi.b.a().Z().a(this.f9930a.b())) {
                    com.baidu.platform.comapi.wnplatform.model.b Z = com.baidu.platform.comapi.walknavi.b.a().Z();
                    l lVar = this.f9930a;
                    i3 = lVar.e;
                    a3 = lVar.a(i3);
                    i4 = this.f9930a.e;
                    Z.a(a3, i4);
                }
                list11 = this.f9930a.d;
                if (list11 != null) {
                    list12 = this.f9930a.d;
                    if (list12.size() > 0) {
                        list13 = this.f9930a.d;
                        Iterator it = list13.iterator();
                        while (it.hasNext()) {
                            ((g) it.next()).c();
                        }
                    }
                }
            }
            if (i7 != 1 && i7 != 0) {
                return;
            }
            if (i6 != 0) {
                list5 = this.f9930a.d;
                if (list5 != null) {
                    list6 = this.f9930a.d;
                    if (list6.size() > 0) {
                        list7 = this.f9930a.d;
                        Iterator it2 = list7.iterator();
                        while (it2.hasNext()) {
                            ((g) it2.next()).a(i6);
                        }
                    }
                }
                eVar = this.f9930a.b;
                if (eVar != null) {
                    eVar2 = this.f9930a.b;
                    eVar2.a(i6);
                    return;
                }
                return;
            }
            if (com.baidu.platform.comapi.walknavi.b.a().Z().a(this.f9930a.b())) {
                com.baidu.platform.comapi.wnplatform.model.b Z2 = com.baidu.platform.comapi.walknavi.b.a().Z();
                l lVar2 = this.f9930a;
                i = lVar2.e;
                a2 = lVar2.a(i);
                i2 = this.f9930a.e;
                Z2.a(a2, i2);
            }
            list8 = this.f9930a.d;
            if (list8 != null) {
                list9 = this.f9930a.d;
                if (list9.size() > 0) {
                    list10 = this.f9930a.d;
                    Iterator it3 = list10.iterator();
                    while (it3.hasNext()) {
                        ((g) it3.next()).b();
                    }
                }
            }
            eVar3 = this.f9930a.b;
            if (eVar3 != null) {
                eVar4 = this.f9930a.b;
                eVar4.a();
                return;
            }
            return;
        }
        if (i5 == 2008 && com.baidu.platform.comapi.wnplatform.f.a().g()) {
            list = this.f9930a.c;
            if (list != null) {
                list2 = this.f9930a.c;
                if (list2.size() > 0 && !com.baidu.platform.comapi.walknavi.b.a().h()) {
                    if (com.baidu.platform.comapi.walknavi.b.a().Z().a(this.f9930a.a())) {
                        this.f9930a.g = true;
                        list4 = this.f9930a.c;
                        Iterator it4 = list4.iterator();
                        while (it4.hasNext()) {
                            ((f) it4.next()).b();
                        }
                        return;
                    }
                    this.f9930a.g = false;
                    list3 = this.f9930a.c;
                    Iterator it5 = list3.iterator();
                    while (it5.hasNext()) {
                        ((f) it5.next()).a(message.arg1);
                    }
                }
            }
        }
    }
}
