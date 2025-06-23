package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.fitness.zzcv;
import com.google.android.gms.internal.fitness.zzcw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator = "DataDeleteRequestCreator")
@SafeParcelable.Reserved({9, 1000})
/* loaded from: classes9.dex */
public class DataDeleteRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<DataDeleteRequest> CREATOR = new zzj();

    @SafeParcelable.Field(getter = "getStartTimeMillis", id = 1)
    private final long zza;

    @SafeParcelable.Field(getter = "getEndTimeMillis", id = 2)
    private final long zzb;

    @SafeParcelable.Field(getter = "getDataSources", id = 3)
    private final List zzc;

    @SafeParcelable.Field(getter = "getDataTypes", id = 4)
    private final List zzd;

    @SafeParcelable.Field(getter = "getSessions", id = 5)
    private final List zze;

    @SafeParcelable.Field(getter = "deleteAllData", id = 6)
    private final boolean zzf;

    @SafeParcelable.Field(getter = "deleteAllSessions", id = 7)
    private final boolean zzg;

    @Nullable
    @SafeParcelable.Field(getter = "getCallbackBinder", id = 8, type = "android.os.IBinder")
    private final zzcw zzh;

    @SafeParcelable.Field(getter = "deleteByTimeRange", id = 10)
    private final boolean zzi;

    @SafeParcelable.Field(getter = "enableLocationCleanup", id = 11)
    private final boolean zzj;

    /* loaded from: classes9.dex */
    public static class Builder {
        private long zza;
        private long zzb;
        private final List zzc = new ArrayList();
        private final List zzd = new ArrayList();
        private final List zze = new ArrayList();
        private boolean zzf = false;
        private boolean zzg = false;

        @NonNull
        public Builder addDataSource(@NonNull DataSource dataSource) {
            boolean z = true;
            Preconditions.checkArgument(!this.zzf, "All data is already marked for deletion.  addDataSource() cannot be combined with deleteAllData()");
            if (dataSource == null) {
                z = false;
            }
            Preconditions.checkArgument(z, "Must specify a valid data source");
            if (!this.zzc.contains(dataSource)) {
                this.zzc.add(dataSource);
            }
            return this;
        }

        @NonNull
        public Builder addDataType(@NonNull DataType dataType) {
            boolean z = true;
            Preconditions.checkArgument(!this.zzf, "All data is already marked for deletion.  addDataType() cannot be combined with deleteAllData()");
            if (dataType == null) {
                z = false;
            }
            Preconditions.checkArgument(z, "Must specify a valid data type");
            if (!this.zzd.contains(dataType)) {
                this.zzd.add(dataType);
            }
            return this;
        }

        @NonNull
        public Builder addSession(@NonNull Session session) {
            boolean z;
            boolean z2 = true;
            Preconditions.checkArgument(!this.zzg, "All sessions already marked for deletion.  addSession() cannot be combined with deleteAllSessions()");
            if (session != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Must specify a valid session");
            if (session.getEndTime(TimeUnit.MILLISECONDS) <= 0) {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "Cannot delete an ongoing session. Please stop the session prior to deleting it");
            this.zze.add(session);
            return this;
        }

        @NonNull
        public DataDeleteRequest build() {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            long j = this.zza;
            if (j > 0 && this.zzb > j) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Must specify a valid time interval");
            if (this.zzf || !this.zzc.isEmpty() || !this.zzd.isEmpty()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.zzg || !this.zze.isEmpty()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z2 || z3) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkState(z4, "No data or session marked for deletion");
            if (!this.zze.isEmpty()) {
                for (Session session : this.zze) {
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    if (session.getStartTime(timeUnit) >= this.zza && session.getEndTime(timeUnit) <= this.zzb) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    Preconditions.checkState(z5, "Session %s is outside the time interval [%d, %d]", session, Long.valueOf(this.zza), Long.valueOf(this.zzb));
                }
            }
            return new DataDeleteRequest(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, false, false, (zzcw) null);
        }

        @NonNull
        public Builder deleteAllData() {
            Preconditions.checkArgument(this.zzd.isEmpty(), "Specific data type already added for deletion. deleteAllData() will delete all data types and cannot be combined with addDataType()");
            Preconditions.checkArgument(this.zzc.isEmpty(), "Specific data source already added for deletion. deleteAllData() will delete all data sources and cannot be combined with addDataSource()");
            this.zzf = true;
            return this;
        }

        @NonNull
        public Builder deleteAllSessions() {
            Preconditions.checkArgument(this.zze.isEmpty(), "Specific session already added for deletion. deleteAllData() will delete all sessions and cannot be combined with addSession()");
            this.zzg = true;
            return this;
        }

        @NonNull
        public Builder setTimeInterval(long j, long j2, @NonNull TimeUnit timeUnit) {
            boolean z;
            boolean z2 = true;
            Object[] objArr = {Long.valueOf(j)};
            if (j > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Invalid start time: %d", objArr);
            Object[] objArr2 = {Long.valueOf(j2)};
            if (j2 <= j) {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "Invalid end time: %d", objArr2);
            this.zza = timeUnit.toMillis(j);
            this.zzb = timeUnit.toMillis(j2);
            return this;
        }
    }

    @SafeParcelable.Constructor
    public DataDeleteRequest(@SafeParcelable.Param(id = 1) long j, @SafeParcelable.Param(id = 2) long j2, @SafeParcelable.Param(id = 3) List list, @SafeParcelable.Param(id = 4) List list2, @SafeParcelable.Param(id = 5) List list3, @SafeParcelable.Param(id = 6) boolean z, @SafeParcelable.Param(id = 7) boolean z2, @SafeParcelable.Param(id = 10) boolean z3, @SafeParcelable.Param(id = 11) boolean z4, @Nullable @SafeParcelable.Param(id = 8) IBinder iBinder) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = Collections.unmodifiableList(list);
        this.zzd = Collections.unmodifiableList(list2);
        this.zze = list3;
        this.zzf = z;
        this.zzg = z2;
        this.zzi = z3;
        this.zzj = z4;
        this.zzh = iBinder == null ? null : zzcv.zzc(iBinder);
    }

    public boolean deleteAllData() {
        return this.zzf;
    }

    public boolean deleteAllSessions() {
        return this.zzg;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataDeleteRequest)) {
            return false;
        }
        DataDeleteRequest dataDeleteRequest = (DataDeleteRequest) obj;
        if (this.zza == dataDeleteRequest.zza && this.zzb == dataDeleteRequest.zzb && Objects.equal(this.zzc, dataDeleteRequest.zzc) && Objects.equal(this.zzd, dataDeleteRequest.zzd) && Objects.equal(this.zze, dataDeleteRequest.zze) && this.zzf == dataDeleteRequest.zzf && this.zzg == dataDeleteRequest.zzg && this.zzi == dataDeleteRequest.zzi && this.zzj == dataDeleteRequest.zzj) {
            return true;
        }
        return false;
    }

    @NonNull
    public List<DataSource> getDataSources() {
        return this.zzc;
    }

    @NonNull
    public List<DataType> getDataTypes() {
        return this.zzd;
    }

    public long getEndTime(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.zzb, TimeUnit.MILLISECONDS);
    }

    @NonNull
    public List<Session> getSessions() {
        return this.zze;
    }

    public long getStartTime(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.zza, TimeUnit.MILLISECONDS);
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Long.valueOf(this.zzb));
    }

    @NonNull
    public String toString() {
        Objects.ToStringHelper add = Objects.toStringHelper(this).add("startTimeMillis", Long.valueOf(this.zza)).add("endTimeMillis", Long.valueOf(this.zzb)).add("dataSources", this.zzc).add("dateTypes", this.zzd).add("sessions", this.zze).add("deleteAllData", Boolean.valueOf(this.zzf)).add("deleteAllSessions", Boolean.valueOf(this.zzg));
        if (this.zzi) {
            add.add("deleteByTimeRange", Boolean.TRUE);
        }
        return add.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        IBinder asBinder;
        long j = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, j);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeTypedList(parcel, 3, getDataSources(), false);
        SafeParcelWriter.writeTypedList(parcel, 4, getDataTypes(), false);
        SafeParcelWriter.writeTypedList(parcel, 5, getSessions(), false);
        SafeParcelWriter.writeBoolean(parcel, 6, deleteAllData());
        SafeParcelWriter.writeBoolean(parcel, 7, deleteAllSessions());
        zzcw zzcwVar = this.zzh;
        if (zzcwVar == null) {
            asBinder = null;
        } else {
            asBinder = zzcwVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 8, asBinder, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzj);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public DataDeleteRequest(long j, long j2, List list, List list2, List list3, boolean z, boolean z2, boolean z3, boolean z4, @Nullable zzcw zzcwVar) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = Collections.unmodifiableList(list);
        this.zzd = Collections.unmodifiableList(list2);
        this.zze = list3;
        this.zzf = z;
        this.zzg = z2;
        this.zzi = z3;
        this.zzj = z4;
        this.zzh = zzcwVar;
    }

    public DataDeleteRequest(DataDeleteRequest dataDeleteRequest, zzcw zzcwVar) {
        this(dataDeleteRequest.zza, dataDeleteRequest.zzb, dataDeleteRequest.zzc, dataDeleteRequest.zzd, dataDeleteRequest.zze, dataDeleteRequest.zzf, dataDeleteRequest.zzg, dataDeleteRequest.zzi, dataDeleteRequest.zzj, zzcwVar);
    }
}
