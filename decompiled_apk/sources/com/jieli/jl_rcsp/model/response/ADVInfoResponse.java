package com.jieli.jl_rcsp.model.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.util.CHexConver;
import java.util.List;
import java.util.Objects;

/* loaded from: classes10.dex */
public class ADVInfoResponse extends CommonResponse implements Parcelable {
    public static final Parcelable.Creator<ADVInfoResponse> CREATOR = new Parcelable.Creator<ADVInfoResponse>() { // from class: com.jieli.jl_rcsp.model.response.ADVInfoResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ADVInfoResponse createFromParcel(Parcel parcel) {
            return new ADVInfoResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ADVInfoResponse[] newArray(int i) {
            return new ADVInfoResponse[i];
        }
    };
    private int chargingBinQuantity;
    private String deviceName;
    private int inEarSettings;
    private boolean isDeviceCharging;
    private boolean isLeftCharging;
    private boolean isRightCharging;
    private String language;
    private int leftDeviceQuantity;
    private List<KeySettings> mKeySettingsList;
    private List<LedSettings> mLedSettingsList;
    private int micChannel;
    private byte[] modes;
    private int pid;
    private int rightDeviceQuantity;
    private int uid;
    private int vid;
    private int workModel;

    /* loaded from: classes10.dex */
    public static class KeySettings implements Parcelable {
        public static final Parcelable.Creator<KeySettings> CREATOR = new Parcelable.Creator<KeySettings>() { // from class: com.jieli.jl_rcsp.model.response.ADVInfoResponse.KeySettings.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public KeySettings createFromParcel(Parcel parcel) {
                return new KeySettings(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public KeySettings[] newArray(int i) {
                return new KeySettings[i];
            }
        };
        private int action;
        private int function;
        private int keyNum;

        public KeySettings() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getAction() {
            return this.action;
        }

        public int getFunction() {
            return this.function;
        }

        public int getKeyNum() {
            return this.keyNum;
        }

        public void setAction(int i) {
            this.action = i;
        }

        public void setFunction(int i) {
            this.function = i;
        }

        public void setKeyNum(int i) {
            this.keyNum = i;
        }

        public byte[] toData() {
            return new byte[]{CHexConver.intToByte(this.keyNum), CHexConver.intToByte(this.action), CHexConver.intToByte(this.function)};
        }

        public String toString() {
            return "KeySettings{, keyNum=" + this.keyNum + ", action=" + this.action + ", function=" + this.function + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.keyNum);
            parcel.writeInt(this.action);
            parcel.writeInt(this.function);
        }

        public KeySettings(Parcel parcel) {
            this.keyNum = parcel.readInt();
            this.action = parcel.readInt();
            this.function = parcel.readInt();
        }
    }

    /* loaded from: classes10.dex */
    public static class LedSettings implements Parcelable {
        public static final Parcelable.Creator<LedSettings> CREATOR = new Parcelable.Creator<LedSettings>() { // from class: com.jieli.jl_rcsp.model.response.ADVInfoResponse.LedSettings.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LedSettings createFromParcel(Parcel parcel) {
                return new LedSettings(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LedSettings[] newArray(int i) {
                return new LedSettings[i];
            }
        };
        private int effect;
        private int scene;

        public LedSettings() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getEffect() {
            return this.effect;
        }

        public int getScene() {
            return this.scene;
        }

        public void setEffect(int i) {
            this.effect = i;
        }

        public void setScene(int i) {
            this.scene = i;
        }

        public byte[] toData() {
            return new byte[]{CHexConver.intToByte(this.scene), CHexConver.intToByte(this.effect)};
        }

        public String toString() {
            return "LedSettings{scene=" + this.scene + ", effect=" + this.effect + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.scene);
            parcel.writeInt(this.effect);
        }

        public LedSettings(Parcel parcel) {
            this.scene = parcel.readInt();
            this.effect = parcel.readInt();
        }
    }

    public ADVInfoResponse() {
    }

    public static boolean baseInfoCompare(ADVInfoResponse aDVInfoResponse, ADVInfoResponse aDVInfoResponse2) {
        if (aDVInfoResponse == null || aDVInfoResponse2 == null) {
            return false;
        }
        if (aDVInfoResponse == aDVInfoResponse2) {
            return true;
        }
        if (aDVInfoResponse.pid != aDVInfoResponse2.pid || aDVInfoResponse.vid != aDVInfoResponse2.vid || aDVInfoResponse.uid != aDVInfoResponse2.uid || aDVInfoResponse.leftDeviceQuantity != aDVInfoResponse2.leftDeviceQuantity || aDVInfoResponse.isLeftCharging != aDVInfoResponse2.isLeftCharging || aDVInfoResponse.rightDeviceQuantity != aDVInfoResponse2.rightDeviceQuantity || aDVInfoResponse.isRightCharging != aDVInfoResponse2.isRightCharging || aDVInfoResponse.chargingBinQuantity != aDVInfoResponse2.chargingBinQuantity || aDVInfoResponse.isDeviceCharging != aDVInfoResponse2.isDeviceCharging || aDVInfoResponse.micChannel != aDVInfoResponse2.micChannel || aDVInfoResponse.workModel != aDVInfoResponse2.workModel || aDVInfoResponse.inEarSettings != aDVInfoResponse2.inEarSettings || !Objects.equals(aDVInfoResponse.deviceName, aDVInfoResponse2.deviceName)) {
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getChargingBinQuantity() {
        return this.chargingBinQuantity;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public int getInEarSettings() {
        return this.inEarSettings;
    }

    public List<KeySettings> getKeySettingsList() {
        return this.mKeySettingsList;
    }

    public String getLanguage() {
        return this.language;
    }

    public List<LedSettings> getLedSettingsList() {
        return this.mLedSettingsList;
    }

    public int getLeftDeviceQuantity() {
        return this.leftDeviceQuantity;
    }

    public int getMicChannel() {
        return this.micChannel;
    }

    public byte[] getModes() {
        return this.modes;
    }

    public int getPid() {
        return this.pid;
    }

    public int getRightDeviceQuantity() {
        return this.rightDeviceQuantity;
    }

    public int getUid() {
        return this.uid;
    }

    public int getVid() {
        return this.vid;
    }

    public int getWorkModel() {
        return this.workModel;
    }

    public boolean isDeviceCharging() {
        return this.isDeviceCharging;
    }

    public boolean isLeftCharging() {
        return this.isLeftCharging;
    }

    public boolean isRightCharging() {
        return this.isRightCharging;
    }

    public ADVInfoResponse setChargingBinQuantity(int i) {
        this.chargingBinQuantity = i;
        return this;
    }

    public ADVInfoResponse setDeviceCharging(boolean z) {
        this.isDeviceCharging = z;
        return this;
    }

    public ADVInfoResponse setDeviceName(String str) {
        this.deviceName = str;
        return this;
    }

    public ADVInfoResponse setInEarSettings(int i) {
        this.inEarSettings = i;
        return this;
    }

    public ADVInfoResponse setKeySettingsList(List<KeySettings> list) {
        this.mKeySettingsList = list;
        return this;
    }

    public ADVInfoResponse setLanguage(String str) {
        this.language = str;
        return this;
    }

    public ADVInfoResponse setLedSettingsList(List<LedSettings> list) {
        this.mLedSettingsList = list;
        return this;
    }

    public ADVInfoResponse setLeftCharging(boolean z) {
        this.isLeftCharging = z;
        return this;
    }

    public ADVInfoResponse setLeftDeviceQuantity(int i) {
        this.leftDeviceQuantity = i;
        return this;
    }

    public ADVInfoResponse setMicChannel(int i) {
        this.micChannel = i;
        return this;
    }

    public ADVInfoResponse setModes(byte[] bArr) {
        this.modes = bArr;
        return this;
    }

    public ADVInfoResponse setPid(int i) {
        this.pid = i;
        return this;
    }

    public ADVInfoResponse setRightCharging(boolean z) {
        this.isRightCharging = z;
        return this;
    }

    public ADVInfoResponse setRightDeviceQuantity(int i) {
        this.rightDeviceQuantity = i;
        return this;
    }

    public ADVInfoResponse setUid(int i) {
        this.uid = i;
        return this;
    }

    public ADVInfoResponse setVid(int i) {
        this.vid = i;
        return this;
    }

    public ADVInfoResponse setWorkModel(int i) {
        this.workModel = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.CommonResponse
    public String toString() {
        return "ADVInfoResponse{pid=" + this.pid + ", vid=" + this.vid + ", uid=" + this.uid + ", leftDeviceQuantity=" + this.leftDeviceQuantity + ", isLeftCharging=" + this.isLeftCharging + ", rightDeviceQuantity=" + this.rightDeviceQuantity + ", isRightCharging=" + this.isRightCharging + ", chargingBinQuantity=" + this.chargingBinQuantity + ", isDeviceCharging=" + this.isDeviceCharging + ", deviceName='" + this.deviceName + "', micChannel=" + this.micChannel + ", workModel=" + this.workModel + ", mKeySettingsList=" + this.mKeySettingsList + ", mLedSettingsList=" + this.mLedSettingsList + ", inEarSettings=" + this.inEarSettings + ", language=" + this.language + ", modes=" + CHexConver.byte2HexStr(this.modes) + "} " + super.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.vid);
        parcel.writeInt(this.uid);
        parcel.writeInt(this.pid);
        parcel.writeInt(this.leftDeviceQuantity);
        parcel.writeByte(this.isLeftCharging ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.rightDeviceQuantity);
        parcel.writeByte(this.isRightCharging ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.chargingBinQuantity);
        parcel.writeByte(this.isDeviceCharging ? (byte) 1 : (byte) 0);
        parcel.writeString(this.deviceName);
        parcel.writeInt(this.micChannel);
        parcel.writeInt(this.workModel);
        parcel.writeTypedList(this.mKeySettingsList);
        parcel.writeTypedList(this.mLedSettingsList);
        parcel.writeInt(this.inEarSettings);
        parcel.writeString(this.language);
        parcel.writeByteArray(this.modes);
    }

    public ADVInfoResponse(Parcel parcel) {
        this.vid = parcel.readInt();
        this.uid = parcel.readInt();
        this.pid = parcel.readInt();
        this.leftDeviceQuantity = parcel.readInt();
        this.isLeftCharging = parcel.readByte() != 0;
        this.rightDeviceQuantity = parcel.readInt();
        this.isRightCharging = parcel.readByte() != 0;
        this.chargingBinQuantity = parcel.readInt();
        this.isDeviceCharging = parcel.readByte() != 0;
        this.deviceName = parcel.readString();
        this.micChannel = parcel.readInt();
        this.workModel = parcel.readInt();
        this.mKeySettingsList = parcel.createTypedArrayList(KeySettings.CREATOR);
        this.mLedSettingsList = parcel.createTypedArrayList(LedSettings.CREATOR);
        this.inEarSettings = parcel.readInt();
        this.language = parcel.readString();
        this.modes = parcel.createByteArray();
    }
}
