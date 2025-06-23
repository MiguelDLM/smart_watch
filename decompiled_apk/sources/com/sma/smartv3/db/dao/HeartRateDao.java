package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.blankj.utilcode.util.ResourceUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.smartv3.db.entity.HeartRate;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@Dao
/* loaded from: classes12.dex */
public interface HeartRateDao {

    @XX({"SMAP\nHeartRateDao.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HeartRateDao.kt\ncom/sma/smartv3/db/dao/HeartRateDao$DefaultImpls\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,49:1\n1855#2,2:50\n*S KotlinDebug\n*F\n+ 1 HeartRateDao.kt\ncom/sma/smartv3/db/dao/HeartRateDao$DefaultImpls\n*L\n39#1:50,2\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class DefaultImpls {
        @OOXIXo
        public static List<HeartRate> getTestHeartRates(@OOXIXo HeartRateDao heartRateDao, long j, long j2) {
            if (TestData.INSTANCE.getTestHeartRates().isEmpty()) {
                try {
                    Object fromJson = new Gson().fromJson(ResourceUtils.readAssets2String("hr"), new TypeToken<List<? extends HeartRate>>() { // from class: com.sma.smartv3.db.dao.HeartRateDao$getTestHeartRates$list$1
                    }.getType());
                    IIX0o.oO(fromJson, "fromJson(...)");
                    List list = (List) fromJson;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((HeartRate) it.next()).setMTime(j);
                        j += 3600000;
                    }
                    TestData.INSTANCE.getTestHeartRates().addAll(list);
                } catch (Exception unused) {
                }
            }
            return TestData.INSTANCE.getTestHeartRates();
        }
    }

    @OOXIXo
    @Query("SELECT * FROM HeartRate WHERE mTime >= :start AND mTime < :end AND mBpm >= 50 AND mBpm<= 220")
    List<HeartRate> getHeartRates(long j, long j2);

    @Query("SELECT * FROM HeartRate WHERE mBpm >= 50 AND mBpm<= 220 ORDER BY mTime DESC LIMIT 1")
    @oOoXoXO
    HeartRate getLastHeartRate();

    @OOXIXo
    @Query("SELECT * FROM HeartRate WHERE  mIsSync = 0  AND mTime > 0 AND mBpm >= 50 AND mBpm<= 220 ORDER BY mTime ASC LIMIT 150")
    List<HeartRate> getListASC();

    @OOXIXo
    List<HeartRate> getTestHeartRates(long j, long j2);

    @Insert(onConflict = 1)
    @OOXIXo
    long[] insert(@OOXIXo List<HeartRate> list);

    @Update
    int update(@OOXIXo List<HeartRate> list);
}
