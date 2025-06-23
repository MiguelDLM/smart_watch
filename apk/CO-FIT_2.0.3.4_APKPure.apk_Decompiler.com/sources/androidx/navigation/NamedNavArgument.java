package androidx.navigation;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;

public final class NamedNavArgument {
    @OOXIXo
    private final NavArgument argument;
    @OOXIXo
    private final String name;

    public NamedNavArgument(@OOXIXo String str, @OOXIXo NavArgument navArgument) {
        IIX0o.x0xO0oo(str, "name");
        IIX0o.x0xO0oo(navArgument, "argument");
        this.name = str;
        this.argument = navArgument;
    }

    @OOXIXo
    public final String component1() {
        return this.name;
    }

    @OOXIXo
    public final NavArgument component2() {
        return this.argument;
    }

    @OOXIXo
    public final NavArgument getArgument() {
        return this.argument;
    }

    @OOXIXo
    public final String getName() {
        return this.name;
    }
}
