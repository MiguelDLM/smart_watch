package kotlin.collections;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes6.dex */
public class XX extends o0 {
    @kotlin.OOXIXo(message = "Use minByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <K, V, R extends Comparable<? super R>> Map.Entry<K, V> O0(Map<? extends K, ? extends V> map, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Map.Entry<K, V> entry;
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            entry = null;
        } else {
            Map.Entry<K, V> entry2 = (Object) it.next();
            if (it.hasNext()) {
                R invoke = selector.invoke(entry2);
                do {
                    Map.Entry<K, V> entry3 = (Object) it.next();
                    R invoke2 = selector.invoke(entry3);
                    if (invoke.compareTo(invoke2) > 0) {
                        entry2 = entry3;
                        invoke = invoke2;
                    }
                } while (it.hasNext());
            }
            entry = entry2;
        }
        return entry;
    }

    @kotlin.OOXIXo(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @xx0o0O.XO
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <K, V> Map.Entry<K, V> Ox0O(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.xx00oOoI(map.entrySet(), comparator);
    }

    @kotlin.OOXIXo(message = "Use maxByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxByOrNull(selector)", imports = {}))
    @xx0o0O.XO
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <K, V, R extends Comparable<? super R>> Map.Entry<K, V> xOoOIoI(Map<? extends K, ? extends V> map, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Map.Entry<K, V> entry;
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            entry = null;
        } else {
            Map.Entry<K, V> entry2 = (Object) it.next();
            if (it.hasNext()) {
                R invoke = selector.invoke(entry2);
                do {
                    Map.Entry<K, V> entry3 = (Object) it.next();
                    R invoke2 = selector.invoke(entry3);
                    if (invoke.compareTo(invoke2) < 0) {
                        entry2 = entry3;
                        invoke = invoke2;
                    }
                } while (it.hasNext());
            }
            entry = entry2;
        }
        return entry;
    }

    @kotlin.OOXIXo(message = "Use minWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Map.Entry xx0X0(Map map, Comparator comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.oxOIoIx(map.entrySet(), comparator);
    }
}
