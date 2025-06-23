package com.google.android.gms.fitness.result;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.LocalBucket;
import com.google.android.gms.fitness.data.LocalDataSet;
import com.google.android.gms.fitness.data.LocalDataType;
import com.google.android.gms.fitness.data.zzw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes9.dex */
public class LocalDataReadResponse extends Response<DataReadResult> {
    public LocalDataReadResponse() {
    }

    @NonNull
    public List<LocalBucket> getBuckets() {
        List<Bucket> buckets = getResult().getBuckets();
        ArrayList arrayList = new ArrayList();
        for (Bucket bucket : buckets) {
            zzw zzwVar = new zzw();
            zzwVar.zzb(bucket.getBucketType());
            zzwVar.zzc(bucket.zzc(), bucket.zzb(), TimeUnit.MILLISECONDS);
            Iterator<DataSet> it = bucket.getDataSets().iterator();
            while (it.hasNext()) {
                zzwVar.zza(new LocalDataSet(it.next()));
            }
            arrayList.add(zzwVar.zzd());
        }
        return arrayList;
    }

    @NonNull
    public LocalDataSet getDataSet(@NonNull LocalDataType localDataType) {
        return new LocalDataSet(getResult().getDataSet(localDataType.zza()));
    }

    @NonNull
    public List<LocalDataSet> getDataSets() {
        ArrayList arrayList = new ArrayList();
        Iterator<DataSet> it = getResult().getDataSets().iterator();
        while (it.hasNext()) {
            arrayList.add(new LocalDataSet(it.next()));
        }
        return arrayList;
    }

    @NonNull
    public Status getStatus() {
        return getResult().getStatus();
    }

    @ShowFirstParty
    public LocalDataReadResponse(@NonNull DataReadResult dataReadResult) {
        super(dataReadResult);
    }
}
