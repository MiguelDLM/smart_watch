package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.OO0x0xX;
import kotlin.OOXIxO0;
import kotlin.Pair;
import kotlin.XX0xXo;
import kotlin.collections.unsigned.UArraysKt___UArraysKt;
import kotlin.xX0IIXIx0;

@kotlin.jvm.internal.XX({"SMAP\nArrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Arrays.kt\nkotlin/collections/ArraysKt__ArraysKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,161:1\n1#2:162\n*E\n"})
/* loaded from: classes6.dex */
public class oOoXoXO extends OOXIXo {
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    @XO0OX.xxIXOIIO(name = "contentDeepToString")
    @kotlin.o0
    public static final <T> String II0XooXoX(@OXOo.oOoXoXO T[] tArr) {
        if (tArr == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder((X0.IIXOooo.XI0IXoo(tArr.length, 429496729) * 5) + 2);
        xxIXOIIO(tArr, sb, new ArrayList());
        String sb2 = sb.toString();
        kotlin.jvm.internal.IIX0o.oO(sb2, "toString(...)");
        return sb2;
    }

    /* JADX WARN: Incorrect types in method signature: <C:[Ljava/lang/Object;:TR;R:Ljava/lang/Object;>(TC;LOox/oIX0oI<+TR;>;)TR; */
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.3")
    public static final Object OOXIXo(Object[] objArr, Oox.oIX0oI defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (objArr.length == 0) {
            return defaultValue.invoke();
        }
        return objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @XO0OX.xxIXOIIO(name = "contentDeepEquals")
    @kotlin.o0
    @kotlin.oxxXoxO(version = "1.3")
    public static <T> boolean Oxx0IOOO(@OXOo.oOoXoXO T[] tArr, @OXOo.oOoXoXO T[] tArr2) {
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == 0 || tArr2 == 0 || tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            Object[] objArr = tArr[i];
            Object[] objArr2 = tArr2[i];
            if (objArr != objArr2) {
                if (objArr == 0 || objArr2 == 0) {
                    return false;
                }
                if ((objArr instanceof Object[]) && (objArr2 instanceof Object[])) {
                    if (!Oxx0IOOO(objArr, objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof byte[]) && (objArr2 instanceof byte[])) {
                    if (!Arrays.equals((byte[]) objArr, (byte[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof short[]) && (objArr2 instanceof short[])) {
                    if (!Arrays.equals((short[]) objArr, (short[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof int[]) && (objArr2 instanceof int[])) {
                    if (!Arrays.equals((int[]) objArr, (int[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof long[]) && (objArr2 instanceof long[])) {
                    if (!Arrays.equals((long[]) objArr, (long[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof float[]) && (objArr2 instanceof float[])) {
                    if (!Arrays.equals((float[]) objArr, (float[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof double[]) && (objArr2 instanceof double[])) {
                    if (!Arrays.equals((double[]) objArr, (double[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof char[]) && (objArr2 instanceof char[])) {
                    if (!Arrays.equals((char[]) objArr, (char[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof boolean[]) && (objArr2 instanceof boolean[])) {
                    if (!Arrays.equals((boolean[]) objArr, (boolean[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof OO0x0xX) && (objArr2 instanceof OO0x0xX)) {
                    if (!UArraysKt___UArraysKt.OoO(((OO0x0xX) objArr).oI0IIXIo(), ((OO0x0xX) objArr2).oI0IIXIo())) {
                        return false;
                    }
                } else if ((objArr instanceof xX0IIXIx0) && (objArr2 instanceof xX0IIXIx0)) {
                    if (!UArraysKt___UArraysKt.o0oIxOo(((xX0IIXIx0) objArr).oI0IIXIo(), ((xX0IIXIx0) objArr2).oI0IIXIo())) {
                        return false;
                    }
                } else if ((objArr instanceof XX0xXo) && (objArr2 instanceof XX0xXo)) {
                    if (!UArraysKt___UArraysKt.XIXIxO(((XX0xXo) objArr).oI0IIXIo(), ((XX0xXo) objArr2).oI0IIXIo())) {
                        return false;
                    }
                } else if ((objArr instanceof OOXIxO0) && (objArr2 instanceof OOXIxO0)) {
                    if (!UArraysKt___UArraysKt.OIOoIIOIx(((OOXIxO0) objArr).oI0IIXIo(), ((OOXIxO0) objArr2).oI0IIXIo())) {
                        return false;
                    }
                } else if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(objArr, objArr2)) {
                    return false;
                }
            }
        }
        return true;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.3")
    public static final boolean oOoXoXO(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            return false;
        }
        return true;
    }

    @OXOo.OOXIXo
    public static final <T, R> Pair<List<T>, List<R>> ooOOo0oXI(@OXOo.OOXIXo Pair<? extends T, ? extends R>[] pairArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(pairArr, "<this>");
        ArrayList arrayList = new ArrayList(pairArr.length);
        ArrayList arrayList2 = new ArrayList(pairArr.length);
        for (Pair<? extends T, ? extends R> pair : pairArr) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return kotlin.Xo0.oIX0oI(arrayList, arrayList2);
    }

    @OXOo.OOXIXo
    public static final <T> List<T> xoIox(@OXOo.OOXIXo T[][] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        int i = 0;
        for (T[] tArr2 : tArr) {
            i += tArr2.length;
        }
        ArrayList arrayList = new ArrayList(i);
        for (T[] tArr3 : tArr) {
            OxI.xxIO(arrayList, tArr3);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void xxIXOIIO(T[] tArr, StringBuilder sb, List<Object[]> list) {
        if (list.contains(tArr)) {
            sb.append("[...]");
            return;
        }
        list.add(tArr);
        sb.append('[');
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            Object[] objArr = tArr[i];
            if (objArr == 0) {
                sb.append("null");
            } else if (objArr instanceof Object[]) {
                xxIXOIIO(objArr, sb, list);
            } else if (objArr instanceof byte[]) {
                String arrays = Arrays.toString((byte[]) objArr);
                kotlin.jvm.internal.IIX0o.oO(arrays, "toString(...)");
                sb.append(arrays);
            } else if (objArr instanceof short[]) {
                String arrays2 = Arrays.toString((short[]) objArr);
                kotlin.jvm.internal.IIX0o.oO(arrays2, "toString(...)");
                sb.append(arrays2);
            } else if (objArr instanceof int[]) {
                String arrays3 = Arrays.toString((int[]) objArr);
                kotlin.jvm.internal.IIX0o.oO(arrays3, "toString(...)");
                sb.append(arrays3);
            } else if (objArr instanceof long[]) {
                String arrays4 = Arrays.toString((long[]) objArr);
                kotlin.jvm.internal.IIX0o.oO(arrays4, "toString(...)");
                sb.append(arrays4);
            } else if (objArr instanceof float[]) {
                String arrays5 = Arrays.toString((float[]) objArr);
                kotlin.jvm.internal.IIX0o.oO(arrays5, "toString(...)");
                sb.append(arrays5);
            } else if (objArr instanceof double[]) {
                String arrays6 = Arrays.toString((double[]) objArr);
                kotlin.jvm.internal.IIX0o.oO(arrays6, "toString(...)");
                sb.append(arrays6);
            } else if (objArr instanceof char[]) {
                String arrays7 = Arrays.toString((char[]) objArr);
                kotlin.jvm.internal.IIX0o.oO(arrays7, "toString(...)");
                sb.append(arrays7);
            } else if (objArr instanceof boolean[]) {
                String arrays8 = Arrays.toString((boolean[]) objArr);
                kotlin.jvm.internal.IIX0o.oO(arrays8, "toString(...)");
                sb.append(arrays8);
            } else if (objArr instanceof OO0x0xX) {
                sb.append(UArraysKt___UArraysKt.IXO(((OO0x0xX) objArr).oI0IIXIo()));
            } else if (objArr instanceof xX0IIXIx0) {
                sb.append(UArraysKt___UArraysKt.Ix00oIoI(((xX0IIXIx0) objArr).oI0IIXIo()));
            } else if (objArr instanceof XX0xXo) {
                sb.append(UArraysKt___UArraysKt.oI(((XX0xXo) objArr).oI0IIXIo()));
            } else if (objArr instanceof OOXIxO0) {
                sb.append(UArraysKt___UArraysKt.O0IxXx(((OOXIxO0) objArr).oI0IIXIo()));
            } else {
                sb.append(objArr.toString());
            }
        }
        sb.append(']');
        list.remove(CollectionsKt__CollectionsKt.oo0xXOI0I(list));
    }
}
