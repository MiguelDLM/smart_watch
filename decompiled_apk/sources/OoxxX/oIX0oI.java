package OoxxX;

import java.util.ArrayList;

/* loaded from: classes6.dex */
public class oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final ArrayList<II0xO0> f2746oIX0oI = new ArrayList<>();

    public synchronized void I0Io(II0xO0 iI0xO0) {
        this.f2746oIX0oI.remove(iI0xO0);
    }

    public synchronized int II0xO0() {
        return this.f2746oIX0oI.size();
    }

    public void X0o0xo() {
        XO(null);
    }

    public void XO(Object obj) {
        II0xO0[] iI0xO0Arr;
        synchronized (this) {
            ArrayList<II0xO0> arrayList = this.f2746oIX0oI;
            iI0xO0Arr = (II0xO0[]) arrayList.toArray(new II0xO0[arrayList.size()]);
        }
        for (int length = iI0xO0Arr.length - 1; length >= 0; length--) {
            iI0xO0Arr[length].updateSkin(this, obj);
        }
    }

    public synchronized void oIX0oI(II0xO0 iI0xO0) {
        if (iI0xO0 != null) {
            if (!this.f2746oIX0oI.contains(iI0xO0)) {
                this.f2746oIX0oI.add(iI0xO0);
            }
        } else {
            throw new NullPointerException();
        }
    }

    public synchronized void oxoX() {
        this.f2746oIX0oI.clear();
    }
}
