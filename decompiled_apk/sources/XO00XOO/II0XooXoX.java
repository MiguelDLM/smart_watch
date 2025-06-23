package XO00XOO;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.lang.model.SourceVersion;

/* loaded from: classes11.dex */
public final class II0XooXoX implements Cloneable {

    /* renamed from: Oo, reason: collision with root package name */
    public final Map<Object, String> f3864Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final Set<String> f3865XO;

    public II0XooXoX() {
        this(new LinkedHashSet(), new LinkedHashMap());
    }

    public static String X0o0xo(String str) {
        int i;
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < str.length()) {
            int codePointAt = str.codePointAt(i2);
            if (i2 == 0 && !Character.isJavaIdentifierStart(codePointAt) && Character.isJavaIdentifierPart(codePointAt)) {
                sb.append("_");
            }
            if (Character.isJavaIdentifierPart(codePointAt)) {
                i = codePointAt;
            } else {
                i = 95;
            }
            sb.appendCodePoint(i);
            i2 += Character.charCount(codePointAt);
        }
        return sb.toString();
    }

    public String I0Io(String str) {
        return oxoX(str, UUID.randomUUID().toString());
    }

    public String II0xO0(Object obj) {
        String str = this.f3864Oo.get(obj);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("unknown tag: " + obj);
    }

    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
    public II0XooXoX clone() {
        return new II0XooXoX(new LinkedHashSet(this.f3865XO), new LinkedHashMap(this.f3864Oo));
    }

    public String oxoX(String str, Object obj) {
        oOoXoXO.I0Io(str, "suggestion", new Object[0]);
        oOoXoXO.I0Io(obj, "tag", new Object[0]);
        String X0o0xo2 = X0o0xo(str);
        while (true) {
            if (!SourceVersion.isKeyword(X0o0xo2) && this.f3865XO.add(X0o0xo2)) {
                break;
            }
            X0o0xo2 = X0o0xo2 + "_";
        }
        String put = this.f3864Oo.put(obj, X0o0xo2);
        if (put == null) {
            return X0o0xo2;
        }
        this.f3864Oo.put(obj, put);
        throw new IllegalArgumentException("tag " + obj + " cannot be used for both '" + put + "' and '" + X0o0xo2 + "'");
    }

    public II0XooXoX(LinkedHashSet<String> linkedHashSet, LinkedHashMap<Object, String> linkedHashMap) {
        this.f3865XO = linkedHashSet;
        this.f3864Oo = linkedHashMap;
    }
}
