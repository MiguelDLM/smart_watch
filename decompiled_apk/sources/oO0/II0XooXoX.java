package oO0;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class II0XooXoX<K, V> extends OOXIXo<K, V> implements Map<K, V> {

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public xoIox<K, V> f31840XI0IXoo;

    /* loaded from: classes6.dex */
    public class oIX0oI extends xoIox<K, V> {
        public oIX0oI() {
        }

        @Override // oO0.xoIox
        public Map<K, V> I0Io() {
            return II0XooXoX.this;
        }

        @Override // oO0.xoIox
        public void II0XooXoX(int i) {
            II0XooXoX.this.oOoXoXO(i);
        }

        @Override // oO0.xoIox
        public Object II0xO0(int i, int i2) {
            return II0XooXoX.this.f31852Oo[(i << 1) + i2];
        }

        @Override // oO0.xoIox
        public void Oxx0IOOO(K k, V v) {
            II0XooXoX.this.put(k, v);
        }

        @Override // oO0.xoIox
        public int X0o0xo(Object obj) {
            return II0XooXoX.this.Oxx0IOOO(obj);
        }

        @Override // oO0.xoIox
        public int XO(Object obj) {
            return II0XooXoX.this.xxIXOIIO(obj);
        }

        @Override // oO0.xoIox
        public void oIX0oI() {
            II0XooXoX.this.clear();
        }

        @Override // oO0.xoIox
        public int oxoX() {
            return II0XooXoX.this.f31851IXxxXO;
        }

        @Override // oO0.xoIox
        public V xxIXOIIO(int i, V v) {
            return II0XooXoX.this.ooOOo0oXI(i, v);
        }
    }

    public II0XooXoX() {
    }

    public boolean IXxxXO(Collection<?> collection) {
        return xoIox.x0xO0oo(this, collection);
    }

    public boolean Oo(Collection<?> collection) {
        return xoIox.oO(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return x0xO0oo().oOoXoXO();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return x0xO0oo().ooOOo0oXI();
    }

    public boolean oO(Collection<?> collection) {
        return xoIox.xoIox(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        oxoX(this.f31851IXxxXO + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return x0xO0oo().x0XOIxOo();
    }

    public final xoIox<K, V> x0xO0oo() {
        if (this.f31840XI0IXoo == null) {
            this.f31840XI0IXoo = new oIX0oI();
        }
        return this.f31840XI0IXoo;
    }

    public II0XooXoX(int i) {
        super(i);
    }

    public II0XooXoX(OOXIXo oOXIXo) {
        super(oOXIXo);
    }
}
