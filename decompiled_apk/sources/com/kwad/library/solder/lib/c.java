package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class c implements com.kwad.library.solder.lib.a.b {
    private final File ajL;
    private final File ajM;
    private final com.kwad.library.solder.lib.ext.c ajN;
    private final Context mContext;

    public c(Context context, com.kwad.library.solder.lib.ext.c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.ajN = cVar;
        this.ajL = applicationContext.getDir(cVar.ye(), 0);
        this.ajM = applicationContext.getCacheDir();
    }

    private String E(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(xB());
        String str3 = File.separator;
        sb.append(str3);
        sb.append(str);
        sb.append(str3);
        sb.append(str2);
        return sb.toString();
    }

    @Nullable
    private String a(com.kwad.library.solder.lib.a.a aVar) {
        return F(aVar.getId(), aVar.getVersion());
    }

    private static void delete(String str) {
        q.delete(str);
    }

    private boolean i(String str, String str2, boolean z) {
        if (!q.gC(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.equals(str2, ae.gI(str))) {
            return true;
        }
        delete(str);
        return false;
    }

    private String xB() {
        return this.ajL.getAbsolutePath();
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void D(String str, String str2) {
        File file = new File(E(str, str2));
        if (!file.exists()) {
            return;
        }
        q.R(file);
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String F(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(xB());
        String str3 = File.separator;
        sb.append(str3);
        sb.append(str);
        sb.append(str3);
        sb.append(str2);
        sb.append(str3);
        sb.append(this.ajN.yj());
        return sb.toString();
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String b(com.kwad.library.solder.lib.a.a aVar) {
        String a2 = a(aVar);
        if (!TextUtils.isEmpty(a2)) {
            aVar.getId();
            File file = new File(a2);
            if (file.exists() && !this.ajN.yk() && i(file.getAbsolutePath(), aVar.xO(), true)) {
                return a2;
            }
            String xN = aVar.xN();
            aVar.getId();
            File file2 = new File(xN);
            if (file2.exists()) {
                aVar.getId();
                if (i(xN, aVar.xO(), true)) {
                    if (file2.renameTo(file)) {
                        aVar.getId();
                        return a2;
                    }
                    try {
                        xA();
                        try {
                            q.f(file2, file);
                            q.R(file2);
                            return a2;
                        } catch (Throwable th) {
                            a.e("PluginInstallerImpl", th);
                            throw new PluginError.InstallError(th, 3004);
                        }
                    } catch (Throwable th2) {
                        a.e("PluginInstallerImpl", th2);
                        throw new PluginError.InstallError(th2, 3005);
                    }
                }
                throw new PluginError.InstallError("check plugin md5 fail", 3003);
            }
            throw new PluginError.InstallError("Plugin file not exist.", 3001);
        }
        throw new PluginError.InstallError("Can not get install path.", 3006);
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void bH(String str) {
        File file = new File(bI(str));
        if (!file.exists()) {
            return;
        }
        q.R(file);
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String bI(@NonNull String str) {
        return xB() + File.separator + str;
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final File e(String str, boolean z) {
        String md5;
        if (str == null || (md5 = com.kwad.library.solder.lib.d.b.getMD5(str)) == null) {
            return null;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(md5);
            if (this.ajN.yi() != null) {
                sb.append(this.ajN.yi());
            }
            File file = new File(this.ajM, sb.toString());
            if (!file.exists() && !file.createNewFile()) {
                return null;
            }
            return file;
        }
        return File.createTempFile(md5 + System.currentTimeMillis(), this.ajN.yi(), this.ajM);
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void xA() {
        if (this.ajL.getFreeSpace() >= 10000000) {
        } else {
            throw new IOException("No enough capacity.");
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final boolean a(String str, String str2, String str3) {
        if (this.ajN.yk()) {
            return false;
        }
        return i(F(str, str2), str3, true);
    }
}
