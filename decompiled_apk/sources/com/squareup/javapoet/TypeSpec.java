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
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes11.dex */
public final class TypeSpec {

    /* renamed from: Oo, reason: collision with root package name */
    public static final /* synthetic */ boolean f25835Oo = false;

    /* renamed from: I0Io, reason: collision with root package name */
    public final com.squareup.javapoet.II0xO0 f25836I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final xoIox f25837II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final String f25838II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public final List<I0Io> f25839OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final List<OOXIXo> f25840Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final List<com.squareup.javapoet.oIX0oI> f25841X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final Set<Modifier> f25842XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Kind f25843oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public final List<TypeSpec> f25844oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public final com.squareup.javapoet.II0xO0 f25845oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public final com.squareup.javapoet.II0xO0 f25846ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final com.squareup.javapoet.II0xO0 f25847oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public final List<X0o0xo> f25848x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public final List<Element> f25849x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public final Map<String, TypeSpec> f25850xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final List<xoIox> f25851xxIXOIIO;

    /* loaded from: classes11.dex */
    public static final class II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public final com.squareup.javapoet.II0xO0 f25852I0Io;

        /* renamed from: II0XooXoX, reason: collision with root package name */
        public xoIox f25853II0XooXoX;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final String f25854II0xO0;

        /* renamed from: OOXIXo, reason: collision with root package name */
        public final List<I0Io> f25855OOXIXo;

        /* renamed from: Oxx0IOOO, reason: collision with root package name */
        public final List<OOXIXo> f25856Oxx0IOOO;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public final List<com.squareup.javapoet.oIX0oI> f25857X0o0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final List<Modifier> f25858XO;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final Kind f25859oIX0oI;

        /* renamed from: oO, reason: collision with root package name */
        public final List<TypeSpec> f25860oO;

        /* renamed from: oOoXoXO, reason: collision with root package name */
        public final II0xO0.C1032II0xO0 f25861oOoXoXO;

        /* renamed from: ooOOo0oXI, reason: collision with root package name */
        public final II0xO0.C1032II0xO0 f25862ooOOo0oXI;

        /* renamed from: oxoX, reason: collision with root package name */
        public final II0xO0.C1032II0xO0 f25863oxoX;

        /* renamed from: x0XOIxOo, reason: collision with root package name */
        public final List<X0o0xo> f25864x0XOIxOo;

        /* renamed from: x0xO0oo, reason: collision with root package name */
        public final List<Element> f25865x0xO0oo;

        /* renamed from: xoIox, reason: collision with root package name */
        public final Map<String, TypeSpec> f25866xoIox;

        /* renamed from: xxIXOIIO, reason: collision with root package name */
        public final List<xoIox> f25867xxIXOIIO;

        public II0xO0 IIX0o(Modifier... modifierArr) {
            boolean z;
            boolean z2;
            if (this.f25852I0Io == null) {
                z = true;
            } else {
                z = false;
            }
            oOoXoXO.oxoX(z, "forbidden on anonymous types.", new Object[0]);
            for (Modifier modifier : modifierArr) {
                if (modifier != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                oOoXoXO.II0xO0(z2, "modifiers contain null", new Object[0]);
                this.f25858XO.add(modifier);
            }
            return this;
        }

        public II0xO0 IIXOooo(String str) {
            return xoXoI(str, TypeSpec.oxoX("", new Object[0]).xII());
        }

        public II0xO0 IO(Iterable<TypeSpec> iterable) {
            boolean z;
            if (iterable != null) {
                z = true;
            } else {
                z = false;
            }
            oOoXoXO.II0xO0(z, "typeSpecs == null", new Object[0]);
            Iterator<TypeSpec> it = iterable.iterator();
            while (it.hasNext()) {
                oOXoIIIo(it.next());
            }
            return this;
        }

        public II0xO0 IXxxXO(XO00XOO.II0xO0 iI0xO0) {
            return Oxx0xo(com.squareup.javapoet.oIX0oI.oIX0oI(iI0xO0).XO());
        }

        public II0xO0 IoOoX(Iterable<? extends xoIox> iterable) {
            boolean z;
            if (iterable != null) {
                z = true;
            } else {
                z = false;
            }
            oOoXoXO.II0xO0(z, "superinterfaces == null", new Object[0]);
            Iterator<? extends xoIox> it = iterable.iterator();
            while (it.hasNext()) {
                oo0xXOI0I(it.next());
            }
            return this;
        }

        public II0xO0 O0xOxO(Type type, String str, Modifier... modifierArr) {
            return o00(xoIox.oOoXoXO(type), str, modifierArr);
        }

        public II0xO0 OxI(I0Io i0Io) {
            Kind kind = this.f25859oIX0oI;
            if (kind == Kind.INTERFACE || kind == Kind.ANNOTATION) {
                oOoXoXO.OOXIXo(i0Io.f25819X0o0xo, Modifier.PUBLIC, Modifier.PRIVATE);
                EnumSet of = EnumSet.of(Modifier.STATIC, Modifier.FINAL);
                oOoXoXO.oxoX(i0Io.f25819X0o0xo.containsAll(of), "%s %s.%s requires modifiers %s", this.f25859oIX0oI, this.f25854II0xO0, i0Io.f25818II0xO0, of);
            }
            this.f25855OOXIXo.add(i0Io);
            return this;
        }

        public II0xO0 Oxx0xo(com.squareup.javapoet.oIX0oI oix0oi) {
            this.f25857X0o0xo.add(oix0oi);
            return this;
        }

        public II0xO0 OxxIIOOXO(Iterable<com.squareup.javapoet.oIX0oI> iterable) {
            boolean z;
            if (iterable != null) {
                z = true;
            } else {
                z = false;
            }
            oOoXoXO.II0xO0(z, "annotationSpecs == null", new Object[0]);
            Iterator<com.squareup.javapoet.oIX0oI> it = iterable.iterator();
            while (it.hasNext()) {
                this.f25857X0o0xo.add(it.next());
            }
            return this;
        }

        public II0xO0 X00IoxXI(Iterable<OOXIXo> iterable) {
            boolean z;
            boolean z2 = true;
            if (this.f25852I0Io == null) {
                z = true;
            } else {
                z = false;
            }
            oOoXoXO.oxoX(z, "forbidden on anonymous types.", new Object[0]);
            if (iterable == null) {
                z2 = false;
            }
            oOoXoXO.II0xO0(z2, "typeVariables == null", new Object[0]);
            Iterator<OOXIXo> it = iterable.iterator();
            while (it.hasNext()) {
                this.f25856Oxx0IOOO.add(it.next());
            }
            return this;
        }

        public II0xO0 X0IIOO(Iterable<I0Io> iterable) {
            boolean z;
            if (iterable != null) {
                z = true;
            } else {
                z = false;
            }
            oOoXoXO.II0xO0(z, "fieldSpecs == null", new Object[0]);
            Iterator<I0Io> it = iterable.iterator();
            while (it.hasNext()) {
                OxI(it.next());
            }
            return this;
        }

        public II0xO0 XI0IXoo(com.squareup.javapoet.II0xO0 iI0xO0) {
            Kind kind = this.f25859oIX0oI;
            if (kind != Kind.CLASS && kind != Kind.ENUM) {
                throw new UnsupportedOperationException(this.f25859oIX0oI + " can't have initializer blocks");
            }
            this.f25862ooOOo0oXI.II0xO0("{\n", new Object[0]).x0XOIxOo().oIX0oI(iI0xO0).Oo().II0xO0("}\n", new Object[0]);
            return this;
        }

        public II0xO0 XIxXXX0x0(com.squareup.javapoet.II0xO0 iI0xO0) {
            this.f25863oxoX.oIX0oI(iI0xO0);
            return this;
        }

        public II0xO0 XOxIOxOx(Type type) {
            return x0o(xoIox.oOoXoXO(type));
        }

        public II0xO0 Xx000oIo(OOXIXo oOXIXo) {
            boolean z;
            if (this.f25852I0Io == null) {
                z = true;
            } else {
                z = false;
            }
            oOoXoXO.oxoX(z, "forbidden on anonymous types.", new Object[0]);
            this.f25856Oxx0IOOO.add(oOXIXo);
            return this;
        }

        public II0xO0 XxX0x0xxx(X0o0xo x0o0xo) {
            boolean z;
            Kind kind = this.f25859oIX0oI;
            Kind kind2 = Kind.INTERFACE;
            if (kind == kind2) {
                oOoXoXO.OOXIXo(x0o0xo.f25877oxoX, Modifier.ABSTRACT, Modifier.STATIC, oOoXoXO.f3879oIX0oI);
                oOoXoXO.OOXIXo(x0o0xo.f25877oxoX, Modifier.PUBLIC, Modifier.PRIVATE);
            } else if (kind == Kind.ANNOTATION) {
                boolean equals = x0o0xo.f25877oxoX.equals(kind.implicitMethodModifiers);
                Kind kind3 = this.f25859oIX0oI;
                oOoXoXO.oxoX(equals, "%s %s.%s requires modifiers %s", kind3, this.f25854II0xO0, x0o0xo.f25876oIX0oI, kind3.implicitMethodModifiers);
            }
            Kind kind4 = this.f25859oIX0oI;
            if (kind4 != Kind.ANNOTATION) {
                if (x0o0xo.f25872OOXIXo == null) {
                    z = true;
                } else {
                    z = false;
                }
                oOoXoXO.oxoX(z, "%s %s.%s cannot have a default value", kind4, this.f25854II0xO0, x0o0xo.f25876oIX0oI);
            }
            if (this.f25859oIX0oI != kind2) {
                oOoXoXO.oxoX(!oOoXoXO.X0o0xo(x0o0xo.f25877oxoX), "%s %s.%s cannot be default", this.f25859oIX0oI, this.f25854II0xO0, x0o0xo.f25876oIX0oI);
            }
            this.f25864x0XOIxOo.add(x0o0xo);
            return this;
        }

        public II0xO0 o00(xoIox xoiox, String str, Modifier... modifierArr) {
            return OxI(I0Io.oIX0oI(xoiox, str, modifierArr).oO());
        }

        public II0xO0 oI0IIXIo(Class<?> cls) {
            return IXxxXO(XO00XOO.II0xO0.X0IIOO(cls));
        }

        public II0xO0 oOXoIIIo(TypeSpec typeSpec) {
            boolean containsAll = typeSpec.f25842XO.containsAll(this.f25859oIX0oI.implicitTypeModifiers);
            Kind kind = this.f25859oIX0oI;
            oOoXoXO.II0xO0(containsAll, "%s %s.%s requires modifiers %s", kind, this.f25854II0xO0, typeSpec.f25838II0xO0, kind.implicitTypeModifiers);
            this.f25860oO.add(typeSpec);
            return this;
        }

        public II0xO0 oo(Type type) {
            return oo0xXOI0I(xoIox.oOoXoXO(type));
        }

        public II0xO0 oo0xXOI0I(xoIox xoiox) {
            boolean z;
            if (xoiox != null) {
                z = true;
            } else {
                z = false;
            }
            oOoXoXO.II0xO0(z, "superinterface == null", new Object[0]);
            this.f25867xxIXOIIO.add(xoiox);
            return this;
        }

        public II0xO0 ooXIXxIX(Element element) {
            this.f25865x0xO0oo.add(element);
            return this;
        }

        public II0xO0 x0o(xoIox xoiox) {
            boolean z;
            boolean z2;
            if (this.f25859oIX0oI == Kind.CLASS) {
                z = true;
            } else {
                z = false;
            }
            oOoXoXO.oxoX(z, "only classes have super classes, not " + this.f25859oIX0oI, new Object[0]);
            if (this.f25853II0XooXoX == XO00XOO.II0xO0.f3866Xx000oIo) {
                z2 = true;
            } else {
                z2 = false;
            }
            oOoXoXO.oxoX(z2, "superclass already set to " + this.f25853II0XooXoX, new Object[0]);
            oOoXoXO.II0xO0(xoiox.IXxxXO() ^ true, "superclass may not be a primitive", new Object[0]);
            this.f25853II0XooXoX = xoiox;
            return this;
        }

        public II0xO0 xI(com.squareup.javapoet.II0xO0 iI0xO0) {
            this.f25861oOoXoXO.xoIox("static", new Object[0]).oIX0oI(iI0xO0).oOoXoXO();
            return this;
        }

        public TypeSpec xII() {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4 = true;
            if (this.f25859oIX0oI == Kind.ENUM && this.f25866xoIox.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            oOoXoXO.II0xO0(z, "at least one enum constant is required for %s", this.f25854II0xO0);
            if (!this.f25858XO.contains(Modifier.ABSTRACT) && this.f25859oIX0oI == Kind.CLASS) {
                z2 = false;
            } else {
                z2 = true;
            }
            for (X0o0xo x0o0xo : this.f25864x0XOIxOo) {
                if (!z2 && x0o0xo.I0Io(Modifier.ABSTRACT)) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                oOoXoXO.II0xO0(z3, "non-abstract type %s cannot declare abstract method %s", this.f25854II0xO0, x0o0xo.f25876oIX0oI);
            }
            int size = (!this.f25853II0XooXoX.equals(XO00XOO.II0xO0.f3866Xx000oIo) ? 1 : 0) + this.f25867xxIXOIIO.size();
            if (this.f25852I0Io != null && size > 1) {
                z4 = false;
            }
            oOoXoXO.II0xO0(z4, "anonymous type has too many supertypes", new Object[0]);
            return new TypeSpec(this);
        }

        public II0xO0 xXxxox0I(Iterable<X0o0xo> iterable) {
            boolean z;
            if (iterable != null) {
                z = true;
            } else {
                z = false;
            }
            oOoXoXO.II0xO0(z, "methodSpecs == null", new Object[0]);
            Iterator<X0o0xo> it = iterable.iterator();
            while (it.hasNext()) {
                XxX0x0xxx(it.next());
            }
            return this;
        }

        public II0xO0 xoXoI(String str, TypeSpec typeSpec) {
            boolean z;
            boolean z2;
            if (this.f25859oIX0oI == Kind.ENUM) {
                z = true;
            } else {
                z = false;
            }
            oOoXoXO.oxoX(z, "%s is not enum", this.f25854II0xO0);
            if (typeSpec.f25836I0Io != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            oOoXoXO.II0xO0(z2, "enum constants must have anonymous type arguments", new Object[0]);
            oOoXoXO.II0xO0(SourceVersion.isName(str), "not a valid enum constant: %s", str);
            this.f25866xoIox.put(str, typeSpec);
            return this;
        }

        public II0xO0 xxX(String str, Object... objArr) {
            this.f25863oxoX.II0xO0(str, objArr);
            return this;
        }

        public II0xO0(Kind kind, String str, com.squareup.javapoet.II0xO0 iI0xO0) {
            this.f25863oxoX = com.squareup.javapoet.II0xO0.I0Io();
            this.f25857X0o0xo = new ArrayList();
            this.f25858XO = new ArrayList();
            this.f25856Oxx0IOOO = new ArrayList();
            this.f25853II0XooXoX = XO00XOO.II0xO0.f3866Xx000oIo;
            this.f25867xxIXOIIO = new ArrayList();
            this.f25866xoIox = new LinkedHashMap();
            this.f25855OOXIXo = new ArrayList();
            this.f25861oOoXoXO = com.squareup.javapoet.II0xO0.I0Io();
            this.f25862ooOOo0oXI = com.squareup.javapoet.II0xO0.I0Io();
            this.f25864x0XOIxOo = new ArrayList();
            this.f25860oO = new ArrayList();
            this.f25865x0xO0oo = new ArrayList();
            oOoXoXO.II0xO0(str == null || SourceVersion.isName(str), "not a valid name: %s", str);
            this.f25859oIX0oI = kind;
            this.f25854II0xO0 = str;
            this.f25852I0Io = iI0xO0;
        }
    }

    /* loaded from: classes11.dex */
    public enum Kind {
        CLASS(Collections.emptySet(), Collections.emptySet(), Collections.emptySet(), Collections.emptySet()),
        INTERFACE(oOoXoXO.xxIXOIIO(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)), oOoXoXO.xxIXOIIO(Arrays.asList(Modifier.PUBLIC, Modifier.ABSTRACT)), oOoXoXO.xxIXOIIO(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC)), oOoXoXO.xxIXOIIO(Arrays.asList(Modifier.STATIC))),
        ENUM(Collections.emptySet(), Collections.emptySet(), Collections.emptySet(), Collections.singleton(Modifier.STATIC)),
        ANNOTATION(oOoXoXO.xxIXOIIO(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)), oOoXoXO.xxIXOIIO(Arrays.asList(Modifier.PUBLIC, Modifier.ABSTRACT)), oOoXoXO.xxIXOIIO(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC)), oOoXoXO.xxIXOIIO(Arrays.asList(Modifier.STATIC)));

        private final Set<Modifier> asMemberModifiers;
        private final Set<Modifier> implicitFieldModifiers;
        private final Set<Modifier> implicitMethodModifiers;
        private final Set<Modifier> implicitTypeModifiers;

        Kind(Set set, Set set2, Set set3, Set set4) {
            this.implicitFieldModifiers = set;
            this.implicitMethodModifiers = set2;
            this.implicitTypeModifiers = set3;
            this.asMemberModifiers = set4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static II0xO0 I0Io(com.squareup.javapoet.II0xO0 iI0xO0) {
        return new II0xO0(Kind.CLASS, null, iI0xO0);
    }

    public static II0xO0 II0XooXoX(XO00XOO.II0xO0 iI0xO0) {
        return xxIXOIIO(((XO00XOO.II0xO0) oOoXoXO.I0Io(iI0xO0, "className == null", new Object[0])).oo0xXOI0I());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static II0xO0 II0xO0(String str) {
        return new II0xO0(Kind.ANNOTATION, (String) oOoXoXO.I0Io(str, "name == null", new Object[0]), null);
    }

    public static II0xO0 OOXIXo(XO00XOO.II0xO0 iI0xO0) {
        return oOoXoXO(((XO00XOO.II0xO0) oOoXoXO.I0Io(iI0xO0, "className == null", new Object[0])).oo0xXOI0I());
    }

    public static II0xO0 X0o0xo(XO00XOO.II0xO0 iI0xO0) {
        return XO(((XO00XOO.II0xO0) oOoXoXO.I0Io(iI0xO0, "className == null", new Object[0])).oo0xXOI0I());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static II0xO0 XO(String str) {
        return new II0xO0(Kind.CLASS, (String) oOoXoXO.I0Io(str, "name == null", new Object[0]), null);
    }

    public static II0xO0 oIX0oI(XO00XOO.II0xO0 iI0xO0) {
        return II0xO0(((XO00XOO.II0xO0) oOoXoXO.I0Io(iI0xO0, "className == null", new Object[0])).oo0xXOI0I());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static II0xO0 oOoXoXO(String str) {
        return new II0xO0(Kind.INTERFACE, (String) oOoXoXO.I0Io(str, "name == null", new Object[0]), null);
    }

    public static II0xO0 oxoX(String str, Object... objArr) {
        return I0Io(com.squareup.javapoet.II0xO0.I0Io().II0xO0(str, objArr).OOXIXo());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static II0xO0 xxIXOIIO(String str) {
        return new II0xO0(Kind.ENUM, (String) oOoXoXO.I0Io(str, "name == null", new Object[0]), null);
    }

    public void Oxx0IOOO(XO00XOO.oxoX oxox, String str, Set<Modifier> set) throws IOException {
        List<xoIox> singletonList;
        List<xoIox> list;
        xoIox xoiox;
        boolean z = true;
        int i = oxox.f3894x0XOIxOo;
        oxox.f3894x0XOIxOo = -1;
        try {
            if (str != null) {
                oxox.II0XooXoX(this.f25847oxoX);
                oxox.X0o0xo(this.f25841X0o0xo, false);
                oxox.I0Io("$L", str);
                if (!this.f25836I0Io.f25832oIX0oI.isEmpty()) {
                    oxox.II0xO0(oIX0oI.I0Io.f4096II0xO0);
                    oxox.oIX0oI(this.f25836I0Io);
                    oxox.II0xO0(oIX0oI.I0Io.f4095I0Io);
                }
                if (this.f25839OOXIXo.isEmpty() && this.f25848x0XOIxOo.isEmpty() && this.f25844oO.isEmpty()) {
                    oxox.f3894x0XOIxOo = i;
                    return;
                }
                oxox.II0xO0(" {\n");
            } else if (this.f25836I0Io != null) {
                if (!this.f25851xxIXOIIO.isEmpty()) {
                    xoiox = this.f25851xxIXOIIO.get(0);
                } else {
                    xoiox = this.f25837II0XooXoX;
                }
                oxox.I0Io("new $T(", xoiox);
                oxox.oIX0oI(this.f25836I0Io);
                oxox.II0xO0(") {\n");
            } else {
                oxox.o00(new TypeSpec(this));
                oxox.II0XooXoX(this.f25847oxoX);
                oxox.X0o0xo(this.f25841X0o0xo, false);
                oxox.OOXIXo(this.f25842XO, oOoXoXO.ooOOo0oXI(set, this.f25843oIX0oI.asMemberModifiers));
                Kind kind = this.f25843oIX0oI;
                if (kind == Kind.ANNOTATION) {
                    oxox.I0Io("$L $L", "@interface", this.f25838II0xO0);
                } else {
                    oxox.I0Io("$L $L", kind.name().toLowerCase(Locale.US), this.f25838II0xO0);
                }
                oxox.ooOOo0oXI(this.f25840Oxx0IOOO);
                if (this.f25843oIX0oI == Kind.INTERFACE) {
                    singletonList = this.f25851xxIXOIIO;
                    list = Collections.emptyList();
                } else {
                    if (this.f25837II0XooXoX.equals(XO00XOO.II0xO0.f3866Xx000oIo)) {
                        singletonList = Collections.emptyList();
                    } else {
                        singletonList = Collections.singletonList(this.f25837II0XooXoX);
                    }
                    list = this.f25851xxIXOIIO;
                }
                if (!singletonList.isEmpty()) {
                    oxox.II0xO0(" extends");
                    boolean z2 = true;
                    for (xoIox xoiox2 : singletonList) {
                        if (!z2) {
                            oxox.II0xO0(",");
                        }
                        oxox.I0Io(" $T", xoiox2);
                        z2 = false;
                    }
                }
                if (!list.isEmpty()) {
                    oxox.II0xO0(" implements");
                    boolean z3 = true;
                    for (xoIox xoiox3 : list) {
                        if (!z3) {
                            oxox.II0xO0(",");
                        }
                        oxox.I0Io(" $T", xoiox3);
                        z3 = false;
                    }
                }
                oxox.IIXOooo();
                oxox.II0xO0(" {\n");
            }
            oxox.o00(this);
            oxox.IXxxXO();
            Iterator<Map.Entry<String, TypeSpec>> it = this.f25850xoIox.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, TypeSpec> next = it.next();
                if (!z) {
                    oxox.II0xO0("\n");
                }
                next.getValue().Oxx0IOOO(oxox, next.getKey(), Collections.emptySet());
                if (it.hasNext()) {
                    oxox.II0xO0(",\n");
                } else {
                    if (this.f25839OOXIXo.isEmpty() && this.f25848x0XOIxOo.isEmpty() && this.f25844oO.isEmpty()) {
                        oxox.II0xO0("\n");
                    }
                    oxox.II0xO0(";\n");
                }
                z = false;
            }
            for (I0Io i0Io : this.f25839OOXIXo) {
                if (i0Io.oxoX(Modifier.STATIC)) {
                    if (!z) {
                        oxox.II0xO0("\n");
                    }
                    i0Io.I0Io(oxox, this.f25843oIX0oI.implicitFieldModifiers);
                    z = false;
                }
            }
            if (!this.f25845oOoXoXO.oxoX()) {
                if (!z) {
                    oxox.II0xO0("\n");
                }
                oxox.oIX0oI(this.f25845oOoXoXO);
                z = false;
            }
            for (I0Io i0Io2 : this.f25839OOXIXo) {
                if (!i0Io2.oxoX(Modifier.STATIC)) {
                    if (!z) {
                        oxox.II0xO0("\n");
                    }
                    i0Io2.I0Io(oxox, this.f25843oIX0oI.implicitFieldModifiers);
                    z = false;
                }
            }
            if (!this.f25846ooOOo0oXI.oxoX()) {
                if (!z) {
                    oxox.II0xO0("\n");
                }
                oxox.oIX0oI(this.f25846ooOOo0oXI);
                z = false;
            }
            for (X0o0xo x0o0xo : this.f25848x0XOIxOo) {
                if (x0o0xo.oxoX()) {
                    if (!z) {
                        oxox.II0xO0("\n");
                    }
                    x0o0xo.II0xO0(oxox, this.f25838II0xO0, this.f25843oIX0oI.implicitMethodModifiers);
                    z = false;
                }
            }
            for (X0o0xo x0o0xo2 : this.f25848x0XOIxOo) {
                if (!x0o0xo2.oxoX()) {
                    if (!z) {
                        oxox.II0xO0("\n");
                    }
                    x0o0xo2.II0xO0(oxox, this.f25838II0xO0, this.f25843oIX0oI.implicitMethodModifiers);
                    z = false;
                }
            }
            for (TypeSpec typeSpec : this.f25844oO) {
                if (!z) {
                    oxox.II0xO0("\n");
                }
                typeSpec.Oxx0IOOO(oxox, null, this.f25843oIX0oI.implicitTypeModifiers);
                z = false;
            }
            oxox.XI0IXoo();
            oxox.IIXOooo();
            oxox.II0xO0(ooOOo0oXI.f33074oOoXoXO);
            if (str == null && this.f25836I0Io == null) {
                oxox.II0xO0("\n");
            }
            oxox.f3894x0XOIxOo = i;
        } catch (Throwable th) {
            oxox.f3894x0XOIxOo = i;
            throw th;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TypeSpec.class != obj.getClass()) {
            return false;
        }
        return toString().equals(obj.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public II0xO0 ooOOo0oXI() {
        II0xO0 iI0xO0 = new II0xO0(this.f25843oIX0oI, this.f25838II0xO0, this.f25836I0Io);
        iI0xO0.f25863oxoX.oIX0oI(this.f25847oxoX);
        iI0xO0.f25857X0o0xo.addAll(this.f25841X0o0xo);
        iI0xO0.f25858XO.addAll(this.f25842XO);
        iI0xO0.f25856Oxx0IOOO.addAll(this.f25840Oxx0IOOO);
        iI0xO0.f25853II0XooXoX = this.f25837II0XooXoX;
        iI0xO0.f25867xxIXOIIO.addAll(this.f25851xxIXOIIO);
        iI0xO0.f25866xoIox.putAll(this.f25850xoIox);
        iI0xO0.f25855OOXIXo.addAll(this.f25839OOXIXo);
        iI0xO0.f25864x0XOIxOo.addAll(this.f25848x0XOIxOo);
        iI0xO0.f25860oO.addAll(this.f25844oO);
        iI0xO0.f25862ooOOo0oXI.oIX0oI(this.f25846ooOOo0oXI);
        iI0xO0.f25861oOoXoXO.oIX0oI(this.f25845oOoXoXO);
        return iI0xO0;
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            Oxx0IOOO(new XO00XOO.oxoX(stringWriter), null, Collections.emptySet());
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    public boolean xoIox(Modifier modifier) {
        return this.f25842XO.contains(modifier);
    }

    public TypeSpec(II0xO0 iI0xO0) {
        this.f25843oIX0oI = iI0xO0.f25859oIX0oI;
        this.f25838II0xO0 = iI0xO0.f25854II0xO0;
        this.f25836I0Io = iI0xO0.f25852I0Io;
        this.f25847oxoX = iI0xO0.f25863oxoX.OOXIXo();
        this.f25841X0o0xo = oOoXoXO.XO(iI0xO0.f25857X0o0xo);
        this.f25842XO = oOoXoXO.xxIXOIIO(iI0xO0.f25858XO);
        this.f25840Oxx0IOOO = oOoXoXO.XO(iI0xO0.f25856Oxx0IOOO);
        this.f25837II0XooXoX = iI0xO0.f25853II0XooXoX;
        this.f25851xxIXOIIO = oOoXoXO.XO(iI0xO0.f25867xxIXOIIO);
        this.f25850xoIox = oOoXoXO.Oxx0IOOO(iI0xO0.f25866xoIox);
        this.f25839OOXIXo = oOoXoXO.XO(iI0xO0.f25855OOXIXo);
        this.f25845oOoXoXO = iI0xO0.f25861oOoXoXO.OOXIXo();
        this.f25846ooOOo0oXI = iI0xO0.f25862ooOOo0oXI.OOXIXo();
        this.f25848x0XOIxOo = oOoXoXO.XO(iI0xO0.f25864x0XOIxOo);
        this.f25844oO = oOoXoXO.XO(iI0xO0.f25860oO);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(iI0xO0.f25865x0xO0oo);
        Iterator it = iI0xO0.f25860oO.iterator();
        while (it.hasNext()) {
            arrayList.addAll(((TypeSpec) it.next()).f25849x0xO0oo);
        }
        this.f25849x0xO0oo = oOoXoXO.XO(arrayList);
    }

    public TypeSpec(TypeSpec typeSpec) {
        this.f25843oIX0oI = typeSpec.f25843oIX0oI;
        this.f25838II0xO0 = typeSpec.f25838II0xO0;
        this.f25836I0Io = null;
        this.f25847oxoX = typeSpec.f25847oxoX;
        this.f25841X0o0xo = Collections.emptyList();
        this.f25842XO = Collections.emptySet();
        this.f25840Oxx0IOOO = Collections.emptyList();
        this.f25837II0XooXoX = null;
        this.f25851xxIXOIIO = Collections.emptyList();
        this.f25850xoIox = Collections.emptyMap();
        this.f25839OOXIXo = Collections.emptyList();
        this.f25845oOoXoXO = typeSpec.f25845oOoXoXO;
        this.f25846ooOOo0oXI = typeSpec.f25846ooOOo0oXI;
        this.f25848x0XOIxOo = Collections.emptyList();
        this.f25844oO = Collections.emptyList();
        this.f25849x0xO0oo = Collections.emptyList();
    }
}
