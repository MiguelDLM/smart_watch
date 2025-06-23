package com.google.android.gms.fitness.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.fitness.zzfy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes9.dex */
public final class LocalDataType {

    @NonNull
    public static final LocalDataType TYPE_CALORIES_EXPENDED;

    @NonNull
    public static final LocalDataType TYPE_DISTANCE_DELTA;

    @NonNull
    public static final LocalDataType TYPE_STEP_COUNT_DELTA;

    @NonNull
    @VisibleForTesting
    public static final Map zza;
    private final DataType zzb;

    static {
        DataType dataType = DataType.TYPE_STEP_COUNT_DELTA;
        LocalDataType localDataType = new LocalDataType(dataType);
        TYPE_STEP_COUNT_DELTA = localDataType;
        DataType dataType2 = DataType.TYPE_CALORIES_EXPENDED;
        LocalDataType localDataType2 = new LocalDataType(dataType2);
        TYPE_CALORIES_EXPENDED = localDataType2;
        DataType dataType3 = DataType.TYPE_DISTANCE_DELTA;
        LocalDataType localDataType3 = new LocalDataType(dataType3);
        TYPE_DISTANCE_DELTA = localDataType3;
        zzfy zzfyVar = new zzfy();
        zzfyVar.zza(dataType2, localDataType2);
        zzfyVar.zza(dataType3, localDataType3);
        zzfyVar.zza(dataType, localDataType);
        zza = zzfyVar.zzb();
    }

    public LocalDataType(DataType dataType) {
        this.zzb = dataType;
    }

    @NonNull
    public static LocalDataType zzb(@NonNull DataType dataType) {
        return (LocalDataType) Preconditions.checkNotNull((LocalDataType) zza.get(dataType));
    }

    @NonNull
    public static List zzc(@NonNull List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LocalDataType localDataType = (LocalDataType) zza.get((DataType) it.next());
            if (localDataType != null) {
                arrayList.add(localDataType);
            }
        }
        return arrayList;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocalDataType)) {
            return false;
        }
        LocalDataType localDataType = (LocalDataType) obj;
        if (this.zzb.getName().equals(localDataType.zzb.getName()) && this.zzb.getFields().equals(localDataType.zzb.getFields())) {
            return true;
        }
        return false;
    }

    @NonNull
    public List<LocalField> getFields() {
        List<Field> fields = this.zzb.getFields();
        ArrayList arrayList = new ArrayList();
        Iterator<Field> it = fields.iterator();
        while (it.hasNext()) {
            LocalField localField = (LocalField) LocalField.zza.get(it.next());
            if (localField != null) {
                arrayList.add(localField);
            }
        }
        return arrayList;
    }

    @NonNull
    public String getName() {
        return this.zzb.getName();
    }

    public int hashCode() {
        return this.zzb.getName().hashCode();
    }

    public int indexOf(@NonNull LocalField localField) {
        int indexOf = this.zzb.getFields().indexOf(localField.zza());
        boolean z = false;
        Object[] objArr = {localField, this};
        if (indexOf >= 0) {
            z = true;
        }
        Preconditions.checkArgument(z, "%s not a field of %s", objArr);
        return indexOf;
    }

    @NonNull
    public String toString() {
        return String.format("LocalDataType{%s%s}", this.zzb.getName(), getFields());
    }

    @NonNull
    public final DataType zza() {
        return this.zzb;
    }
}
