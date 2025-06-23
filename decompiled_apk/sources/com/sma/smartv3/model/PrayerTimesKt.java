package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.batoulapps.adhan2.II0xO0;
import com.garmin.fit.xxXXXxIxo;
import com.szabh.smable3.entity.BlePrayerTimes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import xI.I0Io;

@XX({"SMAP\nPrayerTimes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PrayerTimes.kt\ncom/sma/smartv3/model/PrayerTimesKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,413:1\n1855#2:414\n1855#2,2:415\n1856#2:417\n*S KotlinDebug\n*F\n+ 1 PrayerTimes.kt\ncom/sma/smartv3/model/PrayerTimesKt\n*L\n368#1:414\n370#1:415,2\n368#1:417\n*E\n"})
/* loaded from: classes12.dex */
public final class PrayerTimesKt {

    /* loaded from: classes12.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PrayTimeType.values().length];
            try {
                iArr[PrayTimeType.FAJR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrayTimeType.SUNRISE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PrayTimeType.DHUHR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PrayTimeType.ASR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PrayTimeType.MAGHRIB.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PrayTimeType.ISHA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @OOXIXo
    public static final List<PrayerTime> getPrayerTime(@OOXIXo PrayerTimeSettings prayerTimeSettings, double d, double d2, long j) {
        IIX0o.x0xO0oo(prayerTimeSettings, "prayerTimeSettings");
        try {
            II0xO0 iI0xO0 = new II0xO0(new ooXIXxIX.II0xO0(d, d2), I0Io.f34110oxoX.oIX0oI(IOI.IIX0o.Companion.II0xO0(j)), PrayerTimesCalculationMethod.Companion.getMethodParameters(prayerTimeSettings));
            return CollectionsKt__CollectionsKt.X00IoxXI(new PrayerTime(PrayTimeType.FAJR, iI0xO0.x0XOIxOo().x0xO0oo()), new PrayerTime(PrayTimeType.SUNRISE, iI0xO0.Oo().x0xO0oo()), new PrayerTime(PrayTimeType.DHUHR, iI0xO0.ooOOo0oXI().x0xO0oo()), new PrayerTime(PrayTimeType.ASR, iI0xO0.xxIXOIIO().x0xO0oo()), new PrayerTime(PrayTimeType.MAGHRIB, iI0xO0.x0xO0oo().x0xO0oo()), new PrayerTime(PrayTimeType.ISHA, iI0xO0.oO().x0xO0oo()));
        } catch (Exception e) {
            e.printStackTrace();
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("getPrayerTime -> error: " + e.getMessage());
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
    }

    @OOXIXo
    public static final Map<Long, List<PrayerTime>> getPrayerTimeMap(@OOXIXo PrayerTimeSettings prayerTimeSettings, double d, double d2, long j, int i) {
        IIX0o.x0xO0oo(prayerTimeSettings, "prayerTimeSettings");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("getPrayerTime -> " + d + ", " + d2 + ", " + j + ", " + prayerTimeSettings + ", " + i);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i2 = 0; i2 < i; i2++) {
            long millis = j + (i2 * TimeUnit.DAYS.toMillis(1L));
            linkedHashMap.put(Long.valueOf(millis), getPrayerTime(prayerTimeSettings, d, d2, millis));
        }
        return linkedHashMap;
    }

    public static /* synthetic */ Map getPrayerTimeMap$default(PrayerTimeSettings prayerTimeSettings, double d, double d2, long j, int i, int i2, Object obj) {
        int i3;
        if ((i2 & 16) != 0) {
            i3 = 31;
        } else {
            i3 = i;
        }
        return getPrayerTimeMap(prayerTimeSettings, d, d2, j, i3);
    }

    @OOXIXo
    public static final List<BlePrayerTimes> toBlePrayerTimes(@OOXIXo Map<Long, ? extends List<PrayerTime>> map) {
        BlePrayerTimes blePrayerTimes;
        IIX0o.x0xO0oo(map, "map");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = map.values().iterator();
        while (it.hasNext()) {
            List<PrayerTime> list = (List) it.next();
            BlePrayerTimes blePrayerTimes2 = r15;
            BlePrayerTimes blePrayerTimes3 = new BlePrayerTimes(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, xxXXXxIxo.f15726I0Io, null);
            for (PrayerTime prayerTime : list) {
                switch (WhenMappings.$EnumSwitchMapping$0[prayerTime.getType().ordinal()]) {
                    case 1:
                        blePrayerTimes = blePrayerTimes2;
                        blePrayerTimes.setMFajrHour(prayerTime.getTimeHour());
                        blePrayerTimes.setMFajrMinite(prayerTime.getTimeMinute());
                        break;
                    case 2:
                        blePrayerTimes = blePrayerTimes2;
                        blePrayerTimes.setMSunriseHour(prayerTime.getTimeHour());
                        blePrayerTimes.setMSunriseMinite(prayerTime.getTimeMinute());
                        break;
                    case 3:
                        blePrayerTimes = blePrayerTimes2;
                        blePrayerTimes.setMDhuhrHour(prayerTime.getTimeHour());
                        blePrayerTimes.setMDhuhrMinite(prayerTime.getTimeMinute());
                        break;
                    case 4:
                        blePrayerTimes = blePrayerTimes2;
                        blePrayerTimes.setMAsrHour(prayerTime.getTimeHour());
                        blePrayerTimes.setMAsrMinite(prayerTime.getTimeMinute());
                        break;
                    case 5:
                        blePrayerTimes = blePrayerTimes2;
                        blePrayerTimes.setMMaghribHour(prayerTime.getTimeHour());
                        blePrayerTimes.setMMaghribMinite(prayerTime.getTimeMinute());
                        break;
                    case 6:
                        blePrayerTimes = blePrayerTimes2;
                        blePrayerTimes.setMIshaHour(prayerTime.getTimeHour());
                        blePrayerTimes.setMIshaMinite(prayerTime.getTimeMinute());
                        break;
                    default:
                        blePrayerTimes = blePrayerTimes2;
                        break;
                }
                blePrayerTimes2 = blePrayerTimes;
            }
            arrayList.add(blePrayerTimes2);
        }
        return arrayList;
    }
}
