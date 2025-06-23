package com.jieli.jl_rcsp.model.device.settings.v0;

import android.bluetooth.BluetoothAdapter;
import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.interfaces.cmd.IDataOp;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.RcspUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class DeviceState implements IDataOp, Parcelable {
    public static final Parcelable.Creator<DeviceState> CREATOR = new Parcelable.Creator<DeviceState>() { // from class: com.jieli.jl_rcsp.model.device.settings.v0.DeviceState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceState createFromParcel(Parcel parcel) {
            return new DeviceState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceState[] newArray(int i) {
            return new DeviceState[i];
        }
    };
    public static final String INVALID_ADDRESS = "00:00:00:00:00:00";
    private String bleAddress;
    private String classAddress;
    private int connectWay;
    private int state;
    private int type;

    public DeviceState(byte[] bArr) {
        parse(bArr);
    }

    public static boolean isValidAddress(String str) {
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            return false;
        }
        return !INVALID_ADDRESS.equals(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBleAddress() {
        return this.bleAddress;
    }

    public String getClassAddress() {
        return this.classAddress;
    }

    public int getConnectWay() {
        return this.connectWay;
    }

    public int getState() {
        return this.state;
    }

    public int getType() {
        return this.type;
    }

    public boolean isOnlyBle() {
        if (isValidAddress(this.bleAddress) && !isValidAddress(this.classAddress)) {
            return true;
        }
        return false;
    }

    @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public int parse(byte[] bArr) {
        if (bArr == null || bArr.length < 15) {
            return 0;
        }
        this.type = CHexConver.byteToInt(bArr[0]);
        byte[] bArr2 = new byte[6];
        System.arraycopy(bArr, 1, bArr2, 0, 6);
        this.classAddress = CHexConver.hexDataCovetToAddress(bArr2);
        byte[] bArr3 = new byte[6];
        System.arraycopy(bArr, 7, bArr3, 0, 6);
        this.bleAddress = CHexConver.hexDataCovetToAddress(bArr3);
        this.state = CHexConver.byteToInt(bArr[13]);
        this.connectWay = CHexConver.checkBitValue(bArr[14], 0) ? 1 : 0;
        return 15;
    }

    @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public byte[] toData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(this.type);
            byte[] addressCovertToByteArray = RcspUtil.addressCovertToByteArray(this.classAddress);
            if (addressCovertToByteArray == null) {
                addressCovertToByteArray = new byte[6];
            }
            byteArrayOutputStream.write(addressCovertToByteArray);
            byte[] addressCovertToByteArray2 = RcspUtil.addressCovertToByteArray(this.bleAddress);
            if (addressCovertToByteArray2 == null) {
                addressCovertToByteArray2 = new byte[6];
            }
            byteArrayOutputStream.write(addressCovertToByteArray2);
            byteArrayOutputStream.write(this.state);
            boolean z = true;
            if (this.connectWay != 1) {
                z = false;
            }
            byteArrayOutputStream.write(CHexConver.setBitValue((byte) 0, 0, z));
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return "DeviceState{type=" + this.type + ", classAddress='" + this.classAddress + "', bleAddress='" + this.bleAddress + "', state=" + this.state + ", connectWay=" + this.connectWay + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.classAddress);
        parcel.writeString(this.bleAddress);
        parcel.writeInt(this.state);
        parcel.writeInt(this.connectWay);
    }

    public DeviceState(int i, String str, String str2, int i2, int i3) {
        this.type = i;
        this.classAddress = str == null ? INVALID_ADDRESS : str;
        this.bleAddress = str2 == null ? INVALID_ADDRESS : str2;
        this.state = i2;
        this.connectWay = i3;
    }

    public DeviceState(Parcel parcel) {
        this.type = parcel.readInt();
        this.classAddress = parcel.readString();
        this.bleAddress = parcel.readString();
        this.state = parcel.readInt();
        this.connectWay = parcel.readInt();
    }
}
