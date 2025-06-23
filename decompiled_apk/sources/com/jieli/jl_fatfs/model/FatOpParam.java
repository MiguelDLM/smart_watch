package com.jieli.jl_fatfs.model;

import com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener;

/* loaded from: classes10.dex */
public class FatOpParam {
    public static final int FAT_OP_CREATE_FILE = 2;
    public static final int FAT_OP_DELETE_FILE = 3;
    public static final int FAT_OP_RECOVERY_SYS = 255;
    public static final int FAT_OP_REPLACE_FILE = 4;
    private String filePath;
    private OnFatFileProgressListener mProgressListener;
    private int op;
    private int sumFileDataLen = 0;
    private long totalSize = 0;

    public String getFilePath() {
        return this.filePath;
    }

    public int getOp() {
        return this.op;
    }

    public OnFatFileProgressListener getProgressListener() {
        return this.mProgressListener;
    }

    public int getSumFileDataLen() {
        return this.sumFileDataLen;
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public FatOpParam setFilePath(String str) {
        this.filePath = str;
        return this;
    }

    public FatOpParam setOp(int i) {
        this.op = i;
        return this;
    }

    public FatOpParam setProgressListener(OnFatFileProgressListener onFatFileProgressListener) {
        this.mProgressListener = onFatFileProgressListener;
        return this;
    }

    public FatOpParam setSumFileDataLen(int i) {
        this.sumFileDataLen = i;
        return this;
    }

    public FatOpParam setTotalSize(long j) {
        this.totalSize = j;
        return this;
    }

    public String toString() {
        return "FatOpParam{op=" + this.op + ", filePath='" + this.filePath + "', sumFileDataLen=" + this.sumFileDataLen + ", totalSize=" + this.totalSize + ", mProgressListener=" + this.mProgressListener + '}';
    }
}
