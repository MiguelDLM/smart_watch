package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.internal.bj;
import java.util.HashMap;

/* loaded from: classes7.dex */
class bm implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IOAdEvent f6251a;
    final /* synthetic */ bj.a b;

    public bm(bj.a aVar, IOAdEvent iOAdEvent) {
        this.b = aVar;
        this.f6251a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap hashMap;
        IOAdEvent iOAdEvent = this.f6251a;
        if (iOAdEvent != null && !TextUtils.isEmpty(iOAdEvent.getType())) {
            String type = this.f6251a.getType();
            if (x.K.equals(type)) {
                bj.this.a(this.f6251a);
                return;
            }
            if (x.N.equals(type)) {
                bj.this.n = this.f6251a.getMessage();
                bj.this.q();
                return;
            }
            if (x.O.equals(type)) {
                bj.this.e(this.f6251a);
                return;
            }
            if (x.P.equals(type)) {
                bj.this.f(this.f6251a);
                return;
            }
            if (x.X.equals(type)) {
                bj.this.g(this.f6251a);
                return;
            }
            String str = "";
            boolean z = false;
            int i = 0;
            int i2 = 0;
            r5 = false;
            boolean z2 = false;
            boolean z3 = false;
            if (x.s.equals(type)) {
                HashMap hashMap2 = (HashMap) this.f6251a.getData();
                if (hashMap2 != null) {
                    str = (String) hashMap2.get("error_message");
                    Object obj = hashMap2.get("error_code");
                    Object obj2 = obj;
                    if (obj == null) {
                        obj2 = 0;
                    }
                    i = ((Integer) obj2).intValue();
                }
                bj.this.b(str, i);
                return;
            }
            if (x.M.equals(type)) {
                HashMap hashMap3 = (HashMap) this.f6251a.getData();
                if (hashMap3 != null) {
                    str = (String) hashMap3.get("error_message");
                    Object obj3 = hashMap3.get("error_code");
                    Object obj4 = obj3;
                    if (obj3 == null) {
                        obj4 = 0;
                    }
                    i2 = ((Integer) obj4).intValue();
                }
                bj.this.a(i2, str);
                return;
            }
            if (x.I.equals(type)) {
                bj.this.h(this.f6251a);
                return;
            }
            if (x.Y.equals(type)) {
                bj.this.d();
                return;
            }
            if (x.Z.equals(type)) {
                bj.this.d(this.f6251a);
                return;
            }
            if (x.ab.equals(type)) {
                bj.this.s();
                return;
            }
            if (x.ac.equals(type)) {
                IOAdEvent iOAdEvent2 = this.f6251a;
                if (iOAdEvent2 != null && (hashMap = (HashMap) iOAdEvent2.getData()) != null) {
                    z2 = "1".equals((String) hashMap.get("serverVerify"));
                }
                bj.this.b(z2);
                return;
            }
            if (x.ad.equals(type)) {
                bj.this.b_();
                return;
            }
            if (x.ae.equals(type)) {
                bj.this.c_();
                return;
            }
            if (x.L.equals(type)) {
                bj.this.b(this.f6251a);
                return;
            }
            if (x.af.equals(type)) {
                bj bjVar = bj.this;
                String message = this.f6251a.getMessage();
                if (1 == this.f6251a.getCode()) {
                    z3 = true;
                }
                bjVar.a(message, z3);
                return;
            }
            if (x.ag.equals(type)) {
                bj.this.e(this.f6251a.getMessage());
                return;
            }
            if (x.ah.equals(type)) {
                bj.this.f(this.f6251a.getMessage());
                return;
            }
            if (x.ai.equals(type)) {
                bj.this.d(this.f6251a.getMessage());
                return;
            }
            if (x.E.equals(type)) {
                bj.this.g(this.f6251a.getMessage());
                return;
            }
            if (x.aa.equals(type)) {
                bj.this.t();
                return;
            }
            if (x.aj.equals(type)) {
                bj bjVar2 = bj.this;
                String message2 = this.f6251a.getMessage();
                if (1 == this.f6251a.getCode()) {
                    z = true;
                }
                bjVar2.b(message2, z);
                return;
            }
            if (x.am.equals(type)) {
                bj.this.c(this.f6251a);
                return;
            }
            if (x.ak.equals(type)) {
                bj.this.u();
                return;
            }
            if (x.al.equals(type)) {
                bj.this.v();
                return;
            }
            if (x.ao.equals(type)) {
                bj.this.i(this.f6251a);
            } else if (x.ap.equals(type)) {
                bj.this.j(this.f6251a);
            } else if (x.an.equals(type)) {
                bj.this.k(this.f6251a);
            }
        }
    }
}
