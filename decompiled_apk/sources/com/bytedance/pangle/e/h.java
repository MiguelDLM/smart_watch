package com.bytedance.pangle.e;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HTTP;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public final class h implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final FileInputStream f10541a;
    private a b;
    private b[] c;
    private c[] d;
    private final Map<String, c> e = new HashMap();

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f10542a;
        public final short b;
        public final short c;
        public final int d;
        public final long e;
        public final long f;
        public final long g;
        public final int h;
        public final short i;
        public final short j;
        public final short k;
        public final short l;
        public final short m;
        public final short n;

        public /* synthetic */ a(FileChannel fileChannel, byte b) {
            this(fileChannel);
        }

        private a(FileChannel fileChannel) {
            byte[] bArr = new byte[16];
            this.f10542a = bArr;
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(bArr));
            if (bArr[0] == Byte.MAX_VALUE && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
                h.a(bArr[4], 2, "bad elf class: " + ((int) bArr[4]));
                h.a(bArr[5], 2, "bad elf data encoding: " + ((int) bArr[5]));
                ByteBuffer allocate = ByteBuffer.allocate(bArr[4] == 1 ? 36 : 48);
                allocate.order(bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                h.b(fileChannel, allocate, "failed to read rest part of ehdr.");
                this.b = allocate.getShort();
                this.c = allocate.getShort();
                int i = allocate.getInt();
                this.d = i;
                h.a(i, 1, "bad elf version: " + i);
                byte b = bArr[4];
                if (b == 1) {
                    this.e = allocate.getInt();
                    this.f = allocate.getInt();
                    this.g = allocate.getInt();
                } else if (b == 2) {
                    this.e = allocate.getLong();
                    this.f = allocate.getLong();
                    this.g = allocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) bArr[4]));
                }
                this.h = allocate.getInt();
                this.i = allocate.getShort();
                this.j = allocate.getShort();
                this.k = allocate.getShort();
                this.l = allocate.getShort();
                this.m = allocate.getShort();
                this.n = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])));
        }
    }

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f10543a;
        public final int b;
        public final long c;
        public final long d;
        public final long e;
        public final long f;
        public final long g;
        public final long h;

        public /* synthetic */ b(ByteBuffer byteBuffer, int i, byte b) {
            this(byteBuffer, i);
        }

        private b(ByteBuffer byteBuffer, int i) {
            if (i == 1) {
                this.f10543a = byteBuffer.getInt();
                this.c = byteBuffer.getInt();
                this.d = byteBuffer.getInt();
                this.e = byteBuffer.getInt();
                this.f = byteBuffer.getInt();
                this.g = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.h = byteBuffer.getInt();
                return;
            }
            if (i == 2) {
                this.f10543a = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.c = byteBuffer.getLong();
                this.d = byteBuffer.getLong();
                this.e = byteBuffer.getLong();
                this.f = byteBuffer.getLong();
                this.g = byteBuffer.getLong();
                this.h = byteBuffer.getLong();
                return;
            }
            throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
        }
    }

    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f10544a;
        public final int b;
        public final long c;
        public final long d;
        public final long e;
        public final long f;
        public final int g;
        public final int h;
        public final long i;
        public final long j;
        public String k;

        public /* synthetic */ c(ByteBuffer byteBuffer, int i, byte b) {
            this(byteBuffer, i);
        }

        private c(ByteBuffer byteBuffer, int i) {
            if (i == 1) {
                this.f10544a = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.c = byteBuffer.getInt();
                this.d = byteBuffer.getInt();
                this.e = byteBuffer.getInt();
                this.f = byteBuffer.getInt();
                this.g = byteBuffer.getInt();
                this.h = byteBuffer.getInt();
                this.i = byteBuffer.getInt();
                this.j = byteBuffer.getInt();
            } else if (i == 2) {
                this.f10544a = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.c = byteBuffer.getLong();
                this.d = byteBuffer.getLong();
                this.e = byteBuffer.getLong();
                this.f = byteBuffer.getLong();
                this.g = byteBuffer.getInt();
                this.h = byteBuffer.getInt();
                this.i = byteBuffer.getLong();
                this.j = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
            }
            this.k = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private h(File file) {
        ByteOrder byteOrder;
        c[] cVarArr;
        this.b = null;
        this.c = null;
        this.d = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        this.f10541a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        this.b = new a(channel, 0 == true ? 1 : 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.b.j);
        if (this.b.f10542a[5] == 1) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        allocate.order(byteOrder);
        channel.position(this.b.f);
        this.c = new b[this.b.k];
        for (int i = 0; i < this.c.length; i++) {
            b(channel, allocate, "failed to read phdr.");
            this.c[i] = new b(allocate, this.b.f10542a[4], objArr2 == true ? 1 : 0);
        }
        channel.position(this.b.g);
        allocate.limit(this.b.l);
        this.d = new c[this.b.m];
        int i2 = 0;
        while (true) {
            cVarArr = this.d;
            if (i2 >= cVarArr.length) {
                break;
            }
            b(channel, allocate, "failed to read shdr.");
            this.d[i2] = new c(allocate, this.b.f10542a[4], objArr == true ? 1 : 0);
            i2++;
        }
        short s = this.b.n;
        if (s > 0) {
            c cVar = cVarArr[s];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) cVar.f);
            this.f10541a.getChannel().position(cVar.e);
            b(this.f10541a.getChannel(), allocate2, "failed to read section: " + cVar.k);
            for (c cVar2 : this.d) {
                allocate2.position(cVar2.f10544a);
                String a2 = a(allocate2);
                cVar2.k = a2;
                this.e.put(a2, cVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(FileChannel fileChannel, ByteBuffer byteBuffer, String str) {
        byteBuffer.rewind();
        int read = fileChannel.read(byteBuffer);
        if (read == byteBuffer.limit()) {
            byteBuffer.flip();
            return;
        }
        throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + read + " bytes were read.");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f10541a.close();
        this.e.clear();
        this.c = null;
        this.d = null;
    }

    public static boolean a(File file) {
        try {
            com.bytedance.pangle.util.g.a(new h(file));
            return true;
        } catch (IOException unused) {
            com.bytedance.pangle.util.g.a((Closeable) null);
            return false;
        } catch (Throwable th) {
            com.bytedance.pangle.util.g.a((Closeable) null);
            throw th;
        }
    }

    private static String a(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position();
        while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(array, position, (byteBuffer.position() - position) - 1, Charset.forName(HTTP.ASCII));
    }

    public static /* synthetic */ void a(int i, int i2, String str) {
        if (i <= 0 || i > i2) {
            throw new IOException(str);
        }
    }
}
