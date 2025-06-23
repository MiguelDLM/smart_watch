package okhttp3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import X0.xoIox;
import XO0OX.xxIXOIIO;
import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.EMachine;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.collections.Xo0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.text.OxI;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import kotlin.text.XIxXXX0x0;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;
import org.apache.commons.lang3.ObjectUtils;
import xx0o0O.x0XOIxOo;

/* loaded from: classes6.dex */
public final class HttpUrl {

    @OOXIXo
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";

    @OOXIXo
    public static final String FRAGMENT_ENCODE_SET = "";

    @OOXIXo
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";

    @OOXIXo
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    @OOXIXo
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";

    @OOXIXo
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";

    @OOXIXo
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";

    @OOXIXo
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";

    @OOXIXo
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";

    @OOXIXo
    public static final String QUERY_ENCODE_SET = " \"'<>#";

    @OOXIXo
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    @oOoXoXO
    private final String fragment;

    @OOXIXo
    private final String host;
    private final boolean isHttps;

    @OOXIXo
    private final String password;

    @OOXIXo
    private final List<String> pathSegments;
    private final int port;

    @oOoXoXO
    private final List<String> queryNamesAndValues;

    @OOXIXo
    private final String scheme;

    @OOXIXo
    private final String url;

    @OOXIXo
    private final String username;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    @XX({"SMAP\nHttpUrl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpUrl.kt\nokhttp3/HttpUrl$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1869:1\n1#2:1870\n1549#3:1871\n1620#3,3:1872\n1549#3:1875\n1620#3,3:1876\n*S KotlinDebug\n*F\n+ 1 HttpUrl.kt\nokhttp3/HttpUrl$Builder\n*L\n1180#1:1871\n1180#1:1872,3\n1181#1:1875\n1181#1:1876,3\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class Builder {

        @OOXIXo
        public static final Companion Companion = new Companion(null);

        @OOXIXo
        public static final String INVALID_HOST = "Invalid URL host";

        @oOoXoXO
        private String encodedFragment;

        @OOXIXo
        private final List<String> encodedPathSegments;

        @oOoXoXO
        private List<String> encodedQueryNamesAndValues;

        @oOoXoXO
        private String host;

        @oOoXoXO
        private String scheme;

        @OOXIXo
        private String encodedUsername = "";

        @OOXIXo
        private String encodedPassword = "";
        private int port = -1;

        /* loaded from: classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int parsePort(String str, int i, int i2) {
                try {
                    int parseInt = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i, i2, "", false, false, false, false, null, 248, null));
                    if (1 > parseInt || parseInt >= 65536) {
                        return -1;
                    }
                    return parseInt;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int portColonOffset(String str, int i, int i2) {
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt != '[') {
                        if (charAt == ':') {
                            return i;
                        }
                        i++;
                    }
                    do {
                        i++;
                        if (i < i2) {
                        }
                        i++;
                    } while (str.charAt(i) != ']');
                    i++;
                }
                return i2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int schemeDelimiterOffset(String str, int i, int i2) {
                if (i2 - i < 2) {
                    return -1;
                }
                char charAt = str.charAt(i);
                if ((IIX0o.oI0IIXIo(charAt, 97) < 0 || IIX0o.oI0IIXIo(charAt, 122) > 0) && (IIX0o.oI0IIXIo(charAt, 65) < 0 || IIX0o.oI0IIXIo(charAt, 90) > 0)) {
                    return -1;
                }
                while (true) {
                    i++;
                    if (i >= i2) {
                        return -1;
                    }
                    char charAt2 = str.charAt(i);
                    if ('a' > charAt2 || charAt2 >= '{') {
                        if ('A' > charAt2 || charAt2 >= '[') {
                            if ('0' > charAt2 || charAt2 >= ':') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 != ':') {
                                        return -1;
                                    }
                                    return i;
                                }
                            }
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int slashCount(String str, int i, int i2) {
                int i3 = 0;
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i3++;
                    i++;
                }
                return i3;
            }

            private Companion() {
            }
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private final int effectivePort() {
            int i = this.port;
            if (i == -1) {
                Companion companion = HttpUrl.Companion;
                String str = this.scheme;
                IIX0o.ooOOo0oXI(str);
                return companion.defaultPort(str);
            }
            return i;
        }

        private final boolean isDot(String str) {
            if (IIX0o.Oxx0IOOO(str, FileUtils.FILE_EXTENSION_SEPARATOR) || OxI.oX0I0O(str, "%2e", true)) {
                return true;
            }
            return false;
        }

        private final boolean isDotDot(String str) {
            if (IIX0o.Oxx0IOOO(str, "..") || OxI.oX0I0O(str, "%2e.", true) || OxI.oX0I0O(str, ".%2e", true) || OxI.oX0I0O(str, "%2e%2e", true)) {
                return true;
            }
            return false;
        }

        private final void pop() {
            if (this.encodedPathSegments.remove(r0.size() - 1).length() == 0 && !this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.set(r0.size() - 1, "");
            } else {
                this.encodedPathSegments.add("");
            }
        }

        private final void push(String str, int i, int i2, boolean z, boolean z2) {
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i, i2, HttpUrl.PATH_SEGMENT_ENCODE_SET, z2, false, false, false, null, 240, null);
            if (isDot(canonicalize$okhttp$default)) {
                return;
            }
            if (isDotDot(canonicalize$okhttp$default)) {
                pop();
                return;
            }
            if (this.encodedPathSegments.get(r2.size() - 1).length() == 0) {
                this.encodedPathSegments.set(r2.size() - 1, canonicalize$okhttp$default);
            } else {
                this.encodedPathSegments.add(canonicalize$okhttp$default);
            }
            if (z) {
                this.encodedPathSegments.add("");
            }
        }

        private final void removeAllCanonicalQueryParameters(String str) {
            List<String> list = this.encodedQueryNamesAndValues;
            IIX0o.ooOOo0oXI(list);
            int size = list.size() - 2;
            int I0Io2 = x0XOIxOo.I0Io(size, 0, -2);
            if (I0Io2 > size) {
                return;
            }
            while (true) {
                List<String> list2 = this.encodedQueryNamesAndValues;
                IIX0o.ooOOo0oXI(list2);
                if (IIX0o.Oxx0IOOO(str, list2.get(size))) {
                    List<String> list3 = this.encodedQueryNamesAndValues;
                    IIX0o.ooOOo0oXI(list3);
                    list3.remove(size + 1);
                    List<String> list4 = this.encodedQueryNamesAndValues;
                    IIX0o.ooOOo0oXI(list4);
                    list4.remove(size);
                    List<String> list5 = this.encodedQueryNamesAndValues;
                    IIX0o.ooOOo0oXI(list5);
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (size != I0Io2) {
                    size -= 2;
                } else {
                    return;
                }
            }
        }

        private final void resolvePath(String str, int i, int i2) {
            boolean z;
            if (i == i2) {
                return;
            }
            char charAt = str.charAt(i);
            if (charAt != '/' && charAt != '\\') {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            } else {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                i++;
            }
            while (true) {
                int i3 = i;
                while (i3 < i2) {
                    i = Util.delimiterOffset(str, "/\\", i3, i2);
                    if (i < i2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    push(str, i3, i, z, true);
                    if (z) {
                        i3 = i + 1;
                    }
                }
                return;
            }
        }

        @OOXIXo
        public final Builder addEncodedPathSegment(@OOXIXo String encodedPathSegment) {
            IIX0o.x0xO0oo(encodedPathSegment, "encodedPathSegment");
            push(encodedPathSegment, 0, encodedPathSegment.length(), false, true);
            return this;
        }

        @OOXIXo
        public final Builder addEncodedPathSegments(@OOXIXo String encodedPathSegments) {
            IIX0o.x0xO0oo(encodedPathSegments, "encodedPathSegments");
            return addPathSegments(encodedPathSegments, true);
        }

        @OOXIXo
        public final Builder addEncodedQueryParameter(@OOXIXo String encodedName, @oOoXoXO String str) {
            String str2;
            IIX0o.x0xO0oo(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            IIX0o.ooOOo0oXI(list);
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            IIX0o.ooOOo0oXI(list2);
            if (str != null) {
                str2 = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null);
            } else {
                str2 = null;
            }
            list2.add(str2);
            return this;
        }

        @OOXIXo
        public final Builder addPathSegment(@OOXIXo String pathSegment) {
            IIX0o.x0xO0oo(pathSegment, "pathSegment");
            push(pathSegment, 0, pathSegment.length(), false, false);
            return this;
        }

        @OOXIXo
        public final Builder addPathSegments(@OOXIXo String pathSegments) {
            IIX0o.x0xO0oo(pathSegments, "pathSegments");
            return addPathSegments(pathSegments, false);
        }

        @OOXIXo
        public final Builder addQueryParameter(@OOXIXo String name, @oOoXoXO String str) {
            String str2;
            IIX0o.x0xO0oo(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            IIX0o.ooOOo0oXI(list);
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            IIX0o.ooOOo0oXI(list2);
            if (str != null) {
                str2 = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null);
            } else {
                str2 = null;
            }
            list2.add(str2);
            return this;
        }

        @OOXIXo
        public final HttpUrl build() {
            ArrayList arrayList;
            String str;
            String str2;
            String str3 = this.scheme;
            if (str3 != null) {
                Companion companion = HttpUrl.Companion;
                String percentDecode$okhttp$default = Companion.percentDecode$okhttp$default(companion, this.encodedUsername, 0, 0, false, 7, null);
                String percentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(companion, this.encodedPassword, 0, 0, false, 7, null);
                String str4 = this.host;
                if (str4 != null) {
                    int effectivePort = effectivePort();
                    List<String> list = this.encodedPathSegments;
                    ArrayList arrayList2 = new ArrayList(OxxIIOOXO.xo0x(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(Companion.percentDecode$okhttp$default(HttpUrl.Companion, (String) it.next(), 0, 0, false, 7, null));
                    }
                    List<String> list2 = this.encodedQueryNamesAndValues;
                    if (list2 != null) {
                        List<String> list3 = list2;
                        arrayList = new ArrayList(OxxIIOOXO.xo0x(list3, 10));
                        for (String str5 : list3) {
                            if (str5 != null) {
                                str2 = Companion.percentDecode$okhttp$default(HttpUrl.Companion, str5, 0, 0, true, 3, null);
                            } else {
                                str2 = null;
                            }
                            arrayList.add(str2);
                        }
                    } else {
                        arrayList = null;
                    }
                    String str6 = this.encodedFragment;
                    if (str6 != null) {
                        str = Companion.percentDecode$okhttp$default(HttpUrl.Companion, str6, 0, 0, false, 7, null);
                    } else {
                        str = null;
                    }
                    return new HttpUrl(str3, percentDecode$okhttp$default, percentDecode$okhttp$default2, str4, effectivePort, arrayList2, arrayList, str, toString());
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        @OOXIXo
        public final Builder encodedFragment(@oOoXoXO String str) {
            String str2;
            if (str != null) {
                str2 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", true, false, false, true, null, EMachine.EM_SLE9X, null);
            } else {
                str2 = null;
            }
            this.encodedFragment = str2;
            return this;
        }

        @OOXIXo
        public final Builder encodedPassword(@OOXIXo String encodedPassword) {
            IIX0o.x0xO0oo(encodedPassword, "encodedPassword");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedPassword, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        @OOXIXo
        public final Builder encodedPath(@OOXIXo String encodedPath) {
            IIX0o.x0xO0oo(encodedPath, "encodedPath");
            if (OxI.IOOoXo0Ix(encodedPath, "/", false, 2, null)) {
                resolvePath(encodedPath, 0, encodedPath.length());
                return this;
            }
            throw new IllegalArgumentException(("unexpected encodedPath: " + encodedPath).toString());
        }

        @OOXIXo
        public final Builder encodedQuery(@oOoXoXO String str) {
            List<String> list;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 211, null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                    this.encodedQueryNamesAndValues = list;
                    return this;
                }
            }
            list = null;
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        @OOXIXo
        public final Builder encodedUsername(@OOXIXo String encodedUsername) {
            IIX0o.x0xO0oo(encodedUsername, "encodedUsername");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedUsername, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        @OOXIXo
        public final Builder fragment(@oOoXoXO String str) {
            String str2;
            if (str != null) {
                str2 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", false, false, false, true, null, 187, null);
            } else {
                str2 = null;
            }
            this.encodedFragment = str2;
            return this;
        }

        @oOoXoXO
        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        @OOXIXo
        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        @OOXIXo
        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        @oOoXoXO
        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        @OOXIXo
        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        @oOoXoXO
        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        @oOoXoXO
        public final String getScheme$okhttp() {
            return this.scheme;
        }

        @OOXIXo
        public final Builder host(@OOXIXo String host) {
            IIX0o.x0xO0oo(host, "host");
            String canonicalHost = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, host, 0, 0, false, 7, null));
            if (canonicalHost != null) {
                this.host = canonicalHost;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + host);
        }

        @OOXIXo
        public final Builder parse$okhttp(@oOoXoXO HttpUrl httpUrl, @OOXIXo String str) {
            int delimiterOffset;
            char c;
            int i;
            int i2;
            int i3;
            boolean z;
            String input = str;
            IIX0o.x0xO0oo(input, "input");
            int indexOfFirstNonAsciiWhitespace$default = Util.indexOfFirstNonAsciiWhitespace$default(input, 0, 0, 3, null);
            int indexOfLastNonAsciiWhitespace$default = Util.indexOfLastNonAsciiWhitespace$default(input, indexOfFirstNonAsciiWhitespace$default, 0, 2, null);
            Companion companion = Companion;
            int schemeDelimiterOffset = companion.schemeDelimiterOffset(input, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            char c2 = 65535;
            if (schemeDelimiterOffset != -1) {
                if (OxI.XOxoX(input, "https:", indexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = "https";
                    indexOfFirstNonAsciiWhitespace$default += 6;
                } else if (OxI.XOxoX(input, "http:", indexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = "http";
                    indexOfFirstNonAsciiWhitespace$default += 5;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Expected URL scheme 'http' or 'https' but was '");
                    String substring = input.substring(0, schemeDelimiterOffset);
                    IIX0o.oO(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    sb.append(substring);
                    sb.append('\'');
                    throw new IllegalArgumentException(sb.toString());
                }
            } else if (httpUrl != null) {
                this.scheme = httpUrl.scheme();
            } else {
                if (str.length() > 6) {
                    input = StringsKt___StringsKt.oOI0IXOO(input, 6) + "...";
                }
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no scheme was found for " + input);
            }
            int slashCount = companion.slashCount(input, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            char c3 = '?';
            char c4 = '#';
            if (slashCount < 2 && httpUrl != null && IIX0o.Oxx0IOOO(httpUrl.scheme(), this.scheme)) {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (indexOfFirstNonAsciiWhitespace$default == indexOfLastNonAsciiWhitespace$default || input.charAt(indexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
                i = indexOfLastNonAsciiWhitespace$default;
            } else {
                int i4 = indexOfFirstNonAsciiWhitespace$default + slashCount;
                boolean z2 = false;
                boolean z3 = false;
                while (true) {
                    delimiterOffset = Util.delimiterOffset(input, "@/\\?#", i4, indexOfLastNonAsciiWhitespace$default);
                    if (delimiterOffset != indexOfLastNonAsciiWhitespace$default) {
                        c = input.charAt(delimiterOffset);
                    } else {
                        c = 65535;
                    }
                    if (c == c2 || c == c4 || c == '/' || c == '\\' || c == c3) {
                        break;
                    }
                    if (c == '@') {
                        if (!z2) {
                            int delimiterOffset2 = Util.delimiterOffset(input, ':', i4, delimiterOffset);
                            Companion companion2 = HttpUrl.Companion;
                            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion2, str, i4, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z3) {
                                canonicalize$okhttp$default = this.encodedUsername + "%40" + canonicalize$okhttp$default;
                            }
                            this.encodedUsername = canonicalize$okhttp$default;
                            if (delimiterOffset2 != delimiterOffset) {
                                i2 = delimiterOffset;
                                this.encodedPassword = Companion.canonicalize$okhttp$default(companion2, str, delimiterOffset2 + 1, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z = true;
                            } else {
                                i2 = delimiterOffset;
                                z = z2;
                            }
                            z2 = z;
                            i3 = indexOfLastNonAsciiWhitespace$default;
                            z3 = true;
                        } else {
                            i2 = delimiterOffset;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.encodedPassword);
                            sb2.append("%40");
                            i3 = indexOfLastNonAsciiWhitespace$default;
                            sb2.append(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i4, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
                            this.encodedPassword = sb2.toString();
                        }
                        i4 = i2 + 1;
                        indexOfLastNonAsciiWhitespace$default = i3;
                        c4 = '#';
                        c3 = '?';
                        c2 = 65535;
                    }
                }
                i = indexOfLastNonAsciiWhitespace$default;
                Companion companion3 = Companion;
                int portColonOffset = companion3.portColonOffset(input, i4, delimiterOffset);
                int i5 = portColonOffset + 1;
                if (i5 < delimiterOffset) {
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str, i4, portColonOffset, false, 4, null));
                    int parsePort = companion3.parsePort(input, i5, delimiterOffset);
                    this.port = parsePort;
                    if (parsePort == -1) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Invalid URL port: \"");
                        String substring2 = input.substring(i5, delimiterOffset);
                        IIX0o.oO(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb3.append(substring2);
                        sb3.append('\"');
                        throw new IllegalArgumentException(sb3.toString().toString());
                    }
                } else {
                    Companion companion4 = HttpUrl.Companion;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(companion4, str, i4, portColonOffset, false, 4, null));
                    String str2 = this.scheme;
                    IIX0o.ooOOo0oXI(str2);
                    this.port = companion4.defaultPort(str2);
                }
                if (this.host != null) {
                    indexOfFirstNonAsciiWhitespace$default = delimiterOffset;
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Invalid URL host: \"");
                    String substring3 = input.substring(i4, portColonOffset);
                    IIX0o.oO(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    sb4.append(substring3);
                    sb4.append('\"');
                    throw new IllegalArgumentException(sb4.toString().toString());
                }
            }
            int i6 = i;
            int delimiterOffset3 = Util.delimiterOffset(input, "?#", indexOfFirstNonAsciiWhitespace$default, i6);
            resolvePath(input, indexOfFirstNonAsciiWhitespace$default, delimiterOffset3);
            if (delimiterOffset3 < i6 && input.charAt(delimiterOffset3) == '?') {
                int delimiterOffset4 = Util.delimiterOffset(input, '#', delimiterOffset3, i6);
                Companion companion5 = HttpUrl.Companion;
                this.encodedQueryNamesAndValues = companion5.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(companion5, str, delimiterOffset3 + 1, delimiterOffset4, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 208, null));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < i6 && input.charAt(delimiterOffset3) == '#') {
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, delimiterOffset3 + 1, i6, "", true, false, false, true, null, 176, null);
            }
            return this;
        }

        @OOXIXo
        public final Builder password(@OOXIXo String password) {
            IIX0o.x0xO0oo(password, "password");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        @OOXIXo
        public final Builder port(int i) {
            if (1 <= i && i < 65536) {
                this.port = i;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + i).toString());
        }

        @OOXIXo
        public final Builder query(@oOoXoXO String str) {
            List<String> list;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, null, 219, null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                    this.encodedQueryNamesAndValues = list;
                    return this;
                }
            }
            list = null;
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        @OOXIXo
        public final Builder reencodeForUri$okhttp() {
            String str;
            String str2;
            String str3 = this.host;
            String str4 = null;
            if (str3 != null) {
                str = new Regex("[\"<>^`{|}]").replace(str3, "");
            } else {
                str = null;
            }
            this.host = str;
            int size = this.encodedPathSegments.size();
            for (int i = 0; i < size; i++) {
                List<String> list = this.encodedPathSegments;
                list.set(i, Companion.canonicalize$okhttp$default(HttpUrl.Companion, list.get(i), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, 227, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str5 = list2.get(i2);
                    if (str5 != null) {
                        str2 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str5, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, 195, null);
                    } else {
                        str2 = null;
                    }
                    list2.set(i2, str2);
                }
            }
            String str6 = this.encodedFragment;
            if (str6 != null) {
                str4 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str6, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, 163, null);
            }
            this.encodedFragment = str4;
            return this;
        }

        @OOXIXo
        public final Builder removeAllEncodedQueryParameters(@OOXIXo String encodedName) {
            IIX0o.x0xO0oo(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            return this;
        }

        @OOXIXo
        public final Builder removeAllQueryParameters(@OOXIXo String name) {
            IIX0o.x0xO0oo(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            return this;
        }

        @OOXIXo
        public final Builder removePathSegment(int i) {
            this.encodedPathSegments.remove(i);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        @OOXIXo
        public final Builder scheme(@OOXIXo String scheme) {
            IIX0o.x0xO0oo(scheme, "scheme");
            if (OxI.oX0I0O(scheme, "http", true)) {
                this.scheme = "http";
            } else if (OxI.oX0I0O(scheme, "https", true)) {
                this.scheme = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + scheme);
            }
            return this;
        }

        public final void setEncodedFragment$okhttp(@oOoXoXO String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.encodedPassword = str;
        }

        @OOXIXo
        public final Builder setEncodedPathSegment(int i, @OOXIXo String encodedPathSegment) {
            IIX0o.x0xO0oo(encodedPathSegment, "encodedPathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedPathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, null, 243, null);
            this.encodedPathSegments.set(i, canonicalize$okhttp$default);
            if (!isDot(canonicalize$okhttp$default) && !isDotDot(canonicalize$okhttp$default)) {
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + encodedPathSegment).toString());
        }

        public final void setEncodedQueryNamesAndValues$okhttp(@oOoXoXO List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        @OOXIXo
        public final Builder setEncodedQueryParameter(@OOXIXo String encodedName, @oOoXoXO String str) {
            IIX0o.x0xO0oo(encodedName, "encodedName");
            removeAllEncodedQueryParameters(encodedName);
            addEncodedQueryParameter(encodedName, str);
            return this;
        }

        public final void setEncodedUsername$okhttp(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(@oOoXoXO String str) {
            this.host = str;
        }

        @OOXIXo
        public final Builder setPathSegment(int i, @OOXIXo String pathSegment) {
            IIX0o.x0xO0oo(pathSegment, "pathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, pathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, null, 251, null);
            if (!isDot(canonicalize$okhttp$default) && !isDotDot(canonicalize$okhttp$default)) {
                this.encodedPathSegments.set(i, canonicalize$okhttp$default);
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + pathSegment).toString());
        }

        public final void setPort$okhttp(int i) {
            this.port = i;
        }

        @OOXIXo
        public final Builder setQueryParameter(@OOXIXo String name, @oOoXoXO String str) {
            IIX0o.x0xO0oo(name, "name");
            removeAllQueryParameters(name);
            addQueryParameter(name, str);
            return this;
        }

        public final void setScheme$okhttp(@oOoXoXO String str) {
            this.scheme = str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0083, code lost:
        
            if (r1 != r4.defaultPort(r3)) goto L29;
         */
        @OXOo.OOXIXo
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String toString() {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r6.scheme
                if (r1 == 0) goto L12
                r0.append(r1)
                java.lang.String r1 = "://"
                r0.append(r1)
                goto L17
            L12:
                java.lang.String r1 = "//"
                r0.append(r1)
            L17:
                java.lang.String r1 = r6.encodedUsername
                int r1 = r1.length()
                r2 = 58
                if (r1 <= 0) goto L22
                goto L2a
            L22:
                java.lang.String r1 = r6.encodedPassword
                int r1 = r1.length()
                if (r1 <= 0) goto L44
            L2a:
                java.lang.String r1 = r6.encodedUsername
                r0.append(r1)
                java.lang.String r1 = r6.encodedPassword
                int r1 = r1.length()
                if (r1 <= 0) goto L3f
                r0.append(r2)
                java.lang.String r1 = r6.encodedPassword
                r0.append(r1)
            L3f:
                r1 = 64
                r0.append(r1)
            L44:
                java.lang.String r1 = r6.host
                if (r1 == 0) goto L69
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(r1)
                r3 = 2
                r4 = 0
                r5 = 0
                boolean r1 = kotlin.text.StringsKt__StringsKt.xXo(r1, r2, r5, r3, r4)
                if (r1 == 0) goto L64
                r1 = 91
                r0.append(r1)
                java.lang.String r1 = r6.host
                r0.append(r1)
                r1 = 93
                r0.append(r1)
                goto L69
            L64:
                java.lang.String r1 = r6.host
                r0.append(r1)
            L69:
                int r1 = r6.port
                r3 = -1
                if (r1 != r3) goto L72
                java.lang.String r1 = r6.scheme
                if (r1 == 0) goto L8b
            L72:
                int r1 = r6.effectivePort()
                java.lang.String r3 = r6.scheme
                if (r3 == 0) goto L85
                okhttp3.HttpUrl$Companion r4 = okhttp3.HttpUrl.Companion
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(r3)
                int r3 = r4.defaultPort(r3)
                if (r1 == r3) goto L8b
            L85:
                r0.append(r2)
                r0.append(r1)
            L8b:
                okhttp3.HttpUrl$Companion r1 = okhttp3.HttpUrl.Companion
                java.util.List<java.lang.String> r2 = r6.encodedPathSegments
                r1.toPathString$okhttp(r2, r0)
                java.util.List<java.lang.String> r2 = r6.encodedQueryNamesAndValues
                if (r2 == 0) goto La3
                r2 = 63
                r0.append(r2)
                java.util.List<java.lang.String> r2 = r6.encodedQueryNamesAndValues
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(r2)
                r1.toQueryString$okhttp(r2, r0)
            La3:
                java.lang.String r1 = r6.encodedFragment
                if (r1 == 0) goto Lb1
                r1 = 35
                r0.append(r1)
                java.lang.String r1 = r6.encodedFragment
                r0.append(r1)
            Lb1:
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
                kotlin.jvm.internal.IIX0o.oO(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.toString():java.lang.String");
        }

        @OOXIXo
        public final Builder username(@OOXIXo String username) {
            IIX0o.x0xO0oo(username, "username");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        private final Builder addPathSegments(String str, boolean z) {
            int i = 0;
            do {
                int delimiterOffset = Util.delimiterOffset(str, "/\\", i, str.length());
                push(str, i, delimiterOffset, delimiterOffset < str.length(), z);
                i = delimiterOffset + 1;
            } while (i <= str.length());
            return this;
        }
    }

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset, int i3, Object obj) {
            return companion.canonicalize$okhttp(str, (i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? str.length() : i2, str2, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? false : z2, (i3 & 32) != 0 ? false : z3, (i3 & 64) != 0 ? false : z4, (i3 & 128) != 0 ? null : charset);
        }

        private final boolean isPercentEncoded(String str, int i, int i2) {
            int i3 = i + 2;
            if (i3 < i2 && str.charAt(i) == '%' && Util.parseHexDigit(str.charAt(i + 1)) != -1 && Util.parseHexDigit(str.charAt(i3)) != -1) {
                return true;
            }
            return false;
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String str, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            if ((i3 & 4) != 0) {
                z = false;
            }
            return companion.percentDecode$okhttp(str, i, i2, z);
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x0064, code lost:
        
            if (isPercentEncoded(r16, r5, r18) == false) goto L42;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void writeCanonicalized(okio.Buffer r15, java.lang.String r16, int r17, int r18, java.lang.String r19, boolean r20, boolean r21, boolean r22, boolean r23, java.nio.charset.Charset r24) {
            /*
                r14 = this;
                r0 = r15
                r1 = r16
                r2 = r18
                r3 = r24
                r4 = 0
                r5 = r17
                r6 = r4
            Lb:
                if (r5 >= r2) goto Lbc
                int r7 = r1.codePointAt(r5)
                if (r20 == 0) goto L28
                r8 = 9
                if (r7 == r8) goto L23
                r8 = 10
                if (r7 == r8) goto L23
                r8 = 12
                if (r7 == r8) goto L23
                r8 = 13
                if (r7 != r8) goto L28
            L23:
                r8 = r14
                r12 = r19
                goto Lb5
            L28:
                r8 = 43
                if (r7 != r8) goto L39
                if (r22 == 0) goto L39
                if (r20 == 0) goto L33
                java.lang.String r8 = "+"
                goto L35
            L33:
                java.lang.String r8 = "%2B"
            L35:
                r15.writeUtf8(r8)
                goto L23
            L39:
                r8 = 32
                r9 = 37
                if (r7 < r8) goto L4a
                r8 = 127(0x7f, float:1.78E-43)
                if (r7 == r8) goto L4a
                r8 = 128(0x80, float:1.8E-43)
                if (r7 < r8) goto L4e
                if (r23 == 0) goto L4a
                goto L4e
            L4a:
                r8 = r14
                r12 = r19
                goto L6f
            L4e:
                char r8 = (char) r7
                r10 = 0
                r11 = 2
                r12 = r19
                boolean r8 = kotlin.text.StringsKt__StringsKt.xXo(r12, r8, r10, r11, r4)
                if (r8 != 0) goto L69
                if (r7 != r9) goto L67
                if (r20 == 0) goto L69
                if (r21 == 0) goto L67
                r8 = r14
                boolean r10 = r14.isPercentEncoded(r1, r5, r2)
                if (r10 != 0) goto L6b
                goto L6f
            L67:
                r8 = r14
                goto L6b
            L69:
                r8 = r14
                goto L6f
            L6b:
                r15.writeUtf8CodePoint(r7)
                goto Lb5
            L6f:
                if (r6 != 0) goto L76
                okio.Buffer r6 = new okio.Buffer
                r6.<init>()
            L76:
                if (r3 == 0) goto L8a
                java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8
                boolean r10 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r3, r10)
                if (r10 == 0) goto L81
                goto L8a
            L81:
                int r10 = java.lang.Character.charCount(r7)
                int r10 = r10 + r5
                r6.writeString(r1, r5, r10, r3)
                goto L8d
            L8a:
                r6.writeUtf8CodePoint(r7)
            L8d:
                boolean r10 = r6.exhausted()
                if (r10 != 0) goto Lb5
                byte r10 = r6.readByte()
                r11 = r10 & 255(0xff, float:3.57E-43)
                r15.writeByte(r9)
                char[] r13 = okhttp3.HttpUrl.access$getHEX_DIGITS$cp()
                int r11 = r11 >> 4
                r11 = r11 & 15
                char r11 = r13[r11]
                r15.writeByte(r11)
                char[] r11 = okhttp3.HttpUrl.access$getHEX_DIGITS$cp()
                r10 = r10 & 15
                char r10 = r11[r10]
                r15.writeByte(r10)
                goto L8d
            Lb5:
                int r7 = java.lang.Character.charCount(r7)
                int r5 = r5 + r7
                goto Lb
            Lbc:
                r8 = r14
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Companion.writeCanonicalized(okio.Buffer, java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):void");
        }

        private final void writePercentDecoded(Buffer buffer, String str, int i, int i2, boolean z) {
            int i3;
            while (i < i2) {
                int codePointAt = str.codePointAt(i);
                if (codePointAt == 37 && (i3 = i + 2) < i2) {
                    int parseHexDigit = Util.parseHexDigit(str.charAt(i + 1));
                    int parseHexDigit2 = Util.parseHexDigit(str.charAt(i3));
                    if (parseHexDigit != -1 && parseHexDigit2 != -1) {
                        buffer.writeByte((parseHexDigit << 4) + parseHexDigit2);
                        i = Character.charCount(codePointAt) + i3;
                    }
                    buffer.writeUtf8CodePoint(codePointAt);
                    i += Character.charCount(codePointAt);
                } else {
                    if (codePointAt == 43 && z) {
                        buffer.writeByte(32);
                        i++;
                    }
                    buffer.writeUtf8CodePoint(codePointAt);
                    i += Character.charCount(codePointAt);
                }
            }
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.XX(expression = "url.toHttpUrl()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrl"}))
        @OOXIXo
        @xxIXOIIO(name = "-deprecated_get")
        /* renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m371deprecated_get(@OOXIXo String url) {
            IIX0o.x0xO0oo(url, "url");
            return get(url);
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.XX(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        @xxIXOIIO(name = "-deprecated_parse")
        @oOoXoXO
        /* renamed from: -deprecated_parse, reason: not valid java name */
        public final HttpUrl m374deprecated_parse(@OOXIXo String url) {
            IIX0o.x0xO0oo(url, "url");
            return parse(url);
        }

        @OOXIXo
        public final String canonicalize$okhttp(@OOXIXo String str, int i, int i2, @OOXIXo String encodeSet, boolean z, boolean z2, boolean z3, boolean z4, @oOoXoXO Charset charset) {
            IIX0o.x0xO0oo(str, "<this>");
            IIX0o.x0xO0oo(encodeSet, "encodeSet");
            int i3 = i;
            while (i3 < i2) {
                int codePointAt = str.codePointAt(i3);
                if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || z4) && !StringsKt__StringsKt.xXo(encodeSet, (char) codePointAt, false, 2, null))) {
                    if (codePointAt == 37) {
                        if (z) {
                            if (z2) {
                                if (!isPercentEncoded(str, i3, i2)) {
                                    Buffer buffer = new Buffer();
                                    buffer.writeUtf8(str, i, i3);
                                    writeCanonicalized(buffer, str, i3, i2, encodeSet, z, z2, z3, z4, charset);
                                    return buffer.readUtf8();
                                }
                                if (codePointAt == 43 || !z3) {
                                    i3 += Character.charCount(codePointAt);
                                } else {
                                    Buffer buffer2 = new Buffer();
                                    buffer2.writeUtf8(str, i, i3);
                                    writeCanonicalized(buffer2, str, i3, i2, encodeSet, z, z2, z3, z4, charset);
                                    return buffer2.readUtf8();
                                }
                            }
                        }
                    }
                    if (codePointAt == 43) {
                    }
                    i3 += Character.charCount(codePointAt);
                }
                Buffer buffer22 = new Buffer();
                buffer22.writeUtf8(str, i, i3);
                writeCanonicalized(buffer22, str, i3, i2, encodeSet, z, z2, z3, z4, charset);
                return buffer22.readUtf8();
            }
            String substring = str.substring(i, i2);
            IIX0o.oO(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        @XO0OX.x0XOIxOo
        public final int defaultPort(@OOXIXo String scheme) {
            IIX0o.x0xO0oo(scheme, "scheme");
            if (IIX0o.Oxx0IOOO(scheme, "http")) {
                return 80;
            }
            if (IIX0o.Oxx0IOOO(scheme, "https")) {
                return 443;
            }
            return -1;
        }

        @XO0OX.x0XOIxOo
        @OOXIXo
        @xxIXOIIO(name = "get")
        public final HttpUrl get(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<this>");
            return new Builder().parse$okhttp(null, str).build();
        }

        @XO0OX.x0XOIxOo
        @xxIXOIIO(name = "parse")
        @oOoXoXO
        public final HttpUrl parse(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<this>");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @OOXIXo
        public final String percentDecode$okhttp(@OOXIXo String str, int i, int i2, boolean z) {
            IIX0o.x0xO0oo(str, "<this>");
            for (int i3 = i; i3 < i2; i3++) {
                char charAt = str.charAt(i3);
                if (charAt == '%' || (charAt == '+' && z)) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(str, i, i3);
                    writePercentDecoded(buffer, str, i3, i2, z);
                    return buffer.readUtf8();
                }
            }
            String substring = str.substring(i, i2);
            IIX0o.oO(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        public final void toPathString$okhttp(@OOXIXo List<String> list, @OOXIXo StringBuilder out) {
            IIX0o.x0xO0oo(list, "<this>");
            IIX0o.x0xO0oo(out, "out");
            int size = list.size();
            for (int i = 0; i < size; i++) {
                out.append(IOUtils.DIR_SEPARATOR_UNIX);
                out.append(list.get(i));
            }
        }

        @OOXIXo
        public final List<String> toQueryNamesAndValues$okhttp(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<this>");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                int XxIIOXIXx2 = StringsKt__StringsKt.XxIIOXIXx(str, XIxXXX0x0.f29558oxoX, i, false, 4, null);
                if (XxIIOXIXx2 == -1) {
                    XxIIOXIXx2 = str.length();
                }
                int i2 = XxIIOXIXx2;
                int XxIIOXIXx3 = StringsKt__StringsKt.XxIIOXIXx(str, '=', i, false, 4, null);
                if (XxIIOXIXx3 != -1 && XxIIOXIXx3 <= i2) {
                    String substring = str.substring(i, XxIIOXIXx3);
                    IIX0o.oO(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring);
                    String substring2 = str.substring(XxIIOXIXx3 + 1, i2);
                    IIX0o.oO(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring2);
                } else {
                    String substring3 = str.substring(i, i2);
                    IIX0o.oO(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring3);
                    arrayList.add(null);
                }
                i = i2 + 1;
            }
            return arrayList;
        }

        public final void toQueryString$okhttp(@OOXIXo List<String> list, @OOXIXo StringBuilder out) {
            IIX0o.x0xO0oo(list, "<this>");
            IIX0o.x0xO0oo(out, "out");
            xoIox OIx00oxx2 = X0.IIXOooo.OIx00oxx(X0.IIXOooo.X00xOoXI(0, list.size()), 2);
            int oxoX2 = OIx00oxx2.oxoX();
            int X0o0xo2 = OIx00oxx2.X0o0xo();
            int XO2 = OIx00oxx2.XO();
            if ((XO2 <= 0 || oxoX2 > X0o0xo2) && (XO2 >= 0 || X0o0xo2 > oxoX2)) {
                return;
            }
            while (true) {
                String str = list.get(oxoX2);
                String str2 = list.get(oxoX2 + 1);
                if (oxoX2 > 0) {
                    out.append(XIxXXX0x0.f29558oxoX);
                }
                out.append(str);
                if (str2 != null) {
                    out.append('=');
                    out.append(str2);
                }
                if (oxoX2 != X0o0xo2) {
                    oxoX2 += XO2;
                } else {
                    return;
                }
            }
        }

        private Companion() {
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.XX(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        @xxIXOIIO(name = "-deprecated_get")
        @oOoXoXO
        /* renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m373deprecated_get(@OOXIXo URL url) {
            IIX0o.x0xO0oo(url, "url");
            return get(url);
        }

        @XO0OX.x0XOIxOo
        @xxIXOIIO(name = "get")
        @oOoXoXO
        public final HttpUrl get(@OOXIXo URL url) {
            IIX0o.x0xO0oo(url, "<this>");
            String url2 = url.toString();
            IIX0o.oO(url2, "toString()");
            return parse(url2);
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.XX(expression = "uri.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        @xxIXOIIO(name = "-deprecated_get")
        @oOoXoXO
        /* renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m372deprecated_get(@OOXIXo URI uri) {
            IIX0o.x0xO0oo(uri, "uri");
            return get(uri);
        }

        @XO0OX.x0XOIxOo
        @xxIXOIIO(name = "get")
        @oOoXoXO
        public final HttpUrl get(@OOXIXo URI uri) {
            IIX0o.x0xO0oo(uri, "<this>");
            String uri2 = uri.toString();
            IIX0o.oO(uri2, "toString()");
            return parse(uri2);
        }
    }

    public HttpUrl(@OOXIXo String scheme, @OOXIXo String username, @OOXIXo String password, @OOXIXo String host, int i, @OOXIXo List<String> pathSegments, @oOoXoXO List<String> list, @oOoXoXO String str, @OOXIXo String url) {
        IIX0o.x0xO0oo(scheme, "scheme");
        IIX0o.x0xO0oo(username, "username");
        IIX0o.x0xO0oo(password, "password");
        IIX0o.x0xO0oo(host, "host");
        IIX0o.x0xO0oo(pathSegments, "pathSegments");
        IIX0o.x0xO0oo(url, "url");
        this.scheme = scheme;
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = i;
        this.pathSegments = pathSegments;
        this.queryNamesAndValues = list;
        this.fragment = str;
        this.url = url;
        this.isHttps = IIX0o.Oxx0IOOO(scheme, "https");
    }

    @XO0OX.x0XOIxOo
    public static final int defaultPort(@OOXIXo String str) {
        return Companion.defaultPort(str);
    }

    @XO0OX.x0XOIxOo
    @OOXIXo
    @xxIXOIIO(name = "get")
    public static final HttpUrl get(@OOXIXo String str) {
        return Companion.get(str);
    }

    @XO0OX.x0XOIxOo
    @xxIXOIIO(name = "parse")
    @oOoXoXO
    public static final HttpUrl parse(@OOXIXo String str) {
        return Companion.parse(str);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "encodedFragment", imports = {}))
    @xxIXOIIO(name = "-deprecated_encodedFragment")
    @oOoXoXO
    /* renamed from: -deprecated_encodedFragment, reason: not valid java name */
    public final String m352deprecated_encodedFragment() {
        return encodedFragment();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "encodedPassword", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_encodedPassword")
    /* renamed from: -deprecated_encodedPassword, reason: not valid java name */
    public final String m353deprecated_encodedPassword() {
        return encodedPassword();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "encodedPath", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_encodedPath")
    /* renamed from: -deprecated_encodedPath, reason: not valid java name */
    public final String m354deprecated_encodedPath() {
        return encodedPath();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "encodedPathSegments", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_encodedPathSegments")
    /* renamed from: -deprecated_encodedPathSegments, reason: not valid java name */
    public final List<String> m355deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "encodedQuery", imports = {}))
    @xxIXOIIO(name = "-deprecated_encodedQuery")
    @oOoXoXO
    /* renamed from: -deprecated_encodedQuery, reason: not valid java name */
    public final String m356deprecated_encodedQuery() {
        return encodedQuery();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "encodedUsername", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_encodedUsername")
    /* renamed from: -deprecated_encodedUsername, reason: not valid java name */
    public final String m357deprecated_encodedUsername() {
        return encodedUsername();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "fragment", imports = {}))
    @xxIXOIIO(name = "-deprecated_fragment")
    @oOoXoXO
    /* renamed from: -deprecated_fragment, reason: not valid java name */
    public final String m358deprecated_fragment() {
        return this.fragment;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "host", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_host")
    /* renamed from: -deprecated_host, reason: not valid java name */
    public final String m359deprecated_host() {
        return this.host;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "password", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_password")
    /* renamed from: -deprecated_password, reason: not valid java name */
    public final String m360deprecated_password() {
        return this.password;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "pathSegments", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_pathSegments")
    /* renamed from: -deprecated_pathSegments, reason: not valid java name */
    public final List<String> m361deprecated_pathSegments() {
        return this.pathSegments;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "pathSize", imports = {}))
    @xxIXOIIO(name = "-deprecated_pathSize")
    /* renamed from: -deprecated_pathSize, reason: not valid java name */
    public final int m362deprecated_pathSize() {
        return pathSize();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = ClientCookie.PORT_ATTR, imports = {}))
    @xxIXOIIO(name = "-deprecated_port")
    /* renamed from: -deprecated_port, reason: not valid java name */
    public final int m363deprecated_port() {
        return this.port;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "query", imports = {}))
    @xxIXOIIO(name = "-deprecated_query")
    @oOoXoXO
    /* renamed from: -deprecated_query, reason: not valid java name */
    public final String m364deprecated_query() {
        return query();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "queryParameterNames", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_queryParameterNames")
    /* renamed from: -deprecated_queryParameterNames, reason: not valid java name */
    public final Set<String> m365deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "querySize", imports = {}))
    @xxIXOIIO(name = "-deprecated_querySize")
    /* renamed from: -deprecated_querySize, reason: not valid java name */
    public final int m366deprecated_querySize() {
        return querySize();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "scheme", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_scheme")
    /* renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m367deprecated_scheme() {
        return this.scheme;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to toUri()", replaceWith = @kotlin.XX(expression = "toUri()", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_uri")
    /* renamed from: -deprecated_uri, reason: not valid java name */
    public final URI m368deprecated_uri() {
        return uri();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to toUrl()", replaceWith = @kotlin.XX(expression = "toUrl()", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_url")
    /* renamed from: -deprecated_url, reason: not valid java name */
    public final URL m369deprecated_url() {
        return url();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "username", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_username")
    /* renamed from: -deprecated_username, reason: not valid java name */
    public final String m370deprecated_username() {
        return this.username;
    }

    @xxIXOIIO(name = "encodedFragment")
    @oOoXoXO
    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        String substring = this.url.substring(StringsKt__StringsKt.XxIIOXIXx(this.url, '#', 0, false, 6, null) + 1);
        IIX0o.oO(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @OOXIXo
    @xxIXOIIO(name = "encodedPassword")
    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        String substring = this.url.substring(StringsKt__StringsKt.XxIIOXIXx(this.url, ':', this.scheme.length() + 3, false, 4, null) + 1, StringsKt__StringsKt.XxIIOXIXx(this.url, ObjectUtils.f32506oIX0oI, 0, false, 6, null));
        IIX0o.oO(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @OOXIXo
    @xxIXOIIO(name = "encodedPath")
    public final String encodedPath() {
        int XxIIOXIXx2 = StringsKt__StringsKt.XxIIOXIXx(this.url, IOUtils.DIR_SEPARATOR_UNIX, this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        String substring = this.url.substring(XxIIOXIXx2, Util.delimiterOffset(str, "?#", XxIIOXIXx2, str.length()));
        IIX0o.oO(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @OOXIXo
    @xxIXOIIO(name = "encodedPathSegments")
    public final List<String> encodedPathSegments() {
        int XxIIOXIXx2 = StringsKt__StringsKt.XxIIOXIXx(this.url, IOUtils.DIR_SEPARATOR_UNIX, this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, "?#", XxIIOXIXx2, str.length());
        ArrayList arrayList = new ArrayList();
        while (XxIIOXIXx2 < delimiterOffset) {
            int i = XxIIOXIXx2 + 1;
            int delimiterOffset2 = Util.delimiterOffset(this.url, IOUtils.DIR_SEPARATOR_UNIX, i, delimiterOffset);
            String substring = this.url.substring(i, delimiterOffset2);
            IIX0o.oO(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(substring);
            XxIIOXIXx2 = delimiterOffset2;
        }
        return arrayList;
    }

    @xxIXOIIO(name = "encodedQuery")
    @oOoXoXO
    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int XxIIOXIXx2 = StringsKt__StringsKt.XxIIOXIXx(this.url, '?', 0, false, 6, null) + 1;
        String str = this.url;
        String substring = this.url.substring(XxIIOXIXx2, Util.delimiterOffset(str, '#', XxIIOXIXx2, str.length()));
        IIX0o.oO(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @OOXIXo
    @xxIXOIIO(name = "encodedUsername")
    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        String substring = this.url.substring(length, Util.delimiterOffset(str, ":@", length, str.length()));
        IIX0o.oO(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if ((obj instanceof HttpUrl) && IIX0o.Oxx0IOOO(((HttpUrl) obj).url, this.url)) {
            return true;
        }
        return false;
    }

    @xxIXOIIO(name = "fragment")
    @oOoXoXO
    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    @OOXIXo
    @xxIXOIIO(name = "host")
    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    @OOXIXo
    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    @OOXIXo
    @xxIXOIIO(name = "password")
    public final String password() {
        return this.password;
    }

    @OOXIXo
    @xxIXOIIO(name = "pathSegments")
    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    @xxIXOIIO(name = "pathSize")
    public final int pathSize() {
        return this.pathSegments.size();
    }

    @xxIXOIIO(name = ClientCookie.PORT_ATTR)
    public final int port() {
        return this.port;
    }

    @xxIXOIIO(name = "query")
    @oOoXoXO
    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, sb);
        return sb.toString();
    }

    @oOoXoXO
    public final String queryParameter(@OOXIXo String name) {
        IIX0o.x0xO0oo(name, "name");
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        xoIox OIx00oxx2 = X0.IIXOooo.OIx00oxx(X0.IIXOooo.X00xOoXI(0, list.size()), 2);
        int oxoX2 = OIx00oxx2.oxoX();
        int X0o0xo2 = OIx00oxx2.X0o0xo();
        int XO2 = OIx00oxx2.XO();
        if ((XO2 > 0 && oxoX2 <= X0o0xo2) || (XO2 < 0 && X0o0xo2 <= oxoX2)) {
            while (!IIX0o.Oxx0IOOO(name, this.queryNamesAndValues.get(oxoX2))) {
                if (oxoX2 != X0o0xo2) {
                    oxoX2 += XO2;
                }
            }
            return this.queryNamesAndValues.get(oxoX2 + 1);
        }
        return null;
    }

    @OOXIXo
    public final String queryParameterName(int i) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            String str = list.get(i * 2);
            IIX0o.ooOOo0oXI(str);
            return str;
        }
        throw new IndexOutOfBoundsException();
    }

    @OOXIXo
    @xxIXOIIO(name = "queryParameterNames")
    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return Xo0.OOXIXo();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        xoIox OIx00oxx2 = X0.IIXOooo.OIx00oxx(X0.IIXOooo.X00xOoXI(0, this.queryNamesAndValues.size()), 2);
        int oxoX2 = OIx00oxx2.oxoX();
        int X0o0xo2 = OIx00oxx2.X0o0xo();
        int XO2 = OIx00oxx2.XO();
        if ((XO2 > 0 && oxoX2 <= X0o0xo2) || (XO2 < 0 && X0o0xo2 <= oxoX2)) {
            while (true) {
                String str = this.queryNamesAndValues.get(oxoX2);
                IIX0o.ooOOo0oXI(str);
                linkedHashSet.add(str);
                if (oxoX2 == X0o0xo2) {
                    break;
                }
                oxoX2 += XO2;
            }
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        IIX0o.oO(unmodifiableSet, "unmodifiableSet(result)");
        return unmodifiableSet;
    }

    @oOoXoXO
    public final String queryParameterValue(int i) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    @OOXIXo
    public final List<String> queryParameterValues(@OOXIXo String name) {
        IIX0o.x0xO0oo(name, "name");
        if (this.queryNamesAndValues == null) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList = new ArrayList();
        xoIox OIx00oxx2 = X0.IIXOooo.OIx00oxx(X0.IIXOooo.X00xOoXI(0, this.queryNamesAndValues.size()), 2);
        int oxoX2 = OIx00oxx2.oxoX();
        int X0o0xo2 = OIx00oxx2.X0o0xo();
        int XO2 = OIx00oxx2.XO();
        if ((XO2 > 0 && oxoX2 <= X0o0xo2) || (XO2 < 0 && X0o0xo2 <= oxoX2)) {
            while (true) {
                if (IIX0o.Oxx0IOOO(name, this.queryNamesAndValues.get(oxoX2))) {
                    arrayList.add(this.queryNamesAndValues.get(oxoX2 + 1));
                }
                if (oxoX2 == X0o0xo2) {
                    break;
                }
                oxoX2 += XO2;
            }
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        IIX0o.oO(unmodifiableList, "unmodifiableList(result)");
        return unmodifiableList;
    }

    @xxIXOIIO(name = "querySize")
    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    @OOXIXo
    public final String redact() {
        Builder newBuilder = newBuilder("/...");
        IIX0o.ooOOo0oXI(newBuilder);
        return newBuilder.username("").password("").build().toString();
    }

    @oOoXoXO
    public final HttpUrl resolve(@OOXIXo String link) {
        IIX0o.x0xO0oo(link, "link");
        Builder newBuilder = newBuilder(link);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    @OOXIXo
    @xxIXOIIO(name = "scheme")
    public final String scheme() {
        return this.scheme;
    }

    @OOXIXo
    public String toString() {
        return this.url;
    }

    @oOoXoXO
    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    @OOXIXo
    @xxIXOIIO(name = "uri")
    public final URI uri() {
        String builder = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e) {
            try {
                URI create = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(builder, ""));
                IIX0o.oO(create, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    @OOXIXo
    @xxIXOIIO(name = "url")
    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @OOXIXo
    @xxIXOIIO(name = "username")
    public final String username() {
        return this.username;
    }

    @XO0OX.x0XOIxOo
    @xxIXOIIO(name = "get")
    @oOoXoXO
    public static final HttpUrl get(@OOXIXo URI uri) {
        return Companion.get(uri);
    }

    @XO0OX.x0XOIxOo
    @xxIXOIIO(name = "get")
    @oOoXoXO
    public static final HttpUrl get(@OOXIXo URL url) {
        return Companion.get(url);
    }

    @oOoXoXO
    public final Builder newBuilder(@OOXIXo String link) {
        IIX0o.x0xO0oo(link, "link");
        try {
            return new Builder().parse$okhttp(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
