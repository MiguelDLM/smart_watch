package XO00XOO;

import com.garmin.fit.OxXXx0X;
import com.squareup.javapoet.TypeSpec;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* loaded from: classes11.dex */
public final class oxoX {

    /* renamed from: oO, reason: collision with root package name */
    public static final String f3882oO = new String();

    /* renamed from: I0Io, reason: collision with root package name */
    public int f3883I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final Set<String> f3884II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Oxx0IOOO f3885II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public final Map<String, II0xO0> f3886OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final List<TypeSpec> f3887Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f3888X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public String f3889XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f3890oIX0oI;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public final Set<String> f3891oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public boolean f3892ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f3893oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public int f3894x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public final Map<String, II0xO0> f3895xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final Set<String> f3896xxIXOIIO;

    public oxoX(Appendable appendable) {
        this(appendable, "  ", Collections.emptySet());
    }

    public static String oO(String str) {
        oOoXoXO.II0xO0(Character.isJavaIdentifierStart(str.charAt(0)), "not an identifier: %s", str);
        for (int i = 1; i <= str.length(); i++) {
            if (!SourceVersion.isIdentifier(str.substring(0, i))) {
                return str.substring(0, i - 1);
            }
        }
        return str;
    }

    public oxoX I0Io(String str, Object... objArr) throws IOException {
        return oIX0oI(com.squareup.javapoet.II0xO0.X0o0xo(str, objArr));
    }

    public void II0XooXoX(com.squareup.javapoet.II0xO0 iI0xO0) throws IOException {
        if (iI0xO0.oxoX()) {
            return;
        }
        II0xO0("/**\n");
        this.f3893oxoX = true;
        try {
            oIX0oI(iI0xO0);
            this.f3893oxoX = false;
            II0xO0(" */\n");
        } catch (Throwable th) {
            this.f3893oxoX = false;
            throw th;
        }
    }

    public oxoX II0xO0(String str) throws IOException {
        return oxoX(str);
    }

    public oxoX IIXOooo() {
        this.f3887Oxx0IOOO.remove(r0.size() - 1);
        return this;
    }

    public oxoX IXxxXO() {
        return Oxx0xo(1);
    }

    public final II0xO0 O0xOxO(int i, String str) {
        II0xO0 XI0IXoo2 = II0xO0.XI0IXoo(this.f3889XO, this.f3887Oxx0IOOO.get(0).f25838II0xO0, new String[0]);
        for (int i2 = 1; i2 <= i; i2++) {
            XI0IXoo2 = XI0IXoo2.xXxxox0I(this.f3887Oxx0IOOO.get(i2).f25838II0xO0);
        }
        return XI0IXoo2.xXxxox0I(str);
    }

    public void OOXIXo(Set<Modifier> set, Set<Modifier> set2) throws IOException {
        if (set.isEmpty()) {
            return;
        }
        Iterator it = EnumSet.copyOf((Collection) set).iterator();
        while (it.hasNext()) {
            Modifier modifier = (Modifier) it.next();
            if (!set2.contains(modifier)) {
                oxoX(modifier.name().toLowerCase(Locale.US));
                oxoX(" ");
            }
        }
    }

    public Map<String, II0xO0> Oo() {
        return this.f3895xoIox;
    }

    public final II0xO0 OxI(String str) {
        for (int size = this.f3887Oxx0IOOO.size() - 1; size >= 0; size--) {
            Iterator<TypeSpec> it = this.f3887Oxx0IOOO.get(size).f25844oO.iterator();
            while (it.hasNext()) {
                if (Objects.equals(it.next().f25838II0xO0, str)) {
                    return O0xOxO(size, str);
                }
            }
        }
        if (this.f3887Oxx0IOOO.size() > 0 && Objects.equals(this.f3887Oxx0IOOO.get(0).f25838II0xO0, str)) {
            return II0xO0.XI0IXoo(this.f3889XO, str, new String[0]);
        }
        II0xO0 iI0xO0 = this.f3895xoIox.get(str);
        if (iI0xO0 != null) {
            return iI0xO0;
        }
        return null;
    }

    public final void Oxx0IOOO() throws IOException {
        for (int i = 0; i < this.f3883I0Io; i++) {
            this.f3885II0xO0.oIX0oI(this.f3890oIX0oI);
        }
    }

    public oxoX Oxx0xo(int i) {
        this.f3883I0Io += i;
        return this;
    }

    public oxoX OxxIIOOXO() {
        boolean z;
        String str = this.f3889XO;
        String str2 = f3882oO;
        if (str != str2) {
            z = true;
        } else {
            z = false;
        }
        oOoXoXO.oxoX(z, "package already set: %s", str);
        this.f3889XO = str2;
        return this;
    }

    public Map<String, II0xO0> X0IIOO() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.f3886OOXIXo);
        linkedHashMap.keySet().removeAll(this.f3891oOoXoXO);
        return linkedHashMap;
    }

    public void X0o0xo(List<com.squareup.javapoet.oIX0oI> list, boolean z) throws IOException {
        String str;
        Iterator<com.squareup.javapoet.oIX0oI> it = list.iterator();
        while (it.hasNext()) {
            it.next().I0Io(this, z);
            if (z) {
                str = " ";
            } else {
                str = "\n";
            }
            II0xO0(str);
        }
    }

    public oxoX XI0IXoo() {
        return XIxXXX0x0(1);
    }

    public oxoX XIxXXX0x0(int i) {
        boolean z;
        if (this.f3883I0Io - i >= 0) {
            z = true;
        } else {
            z = false;
        }
        oOoXoXO.II0xO0(z, "cannot unindent %s from %s", Integer.valueOf(i), Integer.valueOf(this.f3883I0Io));
        this.f3883I0Io -= i;
        return this;
    }

    public void XO(com.squareup.javapoet.II0xO0 iI0xO0) throws IOException {
        this.f3892ooOOo0oXI = true;
        this.f3888X0o0xo = true;
        try {
            oIX0oI(iI0xO0);
            II0xO0("\n");
        } finally {
            this.f3888X0o0xo = false;
        }
    }

    public oxoX o00(TypeSpec typeSpec) {
        this.f3887Oxx0IOOO.add(typeSpec);
        return this;
    }

    public String oI0IIXIo(II0xO0 iI0xO0) {
        boolean z;
        II0xO0 iI0xO02 = iI0xO0;
        boolean z2 = false;
        while (iI0xO02 != null) {
            II0xO0 OxI2 = OxI(iI0xO02.oo0xXOI0I());
            if (OxI2 != null) {
                z = true;
            } else {
                z = false;
            }
            if (Objects.equals(OxI2, iI0xO02)) {
                return oOoXoXO.xoIox(FileUtils.FILE_EXTENSION_SEPARATOR, iI0xO0.oo().subList(iI0xO02.oo().size() - 1, iI0xO0.oo().size()));
            }
            iI0xO02 = iI0xO02.O0xOxO();
            z2 = z;
        }
        if (z2) {
            return iI0xO0.f3868oOXoIIIo;
        }
        if (Objects.equals(this.f3889XO, iI0xO0.IIX0o())) {
            this.f3891oOoXoXO.add(iI0xO0.IoOoX().oo0xXOI0I());
            return oOoXoXO.xoIox(FileUtils.FILE_EXTENSION_SEPARATOR, iI0xO0.oo());
        }
        if (!this.f3893oxoX) {
            x0xO0oo(iI0xO0);
        }
        return iI0xO0.f3868oOXoIIIo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v12, types: [XO00XOO.xoIox] */
    /* JADX WARN: Type inference failed for: r6v18, types: [XO00XOO.xoIox] */
    public oxoX oIX0oI(com.squareup.javapoet.II0xO0 iI0xO0) throws IOException {
        char c;
        int i;
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        ListIterator<String> listIterator = iI0xO0.f25832oIX0oI.listIterator();
        II0xO0 iI0xO02 = null;
        int i2 = 0;
        while (listIterator.hasNext()) {
            String next = listIterator.next();
            next.hashCode();
            switch (next.hashCode()) {
                case 1152:
                    if (next.equals("$$")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1176:
                    if (next.equals("$<")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1178:
                    if (next.equals("$>")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1192:
                    if (next.equals("$L")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1194:
                    if (next.equals("$N")) {
                        c = 4;
                        break;
                    }
                    break;
                case OxXXx0X.f13256xXxxox0I /* 1199 */:
                    if (next.equals("$S")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1200:
                    if (next.equals("$T")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1203:
                    if (next.equals("$W")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1207:
                    if (next.equals("$[")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1209:
                    if (next.equals("$]")) {
                        c = '\t';
                        break;
                    }
                    break;
            }
            c = 65535;
            switch (c) {
                case 0:
                    oxoX("$");
                    continue;
                case 1:
                    XI0IXoo();
                    continue;
                case 2:
                    IXxxXO();
                    continue;
                case 3:
                    i = i2 + 1;
                    xxIXOIIO(iI0xO0.f25831II0xO0.get(i2));
                    break;
                case 4:
                    i = i2 + 1;
                    oxoX((String) iI0xO0.f25831II0xO0.get(i2));
                    break;
                case 5:
                    i = i2 + 1;
                    String str2 = (String) iI0xO0.f25831II0xO0.get(i2);
                    if (str2 != null) {
                        str = oOoXoXO.oOoXoXO(str2, this.f3890oIX0oI);
                    } else {
                        str = "null";
                    }
                    oxoX(str);
                    break;
                case 6:
                    int i3 = i2 + 1;
                    ?? r6 = (xoIox) iI0xO0.f25831II0xO0.get(i2);
                    boolean x0xO0oo2 = r6.x0xO0oo();
                    II0xO0 iI0xO03 = r6;
                    if (x0xO0oo2) {
                        r6.OOXIXo(this);
                        iI0xO03 = r6.IIXOooo();
                    }
                    if ((iI0xO03 instanceof II0xO0) && listIterator.hasNext() && !iI0xO0.f25832oIX0oI.get(listIterator.nextIndex()).startsWith("$")) {
                        II0xO0 iI0xO04 = iI0xO03;
                        if (this.f3884II0XooXoX.contains(iI0xO04.f3868oOXoIIIo)) {
                            if (iI0xO02 == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            oOoXoXO.oxoX(z, "pending type for static import?!", new Object[0]);
                            iI0xO02 = iI0xO04;
                            i2 = i3;
                            continue;
                        }
                    }
                    iI0xO03.xoIox(this);
                    i2 = i3;
                    continue;
                case 7:
                    this.f3885II0xO0.oxoX(this.f3883I0Io + 2);
                    continue;
                case '\b':
                    if (this.f3894x0XOIxOo == -1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    oOoXoXO.oxoX(z2, "statement enter $[ followed by statement enter $[", new Object[0]);
                    this.f3894x0XOIxOo = 0;
                    continue;
                case '\t':
                    if (this.f3894x0XOIxOo != -1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    oOoXoXO.oxoX(z3, "statement exit $] has no matching statement enter $[", new Object[0]);
                    if (this.f3894x0XOIxOo > 0) {
                        XIxXXX0x0(2);
                    }
                    this.f3894x0XOIxOo = -1;
                    continue;
                default:
                    if (iI0xO02 != null) {
                        if (next.startsWith(FileUtils.FILE_EXTENSION_SEPARATOR) && oOoXoXO(iI0xO02.f3868oOXoIIIo, next)) {
                            iI0xO02 = null;
                            break;
                        } else {
                            iI0xO02.xoIox(this);
                            iI0xO02 = null;
                        }
                    }
                    oxoX(next);
                    continue;
            }
            i2 = i;
        }
        return this;
    }

    public final boolean oOoXoXO(String str, String str2) throws IOException {
        String substring = str2.substring(1);
        if (substring.isEmpty() || !Character.isJavaIdentifierStart(substring.charAt(0))) {
            return false;
        }
        String str3 = str + FileUtils.FILE_EXTENSION_SEPARATOR + oO(substring);
        String str4 = str + ".*";
        if (!this.f3896xxIXOIIO.contains(str3) && !this.f3896xxIXOIIO.contains(str4)) {
            return false;
        }
        oxoX(substring);
        return true;
    }

    public void ooOOo0oXI(List<OOXIXo> list) throws IOException {
        String str;
        if (list.isEmpty()) {
            return;
        }
        II0xO0("<");
        boolean z = true;
        for (OOXIXo oOXIXo : list) {
            if (!z) {
                II0xO0(", ");
            }
            I0Io("$L", oOXIXo.f3869IoOoX);
            boolean z2 = true;
            for (xoIox xoiox : oOXIXo.f3870oOXoIIIo) {
                if (z2) {
                    str = " extends $T";
                } else {
                    str = " & $T";
                }
                I0Io(str, xoiox);
                z2 = false;
            }
            z = false;
        }
        II0xO0(">");
    }

    public oxoX oxoX(String str) throws IOException {
        String str2;
        String[] split = str.split("\n", -1);
        int length = split.length;
        int i = 0;
        boolean z = true;
        while (i < length) {
            String str3 = split[i];
            if (!z) {
                if ((this.f3893oxoX || this.f3888X0o0xo) && this.f3892ooOOo0oXI) {
                    Oxx0IOOO();
                    Oxx0IOOO oxx0IOOO = this.f3885II0xO0;
                    if (this.f3893oxoX) {
                        str2 = " *";
                    } else {
                        str2 = "//";
                    }
                    oxx0IOOO.oIX0oI(str2);
                }
                this.f3885II0xO0.oIX0oI("\n");
                this.f3892ooOOo0oXI = true;
                int i2 = this.f3894x0XOIxOo;
                if (i2 != -1) {
                    if (i2 == 0) {
                        Oxx0xo(2);
                    }
                    this.f3894x0XOIxOo++;
                }
            }
            if (!str3.isEmpty()) {
                if (this.f3892ooOOo0oXI) {
                    Oxx0IOOO();
                    if (this.f3893oxoX) {
                        this.f3885II0xO0.oIX0oI(" * ");
                    } else if (this.f3888X0o0xo) {
                        this.f3885II0xO0.oIX0oI("// ");
                    }
                }
                this.f3885II0xO0.oIX0oI(str3);
                this.f3892ooOOo0oXI = false;
            }
            i++;
            z = false;
        }
        return this;
    }

    public oxoX x0XOIxOo() throws IOException {
        this.f3885II0xO0.oxoX(this.f3883I0Io + 2);
        return this;
    }

    public final void x0xO0oo(II0xO0 iI0xO0) {
        II0xO0 IoOoX2;
        String oo0xXOI0I2;
        II0xO0 put;
        if (!iI0xO0.IIX0o().isEmpty() && (put = this.f3886OOXIXo.put((oo0xXOI0I2 = (IoOoX2 = iI0xO0.IoOoX()).oo0xXOI0I()), IoOoX2)) != null) {
            this.f3886OOXIXo.put(oo0xXOI0I2, put);
        }
    }

    public void xoIox(Set<Modifier> set) throws IOException {
        OOXIXo(set, Collections.emptySet());
    }

    public oxoX xoXoI(String str) {
        boolean z;
        String str2 = this.f3889XO;
        if (str2 == f3882oO) {
            z = true;
        } else {
            z = false;
        }
        oOoXoXO.oxoX(z, "package already set: %s", str2);
        this.f3889XO = (String) oOoXoXO.I0Io(str, "packageName == null", new Object[0]);
        return this;
    }

    public final void xxIXOIIO(Object obj) throws IOException {
        if (obj instanceof TypeSpec) {
            ((TypeSpec) obj).Oxx0IOOO(this, null, Collections.emptySet());
            return;
        }
        if (obj instanceof com.squareup.javapoet.oIX0oI) {
            ((com.squareup.javapoet.oIX0oI) obj).I0Io(this, true);
        } else if (obj instanceof com.squareup.javapoet.II0xO0) {
            oIX0oI((com.squareup.javapoet.II0xO0) obj);
        } else {
            oxoX(String.valueOf(obj));
        }
    }

    public oxoX(Appendable appendable, String str, Set<String> set) {
        this(appendable, str, Collections.emptyMap(), set);
    }

    public oxoX(Appendable appendable, String str, Map<String, II0xO0> map, Set<String> set) {
        this.f3893oxoX = false;
        this.f3888X0o0xo = false;
        this.f3889XO = f3882oO;
        this.f3887Oxx0IOOO = new ArrayList();
        this.f3886OOXIXo = new LinkedHashMap();
        this.f3891oOoXoXO = new LinkedHashSet();
        this.f3894x0XOIxOo = -1;
        this.f3885II0xO0 = new Oxx0IOOO(appendable, str, 100);
        this.f3890oIX0oI = (String) oOoXoXO.I0Io(str, "indent == null", new Object[0]);
        this.f3895xoIox = (Map) oOoXoXO.I0Io(map, "importedTypes == null", new Object[0]);
        this.f3896xxIXOIIO = (Set) oOoXoXO.I0Io(set, "staticImports == null", new Object[0]);
        this.f3884II0XooXoX = new LinkedHashSet();
        for (String str2 : set) {
            this.f3884II0XooXoX.add(str2.substring(0, str2.lastIndexOf(46)));
        }
    }
}
