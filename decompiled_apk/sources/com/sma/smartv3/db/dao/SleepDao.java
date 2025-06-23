package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.blankj.utilcode.util.ResourceUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.openalliance.ad.constant.x;
import com.sma.smartv3.db.entity.Sleep;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@Dao
/* loaded from: classes12.dex */
public interface SleepDao {

    @XX({"SMAP\nSleepDao.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SleepDao.kt\ncom/sma/smartv3/db/dao/SleepDao$DefaultImpls\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,57:1\n1864#2,3:58\n*S KotlinDebug\n*F\n+ 1 SleepDao.kt\ncom/sma/smartv3/db/dao/SleepDao$DefaultImpls\n*L\n38#1:58,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class DefaultImpls {
        @OOXIXo
        public static List<Sleep> getTestSleeps(@OOXIXo SleepDao sleepDao, long j, long j2) {
            if (TestData.INSTANCE.getTestSleeps().isEmpty()) {
                try {
                    Object fromJson = new Gson().fromJson(ResourceUtils.readAssets2String("sleep"), new TypeToken<List<? extends Sleep>>() { // from class: com.sma.smartv3.db.dao.SleepDao$getTestSleeps$list$1
                    }.getType());
                    IIX0o.oO(fromJson, "fromJson(...)");
                    List list = (List) fromJson;
                    long j3 = j + 36000000;
                    long j4 = j2 - 18000000;
                    int i = 0;
                    long j5 = j3;
                    for (Object obj : list) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt__CollectionsKt.XoX();
                        }
                        Sleep sleep = (Sleep) obj;
                        if (i == 0) {
                            sleep.setMTime(j3 - 300000);
                        } else if (i == list.size() - 1) {
                            sleep.setMTime(300000 + j4);
                        } else {
                            sleep.setMTime(j5);
                            j5 += x.ac;
                        }
                        i = i2;
                    }
                    TestData.INSTANCE.getTestSleeps().addAll(list);
                } catch (Exception unused) {
                }
            }
            return TestData.INSTANCE.getTestSleeps();
        }
    }

    @Query("DELETE FROM Sleep WHERE mTime >= :start AND mTime < :end")
    void deleteSleeps(long j, long j2);

    @OOXIXo
    @Query("SELECT * FROM Sleep WHERE  mIsSync = 0 AND mTime > 0 ORDER BY mTime ASC LIMIT 150")
    List<Sleep> getListASC();

    @OOXIXo
    @Query("SELECT * FROM Sleep WHERE mTime >= :start AND mTime < :end ORDER BY mTime ASC")
    List<Sleep> getSleeps(long j, long j2);

    @OOXIXo
    List<Sleep> getTestSleeps(long j, long j2);

    @Insert(onConflict = 1)
    @OOXIXo
    long[] insert(@OOXIXo List<Sleep> list);

    @Update
    int update(@OOXIXo List<Sleep> list);
}
