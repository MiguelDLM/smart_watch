package com.jieli.jl_rcsp.model.device.settings.v0;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class BrightnessSetting extends SettingFunction {
    public static final Parcelable.Creator<BrightnessSetting> CREATOR = new Parcelable.Creator<BrightnessSetting>() { // from class: com.jieli.jl_rcsp.model.device.settings.v0.BrightnessSetting.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BrightnessSetting createFromParcel(Parcel parcel) {
            return new BrightnessSetting(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BrightnessSetting[] newArray(int i) {
            return new BrightnessSetting[i];
        }
    };
    private int value;

    public BrightnessSetting(byte[] bArr) {
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
    public BrightnessSetting(int r5, java.lang.Integer r6) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            if (r6 != 0) goto L7
            byte[] r2 = new byte[r1]
            goto L13
        L7:
            byte[] r2 = new byte[r0]
            int r3 = r6.intValue()
            byte r3 = com.jieli.jl_rcsp.util.CHexConver.intToByte(r3)
            r2[r1] = r3
        L13:
            r4.<init>(r0, r1, r5, r2)
            if (r6 == 0) goto L1e
            int r5 = r6.intValue()
            r4.value = r5
        L1e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.jl_rcsp.model.device.settings.v0.BrightnessSetting.<init>(int, java.lang.Integer):void");
    }

    public BrightnessSetting(Parcel parcel) {
        super(parcel);
        this.value = parcel.readInt();
    }
}
