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

@NavDeepLinkDsl
@XX({"SMAP\nNavDeepLinkDslBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavDeepLinkDslBuilder.kt\nandroidx/navigation/NavDeepLinkDslBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,141:1\n1#2:142\n*E\n"})
/* loaded from: classes.dex */
public final class NavDeepLinkDslBuilder {

    @oOoXoXO
    private String action;

    @OOXIXo
    private final NavDeepLink.Builder builder;

    @oOoXoXO
    private String mimeType;

    @oOoXoXO
    private oxoX<?> route;

    @OOXIXo
    private Map<Oxx0xo, ? extends NavType<?>> typeMap;

    @oOoXoXO
    private String uriPattern;

    public NavDeepLinkDslBuilder() {
        this.builder = new NavDeepLink.Builder();
        this.typeMap = o0.O0xOxO();
    }

    @OOXIXo
    public final NavDeepLink build$navigation_common_release() {
        NavDeepLink.Builder builder = this.builder;
        String str = this.uriPattern;
        if (str == null && this.action == null && this.mimeType == null) {
            throw new IllegalStateException("The NavDeepLink must have an uri, action, and/or mimeType.");
        }
        if (str != null) {
            builder.setUriPattern(str);
        }
        String str2 = this.action;
        if (str2 != null) {
            builder.setAction(str2);
        }
        String str3 = this.mimeType;
        if (str3 != null) {
            builder.setMimeType(str3);
        }
        return builder.build();
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
        if (str != null && str.length() == 0) {
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
        }
        this.action = str;
    }

    public final void setMimeType(@oOoXoXO String str) {
        this.mimeType = str;
    }

    public final void setUriPattern(@oOoXoXO String str) {
        this.uriPattern = str;
    }

    public NavDeepLinkDslBuilder(@OOXIXo String basePath, @OOXIXo oxoX<?> route, @OOXIXo Map<Oxx0xo, NavType<?>> typeMap) {
        IIX0o.x0xO0oo(basePath, "basePath");
        IIX0o.x0xO0oo(route, "route");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        this.builder = new NavDeepLink.Builder();
        this.typeMap = o0.O0xOxO();
        if (basePath.length() > 0) {
            this.uriPattern = RouteSerializerKt.generateRoutePattern(OxxIIOOXO.Oxx0IOOO(route), typeMap, basePath);
            this.route = route;
            this.typeMap = typeMap;
            return;
        }
        throw new IllegalArgumentException("The basePath for NavDeepLink from KClass cannot be empty");
    }
}
