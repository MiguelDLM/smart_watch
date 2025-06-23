package com.baidu.navisdk.module.routeresultbase.logic.longdistance.service;

import androidx.annotation.RequiresApi;
import com.baidu.nplatform.comapi.basestruct.c;
import java.util.Objects;

/* loaded from: classes7.dex */
public class a implements com.baidu.navisdk.module.routeresultbase.logic.longdistance.a {

    /* renamed from: a, reason: collision with root package name */
    public String f7521a = null;
    public int b = 0;
    public int c = 0;
    public c d = null;
    public boolean e = true;
    public com.baidu.navisdk.model.service.a f = null;
    public int g = 0;

    public void a(com.baidu.navisdk.module.routeresultbase.logic.longdistance.a aVar) {
        if (aVar instanceof a) {
            a aVar2 = (a) aVar;
            this.f7521a = aVar2.f7521a;
            this.b = aVar2.b;
            this.c = aVar2.c;
            this.e = aVar2.e;
            this.f = aVar2.f;
            this.g = aVar2.g;
            if (aVar2.d != null) {
                this.d = new c(r0.c(), aVar2.d.d());
            }
        }
    }

    @RequiresApi(api = 19)
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            return Objects.equals(this.d, ((a) obj).d);
        }
        return false;
    }

    public int hashCode() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "CarPassServiceInfo{mServiceName='" + this.f7521a + "', mDistance=" + this.b + ", mArriveTime=" + this.c + ", mPoint=" + this.d + ", isCanAdd=" + this.e + ", serviceGasInfo=" + this.f + ", serviceSupport=" + this.g + '}';
    }
}
