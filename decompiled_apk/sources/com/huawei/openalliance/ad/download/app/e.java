package com.huawei.openalliance.ad.download.app;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.cy;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.fx;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.activity.AgProtocolActivity;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.download.DownloadListener;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.bh;
import com.huawei.openalliance.ad.utils.w;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes10.dex */
public class e implements DownloadListener<AppDownloadTask>, com.huawei.openalliance.ad.download.e<AppDownloadTask>, NotifyCallback {
    private static Map<String, Method> B = new HashMap();
    private static final String Code = "ApDnDe";
    private Context V;
    private AppDownloadListener Z;
    private Map<String, Set<com.huawei.openalliance.ad.download.g>> I = new ConcurrentHashMap();
    private BroadcastReceiver C = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.download.app.e.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.1.1
                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb;
                    try {
                        String action = intent.getAction();
                        fb.Code(e.Code, "appRe action: %s", action);
                        e.this.Code(intent, action);
                    } catch (IllegalStateException e) {
                        e = e;
                        sb = new StringBuilder();
                        sb.append("appRe ");
                        sb.append(e.getClass().getSimpleName());
                        fb.I(e.Code, sb.toString());
                    } catch (Exception e2) {
                        e = e2;
                        sb = new StringBuilder();
                        sb.append("appRe ");
                        sb.append(e.getClass().getSimpleName());
                        fb.I(e.Code, sb.toString());
                    }
                }
            });
        }
    };
    private BroadcastReceiver S = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.download.app.e.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StringBuilder sb;
            Runnable runnable;
            if (intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                fb.V(e.Code, "itRe action: %s", action);
                String dataString = intent.getDataString();
                if (TextUtils.isEmpty(dataString)) {
                    fb.I(e.Code, "itRe dataString is empty, " + action);
                    return;
                }
                final String substring = dataString.substring(8);
                e.this.Code(action, substring);
                if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                    com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.onAppInstalled(g.I().Code(substring));
                        }
                    });
                    return;
                }
                if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                    e.this.Code(substring);
                    if (TextUtils.isEmpty(substring)) {
                        fb.V(e.Code, "a bad removed intent");
                        return;
                    } else if (!substring.equals(com.huawei.openalliance.ad.utils.g.I(context))) {
                        return;
                    } else {
                        runnable = new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                g.I().V();
                            }
                        };
                    }
                } else {
                    if (!"android.intent.action.PACKAGE_DATA_CLEARED".equals(action)) {
                        return;
                    }
                    String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    if (TextUtils.isEmpty(schemeSpecificPart)) {
                        fb.V(e.Code, "a bad intent");
                        return;
                    } else if (!schemeSpecificPart.equals(com.huawei.openalliance.ad.utils.g.I(context))) {
                        return;
                    } else {
                        runnable = new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.2.3
                            @Override // java.lang.Runnable
                            public void run() {
                                g.I().V();
                            }
                        };
                    }
                }
                bf.Code(runnable);
            } catch (IllegalStateException e) {
                e = e;
                sb = new StringBuilder();
                sb.append("itRe:");
                sb.append(e.getClass().getSimpleName());
                fb.I(e.Code, sb.toString());
            } catch (Exception e2) {
                e = e2;
                sb = new StringBuilder();
                sb.append("itRe:");
                sb.append(e.getClass().getSimpleName());
                fb.I(e.Code, sb.toString());
            }
        }
    };

    public e(Context context) {
        this.V = context.getApplicationContext();
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("huawei.intent.action.DOWNLOAD");
            intentFilter.addAction("huawei.intent.action.OPEN");
            intentFilter.addAction(d.Z);
            intentFilter.addAction(d.d);
            intentFilter.addAction(d.C);
            intentFilter.addAction("huawei.intent.action.PPS_APP_USER_CANCEL");
            this.V.registerReceiver(this.C, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
            if (w.B(this.V)) {
                com.huawei.openalliance.ad.msgnotify.b.Code(context, d.j, this);
            } else {
                com.huawei.openalliance.ad.msgnotify.b.V(context, d.j, this);
            }
            IntentFilter intentFilter2 = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            intentFilter2.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter2.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter2.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
            intentFilter2.addDataScheme("package");
            this.V.registerReceiver(this.S, intentFilter2);
            ge.Code(context).Code();
            Code();
        } catch (Throwable th) {
            fb.I(Code, "registerReceiver " + th.getClass().getSimpleName());
        }
    }

    private void B(Intent intent) {
        String str;
        if (intent == null) {
            str = "msgData is empty!";
        } else {
            SafeIntent safeIntent = new SafeIntent(intent);
            String stringExtra = safeIntent.getStringExtra(bb.aA);
            if (stringExtra == null || stringExtra.equals(this.V.getPackageName())) {
                String stringExtra2 = safeIntent.getStringExtra("contentRecord");
                if (fb.Code()) {
                    fb.Code(Code, "sendNotify content: %s", bh.Code(stringExtra2));
                }
                AdContentData adContentData = (AdContentData) aa.V(stringExtra2, AdContentData.class, new Class[0]);
                if (adContentData != null) {
                    String stringExtra3 = safeIntent.getStringExtra("unique_id");
                    AppInfo y = adContentData.y();
                    if (y == null || y.p() != 1 || TextUtils.isEmpty(y.q())) {
                        return;
                    }
                    int intExtra = safeIntent.getIntExtra(bb.L, 1);
                    fx fxVar = new fx(this.V, adContentData, stringExtra3);
                    fxVar.Code(intExtra);
                    fxVar.I();
                    return;
                }
                str = " contentData is empty.";
            } else {
                str = "sourcePackageName not equals packageName.";
            }
        }
        fb.V(Code, str);
    }

    private synchronized Set<com.huawei.openalliance.ad.download.g> Code(AppInfo appInfo) {
        if (appInfo != null) {
            if (!TextUtils.isEmpty(appInfo.Code())) {
                return V(appInfo.Code());
            }
        }
        return null;
    }

    private void I(Intent intent) {
        try {
            if (d.Z.equals(intent.getAction())) {
                AppInfo V = V(intent);
                if (V == null) {
                    fb.V(Code, "appInfo is null");
                    return;
                }
                com.huawei.openalliance.ad.download.a Code2 = com.huawei.openalliance.ad.download.a.Code();
                if (Code2 != null) {
                    Code2.Code(V);
                }
            }
        } catch (Throwable th) {
            fb.I(Code, "exception: %s", th.getClass().getSimpleName());
        }
    }

    private static AppInfo V(Intent intent) {
        return (AppInfo) aa.V(new SafeIntent(intent).getStringExtra("appInfo"), AppInfo.class, new Class[0]);
    }

    private void Z(Intent intent) {
        String str;
        int i;
        String str2;
        try {
            PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pendingIntent");
            if (pendingIntent != null) {
                Intent intent2 = new Intent();
                intent2.setClass(this.V, AgProtocolActivity.class);
                intent2.putExtra("pendingIntent", pendingIntent);
                i = intent.getIntExtra(d.f, 6);
                intent2.putExtra(d.f, i);
                str = intent.getStringExtra(d.g);
                intent2.putExtra(d.g, str);
                str2 = intent.getStringExtra("ag_action_name");
                intent2.putExtra("ag_action_name", str2);
                intent2.addFlags(268959744);
                intent2.setClipData(x.cM);
                this.V.startActivity(intent2);
            } else {
                str = null;
                i = -1;
                str2 = null;
            }
            cy.Code(this.V, i, str, str2, a.Code);
        } catch (Throwable unused) {
            fb.V(Code, " requestAgProtocol error");
        }
    }

    @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
    public void onMessageNotify(String str, Intent intent) {
        if (TextUtils.isEmpty(str) || intent == null) {
            fb.V(Code, "msgName or msgData is empty!");
        } else {
            fb.Code(Code, "onMessageNotify msgName:%s", str);
            this.C.onReceive(this.V, intent);
        }
    }

    private static void Code() {
        try {
            for (Method method : e.class.getDeclaredMethods()) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].isAssignableFrom(AppDownloadTask.class)) {
                    B.put(method.getName(), method);
                }
            }
        } catch (Throwable th) {
            fb.Code(Code, "transport=%s", th.getMessage());
            fb.Z(Code, "transport=" + th.getClass().getSimpleName());
        }
    }

    private void I(AppDownloadTask appDownloadTask) {
        Set<com.huawei.openalliance.ad.download.g> Code2 = Code(appDownloadTask.L());
        if (Code2 == null || Code2.size() <= 0) {
            return;
        }
        Iterator<com.huawei.openalliance.ad.download.g> it = Code2.iterator();
        while (it.hasNext()) {
            it.next().V(appDownloadTask);
        }
    }

    private synchronized Set<com.huawei.openalliance.ad.download.g> V(String str) {
        return this.I.get(str);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onAppInstalled(AppDownloadTask appDownloadTask) {
        if (appDownloadTask != null) {
            appDownloadTask.Code(6);
            Code(k.INSTALLED, appDownloadTask);
            I(appDownloadTask);
            new n(appDownloadTask).Code();
        }
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onAppUnInstalled(AppDownloadTask appDownloadTask) {
        if (appDownloadTask != null) {
            String Code2 = appDownloadTask.L().Code();
            Set<com.huawei.openalliance.ad.download.g> V = V(Code2);
            if (V != null && V.size() > 0) {
                Iterator<com.huawei.openalliance.ad.download.g> it = V.iterator();
                while (it.hasNext()) {
                    it.next().I(Code2);
                }
            }
            Code(k.DOWNLOAD, appDownloadTask);
        }
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadDeleted(AppDownloadTask appDownloadTask) {
        appDownloadTask.I(0);
        appDownloadTask.V(0L);
        appDownloadTask.Code(4);
        I(appDownloadTask);
        Code(k.DOWNLOADFAILED, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadFail(AppDownloadTask appDownloadTask) {
        if (appDownloadTask != null) {
            fb.V(Code, "onDownloadFail, current way: %s", appDownloadTask.j());
        }
        if (Code(appDownloadTask)) {
            return;
        }
        I(appDownloadTask);
        Code(k.DOWNLOADFAILED, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadPaused(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(k.PAUSE, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadProgress(AppDownloadTask appDownloadTask) {
        fb.Code(Code, "onDownloadProgress: %s", Boolean.valueOf(this.Z == null));
        V(appDownloadTask);
        AppDownloadListener appDownloadListener = this.Z;
        if (appDownloadListener != null) {
            appDownloadListener.Code(appDownloadTask.L(), appDownloadTask.S());
        }
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadResumed(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(k.RESUME, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadStart(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(k.DOWNLOADING, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadSuccess(AppDownloadTask appDownloadTask) {
        Code(k.DOWNLOADED, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadWaiting(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(k.WAITING, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onSilentInstallFailed(AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null) {
            return;
        }
        fb.I(Code, "install apk failed, reason: %s", Integer.valueOf(appDownloadTask.o()));
        if (appDownloadTask.o() != 7) {
            if (appDownloadTask.o() != 1 && Code(appDownloadTask)) {
                return;
            }
            I(appDownloadTask);
            Code(appDownloadTask.B() == 4 ? k.DOWNLOAD : k.INSTALL, appDownloadTask);
            return;
        }
        AppDownloadListener appDownloadListener = this.Z;
        if (appDownloadListener != null) {
            appDownloadListener.Code(appDownloadTask.L(), appDownloadTask.S());
        }
        if (appDownloadTask.l()) {
            fb.Code(Code, "switch next install way success");
        } else {
            fb.Code(Code, "switch next install way failed");
            appDownloadTask.B(0);
        }
        I(appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onSilentInstallStart(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(k.INSTALLING, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onSilentInstallSuccess(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(k.INSTALLED, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onSystemInstallStart(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(k.INSTALL, appDownloadTask);
    }

    private void Code(Intent intent) {
        com.huawei.openalliance.ad.download.a Code2;
        try {
            AppInfo V = V(intent);
            if (V == null || (Code2 = com.huawei.openalliance.ad.download.a.Code()) == null) {
                return;
            }
            Code2.V(V);
        } catch (Throwable th) {
            fb.I(Code, "onUserCancel ex: %s", th.getClass().getSimpleName());
        }
    }

    private void I(String str) {
        if (TextUtils.isEmpty(str)) {
            fb.V(Code, " packageName is empty.");
            return;
        }
        Set<com.huawei.openalliance.ad.download.g> V = V(str);
        fb.Code(Code, " findAndRefreshTask list:%s", V);
        if (V == null || V.size() <= 0) {
            return;
        }
        Iterator<com.huawei.openalliance.ad.download.g> it = V.iterator();
        while (it.hasNext()) {
            it.next().Code(str);
        }
    }

    private void V(AppDownloadTask appDownloadTask) {
        Set<com.huawei.openalliance.ad.download.g> Code2 = Code(appDownloadTask.L());
        if (Code2 == null || Code2.size() <= 0) {
            return;
        }
        Iterator<com.huawei.openalliance.ad.download.g> it = Code2.iterator();
        while (it.hasNext()) {
            it.next().Code(appDownloadTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Intent intent, String str) {
        SafeIntent safeIntent = new SafeIntent(intent);
        if (!"huawei.intent.action.DOWNLOAD".equals(str)) {
            if ("huawei.intent.action.OPEN".equals(str)) {
                String stringExtra = safeIntent.getStringExtra("appPackageName");
                AppDownloadListener appDownloadListener = this.Z;
                if (appDownloadListener != null) {
                    appDownloadListener.Code(stringExtra);
                    return;
                }
                return;
            }
            if (d.Z.equals(str)) {
                I(safeIntent);
                return;
            }
            if (d.d.equals(str)) {
                fb.V(Code, "request intent");
                Z(safeIntent);
                return;
            } else if (d.C.equals(str)) {
                B(safeIntent);
                return;
            } else {
                if ("huawei.intent.action.PPS_APP_USER_CANCEL".equals(str)) {
                    Code(safeIntent);
                    return;
                }
                return;
            }
        }
        String stringExtra2 = safeIntent.getStringExtra("appPackageName");
        AppDownloadTask Code2 = g.I().Code(stringExtra2);
        if (Code2 == null) {
            fb.V(Code, " task is null, pkg=" + stringExtra2);
            I(stringExtra2);
            return;
        }
        String stringExtra3 = safeIntent.getStringExtra("appInfo");
        if (!TextUtils.isEmpty(stringExtra3)) {
            AppInfo appInfo = (AppInfo) aa.V(stringExtra3, AppInfo.class, new Class[0]);
            AppInfo L = Code2.L();
            if (appInfo != null) {
                fb.V(Code, "update appInfo from remote task.");
                L.V(appInfo.e());
            }
        }
        Code(Code2, safeIntent);
        String stringExtra4 = safeIntent.getStringExtra("appDownloadMethod");
        if (TextUtils.isEmpty(stringExtra4)) {
            return;
        }
        if (stringExtra4.equals("onDownloadDeleted")) {
            g.I().I((g) Code2);
            return;
        }
        Method method = B.get(stringExtra4);
        if (method != null) {
            try {
                fb.Code(Code, "methodName:%s", stringExtra4);
                method.invoke(this, Code2);
            } catch (IllegalAccessException unused) {
                fb.Code(Code, "ilex=%s", stringExtra4);
            } catch (InvocationTargetException unused2) {
                fb.Code(Code, "itex=%s", stringExtra4);
            }
        }
    }

    public synchronized void V(String str, com.huawei.openalliance.ad.download.g gVar) {
        Set<com.huawei.openalliance.ad.download.g> set = this.I.get(str);
        if (set != null && set.size() > 0) {
            set.remove(gVar);
            if (set.size() <= 0) {
                this.I.remove(str);
            }
        }
    }

    private void Code(AppDownloadTask appDownloadTask, int i) {
        appDownloadTask.V((appDownloadTask.I() * i) / 100);
    }

    private void Code(AppDownloadTask appDownloadTask, Intent intent) {
        SafeIntent safeIntent = new SafeIntent(intent);
        appDownloadTask.Code(safeIntent.getIntExtra("downloadStatus", 0));
        appDownloadTask.I(safeIntent.getIntExtra("downloadProgress", 0));
        appDownloadTask.Z(safeIntent.getIntExtra("pauseReason", 0));
        appDownloadTask.B(safeIntent.getIntExtra(d.l, 0));
        Code(appDownloadTask, appDownloadTask.S());
    }

    private void Code(k kVar, AppDownloadTask appDownloadTask) {
        AppDownloadListener appDownloadListener = this.Z;
        if (appDownloadListener != null) {
            appDownloadListener.Code(kVar, appDownloadTask.L());
        }
    }

    public void Code(AppDownloadListener appDownloadListener) {
        this.Z = appDownloadListener;
    }

    public void Code(String str) {
        NotificationManager notificationManager;
        if (TextUtils.isEmpty(str) || (notificationManager = (NotificationManager) this.V.getSystemService("notification")) == null) {
            return;
        }
        notificationManager.cancel(str.hashCode());
    }

    public synchronized void Code(String str, com.huawei.openalliance.ad.download.g gVar) {
        try {
            Set<com.huawei.openalliance.ad.download.g> set = this.I.get(str);
            if (set == null) {
                set = new HashSet<>();
                this.I.put(str, set);
            }
            set.add(gVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str, String str2) {
        Set<com.huawei.openalliance.ad.download.g> V = V(str2);
        if (V != null && V.size() > 0) {
            if ("android.intent.action.PACKAGE_ADDED".equals(str)) {
                for (com.huawei.openalliance.ad.download.g gVar : V) {
                    if (gVar != null) {
                        gVar.V(str2);
                    }
                }
            } else if ("android.intent.action.PACKAGE_REMOVED".equals(str)) {
                for (com.huawei.openalliance.ad.download.g gVar2 : V) {
                    if (gVar2 != null) {
                        gVar2.I(str2);
                    }
                }
            }
        }
        if (!"android.intent.action.PACKAGE_REMOVED".equals(str) || this.Z == null) {
            return;
        }
        AppInfo appInfo = new AppInfo();
        appInfo.b(str2);
        this.Z.Code(k.DOWNLOAD, appInfo);
    }

    @Override // com.huawei.openalliance.ad.download.e
    public boolean Code(AppDownloadTask appDownloadTask) {
        return g.I().Z(appDownloadTask);
    }
}
