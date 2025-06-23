package okio;

import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;

@kotlin.OOXIXo(message = "changed in Okio 2.x")
/* renamed from: okio.-DeprecatedUtf8, reason: invalid class name */
/* loaded from: classes6.dex */
public final class DeprecatedUtf8 {

    @OXOo.OOXIXo
    public static final DeprecatedUtf8 INSTANCE = new DeprecatedUtf8();

    private DeprecatedUtf8() {
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @XX(expression = "string.utf8Size()", imports = {"okio.utf8Size"}))
    public final long size(@OXOo.OOXIXo String string) {
        IIX0o.x0xO0oo(string, "string");
        return Utf8.size$default(string, 0, 0, 3, null);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @XX(expression = "string.utf8Size(beginIndex, endIndex)", imports = {"okio.utf8Size"}))
    public final long size(@OXOo.OOXIXo String string, int i, int i2) {
        IIX0o.x0xO0oo(string, "string");
        return Utf8.size(string, i, i2);
    }
}
