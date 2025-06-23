package com.kwad.framework.filedownloader.services;

import android.text.TextUtils;
import com.kwad.framework.filedownloader.f.c;

/* loaded from: classes11.dex */
public final class b implements c.d {
    @Override // com.kwad.framework.filedownloader.f.c.d
    public final int f(String str, String str2, boolean z) {
        return g(str, str2, z);
    }

    @Override // com.kwad.framework.filedownloader.f.c.d
    public final int g(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            if (z) {
                return com.kwad.framework.filedownloader.f.f.bx(com.kwad.framework.filedownloader.f.f.b("%sp%s@dir", str, str2)).hashCode();
            }
            return com.kwad.framework.filedownloader.f.f.bx(com.kwad.framework.filedownloader.f.f.b("%sp%s", str, str2)).hashCode();
        } catch (Throwable unused) {
            return str.hashCode();
        }
    }
}
