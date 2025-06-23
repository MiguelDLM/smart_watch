package com.google.android.gms.fitness.result;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

/* loaded from: classes9.dex */
public class DataReadResponse extends Response<DataReadResult> {
    @NonNull
    public List<Bucket> getBuckets() {
        return getResult().getBuckets();
    }

    @NonNull
    public DataSet getDataSet(@NonNull DataSource dataSource) {
        return getResult().getDataSet(dataSource);
    }

    @NonNull
    public List<DataSet> getDataSets() {
        return getResult().getDataSets();
    }

    @NonNull
    public Status getStatus() {
        return getResult().getStatus();
    }

    @NonNull
    public DataSet getDataSet(@NonNull DataType dataType) {
        return getResult().getDataSet(dataType);
    }
}
