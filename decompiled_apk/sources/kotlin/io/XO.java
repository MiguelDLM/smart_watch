package kotlin.io;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class XO extends ByteArrayOutputStream {
    public XO(int i) {
        super(i);
    }

    @OXOo.OOXIXo
    public final byte[] oIX0oI() {
        byte[] buf = ((ByteArrayOutputStream) this).buf;
        IIX0o.oO(buf, "buf");
        return buf;
    }
}
