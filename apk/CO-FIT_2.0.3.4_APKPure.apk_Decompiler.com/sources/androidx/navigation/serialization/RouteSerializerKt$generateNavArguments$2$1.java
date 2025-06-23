package androidx.navigation.serialization;

import Oox.oOoXoXO;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavType;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;
import kotlin.reflect.Oxx0xo;
import kotlinx.serialization.Oxx0IOOO;
import kotlinx.serialization.descriptors.XO;

public final class RouteSerializerKt$generateNavArguments$2$1 extends Lambda implements oOoXoXO<NavArgumentBuilder, oXIO0o0XI> {
    final /* synthetic */ int $index;
    final /* synthetic */ String $name;
    final /* synthetic */ Oxx0IOOO<T> $this_generateNavArguments;
    final /* synthetic */ Map<Oxx0xo, NavType<?>> $typeMap;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RouteSerializerKt$generateNavArguments$2$1(Oxx0IOOO<T> oxx0IOOO, int i, Map<Oxx0xo, ? extends NavType<?>> map, String str) {
        super(1);
        this.$this_generateNavArguments = oxx0IOOO;
        this.$index = i;
        this.$typeMap = map;
        this.$name = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavArgumentBuilder) obj);
        return oXIO0o0XI.f19155oIX0oI;
    }

    public final void invoke(NavArgumentBuilder navArgumentBuilder) {
        IIX0o.x0xO0oo(navArgumentBuilder, "$this$navArgument");
        XO X0o0xo2 = this.$this_generateNavArguments.oIX0oI().X0o0xo(this.$index);
        boolean I0Io2 = X0o0xo2.I0Io();
        NavType access$computeNavType = RouteSerializerKt.computeNavType(X0o0xo2, this.$typeMap);
        if (access$computeNavType != null) {
            navArgumentBuilder.setType(access$computeNavType);
            navArgumentBuilder.setNullable(I0Io2);
            if (this.$this_generateNavArguments.oIX0oI().xoIox(this.$index)) {
                navArgumentBuilder.setUnknownDefaultValuePresent$navigation_common_release(true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException(RouteSerializerKt.unknownNavTypeErrorMessage(this.$name, X0o0xo2.xxIXOIIO(), this.$this_generateNavArguments.oIX0oI().xxIXOIIO(), this.$typeMap.toString()));
    }
}
