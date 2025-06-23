package kotlin.reflect;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.ooXIXxIX;
import kotlin.oxxXoxO;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import okhttp3.HttpUrl;

@XX({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypesJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,230:1\n1#2:231\n1549#3:232\n1620#3,3:233\n1549#3:236\n1620#3,3:237\n1549#3:240\n1620#3,3:241\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypesJVMKt\n*L\n69#1:232\n69#1:233,3\n71#1:236\n71#1:237,3\n77#1:240\n77#1:241,3\n*E\n"})
/* loaded from: classes6.dex */
public final class TypesJVMKt {

    /* loaded from: classes6.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f29407oIX0oI;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f29407oIX0oI = iArr;
        }
    }

    @kotlin.IXxxXO
    public static final Type I0Io(Oxx0xo oxx0xo, boolean z) {
        Class X0o0xo2;
        int i;
        Oxx0IOOO IXxxXO2 = oxx0xo.IXxxXO();
        if (IXxxXO2 instanceof oI0IIXIo) {
            return new o00((oI0IIXIo) IXxxXO2);
        }
        if (IXxxXO2 instanceof oxoX) {
            oxoX oxox = (oxoX) IXxxXO2;
            if (z) {
                X0o0xo2 = XO0OX.II0xO0.Oxx0IOOO(oxox);
            } else {
                X0o0xo2 = XO0OX.II0xO0.X0o0xo(oxox);
            }
            List<OxxIIOOXO> arguments = oxx0xo.getArguments();
            if (arguments.isEmpty()) {
                return X0o0xo2;
            }
            if (X0o0xo2.isArray()) {
                if (X0o0xo2.getComponentType().isPrimitive()) {
                    return X0o0xo2;
                }
                OxxIIOOXO oxxIIOOXO = (OxxIIOOXO) CollectionsKt___CollectionsKt.xx0O(arguments);
                if (oxxIIOOXO != null) {
                    KVariance oIX0oI2 = oxxIIOOXO.oIX0oI();
                    Oxx0xo II0xO02 = oxxIIOOXO.II0xO0();
                    if (oIX0oI2 == null) {
                        i = -1;
                    } else {
                        i = oIX0oI.f29407oIX0oI[oIX0oI2.ordinal()];
                    }
                    if (i != -1 && i != 1) {
                        if (i != 2 && i != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        IIX0o.ooOOo0oXI(II0xO02);
                        Type oxoX2 = oxoX(II0xO02, false, 1, null);
                        if (!(oxoX2 instanceof Class)) {
                            return new kotlin.reflect.oIX0oI(oxoX2);
                        }
                        return X0o0xo2;
                    }
                    return X0o0xo2;
                }
                throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + oxx0xo);
            }
            return X0o0xo(X0o0xo2, arguments);
        }
        throw new UnsupportedOperationException("Unsupported type classifier: " + oxx0xo);
    }

    @kotlin.IXxxXO
    @xx0o0O.II0XooXoX
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static /* synthetic */ void II0XooXoX(Oxx0xo oxx0xo) {
    }

    public static final Type Oxx0IOOO(OxxIIOOXO oxxIIOOXO) {
        KVariance II0XooXoX2 = oxxIIOOXO.II0XooXoX();
        if (II0XooXoX2 == null) {
            return OxI.f29395IXxxXO.oIX0oI();
        }
        Oxx0xo Oxx0IOOO2 = oxxIIOOXO.Oxx0IOOO();
        IIX0o.ooOOo0oXI(Oxx0IOOO2);
        int i = oIX0oI.f29407oIX0oI[II0XooXoX2.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return new OxI(I0Io(Oxx0IOOO2, true), null);
                }
                throw new NoWhenBranchMatchedException();
            }
            return I0Io(Oxx0IOOO2, true);
        }
        return new OxI(null, I0Io(Oxx0IOOO2, true));
    }

    @kotlin.IXxxXO
    public static final Type X0o0xo(Class<?> cls, List<OxxIIOOXO> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            List<OxxIIOOXO> list2 = list;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(Oxx0IOOO((OxxIIOOXO) it.next()));
            }
            return new ParameterizedTypeImpl(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            List<OxxIIOOXO> list3 = list;
            ArrayList arrayList2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list3, 10));
            Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Oxx0IOOO((OxxIIOOXO) it2.next()));
            }
            return new ParameterizedTypeImpl(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        Type X0o0xo2 = X0o0xo(declaringClass, list.subList(length, list.size()));
        List<OxxIIOOXO> subList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(subList, 10));
        Iterator<T> it3 = subList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(Oxx0IOOO((OxxIIOOXO) it3.next()));
        }
        return new ParameterizedTypeImpl(cls, X0o0xo2, arrayList3);
    }

    @OXOo.OOXIXo
    public static final Type XO(@OXOo.OOXIXo Oxx0xo oxx0xo) {
        Type Oxx0IOOO2;
        IIX0o.x0xO0oo(oxx0xo, "<this>");
        if ((oxx0xo instanceof ooXIXxIX) && (Oxx0IOOO2 = ((ooXIXxIX) oxx0xo).Oxx0IOOO()) != null) {
            return Oxx0IOOO2;
        }
        return oxoX(oxx0xo, false, 1, null);
    }

    public static /* synthetic */ Type oxoX(Oxx0xo oxx0xo, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return I0Io(oxx0xo, z);
    }

    public static final String xoIox(Type type) {
        String name;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                kotlin.sequences.ooOOo0oXI x0XOIxOo2 = SequencesKt__SequencesKt.x0XOIxOo(type, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
                name = ((Class) SequencesKt___SequencesKt.xxOXOOoIX(x0XOIxOo2)).getName() + kotlin.text.OxI.xOOxI(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, SequencesKt___SequencesKt.Xo0(x0XOIxOo2));
            } else {
                name = cls.getName();
            }
            IIX0o.ooOOo0oXI(name);
            return name;
        }
        return type.toString();
    }

    @kotlin.IXxxXO
    public static /* synthetic */ void xxIXOIIO(OxxIIOOXO oxxIIOOXO) {
    }
}
