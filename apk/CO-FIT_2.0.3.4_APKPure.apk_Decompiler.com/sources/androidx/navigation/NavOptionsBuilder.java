package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.annotation.IdRes;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavOptions;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.reflect.oxoX;
import kotlin.text.OxI;

@XX({"SMAP\nNavOptionsBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavOptionsBuilder.kt\nandroidx/navigation/NavOptionsBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,272:1\n1#2:273\n*E\n"})
@NavOptionsDsl
public final class NavOptionsBuilder {
    @OOXIXo
    private final NavOptions.Builder builder = new NavOptions.Builder();
    private boolean inclusive;
    private boolean launchSingleTop;
    @IdRes
    private int popUpToId = -1;
    @oOoXoXO
    private String popUpToRoute;
    @oOoXoXO
    private oxoX<?> popUpToRouteClass;
    @oOoXoXO
    private Object popUpToRouteObject;
    private boolean restoreState;
    private boolean saveState;

    @kotlin.OOXIXo(message = "Use the popUpToId property.")
    public static /* synthetic */ void getPopUpTo$annotations() {
    }

    public static /* synthetic */ void popUpTo$default(NavOptionsBuilder navOptionsBuilder, int i, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            oooxoxo = NavOptionsBuilder$popUpTo$1.INSTANCE;
        }
        navOptionsBuilder.popUpTo(i, (Oox.oOoXoXO<? super PopUpToBuilder, oXIO0o0XI>) oooxoxo);
    }

    private final void setPopUpToRoute(String str) {
        if (str == null) {
            return;
        }
        if (!OxI.X0O0I0(str)) {
            this.popUpToRoute = str;
            this.inclusive = false;
            return;
        }
        throw new IllegalArgumentException("Cannot pop up to an empty route");
    }

    private final void setPopUpToRouteClass(oxoX<?> oxox) {
        if (oxox != null) {
            this.popUpToRouteClass = oxox;
            this.inclusive = false;
        }
    }

    private final void setPopUpToRouteObject(Object obj) {
        if (obj != null) {
            this.popUpToRouteObject = obj;
            this.inclusive = false;
        }
    }

    public final void anim(@OOXIXo Oox.oOoXoXO<? super AnimBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "animBuilder");
        AnimBuilder animBuilder = new AnimBuilder();
        oooxoxo.invoke(animBuilder);
        this.builder.setEnterAnim(animBuilder.getEnter()).setExitAnim(animBuilder.getExit()).setPopEnterAnim(animBuilder.getPopEnter()).setPopExitAnim(animBuilder.getPopExit());
    }

    @OOXIXo
    public final NavOptions build$navigation_common_release() {
        NavOptions.Builder builder2 = this.builder;
        builder2.setLaunchSingleTop(this.launchSingleTop);
        builder2.setRestoreState(this.restoreState);
        String str = this.popUpToRoute;
        if (str != null) {
            builder2.setPopUpTo(str, this.inclusive, this.saveState);
        } else {
            oxoX<?> oxox = this.popUpToRouteClass;
            if (oxox != null) {
                IIX0o.ooOOo0oXI(oxox);
                builder2.setPopUpTo(oxox, this.inclusive, this.saveState);
            } else {
                Object obj = this.popUpToRouteObject;
                if (obj != null) {
                    IIX0o.ooOOo0oXI(obj);
                    builder2.setPopUpTo(obj, this.inclusive, this.saveState);
                } else {
                    builder2.setPopUpTo(this.popUpToId, this.inclusive, this.saveState);
                }
            }
        }
        return builder2.build();
    }

    public final boolean getLaunchSingleTop() {
        return this.launchSingleTop;
    }

    public final int getPopUpTo() {
        return this.popUpToId;
    }

    public final int getPopUpToId() {
        return this.popUpToId;
    }

    @oOoXoXO
    public final String getPopUpToRoute() {
        return this.popUpToRoute;
    }

    @oOoXoXO
    public final oxoX<?> getPopUpToRouteClass() {
        return this.popUpToRouteClass;
    }

    @oOoXoXO
    public final Object getPopUpToRouteObject() {
        return this.popUpToRouteObject;
    }

    public final boolean getRestoreState() {
        return this.restoreState;
    }

    public final void popUpTo(@IdRes int i, @OOXIXo Oox.oOoXoXO<? super PopUpToBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "popUpToBuilder");
        setPopUpToId$navigation_common_release(i);
        setPopUpToRoute((String) null);
        PopUpToBuilder popUpToBuilder = new PopUpToBuilder();
        oooxoxo.invoke(popUpToBuilder);
        this.inclusive = popUpToBuilder.getInclusive();
        this.saveState = popUpToBuilder.getSaveState();
    }

    public final void setLaunchSingleTop(boolean z) {
        this.launchSingleTop = z;
    }

    @kotlin.OOXIXo(message = "Use the popUpTo function and passing in the id.")
    public final void setPopUpTo(int i) {
        popUpTo$default(this, i, (Oox.oOoXoXO) null, 2, (Object) null);
    }

    public final void setPopUpToId$navigation_common_release(int i) {
        this.popUpToId = i;
        this.inclusive = false;
    }

    public final void setRestoreState(boolean z) {
        this.restoreState = z;
    }

    public static /* synthetic */ void popUpTo$default(NavOptionsBuilder navOptionsBuilder, String str, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = NavOptionsBuilder$popUpTo$2.INSTANCE;
        }
        navOptionsBuilder.popUpTo(str, (Oox.oOoXoXO<? super PopUpToBuilder, oXIO0o0XI>) oooxoxo);
    }

    public static /* synthetic */ void popUpTo$default(NavOptionsBuilder navOptionsBuilder, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = NavOptionsBuilder$popUpTo$3.INSTANCE;
        }
        IIX0o.x0xO0oo(oooxoxo, "popUpToBuilder");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        navOptionsBuilder.popUpTo(IO.oxoX(Object.class), (Oox.oOoXoXO<? super PopUpToBuilder, oXIO0o0XI>) oooxoxo);
    }

    public static /* synthetic */ void popUpTo$default(NavOptionsBuilder navOptionsBuilder, Object obj, Oox.oOoXoXO oooxoxo, int i, Object obj2) {
        if ((i & 2) != 0) {
            oooxoxo = NavOptionsBuilder$popUpTo$4.INSTANCE;
        }
        navOptionsBuilder.popUpTo(obj, (Oox.oOoXoXO<? super PopUpToBuilder, oXIO0o0XI>) oooxoxo);
    }

    public final void popUpTo(@OOXIXo String str, @OOXIXo Oox.oOoXoXO<? super PopUpToBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(str, "route");
        IIX0o.x0xO0oo(oooxoxo, "popUpToBuilder");
        setPopUpToRoute(str);
        setPopUpToId$navigation_common_release(-1);
        PopUpToBuilder popUpToBuilder = new PopUpToBuilder();
        oooxoxo.invoke(popUpToBuilder);
        this.inclusive = popUpToBuilder.getInclusive();
        this.saveState = popUpToBuilder.getSaveState();
    }

    public final /* synthetic */ <T> void popUpTo(Oox.oOoXoXO<? super PopUpToBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "popUpToBuilder");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        popUpTo(IO.oxoX(Object.class), oooxoxo);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final <T> void popUpTo(@OOXIXo oxoX<T> oxox, @OOXIXo Oox.oOoXoXO<? super PopUpToBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(oxox, "klass");
        IIX0o.x0xO0oo(oooxoxo, "popUpToBuilder");
        setPopUpToRouteClass(oxox);
        setPopUpToId$navigation_common_release(-1);
        setPopUpToRoute((String) null);
        PopUpToBuilder popUpToBuilder = new PopUpToBuilder();
        oooxoxo.invoke(popUpToBuilder);
        this.inclusive = popUpToBuilder.getInclusive();
        this.saveState = popUpToBuilder.getSaveState();
    }

    public final <T> void popUpTo(@OOXIXo T t, @OOXIXo Oox.oOoXoXO<? super PopUpToBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(t, "route");
        IIX0o.x0xO0oo(oooxoxo, "popUpToBuilder");
        setPopUpToRouteObject(t);
        setPopUpToId$navigation_common_release(-1);
        setPopUpToRoute((String) null);
        PopUpToBuilder popUpToBuilder = new PopUpToBuilder();
        oooxoxo.invoke(popUpToBuilder);
        this.inclusive = popUpToBuilder.getInclusive();
        this.saveState = popUpToBuilder.getSaveState();
    }
}
