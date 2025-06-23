package androidx.navigation;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
public final class NamedNavArgumentKt {
    @OOXIXo
    public static final NamedNavArgument navArgument(@OOXIXo String name, @OOXIXo oOoXoXO<? super NavArgumentBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(builder, "builder");
        NavArgumentBuilder navArgumentBuilder = new NavArgumentBuilder();
        builder.invoke(navArgumentBuilder);
        return new NamedNavArgument(name, navArgumentBuilder.build());
    }
}
