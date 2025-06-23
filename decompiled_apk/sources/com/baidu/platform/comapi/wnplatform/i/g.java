package com.baidu.platform.comapi.wnplatform.i;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.platform.comapi.walknavi.e.j;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class g extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f9920a;

    public g(f fVar) {
        this.f9920a = fVar;
    }

    @Override // android.os.Handler
    @SuppressLint({"HandlerLeak"})
    public void handleMessage(Message message) {
        com.baidu.platform.comapi.walknavi.h.b bVar;
        List list;
        List<a> list2;
        List list3;
        List<a> list4;
        List list5;
        List<a> list6;
        List list7;
        List<a> list8;
        List list9;
        List<a> list10;
        List list11;
        List<a> list12;
        List list13;
        List<a> list14;
        int i = message.what;
        if (i == 4098) {
            this.f9920a.a(message);
            com.baidu.platform.comapi.wnplatform.model.f.a().a(message.what, message.arg1, message.arg2, null);
            return;
        }
        if (i != 4113) {
            if (i != 65301) {
                if (i != 4110) {
                    if (i != 4111) {
                        switch (i) {
                            case 4100:
                                list = this.f9920a.f9919a;
                                if (list != null) {
                                    Bundle bundle = new Bundle();
                                    com.baidu.platform.comapi.walknavi.b.a().K().a(bundle);
                                    list2 = this.f9920a.f9919a;
                                    for (a aVar : list2) {
                                        if (aVar != null) {
                                            aVar.b(bundle);
                                        }
                                    }
                                    return;
                                }
                                return;
                            case 4101:
                                list3 = this.f9920a.f9919a;
                                if (list3 != null) {
                                    Bundle bundle2 = new Bundle();
                                    com.baidu.platform.comapi.walknavi.h.b.a.a(bundle2, 2, message.arg1, message.arg2);
                                    com.baidu.platform.comapi.wnplatform.model.f.a().a(message.what, message.arg1, message.arg2, bundle2);
                                    list4 = this.f9920a.f9919a;
                                    for (a aVar2 : list4) {
                                        if (aVar2 != null) {
                                            aVar2.c(bundle2);
                                        }
                                    }
                                    return;
                                }
                                return;
                            case 4102:
                                list5 = this.f9920a.f9919a;
                                if (list5 != null) {
                                    list6 = this.f9920a.f9919a;
                                    for (a aVar3 : list6) {
                                        if (aVar3 != null) {
                                            aVar3.f(null);
                                        }
                                    }
                                    return;
                                }
                                return;
                            default:
                                switch (i) {
                                    case 4105:
                                        list7 = this.f9920a.f9919a;
                                        if (list7 != null) {
                                            byte[] m = com.baidu.platform.comapi.walknavi.b.a().K().m();
                                            list8 = this.f9920a.f9919a;
                                            for (a aVar4 : list8) {
                                                if (aVar4 != null) {
                                                    aVar4.a(m);
                                                }
                                            }
                                            return;
                                        }
                                        return;
                                    case 4106:
                                        list9 = this.f9920a.f9919a;
                                        if (list9 != null) {
                                            Bundle q = com.baidu.platform.comapi.walknavi.b.a().K().q();
                                            list10 = this.f9920a.f9919a;
                                            for (a aVar5 : list10) {
                                                if (aVar5 != null) {
                                                    aVar5.e(q);
                                                }
                                            }
                                            return;
                                        }
                                        return;
                                    case 4107:
                                        list11 = this.f9920a.f9919a;
                                        if (list11 != null) {
                                            Bundle bundle3 = new Bundle();
                                            com.baidu.platform.comapi.walknavi.b.a().a(bundle3);
                                            list12 = this.f9920a.f9919a;
                                            for (a aVar6 : list12) {
                                                if (aVar6 != null) {
                                                    aVar6.a(bundle3);
                                                }
                                            }
                                        }
                                        if (!j.b()) {
                                            this.f9920a.g();
                                            return;
                                        }
                                        return;
                                    case 4108:
                                        list13 = this.f9920a.f9919a;
                                        if (list13 != null) {
                                            Bundle bundle4 = new Bundle();
                                            com.baidu.platform.comapi.walknavi.b.a().K().f(bundle4);
                                            list14 = this.f9920a.f9919a;
                                            for (a aVar7 : list14) {
                                                if (aVar7 != null) {
                                                    aVar7.d(bundle4);
                                                }
                                            }
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                        }
                    }
                    int i2 = message.arg1;
                    if ((com.baidu.platform.comapi.walknavi.b.a().Y() instanceof com.baidu.platform.comapi.walknavi.h.b) && (bVar = (com.baidu.platform.comapi.walknavi.h.b) com.baidu.platform.comapi.walknavi.b.a().Y()) != null) {
                        bVar.a(RouteGuideKind.values()[i2]);
                        return;
                    }
                    return;
                }
                j.a(false);
                return;
            }
            int i3 = message.arg1;
            if (i3 != 1 && i3 == 0 && com.baidu.platform.comapi.walknavi.b.a().Y() != null) {
                com.baidu.platform.comapi.walknavi.b.a().Y().v();
                return;
            }
            return;
        }
        Bundle bundle5 = new Bundle();
        if (com.baidu.platform.comapi.walknavi.b.a().K().b(bundle5)) {
            com.baidu.platform.comapi.wnplatform.model.f.a().a(message.what, message.arg1, message.arg2, bundle5);
        }
    }
}
