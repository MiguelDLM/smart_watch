package com.tencent.bugly.proguard;

import XIXIX.OOXIXo;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes13.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    protected String f26611a = "GBK";
    private ByteBuffer b;

    /* loaded from: classes13.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte f26612a;
        public int b;
    }

    public k() {
    }

    private boolean b(int i) {
        int i2;
        try {
            a aVar = new a();
            while (true) {
                int a2 = a(aVar, this.b.duplicate());
                i2 = aVar.b;
                if (i <= i2 || aVar.f26612a == 11) {
                    break;
                }
                a(a2);
                a(aVar.f26612a);
            }
        } catch (h | BufferUnderflowException unused) {
        }
        return i == i2;
    }

    private boolean[] d(int i, boolean z) {
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f26612a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    boolean[] zArr = new boolean[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        zArr[i2] = a(0, true);
                    }
                    return zArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a2)));
            }
            throw new h("type mismatch.");
        }
        if (!z) {
            return null;
        }
        throw new h("require field not exist.");
    }

    private short[] e(int i, boolean z) {
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f26612a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    short[] sArr = new short[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        sArr[i2] = a(sArr[0], 0, true);
                    }
                    return sArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a2)));
            }
            throw new h("type mismatch.");
        }
        if (!z) {
            return null;
        }
        throw new h("require field not exist.");
    }

    private int[] f(int i, boolean z) {
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f26612a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    int[] iArr = new int[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        iArr[i2] = a(iArr[0], 0, true);
                    }
                    return iArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a2)));
            }
            throw new h("type mismatch.");
        }
        if (!z) {
            return null;
        }
        throw new h("require field not exist.");
    }

    private long[] g(int i, boolean z) {
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f26612a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    long[] jArr = new long[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        jArr[i2] = a(jArr[0], 0, true);
                    }
                    return jArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a2)));
            }
            throw new h("type mismatch.");
        }
        if (!z) {
            return null;
        }
        throw new h("require field not exist.");
    }

    private float[] h(int i, boolean z) {
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f26612a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    float[] fArr = new float[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        fArr[i2] = a(fArr[0], 0, true);
                    }
                    return fArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a2)));
            }
            throw new h("type mismatch.");
        }
        if (!z) {
            return null;
        }
        throw new h("require field not exist.");
    }

    private double[] i(int i, boolean z) {
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f26612a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    double[] dArr = new double[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        dArr[i2] = a(dArr[0], 0, true);
                    }
                    return dArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a2)));
            }
            throw new h("type mismatch.");
        }
        if (!z) {
            return null;
        }
        throw new h("require field not exist.");
    }

    public final void a(byte[] bArr) {
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.b = ByteBuffer.wrap(bArr);
    }

    public final byte[] c(int i, boolean z) {
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            byte b = aVar.f26612a;
            if (b != 9) {
                if (b == 13) {
                    a aVar2 = new a();
                    a(aVar2);
                    if (aVar2.f26612a == 0) {
                        int a2 = a(0, 0, true);
                        if (a2 >= 0) {
                            byte[] bArr = new byte[a2];
                            this.b.get(bArr);
                            return bArr;
                        }
                        throw new h("invalid size, tag: " + i + ", type: " + ((int) aVar.f26612a) + ", " + ((int) aVar2.f26612a) + ", size: " + a2);
                    }
                    throw new h("type mismatch, tag: " + i + ", type: " + ((int) aVar.f26612a) + ", " + ((int) aVar2.f26612a));
                }
                throw new h("type mismatch.");
            }
            int a3 = a(0, 0, true);
            if (a3 >= 0) {
                byte[] bArr2 = new byte[a3];
                for (int i2 = 0; i2 < a3; i2++) {
                    bArr2[i2] = a(bArr2[0], 0, true);
                }
                return bArr2;
            }
            throw new h("size invalid: ".concat(String.valueOf(a3)));
        }
        if (!z) {
            return null;
        }
        throw new h("require field not exist.");
    }

    public k(byte[] bArr) {
        this.b = ByteBuffer.wrap(bArr);
    }

    private static int a(a aVar, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        aVar.f26612a = (byte) (b & 15);
        int i = (b & 240) >> 4;
        aVar.b = i;
        if (i != 15) {
            return 1;
        }
        aVar.b = byteBuffer.get();
        return 2;
    }

    public k(byte[] bArr, byte b) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.b = wrap;
        wrap.position(4);
    }

    private void b() {
        a aVar = new a();
        a(aVar);
        a(aVar.f26612a);
    }

    private void a(a aVar) {
        a(aVar, this.b);
    }

    private void a(int i) {
        ByteBuffer byteBuffer = this.b;
        byteBuffer.position(byteBuffer.position() + i);
    }

    public final String b(int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        byte b = aVar.f26612a;
        if (b == 6) {
            int i2 = this.b.get();
            if (i2 < 0) {
                i2 += 256;
            }
            byte[] bArr = new byte[i2];
            this.b.get(bArr);
            try {
                return new String(bArr, this.f26611a);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        }
        if (b == 7) {
            int i3 = this.b.getInt();
            if (i3 <= 104857600 && i3 >= 0) {
                byte[] bArr2 = new byte[i3];
                this.b.get(bArr2);
                try {
                    return new String(bArr2, this.f26611a);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            }
            throw new h("String too long: ".concat(String.valueOf(i3)));
        }
        throw new h("type mismatch.");
    }

    private void a() {
        a aVar = new a();
        do {
            a(aVar);
            a(aVar.f26612a);
        } while (aVar.f26612a != 11);
    }

    private void a(byte b) {
        int i = 0;
        switch (b) {
            case 0:
                a(1);
                return;
            case 1:
                a(2);
                return;
            case 2:
                a(4);
                return;
            case 3:
                a(8);
                return;
            case 4:
                a(4);
                return;
            case 5:
                a(8);
                return;
            case 6:
                int i2 = this.b.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                a(i2);
                return;
            case 7:
                a(this.b.getInt());
                return;
            case 8:
                int a2 = a(0, 0, true);
                while (i < a2 * 2) {
                    b();
                    i++;
                }
                return;
            case 9:
                int a3 = a(0, 0, true);
                while (i < a3) {
                    b();
                    i++;
                }
                return;
            case 10:
                a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar = new a();
                a(aVar);
                if (aVar.f26612a == 0) {
                    a(a(0, 0, true));
                    return;
                }
                throw new h("skipField with invalid type, type value: " + ((int) b) + ", " + ((int) aVar.f26612a));
            default:
                throw new h("invalid type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] b(T t, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f26612a == 9) {
            int a2 = a(0, 0, true);
            if (a2 >= 0) {
                T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), a2));
                for (int i2 = 0; i2 < a2; i2++) {
                    tArr[i2] = a((k) t, 0, true);
                }
                return tArr;
            }
            throw new h("size invalid: ".concat(String.valueOf(a2)));
        }
        throw new h("type mismatch.");
    }

    public final boolean a(int i, boolean z) {
        return a((byte) 0, i, z) != 0;
    }

    public final byte a(byte b, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return b;
        }
        a aVar = new a();
        a(aVar);
        byte b2 = aVar.f26612a;
        if (b2 == 0) {
            return this.b.get();
        }
        if (b2 == 12) {
            return (byte) 0;
        }
        throw new h("type mismatch.");
    }

    public final short a(short s, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return s;
        }
        a aVar = new a();
        a(aVar);
        byte b = aVar.f26612a;
        if (b == 0) {
            return this.b.get();
        }
        if (b == 1) {
            return this.b.getShort();
        }
        if (b == 12) {
            return (short) 0;
        }
        throw new h("type mismatch.");
    }

    public final int a(int i, int i2, boolean z) {
        if (!b(i2)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return i;
        }
        a aVar = new a();
        a(aVar);
        byte b = aVar.f26612a;
        if (b == 0) {
            return this.b.get();
        }
        if (b == 1) {
            return this.b.getShort();
        }
        if (b == 2) {
            return this.b.getInt();
        }
        if (b == 12) {
            return 0;
        }
        throw new h("type mismatch.");
    }

    public final long a(long j, int i, boolean z) {
        int i2;
        if (!b(i)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return j;
        }
        a aVar = new a();
        a(aVar);
        byte b = aVar.f26612a;
        if (b == 0) {
            i2 = this.b.get();
        } else if (b == 1) {
            i2 = this.b.getShort();
        } else {
            if (b != 2) {
                if (b == 3) {
                    return this.b.getLong();
                }
                if (b == 12) {
                    return 0L;
                }
                throw new h("type mismatch.");
            }
            i2 = this.b.getInt();
        }
        return i2;
    }

    private float a(float f, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return f;
        }
        a aVar = new a();
        a(aVar);
        byte b = aVar.f26612a;
        if (b == 4) {
            return this.b.getFloat();
        }
        if (b == 12) {
            return 0.0f;
        }
        throw new h("type mismatch.");
    }

    private double a(double d, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return d;
        }
        a aVar = new a();
        a(aVar);
        byte b = aVar.f26612a;
        if (b == 4) {
            return this.b.getFloat();
        }
        if (b == 5) {
            return this.b.getDouble();
        }
        if (b == 12) {
            return OOXIXo.f3760XO;
        }
        throw new h("type mismatch.");
    }

    public final <K, V> HashMap<K, V> a(Map<K, V> map, int i, boolean z) {
        return (HashMap) a(new HashMap(), map, i, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        if (map2 != null && !map2.isEmpty()) {
            Map.Entry<K, V> next = map2.entrySet().iterator().next();
            K key = next.getKey();
            V value = next.getValue();
            if (b(i)) {
                a aVar = new a();
                a(aVar);
                if (aVar.f26612a == 8) {
                    int a2 = a(0, 0, true);
                    if (a2 < 0) {
                        throw new h("size invalid: ".concat(String.valueOf(a2)));
                    }
                    for (int i2 = 0; i2 < a2; i2++) {
                        map.put(a((k) key, 0, true), a((k) value, 1, true));
                    }
                } else {
                    throw new h("type mismatch.");
                }
            } else if (z) {
                throw new h("require field not exist.");
            }
            return map;
        }
        return new HashMap();
    }

    private <T> T[] a(T[] tArr, int i, boolean z) {
        if (tArr != null && tArr.length != 0) {
            return (T[]) b(tArr[0], i, z);
        }
        throw new h("unable to get type of key and value.");
    }

    private <T> List<T> a(List<T> list, int i, boolean z) {
        if (list != null && !list.isEmpty()) {
            Object[] b = b(list.get(0), i, z);
            if (b == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : b) {
                arrayList.add(obj);
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public final m a(m mVar, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return null;
        }
        try {
            m mVar2 = (m) mVar.getClass().newInstance();
            a aVar = new a();
            a(aVar);
            if (aVar.f26612a == 10) {
                mVar2.a(this);
                a();
                return mVar2;
            }
            throw new h("type mismatch.");
        } catch (Exception e) {
            throw new h(e.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Object a(T t, int i, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(a(i, z));
        }
        if (t instanceof Short) {
            return Short.valueOf(a((short) 0, i, z));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(a(0, i, z));
        }
        if (t instanceof Long) {
            return Long.valueOf(a(0L, i, z));
        }
        if (t instanceof Float) {
            return Float.valueOf(a(0.0f, i, z));
        }
        if (t instanceof Double) {
            return Double.valueOf(a(OOXIXo.f3760XO, i, z));
        }
        if (t instanceof String) {
            return String.valueOf(b(i, z));
        }
        if (t instanceof Map) {
            return a((Map) t, i, z);
        }
        if (t instanceof List) {
            return a((List) t, i, z);
        }
        if (t instanceof m) {
            return a((m) t, i, z);
        }
        if (t.getClass().isArray()) {
            if (!(t instanceof byte[]) && !(t instanceof Byte[])) {
                if (t instanceof boolean[]) {
                    return d(i, z);
                }
                if (t instanceof short[]) {
                    return e(i, z);
                }
                if (t instanceof int[]) {
                    return f(i, z);
                }
                if (t instanceof long[]) {
                    return g(i, z);
                }
                if (t instanceof float[]) {
                    return h(i, z);
                }
                if (t instanceof double[]) {
                    return i(i, z);
                }
                return a((Object[]) t, i, z);
            }
            return c(i, z);
        }
        throw new h("read object error: unsupport type.");
    }

    public final int a(String str) {
        this.f26611a = str;
        return 0;
    }
}
