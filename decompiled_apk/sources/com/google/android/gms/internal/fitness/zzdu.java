package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
final class zzdu extends zzae {
    final /* synthetic */ DataReadRequest zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdu(zzdz zzdzVar, GoogleApiClient googleApiClient, DataReadRequest dataReadRequest) {
        super(googleApiClient);
        this.zza = dataReadRequest;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        DataReadRequest dataReadRequest = this.zza;
        List<DataType> dataTypes = dataReadRequest.getDataTypes();
        List<DataSource> dataSources = dataReadRequest.getDataSources();
        ArrayList arrayList = new ArrayList();
        Iterator<DataSource> it = dataSources.iterator();
        while (it.hasNext()) {
            arrayList.add(DataSet.builder(it.next()).build());
        }
        for (DataType dataType : dataTypes) {
            DataSource.Builder builder = new DataSource.Builder();
            builder.setType(1);
            builder.setDataType(dataType);
            builder.setStreamName("Default");
            arrayList.add(DataSet.builder(builder.build()).build());
        }
        return new DataReadResult(arrayList, Collections.emptyList(), status);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzcg) ((zzaj) anyClient).getService()).zzg(new DataReadRequest(this.zza, new zzdy(this, null)));
    }
}
