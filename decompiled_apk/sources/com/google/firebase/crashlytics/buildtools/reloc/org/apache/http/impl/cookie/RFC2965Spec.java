package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.Header;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HeaderElement;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.NameValuePair;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.Contract;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.Obsolete;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.ThreadingBehavior;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.params.CookiePolicy;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.CommonCookieAttributeHandler;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.Cookie;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.CookieAttributeHandler;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.CookieOrigin;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.CookieRestrictionViolationException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.MalformedCookieException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.SM;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BufferedHeader;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.CharArrayBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Obsolete
@Contract(threading = ThreadingBehavior.SAFE)
/* loaded from: classes10.dex */
public class RFC2965Spec extends RFC2109Spec {
    public RFC2965Spec() {
        this((String[]) null, false);
    }

    private static CookieOrigin adjustEffectiveHost(CookieOrigin cookieOrigin) {
        String host = cookieOrigin.getHost();
        for (int i = 0; i < host.length(); i++) {
            char charAt = host.charAt(i);
            if (charAt == '.' || charAt == ':') {
                return cookieOrigin;
            }
        }
        return new CookieOrigin(host + ".local", cookieOrigin.getPort(), cookieOrigin.getPath(), cookieOrigin.isSecure());
    }

    private List<Cookie> createCookies(HeaderElement[] headerElementArr, CookieOrigin cookieOrigin) throws MalformedCookieException {
        ArrayList arrayList = new ArrayList(headerElementArr.length);
        for (HeaderElement headerElement : headerElementArr) {
            String name = headerElement.getName();
            String value = headerElement.getValue();
            if (name != null && !name.isEmpty()) {
                BasicClientCookie2 basicClientCookie2 = new BasicClientCookie2(name, value);
                basicClientCookie2.setPath(CookieSpecBase.getDefaultPath(cookieOrigin));
                basicClientCookie2.setDomain(CookieSpecBase.getDefaultDomain(cookieOrigin));
                basicClientCookie2.setPorts(new int[]{cookieOrigin.getPort()});
                NameValuePair[] parameters = headerElement.getParameters();
                HashMap hashMap = new HashMap(parameters.length);
                for (int length = parameters.length - 1; length >= 0; length--) {
                    NameValuePair nameValuePair = parameters[length];
                    hashMap.put(nameValuePair.getName().toLowerCase(Locale.ROOT), nameValuePair);
                }
                Iterator it = hashMap.entrySet().iterator();
                while (it.hasNext()) {
                    NameValuePair nameValuePair2 = (NameValuePair) ((Map.Entry) it.next()).getValue();
                    String lowerCase = nameValuePair2.getName().toLowerCase(Locale.ROOT);
                    basicClientCookie2.setAttribute(lowerCase, nameValuePair2.getValue());
                    CookieAttributeHandler findAttribHandler = findAttribHandler(lowerCase);
                    if (findAttribHandler != null) {
                        findAttribHandler.parse(basicClientCookie2, nameValuePair2.getValue());
                    }
                }
                arrayList.add(basicClientCookie2);
            } else {
                throw new MalformedCookieException("Cookie name may not be empty");
            }
        }
        return arrayList;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.RFC2109Spec
    public void formatCookieAsVer(CharArrayBuffer charArrayBuffer, Cookie cookie, int i) {
        String attribute;
        int[] ports;
        super.formatCookieAsVer(charArrayBuffer, cookie, i);
        if ((cookie instanceof ClientCookie) && (attribute = ((ClientCookie) cookie).getAttribute(ClientCookie.PORT_ATTR)) != null) {
            charArrayBuffer.append("; $Port");
            charArrayBuffer.append("=\"");
            if (!attribute.trim().isEmpty() && (ports = cookie.getPorts()) != null) {
                int length = ports.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (i2 > 0) {
                        charArrayBuffer.append(",");
                    }
                    charArrayBuffer.append(Integer.toString(ports[i2]));
                }
            }
            charArrayBuffer.append("\"");
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.RFC2109Spec, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.CookieSpec
    public int getVersion() {
        return 1;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.RFC2109Spec, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.CookieSpec
    public Header getVersionHeader() {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(40);
        charArrayBuffer.append(SM.COOKIE2);
        charArrayBuffer.append(": ");
        charArrayBuffer.append("$Version=");
        charArrayBuffer.append(Integer.toString(getVersion()));
        return new BufferedHeader(charArrayBuffer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.CookieSpecBase, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.CookieSpec
    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        return super.match(cookie, adjustEffectiveHost(cookieOrigin));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.RFC2109Spec, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.CookieSpec
    public List<Cookie> parse(Header header, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Args.notNull(header, "Header");
        Args.notNull(cookieOrigin, "Cookie origin");
        if (header.getName().equalsIgnoreCase("Set-Cookie2")) {
            return createCookies(header.getElements(), adjustEffectiveHost(cookieOrigin));
        }
        throw new MalformedCookieException("Unrecognized cookie header '" + header.toString() + "'");
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.RFC2109Spec
    public String toString() {
        return CookiePolicy.RFC_2965;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.RFC2109Spec, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.CookieSpecBase, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.CookieSpec
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        super.validate(cookie, adjustEffectiveHost(cookieOrigin));
    }

    public RFC2965Spec(String[] strArr, boolean z) {
        super(z, new RFC2965VersionAttributeHandler(), new BasicPathHandler() { // from class: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.RFC2965Spec.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.BasicPathHandler, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.CookieAttributeHandler
            public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
                if (match(cookie, cookieOrigin)) {
                    return;
                }
                throw new CookieRestrictionViolationException("Illegal 'path' attribute \"" + cookie.getPath() + "\". Path of origin: \"" + cookieOrigin.getPath() + "\"");
            }
        }, new RFC2965DomainAttributeHandler(), new RFC2965PortAttributeHandler(), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicCommentHandler(), new BasicExpiresHandler(strArr != null ? (String[]) strArr.clone() : RFC2109Spec.DATE_PATTERNS), new RFC2965CommentUrlAttributeHandler(), new RFC2965DiscardAttributeHandler());
    }

    public RFC2965Spec(boolean z, CommonCookieAttributeHandler... commonCookieAttributeHandlerArr) {
        super(z, commonCookieAttributeHandlerArr);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.CookieSpecBase
    public List<Cookie> parse(HeaderElement[] headerElementArr, CookieOrigin cookieOrigin) throws MalformedCookieException {
        return createCookies(headerElementArr, adjustEffectiveHost(cookieOrigin));
    }
}
