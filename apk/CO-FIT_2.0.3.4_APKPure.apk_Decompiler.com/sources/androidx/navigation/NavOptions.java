package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import XXO0.oIX0oI;
import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.serialization.RouteSerializerKt;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.XX;
import kotlin.reflect.oxoX;
import kotlinx.serialization.OxxIIOOXO;

public final class NavOptions {
    private final int enterAnim;
    private final int exitAnim;
    private final int popEnterAnim;
    private final int popExitAnim;
    @IdRes
    private final int popUpToId;
    private final boolean popUpToInclusive;
    @oOoXoXO
    private String popUpToRoute;
    @oOoXoXO
    private oxoX<?> popUpToRouteClass;
    @oOoXoXO
    private Object popUpToRouteObject;
    private final boolean popUpToSaveState;
    private final boolean restoreState;
    private final boolean singleTop;

    @XX({"SMAP\nNavOptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavOptions.kt\nandroidx/navigation/NavOptions$Builder\n*L\n1#1,594:1\n430#1,6:595\n*S KotlinDebug\n*F\n+ 1 NavOptions.kt\nandroidx/navigation/NavOptions$Builder\n*L\n-1#1:595,6\n*E\n"})
    public static final class Builder {
        @AnimRes
        @AnimatorRes
        private int enterAnim = -1;
        @AnimRes
        @AnimatorRes
        private int exitAnim = -1;
        @AnimRes
        @AnimatorRes
        private int popEnterAnim = -1;
        @AnimRes
        @AnimatorRes
        private int popExitAnim = -1;
        @IdRes
        private int popUpToId = -1;
        private boolean popUpToInclusive;
        @oOoXoXO
        private String popUpToRoute;
        @oOoXoXO
        private oxoX<?> popUpToRouteClass;
        @oOoXoXO
        private Object popUpToRouteObject;
        private boolean popUpToSaveState;
        private boolean restoreState;
        private boolean singleTop;

        public static /* synthetic */ Builder setPopUpTo$default(Builder builder, int i, boolean z, boolean z2, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                z2 = false;
            }
            return builder.setPopUpTo(i, z, z2);
        }

        @OOXIXo
        public final NavOptions build() {
            String str = this.popUpToRoute;
            if (str != null) {
                return new NavOptions(this.singleTop, this.restoreState, str, this.popUpToInclusive, this.popUpToSaveState, this.enterAnim, this.exitAnim, this.popEnterAnim, this.popExitAnim);
            }
            oxoX<?> oxox = this.popUpToRouteClass;
            if (oxox != null) {
                return new NavOptions(this.singleTop, this.restoreState, oxox, this.popUpToInclusive, this.popUpToSaveState, this.enterAnim, this.exitAnim, this.popEnterAnim, this.popExitAnim);
            }
            Object obj = this.popUpToRouteObject;
            if (obj != null) {
                boolean z = this.singleTop;
                boolean z2 = this.restoreState;
                IIX0o.ooOOo0oXI(obj);
                return new NavOptions(z, z2, obj, this.popUpToInclusive, this.popUpToSaveState, this.enterAnim, this.exitAnim, this.popEnterAnim, this.popExitAnim);
            }
            return new NavOptions(this.singleTop, this.restoreState, this.popUpToId, this.popUpToInclusive, this.popUpToSaveState, this.enterAnim, this.exitAnim, this.popEnterAnim, this.popExitAnim);
        }

        @OOXIXo
        public final Builder setEnterAnim(@AnimRes @AnimatorRes int i) {
            this.enterAnim = i;
            return this;
        }

        @OOXIXo
        public final Builder setExitAnim(@AnimRes @AnimatorRes int i) {
            this.exitAnim = i;
            return this;
        }

        @OOXIXo
        public final Builder setLaunchSingleTop(boolean z) {
            this.singleTop = z;
            return this;
        }

        @OOXIXo
        public final Builder setPopEnterAnim(@AnimRes @AnimatorRes int i) {
            this.popEnterAnim = i;
            return this;
        }

        @OOXIXo
        public final Builder setPopExitAnim(@AnimRes @AnimatorRes int i) {
            this.popExitAnim = i;
            return this;
        }

        @xoIox
        @OOXIXo
        public final Builder setPopUpTo(@IdRes int i, boolean z) {
            return setPopUpTo$default(this, i, z, false, 4, (Object) null);
        }

        @OOXIXo
        public final Builder setRestoreState(boolean z) {
            this.restoreState = z;
            return this;
        }

        public static /* synthetic */ Builder setPopUpTo$default(Builder builder, String str, boolean z, boolean z2, int i, Object obj) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            return builder.setPopUpTo(str, z, z2);
        }

        @xoIox
        @OOXIXo
        public final <T> Builder setPopUpTo(@OOXIXo T t, boolean z) {
            IIX0o.x0xO0oo(t, "route");
            return setPopUpTo$default(this, (Object) t, z, false, 4, (Object) null);
        }

        public static /* synthetic */ Builder setPopUpTo$default(Builder builder, boolean z, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            builder.setPopUpTo((oxoX<?>) IO.oxoX(Object.class), z, z2);
            return builder;
        }

        @xoIox
        @OOXIXo
        public final Builder setPopUpTo(@oOoXoXO String str, boolean z) {
            return setPopUpTo$default(this, str, z, false, 4, (Object) null);
        }

        public static /* synthetic */ Builder setPopUpTo$default(Builder builder, oxoX oxox, boolean z, boolean z2, int i, Object obj) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            return builder.setPopUpTo((oxoX<?>) oxox, z, z2);
        }

        @xoIox
        @OOXIXo
        public final Builder setPopUpTo(@IdRes int i, boolean z, boolean z2) {
            this.popUpToId = i;
            this.popUpToRoute = null;
            this.popUpToInclusive = z;
            this.popUpToSaveState = z2;
            return this;
        }

        public static /* synthetic */ Builder setPopUpTo$default(Builder builder, Object obj, boolean z, boolean z2, int i, Object obj2) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            return builder.setPopUpTo(obj, z, z2);
        }

        @xoIox
        @OOXIXo
        public final Builder setPopUpTo(@oOoXoXO String str, boolean z, boolean z2) {
            this.popUpToRoute = str;
            this.popUpToId = -1;
            this.popUpToInclusive = z;
            this.popUpToSaveState = z2;
            return this;
        }

        @xoIox
        public final /* synthetic */ <T> Builder setPopUpTo(boolean z, boolean z2) {
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            setPopUpTo((oxoX<?>) IO.oxoX(Object.class), z, z2);
            return this;
        }

        @OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final Builder setPopUpTo(@OOXIXo oxoX<?> oxox, boolean z, boolean z2) {
            IIX0o.x0xO0oo(oxox, "klass");
            this.popUpToRouteClass = oxox;
            this.popUpToId = -1;
            this.popUpToInclusive = z;
            this.popUpToSaveState = z2;
            return this;
        }

        @xoIox
        @OOXIXo
        public final <T> Builder setPopUpTo(@OOXIXo T t, boolean z, boolean z2) {
            IIX0o.x0xO0oo(t, "route");
            this.popUpToRouteObject = t;
            setPopUpTo(RouteSerializerKt.generateHashCode(OxxIIOOXO.Oxx0IOOO(IO.oxoX(t.getClass()))), z, z2);
            return this;
        }

        @xoIox
        public final /* synthetic */ <T> Builder setPopUpTo(boolean z) {
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            setPopUpTo((oxoX<?>) IO.oxoX(Object.class), z, false);
            return this;
        }
    }

    public NavOptions(boolean z, boolean z2, @IdRes int i, boolean z3, boolean z4, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4, @AnimRes @AnimatorRes int i5) {
        this.singleTop = z;
        this.restoreState = z2;
        this.popUpToId = i;
        this.popUpToInclusive = z3;
        this.popUpToSaveState = z4;
        this.enterAnim = i2;
        this.exitAnim = i3;
        this.popEnterAnim = i4;
        this.popExitAnim = i5;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NavOptions)) {
            return false;
        }
        NavOptions navOptions = (NavOptions) obj;
        if (this.singleTop == navOptions.singleTop && this.restoreState == navOptions.restoreState && this.popUpToId == navOptions.popUpToId && IIX0o.Oxx0IOOO(this.popUpToRoute, navOptions.popUpToRoute) && IIX0o.Oxx0IOOO(this.popUpToRouteClass, navOptions.popUpToRouteClass) && IIX0o.Oxx0IOOO(this.popUpToRouteObject, navOptions.popUpToRouteObject) && this.popUpToInclusive == navOptions.popUpToInclusive && this.popUpToSaveState == navOptions.popUpToSaveState && this.enterAnim == navOptions.enterAnim && this.exitAnim == navOptions.exitAnim && this.popEnterAnim == navOptions.popEnterAnim && this.popExitAnim == navOptions.popExitAnim) {
            return true;
        }
        return false;
    }

    @AnimRes
    @AnimatorRes
    public final int getEnterAnim() {
        return this.enterAnim;
    }

    @AnimRes
    @AnimatorRes
    public final int getExitAnim() {
        return this.exitAnim;
    }

    @AnimRes
    @AnimatorRes
    public final int getPopEnterAnim() {
        return this.popEnterAnim;
    }

    @AnimRes
    @AnimatorRes
    public final int getPopExitAnim() {
        return this.popExitAnim;
    }

    @kotlin.OOXIXo(message = "Use popUpToId instead.", replaceWith = @kotlin.XX(expression = "popUpToId", imports = {}))
    @IdRes
    public final int getPopUpTo() {
        return this.popUpToId;
    }

    @IdRes
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

    public int hashCode() {
        int i;
        int i2;
        int i3 = (((((shouldLaunchSingleTop() ? 1 : 0) * true) + (shouldRestoreState() ? 1 : 0)) * 31) + this.popUpToId) * 31;
        String str = this.popUpToRoute;
        int i4 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i5 = (i3 + i) * 31;
        oxoX<?> oxox = this.popUpToRouteClass;
        if (oxox != null) {
            i2 = oxox.hashCode();
        } else {
            i2 = 0;
        }
        int i6 = (i5 + i2) * 31;
        Object obj = this.popUpToRouteObject;
        if (obj != null) {
            i4 = obj.hashCode();
        }
        return ((((((((((((i6 + i4) * 31) + (isPopUpToInclusive() ? 1 : 0)) * 31) + (shouldPopUpToSaveState() ? 1 : 0)) * 31) + this.enterAnim) * 31) + this.exitAnim) * 31) + this.popEnterAnim) * 31) + this.popExitAnim;
    }

    public final boolean isPopUpToInclusive() {
        return this.popUpToInclusive;
    }

    public final boolean shouldLaunchSingleTop() {
        return this.singleTop;
    }

    public final boolean shouldPopUpToSaveState() {
        return this.popUpToSaveState;
    }

    public final boolean shouldRestoreState() {
        return this.restoreState;
    }

    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NavOptions.class.getSimpleName());
        sb.append(oIX0oI.I0Io.f17332II0xO0);
        if (this.singleTop) {
            sb.append("launchSingleTop ");
        }
        if (this.restoreState) {
            sb.append("restoreState ");
        }
        String str = this.popUpToRoute;
        if (!((str == null && this.popUpToId == -1) || str == null)) {
            sb.append("popUpTo(");
            String str2 = this.popUpToRoute;
            if (str2 != null) {
                sb.append(str2);
            } else {
                oxoX<?> oxox = this.popUpToRouteClass;
                if (oxox != null) {
                    sb.append(oxox);
                } else {
                    Object obj = this.popUpToRouteObject;
                    if (obj != null) {
                        sb.append(obj);
                    } else {
                        sb.append(HexStringBuilder.DEFAULT_PREFIX);
                        sb.append(Integer.toHexString(this.popUpToId));
                    }
                }
            }
            if (this.popUpToInclusive) {
                sb.append(" inclusive");
            }
            if (this.popUpToSaveState) {
                sb.append(" saveState");
            }
            sb.append(oIX0oI.I0Io.f17331I0Io);
        }
        if (!(this.enterAnim == -1 && this.exitAnim == -1 && this.popEnterAnim == -1 && this.popExitAnim == -1)) {
            sb.append("anim(enterAnim=0x");
            sb.append(Integer.toHexString(this.enterAnim));
            sb.append(" exitAnim=0x");
            sb.append(Integer.toHexString(this.exitAnim));
            sb.append(" popEnterAnim=0x");
            sb.append(Integer.toHexString(this.popEnterAnim));
            sb.append(" popExitAnim=0x");
            sb.append(Integer.toHexString(this.popExitAnim));
            sb.append(oIX0oI.I0Io.f17331I0Io);
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "sb.toString()");
        return sb2;
    }

    public NavOptions(boolean z, boolean z2, @oOoXoXO String str, boolean z3, boolean z4, int i, int i2, int i3, int i4) {
        this(z, z2, NavDestination.Companion.createRoute(str).hashCode(), z3, z4, i, i2, i3, i4);
        this.popUpToRoute = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NavOptions(boolean z, boolean z2, @oOoXoXO oxoX<?> oxox, boolean z3, boolean z4, int i, int i2, int i3, int i4) {
        this(z, z2, RouteSerializerKt.generateHashCode(OxxIIOOXO.Oxx0IOOO(oxox)), z3, z4, i, i2, i3, i4);
        IIX0o.ooOOo0oXI(oxox);
        this.popUpToRouteClass = oxox;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NavOptions(boolean z, boolean z2, @OOXIXo Object obj, boolean z3, boolean z4, int i, int i2, int i3, int i4) {
        this(z, z2, RouteSerializerKt.generateHashCode(OxxIIOOXO.Oxx0IOOO(IO.oxoX(obj.getClass()))), z3, z4, i, i2, i3, i4);
        IIX0o.x0xO0oo(obj, "popUpToRouteObject");
        this.popUpToRouteObject = obj;
    }
}
