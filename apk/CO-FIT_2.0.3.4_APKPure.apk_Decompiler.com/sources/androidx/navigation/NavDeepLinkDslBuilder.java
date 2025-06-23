package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.navigation.NavDeepLink;
import androidx.navigation.serialization.RouteSerializerKt;
import java.util.Map;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.reflect.Oxx0xo;
import kotlin.reflect.oxoX;
import kotlinx.serialization.OxxIIOOXO;

@XX({"SMAP\nNavDeepLinkDslBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavDeepLinkDslBuilder.kt\nandroidx/navigation/NavDeepLinkDslBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,141:1\n1#2:142\n*E\n"})
@NavDeepLinkDsl
public final class NavDeepLinkDslBuilder {
    @oOoXoXO
    private String action;
    @OOXIXo
    private final NavDeepLink.Builder builder = new NavDeepLink.Builder();
    @oOoXoXO
    private String mimeType;
    @oOoXoXO
    private oxoX<?> route;
    @OOXIXo
    private Map<Oxx0xo, ? extends NavType<?>> typeMap = o0.O0xOxO();
    @oOoXoXO
    private String uriPattern;

    public NavDeepLinkDslBuilder() {
    }

    @OOXIXo
    public final NavDeepLink build$navigation_common_release() {
        NavDeepLink.Builder builder2 = this.builder;
        String str = this.uriPattern;
        if (str == null && this.action == null && this.mimeType == null) {
            throw new IllegalStateException("The NavDeepLink must have an uri, action, and/or mimeType.");
        }
        if (str != null) {
            builder2.setUriPattern(str);
        }
        String str2 = this.action;
        if (str2 != null) {
            builder2.setAction(str2);
        }
        String str3 = this.mimeType;
        if (str3 != null) {
            builder2.setMimeType(str3);
        }
        return builder2.build();
    }

    @oOoXoXO
    public final String getAction() {
        return this.action;
    }

    @oOoXoXO
    public final String getMimeType() {
        return this.mimeType;
    }

    @oOoXoXO
    public final String getUriPattern() {
        return this.uriPattern;
    }

    public final void setAction(@oOoXoXO String str) {
        if (str == null || str.length() != 0) {
            this.action = str;
            return;
        }
        throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
    }

    public final void setMimeType(@oOoXoXO String str) {
        this.mimeType = str;
    }

    public final void setUriPattern(@oOoXoXO String str) {
        this.uriPattern = str;
    }

    public NavDeepLinkDslBuilder(@OOXIXo String str, @OOXIXo oxoX<?> oxox, @OOXIXo Map<Oxx0xo, NavType<?>> map) {
        IIX0o.x0xO0oo(str, "basePath");
        IIX0o.x0xO0oo(oxox, "route");
        IIX0o.x0xO0oo(map, "typeMap");
        if (str.length() > 0) {
            this.uriPattern = RouteSerializerKt.generateRoutePattern(OxxIIOOXO.Oxx0IOOO(oxox), map, str);
            this.route = oxox;
            this.typeMap = map;
            return;
        }
        throw new IllegalArgumentException("The basePath for NavDeepLink from KClass cannot be empty");
    }
}
