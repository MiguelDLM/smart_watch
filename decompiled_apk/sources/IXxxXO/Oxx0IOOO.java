package IXxxXO;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Oxx0IOOO {

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f768I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public PointF f769II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final List<x0xO0oo.oIX0oI> f770oIX0oI;

    public Oxx0IOOO(PointF pointF, boolean z, List<x0xO0oo.oIX0oI> list) {
        this.f769II0xO0 = pointF;
        this.f768I0Io = z;
        this.f770oIX0oI = new ArrayList(list);
    }

    public void I0Io(Oxx0IOOO oxx0IOOO, Oxx0IOOO oxx0IOOO2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        boolean z;
        if (this.f769II0xO0 == null) {
            this.f769II0xO0 = new PointF();
        }
        if (!oxx0IOOO.oxoX() && !oxx0IOOO2.oxoX()) {
            z = false;
        } else {
            z = true;
        }
        this.f768I0Io = z;
        if (oxx0IOOO.oIX0oI().size() != oxx0IOOO2.oIX0oI().size()) {
            IIXOooo.XO.X0o0xo("Curves must have the same number of control points. Shape 1: " + oxx0IOOO.oIX0oI().size() + "\tShape 2: " + oxx0IOOO2.oIX0oI().size());
        }
        int min = Math.min(oxx0IOOO.oIX0oI().size(), oxx0IOOO2.oIX0oI().size());
        if (this.f770oIX0oI.size() < min) {
            for (int size = this.f770oIX0oI.size(); size < min; size++) {
                this.f770oIX0oI.add(new x0xO0oo.oIX0oI());
            }
        } else if (this.f770oIX0oI.size() > min) {
            for (int size2 = this.f770oIX0oI.size() - 1; size2 >= min; size2--) {
                List<x0xO0oo.oIX0oI> list = this.f770oIX0oI;
                list.remove(list.size() - 1);
            }
        }
        PointF II0xO02 = oxx0IOOO.II0xO0();
        PointF II0xO03 = oxx0IOOO2.II0xO0();
        X0o0xo(IIXOooo.xxIXOIIO.OOXIXo(II0xO02.x, II0xO03.x, f), IIXOooo.xxIXOIIO.OOXIXo(II0xO02.y, II0xO03.y, f));
        for (int size3 = this.f770oIX0oI.size() - 1; size3 >= 0; size3--) {
            x0xO0oo.oIX0oI oix0oi = oxx0IOOO.oIX0oI().get(size3);
            x0xO0oo.oIX0oI oix0oi2 = oxx0IOOO2.oIX0oI().get(size3);
            PointF oIX0oI2 = oix0oi.oIX0oI();
            PointF II0xO04 = oix0oi.II0xO0();
            PointF I0Io2 = oix0oi.I0Io();
            PointF oIX0oI3 = oix0oi2.oIX0oI();
            PointF II0xO05 = oix0oi2.II0xO0();
            PointF I0Io3 = oix0oi2.I0Io();
            this.f770oIX0oI.get(size3).oxoX(IIXOooo.xxIXOIIO.OOXIXo(oIX0oI2.x, oIX0oI3.x, f), IIXOooo.xxIXOIIO.OOXIXo(oIX0oI2.y, oIX0oI3.y, f));
            this.f770oIX0oI.get(size3).X0o0xo(IIXOooo.xxIXOIIO.OOXIXo(II0xO04.x, II0xO05.x, f), IIXOooo.xxIXOIIO.OOXIXo(II0xO04.y, II0xO05.y, f));
            this.f770oIX0oI.get(size3).XO(IIXOooo.xxIXOIIO.OOXIXo(I0Io2.x, I0Io3.x, f), IIXOooo.xxIXOIIO.OOXIXo(I0Io2.y, I0Io3.y, f));
        }
    }

    public PointF II0xO0() {
        return this.f769II0xO0;
    }

    public final void X0o0xo(float f, float f2) {
        if (this.f769II0xO0 == null) {
            this.f769II0xO0 = new PointF();
        }
        this.f769II0xO0.set(f, f2);
    }

    public List<x0xO0oo.oIX0oI> oIX0oI() {
        return this.f770oIX0oI;
    }

    public boolean oxoX() {
        return this.f768I0Io;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f770oIX0oI.size() + "closed=" + this.f768I0Io + '}';
    }

    public Oxx0IOOO() {
        this.f770oIX0oI = new ArrayList();
    }
}
