package androidx.navigation;

import Oox.oOoXoXO;
import androidx.annotation.IdRes;
import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.OOXIXo;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.reflect.Oxx0xo;

@XX({"SMAP\nActivityNavigatorDestinationBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityNavigatorDestinationBuilder.kt\nandroidx/navigation/ActivityNavigatorDestinationBuilderKt\n+ 2 NavigatorProvider.kt\nandroidx/navigation/NavigatorProviderKt\n*L\n1#1,126:1\n157#2:127\n157#2:128\n157#2:129\n*S KotlinDebug\n*F\n+ 1 ActivityNavigatorDestinationBuilder.kt\nandroidx/navigation/ActivityNavigatorDestinationBuilderKt\n*L\n40#1:127\n49#1:128\n66#1:129\n*E\n"})
/* loaded from: classes.dex */
public final class ActivityNavigatorDestinationBuilderKt {
    @OOXIXo(message = "Use routes to build your ActivityDestination instead", replaceWith = @kotlin.XX(expression = "activity(route = id.toString()) { builder.invoke() }", imports = {}))
    public static final void activity(@OXOo.OOXIXo NavGraphBuilder navGraphBuilder, @IdRes int i, @OXOo.OOXIXo oOoXoXO<? super ActivityNavigatorDestinationBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(navGraphBuilder, "<this>");
        IIX0o.x0xO0oo(builder, "builder");
        ActivityNavigatorDestinationBuilder activityNavigatorDestinationBuilder = new ActivityNavigatorDestinationBuilder((ActivityNavigator) navGraphBuilder.getProvider().getNavigator(ActivityNavigator.class), i);
        builder.invoke(activityNavigatorDestinationBuilder);
        navGraphBuilder.destination(activityNavigatorDestinationBuilder);
    }

    public static /* synthetic */ void activity$default(NavGraphBuilder navGraphBuilder, Map typeMap, oOoXoXO builder, int i, Object obj) {
        if ((i & 1) != 0) {
            typeMap = o0.O0xOxO();
        }
        IIX0o.x0xO0oo(navGraphBuilder, "<this>");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.x0xO0oo(builder, "builder");
        ActivityNavigator activityNavigator = (ActivityNavigator) navGraphBuilder.getProvider().getNavigator(ActivityNavigator.class);
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        ActivityNavigatorDestinationBuilder activityNavigatorDestinationBuilder = new ActivityNavigatorDestinationBuilder(activityNavigator, IO.oxoX(Object.class), typeMap);
        builder.invoke(activityNavigatorDestinationBuilder);
        navGraphBuilder.destination(activityNavigatorDestinationBuilder);
    }

    public static final void activity(@OXOo.OOXIXo NavGraphBuilder navGraphBuilder, @OXOo.OOXIXo String route, @OXOo.OOXIXo oOoXoXO<? super ActivityNavigatorDestinationBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(navGraphBuilder, "<this>");
        IIX0o.x0xO0oo(route, "route");
        IIX0o.x0xO0oo(builder, "builder");
        ActivityNavigatorDestinationBuilder activityNavigatorDestinationBuilder = new ActivityNavigatorDestinationBuilder((ActivityNavigator) navGraphBuilder.getProvider().getNavigator(ActivityNavigator.class), route);
        builder.invoke(activityNavigatorDestinationBuilder);
        navGraphBuilder.destination(activityNavigatorDestinationBuilder);
    }

    public static final /* synthetic */ <T> void activity(NavGraphBuilder navGraphBuilder, Map<Oxx0xo, NavType<?>> typeMap, oOoXoXO<? super ActivityNavigatorDestinationBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(navGraphBuilder, "<this>");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.x0xO0oo(builder, "builder");
        ActivityNavigator activityNavigator = (ActivityNavigator) navGraphBuilder.getProvider().getNavigator(ActivityNavigator.class);
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        ActivityNavigatorDestinationBuilder activityNavigatorDestinationBuilder = new ActivityNavigatorDestinationBuilder(activityNavigator, IO.oxoX(Object.class), typeMap);
        builder.invoke(activityNavigatorDestinationBuilder);
        navGraphBuilder.destination(activityNavigatorDestinationBuilder);
    }
}
