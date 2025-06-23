package I0oOIX;

import com.garmin.fit.File;
import com.garmin.fit.IXIxx0;
import com.garmin.fit.OX00o0X;
import com.garmin.fit.Sport;
import com.garmin.fit.SubSport;
import com.garmin.fit.XIXIX;
import com.garmin.fit.o0xxxXXxX;
import com.garmin.fit.oI00o;
import com.garmin.fit.oIXoXx0;
import com.garmin.fit.oX0ooo0I0;
import com.garmin.fit.oXoXxOo;
import com.garmin.fit.x00IOx;
import com.garmin.fit.xI;
import com.garmin.fit.xOIx00;
import com.garmin.fit.xOOxIO;
import com.garmin.fit.xx0o0O;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* loaded from: classes9.dex */
public class oO implements xI, xx0o0O {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final x00IOx f84oIX0oI = new x00IOx();

    /* renamed from: II0xO0, reason: collision with root package name */
    public final ArrayList<IXIxx0> f80II0xO0 = new ArrayList<>();

    /* renamed from: I0Io, reason: collision with root package name */
    public final ArrayList<oIXoXx0> f78I0Io = new ArrayList<>();

    /* renamed from: oxoX, reason: collision with root package name */
    public long f85oxoX = 123456789;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public oI00o f82X0o0xo = null;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f83XO = true;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f81Oxx0IOOO = true;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public xOOxIO f79II0XooXoX = null;

    public static /* synthetic */ boolean O0xOxO(XIXIX xixix) {
        if (xixix.xOOxIO().shortValue() == 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean OxI(XIXIX xixix) {
        if (xixix.xOOxIO() != null) {
            return true;
        }
        return false;
    }

    private void OxxIIOOXO(List<? extends oIXoXx0> list) {
        list.forEach(new Consumer() { // from class: I0oOIX.xoIox
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                oO.this.xXxxox0I((oIXoXx0) obj);
            }
        });
    }

    public static /* synthetic */ boolean X0IIOO(xOIx00 xoix00) {
        if (xoix00.Oxx() != null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean XI0IXoo(xOIx00 xoix00) {
        if (xoix00.OX() != null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean XIxXXX0x0(oXoXxOo oxoxxoo) {
        if (oxoxxoo.o0xOIoxo() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: oI0IIXIo, reason: merged with bridge method [inline-methods] */
    public void xXxxox0I(final oIXoXx0 oixoxx0) {
        this.f80II0xO0.forEach(new Consumer() { // from class: I0oOIX.xxIXOIIO
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((IXIxx0) obj).II0xO0(oIXoXx0.this);
            }
        });
    }

    public static /* synthetic */ boolean xxX(oXoXxOo oxoxxoo) {
        if (oxoxxoo.IOXOxOII() != null) {
            return true;
        }
        return false;
    }

    @Override // com.garmin.fit.xI
    public void I0Io() {
        if (this.f78I0Io.size() == 0) {
            return;
        }
        oX0ooo0I0 oxoX2 = this.f84oIX0oI.oxoX();
        oI00o oi00o = (oI00o) this.f78I0Io.get(0);
        oI00o oi00o2 = (oI00o) this.f78I0Io.get(r2.size() - 1);
        o0xxxXXxX timestamp = oi00o.getTimestamp();
        xOOxIO x0xO0oo2 = x0xO0oo(timestamp);
        XIXIX oO2 = oO(oxoX2.o00(), timestamp);
        oXoXxOo Oo2 = Oo(oi00o, oi00o2);
        OX00o0X IXxxXO2 = IXxxXO(oi00o, oi00o2, oxoX2);
        com.garmin.fit.X0o0xo x0XOIxOo2 = x0XOIxOo(oi00o, oi00o2);
        xXxxox0I(x0xO0oo2);
        xXxxox0I(oO2);
        OxxIIOOXO(oxoX2.OxxIIOOXO());
        OxxIIOOXO(oxoX2.oo());
        OxxIIOOXO(this.f78I0Io);
        xXxxox0I(Oo2);
        xXxxox0I(IXxxXO2);
        xXxxox0I(x0XOIxOo2);
    }

    @Override // com.garmin.fit.IXIxx0
    public void II0xO0(oIXoXx0 oixoxx0) {
        oixoxx0.xxOXOOoIX();
        this.f84oIX0oI.II0xO0(oixoxx0);
        if (oixoxx0.XXoOx0() == 20) {
            Oxx0xo();
        }
        ooOOo0oXI(oixoxx0);
    }

    public final boolean IIXOooo(oIXoXx0 oixoxx0) {
        Long IoOoo2 = oixoxx0.IoOoo(253);
        if (IoOoo2 != null && IoOoo2.longValue() >= 268435456) {
            return true;
        }
        return false;
    }

    public OX00o0X IXxxXO(oI00o oi00o, oI00o oi00o2, oX0ooo0I0 ox0ooo0i0) {
        Stream stream;
        Stream filter;
        Stream filter2;
        Optional findFirst;
        Object orElse;
        Stream stream2;
        Stream filter3;
        Stream filter4;
        Optional findFirst2;
        Object orElse2;
        OX00o0X oX00o0X = new OX00o0X();
        oX00o0X.OIOxOX(0);
        oX00o0X.x0I0(oi00o.getTimestamp());
        oX00o0X.oIX0oI(oi00o2.getTimestamp());
        oX00o0X.I0o(Float.valueOf((float) (oi00o2.getTimestamp().x0xO0oo().longValue() - oi00o.getTimestamp().x0xO0oo().longValue())));
        oX00o0X.IOoXX(Float.valueOf((float) (oi00o2.getTimestamp().x0xO0oo().longValue() - oi00o.getTimestamp().x0xO0oo().longValue())));
        oX00o0X.X0OXI(0);
        oX00o0X.OXI(1);
        stream = ox0ooo0i0.OoO().stream();
        filter = stream.filter(new Predicate() { // from class: I0oOIX.oOoXoXO
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean X0IIOO2;
                X0IIOO2 = oO.X0IIOO((xOIx00) obj);
                return X0IIOO2;
            }
        });
        filter2 = filter.filter(new Predicate() { // from class: I0oOIX.ooOOo0oXI
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean XI0IXoo2;
                XI0IXoo2 = oO.XI0IXoo((xOIx00) obj);
                return XI0IXoo2;
            }
        });
        findFirst = filter2.findFirst();
        orElse = findFirst.orElse(null);
        xOIx00 xoix00 = (xOIx00) orElse;
        if (xoix00 == null) {
            stream2 = ox0ooo0i0.I0oOIX().stream();
            filter3 = stream2.filter(new Predicate() { // from class: I0oOIX.x0XOIxOo
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean XIxXXX0x02;
                    XIxXXX0x02 = oO.XIxXXX0x0((oXoXxOo) obj);
                    return XIxXXX0x02;
                }
            });
            filter4 = filter3.filter(new Predicate() { // from class: I0oOIX.OOXIXo
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean xxX2;
                    xxX2 = oO.xxX((oXoXxOo) obj);
                    return xxX2;
                }
            });
            findFirst2 = filter4.findFirst();
            orElse2 = findFirst2.orElse(null);
            oXoXxOo oxoxxoo = (oXoXxOo) orElse2;
            if (oxoxxoo != null) {
                oX00o0X.OI(oxoxxoo.o0xOIoxo());
                oX00o0X.XoOOxOo0o(oxoxxoo.IOXOxOII());
                return oX00o0X;
            }
            oX00o0X.OI(Sport.GENERIC);
            oX00o0X.XoOOxOo0o(SubSport.GENERIC);
            return oX00o0X;
        }
        oX00o0X.OI(xoix00.Oxx());
        oX00o0X.XoOOxOo0o(xoix00.OX());
        return oX00o0X;
    }

    public final oXoXxOo Oo(oI00o oi00o, oI00o oi00o2) {
        oXoXxOo oxoxxoo = new oXoXxOo();
        oxoxxoo.oxOII(0);
        oxoxxoo.oIoIxo(oi00o.getTimestamp());
        oxoxxoo.oIX0oI(oi00o2.getTimestamp());
        oxoxxoo.OxI0(Float.valueOf((float) (oi00o2.getTimestamp().x0xO0oo().longValue() - oi00o.getTimestamp().x0xO0oo().longValue())));
        oxoxxoo.I0IIXxxo(Float.valueOf((float) (oi00o2.getTimestamp().x0xO0oo().longValue() - oi00o.getTimestamp().x0xO0oo().longValue())));
        if (oi00o2.o0oxo0oI() != null) {
            oxoxxoo.xxX0X(oi00o2.o0oxo0oI());
        }
        return oxoxxoo;
    }

    public final void Oxx0xo() {
        if (!this.f83XO) {
            return;
        }
        oI00o oi00o = this.f84oIX0oI.oxoX().I0().get(r0.size() - 1);
        if (!IIXOooo(oi00o)) {
            return;
        }
        if (this.f78I0Io.size() == 0) {
            this.f78I0Io.add(oi00o);
            this.f82X0o0xo = oi00o;
        } else {
            if (!o00(this.f82X0o0xo, oi00o)) {
                return;
            }
            if (!xoXoI(this.f82X0o0xo, oi00o)) {
                this.f83XO = false;
            } else {
                this.f78I0Io.add(oi00o);
                this.f82X0o0xo = oi00o;
            }
        }
    }

    public final boolean o00(oI00o oi00o, oI00o oi00o2) {
        if (oi00o.getTimestamp().x0xO0oo().longValue() <= oi00o2.getTimestamp().x0xO0oo().longValue()) {
            return true;
        }
        return false;
    }

    @Override // com.garmin.fit.xx0o0O
    public void oIX0oI(IXIxx0 iXIxx0) {
        if (iXIxx0 != null && !this.f80II0xO0.contains(iXIxx0)) {
            this.f80II0xO0.add(iXIxx0);
        }
    }

    public final XIXIX oO(List<XIXIX> list, o0xxxXXxX o0xxxxxxx) {
        Stream stream;
        Stream filter;
        Stream filter2;
        Optional findFirst;
        Object orElse;
        stream = list.stream();
        filter = stream.filter(new Predicate() { // from class: I0oOIX.Oxx0IOOO
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean OxI2;
                OxI2 = oO.OxI((XIXIX) obj);
                return OxI2;
            }
        });
        filter2 = filter.filter(new Predicate() { // from class: I0oOIX.II0XooXoX
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean O0xOxO2;
                O0xOxO2 = oO.O0xOxO((XIXIX) obj);
                return O0xOxO2;
            }
        });
        findFirst = filter2.findFirst();
        orElse = findFirst.orElse(null);
        XIXIX xixix = (XIXIX) orElse;
        if (xixix == null) {
            xixix = new XIXIX();
            xixix.oXxx000((short) 0);
            xixix.XoOxI0ox(255);
            xixix.X0ooXIooI(0);
            xixix.oX000x("File Activity Repair");
            xixix.IxIo(Long.valueOf(this.f85oxoX));
            xixix.x0oxIIIX(Float.valueOf(1.0f));
            xixix.oIX0oI(new o0xxxXXxX(o0xxxxxxx));
        }
        if (xixix.getTimestamp() == null) {
            xixix.oIX0oI(new o0xxxXXxX(o0xxxxxxx));
        }
        return xixix;
    }

    public boolean oOoXoXO() {
        if (this.f78I0Io.size() != 0) {
            return true;
        }
        return false;
    }

    public final void ooOOo0oXI(oIXoXx0 oixoxx0) {
        if (!this.f81Oxx0IOOO || oixoxx0.XXoOx0() == 105) {
            return;
        }
        if (oixoxx0.XXoOx0() == 0) {
            this.f79II0XooXoX = new xOOxIO(oixoxx0);
        }
        this.f81Oxx0IOOO = false;
    }

    public final com.garmin.fit.X0o0xo x0XOIxOo(oI00o oi00o, oI00o oi00o2) {
        ZonedDateTime now;
        ZoneOffset offset;
        int totalSeconds;
        com.garmin.fit.X0o0xo x0o0xo = new com.garmin.fit.X0o0xo();
        x0o0xo.oIX0oI(oi00o2.getTimestamp());
        x0o0xo.OO0(1);
        now = ZonedDateTime.now();
        offset = now.getOffset();
        totalSeconds = offset.getTotalSeconds();
        x0o0xo.XoIxOXIXo(Long.valueOf(oi00o2.getTimestamp().x0xO0oo().longValue() + totalSeconds));
        x0o0xo.OooI(Float.valueOf((float) (oi00o2.getTimestamp().x0xO0oo().longValue() - oi00o.getTimestamp().x0xO0oo().longValue())));
        return x0o0xo;
    }

    public final xOOxIO x0xO0oo(o0xxxXXxX o0xxxxxxx) {
        xOOxIO xooxio = this.f79II0XooXoX;
        if (xooxio == null) {
            xooxio = new xOOxIO();
            xooxio.x00IOx(File.ACTIVITY);
            xooxio.oxOXxoXII(0);
            xooxio.XO0o(Long.valueOf(this.f85oxoX));
        }
        if (xooxio.oXIoO() == null) {
            xooxio.xOOxIO(255);
        }
        if (xooxio.OIx00oxx() == null) {
            xooxio.oX0I0O(new o0xxxXXxX(o0xxxxxxx));
        }
        return xooxio;
    }

    public final boolean xoXoI(oI00o oi00o, oI00o oi00o2) {
        if (oi00o2.getTimestamp().x0xO0oo().longValue() < oi00o.getTimestamp().x0xO0oo().longValue() + 172800) {
            return true;
        }
        return false;
    }
}
