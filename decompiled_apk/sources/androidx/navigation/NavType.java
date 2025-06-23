package androidx.navigation;

import OXOo.OOXIXo;
import XO0OX.XO;
import XO0OX.x0XOIxOo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.AnyRes;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.collections.oI0IIXIo;
import kotlin.collections.oOoXoXO;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.text.OxI;
import okhttp3.HttpUrl;

/* loaded from: classes.dex */
public abstract class NavType<T> {
    private final boolean isNullableAllowed;

    @OOXIXo
    private final String name = "nav_type";

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    @XO
    public static final NavType<Integer> IntType = new NavType<Integer>() { // from class: androidx.navigation.NavType$Companion$IntType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return TypedValues.Custom.S_INT;
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ void put(Bundle bundle, String str, Integer num) {
            put(bundle, str, num.intValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Integer get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            Object obj = bundle.get(key);
            IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlin.Int");
            return (Integer) obj;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Integer parseValue(String value) {
            int parseInt;
            IIX0o.x0xO0oo(value, "value");
            if (OxI.IOOoXo0Ix(value, HexStringBuilder.DEFAULT_PREFIX, false, 2, null)) {
                String substring = value.substring(2);
                IIX0o.oO(substring, "substring(...)");
                parseInt = Integer.parseInt(substring, kotlin.text.II0xO0.oIX0oI(16));
            } else {
                parseInt = Integer.parseInt(value);
            }
            return Integer.valueOf(parseInt);
        }

        public void put(Bundle bundle, String key, int i) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            bundle.putInt(key, i);
        }
    };

    @OOXIXo
    @XO
    public static final NavType<Integer> ReferenceType = new NavType<Integer>() { // from class: androidx.navigation.NavType$Companion$ReferenceType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return TypedValues.Custom.S_REFERENCE;
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ void put(Bundle bundle, String str, Integer num) {
            put(bundle, str, num.intValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        @AnyRes
        public Integer get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            Object obj = bundle.get(key);
            IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlin.Int");
            return (Integer) obj;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Integer parseValue(String value) {
            int parseInt;
            IIX0o.x0xO0oo(value, "value");
            if (OxI.IOOoXo0Ix(value, HexStringBuilder.DEFAULT_PREFIX, false, 2, null)) {
                String substring = value.substring(2);
                IIX0o.oO(substring, "substring(...)");
                parseInt = Integer.parseInt(substring, kotlin.text.II0xO0.oIX0oI(16));
            } else {
                parseInt = Integer.parseInt(value);
            }
            return Integer.valueOf(parseInt);
        }

        public void put(Bundle bundle, String key, @AnyRes int i) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            bundle.putInt(key, i);
        }
    };

    @OOXIXo
    @XO
    public static final NavType<int[]> IntArrayType = new CollectionNavType<int[]>() { // from class: androidx.navigation.NavType$Companion$IntArrayType$1
        @Override // androidx.navigation.CollectionNavType
        public int[] emptyCollection() {
            return new int[0];
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return "integer[]";
        }

        @Override // androidx.navigation.NavType
        public int[] get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            return (int[]) bundle.get(key);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, int[] iArr) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            bundle.putIntArray(key, iArr);
        }

        @Override // androidx.navigation.CollectionNavType
        public List<String> serializeAsValues(int[] iArr) {
            List<Integer> XXX0;
            if (iArr != null && (XXX0 = ArraysKt___ArraysKt.XXX0(iArr)) != null) {
                List<Integer> list = XXX0;
                ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(String.valueOf(((Number) it.next()).intValue()));
                }
                return arrayList;
            }
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @Override // androidx.navigation.NavType
        public boolean valueEquals(int[] iArr, int[] iArr2) {
            return oOoXoXO.Oxx0IOOO(iArr != null ? ooOOo0oXI.XXoO0oX(iArr) : null, iArr2 != null ? ooOOo0oXI.XXoO0oX(iArr2) : null);
        }

        @Override // androidx.navigation.NavType
        public int[] parseValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            return new int[]{NavType.IntType.parseValue(value).intValue()};
        }

        @Override // androidx.navigation.NavType
        public int[] parseValue(String value, int[] iArr) {
            int[] oIXoXx02;
            IIX0o.x0xO0oo(value, "value");
            return (iArr == null || (oIXoXx02 = ooOOo0oXI.oIXoXx0(iArr, parseValue(value))) == null) ? parseValue(value) : oIXoXx02;
        }
    };

    @OOXIXo
    @XO
    public static final NavType<List<Integer>> IntListType = new CollectionNavType<List<? extends Integer>>() { // from class: androidx.navigation.NavType$Companion$IntListType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "List<Int>";
        }

        @Override // androidx.navigation.CollectionNavType
        public /* bridge */ /* synthetic */ List serializeAsValues(List<? extends Integer> list) {
            return serializeAsValues2((List<Integer>) list);
        }

        @Override // androidx.navigation.CollectionNavType
        public List<? extends Integer> emptyCollection() {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @Override // androidx.navigation.NavType
        public List<Integer> get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            int[] iArr = (int[]) bundle.get(key);
            if (iArr != null) {
                return ArraysKt___ArraysKt.XXX0(iArr);
            }
            return null;
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, List<Integer> list) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            bundle.putIntArray(key, list != null ? CollectionsKt___CollectionsKt.o0Oox0xox(list) : null);
        }

        /* renamed from: serializeAsValues, reason: avoid collision after fix types in other method */
        public List<String> serializeAsValues2(List<Integer> list) {
            if (list != null) {
                List<Integer> list2 = list;
                ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(String.valueOf(((Number) it.next()).intValue()));
                }
                return arrayList;
            }
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @Override // androidx.navigation.NavType
        public boolean valueEquals(List<Integer> list, List<Integer> list2) {
            return oOoXoXO.Oxx0IOOO(list != null ? (Integer[]) list.toArray(new Integer[0]) : null, list2 != null ? (Integer[]) list2.toArray(new Integer[0]) : null);
        }

        @Override // androidx.navigation.NavType
        public List<Integer> parseValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            return oI0IIXIo.OOXIXo(NavType.IntType.parseValue(value));
        }

        @Override // androidx.navigation.NavType
        public List<Integer> parseValue(String value, List<Integer> list) {
            List<Integer> o0xIIX02;
            IIX0o.x0xO0oo(value, "value");
            return (list == null || (o0xIIX02 = CollectionsKt___CollectionsKt.o0xIIX0(list, parseValue(value))) == null) ? parseValue(value) : o0xIIX02;
        }
    };

    @OOXIXo
    @XO
    public static final NavType<Long> LongType = new NavType<Long>() { // from class: androidx.navigation.NavType$Companion$LongType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "long";
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ void put(Bundle bundle, String str, Long l) {
            put(bundle, str, l.longValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Long get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            Object obj = bundle.get(key);
            IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlin.Long");
            return (Long) obj;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Long parseValue(String value) {
            String str;
            long parseLong;
            IIX0o.x0xO0oo(value, "value");
            if (OxI.XO0o(value, "L", false, 2, null)) {
                str = value.substring(0, value.length() - 1);
                IIX0o.oO(str, "substring(...)");
            } else {
                str = value;
            }
            if (OxI.IOOoXo0Ix(value, HexStringBuilder.DEFAULT_PREFIX, false, 2, null)) {
                String substring = str.substring(2);
                IIX0o.oO(substring, "substring(...)");
                parseLong = Long.parseLong(substring, kotlin.text.II0xO0.oIX0oI(16));
            } else {
                parseLong = Long.parseLong(str);
            }
            return Long.valueOf(parseLong);
        }

        public void put(Bundle bundle, String key, long j) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            bundle.putLong(key, j);
        }
    };

    @OOXIXo
    @XO
    public static final NavType<long[]> LongArrayType = new CollectionNavType<long[]>() { // from class: androidx.navigation.NavType$Companion$LongArrayType$1
        @Override // androidx.navigation.CollectionNavType
        public long[] emptyCollection() {
            return new long[0];
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return "long[]";
        }

        @Override // androidx.navigation.NavType
        public long[] get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            return (long[]) bundle.get(key);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, long[] jArr) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            bundle.putLongArray(key, jArr);
        }

        @Override // androidx.navigation.CollectionNavType
        public List<String> serializeAsValues(long[] jArr) {
            List<Long> OoxIx;
            if (jArr != null && (OoxIx = ArraysKt___ArraysKt.OoxIx(jArr)) != null) {
                List<Long> list = OoxIx;
                ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(String.valueOf(((Number) it.next()).longValue()));
                }
                return arrayList;
            }
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @Override // androidx.navigation.NavType
        public boolean valueEquals(long[] jArr, long[] jArr2) {
            return oOoXoXO.Oxx0IOOO(jArr != null ? ooOOo0oXI.xOI0(jArr) : null, jArr2 != null ? ooOOo0oXI.xOI0(jArr2) : null);
        }

        @Override // androidx.navigation.NavType
        public long[] parseValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            return new long[]{NavType.LongType.parseValue(value).longValue()};
        }

        @Override // androidx.navigation.NavType
        public long[] parseValue(String value, long[] jArr) {
            long[] xX0ox2;
            IIX0o.x0xO0oo(value, "value");
            return (jArr == null || (xX0ox2 = ooOOo0oXI.xX0ox(jArr, parseValue(value))) == null) ? parseValue(value) : xX0ox2;
        }
    };

    @OOXIXo
    @XO
    public static final NavType<List<Long>> LongListType = new CollectionNavType<List<? extends Long>>() { // from class: androidx.navigation.NavType$Companion$LongListType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "List<Long>";
        }

        @Override // androidx.navigation.CollectionNavType
        public /* bridge */ /* synthetic */ List serializeAsValues(List<? extends Long> list) {
            return serializeAsValues2((List<Long>) list);
        }

        @Override // androidx.navigation.CollectionNavType
        public List<? extends Long> emptyCollection() {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @Override // androidx.navigation.NavType
        public List<Long> get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            long[] jArr = (long[]) bundle.get(key);
            if (jArr != null) {
                return ArraysKt___ArraysKt.OoxIx(jArr);
            }
            return null;
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, List<Long> list) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            bundle.putLongArray(key, list != null ? CollectionsKt___CollectionsKt.oo00Io(list) : null);
        }

        /* renamed from: serializeAsValues, reason: avoid collision after fix types in other method */
        public List<String> serializeAsValues2(List<Long> list) {
            if (list != null) {
                List<Long> list2 = list;
                ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(String.valueOf(((Number) it.next()).longValue()));
                }
                return arrayList;
            }
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @Override // androidx.navigation.NavType
        public boolean valueEquals(List<Long> list, List<Long> list2) {
            return oOoXoXO.Oxx0IOOO(list != null ? (Long[]) list.toArray(new Long[0]) : null, list2 != null ? (Long[]) list2.toArray(new Long[0]) : null);
        }

        @Override // androidx.navigation.NavType
        public List<Long> parseValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            return oI0IIXIo.OOXIXo(NavType.LongType.parseValue(value));
        }

        @Override // androidx.navigation.NavType
        public List<Long> parseValue(String value, List<Long> list) {
            List<Long> o0xIIX02;
            IIX0o.x0xO0oo(value, "value");
            return (list == null || (o0xIIX02 = CollectionsKt___CollectionsKt.o0xIIX0(list, parseValue(value))) == null) ? parseValue(value) : o0xIIX02;
        }
    };

    @OOXIXo
    @XO
    public static final NavType<Float> FloatType = new NavType<Float>() { // from class: androidx.navigation.NavType$Companion$FloatType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return TypedValues.Custom.S_FLOAT;
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ void put(Bundle bundle, String str, Float f) {
            put(bundle, str, f.floatValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Float get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            Object obj = bundle.get(key);
            IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlin.Float");
            return (Float) obj;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Float parseValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            return Float.valueOf(Float.parseFloat(value));
        }

        public void put(Bundle bundle, String key, float f) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            bundle.putFloat(key, f);
        }
    };

    @OOXIXo
    @XO
    public static final NavType<float[]> FloatArrayType = new CollectionNavType<float[]>() { // from class: androidx.navigation.NavType$Companion$FloatArrayType$1
        @Override // androidx.navigation.CollectionNavType
        public float[] emptyCollection() {
            return new float[0];
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return "float[]";
        }

        @Override // androidx.navigation.NavType
        public float[] get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            return (float[]) bundle.get(key);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, float[] fArr) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            bundle.putFloatArray(key, fArr);
        }

        @Override // androidx.navigation.CollectionNavType
        public List<String> serializeAsValues(float[] fArr) {
            List<Float> X00OO00x;
            if (fArr != null && (X00OO00x = ArraysKt___ArraysKt.X00OO00x(fArr)) != null) {
                List<Float> list = X00OO00x;
                ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(String.valueOf(((Number) it.next()).floatValue()));
                }
                return arrayList;
            }
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @Override // androidx.navigation.NavType
        public boolean valueEquals(float[] fArr, float[] fArr2) {
            return oOoXoXO.Oxx0IOOO(fArr != null ? ooOOo0oXI.Xxx0oXX(fArr) : null, fArr2 != null ? ooOOo0oXI.Xxx0oXX(fArr2) : null);
        }

        @Override // androidx.navigation.NavType
        public float[] parseValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            return new float[]{NavType.FloatType.parseValue(value).floatValue()};
        }

        @Override // androidx.navigation.NavType
        public float[] parseValue(String value, float[] fArr) {
            float[] O0O0Io00X2;
            IIX0o.x0xO0oo(value, "value");
            return (fArr == null || (O0O0Io00X2 = ooOOo0oXI.O0O0Io00X(fArr, parseValue(value))) == null) ? parseValue(value) : O0O0Io00X2;
        }
    };

    @OOXIXo
    @XO
    public static final NavType<List<Float>> FloatListType = new CollectionNavType<List<? extends Float>>() { // from class: androidx.navigation.NavType$Companion$FloatListType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "List<Float>";
        }

        @Override // androidx.navigation.CollectionNavType
        public /* bridge */ /* synthetic */ List serializeAsValues(List<? extends Float> list) {
            return serializeAsValues2((List<Float>) list);
        }

        @Override // androidx.navigation.CollectionNavType
        public List<? extends Float> emptyCollection() {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @Override // androidx.navigation.NavType
        public List<Float> get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            float[] fArr = (float[]) bundle.get(key);
            if (fArr != null) {
                return ArraysKt___ArraysKt.X00OO00x(fArr);
            }
            return null;
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, List<Float> list) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            bundle.putFloatArray(key, list != null ? CollectionsKt___CollectionsKt.xXO0oXX(list) : null);
        }

        /* renamed from: serializeAsValues, reason: avoid collision after fix types in other method */
        public List<String> serializeAsValues2(List<Float> list) {
            if (list != null) {
                List<Float> list2 = list;
                ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(String.valueOf(((Number) it.next()).floatValue()));
                }
                return arrayList;
            }
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @Override // androidx.navigation.NavType
        public boolean valueEquals(List<Float> list, List<Float> list2) {
            return oOoXoXO.Oxx0IOOO(list != null ? (Float[]) list.toArray(new Float[0]) : null, list2 != null ? (Float[]) list2.toArray(new Float[0]) : null);
        }

        @Override // androidx.navigation.NavType
        public List<Float> parseValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            return oI0IIXIo.OOXIXo(NavType.FloatType.parseValue(value));
        }

        @Override // androidx.navigation.NavType
        public List<Float> parseValue(String value, List<Float> list) {
            List<Float> o0xIIX02;
            IIX0o.x0xO0oo(value, "value");
            return (list == null || (o0xIIX02 = CollectionsKt___CollectionsKt.o0xIIX0(list, parseValue(value))) == null) ? parseValue(value) : o0xIIX02;
        }
    };

    @OOXIXo
    @XO
    public static final NavType<Boolean> BoolType = new NavType<Boolean>() { // from class: androidx.navigation.NavType$Companion$BoolType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return TypedValues.Custom.S_BOOLEAN;
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ void put(Bundle bundle, String str, Boolean bool) {
            put(bundle, str, bool.booleanValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Boolean get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            return (Boolean) bundle.get(key);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Boolean parseValue(String value) {
            boolean z;
            IIX0o.x0xO0oo(value, "value");
            if (IIX0o.Oxx0IOOO(value, "true")) {
                z = true;
            } else {
                if (!IIX0o.Oxx0IOOO(value, "false")) {
                    throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
                }
                z = false;
            }
            return Boolean.valueOf(z);
        }

        public void put(Bundle bundle, String key, boolean z) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            bundle.putBoolean(key, z);
        }
    };

    @OOXIXo
    @XO
    public static final NavType<boolean[]> BoolArrayType = new CollectionNavType<boolean[]>() { // from class: androidx.navigation.NavType$Companion$BoolArrayType$1
        @Override // androidx.navigation.CollectionNavType
        public boolean[] emptyCollection() {
            return new boolean[0];
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return "boolean[]";
        }

        @Override // androidx.navigation.NavType
        public boolean[] get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            return (boolean[]) bundle.get(key);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, boolean[] zArr) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            bundle.putBooleanArray(key, zArr);
        }

        @Override // androidx.navigation.CollectionNavType
        public List<String> serializeAsValues(boolean[] zArr) {
            List<Boolean> XIX0oOXXO;
            if (zArr != null && (XIX0oOXXO = ArraysKt___ArraysKt.XIX0oOXXO(zArr)) != null) {
                List<Boolean> list = XIX0oOXXO;
                ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(String.valueOf(((Boolean) it.next()).booleanValue()));
                }
                return arrayList;
            }
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @Override // androidx.navigation.NavType
        public boolean valueEquals(boolean[] zArr, boolean[] zArr2) {
            return oOoXoXO.Oxx0IOOO(zArr != null ? ooOOo0oXI.xXIX0Xo(zArr) : null, zArr2 != null ? ooOOo0oXI.xXIX0Xo(zArr2) : null);
        }

        @Override // androidx.navigation.NavType
        public boolean[] parseValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            return new boolean[]{NavType.BoolType.parseValue(value).booleanValue()};
        }

        @Override // androidx.navigation.NavType
        public boolean[] parseValue(String value, boolean[] zArr) {
            boolean[] IIIxO2;
            IIX0o.x0xO0oo(value, "value");
            return (zArr == null || (IIIxO2 = ooOOo0oXI.IIIxO(zArr, parseValue(value))) == null) ? parseValue(value) : IIIxO2;
        }
    };

    @OOXIXo
    @XO
    public static final NavType<List<Boolean>> BoolListType = new CollectionNavType<List<? extends Boolean>>() { // from class: androidx.navigation.NavType$Companion$BoolListType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "List<Boolean>";
        }

        @Override // androidx.navigation.CollectionNavType
        public /* bridge */ /* synthetic */ List serializeAsValues(List<? extends Boolean> list) {
            return serializeAsValues2((List<Boolean>) list);
        }

        @Override // androidx.navigation.CollectionNavType
        public List<? extends Boolean> emptyCollection() {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @Override // androidx.navigation.NavType
        public List<Boolean> get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            boolean[] zArr = (boolean[]) bundle.get(key);
            if (zArr != null) {
                return ArraysKt___ArraysKt.XIX0oOXXO(zArr);
            }
            return null;
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, List<Boolean> list) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            bundle.putBooleanArray(key, list != null ? CollectionsKt___CollectionsKt.x0OI(list) : null);
        }

        /* renamed from: serializeAsValues, reason: avoid collision after fix types in other method */
        public List<String> serializeAsValues2(List<Boolean> list) {
            if (list != null) {
                List<Boolean> list2 = list;
                ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(String.valueOf(((Boolean) it.next()).booleanValue()));
                }
                return arrayList;
            }
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @Override // androidx.navigation.NavType
        public boolean valueEquals(List<Boolean> list, List<Boolean> list2) {
            return oOoXoXO.Oxx0IOOO(list != null ? (Boolean[]) list.toArray(new Boolean[0]) : null, list2 != null ? (Boolean[]) list2.toArray(new Boolean[0]) : null);
        }

        @Override // androidx.navigation.NavType
        public List<Boolean> parseValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            return oI0IIXIo.OOXIXo(NavType.BoolType.parseValue(value));
        }

        @Override // androidx.navigation.NavType
        public List<Boolean> parseValue(String value, List<Boolean> list) {
            List<Boolean> o0xIIX02;
            IIX0o.x0xO0oo(value, "value");
            return (list == null || (o0xIIX02 = CollectionsKt___CollectionsKt.o0xIIX0(list, parseValue(value))) == null) ? parseValue(value) : o0xIIX02;
        }
    };

    @OOXIXo
    @XO
    public static final NavType<String> StringType = new NavType<String>() { // from class: androidx.navigation.NavType$Companion$StringType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return TypedValues.Custom.S_STRING;
        }

        @Override // androidx.navigation.NavType
        public String get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            return (String) bundle.get(key);
        }

        @Override // androidx.navigation.NavType
        public String parseValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            if (IIX0o.Oxx0IOOO(value, "null")) {
                return null;
            }
            return value;
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, String str) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            bundle.putString(key, str);
        }

        @Override // androidx.navigation.NavType
        public String serializeAsValue(String str) {
            String encode = str != null ? Uri.encode(str) : null;
            return encode == null ? "null" : encode;
        }
    };

    @OOXIXo
    @XO
    public static final NavType<String[]> StringArrayType = new CollectionNavType<String[]>() { // from class: androidx.navigation.NavType$Companion$StringArrayType$1
        @Override // androidx.navigation.CollectionNavType
        public String[] emptyCollection() {
            return new String[0];
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return "string[]";
        }

        @Override // androidx.navigation.NavType
        public String[] get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            return (String[]) bundle.get(key);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, String[] strArr) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            bundle.putStringArray(key, strArr);
        }

        @Override // androidx.navigation.CollectionNavType
        public List<String> serializeAsValues(String[] strArr) {
            if (strArr != null) {
                ArrayList arrayList = new ArrayList(strArr.length);
                for (String str : strArr) {
                    arrayList.add(Uri.encode(str));
                }
                return arrayList;
            }
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @Override // androidx.navigation.NavType
        public boolean valueEquals(String[] strArr, String[] strArr2) {
            return oOoXoXO.Oxx0IOOO(strArr, strArr2);
        }

        @Override // androidx.navigation.NavType
        public String[] parseValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            return new String[]{value};
        }

        @Override // androidx.navigation.NavType
        public String[] parseValue(String value, String[] strArr) {
            String[] strArr2;
            IIX0o.x0xO0oo(value, "value");
            return (strArr == null || (strArr2 = (String[]) ooOOo0oXI.O0xO0(strArr, parseValue(value))) == null) ? parseValue(value) : strArr2;
        }
    };

    @OOXIXo
    @XO
    public static final NavType<List<String>> StringListType = new CollectionNavType<List<? extends String>>() { // from class: androidx.navigation.NavType$Companion$StringListType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "List<String>";
        }

        @Override // androidx.navigation.CollectionNavType
        public /* bridge */ /* synthetic */ List serializeAsValues(List<? extends String> list) {
            return serializeAsValues2((List<String>) list);
        }

        @Override // androidx.navigation.CollectionNavType
        public List<? extends String> emptyCollection() {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @Override // androidx.navigation.NavType
        public List<String> get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            String[] strArr = (String[]) bundle.get(key);
            if (strArr != null) {
                return ArraysKt___ArraysKt.IoXOX(strArr);
            }
            return null;
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, List<String> list) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            bundle.putStringArray(key, list != null ? (String[]) list.toArray(new String[0]) : null);
        }

        /* renamed from: serializeAsValues, reason: avoid collision after fix types in other method */
        public List<String> serializeAsValues2(List<String> list) {
            if (list != null) {
                List<String> list2 = list;
                ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(Uri.encode((String) it.next()));
                }
                return arrayList;
            }
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @Override // androidx.navigation.NavType
        public boolean valueEquals(List<String> list, List<String> list2) {
            return oOoXoXO.Oxx0IOOO(list != null ? (String[]) list.toArray(new String[0]) : null, list2 != null ? (String[]) list2.toArray(new String[0]) : null);
        }

        @Override // androidx.navigation.NavType
        public List<String> parseValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            return oI0IIXIo.OOXIXo(value);
        }

        @Override // androidx.navigation.NavType
        public List<String> parseValue(String value, List<String> list) {
            List<String> o0xIIX02;
            IIX0o.x0xO0oo(value, "value");
            return (list == null || (o0xIIX02 = CollectionsKt___CollectionsKt.o0xIIX0(list, parseValue(value))) == null) ? parseValue(value) : o0xIIX02;
        }
    };

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OOXIXo
        public NavType<?> fromArgType(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2) {
            String str3;
            NavType<Integer> navType = NavType.IntType;
            if (IIX0o.Oxx0IOOO(navType.getName(), str)) {
                return navType;
            }
            NavType navType2 = NavType.IntArrayType;
            if (IIX0o.Oxx0IOOO(navType2.getName(), str)) {
                return navType2;
            }
            NavType<List<Integer>> navType3 = NavType.IntListType;
            if (IIX0o.Oxx0IOOO(navType3.getName(), str)) {
                return navType3;
            }
            NavType<Long> navType4 = NavType.LongType;
            if (IIX0o.Oxx0IOOO(navType4.getName(), str)) {
                return navType4;
            }
            NavType navType5 = NavType.LongArrayType;
            if (IIX0o.Oxx0IOOO(navType5.getName(), str)) {
                return navType5;
            }
            NavType<List<Long>> navType6 = NavType.LongListType;
            if (IIX0o.Oxx0IOOO(navType6.getName(), str)) {
                return navType6;
            }
            NavType<Boolean> navType7 = NavType.BoolType;
            if (IIX0o.Oxx0IOOO(navType7.getName(), str)) {
                return navType7;
            }
            NavType navType8 = NavType.BoolArrayType;
            if (IIX0o.Oxx0IOOO(navType8.getName(), str)) {
                return navType8;
            }
            NavType<List<Boolean>> navType9 = NavType.BoolListType;
            if (IIX0o.Oxx0IOOO(navType9.getName(), str)) {
                return navType9;
            }
            NavType<String> navType10 = NavType.StringType;
            if (IIX0o.Oxx0IOOO(navType10.getName(), str)) {
                return navType10;
            }
            NavType navType11 = NavType.StringArrayType;
            if (IIX0o.Oxx0IOOO(navType11.getName(), str)) {
                return navType11;
            }
            NavType<List<String>> navType12 = NavType.StringListType;
            if (IIX0o.Oxx0IOOO(navType12.getName(), str)) {
                return navType12;
            }
            NavType<Float> navType13 = NavType.FloatType;
            if (IIX0o.Oxx0IOOO(navType13.getName(), str)) {
                return navType13;
            }
            NavType navType14 = NavType.FloatArrayType;
            if (IIX0o.Oxx0IOOO(navType14.getName(), str)) {
                return navType14;
            }
            NavType<List<Float>> navType15 = NavType.FloatListType;
            if (IIX0o.Oxx0IOOO(navType15.getName(), str)) {
                return navType15;
            }
            NavType<Integer> navType16 = NavType.ReferenceType;
            if (IIX0o.Oxx0IOOO(navType16.getName(), str)) {
                return navType16;
            }
            if (str != null && str.length() != 0) {
                try {
                    if (OxI.IOOoXo0Ix(str, FileUtils.FILE_EXTENSION_SEPARATOR, false, 2, null) && str2 != null) {
                        str3 = str2 + str;
                    } else {
                        str3 = str;
                    }
                    boolean XO0o2 = OxI.XO0o(str, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, false, 2, null);
                    if (XO0o2) {
                        str3 = str3.substring(0, str3.length() - 2);
                        IIX0o.oO(str3, "substring(...)");
                    }
                    Class<?> clazz = Class.forName(str3);
                    IIX0o.oO(clazz, "clazz");
                    NavType<?> parseSerializableOrParcelableType$navigation_common_release = parseSerializableOrParcelableType$navigation_common_release(clazz, XO0o2);
                    if (parseSerializableOrParcelableType$navigation_common_release != null) {
                        return parseSerializableOrParcelableType$navigation_common_release;
                    }
                    throw new IllegalArgumentException((str3 + " is not Serializable or Parcelable.").toString());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            return navType10;
        }

        @x0XOIxOo
        @OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final NavType<Object> inferFromValue(@OOXIXo String value) {
            IIX0o.x0xO0oo(value, "value");
            try {
                try {
                    try {
                        try {
                            NavType<Integer> navType = NavType.IntType;
                            navType.parseValue(value);
                            IIX0o.x0XOIxOo(navType, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                            return navType;
                        } catch (IllegalArgumentException unused) {
                            NavType<Boolean> navType2 = NavType.BoolType;
                            navType2.parseValue(value);
                            IIX0o.x0XOIxOo(navType2, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                            return navType2;
                        }
                    } catch (IllegalArgumentException unused2) {
                        NavType<Long> navType3 = NavType.LongType;
                        navType3.parseValue(value);
                        IIX0o.x0XOIxOo(navType3, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                        return navType3;
                    }
                } catch (IllegalArgumentException unused3) {
                    NavType<String> navType4 = NavType.StringType;
                    IIX0o.x0XOIxOo(navType4, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                    return navType4;
                }
            } catch (IllegalArgumentException unused4) {
                NavType<Float> navType5 = NavType.FloatType;
                navType5.parseValue(value);
                IIX0o.x0XOIxOo(navType5, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType5;
            }
        }

        @x0XOIxOo
        @OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final NavType<Object> inferFromValueType(@OXOo.oOoXoXO Object obj) {
            NavType<Object> serializableType;
            if (obj instanceof Integer) {
                NavType<Integer> navType = NavType.IntType;
                IIX0o.x0XOIxOo(navType, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType;
            }
            if (obj instanceof int[]) {
                NavType<int[]> navType2 = NavType.IntArrayType;
                IIX0o.x0XOIxOo(navType2, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType2;
            }
            if (obj instanceof Long) {
                NavType<Long> navType3 = NavType.LongType;
                IIX0o.x0XOIxOo(navType3, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType3;
            }
            if (obj instanceof long[]) {
                NavType<long[]> navType4 = NavType.LongArrayType;
                IIX0o.x0XOIxOo(navType4, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType4;
            }
            if (obj instanceof Float) {
                NavType<Float> navType5 = NavType.FloatType;
                IIX0o.x0XOIxOo(navType5, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType5;
            }
            if (obj instanceof float[]) {
                NavType<float[]> navType6 = NavType.FloatArrayType;
                IIX0o.x0XOIxOo(navType6, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType6;
            }
            if (obj instanceof Boolean) {
                NavType<Boolean> navType7 = NavType.BoolType;
                IIX0o.x0XOIxOo(navType7, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType7;
            }
            if (obj instanceof boolean[]) {
                NavType<boolean[]> navType8 = NavType.BoolArrayType;
                IIX0o.x0XOIxOo(navType8, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType8;
            }
            if (!(obj instanceof String) && obj != null) {
                if ((obj instanceof Object[]) && (((Object[]) obj) instanceof String[])) {
                    NavType<String[]> navType9 = NavType.StringArrayType;
                    IIX0o.x0XOIxOo(navType9, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                    return navType9;
                }
                if (obj.getClass().isArray()) {
                    Class<?> componentType = obj.getClass().getComponentType();
                    IIX0o.ooOOo0oXI(componentType);
                    if (Parcelable.class.isAssignableFrom(componentType)) {
                        Class<?> componentType2 = obj.getClass().getComponentType();
                        IIX0o.x0XOIxOo(componentType2, "null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");
                        serializableType = new ParcelableArrayType<>(componentType2);
                        return serializableType;
                    }
                }
                if (obj.getClass().isArray()) {
                    Class<?> componentType3 = obj.getClass().getComponentType();
                    IIX0o.ooOOo0oXI(componentType3);
                    if (Serializable.class.isAssignableFrom(componentType3)) {
                        Class<?> componentType4 = obj.getClass().getComponentType();
                        IIX0o.x0XOIxOo(componentType4, "null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                        serializableType = new SerializableArrayType<>(componentType4);
                        return serializableType;
                    }
                }
                if (obj instanceof Parcelable) {
                    serializableType = new ParcelableType<>(obj.getClass());
                } else if (obj instanceof Enum) {
                    serializableType = new EnumType<>(obj.getClass());
                } else if (obj instanceof Serializable) {
                    serializableType = new SerializableType<>(obj.getClass());
                } else {
                    throw new IllegalArgumentException("Object of type " + obj.getClass().getName() + " is not supported for navigation arguments.");
                }
                return serializableType;
            }
            NavType<String> navType10 = NavType.StringType;
            IIX0o.x0XOIxOo(navType10, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
            return navType10;
        }

        @OXOo.oOoXoXO
        public final NavType<?> parseSerializableOrParcelableType$navigation_common_release(@OOXIXo Class<?> clazz, boolean z) {
            IIX0o.x0xO0oo(clazz, "clazz");
            if (Parcelable.class.isAssignableFrom(clazz)) {
                if (z) {
                    return new ParcelableArrayType(clazz);
                }
                return new ParcelableType(clazz);
            }
            if (Enum.class.isAssignableFrom(clazz) && !z) {
                return new EnumType(clazz);
            }
            if (Serializable.class.isAssignableFrom(clazz)) {
                if (z) {
                    return new SerializableArrayType(clazz);
                }
                return new SerializableType(clazz);
            }
            return null;
        }

        private Companion() {
        }
    }

    /* loaded from: classes.dex */
    public static final class ParcelableArrayType<D extends Parcelable> extends NavType<D[]> {

        @OOXIXo
        private final Class<D[]> arrayType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParcelableArrayType(@OOXIXo Class<D> type) {
            super(true);
            IIX0o.x0xO0oo(type, "type");
            if (Parcelable.class.isAssignableFrom(type)) {
                try {
                    Class<D[]> cls = (Class<D[]>) Class.forName("[L" + type.getName() + ';');
                    IIX0o.x0XOIxOo(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.Array<D of androidx.navigation.NavType.ParcelableArrayType>>");
                    this.arrayType = cls;
                    return;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            throw new IllegalArgumentException((type + " does not implement Parcelable.").toString());
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && IIX0o.Oxx0IOOO(ParcelableArrayType.class, obj.getClass())) {
                return IIX0o.Oxx0IOOO(this.arrayType, ((ParcelableArrayType) obj).arrayType);
            }
            return false;
        }

        @Override // androidx.navigation.NavType
        @OOXIXo
        public String getName() {
            String name = this.arrayType.getName();
            IIX0o.oO(name, "arrayType.name");
            return name;
        }

        public int hashCode() {
            return this.arrayType.hashCode();
        }

        @Override // androidx.navigation.NavType
        @OXOo.oOoXoXO
        public D[] get(@OOXIXo Bundle bundle, @OOXIXo String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            return (D[]) ((Parcelable[]) bundle.get(key));
        }

        @Override // androidx.navigation.NavType
        @OOXIXo
        public D[] parseValue(@OOXIXo String value) {
            IIX0o.x0xO0oo(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public void put(@OOXIXo Bundle bundle, @OOXIXo String key, @OXOo.oOoXoXO D[] dArr) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            this.arrayType.cast(dArr);
            bundle.putParcelableArray(key, dArr);
        }

        @Override // androidx.navigation.NavType
        public boolean valueEquals(@OXOo.oOoXoXO D[] dArr, @OXOo.oOoXoXO D[] dArr2) {
            return oOoXoXO.Oxx0IOOO(dArr, dArr2);
        }
    }

    /* loaded from: classes.dex */
    public static final class ParcelableType<D> extends NavType<D> {

        @OOXIXo
        private final Class<D> type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParcelableType(@OOXIXo Class<D> type) {
            super(true);
            IIX0o.x0xO0oo(type, "type");
            if (!Parcelable.class.isAssignableFrom(type) && !Serializable.class.isAssignableFrom(type)) {
                throw new IllegalArgumentException((type + " does not implement Parcelable or Serializable.").toString());
            }
            this.type = type;
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && IIX0o.Oxx0IOOO(ParcelableType.class, obj.getClass())) {
                return IIX0o.Oxx0IOOO(this.type, ((ParcelableType) obj).type);
            }
            return false;
        }

        @Override // androidx.navigation.NavType
        @OXOo.oOoXoXO
        public D get(@OOXIXo Bundle bundle, @OOXIXo String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            return (D) bundle.get(key);
        }

        @Override // androidx.navigation.NavType
        @OOXIXo
        public String getName() {
            String name = this.type.getName();
            IIX0o.oO(name, "type.name");
            return name;
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        @Override // androidx.navigation.NavType
        public D parseValue(@OOXIXo String value) {
            IIX0o.x0xO0oo(value, "value");
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public void put(@OOXIXo Bundle bundle, @OOXIXo String key, D d) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            this.type.cast(d);
            if (d != null && !(d instanceof Parcelable)) {
                if (d instanceof Serializable) {
                    bundle.putSerializable(key, (Serializable) d);
                    return;
                }
                return;
            }
            bundle.putParcelable(key, (Parcelable) d);
        }
    }

    /* loaded from: classes.dex */
    public static final class SerializableArrayType<D extends Serializable> extends NavType<D[]> {

        @OOXIXo
        private final Class<D[]> arrayType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SerializableArrayType(@OOXIXo Class<D> type) {
            super(true);
            IIX0o.x0xO0oo(type, "type");
            if (Serializable.class.isAssignableFrom(type)) {
                try {
                    Class<D[]> cls = (Class<D[]>) Class.forName("[L" + type.getName() + ';');
                    IIX0o.x0XOIxOo(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.Array<D of androidx.navigation.NavType.SerializableArrayType>>");
                    this.arrayType = cls;
                    return;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            throw new IllegalArgumentException((type + " does not implement Serializable.").toString());
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && IIX0o.Oxx0IOOO(SerializableArrayType.class, obj.getClass())) {
                return IIX0o.Oxx0IOOO(this.arrayType, ((SerializableArrayType) obj).arrayType);
            }
            return false;
        }

        @Override // androidx.navigation.NavType
        @OOXIXo
        public String getName() {
            String name = this.arrayType.getName();
            IIX0o.oO(name, "arrayType.name");
            return name;
        }

        public int hashCode() {
            return this.arrayType.hashCode();
        }

        @Override // androidx.navigation.NavType
        @OXOo.oOoXoXO
        public D[] get(@OOXIXo Bundle bundle, @OOXIXo String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            return (D[]) ((Serializable[]) bundle.get(key));
        }

        @Override // androidx.navigation.NavType
        @OOXIXo
        public D[] parseValue(@OOXIXo String value) {
            IIX0o.x0xO0oo(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.navigation.NavType
        public void put(@OOXIXo Bundle bundle, @OOXIXo String key, @OXOo.oOoXoXO D[] dArr) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            this.arrayType.cast(dArr);
            bundle.putSerializable(key, dArr);
        }

        @Override // androidx.navigation.NavType
        public boolean valueEquals(@OXOo.oOoXoXO D[] dArr, @OXOo.oOoXoXO D[] dArr2) {
            return oOoXoXO.Oxx0IOOO(dArr, dArr2);
        }
    }

    @XX({"SMAP\nNavType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavType.kt\nandroidx/navigation/NavType$SerializableType\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1212:1\n1#2:1213\n*E\n"})
    /* loaded from: classes.dex */
    public static class SerializableType<D extends Serializable> extends NavType<D> {

        @OOXIXo
        private final Class<D> type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SerializableType(@OOXIXo Class<D> type) {
            super(true);
            IIX0o.x0xO0oo(type, "type");
            if (Serializable.class.isAssignableFrom(type)) {
                if (!type.isEnum()) {
                    this.type = type;
                    return;
                }
                throw new IllegalArgumentException((type + " is an Enum. You should use EnumType instead.").toString());
            }
            throw new IllegalArgumentException((type + " does not implement Serializable.").toString());
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SerializableType)) {
                return false;
            }
            return IIX0o.Oxx0IOOO(this.type, ((SerializableType) obj).type);
        }

        @Override // androidx.navigation.NavType
        @OOXIXo
        public String getName() {
            String name = this.type.getName();
            IIX0o.oO(name, "type.name");
            return name;
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        @Override // androidx.navigation.NavType
        @OXOo.oOoXoXO
        public D get(@OOXIXo Bundle bundle, @OOXIXo String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            return (D) bundle.get(key);
        }

        @Override // androidx.navigation.NavType
        @OOXIXo
        public D parseValue(@OOXIXo String value) {
            IIX0o.x0xO0oo(value, "value");
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public void put(@OOXIXo Bundle bundle, @OOXIXo String key, @OOXIXo D value) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            IIX0o.x0xO0oo(value, "value");
            this.type.cast(value);
            bundle.putSerializable(key, value);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SerializableType(boolean z, @OOXIXo Class<D> type) {
            super(z);
            IIX0o.x0xO0oo(type, "type");
            if (Serializable.class.isAssignableFrom(type)) {
                this.type = type;
                return;
            }
            throw new IllegalArgumentException((type + " does not implement Serializable.").toString());
        }
    }

    public NavType(boolean z) {
        this.isNullableAllowed = z;
    }

    @x0XOIxOo
    @OOXIXo
    public static NavType<?> fromArgType(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2) {
        return Companion.fromArgType(str, str2);
    }

    @x0XOIxOo
    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final NavType<Object> inferFromValue(@OOXIXo String str) {
        return Companion.inferFromValue(str);
    }

    @x0XOIxOo
    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final NavType<Object> inferFromValueType(@OXOo.oOoXoXO Object obj) {
        return Companion.inferFromValueType(obj);
    }

    @OXOo.oOoXoXO
    public abstract T get(@OOXIXo Bundle bundle, @OOXIXo String str);

    @OOXIXo
    public String getName() {
        return this.name;
    }

    public boolean isNullableAllowed() {
        return this.isNullableAllowed;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final T parseAndPut(@OOXIXo Bundle bundle, @OOXIXo String key, @OOXIXo String value) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(value, "value");
        T parseValue = parseValue(value);
        put(bundle, key, parseValue);
        return parseValue;
    }

    public abstract T parseValue(@OOXIXo String str);

    public T parseValue(@OOXIXo String value, T t) {
        IIX0o.x0xO0oo(value, "value");
        return parseValue(value);
    }

    public abstract void put(@OOXIXo Bundle bundle, @OOXIXo String str, T t);

    @OOXIXo
    public String serializeAsValue(T t) {
        return String.valueOf(t);
    }

    @OOXIXo
    public String toString() {
        return getName();
    }

    public boolean valueEquals(T t, T t2) {
        return IIX0o.Oxx0IOOO(t, t2);
    }

    @XX({"SMAP\nNavType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavType.kt\nandroidx/navigation/NavType$EnumType\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,1212:1\n1#2:1213\n1282#3,2:1214\n*S KotlinDebug\n*F\n+ 1 NavType.kt\nandroidx/navigation/NavType$EnumType\n*L\n1135#1:1214,2\n*E\n"})
    /* loaded from: classes.dex */
    public static final class EnumType<D extends Enum<?>> extends SerializableType<D> {

        @OOXIXo
        private final Class<D> type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnumType(@OOXIXo Class<D> type) {
            super(false, type);
            IIX0o.x0xO0oo(type, "type");
            if (type.isEnum()) {
                this.type = type;
                return;
            }
            throw new IllegalArgumentException((type + " is not an Enum type.").toString());
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        @OOXIXo
        public String getName() {
            String name = this.type.getName();
            IIX0o.oO(name, "type.name");
            return name;
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        @OOXIXo
        public D parseValue(@OOXIXo String value) {
            D d;
            IIX0o.x0xO0oo(value, "value");
            D[] enumConstants = this.type.getEnumConstants();
            IIX0o.oO(enumConstants, "type.enumConstants");
            int length = enumConstants.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    d = null;
                    break;
                }
                d = enumConstants[i];
                if (OxI.oX0I0O(d.name(), value, true)) {
                    break;
                }
                i++;
            }
            D d2 = d;
            if (d2 != null) {
                return d2;
            }
            throw new IllegalArgumentException("Enum value " + value + " not found for type " + this.type.getName() + '.');
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final T parseAndPut(@OOXIXo Bundle bundle, @OOXIXo String key, @OXOo.oOoXoXO String str, T t) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(key, "key");
        if (!bundle.containsKey(key)) {
            throw new IllegalArgumentException("There is no previous value in this bundle.");
        }
        if (str == null) {
            return t;
        }
        T parseValue = parseValue(str, t);
        put(bundle, key, parseValue);
        return parseValue;
    }
}
