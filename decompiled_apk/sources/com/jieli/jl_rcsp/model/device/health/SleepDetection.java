package com.jieli.jl_rcsp.model.device.health;

import com.jieli.jl_rcsp.model.device.AttrBean;
import java.nio.ByteBuffer;

/* loaded from: classes10.dex */
public class SleepDetection implements IHealthSettingToAttr {
    public static final byte STATUS_ALL_DAY = 1;
    public static final byte STATUS_CLOSE = 0;
    public static final byte STATUS_CUSTOM_TIME = 2;
    byte endHour;
    byte endMin;
    byte startHour;
    byte startMin;
    private byte status;

    public SleepDetection(byte[] bArr) {
        parseData(bArr);
    }

    private void parseData(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            this.status = bArr[0];
            int i = 3;
            if (bArr.length >= 3) {
                this.startHour = (byte) Math.max(Math.min((int) bArr[1], 23), 0);
                this.startMin = (byte) Math.max(Math.min((int) bArr[2], 59), 0);
            } else {
                i = 1;
            }
            if (bArr.length >= i + 2) {
                this.endHour = (byte) Math.max(Math.min((int) bArr[i], 23), 0);
                this.endMin = (byte) Math.max(Math.min((int) bArr[i + 1], 59), 0);
            }
        }
    }

    private byte[] toData() {
        ByteBuffer allocate = ByteBuffer.allocate(5);
        allocate.put(this.status).put(this.startHour).put(this.startMin).put(this.endHour).put(this.endMin);
        return allocate.array();
    }

    public byte getEndHour() {
        return this.endHour;
    }

    public byte getEndMin() {
        return this.endMin;
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
        return 6;
    }

    public SleepDetection setEndHour(byte b) {
        this.endHour = b;
        return this;
    }

    public SleepDetection setEndMin(byte b) {
        this.endMin = b;
        return this;
    }

    public SleepDetection setStartHour(byte b) {
        this.startHour = b;
        return this;
    }

    public SleepDetection setStartMin(byte b) {
        this.startMin = b;
        return this;
    }

    public SleepDetection setStatus(byte b) {
        this.status = b;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public AttrBean toAttr() {
        return new AttrBean().setType((byte) getType()).setAttrData(toData());
    }

    public String toString() {
        return "SleepDetection{status=" + ((int) this.status) + ", startHour=" + ((int) this.startHour) + ", startMin=" + ((int) this.startMin) + ", endHour=" + ((int) this.endHour) + ", endMin=" + ((int) this.endMin) + '}';
    }
}
