package XO00XOO;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.WildcardType;
import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes11.dex */
public final class ooOOo0oXI extends xoIox {

    /* renamed from: IoOoX, reason: collision with root package name */
    public final List<xoIox> f3880IoOoX;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public final List<xoIox> f3881oOXoIIIo;

    public ooOOo0oXI(List<xoIox> list, List<xoIox> list2) {
        this(list, list2, new ArrayList());
    }

    public static xoIox O0xOxO(WildcardType wildcardType) {
        return X0IIOO(wildcardType, new LinkedHashMap());
    }

    public static xoIox OxI(java.lang.reflect.WildcardType wildcardType, Map<Type, OOXIXo> map) {
        return new ooOOo0oXI(xoIox.oI0IIXIo(wildcardType.getUpperBounds(), map), xoIox.oI0IIXIo(wildcardType.getLowerBounds(), map));
    }

    public static xoIox X0IIOO(WildcardType wildcardType, Map<TypeParameterElement, OOXIXo> map) {
        TypeMirror extendsBound = wildcardType.getExtendsBound();
        if (extendsBound == null) {
            TypeMirror superBound = wildcardType.getSuperBound();
            if (superBound == null) {
                return XIxXXX0x0(Object.class);
            }
            return xxX(xoIox.oO(superBound, map));
        }
        return XI0IXoo(xoIox.oO(extendsBound, map));
    }

    public static ooOOo0oXI XI0IXoo(xoIox xoiox) {
        return new ooOOo0oXI(Arrays.asList(xoiox), Collections.emptyList());
    }

    public static ooOOo0oXI XIxXXX0x0(Type type) {
        return XI0IXoo(xoIox.oOoXoXO(type));
    }

    public static ooOOo0oXI XxX0x0xxx(Type type) {
        return xxX(xoIox.oOoXoXO(type));
    }

    public static xoIox o00(java.lang.reflect.WildcardType wildcardType) {
        return OxI(wildcardType, new LinkedHashMap());
    }

    public static ooOOo0oXI xxX(xoIox xoiox) {
        return new ooOOo0oXI(Arrays.asList(xoIox.f3904XI0IXoo), Arrays.asList(xoiox));
    }

    @Override // XO00XOO.xoIox
    public xoIox IIXOooo() {
        return new ooOOo0oXI(this.f3880IoOoX, this.f3881oOXoIIIo);
    }

    @Override // XO00XOO.xoIox
    public oxoX xoIox(oxoX oxox) throws IOException {
        if (this.f3881oOXoIIIo.size() == 1) {
            return oxox.I0Io("? super $T", this.f3881oOXoIIIo.get(0));
        }
        if (this.f3880IoOoX.get(0).equals(xoIox.f3904XI0IXoo)) {
            return oxox.II0xO0(LocationInfo.NA);
        }
        return oxox.I0Io("? extends $T", this.f3880IoOoX.get(0));
    }

    @Override // XO00XOO.xoIox
    /* renamed from: xoXoI, reason: merged with bridge method [inline-methods] */
    public ooOOo0oXI I0Io(List<com.squareup.javapoet.oIX0oI> list) {
        return new ooOOo0oXI(this.f3880IoOoX, this.f3881oOXoIIIo, II0XooXoX(list));
    }

    public ooOOo0oXI(List<xoIox> list, List<xoIox> list2, List<com.squareup.javapoet.oIX0oI> list3) {
        super(list3);
        List<xoIox> XO2 = oOoXoXO.XO(list);
        this.f3880IoOoX = XO2;
        this.f3881oOXoIIIo = oOoXoXO.XO(list2);
        oOoXoXO.II0xO0(XO2.size() == 1, "unexpected extends bounds: %s", list);
        Iterator<xoIox> it = XO2.iterator();
        while (it.hasNext()) {
            xoIox next = it.next();
            oOoXoXO.II0xO0((next.IXxxXO() || next == xoIox.f3901Oxx0xo) ? false : true, "invalid upper bound: %s", next);
        }
        Iterator<xoIox> it2 = this.f3881oOXoIIIo.iterator();
        while (it2.hasNext()) {
            xoIox next2 = it2.next();
            oOoXoXO.II0xO0((next2.IXxxXO() || next2 == xoIox.f3901Oxx0xo) ? false : true, "invalid lower bound: %s", next2);
        }
    }
}
