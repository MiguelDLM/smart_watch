package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.Map;
import org.apache.commons.lang3.ObjectUtils;

/* loaded from: classes10.dex */
public class VersionInfo {
    public static final String PROPERTY_MODULE = "info.module";
    public static final String PROPERTY_RELEASE = "info.release";
    public static final String PROPERTY_TIMESTAMP = "info.timestamp";
    public static final String UNAVAILABLE = "UNAVAILABLE";
    public static final String VERSION_PROPERTY_FILE = "version.properties";
    private final String infoClassloader;
    private final String infoModule;
    private final String infoPackage;
    private final String infoRelease;
    private final String infoTimestamp;

    public VersionInfo(String str, String str2, String str3, String str4, String str5) {
        Args.notNull(str, "Package identifier");
        this.infoPackage = str;
        this.infoModule = str2 == null ? UNAVAILABLE : str2;
        this.infoRelease = str3 == null ? UNAVAILABLE : str3;
        this.infoTimestamp = str4 == null ? UNAVAILABLE : str4;
        this.infoClassloader = str5 == null ? UNAVAILABLE : str5;
    }

    public static VersionInfo fromMap(String str, Map<?, ?> map, ClassLoader classLoader) {
        String str2;
        String str3;
        String str4;
        Args.notNull(str, "Package identifier");
        String str5 = null;
        if (map != null) {
            String str6 = (String) map.get(PROPERTY_MODULE);
            if (str6 != null && str6.length() < 1) {
                str6 = null;
            }
            String str7 = (String) map.get(PROPERTY_RELEASE);
            if (str7 != null && (str7.length() < 1 || str7.equals("${pom.version}"))) {
                str7 = null;
            }
            String str8 = (String) map.get(PROPERTY_TIMESTAMP);
            if (str8 != null && (str8.length() < 1 || str8.equals("${mvn.timestamp}"))) {
                str4 = null;
            } else {
                str4 = str8;
            }
            str2 = str6;
            str3 = str7;
        } else {
            str2 = null;
            str3 = null;
            str4 = null;
        }
        if (classLoader != null) {
            str5 = classLoader.toString();
        }
        return new VersionInfo(str, str2, str3, str4, str5);
    }

    public static String getUserAgent(String str, String str2, Class<?> cls) {
        String str3;
        VersionInfo loadVersionInfo = loadVersionInfo(str2, cls.getClassLoader());
        if (loadVersionInfo != null) {
            str3 = loadVersionInfo.getRelease();
        } else {
            str3 = UNAVAILABLE;
        }
        return String.format("%s/%s (Java/%s)", str, str3, System.getProperty("java.version"));
    }

    public static VersionInfo[] loadVersionInfo(String[] strArr, ClassLoader classLoader) {
        Args.notNull(strArr, "Package identifier array");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            VersionInfo loadVersionInfo = loadVersionInfo(str, classLoader);
            if (loadVersionInfo != null) {
                arrayList.add(loadVersionInfo);
            }
        }
        return (VersionInfo[]) arrayList.toArray(new VersionInfo[arrayList.size()]);
    }

    public final String getClassloader() {
        return this.infoClassloader;
    }

    public final String getModule() {
        return this.infoModule;
    }

    public final String getPackage() {
        return this.infoPackage;
    }

    public final String getRelease() {
        return this.infoRelease;
    }

    public final String getTimestamp() {
        return this.infoTimestamp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.infoPackage.length() + 20 + this.infoModule.length() + this.infoRelease.length() + this.infoTimestamp.length() + this.infoClassloader.length());
        sb.append("VersionInfo(");
        sb.append(this.infoPackage);
        sb.append(':');
        sb.append(this.infoModule);
        if (!UNAVAILABLE.equals(this.infoRelease)) {
            sb.append(':');
            sb.append(this.infoRelease);
        }
        if (!UNAVAILABLE.equals(this.infoTimestamp)) {
            sb.append(':');
            sb.append(this.infoTimestamp);
        }
        sb.append(HexStringBuilder.COMMENT_END_CHAR);
        if (!UNAVAILABLE.equals(this.infoClassloader)) {
            sb.append(ObjectUtils.f32506oIX0oI);
            sb.append(this.infoClassloader);
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.VersionInfo loadVersionInfo(java.lang.String r4, java.lang.ClassLoader r5) {
        /*
            java.lang.String r0 = "Package identifier"
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args.notNull(r4, r0)
            if (r5 == 0) goto L8
            goto L10
        L8:
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r5 = r5.getContextClassLoader()
        L10:
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L48
            r1.<init>()     // Catch: java.io.IOException -> L48
            r2 = 46
            r3 = 47
            java.lang.String r2 = r4.replace(r2, r3)     // Catch: java.io.IOException -> L48
            r1.append(r2)     // Catch: java.io.IOException -> L48
            java.lang.String r2 = "/"
            r1.append(r2)     // Catch: java.io.IOException -> L48
            java.lang.String r2 = "version.properties"
            r1.append(r2)     // Catch: java.io.IOException -> L48
            java.lang.String r1 = r1.toString()     // Catch: java.io.IOException -> L48
            java.io.InputStream r1 = r5.getResourceAsStream(r1)     // Catch: java.io.IOException -> L48
            if (r1 == 0) goto L49
            java.util.Properties r2 = new java.util.Properties     // Catch: java.lang.Throwable -> L43
            r2.<init>()     // Catch: java.lang.Throwable -> L43
            r2.load(r1)     // Catch: java.lang.Throwable -> L43
            r1.close()     // Catch: java.io.IOException -> L41
            goto L4a
        L41:
            goto L4a
        L43:
            r2 = move-exception
            r1.close()     // Catch: java.io.IOException -> L48
            throw r2     // Catch: java.io.IOException -> L48
        L48:
        L49:
            r2 = r0
        L4a:
            if (r2 == 0) goto L50
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.VersionInfo r0 = fromMap(r4, r2, r5)
        L50:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.VersionInfo.loadVersionInfo(java.lang.String, java.lang.ClassLoader):com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.VersionInfo");
    }
}
