package com.androidnetworking.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Progress implements Serializable {
    public long currentBytes;
    public long totalBytes;

    public Progress(long j, long j2) {
        this.currentBytes = j;
        this.totalBytes = j2;
    }
}
