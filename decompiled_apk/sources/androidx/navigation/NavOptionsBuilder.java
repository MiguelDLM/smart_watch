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
/* loaded from: classes.dex */
public final class NavOptionsBuilder {
    private boolean inclusive;
    private boolean launchSingleTop;

    @oOoXoXO
    private String popUpToRoute;

    @oOoXoXO
    private oxoX<?> popUpToRouteClass;

    @oOoXoXO
    private Object popUpToRouteObject;
    private boolean restoreState;
    private boolean saveState;

    @OOXIXo
    private final NavOptions.Builder builder = new NavOptions.Builder();

    @IdRes
    private int popUpToId = -1;

    @kotlin.OOXIXo(message = "Use the popUpToId property.")
    public static /* synthetic */ void getPopUpTo$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void popUpTo$default(NavOptionsBuilder navOptionsBuilder, int i, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            oooxoxo = new Oox.oOoXoXO<PopUpToBuilder, oXIO0o0XI>() { // from class: androidx.navigation.NavOptionsBuilder$popUpTo$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PopUpToBuilder popUpToBuilder) {
                    IIX0o.x0xO0oo(popUpToBuilder, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PopUpToBuilder popUpToBuilder) {
                    invoke2(popUpToBuilder);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        navOptionsBuilder.popUpTo(i, (Oox.oOoXoXO<? super PopUpToBuilder, oXIO0o0XI>) oooxoxo);
    }

    private final void setPopUpToRoute(String str) {
        if (str != null) {
            if (!OxI.X0O0I0(str)) {
                this.popUpToRoute = str;
                this.inclusive = false;
                return;
            }
            throw new IllegalArgumentException("Cannot pop up to an empty route");
        }
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

    public final void anim(@OOXIXo Oox.oOoXoXO<? super AnimBuilder, oXIO0o0XI> animBuilder) {
        IIX0o.x0xO0oo(animBuilder, "animBuilder");
        AnimBuilder animBuilder2 = new AnimBuilder();
        animBuilder.invoke(animBuilder2);
        this.builder.setEnterAnim(animBuilder2.getEnter()).setExitAnim(animBuilder2.getExit()).setPopEnterAnim(animBuilder2.getPopEnter()).setPopExitAnim(animBuilder2.getPopExit());
    }

    @OOXIXo
    public final NavOptions build$navigation_common_release() {
        NavOptions.Builder builder = this.builder;
        builder.setLaunchSingleTop(this.launchSingleTop);
        builder.setRestoreState(this.restoreState);
        String str = this.popUpToRoute;
        if (str != null) {
            builder.setPopUpTo(str, this.inclusive, this.saveState);
        } else {
            oxoX<?> oxox = this.popUpToRouteClass;
            if (oxox != null) {
                IIX0o.ooOOo0oXI(oxox);
                builder.setPopUpTo(oxox, this.inclusive, this.saveState);
            } else {
                Object obj = this.popUpToRouteObject;
                if (obj != null) {
                    IIX0o.ooOOo0oXI(obj);
                    builder.setPopUpTo((NavOptions.Builder) obj, this.inclusive, this.saveState);
                } else {
                    builder.setPopUpTo(this.popUpToId, this.inclusive, this.saveState);
                }
            }
        }
        return builder.build();
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

    public final void popUpTo(@IdRes int i, @OOXIXo Oox.oOoXoXO<? super PopUpToBuilder, oXIO0o0XI> popUpToBuilder) {
        IIX0o.x0xO0oo(popUpToBuilder, "popUpToBuilder");
        setPopUpToId$navigation_common_release(i);
        setPopUpToRoute(null);
        PopUpToBuilder popUpToBuilder2 = new PopUpToBuilder();
        popUpToBuilder.invoke(popUpToBuilder2);
        this.inclusive = popUpToBuilder2.getInclusive();
        this.saveState = popUpToBuilder2.getSaveState();
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

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void popUpTo$default(NavOptionsBuilder navOptionsBuilder, String str, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = new Oox.oOoXoXO<PopUpToBuilder, oXIO0o0XI>() { // from class: androidx.navigation.NavOptionsBuilder$popUpTo$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PopUpToBuilder popUpToBuilder) {
                    IIX0o.x0xO0oo(popUpToBuilder, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PopUpToBuilder popUpToBuilder) {
                    invoke2(popUpToBuilder);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        navOptionsBuilder.popUpTo(str, (Oox.oOoXoXO<? super PopUpToBuilder, oXIO0o0XI>) oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void popUpTo$default(NavOptionsBuilder navOptionsBuilder, Oox.oOoXoXO popUpToBuilder, int i, Object obj) {
        if ((i & 1) != 0) {
            popUpToBuilder = new Oox.oOoXoXO<PopUpToBuilder, oXIO0o0XI>() { // from class: androidx.navigation.NavOptionsBuilder$popUpTo$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PopUpToBuilder popUpToBuilder2) {
                    IIX0o.x0xO0oo(popUpToBuilder2, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PopUpToBuilder popUpToBuilder2) {
                    invoke2(popUpToBuilder2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        IIX0o.x0xO0oo(popUpToBuilder, "popUpToBuilder");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        navOptionsBuilder.popUpTo(IO.oxoX(Object.class), (Oox.oOoXoXO<? super PopUpToBuilder, oXIO0o0XI>) popUpToBuilder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void popUpTo$default(NavOptionsBuilder navOptionsBuilder, Object obj, Oox.oOoXoXO oooxoxo, int i, Object obj2) {
        if ((i & 2) != 0) {
            oooxoxo = new Oox.oOoXoXO<PopUpToBuilder, oXIO0o0XI>() { // from class: androidx.navigation.NavOptionsBuilder$popUpTo$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PopUpToBuilder popUpToBuilder) {
                    IIX0o.x0xO0oo(popUpToBuilder, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PopUpToBuilder popUpToBuilder) {
                    invoke2(popUpToBuilder);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        navOptionsBuilder.popUpTo((NavOptionsBuilder) obj, (Oox.oOoXoXO<? super PopUpToBuilder, oXIO0o0XI>) oooxoxo);
    }

    public final void popUpTo(@OOXIXo String route, @OOXIXo Oox.oOoXoXO<? super PopUpToBuilder, oXIO0o0XI> popUpToBuilder) {
        IIX0o.x0xO0oo(route, "route");
        IIX0o.x0xO0oo(popUpToBuilder, "popUpToBuilder");
        setPopUpToRoute(route);
        setPopUpToId$navigation_common_release(-1);
        PopUpToBuilder popUpToBuilder2 = new PopUpToBuilder();
        popUpToBuilder.invoke(popUpToBuilder2);
        this.inclusive = popUpToBuilder2.getInclusive();
        this.saveState = popUpToBuilder2.getSaveState();
    }

    public final /* synthetic */ <T> void popUpTo(Oox.oOoXoXO<? super PopUpToBuilder, oXIO0o0XI> popUpToBuilder) {
        IIX0o.x0xO0oo(popUpToBuilder, "popUpToBuilder");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        popUpTo((oxoX) IO.oxoX(Object.class), popUpToBuilder);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final <T> void popUpTo(@OOXIXo oxoX<T> klass, @OOXIXo Oox.oOoXoXO<? super PopUpToBuilder, oXIO0o0XI> popUpToBuilder) {
        IIX0o.x0xO0oo(klass, "klass");
        IIX0o.x0xO0oo(popUpToBuilder, "popUpToBuilder");
        setPopUpToRouteClass(klass);
        setPopUpToId$navigation_common_release(-1);
        setPopUpToRoute(null);
        PopUpToBuilder popUpToBuilder2 = new PopUpToBuilder();
        popUpToBuilder.invoke(popUpToBuilder2);
        this.inclusive = popUpToBuilder2.getInclusive();
        this.saveState = popUpToBuilder2.getSaveState();
    }

    public final <T> void popUpTo(@OOXIXo T route, @OOXIXo Oox.oOoXoXO<? super PopUpToBuilder, oXIO0o0XI> popUpToBuilder) {
        IIX0o.x0xO0oo(route, "route");
        IIX0o.x0xO0oo(popUpToBuilder, "popUpToBuilder");
        setPopUpToRouteObject(route);
        setPopUpToId$navigation_common_release(-1);
        setPopUpToRoute(null);
        PopUpToBuilder popUpToBuilder2 = new PopUpToBuilder();
        popUpToBuilder.invoke(popUpToBuilder2);
        this.inclusive = popUpToBuilder2.getInclusive();
        this.saveState = popUpToBuilder2.getSaveState();
    }
}
