package com.jieli.jl_rcsp.model.device.settings.v0;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes10.dex */
public class BoundDeviceState extends SettingFunction {
    public static final Parcelable.Creator<BoundDeviceState> CREATOR = new Parcelable.Creator<BoundDeviceState>() { // from class: com.jieli.jl_rcsp.model.device.settings.v0.BoundDeviceState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BoundDeviceState createFromParcel(Parcel parcel) {
            return new BoundDeviceState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BoundDeviceState[] newArray(int i) {
            return new BoundDeviceState[i];
        }
    };
    public static final int STATE_CONNECTED = 1;
    public static final int STATE_CONNECTING = 2;
    public static final int STATE_DISCONNECTED = 0;
    public static final int STATE_UNCONNECTABLE = 255;
    public static final int TYPE_CHARGING_CASE = 2;
    public static final int TYPE_TWS_HEADSET = 1;
    private DeviceState state;

    public BoundDeviceState(byte[] bArr) {
        super(bArr);
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction, com.jieli.jl_rcsp.model.device.settings.SettingData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DeviceState getState() {
        return this.state;
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction, com.jieli.jl_rcsp.model.device.settings.SettingData, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public int parse(byte[] bArr) {
        int parse = super.parse(bArr);
        if (parse == 0) {
            return parse;
        }
        byte[] payload = getPayload();
        if (payload.length == 0) {
            return parse;
        }
        this.state = new DeviceState(payload);
        return parse;
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction, com.jieli.jl_rcsp.model.device.settings.SettingData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.state, i);
    }

    public BoundDeviceState(int i, DeviceState deviceState) {
        super(3, 0, i, deviceState == null ? new byte[0] : deviceState.toData());
    }

    public BoundDeviceState(Parcel parcel) {
        super(parcel);
        this.state = (DeviceState) parcel.readParcelable(DeviceState.class.getClassLoader());
    }
}
