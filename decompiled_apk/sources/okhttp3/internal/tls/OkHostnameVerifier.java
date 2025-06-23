package okhttp3.internal.tls;

import OXOo.OOXIXo;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okio.Utf8;

@XX({"SMAP\nOkHostnameVerifier.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OkHostnameVerifier.kt\nokhttp3/internal/tls/OkHostnameVerifier\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,208:1\n1747#2,3:209\n1747#2,3:212\n*S KotlinDebug\n*F\n+ 1 OkHostnameVerifier.kt\nokhttp3/internal/tls/OkHostnameVerifier\n*L\n63#1:209,3\n71#1:212,3\n*E\n"})
/* loaded from: classes6.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;

    @OOXIXo
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    private final String asciiToLowercase(String str) {
        if (isAscii(str)) {
            Locale US = Locale.US;
            IIX0o.oO(US, "US");
            String lowerCase = str.toLowerCase(US);
            IIX0o.oO(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            return lowerCase;
        }
        return str;
    }

    private final List<String> getSubjectAltNames(X509Certificate x509Certificate, int i) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && IIX0o.Oxx0IOOO(list.get(0), Integer.valueOf(i)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
    }

    private final boolean isAscii(String str) {
        if (str.length() != ((int) Utf8.size$default(str, 0, 0, 3, null))) {
            return false;
        }
        return true;
    }

    private final boolean verifyHostname(String str, X509Certificate x509Certificate) {
        String asciiToLowercase = asciiToLowercase(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 2);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (INSTANCE.verifyHostname(asciiToLowercase, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        String canonicalHost = HostnamesKt.toCanonicalHost(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (IIX0o.Oxx0IOOO(canonicalHost, HostnamesKt.toCanonicalHost((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    @OOXIXo
    public final List<String> allSubjectAltNames(@OOXIXo X509Certificate certificate) {
        IIX0o.x0xO0oo(certificate, "certificate");
        return CollectionsKt___CollectionsKt.o0xIIX0(getSubjectAltNames(certificate, 7), getSubjectAltNames(certificate, 2));
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(@OOXIXo String host, @OOXIXo SSLSession session) {
        Certificate certificate;
        IIX0o.x0xO0oo(host, "host");
        IIX0o.x0xO0oo(session, "session");
        if (isAscii(host)) {
            try {
                certificate = session.getPeerCertificates()[0];
                IIX0o.x0XOIxOo(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            } catch (SSLException unused) {
                return false;
            }
        }
        return verify(host, (X509Certificate) certificate);
    }

    public final boolean verify(@OOXIXo String host, @OOXIXo X509Certificate certificate) {
        IIX0o.x0xO0oo(host, "host");
        IIX0o.x0xO0oo(certificate, "certificate");
        return Util.canParseAsIpAddress(host) ? verifyIpAddress(host, certificate) : verifyHostname(host, certificate);
    }

    private final boolean verifyHostname(String str, String str2) {
        if (str != null && str.length() != 0 && !OxI.IOOoXo0Ix(str, FileUtils.FILE_EXTENSION_SEPARATOR, false, 2, null) && !OxI.XO0o(str, "..", false, 2, null) && str2 != null && str2.length() != 0 && !OxI.IOOoXo0Ix(str2, FileUtils.FILE_EXTENSION_SEPARATOR, false, 2, null) && !OxI.XO0o(str2, "..", false, 2, null)) {
            if (!OxI.XO0o(str, FileUtils.FILE_EXTENSION_SEPARATOR, false, 2, null)) {
                str = str + '.';
            }
            String str3 = str;
            if (!OxI.XO0o(str2, FileUtils.FILE_EXTENSION_SEPARATOR, false, 2, null)) {
                str2 = str2 + '.';
            }
            String asciiToLowercase = asciiToLowercase(str2);
            if (!StringsKt__StringsKt.o00xOoIO(asciiToLowercase, "*", false, 2, null)) {
                return IIX0o.Oxx0IOOO(str3, asciiToLowercase);
            }
            if (!OxI.IOOoXo0Ix(asciiToLowercase, "*.", false, 2, null) || StringsKt__StringsKt.XxIIOXIXx(asciiToLowercase, '*', 1, false, 4, null) != -1 || str3.length() < asciiToLowercase.length() || IIX0o.Oxx0IOOO("*.", asciiToLowercase)) {
                return false;
            }
            String substring = asciiToLowercase.substring(1);
            IIX0o.oO(substring, "this as java.lang.String).substring(startIndex)");
            if (!OxI.XO0o(str3, substring, false, 2, null)) {
                return false;
            }
            int length = str3.length() - substring.length();
            return length <= 0 || StringsKt__StringsKt.XIxO(str3, '.', length + (-1), false, 4, null) == -1;
        }
        return false;
    }
}
