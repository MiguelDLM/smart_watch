package com.baidu.platform.comjni.bikenavi;

/* loaded from: classes8.dex */
public class JNIEngineManager {
    public native int getSubSysHandle(long j, int i, long[] jArr);

    public native int initBaseAr(long j, long j2);

    public native int initBaseManager(Object obj, long j, long[] jArr);

    public native void registTTS(long j);

    public native void unInitBaseAr(long j);

    public native void uninitBaseManager(long j);
}
