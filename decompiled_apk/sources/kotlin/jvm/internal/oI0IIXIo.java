package kotlin.jvm.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.goodix.ble.gr.libdfu.BuildConfig;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.Xo0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt__StringsKt;

@XX({"SMAP\nClassReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,205:1\n1559#2:206\n1590#2,4:207\n1253#2,4:211\n1238#2,4:217\n453#3:215\n403#3:216\n*S KotlinDebug\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference\n*L\n107#1:206\n107#1:207,4\n155#1:211,4\n163#1:217,4\n163#1:215\n163#1:216\n*E\n"})
/* loaded from: classes6.dex */
public final class oI0IIXIo implements kotlin.reflect.oxoX<Object>, Oxx0xo {

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Map<String, String> f29330IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Map<Class<? extends kotlin.IIXOooo<?>>, Integer> f29331IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f29332Oo = new oIX0oI(null);

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final HashMap<String, String> f29333Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final HashMap<String, String> f29334OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final HashMap<String, String> f29335oI0IIXIo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Class<?> f29336XO;

    @XX({"SMAP\nClassReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,205:1\n1#2:206\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public final boolean I0Io(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo Class<?> jClass) {
            IIX0o.x0xO0oo(jClass, "jClass");
            Map map = oI0IIXIo.f29331IXxxXO;
            IIX0o.x0XOIxOo(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(jClass);
            if (num != null) {
                return XoX.XI0IXoo(obj, num.intValue());
            }
            if (jClass.isPrimitive()) {
                jClass = XO0OX.II0xO0.Oxx0IOOO(XO0OX.II0xO0.xxIXOIIO(jClass));
            }
            return jClass.isInstance(obj);
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x003b, code lost:
        
            if (r2 == null) goto L13;
         */
        @OXOo.oOoXoXO
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String II0xO0(@OXOo.OOXIXo java.lang.Class<?> r7) {
            /*
                r6 = this;
                java.lang.String r0 = "jClass"
                kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r0)
                boolean r0 = r7.isAnonymousClass()
                r1 = 0
                if (r0 == 0) goto Le
                goto Lb3
            Le:
                boolean r0 = r7.isLocalClass()
                if (r0 == 0) goto L6a
                java.lang.String r0 = r7.getSimpleName()
                java.lang.reflect.Method r2 = r7.getEnclosingMethod()
                r3 = 2
                r4 = 36
                if (r2 == 0) goto L41
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0)
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r2 = r2.getName()
                r5.append(r2)
                r5.append(r4)
                java.lang.String r2 = r5.toString()
                java.lang.String r2 = kotlin.text.StringsKt__StringsKt.oO0(r0, r2, r1, r3, r1)
                if (r2 != 0) goto L3e
                goto L41
            L3e:
                r1 = r2
                goto Lb3
            L41:
                java.lang.reflect.Constructor r7 = r7.getEnclosingConstructor()
                if (r7 == 0) goto L62
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r7 = r7.getName()
                r2.append(r7)
                r2.append(r4)
                java.lang.String r7 = r2.toString()
                java.lang.String r1 = kotlin.text.StringsKt__StringsKt.oO0(r0, r7, r1, r3, r1)
                goto Lb3
            L62:
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0)
                java.lang.String r1 = kotlin.text.StringsKt__StringsKt.Ox(r0, r4, r1, r3, r1)
                goto Lb3
            L6a:
                boolean r0 = r7.isArray()
                if (r0 == 0) goto L9e
                java.lang.Class r7 = r7.getComponentType()
                boolean r0 = r7.isPrimitive()
                java.lang.String r2 = "Array"
                if (r0 == 0) goto L9b
                java.util.Map r0 = kotlin.jvm.internal.oI0IIXIo.XI0IXoo()
                java.lang.String r7 = r7.getName()
                java.lang.Object r7 = r0.get(r7)
                java.lang.String r7 = (java.lang.String) r7
                if (r7 == 0) goto L9b
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r7)
                r0.append(r2)
                java.lang.String r1 = r0.toString()
            L9b:
                if (r1 != 0) goto Lb3
                goto L3e
            L9e:
                java.util.Map r0 = kotlin.jvm.internal.oI0IIXIo.XI0IXoo()
                java.lang.String r1 = r7.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 != 0) goto Lb3
                java.lang.String r1 = r7.getSimpleName()
            Lb3:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.oI0IIXIo.oIX0oI.II0xO0(java.lang.Class):java.lang.String");
        }

        @OXOo.oOoXoXO
        public final String oIX0oI(@OXOo.OOXIXo Class<?> jClass) {
            String str;
            IIX0o.x0xO0oo(jClass, "jClass");
            String str2 = null;
            if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
                return null;
            }
            if (jClass.isArray()) {
                Class<?> componentType = jClass.getComponentType();
                if (componentType.isPrimitive() && (str = (String) oI0IIXIo.f29334OxxIIOOXO.get(componentType.getName())) != null) {
                    str2 = str + "Array";
                }
                if (str2 == null) {
                    return kotlinx.serialization.internal.OxxIIOOXO.f30670oIX0oI;
                }
                return str2;
            }
            String str3 = (String) oI0IIXIo.f29334OxxIIOOXO.get(jClass.getName());
            if (str3 == null) {
                return jClass.getCanonicalName();
            }
            return str3;
        }

        public oIX0oI() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i = 0;
        List X00IoxXI2 = CollectionsKt__CollectionsKt.X00IoxXI(Oox.oIX0oI.class, Oox.oOoXoXO.class, Oox.x0xO0oo.class, Oox.IXxxXO.class, Oox.Oxx0xo.class, Oox.oI0IIXIo.class, Oox.OxxIIOOXO.class, Oox.IIXOooo.class, Oox.xoXoI.class, Oox.o00.class, Oox.II0xO0.class, Oox.I0Io.class, Oox.oxoX.class, Oox.X0o0xo.class, Oox.XO.class, Oox.Oxx0IOOO.class, Oox.II0XooXoX.class, Oox.xxIXOIIO.class, Oox.xoIox.class, Oox.OOXIXo.class, Oox.ooOOo0oXI.class, Oox.x0XOIxOo.class, Oox.oO.class);
        ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(X00IoxXI2, 10));
        for (Object obj : X00IoxXI2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            arrayList.add(Xo0.oIX0oI((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        f29331IXxxXO = kotlin.collections.o0.ooOx(arrayList);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(TypedValues.Custom.S_BOOLEAN, "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, "kotlin.Int");
        hashMap.put(TypedValues.Custom.S_FLOAT, "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f29333Oxx0xo = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f29335oI0IIXIo = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        IIX0o.oO(values, "<get-values>(...)");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            IIX0o.ooOOo0oXI(str);
            sb.append(StringsKt__StringsKt.oIxOXo(str, '.', null, 2, null));
            sb.append("CompanionObject");
            Pair oIX0oI2 = Xo0.oIX0oI(sb.toString(), str + ".Companion");
            hashMap3.put(oIX0oI2.getFirst(), oIX0oI2.getSecond());
        }
        for (Map.Entry<Class<? extends kotlin.IIXOooo<?>>, Integer> entry : f29331IXxxXO.entrySet()) {
            hashMap3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f29334OxxIIOOXO = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.collections.OI0.xoIox(hashMap3.size()));
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), StringsKt__StringsKt.oIxOXo((String) entry2.getValue(), '.', null, 2, null));
        }
        f29330IIXOooo = linkedHashMap;
    }

    public oI0IIXIo(@OXOo.OOXIXo Class<?> jClass) {
        IIX0o.x0xO0oo(jClass, "jClass");
        this.f29336XO = jClass;
    }

    @kotlin.oxxXoxO(version = "1.1")
    public static /* synthetic */ void IIX0o() {
    }

    @kotlin.oxxXoxO(version = "1.5")
    public static /* synthetic */ void IO() {
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static /* synthetic */ void IoOoX() {
    }

    @kotlin.oxxXoxO(version = "1.1")
    public static /* synthetic */ void X00IoxXI() {
    }

    @kotlin.oxxXoxO(version = "1.1")
    public static /* synthetic */ void Xx000oIo() {
    }

    @kotlin.oxxXoxO(version = "1.1")
    public static /* synthetic */ void XxX0x0xxx() {
    }

    @kotlin.oxxXoxO(version = "1.1")
    public static /* synthetic */ void oOXoIIIo() {
    }

    @kotlin.oxxXoxO(version = "1.1")
    public static /* synthetic */ void oo() {
    }

    @kotlin.oxxXoxO(version = "1.1")
    public static /* synthetic */ void oo0xXOI0I() {
    }

    @kotlin.oxxXoxO(version = "1.1")
    public static /* synthetic */ void ooXIXxIX() {
    }

    @kotlin.oxxXoxO(version = "1.1")
    public static /* synthetic */ void xI() {
    }

    @kotlin.oxxXoxO(version = "1.1")
    public static /* synthetic */ void xXxxox0I() {
    }

    @kotlin.oxxXoxO(version = "1.3")
    public static /* synthetic */ void xxX() {
    }

    @Override // kotlin.reflect.oxoX
    @OXOo.oOoXoXO
    public String II0XooXoX() {
        return f29332Oo.oIX0oI(oI0IIXIo());
    }

    @Override // kotlin.reflect.oxoX, kotlin.reflect.II0XooXoX
    @OXOo.OOXIXo
    public Collection<kotlin.reflect.I0Io<?>> II0xO0() {
        XIxXXX0x0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.oxoX
    public boolean IIXOooo() {
        XIxXXX0x0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.oxoX
    @OXOo.OOXIXo
    public Collection<kotlin.reflect.oxoX<?>> OOXIXo() {
        XIxXXX0x0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.oxoX
    public boolean Oo() {
        XIxXXX0x0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.oxoX
    public boolean OxI() {
        XIxXXX0x0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.oxoX
    @kotlin.oxxXoxO(version = "1.1")
    public boolean Oxx0xo(@OXOo.oOoXoXO Object obj) {
        return f29332Oo.I0Io(obj, oI0IIXIo());
    }

    @Override // kotlin.reflect.oxoX
    public boolean OxxIIOOXO() {
        XIxXXX0x0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.oxoX
    public boolean X0o0xo() {
        XIxXXX0x0();
        throw new KotlinNothingValueException();
    }

    public final Void XIxXXX0x0() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.oxoX
    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if ((obj instanceof oI0IIXIo) && IIX0o.Oxx0IOOO(XO0OX.II0xO0.Oxx0IOOO(this), XO0OX.II0xO0.Oxx0IOOO((kotlin.reflect.oxoX) obj))) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.II0xO0
    @OXOo.OOXIXo
    public List<Annotation> getAnnotations() {
        XIxXXX0x0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.oxoX
    @OXOo.OOXIXo
    public List<kotlin.reflect.oI0IIXIo> getTypeParameters() {
        XIxXXX0x0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.oxoX
    @OXOo.oOoXoXO
    public KVisibility getVisibility() {
        XIxXXX0x0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.oxoX
    public int hashCode() {
        return XO0OX.II0xO0.Oxx0IOOO(this).hashCode();
    }

    @Override // kotlin.reflect.oxoX
    public boolean isAbstract() {
        XIxXXX0x0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.oxoX
    public boolean isFinal() {
        XIxXXX0x0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.oxoX
    public boolean isOpen() {
        XIxXXX0x0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.oxoX
    @OXOo.OOXIXo
    public List<kotlin.reflect.Oxx0xo> o00() {
        XIxXXX0x0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.internal.Oxx0xo
    @OXOo.OOXIXo
    public Class<?> oI0IIXIo() {
        return this.f29336XO;
    }

    @Override // kotlin.reflect.oxoX
    @OXOo.oOoXoXO
    public Object oO() {
        XIxXXX0x0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.oxoX
    @OXOo.OOXIXo
    public Collection<kotlin.reflect.xxIXOIIO<Object>> oOoXoXO() {
        XIxXXX0x0();
        throw new KotlinNothingValueException();
    }

    @OXOo.OOXIXo
    public String toString() {
        return oI0IIXIo().toString() + IO.f29280II0xO0;
    }

    @Override // kotlin.reflect.oxoX
    @OXOo.OOXIXo
    public List<kotlin.reflect.oxoX<? extends Object>> x0XOIxOo() {
        XIxXXX0x0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.oxoX
    public boolean x0xO0oo() {
        XIxXXX0x0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.oxoX
    @OXOo.oOoXoXO
    public String xoXoI() {
        return f29332Oo.II0xO0(oI0IIXIo());
    }
}
