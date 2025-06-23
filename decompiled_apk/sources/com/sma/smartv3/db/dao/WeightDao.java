package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.blankj.utilcode.util.ResourceUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.smartv3.db.entity.Weight;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@Dao
/* loaded from: classes12.dex */
public interface WeightDao {

    @XX({"SMAP\nWeightDao.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WeightDao.kt\ncom/sma/smartv3/db/dao/WeightDao$DefaultImpls\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,52:1\n1855#2,2:53\n*S KotlinDebug\n*F\n+ 1 WeightDao.kt\ncom/sma/smartv3/db/dao/WeightDao$DefaultImpls\n*L\n43#1:53,2\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class DefaultImpls {
        @OOXIXo
        public static List<Weight> getTestWeights(@OOXIXo WeightDao weightDao, long j, long j2) {
            if (TestData.INSTANCE.getTestWeights().isEmpty()) {
                try {
                    Object fromJson = new Gson().fromJson(ResourceUtils.readAssets2String("weight"), new TypeToken<List<? extends Weight>>() { // from class: com.sma.smartv3.db.dao.WeightDao$getTestWeights$list$1
                    }.getType());
                    IIX0o.oO(fromJson, "fromJson(...)");
                    List list = (List) fromJson;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((Weight) it.next()).setMTime(j);
                        j += TimeUnit.DAYS.toMillis(1L);
                    }
                    TestData.INSTANCE.getTestWeights().addAll(list);
                } catch (Exception unused) {
                }
            }
            return TestData.INSTANCE.getTestWeights();
        }
    }

    @Query("DELETE FROM Weight WHERE mTime = :mTime")
    void delete(long j);

    @OOXIXo
    @Query("SELECT * FROM Weight WHERE  mIsSync = 0 AND mTime > 0 ORDER BY mTime ASC LIMIT 150")
    List<Weight> getListASC();

    @OOXIXo
    List<Weight> getTestWeights(long j, long j2);

    @OOXIXo
    @Query("SELECT * FROM Weight WHERE mIsDelete != 1 ORDER BY mTime ASC")
    List<Weight> getWeights();

    @OOXIXo
    @Query("SELECT * FROM Weight WHERE mTime >= :start AND mTime < :end AND mIsDelete != 1 ORDER BY mTime ASC")
    List<Weight> getWeightsASC(long j, long j2);

    @OOXIXo
    @Query("SELECT * FROM Weight WHERE  mIsDelete != 1 ORDER BY mTime DESC LIMIT :startIndex, :endIndex")
    List<Weight> getWeightsDESC(int i, int i2);

    @Insert(onConflict = 1)
    @OOXIXo
    long[] insert(@OOXIXo List<Weight> list);

    @Update
    int update(@OOXIXo List<Weight> list);
}
