package X0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.XI0oooXX;
import kotlin.oxxXoxO;

@oxxXoxO(version = "1.3")
/* loaded from: classes6.dex */
public final class X0IIOO implements Iterator<XI0oooXX>, OI0IXox.oIX0oI {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final long f3189IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f3190Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public long f3191Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final long f3192XO;

    public /* synthetic */ X0IIOO(long j, long j2, long j3, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(j, j2, j3);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3190Oo;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ XI0oooXX next() {
        return XI0oooXX.oxoX(oIX0oI());
    }

    public long oIX0oI() {
        long j = this.f3191Oxx0xo;
        if (j == this.f3192XO) {
            if (this.f3190Oo) {
                this.f3190Oo = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f3191Oxx0xo = XI0oooXX.oOoXoXO(this.f3189IXxxXO + j);
        }
        return j;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public X0IIOO(long j, long j2, long j3) {
        int compare;
        this.f3192XO = j2;
        boolean z = false;
        compare = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
        if (j3 <= 0 ? compare >= 0 : compare <= 0) {
            z = true;
        }
        this.f3190Oo = z;
        this.f3189IXxxXO = XI0oooXX.oOoXoXO(j3);
        this.f3191Oxx0xo = this.f3190Oo ? j : j2;
    }
}
