package com.jieli.jl_rcsp.model.device.health;

import com.jieli.jl_rcsp.model.device.AttrBean;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class AutomaticPressureDetection implements IHealthSettingToAttr {
    public static final int MODE_HIGH = 3;
    public static final int MODE_MIDDLE = 2;
    public static final int MODE_NORMAL = 1;
    public static final int MODE_RELAX = 0;
    private boolean enable;
    private byte mode;

    public AutomaticPressureDetection(byte[] bArr) {
        parseData(bArr);
    }

    private void parseData(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            boolean z = false;
            if (CHexConver.byteToInt(bArr[0]) == 1) {
                z = true;
            }
            this.enable = z;
            if (bArr.length >= 2) {
                this.mode = bArr[1];
            }
        }
    }

    private byte[] toData() {
        return new byte[]{this.enable ? (byte) 1 : (byte) 0, this.mode};
    }

    public byte getMode() {
        return this.mode;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public int getType() {
        return 5;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public AutomaticPressureDetection setEnable(boolean z) {
        this.enable = z;
        return this;
    }

    public AutomaticPressureDetection setMode(byte b) {
        this.mode = b;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public AttrBean toAttr() {
        return new AttrBean().setType((byte) getType()).setAttrData(toData());
    }

    public String toString() {
        return "AutomaticPressureDetection{enable=" + this.enable + ", mode=" + ((int) this.mode) + '}';
    }
}
