package okio.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import okio.Path;

/* loaded from: classes6.dex */
public final class ZipEntry {

    @OOXIXo
    private final Path canonicalPath;

    @OOXIXo
    private final List<Path> children;

    @OOXIXo
    private final String comment;
    private final long compressedSize;
    private final int compressionMethod;
    private final long crc;
    private final boolean isDirectory;

    @oOoXoXO
    private final Long lastModifiedAtMillis;
    private final long offset;
    private final long size;

    public ZipEntry(@OOXIXo Path canonicalPath, boolean z, @OOXIXo String comment, long j, long j2, long j3, int i, @oOoXoXO Long l, long j4) {
        IIX0o.x0xO0oo(canonicalPath, "canonicalPath");
        IIX0o.x0xO0oo(comment, "comment");
        this.canonicalPath = canonicalPath;
        this.isDirectory = z;
        this.comment = comment;
        this.crc = j;
        this.compressedSize = j2;
        this.size = j3;
        this.compressionMethod = i;
        this.lastModifiedAtMillis = l;
        this.offset = j4;
        this.children = new ArrayList();
    }

    @OOXIXo
    public final Path getCanonicalPath() {
        return this.canonicalPath;
    }

    @OOXIXo
    public final List<Path> getChildren() {
        return this.children;
    }

    @OOXIXo
    public final String getComment() {
        return this.comment;
    }

    public final long getCompressedSize() {
        return this.compressedSize;
    }

    public final int getCompressionMethod() {
        return this.compressionMethod;
    }

    public final long getCrc() {
        return this.crc;
    }

    @oOoXoXO
    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    public final long getOffset() {
        return this.offset;
    }

    public final long getSize() {
        return this.size;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public /* synthetic */ ZipEntry(Path path, boolean z, String str, long j, long j2, long j3, int i, Long l, long j4, int i2, IIXOooo iIXOooo) {
        this(path, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? -1L : j, (i2 & 16) != 0 ? -1L : j2, (i2 & 32) != 0 ? -1L : j3, (i2 & 64) != 0 ? -1 : i, (i2 & 128) != 0 ? null : l, (i2 & 256) == 0 ? j4 : -1L);
    }
}
