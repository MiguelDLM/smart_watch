package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.blankj.utilcode.util.ResourceUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.db.entity.Pressure;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@Dao
/* loaded from: classes12.dex */
public interface PressureDao {

    @XX({"SMAP\nPressureDao.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PressureDao.kt\ncom/sma/smartv3/db/dao/PressureDao$DefaultImpls\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,46:1\n1855#2,2:47\n*S KotlinDebug\n*F\n+ 1 PressureDao.kt\ncom/sma/smartv3/db/dao/PressureDao$DefaultImpls\n*L\n36#1:47,2\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class DefaultImpls {
        @OOXIXo
        public static List<Pressure> getTestPressures(@OOXIXo PressureDao pressureDao, long j, long j2) {
            if (TestData.INSTANCE.getTestPressures().isEmpty()) {
                try {
                    Object fromJson = new Gson().fromJson(ResourceUtils.readAssets2String(ProductManager.oXoxo0x), new TypeToken<List<? extends Pressure>>() { // from class: com.sma.smartv3.db.dao.PressureDao$getTestPressures$list$1
                    }.getType());
                    IIX0o.oO(fromJson, "fromJson(...)");
                    List list = (List) fromJson;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((Pressure) it.next()).setMTime(j);
                        j += 3600000;
                    }
                    TestData.INSTANCE.getTestPressures().addAll(list);
                } catch (Exception unused) {
                }
            }
            return TestData.INSTANCE.getTestPressures();
        }
    }

    @OOXIXo
    @Query("SELECT * FROM Pressure WHERE  mIsSync = 0  AND mTime > 0 AND mValue > 0 AND mValue <= 100 ORDER BY mTime ASC LIMIT 150")
    List<Pressure> getListASC();

    @OOXIXo
    @Query("SELECT * FROM Pressure WHERE mTime >= :start AND mTime < :end AND mValue > 0 AND mValue <= 100")
    List<Pressure> getPressures(long j, long j2);

    @OOXIXo
    List<Pressure> getTestPressures(long j, long j2);

    @Insert(onConflict = 1)
    @OOXIXo
    long[] insert(@OOXIXo List<Pressure> list);

    @Update
    int update(@OOXIXo List<Pressure> list);
}
