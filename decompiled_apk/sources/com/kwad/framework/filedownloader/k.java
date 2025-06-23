package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.x;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes11.dex */
final class k implements t {
    private a.InterfaceC0823a afB;
    private a.c afC;
    private Queue<MessageSnapshot> afD;
    private boolean afE = false;

    public k(a.InterfaceC0823a interfaceC0823a, a.c cVar) {
        a(interfaceC0823a, cVar);
    }

    private void a(a.InterfaceC0823a interfaceC0823a, a.c cVar) {
        this.afB = interfaceC0823a;
        this.afC = cVar;
        this.afD = new LinkedBlockingQueue();
    }

    private void bc(int i) {
        if (com.kwad.framework.filedownloader.d.d.bF(i)) {
            if (!this.afD.isEmpty()) {
                MessageSnapshot peek = this.afD.peek();
                com.kwad.framework.filedownloader.f.d.d(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(peek.getId()), Integer.valueOf(this.afD.size()), Byte.valueOf(peek.uz()));
            }
            this.afB = null;
        }
    }

    private void o(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify completed %s", this.afB);
        }
        this.afC.uQ();
        p(messageSnapshot);
    }

    private void p(MessageSnapshot messageSnapshot) {
        a.InterfaceC0823a interfaceC0823a = this.afB;
        if (interfaceC0823a == null) {
            if (com.kwad.framework.filedownloader.f.d.ajb) {
                com.kwad.framework.filedownloader.f.d.c(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.uz()));
            }
        } else {
            if (!this.afE && interfaceC0823a.uH().uw() != null) {
                this.afD.offer(messageSnapshot);
                j.vh().a(this);
                return;
            }
            if ((l.isValid() || this.afB.uO()) && messageSnapshot.uz() == 4) {
                this.afC.uQ();
            }
            bc(messageSnapshot.uz());
        }
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void b(a.InterfaceC0823a interfaceC0823a, a.c cVar) {
        if (this.afB == null) {
            a(interfaceC0823a, cVar);
            return;
        }
        throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.b("the messenger is working, can't re-appointment for %s", interfaceC0823a));
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void f(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify pending %s", this.afB);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void g(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify started %s", this.afB);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void h(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify connected %s", this.afB);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void i(MessageSnapshot messageSnapshot) {
        a uH = this.afB.uH();
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify progress %s %d %d", uH, Long.valueOf(uH.ux()), Long.valueOf(uH.uy()));
        }
        if (uH.ut() <= 0) {
            if (com.kwad.framework.filedownloader.f.d.ajb) {
                com.kwad.framework.filedownloader.f.d.c(this, "notify progress but client not request notify %s", this.afB);
                return;
            }
            return;
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void j(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify block completed %s %s", this.afB, Thread.currentThread().getName());
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void k(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            a uH = this.afB.uH();
            com.kwad.framework.filedownloader.f.d.c(this, "notify retry %s %d %d %s", this.afB, Integer.valueOf(uH.uC()), Integer.valueOf(uH.uD()), uH.uB());
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void l(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify warn %s", this.afB);
        }
        this.afC.uQ();
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void m(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            a.InterfaceC0823a interfaceC0823a = this.afB;
            com.kwad.framework.filedownloader.f.d.c(this, "notify error %s %s", interfaceC0823a, interfaceC0823a.uH().uB());
        }
        this.afC.uQ();
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void n(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify paused %s", this.afB);
        }
        this.afC.uQ();
        p(messageSnapshot);
    }

    public final String toString() {
        int id;
        a.InterfaceC0823a interfaceC0823a = this.afB;
        if (interfaceC0823a == null) {
            id = -1;
        } else {
            id = interfaceC0823a.uH().getId();
        }
        return com.kwad.framework.filedownloader.f.f.b("%d:%s", Integer.valueOf(id), super.toString());
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean vk() {
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify begin %s", this.afB);
        }
        if (this.afB == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.afD.size()));
            return false;
        }
        this.afC.onBegin();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.framework.filedownloader.t
    public final void vl() {
        g gVar;
        if (this.afE) {
            return;
        }
        MessageSnapshot poll = this.afD.poll();
        byte uz = poll.uz();
        a.InterfaceC0823a interfaceC0823a = this.afB;
        if (interfaceC0823a == null) {
            return;
        }
        a uH = interfaceC0823a.uH();
        i uw = uH.uw();
        x.a uI = interfaceC0823a.uI();
        bc(uz);
        if (uw == null) {
            return;
        }
        if (uz == 4) {
            try {
                uw.b(uH);
                o(((com.kwad.framework.filedownloader.message.a) poll).wB());
                return;
            } catch (Throwable th) {
                m(uI.g(th));
                return;
            }
        }
        if (uw instanceof g) {
            gVar = (g) uw;
        } else {
            gVar = null;
        }
        if (uz != -4) {
            if (uz != -3) {
                if (uz != -2) {
                    if (uz != -1) {
                        if (uz != 1) {
                            if (uz != 2) {
                                if (uz != 3) {
                                    if (uz != 5) {
                                        if (uz == 6) {
                                            uw.a(uH);
                                            return;
                                        }
                                        return;
                                    } else if (gVar != null) {
                                        poll.wH();
                                        poll.uD();
                                        poll.wG();
                                        return;
                                    } else {
                                        poll.wH();
                                        poll.uD();
                                        poll.wC();
                                        return;
                                    }
                                }
                                if (gVar != null) {
                                    poll.wG();
                                    return;
                                } else {
                                    uw.b(uH, poll.wC(), uH.getSmallFileTotalBytes());
                                    return;
                                }
                            }
                            if (gVar != null) {
                                poll.getEtag();
                                poll.wu();
                                poll.wE();
                                return;
                            }
                            uw.a(uH, poll.getEtag(), poll.wu(), uH.getSmallFileSoFarBytes(), poll.wD());
                            return;
                        }
                        if (gVar != null) {
                            poll.wG();
                            poll.wE();
                            return;
                        } else {
                            uw.a(uH, poll.wC(), poll.wD());
                            return;
                        }
                    }
                    uw.a(uH, poll.wH());
                    return;
                }
                if (gVar != null) {
                    poll.wG();
                    poll.wE();
                    return;
                } else {
                    uw.c(uH, poll.wC(), poll.wD());
                    return;
                }
            }
            uw.c(uH);
            return;
        }
        uw.d(uH);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean vm() {
        return this.afB.uH().uE();
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean vn() {
        if (this.afD.peek().uz() == 4) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void vo() {
        this.afE = true;
    }
}
