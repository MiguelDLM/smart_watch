package com.jieli.jl_rcsp.model.device.health;

import com.jieli.jl_rcsp.model.device.AttrBean;
import java.nio.ByteBuffer;

/* loaded from: classes10.dex */
public class SedentaryReminder implements IHealthSettingToAttr {
    public static final byte MODE_BRIGHT = 0;
    public static final byte MODE_SHAKE = 1;
    public static final byte STATUS_CLOSE = 0;
    public static final byte STATUS_OPEN = 1;
    private byte endHour;
    private byte endMin;
    private boolean freeLunchBreak;
    private byte mode;
    private byte startHour;
    private byte startMin;
    private byte status;

    public SedentaryReminder(byte[] bArr) {
        parseData(bArr);
    }

    private void parseData(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            boolean z = false;
            this.status = bArr[0];
            int i = 2;
            if (bArr.length >= 2) {
                this.mode = bArr[1];
            } else {
                i = 1;
            }
            int i2 = i + 1;
            if (bArr.length >= i2) {
                if (bArr[i] == 1) {
                    z = true;
                }
                this.freeLunchBreak = z;
                i = i2;
            }
            if (bArr.length >= i + 2) {
                this.startHour = bArr[i];
                this.startMin = bArr[i + 1];
                i += 2;
            }
            if (bArr.length >= i + 2) {
                this.endHour = bArr[i];
                this.endMin = bArr[i + 1];
            }
        }
    }

    private byte[] toData() {
        ByteBuffer allocate = ByteBuffer.allocate(7);
        allocate.put(this.status).put(this.mode).put(this.freeLunchBreak ? (byte) 1 : (byte) 0).put(this.startHour).put(this.startMin).put(this.endHour).put(this.endMin);
        return allocate.array();
    }

    public byte getEndHour() {
        return this.endHour;
    }

    public byte getEndMin() {
        return this.endMin;
    }

    public byte getMode() {
        return this.mode;
    }

    public byte getStartHour() {
        return this.startHour;
    }

    public byte getStartMin() {
        return this.startMin;
    }

    public byte getStatus() {
        return this.status;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public int getType() {
        return 2;
    }

    public boolean isFreeLunchBreak() {
        return this.freeLunchBreak;
    }

    public SedentaryReminder setEndHour(byte b) {
        this.endHour = b;
        return this;
    }

    public SedentaryReminder setEndMin(byte b) {
        this.endMin = b;
        return this;
    }

    public SedentaryReminder setFreeLunchBreak(boolean z) {
        this.freeLunchBreak = z;
        return this;
    }

    public SedentaryReminder setMode(byte b) {
        this.mode = b;
        return this;
    }

    public SedentaryReminder setStartHour(byte b) {
        this.startHour = b;
        return this;
    }

    public SedentaryReminder setStartMin(byte b) {
        this.startMin = b;
        return this;
    }

    public SedentaryReminder setStatus(byte b) {
        this.status = b;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public AttrBean toAttr() {
        return new AttrBean().setType((byte) getType()).setAttrData(toData());
    }

    public String toString() {
        return "SedentaryReminder{status=" + ((int) this.status) + ", freeLunchBreak=" + this.freeLunchBreak + ", mode=" + ((int) this.mode) + ", startHour=" + ((int) this.startHour) + ", startMin=" + ((int) this.startMin) + ", endHour=" + ((int) this.endHour) + ", endMin=" + ((int) this.endMin) + '}';
    }
}
