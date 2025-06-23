package androidx.navigation;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

public final class NamedNavArgumentKt {
    @OOXIXo
    public static final NamedNavArgument navArgument(@OOXIXo String str, @OOXIXo oOoXoXO<? super NavArgumentBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(str, "name");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        NavArgumentBuilder navArgumentBuilder = new NavArgumentBuilder();
        oooxoxo.invoke(navArgumentBuilder);
        return new NamedNavArgument(str, navArgumentBuilder.build());
    }
}
