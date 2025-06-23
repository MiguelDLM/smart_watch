package com.jieli.jl_rcsp.model.device.settings.v0;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class DialExpandInfo extends SettingFunction {
    public static final Parcelable.Creator<DialExpandInfo> CREATOR = new Parcelable.Creator<DialExpandInfo>() { // from class: com.jieli.jl_rcsp.model.device.settings.v0.DialExpandInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DialExpandInfo createFromParcel(Parcel parcel) {
            return new DialExpandInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DialExpandInfo[] newArray(int i) {
            return new DialExpandInfo[i];
        }
    };
    public static final int SHAPE_CIRCULAR = 1;
    public static final int SHAPE_RECTANGLE = 2;
    public static final int SHAPE_ROUNDED_RECTANGLE = 3;
    private int color;
    private int radius;
    private int shape;

    public DialExpandInfo(byte[] bArr) {
        super(bArr);
    }

    public static int argb(byte b, byte b2, byte b3, byte b4) {
        return Color.argb(b & 255, b2 & 255, b3 & 255, b4 & 255);
    }

    public static byte[] int2Argb(int i) {
        return CHexConver.intToBigBytes(i);
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction, com.jieli.jl_rcsp.model.device.settings.SettingData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getColor() {
        return this.color;
    }

    public int getRadius() {
        return this.radius;
    }

    public int getShape() {
        return this.shape;
    }

    public boolean isCircular() {
        if (this.shape <= 1) {
            return true;
        }
        return false;
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction, com.jieli.jl_rcsp.model.device.settings.SettingData, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public int parse(byte[] bArr) {
        int parse = super.parse(bArr);
        if (parse <= 0) {
            return parse;
        }
        byte[] payload = getPayload();
        if (payload.length < 7) {
            return parse;
        }
        this.shape = CHexConver.byteToInt(payload[0]);
        this.radius = CHexConver.bytesToInt(payload, 1, 2);
        byte[] bArr2 = new byte[4];
        System.arraycopy(payload, 3, bArr2, 0, 4);
        this.color = argb(bArr2[0], bArr2[1], bArr2[2], bArr2[3]);
        return parse;
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction, com.jieli.jl_rcsp.model.device.settings.SettingData
    public String toString() {
        return "DialExpandInfo{shape=" + this.shape + ", radius=" + this.radius + ", color=" + this.color + '}';
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction, com.jieli.jl_rcsp.model.device.settings.SettingData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.shape);
        parcel.writeInt(this.radius);
        parcel.writeInt(this.color);
    }

    public DialExpandInfo() {
        super(7, 0, 0, new byte[0]);
    }

    public DialExpandInfo(Parcel parcel) {
        super(parcel);
        this.shape = parcel.readInt();
        this.radius = parcel.readInt();
        this.color = parcel.readInt();
    }
}
