package com.jd.ad.sdk.jad_te;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_hs.jad_jw;
import com.jd.ad.sdk.jad_hs.jad_ly;
import com.jd.ad.sdk.jad_kv.jad_xk;

/* loaded from: classes10.dex */
public class jad_er implements jad_ly<Uri, Drawable> {
    public final Context jad_an;

    public jad_er(Context context) {
        this.jad_an = context.getApplicationContext();
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    @Nullable
    public /* bridge */ /* synthetic */ jad_xk<Drawable> jad_an(@NonNull Uri uri, int i, int i2, @NonNull jad_jw jad_jwVar) {
        return jad_an(uri);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0034  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.jd.ad.sdk.jad_kv.jad_xk jad_an(@androidx.annotation.NonNull android.net.Uri r7) {
        /*
            r6 = this;
            java.lang.String r0 = r7.getAuthority()
            android.content.Context r1 = r6.jad_an
            java.lang.String r1 = r1.getPackageName()
            boolean r1 = r0.equals(r1)
            r2 = 0
            if (r1 == 0) goto L12
            goto L26
        L12:
            android.content.Context r1 = r6.jad_an     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L19
            android.content.Context r0 = r1.createPackageContext(r0, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L19
            goto L28
        L19:
            r1 = move-exception
            android.content.Context r3 = r6.jad_an
            java.lang.String r3 = r3.getPackageName()
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto Lc6
        L26:
            android.content.Context r0 = r6.jad_an
        L28:
            java.util.List r1 = r7.getPathSegments()
            int r3 = r1.size()
            r4 = 2
            r5 = 1
            if (r3 != r4) goto L76
            java.util.List r1 = r7.getPathSegments()
            java.lang.String r3 = r7.getAuthority()
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.get(r5)
            java.lang.String r1 = (java.lang.String) r1
            android.content.res.Resources r4 = r0.getResources()
            int r3 = r4.getIdentifier(r1, r2, r3)
            if (r3 != 0) goto L5c
            android.content.res.Resources r3 = android.content.res.Resources.getSystem()
            java.lang.String r4 = "android"
            int r3 = r3.getIdentifier(r1, r2, r4)
        L5c:
            if (r3 == 0) goto L5f
            goto L8c
        L5f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to find resource id for: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L76:
            int r1 = r1.size()
            java.lang.String r3 = "Unrecognized Uri format: "
            if (r1 != r5) goto Lb1
            java.util.List r1 = r7.getPathSegments()
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.NumberFormatException -> L9b
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.NumberFormatException -> L9b
            int r3 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L9b
        L8c:
            android.content.Context r7 = r6.jad_an
            r1 = 0
            android.graphics.drawable.Drawable r7 = com.jd.ad.sdk.jad_te.jad_bo.jad_an(r7, r0, r3, r1)
            if (r7 == 0) goto L9a
            com.jd.ad.sdk.jad_te.jad_dq r1 = new com.jd.ad.sdk.jad_te.jad_dq
            r1.<init>(r7)
        L9a:
            return r1
        L9b:
            r0 = move-exception
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r1.<init>(r7, r0)
            throw r1
        Lb1:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        Lc6:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to obtain context or unrecognized Uri format for: "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r0.<init>(r7, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_te.jad_er.jad_an(android.net.Uri):com.jd.ad.sdk.jad_kv.jad_xk");
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    public boolean jad_an(@NonNull Uri uri, @NonNull jad_jw jad_jwVar) {
        return uri.getScheme().equals("android.resource");
    }
}
