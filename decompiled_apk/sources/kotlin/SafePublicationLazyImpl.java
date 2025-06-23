package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class SafePublicationLazyImpl<T> implements X0IIOO<T>, Serializable {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> valueUpdater = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");

    @OXOo.oOoXoXO
    private volatile Object _value;

    /* renamed from: final, reason: not valid java name */
    @OXOo.OOXIXo
    private final Object f10final;

    @OXOo.oOoXoXO
    private volatile Oox.oIX0oI<? extends T> initializer;

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public SafePublicationLazyImpl(@OXOo.OOXIXo Oox.oIX0oI<? extends T> initializer) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(initializer, "initializer");
        this.initializer = initializer;
        ooOx ooox = ooOx.f29393oIX0oI;
        this._value = ooox;
        this.f10final = ooox;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.X0IIOO
    public T getValue() {
        T t = (T) this._value;
        ooOx ooox = ooOx.f29393oIX0oI;
        if (t != ooox) {
            return t;
        }
        Oox.oIX0oI<? extends T> oix0oi = this.initializer;
        if (oix0oi != null) {
            T invoke = oix0oi.invoke();
            if (androidx.concurrent.futures.oIX0oI.oIX0oI(valueUpdater, this, ooox, invoke)) {
                this.initializer = null;
                return invoke;
            }
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
