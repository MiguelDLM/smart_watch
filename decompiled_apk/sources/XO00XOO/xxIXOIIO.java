package XO00XOO;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes11.dex */
public final class xxIXOIIO extends xoIox {

    /* renamed from: IoOoX, reason: collision with root package name */
    public final xxIXOIIO f3921IoOoX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public final List<xoIox> f3922Xx000oIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public final II0xO0 f3923oOXoIIIo;

    public xxIXOIIO(xxIXOIIO xxixoiio, II0xO0 iI0xO0, List<xoIox> list) {
        this(xxixoiio, iI0xO0, list, new ArrayList());
    }

    public static xxIXOIIO O0xOxO(ParameterizedType parameterizedType) {
        return X0IIOO(parameterizedType, new LinkedHashMap());
    }

    public static xxIXOIIO OxI(Class<?> cls, Type... typeArr) {
        return new xxIXOIIO(null, II0xO0.X0IIOO(cls), xoIox.Oxx0xo(typeArr));
    }

    public static xxIXOIIO X0IIOO(ParameterizedType parameterizedType, Map<Type, OOXIXo> map) {
        ParameterizedType parameterizedType2;
        II0xO0 X0IIOO2 = II0xO0.X0IIOO((Class) parameterizedType.getRawType());
        if ((parameterizedType.getOwnerType() instanceof ParameterizedType) && !Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers())) {
            parameterizedType2 = (ParameterizedType) parameterizedType.getOwnerType();
        } else {
            parameterizedType2 = null;
        }
        List<xoIox> oI0IIXIo2 = xoIox.oI0IIXIo(parameterizedType.getActualTypeArguments(), map);
        if (parameterizedType2 != null) {
            return X0IIOO(parameterizedType2, map).XIxXXX0x0(X0IIOO2.oo0xXOI0I(), oI0IIXIo2);
        }
        return new xxIXOIIO(null, X0IIOO2, oI0IIXIo2);
    }

    public static xxIXOIIO o00(II0xO0 iI0xO0, xoIox... xoioxArr) {
        return new xxIXOIIO(null, iI0xO0, Arrays.asList(xoioxArr));
    }

    @Override // XO00XOO.xoIox
    public xoIox IIXOooo() {
        return new xxIXOIIO(this.f3921IoOoX, this.f3923oOXoIIIo, this.f3922Xx000oIo, new ArrayList());
    }

    public xxIXOIIO XI0IXoo(String str) {
        oOoXoXO.I0Io(str, "name == null", new Object[0]);
        return new xxIXOIIO(this, this.f3923oOXoIIIo.xXxxox0I(str), new ArrayList(), new ArrayList());
    }

    public xxIXOIIO XIxXXX0x0(String str, List<xoIox> list) {
        oOoXoXO.I0Io(str, "name == null", new Object[0]);
        return new xxIXOIIO(this, this.f3923oOXoIIIo.xXxxox0I(str), list, new ArrayList());
    }

    @Override // XO00XOO.xoIox
    public oxoX xoIox(oxoX oxox) throws IOException {
        xxIXOIIO xxixoiio = this.f3921IoOoX;
        if (xxixoiio != null) {
            xxixoiio.OOXIXo(oxox);
            this.f3921IoOoX.xoIox(oxox);
            oxox.II0xO0(FileUtils.FILE_EXTENSION_SEPARATOR + this.f3923oOXoIIIo.oo0xXOI0I());
        } else {
            this.f3923oOXoIIIo.OOXIXo(oxox);
            this.f3923oOXoIIIo.xoIox(oxox);
        }
        if (!this.f3922Xx000oIo.isEmpty()) {
            oxox.oxoX("<");
            boolean z = true;
            for (xoIox xoiox : this.f3922Xx000oIo) {
                if (!z) {
                    oxox.oxoX(", ");
                }
                xoiox.OOXIXo(oxox);
                xoiox.xoIox(oxox);
                z = false;
            }
            oxox.oxoX(">");
        }
        return oxox;
    }

    @Override // XO00XOO.xoIox
    /* renamed from: xoXoI, reason: merged with bridge method [inline-methods] */
    public xxIXOIIO I0Io(List<com.squareup.javapoet.oIX0oI> list) {
        return new xxIXOIIO(this.f3921IoOoX, this.f3923oOXoIIIo, this.f3922Xx000oIo, II0XooXoX(list));
    }

    public xxIXOIIO(xxIXOIIO xxixoiio, II0xO0 iI0xO0, List<xoIox> list, List<com.squareup.javapoet.oIX0oI> list2) {
        super(list2);
        this.f3923oOXoIIIo = (II0xO0) oOoXoXO.I0Io(iI0xO0, "rawType == null", new Object[0]);
        this.f3921IoOoX = xxixoiio;
        List<xoIox> XO2 = oOoXoXO.XO(list);
        this.f3922Xx000oIo = XO2;
        oOoXoXO.II0xO0((XO2.isEmpty() && xxixoiio == null) ? false : true, "no type arguments: %s", iI0xO0);
        Iterator<xoIox> it = XO2.iterator();
        while (it.hasNext()) {
            xoIox next = it.next();
            oOoXoXO.II0xO0((next.IXxxXO() || next == xoIox.f3901Oxx0xo) ? false : true, "invalid type parameter: %s", next);
        }
    }
}
