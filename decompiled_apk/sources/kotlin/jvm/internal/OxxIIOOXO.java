package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@XO0OX.xxIXOIIO(name = "CollectionToArray")
@XX({"SMAP\nCollectionToArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollectionToArray.kt\nkotlin/jvm/internal/CollectionToArray\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,88:1\n63#1,22:89\n63#1,22:111\n26#2:133\n*S KotlinDebug\n*F\n+ 1 CollectionToArray.kt\nkotlin/jvm/internal/CollectionToArray\n*L\n22#1:89,22\n37#1:111,22\n14#1:133\n*E\n"})
/* loaded from: classes6.dex */
public final class OxxIIOOXO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f29302II0xO0 = 2147483645;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Object[] f29303oIX0oI = new Object[0];

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    public static final Object[] I0Io(Collection<?> collection, Oox.oIX0oI<Object[]> oix0oi, Oox.oOoXoXO<? super Integer, Object[]> oooxoxo, Oox.x0xO0oo<? super Object[], ? super Integer, Object[]> x0xo0oo) {
        int size = collection.size();
        if (size == 0) {
            return oix0oi.invoke();
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            return oix0oi.invoke();
        }
        Object[] invoke = oooxoxo.invoke(Integer.valueOf(size));
        int i = 0;
        ?? r3 = invoke;
        while (true) {
            int i2 = i + 1;
            r3[i] = it.next();
            if (i2 >= r3.length) {
                if (!it.hasNext()) {
                    return r3;
                }
                int i3 = ((i2 * 3) + 1) >>> 1;
                if (i3 <= i2) {
                    i3 = 2147483645;
                    if (i2 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                }
                r3 = Arrays.copyOf((Object[]) r3, i3);
                IIX0o.oO(r3, "copyOf(...)");
            } else if (!it.hasNext()) {
                return x0xo0oo.invoke(r3, Integer.valueOf(i2));
            }
            i = i2;
            r3 = r3;
        }
    }

    @OXOo.OOXIXo
    @kotlin.OOXIXo(message = "This function will be made internal in a future release")
    @XO0OX.xxIXOIIO(name = "toArray")
    @kotlin.oOoXoXO(warningSince = "1.9")
    public static final Object[] II0xO0(@OXOo.OOXIXo Collection<?> collection, @OXOo.oOoXoXO Object[] objArr) {
        Object[] objArr2;
        IIX0o.x0xO0oo(collection, "collection");
        objArr.getClass();
        int size = collection.size();
        int i = 0;
        if (size == 0) {
            if (objArr.length > 0) {
                objArr[0] = null;
                return objArr;
            }
            return objArr;
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            if (objArr.length > 0) {
                objArr[0] = null;
                return objArr;
            }
            return objArr;
        }
        if (size <= objArr.length) {
            objArr2 = objArr;
        } else {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
            IIX0o.x0XOIxOo(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr2 = (Object[]) newInstance;
        }
        while (true) {
            int i2 = i + 1;
            objArr2[i] = it.next();
            if (i2 >= objArr2.length) {
                if (!it.hasNext()) {
                    return objArr2;
                }
                int i3 = ((i2 * 3) + 1) >>> 1;
                if (i3 <= i2) {
                    i3 = 2147483645;
                    if (i2 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                }
                objArr2 = Arrays.copyOf(objArr2, i3);
                IIX0o.oO(objArr2, "copyOf(...)");
            } else if (!it.hasNext()) {
                if (objArr2 == objArr) {
                    objArr[i2] = null;
                    return objArr;
                }
                Object[] copyOf = Arrays.copyOf(objArr2, i2);
                IIX0o.oO(copyOf, "copyOf(...)");
                return copyOf;
            }
            i = i2;
        }
    }

    @OXOo.OOXIXo
    @kotlin.OOXIXo(message = "This function will be made internal in a future release")
    @XO0OX.xxIXOIIO(name = "toArray")
    @kotlin.oOoXoXO(warningSince = "1.9")
    public static final Object[] oIX0oI(@OXOo.OOXIXo Collection<?> collection) {
        IIX0o.x0xO0oo(collection, "collection");
        int size = collection.size();
        if (size != 0) {
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArr = new Object[size];
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    objArr[i] = it.next();
                    if (i2 >= objArr.length) {
                        if (!it.hasNext()) {
                            return objArr;
                        }
                        int i3 = ((i2 * 3) + 1) >>> 1;
                        if (i3 <= i2) {
                            i3 = 2147483645;
                            if (i2 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArr = Arrays.copyOf(objArr, i3);
                        IIX0o.oO(objArr, "copyOf(...)");
                    } else if (!it.hasNext()) {
                        Object[] copyOf = Arrays.copyOf(objArr, i2);
                        IIX0o.oO(copyOf, "copyOf(...)");
                        return copyOf;
                    }
                    i = i2;
                }
            }
        }
        return f29303oIX0oI;
    }
}
