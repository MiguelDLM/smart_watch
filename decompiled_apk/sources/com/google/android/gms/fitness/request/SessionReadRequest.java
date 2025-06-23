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
import com.google.android.gms.internal.fitness.zzcp;
import com.google.android.gms.internal.fitness.zzcq;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator = "SessionReadRequestCreator")
@SafeParcelable.Reserved({11, 1000})
/* loaded from: classes9.dex */
public class SessionReadRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<SessionReadRequest> CREATOR = new zzar();

    @SafeParcelable.Field(getter = "getSessionName", id = 1)
    private final String zza;

    @SafeParcelable.Field(getter = "getSessionId", id = 2)
    private final String zzb;

    @SafeParcelable.Field(getter = "getStartTimeMillis", id = 3)
    private final long zzc;

    @SafeParcelable.Field(getter = "getEndTimeMillis", id = 4)
    private final long zzd;

    @SafeParcelable.Field(getter = "getDataTypes", id = 5)
    private final List zze;

    @SafeParcelable.Field(getter = "getDataSources", id = 6)
    private final List zzf;

    @SafeParcelable.Field(getter = "includeSessionsFromAllApps", id = 7)
    private final boolean zzg;

    @SafeParcelable.Field(getter = "areServerQueriesEnabled", id = 8)
    private final boolean zzh;

    @SafeParcelable.Field(getter = "getExcludedPackages", id = 9)
    private final List zzi;

    @Nullable
    @SafeParcelable.Field(getter = "getCallbackBinder", id = 10, type = "android.os.IBinder")
    private final zzcq zzj;

    @SafeParcelable.Field(defaultValue = "true", getter = "areActivitySessionsIncluded", id = 12)
    private final boolean zzk;

    @SafeParcelable.Field(defaultValue = "false", getter = "areSleepSessionsIncluded", id = 13)
    private final boolean zzl;

    /* JADX WARN: Multi-variable type inference failed */
    public SessionReadRequest(SessionReadRequest sessionReadRequest, zzcq zzcqVar) {
        this(sessionReadRequest.zza, sessionReadRequest.zzb, sessionReadRequest.zzc, sessionReadRequest.zzd, sessionReadRequest.zze, sessionReadRequest.zzf, sessionReadRequest.zzg, sessionReadRequest.zzh, sessionReadRequest.zzi, zzcqVar, sessionReadRequest.zzk, sessionReadRequest.zzl);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionReadRequest)) {
            return false;
        }
        SessionReadRequest sessionReadRequest = (SessionReadRequest) obj;
        if (Objects.equal(this.zza, sessionReadRequest.zza) && this.zzb.equals(sessionReadRequest.zzb) && this.zzc == sessionReadRequest.zzc && this.zzd == sessionReadRequest.zzd && Objects.equal(this.zze, sessionReadRequest.zze) && Objects.equal(this.zzf, sessionReadRequest.zzf) && this.zzg == sessionReadRequest.zzg && this.zzi.equals(sessionReadRequest.zzi) && this.zzh == sessionReadRequest.zzh && this.zzk == sessionReadRequest.zzk && this.zzl == sessionReadRequest.zzl) {
            return true;
        }
        return false;
    }

    @NonNull
    public List<DataSource> getDataSources() {
        return this.zzf;
    }

    @NonNull
    public List<DataType> getDataTypes() {
        return this.zze;
    }

    public long getEndTime(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.zzd, TimeUnit.MILLISECONDS);
    }

    @NonNull
    public List<String> getExcludedPackages() {
        return this.zzi;
    }

    @Nullable
    public String getSessionId() {
        return this.zzb;
    }

    @Nullable
    public String getSessionName() {
        return this.zza;
    }

    public long getStartTime(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.zzc, TimeUnit.MILLISECONDS);
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Long.valueOf(this.zzc), Long.valueOf(this.zzd));
    }

    public boolean includeSessionsFromAllApps() {
        return this.zzg;
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add("sessionName", this.zza).add("sessionId", this.zzb).add("startTimeMillis", Long.valueOf(this.zzc)).add("endTimeMillis", Long.valueOf(this.zzd)).add("dataTypes", this.zze).add("dataSources", this.zzf).add("sessionsFromAllApps", Boolean.valueOf(this.zzg)).add("excludedPackages", this.zzi).add("useServer", Boolean.valueOf(this.zzh)).add("activitySessionsIncluded", Boolean.valueOf(this.zzk)).add("sleepSessionsIncluded", Boolean.valueOf(this.zzl)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        IBinder asBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getSessionName(), false);
        SafeParcelWriter.writeString(parcel, 2, getSessionId(), false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzc);
        SafeParcelWriter.writeLong(parcel, 4, this.zzd);
        SafeParcelWriter.writeTypedList(parcel, 5, getDataTypes(), false);
        SafeParcelWriter.writeTypedList(parcel, 6, getDataSources(), false);
        SafeParcelWriter.writeBoolean(parcel, 7, includeSessionsFromAllApps());
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.writeStringList(parcel, 9, getExcludedPackages(), false);
        zzcq zzcqVar = this.zzj;
        if (zzcqVar == null) {
            asBinder = null;
        } else {
            asBinder = zzcqVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 10, asBinder, false);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzk);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzl);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* loaded from: classes9.dex */
    public static class Builder {
        private String zza;
        private String zzb;
        private long zzc = 0;
        private long zzd = 0;
        private final List zze = new ArrayList();
        private final List zzf = new ArrayList();
        private boolean zzg = false;
        private boolean zzh = false;
        private final List zzi = new ArrayList();
        private boolean zzj = false;
        private boolean zzk = false;
        private boolean zzl = false;

        @NonNull
        public SessionReadRequest build() {
            boolean z;
            boolean z2;
            long j = this.zzc;
            Object[] objArr = {Long.valueOf(j)};
            if (j > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Invalid start time: %s", objArr);
            long j2 = this.zzd;
            if (j2 > 0 && j2 > this.zzc) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "Invalid end time: %s", Long.valueOf(j2));
            if (!this.zzl) {
                this.zzj = true;
            }
            return new SessionReadRequest(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, null, this.zzj, this.zzk);
        }

        @NonNull
        public Builder enableServerQueries() {
            this.zzh = true;
            return this;
        }

        @NonNull
        public Builder excludePackage(@NonNull String str) {
            Preconditions.checkNotNull(str, "Attempting to use a null package name");
            if (!this.zzi.contains(str)) {
                this.zzi.add(str);
            }
            return this;
        }

        @NonNull
        public Builder includeActivitySessions() {
            this.zzj = true;
            this.zzl = true;
            return this;
        }

        @NonNull
        public Builder includeSleepSessions() {
            this.zzk = true;
            this.zzl = true;
            return this;
        }

        @NonNull
        public Builder read(@NonNull DataSource dataSource) {
            Preconditions.checkNotNull(dataSource, "Attempting to add a null data source");
            if (!this.zzf.contains(dataSource)) {
                this.zzf.add(dataSource);
            }
            return this;
        }

        @NonNull
        public Builder readSessionsFromAllApps() {
            this.zzg = true;
            return this;
        }

        @NonNull
        public Builder setSessionId(@NonNull String str) {
            this.zzb = str;
            return this;
        }

        @NonNull
        public Builder setSessionName(@NonNull String str) {
            this.zza = str;
            return this;
        }

        @NonNull
        public Builder setTimeInterval(long j, long j2, @NonNull TimeUnit timeUnit) {
            this.zzc = timeUnit.toMillis(j);
            this.zzd = timeUnit.toMillis(j2);
            return this;
        }

        @NonNull
        public Builder read(@NonNull DataType dataType) {
            Preconditions.checkNotNull(dataType, "Attempting to use a null data type");
            if (!this.zze.contains(dataType)) {
                this.zze.add(dataType);
            }
            return this;
        }
    }

    @SafeParcelable.Constructor
    public SessionReadRequest(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) long j2, @SafeParcelable.Param(id = 5) List list, @SafeParcelable.Param(id = 6) List list2, @SafeParcelable.Param(id = 7) boolean z, @SafeParcelable.Param(id = 8) boolean z2, @SafeParcelable.Param(id = 9) List list3, @Nullable @SafeParcelable.Param(id = 10) IBinder iBinder, @SafeParcelable.Param(id = 12) boolean z3, @SafeParcelable.Param(id = 13) boolean z4) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = j2;
        this.zze = list;
        this.zzf = list2;
        this.zzg = z;
        this.zzh = z2;
        this.zzi = list3;
        this.zzj = iBinder == null ? null : zzcp.zzb(iBinder);
        this.zzk = z3;
        this.zzl = z4;
    }
}
