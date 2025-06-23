package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.aa;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes7.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static volatile q f6335a;
    private List<aa.a> b = new CopyOnWriteArrayList();

    private q() {
    }

    public static q a() {
        if (f6335a == null) {
            synchronized (q.class) {
                try {
                    if (f6335a == null) {
                        f6335a = new q();
                    }
                } finally {
                }
            }
        }
        return f6335a;
    }

    private void b(aa.a aVar) {
        if (this.b.contains(aVar)) {
            this.b.remove(aVar);
        }
    }

    public void a(aa.a aVar) {
        if (aVar == null || this.b.contains(aVar)) {
            return;
        }
        this.b.add(aVar);
    }

    public void a(int i) {
        for (aa.a aVar : this.b) {
            if (i == 1) {
                aVar.onSuccess();
            } else if (i == 2) {
                aVar.onFailure();
            }
            b(aVar);
        }
    }
}
