package com.jieli.jl_rcsp.model.device.settings.v0;

import android.os.Parcel;

/* loaded from: classes10.dex */
public class NetworkFunction extends SettingFunction {
    public NetworkBase networkBase;

    public NetworkFunction(byte[] bArr) {
        super(bArr);
    }

    public NetworkBase getNetworkBase() {
        return this.networkBase;
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction, com.jieli.jl_rcsp.model.device.settings.SettingData, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public int parse(byte[] bArr) {
        int parse = super.parse(bArr);
        if (parse <= 0) {
            return parse;
        }
        byte[] payload = getPayload();
        if (payload.length == 0) {
            return parse;
        }
        if (getOp() == 1) {
            this.networkBase = new NetworkOTA(payload);
        } else {
            NetworkBase networkBase = new NetworkBase(payload);
            this.networkBase = networkBase;
            int type = networkBase.getType();
            if (type != 0) {
                if (type == 1) {
                    this.networkBase = new NetworkOTAState(payload);
                }
            } else {
                this.networkBase = new NetworkInfo(payload);
            }
        }
        return parse;
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction, com.jieli.jl_rcsp.model.device.settings.SettingData
    public String toString() {
        return "NetworkFunction{networkBase=" + this.networkBase + '}';
    }

    public NetworkFunction(int i, NetworkBase networkBase) {
        super(5, 0, i, networkBase == null ? new byte[0] : networkBase.toData());
        this.networkBase = networkBase;
    }

    public NetworkFunction(Parcel parcel) {
        super(parcel);
        this.networkBase = (NetworkBase) parcel.readParcelable(NetworkBase.class.getClassLoader());
    }
}
