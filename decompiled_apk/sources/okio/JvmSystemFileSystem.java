package okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.o00;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import okio.Path;

@XX({"SMAP\nJvmSystemFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmSystemFileSystem.kt\nokio/JvmSystemFileSystem\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,158:1\n11400#2,3:159\n*S KotlinDebug\n*F\n+ 1 JvmSystemFileSystem.kt\nokio/JvmSystemFileSystem\n*L\n77#1:159,3\n*E\n"})
/* loaded from: classes6.dex */
public class JvmSystemFileSystem extends FileSystem {
    private final void requireCreate(Path path) {
        if (!exists(path)) {
            return;
        }
        throw new IOException(path + " already exists.");
    }

    private final void requireExist(Path path) {
        if (exists(path)) {
            return;
        }
        throw new IOException(path + " doesn't exist.");
    }

    @Override // okio.FileSystem
    @OXOo.OOXIXo
    public Sink appendingSink(@OXOo.OOXIXo Path file, boolean z) {
        IIX0o.x0xO0oo(file, "file");
        if (z) {
            requireExist(file);
        }
        return Okio.sink(file.toFile(), true);
    }

    @Override // okio.FileSystem
    public void atomicMove(@OXOo.OOXIXo Path source, @OXOo.OOXIXo Path target) {
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(target, "target");
        if (source.toFile().renameTo(target.toFile())) {
            return;
        }
        throw new IOException("failed to move " + source + " to " + target);
    }

    @Override // okio.FileSystem
    @OXOo.OOXIXo
    public Path canonicalize(@OXOo.OOXIXo Path path) {
        IIX0o.x0xO0oo(path, "path");
        File canonicalFile = path.toFile().getCanonicalFile();
        if (canonicalFile.exists()) {
            Path.Companion companion = Path.Companion;
            IIX0o.ooOOo0oXI(canonicalFile);
            return Path.Companion.get$default(companion, canonicalFile, false, 1, (Object) null);
        }
        throw new FileNotFoundException("no such file");
    }

    @Override // okio.FileSystem
    public void createDirectory(@OXOo.OOXIXo Path dir, boolean z) {
        IIX0o.x0xO0oo(dir, "dir");
        if (!dir.toFile().mkdir()) {
            FileMetadata metadataOrNull = metadataOrNull(dir);
            if (metadataOrNull != null && metadataOrNull.isDirectory()) {
                if (!z) {
                    return;
                }
                throw new IOException(dir + " already exists.");
            }
            throw new IOException("failed to create directory: " + dir);
        }
    }

    @Override // okio.FileSystem
    public void createSymlink(@OXOo.OOXIXo Path source, @OXOo.OOXIXo Path target) {
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(target, "target");
        throw new IOException("unsupported");
    }

    @Override // okio.FileSystem
    public void delete(@OXOo.OOXIXo Path path, boolean z) {
        IIX0o.x0xO0oo(path, "path");
        if (!Thread.interrupted()) {
            File file = path.toFile();
            if (!file.delete()) {
                if (!file.exists()) {
                    if (z) {
                        throw new FileNotFoundException("no such file: " + path);
                    }
                    return;
                }
                throw new IOException("failed to delete " + path);
            }
            return;
        }
        throw new InterruptedIOException("interrupted");
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
        IIX0o.x0xO0oo(path, "path");
        File file = path.toFile();
        boolean isFile = file.isFile();
        boolean isDirectory = file.isDirectory();
        long lastModified = file.lastModified();
        long length = file.length();
        if (!isFile && !isDirectory && lastModified == 0 && length == 0 && !file.exists()) {
            return null;
        }
        return new FileMetadata(isFile, isDirectory, null, Long.valueOf(length), null, Long.valueOf(lastModified), null, null, 128, null);
    }

    @Override // okio.FileSystem
    @OXOo.OOXIXo
    public FileHandle openReadOnly(@OXOo.OOXIXo Path file) {
        IIX0o.x0xO0oo(file, "file");
        return new JvmFileHandle(false, new RandomAccessFile(file.toFile(), "r"));
    }

    @Override // okio.FileSystem
    @OXOo.OOXIXo
    public FileHandle openReadWrite(@OXOo.OOXIXo Path file, boolean z, boolean z2) {
        IIX0o.x0xO0oo(file, "file");
        if (z && z2) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
        if (z) {
            requireCreate(file);
        }
        if (z2) {
            requireExist(file);
        }
        return new JvmFileHandle(true, new RandomAccessFile(file.toFile(), "rw"));
    }

    @Override // okio.FileSystem
    @OXOo.OOXIXo
    public Sink sink(@OXOo.OOXIXo Path file, boolean z) {
        Sink sink$default;
        IIX0o.x0xO0oo(file, "file");
        if (z) {
            requireCreate(file);
        }
        sink$default = Okio__JvmOkioKt.sink$default(file.toFile(), false, 1, null);
        return sink$default;
    }

    @Override // okio.FileSystem
    @OXOo.OOXIXo
    public Source source(@OXOo.OOXIXo Path file) {
        IIX0o.x0xO0oo(file, "file");
        return Okio.source(file.toFile());
    }

    @OXOo.OOXIXo
    public String toString() {
        return "JvmSystemFileSystem";
    }

    private final List<Path> list(Path path, boolean z) {
        File file = path.toFile();
        String[] list = file.list();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                IIX0o.ooOOo0oXI(str);
                arrayList.add(path.resolve(str));
            }
            o00.IoOoo(arrayList);
            return arrayList;
        }
        if (!z) {
            return null;
        }
        if (file.exists()) {
            throw new IOException("failed to list " + path);
        }
        throw new FileNotFoundException("no such file: " + path);
    }
}
