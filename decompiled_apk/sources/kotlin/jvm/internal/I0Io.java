package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* loaded from: classes6.dex */
public final class I0Io extends kotlin.collections.IXxxXO {

    /* renamed from: Oo, reason: collision with root package name */
    public int f29274Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final char[] f29275XO;

    public I0Io(@OXOo.OOXIXo char[] array) {
        IIX0o.x0xO0oo(array, "array");
        this.f29275XO = array;
    }

    @Override // kotlin.collections.IXxxXO
    public char II0xO0() {
        try {
            char[] cArr = this.f29275XO;
            int i = this.f29274Oo;
            this.f29274Oo = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f29274Oo--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f29274Oo < this.f29275XO.length) {
            return true;
        }
        return false;
    }
}
