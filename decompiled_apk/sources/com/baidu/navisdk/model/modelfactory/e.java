package com.baidu.navisdk.model.modelfactory;

import com.baidu.navisdk.model.datastruct.s;
import com.baidu.navisdk.model.datastruct.t;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class e extends a {

    /* renamed from: a, reason: collision with root package name */
    private s f6951a;
    private List<t> b;
    private ArrayList<Object> c;
    private GeoPoint d;

    public e() {
        new ArrayList();
        new ArrayList();
        this.f6951a = new s();
        this.b = new ArrayList();
        this.c = new ArrayList<>(0);
    }

    public void a(s sVar) {
        if (sVar == null) {
            return;
        }
        s sVar2 = new s();
        this.f6951a = sVar2;
        sVar2.a(sVar);
    }

    public s b() {
        return this.f6951a;
    }

    public GeoPoint c() {
        return this.d;
    }

    public List<t> d() {
        return this.b;
    }

    public void a(t tVar) {
        if (tVar == null) {
            return;
        }
        t h = tVar.h();
        if (h == null) {
            this.b.clear();
        } else if (this.b.size() > 0) {
            if (!h.equals(this.b.get(r1.size() - 1))) {
                this.b.clear();
            }
        }
        this.b.add(tVar);
    }

    public void a() {
        ArrayList<Object> arrayList = this.c;
        if (arrayList != null) {
            try {
                arrayList.clear();
            } catch (Exception unused) {
            }
        }
    }
}
