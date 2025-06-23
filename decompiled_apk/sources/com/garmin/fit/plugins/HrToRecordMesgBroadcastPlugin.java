package com.garmin.fit.plugins;

import com.garmin.fit.File;
import com.garmin.fit.FitRuntimeException;
import com.garmin.fit.XooIO0oo0;
import com.garmin.fit.XxI;
import com.garmin.fit.o0xxxXXxX;
import com.garmin.fit.oI00o;
import com.garmin.fit.oIXoXx0;
import com.garmin.fit.xOOxIO;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class HrToRecordMesgBroadcastPlugin implements XxI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final HeartRateList f15115oIX0oI = new HeartRateList();

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f15114II0xO0 = false;

    /* loaded from: classes9.dex */
    public class HeartRateList extends ArrayList<oIX0oI> {
        private final long GAP_INCREMENT_MILLISECONDS = 250;
        private final float GAP_INCREMENT_SECONDS = 0.25f;
        private final long GAP_MAX_MILLISECONDS = 5000;
        private final long GAP_MAX_STEPS = 20;
        private Float anchorEventTimestamp = Float.valueOf(0.0f);
        private o0xxxXXxX anchorTimestamp = null;

        public HeartRateList() {
        }

        public void addHrMesssage(XooIO0oo0 xooIO0oo0) {
            if (xooIO0oo0 != null) {
                int i = 0;
                int i2 = 1;
                if (xooIO0oo0.getTimestamp() != null) {
                    this.anchorTimestamp = new o0xxxXXxX(xooIO0oo0.getTimestamp());
                    if (xooIO0oo0.OooI() != null) {
                        this.anchorTimestamp.I0Io(xooIO0oo0.OooI().floatValue());
                    }
                    if (xooIO0oo0.OIx00oxx() == 1) {
                        this.anchorEventTimestamp = xooIO0oo0.Oxx(0);
                    } else {
                        throw new FitRuntimeException("FIT HrToRecordMesgBroadcastPlugin Error: Anchor HR mesg must have 1 event_timestamp");
                    }
                }
                if (this.anchorTimestamp != null) {
                    if (xooIO0oo0.OIx00oxx() == xooIO0oo0.xxxI()) {
                        while (i < xooIO0oo0.OIx00oxx()) {
                            Float Oxx2 = xooIO0oo0.Oxx(i);
                            if (Oxx2.floatValue() < this.anchorEventTimestamp.floatValue()) {
                                if (this.anchorEventTimestamp.floatValue() - Oxx2.floatValue() > 2097152.0f) {
                                    Oxx2 = Float.valueOf(Oxx2.floatValue() + 4194304.0f);
                                } else {
                                    throw new FitRuntimeException("FIT HrToRecordMesgBroadcastPlugin Error: Anchor event_timestamp is greater than subsequent event_timestamp. This does not allow for correct delta calculation.");
                                }
                            }
                            oIX0oI oix0oi = new oIX0oI(this.anchorTimestamp, xooIO0oo0.XoIxOXIXo(i).shortValue());
                            oix0oi.f15117oIX0oI.I0Io(Oxx2.floatValue() - this.anchorEventTimestamp.floatValue());
                            if (!isEmpty()) {
                                oIX0oI oix0oi2 = get(size() - i2);
                                long abs = Math.abs(oix0oi.f15117oIX0oI.ooOOo0oXI().getTime() - oix0oi2.f15117oIX0oI.ooOOo0oXI().getTime());
                                for (long j = 1; abs > 250 && j <= 20; j++) {
                                    oIX0oI oix0oi3 = new oIX0oI(oix0oi2);
                                    oix0oi3.f15117oIX0oI.I0Io(((float) j) * 0.25f);
                                    add(oix0oi3);
                                    abs -= 250;
                                }
                            }
                            add(oix0oi);
                            i++;
                            i2 = 1;
                        }
                        return;
                    }
                    throw new FitRuntimeException("FIT HrToRecordMesgBroadcastPlugin Error: HR mesg with mismatching event timestamp and filtered bpm");
                }
                throw new FitRuntimeException("FIT HrToRecordMesgBroadcastPlugin Error: No anchor timestamp received in a HR mesg before diff HR mesgs");
            }
            throw new FitRuntimeException("FIT HrToRecordMesgBroadcastPlugin Error: HR mesg must not be null");
        }
    }

    @Override // com.garmin.fit.XxI
    public void II0xO0(List<oIXoXx0> list) {
        if (this.f15114II0xO0 && this.f15115oIX0oI.size() > 0) {
            o0xxxXXxX o0xxxxxxx = null;
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                oIXoXx0 oixoxx0 = list.get(i2);
                if (oixoxx0.XXoOx0() == 20) {
                    oI00o oi00o = new oI00o(oixoxx0);
                    o0xxxXXxX o0xxxxxxx2 = new o0xxxXXxX(oi00o.getTimestamp());
                    if (o0xxxxxxx == null) {
                        o0xxxxxxx = new o0xxxXXxX(oi00o.getTimestamp().x0xO0oo().longValue());
                    }
                    if (o0xxxxxxx.compareTo(o0xxxxxxx2) == 0) {
                        o0xxxxxxx.oxoX(-1L);
                        i = i >= 1 ? i - 1 : 0;
                    }
                    long j = 0;
                    long j2 = 0;
                    while (true) {
                        if (i < this.f15115oIX0oI.size()) {
                            oIX0oI oix0oi = this.f15115oIX0oI.get(i);
                            if (oix0oi.f15117oIX0oI.compareTo(o0xxxxxxx) > 0 && oix0oi.f15117oIX0oI.compareTo(o0xxxxxxx2) <= 0) {
                                j2 += oix0oi.f15116II0xO0;
                                j++;
                            } else if (oix0oi.f15117oIX0oI.compareTo(o0xxxxxxx2) > 0) {
                                if (j > 0) {
                                    oi00o.XoOOx0IX(Short.valueOf((short) Math.round(((float) j2) / ((float) j))));
                                    list.set(i2, oi00o);
                                }
                                o0xxxxxxx = new o0xxxXXxX(o0xxxxxxx2);
                            }
                            i++;
                        }
                    }
                }
            }
        }
    }

    @Override // com.garmin.fit.XxI
    public void oIX0oI(oIXoXx0 oixoxx0) {
        int XXoOx02 = oixoxx0.XXoOx0();
        if (XXoOx02 != 0) {
            if (XXoOx02 == 132) {
                this.f15115oIX0oI.addHrMesssage(new XooIO0oo0(oixoxx0));
            }
        } else if (new xOOxIO(oixoxx0).xIXX() == File.ACTIVITY) {
            this.f15114II0xO0 = true;
        }
    }

    /* loaded from: classes9.dex */
    public static class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public short f15116II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public o0xxxXXxX f15117oIX0oI;

        public oIX0oI(oIX0oI oix0oi) {
            this.f15117oIX0oI = new o0xxxXXxX(oix0oi.f15117oIX0oI);
            this.f15116II0xO0 = oix0oi.f15116II0xO0;
        }

        public oIX0oI(o0xxxXXxX o0xxxxxxx, short s) {
            this.f15117oIX0oI = new o0xxxXXxX(o0xxxxxxx);
            this.f15116II0xO0 = s;
        }
    }
}
