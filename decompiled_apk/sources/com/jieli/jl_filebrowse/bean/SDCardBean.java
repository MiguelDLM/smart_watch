package com.jieli.jl_filebrowse.bean;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* loaded from: classes10.dex */
public class SDCardBean implements Parcelable {
    public static final Parcelable.Creator<SDCardBean> CREATOR = new Parcelable.Creator<SDCardBean>() { // from class: com.jieli.jl_filebrowse.bean.SDCardBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SDCardBean createFromParcel(Parcel parcel) {
            return new SDCardBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SDCardBean[] newArray(int i) {
            return new SDCardBean[i];
        }
    };
    public static final int FLASH = 2;
    public static final int FLASH_2 = 4;
    public static final int INDEX_FLASH = 3;
    public static final int INDEX_FLASH2 = 5;
    public static final int INDEX_FLASH3 = 6;
    public static final int INDEX_LINE_IN = 4;
    public static final int INDEX_SD0 = 1;
    public static final int INDEX_SD1 = 2;
    public static final int INDEX_USB = 0;
    public static final int LINEIN = 3;
    public static final int SD = 0;
    public static final int USB = 1;
    private int devHandler;
    private BluetoothDevice device;
    private int index;
    private String name;
    private boolean online;
    private int type;

    public SDCardBean() {
        this.devHandler = -1;
    }

    public static int getStorageType(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
            case 6:
                return 4;
            default:
                return -1;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SDCardBean sDCardBean = (SDCardBean) obj;
        if (this.index == sDCardBean.index && this.devHandler == sDCardBean.devHandler && Objects.equals(this.device, sDCardBean.device)) {
            return true;
        }
        return false;
    }

    public int getDevHandler() {
        return this.devHandler;
    }

    public BluetoothDevice getDevice() {
        return this.device;
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.index), Integer.valueOf(this.devHandler), this.device);
    }

    public boolean isOnline() {
        return this.online;
    }

    public SDCardBean setDevHandler(int i) {
        this.devHandler = i;
        return this;
    }

    public SDCardBean setDevice(BluetoothDevice bluetoothDevice) {
        this.device = bluetoothDevice;
        return this;
    }

    public SDCardBean setIndex(int i) {
        this.index = i;
        return this;
    }

    public SDCardBean setName(String str) {
        this.name = str;
        return this;
    }

    public SDCardBean setOnline(boolean z) {
        this.online = z;
        return this;
    }

    public SDCardBean setType(int i) {
        this.type = i;
        return this;
    }

    public String toString() {
        return "SDCardBean{index=" + this.index + ", type=" + this.type + ", name='" + this.name + "', devHandler=" + this.devHandler + ", online=" + this.online + ", device='" + this.device + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.index);
        parcel.writeInt(this.type);
        parcel.writeString(this.name);
        parcel.writeInt(this.devHandler);
        parcel.writeByte(this.online ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.device, i);
    }

    public SDCardBean(Parcel parcel) {
        this.devHandler = -1;
        this.index = parcel.readInt();
        this.type = parcel.readInt();
        this.name = parcel.readString();
        this.devHandler = parcel.readInt();
        this.online = parcel.readByte() != 0;
        this.device = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
    }
}
