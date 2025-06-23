package com.garmin.fit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes9.dex */
public class xxxoo0XI implements IIIxO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f15744oIX0oI = 256;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f15742II0xO0 = 255;

    /* renamed from: I0Io, reason: collision with root package name */
    public int f15741I0Io = 254;

    /* renamed from: oxoX, reason: collision with root package name */
    public ArrayList<IIIxO> f15745oxoX = new ArrayList<>();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public ArrayList<LinkedList<XIxO>> f15743X0o0xo = new ArrayList<>();

    /* loaded from: classes9.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f15746oIX0oI;

        static {
            int[] iArr = new int[EventType.values().length];
            f15746oIX0oI = iArr;
            try {
                iArr[EventType.BEGIN_DEPRECIATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15746oIX0oI[EventType.END_DEPRECIATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15746oIX0oI[EventType.CONSECUTIVE_DEPRECIATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15746oIX0oI[EventType.END_ALL_DEPRECIATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15746oIX0oI[EventType.START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15746oIX0oI[EventType.STOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15746oIX0oI[EventType.STOP_DISABLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f15746oIX0oI[EventType.STOP_ALL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f15746oIX0oI[EventType.STOP_DISABLE_ALL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f15746oIX0oI[EventType.MARKER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public xxxoo0XI() {
        for (int i = 0; i < this.f15744oIX0oI; i++) {
            this.f15743X0o0xo.add(new LinkedList<>());
        }
    }

    public final void I0Io(XIxO xIxO) {
        Iterator<IIIxO> it = this.f15745oxoX.iterator();
        while (it.hasNext()) {
            it.next().oIX0oI(xIxO);
        }
    }

    public void II0xO0(IIIxO iIIxO) {
        this.f15745oxoX.add(iIIxO);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.garmin.fit.IIIxO
    public void oIX0oI(XIxO xIxO) {
        XIxO xIxO2 = (XIxO) x0OxxIOxX.Oxx0IOOO((oIXoXx0) xIxO);
        int i = this.f15742II0xO0;
        if (xIxO2.I0Io() != null) {
            i = xIxO2.I0Io().shortValue();
        }
        if (xIxO2.X0o0xo() == null) {
            return;
        }
        int[] iArr = oIX0oI.f15746oIX0oI;
        int i2 = iArr[xIxO2.X0o0xo().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        i = this.f15741I0Io;
                        xIxO2.XO(EventType.STOP_ALL);
                    }
                } else {
                    xIxO2.XO(EventType.STOP);
                }
            } else {
                i = this.f15741I0Io;
                xIxO2.XO(EventType.STOP);
            }
        } else {
            i = this.f15741I0Io;
            xIxO2.XO(EventType.START);
        }
        int i3 = 0;
        switch (iArr[xIxO2.X0o0xo().ordinal()]) {
            case 5:
                while (i3 < this.f15743X0o0xo.get(i).size()) {
                    if (this.f15743X0o0xo.get(i).get(i3).II0xO0() == xIxO2.II0xO0()) {
                        XIxO xIxO3 = (XIxO) x0OxxIOxX.Oxx0IOOO((oIXoXx0) this.f15743X0o0xo.get(i).get(i3));
                        o0xxxXXxX timestamp = xIxO2.getTimestamp();
                        xIxO3.XO(EventType.STOP);
                        if (timestamp != null) {
                            xIxO3.oIX0oI(timestamp);
                        }
                        I0Io(xIxO3);
                        this.f15743X0o0xo.get(i).remove(i3);
                    }
                    i3++;
                }
                this.f15743X0o0xo.get(i).add((XIxO) x0OxxIOxX.Oxx0IOOO((oIXoXx0) xIxO2));
                break;
            case 6:
            case 7:
                while (i3 < this.f15743X0o0xo.get(i).size()) {
                    if (this.f15743X0o0xo.get(i).get(i3).II0xO0() == xIxO2.II0xO0()) {
                        this.f15743X0o0xo.get(i).remove(i3);
                    }
                    i3++;
                }
                break;
            case 8:
                while (i3 < this.f15743X0o0xo.get(i).size()) {
                    if (this.f15743X0o0xo.get(i).get(i3).II0xO0() != xIxO2.II0xO0()) {
                        XIxO xIxO4 = (XIxO) x0OxxIOxX.Oxx0IOOO((oIXoXx0) this.f15743X0o0xo.get(i).get(i3));
                        o0xxxXXxX timestamp2 = xIxO2.getTimestamp();
                        xIxO4.XO(EventType.STOP);
                        if (timestamp2 != null) {
                            xIxO4.oIX0oI(timestamp2);
                        }
                        I0Io(xIxO4);
                    }
                    i3++;
                }
                this.f15743X0o0xo.get(i).clear();
                xIxO2.XO(EventType.STOP);
                break;
            case 9:
                while (i3 < this.f15743X0o0xo.get(i).size()) {
                    if (this.f15743X0o0xo.get(i).get(i3).II0xO0() != xIxO2.II0xO0()) {
                        XIxO xIxO5 = (XIxO) x0OxxIOxX.Oxx0IOOO((oIXoXx0) this.f15743X0o0xo.get(i).get(i3));
                        o0xxxXXxX timestamp3 = xIxO2.getTimestamp();
                        xIxO5.XO(EventType.STOP_DISABLE);
                        if (timestamp3 != null) {
                            xIxO5.oIX0oI(timestamp3);
                        }
                        I0Io(xIxO5);
                    }
                    i3++;
                }
                this.f15743X0o0xo.get(i).clear();
                xIxO2.XO(EventType.STOP_DISABLE);
                break;
        }
        I0Io(xIxO2);
    }

    public void oxoX(IIIxO iIIxO) {
        this.f15745oxoX.remove(iIIxO);
    }
}
