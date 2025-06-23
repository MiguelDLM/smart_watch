package com.baidu.navisdk.apm.cpu;

import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.worker.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private List<com.baidu.navisdk.module.cpu.a> f6537a;
    private List<com.baidu.navisdk.module.cpu.a> b;
    private long c = -1;
    private long d = -1;
    private boolean e = false;

    /* loaded from: classes7.dex */
    public class a extends f<String, String> {
        public a(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            b.this.f();
            return null;
        }
    }

    /* renamed from: com.baidu.navisdk.apm.cpu.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0167b extends f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f6539a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0167b(String str, String str2, e eVar) {
            super(str, str2);
            this.f6539a = eVar;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            b.this.g();
            b.this.a((List<com.baidu.navisdk.module.cpu.b>) b.this.e(), this.f6539a);
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f6540a;
        final /* synthetic */ List b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, String str, String str2, e eVar, List list) {
            super(str, str2);
            this.f6540a = eVar;
            this.b = list;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            e eVar = this.f6540a;
            if (eVar == null) {
                return null;
            }
            eVar.a(this.b);
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Comparator<com.baidu.navisdk.module.cpu.b> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.baidu.navisdk.module.cpu.b bVar, com.baidu.navisdk.module.cpu.b bVar2) {
            if (bVar.b() > bVar2.b()) {
                return -1;
            }
            if (bVar.b() == bVar2.b()) {
                return 0;
            }
            return 1;
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(List<com.baidu.navisdk.module.cpu.b> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.navisdk.module.cpu.b> e() {
        List<com.baidu.navisdk.module.cpu.a> list;
        List<com.baidu.navisdk.module.cpu.a> list2;
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.c;
        if (j != -1) {
            long j2 = this.d;
            if (j2 != -1 && (list = this.f6537a) != null && (list2 = this.b) != null) {
                List<com.baidu.navisdk.module.cpu.b> a2 = a(j, j2, list, list2);
                g gVar = g.HEAT_MONITOR;
                if (gVar.d()) {
                    gVar.e("BNThreadCPUCollector", "collect() cost time = " + (System.currentTimeMillis() - currentTimeMillis));
                }
                return a2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.e) {
            return;
        }
        this.f6537a = com.baidu.navisdk.apm.cpu.a.a();
        this.c = com.baidu.navisdk.apm.cpu.a.c();
        this.e = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!this.e) {
            return;
        }
        this.b = com.baidu.navisdk.apm.cpu.a.a();
        this.d = com.baidu.navisdk.apm.cpu.a.c();
        this.e = false;
    }

    public List<com.baidu.navisdk.module.cpu.a> d() {
        return this.b;
    }

    public long b() {
        return this.d;
    }

    public List<com.baidu.navisdk.module.cpu.a> c() {
        return this.f6537a;
    }

    public void a(int i, e eVar) {
        com.baidu.navisdk.util.worker.c.a().c(new a("BNThreadCPUCollectorstart", null), new com.baidu.navisdk.util.worker.e(202, 0));
        com.baidu.navisdk.util.worker.c.a().a(new C0167b("BNThreadCPUCollectorstart", null, eVar), new com.baidu.navisdk.util.worker.e(202, 0), i * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<com.baidu.navisdk.module.cpu.b> list, e eVar) {
        com.baidu.navisdk.util.worker.c.a().a((f) new c(this, "BNThreadCPUCollectorstart", null, eVar, list), new com.baidu.navisdk.util.worker.e(202, 0));
    }

    public static List<com.baidu.navisdk.module.cpu.b> a(long j, long j2, List<com.baidu.navisdk.module.cpu.a> list, List<com.baidu.navisdk.module.cpu.a> list2) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list2 != null) {
            long j3 = j2 - j;
            for (com.baidu.navisdk.module.cpu.a aVar : list) {
                Iterator<com.baidu.navisdk.module.cpu.a> it = list2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        com.baidu.navisdk.module.cpu.a next = it.next();
                        if (aVar != null && next != null && aVar.equals(next)) {
                            arrayList.add(new com.baidu.navisdk.module.cpu.b(aVar.f7147a, aVar.b, (float) (((next.c - aVar.c) * 100) / j3)));
                            break;
                        }
                    }
                }
            }
            Collections.sort(arrayList, new d());
        }
        return arrayList;
    }

    public long a() {
        return this.c;
    }
}
