package kotlinx.coroutines.debug.internal;

import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class X0o0xo {
    public static final String II0xO0(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\"') {
                sb.append("\\\"");
            } else if (charAt == '\\') {
                sb.append("\\\\");
            } else if (charAt == '\b') {
                sb.append("\\b");
            } else if (charAt == '\n') {
                sb.append("\\n");
            } else if (charAt == '\r') {
                sb.append("\\r");
            } else if (charAt == '\t') {
                sb.append("\\t");
            } else {
                sb.append(charAt);
            }
        }
        sb.append('\"');
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
