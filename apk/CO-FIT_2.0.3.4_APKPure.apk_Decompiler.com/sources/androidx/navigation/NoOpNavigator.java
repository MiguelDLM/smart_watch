package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.navigation.Navigator;
import kotlin.jvm.internal.IIX0o;

@Navigator.Name("NoOp")
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class NoOpNavigator extends Navigator<NavDestination> {
    @OOXIXo
    public NavDestination createDestination() {
        return new NavDestination((Navigator<? extends NavDestination>) this);
    }

    @OOXIXo
    public NavDestination navigate(@OOXIXo NavDestination navDestination, @oOoXoXO Bundle bundle, @oOoXoXO NavOptions navOptions, @oOoXoXO Navigator.Extras extras) {
        IIX0o.x0xO0oo(navDestination, "destination");
        return navDestination;
    }

    public boolean popBackStack() {
        return true;
    }
}
