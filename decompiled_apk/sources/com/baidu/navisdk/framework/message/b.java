package com.baidu.navisdk.framework.message;

import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.util.worker.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes7.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected final Map<Class<?>, CopyOnWriteArraySet<a.InterfaceC0201a>> f6818a = new HashMap();
    protected final Map<Class<?>, Object> b = new HashMap();

    /* loaded from: classes7.dex */
    public class a extends f<CopyOnWriteArraySet<a.InterfaceC0201a>, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f6819a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, CopyOnWriteArraySet copyOnWriteArraySet, Object obj) {
            super(str, copyOnWriteArraySet);
            this.f6819a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            K k = this.inData;
            if (k == 0) {
                return null;
            }
            Iterator it = ((CopyOnWriteArraySet) k).iterator();
            while (it.hasNext()) {
                b.this.a((a.InterfaceC0201a) it.next(), this.f6819a);
            }
            return null;
        }
    }

    /* renamed from: com.baidu.navisdk.framework.message.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0202b extends f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f6820a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0202b(String str, String str2, Object obj) {
            super(str, str2);
            this.f6820a = obj;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            b.this.a(this.f6820a);
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends f<CopyOnWriteArraySet<a.InterfaceC0201a>, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f6821a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, CopyOnWriteArraySet copyOnWriteArraySet, Object obj) {
            super(str, copyOnWriteArraySet);
            this.f6821a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            K k = this.inData;
            if (k == 0) {
                return null;
            }
            Iterator it = ((CopyOnWriteArraySet) k).iterator();
            while (it.hasNext()) {
                b.this.a((a.InterfaceC0201a) it.next(), this.f6821a);
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class d extends f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f6822a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, String str2, Object obj) {
            super(str, str2);
            this.f6822a = obj;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            b.this.b(this.f6822a);
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        private final a.InterfaceC0201a f6823a;

        public e(b bVar, a.InterfaceC0201a interfaceC0201a) {
            this.f6823a = interfaceC0201a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a.InterfaceC0201a) {
                return this.f6823a.equals(obj);
            }
            return super.equals(obj);
        }
    }

    public synchronized void a(a.InterfaceC0201a interfaceC0201a, Class<?> cls, Class<?>... clsArr) {
        a(interfaceC0201a, cls, false);
        if (clsArr != null) {
            for (Class<?> cls2 : clsArr) {
                a(interfaceC0201a, cls2, false);
            }
        }
    }

    public synchronized void b(a.InterfaceC0201a interfaceC0201a, Class<?> cls, Class<?>... clsArr) {
        a(interfaceC0201a, cls, true);
        if (clsArr != null) {
            for (Class<?> cls2 : clsArr) {
                a(interfaceC0201a, cls2, true);
            }
        }
    }

    public void c(Object obj) {
        synchronized (this.b) {
            this.b.put(obj.getClass(), obj);
        }
        a(obj);
    }

    private void a(a.InterfaceC0201a interfaceC0201a, Class<?> cls, boolean z) {
        Object obj;
        if (this.f6818a.containsKey(cls)) {
            this.f6818a.get(cls).add(interfaceC0201a);
        } else {
            CopyOnWriteArraySet<a.InterfaceC0201a> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
            copyOnWriteArraySet.add(interfaceC0201a);
            this.f6818a.put(cls, copyOnWriteArraySet);
        }
        if (z) {
            synchronized (this.b) {
                obj = this.b.get(cls);
            }
            if (obj != null) {
                a(interfaceC0201a, obj);
            }
        }
    }

    public void b(Object obj) {
        CopyOnWriteArraySet<a.InterfaceC0201a> copyOnWriteArraySet;
        if (this.f6818a.containsKey(obj.getClass())) {
            synchronized (this) {
                copyOnWriteArraySet = this.f6818a.get(obj.getClass());
            }
            com.baidu.navisdk.util.worker.c.a().c(new c("BNMsgCt-postInThread", copyOnWriteArraySet, obj), new com.baidu.navisdk.util.worker.e(200, 0));
        }
    }

    public void b(Object obj, int i) {
        com.baidu.navisdk.util.worker.c.a().b(new d("BNMsgCt-postDelayInThread", null, obj), new com.baidu.navisdk.util.worker.e(200, 0), i);
    }

    public synchronized void a(a.InterfaceC0201a interfaceC0201a) {
        Iterator<Class<?>> it = this.f6818a.keySet().iterator();
        while (it.hasNext()) {
            a(it.next(), interfaceC0201a);
        }
    }

    public synchronized void a(Class<?> cls, a.InterfaceC0201a interfaceC0201a) {
        if (this.f6818a.containsKey(cls)) {
            this.f6818a.get(cls).remove(new e(this, interfaceC0201a));
        }
    }

    public void a(Object obj) {
        CopyOnWriteArraySet<a.InterfaceC0201a> copyOnWriteArraySet;
        if (this.f6818a.containsKey(obj.getClass())) {
            synchronized (this) {
                copyOnWriteArraySet = this.f6818a.get(obj.getClass());
            }
            com.baidu.navisdk.util.worker.c.a().a((f) new a("BNMsgCt-post", copyOnWriteArraySet, obj), new com.baidu.navisdk.util.worker.e(200, 0));
        }
    }

    public void a(Object obj, int i) {
        com.baidu.navisdk.util.worker.c.a().a(new C0202b("BNMsgCt-postDelay", null, obj), new com.baidu.navisdk.util.worker.e(200, 0), i);
    }

    public Object a(Class<?> cls) {
        Object remove;
        synchronized (this.b) {
            remove = this.b.remove(cls);
        }
        return remove;
    }

    public void a(a.InterfaceC0201a interfaceC0201a, Object obj) {
        interfaceC0201a.onEvent(obj);
    }
}
