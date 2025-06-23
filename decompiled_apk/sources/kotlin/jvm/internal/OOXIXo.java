package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.O0Xx;

/* loaded from: classes6.dex */
public final class OOXIXo extends O0Xx {

    /* renamed from: Oo, reason: collision with root package name */
    public int f29297Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final short[] f29298XO;

    public OOXIXo(@OXOo.OOXIXo short[] array) {
        IIX0o.x0xO0oo(array, "array");
        this.f29298XO = array;
    }

    @Override // kotlin.collections.O0Xx
    public short II0xO0() {
        try {
            short[] sArr = this.f29298XO;
            int i = this.f29297Oo;
            this.f29297Oo = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f29297Oo--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f29297Oo < this.f29298XO.length) {
            return true;
        }
        return false;
    }
}
