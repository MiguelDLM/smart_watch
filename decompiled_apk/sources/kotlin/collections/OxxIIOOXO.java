package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;

/* loaded from: classes6.dex */
public class OxxIIOOXO extends CollectionsKt__CollectionsKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kotlin.jvm.internal.XX({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n*L\n1#1,70:1\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> implements Iterable<T>, OI0IXox.oIX0oI {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Oox.oIX0oI<Iterator<T>> f29125XO;

        /* JADX WARN: Multi-variable type inference failed */
        public oIX0oI(Oox.oIX0oI<? extends Iterator<? extends T>> oix0oi) {
            this.f29125XO = oix0oi;
        }

        @Override // java.lang.Iterable
        @OXOo.OOXIXo
        public Iterator<T> iterator() {
            return this.f29125XO.invoke();
        }
    }

    @OXOo.OOXIXo
    public static final <T, R> Pair<List<T>, List<R>> I0X0x0oIo(@OXOo.OOXIXo Iterable<? extends Pair<? extends T, ? extends R>> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        int xo0x2 = xo0x(iterable, 10);
        ArrayList arrayList = new ArrayList(xo0x2);
        ArrayList arrayList2 = new ArrayList(xo0x2);
        for (Pair<? extends T, ? extends R> pair : iterable) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return kotlin.Xo0.oIX0oI(arrayList, arrayList2);
    }

    @OXOo.OOXIXo
    public static final <T> List<T> XX0(@OXOo.OOXIXo Iterable<? extends Iterable<? extends T>> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Iterable<? extends T>> it = iterable.iterator();
        while (it.hasNext()) {
            OxI.XIo0oOXIx(arrayList, it.next());
        }
        return arrayList;
    }

    @xx0o0O.XO
    public static final <T> Iterable<T> oxXx0IX(Oox.oIX0oI<? extends Iterator<? extends T>> iterator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterator, "iterator");
        return new oIX0oI(iterator);
    }

    @kotlin.o0
    @OXOo.oOoXoXO
    public static final <T> Integer xXOx(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    @kotlin.o0
    public static <T> int xo0x(@OXOo.OOXIXo Iterable<? extends T> iterable, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return i;
    }
}
