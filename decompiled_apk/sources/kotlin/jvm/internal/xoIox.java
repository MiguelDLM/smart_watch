package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* loaded from: classes6.dex */
public final class xoIox extends kotlin.collections.Xx000oIo {

    /* renamed from: Oo, reason: collision with root package name */
    public int f29375Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final long[] f29376XO;

    public xoIox(@OXOo.OOXIXo long[] array) {
        IIX0o.x0xO0oo(array, "array");
        this.f29376XO = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f29375Oo < this.f29376XO.length) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.Xx000oIo
    public long nextLong() {
        try {
            long[] jArr = this.f29376XO;
            int i = this.f29375Oo;
            this.f29375Oo = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f29375Oo--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
