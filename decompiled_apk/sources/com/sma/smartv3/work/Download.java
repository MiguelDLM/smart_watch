package com.sma.smartv3.work;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.entity.Activity;
import com.sma.smartv3.db.entity.BloodOxygen;
import com.sma.smartv3.db.entity.BloodPressure;
import com.sma.smartv3.db.entity.HeartRate;
import com.sma.smartv3.db.entity.Hrv;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.db.entity.Sleep;
import com.sma.smartv3.db.entity.Temperature;
import com.sma.smartv3.db.entity.Weight;
import com.sma.smartv3.db.entity.Workout;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.model.SMADataUploadData;
import com.sma.smartv3.pop.xOOOX;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.util.xoIox;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes12.dex */
public final class Download {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final Download f25779oIX0oI = new Download();

    public final boolean II0xO0(@OOXIXo xOOOX progressPopup) {
        IIX0o.x0xO0oo(progressPopup, "progressPopup");
        try {
            final SimpleDateFormat I0Io2 = xoIox.I0Io();
            final Date date = new Date();
            final ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            final ArrayList arrayList3 = new ArrayList();
            final ArrayList arrayList4 = new ArrayList();
            final ArrayList arrayList5 = new ArrayList();
            final ArrayList arrayList6 = new ArrayList();
            final ArrayList arrayList7 = new ArrayList();
            final ArrayList arrayList8 = new ArrayList();
            final ArrayList arrayList9 = new ArrayList();
            final ArrayList arrayList10 = new ArrayList();
            X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
            if (!IXxxXO.Oo(oix0oi).exists()) {
                return false;
            }
            FilesKt__FileReadWriteKt.Oo(IXxxXO.Oo(oix0oi), null, new oOoXoXO<String, oXIO0o0XI>() { // from class: com.sma.smartv3.work.Download$parseData$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(String str) {
                    invoke2(str);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo String it) {
                    Workout workout;
                    IIX0o.x0xO0oo(it, "it");
                    try {
                        if (it.length() > 0) {
                            List XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(it, new String[]{"\t"}, false, 0, 6, null);
                            if (XXoO0oX2.isEmpty() || XXoO0oX2.size() <= 2 || ((CharSequence) XXoO0oX2.get(1)).length() <= 0) {
                                return;
                            }
                            long j = 1000;
                            long parseLong = (Long.parseLong((String) XXoO0oX2.get(1)) * j) + SMADataUploadData.defaultTime;
                            date.setTime(parseLong);
                            String format = I0Io2.format(date);
                            String str = (String) XXoO0oX2.get(0);
                            int hashCode = str.hashCode();
                            if (hashCode != 1567) {
                                switch (hashCode) {
                                    case 49:
                                        if (str.equals("1")) {
                                            ArrayList<Activity> arrayList11 = arrayList;
                                            IIX0o.ooOOo0oXI(format);
                                            Download download = Download.f25779oIX0oI;
                                            arrayList11.add(new Activity(0, parseLong, format, download.oIX0oI((String) XXoO0oX2.get(2)), download.oIX0oI((String) XXoO0oX2.get(3)), download.oIX0oI((String) XXoO0oX2.get(4)), download.oIX0oI((String) XXoO0oX2.get(5)) * 10000, download.oIX0oI((String) XXoO0oX2.get(6)) * 10000, 1, ((CharSequence) XXoO0oX2.get(7)).length() > 0 ? download.oIX0oI((String) XXoO0oX2.get(7)) : 0, 1, null));
                                            return;
                                        }
                                        return;
                                    case 50:
                                        if (str.equals("2") && XXoO0oX2.size() > 3) {
                                            ArrayList<BloodPressure> arrayList12 = arrayList2;
                                            IIX0o.ooOOo0oXI(format);
                                            Download download2 = Download.f25779oIX0oI;
                                            arrayList12.add(new BloodPressure(0, parseLong, format, download2.oIX0oI((String) XXoO0oX2.get(2)), download2.oIX0oI((String) XXoO0oX2.get(3)), 1, 1, null));
                                            return;
                                        }
                                        return;
                                    case 51:
                                        if (str.equals("3")) {
                                            ArrayList<HeartRate> arrayList13 = arrayList3;
                                            IIX0o.ooOOo0oXI(format);
                                            arrayList13.add(new HeartRate(0, parseLong, format, Download.f25779oIX0oI.oIX0oI((String) XXoO0oX2.get(2)), 1, 1, null));
                                            return;
                                        }
                                        return;
                                    case 52:
                                        if (str.equals("4")) {
                                            ArrayList<Location> arrayList14 = arrayList4;
                                            IIX0o.ooOOo0oXI(format);
                                            Download download3 = Download.f25779oIX0oI;
                                            arrayList14.add(new Location(0, parseLong, format, 0, download3.oIX0oI((String) XXoO0oX2.get(2)), Float.parseFloat((String) XXoO0oX2.get(3)), Float.parseFloat((String) XXoO0oX2.get(4)), ((CharSequence) XXoO0oX2.get(5)).length() > 0 ? download3.oIX0oI((String) XXoO0oX2.get(5)) : 0, 1, 0, 521, null));
                                            return;
                                        }
                                        return;
                                    case 53:
                                        if (str.equals("5")) {
                                            ArrayList<Sleep> arrayList15 = arrayList5;
                                            IIX0o.ooOOo0oXI(format);
                                            Download download4 = Download.f25779oIX0oI;
                                            arrayList15.add(new Sleep(0, parseLong, format, download4.oIX0oI((String) XXoO0oX2.get(2)), download4.oIX0oI((String) XXoO0oX2.get(3)), download4.oIX0oI((String) XXoO0oX2.get(4)), 1, 0, 129, null));
                                            return;
                                        }
                                        return;
                                    case 54:
                                        if (str.equals("6")) {
                                            ArrayList<Weight> arrayList16 = arrayList6;
                                            IIX0o.ooOOo0oXI(format);
                                            arrayList16.add(new Weight(0, parseLong, format, Float.parseFloat((String) XXoO0oX2.get(2)), 1, 0, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, null, null, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, null, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, null, null, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, null, XIXIX.OOXIXo.f3760XO, null, 0, 0, 0, -31, 2097151, null));
                                            return;
                                        }
                                        return;
                                    case 55:
                                        if (str.equals("7")) {
                                            if (XXoO0oX2.size() > 20) {
                                                long parseLong2 = Long.parseLong((String) XXoO0oX2.get(2));
                                                Long.signum(parseLong2);
                                                long j2 = (parseLong2 * j) + SMADataUploadData.defaultTime;
                                                Download download5 = Download.f25779oIX0oI;
                                                int oIX0oI2 = download5.oIX0oI((String) XXoO0oX2.get(3));
                                                int oIX0oI3 = download5.oIX0oI((String) XXoO0oX2.get(4));
                                                int oIX0oI4 = download5.oIX0oI((String) XXoO0oX2.get(5));
                                                int oIX0oI5 = download5.oIX0oI((String) XXoO0oX2.get(6));
                                                int oIX0oI6 = download5.oIX0oI((String) XXoO0oX2.get(7));
                                                int oIX0oI7 = download5.oIX0oI((String) XXoO0oX2.get(8));
                                                int oIX0oI8 = download5.oIX0oI((String) XXoO0oX2.get(9));
                                                int oIX0oI9 = download5.oIX0oI((String) XXoO0oX2.get(10));
                                                int oIX0oI10 = download5.oIX0oI((String) XXoO0oX2.get(11));
                                                int oIX0oI11 = download5.oIX0oI((String) XXoO0oX2.get(12));
                                                int oIX0oI12 = ((CharSequence) XXoO0oX2.get(13)).length() > 0 ? download5.oIX0oI((String) XXoO0oX2.get(13)) : 0;
                                                int oIX0oI13 = download5.oIX0oI((String) XXoO0oX2.get(14));
                                                int oIX0oI14 = download5.oIX0oI((String) XXoO0oX2.get(15));
                                                int oIX0oI15 = download5.oIX0oI((String) XXoO0oX2.get(16));
                                                int oIX0oI16 = download5.oIX0oI((String) XXoO0oX2.get(17));
                                                int oIX0oI17 = download5.oIX0oI((String) XXoO0oX2.get(18));
                                                int oIX0oI18 = download5.oIX0oI((String) XXoO0oX2.get(19));
                                                int oIX0oI19 = download5.oIX0oI((String) XXoO0oX2.get(20));
                                                int oIX0oI20 = download5.oIX0oI((String) XXoO0oX2.get(21));
                                                int oIX0oI21 = download5.oIX0oI((String) XXoO0oX2.get(22));
                                                int oIX0oI22 = download5.oIX0oI((String) XXoO0oX2.get(23));
                                                int oIX0oI23 = download5.oIX0oI((String) XXoO0oX2.get(24));
                                                int oIX0oI24 = download5.oIX0oI((String) XXoO0oX2.get(25));
                                                int oIX0oI25 = download5.oIX0oI((String) XXoO0oX2.get(26));
                                                int oIX0oI26 = download5.oIX0oI((String) XXoO0oX2.get(27));
                                                String str2 = (String) XXoO0oX2.get(28);
                                                String str3 = (String) XXoO0oX2.get(29);
                                                String str4 = (String) XXoO0oX2.get(30);
                                                IIX0o.ooOOo0oXI(format);
                                                workout = new Workout(0, parseLong, j2, format, oIX0oI2, oIX0oI3, oIX0oI4, oIX0oI5, oIX0oI6, oIX0oI7, oIX0oI8, oIX0oI9, oIX0oI10, oIX0oI11, oIX0oI13, oIX0oI14, oIX0oI15, oIX0oI16, oIX0oI17, oIX0oI18, oIX0oI19, oIX0oI20, oIX0oI21, oIX0oI22, oIX0oI23, oIX0oI24, oIX0oI25, 1, oIX0oI12, oIX0oI26, str2, str3, str4, null, 0, 0, 0, 0, 0, 0, 0.0f, 0.0f, 0, 0.0f, 0, 0, 0, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, null, 0, 0, null, 0, 0, null, 0, 0, null, 0, 0, null, 1, -2, 511, null);
                                            } else {
                                                long parseLong3 = (Long.parseLong((String) XXoO0oX2.get(2)) * j) + SMADataUploadData.defaultTime;
                                                Download download6 = Download.f25779oIX0oI;
                                                int oIX0oI27 = download6.oIX0oI((String) XXoO0oX2.get(3));
                                                int oIX0oI28 = download6.oIX0oI((String) XXoO0oX2.get(4));
                                                int oIX0oI29 = download6.oIX0oI((String) XXoO0oX2.get(5));
                                                int oIX0oI30 = download6.oIX0oI((String) XXoO0oX2.get(6));
                                                int oIX0oI31 = download6.oIX0oI((String) XXoO0oX2.get(7));
                                                int oIX0oI32 = download6.oIX0oI((String) XXoO0oX2.get(8));
                                                int oIX0oI33 = download6.oIX0oI((String) XXoO0oX2.get(9));
                                                int oIX0oI34 = download6.oIX0oI((String) XXoO0oX2.get(10));
                                                int oIX0oI35 = download6.oIX0oI((String) XXoO0oX2.get(11));
                                                int oIX0oI36 = download6.oIX0oI((String) XXoO0oX2.get(12));
                                                int oIX0oI37 = ((CharSequence) XXoO0oX2.get(13)).length() > 0 ? download6.oIX0oI((String) XXoO0oX2.get(13)) : 0;
                                                IIX0o.ooOOo0oXI(format);
                                                workout = new Workout(0, parseLong, parseLong3, format, oIX0oI27, oIX0oI28, oIX0oI29, oIX0oI30, oIX0oI31, oIX0oI32, oIX0oI33, oIX0oI34, oIX0oI35, oIX0oI36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, oIX0oI37, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0.0f, 0.0f, 0, 0.0f, 0, 0, 0, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, null, 0, 0, null, 0, 0, null, 0, 0, null, 0, 0, null, -402669567, -1, 511, null);
                                            }
                                            arrayList7.add(workout);
                                            return;
                                        }
                                        return;
                                    case 56:
                                        if (str.equals("8")) {
                                            ArrayList<Temperature> arrayList17 = arrayList8;
                                            IIX0o.ooOOo0oXI(format);
                                            arrayList17.add(new Temperature(0, parseLong, format, Download.f25779oIX0oI.oIX0oI((String) XXoO0oX2.get(2)), 1, 1, null));
                                            return;
                                        }
                                        return;
                                    case 57:
                                        if (str.equals("9")) {
                                            ArrayList<BloodOxygen> arrayList18 = arrayList10;
                                            IIX0o.ooOOo0oXI(format);
                                            arrayList18.add(new BloodOxygen(0, parseLong, format, Download.f25779oIX0oI.oIX0oI((String) XXoO0oX2.get(2)), 1, 1, null));
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            }
                            if (str.equals("10")) {
                                ArrayList<Hrv> arrayList19 = arrayList9;
                                IIX0o.ooOOo0oXI(format);
                                Download download7 = Download.f25779oIX0oI;
                                arrayList19.add(new Hrv(0, parseLong, format, download7.oIX0oI((String) XXoO0oX2.get(2)), download7.oIX0oI((String) XXoO0oX2.get(3)), 1, 1, null));
                            }
                        }
                    } catch (Exception e) {
                        OI0.oIX0oI.f1507oIX0oI.II0xO0("parseData data error");
                        e.printStackTrace();
                    }
                }
            }, 1, null);
            LogUtils.d("parseData data done");
            progressPopup.XIxXXX0x0(30);
            if (!arrayList7.isEmpty()) {
                MyDb.INSTANCE.getMDatabase().workoutDao().insert(arrayList7);
            }
            progressPopup.XIxXXX0x0(40);
            if (!arrayList.isEmpty()) {
                MyDb.INSTANCE.getMDatabase().activityDao().insert(arrayList);
            }
            progressPopup.XIxXXX0x0(50);
            if (!arrayList4.isEmpty()) {
                MyDb.INSTANCE.getMDatabase().locationDao().insert(arrayList4);
            }
            x0xO0oo.II0xO0(x0xO0oo.f24629oIX0oI, null, 2, null);
            progressPopup.XIxXXX0x0(60);
            if (!arrayList3.isEmpty()) {
                MyDb.INSTANCE.getMDatabase().heartRateDao().insert(arrayList3);
            }
            x0xO0oo.II0xO0(x0xO0oo.f24567II0xO0, null, 2, null);
            progressPopup.XIxXXX0x0(70);
            if (!arrayList2.isEmpty()) {
                MyDb.INSTANCE.getMDatabase().bloodPressureDao().insert(arrayList2);
            }
            x0xO0oo.II0xO0(x0xO0oo.f24562I0Io, null, 2, null);
            progressPopup.XIxXXX0x0(75);
            if (!arrayList5.isEmpty()) {
                MyDb.INSTANCE.getMDatabase().sleepDao().insert(arrayList5);
            }
            x0xO0oo.II0xO0(x0xO0oo.f24645oxoX, null, 2, null);
            progressPopup.XIxXXX0x0(80);
            if (!arrayList6.isEmpty()) {
                MyDb.INSTANCE.getMDatabase().weightDao().insert(arrayList6);
            }
            x0xO0oo.II0xO0(x0xO0oo.f24612XO, null, 2, null);
            progressPopup.XIxXXX0x0(85);
            if (!arrayList8.isEmpty()) {
                MyDb.INSTANCE.getMDatabase().temperatureDao().insert(arrayList8);
            }
            x0xO0oo.II0xO0(x0xO0oo.f24600Oxx0IOOO, null, 2, null);
            progressPopup.XIxXXX0x0(90);
            if (!arrayList10.isEmpty()) {
                MyDb.INSTANCE.getMDatabase().bloodOxygenDao().insert(arrayList10);
            }
            progressPopup.XIxXXX0x0(95);
            x0xO0oo.II0xO0(x0xO0oo.f24566II0XooXoX, null, 2, null);
            if (!arrayList9.isEmpty()) {
                MyDb.INSTANCE.getMDatabase().hrvDao().insert(arrayList9);
            }
            x0xO0oo.II0xO0(x0xO0oo.f24669xxIXOIIO, null, 2, null);
            progressPopup.XIxXXX0x0(100);
            LogUtils.d("parseData data insert done");
            Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24496xxIXOIIO, true);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.d(oXIO0o0XI.f29392oIX0oI);
            return false;
        }
    }

    public final int oIX0oI(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        if (str.length() > 11) {
            String substring = str.substring(0, str.length() / 2);
            IIX0o.oO(substring, "substring(...)");
            return Integer.parseInt(substring);
        }
        return Integer.parseInt(str);
    }
}
