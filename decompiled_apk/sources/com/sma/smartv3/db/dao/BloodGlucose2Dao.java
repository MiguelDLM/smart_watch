package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.sma.smartv3.db.entity.BloodGlucose2;
import com.sma.smartv3.util.xoIox;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@Dao
/* loaded from: classes12.dex */
public interface BloodGlucose2Dao {
    @OOXIXo
    @Query("SELECT * FROM BloodGlucose2 ORDER BY mTime ASC")
    List<BloodGlucose2> getList();

    @OOXIXo
    @Query("SELECT * FROM BloodGlucose2 WHERE mTime >= :start AND mTime < :end ORDER BY mTime ASC")
    List<BloodGlucose2> getList(long j, long j2);

    @OOXIXo
    @Query("SELECT * FROM BloodGlucose2 ORDER BY mTime DESC")
    List<BloodGlucose2> getListDESC();

    @OOXIXo
    @Query("SELECT * FROM BloodGlucose2 WHERE mTime >= :start AND mTime < :end ORDER BY mTime DESC")
    List<BloodGlucose2> getListDESC(long j, long j2);

    @OOXIXo
    List<BloodGlucose2> getListForDay();

    @OOXIXo
    List<BloodGlucose2> getListForDay(long j, long j2);

    @OOXIXo
    List<BloodGlucose2> getTodayList();

    @Insert(onConflict = 1)
    @OOXIXo
    long[] insert(@OOXIXo List<BloodGlucose2> list);

    @XX({"SMAP\nBloodGlucose2Dao.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BloodGlucose2Dao.kt\ncom/sma/smartv3/db/dao/BloodGlucose2Dao$DefaultImpls\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,44:1\n1477#2:45\n1502#2,3:46\n1505#2,3:56\n1477#2:63\n1502#2,3:64\n1505#2,3:74\n372#3,7:49\n372#3,7:67\n125#4:59\n152#4,3:60\n125#4:77\n152#4,3:78\n*S KotlinDebug\n*F\n+ 1 BloodGlucose2Dao.kt\ncom/sma/smartv3/db/dao/BloodGlucose2Dao$DefaultImpls\n*L\n30#1:45\n30#1:46,3\n30#1:56,3\n36#1:63\n36#1:64,3\n36#1:74,3\n30#1:49,7\n36#1:67,7\n31#1:59\n31#1:60,3\n37#1:77\n37#1:78,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class DefaultImpls {
        @OOXIXo
        public static List<BloodGlucose2> getListForDay(@OOXIXo BloodGlucose2Dao bloodGlucose2Dao) {
            List<BloodGlucose2> list = bloodGlucose2Dao.getList();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                String format = xoIox.xoIxX().format(Long.valueOf(((BloodGlucose2) obj).getMTime()));
                Object obj2 = linkedHashMap.get(format);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(format, obj2);
                }
                ((List) obj2).add(obj);
            }
            ArrayList arrayList = new ArrayList(linkedHashMap.size());
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add((BloodGlucose2) CollectionsKt___CollectionsKt.O0OOX0IIx((List) ((Map.Entry) it.next()).getValue()));
            }
            return arrayList;
        }

        @OOXIXo
        public static List<BloodGlucose2> getTodayList(@OOXIXo BloodGlucose2Dao bloodGlucose2Dao) {
            Calendar calendar = Calendar.getInstance();
            IIX0o.oO(calendar, "getInstance(...)");
            long OxxIIOOXO2 = xoIox.OxxIIOOXO(calendar);
            return bloodGlucose2Dao.getList(OxxIIOOXO2, TimeUnit.DAYS.toMillis(1L) + OxxIIOOXO2);
        }

        @OOXIXo
        public static List<BloodGlucose2> getListForDay(@OOXIXo BloodGlucose2Dao bloodGlucose2Dao, long j, long j2) {
            List<BloodGlucose2> list = bloodGlucose2Dao.getList(j, j2);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                String format = xoIox.xoIxX().format(Long.valueOf(((BloodGlucose2) obj).getMTime()));
                Object obj2 = linkedHashMap.get(format);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(format, obj2);
                }
                ((List) obj2).add(obj);
            }
            ArrayList arrayList = new ArrayList(linkedHashMap.size());
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add((BloodGlucose2) CollectionsKt___CollectionsKt.O0OOX0IIx((List) ((Map.Entry) it.next()).getValue()));
            }
            return arrayList;
        }
    }
}
