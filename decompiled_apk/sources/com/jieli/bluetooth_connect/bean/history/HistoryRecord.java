package com.jieli.bluetooth_connect.bean.history;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Objects;

@Entity
/* loaded from: classes10.dex */
public class HistoryRecord implements Parcelable {
    public static final Parcelable.Creator<HistoryRecord> CREATOR = new Parcelable.Creator<HistoryRecord>() { // from class: com.jieli.bluetooth_connect.bean.history.HistoryRecord.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HistoryRecord createFromParcel(Parcel in) {
            return new HistoryRecord(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HistoryRecord[] newArray(int size) {
            return new HistoryRecord[size];
        }
    };

    @NonNull
    private String address;

    @ColumnInfo(name = "connect_type")
    private int connectType;

    @ColumnInfo(name = "dev_type")
    private int devType;

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "left_dev_lat")
    private double leftDevLatitude;

    @ColumnInfo(name = "left_dev_lon")
    private double leftDevLongitude;

    @ColumnInfo(name = "left_dev_update_time")
    private long leftDevUpdateTime;

    @ColumnInfo(name = "mapped_address")
    private String mappedAddress;
    private String name;

    @ColumnInfo(name = "online_time")
    private long onlineTime;
    private int pid;

    @ColumnInfo(name = "right_dev_lat")
    private double rightDevLatitude;

    @ColumnInfo(name = "right_dev_lon")
    private double rightDevLongitude;

    @ColumnInfo(name = "right_dev_update_time")
    private long rightDevUpdateTime;

    @ColumnInfo(name = "sdk_flag")
    private int sdkFlag;
    private int uid;

    @ColumnInfo(name = "update_address")
    private String updateAddress;
    private int vid;

    public HistoryRecord() {
        this.address = "11:22:33:44:55:66";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HistoryRecord historyRecord = (HistoryRecord) o;
        if (this.connectType == historyRecord.connectType && this.sdkFlag == historyRecord.sdkFlag && this.vid == historyRecord.vid && this.uid == historyRecord.uid && this.pid == historyRecord.pid && Objects.equals(this.address, historyRecord.address) && Objects.equals(this.mappedAddress, historyRecord.mappedAddress)) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getAddress() {
        return this.address;
    }

    public int getConnectType() {
        return this.connectType;
    }

    public int getDevType() {
        return this.devType;
    }

    public int getId() {
        return this.id;
    }

    public double getLeftDevLatitude() {
        return this.leftDevLatitude;
    }

    public double getLeftDevLongitude() {
        return this.leftDevLongitude;
    }

    public long getLeftDevUpdateTime() {
        return this.leftDevUpdateTime;
    }

    public String getMappedAddress() {
        return this.mappedAddress;
    }

    public String getName() {
        return this.name;
    }

    public long getOnlineTime() {
        return this.onlineTime;
    }

    public int getPid() {
        return this.pid;
    }

    public double getRightDevLatitude() {
        return this.rightDevLatitude;
    }

    public double getRightDevLongitude() {
        return this.rightDevLongitude;
    }

    public long getRightDevUpdateTime() {
        return this.rightDevUpdateTime;
    }

    public int getSdkFlag() {
        return this.sdkFlag;
    }

    public int getUid() {
        return this.uid;
    }

    public String getUpdateAddress() {
        return this.updateAddress;
    }

    public int getVid() {
        return this.vid;
    }

    public int hashCode() {
        return Objects.hash(this.address, this.mappedAddress, Integer.valueOf(this.connectType), Integer.valueOf(this.sdkFlag), Integer.valueOf(this.vid), Integer.valueOf(this.uid), Integer.valueOf(this.pid));
    }

    public void setAddress(@NonNull String address) {
        this.address = address;
    }

    public void setConnectType(int connectType) {
        this.connectType = connectType;
    }

    public void setDevType(int devType) {
        this.devType = devType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLeftDevLatitude(double leftDevLatitude) {
        this.leftDevLatitude = leftDevLatitude;
    }

    public void setLeftDevLongitude(double leftDevLongitude) {
        this.leftDevLongitude = leftDevLongitude;
    }

    public void setLeftDevUpdateTime(long leftDevUpdateTime) {
        this.leftDevUpdateTime = leftDevUpdateTime;
    }

    public void setMappedAddress(String mappedAddress) {
        this.mappedAddress = mappedAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOnlineTime(long onlineTime) {
        this.onlineTime = onlineTime;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setRightDevLatitude(double rightDevLatitude) {
        this.rightDevLatitude = rightDevLatitude;
    }

    public void setRightDevLongitude(double rightDevLongitude) {
        this.rightDevLongitude = rightDevLongitude;
    }

    public void setRightDevUpdateTime(long rightDevUpdateTime) {
        this.rightDevUpdateTime = rightDevUpdateTime;
    }

    public void setSdkFlag(int sdkFlag) {
        this.sdkFlag = sdkFlag;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUpdateAddress(String updateAddress) {
        this.updateAddress = updateAddress;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    @NonNull
    public String toString() {
        return "HistoryRecord{id=" + this.id + ", name='" + this.name + "', address='" + this.address + "', mappedAddress='" + this.mappedAddress + "', updateAddress='" + this.updateAddress + "', devType=" + this.devType + ", connectType=" + this.connectType + ", sdkFlag=" + this.sdkFlag + ", vid=" + this.vid + ", uid=" + this.uid + ", pid=" + this.pid + ", leftDevLatitude=" + this.leftDevLatitude + ", leftDevLongitude=" + this.leftDevLongitude + ", leftDevUpdateTime=" + this.leftDevUpdateTime + ", rightDevLatitude=" + this.rightDevLatitude + ", rightDevLongitude=" + this.rightDevLongitude + ", rightDevUpdateTime=" + this.rightDevUpdateTime + ", onlineTime=" + this.onlineTime + '}';
    }

    public void updateLeftDevGpsInfo(double leftDevLatitude, double leftDevLongitude, long leftDevUpdateTime) {
        this.leftDevLatitude = leftDevLatitude;
        this.leftDevLongitude = leftDevLongitude;
        this.leftDevUpdateTime = leftDevUpdateTime;
    }

    public void updateRightDevGpsInfo(double rightDevLatitude, double rightDevLongitude, long rightDevUpdateTime) {
        this.rightDevLatitude = rightDevLatitude;
        this.rightDevLongitude = rightDevLongitude;
        this.rightDevUpdateTime = rightDevUpdateTime;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.address);
        dest.writeString(this.mappedAddress);
        dest.writeInt(this.devType);
        dest.writeInt(this.connectType);
        dest.writeInt(this.sdkFlag);
        dest.writeInt(this.vid);
        dest.writeInt(this.uid);
        dest.writeInt(this.pid);
        dest.writeDouble(this.leftDevLatitude);
        dest.writeDouble(this.leftDevLongitude);
        dest.writeLong(this.leftDevUpdateTime);
        dest.writeDouble(this.rightDevLatitude);
        dest.writeDouble(this.rightDevLongitude);
        dest.writeLong(this.rightDevUpdateTime);
        dest.writeLong(this.onlineTime);
        dest.writeString(this.updateAddress);
    }

    public HistoryRecord(Parcel in) {
        this.address = "11:22:33:44:55:66";
        this.id = in.readInt();
        this.name = in.readString();
        String readString = in.readString();
        Objects.requireNonNull(readString);
        this.address = readString;
        this.mappedAddress = in.readString();
        this.devType = in.readInt();
        this.connectType = in.readInt();
        this.sdkFlag = in.readInt();
        this.vid = in.readInt();
        this.uid = in.readInt();
        this.pid = in.readInt();
        this.leftDevLatitude = in.readDouble();
        this.leftDevLongitude = in.readDouble();
        this.leftDevUpdateTime = in.readLong();
        this.rightDevLatitude = in.readDouble();
        this.rightDevLongitude = in.readDouble();
        this.rightDevUpdateTime = in.readLong();
        this.onlineTime = in.readLong();
        this.updateAddress = in.readString();
    }
}
