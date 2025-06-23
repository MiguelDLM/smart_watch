package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.Consts;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.Header;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntityEnclosingRequest;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpRequest;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthenticationException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.ChallengeState;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.Credentials;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.MalformedChallengeException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BasicHeaderValueFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BasicNameValuePair;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BufferedHeader;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.BasicHttpContext;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HttpContext;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.CharArrayBuffer;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.EncodingUtils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;

/* loaded from: classes10.dex */
public class DigestScheme extends RFC2617Scheme {
    private static final char[] HEXADECIMAL = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final int QOP_AUTH = 2;
    private static final int QOP_AUTH_INT = 1;
    private static final int QOP_MISSING = 0;
    private static final int QOP_UNKNOWN = -1;
    private static final long serialVersionUID = 3883908186234566916L;
    private String a1;
    private String a2;
    private String cnonce;
    private boolean complete;
    private String lastNonce;
    private long nounceCount;

    public DigestScheme(Charset charset) {
        super(charset);
        this.complete = false;
    }

    public static String createCnonce() {
        byte[] bArr = new byte[8];
        new SecureRandom().nextBytes(bArr);
        return encode(bArr);
    }

    private Header createDigestHeader(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException {
        String str;
        String str2;
        char c;
        String str3;
        String str4;
        String str5;
        String str6;
        HttpEntity httpEntity;
        String str7;
        String sb;
        String str8;
        boolean z;
        String str9;
        String parameter = getParameter("uri");
        String parameter2 = getParameter("realm");
        String parameter3 = getParameter("nonce");
        String parameter4 = getParameter("opaque");
        String parameter5 = getParameter("methodname");
        String parameter6 = getParameter("algorithm");
        if (parameter6 == null) {
            parameter6 = "MD5";
        }
        HashSet hashSet = new HashSet(8);
        String str10 = "MD5";
        String parameter7 = getParameter("qop");
        if (parameter7 != null) {
            str2 = "algorithm";
            str = "qop";
            for (StringTokenizer stringTokenizer = new StringTokenizer(parameter7, ","); stringTokenizer.hasMoreTokens(); stringTokenizer = stringTokenizer) {
                hashSet.add(stringTokenizer.nextToken().trim().toLowerCase(Locale.ROOT));
            }
            if ((httpRequest instanceof HttpEntityEnclosingRequest) && hashSet.contains("auth-int")) {
                c = 1;
            } else if (hashSet.contains("auth")) {
                c = 2;
            } else {
                c = 65535;
            }
        } else {
            str = "qop";
            str2 = "algorithm";
            c = 0;
        }
        if (c != 65535) {
            String parameter8 = getParameter("charset");
            if (parameter8 == null) {
                parameter8 = "ISO-8859-1";
            }
            if (parameter6.equalsIgnoreCase("MD5-sess")) {
                str3 = "auth-int";
            } else {
                str3 = "auth-int";
                str10 = parameter6;
            }
            try {
                MessageDigest createMessageDigest = createMessageDigest(str10);
                String name = credentials.getUserPrincipal().getName();
                String password = credentials.getPassword();
                if (parameter3.equals(this.lastNonce)) {
                    str4 = parameter;
                    this.nounceCount++;
                } else {
                    str4 = parameter;
                    this.nounceCount = 1L;
                    this.cnonce = null;
                    this.lastNonce = parameter3;
                }
                StringBuilder sb2 = new StringBuilder(256);
                Formatter formatter = new Formatter(sb2, Locale.US);
                formatter.format("%08x", Long.valueOf(this.nounceCount));
                formatter.close();
                String sb3 = sb2.toString();
                if (this.cnonce == null) {
                    this.cnonce = createCnonce();
                }
                this.a1 = null;
                this.a2 = null;
                if (parameter6.equalsIgnoreCase("MD5-sess")) {
                    sb2.setLength(0);
                    sb2.append(name);
                    sb2.append(':');
                    sb2.append(parameter2);
                    sb2.append(':');
                    sb2.append(password);
                    String encode = encode(createMessageDigest.digest(EncodingUtils.getBytes(sb2.toString(), parameter8)));
                    sb2.setLength(0);
                    sb2.append(encode);
                    sb2.append(':');
                    sb2.append(parameter3);
                    sb2.append(':');
                    sb2.append(this.cnonce);
                    this.a1 = sb2.toString();
                } else {
                    sb2.setLength(0);
                    sb2.append(name);
                    sb2.append(':');
                    sb2.append(parameter2);
                    sb2.append(':');
                    sb2.append(password);
                    this.a1 = sb2.toString();
                }
                String encode2 = encode(createMessageDigest.digest(EncodingUtils.getBytes(this.a1, parameter8)));
                if (c == 2) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(parameter5);
                    sb4.append(':');
                    str5 = str4;
                    sb4.append(str5);
                    this.a2 = sb4.toString();
                    str6 = "auth";
                } else {
                    str5 = str4;
                    if (c != 1) {
                        str6 = "auth";
                        this.a2 = parameter5 + ':' + str5;
                    } else {
                        if (httpRequest instanceof HttpEntityEnclosingRequest) {
                            httpEntity = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
                        } else {
                            httpEntity = null;
                        }
                        if (httpEntity == null || httpEntity.isRepeatable()) {
                            str6 = "auth";
                            HttpEntityDigester httpEntityDigester = new HttpEntityDigester(createMessageDigest);
                            if (httpEntity != null) {
                                try {
                                    httpEntity.writeTo(httpEntityDigester);
                                } catch (IOException e) {
                                    throw new AuthenticationException("I/O error reading entity content", e);
                                }
                            }
                            httpEntityDigester.close();
                            this.a2 = parameter5 + ':' + str5 + ':' + encode(httpEntityDigester.getDigest());
                        } else {
                            str6 = "auth";
                            if (hashSet.contains(str6)) {
                                this.a2 = parameter5 + ':' + str5;
                                c = 2;
                            } else {
                                throw new AuthenticationException("Qop auth-int cannot be used with a non-repeatable entity");
                            }
                        }
                    }
                }
                String encode3 = encode(createMessageDigest.digest(EncodingUtils.getBytes(this.a2, parameter8)));
                if (c == 0) {
                    sb2.setLength(0);
                    sb2.append(encode2);
                    sb2.append(':');
                    sb2.append(parameter3);
                    sb2.append(':');
                    sb2.append(encode3);
                    sb = sb2.toString();
                } else {
                    sb2.setLength(0);
                    sb2.append(encode2);
                    sb2.append(':');
                    sb2.append(parameter3);
                    sb2.append(':');
                    sb2.append(sb3);
                    sb2.append(':');
                    sb2.append(this.cnonce);
                    sb2.append(':');
                    if (c == 1) {
                        str7 = str3;
                    } else {
                        str7 = str6;
                    }
                    sb2.append(str7);
                    sb2.append(':');
                    sb2.append(encode3);
                    sb = sb2.toString();
                }
                String encode4 = encode(createMessageDigest.digest(EncodingUtils.getAsciiBytes(sb)));
                CharArrayBuffer charArrayBuffer = new CharArrayBuffer(128);
                if (isProxy()) {
                    charArrayBuffer.append("Proxy-Authorization");
                } else {
                    charArrayBuffer.append("Authorization");
                }
                charArrayBuffer.append(": Digest ");
                ArrayList arrayList = new ArrayList(20);
                arrayList.add(new BasicNameValuePair("username", name));
                arrayList.add(new BasicNameValuePair("realm", parameter2));
                arrayList.add(new BasicNameValuePair("nonce", parameter3));
                arrayList.add(new BasicNameValuePair("uri", str5));
                arrayList.add(new BasicNameValuePair("response", encode4));
                if (c != 0) {
                    if (c == 1) {
                        str9 = str3;
                    } else {
                        str9 = str6;
                    }
                    str8 = str;
                    arrayList.add(new BasicNameValuePair(str8, str9));
                    arrayList.add(new BasicNameValuePair("nc", sb3));
                    arrayList.add(new BasicNameValuePair("cnonce", this.cnonce));
                } else {
                    str8 = str;
                }
                String str11 = str2;
                arrayList.add(new BasicNameValuePair(str11, parameter6));
                if (parameter4 != null) {
                    arrayList.add(new BasicNameValuePair("opaque", parameter4));
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    BasicNameValuePair basicNameValuePair = (BasicNameValuePair) arrayList.get(i);
                    if (i > 0) {
                        charArrayBuffer.append(", ");
                    }
                    String name2 = basicNameValuePair.getName();
                    if (!"nc".equals(name2) && !str8.equals(name2) && !str11.equals(name2)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    BasicHeaderValueFormatter.INSTANCE.formatNameValuePair(charArrayBuffer, basicNameValuePair, !z);
                }
                return new BufferedHeader(charArrayBuffer);
            } catch (UnsupportedDigestAlgorithmException unused) {
                throw new AuthenticationException("Unsuppported digest algorithm: " + str10);
            }
        }
        throw new AuthenticationException("None of the qop methods is supported: " + parameter7);
    }

    private static MessageDigest createMessageDigest(String str) throws UnsupportedDigestAlgorithmException {
        try {
            return MessageDigest.getInstance(str);
        } catch (Exception unused) {
            throw new UnsupportedDigestAlgorithmException("Unsupported algorithm in HTTP Digest authentication: " + str);
        }
    }

    public static String encode(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length * 2];
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = HEXADECIMAL;
            cArr[i2] = cArr2[(b & 240) >> 4];
            cArr[i2 + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthScheme
    @Deprecated
    public Header authenticate(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException {
        return authenticate(credentials, httpRequest, new BasicHttpContext());
    }

    public String getA1() {
        return this.a1;
    }

    public String getA2() {
        return this.a2;
    }

    public String getCnonce() {
        return this.cnonce;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthScheme
    public String getSchemeName() {
        return "digest";
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthScheme
    public boolean isComplete() {
        if ("true".equalsIgnoreCase(getParameter("stale"))) {
            return false;
        }
        return this.complete;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthScheme
    public boolean isConnectionBased() {
        return false;
    }

    public void overrideParamter(String str, String str2) {
        getParameters().put(str, str2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.AuthSchemeBase, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthScheme
    public void processChallenge(Header header) throws MalformedChallengeException {
        super.processChallenge(header);
        this.complete = true;
        if (!getParameters().isEmpty()) {
        } else {
            throw new MalformedChallengeException("Authentication challenge is empty");
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.AuthSchemeBase
    public String toString() {
        return "DIGEST [complete=" + this.complete + ", nonce=" + this.lastNonce + ", nc=" + this.nounceCount + "]";
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.AuthSchemeBase, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.ContextAwareAuthScheme
    public Header authenticate(Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) throws AuthenticationException {
        Args.notNull(credentials, "Credentials");
        Args.notNull(httpRequest, "HTTP request");
        if (getParameter("realm") != null) {
            if (getParameter("nonce") != null) {
                getParameters().put("methodname", httpRequest.getRequestLine().getMethod());
                getParameters().put("uri", httpRequest.getRequestLine().getUri());
                if (getParameter("charset") == null) {
                    getParameters().put("charset", getCredentialsCharset(httpRequest));
                }
                return createDigestHeader(credentials, httpRequest);
            }
            throw new AuthenticationException("missing nonce in challenge");
        }
        throw new AuthenticationException("missing realm in challenge");
    }

    @Deprecated
    public DigestScheme(ChallengeState challengeState) {
        super(challengeState);
    }

    public DigestScheme() {
        this(Consts.ASCII);
    }
}
