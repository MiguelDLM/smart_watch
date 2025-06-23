package com.kwad.components.core.j;

import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public final class a {
    private CopyOnWriteArrayList<b> MM = new CopyOnWriteArrayList<>();
    private volatile boolean MN;

    /* renamed from: com.kwad.components.core.j.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C0794a {
        private static final a MO = new a();
    }

    /* loaded from: classes11.dex */
    public static class b {
        private final c MP;
        public boolean MQ;

        public b(c cVar) {
            this.MP = cVar;
        }
    }

    /* loaded from: classes11.dex */
    public interface c {
        void bk();
    }

    public static boolean b(b bVar) {
        if (bVar == null) {
            return true;
        }
        return bVar.MQ;
    }

    public static a pf() {
        return C0794a.MO;
    }

    public final void a(b bVar) {
        if (this.MM.contains(bVar)) {
            return;
        }
        if (!this.MN) {
            this.MN = true;
            bVar.MQ = true;
        }
        this.MM.add(bVar);
    }

    public final void c(b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.MQ) {
            bVar.MQ = false;
            this.MN = false;
        }
        this.MM.remove(bVar);
        if (this.MM.size() == 0 || this.MN) {
            return;
        }
        this.MM.get(0).MQ = true;
        this.MN = true;
        this.MM.get(0).MP.bk();
    }
}
