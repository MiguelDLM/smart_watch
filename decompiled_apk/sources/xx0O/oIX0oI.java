package xx0O;

import IXo.II0XooXoX;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import oX0O.xoIox;

/* loaded from: classes6.dex */
public class oIX0oI implements Application.ActivityLifecycleCallbacks {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final String f35277Oxx0xo = "SkinActivityLifecycle";

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static volatile oIX0oI f35278oI0IIXIo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public WeakReference<Activity> f35279IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public WeakHashMap<Context, C1176oIX0oI> f35280Oo;

    /* renamed from: XO, reason: collision with root package name */
    public WeakHashMap<Context, oxoX> f35281XO;

    /* renamed from: xx0O.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1176oIX0oI implements OoxxX.II0xO0 {

        /* renamed from: Oo, reason: collision with root package name */
        public boolean f35283Oo = false;

        /* renamed from: XO, reason: collision with root package name */
        public final Context f35284XO;

        public C1176oIX0oI(Context context) {
            this.f35284XO = context;
        }

        public void II0xO0() {
            if (this.f35283Oo) {
                oIX0oI();
            }
        }

        public void oIX0oI() {
            if (xoIox.f32102oIX0oI) {
                xoIox.II0xO0(oIX0oI.f35277Oxx0xo, "Context: " + this.f35284XO + " updateSkinForce");
            }
            Context context = this.f35284XO;
            if (context == null) {
                return;
            }
            if ((context instanceof Activity) && oIX0oI.this.xxIXOIIO(context)) {
                oIX0oI.this.xoIox((Activity) this.f35284XO);
            }
            oIX0oI.this.XO(this.f35284XO).oIX0oI();
            Object obj = this.f35284XO;
            if (obj instanceof xxoXO.Oxx0IOOO) {
                ((xxoXO.Oxx0IOOO) obj).applySkin();
            }
            this.f35283Oo = false;
        }

        @Override // OoxxX.II0xO0
        public void updateSkin(OoxxX.oIX0oI oix0oi, Object obj) {
            if (oIX0oI.this.f35279IXxxXO != null && this.f35284XO != oIX0oI.this.f35279IXxxXO.get() && (this.f35284XO instanceof Activity)) {
                this.f35283Oo = true;
            } else {
                oIX0oI();
            }
        }
    }

    public oIX0oI(Application application) {
        application.registerActivityLifecycleCallbacks(this);
        II0XooXoX(application);
        IIXOxIxOo.I0Io.IXxxXO().oIX0oI(X0o0xo(application));
    }

    public static oIX0oI Oxx0IOOO(Application application) {
        if (f35278oI0IIXIo == null) {
            synchronized (oIX0oI.class) {
                try {
                    if (f35278oI0IIXIo == null) {
                        f35278oI0IIXIo = new oIX0oI(application);
                    }
                } finally {
                }
            }
        }
        return f35278oI0IIXIo;
    }

    public final void II0XooXoX(Context context) {
        try {
            Oo0xX.oIX0oI.oxoX(LayoutInflater.from(context), XO(context));
        } catch (Throwable unused) {
            xoIox.II0xO0("SkinActivity", "A factory has already been set on this LayoutInflater");
        }
    }

    public final C1176oIX0oI X0o0xo(Context context) {
        if (this.f35280Oo == null) {
            this.f35280Oo = new WeakHashMap<>();
        }
        C1176oIX0oI c1176oIX0oI = this.f35280Oo.get(context);
        if (c1176oIX0oI == null) {
            C1176oIX0oI c1176oIX0oI2 = new C1176oIX0oI(context);
            this.f35280Oo.put(context, c1176oIX0oI2);
            return c1176oIX0oI2;
        }
        return c1176oIX0oI;
    }

    public final oxoX XO(Context context) {
        if (this.f35281XO == null) {
            this.f35281XO = new WeakHashMap<>();
        }
        oxoX oxox = this.f35281XO.get(context);
        if (oxox == null) {
            oxoX II0xO02 = oxoX.II0xO0(context);
            this.f35281XO.put(context, II0xO02);
            return II0xO02;
        }
        return oxox;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (xxIXOIIO(activity)) {
            II0XooXoX(activity);
            xoIox(activity);
            if (activity instanceof xxoXO.Oxx0IOOO) {
                ((xxoXO.Oxx0IOOO) activity).applySkin();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (xxIXOIIO(activity)) {
            IIXOxIxOo.I0Io.IXxxXO().I0Io(X0o0xo(activity));
            this.f35280Oo.remove(activity);
            this.f35281XO.remove(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f35279IXxxXO = new WeakReference<>(activity);
        if (xxIXOIIO(activity)) {
            C1176oIX0oI X0o0xo2 = X0o0xo(activity);
            IIXOxIxOo.I0Io.IXxxXO().oIX0oI(X0o0xo2);
            X0o0xo2.II0xO0();
        }
    }

    public final void xoIox(Activity activity) {
        Drawable Oxx0IOOO2;
        if (IIXOxIxOo.I0Io.IXxxXO().X0IIOO()) {
            int II0XooXoX2 = oIxOXo.X0o0xo.II0XooXoX(activity);
            if (xxoXO.I0Io.II0xO0(II0XooXoX2) != 0 && (Oxx0IOOO2 = oIxOXo.oxoX.Oxx0IOOO(activity, II0XooXoX2)) != null) {
                activity.getWindow().setBackgroundDrawable(Oxx0IOOO2);
            }
        }
    }

    public final boolean xxIXOIIO(Context context) {
        if (!IIXOxIxOo.I0Io.IXxxXO().OxI() && context.getClass().getAnnotation(II0XooXoX.class) == null && !(context instanceof xxoXO.Oxx0IOOO)) {
            return false;
        }
        return true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
