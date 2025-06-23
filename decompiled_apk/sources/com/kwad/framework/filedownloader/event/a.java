package com.kwad.framework.filedownloader.event;

import com.kwad.framework.filedownloader.f.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;

/* loaded from: classes11.dex */
public class a {
    private final Executor ahR = com.kwad.framework.filedownloader.f.b.q(10, "EventPool");
    private final HashMap<String, LinkedList<c>> ahS = new HashMap<>();

    public final boolean a(String str, c cVar) {
        boolean add;
        if (d.ajb) {
            d.e(this, "setListener %s", str);
        }
        if (cVar != null) {
            LinkedList<c> linkedList = this.ahS.get(str);
            if (linkedList == null) {
                synchronized (str.intern()) {
                    try {
                        linkedList = this.ahS.get(str);
                        if (linkedList == null) {
                            HashMap<String, LinkedList<c>> hashMap = this.ahS;
                            LinkedList<c> linkedList2 = new LinkedList<>();
                            hashMap.put(str, linkedList2);
                            linkedList = linkedList2;
                        }
                    } finally {
                    }
                }
            }
            synchronized (str.intern()) {
                add = linkedList.add(cVar);
            }
            return add;
        }
        throw new IllegalArgumentException("listener must not be null!");
    }

    public final boolean b(b bVar) {
        if (d.ajb) {
            d.e(this, "publish %s", bVar.getId());
        }
        if (bVar != null) {
            String id = bVar.getId();
            LinkedList<c> linkedList = this.ahS.get(id);
            if (linkedList == null) {
                synchronized (id.intern()) {
                    try {
                        linkedList = this.ahS.get(id);
                        if (linkedList == null) {
                            if (d.ajb) {
                                d.c(this, "No listener for this event %s", id);
                            }
                            return false;
                        }
                    } finally {
                    }
                }
            }
            a(linkedList, bVar);
            return true;
        }
        throw new IllegalArgumentException("event must not be null!");
    }

    public final void c(final b bVar) {
        if (d.ajb) {
            d.e(this, "asyncPublishInNewThread %s", bVar.getId());
        }
        this.ahR.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.event.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.b(bVar);
                } catch (Exception unused) {
                }
            }
        });
    }

    private static void a(LinkedList<c> linkedList, b bVar) {
        for (Object obj : linkedList.toArray()) {
            if (obj != null) {
                ((c) obj).a(bVar);
            }
        }
        Runnable runnable = bVar.ahX;
        if (runnable != null) {
            runnable.run();
        }
    }
}
