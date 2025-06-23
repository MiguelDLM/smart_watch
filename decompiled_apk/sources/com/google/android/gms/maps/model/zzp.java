package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes9.dex */
public final class zzp implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        String str3 = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = 1.0f;
        float f7 = 0.0f;
        int i = 0;
        int i2 = 0;
        float f8 = 0.0f;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    latLng = (LatLng) SafeParcelReader.createParcelable(parcel, readHeader, LatLng.CREATOR);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    iBinder = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 6:
                    f = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 7:
                    f2 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 8:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 9:
                    z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 10:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 11:
                    f3 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 12:
                    f4 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 13:
                    f5 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 14:
                    f6 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 15:
                    f7 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 16:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 17:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 18:
                    iBinder2 = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 19:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 20:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 21:
                    f8 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new MarkerOptions(latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6, f7, i, iBinder2, i2, str3, f8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new MarkerOptions[i];
    }
}
