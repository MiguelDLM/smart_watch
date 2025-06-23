package com.jieli.jl_fatfs.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class FatWriteOp implements Parcelable {
    public static final Parcelable.Creator<FatWriteOp> CREATOR = new Parcelable.Creator<FatWriteOp>() { // from class: com.jieli.jl_fatfs.model.FatWriteOp.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FatWriteOp createFromParcel(Parcel parcel) {
            return new FatWriteOp(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FatWriteOp[] newArray(int i) {
            return new FatWriteOp[i];
        }
    };
    private byte[] data;
    private int offset;
    private int size;

    public FatWriteOp() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getSize() {
        return this.size;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public void setSize(int i) {
        this.size = i;
    }

    public String toString() {
        return "FatWriteOp{offset=" + this.offset + ", size=" + this.size + ", data=" + CHexConver.byte2HexStr(this.data) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.offset);
        parcel.writeInt(this.size);
        parcel.writeByteArray(this.data);
    }

    public FatWriteOp(Parcel parcel) {
        this.offset = parcel.readInt();
        this.size = parcel.readInt();
        this.data = parcel.createByteArray();
    }
}
