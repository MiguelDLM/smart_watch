package XO00XOO;

import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.ArrayType;

/* loaded from: classes11.dex */
public final class oIX0oI extends xoIox {

    /* renamed from: IoOoX, reason: collision with root package name */
    public final xoIox f3878IoOoX;

    public oIX0oI(xoIox xoiox) {
        this(xoiox, new ArrayList());
    }

    public static oIX0oI O0xOxO(ArrayType arrayType) {
        return X0IIOO(arrayType, new LinkedHashMap());
    }

    public static oIX0oI OxI(GenericArrayType genericArrayType, Map<Type, OOXIXo> map) {
        return XI0IXoo(xoIox.ooOOo0oXI(genericArrayType.getGenericComponentType(), map));
    }

    public static oIX0oI X0IIOO(ArrayType arrayType, Map<TypeParameterElement, OOXIXo> map) {
        return new oIX0oI(xoIox.oO(arrayType.getComponentType(), map));
    }

    public static oIX0oI XI0IXoo(xoIox xoiox) {
        return new oIX0oI(xoiox);
    }

    public static oIX0oI XIxXXX0x0(Type type) {
        return XI0IXoo(xoIox.oOoXoXO(type));
    }

    public static oIX0oI o00(GenericArrayType genericArrayType) {
        return OxI(genericArrayType, new LinkedHashMap());
    }

    @Override // XO00XOO.xoIox
    public xoIox IIXOooo() {
        return new oIX0oI(this.f3878IoOoX);
    }

    @Override // XO00XOO.xoIox
    public oxoX xoIox(oxoX oxox) throws IOException {
        return oxox.I0Io("$T[]", this.f3878IoOoX);
    }

    @Override // XO00XOO.xoIox
    /* renamed from: xoXoI, reason: merged with bridge method [inline-methods] */
    public oIX0oI I0Io(List<com.squareup.javapoet.oIX0oI> list) {
        return new oIX0oI(this.f3878IoOoX, II0XooXoX(list));
    }

    public oIX0oI(xoIox xoiox, List<com.squareup.javapoet.oIX0oI> list) {
        super(list);
        this.f3878IoOoX = (xoIox) oOoXoXO.I0Io(xoiox, "rawType == null", new Object[0]);
    }
}
