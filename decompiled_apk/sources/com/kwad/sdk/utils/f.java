package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.c;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class f {
    private static Handler YX;
    private static Messenger aPl;
    private static volatile ExecutorService aPm;
    private static volatile AppStatusRules aPn;
    private static WeakReference<Context> aPo;
    private static com.kwad.sdk.collector.h aPp;
    private static ServiceConnection ayn = new ServiceConnection() { // from class: com.kwad.sdk.utils.f.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message obtain = Message.obtain();
                obtain.what = 100;
                if (f.access$000()) {
                    obtain.replyTo = f.aPl;
                    try {
                        messenger.send(obtain);
                        return;
                    } catch (RemoteException unused) {
                        return;
                    }
                }
                com.kwad.sdk.core.e.c.w("AppStatusHelper", "clientMessenger init error");
            } catch (SecurityException e) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                com.kwad.sdk.service.c.gatherException(e);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: com.kwad.sdk.utils.f$2, reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass2 extends az {
        final /* synthetic */ Context gq;

        public AnonymousClass2(Context context) {
            this.gq = context;
        }

        @Override // com.kwad.sdk.utils.az
        public final void doTask() {
            com.kwad.sdk.collector.c.a(this.gq, new c.a() { // from class: com.kwad.sdk.utils.f.2.1
                @Override // com.kwad.sdk.collector.c.a
                public final void b(AppStatusRules appStatusRules) {
                    boolean z;
                    appStatusRules.initStatus(AnonymousClass2.this.gq);
                    AppStatusRules unused = f.aPn = appStatusRules;
                    f.b(AnonymousClass2.this.gq, f.aPn);
                    f.bU(AnonymousClass2.this.gq);
                    boolean dw = bj.dw(AnonymousClass2.this.gq);
                    boolean isAppStatusTargetNotEmpty = AppStatusRules.isAppStatusTargetNotEmpty(f.aPn);
                    com.kwad.sdk.core.e.c.d("AppStatusHelper", "appStatusTargetNotEmpty: " + isAppStatusTargetNotEmpty + ", permissionGranted: " + dw);
                    if (dw && isAppStatusTargetNotEmpty) {
                        long obtainDefaultScanInterval = f.aPn.obtainDefaultScanInterval();
                        if (obtainDefaultScanInterval <= 0) {
                            f.bW(AnonymousClass2.this.gq);
                        } else {
                            f.c(AnonymousClass2.this.gq, obtainDefaultScanInterval);
                        }
                    }
                    boolean isUploadTargetNotEmpty = AppStatusRules.isUploadTargetNotEmpty(f.aPn);
                    if (f.aPn.obtainUploadConfigFileMaxSize() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    com.kwad.sdk.core.e.c.d("AppStatusHelper", "uploadTargetNotEmpty: " + isUploadTargetNotEmpty + ", enableUpload: " + z);
                    if (isUploadTargetNotEmpty && z && dw) {
                        f.LB();
                        f.aPm.submit(new Runnable() { // from class: com.kwad.sdk.utils.f.2.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    com.kwad.sdk.collector.j.a(AnonymousClass2.this.gq, f.aPn);
                                } catch (Throwable th) {
                                    com.kwad.sdk.service.c.gatherException(th);
                                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.collector.c.a
                public final void r(int i, String str) {
                    com.kwad.sdk.core.e.c.e("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i);
                }
            });
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        void u(List<com.kwad.sdk.collector.model.b> list);
    }

    /* loaded from: classes11.dex */
    public static class c extends Handler {
        public c(@NonNull Looper looper) {
            super(looper);
        }

        private static void N(List<a> list) {
            if (list == null) {
                return;
            }
            f.aPp.c(t.O(list));
        }

        private static void b(ArrayList<com.kwad.sdk.collector.model.b> arrayList) {
            JSONArray L;
            if (arrayList != null && (L = a.L(arrayList)) != null) {
                f.aPp.c(L);
            }
        }

        private void c(Message message) {
            ArrayList arrayList;
            List list;
            Bundle data = message.getData();
            List<AppStatusRules.Strategy> list2 = null;
            if (data != null) {
                try {
                    if (data.containsKey("resultJson")) {
                        list = t.a(data.getString("resultJson"), new com.kwad.sdk.core.c<a>() { // from class: com.kwad.sdk.utils.f.c.1
                            private static a LK() {
                                return new a();
                            }

                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ a BE() {
                                return LK();
                            }
                        });
                        arrayList = null;
                    } else {
                        arrayList = (ArrayList) data.getSerializable("data");
                        list = null;
                    }
                } catch (Throwable unused) {
                    arrayList = null;
                    list = null;
                }
                if (arrayList != null) {
                    com.kwad.sdk.core.e.c.d("AppStatusHelper", "ClientHandler: handleMessage data size: " + arrayList.size());
                    b(arrayList);
                }
                if (list != null) {
                    N(list);
                }
            }
            if (f.aPo != null && f.aPo.get() != null && data != null) {
                if (data.containsKey("allStrategyJson")) {
                    String string = data.getString("allStrategyJson");
                    if (string != null) {
                        list2 = t.a(string, new com.kwad.sdk.core.c<AppStatusRules.Strategy>() { // from class: com.kwad.sdk.utils.f.c.2
                            private static AppStatusRules.Strategy LL() {
                                return new AppStatusRules.Strategy();
                            }

                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ AppStatusRules.Strategy BE() {
                                return LL();
                            }
                        });
                    }
                } else {
                    list2 = (ArrayList) data.getSerializable("allStrategy");
                }
                if (list2 != null) {
                    for (AppStatusRules.Strategy strategy : list2) {
                        long needSaveLaunchTime = strategy.getNeedSaveLaunchTime();
                        if (needSaveLaunchTime >= 0) {
                            com.kwad.sdk.collector.i.a((Context) f.aPo.get(), strategy, needSaveLaunchTime);
                        }
                    }
                }
            }
            if (f.aPo != null && f.ayn != null) {
                com.kwad.sdk.core.e.c.d("AppStatusHelper", "unbindASService");
                com.kwad.sdk.collector.b.a.b((Context) f.aPo.get(), f.ayn);
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what == 101) {
                try {
                    c(message);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class d implements b {
        private b aPx = null;

        public d(b bVar) {
        }

        @Override // com.kwad.sdk.utils.f.b
        public final void u(List<com.kwad.sdk.collector.model.b> list) {
            JSONArray L = a.L(list);
            if (L != null) {
                f.aPp.c(L);
            }
            b bVar = this.aPx;
            if (bVar != null) {
                bVar.u(list);
            }
        }
    }

    private static List<com.kwad.sdk.collector.model.b> K(List<com.kwad.sdk.collector.model.b> list) {
        if (list.isEmpty()) {
            return list;
        }
        return new ArrayList(new LinkedHashSet(list));
    }

    private static boolean LA() {
        if (aPl == null) {
            try {
                aPl = new Messenger(new c(Looper.getMainLooper()));
            } catch (Throwable unused) {
            }
        }
        if (aPl != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void LB() {
        if (aPm == null) {
            synchronized (f.class) {
                try {
                    if (aPm == null) {
                        ExecutorService Gt = GlobalThreadPools.Gt();
                        aPm = Gt;
                        com.kwad.sdk.core.threads.c.a((ThreadPoolExecutor) Gt, "appStatusHelper");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static boolean LC() {
        try {
            Class<?> cls = Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote");
            Context context = ServiceProvider.getContext();
            if (context.getPackageManager().queryIntentServices(new Intent(context, cls), 65536).size() <= 0) {
                return false;
            }
            return true;
        } catch (ClassNotFoundException e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static AppStatusRules Lz() {
        return aPn;
    }

    public static void a(Context context, long j, com.kwad.sdk.collector.h hVar) {
        if (av.Nd() || com.kwad.sdk.core.config.d.ab(8192L) || context == null || com.kwad.sdk.utils.c.bS(context)) {
            return;
        }
        aPp = hVar;
        boolean isInMainProcess = SystemUtil.isInMainProcess(context);
        com.kwad.sdk.core.e.c.d("AppStatusHelper", "isMainProcess: " + isInMainProcess);
        if (isInMainProcess) {
            aPo = new WeakReference<>(context);
            if (YX == null) {
                YX = new Handler(Looper.getMainLooper());
            }
            YX.postDelayed(new AnonymousClass2(context), 30000L);
        }
    }

    public static /* synthetic */ boolean access$000() {
        return LA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static void b(Context context, AppStatusRules appStatusRules) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        String jSONObject = appStatusRules.toJson().toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        com.kwad.sdk.crash.utils.h.k(file.getAbsolutePath(), com.kwad.sdk.core.a.c.dR(jSONObject), false);
    }

    @WorkerThread
    public static void bU(Context context) {
        if (aPn == null) {
            aPn = bV(context);
        }
    }

    @Nullable
    @WorkerThread
    private static AppStatusRules bV(Context context) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        if (!file.exists()) {
            return null;
        }
        try {
            String I = com.kwad.sdk.crash.utils.h.I(file);
            if (TextUtils.isEmpty(I)) {
                return null;
            }
            if (com.kwad.sdk.core.a.c.dT(I)) {
                I = com.kwad.sdk.core.a.c.dS(I);
            }
            JSONObject jSONObject = new JSONObject(I);
            AppStatusRules appStatusRules = new AppStatusRules();
            appStatusRules.parseJson(jSONObject);
            return appStatusRules;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bW(Context context) {
        if (context == null) {
            return;
        }
        boolean LC = LC();
        com.kwad.sdk.core.e.c.d("AppStatusHelper", "isServiceAvailable: " + LC);
        if (LC) {
            com.kwad.sdk.collector.b.a.a(context, ayn);
        } else {
            a(context, new d(null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static List<com.kwad.sdk.collector.model.b> bX(Context context) {
        if (!bj.dw(context)) {
            return new ArrayList();
        }
        if (aPn == null) {
            aPn = bV(context);
        }
        return bY(context);
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.j)
    private static List<com.kwad.sdk.collector.model.b> bY(Context context) {
        ArrayList arrayList = new ArrayList();
        if (!av.Nd() && !com.kwad.sdk.core.config.d.ab(8192L)) {
            if (com.kwad.sdk.utils.c.bS(context)) {
                return arrayList;
            }
            AppStatusRules Lz = Lz();
            for (AppStatusRules.Strategy strategy : com.kwad.sdk.collector.i.c(Lz)) {
                arrayList.addAll(a(strategy));
                strategy.setNeedSaveLaunchTime(System.currentTimeMillis());
            }
            AppStatusRules.Strategy d2 = com.kwad.sdk.collector.i.d(Lz);
            arrayList.addAll(a(d2));
            d2.setNeedSaveLaunchTime(System.currentTimeMillis());
            return K(arrayList);
        }
        return arrayList;
    }

    public static void c(final Context context, final long j) {
        if (YX == null) {
            YX = new Handler(Looper.getMainLooper());
        }
        YX.post(new az() { // from class: com.kwad.sdk.utils.f.3
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                f.bW(context);
                f.YX.postDelayed(this, j);
            }
        });
    }

    /* loaded from: classes11.dex */
    public static class a implements com.kwad.sdk.core.b {
        private List<Long> aPv = new ArrayList();
        private String appName;
        private String packageName;

        private a(String str, String str2) {
            this.appName = str;
            this.packageName = str2;
        }

        @Nullable
        public static JSONArray L(List<com.kwad.sdk.collector.model.b> list) {
            List<a> list2;
            try {
                list2 = M(list);
            } catch (Exception e) {
                com.kwad.sdk.service.c.gatherException(e);
                list2 = null;
            }
            if (list2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<a> it = list2.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
            return jSONArray;
        }

        @Nullable
        private static List<a> M(List<com.kwad.sdk.collector.model.b> list) {
            a aVar;
            if (list != null && list.size() != 0) {
                HashMap hashMap = new HashMap();
                try {
                    for (com.kwad.sdk.collector.model.b bVar : list) {
                        String b = com.kwad.sdk.collector.model.c.b(bVar);
                        if (hashMap.containsKey(b)) {
                            aVar = (a) hashMap.get(b);
                        } else {
                            a aVar2 = new a(com.kwad.sdk.collector.model.c.a(bVar), com.kwad.sdk.collector.model.c.b(bVar));
                            hashMap.put(b, aVar2);
                            aVar = aVar2;
                        }
                        long c = com.kwad.sdk.collector.model.c.c(bVar) / 1000;
                        if (aVar != null) {
                            aVar.aL(c);
                        }
                    }
                    return new ArrayList(hashMap.values());
                } catch (ClassCastException e) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                }
            }
            return null;
        }

        private void aL(long j) {
            this.aPv.add(Long.valueOf(j));
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.appName = jSONObject.optString("appName");
            this.packageName = jSONObject.optString("packageName");
            JSONArray optJSONArray = jSONObject.optJSONArray("runningTimes");
            if (optJSONArray != null) {
                this.aPv.clear();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    try {
                        this.aPv.add(Long.valueOf(optJSONArray.getLong(i)));
                    } catch (JSONException e) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                    }
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "appName", this.appName);
            t.putValue(jSONObject, "packageName", this.packageName);
            JSONArray jSONArray = new JSONArray();
            Iterator<Long> it = this.aPv.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().longValue());
            }
            t.putValue(jSONObject, "runningTimes", jSONArray);
            return jSONObject;
        }

        public a() {
        }
    }

    public static void a(final Context context, final b bVar) {
        if (context == null || av.Nd() || com.kwad.sdk.core.config.d.ab(8192L) || com.kwad.sdk.utils.c.bS(context)) {
            return;
        }
        LB();
        aPm.submit(new Runnable() { // from class: com.kwad.sdk.utils.f.4
            @Override // java.lang.Runnable
            public final void run() {
                List bX;
                try {
                    HashSet hashSet = new HashSet();
                    if (bj.dw(context) && (bX = f.bX(context)) != null) {
                        Iterator it = bX.iterator();
                        while (it.hasNext()) {
                            com.kwad.sdk.core.e.c.d("AppStatusHelper", "AppRunningInfo: " + ((com.kwad.sdk.collector.model.b) it.next()));
                        }
                        hashSet.addAll(bX);
                        if (bVar != null) {
                            bVar.u(new ArrayList(hashSet));
                        }
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    com.kwad.sdk.service.c.gatherException(th);
                }
            }
        });
    }

    @NonNull
    private static List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy) {
        boolean isNeedLaunch = strategy.isNeedLaunch();
        com.kwad.sdk.core.e.c.d("AppStatusHelper", "analysisByFile, strategy: " + strategy.getName() + ", needLaunch: " + isNeedLaunch);
        if (!isNeedLaunch) {
            return new ArrayList();
        }
        return com.kwad.sdk.collector.b.Bd().a(strategy);
    }
}
