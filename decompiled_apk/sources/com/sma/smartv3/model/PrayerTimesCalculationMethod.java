package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.batoulapps.adhan2.Madhab;
import com.batoulapps.adhan2.model.Rounding;
import com.goodix.ble.gr.libdfu.task.sub.ResultCode;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import ooXIXxIX.I0Io;

/* loaded from: classes12.dex */
public final class PrayerTimesCalculationMethod implements Serializable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    private final double fajrAngle;
    private final double ishaAngle;
    private final int method;

    @OOXIXo
    private final String name;

    @XX({"SMAP\nPrayerTimes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PrayerTimes.kt\ncom/sma/smartv3/model/PrayerTimesCalculationMethod$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,413:1\n1#2:414\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final String getMethodName(int i) {
            Object obj;
            String name;
            Iterator<T> it = getMethods().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((PrayerTimesCalculationMethod) obj).getMethod() == i) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            PrayerTimesCalculationMethod prayerTimesCalculationMethod = (PrayerTimesCalculationMethod) obj;
            if (prayerTimesCalculationMethod == null || (name = prayerTimesCalculationMethod.getName()) == null) {
                return "";
            }
            return name;
        }

        @OOXIXo
        public final com.batoulapps.adhan2.oIX0oI getMethodParameters(@OOXIXo PrayerTimeSettings prayerTimeSettings) {
            Madhab madhab;
            IIX0o.x0xO0oo(prayerTimeSettings, "prayerTimeSettings");
            if (prayerTimeSettings.getArsJuristicMethod() != 0) {
                madhab = Madhab.HANAFI;
            } else {
                madhab = Madhab.SHAFI;
            }
            Madhab madhab2 = madhab;
            switch (prayerTimeSettings.getCalculationMethod()) {
                case 0:
                    return new com.batoulapps.adhan2.oIX0oI(18.0d, 17.0d, 0, null, madhab2, null, null, new I0Io(prayerTimeSettings.getFajrAdjustment(), prayerTimeSettings.getSunriseAdjustment(), prayerTimeSettings.getDhuhrAdjustment() + 1, prayerTimeSettings.getAsrAdjustment(), prayerTimeSettings.getMaghribAdjustment(), prayerTimeSettings.getIshaAdjustment()), null, null, ResultCode.SEND_CMD_FAILD, null);
                case 1:
                    return new com.batoulapps.adhan2.oIX0oI(19.5d, 17.5d, 0, null, madhab2, null, null, new I0Io(prayerTimeSettings.getFajrAdjustment(), prayerTimeSettings.getSunriseAdjustment(), prayerTimeSettings.getDhuhrAdjustment() + 1, prayerTimeSettings.getAsrAdjustment(), prayerTimeSettings.getMaghribAdjustment(), prayerTimeSettings.getIshaAdjustment()), null, null, ResultCode.SEND_CMD_FAILD, null);
                case 2:
                    return new com.batoulapps.adhan2.oIX0oI(18.0d, 18.0d, 0, null, madhab2, null, null, new I0Io(prayerTimeSettings.getFajrAdjustment(), prayerTimeSettings.getSunriseAdjustment(), prayerTimeSettings.getDhuhrAdjustment() + 1, prayerTimeSettings.getAsrAdjustment(), prayerTimeSettings.getMaghribAdjustment(), prayerTimeSettings.getIshaAdjustment()), null, null, ResultCode.SEND_CMD_FAILD, null);
                case 3:
                    return new com.batoulapps.adhan2.oIX0oI(18.5d, XIXIX.OOXIXo.f3760XO, 90, null, madhab2, null, null, new I0Io(prayerTimeSettings.getFajrAdjustment(), prayerTimeSettings.getSunriseAdjustment(), prayerTimeSettings.getDhuhrAdjustment(), prayerTimeSettings.getAsrAdjustment(), prayerTimeSettings.getMaghribAdjustment(), prayerTimeSettings.getIshaAdjustment()), null, null, 874, null);
                case 4:
                    return new com.batoulapps.adhan2.oIX0oI(18.2d, 18.2d, 0, null, madhab2, null, null, new I0Io(prayerTimeSettings.getFajrAdjustment(), prayerTimeSettings.getSunriseAdjustment() - 3, prayerTimeSettings.getDhuhrAdjustment() + 3, prayerTimeSettings.getAsrAdjustment() + 3, prayerTimeSettings.getMaghribAdjustment() + 3, prayerTimeSettings.getIshaAdjustment()), null, null, ResultCode.SEND_CMD_FAILD, null);
                case 5:
                    return new com.batoulapps.adhan2.oIX0oI(18.0d, 18.0d, 0, null, madhab2, null, null, new I0Io(prayerTimeSettings.getFajrAdjustment(), prayerTimeSettings.getSunriseAdjustment(), prayerTimeSettings.getDhuhrAdjustment() + 5, prayerTimeSettings.getAsrAdjustment(), prayerTimeSettings.getMaghribAdjustment() + 3, prayerTimeSettings.getIshaAdjustment()), null, null, ResultCode.SEND_CMD_FAILD, null);
                case 6:
                    return new com.batoulapps.adhan2.oIX0oI(15.0d, 15.0d, 0, null, madhab2, null, null, new I0Io(prayerTimeSettings.getFajrAdjustment(), prayerTimeSettings.getSunriseAdjustment(), prayerTimeSettings.getDhuhrAdjustment() + 1, prayerTimeSettings.getAsrAdjustment(), prayerTimeSettings.getMaghribAdjustment(), prayerTimeSettings.getIshaAdjustment()), null, null, ResultCode.SEND_CMD_FAILD, null);
                case 7:
                    return new com.batoulapps.adhan2.oIX0oI(18.0d, 17.5d, 0, null, madhab2, null, null, new I0Io(prayerTimeSettings.getFajrAdjustment(), prayerTimeSettings.getSunriseAdjustment(), prayerTimeSettings.getDhuhrAdjustment(), prayerTimeSettings.getAsrAdjustment(), prayerTimeSettings.getMaghribAdjustment(), prayerTimeSettings.getIshaAdjustment()), null, null, ResultCode.SEND_CMD_FAILD, null);
                case 8:
                    return new com.batoulapps.adhan2.oIX0oI(18.0d, XIXIX.OOXIXo.f3760XO, 90, null, madhab2, null, null, new I0Io(prayerTimeSettings.getFajrAdjustment(), prayerTimeSettings.getSunriseAdjustment(), prayerTimeSettings.getDhuhrAdjustment(), prayerTimeSettings.getAsrAdjustment(), prayerTimeSettings.getMaghribAdjustment(), prayerTimeSettings.getIshaAdjustment()), null, null, 874, null);
                case 9:
                    return new com.batoulapps.adhan2.oIX0oI(20.0d, 18.0d, 0, null, madhab2, null, null, new I0Io(prayerTimeSettings.getFajrAdjustment(), prayerTimeSettings.getSunriseAdjustment(), prayerTimeSettings.getDhuhrAdjustment() + 1, prayerTimeSettings.getAsrAdjustment(), prayerTimeSettings.getMaghribAdjustment(), prayerTimeSettings.getIshaAdjustment()), Rounding.UP, null, 620, null);
                case 10:
                    return new com.batoulapps.adhan2.oIX0oI(18.0d, 17.0d, 0, null, madhab2, null, null, new I0Io(prayerTimeSettings.getFajrAdjustment(), prayerTimeSettings.getSunriseAdjustment() - 7, prayerTimeSettings.getDhuhrAdjustment() + 5, prayerTimeSettings.getAsrAdjustment() + 4, prayerTimeSettings.getMaghribAdjustment() + 7, prayerTimeSettings.getIshaAdjustment()), null, null, ResultCode.SEND_CMD_FAILD, null);
                case 11:
                default:
                    return new com.batoulapps.adhan2.oIX0oI(XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, 0, null, madhab2, null, null, new I0Io(prayerTimeSettings.getFajrAdjustment(), prayerTimeSettings.getSunriseAdjustment(), prayerTimeSettings.getDhuhrAdjustment(), prayerTimeSettings.getAsrAdjustment(), prayerTimeSettings.getMaghribAdjustment(), prayerTimeSettings.getIshaAdjustment()), null, null, ResultCode.SEND_CMD_FAILD, null);
                case 12:
                    return new com.batoulapps.adhan2.oIX0oI(20.0d, 18.0d, 0, null, madhab2, null, null, new I0Io(prayerTimeSettings.getFajrAdjustment() + 1, prayerTimeSettings.getSunriseAdjustment(), prayerTimeSettings.getDhuhrAdjustment(), prayerTimeSettings.getAsrAdjustment(), prayerTimeSettings.getMaghribAdjustment(), prayerTimeSettings.getIshaAdjustment()), null, null, ResultCode.SEND_CMD_FAILD, null);
            }
        }

        @OOXIXo
        public final List<PrayerTimesCalculationMethod> getMethods() {
            return CollectionsKt__CollectionsKt.Oxx0xo(new PrayerTimesCalculationMethod(0, "Muslim World League", 18.0d, 17.0d), new PrayerTimesCalculationMethod(12, "Sihat/Kemenag", 20.0d, 18.0d), new PrayerTimesCalculationMethod(1, "Egyptian", 19.5d, 17.5d), new PrayerTimesCalculationMethod(2, "Karachi", 18.0d, 18.0d), new PrayerTimesCalculationMethod(3, "Umm al-Qura", 18.5d, 90.0d), new PrayerTimesCalculationMethod(4, "Dubai", 18.2d, 18.2d), new PrayerTimesCalculationMethod(5, "Moon Sighting Committee", 18.0d, 18.0d), new PrayerTimesCalculationMethod(6, "North America", 15.0d, 15.0d), new PrayerTimesCalculationMethod(7, "Kuwait", 18.0d, 17.5d), new PrayerTimesCalculationMethod(8, "Qatar", 18.0d, 18.0d), new PrayerTimesCalculationMethod(9, "Singapore", 20.0d, 18.0d), new PrayerTimesCalculationMethod(10, "Turkey", 18.0d, 17.0d), new PrayerTimesCalculationMethod(11, "Other", XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO));
        }

        private Companion() {
        }
    }

    public PrayerTimesCalculationMethod() {
        this(0, null, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, 15, null);
    }

    public static /* synthetic */ PrayerTimesCalculationMethod copy$default(PrayerTimesCalculationMethod prayerTimesCalculationMethod, int i, String str, double d, double d2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = prayerTimesCalculationMethod.method;
        }
        if ((i2 & 2) != 0) {
            str = prayerTimesCalculationMethod.name;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            d = prayerTimesCalculationMethod.fajrAngle;
        }
        double d3 = d;
        if ((i2 & 8) != 0) {
            d2 = prayerTimesCalculationMethod.ishaAngle;
        }
        return prayerTimesCalculationMethod.copy(i, str2, d3, d2);
    }

    public final int component1() {
        return this.method;
    }

    @OOXIXo
    public final String component2() {
        return this.name;
    }

    public final double component3() {
        return this.fajrAngle;
    }

    public final double component4() {
        return this.ishaAngle;
    }

    @OOXIXo
    public final PrayerTimesCalculationMethod copy(int i, @OOXIXo String name, double d, double d2) {
        IIX0o.x0xO0oo(name, "name");
        return new PrayerTimesCalculationMethod(i, name, d, d2);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrayerTimesCalculationMethod)) {
            return false;
        }
        PrayerTimesCalculationMethod prayerTimesCalculationMethod = (PrayerTimesCalculationMethod) obj;
        return this.method == prayerTimesCalculationMethod.method && IIX0o.Oxx0IOOO(this.name, prayerTimesCalculationMethod.name) && Double.compare(this.fajrAngle, prayerTimesCalculationMethod.fajrAngle) == 0 && Double.compare(this.ishaAngle, prayerTimesCalculationMethod.ishaAngle) == 0;
    }

    public final double getFajrAngle() {
        return this.fajrAngle;
    }

    public final double getIshaAngle() {
        return this.ishaAngle;
    }

    public final int getMethod() {
        return this.method;
    }

    @OOXIXo
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((((this.method * 31) + this.name.hashCode()) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.fajrAngle)) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.ishaAngle);
    }

    @OOXIXo
    public String toString() {
        return "PrayerTimesCalculationMethod(method=" + this.method + ", name=" + this.name + ", fajrAngle=" + this.fajrAngle + ", ishaAngle=" + this.ishaAngle + HexStringBuilder.COMMENT_END_CHAR;
    }

    public PrayerTimesCalculationMethod(int i, @OOXIXo String name, double d, double d2) {
        IIX0o.x0xO0oo(name, "name");
        this.method = i;
        this.name = name;
        this.fajrAngle = d;
        this.ishaAngle = d2;
    }

    public /* synthetic */ PrayerTimesCalculationMethod(int i, String str, double d, double d2, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? 0.0d : d, (i2 & 8) == 0 ? d2 : XIXIX.OOXIXo.f3760XO);
    }
}
