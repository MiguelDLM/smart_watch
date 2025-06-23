package com.kwad.library.b.c;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes11.dex */
public class a {
    private static final String CLAZZ_NAME = "com.kwad.library.b.c.a";
    private static final ThreadLocal<C0834a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new ArrayList();
    private static final Map<String, WeakReference<Context>> sResContextCache = new HashMap();

    /* renamed from: com.kwad.library.b.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0834a {
        private int ajA;
        private StackTraceElement[] ajB;
        private int ajC;
        private long ajD;
        private WeakReference<Context> ajz;

        private C0834a() {
            this.ajz = new WeakReference<>(null);
            this.ajA = 0;
            this.ajB = null;
            this.ajC = 0;
        }

        public static /* synthetic */ int c(C0834a c0834a) {
            int i = c0834a.ajA;
            c0834a.ajA = i + 1;
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

        public static /* synthetic */ int g(C0834a c0834a) {
            int i = c0834a.ajC;
            c0834a.ajC = i + 1;
            return i;
        }

        public /* synthetic */ C0834a(byte b) {
            this();
        }
    }

    @Nullable
    private static Context a(String str, Context context) {
        WeakReference<Context> weakReference = sResContextCache.get(str + System.identityHashCode(context));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Context aB(Context context) {
        return ((b) context).getDelegatedContext();
    }

    private static boolean aC(Context context) {
        return context instanceof b;
    }

    private static boolean b(String str, Context context) {
        int i;
        ThreadLocal<C0834a> threadLocal = sAutoUnWrapModelTL;
        C0834a c0834a = threadLocal.get();
        byte b = 0;
        if (c0834a != null) {
            if (c0834a.ajz.get() != context || Math.abs(System.currentTimeMillis() - c0834a.ajD) >= 150) {
                c0834a.clear();
                c0834a.ajz = new WeakReference(context);
                c0834a.ajD = System.currentTimeMillis();
            } else {
                C0834a.c(c0834a);
                if (context instanceof Application) {
                    i = 15;
                } else {
                    i = 5;
                }
                if (c0834a.ajA >= i && a(str, context, c0834a)) {
                    c0834a.clear();
                    return true;
                }
            }
        } else {
            threadLocal.set(new C0834a(b));
        }
        return false;
    }

    private static com.kwad.library.b.a bG(String str) {
        return com.kwad.library.solder.a.a.j(null, str);
    }

    private static List<String> getAutoUnWrapStackList() {
        List<String> list = sAutoUnWrapStackList;
        if (list.isEmpty()) {
            list.add("com.sensorsdata.analytics.android.sdk");
        }
        return list;
    }

    public static int getThemeResId(Context context) {
        if (context instanceof ContextThemeWrapper) {
            Object callMethod = s.callMethod(context, "getThemeResId", new Object[0]);
            if (callMethod == null) {
                return 0;
            }
            return ((Integer) callMethod).intValue();
        }
        if (!(context instanceof androidx.appcompat.view.ContextThemeWrapper)) {
            return 0;
        }
        return ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId();
    }

    @NonNull
    public static Context i(Context context, String str) {
        Context eVar;
        if (context == null) {
            return null;
        }
        com.kwad.library.b.a bG = bG(str);
        if (bG != null && bG.isLoaded() && !(context instanceof b) && !b(str, context)) {
            Context a2 = a(str, context);
            if (a2 != null) {
                return a2;
            }
            if (context instanceof ContextThemeWrapper) {
                eVar = new c((ContextThemeWrapper) context, str);
            } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                eVar = new d((androidx.appcompat.view.ContextThemeWrapper) context, str);
            } else if (context instanceof ContextWrapper) {
                eVar = new e(context, str);
            } else {
                eVar = new e(context, str);
            }
            a(str, context, eVar);
            return eVar;
        }
        return context;
    }

    public static Context unwrapContextIfNeed(Context context) {
        if (aC(context)) {
            context = aB(context);
        }
        if (!aC(context)) {
            return context;
        }
        for (int i = 0; i < 10; i++) {
            context = aB(context);
            if (!aC(context)) {
                return context;
            }
        }
        return context;
    }

    public static Object wrapSystemService(Object obj, String str, Context context) {
        if ("layout_inflater".equals(str) && (obj instanceof LayoutInflater)) {
            LayoutInflater layoutInflater = (LayoutInflater) obj;
            if (layoutInflater.getContext() instanceof b) {
                return layoutInflater;
            }
            return layoutInflater.cloneInContext(context);
        }
        return obj;
    }

    private static void a(String str, Context context, Context context2) {
        sResContextCache.put(str + System.identityHashCode(context), new WeakReference<>(context2));
    }

    private static boolean a(String str, Context context, C0834a c0834a) {
        Context a2 = a(str, context);
        String name = a2 != null ? a2.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (!Arrays.equals(stackTrace, c0834a.ajB)) {
            if (c0834a.ajB != null) {
                c0834a.clear();
                return false;
            }
            c0834a.ajB = stackTrace;
            int i = 0;
            int i2 = 0;
            while (i < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                String className = stackTraceElement.getClassName();
                Iterator<String> it = getAutoUnWrapStackList().iterator();
                while (it.hasNext()) {
                    if (className.contains(it.next())) {
                        Log.d("PluginWrapper", "needAutoUnWrap true 命中白名单");
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
        C0834a.g(c0834a);
        c0834a.ajB = stackTrace;
        if (c0834a.ajC < 5) {
            return false;
        }
        Log.d("PluginWrapper", "needAutoUnWrap true 连续相同堆栈");
        return true;
    }

    public static LayoutInflater a(LayoutInflater layoutInflater, String str) {
        com.kwad.library.b.a bG = bG(str);
        if (bG == null || !bG.isLoaded()) {
            return layoutInflater;
        }
        Context context = layoutInflater.getContext();
        if (context instanceof b) {
            return layoutInflater;
        }
        Context i = i(context, str);
        return i instanceof b ? layoutInflater.cloneInContext(i) : layoutInflater;
    }

    public static Resources a(Resources resources, String str) {
        com.kwad.library.b.a bG = bG(str);
        if (bG != null && bG.isLoaded()) {
            Resources resources2 = bG.getResources();
            Objects.toString(resources2);
            return resources2 != null ? resources2 : resources;
        }
        Objects.toString(bG);
        return resources;
    }

    public static Resources.Theme a(Resources.Theme theme, Resources.Theme theme2, int i, String str) {
        Resources resources;
        com.kwad.library.b.a bG = bG(str);
        if (bG == null || !bG.isLoaded() || (resources = bG.getResources()) == null) {
            return theme;
        }
        if (theme2 != null) {
            return theme2;
        }
        Resources.Theme newTheme = resources.newTheme();
        newTheme.applyStyle(i, true);
        return newTheme;
    }

    public static ClassLoader a(ClassLoader classLoader, String str) {
        com.kwad.library.b.a.b xy;
        com.kwad.library.b.a bG = bG(str);
        return (bG == null || !bG.isLoaded() || (xy = bG.xy()) == null) ? classLoader : xy;
    }
}
