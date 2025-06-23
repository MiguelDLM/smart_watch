package com.baidu.navisdk.framework;

import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private Vector<b> f6800a = new Vector<>();

    /* loaded from: classes7.dex */
    public static abstract class a {
        public abstract boolean a(e eVar, int i, Object obj);

        public final boolean b(e eVar, int i, Object obj) {
            boolean a2 = a(eVar, i, obj);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGStateMsgDispatcher", "executeInner,stateType:" + i + ",careState:" + obj + ",ret:" + a2 + ",observer:" + eVar);
            }
            return a2;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private e f6801a;
        private C0198c b;

        public b(e eVar) {
            this.f6801a = eVar;
            this.b = eVar.a();
        }

        private static boolean a(Object obj, Object obj2) {
            return obj == obj2 || (obj != null && obj.equals(obj2));
        }

        public C0198c b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                return a(this.f6801a, ((b) obj).f6801a);
            }
            return false;
        }

        public int hashCode() {
            return a(this.f6801a);
        }

        private static int a(Object... objArr) {
            return Arrays.hashCode(objArr);
        }

        public e a() {
            return this.f6801a;
        }
    }

    /* renamed from: com.baidu.navisdk.framework.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0198c {

        /* renamed from: a, reason: collision with root package name */
        private e f6802a;
        private HashMap<String, a> b = new HashMap<>();
        private HashMap<Integer, a> c = new HashMap<>();
        private HashMap<Integer, a> d = new HashMap<>();
        private HashMap<Integer, a> e = new HashMap<>();
        private HashMap<Integer, a> f = new HashMap<>();
        private HashMap<Integer, a> g = new HashMap<>();

        public C0198c(e eVar) {
            this.f6802a = eVar;
        }

        public e a() {
            return this.f6802a;
        }

        public C0198c b(int i, a aVar) {
            this.g.put(Integer.valueOf(i), aVar);
            return this;
        }

        public a a(int i, Object obj) {
            switch (i) {
                case 11:
                    return this.b.get(obj);
                case 12:
                    return this.c.get(obj);
                case 13:
                    return this.d.get(obj);
                case 14:
                    return this.e.get(obj);
                case 15:
                    return this.f.get(obj);
                case 16:
                    return this.g.get(obj);
                default:
                    return null;
            }
        }

        public C0198c b(Integer num, a aVar) {
            this.e.put(num, aVar);
            return this;
        }

        public C0198c a(String str, a aVar) {
            this.b.put(str, aVar);
            return this;
        }

        public C0198c a(Integer num, a aVar) {
            this.d.put(num, aVar);
            return this;
        }

        public C0198c a(int i, a aVar) {
            this.f.put(Integer.valueOf(i), aVar);
            return this;
        }
    }

    /* loaded from: classes7.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public static final c f6803a = new c();
    }

    /* loaded from: classes7.dex */
    public interface e {
        C0198c a();
    }

    public static c b() {
        return d.f6803a;
    }

    public synchronized void a(e eVar) {
        try {
            if (eVar == null) {
                if (g.VDR.b()) {
                    throw new NullPointerException("RGStateMsgDispatcher-addObserver-");
                }
            } else {
                b bVar = new b(eVar);
                if (!this.f6800a.contains(bVar)) {
                    this.f6800a.addElement(bVar);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void b(e eVar) {
        if (eVar != null) {
            Vector<b> vector = this.f6800a;
            if (vector != null && vector.size() > 0) {
                this.f6800a.removeElement(eVar);
            }
        }
    }

    public void a(Object obj, int i) {
        Object[] array;
        a a2;
        synchronized (this) {
            array = this.f6800a.toArray();
        }
        for (int length = array.length - 1; length >= 0; length--) {
            b bVar = (b) array[length];
            if (bVar != null && bVar.a() != null) {
                C0198c b2 = bVar.b();
                if (b2 == null) {
                    b2 = bVar.a().a();
                }
                if (b2 != null && (a2 = b2.a(i, obj)) != null) {
                    a2.b(b2.a(), i, obj);
                }
            }
        }
    }

    public synchronized void a() {
        this.f6800a.removeAllElements();
    }
}
