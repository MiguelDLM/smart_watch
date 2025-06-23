package kotlin.collections;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;

@kotlin.jvm.internal.XX({"SMAP\nArraysJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,61:1\n26#2:62\n*S KotlinDebug\n*F\n+ 1 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n18#1:62\n*E\n"})
/* loaded from: classes6.dex */
public class OOXIXo {
    @kotlin.oxxXoxO(version = "1.3")
    public static final void I0Io(int i, int i2) {
        if (i <= i2) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i + ") is greater than size (" + i2 + ").");
    }

    @XO0OX.xxIXOIIO(name = "contentDeepHashCode")
    @kotlin.o0
    @kotlin.oxxXoxO(version = "1.3")
    public static <T> int II0xO0(@OXOo.oOoXoXO T[] tArr) {
        return Arrays.deepHashCode(tArr);
    }

    @xx0o0O.XO
    public static final String X0o0xo(byte[] bArr, Charset charset) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        return new String(bArr, charset);
    }

    public static final /* synthetic */ <T> T[] XO(Collection<? extends T> collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.OxI(0, "T?");
        return (T[]) collection.toArray(new Object[0]);
    }

    @OXOo.OOXIXo
    public static final <T> T[] oIX0oI(@OXOo.OOXIXo T[] reference, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(reference, "reference");
        Object newInstance = Array.newInstance(reference.getClass().getComponentType(), i);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (T[]) ((Object[]) newInstance);
    }

    public static final /* synthetic */ <T> T[] oxoX(T[] tArr) {
        if (tArr == null) {
            kotlin.jvm.internal.IIX0o.OxI(0, "T?");
            return (T[]) new Object[0];
        }
        return tArr;
    }
}
