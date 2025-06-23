package com.jieli.jl_filebrowse.bean;

/* loaded from: classes10.dex */
public class FileChangeInfo {
    private final int cluster;
    private final int devHandle;
    private final String filePath;
    private final int op;

    public FileChangeInfo(int i, int i2, int i3, String str) {
        this.devHandle = i;
        this.op = i2;
        this.cluster = i3;
        this.filePath = str;
    }

    public int getCluster() {
        return this.cluster;
    }

    public final int getDevHandle() {
        return this.devHandle;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getOp() {
        return this.op;
    }

    public String toString() {
        return "FileChangeInfo{devHandle=" + this.devHandle + ", op=" + this.op + ", cluster=" + this.cluster + ", filePath='" + this.filePath + "'}";
    }
}
