package com.jieli.jl_rcsp.model.device.health;

import com.jieli.jl_rcsp.model.device.AttrBean;

/* loaded from: classes10.dex */
public class DisconnectReminder implements IHealthSettingToAttr {
    public static final int MODE_BRIGHT_SCREEN = 0;
    public static final int MODE_SHOCK = 1;
    private boolean enable;
    private byte mode;

    public DisconnectReminder(byte[] bArr) {
        parseData(bArr);
    }

    private void parseData(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            boolean z = false;
            if (bArr[0] == 1) {
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
        return 10;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public DisconnectReminder setEnable(boolean z) {
        this.enable = z;
        return this;
    }

    public DisconnectReminder setMode(byte b) {
        this.mode = b;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public AttrBean toAttr() {
        return new AttrBean().setType((byte) getType()).setAttrData(toData());
    }

    public String toString() {
        return "DisconnectReminder{enable=" + this.enable + ", mode=" + ((int) this.mode) + '}';
    }
}
