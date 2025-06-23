package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.openalliance.ad.uriaction.i;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class PM {
    public static final int CALL_START_BY_DEV = 1;
    private static final Map<Class<?>, String> r = new b();
    private final Context b;
    private String c;
    private File d;
    private volatile int e;
    private DexClassLoader f;
    private RandomAccessFile g;
    private FileLock h;
    private boolean i;
    private final f j;
    private volatile POFactory k;
    private int l;
    private Future<Boolean> m;
    private boolean o;
    private String p;
    private JSONObject q;

    /* renamed from: a, reason: collision with root package name */
    final ExecutorService f19445a = Executors.newSingleThreadExecutor();
    private boolean n = false;

    /* loaded from: classes11.dex */
    public class a implements Callable<Boolean> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            h.b(PM.this.b);
            PM.b(PM.this);
            if (!PM.this.i) {
                PM pm = PM.this;
                pm.i = pm.tryLockUpdate();
            }
            if (PM.d(PM.this)) {
                PM.e(PM.this);
            }
            PM.this.l = (int) (System.currentTimeMillis() - currentTimeMillis);
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes11.dex */
    public static class b extends HashMap<Class<?>, String> {
        public b() {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    }

    public PM(Context context, f fVar) {
        this.b = context.getApplicationContext();
        this.j = fVar;
        com.qq.e.comm.managers.plugin.b.a(context);
        d();
    }

    private boolean b() {
        if (!this.i) {
            return false;
        }
        try {
            Context context = this.b;
            com.qq.e.comm.managers.plugin.b.a(context, h.g(context), h.h(this.b));
            this.c = Sig.ASSET_PLUGIN_SIG;
            this.d = h.g(this.b);
            this.e = SDKStatus.getBuildInPluginVersion();
            return true;
        } catch (Throwable th) {
            GDTLogger.e("插件初始化失败 ");
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
            return false;
        }
    }

    private boolean c() {
        if (this.o) {
            return false;
        }
        if (this.i) {
            g gVar = new g(h.e(this.b), h.f(this.b));
            if (gVar.a(this.b, false)) {
                h.a(this.b);
                GDTLogger.d("NextExist,Updated=" + gVar.a(h.g(this.b), h.h(this.b), this.b));
            }
        }
        g gVar2 = new g(h.g(this.b), h.h(this.b));
        if (!gVar2.a(this.b, true)) {
            return false;
        }
        if (gVar2.b() >= SDKStatus.getBuildInPluginVersion()) {
            this.c = gVar2.a();
            this.e = gVar2.b();
            this.d = h.g(this.b);
            this.p = gVar2.c();
            this.n = true;
            return true;
        }
        GDTLogger.d("last updated plugin version =" + this.e + ";asset plugin version=" + SDKStatus.getBuildInPluginVersion());
        return false;
    }

    private void d() {
        this.n = false;
        this.m = this.f19445a.submit(new a());
    }

    public static void e(PM pm) {
        String absolutePath;
        pm.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append("PluginFile:\t");
        File file = pm.d;
        if (file == null) {
            absolutePath = "null";
        } else {
            absolutePath = file.getAbsolutePath();
        }
        sb.append(absolutePath);
        GDTLogger.d(sb.toString());
        if (pm.c != null && pm.d != null) {
            try {
                pm.f = new DexClassLoader(pm.d.getAbsolutePath(), h.c(pm.b).getAbsolutePath(), null, pm.getClass().getClassLoader());
                f fVar = pm.j;
                if (fVar != null) {
                    fVar.a();
                    return;
                }
                return;
            } catch (Throwable th) {
                GDTLogger.e("插件ClassLoader构造发生异常", th);
                f fVar2 = pm.j;
                if (fVar2 != null) {
                    fVar2.b();
                }
                com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
                return;
            }
        }
        pm.f = null;
    }

    public <T> T getFactory(Class<T> cls) throws e {
        ClassLoader classLoader;
        boolean z;
        Future<Boolean> future = this.m;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        GDTLogger.d("GetFactoryInstaceforInterface:" + cls);
        if (Sig.ASSET_PLUGIN_SIG == null) {
            classLoader = PM.class.getClassLoader();
        } else {
            classLoader = this.f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("PluginClassLoader is parent");
        if (PM.class.getClassLoader() == classLoader) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        GDTLogger.d(sb.toString());
        if (classLoader != null) {
            try {
                String str = r.get(cls);
                if (!TextUtils.isEmpty(str)) {
                    Class<?> loadClass = classLoader.loadClass(str);
                    T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", Context.class, JSONObject.class).invoke(loadClass, this.b, a()));
                    GDTLogger.d("ServiceDelegateFactory =" + cast);
                    return cast;
                }
                throw new e("factory  implemention name is not specified for interface:" + cls.getName());
            } catch (Throwable th) {
                throw new e("Fail to getfactory implement instance for interface:" + cls.getName(), th);
            }
        }
        throw new e("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
    }

    public POFactory getPOFactory() throws e {
        return getPOFactory(true, false);
    }

    public int getPluginVersion() {
        Future<Boolean> future = this.m;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return this.e;
    }

    public JSONObject getStartCaller(int i) {
        if (this.q == null) {
            this.q = new JSONObject();
        }
        try {
            this.q.put("scr", i);
        } catch (JSONException unused) {
        }
        return this.q;
    }

    public boolean tryLockUpdate() {
        try {
            File d = h.d(this.b);
            if (!d.exists()) {
                d.createNewFile();
                h.a("lock", d);
            }
            if (!d.exists()) {
                return false;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(d, "rw");
            this.g = randomAccessFile;
            FileLock tryLock = randomAccessFile.getChannel().tryLock();
            this.h = tryLock;
            if (tryLock == null) {
                return false;
            }
            this.g.writeByte(37);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void b(PM pm) {
        SharedPreferences sharedPreferences = pm.b.getSharedPreferences("start_crash", 0);
        if (sharedPreferences.getInt("crash_count", 0) >= 2) {
            pm.o = true;
            sharedPreferences.edit().remove("crash_count").commit();
            GDTLogger.e("加载本地插件");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
    
        if (r5.b() != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean d(com.qq.e.comm.managers.plugin.PM r5) {
        /*
            java.lang.String r0 = "TimeStap_AFTER_PLUGIN_INIT:"
            r5.getClass()
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b
            r2.<init>()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r3 = "TimeStap_BEFORE_PLUGIN_INIT:"
            r2.append(r3)     // Catch: java.lang.Throwable -> L2b
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L2b
            r2.append(r3)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L2b
            com.qq.e.comm.util.GDTLogger.d(r2)     // Catch: java.lang.Throwable -> L2b
            boolean r2 = r5.c()     // Catch: java.lang.Throwable -> L2b
            if (r2 != 0) goto L2d
            boolean r5 = r5.b()     // Catch: java.lang.Throwable -> L2b
            if (r5 == 0) goto L2e
            goto L2d
        L2b:
            r5 = move-exception
            goto L45
        L2d:
            r1 = 1
        L2e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
        L33:
            r5.append(r0)
            long r2 = java.lang.System.currentTimeMillis()
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            com.qq.e.comm.util.GDTLogger.d(r5)
            goto L57
        L45:
            java.lang.String r2 = "插件加载出现异常"
            com.qq.e.comm.util.GDTLogger.e(r2, r5)     // Catch: java.lang.Throwable -> L58
            java.lang.String r2 = r5.getMessage()     // Catch: java.lang.Throwable -> L58
            com.qq.e.comm.managers.plugin.a.a(r5, r2)     // Catch: java.lang.Throwable -> L58
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L33
        L57:
            return r1
        L58:
            r5 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            long r2 = java.lang.System.currentTimeMillis()
            r1.append(r2)
            java.lang.String r0 = r1.toString()
            com.qq.e.comm.util.GDTLogger.d(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.PM.d(com.qq.e.comm.managers.plugin.PM):boolean");
    }

    public POFactory getPOFactory(boolean z, boolean z2) throws e {
        if (this.k == null) {
            synchronized (this) {
                if (this.k == null) {
                    try {
                        this.k = (POFactory) getFactory(POFactory.class);
                    } catch (e e) {
                        if (!this.n) {
                            throw e;
                        }
                        GDTLogger.e("插件加载错误，回退到内置版本");
                        this.o = true;
                        this.n = false;
                        this.m = this.f19445a.submit(new a());
                        this.k = (POFactory) getFactory(POFactory.class);
                    }
                }
            }
        }
        if (z && this.k != null) {
            this.k.start(z2 ? getStartCaller(0) : getStartCaller(2));
        }
        return this.k;
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            int pluginVersion = getPluginVersion();
            if (pluginVersion > 10000) {
                jSONObject.put("vas", this.p);
            }
            jSONObject.put("pv", pluginVersion);
            jSONObject.put("sig", this.c);
            jSONObject.put(i.Code, com.qq.e.comm.managers.a.b().a());
            jSONObject.put("pn", com.qq.e.comm.managers.plugin.b.a(this.b));
            jSONObject.put("ict", this.l);
            jSONObject.put("mup", this.i);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
