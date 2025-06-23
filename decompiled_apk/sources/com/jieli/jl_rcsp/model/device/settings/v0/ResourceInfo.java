package com.jieli.jl_rcsp.model.device.settings.v0;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.interfaces.cmd.IDataOp;
import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class ResourceInfo implements IDataOp, Parcelable {
    public static final Parcelable.Creator<ResourceInfo> CREATOR = new Parcelable.Creator<ResourceInfo>() { // from class: com.jieli.jl_rcsp.model.device.settings.v0.ResourceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ResourceInfo createFromParcel(Parcel parcel) {
            return new ResourceInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ResourceInfo[] newArray(int i) {
            return new ResourceInfo[i];
        }
    };
    private int cluster;
    private short crc;
    private int devHandle;
    private String filePath;

    public ResourceInfo(byte[] bArr) {
        parse(bArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCluster() {
        return this.cluster;
    }

    public short getCrc() {
        return this.crc;
    }

    public int getDevHandle() {
        return this.devHandle;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getFilename() {
        int lastIndexOf = this.filePath.lastIndexOf("/");
        if (lastIndexOf > -1 && lastIndexOf < this.filePath.length()) {
            return this.filePath.substring(lastIndexOf + 1);
        }
        return this.filePath;
    }

    @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public int parse(byte[] bArr) {
        this.filePath = "";
        if (bArr == null || bArr.length < 12) {
            return 0;
        }
        this.devHandle = CHexConver.bytesToInt(bArr, 0, 4);
        this.cluster = CHexConver.bytesToInt(bArr, 4, 4);
        this.crc = CHexConver.bytesToShort(bArr, 8);
        int bytesToInt = CHexConver.bytesToInt(bArr, 10, 2);
        int i = bytesToInt + 12;
        if (i > bArr.length) {
            return 12;
        }
        try {
            this.filePath = new String(bArr, 12, bytesToInt);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 12;
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public byte[] toData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(CHexConver.intToBigBytes(this.devHandle));
            byteArrayOutputStream.write(CHexConver.intToBigBytes(this.cluster));
            byteArrayOutputStream.write(CHexConver.shortToBigBytes(this.crc));
            byteArrayOutputStream.write(CHexConver.int2byte2(this.filePath.getBytes().length));
            byteArrayOutputStream.write(this.filePath.getBytes());
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return "ResourceInfo{devHandle=" + this.devHandle + ", cluster=" + this.cluster + ", crc=" + ((int) this.crc) + ", filePath='" + this.filePath + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.devHandle);
        parcel.writeInt(this.cluster);
        parcel.writeInt(this.crc);
        parcel.writeString(this.filePath);
    }

    public ResourceInfo(int i, String str) {
        this(i, 0, (short) 0, str);
    }

    public ResourceInfo(int i, int i2, short s, String str) {
        str = str == null ? "" : str;
        this.devHandle = i;
        this.cluster = i2;
        this.crc = s;
        this.filePath = str;
    }

    public ResourceInfo(Parcel parcel) {
        this.devHandle = parcel.readInt();
        this.cluster = parcel.readInt();
        this.crc = (short) parcel.readInt();
        this.filePath = parcel.readString();
    }
}
