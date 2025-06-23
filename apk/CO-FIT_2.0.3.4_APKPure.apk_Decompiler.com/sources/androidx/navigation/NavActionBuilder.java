package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.I0oOoX;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@NavDestinationDsl
@XX({"SMAP\nNavDestinationBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavDestinationBuilder.kt\nandroidx/navigation/NavActionBuilder\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,398:1\n37#2,2:399\n*S KotlinDebug\n*F\n+ 1 NavDestinationBuilder.kt\nandroidx/navigation/NavActionBuilder\n*L\n335#1:399,2\n*E\n"})
public final class NavActionBuilder {
    @OOXIXo
    private final Map<String, Object> defaultArguments = new LinkedHashMap();
    private int destinationId;
    @oOoXoXO
    private NavOptions navOptions;

    @OOXIXo
    public final NavAction build$navigation_common_release() {
        Bundle bundle;
        int i = this.destinationId;
        NavOptions navOptions2 = this.navOptions;
        if (this.defaultArguments.isEmpty()) {
            bundle = null;
        } else {
            Pair[] pairArr = (Pair[]) I0oOoX.XO0o(this.defaultArguments).toArray(new Pair[0]);
            bundle = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        }
        return new NavAction(i, navOptions2, bundle);
    }

    @OOXIXo
    public final Map<String, Object> getDefaultArguments() {
        return this.defaultArguments;
    }

    public final int getDestinationId() {
        return this.destinationId;
    }

    public final void navOptions(@OOXIXo Oox.oOoXoXO<? super NavOptionsBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "optionsBuilder");
        NavOptionsBuilder navOptionsBuilder = new NavOptionsBuilder();
        oooxoxo.invoke(navOptionsBuilder);
        this.navOptions = navOptionsBuilder.build$navigation_common_release();
    }

    public final void setDestinationId(int i) {
        this.destinationId = i;
    }
}
