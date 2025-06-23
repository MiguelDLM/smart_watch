package com.jieli.jl_rcsp.model.device;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class VoiceMode implements Parcelable {
    public static final Parcelable.Creator<VoiceMode> CREATOR = new Parcelable.Creator<VoiceMode>() { // from class: com.jieli.jl_rcsp.model.device.VoiceMode.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VoiceMode createFromParcel(Parcel parcel) {
            return new VoiceMode(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VoiceMode[] newArray(int i) {
            return new VoiceMode[i];
        }
    };
    public static final int VOICE_MODE_CLOSE = 0;
    public static final int VOICE_MODE_DENOISE = 1;
    public static final int VOICE_MODE_TRANSPARENT = 2;
    private int leftCurVal;
    private int leftMax;
    private int mode;
    private int rightCurVal;
    private int rightMax;

    public VoiceMode() {
        this.mode = -1;
    }

    public static boolean isValidMode(int i) {
        return i == 0 || i == 1 || i == 2;
    }

    public static VoiceMode parse(byte[] bArr) {
        if (bArr != null && bArr.length == 9) {
            int byteToInt = CHexConver.byteToInt(bArr[0]);
            int bytesToInt = CHexConver.bytesToInt(bArr, 1, 2);
            int bytesToInt2 = CHexConver.bytesToInt(bArr, 3, 2);
            int bytesToInt3 = CHexConver.bytesToInt(bArr, 5, 2);
            return new VoiceMode().setMode(byteToInt).setLeftMax(bytesToInt).setLeftCurVal(bytesToInt3).setRightMax(bytesToInt2).setRightCurVal(CHexConver.bytesToInt(bArr, 7, 2));
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte[] getBytes() {
        byte[] bArr = new byte[9];
        bArr[0] = CHexConver.intToByte(this.mode);
        byte[] int2byte2 = CHexConver.int2byte2(this.leftMax);
        System.arraycopy(int2byte2, 0, bArr, 1, int2byte2.length);
        int length = int2byte2.length + 1;
        byte[] int2byte22 = CHexConver.int2byte2(this.rightMax);
        System.arraycopy(int2byte22, 0, bArr, length, int2byte22.length);
        int length2 = length + int2byte22.length;
        byte[] int2byte23 = CHexConver.int2byte2(this.leftCurVal);
        System.arraycopy(int2byte23, 0, bArr, length2, int2byte23.length);
        int length3 = length2 + int2byte23.length;
        byte[] int2byte24 = CHexConver.int2byte2(this.rightCurVal);
        System.arraycopy(int2byte24, 0, bArr, length3, int2byte24.length);
        return bArr;
    }

    public int getLeftCurVal() {
        return this.leftCurVal;
    }

    public int getLeftMax() {
        return this.leftMax;
    }

    public int getMode() {
        return this.mode;
    }

    public int getRightCurVal() {
        return this.rightCurVal;
    }

    public int getRightMax() {
        return this.rightMax;
    }

    public VoiceMode setLeftCurVal(int i) {
        this.leftCurVal = i;
        return this;
    }

    public VoiceMode setLeftMax(int i) {
        this.leftMax = i;
        return this;
    }

    public VoiceMode setMode(int i) {
        this.mode = i;
        return this;
    }

    public VoiceMode setRightCurVal(int i) {
        this.rightCurVal = i;
        return this;
    }

    public VoiceMode setRightMax(int i) {
        this.rightMax = i;
        return this;
    }

    public String toString() {
        return "VoiceMode{mode=" + this.mode + ", leftMax=" + this.leftMax + ", rightMax=" + this.rightMax + ", leftCurVal=" + this.leftCurVal + ", rightCurVal=" + this.rightCurVal + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mode);
        parcel.writeInt(this.leftMax);
        parcel.writeInt(this.rightMax);
        parcel.writeInt(this.leftCurVal);
        parcel.writeInt(this.rightCurVal);
    }

    public VoiceMode(Parcel parcel) {
        this.mode = -1;
        this.mode = parcel.readInt();
        this.leftMax = parcel.readInt();
        this.rightMax = parcel.readInt();
        this.leftCurVal = parcel.readInt();
        this.rightCurVal = parcel.readInt();
    }
}
