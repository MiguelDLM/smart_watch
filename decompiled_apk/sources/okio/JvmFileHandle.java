package okio;

import java.io.RandomAccessFile;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class JvmFileHandle extends FileHandle {

    @OXOo.OOXIXo
    private final RandomAccessFile randomAccessFile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmFileHandle(boolean z, @OXOo.OOXIXo RandomAccessFile randomAccessFile) {
        super(z);
        IIX0o.x0xO0oo(randomAccessFile, "randomAccessFile");
        this.randomAccessFile = randomAccessFile;
    }

    @Override // okio.FileHandle
    public synchronized void protectedClose() {
        this.randomAccessFile.close();
    }

    @Override // okio.FileHandle
    public synchronized void protectedFlush() {
        this.randomAccessFile.getFD().sync();
    }

    @Override // okio.FileHandle
    public synchronized int protectedRead(long j, @OXOo.OOXIXo byte[] array, int i, int i2) {
        IIX0o.x0xO0oo(array, "array");
        this.randomAccessFile.seek(j);
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            int read = this.randomAccessFile.read(array, i, i2 - i3);
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
                this.randomAccessFile.setLength(j);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // okio.FileHandle
    public synchronized long protectedSize() {
        return this.randomAccessFile.length();
    }

    @Override // okio.FileHandle
    public synchronized void protectedWrite(long j, @OXOo.OOXIXo byte[] array, int i, int i2) {
        IIX0o.x0xO0oo(array, "array");
        this.randomAccessFile.seek(j);
        this.randomAccessFile.write(array, i, i2);
    }
}
