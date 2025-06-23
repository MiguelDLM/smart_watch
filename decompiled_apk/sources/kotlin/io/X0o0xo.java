package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class X0o0xo {
    public static final String II0xO0(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(org.apache.commons.text.oIX0oI.f33048oxoX + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "toString(...)");
        return sb2;
    }
}
