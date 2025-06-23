package kotlin;

import java.io.Serializable;

/* loaded from: classes6.dex */
public final class InitializedLazyImpl<T> implements X0IIOO<T>, Serializable {
    private final T value;

    public InitializedLazyImpl(T t) {
        this.value = t;
    }

    @Override // kotlin.X0IIOO
    public T getValue() {
        return this.value;
    }

    @Override // kotlin.X0IIOO
    public boolean isInitialized() {
        return true;
    }

    @OXOo.OOXIXo
    public String toString() {
        return String.valueOf(getValue());
    }
}
