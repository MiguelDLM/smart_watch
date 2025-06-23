package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes9.dex */
public final class zzg implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        DataSource dataSource = null;
        Value[] valueArr = null;
        DataSource dataSource2 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 1) {
                if (fieldId != 3) {
                    if (fieldId != 4) {
                        if (fieldId != 5) {
                            if (fieldId != 6) {
                                if (fieldId != 7) {
                                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                                } else {
                                    j3 = SafeParcelReader.readLong(parcel, readHeader);
                                }
                            } else {
                                dataSource2 = (DataSource) SafeParcelReader.createParcelable(parcel, readHeader, DataSource.CREATOR);
                            }
                        } else {
                            valueArr = (Value[]) SafeParcelReader.createTypedArray(parcel, readHeader, Value.CREATOR);
                        }
                    } else {
                        j2 = SafeParcelReader.readLong(parcel, readHeader);
                    }
                } else {
                    j = SafeParcelReader.readLong(parcel, readHeader);
                }
            } else {
                dataSource = (DataSource) SafeParcelReader.createParcelable(parcel, readHeader, DataSource.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new DataPoint(dataSource, j, j2, valueArr, dataSource2, j3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new DataPoint[i];
    }
}
