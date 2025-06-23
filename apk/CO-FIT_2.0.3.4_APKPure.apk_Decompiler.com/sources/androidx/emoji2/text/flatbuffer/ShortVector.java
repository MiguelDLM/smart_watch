package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import kotlin.OX00O0xII;

public final class ShortVector extends BaseVector {
    public ShortVector __assign(int i, ByteBuffer byteBuffer) {
        __reset(i, 2, byteBuffer);
        return this;
    }

    public short get(int i) {
        return this.bb.getShort(__element(i));
    }

    public int getAsUnsigned(int i) {
        return get(i) & OX00O0xII.f18829Oxx0xo;
    }
}
