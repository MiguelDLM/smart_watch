package O0Xx;

import com.garmin.fit.IXIxx0;
import com.garmin.fit.oIXoXx0;
import com.garmin.fit.xI;
import com.garmin.fit.xx0o0O;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/* loaded from: classes9.dex */
public class X0o0xo implements xI, xx0o0O {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final ArrayList<IXIxx0> f1432oIX0oI = new ArrayList<>();

    /* renamed from: II0xO0, reason: collision with root package name */
    public final ArrayList<oIXoXx0> f1431II0xO0 = new ArrayList<>();

    /* renamed from: I0Io, reason: collision with root package name */
    public int f1430I0Io = 0;

    @Override // com.garmin.fit.xI
    public void I0Io() {
        Oxx0IOOO(this.f1431II0xO0);
    }

    public int II0XooXoX() {
        return this.f1430I0Io;
    }

    @Override // com.garmin.fit.IXIxx0
    public void II0xO0(oIXoXx0 oixoxx0) {
        this.f1431II0xO0.add(oixoxx0);
        if (oixoxx0.Ix00oIoI() > this.f1430I0Io) {
            this.f1430I0Io = oixoxx0.Ix00oIoI();
        }
    }

    public final void Oxx0IOOO(List<? extends oIXoXx0> list) {
        list.forEach(new Consumer() { // from class: O0Xx.oxoX
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                X0o0xo.this.xoIox((oIXoXx0) obj);
            }
        });
    }

    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public final void xoIox(final oIXoXx0 oixoxx0) {
        this.f1432oIX0oI.forEach(new Consumer() { // from class: O0Xx.I0Io
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((IXIxx0) obj).II0xO0(oIXoXx0.this);
            }
        });
    }

    @Override // com.garmin.fit.xx0o0O
    public void oIX0oI(IXIxx0 iXIxx0) {
        if (iXIxx0 != null && !this.f1432oIX0oI.contains(iXIxx0)) {
            this.f1432oIX0oI.add(iXIxx0);
        }
    }
}
