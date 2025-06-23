package org.apache.commons.text;

import java.util.Map;
import java.util.ResourceBundle;
import o0oIxXOx.OxxIIOOXO;

@Deprecated
/* loaded from: classes6.dex */
public abstract class II0XooXoX<V> implements OxxIIOOXO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final II0XooXoX<String> f33010oIX0oI = new II0xO0(null);

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final II0XooXoX<String> f33009II0xO0 = new oxoX();

    /* loaded from: classes6.dex */
    public static final class I0Io extends II0XooXoX<String> {

        /* renamed from: I0Io, reason: collision with root package name */
        public final ResourceBundle f33011I0Io;

        @Override // o0oIxXOx.OxxIIOOXO
        public String lookup(String str) {
            ResourceBundle resourceBundle = this.f33011I0Io;
            if (resourceBundle != null && str != null && resourceBundle.containsKey(str)) {
                return this.f33011I0Io.getString(str);
            }
            return null;
        }

        public String toString() {
            return super.toString() + " [resourceBundle=" + this.f33011I0Io + "]";
        }

        public I0Io(ResourceBundle resourceBundle) {
            this.f33011I0Io = resourceBundle;
        }
    }

    /* loaded from: classes6.dex */
    public static class II0xO0<V> extends II0XooXoX<V> {

        /* renamed from: I0Io, reason: collision with root package name */
        public final Map<String, V> f33012I0Io;

        public II0xO0(Map<String, V> map) {
            this.f33012I0Io = map;
        }

        @Override // o0oIxXOx.OxxIIOOXO
        public String lookup(String str) {
            V v;
            Map<String, V> map = this.f33012I0Io;
            if (map == null || (v = map.get(str)) == null) {
                return null;
            }
            return v.toString();
        }

        public String toString() {
            return super.toString() + " [map=" + this.f33012I0Io + "]";
        }
    }

    /* loaded from: classes6.dex */
    public static final class oxoX extends II0XooXoX<String> {
        public oxoX() {
        }

        @Override // o0oIxXOx.OxxIIOOXO
        public String lookup(String str) {
            if (str.length() > 0) {
                try {
                    return System.getProperty(str);
                } catch (SecurityException unused) {
                }
            }
            return null;
        }
    }

    public static II0XooXoX<?> I0Io() {
        return f33010oIX0oI;
    }

    public static <V> II0XooXoX<V> II0xO0(Map<String, V> map) {
        return new II0xO0(map);
    }

    public static II0XooXoX<String> X0o0xo() {
        return f33009II0xO0;
    }

    public static II0XooXoX<String> oxoX(ResourceBundle resourceBundle) {
        return new I0Io(resourceBundle);
    }
}
