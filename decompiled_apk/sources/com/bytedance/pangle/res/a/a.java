package com.bytedance.pangle.res.a;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;

/* loaded from: classes8.dex */
public class a {
    private static final Logger f = Logger.getLogger(a.class.getName());

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f10602a;
    private final h b;
    private final g c;
    private final e d;
    private C0563a e;

    /* renamed from: com.bytedance.pangle.res.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0563a {

        /* renamed from: a, reason: collision with root package name */
        public final short f10603a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        private C0563a(short s, int i, int i2, int i3) {
            this.f10603a = s;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i3 + i2;
        }

        public static C0563a a(g gVar, e eVar) {
            int a2 = eVar.a();
            try {
                return new C0563a(gVar.readShort(), gVar.readShort(), gVar.readInt(), a2);
            } catch (EOFException unused) {
                return new C0563a((short) -1, 0, 0, eVar.a());
            }
        }
    }

    public a(byte[] bArr, h hVar) {
        e eVar = new e(new ByteArrayInputStream(bArr));
        this.d = eVar;
        this.c = new g(new i(eVar));
        this.f10602a = bArr;
        this.b = hVar;
    }

    private String a(int i) {
        int i2;
        short s;
        StringBuilder sb = new StringBuilder(16);
        while (true) {
            i2 = i - 1;
            if (i == 0 || this.c.readByte() == 0) {
                break;
            }
            sb.append((char) s);
            i = i2;
        }
        this.c.skipBytes(i2);
        return sb.toString();
    }

    private void b() {
        b(515);
        int readInt = this.c.readInt();
        for (int i = 0; i < readInt; i++) {
            this.c.readInt();
            this.c.skipBytes(256);
        }
        while (j().f10603a == 513) {
            c();
        }
    }

    private void c() {
        d();
        short s = j().f10603a;
        while (s == 514) {
            d();
            s = j().f10603a;
        }
        while (s == 513) {
            e();
            if (this.d.a() < this.e.e) {
                f.warning("Unknown data detected. Skipping: " + (this.e.e - this.d.a()) + " byte(s)");
                e eVar = this.d;
                eVar.skip((long) (this.e.e - eVar.a()));
            }
            s = j().f10603a;
        }
    }

    private void d() {
        b(514);
        this.c.readUnsignedByte();
        this.c.skipBytes(3);
        this.c.skipBytes(this.c.readInt() * 4);
    }

    private void e() {
        b(513);
        this.c.readUnsignedByte();
        this.c.readByte();
        this.c.skipBytes(2);
        int readInt = this.c.readInt();
        int readInt2 = this.c.readInt();
        i();
        int i = (this.e.d + readInt2) - (readInt * 4);
        if (i != this.d.a()) {
            f.warning("Invalid data detected. Skipping: " + (i - this.d.a()) + " byte(s)");
            this.c.skipBytes(i - this.d.a());
        }
        int[] a2 = this.c.a(readInt);
        HashSet hashSet = new HashSet();
        for (int i2 : a2) {
            if (i2 != -1 && !hashSet.contains(Integer.valueOf(i2))) {
                f();
                hashSet.add(Integer.valueOf(i2));
            }
        }
    }

    private void f() {
        if (this.c.readShort() >= 0) {
            short readShort = this.c.readShort();
            this.c.readInt();
            if ((readShort & 1) == 0) {
                h();
                return;
            } else {
                g();
                return;
            }
        }
        throw new RuntimeException("Entry size is under 0 bytes.");
    }

    private void g() {
        int a2 = k.a(this.c);
        k.a(this.f10602a, this.c.readInt(), a2, this.b);
        int readInt = this.c.readInt();
        for (int i = 0; i < readInt; i++) {
            int a3 = k.a(this.c);
            k.a(this.f10602a, this.c.readInt(), a3, this.b);
            h();
        }
    }

    private void h() {
        this.c.a();
        this.c.b();
        byte readByte = this.c.readByte();
        int a2 = k.a(this.c);
        int readInt = this.c.readInt();
        if (readByte == 1) {
            k.a(this.f10602a, readInt, a2, this.b);
        }
        if (readByte == 2) {
            k.a(this.f10602a, readInt, a2, this.b);
        }
    }

    private void i() {
        int readInt = this.c.readInt();
        int i = 28;
        if (readInt >= 28) {
            this.c.readShort();
            this.c.readShort();
            this.c.readByte();
            this.c.readByte();
            this.c.readByte();
            this.c.readByte();
            this.c.readByte();
            this.c.readByte();
            this.c.readUnsignedShort();
            this.c.readByte();
            this.c.readByte();
            this.c.readByte();
            this.c.skipBytes(1);
            this.c.readShort();
            this.c.readShort();
            this.c.readShort();
            this.c.skipBytes(2);
            if (readInt >= 32) {
                this.c.readByte();
                this.c.readByte();
                this.c.readShort();
                i = 32;
            }
            if (readInt >= 36) {
                this.c.readShort();
                this.c.readShort();
                i = 36;
            }
            if (readInt >= 48) {
                a(4).toCharArray();
                a(8).toCharArray();
                i = 48;
            }
            if (readInt >= 52) {
                this.c.readByte();
                this.c.readByte();
                this.c.skipBytes(2);
                i = 52;
            }
            if (readInt >= 56) {
                this.c.skipBytes(4);
                i = 56;
            }
            int i2 = readInt - 56;
            if (i2 > 0) {
                byte[] bArr = new byte[i2];
                i += i2;
                this.c.readFully(bArr);
                BigInteger bigInteger = new BigInteger(1, bArr);
                if (bigInteger.equals(BigInteger.ZERO)) {
                    f.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", 56));
                } else {
                    f.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", 56, Integer.valueOf(readInt), bigInteger));
                }
            }
            int i3 = readInt - i;
            if (i3 > 0) {
                this.c.skipBytes(i3);
                return;
            }
            return;
        }
        throw new RuntimeException("Config size < 28");
    }

    private C0563a j() {
        C0563a a2 = C0563a.a(this.c, this.d);
        this.e = a2;
        return a2;
    }

    public final void a() {
        j();
        b(2);
        int readInt = this.c.readInt();
        l.a(this.c);
        j();
        for (int i = 0; i < readInt; i++) {
            b(512);
            this.c.readInt();
            this.c.skipBytes(256);
            this.c.skipBytes(4);
            this.c.skipBytes(4);
            this.c.skipBytes(4);
            this.c.skipBytes(4);
            if (this.e.b == 288 && this.c.readInt() > 0) {
                throw new RuntimeException("don't support");
            }
            l.a(this.c);
            l.a(this.c);
            j();
            boolean z = true;
            while (z) {
                short s = this.e.f10603a;
                if (s == 514) {
                    c();
                } else if (s != 515) {
                    z = false;
                } else {
                    b();
                }
            }
        }
    }

    private void b(int i) {
        if (this.e.f10603a != i) {
            throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", Integer.valueOf(i), Short.valueOf(this.e.f10603a)));
        }
    }
}
