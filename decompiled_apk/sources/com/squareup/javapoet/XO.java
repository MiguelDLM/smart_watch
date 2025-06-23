package com.squareup.javapoet;

import XO00XOO.oOoXoXO;
import XO00XOO.xoIox;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.VariableElement;

/* loaded from: classes11.dex */
public final class XO {

    /* renamed from: I0Io, reason: collision with root package name */
    public final Set<Modifier> f25891I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final List<com.squareup.javapoet.oIX0oI> f25892II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f25893oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final xoIox f25894oxoX;

    /* loaded from: classes11.dex */
    public static final class II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public final List<com.squareup.javapoet.oIX0oI> f25895I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final String f25896II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final xoIox f25897oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public final List<Modifier> f25898oxoX;

        public II0xO0 II0XooXoX(Iterable<com.squareup.javapoet.oIX0oI> iterable) {
            boolean z;
            if (iterable != null) {
                z = true;
            } else {
                z = false;
            }
            oOoXoXO.II0xO0(z, "annotationSpecs == null", new Object[0]);
            Iterator<com.squareup.javapoet.oIX0oI> it = iterable.iterator();
            while (it.hasNext()) {
                this.f25895I0Io.add(it.next());
            }
            return this;
        }

        public XO OOXIXo() {
            return new XO(this);
        }

        public II0xO0 Oxx0IOOO(Class<?> cls) {
            return X0o0xo(XO00XOO.II0xO0.X0IIOO(cls));
        }

        public II0xO0 X0o0xo(XO00XOO.II0xO0 iI0xO0) {
            this.f25895I0Io.add(com.squareup.javapoet.oIX0oI.oIX0oI(iI0xO0).XO());
            return this;
        }

        public II0xO0 XO(com.squareup.javapoet.oIX0oI oix0oi) {
            this.f25895I0Io.add(oix0oi);
            return this;
        }

        public II0xO0 xoIox(Modifier... modifierArr) {
            Collections.addAll(this.f25898oxoX, modifierArr);
            return this;
        }

        public II0xO0 xxIXOIIO(Iterable<Modifier> iterable) {
            oOoXoXO.I0Io(iterable, "modifiers == null", new Object[0]);
            Iterator<Modifier> it = iterable.iterator();
            while (it.hasNext()) {
                this.f25898oxoX.add(it.next());
            }
            return this;
        }

        public II0xO0(xoIox xoiox, String str) {
            this.f25895I0Io = new ArrayList();
            this.f25898oxoX = new ArrayList();
            this.f25897oIX0oI = xoiox;
            this.f25896II0xO0 = str;
        }
    }

    public static II0xO0 II0xO0(Type type, String str, Modifier... modifierArr) {
        return oIX0oI(xoIox.oOoXoXO(type), str, modifierArr);
    }

    public static List<XO> XO(ExecutableElement executableElement) {
        ArrayList arrayList = new ArrayList();
        Iterator it = executableElement.getParameters().iterator();
        while (it.hasNext()) {
            arrayList.add(oxoX((VariableElement) it.next()));
        }
        return arrayList;
    }

    public static II0xO0 oIX0oI(xoIox xoiox, String str, Modifier... modifierArr) {
        oOoXoXO.I0Io(xoiox, "type == null", new Object[0]);
        oOoXoXO.II0xO0(SourceVersion.isName(str), "not a valid name: %s", str);
        return new II0xO0(xoiox, str).xoIox(modifierArr);
    }

    public static XO oxoX(VariableElement variableElement) {
        return oIX0oI(xoIox.x0XOIxOo(variableElement.asType()), variableElement.getSimpleName().toString(), new Modifier[0]).xxIXOIIO(variableElement.getModifiers()).OOXIXo();
    }

    public void I0Io(XO00XOO.oxoX oxox, boolean z) throws IOException {
        oxox.X0o0xo(this.f25892II0xO0, true);
        oxox.xoIox(this.f25891I0Io);
        if (z) {
            oxox.I0Io("$T... $L", xoIox.XO(this.f25894oxoX), this.f25893oIX0oI);
        } else {
            oxox.I0Io("$T $L", this.f25894oxoX, this.f25893oIX0oI);
        }
    }

    public II0xO0 II0XooXoX(xoIox xoiox, String str) {
        II0xO0 iI0xO0 = new II0xO0(xoiox, str);
        iI0xO0.f25895I0Io.addAll(this.f25892II0xO0);
        iI0xO0.f25898oxoX.addAll(this.f25891I0Io);
        return iI0xO0;
    }

    public II0xO0 Oxx0IOOO() {
        return II0XooXoX(this.f25894oxoX, this.f25893oIX0oI);
    }

    public boolean X0o0xo(Modifier modifier) {
        return this.f25891I0Io.contains(modifier);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || XO.class != obj.getClass()) {
            return false;
        }
        return toString().equals(obj.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            I0Io(new XO00XOO.oxoX(stringWriter), false);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    public XO(II0xO0 iI0xO0) {
        this.f25893oIX0oI = (String) oOoXoXO.I0Io(iI0xO0.f25896II0xO0, "name == null", new Object[0]);
        this.f25892II0xO0 = oOoXoXO.XO(iI0xO0.f25895I0Io);
        this.f25891I0Io = oOoXoXO.xxIXOIIO(iI0xO0.f25898oxoX);
        this.f25894oxoX = (xoIox) oOoXoXO.I0Io(iI0xO0.f25897oIX0oI, "type == null", new Object[0]);
    }
}
