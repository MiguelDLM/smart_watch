package o0xxxXXxX;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public class oI0IIXIo extends I0Io<IIxOXoOo0.OOXIXo> {
    public oI0IIXIo() {
    }

    public float xII() {
        Iterator it = this.f31251xxIXOIIO.iterator();
        float f = 0.0f;
        while (it.hasNext()) {
            float oO2 = ((IIxOXoOo0.OOXIXo) it.next()).oO();
            if (oO2 > f) {
                f = oO2;
            }
        }
        return f;
    }

    public oI0IIXIo(List<IIxOXoOo0.OOXIXo> list) {
        super(list);
    }

    public oI0IIXIo(IIxOXoOo0.OOXIXo... oOXIXoArr) {
        super(oOXIXoArr);
    }
}
