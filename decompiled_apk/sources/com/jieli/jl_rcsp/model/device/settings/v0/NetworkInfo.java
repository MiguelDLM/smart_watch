package com.jieli.jl_rcsp.model.device.settings.v0;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class NetworkInfo extends NetworkBase {
    public static final Parcelable.Creator<NetworkInfo> CREATOR = new Parcelable.Creator<NetworkInfo>() { // from class: com.jieli.jl_rcsp.model.device.settings.v0.NetworkInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkInfo createFromParcel(Parcel parcel) {
            return new NetworkInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkInfo[] newArray(int i) {
            return new NetworkInfo[i];
        }
    };
    private boolean isMandatoryOTA;
    private int startOtaTimeout;
    private int stopOtaTimeout;
    private String version;
    private int vid;

    public NetworkInfo(byte[] bArr) {
        super(bArr);
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.NetworkBase, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getStartOtaTimeout() {
        return this.startOtaTimeout;
    }

    public int getStopOtaTimeout() {
        return this.stopOtaTimeout;
    }

    public String getVersion() {
        return this.version;
    }

    public int getVid() {
        return this.vid;
    }

    public boolean isMandatoryOTA() {
        return this.isMandatoryOTA;
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.NetworkBase, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public int parse(byte[] bArr) {
        this.type = -1;
        this.vid = -1;
        this.version = "";
        this.startOtaTimeout = 60;
        this.stopOtaTimeout = 240;
        boolean z = false;
        if (bArr != null) {
            int i = 4;
            if (bArr.length >= 4) {
                this.type = CHexConver.byteToInt(bArr[0]);
                this.vid = CHexConver.byteToInt(bArr[1]);
                if (CHexConver.byteToInt(bArr[2]) == 1) {
                    z = true;
                }
                this.isMandatoryOTA = z;
                int byteToInt = CHexConver.byteToInt(bArr[3]);
                int i2 = byteToInt + 4;
                if (i2 <= bArr.length) {
                    try {
                        this.version = new String(bArr, 4, byteToInt);
                        i = i2;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                int i3 = i + 2;
                if (i3 <= bArr.length) {
                    this.startOtaTimeout = CHexConver.bytesToInt(bArr, i, 2);
                    i = i3;
                }
                int i4 = i + 2;
                if (i4 <= bArr.length) {
                    this.stopOtaTimeout = CHexConver.bytesToInt(bArr, i, 2);
                    return i4;
                }
                return i;
            }
        }
        return 0;
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.NetworkBase, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public byte[] toData() {
        int length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(this.type);
            byteArrayOutputStream.write(this.vid);
            byteArrayOutputStream.write(this.isMandatoryOTA ? 1 : 0);
            String str = this.version;
            if (str == null) {
                length = 0;
            } else {
                length = str.getBytes().length;
            }
            byteArrayOutputStream.write(length);
            if (length > 0) {
                byteArrayOutputStream.write(this.version.getBytes());
            }
            byteArrayOutputStream.write(CHexConver.int2byte2(this.startOtaTimeout));
            byteArrayOutputStream.write(CHexConver.int2byte2(this.stopOtaTimeout));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.NetworkBase
    public String toString() {
        return "NetworkInfo{vid=" + this.vid + ", isMandatoryOTA=" + this.isMandatoryOTA + ", version='" + this.version + "', startOtaTimeout=" + this.startOtaTimeout + ", stopOtaTimeout=" + this.stopOtaTimeout + '}';
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.NetworkBase, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.vid);
        parcel.writeInt(this.isMandatoryOTA ? 1 : 0);
        parcel.writeString(this.version);
        parcel.writeInt(this.startOtaTimeout);
        parcel.writeInt(this.stopOtaTimeout);
    }

    public NetworkInfo(int i, boolean z, String str, int i2, int i3) {
        super(0);
        this.vid = i;
        this.isMandatoryOTA = z;
        this.version = str == null ? "" : str;
        this.startOtaTimeout = i2;
        this.stopOtaTimeout = i3;
    }

    public NetworkInfo(Parcel parcel) {
        super(parcel);
        this.vid = parcel.readInt();
        this.isMandatoryOTA = parcel.readInt() == 1;
        this.version = parcel.readString();
        this.startOtaTimeout = parcel.readInt();
        this.stopOtaTimeout = parcel.readInt();
    }
}
