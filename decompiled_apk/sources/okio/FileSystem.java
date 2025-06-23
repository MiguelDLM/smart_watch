package okio;

import XO0OX.x0XOIxOo;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oO;
import kotlin.sequences.ooOOo0oXI;
import okio.Path;
import okio.internal.ResourceFileSystem;
import org.apache.commons.lang3.XX0;

@XX({"SMAP\nFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileSystem.kt\nokio/FileSystem\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,165:1\n52#2,21:166\n52#2,21:187\n*S KotlinDebug\n*F\n+ 1 FileSystem.kt\nokio/FileSystem\n*L\n67#1:166,21\n81#1:187,21\n*E\n"})
/* loaded from: classes6.dex */
public abstract class FileSystem {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final FileSystem RESOURCES;

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final FileSystem SYSTEM;

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final Path SYSTEM_TEMPORARY_DIRECTORY;

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        @XO0OX.xxIXOIIO(name = "get")
        public final FileSystem get(@OXOo.OOXIXo java.nio.file.FileSystem fileSystem) {
            IIX0o.x0xO0oo(fileSystem, "<this>");
            return new NioFileSystemWrappingFileSystem(fileSystem);
        }

        private Companion() {
        }
    }

    /* renamed from: -write$default, reason: not valid java name */
    public static /* synthetic */ Object m447write$default(FileSystem fileSystem, Path file, boolean z, Oox.oOoXoXO writerAction, int i, Object obj) throws IOException {
        Object obj2;
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            IIX0o.x0xO0oo(file, "file");
            IIX0o.x0xO0oo(writerAction, "writerAction");
            BufferedSink buffer = Okio.buffer(fileSystem.sink(file, z));
            Throwable th = null;
            try {
                obj2 = writerAction.invoke(buffer);
                xxX.oxoX(1);
                if (buffer != null) {
                    try {
                        buffer.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                xxX.I0Io(1);
            } catch (Throwable th3) {
                xxX.oxoX(1);
                if (buffer != null) {
                    try {
                        buffer.close();
                    } catch (Throwable th4) {
                        oO.oIX0oI(th3, th4);
                    }
                }
                xxX.I0Io(1);
                obj2 = null;
                th = th3;
            }
            if (th == null) {
                IIX0o.ooOOo0oXI(obj2);
                return obj2;
            }
            throw th;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
    }

    static {
        FileSystem jvmSystemFileSystem;
        try {
            Class.forName("java.nio.file.Files");
            jvmSystemFileSystem = new NioSystemFileSystem();
        } catch (ClassNotFoundException unused) {
            jvmSystemFileSystem = new JvmSystemFileSystem();
        }
        SYSTEM = jvmSystemFileSystem;
        Path.Companion companion = Path.Companion;
        String property = System.getProperty(XX0.f32564X0o0xo);
        IIX0o.oO(property, "getProperty(...)");
        SYSTEM_TEMPORARY_DIRECTORY = Path.Companion.get$default(companion, property, false, 1, (Object) null);
        ClassLoader classLoader = ResourceFileSystem.class.getClassLoader();
        IIX0o.oO(classLoader, "getClassLoader(...)");
        RESOURCES = new ResourceFileSystem(classLoader, false, null, 4, null);
    }

    public static /* synthetic */ Sink appendingSink$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            return fileSystem.appendingSink(path, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendingSink");
    }

    public static /* synthetic */ void createDirectories$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            fileSystem.createDirectories(path, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectories");
    }

    public static /* synthetic */ void createDirectory$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            fileSystem.createDirectory(path, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
    }

    public static /* synthetic */ void delete$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            fileSystem.delete(path, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
    }

    public static /* synthetic */ void deleteRecursively$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            fileSystem.deleteRecursively(path, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteRecursively");
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "get")
    public static final FileSystem get(@OXOo.OOXIXo java.nio.file.FileSystem fileSystem) {
        return Companion.get(fileSystem);
    }

    public static /* synthetic */ ooOOo0oXI listRecursively$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            return fileSystem.listRecursively(path, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listRecursively");
    }

    public static /* synthetic */ FileHandle openReadWrite$default(FileSystem fileSystem, Path path, boolean z, boolean z2, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            return fileSystem.openReadWrite(path, z, z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openReadWrite");
    }

    public static /* synthetic */ Sink sink$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            return fileSystem.sink(path, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
    }

    @XO0OX.xxIXOIIO(name = "-read")
    /* renamed from: -read, reason: not valid java name */
    public final <T> T m448read(@OXOo.OOXIXo Path file, @OXOo.OOXIXo Oox.oOoXoXO<? super BufferedSource, ? extends T> readerAction) throws IOException {
        T t;
        IIX0o.x0xO0oo(file, "file");
        IIX0o.x0xO0oo(readerAction, "readerAction");
        BufferedSource buffer = Okio.buffer(source(file));
        Throwable th = null;
        try {
            t = readerAction.invoke(buffer);
            xxX.oxoX(1);
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            xxX.I0Io(1);
        } catch (Throwable th3) {
            xxX.oxoX(1);
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th4) {
                    oO.oIX0oI(th3, th4);
                }
            }
            xxX.I0Io(1);
            th = th3;
            t = null;
        }
        if (th == null) {
            IIX0o.ooOOo0oXI(t);
            return t;
        }
        throw th;
    }

    @XO0OX.xxIXOIIO(name = "-write")
    /* renamed from: -write, reason: not valid java name */
    public final <T> T m449write(@OXOo.OOXIXo Path file, boolean z, @OXOo.OOXIXo Oox.oOoXoXO<? super BufferedSink, ? extends T> writerAction) throws IOException {
        T t;
        IIX0o.x0xO0oo(file, "file");
        IIX0o.x0xO0oo(writerAction, "writerAction");
        BufferedSink buffer = Okio.buffer(sink(file, z));
        Throwable th = null;
        try {
            t = writerAction.invoke(buffer);
            xxX.oxoX(1);
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            xxX.I0Io(1);
        } catch (Throwable th3) {
            xxX.oxoX(1);
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th4) {
                    oO.oIX0oI(th3, th4);
                }
            }
            xxX.I0Io(1);
            th = th3;
            t = null;
        }
        if (th == null) {
            IIX0o.ooOOo0oXI(t);
            return t;
        }
        throw th;
    }

    @OXOo.OOXIXo
    public final Sink appendingSink(@OXOo.OOXIXo Path file) throws IOException {
        IIX0o.x0xO0oo(file, "file");
        return appendingSink(file, false);
    }

    @OXOo.OOXIXo
    public abstract Sink appendingSink(@OXOo.OOXIXo Path path, boolean z) throws IOException;

    public abstract void atomicMove(@OXOo.OOXIXo Path path, @OXOo.OOXIXo Path path2) throws IOException;

    @OXOo.OOXIXo
    public abstract Path canonicalize(@OXOo.OOXIXo Path path) throws IOException;

    public void copy(@OXOo.OOXIXo Path source, @OXOo.OOXIXo Path target) throws IOException {
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(target, "target");
        okio.internal.FileSystem.commonCopy(this, source, target);
    }

    public final void createDirectories(@OXOo.OOXIXo Path dir, boolean z) throws IOException {
        IIX0o.x0xO0oo(dir, "dir");
        okio.internal.FileSystem.commonCreateDirectories(this, dir, z);
    }

    public final void createDirectory(@OXOo.OOXIXo Path dir) throws IOException {
        IIX0o.x0xO0oo(dir, "dir");
        createDirectory(dir, false);
    }

    public abstract void createDirectory(@OXOo.OOXIXo Path path, boolean z) throws IOException;

    public abstract void createSymlink(@OXOo.OOXIXo Path path, @OXOo.OOXIXo Path path2) throws IOException;

    public final void delete(@OXOo.OOXIXo Path path) throws IOException {
        IIX0o.x0xO0oo(path, "path");
        delete(path, false);
    }

    public abstract void delete(@OXOo.OOXIXo Path path, boolean z) throws IOException;

    public void deleteRecursively(@OXOo.OOXIXo Path fileOrDirectory, boolean z) throws IOException {
        IIX0o.x0xO0oo(fileOrDirectory, "fileOrDirectory");
        okio.internal.FileSystem.commonDeleteRecursively(this, fileOrDirectory, z);
    }

    public final boolean exists(@OXOo.OOXIXo Path path) throws IOException {
        IIX0o.x0xO0oo(path, "path");
        return okio.internal.FileSystem.commonExists(this, path);
    }

    @OXOo.OOXIXo
    public abstract List<Path> list(@OXOo.OOXIXo Path path) throws IOException;

    @OXOo.oOoXoXO
    public abstract List<Path> listOrNull(@OXOo.OOXIXo Path path);

    @OXOo.OOXIXo
    public ooOOo0oXI<Path> listRecursively(@OXOo.OOXIXo Path dir, boolean z) {
        IIX0o.x0xO0oo(dir, "dir");
        return okio.internal.FileSystem.commonListRecursively(this, dir, z);
    }

    @OXOo.OOXIXo
    public final FileMetadata metadata(@OXOo.OOXIXo Path path) throws IOException {
        IIX0o.x0xO0oo(path, "path");
        return okio.internal.FileSystem.commonMetadata(this, path);
    }

    @OXOo.oOoXoXO
    public abstract FileMetadata metadataOrNull(@OXOo.OOXIXo Path path) throws IOException;

    @OXOo.OOXIXo
    public abstract FileHandle openReadOnly(@OXOo.OOXIXo Path path) throws IOException;

    @OXOo.OOXIXo
    public final FileHandle openReadWrite(@OXOo.OOXIXo Path file) throws IOException {
        IIX0o.x0xO0oo(file, "file");
        return openReadWrite(file, false, false);
    }

    @OXOo.OOXIXo
    public abstract FileHandle openReadWrite(@OXOo.OOXIXo Path path, boolean z, boolean z2) throws IOException;

    @OXOo.OOXIXo
    public final Sink sink(@OXOo.OOXIXo Path file) throws IOException {
        IIX0o.x0xO0oo(file, "file");
        return sink(file, false);
    }

    @OXOo.OOXIXo
    public abstract Sink sink(@OXOo.OOXIXo Path path, boolean z) throws IOException;

    @OXOo.OOXIXo
    public abstract Source source(@OXOo.OOXIXo Path path) throws IOException;

    public final void createDirectories(@OXOo.OOXIXo Path dir) throws IOException {
        IIX0o.x0xO0oo(dir, "dir");
        createDirectories(dir, false);
    }

    public final void deleteRecursively(@OXOo.OOXIXo Path fileOrDirectory) throws IOException {
        IIX0o.x0xO0oo(fileOrDirectory, "fileOrDirectory");
        deleteRecursively(fileOrDirectory, false);
    }

    @OXOo.OOXIXo
    public final ooOOo0oXI<Path> listRecursively(@OXOo.OOXIXo Path dir) {
        IIX0o.x0xO0oo(dir, "dir");
        return listRecursively(dir, false);
    }
}
