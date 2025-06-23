package X0;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class II0xO0 extends kotlin.collections.IXxxXO {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f3173IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final int f3174Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f3175Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final int f3176XO;

    public II0xO0(char c, char c2, int i) {
        this.f3176XO = i;
        this.f3174Oo = c2;
        boolean z = false;
        if (i <= 0 ? IIX0o.oI0IIXIo(c, c2) >= 0 : IIX0o.oI0IIXIo(c, c2) <= 0) {
            z = true;
        }
        this.f3173IXxxXO = z;
        this.f3175Oxx0xo = z ? c : c2;
    }

    @Override // kotlin.collections.IXxxXO
    public char II0xO0() {
        int i = this.f3175Oxx0xo;
        if (i == this.f3174Oo) {
            if (this.f3173IXxxXO) {
                this.f3173IXxxXO = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f3175Oxx0xo = this.f3176XO + i;
        }
        return (char) i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3173IXxxXO;
    }

    public final int oxoX() {
        return this.f3176XO;
    }
}
