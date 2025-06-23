package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ConcurrentHashMap;

@KeepForSdk
@Deprecated
/* loaded from: classes9.dex */
public class LibraryVersion {
    private static final GmsLogger zza = new GmsLogger("LibraryVersion", "");
    private static final LibraryVersion zzb = new LibraryVersion();
    private final ConcurrentHashMap zzc = new ConcurrentHashMap();

    @VisibleForTesting
    public LibraryVersion() {
    }

    @NonNull
    @KeepForSdk
    public static LibraryVersion getInstance() {
        return zzb;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0098  */
    @androidx.annotation.NonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getVersion(@androidx.annotation.NonNull java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "Failed to get app version for libraryName: "
            java.lang.String r1 = "LibraryVersion"
            java.lang.String r2 = "Please provide a valid libraryName"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9, r2)
            java.util.concurrent.ConcurrentHashMap r2 = r8.zzc
            boolean r2 = r2.containsKey(r9)
            if (r2 == 0) goto L1a
            java.util.concurrent.ConcurrentHashMap r0 = r8.zzc
            java.lang.Object r9 = r0.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            return r9
        L1a:
            java.util.Properties r2 = new java.util.Properties
            r2.<init>()
            r3 = 0
            java.lang.String r4 = "/%s.properties"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.io.IOException -> L75 java.lang.Throwable -> L77
            r6 = 0
            r5[r6] = r9     // Catch: java.io.IOException -> L75 java.lang.Throwable -> L77
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch: java.io.IOException -> L75 java.lang.Throwable -> L77
            java.lang.Class<com.google.android.gms.common.internal.LibraryVersion> r5 = com.google.android.gms.common.internal.LibraryVersion.class
            java.io.InputStream r4 = r5.getResourceAsStream(r4)     // Catch: java.io.IOException -> L75 java.lang.Throwable -> L77
            if (r4 == 0) goto L5e
            r2.load(r4)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            java.lang.String r5 = "version"
            java.lang.String r3 = r2.getProperty(r5, r3)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            com.google.android.gms.common.internal.GmsLogger r2 = com.google.android.gms.common.internal.LibraryVersion.zza     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r5.<init>()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r5.append(r9)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            java.lang.String r6 = " version is "
            r5.append(r6)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r5.append(r3)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r2.v(r1, r5)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            goto L91
        L57:
            r9 = move-exception
            goto L73
        L59:
            r2 = move-exception
            r7 = r4
            r4 = r3
            r3 = r7
            goto L7a
        L5e:
            com.google.android.gms.common.internal.GmsLogger r2 = com.google.android.gms.common.internal.LibraryVersion.zza     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r5.<init>()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r5.append(r0)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r5.append(r9)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r2.w(r1, r5)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            goto L91
        L73:
            r3 = r4
            goto La7
        L75:
            r2 = move-exception
            goto L79
        L77:
            r9 = move-exception
            goto La7
        L79:
            r4 = r3
        L7a:
            com.google.android.gms.common.internal.GmsLogger r5 = com.google.android.gms.common.internal.LibraryVersion.zza     // Catch: java.lang.Throwable -> L77
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r6.<init>()     // Catch: java.lang.Throwable -> L77
            r6.append(r0)     // Catch: java.lang.Throwable -> L77
            r6.append(r9)     // Catch: java.lang.Throwable -> L77
            java.lang.String r0 = r6.toString()     // Catch: java.lang.Throwable -> L77
            r5.e(r1, r0, r2)     // Catch: java.lang.Throwable -> L77
            r7 = r4
            r4 = r3
            r3 = r7
        L91:
            if (r4 == 0) goto L96
            com.google.android.gms.common.util.IOUtils.closeQuietly(r4)
        L96:
            if (r3 != 0) goto La1
            com.google.android.gms.common.internal.GmsLogger r0 = com.google.android.gms.common.internal.LibraryVersion.zza
            java.lang.String r2 = ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used"
            r0.d(r1, r2)
            java.lang.String r3 = "UNKNOWN"
        La1:
            java.util.concurrent.ConcurrentHashMap r0 = r8.zzc
            r0.put(r9, r3)
            return r3
        La7:
            if (r3 == 0) goto Lac
            com.google.android.gms.common.util.IOUtils.closeQuietly(r3)
        Lac:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.LibraryVersion.getVersion(java.lang.String):java.lang.String");
    }
}
