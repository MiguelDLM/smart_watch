package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import kotlin.collections.builders.SetBuilder;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public class oX {
    @xx0o0O.XO
    @kotlin.o0
    @kotlin.oxxXoxO(version = "1.3")
    public static final <E> Set<E> I0Io(Oox.oOoXoXO<? super Set<E>, oXIO0o0XI> builderAction) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(builderAction, "builderAction");
        Set oxoX2 = oxoX();
        builderAction.invoke(oxoX2);
        return oIX0oI(oxoX2);
    }

    @OXOo.OOXIXo
    public static final <T> TreeSet<T> II0XooXoX(@OXOo.OOXIXo T... elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        return (TreeSet) ArraysKt___ArraysKt.IxOxxxIOI(elements, new TreeSet());
    }

    @xx0o0O.XO
    @kotlin.o0
    @kotlin.oxxXoxO(version = "1.3")
    public static final <E> Set<E> II0xO0(int i, Oox.oOoXoXO<? super Set<E>, oXIO0o0XI> builderAction) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(builderAction, "builderAction");
        Set X0o0xo2 = X0o0xo(i);
        builderAction.invoke(X0o0xo2);
        return oIX0oI(X0o0xo2);
    }

    @OXOo.OOXIXo
    public static final <T> TreeSet<T> Oxx0IOOO(@OXOo.OOXIXo Comparator<? super T> comparator, @OXOo.OOXIXo T... elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        return (TreeSet) ArraysKt___ArraysKt.IxOxxxIOI(elements, new TreeSet(comparator));
    }

    @OXOo.OOXIXo
    @kotlin.o0
    @kotlin.oxxXoxO(version = "1.3")
    public static <E> Set<E> X0o0xo(int i) {
        return new SetBuilder(i);
    }

    @OXOo.OOXIXo
    public static <T> Set<T> XO(T t) {
        Set<T> singleton = Collections.singleton(t);
        kotlin.jvm.internal.IIX0o.oO(singleton, "singleton(...)");
        return singleton;
    }

    @OXOo.OOXIXo
    @kotlin.o0
    @kotlin.oxxXoxO(version = "1.3")
    public static <E> Set<E> oIX0oI(@OXOo.OOXIXo Set<E> builder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(builder, "builder");
        return ((SetBuilder) builder).build();
    }

    @OXOo.OOXIXo
    @kotlin.o0
    @kotlin.oxxXoxO(version = "1.3")
    public static <E> Set<E> oxoX() {
        return new SetBuilder();
    }
}
