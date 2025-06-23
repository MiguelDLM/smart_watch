package X0;

import java.util.NoSuchElementException;
import kotlin.collections.Xx000oIo;

/* loaded from: classes6.dex */
public final class x0XOIxOo extends Xx000oIo {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f3215IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final long f3216Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public long f3217Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final long f3218XO;

    public x0XOIxOo(long j, long j2, long j3) {
        this.f3218XO = j3;
        this.f3216Oo = j2;
        boolean z = false;
        if (j3 <= 0 ? j >= j2 : j <= j2) {
            z = true;
        }
        this.f3215IXxxXO = z;
        this.f3217Oxx0xo = z ? j : j2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3215IXxxXO;
    }

    @Override // kotlin.collections.Xx000oIo
    public long nextLong() {
        long j = this.f3217Oxx0xo;
        if (j == this.f3216Oo) {
            if (this.f3215IXxxXO) {
                this.f3215IXxxXO = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f3217Oxx0xo = this.f3218XO + j;
        }
        return j;
    }

    public final long oIX0oI() {
        return this.f3218XO;
    }
}
