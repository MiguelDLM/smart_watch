package com.squareup.javapoet;

import XO00XOO.oOoXoXO;
import XO00XOO.xoIox;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;

/* loaded from: classes11.dex */
public final class II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final Pattern f25829I0Io = Pattern.compile("\\$(?<argumentName>[\\w_]+):(?<typeChar>[\\w]).*");

    /* renamed from: oxoX, reason: collision with root package name */
    public static final Pattern f25830oxoX = Pattern.compile("[a-z]+[\\w_]*");

    /* renamed from: II0xO0, reason: collision with root package name */
    public final List<Object> f25831II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final List<String> f25832oIX0oI;

    /* renamed from: com.squareup.javapoet.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C1032II0xO0 {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final List<Object> f25833II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final List<String> f25834oIX0oI;

        public final void I0Io(String str, char c, Object obj) {
            if (c != 'L') {
                if (c != 'N') {
                    if (c != 'S') {
                        if (c == 'T') {
                            this.f25833II0xO0.add(xxIXOIIO(obj));
                            return;
                        }
                        throw new IllegalArgumentException(String.format("invalid format string: '%s'", str));
                    }
                    this.f25833II0xO0.add(II0XooXoX(obj));
                    return;
                }
                this.f25833II0xO0.add(Oxx0IOOO(obj));
                return;
            }
            this.f25833II0xO0.add(XO(obj));
        }

        public final String II0XooXoX(Object obj) {
            if (obj != null) {
                return String.valueOf(obj);
            }
            return null;
        }

        public C1032II0xO0 II0xO0(String str, Object... objArr) {
            String str2;
            int i;
            boolean z;
            boolean z2;
            int i2;
            char charAt;
            boolean z3;
            boolean z4;
            int i3;
            boolean z5;
            boolean z6;
            int i4 = 1;
            int[] iArr = new int[objArr.length];
            int i5 = 0;
            boolean z7 = false;
            int i6 = 0;
            boolean z8 = false;
            while (i5 < str.length()) {
                if (str.charAt(i5) != '$') {
                    int indexOf = str.indexOf(36, i5 + 1);
                    if (indexOf == -1) {
                        indexOf = str.length();
                    }
                    this.f25834oIX0oI.add(str.substring(i5, indexOf));
                    i5 = indexOf;
                } else {
                    int i7 = i5 + 1;
                    int i8 = i7;
                    while (true) {
                        if (i8 < str.length()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        Object[] objArr2 = new Object[i4];
                        objArr2[0] = str;
                        oOoXoXO.II0xO0(z2, "dangling format characters in '%s'", objArr2);
                        i2 = i8 + 1;
                        charAt = str.charAt(i8);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i8 = i2;
                    }
                    if (oO(charAt)) {
                        if (i7 == i8) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        oOoXoXO.II0xO0(z3, "$$, $>, $<, $[, $], and $W may not have an index", new Object[0]);
                        this.f25834oIX0oI.add("$" + charAt);
                        i5 = i2;
                    } else {
                        if (i7 < i8) {
                            int parseInt = Integer.parseInt(str.substring(i7, i8)) - i4;
                            if (objArr.length > 0) {
                                int length = parseInt % objArr.length;
                                iArr[length] = iArr[length] + i4;
                            }
                            z4 = true;
                            i3 = i6;
                            i6 = parseInt;
                        } else {
                            z4 = z8;
                            i3 = i6 + 1;
                            z7 = true;
                        }
                        if (i6 >= 0 && i6 < objArr.length) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        oOoXoXO.II0xO0(z5, "index %d for '%s' not in range (received %s arguments)", Integer.valueOf(i6 + 1), str.substring(i5, i8 + i4), Integer.valueOf(objArr.length));
                        if (z4 && z7) {
                            z6 = false;
                        } else {
                            z6 = true;
                        }
                        oOoXoXO.II0xO0(z6, "cannot mix indexed and positional parameters", new Object[0]);
                        I0Io(str, charAt, objArr[i6]);
                        this.f25834oIX0oI.add("$" + charAt);
                        i5 = i2;
                        i6 = i3;
                        z8 = z4;
                        i4 = 1;
                    }
                }
            }
            if (z7) {
                if (i6 >= objArr.length) {
                    z = true;
                } else {
                    z = false;
                }
                oOoXoXO.II0xO0(z, "unused arguments: expected %s, received %s", Integer.valueOf(i6), Integer.valueOf(objArr.length));
            }
            if (z8) {
                ArrayList arrayList = new ArrayList();
                int i9 = 0;
                while (i9 < objArr.length) {
                    if (iArr[i9] == 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("$");
                        i = 1;
                        sb.append(i9 + 1);
                        arrayList.add(sb.toString());
                    } else {
                        i = 1;
                    }
                    i9 += i;
                }
                if (arrayList.size() == 1) {
                    str2 = "";
                } else {
                    str2 = "s";
                }
                oOoXoXO.II0xO0(arrayList.isEmpty(), "unused argument%s: %s", str2, oOoXoXO.xoIox(", ", arrayList));
            }
            return this;
        }

        public II0xO0 OOXIXo() {
            return new II0xO0(this);
        }

        public C1032II0xO0 Oo() {
            this.f25834oIX0oI.add("$<");
            return this;
        }

        public final String Oxx0IOOO(Object obj) {
            if (obj instanceof CharSequence) {
                return obj.toString();
            }
            if (obj instanceof XO) {
                return ((XO) obj).f25893oIX0oI;
            }
            if (obj instanceof I0Io) {
                return ((I0Io) obj).f25818II0xO0;
            }
            if (obj instanceof X0o0xo) {
                return ((X0o0xo) obj).f25876oIX0oI;
            }
            if (obj instanceof TypeSpec) {
                return ((TypeSpec) obj).f25838II0xO0;
            }
            throw new IllegalArgumentException("expected name but was " + obj);
        }

        public C1032II0xO0 X0o0xo(String str, Object... objArr) {
            II0xO0("$[", new Object[0]);
            II0xO0(str, objArr);
            II0xO0(";\n$]", new Object[0]);
            return this;
        }

        public final Object XO(Object obj) {
            return obj;
        }

        public C1032II0xO0 oIX0oI(II0xO0 iI0xO0) {
            this.f25834oIX0oI.addAll(iI0xO0.f25832oIX0oI);
            this.f25833II0xO0.addAll(iI0xO0.f25831II0xO0);
            return this;
        }

        public final boolean oO(char c) {
            return c == '$' || c == '>' || c == '<' || c == '[' || c == ']' || c == 'W';
        }

        public C1032II0xO0 oOoXoXO() {
            Oo();
            II0xO0("}\n", new Object[0]);
            return this;
        }

        public C1032II0xO0 ooOOo0oXI(String str, Object... objArr) {
            Oo();
            II0xO0("} " + str + ";\n", objArr);
            return this;
        }

        public C1032II0xO0 oxoX(String str, Map<String, ?> map) {
            Matcher matcher;
            boolean z;
            String group;
            String group2;
            for (String str2 : map.keySet()) {
                oOoXoXO.II0xO0(II0xO0.f25830oxoX.matcher(str2).matches(), "argument '%s' must start with a lowercase character", str2);
            }
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    break;
                }
                int indexOf = str.indexOf("$", i);
                if (indexOf == -1) {
                    this.f25834oIX0oI.add(str.substring(i, str.length()));
                    break;
                }
                if (i != indexOf) {
                    this.f25834oIX0oI.add(str.substring(i, indexOf));
                    i = indexOf;
                }
                int indexOf2 = str.indexOf(58, i);
                if (indexOf2 != -1) {
                    matcher = II0xO0.f25829I0Io.matcher(str.substring(i, Math.min(indexOf2 + 2, str.length())));
                } else {
                    matcher = null;
                }
                if (matcher != null && matcher.lookingAt()) {
                    group = matcher.group("argumentName");
                    oOoXoXO.II0xO0(map.containsKey(group), "Missing named argument for $%s", group);
                    group2 = matcher.group("typeChar");
                    char charAt = group2.charAt(0);
                    I0Io(str, charAt, map.get(group));
                    this.f25834oIX0oI.add("$" + charAt);
                    i += matcher.regionEnd();
                } else {
                    if (i < str.length() - 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    oOoXoXO.II0xO0(z, "dangling $ at end", new Object[0]);
                    int i2 = i + 1;
                    oOoXoXO.II0xO0(oO(str.charAt(i2)), "unknown format $%s at %s in '%s'", Character.valueOf(str.charAt(i2)), Integer.valueOf(i2), str);
                    int i3 = i + 2;
                    this.f25834oIX0oI.add(str.substring(i, i3));
                    i = i3;
                }
            }
            return this;
        }

        public C1032II0xO0 x0XOIxOo() {
            this.f25834oIX0oI.add("$>");
            return this;
        }

        public C1032II0xO0 x0xO0oo(String str, Object... objArr) {
            Oo();
            II0xO0("} " + str + " {\n", objArr);
            x0XOIxOo();
            return this;
        }

        public C1032II0xO0 xoIox(String str, Object... objArr) {
            II0xO0(str + " {\n", objArr);
            x0XOIxOo();
            return this;
        }

        public final xoIox xxIXOIIO(Object obj) {
            if (obj instanceof xoIox) {
                return (xoIox) obj;
            }
            if (obj instanceof TypeMirror) {
                return xoIox.x0XOIxOo((TypeMirror) obj);
            }
            if (obj instanceof Element) {
                return xoIox.x0XOIxOo(((Element) obj).asType());
            }
            if (obj instanceof Type) {
                return xoIox.oOoXoXO((Type) obj);
            }
            throw new IllegalArgumentException("expected type but was " + obj);
        }

        public C1032II0xO0() {
            this.f25834oIX0oI = new ArrayList();
            this.f25833II0xO0 = new ArrayList();
        }
    }

    public static C1032II0xO0 I0Io() {
        return new C1032II0xO0();
    }

    public static II0xO0 X0o0xo(String str, Object... objArr) {
        return new C1032II0xO0().II0xO0(str, objArr).OOXIXo();
    }

    public C1032II0xO0 XO() {
        C1032II0xO0 c1032II0xO0 = new C1032II0xO0();
        c1032II0xO0.f25834oIX0oI.addAll(this.f25832oIX0oI);
        c1032II0xO0.f25833II0xO0.addAll(this.f25831II0xO0);
        return c1032II0xO0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || II0xO0.class != obj.getClass()) {
            return false;
        }
        return toString().equals(obj.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean oxoX() {
        return this.f25832oIX0oI.isEmpty();
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            new XO00XOO.oxoX(stringWriter).oIX0oI(this);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    public II0xO0(C1032II0xO0 c1032II0xO0) {
        this.f25832oIX0oI = oOoXoXO.XO(c1032II0xO0.f25834oIX0oI);
        this.f25831II0xO0 = oOoXoXO.XO(c1032II0xO0.f25833II0xO0);
    }
}
