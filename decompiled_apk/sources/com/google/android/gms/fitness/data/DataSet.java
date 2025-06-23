package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@SafeParcelable.Class(creator = "DataSetCreator")
@SafeParcelable.Reserved({2, 5})
/* loaded from: classes9.dex */
public final class DataSet extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<DataSet> CREATOR = new zzi();

    @SafeParcelable.VersionField(getter = "getVersionCode", id = 1000)
    private final int zza;

    @SafeParcelable.Field(getter = "getDataSource", id = 1)
    private final DataSource zzb;

    @SafeParcelable.Field(getter = "getRawDataPoints", id = 3, type = "java.util.List")
    private final List zzc;

    @SafeParcelable.Field(getter = "getUniqueDataSources", id = 4)
    private final List zzd;

    /* loaded from: classes9.dex */
    public static class Builder {
        private final DataSet zza;
        private boolean zzb = false;

        public /* synthetic */ Builder(DataSource dataSource, zzh zzhVar) {
            this.zza = DataSet.create(dataSource);
        }

        @NonNull
        public Builder add(@NonNull DataPoint dataPoint) {
            Preconditions.checkState(!this.zzb, "Builder should not be mutated after calling #build.");
            this.zza.add(dataPoint);
            return this;
        }

        @NonNull
        public Builder addAll(@NonNull Iterable<DataPoint> iterable) {
            Preconditions.checkState(!this.zzb, "Builder should not be mutated after calling #build.");
            this.zza.addAll(iterable);
            return this;
        }

        @NonNull
        public DataSet build() {
            Preconditions.checkState(!this.zzb, "DataSet#build() should only be called once.");
            this.zzb = true;
            return this.zza;
        }
    }

    @SafeParcelable.Constructor
    public DataSet(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) DataSource dataSource, @SafeParcelable.Param(id = 3) List list, @SafeParcelable.Param(id = 4) List list2) {
        this.zza = i;
        this.zzb = dataSource;
        this.zzc = new ArrayList(list.size());
        this.zzd = i < 2 ? Collections.singletonList(dataSource) : list2;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.zzc.add(new DataPoint(this.zzd, (RawDataPoint) it.next()));
        }
    }

    @NonNull
    public static Builder builder(@NonNull DataSource dataSource) {
        Preconditions.checkNotNull(dataSource, "DataSource should be specified");
        return new Builder(dataSource, null);
    }

    @NonNull
    public static DataSet create(@NonNull DataSource dataSource) {
        Preconditions.checkNotNull(dataSource, "DataSource should be specified");
        return new DataSet(dataSource);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x068f, code lost:
    
        r1 = "DataPoint out of range";
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x068c, code lost:
    
        if (r5 == XIXIX.OOXIXo.f3760XO) goto L429;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void zzd(@androidx.annotation.NonNull com.google.android.gms.fitness.data.DataPoint r13) {
        /*
            Method dump skipped, instructions count: 2336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.data.DataSet.zzd(com.google.android.gms.fitness.data.DataPoint):void");
    }

    @Deprecated
    public void add(@NonNull DataPoint dataPoint) {
        DataSource dataSource = dataPoint.getDataSource();
        Preconditions.checkArgument(dataSource.getStreamIdentifier().equals(this.zzb.getStreamIdentifier()), "Conflicting data sources found %s vs %s", dataSource, this.zzb);
        dataPoint.zzf();
        zzd(dataPoint);
        zzc(dataPoint);
    }

    @Deprecated
    public void addAll(@NonNull Iterable<DataPoint> iterable) {
        Iterator<DataPoint> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @NonNull
    public DataPoint createDataPoint() {
        return DataPoint.create(this.zzb);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataSet)) {
            return false;
        }
        DataSet dataSet = (DataSet) obj;
        if (Objects.equal(this.zzb, dataSet.zzb) && Objects.equal(this.zzc, dataSet.zzc)) {
            return true;
        }
        return false;
    }

    @NonNull
    public List<DataPoint> getDataPoints() {
        return Collections.unmodifiableList(this.zzc);
    }

    @NonNull
    public DataSource getDataSource() {
        return this.zzb;
    }

    @NonNull
    public DataType getDataType() {
        return this.zzb.getDataType();
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb);
    }

    public boolean isEmpty() {
        return this.zzc.isEmpty();
    }

    @NonNull
    public String toString() {
        List zzb = zzb(this.zzd);
        Locale locale = Locale.US;
        String zzb2 = this.zzb.zzb();
        Object obj = zzb;
        if (this.zzc.size() >= 10) {
            obj = String.format(locale, "%d data points, first 5: %s", Integer.valueOf(this.zzc.size()), zzb.subList(0, 5));
        }
        return String.format(locale, "DataSet{%s %s}", zzb2, obj);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getDataSource(), i, false);
        SafeParcelWriter.writeList(parcel, 3, zzb(this.zzd), false);
        SafeParcelWriter.writeTypedList(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final List zza() {
        return zzb(this.zzd);
    }

    public final List zzb(List list) {
        ArrayList arrayList = new ArrayList(this.zzc.size());
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            arrayList.add(new RawDataPoint((DataPoint) it.next(), list));
        }
        return arrayList;
    }

    @ShowFirstParty
    @Deprecated
    public final void zzc(@NonNull DataPoint dataPoint) {
        this.zzc.add(dataPoint);
        DataSource originalDataSource = dataPoint.getOriginalDataSource();
        if (originalDataSource != null && !this.zzd.contains(originalDataSource)) {
            this.zzd.add(originalDataSource);
        }
    }

    @ShowFirstParty
    public DataSet(@NonNull DataSource dataSource) {
        this.zza = 3;
        DataSource dataSource2 = (DataSource) Preconditions.checkNotNull(dataSource);
        this.zzb = dataSource2;
        this.zzc = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.zzd = arrayList;
        arrayList.add(dataSource2);
    }

    public DataSet(@NonNull RawDataSet rawDataSet, @NonNull List list) {
        this.zza = 3;
        this.zzb = (DataSource) list.get(rawDataSet.zza);
        this.zzd = list;
        List list2 = rawDataSet.zzb;
        this.zzc = new ArrayList(list2.size());
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            this.zzc.add(new DataPoint(this.zzd, (RawDataPoint) it.next()));
        }
    }
}
