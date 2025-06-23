package kotlin;

import java.io.Serializable;

/* loaded from: classes6.dex */
public final class UnsafeLazyImpl<T> implements X0IIOO<T>, Serializable {

    @OXOo.oOoXoXO
    private Object _value;

    @OXOo.oOoXoXO
    private Oox.oIX0oI<? extends T> initializer;

    public UnsafeLazyImpl(@OXOo.OOXIXo Oox.oIX0oI<? extends T> initializer) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(initializer, "initializer");
        this.initializer = initializer;
        this._value = ooOx.f29393oIX0oI;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.X0IIOO
    public T getValue() {
        if (this._value == ooOx.f29393oIX0oI) {
            Oox.oIX0oI<? extends T> oix0oi = this.initializer;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oix0oi);
            this._value = oix0oi.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    @Override // kotlin.X0IIOO
    public boolean isInitialized() {
        if (this._value != ooOx.f29393oIX0oI) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public String toString() {
        if (isInitialized()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }
}
