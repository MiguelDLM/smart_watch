package androidx.navigation.serialization;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import androidx.navigation.CollectionNavType;
import androidx.navigation.NavType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.OxI;

public final class InternalNavType {
    @OOXIXo
    private static final NavType<Boolean> BoolNullableType = new InternalNavType$BoolNullableType$1();
    @OOXIXo
    private static final NavType<double[]> DoubleArrayType = new InternalNavType$DoubleArrayType$1();
    @OOXIXo
    private static final NavType<List<Double>> DoubleListType = new InternalNavType$DoubleListType$1();
    @OOXIXo
    private static final NavType<Double> DoubleNullableType = new InternalNavType$DoubleNullableType$1();
    @OOXIXo
    private static final NavType<Double> DoubleType = new InternalNavType$DoubleType$1();
    @OOXIXo
    private static final NavType<Float> FloatNullableType = new InternalNavType$FloatNullableType$1();
    @OOXIXo
    public static final InternalNavType INSTANCE = new InternalNavType();
    @OOXIXo
    private static final NavType<Integer> IntNullableType = new InternalNavType$IntNullableType$1();
    @OOXIXo
    private static final NavType<Long> LongNullableType = new InternalNavType$LongNullableType$1();
    @OOXIXo
    private static final NavType<String> StringNonNullableType = new InternalNavType$StringNonNullableType$1();
    @OOXIXo
    private static final NavType<String[]> StringNullableArrayType = new InternalNavType$StringNullableArrayType$1();
    @OOXIXo
    private static final NavType<List<String>> StringNullableListType = new InternalNavType$StringNullableListType$1();

    @XX({"SMAP\nNavTypeConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavTypeConverter.kt\nandroidx/navigation/serialization/InternalNavType$EnumListType\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,577:1\n1#2:578\n1549#3:579\n1620#3,3:580\n*S KotlinDebug\n*F\n+ 1 NavTypeConverter.kt\nandroidx/navigation/serialization/InternalNavType$EnumListType\n*L\n496#1:579\n496#1:580,3\n*E\n"})
    public static final class EnumListType<D extends Enum<?>> extends CollectionNavType<List<? extends D>> {
        @OOXIXo
        private final NavType.EnumType<D> enumNavType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EnumListType(@OOXIXo Class<D> cls) {
            super(true);
            IIX0o.x0xO0oo(cls, "type");
            this.enumNavType = new NavType.EnumType<>(cls);
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EnumListType)) {
                return false;
            }
            return IIX0o.Oxx0IOOO(this.enumNavType, ((EnumListType) obj).enumNavType);
        }

        @OOXIXo
        public String getName() {
            return "List<" + this.enumNavType.getName() + "}>";
        }

        public int hashCode() {
            return this.enumNavType.hashCode();
        }

        @OOXIXo
        public List<D> emptyCollection() {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        @oOoXoXO
        public List<D> get(@OOXIXo Bundle bundle, @OOXIXo String str) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(str, "key");
            Object obj = bundle.get(str);
            if (obj instanceof List) {
                return (List) obj;
            }
            return null;
        }

        public void put(@OOXIXo Bundle bundle, @OOXIXo String str, @oOoXoXO List<? extends D> list) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(str, "key");
            bundle.putSerializable(str, list != null ? new ArrayList(list) : null);
        }

        @OOXIXo
        public List<String> serializeAsValues(@oOoXoXO List<? extends D> list) {
            if (list == null) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            Iterable<Enum> iterable = list;
            ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(iterable, 10));
            for (Enum enumR : iterable) {
                arrayList.add(enumR.toString());
            }
            return arrayList;
        }

        public boolean valueEquals(@oOoXoXO List<? extends D> list, @oOoXoXO List<? extends D> list2) {
            ArrayList arrayList = null;
            ArrayList arrayList2 = list != null ? new ArrayList(list) : null;
            if (list2 != null) {
                arrayList = new ArrayList(list2);
            }
            return IIX0o.Oxx0IOOO(arrayList2, arrayList);
        }

        @OOXIXo
        public List<D> parseValue(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "value");
            return oI0IIXIo.OOXIXo(this.enumNavType.parseValue(str));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
            r3 = kotlin.collections.CollectionsKt___CollectionsKt.o0xIIX0(r3, parseValue(r2));
         */
        @OXOo.oOoXoXO
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.List<D> parseValue(@OXOo.OOXIXo java.lang.String r2, @OXOo.oOoXoXO java.util.List<? extends D> r3) {
            /*
                r1 = this;
                java.lang.String r0 = "value"
                kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
                if (r3 == 0) goto L_0x0015
                java.util.Collection r3 = (java.util.Collection) r3
                java.util.List r0 = r1.parseValue((java.lang.String) r2)
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.List r3 = kotlin.collections.CollectionsKt___CollectionsKt.o0xIIX0(r3, r0)
                if (r3 != 0) goto L_0x0019
            L_0x0015:
                java.util.List r3 = r1.parseValue((java.lang.String) r2)
            L_0x0019:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.serialization.InternalNavType.EnumListType.parseValue(java.lang.String, java.util.List):java.util.List");
        }
    }

    public static class SerializableNullableType<D extends Serializable> extends NavType<D> {
        @OOXIXo
        private final Class<D> type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SerializableNullableType(@OOXIXo Class<D> cls) {
            super(true);
            IIX0o.x0xO0oo(cls, "type");
            this.type = cls;
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
            }
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SerializableNullableType)) {
                return false;
            }
            return IIX0o.Oxx0IOOO(this.type, ((SerializableNullableType) obj).type);
        }

        @OOXIXo
        public String getName() {
            String name = this.type.getName();
            IIX0o.oO(name, "type.name");
            return name;
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        @oOoXoXO
        public D get(@OOXIXo Bundle bundle, @OOXIXo String str) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(str, "key");
            D d = bundle.get(str);
            if (d instanceof Serializable) {
                return (Serializable) d;
            }
            return null;
        }

        @oOoXoXO
        public D parseValue(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "value");
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        public void put(@OOXIXo Bundle bundle, @OOXIXo String str, @oOoXoXO D d) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(str, "key");
            bundle.putSerializable(str, (Serializable) this.type.cast(d));
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
    public static final class EnumNullableType<D extends Enum<?>> extends SerializableNullableType<D> {
        @OOXIXo
        private final Class<D> type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EnumNullableType(@OOXIXo Class<D> cls) {
            super(cls);
            IIX0o.x0xO0oo(cls, "type");
            if (cls.isEnum()) {
                this.type = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " is not an Enum type.").toString());
        }

        @OOXIXo
        public String getName() {
            String name = this.type.getName();
            IIX0o.oO(name, "type.name");
            return name;
        }

        @oOoXoXO
        public D parseValue(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "value");
            D d = null;
            if (!IIX0o.Oxx0IOOO(str, "null")) {
                D[] enumConstants = this.type.getEnumConstants();
                IIX0o.ooOOo0oXI(enumConstants);
                int length = enumConstants.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    D d2 = enumConstants[i];
                    Enum enumR = (Enum) d2;
                    IIX0o.ooOOo0oXI(enumR);
                    if (OxI.oX0I0O(enumR.name(), str, true)) {
                        d = d2;
                        break;
                    }
                    i++;
                }
                d = (Enum) d;
                if (d == null) {
                    throw new IllegalArgumentException("Enum value " + str + " not found for type " + this.type.getName() + '.');
                }
            }
            return d;
        }
    }
}
