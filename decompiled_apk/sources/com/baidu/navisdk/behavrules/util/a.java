package com.baidu.navisdk.behavrules.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes7.dex */
public class a {
    private static a c;

    /* renamed from: a, reason: collision with root package name */
    protected final Map<Class<?>, CopyOnWriteArraySet<b>> f6659a = new HashMap();
    protected final Map<Class<?>, Object> b = new HashMap();

    /* renamed from: com.baidu.navisdk.behavrules.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0173a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CopyOnWriteArraySet f6660a;
        final /* synthetic */ Object b;

        public RunnableC0173a(CopyOnWriteArraySet copyOnWriteArraySet, Object obj) {
            this.f6660a = copyOnWriteArraySet;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            CopyOnWriteArraySet copyOnWriteArraySet = this.f6660a;
            if (copyOnWriteArraySet != null) {
                Iterator it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    a.this.a((b) it.next(), this.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onEvent(Object obj);
    }

    /* loaded from: classes7.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        private final b f6661a;

        public c(a aVar, b bVar) {
            this.f6661a = bVar;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f6661a.equals(obj);
            }
            return super.equals(obj);
        }
    }

    private a() {
    }

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                try {
                    if (c == null) {
                        c = new a();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public synchronized void a(b bVar, Class<?> cls, Class<?>... clsArr) {
        a(bVar, cls, false);
        if (clsArr != null) {
            for (Class<?> cls2 : clsArr) {
                a(bVar, cls2, false);
            }
        }
    }

    private void a(b bVar, Class<?> cls, boolean z) {
        Object obj;
        if (this.f6659a.containsKey(cls)) {
            this.f6659a.get(cls).add(bVar);
        } else {
            CopyOnWriteArraySet<b> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
            copyOnWriteArraySet.add(bVar);
            this.f6659a.put(cls, copyOnWriteArraySet);
        }
        if (z) {
            synchronized (this.b) {
                obj = this.b.get(cls);
            }
            if (obj != null) {
                a(bVar, obj);
            }
        }
    }

    public synchronized void a(b bVar) {
        Iterator<Class<?>> it = this.f6659a.keySet().iterator();
        while (it.hasNext()) {
            a(it.next(), bVar);
        }
    }

    public synchronized void a(Class<?> cls, b bVar) {
        if (this.f6659a.containsKey(cls)) {
            this.f6659a.get(cls).remove(new c(this, bVar));
        }
    }

    public void a(Object obj) {
        a(obj, 0L, true);
    }

    public void a(Object obj, long j, boolean z) {
        CopyOnWriteArraySet<b> copyOnWriteArraySet;
        if (this.f6659a.containsKey(obj.getClass())) {
            synchronized (this) {
                copyOnWriteArraySet = this.f6659a.get(obj.getClass());
            }
            RunnableC0173a runnableC0173a = new RunnableC0173a(copyOnWriteArraySet, obj);
            if (z) {
                com.baidu.navisdk.behavrules.util.c.a().a(runnableC0173a, j);
            } else {
                com.baidu.navisdk.behavrules.util.c.a().b(runnableC0173a, j);
            }
        }
    }

    public void a(b bVar, Object obj) {
        bVar.onEvent(obj);
    }
}
