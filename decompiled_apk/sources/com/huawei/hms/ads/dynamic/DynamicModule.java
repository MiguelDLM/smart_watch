package com.huawei.hms.ads.dynamic;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.huawei.hms.ads.analysis.DynamicLoaderAnalysis;
import com.huawei.hms.ads.common.inter.LoaderCommonInter;
import com.huawei.hms.ads.common.inter.LoaderSpHandlerInter;
import com.huawei.hms.ads.dynamic.IDynamicLoader;
import com.huawei.hms.ads.uiengineloader.aa;
import com.huawei.hms.ads.uiengineloader.af;
import com.huawei.hms.ads.uiengineloader.d;
import com.huawei.hms.ads.uiengineloader.g;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes10.dex */
public class DynamicModule {
    public static final int MODULE_INTER_ERROR = 3;
    public static final int MODULE_NORMAL = 0;

    /* renamed from: a, reason: collision with root package name */
    protected static LoaderSpHandlerInter f17261a = null;
    protected static LoaderCommonInter b = null;
    private static final String c = "DynamicModule";
    private static final int d = 256;
    private static final int e = -100;
    private static final ThreadLocal<HashMap<String, Boolean>> f = new ThreadLocal<>();
    private static final ThreadLocal<HashMap<String, String>> g = new ThreadLocal<>();
    private static final ThreadLocal<HashMap<String, IDynamicLoader>> h = new ThreadLocal<>();
    private Context i;

    /* loaded from: classes10.dex */
    public static class DynamicLoaderClassLoader {

        /* renamed from: a, reason: collision with root package name */
        private static HashMap<String, ClassLoader> f17265a = new HashMap<>();

        public static ClassLoader getsClassLoader(String str) {
            return f17265a.get(str);
        }

        public static void setsClassLoader(String str, ClassLoader classLoader) {
            f17265a.put(str, classLoader);
        }
    }

    /* loaded from: classes10.dex */
    public static class LoadingException extends Exception {

        /* renamed from: a, reason: collision with root package name */
        private Bundle f17266a;

        public LoadingException(String str) {
            super(str);
        }

        public Bundle getBundle() {
            return this.f17266a;
        }

        public LoadingException(String str, Bundle bundle) {
            super(str);
            this.f17266a = bundle;
        }
    }

    /* loaded from: classes10.dex */
    public static class a extends Exception {
        private a(String str) {
            super(str);
        }

        public /* synthetic */ a(String str, byte b) {
            this(str);
        }
    }

    private DynamicModule(Context context) {
        this.i = context;
    }

    private static Context a(Context context, String str, Bundle bundle, IDynamicLoader iDynamicLoader) throws LoadingException {
        try {
            IObjectWrapper load = iDynamicLoader.load(ObjectWrapper.wrap(context), str, bundle.getInt("module_version"), ObjectWrapper.wrap(bundle));
            Object unwrap = ObjectWrapper.unwrap(load);
            if (unwrap == null) {
                af.c(c, "Get remote context is null, module:".concat(String.valueOf(str)));
                return null;
            }
            if (unwrap instanceof Context) {
                af.b(c, "Get context for module:" + str + " success.");
                return (Context) unwrap;
            }
            if (!unwrap.getClass().getName().equals(LoadingException.class.getName())) {
                af.c(c, "Get remote context is null, module:".concat(String.valueOf(str)));
                return null;
            }
            Bundle bundle2 = (Bundle) ObjectWrapper.unwrap(load).getClass().getDeclaredMethod("getBundle", null).invoke(ObjectWrapper.unwrap(load), null);
            af.c(c, "Successfully get the bundle in exception.");
            throw new LoadingException("Failed to load, please check the bundle in exception.", bundle2);
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception e3) {
            af.c(c, "Failed to get module context for:" + str + " " + e3.getClass().getSimpleName());
            return null;
        }
    }

    private static Bundle b(Context context, String str) throws LoadingException, a {
        try {
            Bundle queryHMSModuleBundle = queryHMSModuleBundle(context, str);
            String string = queryHMSModuleBundle.getString("loader_path");
            if (!TextUtils.isEmpty(string) && new File(string).exists()) {
                g.set(new HashMap<String, String>(str, string) { // from class: com.huawei.hms.ads.dynamic.DynamicModule.2

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ String f17263a;
                    final /* synthetic */ String b;

                    {
                        this.f17263a = str;
                        this.b = string;
                        put(str, string);
                    }
                });
                af.b(c, "Query remote version by module name:" + str + " success.");
                return queryHMSModuleBundle;
            }
            af.c(c, "The loaderPath in query bundle is not available,change the module version to:-100");
            queryHMSModuleBundle.putInt("module_version", -100);
            return queryHMSModuleBundle;
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception unused) {
            throw new a("failed to Query remote version.", (byte) 0);
        }
    }

    public static LoaderCommonInter getCommonInter() {
        return b;
    }

    public static Bundle getLocalModuleInfo(Context context, String str) {
        int localVersion = getLocalVersion(context, str);
        Bundle bundle = new Bundle();
        bundle.putString("module_name", str);
        bundle.putInt(com.huawei.hms.ads.dynamic.a.h, localVersion);
        return bundle;
    }

    public static int getLocalVersion(Context context, String str) {
        String str2;
        if (context == null || str.length() == 0 || str.length() > 256) {
            af.d(c, "Invalid context or moduleName.");
            return 0;
        }
        try {
            String str3 = "com.huawei.hms.ads.dynamic.descriptors." + str + ".ModuleDescriptor";
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            return context.getClassLoader().loadClass(str3).getDeclaredField("MODULE_VERSION").getInt(null);
        } catch (ClassNotFoundException unused) {
            str2 = "Cannot find the class of module descriptor for ".concat(str);
            af.c(c, str2);
            return 0;
        } catch (Exception e2) {
            str2 = "Get local module info failed." + e2.getClass().getSimpleName();
            af.c(c, str2);
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.os.Bundle getRemoteModuleInfo(android.content.Context r4, java.lang.String r5) throws com.huawei.hms.ads.dynamic.DynamicModule.LoadingException {
        /*
            java.lang.Class<com.huawei.hms.ads.dynamic.DynamicModule> r0 = com.huawei.hms.ads.dynamic.DynamicModule.class
            monitor-enter(r0)     // Catch: java.lang.Exception -> L52 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> L54
            java.lang.ThreadLocal<java.util.HashMap<java.lang.String, java.lang.Boolean>> r1 = com.huawei.hms.ads.dynamic.DynamicModule.f     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r2 = r1.get()     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto L2c
            java.lang.Object r2 = r1.get()     // Catch: java.lang.Throwable -> L2a
            java.util.HashMap r2 = (java.util.HashMap) r2     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r2 = r2.get(r5)     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto L2c
            java.lang.Object r2 = r1.get()     // Catch: java.lang.Throwable -> L2a
            java.util.HashMap r2 = (java.util.HashMap) r2     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r2 = r2.get(r5)     // Catch: java.lang.Throwable -> L2a
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L2a
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L2a
            if (r2 != 0) goto L3a
            goto L2c
        L2a:
            r4 = move-exception
            goto L70
        L2c:
            android.os.Bundle r2 = a(r4, r5)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r3 = "module_version"
            int r3 = r2.getInt(r3)     // Catch: java.lang.Throwable -> L2a
            if (r3 <= 0) goto L3a
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            return r2
        L3a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r0 = r1.get()     // Catch: java.lang.Exception -> L52 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> L54
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch: java.lang.Exception -> L52 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> L54
            java.lang.Object r0 = r0.get(r5)     // Catch: java.lang.Exception -> L52 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> L54
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Exception -> L52 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> L54
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Exception -> L52 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> L54
            if (r0 == 0) goto L95
            android.os.Bundle r4 = b(r4, r5)     // Catch: java.lang.Exception -> L52 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> L54 com.huawei.hms.ads.dynamic.DynamicModule.a -> L56
            return r4
        L52:
            r4 = move-exception
            goto L72
        L54:
            r4 = move-exception
            goto L9b
        L56:
            java.lang.String r4 = "DynamicModule"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L52 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> L54
            java.lang.String r1 = "Query remote module info in HMS failed."
            r0.<init>(r1)     // Catch: java.lang.Exception -> L52 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> L54
            java.lang.Class<com.huawei.hms.ads.dynamic.DynamicModule$a> r1 = com.huawei.hms.ads.dynamic.DynamicModule.a.class
            java.lang.String r1 = r1.getSimpleName()     // Catch: java.lang.Exception -> L52 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> L54
            r0.append(r1)     // Catch: java.lang.Exception -> L52 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> L54
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L52 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> L54
            com.huawei.hms.ads.uiengineloader.af.c(r4, r0)     // Catch: java.lang.Exception -> L52 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> L54
            goto L95
        L70:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            throw r4     // Catch: java.lang.Exception -> L52 com.huawei.hms.ads.dynamic.DynamicModule.LoadingException -> L54
        L72:
            java.lang.String r0 = "DynamicModule"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Get remote module info for "
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r5 = " failed."
            r1.append(r5)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getSimpleName()
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            com.huawei.hms.ads.uiengineloader.af.c(r0, r4)
        L95:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            return r4
        L9b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.dynamic.DynamicModule.getRemoteModuleInfo(android.content.Context, java.lang.String):android.os.Bundle");
    }

    public static int getRemoteVersion(Context context, String str) throws LoadingException {
        try {
            Bundle b2 = b(context, str);
            if (b2 != null && !b2.isEmpty()) {
                return b2.getInt("module_version");
            }
            af.c(c, "Query remote module:" + str + " info failed.");
            throw new LoadingException("Query remote module info failed: null or empty.");
        } catch (a unused) {
            af.c(c, "Query remote module:" + str + " exception:" + a.class.getSimpleName());
            return 0;
        }
    }

    public static LoaderSpHandlerInter getSpHandler() {
        return f17261a;
    }

    public static DynamicModule load(Context context, Integer num, String str, String str2) throws LoadingException {
        if (context == null || num == null || TextUtils.isEmpty(str) || str.length() > 256) {
            DynamicLoaderAnalysis.getInstance().onLoaderException(str, 1, "Null param, please check it.");
            throw new LoadingException("Null param, please check it.");
        }
        Bundle bundle = new Bundle();
        bundle.putString(com.huawei.hms.ads.dynamic.a.n, str2);
        return a(context, num, str, bundle);
    }

    public static Bundle queryHMSModuleBundle(Context context, String str) throws LoadingException, a {
        byte b2 = 0;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                throw new a("Query remote version failed: null contentResolver.", b2);
            }
            Bundle call = contentResolver.call(Uri.parse(com.huawei.hms.ads.dynamic.a.f17272a), str, (String) null, (Bundle) null);
            if (call == null) {
                af.c(c, "Failed to get bundle info:null.");
                throw new a("Query remote version failed: null bundle info.", b2);
            }
            int i = call.getInt("errcode");
            call.getString("loader_path");
            af.b(c, "bundle info: errorCode:" + i + ", moduleVersion:" + call.getInt("module_version") + ", loader_version:" + call.getInt("loader_version") + ", armeabiType:" + call.getInt("armeabiType"));
            if (i == 0) {
                return call;
            }
            af.c(c, "Failed to get " + str + " bundle info, errcode:" + i);
            throw new LoadingException("Query " + str + " unavailable, errorCode:" + i, call);
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception unused) {
            throw new a("failed to get :" + str + " info.", b2);
        }
    }

    public static void setCommonInter(LoaderCommonInter loaderCommonInter) {
        b = loaderCommonInter;
    }

    public static void setSpHandler(LoaderSpHandlerInter loaderSpHandlerInter) {
        f17261a = loaderSpHandlerInter;
    }

    public final Context getModuleContext() {
        return this.i;
    }

    private static Bundle a(Context context, String str) throws LoadingException {
        Method declaredMethod;
        ClassLoader classLoader;
        boolean z = true;
        try {
            try {
                Class<?> a2 = a(context);
                Method declaredMethod2 = a2.getDeclaredMethod("getsClassLoader", String.class);
                declaredMethod = a2.getDeclaredMethod("setsClassLoader", String.class, ClassLoader.class);
                classLoader = (ClassLoader) declaredMethod2.invoke(null, str);
            } catch (Exception e2) {
                af.c(c, "failed to load." + e2.getClass().getSimpleName());
            }
            if (classLoader == null) {
                try {
                    af.b(c, "No available cached loader, query remote.");
                    Bundle b2 = b(context, str);
                    synchronized (DynamicModule.class) {
                        try {
                            HashMap<String, String> hashMap = g.get();
                            Objects.requireNonNull(hashMap);
                            String str2 = hashMap.get(str);
                            if (TextUtils.isEmpty(str2)) {
                                return b2;
                            }
                            g gVar = new g(str2, ClassLoader.getSystemClassLoader());
                            a(str, gVar);
                            declaredMethod.invoke(null, str, gVar);
                            f.set(new HashMap<String, Boolean>(str) { // from class: com.huawei.hms.ads.dynamic.DynamicModule.1

                                /* renamed from: a, reason: collision with root package name */
                                final /* synthetic */ String f17262a;

                                {
                                    this.f17262a = str;
                                    put(str, Boolean.TRUE);
                                }
                            });
                            return b2;
                        } finally {
                        }
                    }
                } catch (a unused) {
                }
            } else if (classLoader != ClassLoader.getSystemClassLoader()) {
                af.b(c, "Cached loader is available, ready to use it.");
                try {
                    a(str, classLoader);
                } catch (LoadingException e3) {
                    af.c(c, "Get loader interface failed." + e3.getClass().getSimpleName());
                }
                HashMap<String, Boolean> hashMap2 = new HashMap<>();
                hashMap2.put(str, Boolean.valueOf(z));
                f.set(hashMap2);
                return new Bundle();
            }
            z = false;
            HashMap<String, Boolean> hashMap22 = new HashMap<>();
            hashMap22.put(str, Boolean.valueOf(z));
            f.set(hashMap22);
            return new Bundle();
        } catch (LoadingException e4) {
            throw e4;
        }
    }

    private static DynamicModule a(Context context, Integer num, String str, Bundle bundle) throws LoadingException {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (!aa.a(context)) {
                DynamicLoaderAnalysis.getInstance().onLoaderException(str, 2, "HMS not installed.");
                throw new LoadingException("HMS not installed.");
            }
            if (!d.a()) {
                String a2 = d.a(com.huawei.hms.ads.dynamic.a.s);
                if (TextUtils.isEmpty(a2) || !a2.startsWith(com.huawei.hms.ads.dynamic.a.t)) {
                    DynamicLoaderAnalysis.getInstance().onLoaderException(str, 3, "Do not allow loading on other devices.");
                    throw new LoadingException("Do not allow loading on other devices.");
                }
            }
            af.b(c, "Load start in new-version-policy.");
            DynamicModule a3 = a(context, str, num, bundle);
            DynamicLoaderAnalysis.getInstance().onLoaderSuccess(str, System.currentTimeMillis() - currentTimeMillis);
            return a3;
        } catch (LoadingException e2) {
            DynamicLoaderAnalysis.getInstance().onLoaderException(str, 4, e2.getMessage());
            throw e2;
        } catch (Exception e3) {
            af.d(c, "Other exception:" + e3.getClass().getSimpleName());
            DynamicLoaderAnalysis.getInstance().onLoaderException(str, 4, "Other exception, " + e3.getClass().getSimpleName());
            throw new LoadingException("Load failed.");
        }
    }

    private static DynamicModule a(Context context, String str, Bundle bundle) throws LoadingException {
        com.huawei.hms.ads.dynamicloader.g gVar = new com.huawei.hms.ads.dynamicloader.g();
        af.b(c, "new DynamicLoader.");
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        Context a2 = a(context, str, bundle, gVar);
        if (a2 != null) {
            return new DynamicModule(a2);
        }
        throw new LoadingException("New version policy: Failed to get module context: null.");
    }

    private static DynamicModule a(Context context, String str, Integer num, Bundle bundle) throws LoadingException {
        int intValue = num.intValue();
        bundle.putString("module_name", str);
        bundle.putInt(com.huawei.hms.ads.dynamic.a.m, intValue);
        try {
            com.huawei.hms.ads.dynamicloader.g gVar = new com.huawei.hms.ads.dynamicloader.g();
            af.b(c, "new DynamicLoader.");
            Context a2 = a(context.getApplicationContext() == null ? context : context.getApplicationContext(), str, bundle, gVar);
            if (a2 != null) {
                return new DynamicModule(a2);
            }
            throw new LoadingException("New version policy: Failed to get module context: null.");
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception e3) {
            af.d(c, "Other exception," + e3.getClass().getSimpleName());
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            return new DynamicModule(context);
        }
    }

    private static Class<?> a(Context context) throws LoadingException {
        Class<?> cls;
        try {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            cls = context.getClassLoader().loadClass(DynamicLoaderClassLoader.class.getName());
        } catch (ClassNotFoundException unused) {
            af.c(c, "ClassLoader class not found when use client context.");
            cls = null;
        }
        if (cls == null) {
            try {
                ClassLoader classLoader = DynamicModule.class.getClassLoader();
                Objects.requireNonNull(classLoader);
                cls = classLoader.loadClass(DynamicLoaderClassLoader.class.getName());
                if (cls == null) {
                    throw new LoadingException("ClassLoader class is null.");
                }
            } catch (ClassNotFoundException unused2) {
                throw new LoadingException("ClassLoader class not found when use DynamicModule's classLoader.");
            }
        }
        return cls;
    }

    private static void a(String str, ClassLoader classLoader) throws LoadingException {
        try {
            h.set(new HashMap<String, IDynamicLoader>(str, (IBinder) classLoader.loadClass(com.huawei.hms.ads.dynamic.a.b).getConstructor(null).newInstance(null)) { // from class: com.huawei.hms.ads.dynamic.DynamicModule.3

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ String f17264a;
                final /* synthetic */ IBinder b;

                {
                    this.f17264a = str;
                    this.b = r2;
                    put(str, IDynamicLoader.Stub.asInterface(r2));
                }
            });
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to get loader interface:" + e2.getMessage());
        }
    }

    private static boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 256;
    }
}
