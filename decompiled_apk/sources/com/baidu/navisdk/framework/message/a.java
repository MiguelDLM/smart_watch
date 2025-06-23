package com.baidu.navisdk.framework.message;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes7.dex */
public class a extends b {
    private static a c;

    /* renamed from: com.baidu.navisdk.framework.message.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0201a {
        void onEvent(Object obj);
    }

    private a() {
    }

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                c = new a();
            }
        }
        return c;
    }

    public void d(Object obj) {
        CopyOnWriteArraySet<InterfaceC0201a> copyOnWriteArraySet;
        if (this.f6818a.containsKey(obj.getClass())) {
            synchronized (this) {
                copyOnWriteArraySet = this.f6818a.get(obj.getClass());
            }
            Iterator<InterfaceC0201a> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                a(it.next(), obj);
            }
        }
    }
}
