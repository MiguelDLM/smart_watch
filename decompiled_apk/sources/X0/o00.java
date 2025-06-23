package X0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.oxxXoxO;
import kotlin.xxIO;

@oxxXoxO(version = "1.3")
/* loaded from: classes6.dex */
public final class o00 implements Iterator<xxIO>, OI0IXox.oIX0oI {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final int f3197IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f3198Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f3199Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final int f3200XO;

    public /* synthetic */ o00(int i, int i2, int i3, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(i, i2, i3);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3198Oo;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ xxIO next() {
        return xxIO.oxoX(oIX0oI());
    }

    public int oIX0oI() {
        int i = this.f3199Oxx0xo;
        if (i == this.f3200XO) {
            if (this.f3198Oo) {
                this.f3198Oo = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f3199Oxx0xo = xxIO.oOoXoXO(this.f3197IXxxXO + i);
        }
        return i;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public o00(int i, int i2, int i3) {
        int compare;
        this.f3200XO = i2;
        boolean z = false;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
        if (i3 <= 0 ? compare >= 0 : compare <= 0) {
            z = true;
        }
        this.f3198Oo = z;
        this.f3197IXxxXO = xxIO.oOoXoXO(i3);
        this.f3199Oxx0xo = this.f3198Oo ? i : i2;
    }
}
