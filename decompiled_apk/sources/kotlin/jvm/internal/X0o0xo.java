package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* loaded from: classes6.dex */
public final class X0o0xo extends kotlin.collections.xxX {

    /* renamed from: Oo, reason: collision with root package name */
    public int f29317Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final float[] f29318XO;

    public X0o0xo(@OXOo.OOXIXo float[] array) {
        IIX0o.x0xO0oo(array, "array");
        this.f29318XO = array;
    }

    @Override // kotlin.collections.xxX
    public float II0xO0() {
        try {
            float[] fArr = this.f29318XO;
            int i = this.f29317Oo;
            this.f29317Oo = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f29317Oo--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f29317Oo < this.f29318XO.length) {
            return true;
        }
        return false;
    }
}
