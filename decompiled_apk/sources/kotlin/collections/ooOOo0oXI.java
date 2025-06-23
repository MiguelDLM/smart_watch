package kotlin.collections;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.SortedSet;
import java.util.TreeSet;

@kotlin.jvm.internal.XX({"SMAP\n_ArraysJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,3042:1\n13896#2,14:3043\n13919#2,14:3057\n13942#2,14:3071\n13965#2,14:3085\n13988#2,14:3099\n14011#2,14:3113\n14034#2,14:3127\n14057#2,14:3141\n14080#2,14:3155\n16482#2,14:3169\n16505#2,14:3183\n16528#2,14:3197\n16551#2,14:3211\n16574#2,14:3225\n16597#2,14:3239\n16620#2,14:3253\n16643#2,14:3267\n16666#2,14:3281\n*S KotlinDebug\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt\n*L\n2434#1:3043,14\n2441#1:3057,14\n2448#1:3071,14\n2455#1:3085,14\n2462#1:3099,14\n2469#1:3113,14\n2476#1:3127,14\n2483#1:3141,14\n2490#1:3155,14\n2632#1:3169,14\n2639#1:3183,14\n2646#1:3197,14\n2653#1:3211,14\n2660#1:3225,14\n2667#1:3239,14\n2674#1:3253,14\n2681#1:3267,14\n2688#1:3281,14\n*E\n"})
/* loaded from: classes6.dex */
public class ooOOo0oXI extends oOoXoXO {

    /* loaded from: classes6.dex */
    public static final class I0Io extends kotlin.collections.II0xO0<Integer> implements RandomAccess {

        /* renamed from: XO */
        public final /* synthetic */ int[] f29156XO;

        public I0Io(int[] iArr) {
            this.f29156XO = iArr;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        @OXOo.OOXIXo
        /* renamed from: II0xO0 */
        public Integer get(int i) {
            return Integer.valueOf(this.f29156XO[i]);
        }

        public int X0o0xo(int i) {
            return ArraysKt___ArraysKt.I0IoX00I(this.f29156XO, i);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof Integer)) {
                return false;
            }
            return oIX0oI(((Number) obj).intValue());
        }

        @Override // kotlin.collections.II0xO0, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.f29156XO.length;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof Integer)) {
                return -1;
            }
            return oxoX(((Number) obj).intValue());
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.f29156XO.length == 0) {
                return true;
            }
            return false;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof Integer)) {
                return -1;
            }
            return X0o0xo(((Number) obj).intValue());
        }

        public boolean oIX0oI(int i) {
            return ArraysKt___ArraysKt.OOI00oxoO(this.f29156XO, i);
        }

        public int oxoX(int i) {
            return ArraysKt___ArraysKt.XoOoxI0X(this.f29156XO, i);
        }
    }

    /* loaded from: classes6.dex */
    public static final class II0XooXoX extends kotlin.collections.II0xO0<Character> implements RandomAccess {

        /* renamed from: XO */
        public final /* synthetic */ char[] f29157XO;

        public II0XooXoX(char[] cArr) {
            this.f29157XO = cArr;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        @OXOo.OOXIXo
        /* renamed from: II0xO0 */
        public Character get(int i) {
            return Character.valueOf(this.f29157XO[i]);
        }

        public int X0o0xo(char c) {
            return ArraysKt___ArraysKt.IoXIOI0O(this.f29157XO, c);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof Character)) {
                return false;
            }
            return oIX0oI(((Character) obj).charValue());
        }

        @Override // kotlin.collections.II0xO0, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.f29157XO.length;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof Character)) {
                return -1;
            }
            return oxoX(((Character) obj).charValue());
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.f29157XO.length == 0) {
                return true;
            }
            return false;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof Character)) {
                return -1;
            }
            return X0o0xo(((Character) obj).charValue());
        }

        public boolean oIX0oI(char c) {
            return ArraysKt___ArraysKt.xoxXoXO(this.f29157XO, c);
        }

        public int oxoX(char c) {
            return ArraysKt___ArraysKt.OOIX(this.f29157XO, c);
        }
    }

    /* loaded from: classes6.dex */
    public static final class II0xO0 extends kotlin.collections.II0xO0<Short> implements RandomAccess {

        /* renamed from: XO */
        public final /* synthetic */ short[] f29158XO;

        public II0xO0(short[] sArr) {
            this.f29158XO = sArr;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        @OXOo.OOXIXo
        /* renamed from: II0xO0 */
        public Short get(int i) {
            return Short.valueOf(this.f29158XO[i]);
        }

        public int X0o0xo(short s) {
            return ArraysKt___ArraysKt.xoOxO0(this.f29158XO, s);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof Short)) {
                return false;
            }
            return oIX0oI(((Number) obj).shortValue());
        }

        @Override // kotlin.collections.II0xO0, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.f29158XO.length;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof Short)) {
                return -1;
            }
            return oxoX(((Number) obj).shortValue());
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.f29158XO.length == 0) {
                return true;
            }
            return false;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof Short)) {
                return -1;
            }
            return X0o0xo(((Number) obj).shortValue());
        }

        public boolean oIX0oI(short s) {
            return ArraysKt___ArraysKt.X0xX(this.f29158XO, s);
        }

        public int oxoX(short s) {
            return ArraysKt___ArraysKt.Oo0OxoOx(this.f29158XO, s);
        }
    }

    /* loaded from: classes6.dex */
    public static final class Oxx0IOOO extends kotlin.collections.II0xO0<Boolean> implements RandomAccess {

        /* renamed from: XO */
        public final /* synthetic */ boolean[] f29159XO;

        public Oxx0IOOO(boolean[] zArr) {
            this.f29159XO = zArr;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        @OXOo.OOXIXo
        /* renamed from: II0xO0 */
        public Boolean get(int i) {
            return Boolean.valueOf(this.f29159XO[i]);
        }

        public int X0o0xo(boolean z) {
            return ArraysKt___ArraysKt.xXxox(this.f29159XO, z);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof Boolean)) {
                return false;
            }
            return oIX0oI(((Boolean) obj).booleanValue());
        }

        @Override // kotlin.collections.II0xO0, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.f29159XO.length;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof Boolean)) {
                return -1;
            }
            return oxoX(((Boolean) obj).booleanValue());
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.f29159XO.length == 0) {
                return true;
            }
            return false;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof Boolean)) {
                return -1;
            }
            return X0o0xo(((Boolean) obj).booleanValue());
        }

        public boolean oIX0oI(boolean z) {
            return ArraysKt___ArraysKt.oXxo(this.f29159XO, z);
        }

        public int oxoX(boolean z) {
            return ArraysKt___ArraysKt.IxXXI0Xo(this.f29159XO, z);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\n_ArraysJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$5\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,3042:1\n12524#2,2:3043\n1687#2,6:3045\n1795#2,6:3051\n*S KotlinDebug\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$5\n*L\n199#1:3043,2\n201#1:3045,6\n202#1:3051,6\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class X0o0xo extends kotlin.collections.II0xO0<Float> implements RandomAccess {

        /* renamed from: XO */
        public final /* synthetic */ float[] f29160XO;

        public X0o0xo(float[] fArr) {
            this.f29160XO = fArr;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        @OXOo.OOXIXo
        /* renamed from: II0xO0 */
        public Float get(int i) {
            return Float.valueOf(this.f29160XO[i]);
        }

        public int X0o0xo(float f) {
            float[] fArr = this.f29160XO;
            int length = fArr.length - 1;
            if (length < 0) {
                return -1;
            }
            while (true) {
                int i = length - 1;
                if (Float.floatToIntBits(fArr[length]) == Float.floatToIntBits(f)) {
                    return length;
                }
                if (i < 0) {
                    return -1;
                }
                length = i;
            }
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof Float)) {
                return false;
            }
            return oIX0oI(((Number) obj).floatValue());
        }

        @Override // kotlin.collections.II0xO0, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.f29160XO.length;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof Float)) {
                return -1;
            }
            return oxoX(((Number) obj).floatValue());
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.f29160XO.length == 0) {
                return true;
            }
            return false;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof Float)) {
                return -1;
            }
            return X0o0xo(((Number) obj).floatValue());
        }

        public boolean oIX0oI(float f) {
            for (float f2 : this.f29160XO) {
                if (Float.floatToIntBits(f2) == Float.floatToIntBits(f)) {
                    return true;
                }
            }
            return false;
        }

        public int oxoX(float f) {
            float[] fArr = this.f29160XO;
            int length = fArr.length;
            for (int i = 0; i < length; i++) {
                if (Float.floatToIntBits(fArr[i]) == Float.floatToIntBits(f)) {
                    return i;
                }
            }
            return -1;
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\n_ArraysJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$6\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,3042:1\n12534#2,2:3043\n1699#2,6:3045\n1807#2,6:3051\n*S KotlinDebug\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$6\n*L\n213#1:3043,2\n215#1:3045,6\n216#1:3051,6\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class XO extends kotlin.collections.II0xO0<Double> implements RandomAccess {

        /* renamed from: XO */
        public final /* synthetic */ double[] f29161XO;

        public XO(double[] dArr) {
            this.f29161XO = dArr;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        @OXOo.OOXIXo
        /* renamed from: II0xO0 */
        public Double get(int i) {
            return Double.valueOf(this.f29161XO[i]);
        }

        public int X0o0xo(double d) {
            double[] dArr = this.f29161XO;
            int length = dArr.length - 1;
            if (length < 0) {
                return -1;
            }
            while (true) {
                int i = length - 1;
                if (Double.doubleToLongBits(dArr[length]) == Double.doubleToLongBits(d)) {
                    return length;
                }
                if (i < 0) {
                    return -1;
                }
                length = i;
            }
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof Double)) {
                return false;
            }
            return oIX0oI(((Number) obj).doubleValue());
        }

        @Override // kotlin.collections.II0xO0, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.f29161XO.length;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof Double)) {
                return -1;
            }
            return oxoX(((Number) obj).doubleValue());
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.f29161XO.length == 0) {
                return true;
            }
            return false;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof Double)) {
                return -1;
            }
            return X0o0xo(((Number) obj).doubleValue());
        }

        public boolean oIX0oI(double d) {
            for (double d2 : this.f29161XO) {
                if (Double.doubleToLongBits(d2) == Double.doubleToLongBits(d)) {
                    return true;
                }
            }
            return false;
        }

        public int oxoX(double d) {
            double[] dArr = this.f29161XO;
            int length = dArr.length;
            for (int i = 0; i < length; i++) {
                if (Double.doubleToLongBits(dArr[i]) == Double.doubleToLongBits(d)) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI extends kotlin.collections.II0xO0<Byte> implements RandomAccess {

        /* renamed from: XO */
        public final /* synthetic */ byte[] f29162XO;

        public oIX0oI(byte[] bArr) {
            this.f29162XO = bArr;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        @OXOo.OOXIXo
        /* renamed from: II0xO0 */
        public Byte get(int i) {
            return Byte.valueOf(this.f29162XO[i]);
        }

        public int X0o0xo(byte b) {
            return ArraysKt___ArraysKt.OIX0oXO0o(this.f29162XO, b);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof Byte)) {
                return false;
            }
            return oIX0oI(((Number) obj).byteValue());
        }

        @Override // kotlin.collections.II0xO0, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.f29162XO.length;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof Byte)) {
                return -1;
            }
            return oxoX(((Number) obj).byteValue());
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.f29162XO.length == 0) {
                return true;
            }
            return false;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof Byte)) {
                return -1;
            }
            return X0o0xo(((Number) obj).byteValue());
        }

        public boolean oIX0oI(byte b) {
            return ArraysKt___ArraysKt.IX0IO(this.f29162XO, b);
        }

        public int oxoX(byte b) {
            return ArraysKt___ArraysKt.O00Ix(this.f29162XO, b);
        }
    }

    /* loaded from: classes6.dex */
    public static final class oxoX extends kotlin.collections.II0xO0<Long> implements RandomAccess {

        /* renamed from: XO */
        public final /* synthetic */ long[] f29163XO;

        public oxoX(long[] jArr) {
            this.f29163XO = jArr;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        @OXOo.OOXIXo
        /* renamed from: II0xO0 */
        public Long get(int i) {
            return Long.valueOf(this.f29163XO[i]);
        }

        public int X0o0xo(long j) {
            return ArraysKt___ArraysKt.I0Xo(this.f29163XO, j);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof Long)) {
                return false;
            }
            return oIX0oI(((Number) obj).longValue());
        }

        @Override // kotlin.collections.II0xO0, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.f29163XO.length;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof Long)) {
                return -1;
            }
            return oxoX(((Number) obj).longValue());
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.f29163XO.length == 0) {
                return true;
            }
            return false;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof Long)) {
                return -1;
            }
            return X0o0xo(((Number) obj).longValue());
        }

        public boolean oIX0oI(long j) {
            return ArraysKt___ArraysKt.XXXoOII(this.f29163XO, j);
        }

        public int oxoX(long j) {
            return ArraysKt___ArraysKt.XxxoIooX(this.f29163XO, j);
        }
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    public static long[] I0(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo long[] destination, int i, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        System.arraycopy(jArr, i2, destination, i, i3 - i2);
        return destination;
    }

    @kotlin.OOXIXo(message = "Use minByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Character I00O(char[] cArr, Oox.oOoXoXO<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        int IoOIIOx = ArraysKt___ArraysKt.IoOIIOx(cArr);
        if (IoOIIOx == 0) {
            return Character.valueOf(c);
        }
        R invoke = selector.invoke(Character.valueOf(c));
        oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx).iterator();
        while (it.hasNext()) {
            char c2 = cArr[it.nextInt()];
            R invoke2 = selector.invoke(Character.valueOf(c2));
            if (invoke.compareTo(invoke2) > 0) {
                c = c2;
                invoke = invoke2;
            }
        }
        return Character.valueOf(c);
    }

    public static void I0OO(@OXOo.OOXIXo long[] jArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        Arrays.sort(jArr, i, i2);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int I0X0x0oIo(char[] cArr) {
        return Arrays.hashCode(cArr);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> int I0oOIX(T[] tArr) {
        return Arrays.hashCode(tArr);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final boolean I0oOoX(float[] fArr, float[] fArr2) {
        return Arrays.equals(fArr, fArr2);
    }

    @XO0OX.xxIXOIIO(name = "copyOfRangeInline")
    @xx0o0O.XO
    public static final long[] I0xX0(long[] jArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
            return X0xxXX0(jArr, i, i2);
        }
        if (i2 <= jArr.length) {
            long[] copyOfRange = Arrays.copyOfRange(jArr, i, i2);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOfRange);
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + jArr.length);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigInteger")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final BigInteger II0OOXOx(int[] iArr, Oox.oOoXoXO<? super Integer, ? extends BigInteger> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        for (int i : iArr) {
            valueOf = valueOf.add(selector.invoke(Integer.valueOf(i)));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @OXOo.OOXIXo
    public static boolean[] IIIxO(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo boolean[] elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        int length = zArr.length;
        int length2 = elements.length;
        boolean[] copyOf = Arrays.copyOf(zArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @kotlin.OOXIXo(message = "Use maxOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Long IIOIX(long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        return ArraysKt___ArraysKt.oXXxI(jArr);
    }

    public static /* synthetic */ Object[] IIX0(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return ooOx(objArr, objArr2, i, i2, i3);
    }

    public static /* synthetic */ int IIX0o(char[] cArr, char c, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        return o00(cArr, c, i, i2);
    }

    @OXOo.OOXIXo
    public static final List<Boolean> IIXOooo(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        return new Oxx0IOOO(zArr);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigDecimal")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final BigDecimal IIoX0OoI(byte[] bArr, Oox.oOoXoXO<? super Byte, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        for (byte b : bArr) {
            valueOf = valueOf.add(selector.invoke(Byte.valueOf(b)));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    public static int[] IIxOXoOo0(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo int[] destination, int i, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        System.arraycopy(iArr, i2, destination, i, i3 - i2);
        return destination;
    }

    @XO0OX.xxIXOIIO(name = "contentDeepEqualsNullable")
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> boolean IO(T[] tArr, T[] tArr2) {
        if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
            return oOoXoXO.Oxx0IOOO(tArr, tArr2);
        }
        return Arrays.deepEquals(tArr, tArr2);
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    @XO0OX.xxIXOIIO(name = "copyOfRange")
    @kotlin.o0
    public static <T> T[] IO0XoXxO(@OXOo.OOXIXo T[] tArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        OOXIXo.I0Io(i2, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i, i2);
        kotlin.jvm.internal.IIX0o.oO(tArr2, "copyOfRange(...)");
        return tArr2;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigInteger")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final BigInteger IO0xX(float[] fArr, Oox.oOoXoXO<? super Float, ? extends BigInteger> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        for (float f : fArr) {
            valueOf = valueOf.add(selector.invoke(Float.valueOf(f)));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    public static /* synthetic */ void IOI(float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = fArr.length;
        }
        oOIx(fArr, i, i2);
    }

    public static <T> void IOOXOOOOo(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Comparator<? super T> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    @kotlin.OOXIXo(message = "Use maxByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Short IOOoXo0Ix(short[] sArr, Oox.oOoXoXO<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        int xX0Ox = ArraysKt___ArraysKt.xX0Ox(sArr);
        if (xX0Ox == 0) {
            return Short.valueOf(s);
        }
        R invoke = selector.invoke(Short.valueOf(s));
        oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox).iterator();
        while (it.hasNext()) {
            short s2 = sArr[it.nextInt()];
            R invoke2 = selector.invoke(Short.valueOf(s2));
            if (invoke.compareTo(invoke2) < 0) {
                s = s2;
                invoke = invoke2;
            }
        }
        return Short.valueOf(s);
    }

    public static final void IOXOxOII(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (sArr.length > 1) {
            Arrays.sort(sArr);
        }
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigInteger")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final BigInteger IOo0(long[] jArr, Oox.oOoXoXO<? super Long, ? extends BigInteger> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        for (long j : jArr) {
            valueOf = valueOf.add(selector.invoke(Long.valueOf(j)));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @XO0OX.xxIXOIIO(name = "copyOfRangeInline")
    @xx0o0O.XO
    public static final char[] IOoo(char[] cArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
            return xXoOI00O(cArr, i, i2);
        }
        if (i2 <= cArr.length) {
            char[] copyOfRange = Arrays.copyOfRange(cArr, i, i2);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOfRange);
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + cArr.length);
    }

    @OXOo.OOXIXo
    public static final <T extends Comparable<? super T>> SortedSet<T> IOooo0o(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.IxOxxxIOI(tArr, new TreeSet());
    }

    @OXOo.OOXIXo
    public static final short[] IXIxx0(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Collection<Short> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        int length = sArr.length;
        short[] copyOf = Arrays.copyOf(sArr, elements.size() + length);
        Iterator<Short> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().shortValue();
            length++;
        }
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @xx0o0O.XO
    public static final <T> T[] IXO(T[] tArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i);
        kotlin.jvm.internal.IIX0o.oO(tArr2, "copyOf(...)");
        return tArr2;
    }

    @OXOo.OOXIXo
    public static byte[] IXX(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo byte[] elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        int length = bArr.length;
        int length2 = elements.length;
        byte[] copyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @OXOo.OOXIXo
    public static short[] IXXIXx00I(@OXOo.OOXIXo short[] sArr, short s) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        int length = sArr.length;
        short[] copyOf = Arrays.copyOf(sArr, length + 1);
        copyOf[length] = s;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @kotlin.OOXIXo(message = "Use minOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Short IXoIo(short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        return ArraysKt___ArraysKt.oxOO0Ix(sArr);
    }

    @OXOo.OOXIXo
    public static final long[] IXxOIOO(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Collection<Long> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, elements.size() + length);
        Iterator<Long> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().longValue();
            length++;
        }
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @OXOo.OOXIXo
    public static List<Integer> IXxxXO(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return new I0Io(iArr);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final boolean Io(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    @xx0o0O.XO
    public static final char[] IoIOOxIIo(char[] cArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        char[] copyOf = Arrays.copyOf(cArr, i);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static /* synthetic */ int IoOoX(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        return XIxXXX0x0(objArr, obj, i, i2);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final String IoOoo(byte[] bArr) {
        String arrays = Arrays.toString(bArr);
        kotlin.jvm.internal.IIX0o.oO(arrays, "toString(...)");
        return arrays;
    }

    @OXOo.OOXIXo
    public static final char[] IoX(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo char[] elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        int length = cArr.length;
        int length2 = elements.length;
        char[] copyOf = Arrays.copyOf(cArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @xx0o0O.XO
    public static final boolean[] IoXIXo(boolean[] zArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        boolean[] copyOf = Arrays.copyOf(zArr, i);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static /* synthetic */ void IoXO0XoX(long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = jArr.length;
        }
        I0OO(jArr, i, i2);
    }

    public static /* synthetic */ void IoxOx(Object[] objArr, Comparator comparator, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        XXx0OXXXo(objArr, comparator, i, i2);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final String Ioxxx(long[] jArr) {
        String arrays = Arrays.toString(jArr);
        kotlin.jvm.internal.IIX0o.oO(arrays, "toString(...)");
        return arrays;
    }

    @kotlin.OOXIXo(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Character Ix0(char[] cArr, Comparator comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return ArraysKt___ArraysKt.xo00oox(cArr, comparator);
    }

    @xx0o0O.XO
    public static final short[] Ix00oIoI(short[] sArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        short[] copyOf = Arrays.copyOf(sArr, i);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @kotlin.OOXIXo(message = "Use minWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Float Ix0x(float[] fArr, Comparator comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return ArraysKt___ArraysKt.xoOo0O0x(fArr, comparator);
    }

    @kotlin.OOXIXo(message = "Use minByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Short IxI(short[] sArr, Oox.oOoXoXO<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        int xX0Ox = ArraysKt___ArraysKt.xX0Ox(sArr);
        if (xX0Ox == 0) {
            return Short.valueOf(s);
        }
        R invoke = selector.invoke(Short.valueOf(s));
        oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox).iterator();
        while (it.hasNext()) {
            short s2 = sArr[it.nextInt()];
            R invoke2 = selector.invoke(Short.valueOf(s2));
            if (invoke.compareTo(invoke2) > 0) {
                s = s2;
                invoke = invoke2;
            }
        }
        return Short.valueOf(s);
    }

    @xx0o0O.XO
    public static final long[] IxIX0I(long[] jArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        long[] copyOf = Arrays.copyOf(jArr, i);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @kotlin.OOXIXo(message = "Use maxByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Double IxIo(double[] dArr, Oox.oOoXoXO<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        int OIO = ArraysKt___ArraysKt.OIO(dArr);
        if (OIO == 0) {
            return Double.valueOf(d);
        }
        R invoke = selector.invoke(Double.valueOf(d));
        oOXoIIIo it = new X0.oOoXoXO(1, OIO).iterator();
        while (it.hasNext()) {
            double d2 = dArr[it.nextInt()];
            R invoke2 = selector.invoke(Double.valueOf(d2));
            if (invoke.compareTo(invoke2) < 0) {
                d = d2;
                invoke = invoke2;
            }
        }
        return Double.valueOf(d);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T extends Comparable<? super T>> void IxO0Oxo(@OXOo.OOXIXo T[] tArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        Arrays.sort(tArr, i, i2);
    }

    public static final void IxX00(@OXOo.OOXIXo double[] dArr, double d, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        Arrays.fill(dArr, i, i2, d);
    }

    @xx0o0O.XO
    public static final byte[] O0(byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @xx0o0O.XO
    public static final short O00(short[] sArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        return sArr[i];
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    public static byte[] O00XxXI(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo byte[] destination, int i, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        System.arraycopy(bArr, i2, destination, i, i3 - i2);
        return destination;
    }

    @xx0o0O.XO
    public static final boolean[] O0IxXx(boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        boolean[] copyOf = Arrays.copyOf(zArr, zArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @OXOo.OOXIXo
    public static float[] O0O0Io00X(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo float[] elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        int length = fArr.length;
        int length2 = elements.length;
        float[] copyOf = Arrays.copyOf(fArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @kotlin.OOXIXo(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Short O0OOX0IIx(short[] sArr, Comparator comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return ArraysKt___ArraysKt.IXIO(sArr, comparator);
    }

    public static /* synthetic */ long[] O0X(long[] jArr, long[] jArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = jArr.length;
        }
        return I0(jArr, jArr2, i, i2, i3);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int O0Xx(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    @OXOo.OOXIXo
    public static byte[] O0o0(@OXOo.OOXIXo byte[] bArr, byte b) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        int length = bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, length + 1);
        copyOf[length] = b;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @kotlin.OOXIXo(message = "Use minOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Float O0x(float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return ArraysKt___ArraysKt.x0I0oOo0(fArr);
    }

    @OXOo.OOXIXo
    public static <T> T[] O0xO0(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo T[] elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        int length = tArr.length;
        int length2 = elements.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + length2);
        System.arraycopy(elements, 0, tArr2, length, length2);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(tArr2);
        return tArr2;
    }

    public static final int O0xOxO(@OXOo.OOXIXo float[] fArr, float f, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return Arrays.binarySearch(fArr, i, i2, f);
    }

    public static void O0xxXxI(@OXOo.OOXIXo byte[] bArr, byte b, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        Arrays.fill(bArr, i, i2, b);
    }

    @XO0OX.xxIXOIIO(name = "contentDeepToStringNullable")
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> String OI0(T[] tArr) {
        if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
            return oOoXoXO.II0XooXoX(tArr);
        }
        String deepToString = Arrays.deepToString(tArr);
        kotlin.jvm.internal.IIX0o.oO(deepToString, "deepToString(...)");
        return deepToString;
    }

    public static final void OI0IXox(@OXOo.OOXIXo char[] cArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        Arrays.sort(cArr, i, i2);
    }

    @OXOo.OOXIXo
    public static Double[] OIII0O(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        Double[] dArr2 = new Double[dArr.length];
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return dArr2;
    }

    @OXOo.OOXIXo
    public static int[] OIIXOxo(@OXOo.OOXIXo int[] iArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, length + 1);
        copyOf[length] = i;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @xx0o0O.XO
    public static final int[] OIOoIIOIx(int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @kotlin.OOXIXo(message = "Use minWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Byte OIoxIx(byte[] bArr, Comparator comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return ArraysKt___ArraysKt.oxXxX000(bArr, comparator);
    }

    @xx0o0O.XO
    public static final int OIx00oxx(int[] iArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return iArr[i];
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigDecimal")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final BigDecimal OIx0xoOo(int[] iArr, Oox.oOoXoXO<? super Integer, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        for (int i : iArr) {
            valueOf = valueOf.add(selector.invoke(Integer.valueOf(i)));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @OXOo.OOXIXo
    public static final byte[] OIxI0O(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Collection<Byte> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        int length = bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, elements.size() + length);
        Iterator<Byte> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().byteValue();
            length++;
        }
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @OXOo.OOXIXo
    public static final SortedSet<Double> OIxOIX0II(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.IxXXoxI(dArr, new TreeSet());
    }

    @kotlin.OOXIXo(message = "Use minOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Integer OIxOX(int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return ArraysKt___ArraysKt.X0OxxX(iArr);
    }

    @kotlin.OOXIXo(message = "Use minOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Character OIxx0I0(char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return ArraysKt___ArraysKt.o0XIX(cArr);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int OO(boolean[] zArr) {
        return Arrays.hashCode(zArr);
    }

    @xx0o0O.XO
    public static final double OO0(double[] dArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return dArr[i];
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final String OO0x0xX(float[] fArr) {
        String arrays = Arrays.toString(fArr);
        kotlin.jvm.internal.IIX0o.oO(arrays, "toString(...)");
        return arrays;
    }

    @kotlin.OOXIXo(message = "Use maxOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Character OOIXx0x(char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return ArraysKt___ArraysKt.oOII0(cArr);
    }

    public static /* synthetic */ void OOOI(char[] cArr, char c, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        oxOXxoXII(cArr, c, i, i2);
    }

    public static /* synthetic */ void OOOox(int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = iArr.length;
        }
        o0xOIoxo(iArr, i, i2);
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    public static float[] OOXIxO0(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo float[] destination, int i, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        System.arraycopy(fArr, i2, destination, i, i3 - i2);
        return destination;
    }

    public static /* synthetic */ void OOxOI(boolean[] zArr, boolean z, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = zArr.length;
        }
        oo00(zArr, z, i, i2);
    }

    @kotlin.OOXIXo(message = "Use minWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Integer OOxOOxIO(int[] iArr, Comparator comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return ArraysKt___ArraysKt.XXIOoXOI(iArr, comparator);
    }

    @XO0OX.xxIXOIIO(name = "copyOfRangeInline")
    @xx0o0O.XO
    public static final short[] OX(short[] sArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
            return oXxOI0oIx(sArr, i, i2);
        }
        if (i2 <= sArr.length) {
            short[] copyOfRange = Arrays.copyOfRange(sArr, i, i2);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOfRange);
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + sArr.length);
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    public static final boolean[] OX00O0xII(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo boolean[] destination, int i, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        System.arraycopy(zArr, i2, destination, i, i3 - i2);
        return destination;
    }

    @OXOo.OOXIXo
    public static final <T> SortedSet<T> OX00o0X(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Comparator<? super T> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return (SortedSet) ArraysKt___ArraysKt.IxOxxxIOI(tArr, new TreeSet(comparator));
    }

    @kotlin.OOXIXo(message = "Use minByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Boolean OXIOoo0X0(boolean[] zArr, Oox.oOoXoXO<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        int XXoXOI = ArraysKt___ArraysKt.XXoXOI(zArr);
        if (XXoXOI == 0) {
            return Boolean.valueOf(z);
        }
        R invoke = selector.invoke(Boolean.valueOf(z));
        oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI).iterator();
        while (it.hasNext()) {
            boolean z2 = zArr[it.nextInt()];
            R invoke2 = selector.invoke(Boolean.valueOf(z2));
            if (invoke.compareTo(invoke2) > 0) {
                z = z2;
                invoke = invoke2;
            }
        }
        return Boolean.valueOf(z);
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super R>, R> C OXXoIoXI(@OXOo.OOXIXo Object[] objArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Class<R> klass) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(objArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(klass, "klass");
        for (Object obj : objArr) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @kotlin.OOXIXo(message = "Use minWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Double OXooXo(double[] dArr, Comparator comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return ArraysKt___ArraysKt.xIOOXX(dArr, comparator);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigDecimal")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final BigDecimal OXxx0OO(boolean[] zArr, Oox.oOoXoXO<? super Boolean, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        for (boolean z : zArr) {
            valueOf = valueOf.add(selector.invoke(Boolean.valueOf(z)));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @OXOo.OOXIXo
    public static final List<Float> Oo(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return new X0o0xo(fArr);
    }

    public static /* synthetic */ void OoI0OO(double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = dArr.length;
        }
        oXIoIo(dArr, i, i2);
    }

    @OXOo.OOXIXo
    public static double[] OoIXo(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo double[] elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        int length = dArr.length;
        int length2 = elements.length;
        double[] copyOf = Arrays.copyOf(dArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @xx0o0O.XO
    public static final float[] OoO(float[] fArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        float[] copyOf = Arrays.copyOf(fArr, i);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @xx0o0O.XO
    public static final float OooI(float[] fArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return fArr[i];
    }

    @kotlin.OOXIXo(message = "Use minOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Double OooO0XOx(double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return ArraysKt___ArraysKt.xOoOx0o(dArr);
    }

    public static final void Oox(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (cArr.length > 1) {
            Arrays.sort(cArr);
        }
    }

    @OXOo.OOXIXo
    public static final SortedSet<Boolean> OoxOxII(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.x00xO(zArr, new TreeSet());
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigInteger")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final BigInteger Ox00XOXoo(short[] sArr, Oox.oOoXoXO<? super Short, ? extends BigInteger> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        for (short s : sArr) {
            valueOf = valueOf.add(selector.invoke(Short.valueOf(s)));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    public static /* synthetic */ boolean[] Ox0O(boolean[] zArr, boolean[] zArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = zArr.length;
        }
        return OX00O0xII(zArr, zArr2, i, i2, i3);
    }

    public static final int OxI(@OXOo.OOXIXo double[] dArr, double d, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return Arrays.binarySearch(dArr, i, i2, d);
    }

    public static /* synthetic */ void OxIxx0(short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = sArr.length;
        }
        oXxOXOX(sArr, i, i2);
    }

    public static /* synthetic */ void OxO(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = iArr.length;
        }
        oX0I0O(iArr, i, i2, i3);
    }

    public static /* synthetic */ void OxXXx0X(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        O0xxXxI(bArr, b, i, i2);
    }

    @kotlin.OOXIXo(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Byte Oxo00O(byte[] bArr, Comparator comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return ArraysKt___ArraysKt.xOxXxx(bArr, comparator);
    }

    @XO0OX.xxIXOIIO(name = "copyOfRangeInline")
    @xx0o0O.XO
    public static final <T> T[] Oxx(T[] tArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
            return (T[]) IO0XoXxO(tArr, i, i2);
        }
        if (i2 <= tArr.length) {
            T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i, i2);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(tArr2);
            return tArr2;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + tArr.length);
    }

    @OXOo.OOXIXo
    public static List<Long> Oxx0xo(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        return new oxoX(jArr);
    }

    @OXOo.OOXIXo
    public static final List<Short> OxxIIOOXO(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        return new II0xO0(sArr);
    }

    @OXOo.OOXIXo
    public static final Byte[] Oxxo(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        Byte[] bArr2 = new Byte[bArr.length];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            bArr2[i] = Byte.valueOf(bArr[i]);
        }
        return bArr2;
    }

    public static final void X0(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (jArr.length > 1) {
            Arrays.sort(jArr);
        }
    }

    @xx0o0O.II0XooXoX
    @kotlin.oxxXoxO(version = "1.1")
    @XO0OX.xxIXOIIO(name = "contentDeepEqualsInline")
    @xx0o0O.XO
    public static final <T> boolean X00IoxXI(T[] tArr, T[] other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
            return oOoXoXO.Oxx0IOOO(tArr, other);
        }
        return Arrays.deepEquals(tArr, other);
    }

    public static final void X00IxOx(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length > 1) {
            Arrays.sort(dArr);
        }
    }

    public static /* synthetic */ void X00xOoXI(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length;
        }
        oX0ooo0I0(sArr, s, i, i2);
    }

    public static final int X0IIOO(@OXOo.OOXIXo int[] iArr, int i, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return Arrays.binarySearch(iArr, i2, i3, i);
    }

    @kotlin.OOXIXo(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Boolean X0IOOI(boolean[] zArr, Comparator comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return ArraysKt___ArraysKt.oOxx(zArr, comparator);
    }

    public static /* synthetic */ void X0O0I0(float[] fArr, float f, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length;
        }
        XO0o(fArr, f, i, i2);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigInteger")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final BigInteger X0OXX(char[] cArr, Oox.oOoXoXO<? super Character, ? extends BigInteger> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        for (char c : cArr) {
            valueOf = valueOf.add(selector.invoke(Character.valueOf(c)));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @kotlin.OOXIXo(message = "Use maxByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Boolean X0ooXIooI(boolean[] zArr, Oox.oOoXoXO<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        int XXoXOI = ArraysKt___ArraysKt.XXoXOI(zArr);
        if (XXoXOI == 0) {
            return Boolean.valueOf(z);
        }
        R invoke = selector.invoke(Boolean.valueOf(z));
        oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI).iterator();
        while (it.hasNext()) {
            boolean z2 = zArr[it.nextInt()];
            R invoke2 = selector.invoke(Boolean.valueOf(z2));
            if (invoke.compareTo(invoke2) < 0) {
                z = z2;
                invoke = invoke2;
            }
        }
        return Boolean.valueOf(z);
    }

    public static final void X0x(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (bArr.length > 1) {
            Arrays.sort(bArr);
        }
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    @XO0OX.xxIXOIIO(name = "copyOfRange")
    @kotlin.o0
    public static int[] X0xII0I(@OXOo.OOXIXo int[] iArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        OOXIXo.I0Io(i2, iArr.length);
        int[] copyOfRange = Arrays.copyOfRange(iArr, i, i2);
        kotlin.jvm.internal.IIX0o.oO(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    @OXOo.OOXIXo
    public static final float[] X0xOO(@OXOo.OOXIXo float[] fArr, float f) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        int length = fArr.length;
        float[] copyOf = Arrays.copyOf(fArr, length + 1);
        copyOf[length] = f;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    @XO0OX.xxIXOIIO(name = "copyOfRange")
    @kotlin.o0
    public static long[] X0xxXX0(@OXOo.OOXIXo long[] jArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        OOXIXo.I0Io(i2, jArr.length);
        long[] copyOfRange = Arrays.copyOfRange(jArr, i, i2);
        kotlin.jvm.internal.IIX0o.oO(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    @XO0OX.xxIXOIIO(name = "copyOfRangeInline")
    @xx0o0O.XO
    public static final byte[] XI(byte[] bArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
            return xxOXOOoIX(bArr, i, i2);
        }
        if (i2 <= bArr.length) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOfRange);
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + bArr.length);
    }

    public static final int XI0IXoo(@OXOo.OOXIXo long[] jArr, long j, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        return Arrays.binarySearch(jArr, i, i2, j);
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    public static final double[] XI0oooXX(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo double[] destination, int i, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        System.arraycopy(dArr, i2, destination, i, i3 - i2);
        return destination;
    }

    @kotlin.OOXIXo(message = "Use minWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Long XIOOI(long[] jArr, Comparator comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return ArraysKt___ArraysKt.O0OIo(jArr, comparator);
    }

    public static /* synthetic */ double[] XIXIX(double[] dArr, double[] dArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = dArr.length;
        }
        return XI0oooXX(dArr, dArr2, i, i2, i3);
    }

    @xx0o0O.XO
    public static final float[] XIXIxO(float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final String XIo0oOXIx(int[] iArr) {
        String arrays = Arrays.toString(iArr);
        kotlin.jvm.internal.IIX0o.oO(arrays, "toString(...)");
        return arrays;
    }

    @OXOo.OOXIXo
    public static final boolean[] XIxO(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Collection<Boolean> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        int length = zArr.length;
        boolean[] copyOf = Arrays.copyOf(zArr, elements.size() + length);
        Iterator<Boolean> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().booleanValue();
            length++;
        }
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    public static final <T> int XIxXXX0x0(@OXOo.OOXIXo T[] tArr, T t, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return Arrays.binarySearch(tArr, i, i2, t);
    }

    @OXOo.OOXIXo
    public static final <R> List<R> XO00XOO(@OXOo.OOXIXo Object[] objArr, @OXOo.OOXIXo Class<R> klass) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(objArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(klass, "klass");
        return (List) OXXoIoXI(objArr, new ArrayList(), klass);
    }

    public static final void XO0OX(@OXOo.OOXIXo byte[] bArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        Arrays.sort(bArr, i, i2);
    }

    public static final void XO0o(@OXOo.OOXIXo float[] fArr, float f, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        Arrays.fill(fArr, i, i2, f);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigInteger")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final BigInteger XOOO0O(boolean[] zArr, Oox.oOoXoXO<? super Boolean, ? extends BigInteger> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        for (boolean z : zArr) {
            valueOf = valueOf.add(selector.invoke(Boolean.valueOf(z)));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @OXOo.OOXIXo
    public static final char[] XOo0(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Collection<Character> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        int length = cArr.length;
        char[] copyOf = Arrays.copyOf(cArr, elements.size() + length);
        Iterator<Character> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().charValue();
            length++;
        }
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @xx0o0O.II0XooXoX
    @kotlin.oxxXoxO(version = "1.1")
    @XO0OX.xxIXOIIO(name = "contentDeepToStringInline")
    @xx0o0O.XO
    public static final <T> String XOxIOxOx(T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
            return oOoXoXO.II0XooXoX(tArr);
        }
        String deepToString = Arrays.deepToString(tArr);
        kotlin.jvm.internal.IIX0o.oO(deepToString, "deepToString(...)");
        return deepToString;
    }

    @kotlin.OOXIXo(message = "Use maxByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Integer XOxoX(int[] iArr, Oox.oOoXoXO<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        int oOIoXOoI = ArraysKt___ArraysKt.oOIoXOoI(iArr);
        if (oOIoXOoI == 0) {
            return Integer.valueOf(i);
        }
        R invoke = selector.invoke(Integer.valueOf(i));
        oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI).iterator();
        while (it.hasNext()) {
            int i2 = iArr[it.nextInt()];
            R invoke2 = selector.invoke(Integer.valueOf(i2));
            if (invoke.compareTo(invoke2) < 0) {
                i = i2;
                invoke = invoke2;
            }
        }
        return Integer.valueOf(i);
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    @XO0OX.xxIXOIIO(name = "copyOfRange")
    @kotlin.o0
    public static final boolean[] XOxxooXI(@OXOo.OOXIXo boolean[] zArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        OOXIXo.I0Io(i2, zArr.length);
        boolean[] copyOfRange = Arrays.copyOfRange(zArr, i, i2);
        kotlin.jvm.internal.IIX0o.oO(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final boolean XX(double[] dArr, double[] dArr2) {
        return Arrays.equals(dArr, dArr2);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int XX0(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final String XX0xXo(short[] sArr) {
        String arrays = Arrays.toString(sArr);
        kotlin.jvm.internal.IIX0o.oO(arrays, "toString(...)");
        return arrays;
    }

    public static /* synthetic */ void XXIoX0(char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = cArr.length;
        }
        OI0IXox(cArr, i, i2);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigDecimal")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final BigDecimal XXO0(long[] jArr, Oox.oOoXoXO<? super Long, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        for (long j : jArr) {
            valueOf = valueOf.add(selector.invoke(Long.valueOf(j)));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @XO0OX.xxIXOIIO(name = "copyOfRangeInline")
    @xx0o0O.XO
    public static final int[] XXXI(int[] iArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
            return X0xII0I(iArr, i, i2);
        }
        if (i2 <= iArr.length) {
            int[] copyOfRange = Arrays.copyOfRange(iArr, i, i2);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOfRange);
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + iArr.length);
    }

    @OXOo.OOXIXo
    public static Integer[] XXoO0oX(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        Integer[] numArr = new Integer[iArr.length];
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    @xx0o0O.XO
    public static final long[] XXoOx0(long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @OXOo.OOXIXo
    public static final Character[] XXooOOI(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        Character[] chArr = new Character[cArr.length];
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            chArr[i] = Character.valueOf(cArr[i]);
        }
        return chArr;
    }

    public static final <T> void XXx0OXXXo(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Comparator<? super T> comparator, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        Arrays.sort(tArr, i, i2, comparator);
    }

    @kotlin.OOXIXo(message = "Use maxOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxOrNull()", imports = {}))
    @kotlin.oxxXoxO(version = "1.1")
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Float Xo(Float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return ArraysKt___ArraysKt.XOOXIXxxI(fArr);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int Xo0(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int XoI0Ixx0(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    @xx0o0O.XO
    public static final char XoIxOXIXo(char[] cArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return cArr[i];
    }

    public static <T> void XoOOx0IX(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    @kotlin.OOXIXo(message = "Use maxOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Short XoOxI0ox(short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        return ArraysKt___ArraysKt.oOoIxI0x(sArr);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final boolean XoX(long[] jArr, long[] jArr2) {
        return Arrays.equals(jArr, jArr2);
    }

    @kotlin.OOXIXo(message = "Use maxOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Byte XooIO0oo0(byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return ArraysKt___ArraysKt.IoOxoIx(bArr);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigInteger")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final BigInteger Xx(byte[] bArr, Oox.oOoXoXO<? super Byte, ? extends BigInteger> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        for (byte b : bArr) {
            valueOf = valueOf.add(selector.invoke(Byte.valueOf(b)));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigInteger")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final BigInteger Xx0(double[] dArr, Oox.oOoXoXO<? super Double, ? extends BigInteger> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        for (double d : dArr) {
            valueOf = valueOf.add(selector.invoke(Double.valueOf(d)));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    public static /* synthetic */ int Xx000oIo(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length;
        }
        return XxX0x0xxx(sArr, s, i, i2);
    }

    @OXOo.OOXIXo
    public static long[] XxI(@OXOo.OOXIXo long[] jArr, long j) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, length + 1);
        copyOf[length] = j;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @OXOo.OOXIXo
    public static final float[] XxIIOXIXx(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Collection<Float> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        int length = fArr.length;
        float[] copyOf = Arrays.copyOf(fArr, elements.size() + length);
        Iterator<Float> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().floatValue();
            length++;
        }
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigInteger")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T> BigInteger XxIOX(T[] tArr, Oox.oOoXoXO<? super T, ? extends BigInteger> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        for (T t : tArr) {
            valueOf = valueOf.add(selector.invoke(t));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @kotlin.OOXIXo(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Integer XxIo(int[] iArr, Comparator comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return ArraysKt___ArraysKt.X0Xxxoo(iArr, comparator);
    }

    public static final int XxX0x0xxx(@OXOo.OOXIXo short[] sArr, short s, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        return Arrays.binarySearch(sArr, i, i2, s);
    }

    @kotlin.OOXIXo(message = "Use minOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minOrNull()", imports = {}))
    @kotlin.oxxXoxO(version = "1.1")
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Double XxXX(Double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return ArraysKt___ArraysKt.OX0X(dArr);
    }

    @OXOo.OOXIXo
    public static Float[] Xxx0oXX(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        Float[] fArr2 = new Float[fArr.length];
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final boolean o0(char[] cArr, char[] cArr2) {
        return Arrays.equals(cArr, cArr2);
    }

    public static final int o00(@OXOo.OOXIXo char[] cArr, char c, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return Arrays.binarySearch(cArr, i, i2, c);
    }

    @kotlin.OOXIXo(message = "Use minByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T o00xOoIO(T[] tArr, Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int o0IXO = ArraysKt___ArraysKt.o0IXO(tArr);
        if (o0IXO != 0) {
            R invoke = selector.invoke(t);
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO).iterator();
            while (it.hasNext()) {
                T t2 = tArr[it.nextInt()];
                R invoke2 = selector.invoke(t2);
                if (invoke.compareTo(invoke2) > 0) {
                    t = t2;
                    invoke = invoke2;
                }
            }
        }
        return t;
    }

    @xx0o0O.XO
    public static final byte o0IXXIx(byte[] bArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return bArr[i];
    }

    @kotlin.OOXIXo(message = "Use minByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Integer o0OO0(int[] iArr, Oox.oOoXoXO<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        int oOIoXOoI = ArraysKt___ArraysKt.oOIoXOoI(iArr);
        if (oOIoXOoI == 0) {
            return Integer.valueOf(i);
        }
        R invoke = selector.invoke(Integer.valueOf(i));
        oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI).iterator();
        while (it.hasNext()) {
            int i2 = iArr[it.nextInt()];
            R invoke2 = selector.invoke(Integer.valueOf(i2));
            if (invoke.compareTo(invoke2) > 0) {
                i = i2;
                invoke = invoke2;
            }
        }
        return Integer.valueOf(i);
    }

    @kotlin.OOXIXo(message = "Use minOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minOrNull()", imports = {}))
    @kotlin.oxxXoxO(version = "1.1")
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Float o0Oo(Float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return ArraysKt___ArraysKt.xXx0IX0(fArr);
    }

    public static /* synthetic */ void o0Xo(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        xX(objArr, obj, i, i2);
    }

    @xx0o0O.XO
    public static final double[] o0oIxOo(double[] dArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        double[] copyOf = Arrays.copyOf(dArr, i);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @OXOo.OOXIXo
    public static final SortedSet<Float> o0oIxXOx(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.xO0II(fArr, new TreeSet());
    }

    public static /* synthetic */ void o0oxo0oI(double[] dArr, double d, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length;
        }
        IxX00(dArr, d, i, i2);
    }

    @OXOo.OOXIXo
    public static final SortedSet<Character> o0xIIX0(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.IOIXIoo(cArr, new TreeSet());
    }

    public static /* synthetic */ void o0xIoII(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        XO0OX(bArr, i, i2);
    }

    public static void o0xOIoxo(@OXOo.OOXIXo int[] iArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        Arrays.sort(iArr, i, i2);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final String o0xxxXXxX(boolean[] zArr) {
        String arrays = Arrays.toString(zArr);
        kotlin.jvm.internal.IIX0o.oO(arrays, "toString(...)");
        return arrays;
    }

    @xx0o0O.XO
    public static final short[] oI(short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @OXOo.OOXIXo
    public static final double[] oI0(@OXOo.OOXIXo double[] dArr, double d) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        int length = dArr.length;
        double[] copyOf = Arrays.copyOf(dArr, length + 1);
        copyOf[length] = d;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigDecimal")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final BigDecimal oI00o(double[] dArr, Oox.oOoXoXO<? super Double, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        for (double d : dArr) {
            valueOf = valueOf.add(selector.invoke(Double.valueOf(d)));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @OXOo.OOXIXo
    public static <T> List<T> oI0IIXIo(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        List<T> oIX0oI2 = x0XOIxOo.oIX0oI(tArr);
        kotlin.jvm.internal.IIX0o.oO(oIX0oI2, "asList(...)");
        return oIX0oI2;
    }

    @OXOo.OOXIXo
    public static final int[] oI0X0(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Collection<Integer> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, elements.size() + length);
        Iterator<Integer> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().intValue();
            length++;
        }
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @XO0OX.xxIXOIIO(name = "copyOfRangeInline")
    @xx0o0O.XO
    public static final double[] oIIxXoo(double[] dArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
            return x0OxxIOxX(dArr, i, i2);
        }
        if (i2 <= dArr.length) {
            double[] copyOfRange = Arrays.copyOfRange(dArr, i, i2);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOfRange);
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + dArr.length);
    }

    @OXOo.OOXIXo
    public static final Short[] oIX0o(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        Short[] shArr = new Short[sArr.length];
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            shArr[i] = Short.valueOf(sArr[i]);
        }
        return shArr;
    }

    @OXOo.OOXIXo
    public static int[] oIXoXx0(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo int[] elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        int length = iArr.length;
        int length2 = elements.length;
        int[] copyOf = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @OXOo.OOXIXo
    public static final List<Character> oO(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return new II0XooXoX(cArr);
    }

    @kotlin.OOXIXo(message = "Use minByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Double oO0IXx(double[] dArr, Oox.oOoXoXO<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        int OIO = ArraysKt___ArraysKt.OIO(dArr);
        if (OIO == 0) {
            return Double.valueOf(d);
        }
        R invoke = selector.invoke(Double.valueOf(d));
        oOXoIIIo it = new X0.oOoXoXO(1, OIO).iterator();
        while (it.hasNext()) {
            double d2 = dArr[it.nextInt()];
            R invoke2 = selector.invoke(Double.valueOf(d2));
            if (invoke.compareTo(invoke2) > 0) {
                d = d2;
                invoke = invoke2;
            }
        }
        return Double.valueOf(d);
    }

    @OXOo.OOXIXo
    public static final SortedSet<Byte> oO0OX0(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.xXxxOxI0I(bArr, new TreeSet());
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigDecimal")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final BigDecimal oOIXoIXXI(char[] cArr, Oox.oOoXoXO<? super Character, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        for (char c : cArr) {
            valueOf = valueOf.add(selector.invoke(Character.valueOf(c)));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    public static void oOIx(@OXOo.OOXIXo float[] fArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        Arrays.sort(fArr, i, i2);
    }

    public static /* synthetic */ int oOXoIIIo(Object[] objArr, Object obj, Comparator comparator, int i, int i2, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = objArr.length;
        }
        return xxX(objArr, obj, comparator, i, i2);
    }

    public static /* synthetic */ int[] oOo(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = iArr.length;
        }
        return IIxOXoOo0(iArr, iArr2, i, i2, i3);
    }

    @xx0o0O.XO
    public static final <T> T[] oOoIIO0(T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.IIX0o.oO(tArr2, "copyOf(...)");
        return tArr2;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int oX(double[] dArr) {
        return Arrays.hashCode(dArr);
    }

    @kotlin.OOXIXo(message = "Use maxByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Byte oX000x(byte[] bArr, Oox.oOoXoXO<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        int xxXIIXIxx = ArraysKt___ArraysKt.xxXIIXIxx(bArr);
        if (xxXIIXIxx == 0) {
            return Byte.valueOf(b);
        }
        R invoke = selector.invoke(Byte.valueOf(b));
        oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx).iterator();
        while (it.hasNext()) {
            byte b2 = bArr[it.nextInt()];
            R invoke2 = selector.invoke(Byte.valueOf(b2));
            if (invoke.compareTo(invoke2) < 0) {
                b = b2;
                invoke = invoke2;
            }
        }
        return Byte.valueOf(b);
    }

    public static void oX0I0O(@OXOo.OOXIXo int[] iArr, int i, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        Arrays.fill(iArr, i2, i3, i);
    }

    public static void oX0ooo0I0(@OXOo.OOXIXo short[] sArr, short s, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        Arrays.fill(sArr, i, i2, s);
    }

    public static /* synthetic */ float[] oXIO0o0XI(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = fArr.length;
        }
        return OOXIxO0(fArr, fArr2, i, i2, i3);
    }

    public static final void oXIoIo(@OXOo.OOXIXo double[] dArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        Arrays.sort(dArr, i, i2);
    }

    @XO0OX.xxIXOIIO(name = "copyOfRangeInline")
    @xx0o0O.XO
    public static final boolean[] oXIoO(boolean[] zArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
            return XOxxooXI(zArr, i, i2);
        }
        if (i2 <= zArr.length) {
            boolean[] copyOfRange = Arrays.copyOfRange(zArr, i, i2);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOfRange);
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + zArr.length);
    }

    @kotlin.OOXIXo(message = "Use maxOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Integer oXO0oOx0(int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return ArraysKt___ArraysKt.O0oXIX0oX(iArr);
    }

    @XO0OX.xxIXOIIO(name = "copyOfRangeInline")
    @xx0o0O.XO
    public static final float[] oXX0IoI(float[] fArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
            return x0(fArr, i, i2);
        }
        if (i2 <= fArr.length) {
            float[] copyOfRange = Arrays.copyOfRange(fArr, i, i2);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOfRange);
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + fArr.length);
    }

    @kotlin.OOXIXo(message = "Use minWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Character oXoXxOo(char[] cArr, Comparator comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return ArraysKt___ArraysKt.xxXIO0OO(cArr, comparator);
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    @XO0OX.xxIXOIIO(name = "copyOfRange")
    @kotlin.o0
    public static short[] oXxOI0oIx(@OXOo.OOXIXo short[] sArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        OOXIXo.I0Io(i2, sArr.length);
        short[] copyOfRange = Arrays.copyOfRange(sArr, i, i2);
        kotlin.jvm.internal.IIX0o.oO(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static final void oXxOXOX(@OXOo.OOXIXo short[] sArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        Arrays.sort(sArr, i, i2);
    }

    @kotlin.OOXIXo(message = "Use maxOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Double oXxx000(double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return ArraysKt___ArraysKt.IIOx(dArr);
    }

    public static /* synthetic */ int oo(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length;
        }
        return XI0IXoo(jArr, j, i, i2);
    }

    public static final void oo00(@OXOo.OOXIXo boolean[] zArr, boolean z, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        Arrays.fill(zArr, i, i2, z);
    }

    @kotlin.OOXIXo(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Object oo0oIXo(Object[] objArr, Comparator comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(objArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return ArraysKt___ArraysKt.XIXOxI0(objArr, comparator);
    }

    public static /* synthetic */ int oo0xXOI0I(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = iArr.length;
        }
        return X0IIOO(iArr, i, i2, i3);
    }

    @kotlin.OOXIXo(message = "Use minByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Float ooO0oXxI(float[] fArr, Oox.oOoXoXO<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        int oXIX = ArraysKt___ArraysKt.oXIX(fArr);
        if (oXIX == 0) {
            return Float.valueOf(f);
        }
        R invoke = selector.invoke(Float.valueOf(f));
        oOXoIIIo it = new X0.oOoXoXO(1, oXIX).iterator();
        while (it.hasNext()) {
            float f2 = fArr[it.nextInt()];
            R invoke2 = selector.invoke(Float.valueOf(f2));
            if (invoke.compareTo(invoke2) > 0) {
                f = f2;
                invoke = invoke2;
            }
        }
        return Float.valueOf(f);
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    public static <T> T[] ooOx(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo T[] destination, int i, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        System.arraycopy(tArr, i2, destination, i, i3 - i2);
        return destination;
    }

    public static /* synthetic */ int ooXIXxIX(double[] dArr, double d, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length;
        }
        return OxI(dArr, d, i, i2);
    }

    @kotlin.OOXIXo(message = "Use minWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Object oox000IX(Object[] objArr, Comparator comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(objArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return ArraysKt___ArraysKt.xoOX(objArr, comparator);
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    public static final char[] ox(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo char[] destination, int i, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        System.arraycopy(cArr, i2, destination, i, i3 - i2);
        return destination;
    }

    @OXOo.OOXIXo
    public static final SortedSet<Short> ox0(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.oOX0oo0(sArr, new TreeSet());
    }

    @kotlin.OOXIXo(message = "Use minWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Short ox0I(short[] sArr, Comparator comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return ArraysKt___ArraysKt.OO0X(sArr, comparator);
    }

    @xx0o0O.XO
    public static final double[] oxIIX0o(double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @kotlin.OOXIXo(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Long oxIO0IIo(long[] jArr, Comparator comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return ArraysKt___ArraysKt.xI0XO0Ix(jArr, comparator);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigDecimal")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final BigDecimal oxOIoIx(float[] fArr, Oox.oOoXoXO<? super Float, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        for (float f : fArr) {
            valueOf = valueOf.add(selector.invoke(Float.valueOf(f)));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    public static final void oxOXxoXII(@OXOo.OOXIXo char[] cArr, char c, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        Arrays.fill(cArr, i, i2, c);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> boolean oxXx0IX(T[] tArr, T[] tArr2) {
        return Arrays.equals(tArr, tArr2);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final boolean oxxXoxO(int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    @XO0OX.xxIXOIIO(name = "copyOfRange")
    @kotlin.o0
    public static final float[] x0(@OXOo.OOXIXo float[] fArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        OOXIXo.I0Io(i2, fArr.length);
        float[] copyOfRange = Arrays.copyOfRange(fArr, i, i2);
        kotlin.jvm.internal.IIX0o.oO(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static void x00IOx(@OXOo.OOXIXo long[] jArr, long j, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        Arrays.fill(jArr, i, i2, j);
    }

    @OXOo.OOXIXo
    public static final char[] x00X0xoXO(@OXOo.OOXIXo char[] cArr, char c) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        int length = cArr.length;
        char[] copyOf = Arrays.copyOf(cArr, length + 1);
        copyOf[length] = c;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @xx0o0O.XO
    public static final int[] x0OIX00oO(int[] iArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        int[] copyOf = Arrays.copyOf(iArr, i);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @kotlin.OOXIXo(message = "Use minOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Long x0OOI(long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        return ArraysKt___ArraysKt.OXI0O(jArr);
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    @XO0OX.xxIXOIIO(name = "copyOfRange")
    @kotlin.o0
    public static final double[] x0OxxIOxX(@OXOo.OOXIXo double[] dArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        OOXIXo.I0Io(i2, dArr.length);
        double[] copyOfRange = Arrays.copyOfRange(dArr, i, i2);
        kotlin.jvm.internal.IIX0o.oO(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    @OXOo.OOXIXo
    public static final List<Byte> x0XOIxOo(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return new oIX0oI(bArr);
    }

    @XO0OX.xxIXOIIO(name = "contentDeepHashCodeNullable")
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> int x0o(T[] tArr) {
        if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
            return OOXIXo.II0xO0(tArr);
        }
        return Arrays.deepHashCode(tArr);
    }

    @kotlin.OOXIXo(message = "Use minByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Byte x0oox0(byte[] bArr, Oox.oOoXoXO<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        int xxXIIXIxx = ArraysKt___ArraysKt.xxXIIXIxx(bArr);
        if (xxXIIXIxx == 0) {
            return Byte.valueOf(b);
        }
        R invoke = selector.invoke(Byte.valueOf(b));
        oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx).iterator();
        while (it.hasNext()) {
            byte b2 = bArr[it.nextInt()];
            R invoke2 = selector.invoke(Byte.valueOf(b2));
            if (invoke.compareTo(invoke2) > 0) {
                b = b2;
                invoke = invoke2;
            }
        }
        return Byte.valueOf(b);
    }

    @kotlin.OOXIXo(message = "Use maxByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Float x0oxIIIX(float[] fArr, Oox.oOoXoXO<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        int oXIX = ArraysKt___ArraysKt.oXIX(fArr);
        if (oXIX == 0) {
            return Float.valueOf(f);
        }
        R invoke = selector.invoke(Float.valueOf(f));
        oOXoIIIo it = new X0.oOoXoXO(1, oXIX).iterator();
        while (it.hasNext()) {
            float f2 = fArr[it.nextInt()];
            R invoke2 = selector.invoke(Float.valueOf(f2));
            if (invoke.compareTo(invoke2) < 0) {
                f = f2;
                invoke = invoke2;
            }
        }
        return Float.valueOf(f);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final String x0xO(double[] dArr) {
        String arrays = Arrays.toString(dArr);
        kotlin.jvm.internal.IIX0o.oO(arrays, "toString(...)");
        return arrays;
    }

    @OXOo.OOXIXo
    public static List<Double> x0xO0oo(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return new XO(dArr);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigDecimal")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T> BigDecimal x0xOIoO(T[] tArr, Oox.oOoXoXO<? super T, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        for (T t : tArr) {
            valueOf = valueOf.add(selector.invoke(t));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    public static /* synthetic */ int xI(float[] fArr, float f, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length;
        }
        return O0xOxO(fArr, f, i, i2);
    }

    @OXOo.OOXIXo
    public static final SortedSet<Long> xI0OXooO(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.ooxIIII(jArr, new TreeSet());
    }

    @xx0o0O.XO
    public static final char[] xI0oxI00(char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @xx0o0O.II0XooXoX
    @kotlin.oxxXoxO(version = "1.1")
    @XO0OX.xxIXOIIO(name = "contentDeepHashCodeInline")
    @xx0o0O.XO
    public static final <T> int xII(T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
            return OOXIXo.II0xO0(tArr);
        }
        return Arrays.deepHashCode(tArr);
    }

    @kotlin.OOXIXo(message = "Use maxByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Character xIOXX(char[] cArr, Oox.oOoXoXO<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        int IoOIIOx = ArraysKt___ArraysKt.IoOIIOx(cArr);
        if (IoOIIOx == 0) {
            return Character.valueOf(c);
        }
        R invoke = selector.invoke(Character.valueOf(c));
        oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx).iterator();
        while (it.hasNext()) {
            char c2 = cArr[it.nextInt()];
            R invoke2 = selector.invoke(Character.valueOf(c2));
            if (invoke.compareTo(invoke2) < 0) {
                c = c2;
                invoke = invoke2;
            }
        }
        return Character.valueOf(c);
    }

    @kotlin.OOXIXo(message = "Use maxByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Long xIXIOX(long[] jArr, Oox.oOoXoXO<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int IOXI = ArraysKt___ArraysKt.IOXI(jArr);
        if (IOXI == 0) {
            return Long.valueOf(j);
        }
        R invoke = selector.invoke(Long.valueOf(j));
        oOXoIIIo it = new X0.oOoXoXO(1, IOXI).iterator();
        while (it.hasNext()) {
            long j2 = jArr[it.nextInt()];
            R invoke2 = selector.invoke(Long.valueOf(j2));
            if (invoke.compareTo(invoke2) < 0) {
                j = j2;
                invoke = invoke2;
            }
        }
        return Long.valueOf(j);
    }

    @kotlin.OOXIXo(message = "Use minWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Boolean xIXOoI(boolean[] zArr, Comparator comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return ArraysKt___ArraysKt.Ox0OXI(zArr, comparator);
    }

    @xx0o0O.XO
    public static final long xIXX(long[] jArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        return jArr[i];
    }

    public static /* synthetic */ void xIXoO0Xx(Object[] objArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = objArr.length;
        }
        xx00oOoI(objArr, i, i2);
    }

    @OXOo.OOXIXo
    public static final double[] xIoXXXIXo(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Collection<Double> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        int length = dArr.length;
        double[] copyOf = Arrays.copyOf(dArr, elements.size() + length);
        Iterator<Double> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().doubleValue();
            length++;
        }
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @kotlin.OOXIXo(message = "Use maxOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Float xIx(float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return ArraysKt___ArraysKt.oo0I(fArr);
    }

    @kotlin.OOXIXo(message = "Use maxOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Comparable xIx0XO(Comparable[] comparableArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparableArr, "<this>");
        return ArraysKt___ArraysKt.xXo0X0(comparableArr);
    }

    @kotlin.OOXIXo(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Float xIxooxXX(float[] fArr, Comparator comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return ArraysKt___ArraysKt.IOx(fArr, comparator);
    }

    @OXOo.OOXIXo
    public static Long[] xOI0(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        Long[] lArr = new Long[jArr.length];
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    public static /* synthetic */ char[] xOOOX(char[] cArr, char[] cArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = cArr.length;
        }
        return ox(cArr, cArr2, i, i2, i3);
    }

    @kotlin.OOXIXo(message = "Use maxOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxOrNull()", imports = {}))
    @kotlin.oxxXoxO(version = "1.1")
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Double xOOxI(Double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return ArraysKt___ArraysKt.IOX0Xo(dArr);
    }

    @xx0o0O.XO
    public static final boolean xOOxIO(boolean[] zArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        return zArr[i];
    }

    public static final void xOoIIIoXI(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length > 1) {
            Arrays.sort(fArr);
        }
    }

    public static /* synthetic */ short[] xOoOIoI(short[] sArr, short[] sArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = sArr.length;
        }
        return xoO0xx0(sArr, sArr2, i, i2, i3);
    }

    @OXOo.OOXIXo
    public static final SortedSet<Integer> xOx(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.xIXXxOoo(iArr, new TreeSet());
    }

    public static final void xOxOoo(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (iArr.length > 1) {
            Arrays.sort(iArr);
        }
    }

    @xx0o0O.XO
    public static final <T extends Comparable<? super T>> void xOxxXO(T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        XoOOx0IX(tArr);
    }

    public static <T> void xX(@OXOo.OOXIXo T[] tArr, T t, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        Arrays.fill(tArr, i, i2, t);
    }

    public static /* synthetic */ byte[] xX0IIXIx0(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length;
        }
        return O00XxXI(bArr, bArr2, i, i2, i3);
    }

    @OXOo.OOXIXo
    public static long[] xX0ox(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo long[] elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        int length = jArr.length;
        int length2 = elements.length;
        long[] copyOf = Arrays.copyOf(jArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @OXOo.OOXIXo
    public static Boolean[] xXIX0Xo(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        Boolean[] boolArr = new Boolean[zArr.length];
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final boolean xXOx(boolean[] zArr, boolean[] zArr2) {
        return Arrays.equals(zArr, zArr2);
    }

    @kotlin.OOXIXo(message = "Use minByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Long xXo(long[] jArr, Oox.oOoXoXO<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int IOXI = ArraysKt___ArraysKt.IOXI(jArr);
        if (IOXI == 0) {
            return Long.valueOf(j);
        }
        R invoke = selector.invoke(Long.valueOf(j));
        oOXoIIIo it = new X0.oOoXoXO(1, IOXI).iterator();
        while (it.hasNext()) {
            long j2 = jArr[it.nextInt()];
            R invoke2 = selector.invoke(Long.valueOf(j2));
            if (invoke.compareTo(invoke2) > 0) {
                j = j2;
                invoke = invoke2;
            }
        }
        return Long.valueOf(j);
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    @XO0OX.xxIXOIIO(name = "copyOfRange")
    @kotlin.o0
    public static final char[] xXoOI00O(@OXOo.OOXIXo char[] cArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        OOXIXo.I0Io(i2, cArr.length);
        char[] copyOfRange = Arrays.copyOfRange(cArr, i, i2);
        kotlin.jvm.internal.IIX0o.oO(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static /* synthetic */ int xXxxox0I(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return xoXoI(bArr, b, i, i2);
    }

    @kotlin.OOXIXo(message = "Use maxByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T xo(T[] tArr, Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int o0IXO = ArraysKt___ArraysKt.o0IXO(tArr);
        if (o0IXO != 0) {
            R invoke = selector.invoke(t);
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO).iterator();
            while (it.hasNext()) {
                T t2 = tArr[it.nextInt()];
                R invoke2 = selector.invoke(t2);
                if (invoke.compareTo(invoke2) < 0) {
                    t = t2;
                    invoke = invoke2;
                }
            }
        }
        return t;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final boolean xo0x(short[] sArr, short[] sArr2) {
        return Arrays.equals(sArr, sArr2);
    }

    @OXOo.OOXIXo
    public static final <T> T[] xoIXOxX(@OXOo.OOXIXo T[] tArr, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + 1);
        tArr2[length] = t;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(tArr2);
        return tArr2;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final String xoIxX(char[] cArr) {
        String arrays = Arrays.toString(cArr);
        kotlin.jvm.internal.IIX0o.oO(arrays, "toString(...)");
        return arrays;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    public static short[] xoO0xx0(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo short[] destination, int i, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        System.arraycopy(sArr, i2, destination, i, i3 - i2);
        return destination;
    }

    @kotlin.OOXIXo(message = "Use minOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Byte xoX(byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return ArraysKt___ArraysKt.x0ox(bArr);
    }

    public static final int xoXoI(@OXOo.OOXIXo byte[] bArr, byte b, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return Arrays.binarySearch(bArr, i, i2, b);
    }

    @OXOo.OOXIXo
    public static final <T> T[] xooxxX(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Collection<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, elements.size() + length);
        Iterator<? extends T> it = elements.iterator();
        while (it.hasNext()) {
            tArr2[length] = it.next();
            length++;
        }
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(tArr2);
        return tArr2;
    }

    @kotlin.OOXIXo(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Double xox(double[] dArr, Comparator comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return ArraysKt___ArraysKt.XO0xXoO0X(dArr, comparator);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int xoxXI(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigDecimal")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final BigDecimal xoxo(short[] sArr, Oox.oOoXoXO<? super Short, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        for (short s : sArr) {
            valueOf = valueOf.add(selector.invoke(Short.valueOf(s)));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    public static /* synthetic */ void xx(Comparable[] comparableArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = comparableArr.length;
        }
        IxO0Oxo(comparableArr, i, i2);
    }

    @kotlin.OOXIXo(message = "Use minOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Comparable xx0(Comparable[] comparableArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparableArr, "<this>");
        return ArraysKt___ArraysKt.o0xoIoI0o(comparableArr);
    }

    public static final <T> void xx00oOoI(@OXOo.OOXIXo T[] tArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        Arrays.sort(tArr, i, i2);
    }

    @xx0o0O.XO
    public static final byte[] xx0X0(byte[] bArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        byte[] copyOf = Arrays.copyOf(bArr, i);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @OXOo.OOXIXo
    public static short[] xx0o0O(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo short[] elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        int length = sArr.length;
        int length2 = elements.length;
        short[] copyOf = Arrays.copyOf(sArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> String xxIO(T[] tArr) {
        String arrays = Arrays.toString(tArr);
        kotlin.jvm.internal.IIX0o.oO(arrays, "toString(...)");
        return arrays;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    @XO0OX.xxIXOIIO(name = "copyOfRange")
    @kotlin.o0
    public static byte[] xxOXOOoIX(@OXOo.OOXIXo byte[] bArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        OOXIXo.I0Io(i2, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2);
        kotlin.jvm.internal.IIX0o.oO(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static final <T> int xxX(@OXOo.OOXIXo T[] tArr, T t, @OXOo.OOXIXo Comparator<? super T> comparator, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return Arrays.binarySearch(tArr, i, i2, t, comparator);
    }

    @xx0o0O.XO
    public static final <T> T[] xxXXXxIxo(T[] tArr, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return (T[]) xoIXOxX(tArr, t);
    }

    public static /* synthetic */ void xxx00(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length;
        }
        x00IOx(jArr, j, i, i2);
    }

    @xx0o0O.XO
    public static final <T> T xxxI(T[] tArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return tArr[i];
    }

    @OXOo.OOXIXo
    public static final boolean[] xxxoo0XI(@OXOo.OOXIXo boolean[] zArr, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        int length = zArr.length;
        boolean[] copyOf = Arrays.copyOf(zArr, length + 1);
        copyOf[length] = z;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(copyOf);
        return copyOf;
    }
}
