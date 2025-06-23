package XO00XOO;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;

/* loaded from: classes11.dex */
public final class OOXIXo extends xoIox {

    /* renamed from: IoOoX, reason: collision with root package name */
    public final String f3869IoOoX;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public final List<xoIox> f3870oOXoIIIo;

    public OOXIXo(String str, List<xoIox> list) {
        this(str, list, new ArrayList());
    }

    public static OOXIXo O0xOxO(String str, Type... typeArr) {
        return xXxxox0I(str, xoIox.Oxx0xo(typeArr));
    }

    public static OOXIXo OxI(String str, xoIox... xoioxArr) {
        return xXxxox0I(str, Arrays.asList(xoioxArr));
    }

    public static OOXIXo X0IIOO(TypeVariable<?> typeVariable) {
        return XI0IXoo(typeVariable, new LinkedHashMap());
    }

    public static OOXIXo XI0IXoo(TypeVariable<?> typeVariable, Map<Type, OOXIXo> map) {
        OOXIXo oOXIXo = map.get(typeVariable);
        if (oOXIXo == null) {
            ArrayList arrayList = new ArrayList();
            OOXIXo oOXIXo2 = new OOXIXo(typeVariable.getName(), Collections.unmodifiableList(arrayList));
            map.put(typeVariable, oOXIXo2);
            for (Type type : typeVariable.getBounds()) {
                arrayList.add(xoIox.ooOOo0oXI(type, map));
            }
            arrayList.remove(xoIox.f3904XI0IXoo);
            return oOXIXo2;
        }
        return oOXIXo;
    }

    public static OOXIXo XIxXXX0x0(TypeParameterElement typeParameterElement) {
        String obj = typeParameterElement.getSimpleName().toString();
        List bounds = typeParameterElement.getBounds();
        ArrayList arrayList = new ArrayList();
        Iterator it = bounds.iterator();
        while (it.hasNext()) {
            arrayList.add(xoIox.x0XOIxOo((TypeMirror) it.next()));
        }
        return xXxxox0I(obj, arrayList);
    }

    public static OOXIXo XxX0x0xxx(javax.lang.model.type.TypeVariable typeVariable, Map<TypeParameterElement, OOXIXo> map) {
        TypeParameterElement typeParameterElement = (TypeParameterElement) typeVariable.asElement();
        OOXIXo oOXIXo = map.get(typeParameterElement);
        if (oOXIXo == null) {
            ArrayList arrayList = new ArrayList();
            OOXIXo oOXIXo2 = new OOXIXo(typeParameterElement.getSimpleName().toString(), Collections.unmodifiableList(arrayList));
            map.put(typeParameterElement, oOXIXo2);
            Iterator it = typeParameterElement.getBounds().iterator();
            while (it.hasNext()) {
                arrayList.add(xoIox.oO((TypeMirror) it.next(), map));
            }
            arrayList.remove(xoIox.f3904XI0IXoo);
            return oOXIXo2;
        }
        return oOXIXo;
    }

    public static OOXIXo o00(String str) {
        return xXxxox0I(str, Collections.emptyList());
    }

    public static OOXIXo xXxxox0I(String str, List<xoIox> list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.remove(xoIox.f3904XI0IXoo);
        return new OOXIXo(str, Collections.unmodifiableList(arrayList));
    }

    public static OOXIXo xxX(javax.lang.model.type.TypeVariable typeVariable) {
        return XIxXXX0x0(typeVariable.asElement());
    }

    public OOXIXo IIX0o(List<? extends xoIox> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f3870oOXoIIIo);
        arrayList.addAll(list);
        return new OOXIXo(this.f3869IoOoX, arrayList, this.f3917Oo);
    }

    @Override // XO00XOO.xoIox
    public xoIox IIXOooo() {
        return new OOXIXo(this.f3869IoOoX, this.f3870oOXoIIIo);
    }

    public OOXIXo ooXIXxIX(xoIox... xoioxArr) {
        return IIX0o(Arrays.asList(xoioxArr));
    }

    public OOXIXo xI(Type... typeArr) {
        return IIX0o(xoIox.Oxx0xo(typeArr));
    }

    @Override // XO00XOO.xoIox
    public oxoX xoIox(oxoX oxox) throws IOException {
        return oxox.oxoX(this.f3869IoOoX);
    }

    @Override // XO00XOO.xoIox
    /* renamed from: xoXoI, reason: merged with bridge method [inline-methods] */
    public OOXIXo I0Io(List<com.squareup.javapoet.oIX0oI> list) {
        return new OOXIXo(this.f3869IoOoX, this.f3870oOXoIIIo, list);
    }

    public OOXIXo(String str, List<xoIox> list, List<com.squareup.javapoet.oIX0oI> list2) {
        super(list2);
        this.f3869IoOoX = (String) oOoXoXO.I0Io(str, "name == null", new Object[0]);
        this.f3870oOXoIIIo = list;
        Iterator<xoIox> it = list.iterator();
        while (it.hasNext()) {
            xoIox next = it.next();
            oOoXoXO.II0xO0((next.IXxxXO() || next == xoIox.f3901Oxx0xo) ? false : true, "invalid bound: %s", next);
        }
    }
}
