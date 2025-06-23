package com.kwad.sdk.collector;

import android.content.Context;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.utils.t;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class j {
    @WorkerThread
    public static void a(Context context, AppStatusRules appStatusRules) {
        long obtainUploadConfigFileMaxSize = appStatusRules.obtainUploadConfigFileMaxSize();
        List<com.kwad.sdk.collector.model.d> uploadTargets = appStatusRules.getUploadTargets();
        if (uploadTargets == null) {
            return;
        }
        List<com.kwad.sdk.collector.model.e> a2 = b.Bd().a(uploadTargets, obtainUploadConfigFileMaxSize, new File(Environment.getExternalStorageDirectory(), "/Android/data/").getAbsolutePath() + "/");
        List<UploadEntryNative> aZ = aZ(context);
        if (aZ != null) {
            a2.addAll(aZ);
            HashSet hashSet = new HashSet(a2);
            a2.clear();
            a2.addAll(hashSet);
        }
        d(context, a2);
    }

    private static List<UploadEntryNative> aZ(Context context) {
        File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
        if (!file.exists()) {
            return null;
        }
        try {
            return t.gG(com.kwad.sdk.crash.utils.h.I(file));
        } catch (IOException unused) {
            return null;
        }
    }

    public static void ba(Context context) {
        try {
            File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
            if (!file.exists()) {
                return;
            }
            file.delete();
        } catch (Throwable unused) {
        }
    }

    @RequiresApi(api = 19)
    private static void d(final Context context, final List<com.kwad.sdk.collector.model.e> list) {
        if (list != null && list.size() != 0) {
            new l<com.kwad.sdk.collector.a.b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: Bi, reason: merged with bridge method [inline-methods] */
                public com.kwad.sdk.collector.a.b createRequest() {
                    return new com.kwad.sdk.collector.a.b(list);
                }

                @NonNull
                private static CollectResponse cy(String str) {
                    CollectResponse collectResponse = new CollectResponse();
                    collectResponse.parseJson(new JSONObject(str));
                    return collectResponse;
                }

                @Override // com.kwad.sdk.core.network.l
                public final boolean enableMonitorReport() {
                    return false;
                }

                @Override // com.kwad.sdk.core.network.l
                @NonNull
                public final /* synthetic */ CollectResponse parseData(String str) {
                    return cy(str);
                }
            }.request(new o<com.kwad.sdk.collector.a.b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.2
                private synchronized void Bj() {
                    j.ba(context);
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onStartRequest(@NonNull com.kwad.sdk.collector.a.b bVar) {
                    super.onStartRequest(bVar);
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(@NonNull com.kwad.sdk.collector.a.b bVar, @NonNull CollectResponse collectResponse) {
                    super.onSuccess(bVar, collectResponse);
                    Bj();
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onError(@NonNull com.kwad.sdk.collector.a.b bVar, int i, String str) {
                    super.onError(bVar, i, str);
                }
            });
        }
    }
}
