package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* loaded from: classes6.dex */
public final class II0xO0 extends kotlin.collections.x0xO0oo {

    /* renamed from: Oo, reason: collision with root package name */
    public int f29277Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final byte[] f29278XO;

    public II0xO0(@OXOo.OOXIXo byte[] array) {
        IIX0o.x0xO0oo(array, "array");
        this.f29278XO = array;
    }

    @Override // kotlin.collections.x0xO0oo
    public byte II0xO0() {
        try {
            byte[] bArr = this.f29278XO;
            int i = this.f29277Oo;
            this.f29277Oo = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f29277Oo--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f29277Oo < this.f29278XO.length) {
            return true;
        }
        return false;
    }
}
