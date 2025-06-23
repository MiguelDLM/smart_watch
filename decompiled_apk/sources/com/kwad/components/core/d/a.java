package com.kwad.components.core.d;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kuaishou.aegon.Aegon;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.t;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.h;
import com.kwad.sdk.l;
import com.kwad.sdk.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.k;
import com.kwai.CpuMemoryProfiler;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a {
    private static boolean Kb;
    private static List<Throwable> Kd;
    private static Map<String, String> Ke;
    private static final AtomicBoolean Kc = new AtomicBoolean(false);
    private static final List<b> Kf = new CopyOnWriteArrayList();
    private static final List<c> Kg = new CopyOnWriteArrayList();

    /* renamed from: com.kwad.components.core.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0783a {
        public static String ah(Context context) {
            File file = new File(getDataDir(context), "kwad_ex");
            if (!file.exists()) {
                file.mkdir();
            }
            return file.getAbsolutePath();
        }

        private static File getDataDir(Context context) {
            int i = Build.VERSION.SDK_INT;
            File file = null;
            if (i >= 29) {
                return new File(context.getExternalFilesDir(null).getAbsolutePath());
            }
            if (i >= 24) {
                file = context.getDataDir();
            }
            if (file == null) {
                file = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
                if (!file.exists()) {
                    return new File("/data/data/" + context.getPackageName());
                }
            }
            return file;
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        String getKey();

        JSONObject getValue();
    }

    /* loaded from: classes11.dex */
    public interface c {
        void onCrashOccur(int i, String str);
    }

    public static void a(b bVar) {
        Kf.add(bVar);
    }

    private static com.kwad.sdk.crash.model.b ab(String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.kwad.sdk.crash.model.b();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.kwad.sdk.crash.model.b bVar = new com.kwad.sdk.crash.model.b();
            bVar.parseJson(jSONObject);
            return bVar;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.w("KsAdExceptionCollectorHelper", e);
            return new com.kwad.sdk.crash.model.b();
        }
    }

    private static String ac(String str) {
        try {
            int indexOf = str.indexOf(46, str.indexOf(46) + 1);
            if (indexOf > 0) {
                return str.substring(0, indexOf);
            }
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return null;
        }
    }

    private static void b(Throwable th) {
        if (Kd == null) {
            Kd = new CopyOnWriteArrayList();
        }
        Kd.add(th);
    }

    public static synchronized void initAsync(Context context) {
        synchronized (a.class) {
            if (context != null) {
                if (!Kc.get() && !Kb) {
                    Kb = true;
                    g.execute(new az() { // from class: com.kwad.components.core.d.a.1
                        @Override // com.kwad.sdk.utils.az
                        public final void doTask() {
                            if (!d.b(com.kwad.sdk.core.config.c.arC)) {
                                return;
                            }
                            com.kwad.sdk.core.e.c.d("KsAdExceptionCollectorHelper", "init");
                            com.kwad.sdk.crash.b.a(a.nv());
                            a.Kc.set(true);
                            a.nq();
                            a.nr();
                        }
                    });
                }
            }
        }
    }

    public static void j(String str, String str2) {
        if (!Kc.get()) {
            k(str, str2);
        } else {
            h.ah(str, str2);
        }
    }

    private static void k(String str, String str2) {
        if (Ke == null) {
            Ke = new ConcurrentHashMap();
        }
        if (!TextUtils.isEmpty(str)) {
            Ke.put(str, str2);
        }
    }

    private static boolean np() {
        return d.b(com.kwad.sdk.core.config.c.arD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nq() {
        if (Kd != null && np()) {
            Iterator<Throwable> it = Kd.iterator();
            while (it.hasNext()) {
                com.kwad.sdk.crash.b.n(it.next());
            }
            Kd.clear();
            Kd = null;
            ServiceProvider.f(new com.kwad.sdk.f.a<Throwable>() { // from class: com.kwad.components.core.d.a.2
                private static void c(Throwable th) {
                    com.kwad.sdk.crash.b.n(th);
                }

                @Override // com.kwad.sdk.f.a
                public final /* synthetic */ void accept(Throwable th) {
                    c(th);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr() {
        Map<String, String> map = Ke;
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                h.ah(entry.getKey(), entry.getValue());
            }
        }
        Ke.clear();
    }

    @NonNull
    private static com.kwad.sdk.crash.c ns() {
        String a2 = d.a(com.kwad.sdk.core.config.c.asV);
        com.kwad.sdk.core.e.c.d("KsAdExceptionCollectorHelper", "configStr:" + a2);
        com.kwad.sdk.crash.model.b ab = ab(a2);
        String str = ab.aHy;
        String str2 = ab.aHz;
        boolean a3 = com.kwad.sdk.crash.utils.g.a(ab);
        boolean b2 = com.kwad.sdk.crash.utils.g.b(ab);
        final Context context = ServiceProvider.getContext();
        String ah = C0783a.ah(context);
        c.a fj = new c.a().bI(context).bx(a3).by(b2).bz(l.zJ().yV()).fk(str).fj(str2);
        l.zJ();
        c.a fr = fj.fr(ExceptionMessage.getSdkCrashVersionName(l.getSDKVersion(), 1));
        l.zJ();
        return fr.dy(BuildConfig.VERSION_CODE).fs(ExceptionMessage.getSdkCrashVersionName(l.zJ().getApiVersion(), 1)).dz(l.zJ().getApiVersionCode()).dA(1).fq("com.kwad.sdk").ft(context.getPackageName()).fu(ServiceProvider.Lx().appId).fv(ServiceProvider.Lx().appName).fw(k.cd(context)).fx(ab.aHv).fn(aw.getDeviceId()).fo(ServiceProvider.Lx().appId).fm(ab.version).fy(ab.aHx).fz(ab.aHw).fl("Android").fp(ah).a(new com.kwad.sdk.crash.h() { // from class: com.kwad.components.core.d.a.4
            @Override // com.kwad.sdk.crash.h
            public final com.kwad.sdk.crash.model.message.a nB() {
                com.kwad.sdk.crash.model.message.a aVar = new com.kwad.sdk.crash.model.message.a();
                aVar.fD(t.FD());
                aVar.putString("mKsadAppId", ServiceProvider.Lx().appId);
                aVar.putString("mKsadAppName", ServiceProvider.Lx().appName);
                aVar.putString("mKsadAppPackageName", context.getPackageName());
                aVar.putString("mKsadAppVersion", k.cd(context));
                aVar.putString("mKsadSdkName", "com.kwad.sdk");
                l.zJ();
                aVar.putString("mKsadSdkVersion", ExceptionMessage.getSdkCrashVersionName(l.getSDKVersion(), 1));
                l.zJ();
                aVar.putInt("mKsadSdKVersionCode", BuildConfig.VERSION_CODE);
                aVar.putString("mKsadSdkApiVersion", ExceptionMessage.getSdkCrashVersionName(l.zJ().getApiVersion(), 1));
                aVar.putInt("mKsadSdKApiVersionCode", l.zJ().getApiVersionCode());
                aVar.putInt("mKsadSdkType", 1);
                aVar.putInt("mBuildNumber", 665);
                for (b bVar : a.Kf) {
                    String key = bVar.getKey();
                    JSONObject value = bVar.getValue();
                    if (key != null && value != null) {
                        aVar.a(bVar.getKey(), bVar.getValue());
                    }
                }
                return aVar;
            }
        }).a(new f() { // from class: com.kwad.components.core.d.a.3
            @Override // com.kwad.sdk.crash.f
            public final void a(int i, ExceptionMessage exceptionMessage) {
                n.aF(context);
                if (i == 1 || i == 3 || i == 4) {
                    com.kwad.sdk.core.e.c.d("KsAdExceptionCollectorHelper", "onOccurred crashType=" + i);
                }
                Iterator it = a.Kg.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).onCrashOccur(i, exceptionMessage.mCrashDetail);
                }
            }
        }).d(nt()).e(nu()).E(d.Cm()).m(d.a(com.kwad.sdk.core.config.c.atV)).Ie();
    }

    private static String[] nt() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(ac(KsAdSDKImpl.class.getName()));
            arrayList.add(ac(DownloadTask.class.getName()));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
        try {
            arrayList.add(ac(CpuMemoryProfiler.class.getName()));
            arrayList.add(ac(Aegon.class.getName()));
        } catch (Throwable unused) {
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String[] nu() {
        String[] strArr = new String[1];
        try {
            String name = com.kwad.sdk.crash.d.class.getName();
            strArr[0] = name.substring(0, name.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
        return strArr;
    }

    public static /* synthetic */ com.kwad.sdk.crash.c nv() {
        return ns();
    }

    public static void reportSdkCaughtException(Throwable th) {
        com.kwad.sdk.core.e.c.printStackTrace(th);
        if (!Kc.get()) {
            b(th);
        } else if (np()) {
            com.kwad.sdk.crash.b.n(th);
        }
    }

    public static void a(c cVar) {
        Kg.add(cVar);
    }
}
