package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.navigation.Navigator;
import kotlin.jvm.internal.IIX0o;

@Navigator.Name("NoOp")
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class NoOpNavigator extends Navigator<NavDestination> {
    @Override // androidx.navigation.Navigator
    @OOXIXo
    public NavDestination createDestination() {
        return new NavDestination(this);
    }

    @Override // androidx.navigation.Navigator
    @OOXIXo
    public NavDestination navigate(@OOXIXo NavDestination destination, @oOoXoXO Bundle bundle, @oOoXoXO NavOptions navOptions, @oOoXoXO Navigator.Extras extras) {
        IIX0o.x0xO0oo(destination, "destination");
        return destination;
    }

    @Override // androidx.navigation.Navigator
    public boolean popBackStack() {
        return true;
    }
}
