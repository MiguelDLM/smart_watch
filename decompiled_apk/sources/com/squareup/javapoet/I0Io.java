package com.squareup.javapoet;

import XO00XOO.oOoXoXO;
import XO00XOO.xoIox;
import com.squareup.javapoet.II0xO0;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* loaded from: classes11.dex */
public final class I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public final com.squareup.javapoet.II0xO0 f25817I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final String f25818II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final Set<Modifier> f25819X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final com.squareup.javapoet.II0xO0 f25820XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final xoIox f25821oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final List<com.squareup.javapoet.oIX0oI> f25822oxoX;

    /* loaded from: classes11.dex */
    public static final class II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public final II0xO0.C1032II0xO0 f25823I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final String f25824II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public final List<Modifier> f25825X0o0xo;

        /* renamed from: XO, reason: collision with root package name */
        public com.squareup.javapoet.II0xO0 f25826XO;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final xoIox f25827oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public final List<com.squareup.javapoet.oIX0oI> f25828oxoX;

        public II0xO0 II0XooXoX(XO00XOO.II0xO0 iI0xO0) {
            this.f25828oxoX.add(com.squareup.javapoet.oIX0oI.oIX0oI(iI0xO0).XO());
            return this;
        }

        public II0xO0 OOXIXo(Iterable<com.squareup.javapoet.oIX0oI> iterable) {
            boolean z;
            if (iterable != null) {
                z = true;
            } else {
                z = false;
            }
            oOoXoXO.II0xO0(z, "annotationSpecs == null", new Object[0]);
            Iterator<com.squareup.javapoet.oIX0oI> it = iterable.iterator();
            while (it.hasNext()) {
                this.f25828oxoX.add(it.next());
            }
            return this;
        }

        public II0xO0 Oo(String str, Object... objArr) {
            return x0xO0oo(com.squareup.javapoet.II0xO0.X0o0xo(str, objArr));
        }

        public I0Io oO() {
            return new I0Io(this);
        }

        public II0xO0 oOoXoXO(com.squareup.javapoet.II0xO0 iI0xO0) {
            this.f25823I0Io.oIX0oI(iI0xO0);
            return this;
        }

        public II0xO0 ooOOo0oXI(String str, Object... objArr) {
            this.f25823I0Io.II0xO0(str, objArr);
            return this;
        }

        public II0xO0 x0XOIxOo(Modifier... modifierArr) {
            Collections.addAll(this.f25825X0o0xo, modifierArr);
            return this;
        }

        public II0xO0 x0xO0oo(com.squareup.javapoet.II0xO0 iI0xO0) {
            boolean z;
            if (this.f25826XO == null) {
                z = true;
            } else {
                z = false;
            }
            oOoXoXO.oxoX(z, "initializer was already set", new Object[0]);
            this.f25826XO = (com.squareup.javapoet.II0xO0) oOoXoXO.I0Io(iI0xO0, "codeBlock == null", new Object[0]);
            return this;
        }

        public II0xO0 xoIox(Class<?> cls) {
            return II0XooXoX(XO00XOO.II0xO0.X0IIOO(cls));
        }

        public II0xO0 xxIXOIIO(com.squareup.javapoet.oIX0oI oix0oi) {
            this.f25828oxoX.add(oix0oi);
            return this;
        }

        public II0xO0(xoIox xoiox, String str) {
            this.f25823I0Io = com.squareup.javapoet.II0xO0.I0Io();
            this.f25828oxoX = new ArrayList();
            this.f25825X0o0xo = new ArrayList();
            this.f25826XO = null;
            this.f25827oIX0oI = xoiox;
            this.f25824II0xO0 = str;
        }
    }

    public static II0xO0 II0xO0(Type type, String str, Modifier... modifierArr) {
        return oIX0oI(xoIox.oOoXoXO(type), str, modifierArr);
    }

    public static II0xO0 oIX0oI(xoIox xoiox, String str, Modifier... modifierArr) {
        oOoXoXO.I0Io(xoiox, "type == null", new Object[0]);
        oOoXoXO.II0xO0(SourceVersion.isName(str), "not a valid name: %s", str);
        return new II0xO0(xoiox, str).x0XOIxOo(modifierArr);
    }

    public void I0Io(XO00XOO.oxoX oxox, Set<Modifier> set) throws IOException {
        oxox.II0XooXoX(this.f25817I0Io);
        oxox.X0o0xo(this.f25822oxoX, false);
        oxox.OOXIXo(this.f25819X0o0xo, set);
        oxox.I0Io("$T $L", this.f25821oIX0oI, this.f25818II0xO0);
        if (!this.f25820XO.oxoX()) {
            oxox.II0xO0(" = ");
            oxox.oIX0oI(this.f25820XO);
        }
        oxox.II0xO0(";\n");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public II0xO0 X0o0xo() {
        com.squareup.javapoet.II0xO0 iI0xO0 = null;
        II0xO0 iI0xO02 = new II0xO0(this.f25821oIX0oI, this.f25818II0xO0);
        iI0xO02.f25823I0Io.oIX0oI(this.f25817I0Io);
        iI0xO02.f25828oxoX.addAll(this.f25822oxoX);
        iI0xO02.f25825X0o0xo.addAll(this.f25819X0o0xo);
        if (!this.f25820XO.oxoX()) {
            iI0xO0 = this.f25820XO;
        }
        iI0xO02.f25826XO = iI0xO0;
        return iI0xO02;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || I0Io.class != obj.getClass()) {
            return false;
        }
        return toString().equals(obj.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean oxoX(Modifier modifier) {
        return this.f25819X0o0xo.contains(modifier);
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            I0Io(new XO00XOO.oxoX(stringWriter), Collections.emptySet());
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    public I0Io(II0xO0 iI0xO0) {
        com.squareup.javapoet.II0xO0 iI0xO02;
        this.f25821oIX0oI = (xoIox) oOoXoXO.I0Io(iI0xO0.f25827oIX0oI, "type == null", new Object[0]);
        this.f25818II0xO0 = (String) oOoXoXO.I0Io(iI0xO0.f25824II0xO0, "name == null", new Object[0]);
        this.f25817I0Io = iI0xO0.f25823I0Io.OOXIXo();
        this.f25822oxoX = oOoXoXO.XO(iI0xO0.f25828oxoX);
        this.f25819X0o0xo = oOoXoXO.xxIXOIIO(iI0xO0.f25825X0o0xo);
        if (iI0xO0.f25826XO != null) {
            iI0xO02 = iI0xO0.f25826XO;
        } else {
            iI0xO02 = com.squareup.javapoet.II0xO0.I0Io().OOXIXo();
        }
        this.f25820XO = iI0xO02;
    }
}
