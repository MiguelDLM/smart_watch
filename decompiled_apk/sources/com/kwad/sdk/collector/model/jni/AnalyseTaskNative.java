package com.kwad.sdk.collector.model.jni;

import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.a;
import java.util.Set;

/* loaded from: classes11.dex */
public class AnalyseTaskNative extends NativeObject implements a {
    public AnalyseTaskNative(AppRunningInfoNative appRunningInfoNative, Set<String> set, long j) {
        String[] strArr = new String[set.size()];
        set.toArray(strArr);
        this.mPtr = AppStatusNative.nativeCreateAnalyseTask(appRunningInfoNative.mPtr, strArr, j);
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        long j = this.mPtr;
        if (j != 0) {
            AppStatusNative.nativeDeleteAnalyseTask(j);
            this.mPtr = 0L;
        }
    }
}
