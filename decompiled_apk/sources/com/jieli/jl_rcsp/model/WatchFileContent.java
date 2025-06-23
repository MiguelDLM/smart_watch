package com.jieli.jl_rcsp.model;

/* loaded from: classes10.dex */
public class WatchFileContent {
    private final short crc;
    private final long fileSize;

    public WatchFileContent(long j, short s) {
        this.fileSize = j;
        this.crc = s;
    }

    public short getCrc() {
        return this.crc;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String toString() {
        return "WatchFileContent{fileSize=" + this.fileSize + ", crc=" + ((int) this.crc) + '}';
    }
}
