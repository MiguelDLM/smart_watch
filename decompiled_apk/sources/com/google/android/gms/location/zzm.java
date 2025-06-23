package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes9.dex */
public final class zzm implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        float[] fArr = null;
        float f = 0.0f;
        float f2 = 0.0f;
        byte b = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 1) {
                switch (fieldId) {
                    case 4:
                        f = SafeParcelReader.readFloat(parcel, readHeader);
                        break;
                    case 5:
                        f2 = SafeParcelReader.readFloat(parcel, readHeader);
                        break;
                    case 6:
                        j = SafeParcelReader.readLong(parcel, readHeader);
                        break;
                    case 7:
                        b = SafeParcelReader.readByte(parcel, readHeader);
                        break;
                    case 8:
                        f3 = SafeParcelReader.readFloat(parcel, readHeader);
                        break;
                    case 9:
                        f4 = SafeParcelReader.readFloat(parcel, readHeader);
                        break;
                    default:
                        SafeParcelReader.skipUnknownField(parcel, readHeader);
                        break;
                }
            } else {
                fArr = SafeParcelReader.createFloatArray(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new DeviceOrientation(fArr, f, f2, j, b, f3, f4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new DeviceOrientation[i];
    }
}
