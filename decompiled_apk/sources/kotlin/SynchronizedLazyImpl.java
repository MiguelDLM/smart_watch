package kotlin;

import java.io.Serializable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class SynchronizedLazyImpl<T> implements X0IIOO<T>, Serializable {

    @OXOo.oOoXoXO
    private volatile Object _value;

    @OXOo.oOoXoXO
    private Oox.oIX0oI<? extends T> initializer;

    @OXOo.OOXIXo
    private final Object lock;

    public SynchronizedLazyImpl(@OXOo.OOXIXo Oox.oIX0oI<? extends T> initializer, @OXOo.oOoXoXO Object obj) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(initializer, "initializer");
        this.initializer = initializer;
        this._value = ooOx.f29393oIX0oI;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.X0IIOO
    public T getValue() {
        T t;
        T t2 = (T) this._value;
        ooOx ooox = ooOx.f29393oIX0oI;
        if (t2 != ooox) {
            return t2;
        }
        synchronized (this.lock) {
            t = (T) this._value;
            if (t == ooox) {
                Oox.oIX0oI<? extends T> oix0oi = this.initializer;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(oix0oi);
                t = oix0oi.invoke();
                this._value = t;
                this.initializer = null;
            }
        }
        return t;
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

    public /* synthetic */ SynchronizedLazyImpl(Oox.oIX0oI oix0oi, Object obj, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(oix0oi, (i & 2) != 0 ? null : obj);
    }
}
