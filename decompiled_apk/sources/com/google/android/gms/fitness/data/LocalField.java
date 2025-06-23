package com.google.android.gms.fitness.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.fitness.zzfy;
import java.util.Map;

/* loaded from: classes9.dex */
public final class LocalField {

    @NonNull
    public static final LocalField FIELD_CALORIES;

    @NonNull
    public static final LocalField FIELD_DISTANCE;

    @NonNull
    public static final LocalField FIELD_STEPS;
    public static final int FORMAT_FLOAT = 2;
    public static final int FORMAT_INT32 = 1;

    @NonNull
    @VisibleForTesting
    public static final Map zza;
    private final Field zzb;

    static {
        Field field = Field.FIELD_STEPS;
        LocalField localField = new LocalField(field);
        FIELD_STEPS = localField;
        Field field2 = Field.FIELD_DISTANCE;
        LocalField localField2 = new LocalField(field2);
        FIELD_DISTANCE = localField2;
        Field field3 = Field.FIELD_CALORIES;
        LocalField localField3 = new LocalField(field3);
        FIELD_CALORIES = localField3;
        zzfy zzfyVar = new zzfy();
        zzfyVar.zza(field, localField);
        zzfyVar.zza(field2, localField2);
        zzfyVar.zza(field3, localField3);
        zza = zzfyVar.zzb();
    }

    @ShowFirstParty
    public LocalField(@NonNull Field field) {
        this.zzb = field;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocalField)) {
            return false;
        }
        return this.zzb.equals(((LocalField) obj).zzb);
    }

    public int getFormat() {
        return this.zzb.getFormat();
    }

    @NonNull
    public String getName() {
        return this.zzb.getName();
    }

    public int hashCode() {
        return this.zzb.hashCode();
    }

    @NonNull
    public String toString() {
        return this.zzb.toString();
    }

    @NonNull
    public final Field zza() {
        return this.zzb;
    }
}
