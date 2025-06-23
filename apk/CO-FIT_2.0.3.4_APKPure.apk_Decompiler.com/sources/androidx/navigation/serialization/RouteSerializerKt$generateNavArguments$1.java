package androidx.navigation.serialization;

import Oox.oIX0oI;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;
import kotlinx.serialization.Oxx0IOOO;

public final class RouteSerializerKt$generateNavArguments$1 extends Lambda implements oIX0oI<oXIO0o0XI> {
    final /* synthetic */ Oxx0IOOO<T> $this_generateNavArguments;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RouteSerializerKt$generateNavArguments$1(Oxx0IOOO<T> oxx0IOOO) {
        super(0);
        this.$this_generateNavArguments = oxx0IOOO;
    }

    public final void invoke() {
        throw new IllegalArgumentException("Cannot generate NavArguments for polymorphic serializer " + this.$this_generateNavArguments + ". Arguments can only be generated from concrete classes or objects.");
    }
}
