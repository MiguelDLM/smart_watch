package jxl.biff.formula;

import java.util.Stack;

/* loaded from: classes6.dex */
public abstract class xII extends OI0 {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public OI0[] f27988Oxx0IOOO = new OI0[0];

    public void IIXOooo() {
        int i = 0;
        while (true) {
            OI0[] oi0Arr = this.f27988Oxx0IOOO;
            if (i < oi0Arr.length) {
                oi0Arr[i].oOoXoXO();
                i++;
            } else {
                return;
            }
        }
    }

    public void IXxxXO(OI0 oi0) {
        oi0.x0XOIxOo(this);
        OI0[] oi0Arr = this.f27988Oxx0IOOO;
        OI0[] oi0Arr2 = new OI0[oi0Arr.length + 1];
        System.arraycopy(oi0Arr, 0, oi0Arr2, 0, oi0Arr.length);
        oi0Arr2[this.f27988Oxx0IOOO.length] = oi0;
        this.f27988Oxx0IOOO = oi0Arr2;
    }

    public abstract void Oxx0xo(Stack stack);

    public abstract int OxxIIOOXO();

    public OI0[] oI0IIXIo() {
        return this.f27988Oxx0IOOO;
    }
}
