package com.jieli.jl_rcsp.model.data;

/* loaded from: classes10.dex */
public class DataParams {
    private final int dataType;
    private int receiveLimit;
    private int sendLimit;
    private final int version;
    private final int way;

    public DataParams(int i, int i2, int i3, int i4, int i5) {
        this.way = i;
        this.dataType = i2;
        this.version = i3;
        setSendLimit(i4).setReceiveLimit(i5);
    }

    public int getDataType() {
        return this.dataType;
    }

    public int getReceiveLimit() {
        return this.receiveLimit;
    }

    public int getSendLimit() {
        return this.sendLimit;
    }

    public int getVersion() {
        return this.version;
    }

    public int getWay() {
        return this.way;
    }

    public DataParams setReceiveLimit(int i) {
        this.receiveLimit = i;
        return this;
    }

    public DataParams setSendLimit(int i) {
        this.sendLimit = i;
        return this;
    }

    public String toString() {
        return "DataParams{dataType=" + this.dataType + ", version=" + this.version + ", sendLimit=" + this.sendLimit + ", receiveLimit=" + this.receiveLimit + '}';
    }
}
