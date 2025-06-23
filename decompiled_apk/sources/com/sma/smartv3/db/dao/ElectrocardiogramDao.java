package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.blankj.utilcode.util.ResourceUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.db.entity.Electrocardiogram;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@Dao
/* loaded from: classes12.dex */
public interface ElectrocardiogramDao {

    @XX({"SMAP\nElectrocardiogramDao.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ElectrocardiogramDao.kt\ncom/sma/smartv3/db/dao/ElectrocardiogramDao$DefaultImpls\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,44:1\n1855#2,2:45\n*S KotlinDebug\n*F\n+ 1 ElectrocardiogramDao.kt\ncom/sma/smartv3/db/dao/ElectrocardiogramDao$DefaultImpls\n*L\n34#1:45,2\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class DefaultImpls {
        @OOXIXo
        public static List<Electrocardiogram> getTestElectrocardiograms(@OOXIXo ElectrocardiogramDao electrocardiogramDao, long j, long j2) {
            if (TestData.INSTANCE.getTestElectrocardiograms().isEmpty()) {
                try {
                    Object fromJson = new Gson().fromJson(ResourceUtils.readAssets2String(ProductManager.OXxXX), new TypeToken<List<? extends Electrocardiogram>>() { // from class: com.sma.smartv3.db.dao.ElectrocardiogramDao$getTestElectrocardiograms$list$1
                    }.getType());
                    IIX0o.oO(fromJson, "fromJson(...)");
                    List list = (List) fromJson;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((Electrocardiogram) it.next()).setMTime(j);
                        j += 3600000;
                    }
                    TestData.INSTANCE.getTestElectrocardiograms().addAll(list);
                } catch (Exception unused) {
                }
            }
            return TestData.INSTANCE.getTestElectrocardiograms();
        }
    }

    @OOXIXo
    @Query("SELECT * FROM Electrocardiogram WHERE mTime >= :start AND mTime < :end AND mValue >= 50 AND mValue <= 220")
    List<Electrocardiogram> getElectrocardiograms(long j, long j2);

    @Query("SELECT * FROM Electrocardiogram ORDER BY mId DESC LIMIT 1")
    @oOoXoXO
    Electrocardiogram getLastElectrocardiogram();

    @OOXIXo
    List<Electrocardiogram> getTestElectrocardiograms(long j, long j2);

    @Insert(onConflict = 1)
    @OOXIXo
    long[] insert(@OOXIXo List<Electrocardiogram> list);
}
