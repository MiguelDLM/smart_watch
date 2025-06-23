package xOxOoo;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.reflect.x0XOIxOo;

/* loaded from: classes6.dex */
public final class II0xO0<T> implements XO<Object, T> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @oOoXoXO
    public T f34495oIX0oI;

    @Override // xOxOoo.XO
    public void II0xO0(@oOoXoXO Object obj, @OOXIXo x0XOIxOo<?> property, @OOXIXo T value) {
        IIX0o.x0xO0oo(property, "property");
        IIX0o.x0xO0oo(value, "value");
        this.f34495oIX0oI = value;
    }

    @Override // xOxOoo.XO, xOxOoo.X0o0xo
    @OOXIXo
    public T oIX0oI(@oOoXoXO Object obj, @OOXIXo x0XOIxOo<?> property) {
        IIX0o.x0xO0oo(property, "property");
        T t = this.f34495oIX0oI;
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Property " + property.getName() + " should be initialized before get.");
    }

    @OOXIXo
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("NotNullProperty(");
        if (this.f34495oIX0oI != null) {
            str = "value=" + this.f34495oIX0oI;
        } else {
            str = "value not initialized yet";
        }
        sb.append(str);
        sb.append(HexStringBuilder.COMMENT_END_CHAR);
        return sb.toString();
    }
}
