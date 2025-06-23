package androidx.navigation;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.oXIO0o0XI;
import kotlin.reflect.Oxx0xo;
import kotlin.reflect.oxoX;

public final class NavDeepLinkDslBuilderKt {
    @OOXIXo
    public static final NavDeepLink navDeepLink(@OOXIXo oOoXoXO<? super NavDeepLinkDslBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "deepLinkBuilder");
        NavDeepLinkDslBuilder navDeepLinkDslBuilder = new NavDeepLinkDslBuilder();
        oooxoxo.invoke(navDeepLinkDslBuilder);
        return navDeepLinkDslBuilder.build$navigation_common_release();
    }

    public static /* synthetic */ NavDeepLink navDeepLink$default(String str, Map map, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            map = o0.O0xOxO();
        }
        if ((i & 4) != 0) {
            oooxoxo = NavDeepLinkDslBuilderKt$navDeepLink$1.INSTANCE;
        }
        IIX0o.x0xO0oo(str, "basePath");
        IIX0o.x0xO0oo(map, "typeMap");
        IIX0o.x0xO0oo(oooxoxo, "deepLinkBuilder");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        return navDeepLink(str, IO.oxoX(Object.class), map, oooxoxo);
    }

    public static final /* synthetic */ <T> NavDeepLink navDeepLink(String str, Map<Oxx0xo, NavType<?>> map, oOoXoXO<? super NavDeepLinkDslBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(str, "basePath");
        IIX0o.x0xO0oo(map, "typeMap");
        IIX0o.x0xO0oo(oooxoxo, "deepLinkBuilder");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        return navDeepLink(str, IO.oxoX(Object.class), map, oooxoxo);
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T> NavDeepLink navDeepLink(@OOXIXo String str, @OOXIXo oxoX<T> oxox, @OOXIXo Map<Oxx0xo, NavType<?>> map, @OOXIXo oOoXoXO<? super NavDeepLinkDslBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(str, "basePath");
        IIX0o.x0xO0oo(oxox, "route");
        IIX0o.x0xO0oo(map, "typeMap");
        IIX0o.x0xO0oo(oooxoxo, "deepLinkBuilder");
        NavDeepLinkDslBuilder navDeepLinkDslBuilder = new NavDeepLinkDslBuilder(str, oxox, map);
        oooxoxo.invoke(navDeepLinkDslBuilder);
        return navDeepLinkDslBuilder.build$navigation_common_release();
    }
}
