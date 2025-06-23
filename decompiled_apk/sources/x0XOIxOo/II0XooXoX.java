package x0XOIxOo;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class II0XooXoX extends xoXoI.oIX0oI<PointF> {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @Nullable
    public Path f33961Oxx0xo;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public final xoXoI.oIX0oI<PointF> f33962oI0IIXIo;

    public II0XooXoX(com.airbnb.lottie.Oxx0IOOO oxx0IOOO, xoXoI.oIX0oI<PointF> oix0oi) {
        super(oxx0IOOO, oix0oi.f35166II0xO0, oix0oi.f35164I0Io, oix0oi.f35175oxoX, oix0oi.f35169X0o0xo, oix0oi.f35170XO, oix0oi.f35168Oxx0IOOO, oix0oi.f35165II0XooXoX);
        this.f33962oI0IIXIo = oix0oi;
        xxIXOIIO();
    }

    @Nullable
    public Path xoIox() {
        return this.f33961Oxx0xo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void xxIXOIIO() {
        boolean z;
        T t;
        T t2;
        T t3 = this.f35164I0Io;
        if (t3 != 0 && (t2 = this.f35166II0xO0) != 0 && ((PointF) t2).equals(((PointF) t3).x, ((PointF) t3).y)) {
            z = true;
        } else {
            z = false;
        }
        T t4 = this.f35166II0xO0;
        if (t4 != 0 && (t = this.f35164I0Io) != 0 && !z) {
            xoXoI.oIX0oI<PointF> oix0oi = this.f33962oI0IIXIo;
            this.f33961Oxx0xo = IIXOooo.xoIox.oxoX((PointF) t4, (PointF) t, oix0oi.f35172oO, oix0oi.f35177x0xO0oo);
        }
    }
}
