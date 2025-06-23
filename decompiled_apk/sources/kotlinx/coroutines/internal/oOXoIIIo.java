package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes6.dex */
public final class oOXoIIIo<T> {

    @OXOo.OOXIXo
    private volatile AtomicReferenceArray<T> array;

    public oOXoIIIo(int i) {
        this.array = new AtomicReferenceArray<>(i);
    }

    public final void I0Io(int i, @OXOo.oOoXoXO T t) {
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        int length = atomicReferenceArray.length();
        if (i < length) {
            atomicReferenceArray.set(i, t);
            return;
        }
        AtomicReferenceArray<T> atomicReferenceArray2 = new AtomicReferenceArray<>(X0.IIXOooo.OxxIIOOXO(i + 1, length * 2));
        for (int i2 = 0; i2 < length; i2++) {
            atomicReferenceArray2.set(i2, atomicReferenceArray.get(i2));
        }
        atomicReferenceArray2.set(i, t);
        this.array = atomicReferenceArray2;
    }

    @OXOo.oOoXoXO
    public final T II0xO0(int i) {
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        if (i < atomicReferenceArray.length()) {
            return atomicReferenceArray.get(i);
        }
        return null;
    }

    public final int oIX0oI() {
        return this.array.length();
    }
}
