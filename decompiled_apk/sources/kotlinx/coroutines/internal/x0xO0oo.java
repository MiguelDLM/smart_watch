package kotlinx.coroutines.internal;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import kotlin.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nInlineList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InlineList.kt\nkotlinx/coroutines/internal/InlineList\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,49:1\n1#2:50\n*E\n"})
@XO0OX.Oxx0IOOO
/* loaded from: classes6.dex */
public final class x0xO0oo<E> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Object f30314oIX0oI;

    public /* synthetic */ x0xO0oo(Object obj) {
        this.f30314oIX0oI = obj;
    }

    public static /* synthetic */ Object I0Io(Object obj, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return II0xO0(obj);
    }

    @OXOo.OOXIXo
    public static final Object II0XooXoX(Object obj, E e) {
        if (obj == null) {
            return II0xO0(e);
        }
        if (obj instanceof ArrayList) {
            kotlin.jvm.internal.IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ((ArrayList) obj).add(e);
            return II0xO0(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e);
        return II0xO0(arrayList);
    }

    @OXOo.OOXIXo
    public static <E> Object II0xO0(@OXOo.oOoXoXO Object obj) {
        return obj;
    }

    public static int Oxx0IOOO(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean X0o0xo(Object obj, Object obj2) {
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(obj, obj2);
    }

    public static final void XO(Object obj, @OXOo.OOXIXo Oox.oOoXoXO<? super E, oXIO0o0XI> oooxoxo) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            oooxoxo.invoke(obj);
            return;
        }
        kotlin.jvm.internal.IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList arrayList = (ArrayList) obj;
        int size = arrayList.size();
        while (true) {
            size--;
            if (-1 < size) {
                oooxoxo.invoke((Object) arrayList.get(size));
            } else {
                return;
            }
        }
    }

    public static final /* synthetic */ x0xO0oo oIX0oI(Object obj) {
        return new x0xO0oo(obj);
    }

    public static boolean oxoX(Object obj, Object obj2) {
        return (obj2 instanceof x0xO0oo) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(obj, ((x0xO0oo) obj2).xoIox());
    }

    public static String xxIXOIIO(Object obj) {
        return "InlineList(holder=" + obj + HexStringBuilder.COMMENT_END_CHAR;
    }

    public boolean equals(Object obj) {
        return oxoX(this.f30314oIX0oI, obj);
    }

    public int hashCode() {
        return Oxx0IOOO(this.f30314oIX0oI);
    }

    public String toString() {
        return xxIXOIIO(this.f30314oIX0oI);
    }

    public final /* synthetic */ Object xoIox() {
        return this.f30314oIX0oI;
    }
}
