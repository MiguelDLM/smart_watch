package com.baidu.ar;

import java.util.Queue;

/* loaded from: classes7.dex */
public class pt implements pq {
    qb Ka;
    Queue<pw> Kb;
    String name;

    public pt(qb qbVar, Queue<pw> queue) {
        this.Ka = qbVar;
        this.name = qbVar.getName();
        this.Kb = queue;
    }

    private void a(pu puVar, ps psVar, String str, Object[] objArr, Throwable th) {
        pw pwVar = new pw();
        pwVar.p(System.currentTimeMillis());
        pwVar.a(puVar);
        pwVar.a(this.Ka);
        pwVar.setLoggerName(this.name);
        pwVar.a(psVar);
        pwVar.setMessage(str);
        pwVar.a(objArr);
        pwVar.b(th);
        pwVar.cS(Thread.currentThread().getName());
        this.Kb.add(pwVar);
    }

    @Override // com.baidu.ar.pq
    public void b(String str, Object obj) {
        a(pu.TRACE, str, new Object[]{obj}, null);
    }

    @Override // com.baidu.ar.pq
    public void cP(String str) {
        a(pu.TRACE, str, null, null);
    }

    @Override // com.baidu.ar.pq
    public void cQ(String str) {
        a(pu.ERROR, str, null, null);
    }

    @Override // com.baidu.ar.pq
    public String getName() {
        return this.name;
    }

    @Override // com.baidu.ar.pq
    public boolean isTraceEnabled() {
        return true;
    }

    private void a(pu puVar, String str, Object[] objArr, Throwable th) {
        a(puVar, null, str, objArr, th);
    }

    @Override // com.baidu.ar.pq
    public void b(String str, Throwable th) {
        a(pu.ERROR, str, null, th);
    }

    @Override // com.baidu.ar.pq
    public void a(String str, Object obj, Object obj2) {
        a(pu.TRACE, str, new Object[]{obj, obj2}, null);
    }

    @Override // com.baidu.ar.pq
    public void a(String str, Throwable th) {
        a(pu.TRACE, str, null, th);
    }
}
