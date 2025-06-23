package xOxOoo;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.reflect.x0XOIxOo;

/* loaded from: classes6.dex */
public abstract class I0Io<V> implements XO<Object, V> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public V f34494oIX0oI;

    public I0Io(V v) {
        this.f34494oIX0oI = v;
    }

    public void I0Io(@OOXIXo x0XOIxOo<?> property, V v, V v2) {
        IIX0o.x0xO0oo(property, "property");
    }

    @Override // xOxOoo.XO
    public void II0xO0(@oOoXoXO Object obj, @OOXIXo x0XOIxOo<?> property, V v) {
        IIX0o.x0xO0oo(property, "property");
        V v2 = this.f34494oIX0oI;
        if (!oxoX(property, v2, v)) {
            return;
        }
        this.f34494oIX0oI = v;
        I0Io(property, v2, v);
    }

    @Override // xOxOoo.XO, xOxOoo.X0o0xo
    public V oIX0oI(@oOoXoXO Object obj, @OOXIXo x0XOIxOo<?> property) {
        IIX0o.x0xO0oo(property, "property");
        return this.f34494oIX0oI;
    }

    public boolean oxoX(@OOXIXo x0XOIxOo<?> property, V v, V v2) {
        IIX0o.x0xO0oo(property, "property");
        return true;
    }

    @OOXIXo
    public String toString() {
        return "ObservableProperty(value=" + this.f34494oIX0oI + HexStringBuilder.COMMENT_END_CHAR;
    }
}
