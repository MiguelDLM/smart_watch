package okhttp3.internal.cache2;

import OXOo.OOXIXo;
import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.jvm.internal.IIX0o;
import okio.Buffer;

/* loaded from: classes6.dex */
public final class FileOperator {

    @OOXIXo
    private final FileChannel fileChannel;

    public FileOperator(@OOXIXo FileChannel fileChannel) {
        IIX0o.x0xO0oo(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    public final void read(long j, @OOXIXo Buffer sink, long j2) {
        IIX0o.x0xO0oo(sink, "sink");
        if (j2 >= 0) {
            while (j2 > 0) {
                long transferTo = this.fileChannel.transferTo(j, j2, sink);
                j += transferTo;
                j2 -= transferTo;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public final void write(long j, @OOXIXo Buffer source, long j2) throws IOException {
        IIX0o.x0xO0oo(source, "source");
        if (j2 >= 0 && j2 <= source.size()) {
            long j3 = j;
            long j4 = j2;
            while (j4 > 0) {
                long transferFrom = this.fileChannel.transferFrom(source, j3, j4);
                j3 += transferFrom;
                j4 -= transferFrom;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
