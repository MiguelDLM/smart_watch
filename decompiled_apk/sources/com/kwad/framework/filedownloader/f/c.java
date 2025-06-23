package com.kwad.framework.filedownloader.f;

import android.annotation.SuppressLint;
import android.content.Context;
import com.kwad.framework.filedownloader.exception.PathConflictException;
import com.kwad.framework.filedownloader.y;
import java.io.File;

/* loaded from: classes11.dex */
public final class c {

    @SuppressLint({"StaticFieldLeak"})
    private static Context aja;

    /* loaded from: classes11.dex */
    public interface a {
        int O(long j);
    }

    /* loaded from: classes11.dex */
    public interface b {
        com.kwad.framework.filedownloader.a.b bh(String str);
    }

    /* renamed from: com.kwad.framework.filedownloader.f.c$c, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0829c {
        com.kwad.framework.filedownloader.b.a xq();
    }

    /* loaded from: classes11.dex */
    public interface d {
        int f(String str, String str2, boolean z);

        int g(String str, String str2, boolean z);
    }

    /* loaded from: classes11.dex */
    public interface e {
        com.kwad.framework.filedownloader.e.a c(File file);
    }

    public static boolean a(int i, String str, boolean z, boolean z2) {
        if (!z && str != null) {
            File file = new File(str);
            if (file.exists()) {
                com.kwad.framework.filedownloader.message.e.wJ().s(com.kwad.framework.filedownloader.message.f.a(i, file, z2));
                return true;
            }
        }
        return false;
    }

    public static void ax(Context context) {
        aja = context;
    }

    public static Context xp() {
        return aja;
    }

    public static boolean a(int i, com.kwad.framework.filedownloader.d.c cVar, y yVar, boolean z) {
        if (!yVar.a(cVar)) {
            return false;
        }
        com.kwad.framework.filedownloader.message.e.wJ().s(com.kwad.framework.filedownloader.message.f.a(i, cVar.wP(), cVar.getTotal(), z));
        return true;
    }

    public static boolean a(int i, long j, String str, String str2, y yVar) {
        int o;
        if (str2 == null || str == null || (o = yVar.o(str, i)) == 0) {
            return false;
        }
        com.kwad.framework.filedownloader.message.e.wJ().s(com.kwad.framework.filedownloader.message.f.a(i, j, new PathConflictException(o, str, str2)));
        return true;
    }
}
