package com.google.android.gms.fitness.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes9.dex */
public final class LocalDataSet {
    private final DataSet zza;

    public LocalDataSet(@NonNull DataSet dataSet) {
        this.zza = dataSet;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocalDataSet)) {
            return false;
        }
        return Objects.equal(this.zza, ((LocalDataSet) obj).zza);
    }

    @NonNull
    public List<LocalDataPoint> getDataPoints() {
        ArrayList arrayList = new ArrayList();
        Iterator<DataPoint> it = this.zza.getDataPoints().iterator();
        while (it.hasNext()) {
            arrayList.add(new LocalDataPoint(it.next()));
        }
        return arrayList;
    }

    @NonNull
    public LocalDataType getDataType() {
        return LocalDataType.zzb(this.zza.getDataType());
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    public boolean isEmpty() {
        return this.zza.getDataPoints().isEmpty();
    }

    @NonNull
    public String toString() {
        DataSet dataSet = this.zza;
        List zza = dataSet.zza();
        Locale locale = Locale.US;
        String zzb = dataSet.getDataSource().zzb();
        Object obj = zza;
        if (this.zza.getDataPoints().size() >= 10) {
            obj = String.format(locale, "%d data points, first 5: %s", Integer.valueOf(this.zza.getDataPoints().size()), zza.subList(0, 5));
        }
        return String.format(locale, "LocalDataSet{%s %s}", zzb, obj);
    }
}
