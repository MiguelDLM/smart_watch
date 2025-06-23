package com.jieli.jl_rcsp.model.device.settings.v0;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.interfaces.cmd.IDataOp;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class NetworkBase implements IDataOp, Parcelable {
    public static final Parcelable.Creator<NetworkBase> CREATOR = new Parcelable.Creator<NetworkBase>() { // from class: com.jieli.jl_rcsp.model.device.settings.v0.NetworkBase.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkBase createFromParcel(Parcel parcel) {
            return new NetworkBase(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkBase[] newArray(int i) {
            return new NetworkBase[i];
        }
    };
    public static final int TYPE_NETWORK_INFO = 0;
    public static final int TYPE_OTA_STATE = 1;
    protected int type;

    public NetworkBase(byte[] bArr) {
        parse(bArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getType() {
        return this.type;
    }

    @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public int parse(byte[] bArr) {
        this.type = -1;
        if (bArr == null || bArr.length == 0) {
            return 0;
        }
        this.type = CHexConver.byteToInt(bArr[0]);
        return 1;
    }

    @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public byte[] toData() {
        return new byte[]{(byte) this.type};
    }

    public String toString() {
        return "NetworkBase{type=" + this.type + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
    }

    public NetworkBase(int i) {
        this.type = i;
    }

    public NetworkBase(Parcel parcel) {
        this.type = parcel.readInt();
    }
}
