package com.androidnetworking.model;

import java.io.File;

/* loaded from: classes.dex */
public class MultipartFileBody {
    public final String contentType;
    public final File file;

    public MultipartFileBody(File file, String str) {
        this.file = file;
        this.contentType = str;
    }
}
