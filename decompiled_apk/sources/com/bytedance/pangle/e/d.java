package com.bytedance.pangle.e;

import android.os.Build;
import androidx.annotation.NonNull;
import com.bytedance.pangle.e.f;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* loaded from: classes8.dex */
public final class d implements f.a {
    @Override // com.bytedance.pangle.e.f.a
    public final boolean a(String str, int i) {
        String b = com.bytedance.pangle.d.c.b(str, i);
        ZeusLogger.d(ZeusLogger.TAG_INSTALL, "full DexOpt:".concat(String.valueOf(b)));
        String c = com.bytedance.pangle.d.c.c(str, i);
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        String str2 = File.separator;
        sb.append(str2);
        sb.append("compFully");
        sb.append(b.b(b));
        String sb2 = sb.toString();
        String str3 = c + str2 + b.a(b);
        if (!a(b, sb2)) {
            return false;
        }
        File file = new File(sb2);
        if (file.exists()) {
            file.renameTo(new File(str3));
        }
        String str4 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        File file2 = new File(sb2.replace(str4, ".vdex"));
        if (file2.exists()) {
            file2.renameTo(new File(str3.replace(str4, ".vdex")));
        }
        boolean a2 = b.a(str3);
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:".concat(String.valueOf(a2)));
        return a2;
    }

    private static boolean a(@NonNull String str, @NonNull String str2) {
        try {
            return a.a(b.a(str, str2, b.b));
        } catch (Exception unused) {
            return false;
        }
    }
}
