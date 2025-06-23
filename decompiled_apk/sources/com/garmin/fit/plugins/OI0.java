package com.garmin.fit.plugins;

import androidx.core.provider.FontsContractCompat;
import com.garmin.fit.File;
import com.garmin.fit.OX00o0X;
import com.garmin.fit.X0xOO;
import com.garmin.fit.XIXIX;
import com.garmin.fit.XxI;
import com.garmin.fit.o0xxxXXxX;
import com.garmin.fit.oI00o;
import com.garmin.fit.oIXoXx0;
import com.garmin.fit.oX0ooo0I0;
import com.garmin.fit.oXoXxOo;
import com.garmin.fit.plugins.ActivityFileValidationResult;
import com.garmin.fit.x00IOx;
import com.garmin.fit.xOOxIO;
import com.sma.smartv3.network.BaiDu;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/* loaded from: classes9.dex */
public class OI0 implements XxI {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f15118X0o0xo = 50400;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f15119oxoX = -43200;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final x00IOx f15122oIX0oI = new x00IOx();

    /* renamed from: II0xO0, reason: collision with root package name */
    public final ArrayList<ActivityFileValidationResult> f15121II0xO0 = new ArrayList<>();

    /* renamed from: I0Io, reason: collision with root package name */
    public int f15120I0Io = 0;

    public static /* synthetic */ boolean IIX0(OX00o0X oX00o0X) {
        if (oX00o0X.IXoIo() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean IXO(OX00o0X oX00o0X) {
        if (oX00o0X.xOoIIIoXI() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean IoIOOxIIo(oIXoXx0 oixoxx0) {
        if (oixoxx0.XIo0oOXIx(BaiDu.START_TIME) == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean IoXIXo(OX00o0X oX00o0X) {
        if (oX00o0X.IoxX() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean Ix00oIoI(OX00o0X oX00o0X) {
        if (oX00o0X.IXoIo() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean IxIX0I(OX00o0X oX00o0X) {
        if (oX00o0X.XXooOOI() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean O0(oXoXxOo oxoxxoo) {
        if (oxoxxoo.getTimestamp() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean O0IxXx(OX00o0X oX00o0X) {
        if (oX00o0X.xOoIIIoXI() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean O0X(OX00o0X oX00o0X) {
        if (oX00o0X.XXooOOI() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean OIOoIIOIx(OX00o0X oX00o0X) {
        if (oX00o0X.getTimestamp() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean OX00O0xII(XIXIX xixix) {
        if (xixix.xOOxIO() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean OoO(OX00o0X oX00o0X) {
        if (oX00o0X.xOoIIIoXI() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean Ox0O(oXoXxOo oxoxxoo) {
        if (oxoxxoo.IxO0Oxo() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean XIXIX(XIXIX xixix) {
        return X0xOO.oIX0oI(xixix.x00IOx()).equals("");
    }

    public static /* synthetic */ boolean XIXIxO(OX00o0X oX00o0X) {
        if (oX00o0X.IXoIo() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean XXoOx0(OX00o0X oX00o0X) {
        if (oX00o0X.XXooOOI() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean o0oIxOo(oI00o oi00o) {
        if (oi00o.getTimestamp() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean oI(OX00o0X oX00o0X) {
        if (oX00o0X.IoxX() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean oOo(OX00o0X oX00o0X) {
        if (oX00o0X.getTimestamp() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean oOoIIO0(OX00o0X oX00o0X) {
        if (oX00o0X.IXoIo() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean oXIO0o0XI(OX00o0X oX00o0X) {
        if (oX00o0X.x0xOIoO() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean ooOx(String str, oIXoXx0 oixoxx0) {
        if (oixoxx0.oxIIX0o(str) == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean oxIIX0o(oIXoXx0 oixoxx0) {
        if (oixoxx0.XIo0oOXIx("total_elapsed_time") == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean x0(List list) {
        if (list.size() == 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean x0OIX00oO(OX00o0X oX00o0X) {
        if (oX00o0X.x0xOIoO() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ double x0OxxIOxX(String str, oIXoXx0 oixoxx0) {
        return oixoxx0.oxxXoxO(str).floatValue();
    }

    public static /* synthetic */ boolean xI0oxI00(oIXoXx0 oixoxx0) {
        if (oixoxx0.XIo0oOXIx("timestamp") == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean xOOOX(XIXIX xixix) {
        if (xixix.x00IOx() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean xOoOIoI(OX00o0X oX00o0X) {
        if (oX00o0X.xOoIIIoXI() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean xX0IIXIx0(XIXIX xixix) {
        return xixix.xOOxIO().equals((short) 0);
    }

    public static /* synthetic */ boolean xXoOI00O(String str, oIXoXx0 oixoxx0) {
        if (oixoxx0.oxxXoxO(str) == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean xoO0xx0(String str, oIXoXx0 oixoxx0) {
        if (oixoxx0.oxIIX0o(str) == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean xx0X0(oXoXxOo oxoxxoo) {
        if (oxoxxoo.oI00o() == null) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean xxOXOOoIX(OX00o0X oX00o0X) {
        if (oX00o0X.XXooOOI() == null) {
            return true;
        }
        return false;
    }

    @SafeVarargs
    public final boolean I0(List<? extends oIXoXx0>... listArr) {
        Stream stream;
        boolean anyMatch;
        stream = Arrays.stream(listArr);
        anyMatch = stream.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.XOxIOxOx
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean x02;
                x02 = OI0.x0((List) obj);
                return x02;
            }
        });
        return anyMatch;
    }

    public ActivityFileValidationResult I0X0x0oIo(int i) {
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("Lap Message Exists", ActivityFileValidationResult.Level.REQUIRED);
        if (i > 0) {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
        } else {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
        }
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult I0oOIX(List<OX00o0X> list, List<oXoXxOo> list2) {
        Stream stream;
        boolean anyMatch;
        Stream stream2;
        boolean anyMatch2;
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("Session Message First Lap Index and Num Laps are Valid", ActivityFileValidationResult.Level.REQUIRED);
        if (list.size() != 0 && list2.size() != 0) {
            stream = list.stream();
            anyMatch = stream.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.xxX
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean XIXIxO2;
                    XIXIxO2 = OI0.XIXIxO((OX00o0X) obj);
                    return XIXIxO2;
                }
            });
            stream2 = list.stream();
            anyMatch2 = stream2.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.XxX0x0xxx
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean OoO2;
                    OoO2 = OI0.OoO((OX00o0X) obj);
                    return OoO2;
                }
            });
            if (!anyMatch && !anyMatch2) {
                int i = 0;
                for (OX00o0X oX00o0X : list) {
                    if (oX00o0X.IXoIo().intValue() != i) {
                        activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
                        activityFileValidationResult.X0o0xo("One or more Session messages contains an invlaid First Lap Index value.");
                        return activityFileValidationResult;
                    }
                    i += oX00o0X.xOoIIIoXI().intValue();
                }
                if (i != list2.size()) {
                    activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
                    activityFileValidationResult.X0o0xo("Sum of Session messages Num Laps values is not equal to total number of Lap messages found in the file.");
                    return activityFileValidationResult;
                }
                activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
                return activityFileValidationResult;
            }
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
            activityFileValidationResult.X0o0xo("One or more Session messages contain a null First Lap Index value and/or null Num Lap value.");
            return activityFileValidationResult;
        }
        activityFileValidationResult.XO(ActivityFileValidationResult.Status.SKIPPED);
        activityFileValidationResult.X0o0xo("No Session messages exist and/or no Lap messages exist.");
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult I0oOoX(List<oIXoXx0> list) {
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("FileId Message Is First", ActivityFileValidationResult.Level.REQUIRED);
        Iterator<oIXoXx0> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            oIXoXx0 next = it.next();
            if (!next.x0OIX00oO().equals("pad")) {
                if (next.x0OIX00oO().equals(FontsContractCompat.Columns.FILE_ID)) {
                    activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
                } else {
                    activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
                }
            }
        }
        return activityFileValidationResult;
    }

    @Override // com.garmin.fit.XxI
    public void II0xO0(List<oIXoXx0> list) {
        oX0ooo0I0 oxoX2 = this.f15122oIX0oI.oxoX();
        this.f15121II0xO0.clear();
        this.f15121II0xO0.add(XX(oxoX2.Xx000oIo()));
        if (oxoX2.Xx000oIo().size() > 0) {
            this.f15121II0xO0.add(I0oOoX(list));
            this.f15121II0xO0.add(oxXx0IX(oxoX2.Xx000oIo().get(0)));
            this.f15121II0xO0.add(oxxXoxO(oxoX2.Xx000oIo().get(0)));
            this.f15121II0xO0.add(XoX(oxoX2.Xx000oIo().get(0)));
        }
        this.f15121II0xO0.add(Xx000oIo(oxoX2.I0Io()));
        if (oxoX2.I0Io().size() > 0) {
            this.f15121II0xO0.add(xII(oxoX2.I0Io().get(0)));
            this.f15121II0xO0.add(X00IoxXI(oxoX2.I0Io().get(0)));
            this.f15121II0xO0.add(x0o(oxoX2.I0Io().get(0), oxoX2.O0X()));
            this.f15121II0xO0.add(IO(oxoX2.I0Io().get(0), oxoX2.O0X().size()));
        }
        this.f15121II0xO0.add(XX0xXo(oxoX2.O0X().size()));
        this.f15121II0xO0.add(xoIxX(oxoX2.O0X()));
        this.f15121II0xO0.add(OO(oxoX2.O0X()));
        this.f15121II0xO0.add(XIo0oOXIx(oxoX2.O0X()));
        this.f15121II0xO0.add(I0oOIX(oxoX2.O0X(), oxoX2.I0oOIX()));
        this.f15121II0xO0.add(OO0x0xX(oxoX2.O0X(), oxoX2.I0oOIX()));
        this.f15121II0xO0.add(x0xO(oxoX2.O0X(), oxoX2.I0oOIX()));
        this.f15121II0xO0.add(xoxXI(oxoX2.O0X()));
        this.f15121II0xO0.add(IoOoo(oxoX2.O0X()));
        this.f15121II0xO0.add(xxIO(oxoX2.O0X()));
        this.f15121II0xO0.add(Ioxxx(oxoX2.O0X()));
        this.f15121II0xO0.add(I0X0x0oIo(oxoX2.I0oOIX().size()));
        this.f15121II0xO0.add(xo0x(oxoX2.I0oOIX()));
        this.f15121II0xO0.add(xXOx(oxoX2.O0X(), oxoX2.I0oOIX()));
        this.f15121II0xO0.add(XX0(oxoX2.I0oOIX()));
        this.f15121II0xO0.add(XoI0Ixx0(oxoX2.O0X(), oxoX2.I0()));
        this.f15121II0xO0.add(O0Xx(oxoX2.I0()));
        this.f15121II0xO0.add(Io(oxoX2.o00()));
        this.f15121II0xO0.add(XOxIOxOx(oxoX2.o00()));
        this.f15121II0xO0.add(OI0(oxoX2.o00()));
    }

    public List<ActivityFileValidationResult> IIxOXoOo0() {
        return Collections.unmodifiableList(this.f15121II0xO0);
    }

    public ActivityFileValidationResult IO(com.garmin.fit.X0o0xo x0o0xo, int i) {
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("Activity Message Session Count Is Equal To Actual Session Count", ActivityFileValidationResult.Level.OPTIONAL);
        if (x0o0xo.OX() == null) {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.WARNING);
            activityFileValidationResult.X0o0xo("Num Sessions is null.");
            return activityFileValidationResult;
        }
        if (x0o0xo.OX().intValue() != i) {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.WARNING);
            activityFileValidationResult.X0o0xo("Num Sessions does not match the actual number of Sessions messages found in the file.");
            return activityFileValidationResult;
        }
        activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult Io(List<XIXIX> list) {
        return oX(list, "Device Info");
    }

    public boolean IoOoX(List<? extends oIXoXx0> list, final String str) {
        Stream stream;
        boolean anyMatch;
        stream = list.stream();
        anyMatch = stream.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.XIxXXX0x0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean xoO0xx02;
                xoO0xx02 = OI0.xoO0xx0(str, (oIXoXx0) obj);
                return xoO0xx02;
            }
        });
        return anyMatch;
    }

    public ActivityFileValidationResult IoOoo(List<OX00o0X> list) {
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("Session Message Sub Sport Exists", ActivityFileValidationResult.Level.OPTIONAL);
        ActivityFileValidationResult.Status O00XxXI2 = O00XxXI(list);
        if (O00XxXI2 == ActivityFileValidationResult.Status.WARNING) {
            activityFileValidationResult.X0o0xo("One or more Session messages contain a null Sub Sport value. Set Sub Sport value to 'generic' if unknown.");
        }
        activityFileValidationResult.XO(O00XxXI2);
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult Ioxxx(List<OX00o0X> list) {
        return XI0oooXX(list, "Session");
    }

    public ActivityFileValidationResult.Status O00XxXI(List<? extends oIXoXx0> list) {
        ActivityFileValidationResult.Status o02 = o0(list, "sub_sport");
        if (o02 == ActivityFileValidationResult.Status.FAILED) {
            return ActivityFileValidationResult.Status.WARNING;
        }
        return o02;
    }

    public ActivityFileValidationResult O0Xx(List<oI00o> list) {
        Stream stream;
        boolean anyMatch;
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("Record Messages Are in Chronological Ascending Order", ActivityFileValidationResult.Level.REQUIRED);
        if (list.size() != 0) {
            stream = list.stream();
            anyMatch = stream.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.x0o
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean o0oIxOo2;
                    o0oIxOo2 = OI0.o0oIxOo((oI00o) obj);
                    return o0oIxOo2;
                }
            });
            if (anyMatch) {
                activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
                activityFileValidationResult.X0o0xo("One or more Record messages contain a null Timestamp.");
                return activityFileValidationResult;
            }
            o0xxxXXxX timestamp = list.get(0).getTimestamp();
            for (oI00o oi00o : list) {
                if (timestamp.Oxx0IOOO(oi00o.getTimestamp())) {
                    activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
                    activityFileValidationResult.X0o0xo("One or more Record messages are not sequential.");
                    return activityFileValidationResult;
                }
                timestamp = oi00o.getTimestamp();
            }
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
            return activityFileValidationResult;
        }
        activityFileValidationResult.XO(ActivityFileValidationResult.Status.SKIPPED);
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult OI0(List<XIXIX> list) {
        Stream stream;
        boolean anyMatch;
        Stream stream2;
        boolean anyMatch2;
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("Device Info Message Manufacturer Id is Valid", ActivityFileValidationResult.Level.OPTIONAL);
        if (list.size() != 0) {
            stream = list.stream();
            anyMatch = stream.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.X0IIOO
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean xOOOX2;
                    xOOOX2 = OI0.xOOOX((XIXIX) obj);
                    return xOOOX2;
                }
            });
            if (!anyMatch) {
                stream2 = list.stream();
                anyMatch2 = stream2.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.XI0IXoo
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        boolean XIXIX2;
                        XIXIX2 = OI0.XIXIX((XIXIX) obj);
                        return XIXIX2;
                    }
                });
                if (anyMatch2) {
                    activityFileValidationResult.XO(ActivityFileValidationResult.Status.WARNING);
                    activityFileValidationResult.X0o0xo("One or more Device Info messages contain an unknown Manufacturer Id.");
                    return activityFileValidationResult;
                }
                activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
                return activityFileValidationResult;
            }
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.WARNING);
            activityFileValidationResult.X0o0xo("One or more Device Info messages contain a null Manufacturer Id.");
            return activityFileValidationResult;
        }
        activityFileValidationResult.XO(ActivityFileValidationResult.Status.SKIPPED);
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult OO(List<OX00o0X> list) {
        Stream stream;
        boolean anyMatch;
        Stream stream2;
        boolean anyMatch2;
        Stream stream3;
        boolean anyMatch3;
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("Session Message Start Time Is Valid", ActivityFileValidationResult.Level.REQUIRED);
        if (list.size() != 0) {
            stream = list.stream();
            anyMatch = stream.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.ooOOo0oXI
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean OIOoIIOIx2;
                    OIOoIIOIx2 = OI0.OIOoIIOIx((OX00o0X) obj);
                    return OIOoIIOIx2;
                }
            });
            stream2 = list.stream();
            anyMatch2 = stream2.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.x0XOIxOo
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean x0OIX00oO2;
                    x0OIX00oO2 = OI0.x0OIX00oO((OX00o0X) obj);
                    return x0OIX00oO2;
                }
            });
            stream3 = list.stream();
            anyMatch3 = stream3.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.oO
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean XXoOx02;
                    XXoOx02 = OI0.XXoOx0((OX00o0X) obj);
                    return XXoOx02;
                }
            });
            if (!anyMatch && !anyMatch2 && !anyMatch3) {
                activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
                return activityFileValidationResult;
            }
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
            activityFileValidationResult.X0o0xo("One or more Session messages contain a null Start Time, Timestamp and/or a null Total Elapsed Time.");
            return activityFileValidationResult;
        }
        activityFileValidationResult.XO(ActivityFileValidationResult.Status.SKIPPED);
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult OO0x0xX(List<OX00o0X> list, List<oXoXxOo> list2) {
        Stream stream;
        boolean anyMatch;
        Stream stream2;
        boolean anyMatch2;
        Stream stream3;
        boolean anyMatch3;
        Stream stream4;
        Stream skip;
        Stream limit;
        Collector list3;
        Object collect;
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("Session Message Total Timer Time Is Equal To Sum of Lap Messages Total Timer Time", ActivityFileValidationResult.Level.REQUIRED);
        if (list.size() != 0 && list2.size() != 0) {
            stream = list.stream();
            anyMatch = stream.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.xXxxox0I
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean oI2;
                    oI2 = OI0.oI((OX00o0X) obj);
                    return oI2;
                }
            });
            if (!anyMatch) {
                stream2 = list.stream();
                anyMatch2 = stream2.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.IIX0o
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        boolean Ix00oIoI2;
                        Ix00oIoI2 = OI0.Ix00oIoI((OX00o0X) obj);
                        return Ix00oIoI2;
                    }
                });
                stream3 = list.stream();
                anyMatch3 = stream3.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.ooXIXxIX
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        boolean O0IxXx2;
                        O0IxXx2 = OI0.O0IxXx((OX00o0X) obj);
                        return O0IxXx2;
                    }
                });
                if (!anyMatch2 && !anyMatch3) {
                    for (OX00o0X oX00o0X : list) {
                        stream4 = list2.stream();
                        skip = stream4.skip(oX00o0X.IXoIo().intValue());
                        limit = skip.limit(oX00o0X.xOoIIIoXI().intValue());
                        list3 = Collectors.toList();
                        collect = limit.collect(list3);
                        activityFileValidationResult = ox(oX00o0X, (List) collect, "Session", "Lap", "total_timer_time");
                        if (activityFileValidationResult.oxoX() == ActivityFileValidationResult.Status.FAILED) {
                            break;
                        }
                    }
                    return activityFileValidationResult;
                }
                activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
                activityFileValidationResult.X0o0xo("One or more Session messages contain a null First Lap Index value and/or null Num Lap value.");
                return activityFileValidationResult;
            }
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
            return activityFileValidationResult;
        }
        activityFileValidationResult.XO(ActivityFileValidationResult.Status.SKIPPED);
        activityFileValidationResult.X0o0xo("No Session messages exist and/or no Lap messages exist.");
        return activityFileValidationResult;
    }

    public int OOXIxO0() {
        return this.f15120I0Io;
    }

    public ActivityFileValidationResult X00IoxXI(com.garmin.fit.X0o0xo x0o0xo) {
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("Activity Message Local Timestamp is Valid", ActivityFileValidationResult.Level.REQUIRED);
        if (x0o0xo.Oxx() == null) {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
            activityFileValidationResult.X0o0xo("Local Timestamp is null.");
            return activityFileValidationResult;
        }
        long longValue = x0o0xo.Oxx().longValue() - x0o0xo.getTimestamp().x0xO0oo().longValue();
        if (longValue >= -43200 && longValue <= 50400) {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
        } else {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
            activityFileValidationResult.X0o0xo("Local Timestamp is not within the tolerated range of [-12,14] hours.");
        }
        return activityFileValidationResult;
    }

    public void X0xII0I() {
        II0xO0(new ArrayList());
    }

    public ActivityFileValidationResult XI0oooXX(List<? extends oIXoXx0> list, String str) {
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult(str + " Message Valid Message Index", ActivityFileValidationResult.Level.REQUIRED);
        if (list.size() == 0) {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.SKIPPED);
            return activityFileValidationResult;
        }
        for (int i = 0; i < list.size(); i++) {
            Integer oX2 = list.get(i).oX(254, 0, 65535);
            if (oX2 == null) {
                activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
                activityFileValidationResult.X0o0xo("One or more " + str + " messages contain a null Message Index value.");
                return activityFileValidationResult;
            }
            if (oX2.intValue() != i) {
                activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
                activityFileValidationResult.X0o0xo("Message Indexes are not sequential.");
                return activityFileValidationResult;
            }
        }
        activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult XIo0oOXIx(List<OX00o0X> list) {
        Stream stream;
        boolean anyMatch;
        Stream stream2;
        boolean anyMatch2;
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("Session Message Total Timer Time and Total Elapsed Time are Valid", ActivityFileValidationResult.Level.REQUIRED);
        if (list.size() != 0) {
            stream = list.stream();
            anyMatch = stream.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.xI
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean IoXIXo2;
                    IoXIXo2 = OI0.IoXIXo((OX00o0X) obj);
                    return IoXIXo2;
                }
            });
            stream2 = list.stream();
            anyMatch2 = stream2.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.oo0xXOI0I
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean xxOXOOoIX2;
                    xxOXOOoIX2 = OI0.xxOXOOoIX((OX00o0X) obj);
                    return xxOXOOoIX2;
                }
            });
            if (!anyMatch && !anyMatch2) {
                for (OX00o0X oX00o0X : list) {
                    if (oX00o0X.XXooOOI().floatValue() < oX00o0X.IoxX().floatValue()) {
                        activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
                        activityFileValidationResult.X0o0xo("Session message Total Timer Time " + oX00o0X.IoxX() + " >  Total Elapsed Time" + oX00o0X.XXooOOI() + FileUtils.FILE_EXTENSION_SEPARATOR);
                        return activityFileValidationResult;
                    }
                }
                activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
                return activityFileValidationResult;
            }
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
            activityFileValidationResult.X0o0xo("One or more Session messages contain a null Start Time and/or a null Timestamp.");
            return activityFileValidationResult;
        }
        activityFileValidationResult.XO(ActivityFileValidationResult.Status.SKIPPED);
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult XOxIOxOx(List<XIXIX> list) {
        Stream stream;
        boolean anyMatch;
        Stream stream2;
        boolean anyMatch2;
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("Device Info Message Device Index is Valid", ActivityFileValidationResult.Level.REQUIRED);
        if (list.size() != 0) {
            stream = list.stream();
            anyMatch = stream.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.x0xO0oo
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean OX00O0xII2;
                    OX00O0xII2 = OI0.OX00O0xII((XIXIX) obj);
                    return OX00O0xII2;
                }
            });
            if (!anyMatch) {
                stream2 = list.stream();
                anyMatch2 = stream2.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.IXxxXO
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        boolean xX0IIXIx02;
                        xX0IIXIx02 = OI0.xX0IIXIx0((XIXIX) obj);
                        return xX0IIXIx02;
                    }
                });
                if (!anyMatch2) {
                    activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
                    activityFileValidationResult.X0o0xo("At least one Device Info message Device Index field needs to be set to Creator.");
                    return activityFileValidationResult;
                }
                activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
                return activityFileValidationResult;
            }
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
            activityFileValidationResult.X0o0xo("One or more Device Info messages contain a null Device Index value.");
            return activityFileValidationResult;
        }
        activityFileValidationResult.XO(ActivityFileValidationResult.Status.SKIPPED);
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult XX(List<xOOxIO> list) {
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("FileId Message Exists", ActivityFileValidationResult.Level.REQUIRED);
        if (list.size() > 0) {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
        } else {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
        }
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult XX0(List<oXoXxOo> list) {
        return Xo0(list, "Lap");
    }

    public ActivityFileValidationResult XX0xXo(int i) {
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("Session Message Exists", ActivityFileValidationResult.Level.REQUIRED);
        if (i > 0) {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
        } else {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
        }
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult Xo0(List<? extends oIXoXx0> list, String str) {
        Stream stream;
        boolean anyMatch;
        Stream stream2;
        boolean anyMatch2;
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult(str + " Message Are Sequential and Abut", ActivityFileValidationResult.Level.REQUIRED);
        if (list.size() > 1) {
            stream = list.stream();
            anyMatch = stream.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.IO
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean IoIOOxIIo2;
                    IoIOOxIIo2 = OI0.IoIOOxIIo((oIXoXx0) obj);
                    return IoIOOxIIo2;
                }
            });
            stream2 = list.stream();
            anyMatch2 = stream2.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.xII
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean oxIIX0o2;
                    oxIIX0o2 = OI0.oxIIX0o((oIXoXx0) obj);
                    return oxIIX0o2;
                }
            });
            if (!anyMatch && !anyMatch2) {
                long longValue = oOXoIIIo(list.get(0)).longValue();
                for (oIXoXx0 oixoxx0 : list.subList(1, list.size())) {
                    if (Math.abs(oixoxx0.XIo0oOXIx(BaiDu.START_TIME).longValue() - longValue) > 2) {
                        activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
                        activityFileValidationResult.X0o0xo(str + " messages are not sequential, or do not abut.");
                        return activityFileValidationResult;
                    }
                    longValue = oOXoIIIo(oixoxx0).longValue();
                }
                activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
                return activityFileValidationResult;
            }
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
            activityFileValidationResult.X0o0xo("One or more " + str + " messages contain a null Start Time and/or a null Total Elapsed Time.");
            return activityFileValidationResult;
        }
        activityFileValidationResult.XO(ActivityFileValidationResult.Status.SKIPPED);
        activityFileValidationResult.X0o0xo("Check requires two or more " + str + " messages, found " + list.size() + FileUtils.FILE_EXTENSION_SEPARATOR);
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult XoI0Ixx0(List<OX00o0X> list, List<oI00o> list2) {
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("Record Message Timestamps Fall Within Session Message Times", ActivityFileValidationResult.Level.REQUIRED);
        if (list.size() != 0 && list2.size() != 0) {
            o0xxxXXxX x0xOIoO2 = list.get(0).x0xOIoO();
            Long oOXoIIIo2 = oOXoIIIo(list.get(list.size() - 1));
            if (x0xOIoO2 != null && oOXoIIIo2 != null) {
                o0xxxXXxX timestamp = list2.get(0).getTimestamp();
                o0xxxXXxX timestamp2 = list2.get(list2.size() - 1).getTimestamp();
                if (timestamp != null && timestamp2 != null) {
                    if (timestamp.x0xO0oo().longValue() - x0xOIoO2.x0xO0oo().longValue() < -1) {
                        activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
                        activityFileValidationResult.X0o0xo("One or more Record message Timestamps is earlier than Session Start Time.");
                        return activityFileValidationResult;
                    }
                    if (timestamp2.x0xO0oo().longValue() - oOXoIIIo2.longValue() > 1) {
                        activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
                        activityFileValidationResult.X0o0xo("One or more Record message Timestamps is later than Session 'End Time'.");
                        return activityFileValidationResult;
                    }
                    activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
                    return activityFileValidationResult;
                }
                activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
                activityFileValidationResult.X0o0xo("One or more Record messages contain a null Timestamp.");
                return activityFileValidationResult;
            }
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
            activityFileValidationResult.X0o0xo("One or more Session Messages contain a null Start Time and/or a null 'End Time'.");
            return activityFileValidationResult;
        }
        activityFileValidationResult.XO(ActivityFileValidationResult.Status.SKIPPED);
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult XoX(xOOxIO xooxio) {
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("FileId Message Time Created Exists", ActivityFileValidationResult.Level.REQUIRED);
        if (xooxio.OIx00oxx() == null) {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
            activityFileValidationResult.X0o0xo("Time Created is null.");
        } else {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
        }
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult Xx000oIo(List<com.garmin.fit.X0o0xo> list) {
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("Activity Message Exists", ActivityFileValidationResult.Level.REQUIRED);
        if (list.size() > 0) {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
        } else {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
        }
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult.Status o0(List<? extends oIXoXx0> list, String str) {
        if (list.size() == 0) {
            return ActivityFileValidationResult.Status.SKIPPED;
        }
        if (IoOoX(list, str)) {
            return ActivityFileValidationResult.Status.FAILED;
        }
        return ActivityFileValidationResult.Status.PASSED;
    }

    public ActivityFileValidationResult.Status o0xxxXXxX(List<? extends oIXoXx0> list) {
        ActivityFileValidationResult.Status o02 = o0(list, "sport");
        if (o02 == ActivityFileValidationResult.Status.FAILED) {
            return ActivityFileValidationResult.Status.WARNING;
        }
        return o02;
    }

    @Override // com.garmin.fit.XxI
    public void oIX0oI(oIXoXx0 oixoxx0) {
        this.f15122oIX0oI.II0xO0(oixoxx0);
        this.f15120I0Io++;
    }

    public Long oOXoIIIo(oIXoXx0 oixoxx0) {
        try {
            return Long.valueOf(oixoxx0.XIo0oOXIx(BaiDu.START_TIME).longValue() + oixoxx0.XIo0oOXIx("total_elapsed_time").longValue());
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public ActivityFileValidationResult oX(List<? extends oIXoXx0> list, String str) {
        Stream stream;
        boolean anyMatch;
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult(str + " Message Timestamps are Valid", ActivityFileValidationResult.Level.REQUIRED);
        if (list.size() != 0) {
            stream = list.stream();
            anyMatch = stream.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.oOoXoXO
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean xI0oxI002;
                    xI0oxI002 = OI0.xI0oxI00((oIXoXx0) obj);
                    return xI0oxI002;
                }
            });
            if (anyMatch) {
                activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
                activityFileValidationResult.X0o0xo("One or more " + str + " messages contain a null Timestamp.");
                return activityFileValidationResult;
            }
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
            return activityFileValidationResult;
        }
        activityFileValidationResult.XO(ActivityFileValidationResult.Status.SKIPPED);
        return activityFileValidationResult;
    }

    public boolean oo(List<? extends oIXoXx0> list, final String str) {
        Stream stream;
        boolean allMatch;
        stream = list.stream();
        allMatch = stream.allMatch(new Predicate() { // from class: com.garmin.fit.plugins.X00IoxXI
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean ooOx2;
                ooOx2 = OI0.ooOx(str, (oIXoXx0) obj);
                return ooOx2;
            }
        });
        return allMatch;
    }

    public ActivityFileValidationResult ox(oIXoXx0 oixoxx0, List<? extends oIXoXx0> list, String str, String str2, final String str3) {
        Stream stream;
        boolean anyMatch;
        Stream stream2;
        DoubleStream mapToDouble;
        double sum;
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult(str + " Message " + str3 + " is Equal to the Sum of " + str2 + " Messages " + str3 + " Values", ActivityFileValidationResult.Level.REQUIRED);
        if (list.size() == 0) {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.SKIPPED);
            return activityFileValidationResult;
        }
        if (oixoxx0.oxxXoxO(str3) != null) {
            stream = list.stream();
            anyMatch = stream.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.xoIox
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean xXoOI00O2;
                    xXoOI00O2 = OI0.xXoOI00O(str3, (oIXoXx0) obj);
                    return xXoOI00O2;
                }
            });
            if (!anyMatch) {
                stream2 = list.stream();
                mapToDouble = stream2.mapToDouble(new ToDoubleFunction() { // from class: com.garmin.fit.plugins.OOXIXo
                    @Override // java.util.function.ToDoubleFunction
                    public final double applyAsDouble(Object obj) {
                        double x0OxxIOxX2;
                        x0OxxIOxX2 = OI0.x0OxxIOxX(str3, (oIXoXx0) obj);
                        return x0OxxIOxX2;
                    }
                });
                sum = mapToDouble.sum();
                if (Math.abs(oixoxx0.oxxXoxO(str3).floatValue() - sum) > 1.0d) {
                    activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
                    activityFileValidationResult.X0o0xo(str + " message " + str3 + " does not equal the sum of " + str2 + " messages " + str3 + " values.");
                    return activityFileValidationResult;
                }
                activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
                return activityFileValidationResult;
            }
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
            activityFileValidationResult.X0o0xo(str2 + "Message contains a null " + str3 + " value.");
            return activityFileValidationResult;
        }
        activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
        activityFileValidationResult.X0o0xo(str + " Message contains a null " + str3);
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult oxXx0IX(xOOxIO xooxio) {
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("FileId Message Type Is Activity", ActivityFileValidationResult.Level.REQUIRED);
        if (xooxio.xIXX() == File.ACTIVITY) {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
        } else {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
            activityFileValidationResult.X0o0xo("Expected Type: Activity, actual Type: " + xooxio.xIXX() + FileUtils.FILE_EXTENSION_SEPARATOR);
        }
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult oxxXoxO(xOOxIO xooxio) {
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("FileId Message Manufacturer Id Exists", ActivityFileValidationResult.Level.REQUIRED);
        if (xooxio.oXIoO() == null) {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
            activityFileValidationResult.X0o0xo("Manufacturer Id is null.");
            return activityFileValidationResult;
        }
        if (X0xOO.oIX0oI(xooxio.oXIoO()).equals("")) {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.WARNING);
            activityFileValidationResult.X0o0xo("Unknown Manufacturer Id " + xooxio.oXIoO() + FileUtils.FILE_EXTENSION_SEPARATOR);
            return activityFileValidationResult;
        }
        activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult x0o(com.garmin.fit.X0o0xo x0o0xo, List<OX00o0X> list) {
        return ox(x0o0xo, list, "Activity", "Session", "total_timer_time");
    }

    public ActivityFileValidationResult x0xO(List<OX00o0X> list, List<oXoXxOo> list2) {
        Stream stream;
        boolean anyMatch;
        Stream stream2;
        boolean anyMatch2;
        Stream stream3;
        boolean anyMatch3;
        Stream stream4;
        Stream skip;
        Stream limit;
        Collector list3;
        Object collect;
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("Session Message Total Elapsed Time Is Equal To Sum of Lap Messages Total Elapsed Time", ActivityFileValidationResult.Level.REQUIRED);
        if (list.size() != 0 && list2.size() != 0) {
            stream = list.stream();
            anyMatch = stream.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.IoOoX
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean IxIX0I2;
                    IxIX0I2 = OI0.IxIX0I((OX00o0X) obj);
                    return IxIX0I2;
                }
            });
            if (!anyMatch) {
                stream2 = list.stream();
                anyMatch2 = stream2.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.oOXoIIIo
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        boolean oOoIIO02;
                        oOoIIO02 = OI0.oOoIIO0((OX00o0X) obj);
                        return oOoIIO02;
                    }
                });
                stream3 = list.stream();
                anyMatch3 = stream3.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.Xx000oIo
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        boolean IXO2;
                        IXO2 = OI0.IXO((OX00o0X) obj);
                        return IXO2;
                    }
                });
                if (!anyMatch2 && !anyMatch3) {
                    for (OX00o0X oX00o0X : list) {
                        stream4 = list2.stream();
                        skip = stream4.skip(oX00o0X.IXoIo().intValue());
                        limit = skip.limit(oX00o0X.xOoIIIoXI().intValue());
                        list3 = Collectors.toList();
                        collect = limit.collect(list3);
                        activityFileValidationResult = ox(oX00o0X, (List) collect, "Session", "Lap", "total_elapsed_time");
                        if (activityFileValidationResult.oxoX() == ActivityFileValidationResult.Status.FAILED) {
                            break;
                        }
                    }
                    return activityFileValidationResult;
                }
                activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
                activityFileValidationResult.X0o0xo("One or more Session messages contain a null First Lap Index value and/or null Num Lap value.");
                return activityFileValidationResult;
            }
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
            return activityFileValidationResult;
        }
        activityFileValidationResult.XO(ActivityFileValidationResult.Status.SKIPPED);
        activityFileValidationResult.X0o0xo("No Session messages exist and/or no Lap messages exist.");
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult xII(com.garmin.fit.X0o0xo x0o0xo) {
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("Activity Message Timestamp Exists", ActivityFileValidationResult.Level.REQUIRED);
        if (x0o0xo.getTimestamp() == null) {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
            activityFileValidationResult.X0o0xo("Timestamp is null.");
        } else {
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
        }
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult xXOx(List<OX00o0X> list, List<oXoXxOo> list2) {
        Stream stream;
        boolean anyMatch;
        Stream stream2;
        boolean anyMatch2;
        Stream stream3;
        boolean anyMatch3;
        Stream stream4;
        boolean anyMatch4;
        Stream stream5;
        boolean anyMatch5;
        Stream stream6;
        boolean anyMatch6;
        Stream stream7;
        boolean anyMatch7;
        Stream stream8;
        boolean anyMatch8;
        Stream stream9;
        Stream skip;
        Stream limit;
        Collector list3;
        Object collect;
        boolean z;
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("Lap Message Start Time and Timestamp are Valid", ActivityFileValidationResult.Level.REQUIRED);
        if (list.size() != 0 && list2.size() != 0) {
            stream = list.stream();
            anyMatch = stream.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.xoXoI
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean oXIO0o0XI2;
                    oXIO0o0XI2 = OI0.oXIO0o0XI((OX00o0X) obj);
                    return oXIO0o0XI2;
                }
            });
            stream2 = list.stream();
            anyMatch2 = stream2.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.OxI
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean oOo2;
                    oOo2 = OI0.oOo((OX00o0X) obj);
                    return oOo2;
                }
            });
            stream3 = list.stream();
            anyMatch3 = stream3.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.O0xOxO
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean O0X2;
                    O0X2 = OI0.O0X((OX00o0X) obj);
                    return O0X2;
                }
            });
            if (!anyMatch && !anyMatch2 && !anyMatch3) {
                stream4 = list.stream();
                anyMatch4 = stream4.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.Oxx0xo
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        boolean IIX02;
                        IIX02 = OI0.IIX0((OX00o0X) obj);
                        return IIX02;
                    }
                });
                stream5 = list.stream();
                anyMatch5 = stream5.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.oI0IIXIo
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        boolean xOoOIoI2;
                        xOoOIoI2 = OI0.xOoOIoI((OX00o0X) obj);
                        return xOoOIoI2;
                    }
                });
                if (!anyMatch4 && !anyMatch5) {
                    stream6 = list2.stream();
                    anyMatch6 = stream6.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.OxxIIOOXO
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            boolean Ox0O2;
                            Ox0O2 = OI0.Ox0O((oXoXxOo) obj);
                            return Ox0O2;
                        }
                    });
                    stream7 = list2.stream();
                    anyMatch7 = stream7.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.IIXOooo
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            boolean O02;
                            O02 = OI0.O0((oXoXxOo) obj);
                            return O02;
                        }
                    });
                    stream8 = list2.stream();
                    anyMatch8 = stream8.anyMatch(new Predicate() { // from class: com.garmin.fit.plugins.o00
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            boolean xx0X02;
                            xx0X02 = OI0.xx0X0((oXoXxOo) obj);
                            return xx0X02;
                        }
                    });
                    if (!anyMatch6 && !anyMatch7 && !anyMatch8) {
                        for (OX00o0X oX00o0X : list) {
                            stream9 = list2.stream();
                            skip = stream9.skip(oX00o0X.IXoIo().intValue());
                            limit = skip.limit(oX00o0X.xOoIIIoXI().intValue());
                            list3 = Collectors.toList();
                            collect = limit.collect(list3);
                            for (oXoXxOo oxoxxoo : (List) collect) {
                                boolean II0XooXoX2 = oxoxxoo.IxO0Oxo().II0XooXoX(oX00o0X.x0xOIoO());
                                if (oOXoIIIo(oxoxxoo).longValue() - oOXoIIIo(oX00o0X).longValue() > 1) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (II0XooXoX2 || z) {
                                    activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
                                    activityFileValidationResult.X0o0xo("One or more Lap messages contain an incorrect Start Time and/or an incorrect 'End Time' relative to the Session message.");
                                    return activityFileValidationResult;
                                }
                            }
                        }
                        activityFileValidationResult.XO(ActivityFileValidationResult.Status.PASSED);
                        return activityFileValidationResult;
                    }
                    activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
                    activityFileValidationResult.X0o0xo("One or more Lap messages contain a null Start Time, Total Elapsed Time and/or a null Timestamp.");
                    return activityFileValidationResult;
                }
                activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
                activityFileValidationResult.X0o0xo("One or more Session messages contain a null First Lap Index value and/or a null Num Lap value.");
                return activityFileValidationResult;
            }
            activityFileValidationResult.XO(ActivityFileValidationResult.Status.FAILED);
            activityFileValidationResult.X0o0xo("One or more Session messages contain a null Start Time, Timestamp and/or null Total Elapsed Time.");
            return activityFileValidationResult;
        }
        activityFileValidationResult.XO(ActivityFileValidationResult.Status.SKIPPED);
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult xo0x(List<oXoXxOo> list) {
        return XI0oooXX(list, "Lap");
    }

    public ActivityFileValidationResult xoIxX(List<OX00o0X> list) {
        return oX(list, "Session");
    }

    public ActivityFileValidationResult xoxXI(List<OX00o0X> list) {
        ActivityFileValidationResult activityFileValidationResult = new ActivityFileValidationResult("Session Message Sport Exists", ActivityFileValidationResult.Level.REQUIRED);
        ActivityFileValidationResult.Status o02 = o0(list, "sport");
        if (o02 == ActivityFileValidationResult.Status.FAILED) {
            activityFileValidationResult.X0o0xo("One or more Session messages contain a null Sport value.");
        }
        activityFileValidationResult.XO(o02);
        return activityFileValidationResult;
    }

    public ActivityFileValidationResult xxIO(List<OX00o0X> list) {
        return Xo0(list, "Session");
    }
}
