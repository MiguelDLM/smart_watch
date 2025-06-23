package com.google.android.gms.fitness;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.concurrent.TimeUnit;

@Deprecated
/* loaded from: classes9.dex */
public interface HistoryApi {

    /* loaded from: classes9.dex */
    public static class ViewIntentBuilder {
        private final Context zza;
        private final DataType zzb;
        private DataSource zzc;
        private long zzd;
        private long zze;
        private String zzf;

        public ViewIntentBuilder(@NonNull Context context, @NonNull DataType dataType) {
            this.zza = context;
            this.zzb = dataType;
        }

        @NonNull
        public Intent build() {
            boolean z;
            Intent intent;
            ResolveInfo resolveActivity;
            boolean z2 = true;
            if (this.zzd > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Start time must be set");
            if (this.zze <= this.zzd) {
                z2 = false;
            }
            Preconditions.checkState(z2, "End time must be set and after start time");
            Intent intent2 = new Intent(Fitness.ACTION_VIEW);
            intent2.setType(DataType.getMimeType(this.zzc.getDataType()));
            intent2.putExtra(Fitness.EXTRA_START_TIME, this.zzd);
            intent2.putExtra(Fitness.EXTRA_END_TIME, this.zze);
            SafeParcelableSerializer.serializeToIntentExtra(this.zzc, intent2, DataSource.EXTRA_DATA_SOURCE);
            if (this.zzf != null && (resolveActivity = this.zza.getPackageManager().resolveActivity((intent = new Intent(intent2).setPackage(this.zzf)), 0)) != null) {
                intent.setComponent(new ComponentName(this.zzf, resolveActivity.activityInfo.name));
                return intent;
            }
            return intent2;
        }

        @NonNull
        public ViewIntentBuilder setDataSource(@NonNull DataSource dataSource) {
            Preconditions.checkArgument(dataSource.getDataType().equals(this.zzb), "Data source %s is not for the data type %s", dataSource, this.zzb);
            this.zzc = dataSource;
            return this;
        }

        @NonNull
        public ViewIntentBuilder setPreferredApplication(@NonNull String str) {
            this.zzf = str;
            return this;
        }

        @NonNull
        public ViewIntentBuilder setTimeInterval(long j, long j2, @NonNull TimeUnit timeUnit) {
            this.zzd = timeUnit.toMillis(j);
            this.zze = timeUnit.toMillis(j2);
            return this;
        }
    }

    @NonNull
    PendingResult<Status> deleteData(@NonNull GoogleApiClient googleApiClient, @NonNull DataDeleteRequest dataDeleteRequest);

    @NonNull
    PendingResult<Status> insertData(@NonNull GoogleApiClient googleApiClient, @NonNull DataSet dataSet);

    @NonNull
    PendingResult<DailyTotalResult> readDailyTotal(@NonNull GoogleApiClient googleApiClient, @NonNull DataType dataType);

    @NonNull
    PendingResult<DailyTotalResult> readDailyTotalFromLocalDevice(@NonNull GoogleApiClient googleApiClient, @NonNull DataType dataType);

    @NonNull
    PendingResult<DataReadResult> readData(@NonNull GoogleApiClient googleApiClient, @NonNull DataReadRequest dataReadRequest);

    @NonNull
    PendingResult<Status> registerDataUpdateListener(@NonNull GoogleApiClient googleApiClient, @NonNull DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest);

    @NonNull
    PendingResult<Status> unregisterDataUpdateListener(@NonNull GoogleApiClient googleApiClient, @NonNull PendingIntent pendingIntent);

    @NonNull
    PendingResult<Status> updateData(@NonNull GoogleApiClient googleApiClient, @NonNull DataUpdateRequest dataUpdateRequest);
}
