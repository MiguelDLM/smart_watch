package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oO;
import okio.Path;
import okio.internal.FixedLengthSource;
import okio.internal.ZipEntry;
import okio.internal.ZipFilesKt;

@XX({"SMAP\nZipFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ZipFileSystem.kt\nokio/ZipFileSystem\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,175:1\n52#2,5:176\n52#2,21:181\n60#2,10:202\n57#2,2:212\n71#2,2:214\n52#2,21:216\n*S KotlinDebug\n*F\n+ 1 ZipFileSystem.kt\nokio/ZipFileSystem\n*L\n102#1:176,5\n103#1:181,21\n102#1:202,10\n102#1:212,2\n102#1:214,2\n132#1:216,21\n*E\n"})
/* loaded from: classes6.dex */
public final class ZipFileSystem extends FileSystem {

    @OXOo.OOXIXo
    private static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final Path ROOT = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);

    @OXOo.oOoXoXO
    private final String comment;

    @OXOo.OOXIXo
    private final Map<Path, ZipEntry> entries;

    @OXOo.OOXIXo
    private final FileSystem fileSystem;

    @OXOo.OOXIXo
    private final Path zipPath;

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final Path getROOT() {
            return ZipFileSystem.ROOT;
        }

        private Companion() {
        }
    }

    public ZipFileSystem(@OXOo.OOXIXo Path zipPath, @OXOo.OOXIXo FileSystem fileSystem, @OXOo.OOXIXo Map<Path, ZipEntry> entries, @OXOo.oOoXoXO String str) {
        IIX0o.x0xO0oo(zipPath, "zipPath");
        IIX0o.x0xO0oo(fileSystem, "fileSystem");
        IIX0o.x0xO0oo(entries, "entries");
        this.zipPath = zipPath;
        this.fileSystem = fileSystem;
        this.entries = entries;
        this.comment = str;
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    @Override // okio.FileSystem
    @OXOo.OOXIXo
    public Sink appendingSink(@OXOo.OOXIXo Path file, boolean z) {
        IIX0o.x0xO0oo(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void atomicMove(@OXOo.OOXIXo Path source, @OXOo.OOXIXo Path target) {
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    @OXOo.OOXIXo
    public Path canonicalize(@OXOo.OOXIXo Path path) {
        IIX0o.x0xO0oo(path, "path");
        Path canonicalizeInternal = canonicalizeInternal(path);
        if (this.entries.containsKey(canonicalizeInternal)) {
            return canonicalizeInternal;
        }
        throw new FileNotFoundException(String.valueOf(path));
    }

    @Override // okio.FileSystem
    public void createDirectory(@OXOo.OOXIXo Path dir, boolean z) {
        IIX0o.x0xO0oo(dir, "dir");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void createSymlink(@OXOo.OOXIXo Path source, @OXOo.OOXIXo Path target) {
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void delete(@OXOo.OOXIXo Path path, boolean z) {
        IIX0o.x0xO0oo(path, "path");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    @OXOo.OOXIXo
    public List<Path> list(@OXOo.OOXIXo Path dir) {
        IIX0o.x0xO0oo(dir, "dir");
        List<Path> list = list(dir, true);
        IIX0o.ooOOo0oXI(list);
        return list;
    }

    @Override // okio.FileSystem
    @OXOo.oOoXoXO
    public List<Path> listOrNull(@OXOo.OOXIXo Path dir) {
        IIX0o.x0xO0oo(dir, "dir");
        return list(dir, false);
    }

    @Override // okio.FileSystem
    @OXOo.oOoXoXO
    public FileMetadata metadataOrNull(@OXOo.OOXIXo Path path) {
        Long valueOf;
        FileMetadata fileMetadata;
        Throwable th;
        IIX0o.x0xO0oo(path, "path");
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(path));
        Throwable th2 = null;
        if (zipEntry == null) {
            return null;
        }
        boolean z = !zipEntry.isDirectory();
        boolean isDirectory = zipEntry.isDirectory();
        if (zipEntry.isDirectory()) {
            valueOf = null;
        } else {
            valueOf = Long.valueOf(zipEntry.getSize());
        }
        FileMetadata fileMetadata2 = new FileMetadata(z, isDirectory, null, valueOf, null, zipEntry.getLastModifiedAtMillis(), null, null, 128, null);
        if (zipEntry.getOffset() == -1) {
            return fileMetadata2;
        }
        FileHandle openReadOnly = this.fileSystem.openReadOnly(this.zipPath);
        try {
            BufferedSource buffer = Okio.buffer(openReadOnly.source(zipEntry.getOffset()));
            try {
                fileMetadata = ZipFilesKt.readLocalHeader(buffer, fileMetadata2);
                if (buffer != null) {
                    try {
                        buffer.close();
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                th = null;
            } catch (Throwable th4) {
                if (buffer != null) {
                    try {
                        buffer.close();
                    } catch (Throwable th5) {
                        oO.oIX0oI(th4, th5);
                    }
                }
                th = th4;
                fileMetadata = null;
            }
        } catch (Throwable th6) {
            if (openReadOnly != null) {
                try {
                    openReadOnly.close();
                } catch (Throwable th7) {
                    oO.oIX0oI(th6, th7);
                }
            }
            fileMetadata = null;
            th2 = th6;
        }
        if (th == null) {
            IIX0o.ooOOo0oXI(fileMetadata);
            if (openReadOnly != null) {
                try {
                    openReadOnly.close();
                } catch (Throwable th8) {
                    th2 = th8;
                }
            }
            if (th2 == null) {
                IIX0o.ooOOo0oXI(fileMetadata);
                return fileMetadata;
            }
            throw th2;
        }
        throw th;
    }

    @Override // okio.FileSystem
    @OXOo.OOXIXo
    public FileHandle openReadOnly(@OXOo.OOXIXo Path file) {
        IIX0o.x0xO0oo(file, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // okio.FileSystem
    @OXOo.OOXIXo
    public FileHandle openReadWrite(@OXOo.OOXIXo Path file, boolean z, boolean z2) {
        IIX0o.x0xO0oo(file, "file");
        throw new IOException("zip entries are not writable");
    }

    @Override // okio.FileSystem
    @OXOo.OOXIXo
    public Sink sink(@OXOo.OOXIXo Path file, boolean z) {
        IIX0o.x0xO0oo(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    @OXOo.OOXIXo
    public Source source(@OXOo.OOXIXo Path file) throws IOException {
        BufferedSource bufferedSource;
        IIX0o.x0xO0oo(file, "file");
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(file));
        if (zipEntry != null) {
            FileHandle openReadOnly = this.fileSystem.openReadOnly(this.zipPath);
            Throwable th = null;
            try {
                bufferedSource = Okio.buffer(openReadOnly.source(zipEntry.getOffset()));
                if (openReadOnly != null) {
                    try {
                        openReadOnly.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                if (openReadOnly != null) {
                    try {
                        openReadOnly.close();
                    } catch (Throwable th4) {
                        oO.oIX0oI(th3, th4);
                    }
                }
                bufferedSource = null;
                th = th3;
            }
            if (th == null) {
                IIX0o.ooOOo0oXI(bufferedSource);
                ZipFilesKt.skipLocalHeader(bufferedSource);
                if (zipEntry.getCompressionMethod() == 0) {
                    return new FixedLengthSource(bufferedSource, zipEntry.getSize(), true);
                }
                return new FixedLengthSource(new InflaterSource(new FixedLengthSource(bufferedSource, zipEntry.getCompressedSize(), true), new Inflater(true)), zipEntry.getSize(), false);
            }
            throw th;
        }
        throw new FileNotFoundException("no such file: " + file);
    }

    private final List<Path> list(Path path, boolean z) {
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(path));
        if (zipEntry != null) {
            return CollectionsKt___CollectionsKt.oOo0o(zipEntry.getChildren());
        }
        if (!z) {
            return null;
        }
        throw new IOException("not a directory: " + path);
    }
}
