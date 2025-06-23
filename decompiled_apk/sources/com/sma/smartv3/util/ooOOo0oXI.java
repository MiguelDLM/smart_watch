package com.sma.smartv3.util;

import com.blankj.utilcode.util.TimeUtils;
import com.sma.smartv3.db.entity.Electrocardiogram;
import com.szabh.smable3.entity.BleEcg;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.random.Random;

@kotlin.jvm.internal.XX({"SMAP\nEcgIntervalDataUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EcgIntervalDataUtil.kt\ncom/sma/smartv3/util/EcgIntervalDataUtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,168:1\n1855#2,2:169\n1549#2:171\n1620#2,3:172\n*S KotlinDebug\n*F\n+ 1 EcgIntervalDataUtil.kt\ncom/sma/smartv3/util/EcgIntervalDataUtilKt\n*L\n30#1:169,2\n56#1:171\n56#1:172,3\n*E\n"})
/* loaded from: classes12.dex */
public final class ooOOo0oXI {
    @OXOo.OOXIXo
    public static final List<Electrocardiogram> I0Io(@OXOo.OOXIXo List<BleEcg> ecgs, @OXOo.oOoXoXO Electrocardiogram electrocardiogram) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(ecgs, "ecgs");
        SimpleDateFormat I0Io2 = xoIox.I0Io();
        Date date = new Date();
        long offset = TimeZone.getDefault().getOffset(System.currentTimeMillis());
        BleEcg bleEcg = (BleEcg) CollectionsKt___CollectionsKt.O0OOX0IIx(ecgs);
        BleEcg bleEcg2 = (BleEcg) CollectionsKt___CollectionsKt.O0O0Io00X(ecgs);
        List<BleEcg> list = ecgs;
        int i = 0;
        int i2 = 0;
        for (BleEcg bleEcg3 : list) {
            if (i < bleEcg3.getMValue()) {
                i = bleEcg3.getMValue();
            }
            if (i2 > bleEcg3.getMValue() || i2 == 0) {
                i2 = bleEcg3.getMValue();
            }
        }
        ArrayList arrayList = new ArrayList();
        if (bleEcg.getMValue() == bleEcg2.getMValue()) {
            bleEcg.setMValue(bleEcg.getMValue() - 2);
        }
        II0xO0(electrocardiogram, bleEcg, offset, i, i2, arrayList, bleEcg2, date, I0Io2);
        oIX0oI(arrayList, bleEcg2.getMValue(), bleEcg.getMTime() - 30, offset, date, I0Io2);
        oIX0oI(arrayList, bleEcg2.getMValue(), bleEcg.getMTime() - 13, offset, date, I0Io2);
        oIX0oI(arrayList, bleEcg2.getMValue() + 5, bleEcg.getMTime() - 9, offset, date, I0Io2);
        oIX0oI(arrayList, bleEcg2.getMValue(), bleEcg.getMTime() - 5, offset, date, I0Io2);
        oIX0oI(arrayList, bleEcg2.getMValue(), bleEcg.getMTime() - 2, offset, date, I0Io2);
        ArrayList arrayList2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Electrocardiogram electrocardiogram2 = new Electrocardiogram((BleEcg) it.next(), offset);
            date.setTime(electrocardiogram2.getMTime());
            String format = I0Io2.format(date);
            kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
            electrocardiogram2.setMLocalTime(format);
            arrayList2.add(Boolean.valueOf(arrayList.add(electrocardiogram2)));
        }
        oIX0oI(arrayList, bleEcg2.getMValue(), bleEcg2.getMTime() + 7, offset, date, I0Io2);
        return arrayList;
    }

    public static final void II0xO0(Electrocardiogram electrocardiogram, BleEcg bleEcg, long j, int i, int i2, List<Electrocardiogram> list, BleEcg bleEcg2, Date date, SimpleDateFormat simpleDateFormat) {
        int i3;
        int i4;
        int i5;
        long mTime = ((bleEcg.getMTime() - (-946684770)) * 1000) - j;
        if (electrocardiogram == null || !TimeUtils.isToday(electrocardiogram.getMTime()) || mTime - electrocardiogram.getMTime() <= 60000) {
            return;
        }
        long oxoX2 = xx0o0O.x0XOIxOo.oxoX(0L, mTime - electrocardiogram.getMTime(), 20000L);
        if (0 > oxoX2) {
            return;
        }
        int i6 = 0;
        long j2 = 0;
        int i7 = 0;
        boolean z = false;
        while (true) {
            if (i7 > 4) {
                Electrocardiogram electrocardiogram2 = new Electrocardiogram(0, (electrocardiogram.getMTime() + j2) - 5000, null, bleEcg2.getMValue(), 0, 21, null);
                date.setTime(electrocardiogram2.getMTime());
                String format = simpleDateFormat.format(date);
                kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
                electrocardiogram2.setMLocalTime(format);
                list.add(electrocardiogram2);
                Random.Default r5 = Random.Default;
                int nextInt = i + r5.nextInt(-4, i6);
                long j3 = 4000;
                Electrocardiogram electrocardiogram3 = new Electrocardiogram(0, (electrocardiogram.getMTime() + j2) - j3, null, nextInt, 0, 21, null);
                date.setTime(electrocardiogram3.getMTime());
                String format2 = simpleDateFormat.format(date);
                kotlin.jvm.internal.IIX0o.oO(format2, "format(...)");
                electrocardiogram3.setMLocalTime(format2);
                list.add(electrocardiogram3);
                Electrocardiogram electrocardiogram4 = new Electrocardiogram(0, electrocardiogram.getMTime() + j2 + 3000, null, i2 + r5.nextInt(0, 4), 0, 21, null);
                date.setTime(electrocardiogram4.getMTime());
                String format3 = simpleDateFormat.format(date);
                kotlin.jvm.internal.IIX0o.oO(format3, "format(...)");
                electrocardiogram4.setMLocalTime(format3);
                list.add(electrocardiogram4);
                Electrocardiogram electrocardiogram5 = new Electrocardiogram(0, electrocardiogram.getMTime() + j2 + j3, null, bleEcg2.getMValue(), 0, 21, null);
                date.setTime(electrocardiogram5.getMTime());
                String format4 = simpleDateFormat.format(date);
                kotlin.jvm.internal.IIX0o.oO(format4, "format(...)");
                electrocardiogram5.setMLocalTime(format4);
                list.add(electrocardiogram5);
                i7 = 0;
            } else {
                if (i7 > 3) {
                    int mValue = bleEcg2.getMValue();
                    Random.Default r14 = Random.Default;
                    Electrocardiogram electrocardiogram6 = new Electrocardiogram(0, electrocardiogram.getMTime() + j2 + (r14.nextInt(-5, 0) * 1000), null, mValue + r14.nextInt(-5, 5), 0, 21, null);
                    i3 = i7;
                    date.setTime(electrocardiogram6.getMTime());
                    String format5 = simpleDateFormat.format(date);
                    kotlin.jvm.internal.IIX0o.oO(format5, "format(...)");
                    electrocardiogram6.setMLocalTime(format5);
                    list.add(electrocardiogram6);
                    Electrocardiogram electrocardiogram7 = new Electrocardiogram(0, electrocardiogram.getMTime() + j2 + (r14.nextInt(1, 5) * 1000), null, bleEcg2.getMValue() + r14.nextInt(-10, 10), 0, 21, null);
                    date.setTime(electrocardiogram7.getMTime());
                    String format6 = simpleDateFormat.format(date);
                    kotlin.jvm.internal.IIX0o.oO(format6, "format(...)");
                    electrocardiogram7.setMLocalTime(format6);
                    list.add(electrocardiogram7);
                } else {
                    i3 = i7;
                    Random.Default r52 = Random.Default;
                    if (z) {
                        i4 = 10;
                        i5 = 1;
                    } else {
                        i4 = -1;
                        i5 = -10;
                    }
                    int nextInt2 = r52.nextInt(i5, i4);
                    if (j2 == 0) {
                        i7 = i3;
                    } else {
                        int mValue2 = bleEcg2.getMValue();
                        long mTime2 = electrocardiogram.getMTime() + j2;
                        Random.Default r12 = Random.Default;
                        Electrocardiogram electrocardiogram8 = new Electrocardiogram(0, mTime2 + (r12.nextInt(1, 7) * 1000), null, mValue2, 0, 21, null);
                        date.setTime(electrocardiogram8.getMTime());
                        String format7 = simpleDateFormat.format(date);
                        kotlin.jvm.internal.IIX0o.oO(format7, "format(...)");
                        electrocardiogram8.setMLocalTime(format7);
                        list.add(electrocardiogram8);
                        Electrocardiogram electrocardiogram9 = new Electrocardiogram(0, electrocardiogram.getMTime() + j2 + (r12.nextInt(8, 15) * 1000), null, bleEcg2.getMValue() + nextInt2, 0, 21, null);
                        date.setTime(electrocardiogram9.getMTime());
                        String format8 = simpleDateFormat.format(date);
                        kotlin.jvm.internal.IIX0o.oO(format8, "format(...)");
                        electrocardiogram9.setMLocalTime(format8);
                        list.add(electrocardiogram9);
                        z = !z;
                    }
                }
                i7 = i3 + 1;
            }
            if (j2 == oxoX2) {
                return;
            }
            j2 += 20000;
            i6 = 0;
        }
    }

    public static final void oIX0oI(List<Electrocardiogram> list, int i, int i2, long j, Date date, SimpleDateFormat simpleDateFormat) {
        Electrocardiogram electrocardiogram = new Electrocardiogram(new BleEcg(i2, i), j);
        date.setTime(electrocardiogram.getMTime());
        String format = simpleDateFormat.format(date);
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        electrocardiogram.setMLocalTime(format);
        list.add(electrocardiogram);
    }
}
