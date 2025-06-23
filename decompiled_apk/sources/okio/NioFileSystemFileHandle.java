package okio;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class NioFileSystemFileHandle extends FileHandle {

    @OXOo.OOXIXo
    private final FileChannel fileChannel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NioFileSystemFileHandle(boolean z, @OXOo.OOXIXo FileChannel fileChannel) {
        super(z);
        IIX0o.x0xO0oo(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    @Override // okio.FileHandle
    public synchronized void protectedClose() {
        this.fileChannel.close();
    }

    @Override // okio.FileHandle
    public synchronized void protectedFlush() {
        this.fileChannel.force(true);
    }

    @Override // okio.FileHandle
    public synchronized int protectedRead(long j, @OXOo.OOXIXo byte[] array, int i, int i2) {
        IIX0o.x0xO0oo(array, "array");
        this.fileChannel.position(j);
        ByteBuffer wrap = ByteBuffer.wrap(array, i, i2);
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            int read = this.fileChannel.read(wrap);
            if (read == -1) {
                if (i3 == 0) {
                    return -1;
                }
            } else {
                i3 += read;
            }
        }
        return i3;
    }

    @Override // okio.FileHandle
    public synchronized void protectedResize(long j) {
        try {
            long size = size();
            long j2 = j - size;
            if (j2 > 0) {
                int i = (int) j2;
                protectedWrite(size, new byte[i], 0, i);
            } else {
                this.fileChannel.truncate(j);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // okio.FileHandle
    public synchronized long protectedSize() {
        return this.fileChannel.size();
    }

    @Override // okio.FileHandle
    public synchronized void protectedWrite(long j, @OXOo.OOXIXo byte[] array, int i, int i2) {
        IIX0o.x0xO0oo(array, "array");
        this.fileChannel.position(j);
        this.fileChannel.write(ByteBuffer.wrap(array, i, i2));
    }
}
