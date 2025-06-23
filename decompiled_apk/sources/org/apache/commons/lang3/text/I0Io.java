package org.apache.commons.lang3.text;

import java.util.Map;

@Deprecated
/* loaded from: classes6.dex */
public abstract class I0Io<V> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final I0Io<String> f32774oIX0oI = new II0xO0(null);

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final I0Io<String> f32773II0xO0 = new C1137I0Io();

    /* renamed from: org.apache.commons.lang3.text.I0Io$I0Io, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1137I0Io extends I0Io<String> {
        public C1137I0Io() {
        }

        @Override // org.apache.commons.lang3.text.I0Io
        public String oIX0oI(String str) {
            if (!str.isEmpty()) {
                try {
                    return System.getProperty(str);
                } catch (SecurityException unused) {
                    return null;
                }
            }
            return null;
        }
    }

    /* loaded from: classes6.dex */
    public static class II0xO0<V> extends I0Io<V> {

        /* renamed from: I0Io, reason: collision with root package name */
        public final Map<String, V> f32775I0Io;

        public II0xO0(Map<String, V> map) {
            this.f32775I0Io = map;
        }

        @Override // org.apache.commons.lang3.text.I0Io
        public String oIX0oI(String str) {
            V v;
            Map<String, V> map = this.f32775I0Io;
            if (map == null || (v = map.get(str)) == null) {
                return null;
            }
            return v.toString();
        }
    }

    public static I0Io<?> I0Io() {
        return f32774oIX0oI;
    }

    public static <V> I0Io<V> II0xO0(Map<String, V> map) {
        return new II0xO0(map);
    }

    public static I0Io<String> oxoX() {
        return f32773II0xO0;
    }

    public abstract String oIX0oI(String str);
}
