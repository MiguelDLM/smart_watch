package xIXoO0Xx;

import OXOo.OOXIXo;
import Oox.IXxxXO;
import Oox.oOoXoXO;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nEncoding.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Encoding.kt\nkotlinx/serialization/encoding/EncodingKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,507:1\n488#1,2:508\n490#1,2:513\n1864#2,3:510\n*S KotlinDebug\n*F\n+ 1 Encoding.kt\nkotlinx/serialization/encoding/EncodingKt\n*L\n501#1:508,2\n501#1:513,2\n502#1:510,3\n*E\n"})
/* loaded from: classes6.dex */
public final class xxIXOIIO {
    public static final void I0Io(@OOXIXo II0XooXoX iI0XooXoX, @OOXIXo kotlinx.serialization.descriptors.XO descriptor, @OOXIXo oOoXoXO<? super X0o0xo, oXIO0o0XI> block) {
        IIX0o.x0xO0oo(iI0XooXoX, "<this>");
        IIX0o.x0xO0oo(descriptor, "descriptor");
        IIX0o.x0xO0oo(block, "block");
        X0o0xo beginStructure = iI0XooXoX.beginStructure(descriptor);
        block.invoke(beginStructure);
        beginStructure.endStructure(descriptor);
    }

    public static final <E> void II0xO0(@OOXIXo II0XooXoX iI0XooXoX, @OOXIXo kotlinx.serialization.descriptors.XO descriptor, @OOXIXo Collection<? extends E> collection, @OOXIXo IXxxXO<? super X0o0xo, ? super Integer, ? super E, oXIO0o0XI> block) {
        IIX0o.x0xO0oo(iI0XooXoX, "<this>");
        IIX0o.x0xO0oo(descriptor, "descriptor");
        IIX0o.x0xO0oo(collection, "collection");
        IIX0o.x0xO0oo(block, "block");
        X0o0xo beginCollection = iI0XooXoX.beginCollection(descriptor, collection.size());
        Iterator<T> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            I00O.II0xO0 iI0xO0 = (Object) it.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            block.invoke(beginCollection, Integer.valueOf(i), iI0xO0);
            i = i2;
        }
        beginCollection.endStructure(descriptor);
    }

    public static final void oIX0oI(@OOXIXo II0XooXoX iI0XooXoX, @OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, @OOXIXo oOoXoXO<? super X0o0xo, oXIO0o0XI> block) {
        IIX0o.x0xO0oo(iI0XooXoX, "<this>");
        IIX0o.x0xO0oo(descriptor, "descriptor");
        IIX0o.x0xO0oo(block, "block");
        X0o0xo beginCollection = iI0XooXoX.beginCollection(descriptor, i);
        block.invoke(beginCollection);
        beginCollection.endStructure(descriptor);
    }
}
