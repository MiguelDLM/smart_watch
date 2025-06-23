package kotlinx.coroutines.flow;

/* loaded from: classes6.dex */
public interface xoIox<T> extends IIXOooo<T>, xxIXOIIO<T> {
    boolean compareAndSet(T t, T t2);

    @Override // kotlinx.coroutines.flow.IIXOooo
    T getValue();

    void setValue(T t);
}
