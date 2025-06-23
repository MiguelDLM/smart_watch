package okio;

import java.util.zip.Deflater;
import kotlin.jvm.internal.IIX0o;

@XO0OX.xxIXOIIO(name = "-DeflaterSinkExtensions")
/* renamed from: okio.-DeflaterSinkExtensions, reason: invalid class name */
/* loaded from: classes6.dex */
public final class DeflaterSinkExtensions {
    @OXOo.OOXIXo
    public static final DeflaterSink deflate(@OXOo.OOXIXo Sink sink, @OXOo.OOXIXo Deflater deflater) {
        IIX0o.x0xO0oo(sink, "<this>");
        IIX0o.x0xO0oo(deflater, "deflater");
        return new DeflaterSink(sink, deflater);
    }

    public static /* synthetic */ DeflaterSink deflate$default(Sink sink, Deflater deflater, int i, Object obj) {
        if ((i & 1) != 0) {
            deflater = new Deflater();
        }
        IIX0o.x0xO0oo(sink, "<this>");
        IIX0o.x0xO0oo(deflater, "deflater");
        return new DeflaterSink(sink, deflater);
    }
}
