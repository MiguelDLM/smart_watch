package com.jieli.jl_rcsp.model.device.settings.v0;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class NetworkOTA extends NetworkBase {
    public static final Parcelable.Creator<NetworkOTA> CREATOR = new Parcelable.Creator<NetworkOTA>() { // from class: com.jieli.jl_rcsp.model.device.settings.v0.NetworkOTA.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkOTA createFromParcel(Parcel parcel) {
            return new NetworkOTA(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkOTA[] newArray(int i) {
            return new NetworkOTA[i];
        }
    };
    private int dataSize;

    public NetworkOTA(byte[] bArr) {
        super(bArr);
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.NetworkBase, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDataSize() {
        return this.dataSize;
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.NetworkBase, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public int parse(byte[] bArr) {
        this.dataSize = 0;
        if (bArr == null || bArr.length < 4) {
            return 0;
        }
        this.dataSize = CHexConver.bytesToInt(bArr, 0, 4);
        return 4;
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.NetworkBase, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public byte[] toData() {
        return CHexConver.intToBigBytes(this.dataSize);
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.NetworkBase, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.dataSize);
    }

    public NetworkOTA(int i) {
        super(-1);
        this.dataSize = i;
    }

    public NetworkOTA(Parcel parcel) {
        super(parcel);
        this.dataSize = parcel.readInt();
    }
}
