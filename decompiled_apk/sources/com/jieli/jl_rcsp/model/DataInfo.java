package com.jieli.jl_rcsp.model;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class DataInfo {
    public static final int DATA_TYPE_RECEIVE = 1;
    public static final int DATA_TYPE_SEND = 0;
    private BasePacket basePacket;
    private BluetoothDevice device;
    private boolean isSend;
    private RcspCommandCallback mRcspCmdCallback;
    private int reSendCount;
    private byte[] recvData;
    private long sendTime;
    private int timeoutMs = 2000;
    private int type;

    public BasePacket getBasePacket() {
        return this.basePacket;
    }

    public BluetoothDevice getDevice() {
        return this.device;
    }

    public RcspCommandCallback getRcspCmdCallback() {
        return this.mRcspCmdCallback;
    }

    public int getReSendCount() {
        return this.reSendCount;
    }

    public byte[] getRecvData() {
        return this.recvData;
    }

    public long getSendTime() {
        return this.sendTime;
    }

    public int getTimeoutMs() {
        return this.timeoutMs;
    }

    public int getType() {
        return this.type;
    }

    public boolean isSend() {
        return this.isSend;
    }

    public DataInfo setBasePacket(BasePacket basePacket) {
        this.basePacket = basePacket;
        return this;
    }

    public DataInfo setDevice(BluetoothDevice bluetoothDevice) {
        this.device = bluetoothDevice;
        return this;
    }

    public DataInfo setRcspCmdCallback(RcspCommandCallback rcspCommandCallback) {
        this.mRcspCmdCallback = rcspCommandCallback;
        return this;
    }

    public DataInfo setReSendCount(int i) {
        this.reSendCount = i;
        return this;
    }

    public DataInfo setRecvData(byte[] bArr) {
        this.recvData = bArr;
        return this;
    }

    public DataInfo setSend(boolean z) {
        this.isSend = z;
        return this;
    }

    public DataInfo setSendTime(long j) {
        this.sendTime = j;
        return this;
    }

    public DataInfo setTimeoutMs(int i) {
        this.timeoutMs = Math.max(100, i);
        return this;
    }

    public DataInfo setType(int i) {
        this.type = i;
        return this;
    }

    public String toString() {
        return "DataInfo{device=" + this.device + ", type=" + this.type + ", recvData=" + CHexConver.byte2HexStr(this.recvData) + ", basePacket=" + this.basePacket + ", timeoutMs=" + this.timeoutMs + ", mRcspCmdCallback=" + this.mRcspCmdCallback + ", reSendCount=" + this.reSendCount + ", isSend=" + this.isSend + ", sendTime=" + this.sendTime + '}';
    }
}
