package kotlinx.serialization.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.SerializationException;

@kotlin.jvm.internal.XX({"SMAP\nPlatform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Platform.kt\nkotlinx/serialization/internal/PlatformKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,174:1\n1#2:175\n3133#3,11:176\n1282#3,2:187\n3133#3,11:190\n3133#3,11:201\n26#4:189\n*S KotlinDebug\n*F\n+ 1 Platform.kt\nkotlinx/serialization/internal/PlatformKt\n*L\n70#1:176,11\n78#1:187,2\n161#1:190,11\n166#1:201,11\n129#1:189\n*E\n"})
/* loaded from: classes6.dex */
public final class o0xxxXXxX {
    @OXOo.oOoXoXO
    public static final <T> kotlinx.serialization.Oxx0IOOO<T> I0Io(@OXOo.OOXIXo Class<T> cls, @OXOo.OOXIXo kotlinx.serialization.Oxx0IOOO<Object>... args) {
        kotlinx.serialization.Oxx0IOOO<T> OOXIXo2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(cls, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(args, "args");
        if (cls.isEnum() && x0XOIxOo(cls)) {
            return X0o0xo(cls);
        }
        if (cls.isInterface() && (OOXIXo2 = OOXIXo(cls)) != null) {
            return OOXIXo2;
        }
        kotlinx.serialization.Oxx0IOOO<T> ooOOo0oXI2 = ooOOo0oXI(cls, (kotlinx.serialization.Oxx0IOOO[]) Arrays.copyOf(args, args.length));
        if (ooOOo0oXI2 != null) {
            return ooOOo0oXI2;
        }
        kotlinx.serialization.Oxx0IOOO<T> II0XooXoX2 = II0XooXoX(cls);
        if (II0XooXoX2 != null) {
            return II0XooXoX2;
        }
        kotlinx.serialization.Oxx0IOOO<T> XO2 = XO(cls, (kotlinx.serialization.Oxx0IOOO[]) Arrays.copyOf(args, args.length));
        if (XO2 != null) {
            return XO2;
        }
        if (oO(cls)) {
            return new PolymorphicSerializer(XO0OX.II0xO0.xxIXOIIO(cls));
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x009d, code lost:
    
        if (r4 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0056, code lost:
    
        if (r5 == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> kotlinx.serialization.Oxx0IOOO<T> II0XooXoX(java.lang.Class<T> r11) {
        /*
            java.lang.String r0 = r11.getCanonicalName()
            r1 = 0
            if (r0 == 0) goto Lae
            java.lang.String r2 = "java."
            r3 = 0
            r4 = 2
            boolean r2 = kotlin.text.OxI.IOOoXo0Ix(r0, r2, r3, r4, r1)
            if (r2 != 0) goto Lae
            java.lang.String r2 = "kotlin."
            boolean r0 = kotlin.text.OxI.IOOoXo0Ix(r0, r2, r3, r4, r1)
            if (r0 == 0) goto L1b
            goto Lae
        L1b:
            java.lang.reflect.Field[] r0 = r11.getDeclaredFields()
            java.lang.String r2 = "getDeclaredFields(...)"
            kotlin.jvm.internal.IIX0o.oO(r0, r2)
            int r2 = r0.length
            r6 = r1
            r4 = 0
            r5 = 0
        L28:
            r7 = 1
            if (r4 >= r2) goto L56
            r8 = r0[r4]
            java.lang.String r9 = r8.getName()
            java.lang.String r10 = "INSTANCE"
            boolean r9 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r9, r10)
            if (r9 == 0) goto L53
            java.lang.Class r9 = r8.getType()
            boolean r9 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r9, r11)
            if (r9 == 0) goto L53
            int r9 = r8.getModifiers()
            boolean r9 = java.lang.reflect.Modifier.isStatic(r9)
            if (r9 == 0) goto L53
            if (r5 == 0) goto L51
        L4f:
            r6 = r1
            goto L59
        L51:
            r6 = r8
            r5 = 1
        L53:
            int r4 = r4 + 1
            goto L28
        L56:
            if (r5 != 0) goto L59
            goto L4f
        L59:
            if (r6 != 0) goto L5c
            return r1
        L5c:
            java.lang.Object r0 = r6.get(r1)
            java.lang.reflect.Method[] r11 = r11.getMethods()
            java.lang.String r2 = "getMethods(...)"
            kotlin.jvm.internal.IIX0o.oO(r11, r2)
            int r2 = r11.length
            r5 = r1
            r4 = 0
        L6c:
            if (r3 >= r2) goto L9d
            r6 = r11[r3]
            java.lang.String r8 = r6.getName()
            java.lang.String r9 = "serializer"
            boolean r8 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r8, r9)
            if (r8 == 0) goto L9a
            java.lang.Class[] r8 = r6.getParameterTypes()
            java.lang.String r9 = "getParameterTypes(...)"
            kotlin.jvm.internal.IIX0o.oO(r8, r9)
            int r8 = r8.length
            if (r8 != 0) goto L9a
            java.lang.Class r8 = r6.getReturnType()
            java.lang.Class<kotlinx.serialization.Oxx0IOOO> r9 = kotlinx.serialization.Oxx0IOOO.class
            boolean r8 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r8, r9)
            if (r8 == 0) goto L9a
            if (r4 == 0) goto L98
        L96:
            r5 = r1
            goto La0
        L98:
            r5 = r6
            r4 = 1
        L9a:
            int r3 = r3 + 1
            goto L6c
        L9d:
            if (r4 != 0) goto La0
            goto L96
        La0:
            if (r5 != 0) goto La3
            return r1
        La3:
            java.lang.Object r11 = r5.invoke(r0, r1)
            boolean r0 = r11 instanceof kotlinx.serialization.Oxx0IOOO
            if (r0 == 0) goto Lae
            r1 = r11
            kotlinx.serialization.Oxx0IOOO r1 = (kotlinx.serialization.Oxx0IOOO) r1
        Lae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.o0xxxXXxX.II0XooXoX(java.lang.Class):kotlinx.serialization.Oxx0IOOO");
    }

    @OXOo.oOoXoXO
    public static final <T> kotlinx.serialization.Oxx0IOOO<T> II0xO0(@OXOo.OOXIXo kotlin.reflect.oxoX<T> oxox) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oxox, "<this>");
        return oxoX(oxox, new kotlinx.serialization.Oxx0IOOO[0]);
    }

    @OXOo.OOXIXo
    public static final Void IXxxXO(@OXOo.OOXIXo Class<?> cls) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cls, "<this>");
        throw new SerializationException(O00XxXI.xxIXOIIO(XO0OX.II0xO0.xxIXOIIO(cls)));
    }

    public static final <T> kotlinx.serialization.Oxx0IOOO<T> OOXIXo(Class<T> cls) {
        kotlinx.serialization.IXxxXO iXxxXO = (kotlinx.serialization.IXxxXO) cls.getAnnotation(kotlinx.serialization.IXxxXO.class);
        if (iXxxXO != null && !kotlin.jvm.internal.IIX0o.Oxx0IOOO(kotlin.jvm.internal.IO.oxoX(iXxxXO.with()), kotlin.jvm.internal.IO.oxoX(PolymorphicSerializer.class))) {
            return null;
        }
        return new PolymorphicSerializer(XO0OX.II0xO0.xxIXOIIO(cls));
    }

    @OXOo.OOXIXo
    public static final Void Oo(@OXOo.OOXIXo kotlin.reflect.oxoX<?> oxox) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oxox, "<this>");
        O00XxXI.xoIox(oxox);
        throw new KotlinNothingValueException();
    }

    public static final <T> Object Oxx0IOOO(Class<T> cls) {
        Class<?> cls2;
        Class<?>[] declaredClasses = cls.getDeclaredClasses();
        kotlin.jvm.internal.IIX0o.oO(declaredClasses, "getDeclaredClasses(...)");
        int length = declaredClasses.length;
        int i = 0;
        while (true) {
            if (i < length) {
                cls2 = declaredClasses[i];
                if (cls2.getAnnotation(xoxXI.class) != null) {
                    break;
                }
                i++;
            } else {
                cls2 = null;
                break;
            }
        }
        if (cls2 == null) {
            return null;
        }
        String simpleName = cls2.getSimpleName();
        kotlin.jvm.internal.IIX0o.oO(simpleName, "getSimpleName(...)");
        return oIX0oI(cls, simpleName);
    }

    @OXOo.OOXIXo
    public static final <T, E extends T> E[] Oxx0xo(@OXOo.OOXIXo ArrayList<E> arrayList, @OXOo.OOXIXo kotlin.reflect.oxoX<T> eClass) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(arrayList, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(eClass, "eClass");
        Object newInstance = Array.newInstance((Class<?>) XO0OX.II0xO0.X0o0xo(eClass), arrayList.size());
        kotlin.jvm.internal.IIX0o.x0XOIxOo(newInstance, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        E[] eArr = (E[]) arrayList.toArray((Object[]) newInstance);
        kotlin.jvm.internal.IIX0o.oO(eArr, "toArray(...)");
        return eArr;
    }

    public static final <T> kotlinx.serialization.Oxx0IOOO<T> X0o0xo(Class<T> cls) {
        T[] enumConstants = cls.getEnumConstants();
        String canonicalName = cls.getCanonicalName();
        kotlin.jvm.internal.IIX0o.oO(canonicalName, "getCanonicalName(...)");
        kotlin.jvm.internal.IIX0o.x0XOIxOo(enumConstants, "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
        return new EnumSerializer(canonicalName, (Enum[]) enumConstants);
    }

    public static final <T> kotlinx.serialization.Oxx0IOOO<T> XO(Class<T> cls, kotlinx.serialization.Oxx0IOOO<Object>... oxx0IOOOArr) {
        Object obj;
        Field field;
        kotlinx.serialization.Oxx0IOOO<T> oOoXoXO2;
        Object Oxx0IOOO2 = Oxx0IOOO(cls);
        if (Oxx0IOOO2 != null && (oOoXoXO2 = oOoXoXO(Oxx0IOOO2, (kotlinx.serialization.Oxx0IOOO[]) Arrays.copyOf(oxx0IOOOArr, oxx0IOOOArr.length))) != null) {
            return oOoXoXO2;
        }
        try {
            Class<?>[] declaredClasses = cls.getDeclaredClasses();
            kotlin.jvm.internal.IIX0o.oO(declaredClasses, "getDeclaredClasses(...)");
            int length = declaredClasses.length;
            int i = 0;
            Class<?> cls2 = null;
            boolean z = false;
            while (true) {
                if (i < length) {
                    Class<?> cls3 = declaredClasses[i];
                    if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(cls3.getSimpleName(), "$serializer")) {
                        if (z) {
                            break;
                        }
                        z = true;
                        cls2 = cls3;
                    }
                    i++;
                } else if (!z) {
                }
            }
            cls2 = null;
            if (cls2 != null && (field = cls2.getField("INSTANCE")) != null) {
                obj = field.get(null);
            } else {
                obj = null;
            }
            if (!(obj instanceof kotlinx.serialization.Oxx0IOOO)) {
                return null;
            }
            return (kotlinx.serialization.Oxx0IOOO) obj;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    public static final Object oIX0oI(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final <T> boolean oO(Class<T> cls) {
        if (cls.getAnnotation(kotlinx.serialization.xoIox.class) != null) {
            return true;
        }
        kotlinx.serialization.IXxxXO iXxxXO = (kotlinx.serialization.IXxxXO) cls.getAnnotation(kotlinx.serialization.IXxxXO.class);
        if (iXxxXO != null && kotlin.jvm.internal.IIX0o.Oxx0IOOO(kotlin.jvm.internal.IO.oxoX(iXxxXO.with()), kotlin.jvm.internal.IO.oxoX(PolymorphicSerializer.class))) {
            return true;
        }
        return false;
    }

    public static final <T> kotlinx.serialization.Oxx0IOOO<T> oOoXoXO(Object obj, kotlinx.serialization.Oxx0IOOO<Object>... oxx0IOOOArr) {
        Class[] clsArr;
        try {
            if (oxx0IOOOArr.length == 0) {
                clsArr = new Class[0];
            } else {
                int length = oxx0IOOOArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i = 0; i < length; i++) {
                    clsArr2[i] = kotlinx.serialization.Oxx0IOOO.class;
                }
                clsArr = clsArr2;
            }
            Object invoke = obj.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(clsArr, clsArr.length)).invoke(obj, Arrays.copyOf(oxx0IOOOArr, oxx0IOOOArr.length));
            if (!(invoke instanceof kotlinx.serialization.Oxx0IOOO)) {
                return null;
            }
            return (kotlinx.serialization.Oxx0IOOO) invoke;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause != null) {
                String message = cause.getMessage();
                if (message == null) {
                    message = e.getMessage();
                }
                throw new InvocationTargetException(cause, message);
            }
            throw e;
        }
    }

    public static final <T> kotlinx.serialization.Oxx0IOOO<T> ooOOo0oXI(Class<?> cls, kotlinx.serialization.Oxx0IOOO<Object>... oxx0IOOOArr) {
        Object oIX0oI2 = oIX0oI(cls, "Companion");
        if (oIX0oI2 == null) {
            return null;
        }
        return oOoXoXO(oIX0oI2, (kotlinx.serialization.Oxx0IOOO[]) Arrays.copyOf(oxx0IOOOArr, oxx0IOOOArr.length));
    }

    @OXOo.oOoXoXO
    public static final <T> kotlinx.serialization.Oxx0IOOO<T> oxoX(@OXOo.OOXIXo kotlin.reflect.oxoX<T> oxox, @OXOo.OOXIXo kotlinx.serialization.Oxx0IOOO<Object>... args) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oxox, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(args, "args");
        return I0Io(XO0OX.II0xO0.X0o0xo(oxox), (kotlinx.serialization.Oxx0IOOO[]) Arrays.copyOf(args, args.length));
    }

    public static final <T> boolean x0XOIxOo(Class<T> cls) {
        if (cls.getAnnotation(kotlinx.serialization.IXxxXO.class) == null && cls.getAnnotation(kotlinx.serialization.xoIox.class) == null) {
            return true;
        }
        return false;
    }

    public static final boolean x0xO0oo(@OXOo.OOXIXo kotlin.reflect.oxoX<Object> rootClass) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(rootClass, "rootClass");
        return XO0OX.II0xO0.X0o0xo(rootClass).isArray();
    }

    public static final boolean xoIox(@OXOo.OOXIXo boolean[] zArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        return zArr[i];
    }

    public static final <T> T xxIXOIIO(@OXOo.OOXIXo T[] tArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return tArr[i];
    }
}
