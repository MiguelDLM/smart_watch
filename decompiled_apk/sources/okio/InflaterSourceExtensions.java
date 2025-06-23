package okio;

import java.util.zip.Inflater;
import kotlin.jvm.internal.IIX0o;

@XO0OX.xxIXOIIO(name = "-InflaterSourceExtensions")
/* renamed from: okio.-InflaterSourceExtensions, reason: invalid class name */
/* loaded from: classes6.dex */
public final class InflaterSourceExtensions {
    @OXOo.OOXIXo
    public static final InflaterSource inflate(@OXOo.OOXIXo Source source, @OXOo.OOXIXo Inflater inflater) {
        IIX0o.x0xO0oo(source, "<this>");
        IIX0o.x0xO0oo(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }

    public static /* synthetic */ InflaterSource inflate$default(Source source, Inflater inflater, int i, Object obj) {
        if ((i & 1) != 0) {
            inflater = new Inflater();
        }
        IIX0o.x0xO0oo(source, "<this>");
        IIX0o.x0xO0oo(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }
}
