package com.realsil.sdk.core.logger;

/* loaded from: classes11.dex */
public interface Logger {
    public static final int ASSET = 6;
    public static final int DEBUG = 2;
    public static final int ERROR = 5;
    public static final int INFO = 3;
    public static final int NA = 0;
    public static final int VERBOSE = 1;
    public static final int WARN = 4;

    void log(int i, String str, String str2);
}
