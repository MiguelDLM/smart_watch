package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.IIX0o;

public final class NavArgument {
    @oOoXoXO
    private final Object defaultValue;
    private final boolean isDefaultValuePresent;
    private final boolean isDefaultValueUnknown;
    private final boolean isNullable;
    @OOXIXo
    private final NavType<Object> type;

    public static final class Builder {
        @oOoXoXO
        private Object defaultValue;
        private boolean defaultValuePresent;
        private boolean isNullable;
        @oOoXoXO
        private NavType<Object> type;
        private boolean unknownDefaultValuePresent;

        @OOXIXo
        public final NavArgument build() {
            NavType<Object> navType = this.type;
            if (navType == null) {
                navType = NavType.Companion.inferFromValueType(this.defaultValue);
                IIX0o.x0XOIxOo(navType, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any?>");
            }
            return new NavArgument(navType, this.isNullable, this.defaultValue, this.defaultValuePresent, this.unknownDefaultValuePresent);
        }

        @OOXIXo
        public final Builder setDefaultValue(@oOoXoXO Object obj) {
            this.defaultValue = obj;
            this.defaultValuePresent = true;
            return this;
        }

        @OOXIXo
        public final Builder setIsNullable(boolean z) {
            this.isNullable = z;
            return this;
        }

        @OOXIXo
        public final <T> Builder setType(@OOXIXo NavType<T> navType) {
            IIX0o.x0xO0oo(navType, "type");
            this.type = navType;
            return this;
        }

        @OOXIXo
        public final Builder setUnknownDefaultValuePresent$navigation_common_release(boolean z) {
            this.unknownDefaultValuePresent = z;
            return this;
        }
    }

    public NavArgument(@OOXIXo NavType<Object> navType, boolean z, @oOoXoXO Object obj, boolean z2, boolean z3) {
        boolean z4;
        IIX0o.x0xO0oo(navType, "type");
        if (!navType.isNullableAllowed() && z) {
            throw new IllegalArgumentException((navType.getName() + " does not allow nullable values").toString());
        } else if (z || !z2 || obj != null) {
            this.type = navType;
            this.isNullable = z;
            this.defaultValue = obj;
            if (z2 || z3) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.isDefaultValuePresent = z4;
            this.isDefaultValueUnknown = z3;
        } else {
            throw new IllegalArgumentException(("Argument with type " + navType.getName() + " has null value but is not nullable.").toString());
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (IIX0o.Oxx0IOOO(NavArgument.class, obj.getClass())) {
                NavArgument navArgument = (NavArgument) obj;
                if (this.isNullable != navArgument.isNullable || this.isDefaultValuePresent != navArgument.isDefaultValuePresent || !IIX0o.Oxx0IOOO(this.type, navArgument.type)) {
                    return false;
                }
                Object obj2 = this.defaultValue;
                if (obj2 != null) {
                    return IIX0o.Oxx0IOOO(obj2, navArgument.defaultValue);
                }
                if (navArgument.defaultValue == null) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    @oOoXoXO
    public final Object getDefaultValue() {
        return this.defaultValue;
    }

    @OOXIXo
    public final NavType<Object> getType() {
        return this.type;
    }

    public int hashCode() {
        int i;
        int hashCode = ((((this.type.hashCode() * 31) + (this.isNullable ? 1 : 0)) * 31) + (this.isDefaultValuePresent ? 1 : 0)) * 31;
        Object obj = this.defaultValue;
        if (obj != null) {
            i = obj.hashCode();
        } else {
            i = 0;
        }
        return hashCode + i;
    }

    public final boolean isDefaultValuePresent() {
        return this.isDefaultValuePresent;
    }

    public final boolean isDefaultValueUnknown$navigation_common_release() {
        return this.isDefaultValueUnknown;
    }

    public final boolean isNullable() {
        return this.isNullable;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void putDefaultValue(@OOXIXo String str, @OOXIXo Bundle bundle) {
        Object obj;
        IIX0o.x0xO0oo(str, "name");
        IIX0o.x0xO0oo(bundle, "bundle");
        if (this.isDefaultValuePresent && (obj = this.defaultValue) != null) {
            this.type.put(bundle, str, obj);
        }
    }

    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NavArgument.class.getSimpleName());
        sb.append(" Type: " + this.type);
        sb.append(" Nullable: " + this.isNullable);
        if (this.isDefaultValuePresent) {
            sb.append(" DefaultValue: " + this.defaultValue);
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "sb.toString()");
        return sb2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean verify(@OOXIXo String str, @OOXIXo Bundle bundle) {
        IIX0o.x0xO0oo(str, "name");
        IIX0o.x0xO0oo(bundle, "bundle");
        if (!this.isNullable && bundle.containsKey(str) && bundle.get(str) == null) {
            return false;
        }
        try {
            this.type.get(bundle, str);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }
}
