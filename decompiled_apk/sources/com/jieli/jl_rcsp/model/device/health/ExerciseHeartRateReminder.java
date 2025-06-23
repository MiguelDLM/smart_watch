package com.jieli.jl_rcsp.model.device.health;

import com.jieli.jl_rcsp.model.device.AttrBean;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class ExerciseHeartRateReminder implements IHealthSettingToAttr {
    public static final byte SPACE_MODE_MAX_PERCENT = 0;
    public static final byte SPACE_MODE_SAVE_PERCENT = 1;
    private boolean enable;
    private int max;
    private byte spaceMode;

    public ExerciseHeartRateReminder(byte[] bArr) {
        parseData(bArr);
    }

    private void parseData(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            boolean z = false;
            char c = 1;
            if (CHexConver.byteToInt(bArr[0]) == 1) {
                z = true;
            }
            this.enable = z;
            if (bArr.length > 1) {
                this.max = CHexConver.byteToInt(bArr[1]);
                c = 2;
            }
            if (bArr.length > 2) {
                this.spaceMode = bArr[c];
            }
        }
    }

    private byte[] toData() {
        return new byte[]{this.enable ? (byte) 1 : (byte) 0, (byte) this.max, this.spaceMode};
    }

    public int getMax() {
        return this.max;
    }

    public byte getSpaceMode() {
        return this.spaceMode;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public int getType() {
        return 4;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public ExerciseHeartRateReminder setEnable(boolean z) {
        this.enable = z;
        return this;
    }

    public ExerciseHeartRateReminder setMax(int i) {
        this.max = i;
        return this;
    }

    public ExerciseHeartRateReminder setSpaceMode(byte b) {
        this.spaceMode = b;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public AttrBean toAttr() {
        return new AttrBean().setType((byte) getType()).setAttrData(toData());
    }

    public String toString() {
        return "ExerciseHeartRateReminder{max=" + this.max + "spaceMode=" + ((int) this.spaceMode) + ", enable=" + this.enable + '}';
    }
}
