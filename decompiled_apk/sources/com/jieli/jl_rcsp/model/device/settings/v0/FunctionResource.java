package com.jieli.jl_rcsp.model.device.settings.v0;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;

/* loaded from: classes10.dex */
public class FunctionResource extends SettingFunction {
    public static final Parcelable.Creator<FunctionResource> CREATOR = new Parcelable.Creator<FunctionResource>() { // from class: com.jieli.jl_rcsp.model.device.settings.v0.FunctionResource.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FunctionResource createFromParcel(Parcel parcel) {
            return new FunctionResource(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FunctionResource[] newArray(int i) {
            return new FunctionResource[i];
        }
    };
    public static final int FUNC_BOOT_ANIM = 2;
    public static final int FUNC_SCREEN_SAVERS = 1;
    private ResourceInfo resourceInfo;
    private int subFunction;

    public FunctionResource(byte[] bArr) {
        super(bArr);
    }

    public static byte[] convertPayload(int i, ResourceInfo resourceInfo) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(i);
            if (resourceInfo != null) {
                byteArrayOutputStream.write(resourceInfo.toData());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction, com.jieli.jl_rcsp.model.device.settings.SettingData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ResourceInfo getResourceInfo() {
        return this.resourceInfo;
    }

    public int getSubFunction() {
        return this.subFunction;
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
        this.subFunction = CHexConver.byteToInt(payload[0]);
        if (payload.length > 1) {
            int length = payload.length - 1;
            byte[] bArr2 = new byte[length];
            System.arraycopy(payload, 1, bArr2, 0, length);
            this.resourceInfo = new ResourceInfo(bArr2);
        }
        return parse;
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction, com.jieli.jl_rcsp.model.device.settings.SettingData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.subFunction);
        parcel.writeParcelable(this.resourceInfo, i);
    }

    public FunctionResource(int i, int i2, ResourceInfo resourceInfo) {
        super(4, 0, i, convertPayload(i2, resourceInfo));
        this.subFunction = i2;
        this.resourceInfo = resourceInfo;
    }

    public FunctionResource(Parcel parcel) {
        super(parcel);
        this.subFunction = parcel.readInt();
        this.resourceInfo = (ResourceInfo) parcel.readParcelable(ResourceInfo.class.getClassLoader());
    }
}
