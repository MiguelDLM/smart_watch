package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import XO0OX.x0XOIxOo;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.text.OxI;
import okhttp3.HttpUrl;

public abstract class NavType<T> {
    @XO
    @OOXIXo
    public static final NavType<boolean[]> BoolArrayType = new NavType$Companion$BoolArrayType$1();
    @XO
    @OOXIXo
    public static final NavType<List<Boolean>> BoolListType = new NavType$Companion$BoolListType$1();
    @XO
    @OOXIXo
    public static final NavType<Boolean> BoolType = new NavType$Companion$BoolType$1();
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @XO
    @OOXIXo
    public static final NavType<float[]> FloatArrayType = new NavType$Companion$FloatArrayType$1();
    @XO
    @OOXIXo
    public static final NavType<List<Float>> FloatListType = new NavType$Companion$FloatListType$1();
    @XO
    @OOXIXo
    public static final NavType<Float> FloatType = new NavType$Companion$FloatType$1();
    @XO
    @OOXIXo
    public static final NavType<int[]> IntArrayType = new NavType$Companion$IntArrayType$1();
    @XO
    @OOXIXo
    public static final NavType<List<Integer>> IntListType = new NavType$Companion$IntListType$1();
    @XO
    @OOXIXo
    public static final NavType<Integer> IntType = new NavType$Companion$IntType$1();
    @XO
    @OOXIXo
    public static final NavType<long[]> LongArrayType = new NavType$Companion$LongArrayType$1();
    @XO
    @OOXIXo
    public static final NavType<List<Long>> LongListType = new NavType$Companion$LongListType$1();
    @XO
    @OOXIXo
    public static final NavType<Long> LongType = new NavType$Companion$LongType$1();
    @XO
    @OOXIXo
    public static final NavType<Integer> ReferenceType = new NavType$Companion$ReferenceType$1();
    @XO
    @OOXIXo
    public static final NavType<String[]> StringArrayType = new NavType$Companion$StringArrayType$1();
    @XO
    @OOXIXo
    public static final NavType<List<String>> StringListType = new NavType$Companion$StringListType$1();
    @XO
    @OOXIXo
    public static final NavType<String> StringType = new NavType$Companion$StringType$1();
    private final boolean isNullableAllowed;
    @OOXIXo
    private final String name = "nav_type";

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OOXIXo
        public NavType<?> fromArgType(@oOoXoXO String str, @oOoXoXO String str2) {
            String str3;
            NavType<Integer> navType = NavType.IntType;
            if (IIX0o.Oxx0IOOO(navType.getName(), str)) {
                return navType;
            }
            NavType<int[]> navType2 = NavType.IntArrayType;
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
            NavType<long[]> navType5 = NavType.LongArrayType;
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
            NavType<boolean[]> navType8 = NavType.BoolArrayType;
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
            NavType<String[]> navType11 = NavType.StringArrayType;
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
            NavType<float[]> navType14 = NavType.FloatArrayType;
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
            if (str == null || str.length() == 0) {
                return navType10;
            }
            try {
                if (!OxI.IOOoXo0Ix(str, FileUtils.FILE_EXTENSION_SEPARATOR, false, 2, (Object) null) || str2 == null) {
                    str3 = str;
                } else {
                    str3 = str2 + str;
                }
                boolean XO0o2 = OxI.XO0o(str, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, false, 2, (Object) null);
                if (XO0o2) {
                    str3 = str3.substring(0, str3.length() - 2);
                    IIX0o.oO(str3, "substring(...)");
                }
                Class<?> cls = Class.forName(str3);
                IIX0o.oO(cls, "clazz");
                NavType<?> parseSerializableOrParcelableType$navigation_common_release = parseSerializableOrParcelableType$navigation_common_release(cls, XO0o2);
                if (parseSerializableOrParcelableType$navigation_common_release != null) {
                    return parseSerializableOrParcelableType$navigation_common_release;
                }
                throw new IllegalArgumentException((str3 + " is not Serializable or Parcelable.").toString());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r1 = androidx.navigation.NavType.BoolType;
            r1.parseValue(r3);
            kotlin.jvm.internal.IIX0o.x0XOIxOo(r1, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
            r3 = androidx.navigation.NavType.StringType;
            kotlin.jvm.internal.IIX0o.x0XOIxOo(r3, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
            return r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
            r1 = androidx.navigation.NavType.LongType;
            r1.parseValue(r3);
            kotlin.jvm.internal.IIX0o.x0XOIxOo(r1, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
            r1 = androidx.navigation.NavType.FloatType;
            r1.parseValue(r3);
            kotlin.jvm.internal.IIX0o.x0XOIxOo(r1, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
            return r1;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0019 */
        @XO0OX.x0XOIxOo
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        @OXOo.OOXIXo
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.navigation.NavType<java.lang.Object> inferFromValue(@OXOo.OOXIXo java.lang.String r3) {
            /*
                r2 = this;
                java.lang.String r0 = "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>"
                java.lang.String r1 = "value"
                kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r1)
                androidx.navigation.NavType<java.lang.Integer> r1 = androidx.navigation.NavType.IntType     // Catch:{ IllegalArgumentException -> 0x0010 }
                r1.parseValue(r3)     // Catch:{ IllegalArgumentException -> 0x0010 }
                kotlin.jvm.internal.IIX0o.x0XOIxOo(r1, r0)     // Catch:{ IllegalArgumentException -> 0x0010 }
                return r1
            L_0x0010:
                androidx.navigation.NavType<java.lang.Long> r1 = androidx.navigation.NavType.LongType     // Catch:{ IllegalArgumentException -> 0x0019 }
                r1.parseValue(r3)     // Catch:{ IllegalArgumentException -> 0x0019 }
                kotlin.jvm.internal.IIX0o.x0XOIxOo(r1, r0)     // Catch:{ IllegalArgumentException -> 0x0019 }
                return r1
            L_0x0019:
                androidx.navigation.NavType<java.lang.Float> r1 = androidx.navigation.NavType.FloatType     // Catch:{ IllegalArgumentException -> 0x0022 }
                r1.parseValue(r3)     // Catch:{ IllegalArgumentException -> 0x0022 }
                kotlin.jvm.internal.IIX0o.x0XOIxOo(r1, r0)     // Catch:{ IllegalArgumentException -> 0x0022 }
                return r1
            L_0x0022:
                androidx.navigation.NavType<java.lang.Boolean> r1 = androidx.navigation.NavType.BoolType     // Catch:{ IllegalArgumentException -> 0x002b }
                r1.parseValue(r3)     // Catch:{ IllegalArgumentException -> 0x002b }
                kotlin.jvm.internal.IIX0o.x0XOIxOo(r1, r0)     // Catch:{ IllegalArgumentException -> 0x002b }
                return r1
            L_0x002b:
                androidx.navigation.NavType<java.lang.String> r3 = androidx.navigation.NavType.StringType
                kotlin.jvm.internal.IIX0o.x0XOIxOo(r3, r0)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavType.Companion.inferFromValue(java.lang.String):androidx.navigation.NavType");
        }

        @x0XOIxOo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @OOXIXo
        public final NavType<Object> inferFromValueType(@oOoXoXO Object obj) {
            NavType<Object> serializableType;
            if (obj instanceof Integer) {
                NavType<Integer> navType = NavType.IntType;
                IIX0o.x0XOIxOo(navType, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType;
            } else if (obj instanceof int[]) {
                NavType<int[]> navType2 = NavType.IntArrayType;
                IIX0o.x0XOIxOo(navType2, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType2;
            } else if (obj instanceof Long) {
                NavType<Long> navType3 = NavType.LongType;
                IIX0o.x0XOIxOo(navType3, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType3;
            } else if (obj instanceof long[]) {
                NavType<long[]> navType4 = NavType.LongArrayType;
                IIX0o.x0XOIxOo(navType4, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType4;
            } else if (obj instanceof Float) {
                NavType<Float> navType5 = NavType.FloatType;
                IIX0o.x0XOIxOo(navType5, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType5;
            } else if (obj instanceof float[]) {
                NavType<float[]> navType6 = NavType.FloatArrayType;
                IIX0o.x0XOIxOo(navType6, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType6;
            } else if (obj instanceof Boolean) {
                NavType<Boolean> navType7 = NavType.BoolType;
                IIX0o.x0XOIxOo(navType7, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType7;
            } else if (obj instanceof boolean[]) {
                NavType<boolean[]> navType8 = NavType.BoolArrayType;
                IIX0o.x0XOIxOo(navType8, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType8;
            } else if ((obj instanceof String) || obj == null) {
                NavType<String> navType9 = NavType.StringType;
                IIX0o.x0XOIxOo(navType9, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType9;
            } else if (!(obj instanceof Object[]) || !(((Object[]) obj) instanceof String[])) {
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
            } else {
                NavType<String[]> navType10 = NavType.StringArrayType;
                IIX0o.x0XOIxOo(navType10, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType10;
            }
        }

        @oOoXoXO
        public final NavType<?> parseSerializableOrParcelableType$navigation_common_release(@OOXIXo Class<?> cls, boolean z) {
            IIX0o.x0xO0oo(cls, "clazz");
            if (Parcelable.class.isAssignableFrom(cls)) {
                if (z) {
                    return new ParcelableArrayType(cls);
                }
                return new ParcelableType(cls);
            } else if (Enum.class.isAssignableFrom(cls) && !z) {
                return new EnumType(cls);
            } else {
                if (!Serializable.class.isAssignableFrom(cls)) {
                    return null;
                }
                if (z) {
                    return new SerializableArrayType(cls);
                }
                return new SerializableType(cls);
            }
        }

        private Companion() {
        }
    }

    public static final class ParcelableArrayType<D extends Parcelable> extends NavType<D[]> {
        @OOXIXo
        private final Class<D[]> arrayType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ParcelableArrayType(@OOXIXo Class<D> cls) {
            super(true);
            IIX0o.x0xO0oo(cls, "type");
            if (Parcelable.class.isAssignableFrom(cls)) {
                try {
                    Class<?> cls2 = Class.forName("[L" + cls.getName() + ';');
                    IIX0o.x0XOIxOo(cls2, "null cannot be cast to non-null type java.lang.Class<kotlin.Array<D of androidx.navigation.NavType.ParcelableArrayType>>");
                    this.arrayType = cls2;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new IllegalArgumentException((cls + " does not implement Parcelable.").toString());
            }
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!IIX0o.Oxx0IOOO(ParcelableArrayType.class, obj.getClass())) {
                return false;
            }
            return IIX0o.Oxx0IOOO(this.arrayType, ((ParcelableArrayType) obj).arrayType);
        }

        @OOXIXo
        public String getName() {
            String name = this.arrayType.getName();
            IIX0o.oO(name, "arrayType.name");
            return name;
        }

        public int hashCode() {
            return this.arrayType.hashCode();
        }

        @oOoXoXO
        public D[] get(@OOXIXo Bundle bundle, @OOXIXo String str) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(str, "key");
            return (Parcelable[]) bundle.get(str);
        }

        @OOXIXo
        public D[] parseValue(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public void put(@OOXIXo Bundle bundle, @OOXIXo String str, @oOoXoXO D[] dArr) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(str, "key");
            this.arrayType.cast(dArr);
            bundle.putParcelableArray(str, dArr);
        }

        public boolean valueEquals(@oOoXoXO D[] dArr, @oOoXoXO D[] dArr2) {
            return kotlin.collections.oOoXoXO.Oxx0IOOO(dArr, dArr2);
        }
    }

    public static final class ParcelableType<D> extends NavType<D> {
        @OOXIXo
        private final Class<D> type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ParcelableType(@OOXIXo Class<D> cls) {
            super(true);
            IIX0o.x0xO0oo(cls, "type");
            if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                this.type = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " does not implement Parcelable or Serializable.").toString());
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!IIX0o.Oxx0IOOO(ParcelableType.class, obj.getClass())) {
                return false;
            }
            return IIX0o.Oxx0IOOO(this.type, ((ParcelableType) obj).type);
        }

        @oOoXoXO
        public D get(@OOXIXo Bundle bundle, @OOXIXo String str) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(str, "key");
            return bundle.get(str);
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

        public D parseValue(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "value");
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        public void put(@OOXIXo Bundle bundle, @OOXIXo String str, D d) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(str, "key");
            this.type.cast(d);
            if (d == null || (d instanceof Parcelable)) {
                bundle.putParcelable(str, (Parcelable) d);
            } else if (d instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) d);
            }
        }
    }

    public static final class SerializableArrayType<D extends Serializable> extends NavType<D[]> {
        @OOXIXo
        private final Class<D[]> arrayType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SerializableArrayType(@OOXIXo Class<D> cls) {
            super(true);
            IIX0o.x0xO0oo(cls, "type");
            if (Serializable.class.isAssignableFrom(cls)) {
                try {
                    Class<?> cls2 = Class.forName("[L" + cls.getName() + ';');
                    IIX0o.x0XOIxOo(cls2, "null cannot be cast to non-null type java.lang.Class<kotlin.Array<D of androidx.navigation.NavType.SerializableArrayType>>");
                    this.arrayType = cls2;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
            }
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!IIX0o.Oxx0IOOO(SerializableArrayType.class, obj.getClass())) {
                return false;
            }
            return IIX0o.Oxx0IOOO(this.arrayType, ((SerializableArrayType) obj).arrayType);
        }

        @OOXIXo
        public String getName() {
            String name = this.arrayType.getName();
            IIX0o.oO(name, "arrayType.name");
            return name;
        }

        public int hashCode() {
            return this.arrayType.hashCode();
        }

        @oOoXoXO
        public D[] get(@OOXIXo Bundle bundle, @OOXIXo String str) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(str, "key");
            return (Serializable[]) bundle.get(str);
        }

        @OOXIXo
        public D[] parseValue(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX WARNING: type inference failed for: r4v0, types: [D[], java.lang.Object, java.io.Serializable] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void put(@OXOo.OOXIXo android.os.Bundle r2, @OXOo.OOXIXo java.lang.String r3, @OXOo.oOoXoXO D[] r4) {
            /*
                r1 = this;
                java.lang.String r0 = "bundle"
                kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
                java.lang.String r0 = "key"
                kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
                java.lang.Class<D[]> r0 = r1.arrayType
                r0.cast(r4)
                r2.putSerializable(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavType.SerializableArrayType.put(android.os.Bundle, java.lang.String, java.io.Serializable[]):void");
        }

        public boolean valueEquals(@oOoXoXO D[] dArr, @oOoXoXO D[] dArr2) {
            return kotlin.collections.oOoXoXO.Oxx0IOOO(dArr, dArr2);
        }
    }

    @XX({"SMAP\nNavType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavType.kt\nandroidx/navigation/NavType$SerializableType\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1212:1\n1#2:1213\n*E\n"})
    public static class SerializableType<D extends Serializable> extends NavType<D> {
        @OOXIXo
        private final Class<D> type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SerializableType(@OOXIXo Class<D> cls) {
            super(true);
            IIX0o.x0xO0oo(cls, "type");
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
            } else if (!cls.isEnum()) {
                this.type = cls;
            } else {
                throw new IllegalArgumentException((cls + " is an Enum. You should use EnumType instead.").toString());
            }
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SerializableType)) {
                return false;
            }
            return IIX0o.Oxx0IOOO(this.type, ((SerializableType) obj).type);
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
            return (Serializable) bundle.get(str);
        }

        @OOXIXo
        public D parseValue(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "value");
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        public void put(@OOXIXo Bundle bundle, @OOXIXo String str, @OOXIXo D d) {
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(str, "key");
            IIX0o.x0xO0oo(d, "value");
            this.type.cast(d);
            bundle.putSerializable(str, d);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SerializableType(boolean z, @OOXIXo Class<D> cls) {
            super(z);
            IIX0o.x0xO0oo(cls, "type");
            if (Serializable.class.isAssignableFrom(cls)) {
                this.type = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
        }
    }

    public NavType(boolean z) {
        this.isNullableAllowed = z;
    }

    @x0XOIxOo
    @OOXIXo
    public static NavType<?> fromArgType(@oOoXoXO String str, @oOoXoXO String str2) {
        return Companion.fromArgType(str, str2);
    }

    @x0XOIxOo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @OOXIXo
    public static final NavType<Object> inferFromValue(@OOXIXo String str) {
        return Companion.inferFromValue(str);
    }

    @x0XOIxOo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @OOXIXo
    public static final NavType<Object> inferFromValueType(@oOoXoXO Object obj) {
        return Companion.inferFromValueType(obj);
    }

    @oOoXoXO
    public abstract T get(@OOXIXo Bundle bundle, @OOXIXo String str);

    @OOXIXo
    public String getName() {
        return this.name;
    }

    public boolean isNullableAllowed() {
        return this.isNullableAllowed;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final T parseAndPut(@OOXIXo Bundle bundle, @OOXIXo String str, @OOXIXo String str2) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        IIX0o.x0xO0oo(str2, "value");
        T parseValue = parseValue(str2);
        put(bundle, str, parseValue);
        return parseValue;
    }

    public abstract T parseValue(@OOXIXo String str);

    public T parseValue(@OOXIXo String str, T t) {
        IIX0o.x0xO0oo(str, "value");
        return parseValue(str);
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
    public static final class EnumType<D extends Enum<?>> extends SerializableType<D> {
        @OOXIXo
        private final Class<D> type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EnumType(@OOXIXo Class<D> cls) {
            super(false, cls);
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

        @OOXIXo
        public D parseValue(@OOXIXo String str) {
            D d;
            IIX0o.x0xO0oo(str, "value");
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
                if (OxI.oX0I0O(((Enum) d).name(), str, true)) {
                    break;
                }
                i++;
            }
            D d2 = (Enum) d;
            if (d2 != null) {
                return d2;
            }
            throw new IllegalArgumentException("Enum value " + str + " not found for type " + this.type.getName() + '.');
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final T parseAndPut(@OOXIXo Bundle bundle, @OOXIXo String str, @oOoXoXO String str2, T t) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        if (!bundle.containsKey(str)) {
            throw new IllegalArgumentException("There is no previous value in this bundle.");
        } else if (str2 == null) {
            return t;
        } else {
            T parseValue = parseValue(str2, t);
            put(bundle, str, parseValue);
            return parseValue;
        }
    }
}
