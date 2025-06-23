package com.kwad.framework.filedownloader.b;

import android.util.SparseArray;
import com.kwad.framework.filedownloader.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public final class b implements com.kwad.framework.filedownloader.b.a {
    final SparseArray<com.kwad.framework.filedownloader.d.c> agd = new SparseArray<>();
    final SparseArray<List<com.kwad.framework.filedownloader.d.a>> age = new SparseArray<>();

    /* loaded from: classes11.dex */
    public class a implements a.InterfaceC0824a {
        public a() {
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0824a
        public final void a(int i, com.kwad.framework.filedownloader.d.c cVar) {
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0824a
        public final void c(com.kwad.framework.filedownloader.d.c cVar) {
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwad.framework.filedownloader.d.c> iterator() {
            return new C0825b();
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0824a
        public final void vK() {
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0825b implements Iterator<com.kwad.framework.filedownloader.d.c> {
        public C0825b() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final /* bridge */ /* synthetic */ com.kwad.framework.filedownloader.d.c next() {
            return null;
        }

        @Override // java.util.Iterator
        public final void remove() {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, long j, String str, String str2) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(int i, long j) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bj(int i) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c bk(int i) {
        com.kwad.framework.filedownloader.d.c cVar;
        synchronized (this.agd) {
            cVar = this.agd.get(i);
        }
        return cVar;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final List<com.kwad.framework.filedownloader.d.a> bl(int i) {
        List<com.kwad.framework.filedownloader.d.a> list;
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (this.age) {
                list = this.age.get(i);
            }
            if (list != null) {
                arrayList.addAll(list);
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bm(int i) {
        try {
            synchronized (this.age) {
                this.age.remove(i);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean bn(int i) {
        synchronized (this.agd) {
            this.agd.remove(i);
        }
        return true;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bo(int i) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i, long j) {
        bn(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        synchronized (this.agd) {
            this.agd.clear();
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i, long j) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void s(int i, int i2) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0824a vJ() {
        return new a();
    }

    private void d(com.kwad.framework.filedownloader.d.c cVar) {
        synchronized (this.agd) {
            this.agd.put(cVar.getId(), cVar);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, String str, long j, long j2, int i2) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
            return;
        }
        if (bk(cVar.getId()) != null) {
            synchronized (this.agd) {
                this.agd.remove(cVar.getId());
                this.agd.put(cVar.getId(), cVar);
            }
            return;
        }
        d(cVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th, long j) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        List<com.kwad.framework.filedownloader.d.a> list;
        try {
            int id = aVar.getId();
            synchronized (this.age) {
                try {
                    list = this.age.get(id);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.age.put(id, list);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            list.add(aVar);
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, int i2, long j) {
        List<com.kwad.framework.filedownloader.d.a> list;
        synchronized (this.age) {
            list = this.age.get(i);
        }
        if (list == null) {
            return;
        }
        for (com.kwad.framework.filedownloader.d.a aVar : list) {
            if (aVar.getIndex() == i2) {
                aVar.Q(j);
                return;
            }
        }
    }
}
