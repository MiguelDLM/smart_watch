package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* loaded from: classes6.dex */
public final class oIX0oI extends kotlin.collections.oO {

    /* renamed from: Oo, reason: collision with root package name */
    public int f29337Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final boolean[] f29338XO;

    public oIX0oI(@OXOo.OOXIXo boolean[] array) {
        IIX0o.x0xO0oo(array, "array");
        this.f29338XO = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f29337Oo < this.f29338XO.length) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.oO
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.f29338XO;
            int i = this.f29337Oo;
            this.f29337Oo = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f29337Oo--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
