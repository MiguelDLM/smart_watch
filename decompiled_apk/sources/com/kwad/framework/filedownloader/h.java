package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public final class h {
    private final ArrayList<a.InterfaceC0823a> afq;

    /* loaded from: classes11.dex */
    public static final class a {
        private static final h afr = new h(0);
    }

    public /* synthetic */ h(byte b) {
        this();
    }

    public static h vf() {
        return a.afr;
    }

    public final boolean a(a.InterfaceC0823a interfaceC0823a) {
        return this.afq.isEmpty() || !this.afq.contains(interfaceC0823a);
    }

    public final int aZ(int i) {
        int i2;
        synchronized (this.afq) {
            try {
                Iterator<a.InterfaceC0823a> it = this.afq.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    if (it.next().aY(i)) {
                        i2++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i2;
    }

    public final void b(a.InterfaceC0823a interfaceC0823a) {
        if (!interfaceC0823a.uH().us()) {
            interfaceC0823a.uK();
        }
        if (interfaceC0823a.uI().uX().vk()) {
            c(interfaceC0823a);
        }
    }

    public final List<a.InterfaceC0823a> ba(int i) {
        byte uz;
        ArrayList arrayList = new ArrayList();
        synchronized (this.afq) {
            try {
                Iterator<a.InterfaceC0823a> it = this.afq.iterator();
                while (it.hasNext()) {
                    a.InterfaceC0823a next = it.next();
                    if (next.aY(i) && !next.isOver() && (uz = next.uH().uz()) != 0 && uz != 10) {
                        arrayList.add(next);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public final List<a.InterfaceC0823a> bb(int i) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.afq) {
            try {
                Iterator<a.InterfaceC0823a> it = this.afq.iterator();
                while (it.hasNext()) {
                    a.InterfaceC0823a next = it.next();
                    if (next.aY(i) && !next.isOver()) {
                        arrayList.add(next);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public final void c(a.InterfaceC0823a interfaceC0823a) {
        if (interfaceC0823a.uL()) {
            return;
        }
        synchronized (this.afq) {
            try {
                if (this.afq.contains(interfaceC0823a)) {
                    com.kwad.framework.filedownloader.f.d.d(this, "already has %s", interfaceC0823a);
                } else {
                    interfaceC0823a.uM();
                    this.afq.add(interfaceC0823a);
                    if (com.kwad.framework.filedownloader.f.d.ajb) {
                        com.kwad.framework.filedownloader.f.d.e(this, "add list in all %s %d %d", interfaceC0823a, Byte.valueOf(interfaceC0823a.uH().uz()), Integer.valueOf(this.afq.size()));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void o(List<a.InterfaceC0823a> list) {
        synchronized (this.afq) {
            try {
                Iterator<a.InterfaceC0823a> it = this.afq.iterator();
                while (it.hasNext()) {
                    a.InterfaceC0823a next = it.next();
                    if (!list.contains(next)) {
                        list.add(next);
                    }
                }
                this.afq.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int size() {
        return this.afq.size();
    }

    private h() {
        this.afq = new ArrayList<>();
    }

    public final boolean a(a.InterfaceC0823a interfaceC0823a, MessageSnapshot messageSnapshot) {
        boolean remove;
        byte uz = messageSnapshot.uz();
        synchronized (this.afq) {
            remove = this.afq.remove(interfaceC0823a);
        }
        if (com.kwad.framework.filedownloader.f.d.ajb && this.afq.size() == 0) {
            com.kwad.framework.filedownloader.f.d.e(this, "remove %s left %d %d", interfaceC0823a, Byte.valueOf(uz), Integer.valueOf(this.afq.size()));
        }
        if (remove) {
            t uX = interfaceC0823a.uI().uX();
            if (uz == -4) {
                uX.l(messageSnapshot);
            } else if (uz == -3) {
                uX.j(com.kwad.framework.filedownloader.message.f.t(messageSnapshot));
            } else if (uz == -2) {
                uX.n(messageSnapshot);
            } else if (uz == -1) {
                uX.m(messageSnapshot);
            }
        } else {
            com.kwad.framework.filedownloader.f.d.a(this, "remove error, not exist: %s %d", interfaceC0823a, Byte.valueOf(uz));
        }
        return remove;
    }
}
