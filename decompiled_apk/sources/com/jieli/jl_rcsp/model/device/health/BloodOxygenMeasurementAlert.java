package com.jieli.jl_rcsp.model.device.health;

import com.jieli.jl_rcsp.model.device.AttrBean;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class BloodOxygenMeasurementAlert implements IHealthSettingToAttr {
    public static final int MODE_SMART = 0;
    public static final int MODE_TIMING = 1;
    public static final int STATE_CLOSE = 0;
    public static final int STATE_OPEN = 1;
    private int limitingValue;
    private int mode;
    private int state;

    public BloodOxygenMeasurementAlert(byte[] bArr) {
        parseData(bArr);
    }

    private void parseData(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            this.state = CHexConver.byteToInt(bArr[0]);
            char c = 1;
            if (bArr.length > 1) {
                this.mode = CHexConver.byteToInt(bArr[1]);
                c = 2;
            }
            if (bArr.length > 2) {
                this.limitingValue = CHexConver.byteToInt(bArr[c]);
            }
        }
    }

    private byte[] toData() {
        return new byte[]{CHexConver.intToByte(this.state), CHexConver.intToByte(this.mode), CHexConver.intToByte(this.limitingValue)};
    }

    public int getLimitingValue() {
        return this.limitingValue;
    }

    public int getMode() {
        return this.mode;
    }

    public int getState() {
        return this.state;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public int getType() {
        return 11;
    }

    public BloodOxygenMeasurementAlert setLimitingValue(int i) {
        this.limitingValue = i;
        return this;
    }

    public BloodOxygenMeasurementAlert setMode(int i) {
        this.mode = i;
        return this;
    }

    public BloodOxygenMeasurementAlert setState(int i) {
        this.state = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public AttrBean toAttr() {
        AttrBean attrBean = new AttrBean();
        attrBean.setType((byte) getType());
        attrBean.setAttrData(toData());
        return attrBean;
    }

    public String toString() {
        return "BloodOxygenMeasurementAlert{state=" + this.state + ", mode=" + this.mode + ", limitingValue=" + this.limitingValue + '}';
    }
}
