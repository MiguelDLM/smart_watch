package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.blankj.utilcode.util.ResourceUtils;
import com.google.android.gms.common.util.GmsVersion;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.smartv3.db.entity.BloodPressure;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@Dao
/* loaded from: classes12.dex */
public interface BloodPressureDao {

    @XX({"SMAP\nBloodPressureDao.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BloodPressureDao.kt\ncom/sma/smartv3/db/dao/BloodPressureDao$DefaultImpls\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,45:1\n1855#2,2:46\n*S KotlinDebug\n*F\n+ 1 BloodPressureDao.kt\ncom/sma/smartv3/db/dao/BloodPressureDao$DefaultImpls\n*L\n36#1:46,2\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class DefaultImpls {
        @OOXIXo
        public static List<BloodPressure> getTestBloodPressures(@OOXIXo BloodPressureDao bloodPressureDao, long j, long j2) {
            if (TestData.INSTANCE.getTestBloodPressures().isEmpty()) {
                try {
                    Object fromJson = new Gson().fromJson(ResourceUtils.readAssets2String("bp"), new TypeToken<List<? extends BloodPressure>>() { // from class: com.sma.smartv3.db.dao.BloodPressureDao$getTestBloodPressures$list$1
                    }.getType());
                    IIX0o.oO(fromJson, "fromJson(...)");
                    List list = (List) fromJson;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((BloodPressure) it.next()).setMTime(j);
                        j += GmsVersion.VERSION_PARMESAN;
                    }
                    TestData.INSTANCE.getTestBloodPressures().addAll(list);
                } catch (Exception unused) {
                }
            }
            return TestData.INSTANCE.getTestBloodPressures();
        }
    }

    @OOXIXo
    @Query("SELECT * FROM BloodPressure WHERE mTime >= :start AND mTime < :end AND mSystolic <200 AND mDiastolic >=60 ")
    List<BloodPressure> getBloodPressures(long j, long j2);

    @Query("SELECT * FROM BloodPressure WHERE mSystolic <200 AND mDiastolic >=60 ORDER BY mTime DESC LIMIT 1")
    @oOoXoXO
    BloodPressure getLastBloodPressure();

    @OOXIXo
    @Query("SELECT * FROM BloodPressure WHERE  mIsSync = 0 AND mTime > 0 AND mSystolic <200 AND mDiastolic >=60 ORDER BY mTime ASC LIMIT 150")
    List<BloodPressure> getListASC();

    @OOXIXo
    List<BloodPressure> getTestBloodPressures(long j, long j2);

    @Insert(onConflict = 1)
    @OOXIXo
    long[] insert(@OOXIXo List<BloodPressure> list);

    @Update
    int update(@OOXIXo List<BloodPressure> list);
}
