package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* loaded from: classes6.dex */
public final class oxoX extends kotlin.collections.XI0IXoo {

    /* renamed from: Oo, reason: collision with root package name */
    public int f29354Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final double[] f29355XO;

    public oxoX(@OXOo.OOXIXo double[] array) {
        IIX0o.x0xO0oo(array, "array");
        this.f29355XO = array;
    }

    @Override // kotlin.collections.XI0IXoo
    public double II0xO0() {
        try {
            double[] dArr = this.f29355XO;
            int i = this.f29354Oo;
            this.f29354Oo = i + 1;
            return dArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f29354Oo--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f29354Oo < this.f29355XO.length) {
            return true;
        }
        return false;
    }
}
