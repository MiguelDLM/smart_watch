package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* loaded from: classes6.dex */
public final class XO extends kotlin.collections.oOXoIIIo {

    /* renamed from: Oo, reason: collision with root package name */
    public int f29319Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final int[] f29320XO;

    public XO(@OXOo.OOXIXo int[] array) {
        IIX0o.x0xO0oo(array, "array");
        this.f29320XO = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f29319Oo < this.f29320XO.length) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.oOXoIIIo
    public int nextInt() {
        try {
            int[] iArr = this.f29320XO;
            int i = this.f29319Oo;
            this.f29319Oo = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f29319Oo--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
