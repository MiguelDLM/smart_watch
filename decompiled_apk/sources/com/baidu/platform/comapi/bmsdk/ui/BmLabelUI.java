package com.baidu.platform.comapi.bmsdk.ui;

/* loaded from: classes8.dex */
public class BmLabelUI extends BmBaseUI {

    /* renamed from: a, reason: collision with root package name */
    private String f9591a;

    public BmLabelUI() {
        super(33, nativeCreate());
        this.f9591a = "";
    }

    private static native long nativeCreate();

    private static native boolean nativeSetMaxLines(long j, int i);

    private static native boolean nativeSetMinLines(long j, int i);

    private static native boolean nativeSetStyle(long j, long j2);

    private static native boolean nativeSetText(long j, String str);
}
