package androidx.navigation;

import OXOo.OOXIXo;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.serialization.RouteDeserializerKt;
import androidx.navigation.serialization.RouteSerializerKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.XX;
import kotlin.reflect.Oxx0xo;
import kotlin.reflect.oxoX;
import kotlinx.serialization.Oxx0IOOO;
import kotlinx.serialization.OxxIIOOXO;

@XX({"SMAP\nSavedStateHandle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandle.kt\nandroidx/navigation/SavedStateHandleKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,53:1\n2634#2:54\n1#3:55\n*S KotlinDebug\n*F\n+ 1 SavedStateHandle.kt\nandroidx/navigation/SavedStateHandleKt\n*L\n50#1:54\n50#1:55\n*E\n"})
/* loaded from: classes.dex */
public final class SavedStateHandleKt {
    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T> T internalToRoute(@OOXIXo SavedStateHandle savedStateHandle, @OOXIXo oxoX<T> route, @OOXIXo Map<Oxx0xo, ? extends NavType<?>> typeMap) {
        IIX0o.x0xO0oo(savedStateHandle, "<this>");
        IIX0o.x0xO0oo(route, "route");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Oxx0IOOO Oxx0IOOO2 = OxxIIOOXO.Oxx0IOOO(route);
        for (NamedNavArgument namedNavArgument : RouteSerializerKt.generateNavArguments(Oxx0IOOO2, typeMap)) {
            linkedHashMap.put(namedNavArgument.getName(), namedNavArgument.getArgument().getType());
        }
        return (T) RouteDeserializerKt.decodeArguments(Oxx0IOOO2, savedStateHandle, linkedHashMap);
    }

    public static final /* synthetic */ <T> T toRoute(SavedStateHandle savedStateHandle, Map<Oxx0xo, NavType<?>> typeMap) {
        IIX0o.x0xO0oo(savedStateHandle, "<this>");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) internalToRoute(savedStateHandle, IO.oxoX(Object.class), typeMap);
    }

    public static /* synthetic */ Object toRoute$default(SavedStateHandle savedStateHandle, Map typeMap, int i, Object obj) {
        if ((i & 1) != 0) {
            typeMap = o0.O0xOxO();
        }
        IIX0o.x0xO0oo(savedStateHandle, "<this>");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        return internalToRoute(savedStateHandle, IO.oxoX(Object.class), typeMap);
    }
}
