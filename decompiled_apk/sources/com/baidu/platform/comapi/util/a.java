package com.baidu.platform.comapi.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f9686a = new a();
    private static final String b = "com.baidu.platform.comapi.util.a";
    private final Map<Class<?>, CopyOnWriteArraySet<C0531a>> c = new HashMap();
    private final Map<Class<?>, Object> d = new HashMap();

    /* renamed from: com.baidu.platform.comapi.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0531a implements b {

        /* renamed from: a, reason: collision with root package name */
        private final b f9688a;

        @Override // com.baidu.platform.comapi.util.a.b
        public void a(Object obj) {
            this.f9688a.a(obj);
        }

        public boolean equals(Object obj) {
            return this.f9688a.equals(obj);
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(Object obj);
    }

    private a() {
    }

    public static a a() {
        return f9686a;
    }

    public void a(Object obj) {
        CopyOnWriteArraySet<C0531a> copyOnWriteArraySet;
        if (this.c.containsKey(obj.getClass())) {
            synchronized (this) {
                copyOnWriteArraySet = this.c.get(obj.getClass());
            }
            Iterator<C0531a> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                j.a(new com.baidu.platform.comapi.util.b(this, it.next(), obj), 0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar, Object obj) {
        bVar.a(obj);
    }
}
