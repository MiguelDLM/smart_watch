package com.baidu.ar;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;

/* loaded from: classes7.dex */
public class qb implements pq {
    private Queue<pw> Kb;
    private volatile pq Ks;
    private Boolean Kt;
    private Method Ku;
    private pt Kv;
    private final boolean Kw;
    private final String name;

    public qb(String str, Queue<pw> queue, boolean z) {
        this.name = str;
        this.Kb = queue;
        this.Kw = z;
    }

    private pq kd() {
        if (this.Kv == null) {
            this.Kv = new pt(this, this.Kb);
        }
        return this.Kv;
    }

    public void a(pq pqVar) {
        this.Ks = pqVar;
    }

    @Override // com.baidu.ar.pq
    public void b(String str, Object obj) {
        kc().b(str, obj);
    }

    @Override // com.baidu.ar.pq
    public void cP(String str) {
        kc().cP(str);
    }

    @Override // com.baidu.ar.pq
    public void cQ(String str) {
        kc().cQ(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.name.equals(((qb) obj).name);
    }

    @Override // com.baidu.ar.pq
    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    @Override // com.baidu.ar.pq
    public boolean isTraceEnabled() {
        return kc().isTraceEnabled();
    }

    public pq kc() {
        return this.Ks != null ? this.Ks : this.Kw ? py.Kr : kd();
    }

    public boolean ke() {
        Boolean bool = this.Kt;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.Ku = this.Ks.getClass().getMethod("log", pv.class);
            this.Kt = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.Kt = Boolean.FALSE;
        }
        return this.Kt.booleanValue();
    }

    public boolean kf() {
        return this.Ks == null;
    }

    public boolean kg() {
        return this.Ks instanceof py;
    }

    public void a(pv pvVar) {
        if (ke()) {
            try {
                this.Ku.invoke(this.Ks, pvVar);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    @Override // com.baidu.ar.pq
    public void b(String str, Throwable th) {
        kc().b(str, th);
    }

    @Override // com.baidu.ar.pq
    public void a(String str, Object obj, Object obj2) {
        kc().a(str, obj, obj2);
    }

    @Override // com.baidu.ar.pq
    public void a(String str, Throwable th) {
        kc().a(str, th);
    }
}
