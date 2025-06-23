package com.huawei.openalliance.ad.download.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.work.PeriodicWorkRequest;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.jc;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.SafeIntent;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes10.dex */
public class l {
    private static l B = null;
    private static final String Code = "GPDownloadManager";
    private static final int V = 900000;
    private Context C;
    private static final byte[] I = new byte[0];
    private static final byte[] Z = new byte[0];
    private Map<String, AppDownloadTask> S = new ConcurrentHashMap();
    private BroadcastReceiver F = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.download.app.l.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            String dataString = safeIntent.getDataString();
            if (TextUtils.isEmpty(dataString)) {
                fb.I(l.Code, "itRer dataString is empty");
                return;
            }
            String substring = dataString.substring(8);
            try {
                if ("android.intent.action.PACKAGE_ADDED".equals(safeIntent.getAction())) {
                    l.this.Code(substring);
                }
            } catch (Throwable th) {
                fb.I(l.Code, "itRer: %s", th.getClass().getSimpleName());
            }
        }
    };

    private l(Context context) {
        this.C = context.getApplicationContext();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        this.C.registerReceiver(this.F, intentFilter);
    }

    public static l Code(Context context) {
        l lVar;
        synchronized (I) {
            try {
                if (B == null) {
                    B = new l(context);
                }
                lVar = B;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str) {
        fb.V(Code, "dealWithAdd");
        synchronized (Z) {
            try {
                if (this.S.containsKey(str)) {
                    AppDownloadTask appDownloadTask = this.S.get(str);
                    this.S.remove(str);
                    fb.V(Code, "task size after remove: %s", Integer.valueOf(this.S.size()));
                    AdContentData f = appDownloadTask.f();
                    if (f != null && f.y() != null) {
                        jc.Code(this.C, f, appDownloadTask.b(), f.y().k());
                    }
                }
            } finally {
            }
        }
    }

    public void Code(String str, AppDownloadTask appDownloadTask) {
        synchronized (Z) {
            try {
                fb.Code(Code, "task size before: %s", Integer.valueOf(this.S.size()));
                for (Map.Entry entry : new ConcurrentHashMap(this.S).entrySet()) {
                    fb.Code(Code, "entry key: %s time: %s", entry.getKey(), Long.valueOf(((AppDownloadTask) entry.getValue()).p()));
                    if (System.currentTimeMillis() - ((AppDownloadTask) entry.getValue()).p() > PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
                        this.S.remove(entry.getKey());
                    }
                }
                this.S.put(str, appDownloadTask);
                fb.V(Code, "task size after: %s, packageName: %s time: %s", Integer.valueOf(this.S.size()), str, this.S.get(str) != null ? Long.valueOf(this.S.get(str).p()) : null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
