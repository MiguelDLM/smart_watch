package androidx.navigation;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class NamedNavArgument {

    @OOXIXo
    private final NavArgument argument;

    @OOXIXo
    private final String name;

    public NamedNavArgument(@OOXIXo String name, @OOXIXo NavArgument argument) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(argument, "argument");
        this.name = name;
        this.argument = argument;
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
