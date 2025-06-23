package com.kwad.sdk.api.loader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.proxy.IComponentProxy;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes11.dex */
public class Loader {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;
    private final AtomicBoolean Kc;
    private IKsAdSDK aoa;
    private l aob;

    /* loaded from: classes11.dex */
    public static class a {
        private static final Loader aoc = new Loader(0);
    }

    public /* synthetic */ Loader(byte b) {
        this();
    }

    private static void AQ() {
        try {
            int AF = com.kwad.sdk.api.c.AF();
            if (AF > 0) {
                try {
                    e.aL(mContext).setDefaultUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
                    Thread.setDefaultUncaughtExceptionHandler(e.aL(mContext));
                    e.aL(mContext).bW(AF);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @NonNull
    @MainThread
    public static synchronized IKsAdSDK a(ClassLoader classLoader) {
        IKsAdSDK iKsAdSDK;
        synchronized (Loader.class) {
            try {
                Object invoke = Class.forName(((KsAdSdkDynamicApi) IKsAdSDK.class.getAnnotation(KsAdSdkDynamicApi.class)).value(), true, classLoader).getDeclaredMethod("get", null).invoke(null, null);
                if (invoke != null) {
                    iKsAdSDK = (IKsAdSDK) invoke;
                } else {
                    throw new RuntimeException("Can not get sdk form " + classLoader);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return iKsAdSDK;
    }

    private boolean aQ(Context context) {
        try {
            String aM = h.aM(context);
            String aN = h.aN(context);
            if (TextUtils.isEmpty(aM) && TextUtils.isEmpty(aN)) {
                return false;
            }
            if (!TextUtils.isEmpty(aN) && h.K(aN, aM)) {
                h.o(context, aN);
                y(context, aM);
                h.p(context, "");
                aM = aN;
            }
            if (TextUtils.isEmpty(aM)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            com.kwad.sdk.api.c.m(th);
            return false;
        }
    }

    private static void aR(Context context) {
        try {
            String aO = h.aO(context);
            boolean b = b.b(context, h.anF, false);
            if (!TextUtils.isEmpty(aO) && aO.equals(BuildConfig.VERSION_NAME) && !b) {
                return;
            }
            String aM = h.aM(context);
            h.o(context, "");
            h.p(context, "");
            b.a(context, h.anF, false);
            i.j(i.t(context, aM));
            h.q(context, BuildConfig.VERSION_NAME);
        } catch (Throwable th) {
            com.kwad.sdk.api.c.m(th);
        }
    }

    public static void checkInitSDK(Context context) {
        if (!KsAdSDK.sHasInit.get()) {
            if (context == null) {
                context = KSLifecycleObserver.getInstance().getApplication();
            }
            KsAdSDK.init(context, SdkConfig.create(b.getString(context, "sdkconfig")));
        }
    }

    public static Loader get() {
        return a.aoc;
    }

    private static void y(Context context, String str) {
        i.x(context, str);
    }

    public Context getContext() {
        return mContext;
    }

    @MainThread
    public ClassLoader getExternalClassLoader() {
        l lVar = this.aob;
        if (lVar != null) {
            return lVar.getClassLoader();
        }
        return null;
    }

    @MainThread
    public Resources getExternalResource() {
        l lVar = this.aob;
        if (lVar != null) {
            return lVar.AN();
        }
        return null;
    }

    public ClassLoader getRealClassLoader() {
        l lVar = this.aob;
        if (lVar != null) {
            return lVar.getClassLoader();
        }
        return getClass().getClassLoader();
    }

    public IKsAdSDK init(@NonNull Context context, ClassLoader classLoader) {
        if (this.Kc.get()) {
            return this.aoa;
        }
        mContext = context.getApplicationContext();
        aR(context);
        if (aQ(context)) {
            this.aob = l.a(context, classLoader, h.aM(context));
        }
        l lVar = this.aob;
        if (lVar == null) {
            IKsAdSDK a2 = a(getClass().getClassLoader());
            this.aoa = a2;
            a2.setIsExternal(false);
        } else {
            IKsAdSDK AO = lVar.AO();
            this.aoa = AO;
            AO.setIsExternal(true);
        }
        com.kwad.sdk.api.c.a(this.aoa);
        if (this.aob != null) {
            AQ();
        }
        this.Kc.set(true);
        return this.aoa;
    }

    public boolean isExternalLoaded() {
        if (this.aob != null) {
            return true;
        }
        return false;
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        checkInitSDK(context);
        return (T) this.aoa.newComponentProxy(cls, obj);
    }

    @MainThread
    public <T> T newInstance(Class<T> cls) {
        checkInitSDK(mContext);
        return (T) this.aoa.newInstance(cls);
    }

    public void rest() {
        this.Kc.set(false);
        mContext = null;
        this.aoa = null;
        this.aob = null;
    }

    private Loader() {
        this.aob = null;
        this.Kc = new AtomicBoolean(false);
    }
}
