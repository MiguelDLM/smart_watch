package com.jieli.jl_rcsp.model.device.settings.v0;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class FlashlightSetting extends SettingFunction {
    public static final Parcelable.Creator<FlashlightSetting> CREATOR = new Parcelable.Creator<FlashlightSetting>() { // from class: com.jieli.jl_rcsp.model.device.settings.v0.FlashlightSetting.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FlashlightSetting createFromParcel(Parcel parcel) {
            return new FlashlightSetting(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FlashlightSetting[] newArray(int i) {
            return new FlashlightSetting[i];
        }
    };
    private int value;

    public FlashlightSetting(byte[] bArr) {
        super(bArr);
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction, com.jieli.jl_rcsp.model.device.settings.SettingData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getValue() {
        return this.value;
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
        this.value = CHexConver.byteToInt(payload[0]);
        return parse;
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction, com.jieli.jl_rcsp.model.device.settings.SettingData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.value);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public FlashlightSetting(int r4, java.lang.Integer r5) {
        /*
            r3 = this;
            r0 = 0
            if (r5 != 0) goto L6
            byte[] r1 = new byte[r0]
            goto L13
        L6:
            r1 = 1
            byte[] r1 = new byte[r1]
            int r2 = r5.intValue()
            byte r2 = com.jieli.jl_rcsp.util.CHexConver.intToByte(r2)
            r1[r0] = r2
        L13:
            r2 = 2
            r3.<init>(r2, r0, r4, r1)
            if (r5 == 0) goto L1f
            int r4 = r5.intValue()
            r3.value = r4
        L1f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.jl_rcsp.model.device.settings.v0.FlashlightSetting.<init>(int, java.lang.Integer):void");
    }

    public FlashlightSetting(Parcel parcel) {
        super(parcel);
        this.value = parcel.readInt();
    }
}
