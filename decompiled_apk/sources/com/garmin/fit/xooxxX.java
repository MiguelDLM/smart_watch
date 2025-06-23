package com.garmin.fit;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes9.dex */
public class xooxxX {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f15595I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f15596II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public ArrayList<I0> f15597X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f15598oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public ArrayList<XXXI> f15599oxoX;

    public xooxxX() {
        this.f15598oIX0oI = IXXIXx00I.f11732XXXI;
        this.f15596II0xO0 = 0;
        this.f15595I0Io = 1;
        this.f15599oxoX = new ArrayList<>();
        this.f15597X0o0xo = new ArrayList<>();
    }

    public int I0Io() {
        return this.f15595I0Io;
    }

    public ArrayList<XXXI> II0XooXoX() {
        return this.f15599oxoX;
    }

    public void II0xO0(XXXI xxxi) {
        this.f15599oxoX.add(xxxi);
    }

    public boolean OOXIXo(oIXoXx0 oixoxx0) {
        return oOoXoXO(new xooxxX(oixoxx0));
    }

    public XXXI Oxx0IOOO(int i) {
        Iterator<XXXI> it = this.f15599oxoX.iterator();
        while (it.hasNext()) {
            XXXI next = it.next();
            if (next.f13982oIX0oI == i) {
                return next;
            }
        }
        return null;
    }

    public int X0o0xo() {
        Iterator<I0> it = this.f15597X0o0xo.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().oIX0oI();
        }
        return i;
    }

    public Iterable<I0> XO() {
        return this.f15597X0o0xo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xooxxX)) {
            return false;
        }
        xooxxX xooxxx = (xooxxX) obj;
        if (this.f15598oIX0oI != xooxxx.f15598oIX0oI || this.f15596II0xO0 != xooxxx.f15596II0xO0 || this.f15599oxoX.size() != xooxxx.f15599oxoX.size()) {
            return false;
        }
        for (int i = 0; i < this.f15599oxoX.size(); i++) {
            if (!this.f15599oxoX.get(i).equals(xooxxx.f15599oxoX.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return ((((31 + new Integer(this.f15598oIX0oI).hashCode()) * 47) + new Integer(this.f15596II0xO0).hashCode()) * 19) + this.f15599oxoX.hashCode();
    }

    public void oIX0oI(I0 i0) {
        this.f15597X0o0xo.add(i0);
    }

    public boolean oOoXoXO(xooxxX xooxxx) {
        if (xooxxx == null || this.f15598oIX0oI != xooxxx.f15598oIX0oI || this.f15596II0xO0 != xooxxx.f15596II0xO0) {
            return false;
        }
        Iterator<XXXI> it = xooxxx.f15599oxoX.iterator();
        while (it.hasNext()) {
            XXXI next = it.next();
            XXXI Oxx0IOOO2 = Oxx0IOOO(next.f13982oIX0oI);
            if (Oxx0IOOO2 == null || next.f13981II0xO0 > Oxx0IOOO2.f13981II0xO0) {
                return false;
            }
        }
        Iterator<I0> it2 = xooxxx.f15597X0o0xo.iterator();
        while (it2.hasNext()) {
            I0 next2 = it2.next();
            I0 oxoX2 = oxoX(next2.XO(), next2.xxIXOIIO());
            if (oxoX2 == null || next2.oIX0oI() > oxoX2.oIX0oI()) {
                return false;
            }
        }
        return true;
    }

    public void ooOOo0oXI(OutputStream outputStream) {
        try {
            int i = this.f15596II0xO0 & 15;
            int i2 = i | 64;
            if (!this.f15597X0o0xo.isEmpty()) {
                i2 = i | 96;
            }
            outputStream.write(i2);
            outputStream.write(0);
            outputStream.write(1);
            outputStream.write(this.f15598oIX0oI >> 8);
            outputStream.write(this.f15598oIX0oI);
            outputStream.write(this.f15599oxoX.size());
            Iterator<XXXI> it = this.f15599oxoX.iterator();
            while (it.hasNext()) {
                it.next().X0o0xo(outputStream);
            }
            if (!this.f15597X0o0xo.isEmpty()) {
                outputStream.write(this.f15597X0o0xo.size());
                Iterator<I0> it2 = this.f15597X0o0xo.iterator();
                while (it2.hasNext()) {
                    it2.next().IXxxXO(outputStream);
                }
            }
        } catch (IOException e) {
            throw new FitRuntimeException(e);
        }
    }

    public final I0 oxoX(short s, int i) {
        Iterator<I0> it = this.f15597X0o0xo.iterator();
        while (it.hasNext()) {
            I0 next = it.next();
            if (next.xxIXOIIO() == i && next.XO() == s) {
                return next;
            }
        }
        return null;
    }

    public int xoIox() {
        return this.f15598oIX0oI;
    }

    public int xxIXOIIO() {
        return this.f15596II0xO0;
    }

    public xooxxX(oIXoXx0 oixoxx0) {
        this.f15598oIX0oI = oixoxx0.f14424II0xO0;
        int i = oixoxx0.f14423I0Io;
        this.f15596II0xO0 = i;
        this.f15595I0Io = 1;
        if (i < 16) {
            this.f15599oxoX = new ArrayList<>();
            this.f15597X0o0xo = new ArrayList<>();
            Iterator<X0xII0I> it = oixoxx0.f14429oxoX.iterator();
            while (it.hasNext()) {
                this.f15599oxoX.add(new XXXI(it.next()));
            }
            Iterator<IIxOXoOo0> it2 = oixoxx0.f14426X0o0xo.iterator();
            while (it2.hasNext()) {
                this.f15597X0o0xo.add(new I0(it2.next()));
            }
            return;
        }
        throw new FitRuntimeException("Invalid local message number " + this.f15596II0xO0 + ".  Local message number must be < 16" + FileUtils.FILE_EXTENSION_SEPARATOR);
    }
}
