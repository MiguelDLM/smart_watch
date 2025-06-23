package com.jieli.jl_rcsp.model.device.settings.v0;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class NetworkOTAState extends NetworkBase {
    public static final Parcelable.Creator<NetworkOTAState> CREATOR = new Parcelable.Creator<NetworkOTAState>() { // from class: com.jieli.jl_rcsp.model.device.settings.v0.NetworkOTAState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkOTAState createFromParcel(Parcel parcel) {
            return new NetworkOTAState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkOTAState[] newArray(int i) {
            return new NetworkOTAState[i];
        }
    };
    public static final int RESULT_UPGRADE_FAILED = 1;
    public static final int RESULT_UPGRADE_SUCCESS = 0;
    public static final int RESULT_UPGRADE_TIMEOUT = 2;
    public static final int STATE_TRANSFERRING = 2;
    public static final int STATE_UPGRADE_END = 0;
    public static final int STATE_UPGRADE_START = 1;
    private int code;
    private int state;

    public NetworkOTAState(byte[] bArr) {
        super(bArr);
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.NetworkBase, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCode() {
        return this.code;
    }

    public int getState() {
        return this.state;
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.NetworkBase, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public int parse(byte[] bArr) {
        this.type = -1;
        this.state = -1;
        this.code = -1;
        if (bArr == null || bArr.length < 2) {
            return 0;
        }
        this.type = CHexConver.byteToInt(bArr[0]);
        this.state = CHexConver.byteToInt(bArr[1]);
        if (bArr.length <= 2) {
            return 2;
        }
        this.code = CHexConver.byteToInt(bArr[2]);
        return 3;
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.NetworkBase, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public byte[] toData() {
        int i = this.state;
        if (i == 0) {
            return new byte[]{(byte) this.type, (byte) i, (byte) this.code};
        }
        return new byte[]{(byte) this.type, (byte) i};
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.NetworkBase
    public String toString() {
        return "NetworkOTAState{state=" + this.state + ", code=" + this.code + '}';
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.NetworkBase, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.state);
        parcel.writeInt(this.code);
    }

    public NetworkOTAState(int i, int i2) {
        super(1);
        this.state = i;
        this.code = i2;
    }

    public NetworkOTAState(Parcel parcel) {
        super(parcel);
        this.state = parcel.readInt();
        this.code = parcel.readInt();
    }
}
