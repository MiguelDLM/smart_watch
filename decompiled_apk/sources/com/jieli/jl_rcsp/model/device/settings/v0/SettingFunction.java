package com.jieli.jl_rcsp.model.device.settings.v0;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.model.device.settings.SettingData;
import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class SettingFunction extends SettingData {
    public static final Parcelable.Creator<SettingFunction> CREATOR = new Parcelable.Creator<SettingFunction>() { // from class: com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SettingFunction createFromParcel(Parcel parcel) {
            return new SettingFunction(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SettingFunction[] newArray(int i) {
            return new SettingFunction[i];
        }
    };
    public static final int FUNC_4G_NETWORK_FUNCTION = 5;
    public static final int FUNC_BOUND_DEVICE_STATE = 3;
    public static final int FUNC_BRIGHTNESS = 1;
    public static final int FUNC_DIAL_EXPAND_INFO = 7;
    public static final int FUNC_FLASHLIGHT = 2;
    public static final int FUNC_USING_RESOURCE = 4;
    public static final int OP_NOTIFY = 2;
    public static final int OP_READ = 0;
    public static final int OP_SET = 1;
    private int funcVersion;
    private int function;
    private int op;
    private byte[] payload;

    public SettingFunction(byte[] bArr) {
        super(bArr);
    }

    private static byte[] convertData(int i, int i2, int i3, byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(CHexConver.int2byte2(i));
            byteArrayOutputStream.write(i2);
            byteArrayOutputStream.write(i3);
            if (bArr != null) {
                byteArrayOutputStream.write(bArr);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.SettingData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFuncVersion() {
        return this.funcVersion;
    }

    public int getFunction() {
        return this.function;
    }

    public int getOp() {
        return this.op;
    }

    public byte[] getPayload() {
        return this.payload;
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.SettingData, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public int parse(byte[] bArr) {
        this.payload = new byte[0];
        int parse = super.parse(bArr);
        if (parse == 0) {
            return parse;
        }
        byte[] data = getData();
        if (data.length < 4) {
            return parse;
        }
        this.function = CHexConver.bytesToInt(data, 0, 2);
        this.funcVersion = CHexConver.byteToInt(data[2]);
        this.op = CHexConver.byteToInt(data[3]);
        if (4 < data.length) {
            int length = data.length - 4;
            byte[] bArr2 = new byte[length];
            this.payload = bArr2;
            System.arraycopy(data, 4, bArr2, 0, length);
        }
        return parse;
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.SettingData
    public String toString() {
        return "SettingFunction{function=" + this.function + ", funcVersion=" + this.funcVersion + ", op=" + this.op + ", payload=" + CHexConver.byte2HexStr(this.payload) + '}';
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.SettingData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.function);
        parcel.writeInt(this.funcVersion);
        parcel.writeInt(this.op);
        parcel.writeByteArray(this.payload);
    }

    public SettingFunction(int i, int i2, int i3, byte[] bArr) {
        super(0, convertData(i, i2, i3, bArr));
        this.function = i;
        this.funcVersion = i2;
        this.op = i3;
        this.payload = bArr;
    }

    public SettingFunction(Parcel parcel) {
        super(parcel);
        this.function = parcel.readInt();
        this.funcVersion = parcel.readInt();
        this.op = parcel.readInt();
        this.payload = parcel.createByteArray();
    }
}
