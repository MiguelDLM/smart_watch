package com.squareup.javapoet;

import XO00XOO.OOXIXo;
import XO00XOO.oOoXoXO;
import XO00XOO.xoIox;
import XXO0.oIX0oI;
import com.squareup.javapoet.II0xO0;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Types;

/* loaded from: classes11.dex */
public final class X0o0xo {

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final String f25868oOoXoXO = "<init>";

    /* renamed from: I0Io, reason: collision with root package name */
    public final List<com.squareup.javapoet.oIX0oI> f25869I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final boolean f25870II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final com.squareup.javapoet.II0xO0 f25871II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public final com.squareup.javapoet.II0xO0 f25872OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final List<XO> f25873Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final List<OOXIXo> f25874X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final xoIox f25875XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f25876oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final Set<Modifier> f25877oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public final com.squareup.javapoet.II0xO0 f25878xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final List<xoIox> f25879xxIXOIIO;

    /* loaded from: classes11.dex */
    public static final class II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public final List<com.squareup.javapoet.oIX0oI> f25880I0Io;

        /* renamed from: II0XooXoX, reason: collision with root package name */
        public final Set<xoIox> f25881II0XooXoX;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final II0xO0.C1032II0xO0 f25882II0xO0;

        /* renamed from: OOXIXo, reason: collision with root package name */
        public com.squareup.javapoet.II0xO0 f25883OOXIXo;

        /* renamed from: Oxx0IOOO, reason: collision with root package name */
        public final List<XO> f25884Oxx0IOOO;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public List<OOXIXo> f25885X0o0xo;

        /* renamed from: XO, reason: collision with root package name */
        public xoIox f25886XO;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final String f25887oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public final List<Modifier> f25888oxoX;

        /* renamed from: xoIox, reason: collision with root package name */
        public boolean f25889xoIox;

        /* renamed from: xxIXOIIO, reason: collision with root package name */
        public final II0xO0.C1032II0xO0 f25890xxIXOIIO;

        public II0xO0 IIX0o(Iterable<XO> iterable) {
            boolean z;
            if (iterable != null) {
                z = true;
            } else {
                z = false;
            }
            oOoXoXO.II0xO0(z, "parameterSpecs == null", new Object[0]);
            Iterator<XO> it = iterable.iterator();
            while (it.hasNext()) {
                this.f25884Oxx0IOOO.add(it.next());
            }
            return this;
        }

        public II0xO0 IIXOooo(xoIox xoiox) {
            this.f25881II0XooXoX.add(xoiox);
            return this;
        }

        public II0xO0 IO(String str, Object... objArr) {
            this.f25890xxIXOIIO.ooOOo0oXI(str, objArr);
            return this;
        }

        public II0xO0 IXxxXO(Iterable<com.squareup.javapoet.oIX0oI> iterable) {
            boolean z;
            if (iterable != null) {
                z = true;
            } else {
                z = false;
            }
            oOoXoXO.II0xO0(z, "annotationSpecs == null", new Object[0]);
            Iterator<com.squareup.javapoet.oIX0oI> it = iterable.iterator();
            while (it.hasNext()) {
                this.f25880I0Io.add(it.next());
            }
            return this;
        }

        public II0xO0 Io(boolean z) {
            this.f25889xoIox = z;
            return this;
        }

        public X0o0xo IoOoX() {
            return new X0o0xo(this);
        }

        public II0xO0 O0xOxO(String str, Object... objArr) {
            this.f25882II0xO0.II0xO0(str, objArr);
            return this;
        }

        public II0xO0 OI0() {
            return Io(true);
        }

        public II0xO0 Oo(Class<?> cls) {
            return oO(XO00XOO.II0xO0.X0IIOO(cls));
        }

        public II0xO0 OxI(com.squareup.javapoet.II0xO0 iI0xO0) {
            this.f25882II0xO0.oIX0oI(iI0xO0);
            return this;
        }

        public II0xO0 Oxx0xo(com.squareup.javapoet.II0xO0 iI0xO0) {
            this.f25890xxIXOIIO.oIX0oI(iI0xO0);
            return this;
        }

        public II0xO0 OxxIIOOXO(String str, Object... objArr) {
            this.f25890xxIXOIIO.II0xO0("// " + str + "\n", objArr);
            return this;
        }

        public II0xO0 X00IoxXI() {
            this.f25890xxIXOIIO.oOoXoXO();
            return this;
        }

        public II0xO0 X0IIOO(Iterable<Modifier> iterable) {
            oOoXoXO.I0Io(iterable, "modifiers == null", new Object[0]);
            Iterator<Modifier> it = iterable.iterator();
            while (it.hasNext()) {
                this.f25888oxoX.add(it.next());
            }
            return this;
        }

        public II0xO0 XI0IXoo(Modifier... modifierArr) {
            oOoXoXO.I0Io(modifierArr, "modifiers == null", new Object[0]);
            Collections.addAll(this.f25888oxoX, modifierArr);
            return this;
        }

        public II0xO0 XIxXXX0x0(String str, Map<String, ?> map) {
            this.f25890xxIXOIIO.oxoX(str, map);
            return this;
        }

        public II0xO0 XOxIOxOx(Type type) {
            return x0o(xoIox.oOoXoXO(type));
        }

        public II0xO0 Xx000oIo(String str, Object... objArr) {
            return oOXoIIIo(com.squareup.javapoet.II0xO0.X0o0xo(str, objArr));
        }

        public II0xO0 XxX0x0xxx(XO xo2) {
            this.f25884Oxx0IOOO.add(xo2);
            return this;
        }

        public II0xO0 o00(Iterable<? extends xoIox> iterable) {
            boolean z;
            if (iterable != null) {
                z = true;
            } else {
                z = false;
            }
            oOoXoXO.II0xO0(z, "exceptions == null", new Object[0]);
            Iterator<? extends xoIox> it = iterable.iterator();
            while (it.hasNext()) {
                this.f25881II0XooXoX.add(it.next());
            }
            return this;
        }

        public II0xO0 oI0IIXIo(String str, Object... objArr) {
            this.f25890xxIXOIIO.II0xO0(str, objArr);
            return this;
        }

        public II0xO0 oO(XO00XOO.II0xO0 iI0xO0) {
            this.f25880I0Io.add(com.squareup.javapoet.oIX0oI.oIX0oI(iI0xO0).XO());
            return this;
        }

        public II0xO0 oOXoIIIo(com.squareup.javapoet.II0xO0 iI0xO0) {
            boolean z;
            if (this.f25883OOXIXo == null) {
                z = true;
            } else {
                z = false;
            }
            oOoXoXO.oxoX(z, "defaultValue was already set", new Object[0]);
            this.f25883OOXIXo = (com.squareup.javapoet.II0xO0) oOoXoXO.I0Io(iI0xO0, "codeBlock == null", new Object[0]);
            return this;
        }

        public II0xO0 oo(String str, Object... objArr) {
            this.f25890xxIXOIIO.xoIox(str, objArr);
            return this;
        }

        public II0xO0 oo0xXOI0I(Iterable<OOXIXo> iterable) {
            boolean z;
            if (iterable != null) {
                z = true;
            } else {
                z = false;
            }
            oOoXoXO.II0xO0(z, "typeVariables == null", new Object[0]);
            Iterator<OOXIXo> it = iterable.iterator();
            while (it.hasNext()) {
                this.f25885X0o0xo.add(it.next());
            }
            return this;
        }

        public II0xO0 ooXIXxIX(String str, Object... objArr) {
            this.f25890xxIXOIIO.X0o0xo(str, objArr);
            return this;
        }

        public II0xO0 x0o(xoIox xoiox) {
            oOoXoXO.oxoX(!this.f25887oIX0oI.equals(X0o0xo.f25868oOoXoXO), "constructor cannot have return type.", new Object[0]);
            this.f25886XO = xoiox;
            return this;
        }

        public II0xO0 x0xO0oo(com.squareup.javapoet.oIX0oI oix0oi) {
            this.f25880I0Io.add(oix0oi);
            return this;
        }

        public II0xO0 xI(OOXIXo oOXIXo) {
            this.f25885X0o0xo.add(oOXIXo);
            return this;
        }

        public II0xO0 xII(String str, Object... objArr) {
            this.f25890xxIXOIIO.x0xO0oo(str, objArr);
            return this;
        }

        public II0xO0 xXxxox0I(Type type, String str, Modifier... modifierArr) {
            return xxX(xoIox.oOoXoXO(type), str, modifierArr);
        }

        public II0xO0 xoXoI(Type type) {
            return IIXOooo(xoIox.oOoXoXO(type));
        }

        public II0xO0 xxX(xoIox xoiox, String str, Modifier... modifierArr) {
            return XxX0x0xxx(XO.oIX0oI(xoiox, str, modifierArr).OOXIXo());
        }

        public II0xO0(String str) {
            this.f25882II0xO0 = com.squareup.javapoet.II0xO0.I0Io();
            this.f25880I0Io = new ArrayList();
            this.f25888oxoX = new ArrayList();
            this.f25885X0o0xo = new ArrayList();
            this.f25884Oxx0IOOO = new ArrayList();
            this.f25881II0XooXoX = new LinkedHashSet();
            this.f25890xxIXOIIO = com.squareup.javapoet.II0xO0.I0Io();
            oOoXoXO.I0Io(str, "name == null", new Object[0]);
            oOoXoXO.II0xO0(str.equals(X0o0xo.f25868oOoXoXO) || SourceVersion.isName(str), "not a valid name: %s", str);
            this.f25887oIX0oI = str;
            this.f25886XO = str.equals(X0o0xo.f25868oOoXoXO) ? null : xoIox.f3901Oxx0xo;
        }
    }

    public static II0xO0 II0XooXoX(ExecutableElement executableElement, DeclaredType declaredType, Types types) {
        ExecutableType asMemberOf = types.asMemberOf(declaredType, executableElement);
        List parameterTypes = asMemberOf.getParameterTypes();
        TypeMirror returnType = asMemberOf.getReturnType();
        II0xO0 Oxx0IOOO2 = Oxx0IOOO(executableElement);
        Oxx0IOOO2.x0o(xoIox.x0XOIxOo(returnType));
        int size = Oxx0IOOO2.f25884Oxx0IOOO.size();
        for (int i = 0; i < size; i++) {
            XO xo2 = (XO) Oxx0IOOO2.f25884Oxx0IOOO.get(i);
            Oxx0IOOO2.f25884Oxx0IOOO.set(i, xo2.II0XooXoX(xoIox.x0XOIxOo((TypeMirror) parameterTypes.get(i)), xo2.f25893oIX0oI).OOXIXo());
        }
        return Oxx0IOOO2;
    }

    public static II0xO0 Oxx0IOOO(ExecutableElement executableElement) {
        oOoXoXO.I0Io(executableElement, "method == null", new Object[0]);
        Set modifiers = executableElement.getModifiers();
        if (!modifiers.contains(Modifier.PRIVATE) && !modifiers.contains(Modifier.FINAL) && !modifiers.contains(Modifier.STATIC)) {
            II0xO0 XO2 = XO(executableElement.getSimpleName().toString());
            XO2.Oo(Override.class);
            LinkedHashSet linkedHashSet = new LinkedHashSet(modifiers);
            linkedHashSet.remove(Modifier.ABSTRACT);
            linkedHashSet.remove(oOoXoXO.f3879oIX0oI);
            XO2.X0IIOO(linkedHashSet);
            Iterator it = executableElement.getTypeParameters().iterator();
            while (it.hasNext()) {
                XO2.xI(OOXIXo.xxX(((TypeParameterElement) it.next()).asType()));
            }
            XO2.x0o(xoIox.x0XOIxOo(executableElement.getReturnType()));
            XO2.IIX0o(XO.XO(executableElement));
            XO2.Io(executableElement.isVarArgs());
            Iterator it2 = executableElement.getThrownTypes().iterator();
            while (it2.hasNext()) {
                XO2.IIXOooo(xoIox.x0XOIxOo((TypeMirror) it2.next()));
            }
            return XO2;
        }
        throw new IllegalArgumentException("cannot override method with modifiers: " + modifiers);
    }

    public static II0xO0 XO(String str) {
        return new II0xO0(str);
    }

    public static II0xO0 oIX0oI() {
        return new II0xO0(f25868oOoXoXO);
    }

    public boolean I0Io(Modifier modifier) {
        return this.f25877oxoX.contains(modifier);
    }

    public void II0xO0(XO00XOO.oxoX oxox, String str, Set<Modifier> set) throws IOException {
        boolean z;
        oxox.II0XooXoX(this.f25871II0xO0);
        oxox.X0o0xo(this.f25869I0Io, false);
        oxox.OOXIXo(this.f25877oxoX, set);
        if (!this.f25874X0o0xo.isEmpty()) {
            oxox.ooOOo0oXI(this.f25874X0o0xo);
            oxox.II0xO0(" ");
        }
        if (oxoX()) {
            oxox.I0Io("$L(", str);
        } else {
            oxox.I0Io("$T $L(", this.f25875XO, this.f25876oIX0oI);
        }
        Iterator<XO> it = this.f25873Oxx0IOOO.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            XO next = it.next();
            if (!z2) {
                oxox.II0xO0(",").x0XOIxOo();
            }
            if (!it.hasNext() && this.f25870II0XooXoX) {
                z = true;
            } else {
                z = false;
            }
            next.I0Io(oxox, z);
            z2 = false;
        }
        oxox.II0xO0(oIX0oI.I0Io.f4095I0Io);
        com.squareup.javapoet.II0xO0 iI0xO0 = this.f25872OOXIXo;
        if (iI0xO0 != null && !iI0xO0.oxoX()) {
            oxox.II0xO0(" default ");
            oxox.oIX0oI(this.f25872OOXIXo);
        }
        if (!this.f25879xxIXOIIO.isEmpty()) {
            oxox.x0XOIxOo().II0xO0("throws");
            boolean z3 = true;
            for (xoIox xoiox : this.f25879xxIXOIIO) {
                if (!z3) {
                    oxox.II0xO0(",");
                }
                oxox.x0XOIxOo().I0Io("$T", xoiox);
                z3 = false;
            }
        }
        if (I0Io(Modifier.ABSTRACT)) {
            oxox.II0xO0(";\n");
            return;
        }
        if (I0Io(Modifier.NATIVE)) {
            oxox.oIX0oI(this.f25878xoIox);
            oxox.II0xO0(";\n");
            return;
        }
        oxox.II0xO0(" {\n");
        oxox.IXxxXO();
        oxox.oIX0oI(this.f25878xoIox);
        oxox.XI0IXoo();
        oxox.II0xO0("}\n");
    }

    public final boolean X0o0xo(List<XO> list) {
        if (!list.isEmpty() && xoIox.XO(list.get(list.size() - 1).f25894oxoX) != null) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || X0o0xo.class != obj.getClass()) {
            return false;
        }
        return toString().equals(obj.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean oxoX() {
        return this.f25876oIX0oI.equals(f25868oOoXoXO);
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            II0xO0(new XO00XOO.oxoX(stringWriter), "Constructor", Collections.emptySet());
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    public II0xO0 xxIXOIIO() {
        II0xO0 iI0xO0 = new II0xO0(this.f25876oIX0oI);
        iI0xO0.f25882II0xO0.oIX0oI(this.f25871II0xO0);
        iI0xO0.f25880I0Io.addAll(this.f25869I0Io);
        iI0xO0.f25888oxoX.addAll(this.f25877oxoX);
        iI0xO0.f25885X0o0xo.addAll(this.f25874X0o0xo);
        iI0xO0.f25886XO = this.f25875XO;
        iI0xO0.f25884Oxx0IOOO.addAll(this.f25873Oxx0IOOO);
        iI0xO0.f25881II0XooXoX.addAll(this.f25879xxIXOIIO);
        iI0xO0.f25890xxIXOIIO.oIX0oI(this.f25878xoIox);
        iI0xO0.f25889xoIox = this.f25870II0XooXoX;
        iI0xO0.f25883OOXIXo = this.f25872OOXIXo;
        return iI0xO0;
    }

    public X0o0xo(II0xO0 iI0xO0) {
        com.squareup.javapoet.II0xO0 OOXIXo2 = iI0xO0.f25890xxIXOIIO.OOXIXo();
        oOoXoXO.II0xO0(OOXIXo2.oxoX() || !iI0xO0.f25888oxoX.contains(Modifier.ABSTRACT), "abstract method %s cannot have code", iI0xO0.f25887oIX0oI);
        oOoXoXO.II0xO0(!iI0xO0.f25889xoIox || X0o0xo(iI0xO0.f25884Oxx0IOOO), "last parameter of varargs method %s must be an array", iI0xO0.f25887oIX0oI);
        this.f25876oIX0oI = (String) oOoXoXO.I0Io(iI0xO0.f25887oIX0oI, "name == null", new Object[0]);
        this.f25871II0xO0 = iI0xO0.f25882II0xO0.OOXIXo();
        this.f25869I0Io = oOoXoXO.XO(iI0xO0.f25880I0Io);
        this.f25877oxoX = oOoXoXO.xxIXOIIO(iI0xO0.f25888oxoX);
        this.f25874X0o0xo = oOoXoXO.XO(iI0xO0.f25885X0o0xo);
        this.f25875XO = iI0xO0.f25886XO;
        this.f25873Oxx0IOOO = oOoXoXO.XO(iI0xO0.f25884Oxx0IOOO);
        this.f25870II0XooXoX = iI0xO0.f25889xoIox;
        this.f25879xxIXOIIO = oOoXoXO.XO(iI0xO0.f25881II0XooXoX);
        this.f25872OOXIXo = iI0xO0.f25883OOXIXo;
        this.f25878xoIox = OOXIXo2;
    }
}
