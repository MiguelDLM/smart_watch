package com.baidu.ar;

import IoxX.I0Io;
import androidx.work.WorkInfo;
import com.google.common.net.HttpHeaders;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import org.apache.commons.lang3.time.xoIox;

/* loaded from: classes7.dex */
public class nz extends ny {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final pq HJ;
    private op IB;
    private List<op> IC;
    private pj ID;
    private List<pj> IE;
    private ov IF;
    private final List<ByteBuffer> IG;
    private ByteBuffer IH;
    private final Random II;
    private int IJ;

    /* loaded from: classes7.dex */
    public class a {
        private int IK;
        private int IL;

        public a(int i, int i2) {
            this.IK = i;
            this.IL = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int jv() {
            return this.IK;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int jw() {
            return this.IL;
        }
    }

    public nz() {
        this(Collections.emptyList());
    }

    private byte a(oc ocVar) {
        if (ocVar == oc.CONTINUOUS) {
            return (byte) 0;
        }
        if (ocVar == oc.TEXT) {
            return (byte) 1;
        }
        if (ocVar == oc.BINARY) {
            return (byte) 2;
        }
        if (ocVar == oc.CLOSING) {
            return (byte) 8;
        }
        if (ocVar == oc.PING) {
            return (byte) 9;
        }
        if (ocVar == oc.PONG) {
            return (byte) 10;
        }
        throw new IllegalArgumentException("Don't know how to handle " + ocVar.toString());
    }

    private byte ag(int i) {
        if (i == 1) {
            return (byte) 64;
        }
        if (i == 2) {
            return (byte) 32;
        }
        return i == 3 ? (byte) 16 : (byte) 0;
    }

    private byte ak(boolean z) {
        return z ? Byte.MIN_VALUE : (byte) 0;
    }

    private ByteBuffer c(ov ovVar) {
        int ak;
        ByteBuffer jE = ovVar.jE();
        int i = 0;
        boolean z = this.Id == oe.CLIENT;
        int l = l(jE);
        ByteBuffer allocate = ByteBuffer.allocate((l > 1 ? l + 1 : l) + 1 + (z ? 4 : 0) + jE.remaining());
        byte a2 = (byte) (a(ovVar.jJ()) | ((byte) (ovVar.jF() ? WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT : 0)));
        if (ovVar.jG()) {
            a2 = (byte) (a2 | ag(1));
        }
        if (ovVar.jH()) {
            a2 = (byte) (a2 | ag(2));
        }
        if (ovVar.jI()) {
            a2 = (byte) (ag(3) | a2);
        }
        allocate.put(a2);
        byte[] b = b(jE.remaining(), l);
        if (l == 1) {
            allocate.put((byte) (b[0] | ak(z)));
        } else {
            if (l == 2) {
                ak = ak(z) | 126;
            } else {
                if (l != 8) {
                    throw new IllegalStateException("Size representation not supported/specified");
                }
                ak = ak(z) | Byte.MAX_VALUE;
            }
            allocate.put((byte) ak);
            allocate.put(b);
        }
        if (z) {
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(this.II.nextInt());
            allocate.put(allocate2.array());
            while (jE.hasRemaining()) {
                allocate.put((byte) (jE.get() ^ allocate2.get(i % 4)));
                i++;
            }
        } else {
            allocate.put(jE);
            jE.flip();
        }
        allocate.flip();
        return allocate;
    }

    private ob cC(String str) {
        for (pj pjVar : this.IE) {
            if (pjVar.cL(str)) {
                this.ID = pjVar;
                this.HJ.b("acceptHandshake - Matching protocol found: {}", pjVar);
                return ob.MATCHED;
            }
        }
        return ob.NOT_MATCHED;
    }

    private String cD(String str) {
        try {
            return pl.u(MessageDigest.getInstance(I0Io.f849Oxx0IOOO).digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private void e(nu nuVar, ov ovVar) {
        int i;
        String str;
        if (ovVar instanceof or) {
            or orVar = (or) ovVar;
            i = orVar.jy();
            str = orVar.getMessage();
        } else {
            i = 1005;
            str = "";
        }
        if (nuVar.jc() == od.CLOSING) {
            nuVar.c(i, str, true);
        } else if (jj() == oa.TWOWAY) {
            nuVar.b(i, str, true);
        } else {
            nuVar.d(i, str, false);
        }
    }

    private String jq() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(xoIox.f32917oIX0oI));
        return simpleDateFormat.format(calendar.getTime());
    }

    private void jr() {
        synchronized (this.IG) {
            this.IG.clear();
        }
    }

    private void js() {
        long ju = ju();
        if (ju <= this.IJ) {
            return;
        }
        jr();
        this.HJ.a("Payload limit reached. Allowed: {} Current: {}", Integer.valueOf(this.IJ), Long.valueOf(ju));
        throw new ol(this.IJ);
    }

    private ByteBuffer jt() {
        ByteBuffer allocate;
        synchronized (this.IG) {
            try {
                long j = 0;
                while (this.IG.iterator().hasNext()) {
                    j += r1.next().limit();
                }
                js();
                allocate = ByteBuffer.allocate((int) j);
                Iterator<ByteBuffer> it = this.IG.iterator();
                while (it.hasNext()) {
                    allocate.put(it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        allocate.flip();
        return allocate;
    }

    private long ju() {
        long j;
        synchronized (this.IG) {
            try {
                j = 0;
                while (this.IG.iterator().hasNext()) {
                    j += r1.next().limit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }

    private ov k(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException();
        }
        int remaining = byteBuffer.remaining();
        int i = 2;
        o(remaining, 2);
        byte b = byteBuffer.get();
        boolean z = (b >> 8) != 0;
        boolean z2 = (b & 64) != 0;
        boolean z3 = (b & 32) != 0;
        boolean z4 = (b & 16) != 0;
        byte b2 = byteBuffer.get();
        boolean z5 = (b2 & Byte.MIN_VALUE) != 0;
        int i2 = (byte) (b2 & Byte.MAX_VALUE);
        oc a2 = a((byte) (b & 15));
        if (i2 < 0 || i2 > 125) {
            a a3 = a(byteBuffer, a2, i2, remaining, 2);
            i2 = a3.jv();
            i = a3.jw();
        }
        o(i2);
        o(remaining, i + (z5 ? 4 : 0) + i2);
        ByteBuffer allocate = ByteBuffer.allocate(af(i2));
        if (z5) {
            byte[] bArr = new byte[4];
            byteBuffer.get(bArr);
            for (int i3 = 0; i3 < i2; i3++) {
                allocate.put((byte) (byteBuffer.get() ^ bArr[i3 % 4]));
            }
        } else {
            allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
            byteBuffer.position(byteBuffer.position() + allocate.limit());
        }
        ow b3 = ow.b(a2);
        b3.al(z);
        b3.am(z2);
        b3.an(z3);
        b3.ao(z4);
        allocate.flip();
        b3.n(allocate);
        jl().g(b3);
        jl().e(b3);
        if (this.HJ.isTraceEnabled()) {
            this.HJ.a("afterDecoding({}): {}", Integer.valueOf(b3.jE().remaining()), b3.jE().remaining() > 1000 ? "too big to display" : new String(b3.jE().array()));
        }
        b3.jC();
        return b3;
    }

    private int l(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 125) {
            return 1;
        }
        return byteBuffer.remaining() <= 65535 ? 2 : 8;
    }

    private void m(ByteBuffer byteBuffer) {
        synchronized (this.IG) {
            this.IG.add(byteBuffer);
        }
    }

    private void o(int i, int i2) {
        if (i >= i2) {
            return;
        }
        this.HJ.cP("Incomplete frame: maxpacketsize < realpacketsize");
        throw new of(i2);
    }

    @Override // com.baidu.ar.ny
    public pb b(pb pbVar) {
        pbVar.put("Upgrade", I0Io.f855xoIox);
        pbVar.put("Connection", "Upgrade");
        byte[] bArr = new byte[16];
        this.II.nextBytes(bArr);
        pbVar.put(HttpHeaders.SEC_WEBSOCKET_KEY, pl.u(bArr));
        pbVar.put(HttpHeaders.SEC_WEBSOCKET_VERSION, com.tencent.connect.common.II0xO0.f26825XoIxOXIXo);
        StringBuilder sb = new StringBuilder();
        for (op opVar : this.IC) {
            if (opVar.jz() != null && opVar.jz().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(opVar.jz());
            }
        }
        if (sb.length() != 0) {
            pbVar.put(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS, sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (pj pjVar : this.IE) {
            if (pjVar.jO().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(pjVar.jO());
            }
        }
        if (sb2.length() != 0) {
            pbVar.put(HttpHeaders.SEC_WEBSOCKET_PROTOCOL, sb2.toString());
        }
        return pbVar;
    }

    @Override // com.baidu.ar.ny
    public List<ov> d(String str, boolean z) {
        oz ozVar = new oz();
        ozVar.n(ByteBuffer.wrap(pn.cM(str)));
        ozVar.ap(z);
        try {
            ozVar.jC();
            return Collections.singletonList(ozVar);
        } catch (oh e) {
            throw new om(e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        nz nzVar = (nz) obj;
        if (this.IJ != nzVar.jo()) {
            return false;
        }
        op opVar = this.IB;
        if (opVar == null ? nzVar.jl() != null : !opVar.equals(nzVar.jl())) {
            return false;
        }
        pj pjVar = this.ID;
        pj jn = nzVar.jn();
        return pjVar != null ? pjVar.equals(jn) : jn == null;
    }

    public int hashCode() {
        op opVar = this.IB;
        int hashCode = (opVar != null ? opVar.hashCode() : 0) * 31;
        pj pjVar = this.ID;
        int hashCode2 = (hashCode + (pjVar != null ? pjVar.hashCode() : 0)) * 31;
        int i = this.IJ;
        return hashCode2 + (i ^ (i >>> 32));
    }

    @Override // com.baidu.ar.ny
    public List<ov> i(ByteBuffer byteBuffer) {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.IH == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.IH.remaining();
                if (remaining2 > remaining) {
                    this.IH.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(byteBuffer.position() + remaining);
                    return Collections.emptyList();
                }
                this.IH.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(k((ByteBuffer) this.IH.duplicate().position(0)));
                this.IH = null;
            } catch (of e) {
                ByteBuffer allocate = ByteBuffer.allocate(af(e.jx()));
                this.IH.rewind();
                allocate.put(this.IH);
                this.IH = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(k(byteBuffer));
            } catch (of e2) {
                byteBuffer.reset();
                ByteBuffer allocate2 = ByteBuffer.allocate(af(e2.jx()));
                this.IH = allocate2;
                allocate2.put(byteBuffer);
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ar.ny
    public oa jj() {
        return oa.TWOWAY;
    }

    @Override // com.baidu.ar.ny
    public ny jk() {
        ArrayList arrayList = new ArrayList();
        Iterator<op> it = jm().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().jB());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<pj> it2 = jp().iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next().jP());
        }
        return new nz(arrayList, arrayList2, this.IJ);
    }

    public op jl() {
        return this.IB;
    }

    public List<op> jm() {
        return this.IC;
    }

    public pj jn() {
        return this.ID;
    }

    public int jo() {
        return this.IJ;
    }

    public List<pj> jp() {
        return this.IE;
    }

    @Override // com.baidu.ar.ny
    public void reset() {
        this.IH = null;
        op opVar = this.IB;
        if (opVar != null) {
            opVar.reset();
        }
        this.IB = new oo();
        this.ID = null;
    }

    @Override // com.baidu.ar.ny
    public String toString() {
        String nyVar = super.toString();
        if (jl() != null) {
            nyVar = nyVar + " extension: " + jl().toString();
        }
        if (jn() != null) {
            nyVar = nyVar + " protocol: " + jn().toString();
        }
        return nyVar + " max frame size: " + this.IJ;
    }

    public nz(List<op> list) {
        this(list, Collections.singletonList(new pk("")));
    }

    private a a(ByteBuffer byteBuffer, oc ocVar, int i, int i2, int i3) {
        int i4;
        int i5;
        if (ocVar == oc.PING || ocVar == oc.PONG || ocVar == oc.CLOSING) {
            this.HJ.cP("Invalid frame: more than 125 octets");
            throw new oj("more than 125 octets");
        }
        if (i == 126) {
            i4 = i3 + 2;
            o(i2, i4);
            i5 = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
        } else {
            i4 = i3 + 8;
            o(i2, i4);
            byte[] bArr = new byte[8];
            for (int i6 = 0; i6 < 8; i6++) {
                bArr[i6] = byteBuffer.get();
            }
            long longValue = new BigInteger(bArr).longValue();
            o(longValue);
            i5 = (int) longValue;
        }
        return new a(i5, i4);
    }

    private void c(nu nuVar, ov ovVar) {
        try {
            nuVar.jf().a(nuVar, pn.o(ovVar.jE()));
        } catch (RuntimeException e) {
            a(nuVar, e);
        }
    }

    private void d(nu nuVar, ov ovVar) {
        if (this.IF == null) {
            this.HJ.cP("Protocol error: Previous continuous frame sequence not completed.");
            throw new oh(1002, "Continuous frame sequence was not started.");
        }
        m(ovVar.jE());
        js();
        try {
        } catch (RuntimeException e) {
            a(nuVar, e);
        }
        if (this.IF.jJ() != oc.TEXT) {
            if (this.IF.jJ() == oc.BINARY) {
                ((ow) this.IF).n(jt());
                ((ow) this.IF).jC();
                nuVar.jf().a(nuVar, this.IF.jE());
            }
            this.IF = null;
            jr();
        }
        ((ow) this.IF).n(jt());
        ((ow) this.IF).jC();
        nuVar.jf().a(nuVar, pn.o(this.IF.jE()));
        this.IF = null;
        jr();
    }

    private void o(long j) {
        if (j > 2147483647L) {
            this.HJ.cP("Limit exedeed: Payloadsize is to big...");
            throw new ol("Payloadsize is to big...");
        }
        int i = this.IJ;
        if (j > i) {
            this.HJ.a("Payload limit reached. Allowed: {} Current: {}", Integer.valueOf(i), Long.valueOf(j));
            throw new ol("Payload limit reached.", this.IJ);
        }
        if (j >= 0) {
            return;
        }
        this.HJ.cP("Limit underflow: Payloadsize is to little...");
        throw new ol("Payloadsize is to little...");
    }

    @Override // com.baidu.ar.ny
    public ByteBuffer b(ov ovVar) {
        jl().f(ovVar);
        if (this.HJ.isTraceEnabled()) {
            this.HJ.a("afterEnconding({}): {}", Integer.valueOf(ovVar.jE().remaining()), ovVar.jE().remaining() > 1000 ? "too big to display" : new String(ovVar.jE().array()));
        }
        return c(ovVar);
    }

    public nz(List<op> list, List<pj> list2) {
        this(list, list2, Integer.MAX_VALUE);
    }

    private void b(nu nuVar, ov ovVar) {
        try {
            nuVar.jf().a(nuVar, ovVar.jE());
        } catch (RuntimeException e) {
            a(nuVar, e);
        }
    }

    private void d(ov ovVar) {
        if (this.IF != null) {
            this.HJ.cP("Protocol error: Previous continuous frame sequence not completed.");
            throw new oh(1002, "Previous continuous frame sequence not completed.");
        }
        this.IF = ovVar;
        m(ovVar.jE());
        js();
    }

    @Override // com.baidu.ar.ny
    public ob a(pa paVar) {
        pq pqVar;
        String str;
        if (d(paVar) != 13) {
            pqVar = this.HJ;
            str = "acceptHandshakeAsServer - Wrong websocket version.";
        } else {
            ob obVar = ob.NOT_MATCHED;
            String cJ = paVar.cJ(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS);
            Iterator<op> it = this.IC.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                op next = it.next();
                if (next.cE(cJ)) {
                    this.IB = next;
                    obVar = ob.MATCHED;
                    this.HJ.b("acceptHandshakeAsServer - Matching extension found: {}", next);
                    break;
                }
            }
            ob cC = cC(paVar.cJ(HttpHeaders.SEC_WEBSOCKET_PROTOCOL));
            ob obVar2 = ob.MATCHED;
            if (cC == obVar2 && obVar == obVar2) {
                return obVar2;
            }
            pqVar = this.HJ;
            str = "acceptHandshakeAsServer - No matching extension or protocol found.";
        }
        pqVar.cP(str);
        return ob.NOT_MATCHED;
    }

    public nz(List<op> list, List<pj> list2, int i) {
        this.HJ = pr.a((Class<?>) nz.class);
        this.IB = new oo();
        this.II = new Random();
        if (list == null || list2 == null || i < 1) {
            throw new IllegalArgumentException();
        }
        this.IC = new ArrayList(list.size());
        this.IE = new ArrayList(list2.size());
        this.IG = new ArrayList();
        Iterator<op> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().getClass().equals(oo.class)) {
                z = true;
            }
        }
        this.IC.addAll(list);
        if (!z) {
            List<op> list3 = this.IC;
            list3.add(list3.size(), this.IB);
        }
        this.IE.addAll(list2);
        this.IJ = i;
    }

    private byte[] b(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) (j >>> (i2 - (i3 * 8)));
        }
        return bArr;
    }

    @Override // com.baidu.ar.ny
    public ob a(pa paVar, ph phVar) {
        pq pqVar;
        String str;
        if (!b(phVar)) {
            pqVar = this.HJ;
            str = "acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.";
        } else if (paVar.cK(HttpHeaders.SEC_WEBSOCKET_KEY) && phVar.cK(HttpHeaders.SEC_WEBSOCKET_ACCEPT)) {
            if (cD(paVar.cJ(HttpHeaders.SEC_WEBSOCKET_KEY)).equals(phVar.cJ(HttpHeaders.SEC_WEBSOCKET_ACCEPT))) {
                ob obVar = ob.NOT_MATCHED;
                String cJ = phVar.cJ(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS);
                Iterator<op> it = this.IC.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    op next = it.next();
                    if (next.cF(cJ)) {
                        this.IB = next;
                        obVar = ob.MATCHED;
                        this.HJ.b("acceptHandshakeAsClient - Matching extension found: {}", next);
                        break;
                    }
                }
                ob cC = cC(phVar.cJ(HttpHeaders.SEC_WEBSOCKET_PROTOCOL));
                ob obVar2 = ob.MATCHED;
                if (cC == obVar2 && obVar == obVar2) {
                    return obVar2;
                }
                pqVar = this.HJ;
                str = "acceptHandshakeAsClient - No matching extension or protocol found.";
            } else {
                pqVar = this.HJ;
                str = "acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.";
            }
        } else {
            pqVar = this.HJ;
            str = "acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept";
        }
        pqVar.cP(str);
        return ob.NOT_MATCHED;
    }

    private oc a(byte b) {
        if (b == 0) {
            return oc.CONTINUOUS;
        }
        if (b == 1) {
            return oc.TEXT;
        }
        if (b == 2) {
            return oc.BINARY;
        }
        switch (b) {
            case 8:
                return oc.CLOSING;
            case 9:
                return oc.PING;
            case 10:
                return oc.PONG;
            default:
                throw new oj("Unknown opcode " + ((int) b));
        }
    }

    @Override // com.baidu.ar.ny
    public pc a(pa paVar, pi piVar) {
        piVar.put("Upgrade", I0Io.f855xoIox);
        piVar.put("Connection", paVar.cJ("Connection"));
        String cJ = paVar.cJ(HttpHeaders.SEC_WEBSOCKET_KEY);
        if (cJ == null) {
            throw new ok("missing Sec-WebSocket-Key");
        }
        piVar.put(HttpHeaders.SEC_WEBSOCKET_ACCEPT, cD(cJ));
        if (jl().jA().length() != 0) {
            piVar.put(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS, jl().jA());
        }
        if (jn() != null && jn().jO().length() != 0) {
            piVar.put(HttpHeaders.SEC_WEBSOCKET_PROTOCOL, jn().jO());
        }
        piVar.cI("Web Socket Protocol Handshake");
        piVar.put("Server", "TooTallNate Java-WebSocket");
        piVar.put("Date", jq());
        return piVar;
    }

    @Override // com.baidu.ar.ny
    public List<ov> a(ByteBuffer byteBuffer, boolean z) {
        oq oqVar = new oq();
        oqVar.n(byteBuffer);
        oqVar.ap(z);
        try {
            oqVar.jC();
            return Collections.singletonList(oqVar);
        } catch (oh e) {
            throw new om(e);
        }
    }

    @Override // com.baidu.ar.ny
    public void a(nu nuVar, ov ovVar) {
        oc jJ = ovVar.jJ();
        if (jJ == oc.CLOSING) {
            e(nuVar, ovVar);
            return;
        }
        if (jJ == oc.PING) {
            nuVar.jf().a(nuVar, ovVar);
            return;
        }
        if (jJ == oc.PONG) {
            nuVar.je();
            nuVar.jf().b(nuVar, ovVar);
            return;
        }
        if (!ovVar.jF() || jJ == oc.CONTINUOUS) {
            a(nuVar, ovVar, jJ);
            return;
        }
        if (this.IF != null) {
            this.HJ.cQ("Protocol error: Continuous frame sequence not completed.");
            throw new oh(1002, "Continuous frame sequence not completed.");
        }
        if (jJ == oc.TEXT) {
            c(nuVar, ovVar);
        } else if (jJ == oc.BINARY) {
            b(nuVar, ovVar);
        } else {
            this.HJ.cQ("non control or continious frame expected");
            throw new oh(1002, "non control or continious frame expected");
        }
    }

    private void a(nu nuVar, ov ovVar, oc ocVar) {
        oc ocVar2 = oc.CONTINUOUS;
        if (ocVar != ocVar2) {
            d(ovVar);
        } else if (ovVar.jF()) {
            d(nuVar, ovVar);
        } else if (this.IF == null) {
            this.HJ.cQ("Protocol error: Continuous frame sequence was not started.");
            throw new oh(1002, "Continuous frame sequence was not started.");
        }
        if (ocVar == oc.TEXT && !pn.p(ovVar.jE())) {
            this.HJ.cQ("Protocol error: Payload is not UTF8");
            throw new oh(1007);
        }
        if (ocVar != ocVar2 || this.IF == null) {
            return;
        }
        m(ovVar.jE());
    }

    private void a(nu nuVar, RuntimeException runtimeException) {
        this.HJ.b("Runtime exception during onWebsocketMessage", (Throwable) runtimeException);
        nuVar.jf().a(nuVar, runtimeException);
    }
}
