package com.baidu.ar;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes7.dex */
public class nu implements ns {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final BlockingQueue<ByteBuffer> HU;
    public final BlockingQueue<ByteBuffer> HV;
    private final nv HW;
    private SelectionKey HX;
    private ByteChannel HY;
    private List<ny> Ib;
    private ny Ic;
    private oe Id;
    private final pq HJ = pr.a((Class<?>) nu.class);
    private boolean HZ = false;
    private volatile od Ia = od.NOT_YET_CONNECTED;
    private ByteBuffer Ie = ByteBuffer.allocate(0);
    private pa If = null;
    private String Ig = null;
    private Integer Ih = null;
    private Boolean Ii = null;
    private String Ij = null;
    private long Ik = System.nanoTime();
    private final Object Il = new Object();

    public nu(nv nvVar, ny nyVar) {
        this.Ic = null;
        if (nvVar == null || (nyVar == null && this.Id == oe.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.HU = new LinkedBlockingQueue();
        this.HV = new LinkedBlockingQueue();
        this.HW = nvVar;
        this.Id = oe.CLIENT;
        if (nyVar != null) {
            this.Ic = nyVar.jk();
        }
    }

    private void a(oh ohVar) {
        f(ad(404));
        d(ohVar.jy(), ohVar.getMessage(), false);
    }

    private ByteBuffer ad(int i) {
        String str = i != 404 ? "500 Internal Server Error" : "404 WebSocket Upgrade Failure";
        return ByteBuffer.wrap(pn.cN("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    private void m(List<ByteBuffer> list) {
        synchronized (this.Il) {
            try {
                Iterator<ByteBuffer> it = list.iterator();
                while (it.hasNext()) {
                    f(it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void ae(int i) {
        b(i, "", false);
    }

    public synchronized void b(int i, String str, boolean z) {
        od odVar = this.Ia;
        od odVar2 = od.CLOSING;
        if (odVar == odVar2 || this.Ia == od.CLOSED) {
            return;
        }
        if (this.Ia != od.OPEN) {
            if (i == -3) {
                d(-3, str, true);
            } else if (i != 1002) {
                d(-1, str, false);
            }
            this.Ia = od.CLOSING;
            this.Ie = null;
        }
        if (i == 1006) {
            this.Ia = odVar2;
            d(i, str, false);
            return;
        }
        if (this.Ic.jj() != oa.NONE) {
            if (!z) {
                try {
                    try {
                        this.HW.a(this, i, str);
                    } catch (RuntimeException e) {
                        this.HW.a(this, e);
                    }
                } catch (oh e2) {
                    this.HJ.b("generated frame is invalid", (Throwable) e2);
                    this.HW.a(this, e2);
                    d(1006, "generated frame is invalid", false);
                }
            }
            if (isOpen()) {
                or orVar = new or();
                orVar.cG(str);
                orVar.setCode(i);
                orVar.jC();
                a(orVar);
            }
        }
        d(i, str, z);
        this.Ia = od.CLOSING;
        this.Ie = null;
    }

    public synchronized void c(int i, String str, boolean z) {
        try {
            if (this.Ia == od.CLOSED) {
                return;
            }
            if (this.Ia == od.OPEN && i == 1006) {
                this.Ia = od.CLOSING;
            }
            SelectionKey selectionKey = this.HX;
            if (selectionKey != null) {
                selectionKey.cancel();
            }
            ByteChannel byteChannel = this.HY;
            if (byteChannel != null) {
                try {
                    byteChannel.close();
                } catch (IOException e) {
                    if (e.getMessage() == null || !e.getMessage().equals("Broken pipe")) {
                        this.HJ.b("Exception during channel.close()", (Throwable) e);
                        this.HW.a(this, e);
                    } else {
                        this.HJ.a("Caught IOException: Broken pipe during closeConnection()", e);
                    }
                }
            }
            try {
                this.HW.a(this, i, str, z);
            } catch (RuntimeException e2) {
                this.HW.a(this, e2);
            }
            ny nyVar = this.Ic;
            if (nyVar != null) {
                nyVar.reset();
            }
            this.If = null;
            this.Ia = od.CLOSED;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void cB(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        b(this.Ic.d(str, this.Id == oe.CLIENT));
    }

    public synchronized void d(int i, String str, boolean z) {
        if (this.HZ) {
            return;
        }
        this.Ih = Integer.valueOf(i);
        this.Ig = str;
        this.Ii = Boolean.valueOf(z);
        this.HZ = true;
        this.HW.b(this);
        try {
            this.HW.b(this, i, str, z);
        } catch (RuntimeException e) {
            this.HJ.b("Exception in onWebsocketClosing", (Throwable) e);
            this.HW.a(this, e);
        }
        ny nyVar = this.Ic;
        if (nyVar != null) {
            nyVar.reset();
        }
        this.If = null;
    }

    public void e(int i, String str) {
        b(i, str, false);
    }

    public void f(int i, String str) {
        c(i, str, false);
    }

    public void iZ() {
        if (this.Ia == od.NOT_YET_CONNECTED) {
            e(-1, true);
            return;
        }
        if (this.HZ) {
            c(this.Ih.intValue(), this.Ig, this.Ii.booleanValue());
        } else if (this.Ic.jj() != oa.NONE && (this.Ic.jj() != oa.ONEWAY || this.Id == oe.SERVER)) {
            e(1006, true);
        } else {
            e(1000, true);
        }
    }

    public boolean isClosed() {
        return this.Ia == od.CLOSED;
    }

    public boolean isOpen() {
        return this.Ia == od.OPEN;
    }

    public void ja() {
        ox a2 = this.HW.a(this);
        if (a2 == null) {
            throw new NullPointerException("onPreparePing(WebSocket) returned null. PingFrame to sent can't be null.");
        }
        a(a2);
    }

    public boolean jb() {
        return this.Ia == od.CLOSING;
    }

    public od jc() {
        return this.Ia;
    }

    public long jd() {
        return this.Ik;
    }

    public void je() {
        this.Ik = System.nanoTime();
    }

    public nv jf() {
        return this.HW;
    }

    public void t(byte[] bArr) {
        e(ByteBuffer.wrap(bArr));
    }

    public String toString() {
        return super.toString();
    }

    private boolean c(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        oe oeVar;
        pf j;
        if (this.Ie.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.Ie.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.Ie.capacity() + byteBuffer.remaining());
                this.Ie.flip();
                allocate.put(this.Ie);
                this.Ie = allocate;
            }
            this.Ie.put(byteBuffer);
            this.Ie.flip();
            byteBuffer2 = this.Ie;
        }
        byteBuffer2.mark();
        try {
            try {
                oeVar = this.Id;
            } catch (og e) {
                if (this.Ie.capacity() == 0) {
                    byteBuffer2.reset();
                    int jx = e.jx();
                    if (jx == 0) {
                        jx = byteBuffer2.capacity() + 16;
                    }
                    ByteBuffer allocate2 = ByteBuffer.allocate(jx);
                    this.Ie = allocate2;
                    allocate2.put(byteBuffer);
                } else {
                    ByteBuffer byteBuffer3 = this.Ie;
                    byteBuffer3.position(byteBuffer3.limit());
                    ByteBuffer byteBuffer4 = this.Ie;
                    byteBuffer4.limit(byteBuffer4.capacity());
                }
            }
        } catch (ok e2) {
            this.HJ.a("Closing due to invalid handshake", e2);
            b(e2);
        }
        if (oeVar != oe.SERVER) {
            if (oeVar == oe.CLIENT) {
                this.Ic.a(oeVar);
                pf j2 = this.Ic.j(byteBuffer2);
                if (!(j2 instanceof ph)) {
                    this.HJ.cP("Closing due to protocol error: wrong http function");
                    d(1002, "wrong http function", false);
                    return false;
                }
                ph phVar = (ph) j2;
                if (this.Ic.a(this.If, phVar) == ob.MATCHED) {
                    try {
                        this.HW.a(this, this.If, phVar);
                        a(phVar);
                        return true;
                    } catch (oh e3) {
                        this.HJ.a("Closing due to invalid data exception. Possible handshake rejection", e3);
                        d(e3.jy(), e3.getMessage(), false);
                        return false;
                    } catch (RuntimeException e4) {
                        this.HJ.b("Closing since client was never connected", (Throwable) e4);
                        this.HW.a(this, e4);
                        d(-1, e4.getMessage(), false);
                        return false;
                    }
                }
                this.HJ.b("Closing due to protocol error: draft {} refuses handshake", this.Ic);
                e(1002, "draft " + this.Ic + " refuses handshake");
            }
            return false;
        }
        ny nyVar = this.Ic;
        if (nyVar != null) {
            pf j3 = nyVar.j(byteBuffer2);
            if (!(j3 instanceof pa)) {
                this.HJ.cP("Closing due to protocol error: wrong http function");
                d(1002, "wrong http function", false);
                return false;
            }
            pa paVar = (pa) j3;
            if (this.Ic.a(paVar) == ob.MATCHED) {
                a(paVar);
                return true;
            }
            this.HJ.cP("Closing due to protocol error: the handshake did finally not match");
            e(1002, "the handshake did finally not match");
            return false;
        }
        Iterator<ny> it = this.Ib.iterator();
        while (it.hasNext()) {
            ny jk = it.next().jk();
            try {
                jk.a(this.Id);
                byteBuffer2.reset();
                j = jk.j(byteBuffer2);
            } catch (ok unused) {
            }
            if (!(j instanceof pa)) {
                this.HJ.cP("Closing due to wrong handshake");
                a(new oh(1002, "wrong http function"));
                return false;
            }
            pa paVar2 = (pa) j;
            if (jk.a(paVar2) == ob.MATCHED) {
                this.Ij = paVar2.jK();
                try {
                    m(jk.c(jk.a(paVar2, this.HW.a(this, jk, paVar2))));
                    this.Ic = jk;
                    a(paVar2);
                    return true;
                } catch (oh e5) {
                    this.HJ.a("Closing due to wrong handshake. Possible handshake rejection", e5);
                    a(e5);
                    return false;
                } catch (RuntimeException e6) {
                    this.HJ.b("Closing due to internal server error", (Throwable) e6);
                    this.HW.a(this, e6);
                    a(e6);
                    return false;
                }
            }
        }
        if (this.Ic == null) {
            this.HJ.cP("Closing due to protocol error: no draft matches");
            a(new oh(1002, "no draft matches"));
        }
        return false;
    }

    private void d(ByteBuffer byteBuffer) {
        String str;
        oh ohVar;
        pq pqVar;
        oh ohVar2;
        try {
            for (ov ovVar : this.Ic.i(byteBuffer)) {
                this.HJ.b("matched frame: {}", ovVar);
                this.Ic.a(this, ovVar);
            }
        } catch (ol e) {
            int limit = e.getLimit();
            ohVar2 = e;
            if (limit == Integer.MAX_VALUE) {
                str = "Closing due to invalid size of frame";
                pqVar = this.HJ;
                ohVar = e;
                pqVar.b(str, (Throwable) ohVar);
                this.HW.a(this, ohVar);
                ohVar2 = ohVar;
            }
            b(ohVar2);
        } catch (oh e2) {
            str = "Closing due to invalid data in frame";
            pqVar = this.HJ;
            ohVar = e2;
            pqVar.b(str, (Throwable) ohVar);
            this.HW.a(this, ohVar);
            ohVar2 = ohVar;
            b(ohVar2);
        }
    }

    private void f(ByteBuffer byteBuffer) {
        this.HJ.a("write({}): {}", Integer.valueOf(byteBuffer.remaining()), byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array()));
        this.HU.add(byteBuffer);
        this.HW.b(this);
    }

    @Override // com.baidu.ar.ns
    public void a(ov ovVar) {
        b(Collections.singletonList(ovVar));
    }

    public void b(oh ohVar) {
        b(ohVar.jy(), ohVar.getMessage(), false);
    }

    public void e(int i, boolean z) {
        c(i, "", z);
    }

    public void a(pb pbVar) {
        this.If = this.Ic.b(pbVar);
        this.Ij = pbVar.jK();
        try {
            this.HW.a((ns) this, this.If);
            m(this.Ic.c(this.If));
        } catch (oh unused) {
            throw new ok("Handshake data rejected by client.");
        } catch (RuntimeException e) {
            this.HJ.b("Exception in startHandshake", (Throwable) e);
            this.HW.a(this, e);
            throw new ok("rejected because of " + e);
        }
    }

    public void b(ByteBuffer byteBuffer) {
        this.HJ.a("process({}): ({})", Integer.valueOf(byteBuffer.remaining()), byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining()));
        if (this.Ia != od.NOT_YET_CONNECTED) {
            if (this.Ia != od.OPEN) {
                return;
            }
        } else {
            if (!c(byteBuffer) || jb() || isClosed()) {
                return;
            }
            if (!byteBuffer.hasRemaining()) {
                if (!this.Ie.hasRemaining()) {
                    return;
                } else {
                    byteBuffer = this.Ie;
                }
            }
        }
        d(byteBuffer);
    }

    public void e(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        b(this.Ic.a(byteBuffer, this.Id == oe.CLIENT));
    }

    private void a(pf pfVar) {
        this.HJ.b("open using draft: {}", this.Ic);
        this.Ia = od.OPEN;
        try {
            this.HW.a(this, pfVar);
        } catch (RuntimeException e) {
            this.HW.a(this, e);
        }
    }

    private void b(Collection<ov> collection) {
        if (!isOpen()) {
            throw new on();
        }
        if (collection == null) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList();
        for (ov ovVar : collection) {
            this.HJ.b("send frame: {}", ovVar);
            arrayList.add(this.Ic.b(ovVar));
        }
        m(arrayList);
    }

    private void a(RuntimeException runtimeException) {
        f(ad(500));
        d(-1, runtimeException.getMessage(), false);
    }
}
