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

/* loaded from: classes.dex */
public final class NavDeepLinkDslBuilderKt {
    @OOXIXo
    public static final NavDeepLink navDeepLink(@OOXIXo oOoXoXO<? super NavDeepLinkDslBuilder, oXIO0o0XI> deepLinkBuilder) {
        IIX0o.x0xO0oo(deepLinkBuilder, "deepLinkBuilder");
        NavDeepLinkDslBuilder navDeepLinkDslBuilder = new NavDeepLinkDslBuilder();
        deepLinkBuilder.invoke(navDeepLinkDslBuilder);
        return navDeepLinkDslBuilder.build$navigation_common_release();
    }

    public static /* synthetic */ NavDeepLink navDeepLink$default(String basePath, Map typeMap, oOoXoXO deepLinkBuilder, int i, Object obj) {
        if ((i & 2) != 0) {
            typeMap = o0.O0xOxO();
        }
        if ((i & 4) != 0) {
            deepLinkBuilder = new oOoXoXO<NavDeepLinkDslBuilder, oXIO0o0XI>() { // from class: androidx.navigation.NavDeepLinkDslBuilderKt$navDeepLink$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(NavDeepLinkDslBuilder navDeepLinkDslBuilder) {
                    IIX0o.x0xO0oo(navDeepLinkDslBuilder, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(NavDeepLinkDslBuilder navDeepLinkDslBuilder) {
                    invoke2(navDeepLinkDslBuilder);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        IIX0o.x0xO0oo(basePath, "basePath");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.x0xO0oo(deepLinkBuilder, "deepLinkBuilder");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        return navDeepLink(basePath, IO.oxoX(Object.class), typeMap, deepLinkBuilder);
    }

    public static final /* synthetic */ <T> NavDeepLink navDeepLink(String basePath, Map<Oxx0xo, NavType<?>> typeMap, oOoXoXO<? super NavDeepLinkDslBuilder, oXIO0o0XI> deepLinkBuilder) {
        IIX0o.x0xO0oo(basePath, "basePath");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.x0xO0oo(deepLinkBuilder, "deepLinkBuilder");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        return navDeepLink(basePath, IO.oxoX(Object.class), typeMap, deepLinkBuilder);
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T> NavDeepLink navDeepLink(@OOXIXo String basePath, @OOXIXo oxoX<T> route, @OOXIXo Map<Oxx0xo, NavType<?>> typeMap, @OOXIXo oOoXoXO<? super NavDeepLinkDslBuilder, oXIO0o0XI> deepLinkBuilder) {
        IIX0o.x0xO0oo(basePath, "basePath");
        IIX0o.x0xO0oo(route, "route");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.x0xO0oo(deepLinkBuilder, "deepLinkBuilder");
        NavDeepLinkDslBuilder navDeepLinkDslBuilder = new NavDeepLinkDslBuilder(basePath, route, typeMap);
        deepLinkBuilder.invoke(navDeepLinkDslBuilder);
        return navDeepLinkDslBuilder.build$navigation_common_release();
    }
}
