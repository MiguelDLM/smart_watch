package com.kwad.sdk.api.loader;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.ResContext;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Keep
/* loaded from: classes11.dex */
public class Wrapper {
    private static final String CLAZZ_NAME = "com.kwad.sdk.api.loader.Wrapper";
    private static final int COUNT_LIMIT_AUTO_UN_WRAP = 5;
    private static final int COUNT_LIMIT_AUTO_UN_WRAP_APPLICATION = 15;
    private static final int COUNT_LIMIT_SAME_STACK_TRACE = 5;
    private static final String METHOD_GET_BASE_CONTEXT = "getBaseContext";
    private static final String METHOD_WRAP_CONTEXT = "wrapContextIfNeed";
    private static final String TAG = "Wrapper";
    private static final int TIMELINE_MINIWRAP = 150;
    private static final ThreadLocal<a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new CopyOnWriteArrayList();
    private static Map<Context, Context> sResContextCache = new WeakHashMap();

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

    private static List<String> getAutoUnWrapStackList() {
        List<String> list = sAutoUnWrapStackList;
        if (list.isEmpty()) {
            list.add("com.sensorsdata.analytics.android.sdk");
        }
        return list;
    }

    public static int getThemeResId(Context context) {
        if (context instanceof ContextThemeWrapper) {
            Object obj = ApiReflect.g(context).cj("getThemeResId").get();
            if (obj == null) {
                return 0;
            }
            return ((Integer) obj).intValue();
        }
        if (!(context instanceof androidx.appcompat.view.ContextThemeWrapper)) {
            return 0;
        }
        return ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId();
    }

    private static boolean needAutoUnWrap(Context context, a aVar) {
        String str;
        Context context2 = sResContextCache.get(context);
        if (context2 != null) {
            str = context2.getClass().getName();
        } else {
            str = "";
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (Arrays.equals(stackTrace, aVar.ajB)) {
            a.g(aVar);
            aVar.ajB = stackTrace;
            if (aVar.ajC < 5) {
                return false;
            }
            Log.d(TAG, "needAutoUnWrap true 连续相同堆栈");
            return true;
        }
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
            for (String str2 : getAutoUnWrapStackList()) {
                if (!TextUtils.isEmpty(str2) && className.contains(str2)) {
                    Log.d(TAG, "needAutoUnWrap true 命中白名单");
                    return true;
                }
            }
            String methodName = stackTraceElement.getMethodName();
            i++;
            if (i < stackTrace.length && CLAZZ_NAME.equals(className) && METHOD_WRAP_CONTEXT.equals(methodName)) {
                StackTraceElement stackTraceElement2 = stackTrace[i];
                if (TextUtils.equals(str, stackTraceElement2.getClassName()) && METHOD_GET_BASE_CONTEXT.equals(stackTraceElement2.getMethodName()) && (i2 = i2 + 1) >= 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void onDestroy(Context context) {
        if (context == null) {
            return;
        }
        sResContextCache.remove(context);
    }

    public static ClassLoader replaceExternalClassLoader(ClassLoader classLoader) {
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        if (externalClassLoader != null) {
            return externalClassLoader;
        }
        return classLoader;
    }

    public static Resources replaceExternalResources(Resources resources) {
        Resources externalResource = Loader.get().getExternalResource();
        if (externalResource != null) {
            return externalResource;
        }
        return resources;
    }

    public static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i) {
        Resources.Theme theme3 = (Resources.Theme) com.kwad.sdk.api.c.f("WRT", theme, theme2, Integer.valueOf(i));
        if (theme3 != null) {
            return theme3;
        }
        Resources externalResource = Loader.get().getExternalResource();
        if (externalResource != null) {
            if (theme2 == null) {
                Resources.Theme newTheme = externalResource.newTheme();
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
                if (aVar.ajA >= i && needAutoUnWrap(context, aVar)) {
                    aVar.clear();
                    return true;
                }
            }
        } else {
            threadLocal.set(new a(b));
        }
        return false;
    }

    @Keep
    @Deprecated
    public static Context unwrapContextIfNeed(Context context) {
        ResContext resContext;
        Context context2 = (Context) com.kwad.sdk.api.c.f("URC", context);
        if (context2 != null) {
            return context2;
        }
        if (context instanceof ResContext) {
            resContext = (ResContext) context;
        } else {
            resContext = null;
        }
        Context context3 = context;
        while (context3 instanceof ContextWrapper) {
            if (context3 instanceof Activity) {
                return context3;
            }
            if (context3 instanceof ResContext) {
                resContext = context3;
                context3 = resContext.getDelegatedContext();
            } else {
                context3 = ((ContextWrapper) context3).getBaseContext();
            }
        }
        if (resContext != null) {
            return resContext.getDelegatedContext();
        }
        return context;
    }

    @NonNull
    @Keep
    public static Context wrapContextIfNeed(@Nullable Context context) {
        Context context2 = (Context) com.kwad.sdk.api.c.f("WRC", context);
        if (context2 != null) {
            return context2;
        }
        if (!Loader.get().isExternalLoaded()) {
            return context;
        }
        if (context == null) {
            return null;
        }
        if (!(context instanceof ResContext) && !returnUnWrappedContext(context)) {
            if (context instanceof ContextThemeWrapper) {
                Context context3 = sResContextCache.get(context);
                if (context3 == null) {
                    o oVar = new o((ContextThemeWrapper) context);
                    sResContextCache.put(context, oVar);
                    return oVar;
                }
                return context3;
            }
            if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                Context context4 = sResContextCache.get(context);
                if (context4 == null) {
                    p pVar = new p((androidx.appcompat.view.ContextThemeWrapper) context);
                    sResContextCache.put(context, pVar);
                    return pVar;
                }
                return context4;
            }
            if (context instanceof ContextWrapper) {
                Context context5 = sResContextCache.get(context);
                if (context5 == null) {
                    q qVar = new q(context);
                    sResContextCache.put(context, qVar);
                    return qVar;
                }
                return context5;
            }
            Context context6 = sResContextCache.get(context);
            if (context6 == null) {
                q qVar2 = new q(context);
                sResContextCache.put(context, qVar2);
                return qVar2;
            }
            return context6;
        }
        return context;
    }

    @Keep
    @Deprecated
    public static LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater) {
        LayoutInflater layoutInflater2 = (LayoutInflater) com.kwad.sdk.api.c.f("WRI", layoutInflater);
        if (layoutInflater2 != null) {
            return layoutInflater2;
        }
        if (!Loader.get().isExternalLoaded()) {
            return layoutInflater;
        }
        Context context = layoutInflater.getContext();
        if (!(context instanceof ResContext)) {
            Context wrapContextIfNeed = wrapContextIfNeed(context);
            if (wrapContextIfNeed instanceof ResContext) {
                return layoutInflater.cloneInContext(wrapContextIfNeed);
            }
            return layoutInflater;
        }
        return layoutInflater;
    }

    public static Object wrapSystemService(Object obj, String str, Context context) {
        if ("layout_inflater".equals(str) && (obj instanceof LayoutInflater)) {
            LayoutInflater layoutInflater = (LayoutInflater) obj;
            if (layoutInflater.getContext() instanceof ResContext) {
                return layoutInflater;
            }
            return layoutInflater.cloneInContext(context);
        }
        return obj;
    }
}
