package com.jieli.jl_rcsp.model.device;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class AuditionParam implements Parcelable {
    public static final Parcelable.Creator<AuditionParam> CREATOR = new Parcelable.Creator<AuditionParam>() { // from class: com.jieli.jl_rcsp.model.device.AuditionParam.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuditionParam createFromParcel(Parcel parcel) {
            return new AuditionParam(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuditionParam[] newArray(int i) {
            return new AuditionParam[i];
        }
    };
    private int cluster;
    private byte dev;
    private String name;
    private byte op;
    private byte type;

    public AuditionParam() {
        this.op = (byte) 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCluster() {
        return this.cluster;
    }

    public byte[] getData() {
        byte[] bArr = {this.op, this.type, this.dev};
        System.arraycopy(CHexConver.intToBigBytes(this.cluster), 0, bArr, 3, 4);
        return bArr;
    }

    public byte getDev() {
        return this.dev;
    }

    public String getName() {
        return this.name;
    }

    public byte getOp() {
        return this.op;
    }

    public byte getType() {
        return this.type;
    }

    public void setCluster(int i) {
        this.cluster = i;
    }

    public void setDev(byte b) {
        this.dev = b;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(byte b) {
        this.type = b;
    }

    public String toString() {
        return "AuditionParam{op=" + ((int) this.op) + ", type=" + ((int) this.type) + ", dev=" + ((int) this.dev) + ", cluster=" + this.cluster + ", name='" + this.name + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.op);
        parcel.writeByte(this.type);
        parcel.writeByte(this.dev);
        parcel.writeInt(this.cluster);
        parcel.writeString(this.name);
    }

    public AuditionParam(Parcel parcel) {
        this.op = parcel.readByte();
        this.type = parcel.readByte();
        this.dev = parcel.readByte();
        this.cluster = parcel.readInt();
        this.name = parcel.readString();
    }
}
