package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.navigation.NavArgument;
import kotlin.jvm.internal.IIX0o;

@NavDestinationDsl
/* loaded from: classes.dex */
public final class NavArgumentBuilder {

    @oOoXoXO
    private NavType<?> _type;

    @OOXIXo
    private final NavArgument.Builder builder = new NavArgument.Builder();

    @oOoXoXO
    private Object defaultValue;
    private boolean nullable;
    private boolean unknownDefaultValuePresent;

    @OOXIXo
    public final NavArgument build() {
        return this.builder.build();
    }

    @oOoXoXO
    public final Object getDefaultValue() {
        return this.defaultValue;
    }

    public final boolean getNullable() {
        return this.nullable;
    }

    @OOXIXo
    public final NavType<?> getType() {
        NavType<?> navType = this._type;
        if (navType != null) {
            return navType;
        }
        throw new IllegalStateException("NavType has not been set on this builder.");
    }

    public final boolean getUnknownDefaultValuePresent$navigation_common_release() {
        return this.unknownDefaultValuePresent;
    }

    public final void setDefaultValue(@oOoXoXO Object obj) {
        this.defaultValue = obj;
        this.builder.setDefaultValue(obj);
    }

    public final void setNullable(boolean z) {
        this.nullable = z;
        this.builder.setIsNullable(z);
    }

    public final void setType(@OOXIXo NavType<?> value) {
        IIX0o.x0xO0oo(value, "value");
        this._type = value;
        this.builder.setType(value);
    }

    public final void setUnknownDefaultValuePresent$navigation_common_release(boolean z) {
        this.unknownDefaultValuePresent = z;
        this.builder.setUnknownDefaultValuePresent$navigation_common_release(z);
    }
}
