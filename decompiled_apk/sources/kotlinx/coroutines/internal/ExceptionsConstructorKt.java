package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Xo0;

@kotlin.jvm.internal.XX({"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,116:1\n1#2:117\n11335#3:118\n11670#3,3:119\n12904#3,3:136\n1963#4,14:122\n*S KotlinDebug\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n*L\n45#1:118\n45#1:119,3\n82#1:136,3\n63#1:122,14\n*E\n"})
/* loaded from: classes6.dex */
public final class ExceptionsConstructorKt {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final OOXIXo f30217II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f30218oIX0oI = X0o0xo(Throwable.class, -1);

    static {
        OOXIXo oOXIXo;
        try {
            if (oO.oIX0oI()) {
                oOXIXo = I0X0x0oIo.f30221oIX0oI;
            } else {
                oOXIXo = oxoX.f30307oIX0oI;
            }
        } catch (Throwable unused) {
            oOXIXo = I0X0x0oIo.f30221oIX0oI;
        }
        f30217II0xO0 = oOXIXo;
    }

    public static final int I0Io(Class<?> cls, int i) {
        do {
            int i2 = 0;
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i;
    }

    public static final <E extends Throwable> Oox.oOoXoXO<Throwable, Throwable> II0xO0(Class<E> cls) {
        Object obj;
        Oox.oOoXoXO<Throwable, Throwable> oooxoxo;
        Pair oIX0oI2;
        ExceptionsConstructorKt$createConstructor$nullResult$1 exceptionsConstructorKt$createConstructor$nullResult$1 = new Oox.oOoXoXO() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$nullResult$1
            @Override // Oox.oOoXoXO
            @OXOo.oOoXoXO
            public final Void invoke(@OXOo.OOXIXo Throwable th) {
                return null;
            }
        };
        if (f30218oIX0oI != X0o0xo(cls, 0)) {
            return exceptionsConstructorKt$createConstructor$nullResult$1;
        }
        Constructor<?>[] constructors = cls.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.length);
        int length = constructors.length;
        int i = 0;
        while (true) {
            obj = null;
            if (i >= length) {
                break;
            }
            final Constructor<?> constructor = constructors[i];
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            int length2 = parameterTypes.length;
            if (length2 != 0) {
                if (length2 != 1) {
                    if (length2 != 2) {
                        oIX0oI2 = Xo0.oIX0oI(null, -1);
                    } else if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(parameterTypes[0], String.class) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(parameterTypes[1], Throwable.class)) {
                        oIX0oI2 = Xo0.oIX0oI(XO(new Oox.oOoXoXO<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            @OXOo.OOXIXo
                            public final Throwable invoke(@OXOo.OOXIXo Throwable th) {
                                Object newInstance = constructor.newInstance(th.getMessage(), th);
                                kotlin.jvm.internal.IIX0o.x0XOIxOo(newInstance, "null cannot be cast to non-null type kotlin.Throwable");
                                return (Throwable) newInstance;
                            }
                        }), 3);
                    } else {
                        oIX0oI2 = Xo0.oIX0oI(null, -1);
                    }
                } else {
                    Class<?> cls2 = parameterTypes[0];
                    if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(cls2, String.class)) {
                        oIX0oI2 = Xo0.oIX0oI(XO(new Oox.oOoXoXO<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            @OXOo.OOXIXo
                            public final Throwable invoke(@OXOo.OOXIXo Throwable th) {
                                Object newInstance = constructor.newInstance(th.getMessage());
                                kotlin.jvm.internal.IIX0o.x0XOIxOo(newInstance, "null cannot be cast to non-null type kotlin.Throwable");
                                Throwable th2 = (Throwable) newInstance;
                                th2.initCause(th);
                                return th2;
                            }
                        }), 2);
                    } else if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(cls2, Throwable.class)) {
                        oIX0oI2 = Xo0.oIX0oI(XO(new Oox.oOoXoXO<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            @OXOo.OOXIXo
                            public final Throwable invoke(@OXOo.OOXIXo Throwable th) {
                                Object newInstance = constructor.newInstance(th);
                                kotlin.jvm.internal.IIX0o.x0XOIxOo(newInstance, "null cannot be cast to non-null type kotlin.Throwable");
                                return (Throwable) newInstance;
                            }
                        }), 1);
                    } else {
                        oIX0oI2 = Xo0.oIX0oI(null, -1);
                    }
                }
            } else {
                oIX0oI2 = Xo0.oIX0oI(XO(new Oox.oOoXoXO<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    @OXOo.OOXIXo
                    public final Throwable invoke(@OXOo.OOXIXo Throwable th) {
                        Object newInstance = constructor.newInstance(null);
                        kotlin.jvm.internal.IIX0o.x0XOIxOo(newInstance, "null cannot be cast to non-null type kotlin.Throwable");
                        Throwable th2 = (Throwable) newInstance;
                        th2.initCause(th);
                        return th2;
                    }
                }), 0);
            }
            arrayList.add(oIX0oI2);
            i++;
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            obj = it.next();
            if (it.hasNext()) {
                int intValue = ((Number) ((Pair) obj).getSecond()).intValue();
                do {
                    Object next = it.next();
                    int intValue2 = ((Number) ((Pair) next).getSecond()).intValue();
                    if (intValue < intValue2) {
                        obj = next;
                        intValue = intValue2;
                    }
                } while (it.hasNext());
            }
        }
        Pair pair = (Pair) obj;
        if (pair != null && (oooxoxo = (Oox.oOoXoXO) pair.getFirst()) != null) {
            return oooxoxo;
        }
        return exceptionsConstructorKt$createConstructor$nullResult$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.oOoXoXO
    public static final <E extends Throwable> E Oxx0IOOO(@OXOo.OOXIXo E e) {
        Object m287constructorimpl;
        if (e instanceof kotlinx.coroutines.IoOoX) {
            try {
                Result.oIX0oI oix0oi = Result.Companion;
                m287constructorimpl = Result.m287constructorimpl(((kotlinx.coroutines.IoOoX) e).createCopy());
            } catch (Throwable th) {
                Result.oIX0oI oix0oi2 = Result.Companion;
                m287constructorimpl = Result.m287constructorimpl(kotlin.I0oOoX.oIX0oI(th));
            }
            if (Result.m293isFailureimpl(m287constructorimpl)) {
                m287constructorimpl = null;
            }
            return (E) m287constructorimpl;
        }
        return (E) f30217II0xO0.oIX0oI(e.getClass()).invoke(e);
    }

    public static final int X0o0xo(Class<?> cls, int i) {
        Object m287constructorimpl;
        XO0OX.II0xO0.xxIXOIIO(cls);
        try {
            Result.oIX0oI oix0oi = Result.Companion;
            m287constructorimpl = Result.m287constructorimpl(Integer.valueOf(oxoX(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.oIX0oI oix0oi2 = Result.Companion;
            m287constructorimpl = Result.m287constructorimpl(kotlin.I0oOoX.oIX0oI(th));
        }
        Integer valueOf = Integer.valueOf(i);
        if (Result.m293isFailureimpl(m287constructorimpl)) {
            m287constructorimpl = valueOf;
        }
        return ((Number) m287constructorimpl).intValue();
    }

    public static final Oox.oOoXoXO<Throwable, Throwable> XO(final Oox.oOoXoXO<? super Throwable, ? extends Throwable> oooxoxo) {
        return new Oox.oOoXoXO<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$safeCtor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            @OXOo.oOoXoXO
            public final Throwable invoke(@OXOo.OOXIXo Throwable th) {
                Object m287constructorimpl;
                Oox.oOoXoXO<Throwable, Throwable> oooxoxo2 = oooxoxo;
                try {
                    Result.oIX0oI oix0oi = Result.Companion;
                    Throwable invoke = oooxoxo2.invoke(th);
                    if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(th.getMessage(), invoke.getMessage()) && !kotlin.jvm.internal.IIX0o.Oxx0IOOO(invoke.getMessage(), th.toString())) {
                        invoke = null;
                    }
                    m287constructorimpl = Result.m287constructorimpl(invoke);
                } catch (Throwable th2) {
                    Result.oIX0oI oix0oi2 = Result.Companion;
                    m287constructorimpl = Result.m287constructorimpl(kotlin.I0oOoX.oIX0oI(th2));
                }
                return (Throwable) (Result.m293isFailureimpl(m287constructorimpl) ? null : m287constructorimpl);
            }
        };
    }

    public static /* synthetic */ int oxoX(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return I0Io(cls, i);
    }
}
