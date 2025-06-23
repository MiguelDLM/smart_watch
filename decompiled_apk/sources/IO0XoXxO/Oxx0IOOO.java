package IO0XoXxO;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes11.dex */
public class Oxx0IOOO {

    /* renamed from: XO, reason: collision with root package name */
    public String f406XO;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public X0o0xo f409xxIXOIIO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f407oIX0oI = "OnLineStateClass";

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f403II0xO0 = 0;

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f401I0Io = true;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f408oxoX = false;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f405X0o0xo = false;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public Map<String, String> f404Oxx0IOOO = new HashMap();

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public long f402II0XooXoX = 0;

    public static /* synthetic */ int OOXIXo(Oxx0IOOO oxx0IOOO) {
        int i = oxx0IOOO.f403II0xO0;
        oxx0IOOO.f403II0xO0 = i + 1;
        return i;
    }

    public static /* synthetic */ int oO(Oxx0IOOO oxx0IOOO) {
        int i = oxx0IOOO.f403II0xO0;
        oxx0IOOO.f403II0xO0 = i - 1;
        return i;
    }

    public void X0o0xo(Context context) {
        Application application = (Application) context.getApplicationContext();
        this.f402II0XooXoX = System.currentTimeMillis() / 1000;
        application.registerActivityLifecycleCallbacks(new oIX0oI());
    }

    public void oxoX(X0o0xo x0o0xo) {
        this.f409xxIXOIIO = x0o0xo;
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements Application.ActivityLifecycleCallbacks {
        public oIX0oI() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Oxx0IOOO.this.f406XO = activity.getClass().getSimpleName();
            Oxx0IOOO.this.f404Oxx0IOOO.put(Oxx0IOOO.this.f406XO, Oxx0IOOO.this.f406XO);
            Oxx0IOOO.this.f401I0Io = true;
            Oxx0IOOO.this.f408oxoX = false;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Oxx0IOOO.this.f404Oxx0IOOO.remove(activity.getClass().getSimpleName());
            if (Oxx0IOOO.this.f404Oxx0IOOO.size() == 0 && Oxx0IOOO.this.f401I0Io) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (Oxx0IOOO.this.f409xxIXOIIO != null) {
                    long unused = Oxx0IOOO.this.f402II0XooXoX;
                    Oxx0IOOO.this.f409xxIXOIIO.a(currentTimeMillis, Oxx0IOOO.this.f402II0XooXoX);
                    Oxx0IOOO.this.f402II0XooXoX = System.currentTimeMillis() / 1000;
                }
                Oxx0IOOO.this.f401I0Io = false;
            }
            if (Oxx0IOOO.this.f404Oxx0IOOO.size() == 0) {
                Oxx0IOOO.this.f405X0o0xo = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Oxx0IOOO.this.f408oxoX = !activity.getClass().getSimpleName().equals(Oxx0IOOO.this.f406XO);
            Oxx0IOOO.this.f406XO = activity.getClass().getSimpleName();
            if (!Oxx0IOOO.this.f401I0Io || Oxx0IOOO.this.f405X0o0xo) {
                Oxx0IOOO.this.f405X0o0xo = false;
                if (Oxx0IOOO.this.f409xxIXOIIO != null) {
                    Oxx0IOOO.this.f409xxIXOIIO.a();
                }
                Oxx0IOOO.this.f402II0XooXoX = System.currentTimeMillis() / 1000;
                Oxx0IOOO.this.f401I0Io = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            o0IXXIx.II0XooXoX.oIX0oI(Oxx0IOOO.this.f407oIX0oI, "onActivityStarted");
            Oxx0IOOO.OOXIXo(Oxx0IOOO.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            o0IXXIx.II0XooXoX.oIX0oI(Oxx0IOOO.this.f407oIX0oI, "onActivityStopped");
            Oxx0IOOO.oO(Oxx0IOOO.this);
            if (activity.getClass().getSimpleName().equals(Oxx0IOOO.this.f406XO)) {
                if (!Oxx0IOOO.this.f408oxoX || Oxx0IOOO.this.f404Oxx0IOOO.size() == 1) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (Oxx0IOOO.this.f409xxIXOIIO != null) {
                        long unused = Oxx0IOOO.this.f402II0XooXoX;
                        Oxx0IOOO.this.f409xxIXOIIO.a(Oxx0IOOO.this.f402II0XooXoX, currentTimeMillis);
                        Oxx0IOOO.this.f402II0XooXoX = System.currentTimeMillis() / 1000;
                    }
                    Oxx0IOOO.this.f401I0Io = false;
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
