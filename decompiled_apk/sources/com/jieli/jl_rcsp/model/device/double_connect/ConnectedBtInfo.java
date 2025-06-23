package com.jieli.jl_rcsp.model.device.double_connect;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class ConnectedBtInfo implements Parcelable {
    public static final Parcelable.Creator<ConnectedBtInfo> CREATOR = new Parcelable.Creator<ConnectedBtInfo>() { // from class: com.jieli.jl_rcsp.model.device.double_connect.ConnectedBtInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConnectedBtInfo createFromParcel(Parcel parcel) {
            return new ConnectedBtInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConnectedBtInfo[] newArray(int i) {
            return new ConnectedBtInfo[i];
        }
    };
    private int connectionNum;
    private List<DeviceBtInfo> mDeviceBtInfoList;

    public ConnectedBtInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getConnectionNum() {
        return this.connectionNum;
    }

    public List<DeviceBtInfo> getDeviceBtInfoList() {
        return this.mDeviceBtInfoList;
    }

    public int parseConnectedDeviceBtData(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return 0;
        }
        this.connectionNum = CHexConver.byteToInt(bArr[0]);
        if (bArr.length < 2) {
            this.connectionNum = 0;
            return 0;
        }
        int length = bArr.length - 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 1, bArr2, 0, length);
        this.mDeviceBtInfoList = new ArrayList();
        int i = 0;
        while (i < length) {
            int i2 = length - i;
            byte[] bArr3 = new byte[i2];
            System.arraycopy(bArr2, i, bArr3, 0, i2);
            DeviceBtInfo deviceBtInfo = new DeviceBtInfo();
            int parseData = deviceBtInfo.parseData(bArr3);
            if (parseData == 0) {
                break;
            }
            this.mDeviceBtInfoList.add(deviceBtInfo);
            i += parseData;
        }
        this.connectionNum = this.mDeviceBtInfoList.size();
        return i;
    }

    public byte[] toData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(this.connectionNum);
        List<DeviceBtInfo> list = this.mDeviceBtInfoList;
        if (list != null && list.size() > 0) {
            try {
                Iterator<DeviceBtInfo> it = this.mDeviceBtInfoList.iterator();
                while (it.hasNext()) {
                    byteArrayOutputStream.write(it.next().toData());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String toString() {
        return "ConnectedBtInfo{connectionNum=" + this.connectionNum + ", mDeviceBtInfoList=" + this.mDeviceBtInfoList + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.connectionNum);
        parcel.writeTypedList(this.mDeviceBtInfoList);
    }

    public ConnectedBtInfo(Parcel parcel) {
        this.connectionNum = parcel.readInt();
        this.mDeviceBtInfoList = parcel.createTypedArrayList(DeviceBtInfo.CREATOR);
    }
}
