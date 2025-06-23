package com.jieli.jl_rcsp.model.device.settings;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.interfaces.cmd.IDataOp;
import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class SettingData implements IDataOp, Parcelable {
    public static final Parcelable.Creator<SettingData> CREATOR = new Parcelable.Creator<SettingData>() { // from class: com.jieli.jl_rcsp.model.device.settings.SettingData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SettingData createFromParcel(Parcel parcel) {
            return new SettingData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SettingData[] newArray(int i) {
            return new SettingData[i];
        }
    };
    private byte[] data;
    private int version;

    public SettingData(byte[] bArr) {
        this.data = new byte[0];
        parse(bArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getVersion() {
        return this.version;
    }

    @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public int parse(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return 0;
        }
        this.version = CHexConver.byteToInt(bArr[0]);
        if (bArr.length > 1) {
            int length = bArr.length - 1;
            byte[] bArr2 = new byte[length];
            this.data = bArr2;
            System.arraycopy(bArr, 1, bArr2, 0, length);
        }
        return bArr.length;
    }

    @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public byte[] toData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(this.version);
            byteArrayOutputStream.write(this.data);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return "SettingData{version=" + this.version + ", data=" + CHexConver.byte2HexStr(this.data) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.version);
        parcel.writeByteArray(this.data);
    }

    public SettingData(int i, byte[] bArr) {
        this.version = i;
        this.data = bArr;
    }

    public SettingData(Parcel parcel) {
        this.version = parcel.readInt();
        this.data = parcel.createByteArray();
    }
}
