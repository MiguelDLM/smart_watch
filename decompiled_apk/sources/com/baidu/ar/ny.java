package com.baidu.ar;

import IoxX.I0Io;
import com.google.common.net.HttpHeaders;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes7.dex */
public abstract class ny {
    protected oe Id = null;
    protected oc IA = null;

    /* JADX WARN: Code restructure failed: missing block: B:29:0x007b, code lost:
    
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007d, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
    
        throw new com.baidu.ar.og();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.baidu.ar.pc a(java.nio.ByteBuffer r7, com.baidu.ar.oe r8) {
        /*
            java.lang.String r0 = h(r7)
            if (r0 == 0) goto L8a
            java.lang.String r1 = " "
            r2 = 3
            java.lang.String[] r1 = r0.split(r1, r2)
            int r3 = r1.length
            if (r3 != r2) goto L84
            com.baidu.ar.oe r2 = com.baidu.ar.oe.CLIENT
            if (r8 != r2) goto L19
            com.baidu.ar.pc r8 = b(r1, r0)
            goto L1d
        L19:
            com.baidu.ar.pc r8 = a(r1, r0)
        L1d:
            java.lang.String r0 = h(r7)
            if (r0 == 0) goto L7b
            int r1 = r0.length()
            if (r1 <= 0) goto L7b
            java.lang.String r1 = ":"
            r2 = 2
            java.lang.String[] r0 = r0.split(r1, r2)
            int r1 = r0.length
            if (r1 != r2) goto L73
            r1 = 0
            r2 = r0[r1]
            boolean r2 = r8.cK(r2)
            java.lang.String r3 = ""
            java.lang.String r4 = "^ +"
            r5 = 1
            if (r2 == 0) goto L67
            r2 = r0[r1]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r1 = r0[r1]
            java.lang.String r1 = r8.cJ(r1)
            r6.append(r1)
            java.lang.String r1 = "; "
            r6.append(r1)
            r0 = r0[r5]
            java.lang.String r0 = r0.replaceFirst(r4, r3)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r8.put(r2, r0)
            goto L1d
        L67:
            r1 = r0[r1]
            r0 = r0[r5]
            java.lang.String r0 = r0.replaceFirst(r4, r3)
            r8.put(r1, r0)
            goto L1d
        L73:
            com.baidu.ar.ok r7 = new com.baidu.ar.ok
            java.lang.String r8 = "not an http header"
            r7.<init>(r8)
            throw r7
        L7b:
            if (r0 == 0) goto L7e
            return r8
        L7e:
            com.baidu.ar.og r7 = new com.baidu.ar.og
            r7.<init>()
            throw r7
        L84:
            com.baidu.ar.ok r7 = new com.baidu.ar.ok
            r7.<init>()
            throw r7
        L8a:
            com.baidu.ar.og r8 = new com.baidu.ar.og
            int r7 = r7.capacity()
            int r7 = r7 + 128
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.ny.a(java.nio.ByteBuffer, com.baidu.ar.oe):com.baidu.ar.pc");
    }

    private static pc b(String[] strArr, String str) {
        if (!"101".equals(strArr[1])) {
            throw new ok(String.format("Invalid status code received: %s Status line: %s", strArr[1], str));
        }
        if (!"HTTP/1.1".equalsIgnoreCase(strArr[0])) {
            throw new ok(String.format("Invalid status line received: %s Status line: %s", strArr[0], str));
        }
        pe peVar = new pe();
        peVar.a(Short.parseShort(strArr[1]));
        peVar.cI(strArr[2]);
        return peVar;
    }

    public static ByteBuffer g(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b = 48;
        while (byteBuffer.hasRemaining()) {
            byte b2 = byteBuffer.get();
            allocate.put(b2);
            if (b == 13 && b2 == 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                return allocate;
            }
            b = b2;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        return null;
    }

    public static String h(ByteBuffer byteBuffer) {
        ByteBuffer g = g(byteBuffer);
        if (g == null) {
            return null;
        }
        return pn.b(g.array(), 0, g.limit());
    }

    public abstract ob a(pa paVar);

    public abstract ob a(pa paVar, ph phVar);

    public abstract pc a(pa paVar, pi piVar);

    public abstract List<ov> a(ByteBuffer byteBuffer, boolean z);

    public abstract void a(nu nuVar, ov ovVar);

    public int af(int i) {
        if (i >= 0) {
            return i;
        }
        throw new oh(1002, "Negative count");
    }

    public abstract pb b(pb pbVar);

    public abstract ByteBuffer b(ov ovVar);

    public List<ByteBuffer> c(pf pfVar) {
        return a(pfVar, true);
    }

    public int d(pf pfVar) {
        String cJ = pfVar.cJ(HttpHeaders.SEC_WEBSOCKET_VERSION);
        if (cJ.length() > 0) {
            try {
                return new Integer(cJ.trim()).intValue();
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    public abstract List<ov> d(String str, boolean z);

    public abstract List<ov> i(ByteBuffer byteBuffer);

    public pf j(ByteBuffer byteBuffer) {
        return a(byteBuffer, this.Id);
    }

    public abstract oa jj();

    public abstract ny jk();

    public abstract void reset();

    public String toString() {
        return getClass().getSimpleName();
    }

    private static pc a(String[] strArr, String str) {
        if (!"GET".equalsIgnoreCase(strArr[0])) {
            throw new ok(String.format("Invalid request method received: %s Status line: %s", strArr[0], str));
        }
        if (!"HTTP/1.1".equalsIgnoreCase(strArr[2])) {
            throw new ok(String.format("Invalid status line received: %s Status line: %s", strArr[2], str));
        }
        pd pdVar = new pd();
        pdVar.cH(strArr[1]);
        return pdVar;
    }

    public boolean b(pf pfVar) {
        return pfVar.cJ("Upgrade").equalsIgnoreCase(I0Io.f855xoIox) && pfVar.cJ("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    public List<ByteBuffer> a(pf pfVar, boolean z) {
        String jL;
        StringBuilder sb = new StringBuilder(100);
        if (pfVar instanceof pa) {
            sb.append("GET ");
            sb.append(((pa) pfVar).jK());
            jL = " HTTP/1.1";
        } else {
            if (!(pfVar instanceof ph)) {
                throw new IllegalArgumentException("unknown role");
            }
            sb.append("HTTP/1.1 101 ");
            jL = ((ph) pfVar).jL();
        }
        sb.append(jL);
        sb.append("\r\n");
        Iterator<String> jM = pfVar.jM();
        while (jM.hasNext()) {
            String next = jM.next();
            String cJ = pfVar.cJ(next);
            sb.append(next);
            sb.append(": ");
            sb.append(cJ);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        byte[] cN = pn.cN(sb.toString());
        byte[] jN = z ? pfVar.jN() : null;
        ByteBuffer allocate = ByteBuffer.allocate((jN == null ? 0 : jN.length) + cN.length);
        allocate.put(cN);
        if (jN != null) {
            allocate.put(jN);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public void a(oe oeVar) {
        this.Id = oeVar;
    }
}
