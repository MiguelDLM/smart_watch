package kotlin.collections;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.IIX0;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public class Xo0 extends oX {
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> Set<T> IIXOooo(@OXOo.oOoXoXO T t) {
        if (t != null) {
            return oX.XO(t);
        }
        return OOXIXo();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <T> Set<T> IXxxXO(@OXOo.OOXIXo Set<? extends T> set) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(set, "<this>");
        int size = set.size();
        if (size != 0) {
            if (size == 1) {
                return oX.XO(set.iterator().next());
            }
            return set;
        }
        return OOXIXo();
    }

    @OXOo.OOXIXo
    public static <T> Set<T> OOXIXo() {
        return EmptySet.INSTANCE;
    }

    @OXOo.OOXIXo
    public static <T> Set<T> Oo(@OXOo.OOXIXo T... elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        return (Set) ArraysKt___ArraysKt.IxOxxxIOI(elements, new LinkedHashSet(OI0.xoIox(elements.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @xx0o0O.XO
    public static final <T> Set<T> Oxx0xo(Set<? extends T> set) {
        if (set == 0) {
            return OOXIXo();
        }
        return set;
    }

    @OXOo.OOXIXo
    public static <T> Set<T> OxxIIOOXO(@OXOo.OOXIXo T... elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        if (elements.length > 0) {
            return ArraysKt___ArraysKt.oOIoOOO(elements);
        }
        return OOXIXo();
    }

    @xx0o0O.XO
    public static final <T> Set<T> oI0IIXIo() {
        return OOXIXo();
    }

    @OXOo.OOXIXo
    public static final <T> LinkedHashSet<T> oO(@OXOo.OOXIXo T... elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        return (LinkedHashSet) ArraysKt___ArraysKt.IxOxxxIOI(elements, new LinkedHashSet(OI0.xoIox(elements.length)));
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.1")
    public static final <T> HashSet<T> oOoXoXO() {
        return new HashSet<>();
    }

    @OXOo.OOXIXo
    public static <T> HashSet<T> ooOOo0oXI(@OXOo.OOXIXo T... elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        return (HashSet) ArraysKt___ArraysKt.IxOxxxIOI(elements, new HashSet(OI0.xoIox(elements.length)));
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.1")
    public static final <T> LinkedHashSet<T> x0XOIxOo() {
        return new LinkedHashSet<>();
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.1")
    public static final <T> Set<T> x0xO0oo() {
        return new LinkedHashSet();
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.6")
    public static final <E> Set<E> xoIox(@kotlin.II0xO0 Oox.oOoXoXO<? super Set<E>, oXIO0o0XI> builderAction) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(builderAction, "builderAction");
        Set oxoX2 = oX.oxoX();
        builderAction.invoke(oxoX2);
        return oX.oIX0oI(oxoX2);
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> Set<T> xoXoI(@OXOo.OOXIXo T... elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        return (Set) ArraysKt___ArraysKt.OOXo0xOXx(elements, new LinkedHashSet());
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.6")
    public static final <E> Set<E> xxIXOIIO(int i, @kotlin.II0xO0 Oox.oOoXoXO<? super Set<E>, oXIO0o0XI> builderAction) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(builderAction, "builderAction");
        Set X0o0xo2 = oX.X0o0xo(i);
        builderAction.invoke(X0o0xo2);
        return oX.oIX0oI(X0o0xo2);
    }
}
