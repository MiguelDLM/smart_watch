package com.kwad.sdk.n;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes11.dex */
public class i {
    private static final String CLAZZ_NAME = "com.kwad.sdk.n.i";
    private static final ThreadLocal<a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new CopyOnWriteArrayList();
    private static final Map<Context, Context> sResContextCache = new WeakHashMap();
    private static final AtomicBoolean aUu = new AtomicBoolean(false);

    /* loaded from: classes11.dex */
    public static class a {
        private int ajA;
        private StackTraceElement[] ajB;
        private int ajC;
        private long ajD;
        private WeakReference<Context> ajz;

        private a() {
            this.ajz = new WeakReference<>(null);
            this.ajA = 0;
            this.ajB = null;
            this.ajC = 0;
        }

        public static /* synthetic */ int c(a aVar) {
            int i = aVar.ajA;
            aVar.ajA = i + 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.ajz = new WeakReference<>(null);
            this.ajA = 0;
            this.ajB = null;
            this.ajC = 0;
            this.ajD = 0L;
        }

        public static /* synthetic */ int g(a aVar) {
            int i = aVar.ajC;
            aVar.ajC = i + 1;
            return i;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static boolean OK() {
        return aUu.get();
    }

    private static void a(final Context context, Context context2) {
        sResContextCache.put(context, context2);
        if (context instanceof Activity) {
            com.kwad.sdk.core.c.b.En();
            com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.n.i.1
                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                /* renamed from: onActivityDestroyed */
                public final void b(@NonNull Activity activity) {
                    if (activity == context) {
                        com.kwad.sdk.core.c.b.En();
                        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                        i.onDestroy(context);
                    }
                }
            });
        }
    }

    public static void cj(boolean z) {
        aUu.set(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v3 */
    public static Context dy(Context context) {
        boolean z = context instanceof com.kwad.sdk.n.a;
        Context context2 = context;
        if (z) {
            context2 = ((com.kwad.sdk.n.a) context).getDelegatedContext();
        }
        if (l.dG(context2)) {
            return context2;
        }
        RuntimeException runtimeException = null;
        int i = 0;
        Context context3 = context2;
        while (i < 10) {
            if (runtimeException == null) {
                RuntimeException runtimeException2 = new RuntimeException("expect normalContext --context:" + context3.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yY());
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(runtimeException2);
                runtimeException = runtimeException2;
            }
            boolean aC = j.aC(context3);
            ?? r5 = context3;
            if (aC) {
                r5 = j.aB(context3);
            }
            boolean z2 = r5 instanceof com.kwad.sdk.n.a;
            Context context4 = r5;
            if (z2) {
                context4 = ((com.kwad.sdk.n.a) r5).getDelegatedContext();
            }
            if (l.dG(context4)) {
                return context4;
            }
            i++;
            context3 = context4;
        }
        return context3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5 */
    public static Context dz(Context context) {
        if (context instanceof Application) {
            return context;
        }
        Context applicationContext = dy(context).getApplicationContext();
        if (applicationContext instanceof Application) {
            return applicationContext;
        }
        int i = 0;
        Context context2 = applicationContext;
        while (i < 10) {
            Context applicationContext2 = context2.getApplicationContext();
            if (applicationContext2 instanceof Application) {
                return applicationContext2;
            }
            if (applicationContext2 instanceof com.kwad.sdk.n.a) {
                applicationContext2 = ((com.kwad.sdk.n.a) applicationContext2).getDelegatedContext();
            }
            i++;
            context2 = applicationContext2;
        }
        return context2;
    }

    private static List<String> getAutoUnWrapStackList() {
        List<String> list = sAutoUnWrapStackList;
        if (list.isEmpty()) {
            list.add("com.sensorsdata.analytics.android.sdk");
        }
        return list;
    }

    public static void onDestroy(Context context) {
        sResContextCache.remove(context);
    }

    public static ClassLoader replaceExternalClassLoader(ClassLoader classLoader) {
        ClassLoader classLoader2 = e.OH().getClassLoader();
        if (classLoader2 != null) {
            return classLoader2;
        }
        return classLoader;
    }

    public static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i) {
        Resources resources = e.OH().getResources();
        if (resources != null) {
            if (theme2 == null) {
                Resources.Theme newTheme = resources.newTheme();
                newTheme.applyStyle(i, true);
                return newTheme;
            }
            return theme2;
        }
        return theme;
    }

    private static boolean returnUnWrappedContext(Context context) {
        int i;
        ThreadLocal<a> threadLocal = sAutoUnWrapModelTL;
        a aVar = threadLocal.get();
        byte b = 0;
        if (aVar != null) {
            if (aVar.ajz.get() != context || Math.abs(System.currentTimeMillis() - aVar.ajD) >= 150) {
                aVar.clear();
                aVar.ajz = new WeakReference(context);
                aVar.ajD = System.currentTimeMillis();
            } else {
                a.c(aVar);
                if (context instanceof Application) {
                    i = 15;
                } else {
                    i = 5;
                }
                if (aVar.ajA >= i && a(context, aVar)) {
                    aVar.clear();
                    return true;
                }
            }
        } else {
            threadLocal.set(new a(b));
        }
        return false;
    }

    public static Context wrapContextIfNeed(Context context) {
        Context context2;
        if (context == null) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("KSWrapper wrapContextIfNeed context is null"));
            return null;
        }
        if (!((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yV()) {
            return context;
        }
        if (context instanceof com.kwad.sdk.n.a) {
            return context;
        }
        if (j.aC(context)) {
            context = j.unwrapContextIfNeed(context);
            if (j.aC(context)) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("KSWrapper unwrapContextIfNeed fail"));
                return context;
            }
        }
        Context context3 = sResContextCache.get(context);
        if (context3 instanceof com.kwad.sdk.n.a) {
            return context3;
        }
        if (k.dA(context)) {
            return context;
        }
        if (returnUnWrappedContext(context)) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("KSWrapper returnUnWrappedContext context: " + context.getClass().getName()));
            return context;
        }
        if (context instanceof Application) {
            try {
                f fVar = new f((Application) context, new g(context, e.OH()));
                l.a(fVar);
                context2 = fVar;
            } catch (Throwable unused) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("wrapper Application fail --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yY()));
                return context;
            }
        } else if (context instanceof ContextThemeWrapper) {
            context2 = new b((ContextThemeWrapper) context);
        } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            context2 = new c((androidx.appcompat.view.ContextThemeWrapper) context);
        } else if (context instanceof ContextWrapper) {
            context2 = new d(context);
        } else {
            context2 = new d(context);
        }
        a(context, context2);
        return context2;
    }

    private static boolean a(Context context, a aVar) {
        Context context2 = sResContextCache.get(context);
        String name = context2 != null ? context2.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (!Arrays.equals(stackTrace, aVar.ajB)) {
            if (aVar.ajB != null) {
                aVar.clear();
                return false;
            }
            aVar.ajB = stackTrace;
            int i = 0;
            int i2 = 0;
            while (i < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                String className = stackTraceElement.getClassName();
                for (String str : getAutoUnWrapStackList()) {
                    if (!TextUtils.isEmpty(str) && className.contains(str)) {
                        Log.d("Wrapper", "needAutoUnWrap true 命中白名单");
                        return true;
                    }
                }
                String methodName = stackTraceElement.getMethodName();
                i++;
                if (i < stackTrace.length && CLAZZ_NAME.equals(className) && "wrapContextIfNeed".equals(methodName)) {
                    StackTraceElement stackTraceElement2 = stackTrace[i];
                    if (TextUtils.equals(name, stackTraceElement2.getClassName()) && "getBaseContext".equals(stackTraceElement2.getMethodName()) && (i2 = i2 + 1) >= 5) {
                        return true;
                    }
                }
            }
            return false;
        }
        a.g(aVar);
        aVar.ajB = stackTrace;
        if (aVar.ajC < 5) {
            return false;
        }
        Log.d("Wrapper", "needAutoUnWrap true 连续相同堆栈");
        return true;
    }
}
