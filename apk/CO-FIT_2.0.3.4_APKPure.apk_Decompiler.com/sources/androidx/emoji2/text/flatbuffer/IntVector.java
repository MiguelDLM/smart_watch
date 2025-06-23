package androidx.emoji2.text.flatbuffer;

import com.szabh.smable3.entity.BleWatchFaceId;
import java.nio.ByteBuffer;

public final class IntVector extends BaseVector {
    public IntVector __assign(int i, ByteBuffer byteBuffer) {
        __reset(i, 4, byteBuffer);
        return this;
    }

    public int get(int i) {
        return this.bb.getInt(__element(i));
    }

    public long getAsUnsigned(int i) {
        return ((long) get(i)) & BleWatchFaceId.WATCHFACE_ID_INVALID;
    }
}
