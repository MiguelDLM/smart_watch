package okio;

import kotlin.jvm.internal.IIX0o;

@XO0OX.xxIXOIIO(name = "-GzipSourceExtensions")
/* renamed from: okio.-GzipSourceExtensions, reason: invalid class name */
/* loaded from: classes6.dex */
public final class GzipSourceExtensions {
    private static final int FCOMMENT = 4;
    private static final int FEXTRA = 2;
    private static final int FHCRC = 1;
    private static final int FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;

    private static final boolean getBit(int i, int i2) {
        return ((i >> i2) & 1) == 1;
    }

    @OXOo.OOXIXo
    public static final GzipSource gzip(@OXOo.OOXIXo Source source) {
        IIX0o.x0xO0oo(source, "<this>");
        return new GzipSource(source);
    }
}
