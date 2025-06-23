package XO00XOO;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.NestingKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;

/* loaded from: classes11.dex */
public final class II0xO0 extends xoIox implements Comparable<II0xO0> {

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public static final II0xO0 f3866Xx000oIo = X0IIOO(Object.class);

    /* renamed from: IoOoX, reason: collision with root package name */
    public final List<String> f3867IoOoX;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public final String f3868oOXoIIIo;

    public II0xO0(List<String> list) {
        this(list, new ArrayList());
    }

    public static II0xO0 X0IIOO(Class<?> cls) {
        oOoXoXO.I0Io(cls, "clazz == null", new Object[0]);
        oOoXoXO.II0xO0(!cls.isPrimitive(), "primitive types cannot be represented as a ClassName", new Object[0]);
        oOoXoXO.II0xO0(!Void.TYPE.equals(cls), "'void' type cannot be represented as a ClassName", new Object[0]);
        oOoXoXO.II0xO0(!cls.isArray(), "array types cannot be represented as a ClassName", new Object[0]);
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (cls.isAnonymousClass()) {
                int lastIndexOf = cls.getName().lastIndexOf(46);
                if (lastIndexOf != -1) {
                    String substring = cls.getName().substring(lastIndexOf + 1);
                    arrayList.add(substring.substring(substring.lastIndexOf(36)));
                }
            } else {
                arrayList.add(cls.getSimpleName());
            }
            Class<?> enclosingClass = cls.getEnclosingClass();
            if (enclosingClass == null) {
                break;
            }
            cls = enclosingClass;
        }
        int lastIndexOf2 = cls.getName().lastIndexOf(46);
        if (lastIndexOf2 != -1) {
            arrayList.add(cls.getName().substring(0, lastIndexOf2));
        }
        Collections.reverse(arrayList);
        return new II0xO0(arrayList);
    }

    public static II0xO0 XI0IXoo(String str, String str2, String... strArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        Collections.addAll(arrayList, strArr);
        return new II0xO0(arrayList);
    }

    public static II0xO0 XIxXXX0x0(TypeElement typeElement) {
        boolean z;
        oOoXoXO.I0Io(typeElement, "element == null", new Object[0]);
        ArrayList arrayList = new ArrayList();
        for (TypeElement typeElement2 = typeElement; XxX0x0xxx(typeElement2); typeElement2 = typeElement2.getEnclosingElement()) {
            if (typeElement.getNestingKind() != NestingKind.TOP_LEVEL && typeElement.getNestingKind() != NestingKind.MEMBER) {
                z = false;
            } else {
                z = true;
            }
            oOoXoXO.II0xO0(z, "unexpected type testing", new Object[0]);
            arrayList.add(typeElement2.getSimpleName().toString());
        }
        arrayList.add(xxX(typeElement).getQualifiedName().toString());
        Collections.reverse(arrayList);
        return new II0xO0(arrayList);
    }

    public static boolean XxX0x0xxx(Element element) {
        if (!element.getKind().isClass() && !element.getKind().isInterface()) {
            return false;
        }
        return true;
    }

    public static II0xO0 o00(String str) {
        String str2;
        boolean z;
        boolean z2;
        boolean z3;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < str.length() && Character.isLowerCase(str.codePointAt(i))) {
            i = str.indexOf(46, i) + 1;
            if (i != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            oOoXoXO.II0xO0(z3, "couldn't make a guess for %s", str);
        }
        if (i != 0) {
            str2 = str.substring(0, i - 1);
        } else {
            str2 = "";
        }
        arrayList.add(str2);
        for (String str3 : str.substring(i).split("\\.", -1)) {
            if (!str3.isEmpty() && Character.isUpperCase(str3.codePointAt(0))) {
                z2 = true;
            } else {
                z2 = false;
            }
            oOoXoXO.II0xO0(z2, "couldn't make a guess for %s", str);
            arrayList.add(str3);
        }
        if (arrayList.size() >= 2) {
            z = true;
        } else {
            z = false;
        }
        oOoXoXO.II0xO0(z, "couldn't make a guess for %s", str);
        return new II0xO0(arrayList);
    }

    public static PackageElement xxX(Element element) {
        while (element.getKind() != ElementKind.PACKAGE) {
            element = element.getEnclosingElement();
        }
        return (PackageElement) element;
    }

    public String IIX0o() {
        return this.f3867IoOoX.get(0);
    }

    @Override // XO00XOO.xoIox
    public xoIox IIXOooo() {
        return new II0xO0(this.f3867IoOoX);
    }

    public II0xO0 IoOoX() {
        return new II0xO0(this.f3867IoOoX.subList(0, 2));
    }

    public II0xO0 O0xOxO() {
        if (this.f3867IoOoX.size() == 2) {
            return null;
        }
        return new II0xO0(this.f3867IoOoX.subList(0, r1.size() - 1));
    }

    @Override // java.lang.Comparable
    /* renamed from: OxI, reason: merged with bridge method [inline-methods] */
    public int compareTo(II0xO0 iI0xO0) {
        return this.f3868oOXoIIIo.compareTo(iI0xO0.f3868oOXoIIIo);
    }

    public List<String> oo() {
        List<String> list = this.f3867IoOoX;
        return list.subList(1, list.size());
    }

    public String oo0xXOI0I() {
        return this.f3867IoOoX.get(r0.size() - 1);
    }

    public II0xO0 ooXIXxIX(String str) {
        ArrayList arrayList = new ArrayList(this.f3867IoOoX);
        arrayList.set(arrayList.size() - 1, str);
        return new II0xO0(arrayList);
    }

    public String xI() {
        if (this.f3867IoOoX.size() == 2) {
            String IIX0o2 = IIX0o();
            if (IIX0o2.isEmpty()) {
                return this.f3867IoOoX.get(1);
            }
            return IIX0o2 + FileUtils.FILE_EXTENSION_SEPARATOR + this.f3867IoOoX.get(1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IoOoX());
        for (String str : oo().subList(1, oo().size())) {
            sb.append('$');
            sb.append(str);
        }
        return sb.toString();
    }

    public II0xO0 xXxxox0I(String str) {
        oOoXoXO.I0Io(str, "name == null", new Object[0]);
        ArrayList arrayList = new ArrayList(this.f3867IoOoX.size() + 1);
        arrayList.addAll(this.f3867IoOoX);
        arrayList.add(str);
        return new II0xO0(arrayList);
    }

    @Override // XO00XOO.xoIox
    public oxoX xoIox(oxoX oxox) throws IOException {
        return oxox.oxoX(oxox.oI0IIXIo(this));
    }

    @Override // XO00XOO.xoIox
    /* renamed from: xoXoI, reason: merged with bridge method [inline-methods] */
    public II0xO0 I0Io(List<com.squareup.javapoet.oIX0oI> list) {
        return new II0xO0(this.f3867IoOoX, II0XooXoX(list));
    }

    public II0xO0(List<String> list, List<com.squareup.javapoet.oIX0oI> list2) {
        super(list2);
        String xoIox2;
        for (int i = 1; i < list.size(); i++) {
            oOoXoXO.II0xO0(SourceVersion.isName(list.get(i)), "part '%s' is keyword", list.get(i));
        }
        this.f3867IoOoX = oOoXoXO.XO(list);
        if (list.get(0).isEmpty()) {
            xoIox2 = oOoXoXO.xoIox(FileUtils.FILE_EXTENSION_SEPARATOR, list.subList(1, list.size()));
        } else {
            xoIox2 = oOoXoXO.xoIox(FileUtils.FILE_EXTENSION_SEPARATOR, list);
        }
        this.f3868oOXoIIIo = xoIox2.replace(".$", "$");
    }
}
