package okhttp3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import XO0OX.xxIXOIIO;
import androidx.collection.oIX0oI;
import com.baidu.ar.auth.FeatureCodes;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.text.OxI;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* loaded from: classes6.dex */
public final class Cookie {

    @OOXIXo
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;

    @OOXIXo
    private final String name;

    @OOXIXo
    private final String path;
    private final boolean persistent;
    private final boolean secure;

    @OOXIXo
    private final String value;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    @XX({"SMAP\nCookie.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cookie.kt\nokhttp3/Cookie$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,614:1\n1#2:615\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class Builder {

        @oOoXoXO
        private String domain;
        private boolean hostOnly;
        private boolean httpOnly;

        @oOoXoXO
        private String name;
        private boolean persistent;
        private boolean secure;

        @oOoXoXO
        private String value;
        private long expiresAt = DatesKt.MAX_DATE;

        @OOXIXo
        private String path = "/";

        @OOXIXo
        public final Cookie build() {
            String str = this.name;
            if (str != null) {
                String str2 = this.value;
                if (str2 != null) {
                    long j = this.expiresAt;
                    String str3 = this.domain;
                    if (str3 != null) {
                        return new Cookie(str, str2, j, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
                    }
                    throw new NullPointerException("builder.domain == null");
                }
                throw new NullPointerException("builder.value == null");
            }
            throw new NullPointerException("builder.name == null");
        }

        @OOXIXo
        public final Builder domain(@OOXIXo String domain) {
            IIX0o.x0xO0oo(domain, "domain");
            return domain(domain, false);
        }

        @OOXIXo
        public final Builder expiresAt(long j) {
            if (j <= 0) {
                j = Long.MIN_VALUE;
            }
            if (j > DatesKt.MAX_DATE) {
                j = 253402300799999L;
            }
            this.expiresAt = j;
            this.persistent = true;
            return this;
        }

        @OOXIXo
        public final Builder hostOnlyDomain(@OOXIXo String domain) {
            IIX0o.x0xO0oo(domain, "domain");
            return domain(domain, true);
        }

        @OOXIXo
        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        @OOXIXo
        public final Builder name(@OOXIXo String name) {
            IIX0o.x0xO0oo(name, "name");
            if (IIX0o.Oxx0IOOO(StringsKt__StringsKt.oIoIXxIO(name).toString(), name)) {
                this.name = name;
                return this;
            }
            throw new IllegalArgumentException("name is not trimmed");
        }

        @OOXIXo
        public final Builder path(@OOXIXo String path) {
            IIX0o.x0xO0oo(path, "path");
            if (OxI.IOOoXo0Ix(path, "/", false, 2, null)) {
                this.path = path;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'");
        }

        @OOXIXo
        public final Builder secure() {
            this.secure = true;
            return this;
        }

        @OOXIXo
        public final Builder value(@OOXIXo String value) {
            IIX0o.x0xO0oo(value, "value");
            if (IIX0o.Oxx0IOOO(StringsKt__StringsKt.oIoIXxIO(value).toString(), value)) {
                this.value = value;
                return this;
            }
            throw new IllegalArgumentException("value is not trimmed");
        }

        private final Builder domain(String str, boolean z) {
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost != null) {
                this.domain = canonicalHost;
                this.hostOnly = z;
                return this;
            }
            throw new IllegalArgumentException("unexpected domain: " + str);
        }
    }

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private final int dateCharacterOffset(String str, int i, int i2, boolean z) {
            boolean z2;
            while (i < i2) {
                char charAt = str.charAt(i);
                if ((charAt >= ' ' || charAt == '\t') && charAt < 127 && (('0' > charAt || charAt >= ':') && (('a' > charAt || charAt >= '{') && (('A' > charAt || charAt >= '[') && charAt != ':')))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2 == (!z)) {
                    return i;
                }
                i++;
            }
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            if (IIX0o.Oxx0IOOO(str, str2)) {
                return true;
            }
            if (OxI.XO0o(str, str2, false, 2, null) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.canParseAsIpAddress(str)) {
                return true;
            }
            return false;
        }

        private final String parseDomain(String str) {
            if (!OxI.XO0o(str, FileUtils.FILE_EXTENSION_SEPARATOR, false, 2, null)) {
                String canonicalHost = HostnamesKt.toCanonicalHost(StringsKt__StringsKt.OoI0OO(str, FileUtils.FILE_EXTENSION_SEPARATOR));
                if (canonicalHost != null) {
                    return canonicalHost;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException("Failed requirement.");
        }

        private final long parseExpires(String str, int i, int i2) {
            int dateCharacterOffset = dateCharacterOffset(str, i, i2, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            while (dateCharacterOffset < i2) {
                int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, i2, true);
                matcher.region(dateCharacterOffset, dateCharacterOffset2);
                if (i4 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String group = matcher.group(1);
                    IIX0o.oO(group, "matcher.group(1)");
                    i4 = Integer.parseInt(group);
                    String group2 = matcher.group(2);
                    IIX0o.oO(group2, "matcher.group(2)");
                    i7 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    IIX0o.oO(group3, "matcher.group(3)");
                    i8 = Integer.parseInt(group3);
                } else if (i5 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String group4 = matcher.group(1);
                    IIX0o.oO(group4, "matcher.group(1)");
                    i5 = Integer.parseInt(group4);
                } else if (i6 == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String group5 = matcher.group(1);
                    IIX0o.oO(group5, "matcher.group(1)");
                    Locale US = Locale.US;
                    IIX0o.oO(US, "US");
                    String lowerCase = group5.toLowerCase(US);
                    IIX0o.oO(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    String pattern = Cookie.MONTH_PATTERN.pattern();
                    IIX0o.oO(pattern, "MONTH_PATTERN.pattern()");
                    i6 = StringsKt__StringsKt.O0O0Io00X(pattern, lowerCase, 0, false, 6, null) / 4;
                } else if (i3 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String group6 = matcher.group(1);
                    IIX0o.oO(group6, "matcher.group(1)");
                    i3 = Integer.parseInt(group6);
                }
                dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, i2, false);
            }
            if (70 <= i3 && i3 < 100) {
                i3 += FeatureCodes.SKY_SEG;
            }
            if (i3 >= 0 && i3 < 70) {
                i3 += 2000;
            }
            if (i3 >= 1601) {
                if (i6 != -1) {
                    if (1 <= i5 && i5 < 32) {
                        if (i4 >= 0 && i4 < 24) {
                            if (i7 >= 0 && i7 < 60) {
                                if (i8 >= 0 && i8 < 60) {
                                    GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
                                    gregorianCalendar.setLenient(false);
                                    gregorianCalendar.set(1, i3);
                                    gregorianCalendar.set(2, i6 - 1);
                                    gregorianCalendar.set(5, i5);
                                    gregorianCalendar.set(11, i4);
                                    gregorianCalendar.set(12, i7);
                                    gregorianCalendar.set(13, i8);
                                    gregorianCalendar.set(14, 0);
                                    return gregorianCalendar.getTimeInMillis();
                                }
                                throw new IllegalArgumentException("Failed requirement.");
                            }
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                    throw new IllegalArgumentException("Failed requirement.");
                }
                throw new IllegalArgumentException("Failed requirement.");
            }
            throw new IllegalArgumentException("Failed requirement.");
        }

        private final long parseMaxAge(String str) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e) {
                if (new Regex("-?\\d+").matches(str)) {
                    if (OxI.IOOoXo0Ix(str, HelpFormatter.DEFAULT_OPT_PREFIX, false, 2, null)) {
                        return Long.MIN_VALUE;
                    }
                    return Long.MAX_VALUE;
                }
                throw e;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String encodedPath = httpUrl.encodedPath();
            if (IIX0o.Oxx0IOOO(encodedPath, str)) {
                return true;
            }
            if (OxI.IOOoXo0Ix(encodedPath, str, false, 2, null) && (OxI.XO0o(str, "/", false, 2, null) || encodedPath.charAt(str.length()) == '/')) {
                return true;
            }
            return false;
        }

        @x0XOIxOo
        @oOoXoXO
        public final Cookie parse(@OOXIXo HttpUrl url, @OOXIXo String setCookie) {
            IIX0o.x0xO0oo(url, "url");
            IIX0o.x0xO0oo(setCookie, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), url, setCookie);
        }

        /* JADX WARN: Removed duplicated region for block: B:54:0x0111  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0157  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0114  */
        @OXOo.oOoXoXO
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final okhttp3.Cookie parse$okhttp(long r26, @OXOo.OOXIXo okhttp3.HttpUrl r28, @OXOo.OOXIXo java.lang.String r29) {
            /*
                Method dump skipped, instructions count: 363
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.Companion.parse$okhttp(long, okhttp3.HttpUrl, java.lang.String):okhttp3.Cookie");
        }

        @x0XOIxOo
        @OOXIXo
        public final List<Cookie> parseAll(@OOXIXo HttpUrl url, @OOXIXo Headers headers) {
            IIX0o.x0xO0oo(url, "url");
            IIX0o.x0xO0oo(headers, "headers");
            List<String> values = headers.values("Set-Cookie");
            int size = values.size();
            ArrayList arrayList = null;
            for (int i = 0; i < size; i++) {
                Cookie parse = parse(url, values.get(i));
                if (parse != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(parse);
                }
            }
            if (arrayList != null) {
                List<Cookie> unmodifiableList = Collections.unmodifiableList(arrayList);
                IIX0o.oO(unmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
                return unmodifiableList;
            }
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }

        private Companion() {
        }
    }

    public /* synthetic */ Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, IIXOooo iIXOooo) {
        this(str, str2, j, str3, str4, z, z2, z3, z4);
    }

    @x0XOIxOo
    @oOoXoXO
    public static final Cookie parse(@OOXIXo HttpUrl httpUrl, @OOXIXo String str) {
        return Companion.parse(httpUrl, str);
    }

    @x0XOIxOo
    @OOXIXo
    public static final List<Cookie> parseAll(@OOXIXo HttpUrl httpUrl, @OOXIXo Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = ClientCookie.DOMAIN_ATTR, imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_domain")
    /* renamed from: -deprecated_domain, reason: not valid java name */
    public final String m331deprecated_domain() {
        return this.domain;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "expiresAt", imports = {}))
    @xxIXOIIO(name = "-deprecated_expiresAt")
    /* renamed from: -deprecated_expiresAt, reason: not valid java name */
    public final long m332deprecated_expiresAt() {
        return this.expiresAt;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "hostOnly", imports = {}))
    @xxIXOIIO(name = "-deprecated_hostOnly")
    /* renamed from: -deprecated_hostOnly, reason: not valid java name */
    public final boolean m333deprecated_hostOnly() {
        return this.hostOnly;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "httpOnly", imports = {}))
    @xxIXOIIO(name = "-deprecated_httpOnly")
    /* renamed from: -deprecated_httpOnly, reason: not valid java name */
    public final boolean m334deprecated_httpOnly() {
        return this.httpOnly;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "name", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_name")
    /* renamed from: -deprecated_name, reason: not valid java name */
    public final String m335deprecated_name() {
        return this.name;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "path", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_path")
    /* renamed from: -deprecated_path, reason: not valid java name */
    public final String m336deprecated_path() {
        return this.path;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "persistent", imports = {}))
    @xxIXOIIO(name = "-deprecated_persistent")
    /* renamed from: -deprecated_persistent, reason: not valid java name */
    public final boolean m337deprecated_persistent() {
        return this.persistent;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = ClientCookie.SECURE_ATTR, imports = {}))
    @xxIXOIIO(name = "-deprecated_secure")
    /* renamed from: -deprecated_secure, reason: not valid java name */
    public final boolean m338deprecated_secure() {
        return this.secure;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "value", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_value")
    /* renamed from: -deprecated_value, reason: not valid java name */
    public final String m339deprecated_value() {
        return this.value;
    }

    @OOXIXo
    @xxIXOIIO(name = ClientCookie.DOMAIN_ATTR)
    public final String domain() {
        return this.domain;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            if (IIX0o.Oxx0IOOO(cookie.name, this.name) && IIX0o.Oxx0IOOO(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && IIX0o.Oxx0IOOO(cookie.domain, this.domain) && IIX0o.Oxx0IOOO(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
                return true;
            }
        }
        return false;
    }

    @xxIXOIIO(name = "expiresAt")
    public final long expiresAt() {
        return this.expiresAt;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return ((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + oIX0oI.oIX0oI(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + androidx.work.oIX0oI.oIX0oI(this.secure)) * 31) + androidx.work.oIX0oI.oIX0oI(this.httpOnly)) * 31) + androidx.work.oIX0oI.oIX0oI(this.persistent)) * 31) + androidx.work.oIX0oI.oIX0oI(this.hostOnly);
    }

    @xxIXOIIO(name = "hostOnly")
    public final boolean hostOnly() {
        return this.hostOnly;
    }

    @xxIXOIIO(name = "httpOnly")
    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(@OOXIXo HttpUrl url) {
        boolean domainMatch;
        IIX0o.x0xO0oo(url, "url");
        if (!this.hostOnly) {
            domainMatch = Companion.domainMatch(url.host(), this.domain);
        } else {
            domainMatch = IIX0o.Oxx0IOOO(url.host(), this.domain);
        }
        if (!domainMatch || !Companion.pathMatch(url, this.path)) {
            return false;
        }
        if (this.secure && !url.isHttps()) {
            return false;
        }
        return true;
    }

    @OOXIXo
    @xxIXOIIO(name = "name")
    public final String name() {
        return this.name;
    }

    @OOXIXo
    @xxIXOIIO(name = "path")
    public final String path() {
        return this.path;
    }

    @xxIXOIIO(name = "persistent")
    public final boolean persistent() {
        return this.persistent;
    }

    @xxIXOIIO(name = ClientCookie.SECURE_ATTR)
    public final boolean secure() {
        return this.secure;
    }

    @OOXIXo
    public String toString() {
        return toString$okhttp(false);
    }

    @OOXIXo
    public final String toString$okhttp(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(DatesKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z) {
                sb.append(FileUtils.FILE_EXTENSION_SEPARATOR);
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "toString()");
        return sb2;
    }

    @OOXIXo
    @xxIXOIIO(name = "value")
    public final String value() {
        return this.value;
    }

    private Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.persistent = z3;
        this.hostOnly = z4;
    }
}
