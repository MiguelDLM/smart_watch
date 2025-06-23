package com.baidu.mapsdkplatform.comapi;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d implements FilenameFilter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f6161a;
    final /* synthetic */ NativeLoader b;

    public d(NativeLoader nativeLoader, String str) {
        this.b = nativeLoader;
        this.f6161a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        if (str == null || !str.contains("libBaiduMapSDK_") || str.contains(this.f6161a)) {
            return false;
        }
        return true;
    }
}
