package okhttp3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class Challenge {

    @OOXIXo
    private final Map<String, String> authParams;

    @OOXIXo
    private final String scheme;

    public Challenge(@OOXIXo String scheme, @OOXIXo Map<String, String> authParams) {
        String str;
        IIX0o.x0xO0oo(scheme, "scheme");
        IIX0o.x0xO0oo(authParams, "authParams");
        this.scheme = scheme;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : authParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale US = Locale.US;
                IIX0o.oO(US, "US");
                str = key.toLowerCase(US);
                IIX0o.oO(str, "this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            linkedHashMap.put(str, value);
        }
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        IIX0o.oO(unmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.authParams = unmodifiableMap;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "authParams", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_authParams")
    /* renamed from: -deprecated_authParams, reason: not valid java name */
    public final Map<String, String> m323deprecated_authParams() {
        return this.authParams;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "charset", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_charset")
    /* renamed from: -deprecated_charset, reason: not valid java name */
    public final Charset m324deprecated_charset() {
        return charset();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "realm", imports = {}))
    @xxIXOIIO(name = "-deprecated_realm")
    @oOoXoXO
    /* renamed from: -deprecated_realm, reason: not valid java name */
    public final String m325deprecated_realm() {
        return realm();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "scheme", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_scheme")
    /* renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m326deprecated_scheme() {
        return this.scheme;
    }

    @OOXIXo
    @xxIXOIIO(name = "authParams")
    public final Map<String, String> authParams() {
        return this.authParams;
    }

    @OOXIXo
    @xxIXOIIO(name = "charset")
    public final Charset charset() {
        String str = this.authParams.get("charset");
        if (str != null) {
            try {
                Charset forName = Charset.forName(str);
                IIX0o.oO(forName, "forName(charset)");
                return forName;
            } catch (Exception unused) {
            }
        }
        Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
        IIX0o.oO(ISO_8859_1, "ISO_8859_1");
        return ISO_8859_1;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            if (IIX0o.Oxx0IOOO(challenge.scheme, this.scheme) && IIX0o.Oxx0IOOO(challenge.authParams, this.authParams)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.scheme.hashCode()) * 31) + this.authParams.hashCode();
    }

    @xxIXOIIO(name = "realm")
    @oOoXoXO
    public final String realm() {
        return this.authParams.get("realm");
    }

    @OOXIXo
    @xxIXOIIO(name = "scheme")
    public final String scheme() {
        return this.scheme;
    }

    @OOXIXo
    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }

    @OOXIXo
    public final Challenge withCharset(@OOXIXo Charset charset) {
        IIX0o.x0xO0oo(charset, "charset");
        Map O0X2 = o0.O0X(this.authParams);
        String name = charset.name();
        IIX0o.oO(name, "charset.name()");
        O0X2.put("charset", name);
        return new Challenge(this.scheme, (Map<String, String>) O0X2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Challenge(@OXOo.OOXIXo java.lang.String r2, @OXOo.OOXIXo java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "scheme"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            java.lang.String r0 = "realm"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            java.util.Map r3 = java.util.Collections.singletonMap(r0, r3)
            java.lang.String r0 = "singletonMap(\"realm\", realm)"
            kotlin.jvm.internal.IIX0o.oO(r3, r0)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Challenge.<init>(java.lang.String, java.lang.String):void");
    }
}
