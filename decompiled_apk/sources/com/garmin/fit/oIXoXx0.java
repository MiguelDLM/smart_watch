package com.garmin.fit;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes9.dex */
public class oIXoXx0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f14423I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f14424II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f14425Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public ArrayList<IIxOXoOo0> f14426X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public long f14427XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f14428oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public ArrayList<X0xII0I> f14429oxoX;

    public oIXoXx0(oIXoXx0 oixoxx0) {
        this.f14429oxoX = new ArrayList<>();
        this.f14426X0o0xo = new ArrayList<>();
        if (oixoxx0 == null) {
            this.f14428oIX0oI = "unknown";
            this.f14424II0xO0 = IXXIXx00I.f11732XXXI;
            this.f14427XO = 0L;
            return;
        }
        this.f14428oIX0oI = oixoxx0.f14428oIX0oI;
        this.f14424II0xO0 = oixoxx0.f14424II0xO0;
        this.f14423I0Io = oixoxx0.f14423I0Io;
        this.f14427XO = oixoxx0.f14427XO;
        this.f14425Oxx0IOOO = oixoxx0.f14425Oxx0IOOO;
        Iterator<X0xII0I> it = oixoxx0.f14429oxoX.iterator();
        while (it.hasNext()) {
            X0xII0I next = it.next();
            if (next.x0xO() > 0) {
                this.f14429oxoX.add(new X0xII0I(next));
            }
        }
        Iterator<IIxOXoOo0> it2 = oixoxx0.f14426X0o0xo.iterator();
        while (it2.hasNext()) {
            IIxOXoOo0 next2 = it2.next();
            if (next2.x0xO() > 0) {
                this.f14426X0o0xo.add(new IIxOXoOo0(next2));
            }
        }
    }

    public Short I0(String str, int i) {
        X0xII0I Oo2 = Oo(str, false);
        if (Oo2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = Oo2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return Oo2.IIxOXoOo0(i, str);
    }

    public Integer I0X0x0oIo(int i, int i2) {
        return oX(i, i2, 65534);
    }

    public Integer[] I0oOIX(int i) {
        return xoxXI(i, 65534);
    }

    public Float I0oOoX(int i, int i2, String str) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = oO2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return oO2.Xx000oIo(i2, str);
    }

    public void I0xX0(OutputStream outputStream, xooxxX xooxxx) {
        try {
            new DataOutputStream(outputStream).writeByte(this.f14423I0Io & 15);
            if (xooxxx == null) {
                xooxxx = new xooxxX(this);
            }
            Iterator<XXXI> it = xooxxx.f15599oxoX.iterator();
            while (it.hasNext()) {
                XXXI next = it.next();
                X0xII0I oO2 = oO(next.f13982oIX0oI);
                if (oO2 == null) {
                    oO2 = x0OxxIOxX.oIX0oI(this.f14424II0xO0, next.f13982oIX0oI);
                }
                oO2.oXIoO(outputStream, next);
            }
            Iterator<I0> it2 = xooxxx.f15597X0o0xo.iterator();
            while (it2.hasNext()) {
                I0 next2 = it2.next();
                IIxOXoOo0 ooOOo0oXI2 = ooOOo0oXI(next2.XO(), next2.xxIXOIIO());
                if (ooOOo0oXI2 == null) {
                    ooOOo0oXI2 = next2.X0o0xo();
                }
                ooOOo0oXI2.oXIoO(outputStream, next2);
            }
        } catch (IOException e) {
            throw new FitRuntimeException(e);
        }
    }

    public void II0XooXoX(IIxOXoOo0 iIxOXoOo0) {
        for (int i = 0; i < this.f14426X0o0xo.size(); i++) {
            IIxOXoOo0 iIxOXoOo02 = this.f14426X0o0xo.get(i);
            if (iIxOXoOo02.O00() == iIxOXoOo0.O00() && iIxOXoOo02.OIx00oxx() == iIxOXoOo0.OIx00oxx()) {
                this.f14426X0o0xo.set(i, iIxOXoOo0);
                return;
            }
        }
        this.f14426X0o0xo.add(iIxOXoOo0);
    }

    public String[] IIX0(int i) {
        return xOoOIoI(i, 65534);
    }

    public Byte IIX0o(String str) {
        return ooXIXxIX(str, 0);
    }

    public BigInteger IIXOooo(String str) {
        return xoXoI(str, 0);
    }

    public Short IIxOXoOo0(String str) {
        return I0(str, 0);
    }

    public Double IO(String str) {
        return xII(str, 0);
    }

    public void IO0XoXxO(int i, int i2, Object obj, String str) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            oO2 = x0OxxIOxX.oIX0oI(this.f14424II0xO0, i);
            xxIXOIIO(oO2);
        }
        oO2.oIIxXoo(i2, obj, str);
    }

    public void IOoo(oIXoXx0 oixoxx0) {
        if (oixoxx0.f14424II0xO0 != this.f14424II0xO0) {
            return;
        }
        Iterator<X0xII0I> it = oixoxx0.f14429oxoX.iterator();
        while (it.hasNext()) {
            x0(it.next());
        }
    }

    public int IXO(int i, String str) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return 0;
        }
        xxOoXO IoIOOxIIo2 = oO2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return 0;
        }
        return oO2.x0xO();
    }

    public BigInteger IXxxXO(int i) {
        return oI0IIXIo(i, 0, 65534);
    }

    public Float Io(int i) {
        return XX(i, 0, 65534);
    }

    public Object IoIOOxIIo(int i, int i2, String str) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = oO2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return oO2.Ix00oIoI(i2, str);
    }

    public Double IoOoX(int i) {
        return Xx000oIo(i, 0, 65534);
    }

    public Long IoOoo(int i) {
        return x0xO(i, 0, 65534);
    }

    public boolean IoXIXo(int i) {
        for (int i2 = 0; i2 < this.f14429oxoX.size(); i2++) {
            if (this.f14429oxoX.get(i2).f13536oxoX == i) {
                return true;
            }
        }
        return false;
    }

    public Long Ioxxx(String str, int i) {
        X0xII0I Oo2 = Oo(str, false);
        if (Oo2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = Oo2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return Oo2.oX(i, str);
    }

    public int Ix00oIoI() {
        return this.f14429oxoX.size();
    }

    public int IxIX0I(int i) {
        return oOoIIO0(i, 65534);
    }

    public Object O0(int i) {
        return xI0oxI00(i, 0, 65534);
    }

    public Short O00XxXI(int i) {
        return XI0oooXX(i, 0, 65534);
    }

    public Iterable<XOxxooXI> O0IxXx(short s) {
        LinkedList linkedList = new LinkedList();
        X0xII0I oO2 = oO(s);
        if (oO2 != null) {
            linkedList.add(oO2);
        }
        Iterator<IIxOXoOo0> it = this.f14426X0o0xo.iterator();
        while (it.hasNext()) {
            IIxOXoOo0 next = it.next();
            if (next.xxxI() == s) {
                linkedList.add(next);
            }
        }
        return linkedList;
    }

    public String O0X(String str, int i) {
        X0xII0I Oo2 = Oo(str, false);
        if (Oo2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = Oo2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return Oo2.O0X(i, str);
    }

    public Integer O0Xx(String str, int i) {
        X0xII0I Oo2 = Oo(str, false);
        if (Oo2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = Oo2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return Oo2.XX(i, str);
    }

    public BigInteger[] O0xOxO(int i, String str) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = oO2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return oO2.x0xO0oo(str);
    }

    public Double[] OI0(int i, String str) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = oO2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return oO2.xI(str);
    }

    public int OIOoIIOIx() {
        return this.f14423I0Io;
    }

    public Integer[] OO(int i, String str) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = oO2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return oO2.xo0x(str);
    }

    public Long OO0x0xX(int i, int i2, String str) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = oO2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return oO2.oX(i2, str);
    }

    public String OOXIXo(int i) {
        X0xII0I oIX0oI2 = x0OxxIOxX.oIX0oI(this.f14424II0xO0, i);
        if (oIX0oI2 == null) {
            return Fit.f11215oo;
        }
        for (int i2 = 0; i2 < oIX0oI2.f13530OOXIXo.size(); i2++) {
            if (oIX0oI2.f13530OOXIXo.get(i2).I0Io(this)) {
                return oIX0oI2.f13530OOXIXo.get(i2).oxoX();
            }
        }
        return Fit.f11215oo;
    }

    public Short OOXIxO0(int i, int i2, String str) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = oO2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return oO2.IIxOXoOo0(i2, str);
    }

    public Short[] OX00O0xII(int i, String str) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = oO2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return oO2.xX0IIXIx0(str);
    }

    public X0xII0I Oo(String str, boolean z) {
        for (int i = 0; i < this.f14429oxoX.size(); i++) {
            if (this.f14429oxoX.get(i).f13528I0Io.equals(str)) {
                return this.f14429oxoX.get(i);
            }
            for (int i2 = 0; i2 < this.f14429oxoX.get(i).f13530OOXIXo.size(); i2++) {
                if (this.f14429oxoX.get(i).f13530OOXIXo.get(i2).f15703oIX0oI.equals(str) && (!z || this.f14429oxoX.get(i).f13530OOXIXo.get(i2).I0Io(this))) {
                    return this.f14429oxoX.get(i);
                }
            }
        }
        return null;
    }

    public boolean OoO(int i) {
        X0xII0I oO2 = oO(i);
        if (oO2 != null) {
            return oO2.XoIxOXIXo();
        }
        return false;
    }

    public String[] Ox0O(int i, String str) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = oO2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return oO2.xx0X0(str);
    }

    public BigInteger[] OxI(int i, int i2) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO xI0oxI002 = oO2.xI0oxI00(i2);
        if (xI0oxI002 != null && !xI0oxI002.I0Io(this)) {
            return null;
        }
        return oO2.x0XOIxOo(i2);
    }

    public BigInteger Oxx0xo(int i, int i2) {
        return oI0IIXIo(i, i2, 65534);
    }

    public BigInteger OxxIIOOXO(int i, int i2, String str) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = oO2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return oO2.OOXIXo(i2, str);
    }

    public Double X00IoxXI(int i, int i2, String str) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = oO2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return oO2.xxX(i2, str);
    }

    public Long X0IIOO(int i, int i2, int i3, boolean z) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        return oO2.Oo(i2, i3, z);
    }

    public void X0xII0I(int i, int i2, Object obj) {
        X0xxXX0(i, i2, obj, 65535);
    }

    public void X0xxXX0(int i, int i2, Object obj, int i3) {
        if (i3 == 65534) {
            i3 = xoIox(i);
        }
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            oO2 = x0OxxIOxX.oIX0oI(this.f14424II0xO0, i);
            xxIXOIIO(oO2);
        }
        oO2.IOoo(i2, obj, i3);
    }

    public void XI(String str, Object obj) {
        XOxxooXI(str, 0, obj);
    }

    public Long XI0IXoo(String str, int i, int i2, boolean z) {
        X0xII0I Oo2 = Oo(str, false);
        if (Oo2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = Oo2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return Oo2.Oo(i, i2, z);
    }

    public Short XI0oooXX(int i, int i2, int i3) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        if (i3 == 65534) {
            return oO2.OOXIxO0(i2, xoIox(i));
        }
        xxOoXO xI0oxI002 = oO2.xI0oxI00(i3);
        if (xI0oxI002 != null && !xI0oxI002.I0Io(this)) {
            return null;
        }
        return oO2.OOXIxO0(i2, i3);
    }

    public String XIXIX(int i, int i2, int i3) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        if (i3 == 65534) {
            return oO2.oOo(i2, xoIox(i));
        }
        xxOoXO xI0oxI002 = oO2.xI0oxI00(i3);
        if (xI0oxI002 != null && !xI0oxI002.I0Io(this)) {
            return null;
        }
        return oO2.oOo(i2, i3);
    }

    public Collection<X0xII0I> XIXIxO() {
        return Collections.unmodifiableCollection(this.f14429oxoX);
    }

    public Long XIo0oOXIx(String str) {
        return Ioxxx(str, 0);
    }

    public Byte XIxXXX0x0(int i) {
        return XxX0x0xxx(i, 0, 65534);
    }

    public Double[] XOxIOxOx(int i, int i2) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO xI0oxI002 = oO2.xI0oxI00(i2);
        if (xI0oxI002 != null && !xI0oxI002.I0Io(this)) {
            return null;
        }
        return oO2.IIX0o(i2);
    }

    public void XOxxooXI(String str, int i, Object obj) {
        X0xII0I Oo2 = Oo(str, false);
        if (Oo2 == null) {
            Oo2 = x0OxxIOxX.II0xO0(this.f14424II0xO0, str);
            xxIXOIIO(Oo2);
        }
        Oo2.oIIxXoo(i, obj, str);
    }

    public Float XX(int i, int i2, int i3) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        if (i3 == 65534) {
            return oO2.oOXoIIIo(i2, xoIox(i));
        }
        xxOoXO xI0oxI002 = oO2.xI0oxI00(i3);
        if (xI0oxI002 != null && !xI0oxI002.I0Io(this)) {
            return null;
        }
        return oO2.oOXoIIIo(i2, i3);
    }

    public Integer XX0(int i) {
        return oX(i, 0, 65534);
    }

    public Long[] XX0xXo(int i, int i2) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO xI0oxI002 = oO2.xI0oxI00(i2);
        if (xI0oxI002 != null && !xI0oxI002.I0Io(this)) {
            return null;
        }
        return oO2.O0Xx(i2);
    }

    public void XXXI(OutputStream outputStream) {
        I0xX0(outputStream, null);
    }

    public int XXoOx0() {
        return this.f14424II0xO0;
    }

    public Integer Xo0(int i, int i2, String str) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = oO2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return oO2.XX(i2, str);
    }

    public Integer XoI0Ixx0(String str) {
        return O0Xx(str, 0);
    }

    public Float XoX(String str, int i) {
        X0xII0I Oo2 = Oo(str, false);
        if (Oo2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = Oo2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return Oo2.Xx000oIo(i, str);
    }

    public Double Xx000oIo(int i, int i2, int i3) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        if (i3 == 65534) {
            return oO2.XIxXXX0x0(i2, xoIox(i));
        }
        xxOoXO xI0oxI002 = oO2.xI0oxI00(i3);
        if (xI0oxI002 != null && !xI0oxI002.I0Io(this)) {
            return null;
        }
        return oO2.XIxXXX0x0(i2, i3);
    }

    public Byte XxX0x0xxx(int i, int i2, int i3) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        if (i3 == 65534) {
            return oO2.oI0IIXIo(i2, xoIox(i));
        }
        xxOoXO xI0oxI002 = oO2.xI0oxI00(i3);
        if (xI0oxI002 != null && !xI0oxI002.I0Io(this)) {
            return null;
        }
        return oO2.oI0IIXIo(i2, i3);
    }

    public Float o0(int i, int i2) {
        return XX(i, i2, 65534);
    }

    public BigInteger[] o00(int i) {
        return OxI(i, 65534);
    }

    public Object o0oIxOo(String str, int i) {
        X0xII0I Oo2 = Oo(str, false);
        if (Oo2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = Oo2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return Oo2.Ix00oIoI(i, str);
    }

    public Long[] o0xxxXXxX(int i, String str) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = oO2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return oO2.xoxXI(str);
    }

    public int oI(String str) {
        X0xII0I Oo2 = Oo(str, false);
        if (Oo2 == null) {
            return 0;
        }
        xxOoXO IoIOOxIIo2 = Oo2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return 0;
        }
        return Oo2.x0xO();
    }

    public BigInteger oI0IIXIo(int i, int i2, int i3) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        if (i3 == 65534) {
            return oO2.xoIox(i2, xoIox(i));
        }
        xxOoXO xI0oxI002 = oO2.xI0oxI00(i3);
        if (xI0oxI002 != null && !xI0oxI002.I0Io(this)) {
            return null;
        }
        return oO2.xoIox(i2, i3);
    }

    public void oIIxXoo(int i) {
        if (i < 16) {
            this.f14423I0Io = i;
            return;
        }
        throw new FitRuntimeException("Invalid local message number " + i + ".  Local message number must be < 16" + FileUtils.FILE_EXTENSION_SEPARATOR);
    }

    public X0xII0I oO(int i) {
        for (int i2 = 0; i2 < this.f14429oxoX.size(); i2++) {
            if (this.f14429oxoX.get(i2).f13536oxoX == i) {
                return this.f14429oxoX.get(i2);
            }
        }
        return null;
    }

    public Double oOXoIIIo(int i, int i2) {
        return Xx000oIo(i, i2, 65534);
    }

    public String oOo(String str) {
        return O0X(str, 0);
    }

    public int oOoIIO0(int i, int i2) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return 0;
        }
        if (i2 == 65534) {
            return oO2.x0xO();
        }
        xxOoXO xI0oxI002 = oO2.xI0oxI00(i2);
        if (xI0oxI002 != null && !xI0oxI002.I0Io(this)) {
            return 0;
        }
        return oO2.x0xO();
    }

    public int oOoXoXO() {
        return this.f14425Oxx0IOOO;
    }

    public Integer oX(int i, int i2, int i3) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        if (i3 == 65534) {
            return oO2.o0(i2, xoIox(i));
        }
        xxOoXO xI0oxI002 = oO2.xI0oxI00(i3);
        if (xI0oxI002 != null && !xI0oxI002.I0Io(this)) {
            return null;
        }
        return oO2.o0(i2, i3);
    }

    public String oXIO0o0XI(int i, int i2, String str) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = oO2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return oO2.O0X(i2, str);
    }

    public o0xxxXXxX oXX0IoI(Long l) {
        if (l == null) {
            return null;
        }
        o0xxxXXxX o0xxxxxxx = new o0xxxXXxX(l.longValue());
        o0xxxxxxx.OOXIXo(this.f14427XO);
        return o0xxxxxxx;
    }

    public void oXxOI0oIx(int i, Object obj) {
        X0xxXX0(i, 0, obj, 65535);
    }

    public Byte[] oo(int i, String str) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = oO2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return oO2.O0xOxO(str);
    }

    public Byte[] oo0xXOI0I(int i, int i2) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO xI0oxI002 = oO2.xI0oxI00(i2);
        if (xI0oxI002 != null && !xI0oxI002.I0Io(this)) {
            return null;
        }
        return oO2.o00(i2);
    }

    public final IIxOXoOo0 ooOOo0oXI(short s, int i) {
        Iterator<IIxOXoOo0> it = this.f14426X0o0xo.iterator();
        while (it.hasNext()) {
            IIxOXoOo0 next = it.next();
            if (next.OIx00oxx() == s && next.O00() == i) {
                return next;
            }
        }
        return null;
    }

    public Short[] ooOx(int i) {
        return xoO0xx0(i, 65534);
    }

    public Byte ooXIXxIX(String str, int i) {
        X0xII0I Oo2 = Oo(str, false);
        if (Oo2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = Oo2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return Oo2.OxxIIOOXO(i, str);
    }

    public Short ox(int i, int i2) {
        return XI0oooXX(i, i2, 65534);
    }

    public Object oxIIX0o(String str) {
        return o0oIxOo(str, 0);
    }

    public Float[] oxXx0IX(int i) {
        return xo0x(i, 65534);
    }

    public Float oxxXoxO(String str) {
        return XoX(str, 0);
    }

    public void x0(X0xII0I x0xII0I) {
        for (int i = 0; i < this.f14429oxoX.size(); i++) {
            if (this.f14429oxoX.get(i).f13536oxoX == x0xII0I.f13536oxoX) {
                this.f14429oxoX.set(i, x0xII0I);
                return;
            }
        }
        this.f14429oxoX.add(x0xII0I);
    }

    public String x0OIX00oO() {
        return this.f14428oIX0oI;
    }

    public void x0OxxIOxX(int i) {
        this.f14425Oxx0IOOO = i;
    }

    public Iterable<IIxOXoOo0> x0XOIxOo() {
        return this.f14426X0o0xo;
    }

    public Double[] x0o(int i) {
        return XOxIOxOx(i, 65534);
    }

    public Long x0xO(int i, int i2, int i3) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        if (i3 == 65534) {
            return oO2.I0X0x0oIo(i2, xoIox(i));
        }
        xxOoXO xI0oxI002 = oO2.xI0oxI00(i3);
        if (xI0oxI002 != null && !xI0oxI002.I0Io(this)) {
            return null;
        }
        return oO2.I0X0x0oIo(i2, i3);
    }

    public X0xII0I x0xO0oo(String str) {
        return Oo(str, true);
    }

    public Byte[] xI(int i) {
        return oo0xXOI0I(i, 65534);
    }

    public Object xI0oxI00(int i, int i2, int i3) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        if (i3 == 65534) {
            return oO2.oI(i2, xoIox(i));
        }
        xxOoXO xI0oxI002 = oO2.xI0oxI00(i3);
        if (xI0oxI002 != null && !xI0oxI002.I0Io(this)) {
            return null;
        }
        return oO2.oI(i2, i3);
    }

    public Double xII(String str, int i) {
        X0xII0I Oo2 = Oo(str, false);
        if (Oo2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = Oo2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return Oo2.xxX(i, str);
    }

    public String xOOOX(int i, int i2) {
        return XIXIX(i, i2, 65534);
    }

    public String[] xOoOIoI(int i, int i2) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO xI0oxI002 = oO2.xI0oxI00(i2);
        if (xI0oxI002 != null && !xI0oxI002.I0Io(this)) {
            return null;
        }
        return oO2.Ox0O(i2);
    }

    public String xX0IIXIx0(int i) {
        return XIXIX(i, 0, 65534);
    }

    public Float[] xXOx(int i, String str) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = oO2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return oO2.XOxIOxOx(str);
    }

    public boolean xXoOI00O(X0xII0I x0xII0I) {
        if (this.f14429oxoX.contains(x0xII0I)) {
            this.f14429oxoX.remove(x0xII0I);
            return true;
        }
        return false;
    }

    public Byte xXxxox0I(int i, int i2, String str) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = oO2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return oO2.OxxIIOOXO(i2, str);
    }

    public Float[] xo0x(int i, int i2) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO xI0oxI002 = oO2.xI0oxI00(i2);
        if (xI0oxI002 != null && !xI0oxI002.I0Io(this)) {
            return null;
        }
        return oO2.xII(i2);
    }

    public int xoIox(int i) {
        X0xII0I oIX0oI2 = x0OxxIOxX.oIX0oI(this.f14424II0xO0, i);
        if (oIX0oI2 == null) {
            return 65535;
        }
        for (int i2 = 0; i2 < oIX0oI2.f13530OOXIXo.size(); i2++) {
            if (oIX0oI2.f13530OOXIXo.get(i2).I0Io(this)) {
                return i2;
            }
        }
        return 65535;
    }

    public Long xoIxX(int i, int i2) {
        return x0xO(i, i2, 65534);
    }

    public Short[] xoO0xx0(int i, int i2) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO xI0oxI002 = oO2.xI0oxI00(i2);
        if (xI0oxI002 != null && !xI0oxI002.I0Io(this)) {
            return null;
        }
        return oO2.xoO0xx0(i2);
    }

    public BigInteger xoXoI(String str, int i) {
        X0xII0I Oo2 = Oo(str, false);
        if (Oo2 == null) {
            return null;
        }
        xxOoXO IoIOOxIIo2 = Oo2.IoIOOxIIo(str);
        if (IoIOOxIIo2 != null && !IoIOOxIIo2.I0Io(this)) {
            return null;
        }
        return Oo2.OOXIXo(i, str);
    }

    public Integer[] xoxXI(int i, int i2) {
        X0xII0I oO2 = oO(i);
        if (oO2 == null) {
            return null;
        }
        xxOoXO xI0oxI002 = oO2.xI0oxI00(i2);
        if (xI0oxI002 != null && !xI0oxI002.I0Io(this)) {
            return null;
        }
        return oO2.XoX(i2);
    }

    public Object xx0X0(int i, int i2) {
        return xI0oxI00(i, i2, 65534);
    }

    public Long[] xxIO(int i) {
        return XX0xXo(i, 65534);
    }

    public void xxIXOIIO(X0xII0I x0xII0I) {
        this.f14429oxoX.add(x0xII0I);
    }

    public void xxOXOOoIX() {
        ArrayList arrayList = new ArrayList();
        Iterator<X0xII0I> it = this.f14429oxoX.iterator();
        while (it.hasNext()) {
            X0xII0I next = it.next();
            if (next.OO0()) {
                arrayList.add(next);
            }
        }
        this.f14429oxoX.removeAll(arrayList);
    }

    public Byte xxX(int i, int i2) {
        return XxX0x0xxx(i, i2, 65534);
    }

    public oIXoXx0(String str, int i) {
        this.f14428oIX0oI = str;
        this.f14424II0xO0 = i;
        this.f14423I0Io = 0;
        this.f14429oxoX = new ArrayList<>();
        this.f14426X0o0xo = new ArrayList<>();
        this.f14427XO = 0L;
    }
}
