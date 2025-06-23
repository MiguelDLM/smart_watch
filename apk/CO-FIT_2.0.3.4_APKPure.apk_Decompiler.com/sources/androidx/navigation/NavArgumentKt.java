package androidx.navigation;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nNavArgument.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavArgument.kt\nandroidx/navigation/NavArgumentKt\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,238:1\n494#2,7:239\n766#3:246\n857#3,2:247\n*S KotlinDebug\n*F\n+ 1 NavArgument.kt\nandroidx/navigation/NavArgumentKt\n*L\n234#1:239,7\n236#1:246\n236#1:247,2\n*E\n"})
public final class NavArgumentKt {
    @OOXIXo
    public static final List<String> missingRequiredArguments(@OOXIXo Map<String, NavArgument> map, @OOXIXo oOoXoXO<? super String, Boolean> oooxoxo) {
        Boolean bool;
        IIX0o.x0xO0oo(map, "<this>");
        IIX0o.x0xO0oo(oooxoxo, "isArgumentMissing");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            NavArgument navArgument = (NavArgument) next.getValue();
            if (navArgument != null) {
                bool = Boolean.valueOf(navArgument.isNullable());
            } else {
                bool = null;
            }
            IIX0o.ooOOo0oXI(bool);
            if (!bool.booleanValue() && !navArgument.isDefaultValuePresent()) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        Set keySet = linkedHashMap.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object next2 : keySet) {
            if (oooxoxo.invoke((String) next2).booleanValue()) {
                arrayList.add(next2);
            }
        }
        return arrayList;
    }
}
