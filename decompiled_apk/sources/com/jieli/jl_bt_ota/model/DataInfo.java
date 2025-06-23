package com.jieli.jl_bt_ota.model;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.interfaces.CommandCallback;
import com.jieli.jl_bt_ota.model.base.BasePacket;
import com.jieli.jl_bt_ota.util.CHexConver;

/* loaded from: classes10.dex */
public class DataInfo {
    public static final int DATA_TYPE_RECEIVE = 1;
    public static final int DATA_TYPE_SEND = 0;
    private BasePacket basePacket;
    private CommandCallback callback;
    private BluetoothDevice device;
    private boolean isSend;
    private int reSendCount;
    private byte[] recvData;
    private long sendTime;
    private int timeoutMs;
    private int type;

    public BasePacket getBasePacket() {
        return this.basePacket;
    }

    public CommandCallback getCallback() {
        return this.callback;
    }

    public BluetoothDevice getDevice() {
        return this.device;
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

    public DataInfo setCallback(CommandCallback commandCallback) {
        this.callback = commandCallback;
        return this;
    }

    public DataInfo setDevice(BluetoothDevice bluetoothDevice) {
        this.device = bluetoothDevice;
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
        this.timeoutMs = i;
        return this;
    }

    public DataInfo setType(int i) {
        this.type = i;
        return this;
    }

    public String toString() {
        return "DataInfo{type=" + this.type + ", recvData=" + CHexConver.byte2HexStr(this.recvData) + ", basePacket=" + this.basePacket + ", timeoutMs=" + this.timeoutMs + ", callback=" + this.callback + ", device=" + this.device + ", reSendCount=" + this.reSendCount + ", isSend=" + this.isSend + ", sendTime=" + this.sendTime + '}';
    }
}
