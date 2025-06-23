package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import XXO0.oIX0oI;
import android.os.Bundle;
import androidx.annotation.IdRes;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nNavAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavAction.kt\nandroidx/navigation/NavAction\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n1855#2,2:90\n*S KotlinDebug\n*F\n+ 1 NavAction.kt\nandroidx/navigation/NavAction\n*L\n58#1:87,3\n67#1:90,2\n*E\n"})
public final class NavAction {
    @oOoXoXO
    private Bundle defaultArguments;
    @IdRes
    private final int destinationId;
    @oOoXoXO
    private NavOptions navOptions;

    @xoIox
    public NavAction(@IdRes int i) {
        this(i, (NavOptions) null, (Bundle) null, 6, (IIXOooo) null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        Set<String> keySet;
        Object obj2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NavAction)) {
            return false;
        }
        NavAction navAction = (NavAction) obj;
        if (this.destinationId == navAction.destinationId && IIX0o.Oxx0IOOO(this.navOptions, navAction.navOptions)) {
            if (IIX0o.Oxx0IOOO(this.defaultArguments, navAction.defaultArguments)) {
                return true;
            }
            Bundle bundle = this.defaultArguments;
            if (!(bundle == null || (keySet = bundle.keySet()) == null)) {
                if (keySet.isEmpty()) {
                    return true;
                }
                for (String str : keySet) {
                    Bundle bundle2 = this.defaultArguments;
                    Object obj3 = null;
                    if (bundle2 != null) {
                        obj2 = bundle2.get(str);
                    } else {
                        obj2 = null;
                    }
                    Bundle bundle3 = navAction.defaultArguments;
                    if (bundle3 != null) {
                        obj3 = bundle3.get(str);
                    }
                    if (!IIX0o.Oxx0IOOO(obj2, obj3)) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @oOoXoXO
    public final Bundle getDefaultArguments() {
        return this.defaultArguments;
    }

    public final int getDestinationId() {
        return this.destinationId;
    }

    @oOoXoXO
    public final NavOptions getNavOptions() {
        return this.navOptions;
    }

    public int hashCode() {
        int i;
        Set<String> keySet;
        Object obj;
        int i2;
        int i3 = this.destinationId * 31;
        NavOptions navOptions2 = this.navOptions;
        if (navOptions2 != null) {
            i = navOptions2.hashCode();
        } else {
            i = 0;
        }
        int i4 = i3 + i;
        Bundle bundle = this.defaultArguments;
        if (!(bundle == null || (keySet = bundle.keySet()) == null)) {
            for (String str : keySet) {
                int i5 = i4 * 31;
                Bundle bundle2 = this.defaultArguments;
                if (bundle2 != null) {
                    obj = bundle2.get(str);
                } else {
                    obj = null;
                }
                if (obj != null) {
                    i2 = obj.hashCode();
                } else {
                    i2 = 0;
                }
                i4 = i5 + i2;
            }
        }
        return i4;
    }

    public final void setDefaultArguments(@oOoXoXO Bundle bundle) {
        this.defaultArguments = bundle;
    }

    public final void setNavOptions(@oOoXoXO NavOptions navOptions2) {
        this.navOptions = navOptions2;
    }

    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NavAction.class.getSimpleName());
        sb.append("(0x");
        sb.append(Integer.toHexString(this.destinationId));
        sb.append(oIX0oI.I0Io.f17331I0Io);
        if (this.navOptions != null) {
            sb.append(" navOptions=");
            sb.append(this.navOptions);
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "sb.toString()");
        return sb2;
    }

    @xoIox
    public NavAction(@IdRes int i, @oOoXoXO NavOptions navOptions2) {
        this(i, navOptions2, (Bundle) null, 4, (IIXOooo) null);
    }

    @xoIox
    public NavAction(@IdRes int i, @oOoXoXO NavOptions navOptions2, @oOoXoXO Bundle bundle) {
        this.destinationId = i;
        this.navOptions = navOptions2;
        this.defaultArguments = bundle;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavAction(int i, NavOptions navOptions2, Bundle bundle, int i2, IIXOooo iIXOooo) {
        this(i, (i2 & 2) != 0 ? null : navOptions2, (i2 & 4) != 0 ? null : bundle);
    }
}
