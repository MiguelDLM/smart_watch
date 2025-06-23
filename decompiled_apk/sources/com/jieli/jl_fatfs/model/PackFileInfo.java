package com.jieli.jl_fatfs.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes10.dex */
public class PackFileInfo implements Parcelable {
    public static final Parcelable.Creator<PackFileInfo> CREATOR = new Parcelable.Creator<PackFileInfo>() { // from class: com.jieli.jl_fatfs.model.PackFileInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PackFileInfo createFromParcel(Parcel parcel) {
            return new PackFileInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PackFileInfo[] newArray(int i) {
            return new PackFileInfo[i];
        }
    };
    private String fileName;
    private int offset;
    private int size;

    public PackFileInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getSize() {
        return this.size;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public void setSize(int i) {
        this.size = i;
    }

    public String toString() {
        return "PackFileInfo{fileName='" + this.fileName + "', offset=" + this.offset + ", size=" + this.size + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fileName);
        parcel.writeInt(this.offset);
        parcel.writeInt(this.size);
    }

    public PackFileInfo(Parcel parcel) {
        this.fileName = parcel.readString();
        this.offset = parcel.readInt();
        this.size = parcel.readInt();
    }
}
