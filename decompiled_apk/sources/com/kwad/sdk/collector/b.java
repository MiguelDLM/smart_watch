package com.kwad.sdk.collector;

import android.os.Environment;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.model.jni.AnalyseTaskNative;
import com.kwad.sdk.collector.model.jni.AppRunningInfoNative;
import com.kwad.sdk.collector.model.jni.RulesTargetNative;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public final class b {
    public static com.kwad.sdk.collector.a Bd() {
        return new a();
    }

    /* loaded from: classes11.dex */
    public static class a implements com.kwad.sdk.collector.a {
        @Override // com.kwad.sdk.collector.a
        public final List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            com.kwad.sdk.collector.model.c.a(strategy, arrayList2);
            File file = new File(Environment.getExternalStorageDirectory(), "/Android/data/");
            int size = arrayList2.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                com.kwad.sdk.collector.model.a aVar = (com.kwad.sdk.collector.model.a) arrayList2.get(i);
                if (!(aVar instanceof AnalyseTaskNative)) {
                    return arrayList;
                }
                jArr[i] = ((AnalyseTaskNative) aVar).getNativePtr();
            }
            if (d.Bf()) {
                try {
                    long[] analysis = AppStatusNative.analysis(jArr, file.getAbsolutePath() + "/");
                    StringBuilder sb = new StringBuilder("analysisByFile: runningInfoPtrs: ");
                    sb.append(analysis);
                    com.kwad.sdk.core.e.c.d("AppStatusAnalyserNative", sb.toString());
                    for (long j : analysis) {
                        arrayList.add(new AppRunningInfoNative(j));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
            com.kwad.sdk.core.e.c.d("AppStatusAnalyserNative", "analysisByFile: info size: " + arrayList.size());
            return arrayList;
        }

        @Override // com.kwad.sdk.collector.a
        public final List<com.kwad.sdk.collector.model.e> a(List<com.kwad.sdk.collector.model.d> list, long j, String str) {
            int size = list.size();
            long[] jArr = new long[list.size()];
            for (int i = 0; i < size; i++) {
                com.kwad.sdk.collector.model.d dVar = list.get(i);
                if (dVar instanceof RulesTargetNative) {
                    jArr[i] = ((RulesTargetNative) dVar).getNativePtr();
                }
            }
            ArrayList arrayList = new ArrayList();
            if (d.Bf()) {
                try {
                    for (long j2 : AppStatusNative.nativeGetUploadEntry(jArr, j, str)) {
                        arrayList.add(new UploadEntryNative(j2));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
            return arrayList;
        }
    }
}
