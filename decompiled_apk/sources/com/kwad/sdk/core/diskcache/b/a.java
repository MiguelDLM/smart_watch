package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.ax;
import java.io.File;
import java.io.IOException;

/* loaded from: classes11.dex */
public final class a {
    private com.kwad.sdk.core.diskcache.a.a avt;

    /* renamed from: com.kwad.sdk.core.diskcache.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C0850a {
        static final a avu = new a(0);
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static a DM() {
        return C0850a.avu;
    }

    private boolean DN() {
        init(((f) ServiceProvider.get(f.class)).getContext());
        if (this.avt == null) {
            return true;
        }
        return false;
    }

    @Nullable
    private File dC(String str) {
        if (!DN() && !TextUtils.isEmpty(str)) {
            return b.a(this.avt, str);
        }
        return null;
    }

    private synchronized void init(Context context) {
        if (this.avt == null && context != null) {
            try {
                this.avt = com.kwad.sdk.core.diskcache.a.a.a(ax.cY(context), 1, 1, 209715200L);
            } catch (Throwable unused) {
            }
        }
    }

    public final boolean a(String str, a.C0856a c0856a) {
        File dC;
        if (!DN() && !TextUtils.isEmpty(str)) {
            String dD = c.dD(str);
            if (b.a(this.avt, str, dD, c0856a) && (dC = dC(dD)) != null && dC.exists()) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(String str, @NonNull String str2, a.C0856a c0856a) {
        File dC;
        if (!DN() && !TextUtils.isEmpty(str)) {
            String dD = c.dD(str2);
            if (b.a(this.avt, str, dD, c0856a) && (dC = dC(dD)) != null && dC.exists()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final File bZ(String str) {
        if (!DN() && !TextUtils.isEmpty(str)) {
            return dC(c.dD(str));
        }
        return null;
    }

    public final void dB(String str) {
        if (!DN() && !TextUtils.isEmpty(str)) {
            b.a(this.avt, str, c.dD(str));
        }
    }

    public final void delete() {
        if (DN()) {
            return;
        }
        try {
            this.avt.delete();
        } catch (IOException unused) {
        }
    }

    public final boolean remove(String str) {
        if (DN()) {
            return false;
        }
        try {
            aq.av(str, "cacheKey is not allowed empty");
            return this.avt.remove(c.dD(str));
        } catch (IOException unused) {
            return false;
        }
    }

    private a() {
    }
}
