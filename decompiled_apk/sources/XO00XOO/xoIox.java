package XO00XOO;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.SimpleTypeVisitor7;

/* loaded from: classes11.dex */
public class xoIox {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public String f3916IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final List<com.squareup.javapoet.oIX0oI> f3917Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final String f3918XO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final xoIox f3901Oxx0xo = new xoIox("void");

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final xoIox f3908oI0IIXIo = new xoIox(TypedValues.Custom.S_BOOLEAN);

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final xoIox f3902OxxIIOOXO = new xoIox("byte");

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final xoIox f3898IIXOooo = new xoIox("short");

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final xoIox f3914xoXoI = new xoIox(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);

    /* renamed from: o00, reason: collision with root package name */
    public static final xoIox f3907o00 = new xoIox("long");

    /* renamed from: OxI, reason: collision with root package name */
    public static final xoIox f3900OxI = new xoIox("char");

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final xoIox f3899O0xOxO = new xoIox(TypedValues.Custom.S_FLOAT);

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final xoIox f3903X0IIOO = new xoIox("double");

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final XO00XOO.II0xO0 f3904XI0IXoo = XO00XOO.II0xO0.XI0IXoo("java.lang", "Object", new String[0]);

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final XO00XOO.II0xO0 f3905XIxXXX0x0 = XO00XOO.II0xO0.XI0IXoo("java.lang", "Void", new String[0]);

    /* renamed from: xxX, reason: collision with root package name */
    public static final XO00XOO.II0xO0 f3915xxX = XO00XOO.II0xO0.XI0IXoo("java.lang", "Boolean", new String[0]);

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final XO00XOO.II0xO0 f3906XxX0x0xxx = XO00XOO.II0xO0.XI0IXoo("java.lang", "Byte", new String[0]);

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final XO00XOO.II0xO0 f3913xXxxox0I = XO00XOO.II0xO0.XI0IXoo("java.lang", "Short", new String[0]);

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final XO00XOO.II0xO0 f3897IIX0o = XO00XOO.II0xO0.XI0IXoo("java.lang", "Integer", new String[0]);

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static final XO00XOO.II0xO0 f3911ooXIXxIX = XO00XOO.II0xO0.XI0IXoo("java.lang", "Long", new String[0]);

    /* renamed from: xI, reason: collision with root package name */
    public static final XO00XOO.II0xO0 f3912xI = XO00XOO.II0xO0.XI0IXoo("java.lang", "Character", new String[0]);

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public static final XO00XOO.II0xO0 f3910oo0xXOI0I = XO00XOO.II0xO0.XI0IXoo("java.lang", "Float", new String[0]);

    /* renamed from: oo, reason: collision with root package name */
    public static final XO00XOO.II0xO0 f3909oo = XO00XOO.II0xO0.XI0IXoo("java.lang", "Double", new String[0]);

    /* loaded from: classes11.dex */
    public static /* synthetic */ class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f3919oIX0oI;

        static {
            int[] iArr = new int[TypeKind.values().length];
            f3919oIX0oI = iArr;
            try {
                iArr[TypeKind.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3919oIX0oI[TypeKind.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3919oIX0oI[TypeKind.SHORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3919oIX0oI[TypeKind.INT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3919oIX0oI[TypeKind.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3919oIX0oI[TypeKind.CHAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3919oIX0oI[TypeKind.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3919oIX0oI[TypeKind.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI extends SimpleTypeVisitor7<xoIox, Void> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ Map f3920oIX0oI;

        public oIX0oI(Map map) {
            this.f3920oIX0oI = map;
        }

        /* renamed from: I0Io, reason: merged with bridge method [inline-methods] */
        public XO00XOO.oIX0oI oxoX(ArrayType arrayType, Void r2) {
            return XO00XOO.oIX0oI.X0IIOO(arrayType, this.f3920oIX0oI);
        }

        /* renamed from: OOXIXo, reason: merged with bridge method [inline-methods] */
        public xoIox oOoXoXO(PrimitiveType primitiveType, Void r2) {
            switch (II0xO0.f3919oIX0oI[primitiveType.getKind().ordinal()]) {
                case 1:
                    return xoIox.f3908oI0IIXIo;
                case 2:
                    return xoIox.f3902OxxIIOOXO;
                case 3:
                    return xoIox.f3898IIXOooo;
                case 4:
                    return xoIox.f3914xoXoI;
                case 5:
                    return xoIox.f3907o00;
                case 6:
                    return xoIox.f3900OxI;
                case 7:
                    return xoIox.f3899O0xOxO;
                case 8:
                    return xoIox.f3903X0IIOO;
                default:
                    throw new AssertionError();
            }
        }

        /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
        public xoIox II0XooXoX(ErrorType errorType, Void r2) {
            return XO(errorType, r2);
        }

        /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
        public xoIox XO(DeclaredType declaredType, Void r7) {
            xoIox xoiox;
            XO00XOO.II0xO0 XIxXXX0x02 = XO00XOO.II0xO0.XIxXXX0x0(declaredType.asElement());
            TypeMirror enclosingType = declaredType.getEnclosingType();
            if (enclosingType.getKind() != TypeKind.NONE && !declaredType.asElement().getModifiers().contains(Modifier.STATIC)) {
                xoiox = (xoIox) enclosingType.accept(this, (Object) null);
            } else {
                xoiox = null;
            }
            if (declaredType.getTypeArguments().isEmpty() && !(xoiox instanceof xxIXOIIO)) {
                return XIxXXX0x02;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = declaredType.getTypeArguments().iterator();
            while (it.hasNext()) {
                arrayList.add(xoIox.oO((TypeMirror) it.next(), this.f3920oIX0oI));
            }
            if (xoiox instanceof xxIXOIIO) {
                return ((xxIXOIIO) xoiox).XIxXXX0x0(XIxXXX0x02.oo0xXOI0I(), arrayList);
            }
            return new xxIXOIIO(null, XIxXXX0x02, arrayList);
        }

        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public xoIox II0xO0(TypeMirror typeMirror, Void r4) {
            throw new IllegalArgumentException("Unexpected type mirror: " + typeMirror);
        }

        /* renamed from: oO, reason: merged with bridge method [inline-methods] */
        public xoIox x0xO0oo(WildcardType wildcardType, Void r2) {
            return ooOOo0oXI.X0IIOO(wildcardType, this.f3920oIX0oI);
        }

        /* renamed from: ooOOo0oXI, reason: merged with bridge method [inline-methods] */
        public xoIox x0XOIxOo(TypeVariable typeVariable, Void r2) {
            return OOXIXo.XxX0x0xxx(typeVariable, this.f3920oIX0oI);
        }

        /* renamed from: xxIXOIIO, reason: merged with bridge method [inline-methods] */
        public xoIox xoIox(NoType noType, Void r4) {
            if (noType.getKind() == TypeKind.VOID) {
                return xoIox.f3901Oxx0xo;
            }
            return (xoIox) super.visitUnknown(noType, r4);
        }
    }

    public xoIox(String str) {
        this(str, new ArrayList());
    }

    public static List<xoIox> Oxx0xo(Type[] typeArr) {
        return oI0IIXIo(typeArr, new LinkedHashMap());
    }

    public static xoIox XO(xoIox xoiox) {
        if (xoiox instanceof XO00XOO.oIX0oI) {
            return ((XO00XOO.oIX0oI) xoiox).f3878IoOoX;
        }
        return null;
    }

    public static List<xoIox> oI0IIXIo(Type[] typeArr, Map<Type, OOXIXo> map) {
        ArrayList arrayList = new ArrayList(typeArr.length);
        for (Type type : typeArr) {
            arrayList.add(ooOOo0oXI(type, map));
        }
        return arrayList;
    }

    public static xoIox oO(TypeMirror typeMirror, Map<TypeParameterElement, OOXIXo> map) {
        return (xoIox) typeMirror.accept(new oIX0oI(map), (Object) null);
    }

    public static xoIox oOoXoXO(Type type) {
        return ooOOo0oXI(type, new LinkedHashMap());
    }

    public static xoIox ooOOo0oXI(Type type, Map<Type, OOXIXo> map) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (type == Void.TYPE) {
                return f3901Oxx0xo;
            }
            if (type == Boolean.TYPE) {
                return f3908oI0IIXIo;
            }
            if (type == Byte.TYPE) {
                return f3902OxxIIOOXO;
            }
            if (type == Short.TYPE) {
                return f3898IIXOooo;
            }
            if (type == Integer.TYPE) {
                return f3914xoXoI;
            }
            if (type == Long.TYPE) {
                return f3907o00;
            }
            if (type == Character.TYPE) {
                return f3900OxI;
            }
            if (type == Float.TYPE) {
                return f3899O0xOxO;
            }
            if (type == Double.TYPE) {
                return f3903X0IIOO;
            }
            if (cls.isArray()) {
                return XO00XOO.oIX0oI.XI0IXoo(ooOOo0oXI(cls.getComponentType(), map));
            }
            return XO00XOO.II0xO0.X0IIOO(cls);
        }
        if (type instanceof ParameterizedType) {
            return xxIXOIIO.X0IIOO((ParameterizedType) type, map);
        }
        if (type instanceof java.lang.reflect.WildcardType) {
            return ooOOo0oXI.OxI((java.lang.reflect.WildcardType) type, map);
        }
        if (type instanceof java.lang.reflect.TypeVariable) {
            return OOXIXo.XI0IXoo((java.lang.reflect.TypeVariable) type, map);
        }
        if (type instanceof GenericArrayType) {
            return XO00XOO.oIX0oI.OxI((GenericArrayType) type, map);
        }
        throw new IllegalArgumentException("unexpected type: " + type);
    }

    public static xoIox x0XOIxOo(TypeMirror typeMirror) {
        return oO(typeMirror, new LinkedHashMap());
    }

    public xoIox I0Io(List<com.squareup.javapoet.oIX0oI> list) {
        oOoXoXO.I0Io(list, "annotations == null", new Object[0]);
        return new xoIox(this.f3918XO, II0XooXoX(list));
    }

    public final List<com.squareup.javapoet.oIX0oI> II0XooXoX(List<com.squareup.javapoet.oIX0oI> list) {
        ArrayList arrayList = new ArrayList(this.f3917Oo);
        arrayList.addAll(list);
        return arrayList;
    }

    public xoIox IIXOooo() {
        return new xoIox(this.f3918XO);
    }

    public boolean IXxxXO() {
        if (this.f3918XO != null && this != f3901Oxx0xo) {
            return true;
        }
        return false;
    }

    public oxoX OOXIXo(oxoX oxox) throws IOException {
        Iterator<com.squareup.javapoet.oIX0oI> it = this.f3917Oo.iterator();
        while (it.hasNext()) {
            it.next().I0Io(oxox, true);
            oxox.II0xO0(" ");
        }
        return oxox;
    }

    public boolean Oo() {
        if (!equals(f3915xxX) && !equals(f3906XxX0x0xxx) && !equals(f3913xXxxox0I) && !equals(f3897IIX0o) && !equals(f3911ooXIXxIX) && !equals(f3912xI) && !equals(f3910oo0xXOI0I) && !equals(f3909oo)) {
            return false;
        }
        return true;
    }

    public xoIox Oxx0IOOO() {
        if (this.f3918XO == null) {
            return this;
        }
        if (this == f3901Oxx0xo) {
            return f3905XIxXXX0x0;
        }
        if (this == f3908oI0IIXIo) {
            return f3915xxX;
        }
        if (this == f3902OxxIIOOXO) {
            return f3906XxX0x0xxx;
        }
        if (this == f3898IIXOooo) {
            return f3913xXxxox0I;
        }
        if (this == f3914xoXoI) {
            return f3897IIX0o;
        }
        if (this == f3907o00) {
            return f3911ooXIXxIX;
        }
        if (this == f3900OxI) {
            return f3912xI;
        }
        if (this == f3899O0xOxO) {
            return f3910oo0xXOI0I;
        }
        if (this == f3903X0IIOO) {
            return f3909oo;
        }
        throw new AssertionError(this.f3918XO);
    }

    public xoIox OxxIIOOXO() {
        if (this.f3918XO != null) {
            return this;
        }
        if (equals(f3905XIxXXX0x0)) {
            return f3901Oxx0xo;
        }
        if (equals(f3915xxX)) {
            return f3908oI0IIXIo;
        }
        if (equals(f3906XxX0x0xxx)) {
            return f3902OxxIIOOXO;
        }
        if (equals(f3913xXxxox0I)) {
            return f3898IIXOooo;
        }
        if (equals(f3897IIX0o)) {
            return f3914xoXoI;
        }
        if (equals(f3911ooXIXxIX)) {
            return f3907o00;
        }
        if (equals(f3912xI)) {
            return f3900OxI;
        }
        if (equals(f3910oo0xXOI0I)) {
            return f3899O0xOxO;
        }
        if (equals(f3909oo)) {
            return f3903X0IIOO;
        }
        throw new UnsupportedOperationException("cannot unbox " + this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return toString().equals(obj.toString());
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final xoIox oxoX(com.squareup.javapoet.oIX0oI... oix0oiArr) {
        return I0Io(Arrays.asList(oix0oiArr));
    }

    public final String toString() {
        String str = this.f3916IXxxXO;
        if (str == null) {
            try {
                StringBuilder sb = new StringBuilder();
                oxoX oxox = new oxoX(sb);
                OOXIXo(oxox);
                xoIox(oxox);
                String sb2 = sb.toString();
                this.f3916IXxxXO = sb2;
                return sb2;
            } catch (IOException unused) {
                throw new AssertionError();
            }
        }
        return str;
    }

    public boolean x0xO0oo() {
        return !this.f3917Oo.isEmpty();
    }

    public oxoX xoIox(oxoX oxox) throws IOException {
        String str = this.f3918XO;
        if (str != null) {
            return oxox.oxoX(str);
        }
        throw new AssertionError();
    }

    public xoIox(String str, List<com.squareup.javapoet.oIX0oI> list) {
        this.f3918XO = str;
        this.f3917Oo = oOoXoXO.XO(list);
    }

    public xoIox(List<com.squareup.javapoet.oIX0oI> list) {
        this(null, list);
    }
}
