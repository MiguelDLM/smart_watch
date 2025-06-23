package androidx.room.util;

import OXOo.OOXIXo;
import XO0OX.xxIXOIIO;
import androidx.annotation.RestrictTo;
import java.nio.ByteBuffer;
import java.util.UUID;
import kotlin.jvm.internal.IIX0o;

@xxIXOIIO(name = "UUIDUtil")
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class UUIDUtil {
    @OOXIXo
    public static final UUID convertByteToUUID(@OOXIXo byte[] bytes) {
        IIX0o.x0xO0oo(bytes, "bytes");
        ByteBuffer wrap = ByteBuffer.wrap(bytes);
        return new UUID(wrap.getLong(), wrap.getLong());
    }

    @OOXIXo
    public static final byte[] convertUUIDToByte(@OOXIXo UUID uuid) {
        IIX0o.x0xO0oo(uuid, "uuid");
        ByteBuffer wrap = ByteBuffer.wrap(new byte[16]);
        wrap.putLong(uuid.getMostSignificantBits());
        wrap.putLong(uuid.getLeastSignificantBits());
        byte[] array = wrap.array();
        IIX0o.oO(array, "buffer.array()");
        return array;
    }
}
