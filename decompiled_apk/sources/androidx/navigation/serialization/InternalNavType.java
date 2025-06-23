package androidx.navigation.serialization;

import OXOo.OOXIXo;
import android.net.Uri;
import android.os.Bundle;
import androidx.navigation.CollectionNavType;
import androidx.navigation.NavType;
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
import kotlin.jvm.internal.XX;
import kotlin.text.OxI;

/* loaded from: classes.dex */
public final class InternalNavType {

    @OOXIXo
    public static final InternalNavType INSTANCE = new InternalNavType();

    @OOXIXo
    private static final NavType<Integer> IntNullableType = new NavType<Integer>() { // from class: androidx.navigation.serialization.InternalNavType$IntNullableType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "integer_nullable";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Integer get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            Object obj = bundle.get(key);
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Integer parseValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            if (IIX0o.Oxx0IOOO(value, "null")) {
                return null;
            }
            return NavType.IntType.parseValue(value);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, Integer num) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            if (num == null) {
                bundle.putSerializable(key, null);
            } else {
                NavType.IntType.put(bundle, key, num);
            }
        }
    };

    @OOXIXo
    private static final NavType<Boolean> BoolNullableType = new NavType<Boolean>() { // from class: androidx.navigation.serialization.InternalNavType$BoolNullableType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "boolean_nullable";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Boolean get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            Object obj = bundle.get(key);
            if (obj instanceof Boolean) {
                return (Boolean) obj;
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Boolean parseValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            if (IIX0o.Oxx0IOOO(value, "null")) {
                return null;
            }
            return NavType.BoolType.parseValue(value);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, Boolean bool) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            if (bool == null) {
                bundle.putSerializable(key, null);
            } else {
                NavType.BoolType.put(bundle, key, bool);
            }
        }
    };

    @OOXIXo
    private static final NavType<Double> DoubleType = new NavType<Double>() { // from class: androidx.navigation.serialization.InternalNavType$DoubleType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "double";
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ void put(Bundle bundle, String str, Double d) {
            put(bundle, str, d.doubleValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Double get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            Object obj = bundle.get(key);
            IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlin.Double");
            return (Double) obj;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Double parseValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            return Double.valueOf(Double.parseDouble(value));
        }

        public void put(Bundle bundle, String key, double d) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            bundle.putDouble(key, d);
        }
    };

    @OOXIXo
    private static final NavType<Double> DoubleNullableType = new NavType<Double>() { // from class: androidx.navigation.serialization.InternalNavType$DoubleNullableType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "double_nullable";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Double get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            Object obj = bundle.get(key);
            if (obj instanceof Double) {
                return (Double) obj;
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Double parseValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            if (IIX0o.Oxx0IOOO(value, "null")) {
                return null;
            }
            return InternalNavType.INSTANCE.getDoubleType().parseValue(value);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, Double d) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            if (d == null) {
                bundle.putSerializable(key, null);
            } else {
                InternalNavType.INSTANCE.getDoubleType().put(bundle, key, d);
            }
        }
    };

    @OOXIXo
    private static final NavType<Float> FloatNullableType = new NavType<Float>() { // from class: androidx.navigation.serialization.InternalNavType$FloatNullableType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "float_nullable";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Float get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            Object obj = bundle.get(key);
            if (obj instanceof Float) {
                return (Float) obj;
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Float parseValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            if (IIX0o.Oxx0IOOO(value, "null")) {
                return null;
            }
            return NavType.FloatType.parseValue(value);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, Float f) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            if (f == null) {
                bundle.putSerializable(key, null);
            } else {
                NavType.FloatType.put(bundle, key, f);
            }
        }
    };

    @OOXIXo
    private static final NavType<Long> LongNullableType = new NavType<Long>() { // from class: androidx.navigation.serialization.InternalNavType$LongNullableType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "long_nullable";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Long get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            Object obj = bundle.get(key);
            if (obj instanceof Long) {
                return (Long) obj;
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Long parseValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            if (IIX0o.Oxx0IOOO(value, "null")) {
                return null;
            }
            return NavType.LongType.parseValue(value);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, Long l) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            if (l == null) {
                bundle.putSerializable(key, null);
            } else {
                NavType.LongType.put(bundle, key, l);
            }
        }
    };

    @OOXIXo
    private static final NavType<String> StringNonNullableType = new NavType<String>() { // from class: androidx.navigation.serialization.InternalNavType$StringNonNullableType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "string_non_nullable";
        }

        @Override // androidx.navigation.NavType
        public String parseValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            return value;
        }

        @Override // androidx.navigation.NavType
        public String get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            String string = bundle.getString(key);
            return string == null ? "null" : string;
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, String value) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            IIX0o.x0xO0oo(value, "value");
            bundle.putString(key, value);
        }

        @Override // androidx.navigation.NavType
        public String serializeAsValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            String encode = Uri.encode(value);
            IIX0o.oO(encode, "encode(value)");
            return encode;
        }
    };

    @OOXIXo
    private static final NavType<String[]> StringNullableArrayType = new CollectionNavType<String[]>() { // from class: androidx.navigation.serialization.InternalNavType$StringNullableArrayType$1
        @Override // androidx.navigation.CollectionNavType
        public String[] emptyCollection() {
            return new String[0];
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return "string_nullable[]";
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
            return new String[]{NavType.StringType.parseValue(value)};
        }

        @Override // androidx.navigation.NavType
        public String[] parseValue(String value, String[] strArr) {
            String[] strArr2;
            IIX0o.x0xO0oo(value, "value");
            return (strArr == null || (strArr2 = (String[]) ooOOo0oXI.O0xO0(strArr, parseValue(value))) == null) ? parseValue(value) : strArr2;
        }
    };

    @OOXIXo
    private static final NavType<List<String>> StringNullableListType = new CollectionNavType<List<? extends String>>() { // from class: androidx.navigation.serialization.InternalNavType$StringNullableListType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "List<String?>";
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
            return oI0IIXIo.OOXIXo(NavType.StringType.parseValue(value));
        }

        @Override // androidx.navigation.NavType
        public List<String> parseValue(String value, List<String> list) {
            List<String> o0xIIX02;
            IIX0o.x0xO0oo(value, "value");
            return (list == null || (o0xIIX02 = CollectionsKt___CollectionsKt.o0xIIX0(list, parseValue(value))) == null) ? parseValue(value) : o0xIIX02;
        }
    };

    @OOXIXo
    private static final NavType<double[]> DoubleArrayType = new CollectionNavType<double[]>() { // from class: androidx.navigation.serialization.InternalNavType$DoubleArrayType$1
        @Override // androidx.navigation.CollectionNavType
        public double[] emptyCollection() {
            return new double[0];
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return "double[]";
        }

        @Override // androidx.navigation.NavType
        public double[] get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            return (double[]) bundle.get(key);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, double[] dArr) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            bundle.putDoubleArray(key, dArr);
        }

        @Override // androidx.navigation.CollectionNavType
        public List<String> serializeAsValues(double[] dArr) {
            List<Double> OXIIooO0;
            if (dArr != null && (OXIIooO0 = ArraysKt___ArraysKt.OXIIooO0(dArr)) != null) {
                List<Double> list = OXIIooO0;
                ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(String.valueOf(((Number) it.next()).doubleValue()));
                }
                return arrayList;
            }
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @Override // androidx.navigation.NavType
        public boolean valueEquals(double[] dArr, double[] dArr2) {
            return oOoXoXO.Oxx0IOOO(dArr != null ? ooOOo0oXI.OIII0O(dArr) : null, dArr2 != null ? ooOOo0oXI.OIII0O(dArr2) : null);
        }

        @Override // androidx.navigation.NavType
        public double[] parseValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            return new double[]{InternalNavType.INSTANCE.getDoubleType().parseValue(value).doubleValue()};
        }

        @Override // androidx.navigation.NavType
        public double[] parseValue(String value, double[] dArr) {
            double[] OoIXo2;
            IIX0o.x0xO0oo(value, "value");
            return (dArr == null || (OoIXo2 = ooOOo0oXI.OoIXo(dArr, parseValue(value))) == null) ? parseValue(value) : OoIXo2;
        }
    };

    @OOXIXo
    private static final NavType<List<Double>> DoubleListType = new CollectionNavType<List<? extends Double>>() { // from class: androidx.navigation.serialization.InternalNavType$DoubleListType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "List<Double>";
        }

        @Override // androidx.navigation.CollectionNavType
        public /* bridge */ /* synthetic */ List serializeAsValues(List<? extends Double> list) {
            return serializeAsValues2((List<Double>) list);
        }

        @Override // androidx.navigation.CollectionNavType
        public List<? extends Double> emptyCollection() {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @Override // androidx.navigation.NavType
        public List<Double> get(Bundle bundle, String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            Object obj = bundle.get(key);
            double[] dArr = obj instanceof double[] ? (double[]) obj : null;
            if (dArr != null) {
                return ArraysKt___ArraysKt.OXIIooO0(dArr);
            }
            return null;
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, List<Double> list) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            bundle.putDoubleArray(key, list != null ? CollectionsKt___CollectionsKt.XxOOoxOO(list) : null);
        }

        /* renamed from: serializeAsValues, reason: avoid collision after fix types in other method */
        public List<String> serializeAsValues2(List<Double> list) {
            if (list != null) {
                List<Double> list2 = list;
                ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(String.valueOf(((Number) it.next()).doubleValue()));
                }
                return arrayList;
            }
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @Override // androidx.navigation.NavType
        public boolean valueEquals(List<Double> list, List<Double> list2) {
            return oOoXoXO.Oxx0IOOO(list != null ? (Double[]) list.toArray(new Double[0]) : null, list2 != null ? (Double[]) list2.toArray(new Double[0]) : null);
        }

        @Override // androidx.navigation.NavType
        public List<Double> parseValue(String value) {
            IIX0o.x0xO0oo(value, "value");
            return oI0IIXIo.OOXIXo(InternalNavType.INSTANCE.getDoubleType().parseValue(value));
        }

        @Override // androidx.navigation.NavType
        public List<Double> parseValue(String value, List<Double> list) {
            List<Double> o0xIIX02;
            IIX0o.x0xO0oo(value, "value");
            return (list == null || (o0xIIX02 = CollectionsKt___CollectionsKt.o0xIIX0(list, parseValue(value))) == null) ? parseValue(value) : o0xIIX02;
        }
    };

    @XX({"SMAP\nNavTypeConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavTypeConverter.kt\nandroidx/navigation/serialization/InternalNavType$EnumListType\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,577:1\n1#2:578\n1549#3:579\n1620#3,3:580\n*S KotlinDebug\n*F\n+ 1 NavTypeConverter.kt\nandroidx/navigation/serialization/InternalNavType$EnumListType\n*L\n496#1:579\n496#1:580,3\n*E\n"})
    /* loaded from: classes.dex */
    public static final class EnumListType<D extends Enum<?>> extends CollectionNavType<List<? extends D>> {

        @OOXIXo
        private final NavType.EnumType<D> enumNavType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnumListType(@OOXIXo Class<D> type) {
            super(true);
            IIX0o.x0xO0oo(type, "type");
            this.enumNavType = new NavType.EnumType<>(type);
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EnumListType)) {
                return false;
            }
            return IIX0o.Oxx0IOOO(this.enumNavType, ((EnumListType) obj).enumNavType);
        }

        @Override // androidx.navigation.NavType
        @OOXIXo
        public String getName() {
            return "List<" + this.enumNavType.getName() + "}>";
        }

        public int hashCode() {
            return this.enumNavType.hashCode();
        }

        @Override // androidx.navigation.CollectionNavType
        @OOXIXo
        public List<D> emptyCollection() {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @Override // androidx.navigation.NavType
        @OXOo.oOoXoXO
        public List<D> get(@OOXIXo Bundle bundle, @OOXIXo String key) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            Object obj = bundle.get(key);
            if (obj instanceof List) {
                return (List) obj;
            }
            return null;
        }

        @Override // androidx.navigation.NavType
        public void put(@OOXIXo Bundle bundle, @OOXIXo String key, @OXOo.oOoXoXO List<? extends D> list) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            bundle.putSerializable(key, list != null ? new ArrayList(list) : null);
        }

        @Override // androidx.navigation.CollectionNavType
        @OOXIXo
        public List<String> serializeAsValues(@OXOo.oOoXoXO List<? extends D> list) {
            if (list != null) {
                List<? extends D> list2 = list;
                ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Enum) it.next()).toString());
                }
                return arrayList;
            }
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @Override // androidx.navigation.NavType
        public boolean valueEquals(@OXOo.oOoXoXO List<? extends D> list, @OXOo.oOoXoXO List<? extends D> list2) {
            return IIX0o.Oxx0IOOO(list != null ? new ArrayList(list) : null, list2 != null ? new ArrayList(list2) : null);
        }

        @Override // androidx.navigation.NavType
        @OOXIXo
        public List<D> parseValue(@OOXIXo String value) {
            IIX0o.x0xO0oo(value, "value");
            return oI0IIXIo.OOXIXo(this.enumNavType.parseValue(value));
        }

        @Override // androidx.navigation.NavType
        @OXOo.oOoXoXO
        public List<D> parseValue(@OOXIXo String value, @OXOo.oOoXoXO List<? extends D> list) {
            List<D> o0xIIX02;
            IIX0o.x0xO0oo(value, "value");
            return (list == null || (o0xIIX02 = CollectionsKt___CollectionsKt.o0xIIX0(list, parseValue(value))) == null) ? parseValue(value) : o0xIIX02;
        }
    }

    /* loaded from: classes.dex */
    public static class SerializableNullableType<D extends Serializable> extends NavType<D> {

        @OOXIXo
        private final Class<D> type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SerializableNullableType(@OOXIXo Class<D> type) {
            super(true);
            IIX0o.x0xO0oo(type, "type");
            this.type = type;
            if (Serializable.class.isAssignableFrom(type)) {
                return;
            }
            throw new IllegalArgumentException((type + " does not implement Serializable.").toString());
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SerializableNullableType)) {
                return false;
            }
            return IIX0o.Oxx0IOOO(this.type, ((SerializableNullableType) obj).type);
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
            Object obj = bundle.get(key);
            if (obj instanceof Serializable) {
                return (D) obj;
            }
            return null;
        }

        @Override // androidx.navigation.NavType
        @OXOo.oOoXoXO
        public D parseValue(@OOXIXo String value) {
            IIX0o.x0xO0oo(value, "value");
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public void put(@OOXIXo Bundle bundle, @OOXIXo String key, @OXOo.oOoXoXO D d) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(key, "key");
            bundle.putSerializable(key, this.type.cast(d));
        }
    }

    private InternalNavType() {
    }

    @OOXIXo
    public final NavType<Boolean> getBoolNullableType() {
        return BoolNullableType;
    }

    @OOXIXo
    public final NavType<double[]> getDoubleArrayType() {
        return DoubleArrayType;
    }

    @OOXIXo
    public final NavType<List<Double>> getDoubleListType() {
        return DoubleListType;
    }

    @OOXIXo
    public final NavType<Double> getDoubleNullableType() {
        return DoubleNullableType;
    }

    @OOXIXo
    public final NavType<Double> getDoubleType() {
        return DoubleType;
    }

    @OOXIXo
    public final NavType<Float> getFloatNullableType() {
        return FloatNullableType;
    }

    @OOXIXo
    public final NavType<Integer> getIntNullableType() {
        return IntNullableType;
    }

    @OOXIXo
    public final NavType<Long> getLongNullableType() {
        return LongNullableType;
    }

    @OOXIXo
    public final NavType<String> getStringNonNullableType() {
        return StringNonNullableType;
    }

    @OOXIXo
    public final NavType<String[]> getStringNullableArrayType() {
        return StringNullableArrayType;
    }

    @OOXIXo
    public final NavType<List<String>> getStringNullableListType() {
        return StringNullableListType;
    }

    @XX({"SMAP\nNavTypeConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavTypeConverter.kt\nandroidx/navigation/serialization/InternalNavType$EnumNullableType\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,577:1\n1#2:578\n1282#3,2:579\n*S KotlinDebug\n*F\n+ 1 NavTypeConverter.kt\nandroidx/navigation/serialization/InternalNavType$EnumNullableType\n*L\n527#1:579,2\n*E\n"})
    /* loaded from: classes.dex */
    public static final class EnumNullableType<D extends Enum<?>> extends SerializableNullableType<D> {

        @OOXIXo
        private final Class<D> type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnumNullableType(@OOXIXo Class<D> type) {
            super(type);
            IIX0o.x0xO0oo(type, "type");
            if (type.isEnum()) {
                this.type = type;
                return;
            }
            throw new IllegalArgumentException((type + " is not an Enum type.").toString());
        }

        @Override // androidx.navigation.serialization.InternalNavType.SerializableNullableType, androidx.navigation.NavType
        @OOXIXo
        public String getName() {
            String name = this.type.getName();
            IIX0o.oO(name, "type.name");
            return name;
        }

        @Override // androidx.navigation.serialization.InternalNavType.SerializableNullableType, androidx.navigation.NavType
        @OXOo.oOoXoXO
        public D parseValue(@OOXIXo String value) {
            IIX0o.x0xO0oo(value, "value");
            D d = null;
            if (!IIX0o.Oxx0IOOO(value, "null")) {
                D[] enumConstants = this.type.getEnumConstants();
                IIX0o.ooOOo0oXI(enumConstants);
                int length = enumConstants.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    D d2 = enumConstants[i];
                    D d3 = d2;
                    IIX0o.ooOOo0oXI(d3);
                    if (OxI.oX0I0O(d3.name(), value, true)) {
                        d = d2;
                        break;
                    }
                    i++;
                }
                d = d;
                if (d == null) {
                    throw new IllegalArgumentException("Enum value " + value + " not found for type " + this.type.getName() + '.');
                }
            }
            return d;
        }
    }
}
