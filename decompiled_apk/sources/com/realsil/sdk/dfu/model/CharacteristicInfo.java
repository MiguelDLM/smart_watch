package com.realsil.sdk.dfu.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes11.dex */
public class CharacteristicInfo implements Parcelable {
    public static final Parcelable.Creator<CharacteristicInfo> CREATOR = new Parcelable.Creator<CharacteristicInfo>() { // from class: com.realsil.sdk.dfu.model.CharacteristicInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CharacteristicInfo createFromParcel(Parcel parcel) {
            return new CharacteristicInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CharacteristicInfo[] newArray(int i) {
            return new CharacteristicInfo[i];
        }
    };
    public int key;
    public byte[] value;

    public CharacteristicInfo(int i, byte[] bArr) {
        this.key = i;
        this.value = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.key);
        parcel.writeByteArray(this.value);
    }

    public CharacteristicInfo(Parcel parcel) {
        this.key = parcel.readInt();
        this.value = parcel.createByteArray();
    }
}
