package com.garmin.fit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes9.dex */
public class xOxOoo implements oXIoIo, oOIx, O0X, O0xxXxI {

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final String f15462IIX0o = "moderate_activity_minutes";

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f15463IIXOooo = 86400;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final String f15464O0xOxO = "calories";

    /* renamed from: OxI, reason: collision with root package name */
    public static final String f15465OxI = "active_calories";

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final String f15466X0IIOO = "active_time";

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final String f15467XI0IXoo = "intensity";

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final String f15468XIxXXX0x0 = "heart_rate";

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final String f15469XxX0x0xxx = "ascent";

    /* renamed from: o00, reason: collision with root package name */
    public static final String f15470o00 = "distance";

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static final String f15471ooXIXxIX = "vigorous_activity_minutes";

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final String f15472xXxxox0I = "descent";

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final String f15473xoXoI = "cycles";

    /* renamed from: xxX, reason: collision with root package name */
    public static final String f15474xxX = "temperature";

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public xOoIIIoXI f15476II0XooXoX;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public long f15478IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public TreeMap<ActivityType, xOoIIIoXI> f15479OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public long f15480Oo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public X00IxOx f15481Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public HashSet<String> f15482Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public HashMap<String, Boolean> f15483OxxIIOOXO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f15484X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f15485XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public TreeMap<ActivityType, I0Io> f15486oI0IIXIo;

    /* renamed from: oO, reason: collision with root package name */
    public long f15488oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public long f15489oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public long f15490ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public ArrayList<oOIx> f15491oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public long f15492x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public long f15493x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public TreeMap<ActivityType, ArrayList<xOoIIIoXI>> f15494xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public xOoIIIoXI f15495xxIXOIIO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String[] f15487oIX0oI = {f15473xoXoI, f15470o00, f15465OxI, "calories", f15466X0IIOO};

    /* renamed from: II0xO0, reason: collision with root package name */
    public final String[] f15477II0xO0 = {f15467XI0IXoo, "heart_rate", "temperature"};

    /* renamed from: I0Io, reason: collision with root package name */
    public final String[] f15475I0Io = {f15469XxX0x0xxx, f15472xXxxox0I, f15462IIX0o, f15471ooXIXxIX};

    /* loaded from: classes9.dex */
    public class I0Io {

        /* renamed from: I0Io, reason: collision with root package name */
        public float f15496I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f15497II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public float f15499oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public float f15500oxoX;

        public I0Io() {
            this.f15499oIX0oI = 0.0f;
            this.f15497II0xO0 = 0;
            this.f15496I0Io = 0.0f;
            this.f15500oxoX = 0.0f;
        }
    }

    /* loaded from: classes9.dex */
    public class II0xO0 extends X0xII0I implements X0o0xo {

        /* renamed from: Oo, reason: collision with root package name */
        public long f15502Oo;

        /* renamed from: oO, reason: collision with root package name */
        public long f15503oO;

        /* renamed from: x0XOIxOo, reason: collision with root package name */
        public Double f15504x0XOIxOo;

        /* renamed from: x0xO0oo, reason: collision with root package name */
        public Double f15505x0xO0oo;

        public II0xO0(X0xII0I x0xII0I) {
            super(x0xII0I);
            this.f15504x0XOIxOo = new Double(XIXIX.OOXIXo.f3760XO);
            long j = xOxOoo.this.f15489oOoXoXO + xOxOoo.this.f15488oO;
            long j2 = j - (j % jxl.read.biff.oI0IIXIo.f28349Oxx0xo);
            this.f15503oO = j2;
            this.f15503oO = j2 - xOxOoo.this.f15488oO;
            this.f15505x0xO0oo = null;
            this.f15502Oo = 0L;
        }

        @Override // com.garmin.fit.xOxOoo.X0o0xo
        public double II0xO0() {
            return -1.0d;
        }

        @Override // com.garmin.fit.oOIx
        public void oIX0oI(xOoIIIoXI xooiiioxi) {
            Double d;
            long j;
            X0xII0I oO2 = xooiiioxi.oO(this.f13536oxoX);
            long longValue = xooiiioxi.getTimestamp().x0xO0oo().longValue();
            if (!((Boolean) xOxOoo.this.f15483OxxIIOOXO.get(this.f13528I0Io)).booleanValue()) {
                return;
            }
            if (oO2 != null) {
                d = oO2.X0IIOO();
            } else {
                d = null;
            }
            if (longValue <= xOxOoo.this.f15489oOoXoXO) {
                if (d != null) {
                    this.f15504x0XOIxOo = d;
                }
                this.f15503oO = longValue;
                return;
            }
            if (xOxOoo.this.f15476II0XooXoX != null && xOxOoo.this.f15476II0XooXoX.getTimestamp() != null) {
                j = xOxOoo.this.f15476II0XooXoX.getTimestamp().x0xO0oo().longValue();
            } else {
                j = 0;
            }
            if (this.f15503oO < xOxOoo.this.f15489oOoXoXO && (xOxOoo.this.f15489oOoXoXO >= j || xOxOoo.this.f15495xxIXOIIO == null || xOxOoo.this.f15495xxIXOIIO.getTimestamp().x0xO0oo().longValue() < this.f15503oO)) {
                if (d != null) {
                    long j2 = this.f15503oO;
                    if (j2 == longValue) {
                        this.f15503oO = j2 - (xOxOoo.this.f15489oOoXoXO - this.f15503oO);
                    }
                    double doubleValue = this.f15504x0XOIxOo.doubleValue();
                    double doubleValue2 = d.doubleValue() - this.f15504x0XOIxOo.doubleValue();
                    long j3 = xOxOoo.this.f15489oOoXoXO;
                    long j4 = this.f15503oO;
                    this.f15504x0XOIxOo = Double.valueOf(doubleValue + ((doubleValue2 * (j3 - j4)) / (longValue - j4)));
                }
                this.f15503oO = xOxOoo.this.f15489oOoXoXO;
            }
            if (longValue > xOxOoo.this.f15490ooOOo0oXI && d != null) {
                if (this.f15505x0xO0oo == null) {
                    this.f15505x0xO0oo = this.f15504x0XOIxOo;
                    this.f15502Oo = this.f15503oO;
                }
                long j5 = this.f15502Oo;
                if (j5 == longValue) {
                    this.f15502Oo = j5 - (longValue - xOxOoo.this.f15490ooOOo0oXI);
                }
                double doubleValue3 = this.f15505x0xO0oo.doubleValue();
                double doubleValue4 = d.doubleValue() - this.f15505x0xO0oo.doubleValue();
                long j6 = xOxOoo.this.f15490ooOOo0oXI;
                long j7 = this.f15502Oo;
                d = Double.valueOf(doubleValue3 + ((doubleValue4 * (j6 - j7)) / (longValue - j7)));
            }
            this.f15502Oo = longValue;
            if (d != null) {
                this.f15505x0xO0oo = d;
            }
        }

        @Override // com.garmin.fit.xOxOoo.X0o0xo
        public boolean oxoX(xOoIIIoXI xooiiioxi) {
            Double d = this.f15505x0xO0oo;
            if (d == null) {
                return false;
            }
            double doubleValue = d.doubleValue() - this.f15504x0XOIxOo.doubleValue();
            if (doubleValue < XIXIX.OOXIXo.f3760XO) {
                doubleValue = 0.0d;
            }
            xooiiioxi.X0xII0I(this.f13536oxoX, 0, Double.valueOf(doubleValue));
            if (doubleValue == XIXIX.OOXIXo.f3760XO) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes9.dex */
    public interface X0o0xo extends oOIx {
        double II0xO0();

        String getName();

        boolean oxoX(xOoIIIoXI xooiiioxi);
    }

    /* loaded from: classes9.dex */
    public class XO extends X0xII0I implements X0o0xo {

        /* renamed from: x0XOIxOo, reason: collision with root package name */
        public double f15507x0XOIxOo;

        public XO(X0xII0I x0xII0I) {
            super(x0xII0I);
            this.f15507x0XOIxOo = XIXIX.OOXIXo.f3760XO;
        }

        @Override // com.garmin.fit.xOxOoo.X0o0xo
        public double II0xO0() {
            return this.f15507x0XOIxOo;
        }

        @Override // com.garmin.fit.oOIx
        public void oIX0oI(xOoIIIoXI xooiiioxi) {
            Double X0IIOO2;
            X0xII0I oO2 = xooiiioxi.oO(this.f13536oxoX);
            if (!((Boolean) xOxOoo.this.f15483OxxIIOOXO.get(this.f13528I0Io)).booleanValue()) {
                return;
            }
            if (xooiiioxi.getTimestamp().x0xO0oo().longValue() > xOxOoo.this.f15490ooOOo0oXI) {
                long unused = xOxOoo.this.f15490ooOOo0oXI;
            }
            if (oO2 == null || (X0IIOO2 = oO2.X0IIOO()) == null) {
                return;
            }
            this.f15507x0XOIxOo += X0IIOO2.doubleValue();
        }

        @Override // com.garmin.fit.xOxOoo.X0o0xo
        public boolean oxoX(xOoIIIoXI xooiiioxi) {
            double d = this.f15507x0XOIxOo;
            if (d == XIXIX.OOXIXo.f3760XO) {
                return false;
            }
            xooiiioxi.X0xII0I(this.f13536oxoX, 0, Double.valueOf(d));
            return true;
        }
    }

    /* loaded from: classes9.dex */
    public class oxoX extends X0xII0I implements X0o0xo {

        /* renamed from: oO, reason: collision with root package name */
        public double f15509oO;

        /* renamed from: x0XOIxOo, reason: collision with root package name */
        public double f15510x0XOIxOo;

        /* renamed from: x0xO0oo, reason: collision with root package name */
        public long f15511x0xO0oo;

        public oxoX(X0xII0I x0xII0I) {
            super(x0xII0I);
            this.f15510x0XOIxOo = XIXIX.OOXIXo.f3760XO;
            this.f15509oO = XIXIX.OOXIXo.f3760XO;
            this.f15511x0xO0oo = xOxOoo.this.f15489oOoXoXO;
        }

        @Override // com.garmin.fit.xOxOoo.X0o0xo
        public double II0xO0() {
            return this.f15510x0XOIxOo / this.f15509oO;
        }

        @Override // com.garmin.fit.oOIx
        public void oIX0oI(xOoIIIoXI xooiiioxi) {
            Double X0IIOO2;
            X0xII0I oO2 = xooiiioxi.oO(this.f13536oxoX);
            if (!xOxOoo.this.f15485XO && ((Boolean) xOxOoo.this.f15483OxxIIOOXO.get(this.f13528I0Io)).booleanValue()) {
                long longValue = xooiiioxi.getTimestamp().x0xO0oo().longValue();
                if (longValue > xOxOoo.this.f15490ooOOo0oXI) {
                    longValue = xOxOoo.this.f15490ooOOo0oXI;
                }
                long j = this.f15511x0xO0oo;
                if (j >= longValue) {
                    return;
                }
                double d = longValue - j;
                this.f15511x0xO0oo = longValue;
                if (oO2 == null || (X0IIOO2 = oO2.X0IIOO()) == null) {
                    return;
                }
                this.f15509oO += d;
                this.f15510x0XOIxOo += X0IIOO2.doubleValue() * d;
            }
        }

        @Override // com.garmin.fit.xOxOoo.X0o0xo
        public boolean oxoX(xOoIIIoXI xooiiioxi) {
            double d = this.f15509oO;
            if (d == XIXIX.OOXIXo.f3760XO) {
                return false;
            }
            xooiiioxi.X0xII0I(this.f13536oxoX, 0, Double.valueOf(this.f15510x0XOIxOo / d));
            return true;
        }
    }

    public xOxOoo(int i) {
        if (i >= 0 && i <= 86400) {
            this.f15491oxoX = new ArrayList<>();
            this.f15484X0o0xo = i;
            int i2 = 0;
            this.f15485XO = false;
            this.f15494xoIox = new TreeMap<>();
            this.f15479OOXIXo = new TreeMap<>();
            this.f15488oO = 0L;
            this.f15480Oo = 0L;
            this.f15478IXxxXO = 0L;
            this.f15486oI0IIXIo = new TreeMap<>();
            this.f15483OxxIIOOXO = new HashMap<>();
            this.f15482Oxx0xo = new HashSet<>();
            while (true) {
                String[] strArr = this.f15475I0Io;
                if (i2 < strArr.length) {
                    this.f15482Oxx0xo.add(strArr[i2]);
                    i2++;
                } else {
                    HashMap<String, Boolean> hashMap = this.f15483OxxIIOOXO;
                    Boolean bool = Boolean.TRUE;
                    hashMap.put(f15473xoXoI, bool);
                    this.f15483OxxIIOOXO.put(f15470o00, bool);
                    this.f15483OxxIIOOXO.put(f15465OxI, bool);
                    this.f15483OxxIIOOXO.put("calories", bool);
                    this.f15483OxxIIOOXO.put(f15466X0IIOO, bool);
                    this.f15483OxxIIOOXO.put(f15467XI0IXoo, bool);
                    this.f15483OxxIIOOXO.put("heart_rate", bool);
                    this.f15483OxxIIOOXO.put("temperature", bool);
                    this.f15483OxxIIOOXO.put(f15469XxX0x0xxx, bool);
                    this.f15483OxxIIOOXO.put(f15472xXxxox0I, bool);
                    this.f15483OxxIIOOXO.put(f15462IIX0o, bool);
                    this.f15483OxxIIOOXO.put(f15471ooXIXxIX, bool);
                    return;
                }
            }
        } else {
            throw new FitRuntimeException(i + "s is invalid.  Output interval duration must be between 1s and 86400s (1 day).");
        }
    }

    @Override // com.garmin.fit.oXIoIo
    public void I0Io(X00IxOx x00IxOx) {
        this.f15481Oxx0IOOO = x00IxOx;
        o0xxxXXxX timestamp = x00IxOx.getTimestamp();
        this.f15493x0xO0oo = timestamp.x0xO0oo().longValue();
        timestamp.OOXIXo(this.f15480Oo);
        this.f15481Oxx0IOOO.oIX0oI(timestamp);
        this.f15492x0XOIxOo = timestamp.x0xO0oo().longValue();
        if (this.f15481Oxx0IOOO.OooI() != null) {
            IXX ixx = new IXX(this.f15481Oxx0IOOO.OooI().longValue());
            ixx.oIX0oI(this.f15478IXxxXO);
            this.f15488oO = ixx.X0o0xo().longValue() - this.f15492x0XOIxOo;
        } else {
            this.f15488oO = this.f15478IXxxXO - this.f15480Oo;
        }
        this.f15489oOoXoXO = this.f15492x0XOIxOo;
    }

    public void IIXOooo() {
        Iterator<Map.Entry<String, Boolean>> it = this.f15483OxxIIOOXO.entrySet().iterator();
        while (it.hasNext()) {
            this.f15483OxxIIOOXO.put(it.next().getKey(), Boolean.TRUE);
        }
    }

    public final xOoIIIoXI IXxxXO(ActivityType activityType, ArrayList<xOoIIIoXI> arrayList) {
        xOoIIIoXI xooiiioxi = new xOoIIIoXI();
        ArrayList arrayList2 = new ArrayList();
        if (arrayList.size() == 0) {
            return null;
        }
        xooiiioxi.oIX0oI(new o0xxxXXxX(this.f15490ooOOo0oXI));
        xooiiioxi.Oxo00O(Long.valueOf(this.f15490ooOOo0oXI + this.f15488oO));
        xooiiioxi.Xo(activityType);
        xooiiioxi.xIXIOX(Long.valueOf(this.f15490ooOOo0oXI - this.f15489oOoXoXO));
        boolean z = false;
        for (String str : this.f15487oIX0oI) {
            arrayList2.add(new II0xO0(xOoIIIoXI.f15450oo.x0xO0oo(str)));
        }
        for (String str2 : this.f15477II0xO0) {
            arrayList2.add(new oxoX(xOoIIIoXI.f15450oo.x0xO0oo(str2)));
        }
        for (String str3 : this.f15475I0Io) {
            arrayList2.add(new XO(xOoIIIoXI.f15450oo.x0xO0oo(str3)));
        }
        Iterator<xOoIIIoXI> it = arrayList.iterator();
        while (true) {
            boolean z2 = true;
            if (!it.hasNext()) {
                break;
            }
            xOoIIIoXI next = it.next();
            int i = 0;
            while (true) {
                String[] strArr = this.f15475I0Io;
                if (i < strArr.length) {
                    if (next.x0xO0oo(strArr[i]) != null) {
                        this.f15495xxIXOIIO = next;
                        z2 = false;
                    }
                    if (z2) {
                        this.f15476II0XooXoX = next;
                    }
                    i++;
                }
            }
        }
        Iterator<xOoIIIoXI> it2 = arrayList.iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            xOoIIIoXI next2 = it2.next();
            long longValue = next2.getTimestamp().x0xO0oo().longValue();
            if (longValue > this.f15489oOoXoXO && longValue < this.f15490ooOOo0oXI + this.f15484X0o0xo) {
                z3 = true;
            }
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                X0o0xo x0o0xo = (X0o0xo) it3.next();
                if (this.f15482Oxx0xo.contains(x0o0xo.getName())) {
                    if (longValue > this.f15489oOoXoXO && longValue <= this.f15490ooOOo0oXI) {
                        x0o0xo.oIX0oI(next2);
                    }
                } else {
                    x0o0xo.oIX0oI(next2);
                }
            }
        }
        if (!z3) {
            return null;
        }
        Iterator it4 = arrayList2.iterator();
        while (it4.hasNext()) {
            if (((X0o0xo) it4.next()).oxoX(xooiiioxi)) {
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return xooiiioxi;
    }

    public final void O0xOxO(xOoIIIoXI xooiiioxi, xOoIIIoXI xooiiioxi2) {
        Iterator<X0xII0I> it = xooiiioxi2.f14429oxoX.iterator();
        while (it.hasNext()) {
            xooiiioxi.x0(new X0xII0I(it.next()));
        }
    }

    public final boolean Oo(boolean z) {
        TreeMap treeMap = new TreeMap();
        if (this.f15490ooOOo0oXI == this.f15492x0XOIxOo) {
            return false;
        }
        if (this.f15485XO) {
            this.f15489oOoXoXO = xoXoI(this.f15489oOoXoXO);
        }
        long j = this.f15490ooOOo0oXI;
        long j2 = this.f15489oOoXoXO;
        if (j < j2) {
            this.f15490ooOOo0oXI = xoXoI(j2);
        }
        if (z && this.f15490ooOOo0oXI + this.f15484X0o0xo > this.f15492x0XOIxOo) {
            return false;
        }
        long j3 = this.f15490ooOOo0oXI + this.f15484X0o0xo;
        this.f15490ooOOo0oXI = j3;
        long j4 = this.f15492x0XOIxOo;
        if (j3 > j4) {
            this.f15490ooOOo0oXI = j4;
        }
        xOoIIIoXI xooiiioxi = null;
        for (ActivityType activityType : this.f15494xoIox.keySet()) {
            ArrayList<xOoIIIoXI> arrayList = this.f15494xoIox.get(activityType);
            xOoIIIoXI IXxxXO2 = IXxxXO(activityType, arrayList);
            if (IXxxXO2 != null) {
                treeMap.put(activityType, IXxxXO2);
                if (IXxxXO2.OIx00oxx() == ActivityType.ALL) {
                    xooiiioxi = IXxxXO2;
                }
            }
            int i = 0;
            while (i < arrayList.size() && arrayList.get(i).getTimestamp().x0xO0oo().longValue() <= this.f15490ooOOo0oXI) {
                i++;
            }
            int i2 = i - 1;
            while (i2 > 0) {
                i2--;
                arrayList.remove(i2);
            }
        }
        if (treeMap.size() > 0) {
            xOoIIIoXI xooiiioxi2 = (xOoIIIoXI) treeMap.values().iterator().next();
            xOoIIIoXI xooiiioxi3 = new xOoIIIoXI();
            xooiiioxi3.oIX0oI(xooiiioxi2.getTimestamp());
            xooiiioxi3.Oxo00O(xooiiioxi2.OxXXx0X());
            xooiiioxi3.Xo(ActivityType.ALL);
            xooiiioxi3.xIXIOX(xooiiioxi2.x00IOx());
            Iterator it = treeMap.keySet().iterator();
            while (it.hasNext()) {
                xOoIIIoXI xooiiioxi4 = (xOoIIIoXI) treeMap.get((ActivityType) it.next());
                if (xooiiioxi4.OIx00oxx() != ActivityType.ALL) {
                    for (String str : this.f15487oIX0oI) {
                        if (xooiiioxi4.IO(str) != null) {
                            if (xooiiioxi3.IO(str) == null) {
                                xooiiioxi3.XI(str, Float.valueOf(0.0f));
                            }
                            xooiiioxi3.XI(str, Double.valueOf(xooiiioxi3.IO(str).doubleValue() + xooiiioxi4.IO(str).doubleValue()));
                        }
                    }
                    for (String str2 : this.f15475I0Io) {
                        if (xooiiioxi4.IO(str2) != null) {
                            if (xooiiioxi3.IO(str2) == null) {
                                xooiiioxi3.XI(str2, Float.valueOf(0.0f));
                            }
                            xooiiioxi3.XI(str2, Double.valueOf(xooiiioxi3.IO(str2).doubleValue() + xooiiioxi4.IO(str2).doubleValue()));
                        }
                    }
                }
            }
            if (xooiiioxi3.xxxI() == null && this.f15481Oxx0IOOO.O00() != null) {
                xooiiioxi3.IIOIX(Integer.valueOf((int) ((xooiiioxi3.x00IOx().longValue() * this.f15481Oxx0IOOO.O00().intValue()) / jxl.read.biff.oI0IIXIo.f28349Oxx0xo)));
                if (xooiiioxi3.Oxx() != null) {
                    xooiiioxi3.IIOIX(Integer.valueOf(xooiiioxi3.xxxI().intValue() + xooiiioxi3.Oxx().intValue()));
                }
            }
            if (xooiiioxi != null) {
                Iterator<X0xII0I> it2 = xooiiioxi3.f14429oxoX.iterator();
                while (it2.hasNext()) {
                    X0xII0I next = it2.next();
                    if (xooiiioxi.oO(next.f13536oxoX) == null) {
                        xooiiioxi.x0(next);
                    }
                }
            } else {
                treeMap.put(ActivityType.ALL, xooiiioxi3);
            }
            for (ActivityType activityType2 : treeMap.keySet()) {
                Iterator<oOIx> it3 = this.f15491oxoX.iterator();
                while (it3.hasNext()) {
                    it3.next().oIX0oI((xOoIIIoXI) treeMap.get(activityType2));
                }
            }
            this.f15489oOoXoXO = this.f15490ooOOo0oXI;
            return true;
        }
        return true;
    }

    public void OxI(String str, boolean z) {
        this.f15483OxxIIOOXO.put(str, Boolean.valueOf(z));
    }

    public void Oxx0xo() {
        Iterator<Map.Entry<String, Boolean>> it = this.f15483OxxIIOOXO.entrySet().iterator();
        while (it.hasNext()) {
            this.f15483OxxIIOOXO.put(it.next().getKey(), Boolean.FALSE);
        }
    }

    public HashMap<String, Boolean> OxxIIOOXO() {
        return new HashMap<>(this.f15483OxxIIOOXO);
    }

    public void X0IIOO(long j) {
        this.f15478IXxxXO = j;
    }

    @Override // com.garmin.fit.O0X
    public void X0o0xo(oOo ooo) {
        short s;
        if (ooo.OOIXx0x() != null) {
            long longValue = ooo.OOIXx0x().longValue();
            XI0IXoo(longValue);
            if (ooo.Oxx() != null) {
                s = ooo.Oxx().shortValue();
            } else {
                s = 0;
            }
            if (ooo.OXXoIoXI(s) != null) {
                longValue = (long) (longValue + (ooo.OXXoIoXI(s).floatValue() * 3600.0d));
            }
            X0IIOO(longValue);
        }
    }

    public void XI0IXoo(long j) {
        this.f15480Oo = j;
    }

    @Override // com.garmin.fit.O0xxXxI
    public void XO(xOOxIO xooxio) {
    }

    public void o00() {
        if (this.f15484X0o0xo == 86400) {
            this.f15485XO = true;
            return;
        }
        throw new FitRuntimeException("Interval must be 86400s to output daily totals");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final xOoIIIoXI oI0IIXIo(xOoIIIoXI xooiiioxi) {
        I0Io i0Io;
        long j;
        long j2;
        long j3;
        long j4;
        xOoIIIoXI xooiiioxi2 = new xOoIIIoXI();
        if (xooiiioxi.getTimestamp() != null) {
            this.f15493x0xO0oo = xooiiioxi.getTimestamp().x0xO0oo().longValue();
        } else if (xooiiioxi.OOxOI() != null) {
            this.f15493x0xO0oo += (xooiiioxi.OOxOI().intValue() - (this.f15493x0xO0oo & 65535)) & 65535;
        } else if (xooiiioxi.XO00XOO() != null) {
            long j5 = this.f15493x0xO0oo / 60;
            this.f15493x0xO0oo = j5;
            this.f15493x0xO0oo = (j5 + ((xooiiioxi.XO00XOO().shortValue() - (this.f15493x0xO0oo & 255)) & 255)) * 60;
        }
        o0xxxXXxX o0xxxxxxx = new o0xxxXXxX(this.f15493x0xO0oo);
        o0xxxxxxx.OOXIXo(this.f15480Oo);
        xooiiioxi2.oIX0oI(o0xxxxxxx);
        if (xooiiioxi.OxXXx0X() != null) {
            xooiiioxi2.Oxo00O(xooiiioxi.OxXXx0X());
        } else {
            xooiiioxi2.Oxo00O(Long.valueOf(o0xxxxxxx.x0xO0oo().longValue() + this.f15488oO));
        }
        if (xooiiioxi.OIx00oxx() != null) {
            xooiiioxi2.Xo(xooiiioxi.OIx00oxx());
        }
        ActivityType OIx00oxx2 = xooiiioxi2.OIx00oxx();
        xOoIIIoXI xooiiioxi3 = null;
        Object[] objArr = 0;
        if (OIx00oxx2 != null) {
            i0Io = this.f15486oI0IIXIo.get(OIx00oxx2);
        } else {
            i0Io = null;
        }
        if (i0Io == null) {
            i0Io = new I0Io();
            if (OIx00oxx2 != null) {
                this.f15486oI0IIXIo.put(OIx00oxx2, i0Io);
            }
        }
        int i = Integer.MAX_VALUE;
        if (this.f15481Oxx0IOOO.OIx00oxx() > 0) {
            for (int i2 = 0; i2 < this.f15481Oxx0IOOO.OIx00oxx(); i2++) {
                if (this.f15481Oxx0IOOO.Oxx(i2) == xooiiioxi2.OIx00oxx()) {
                    i = i2;
                }
            }
        }
        ActivityType OIx00oxx3 = xooiiioxi.OIx00oxx();
        if (OIx00oxx3 != null) {
            xooiiioxi3 = this.f15479OOXIXo.get(OIx00oxx3);
        }
        if (xooiiioxi3 == null) {
            xooiiioxi3 = new xOoIIIoXI();
        }
        if (xooiiioxi.x00IOx() != null) {
            xooiiioxi2.xIXIOX(xooiiioxi.x00IOx());
        } else if (xooiiioxi.xX() != null) {
            xooiiioxi2.xIXIOX(Long.valueOf(xooiiioxi.xX().intValue() * 60));
        }
        if (xooiiioxi.OX() != null) {
            xooiiioxi2.OOIXx0x(xooiiioxi.OX());
        } else if (xooiiioxi.oXIoO() != null) {
            if (xooiiioxi3.OX() != null) {
                j2 = (long) (xooiiioxi3.OX().floatValue() + 0.5d);
            } else {
                j2 = 0;
            }
            xooiiioxi2.OOIXx0x(Float.valueOf((float) (j2 + ((xooiiioxi.oXIoO().intValue() - (j2 & 65535)) & 65535))));
        } else if (xooiiioxi.O00() != null) {
            if (xooiiioxi3.OX() != null) {
                j = (long) (xooiiioxi3.OX().floatValue() + 0.5d);
            } else {
                j = 0;
            }
            xooiiioxi2.OOIXx0x(Float.valueOf((float) (j + (o0xxxxxxx.x0xO0oo().longValue() - this.f15492x0XOIxOo))));
        }
        if (xooiiioxi.xOOxIO() != null) {
            xooiiioxi2.X0ooXIooI(xooiiioxi.xOOxIO());
        } else if (xooiiioxi.O0xxXxI() != null) {
            if (xooiiioxi3.xOOxIO() != null) {
                j3 = xooiiioxi3.xOOxIO().floatValue() * 2.0f;
            } else {
                j3 = 0;
            }
            xooiiioxi2.X0ooXIooI(Float.valueOf(((float) (j3 + ((xooiiioxi.O0xxXxI().intValue() - (j3 & 65535)) & 65535))) / 2.0f));
        }
        if (xooiiioxi.XO0o() != null) {
            xooiiioxi2.x0oxIIIX(xooiiioxi.XO0o());
        } else if (xooiiioxi.oX0I0O() != null) {
            if (xooiiioxi3.XO0o() != null) {
                j4 = xooiiioxi3.XO0o().floatValue() * 100.0f;
            } else {
                j4 = 0;
            }
            xooiiioxi2.x0oxIIIX(Float.valueOf(((float) (j4 + ((xooiiioxi.oX0I0O().intValue() - (j4 & 65535)) & 65535))) / 100.0f));
        }
        if (xooiiioxi.Oxx() != null) {
            xooiiioxi2.XooIO0oo0(xooiiioxi.Oxx());
        }
        if (xooiiioxi.xxxI() != null) {
            xooiiioxi2.IIOIX(xooiiioxi.xxxI());
        }
        if (xooiiioxi.oo00() != null) {
            xooiiioxi2.X0IOOI(xooiiioxi.oo00());
        }
        if (xooiiioxi.oX0ooo0I0() != null) {
            xooiiioxi2.IOOoXo0Ix(xooiiioxi.oX0ooo0I0());
        }
        if (xooiiioxi.xxx00() != null) {
            xooiiioxi2.XxIo(xooiiioxi.xxx00());
        }
        if (xooiiioxi.xIXX() != null) {
            xooiiioxi2.oXO0oOx0(xooiiioxi.xIXX());
        }
        if (xooiiioxi.oxOXxoXII() != null) {
            xooiiioxi2.xIOXX(xooiiioxi.oxOXxoXII());
        }
        if (xooiiioxi.OOOI() != null) {
            xooiiioxi2.Ix0(xooiiioxi.OOOI());
        }
        if (xooiiioxi.OXXoIoXI() != null) {
            xooiiioxi2.OIxx0I0(xooiiioxi.OXXoIoXI());
        }
        if (xooiiioxi2.XO0o() != null) {
            i0Io.f15500oxoX = xooiiioxi2.XO0o().floatValue();
            i0Io.f15496I0Io = xooiiioxi2.xOOxIO().floatValue();
        } else if (i < this.f15481Oxx0IOOO.xxxI() && xooiiioxi2.xOOxIO() != null) {
            xooiiioxi2.x0oxIIIX(Float.valueOf(i0Io.f15500oxoX + ((xooiiioxi2.xOOxIO().floatValue() - i0Io.f15496I0Io) * this.f15481Oxx0IOOO.XoIxOXIXo(i).floatValue())));
        }
        if (xooiiioxi2.Oxx() != null) {
            i0Io.f15497II0xO0 = xooiiioxi2.Oxx().intValue();
            i0Io.f15499oIX0oI = xooiiioxi2.xOOxIO().floatValue();
        } else if (i < this.f15481Oxx0IOOO.xIXX() && xooiiioxi2.xOOxIO() != null) {
            xooiiioxi2.XooIO0oo0(Integer.valueOf((int) (i0Io.f15497II0xO0 + ((xooiiioxi2.xOOxIO().floatValue() - i0Io.f15499oIX0oI) * this.f15481Oxx0IOOO.oXIoO(i).floatValue()))));
        }
        return xooiiioxi2;
    }

    @Override // com.garmin.fit.oOIx
    public void oIX0oI(xOoIIIoXI xooiiioxi) {
        xOoIIIoXI xooiiioxi2;
        if (this.f15481Oxx0IOOO == null) {
            return;
        }
        xOoIIIoXI oI0IIXIo2 = oI0IIXIo(xooiiioxi);
        if (oI0IIXIo2.OIx00oxx() == null) {
            oI0IIXIo2.Xo(ActivityType.ALL);
        }
        if (oI0IIXIo2.getTimestamp() == null) {
            return;
        }
        if (this.f15492x0XOIxOo != oI0IIXIo2.getTimestamp().x0xO0oo().longValue() && this.f15492x0XOIxOo - xoXoI(this.f15489oOoXoXO) >= this.f15484X0o0xo) {
            x0xO0oo();
        }
        if (xooiiioxi.O00() != null) {
            if (this.f15479OOXIXo.get(oI0IIXIo2.OIx00oxx()) == null) {
                ArrayList<xOoIIIoXI> arrayList = new ArrayList<>();
                xOoIIIoXI xooiiioxi3 = new xOoIIIoXI();
                xooiiioxi3.Xo(oI0IIXIo2.OIx00oxx());
                xooiiioxi3.oIX0oI(new o0xxxXXxX(oI0IIXIo2.getTimestamp().x0xO0oo().longValue() - oI0IIXIo2.OX().longValue()));
                arrayList.add(xooiiioxi3);
                this.f15494xoIox.put(xooiiioxi3.OIx00oxx(), arrayList);
            }
            for (xOoIIIoXI xooiiioxi4 : this.f15479OOXIXo.values()) {
                if (xooiiioxi4.OIx00oxx() != oI0IIXIo2.OIx00oxx()) {
                    xOoIIIoXI xooiiioxi5 = new xOoIIIoXI();
                    xooiiioxi5.oIX0oI(oI0IIXIo2.getTimestamp());
                    xooiiioxi5.Xo(xooiiioxi4.OIx00oxx());
                    for (String str : this.f15487oIX0oI) {
                        if (xooiiioxi4.x0xO0oo(str) != null) {
                            xooiiioxi5.x0(xooiiioxi4.x0xO0oo(str));
                        }
                    }
                    this.f15494xoIox.get(xooiiioxi5.OIx00oxx()).add(xooiiioxi5);
                }
            }
        }
        this.f15492x0XOIxOo = oI0IIXIo2.getTimestamp().x0xO0oo().longValue();
        xOoIIIoXI xooiiioxi6 = this.f15479OOXIXo.get(oI0IIXIo2.OIx00oxx());
        if (xooiiioxi6 == null) {
            xooiiioxi6 = new xOoIIIoXI();
            this.f15479OOXIXo.put(oI0IIXIo2.OIx00oxx(), xooiiioxi6);
        }
        O0xOxO(xooiiioxi6, oI0IIXIo2);
        ArrayList<xOoIIIoXI> arrayList2 = this.f15494xoIox.get(oI0IIXIo2.OIx00oxx());
        if (arrayList2 == null) {
            arrayList2 = new ArrayList<>();
            this.f15494xoIox.put(oI0IIXIo2.OIx00oxx(), arrayList2);
        }
        if (arrayList2.size() > 0) {
            xooiiioxi2 = arrayList2.get(arrayList2.size() - 1);
        } else {
            xooiiioxi2 = null;
        }
        if (xooiiioxi2 != null && oI0IIXIo2.getTimestamp().oOoXoXO(xooiiioxi2.getTimestamp())) {
            O0xOxO(xooiiioxi2, oI0IIXIo2);
        } else {
            arrayList2.add(oI0IIXIo2);
        }
    }

    public void oO() {
        do {
        } while (Oo(false));
    }

    public void x0XOIxOo(oOIx ooix) {
        this.f15491oxoX.add(ooix);
    }

    public final void x0xO0oo() {
        do {
        } while (Oo(true));
    }

    public final long xoXoI(long j) {
        long j2 = this.f15488oO;
        long j3 = j + j2;
        return (j3 - (j3 % this.f15484X0o0xo)) - j2;
    }
}
