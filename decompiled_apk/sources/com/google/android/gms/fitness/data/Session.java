package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.fitness.zzgo;
import com.google.android.gms.internal.fitness.zzgp;
import com.huawei.openalliance.ad.constant.bn;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator = "SessionCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes9.dex */
public class Session extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<Session> CREATOR = new zzad();

    @NonNull
    public static final String EXTRA_SESSION = "vnd.google.fitness.session";

    @NonNull
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";

    @SafeParcelable.Field(getter = "getStartTimeMillis", id = 1)
    private final long zza;

    @SafeParcelable.Field(getter = "getEndTimeMillis", id = 2)
    private final long zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getName", id = 3)
    private final String zzc;

    @SafeParcelable.Field(getter = "getIdentifier", id = 4)
    private final String zzd;

    @SafeParcelable.Field(getter = "getDescription", id = 5)
    private final String zze;

    @SafeParcelable.Field(getter = "getActivityType", id = 7)
    private final int zzf;

    @SafeParcelable.Field(getter = "getApplication", id = 8)
    private final zzb zzg;

    @Nullable
    @SafeParcelable.Field(getter = "getActiveTimeMillis", id = 9)
    private final Long zzh;

    /* loaded from: classes9.dex */
    public static class Builder {
        private String zzd;

        @Nullable
        private Long zzg;
        private long zza = 0;
        private long zzb = 0;

        @Nullable
        private String zzc = null;
        private String zze = "";
        private int zzf = 4;

        @NonNull
        public Session build() {
            boolean z;
            boolean z2 = false;
            if (this.zza > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Start time should be specified.");
            long j = this.zzb;
            if (j == 0 || j > this.zza) {
                z2 = true;
            }
            Preconditions.checkState(z2, "End time should be later than start time.");
            if (this.zzd == null) {
                String str = this.zzc;
                if (str == null) {
                    str = "";
                }
                this.zzd = str + this.zza;
            }
            return new Session(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, null, this.zzg);
        }

        @NonNull
        public Builder setActiveTime(long j, @NonNull TimeUnit timeUnit) {
            this.zzg = Long.valueOf(timeUnit.toMillis(j));
            return this;
        }

        @NonNull
        public Builder setActivity(@NonNull String str) {
            boolean z;
            int zza = zzgo.zza(str);
            zzgp zza2 = zzgp.zza(zza, zzgp.UNKNOWN);
            if (zza2.zzb() && !zza2.equals(zzgp.SLEEP)) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(!z, "Unsupported session activity type %s.", Integer.valueOf(zza));
            this.zzf = zza;
            return this;
        }

        @NonNull
        public Builder setDescription(@NonNull String str) {
            boolean z = true;
            Object[] objArr = {1000};
            if (str.length() > 1000) {
                z = false;
            }
            Preconditions.checkArgument(z, "Session description cannot exceed %d characters", objArr);
            this.zze = str;
            return this;
        }

        @NonNull
        public Builder setEndTime(long j, @NonNull TimeUnit timeUnit) {
            boolean z;
            if (j >= 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "End time should be positive.");
            this.zzb = timeUnit.toMillis(j);
            return this;
        }

        @NonNull
        public Builder setIdentifier(@NonNull String str) {
            boolean z = false;
            if (str != null && TextUtils.getTrimmedLength(str) > 0) {
                z = true;
            }
            Preconditions.checkArgument(z);
            this.zzd = str;
            return this;
        }

        @NonNull
        public Builder setName(@NonNull String str) {
            boolean z = true;
            Object[] objArr = {100};
            if (str.length() > 100) {
                z = false;
            }
            Preconditions.checkArgument(z, "Session name cannot exceed %d characters", objArr);
            this.zzc = str;
            return this;
        }

        @NonNull
        public Builder setStartTime(long j, @NonNull TimeUnit timeUnit) {
            boolean z;
            if (j > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Start time should be positive.");
            this.zza = timeUnit.toMillis(j);
            return this;
        }
    }

    @SafeParcelable.Constructor
    public Session(@SafeParcelable.Param(id = 1) long j, @SafeParcelable.Param(id = 2) long j2, @Nullable @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 7) int i, @SafeParcelable.Param(id = 8) zzb zzbVar, @Nullable @SafeParcelable.Param(id = 9) Long l) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = str;
        this.zzd = str2;
        this.zze = str3;
        this.zzf = i;
        this.zzg = zzbVar;
        this.zzh = l;
    }

    @Nullable
    public static Session extract(@NonNull Intent intent) {
        if (intent == null) {
            return null;
        }
        return (Session) SafeParcelableSerializer.deserializeFromIntentExtra(intent, EXTRA_SESSION, CREATOR);
    }

    @NonNull
    public static String getMimeType(@NonNull String str) {
        return MIME_TYPE_PREFIX.concat(String.valueOf(str));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Session)) {
            return false;
        }
        Session session = (Session) obj;
        if (this.zza == session.zza && this.zzb == session.zzb && Objects.equal(this.zzc, session.zzc) && Objects.equal(this.zzd, session.zzd) && Objects.equal(this.zze, session.zze) && Objects.equal(this.zzg, session.zzg) && this.zzf == session.zzf) {
            return true;
        }
        return false;
    }

    public long getActiveTime(@NonNull TimeUnit timeUnit) {
        Long l = this.zzh;
        if (l != null) {
            return timeUnit.convert(l.longValue(), TimeUnit.MILLISECONDS);
        }
        throw new IllegalStateException("Active time is not set");
    }

    @NonNull
    public String getActivity() {
        return zzgo.zzb(this.zzf);
    }

    @Nullable
    public String getAppPackageName() {
        zzb zzbVar = this.zzg;
        if (zzbVar == null) {
            return null;
        }
        return zzbVar.zza();
    }

    @NonNull
    public String getDescription() {
        return this.zze;
    }

    public long getEndTime(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.zzb, TimeUnit.MILLISECONDS);
    }

    @NonNull
    public String getIdentifier() {
        return this.zzd;
    }

    @Nullable
    public String getName() {
        return this.zzc;
    }

    public long getStartTime(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.zza, TimeUnit.MILLISECONDS);
    }

    public boolean hasActiveTime() {
        return this.zzh != null;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Long.valueOf(this.zzb), this.zzd);
    }

    public boolean isOngoing() {
        return this.zzb == 0;
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add(bn.f.g, Long.valueOf(this.zza)).add("endTime", Long.valueOf(this.zzb)).add("name", this.zzc).add("identifier", this.zzd).add("description", this.zze).add(TTDownloadField.TT_ACTIVITY, Integer.valueOf(this.zzf)).add(MimeTypes.BASE_TYPE_APPLICATION, this.zzg).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        long j = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, j);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 3, getName(), false);
        SafeParcelWriter.writeString(parcel, 4, getIdentifier(), false);
        SafeParcelWriter.writeString(parcel, 5, getDescription(), false);
        SafeParcelWriter.writeInt(parcel, 7, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzg, i, false);
        SafeParcelWriter.writeLongObject(parcel, 9, this.zzh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
