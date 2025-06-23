package com.kwad.framework.filedownloader.message;

import com.kwad.framework.filedownloader.message.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes11.dex */
public final class g {
    private final e.b aij;
    private final List<a> ail = new ArrayList();

    /* loaded from: classes11.dex */
    public class a {
        private final List<Integer> aim = new ArrayList();
        private final Executor ain;

        public a(int i) {
            this.ain = com.kwad.framework.filedownloader.f.b.q(1, "Flow-" + i);
        }

        public final void bB(int i) {
            this.aim.add(Integer.valueOf(i));
        }

        public final void u(final MessageSnapshot messageSnapshot) {
            this.ain.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.message.g.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.aij.r(messageSnapshot);
                    try {
                        a.this.aim.remove(Integer.valueOf(messageSnapshot.getId()));
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public g(int i, e.b bVar) {
        this.aij = bVar;
        for (int i2 = 0; i2 < 5; i2++) {
            this.ail.add(new a(i2));
        }
    }

    public final void u(MessageSnapshot messageSnapshot) {
        a aVar = null;
        try {
            synchronized (this.ail) {
                try {
                    int id = messageSnapshot.getId();
                    Iterator<a> it = this.ail.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        a next = it.next();
                        if (next.aim.contains(Integer.valueOf(id))) {
                            aVar = next;
                            break;
                        }
                    }
                    if (aVar == null) {
                        Iterator<a> it2 = this.ail.iterator();
                        int i = 0;
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            a next2 = it2.next();
                            if (next2.aim.size() <= 0) {
                                aVar = next2;
                                break;
                            } else if (i == 0 || next2.aim.size() < i) {
                                i = next2.aim.size();
                                aVar = next2;
                            }
                        }
                    }
                    if (aVar != null) {
                        aVar.bB(id);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } finally {
            if (aVar != null) {
                aVar.u(messageSnapshot);
            }
        }
    }
}
