package com.tencent.bugly.proguard;

import com.garmin.fit.O0Xx;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes13.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f26613a;
    protected String b;

    public l(int i) {
        this.b = "GBK";
        this.f26613a = ByteBuffer.allocate(i);
    }

    private void a(int i) {
        if (this.f26613a.remaining() < i) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f26613a.capacity() + i) * 2);
            allocate.put(this.f26613a.array(), 0, this.f26613a.position());
            this.f26613a = allocate;
        }
    }

    private void b(byte b, int i) {
        if (i < 15) {
            this.f26613a.put((byte) (b | (i << 4)));
        } else {
            if (i < 256) {
                this.f26613a.put((byte) (b | 240));
                this.f26613a.put((byte) i);
                return;
            }
            throw new j("tag is too large: ".concat(String.valueOf(i)));
        }
    }

    public l() {
        this(128);
    }

    public final void a(boolean z, int i) {
        a(z ? (byte) 1 : (byte) 0, i);
    }

    public final void a(byte b, int i) {
        a(3);
        if (b == 0) {
            b((byte) 12, i);
        } else {
            b((byte) 0, i);
            this.f26613a.put(b);
        }
    }

    public final void a(short s, int i) {
        a(4);
        if (s >= -128 && s <= 127) {
            a((byte) s, i);
        } else {
            b((byte) 1, i);
            this.f26613a.putShort(s);
        }
    }

    public final void a(int i, int i2) {
        a(6);
        if (i >= -32768 && i <= 32767) {
            a((short) i, i2);
        } else {
            b((byte) 2, i2);
            this.f26613a.putInt(i);
        }
    }

    public final void a(long j, int i) {
        a(10);
        if (j >= O0Xx.f12378xXxxox0I && j <= 2147483647L) {
            a((int) j, i);
        } else {
            b((byte) 3, i);
            this.f26613a.putLong(j);
        }
    }

    private void a(float f, int i) {
        a(6);
        b((byte) 4, i);
        this.f26613a.putFloat(f);
    }

    private void a(double d, int i) {
        a(10);
        b((byte) 5, i);
        this.f26613a.putDouble(d);
    }

    public final void a(String str, int i) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.b);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            b((byte) 7, i);
            this.f26613a.putInt(bytes.length);
            this.f26613a.put(bytes);
        } else {
            b((byte) 6, i);
            this.f26613a.put((byte) bytes.length);
            this.f26613a.put(bytes);
        }
    }

    public final <K, V> void a(Map<K, V> map, int i) {
        a(8);
        b((byte) 8, i);
        a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                a(entry.getKey(), 0);
                a(entry.getValue(), 1);
            }
        }
    }

    private void a(boolean[] zArr, int i) {
        a(8);
        b((byte) 9, i);
        a(zArr.length, 0);
        for (boolean z : zArr) {
            a(z, 0);
        }
    }

    public final void a(byte[] bArr, int i) {
        a(bArr.length + 8);
        b((byte) 13, i);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.f26613a.put(bArr);
    }

    private void a(short[] sArr, int i) {
        a(8);
        b((byte) 9, i);
        a(sArr.length, 0);
        for (short s : sArr) {
            a(s, 0);
        }
    }

    private void a(int[] iArr, int i) {
        a(8);
        b((byte) 9, i);
        a(iArr.length, 0);
        for (int i2 : iArr) {
            a(i2, 0);
        }
    }

    private void a(long[] jArr, int i) {
        a(8);
        b((byte) 9, i);
        a(jArr.length, 0);
        for (long j : jArr) {
            a(j, 0);
        }
    }

    private void a(float[] fArr, int i) {
        a(8);
        b((byte) 9, i);
        a(fArr.length, 0);
        for (float f : fArr) {
            a(f, 0);
        }
    }

    private void a(double[] dArr, int i) {
        a(8);
        b((byte) 9, i);
        a(dArr.length, 0);
        for (double d : dArr) {
            a(d, 0);
        }
    }

    private void a(Object[] objArr, int i) {
        a(8);
        b((byte) 9, i);
        a(objArr.length, 0);
        for (Object obj : objArr) {
            a(obj, 0);
        }
    }

    public final <T> void a(Collection<T> collection, int i) {
        a(8);
        b((byte) 9, i);
        a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                a(it.next(), 0);
            }
        }
    }

    public final void a(m mVar, int i) {
        a(2);
        b((byte) 10, i);
        mVar.a(this);
        a(2);
        b((byte) 11, 0);
    }

    public final void a(Object obj, int i) {
        if (obj instanceof Byte) {
            a(((Byte) obj).byteValue(), i);
            return;
        }
        if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue(), i);
            return;
        }
        if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i);
            return;
        }
        if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i);
            return;
        }
        if (obj instanceof Long) {
            a(((Long) obj).longValue(), i);
            return;
        }
        if (obj instanceof Float) {
            a(((Float) obj).floatValue(), i);
            return;
        }
        if (obj instanceof Double) {
            a(((Double) obj).doubleValue(), i);
            return;
        }
        if (obj instanceof String) {
            a((String) obj, i);
            return;
        }
        if (obj instanceof Map) {
            a((Map) obj, i);
            return;
        }
        if (obj instanceof List) {
            a((Collection) obj, i);
            return;
        }
        if (obj instanceof m) {
            a((m) obj, i);
            return;
        }
        if (obj instanceof byte[]) {
            a((byte[]) obj, i);
            return;
        }
        if (obj instanceof boolean[]) {
            a((boolean[]) obj, i);
            return;
        }
        if (obj instanceof short[]) {
            a((short[]) obj, i);
            return;
        }
        if (obj instanceof int[]) {
            a((int[]) obj, i);
            return;
        }
        if (obj instanceof long[]) {
            a((long[]) obj, i);
            return;
        }
        if (obj instanceof float[]) {
            a((float[]) obj, i);
            return;
        }
        if (obj instanceof double[]) {
            a((double[]) obj, i);
            return;
        }
        if (obj.getClass().isArray()) {
            a((Object[]) obj, i);
        } else if (obj instanceof Collection) {
            a((Collection) obj, i);
        } else {
            throw new j("write object error: unsupport type. " + obj.getClass());
        }
    }

    public final int a(String str) {
        this.b = str;
        return 0;
    }
}
