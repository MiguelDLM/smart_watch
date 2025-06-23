package X0;

import java.util.NoSuchElementException;
import kotlin.collections.oOXoIIIo;

/* loaded from: classes6.dex */
public final class OOXIXo extends oOXoIIIo {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f3183IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final int f3184Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f3185Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final int f3186XO;

    public OOXIXo(int i, int i2, int i3) {
        this.f3186XO = i3;
        this.f3184Oo = i2;
        boolean z = false;
        if (i3 <= 0 ? i >= i2 : i <= i2) {
            z = true;
        }
        this.f3183IXxxXO = z;
        this.f3185Oxx0xo = z ? i : i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3183IXxxXO;
    }

    @Override // kotlin.collections.oOXoIIIo
    public int nextInt() {
        int i = this.f3185Oxx0xo;
        if (i == this.f3184Oo) {
            if (this.f3183IXxxXO) {
                this.f3183IXxxXO = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f3185Oxx0xo = this.f3186XO + i;
        }
        return i;
    }

    public final int oIX0oI() {
        return this.f3186XO;
    }
}
