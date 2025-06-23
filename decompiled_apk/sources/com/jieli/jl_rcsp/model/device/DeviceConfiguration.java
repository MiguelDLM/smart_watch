package com.jieli.jl_rcsp.model.device;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.interfaces.cmd.IDataOp;
import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class DeviceConfiguration implements IDataOp, Parcelable {
    public static final Parcelable.Creator<DeviceConfiguration> CREATOR = new Parcelable.Creator<DeviceConfiguration>() { // from class: com.jieli.jl_rcsp.model.device.DeviceConfiguration.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceConfiguration createFromParcel(Parcel parcel) {
            return new DeviceConfiguration(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceConfiguration[] newArray(int i) {
            return new DeviceConfiguration[i];
        }
    };
    public static final int FLAG_TWS_HEADSET = 1;
    public static final int FLAG_WATCH = 0;
    private byte[] data;
    private int type;
    private int version;

    public DeviceConfiguration() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getType() {
        return this.type;
    }

    public int getVersion() {
        return this.version;
    }

    @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public int parse(byte[] bArr) {
        this.data = new byte[0];
        if (bArr == null || bArr.length < 2) {
            return 0;
        }
        this.type = CHexConver.byteToInt(bArr[0]);
        this.version = CHexConver.byteToInt(bArr[1]);
        if (2 >= bArr.length) {
            return 2;
        }
        int length = bArr.length - 2;
        byte[] bArr2 = new byte[length];
        this.data = bArr2;
        System.arraycopy(bArr, 2, bArr2, 0, length);
        return 2 + parsePayload(this.data);
    }

    public int parsePayload(byte[] bArr) {
        return 0;
    }

    @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public byte[] toData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(this.type);
            byteArrayOutputStream.write(this.version);
            byte[] bArr = this.data;
            if (bArr != null) {
                byteArrayOutputStream.write(bArr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeInt(this.version);
        parcel.writeByteArray(this.data);
    }

    public DeviceConfiguration(int i, int i2, byte[] bArr) {
        this.type = i;
        this.version = i2;
        this.data = bArr;
    }

    public DeviceConfiguration(Parcel parcel) {
        this.type = parcel.readInt();
        this.version = parcel.readInt();
        this.data = parcel.createByteArray();
    }
}
