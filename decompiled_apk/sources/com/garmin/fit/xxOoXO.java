package com.garmin.fit;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes9.dex */
public class xxOoXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public double f15698I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f15699II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public ArrayList<oXX0IoI> f15700Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f15701X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public ArrayList<oIX0oI> f15702XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f15703oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public double f15704oxoX;

    /* loaded from: classes9.dex */
    public class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public long f15706II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f15707oIX0oI;

        public oIX0oI(int i, long j) {
            this.f15707oIX0oI = i;
            this.f15706II0xO0 = j;
        }

        public boolean oIX0oI(oIXoXx0 oixoxx0) {
            Long I0X0x0oIo2;
            X0xII0I oO2 = oixoxx0.oO(this.f15707oIX0oI);
            if (oO2 == null || (I0X0x0oIo2 = oO2.I0X0x0oIo(0, 65535)) == null || I0X0x0oIo2.longValue() != this.f15706II0xO0) {
                return false;
            }
            return true;
        }
    }

    public xxOoXO(xxOoXO xxooxo) {
        if (xxooxo == null) {
            this.f15703oIX0oI = "unknown";
            this.f15699II0xO0 = 0;
            this.f15698I0Io = 1.0d;
            this.f15704oxoX = XIXIX.OOXIXo.f3760XO;
            this.f15701X0o0xo = "";
            this.f15702XO = new ArrayList<>();
            this.f15700Oxx0IOOO = new ArrayList<>();
            return;
        }
        this.f15703oIX0oI = xxooxo.f15703oIX0oI;
        this.f15699II0xO0 = xxooxo.f15699II0xO0;
        this.f15698I0Io = xxooxo.f15698I0Io;
        this.f15704oxoX = xxooxo.f15704oxoX;
        this.f15701X0o0xo = xxooxo.f15701X0o0xo;
        this.f15702XO = xxooxo.f15702XO;
        this.f15700Oxx0IOOO = xxooxo.f15700Oxx0IOOO;
    }

    public boolean I0Io(oIXoXx0 oixoxx0) {
        Iterator<oIX0oI> it = this.f15702XO.iterator();
        while (it.hasNext()) {
            if (it.next().oIX0oI(oixoxx0)) {
                return true;
            }
        }
        return false;
    }

    public void II0xO0(int i, long j) {
        this.f15702XO.add(new oIX0oI(i, j));
    }

    public int X0o0xo() {
        return this.f15699II0xO0;
    }

    public String XO() {
        return this.f15701X0o0xo;
    }

    public void oIX0oI(oXX0IoI oxx0ioi) {
        this.f15700Oxx0IOOO.add(oxx0ioi);
    }

    public String oxoX() {
        return this.f15703oIX0oI;
    }

    public xxOoXO(String str, int i, double d, double d2, String str2) {
        this.f15703oIX0oI = str;
        this.f15699II0xO0 = i;
        this.f15698I0Io = d;
        this.f15704oxoX = d2;
        this.f15701X0o0xo = str2;
        this.f15702XO = new ArrayList<>();
        this.f15700Oxx0IOOO = new ArrayList<>();
    }
}
