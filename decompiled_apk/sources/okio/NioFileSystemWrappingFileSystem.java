package okio;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.X00IoxXI;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.o00;
import kotlin.collections.oI0IIXIo;
import kotlin.io.path.OOXIxO0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.XX;
import okio.Path;

@XX({"SMAP\nNioFileSystemWrappingFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NioFileSystemWrappingFileSystem.kt\nokio/NioFileSystemWrappingFileSystem\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,192:1\n1620#2,3:193\n1#3:196\n37#4,2:197\n37#4,2:199\n37#4,2:201\n*S KotlinDebug\n*F\n+ 1 NioFileSystemWrappingFileSystem.kt\nokio/NioFileSystemWrappingFileSystem\n*L\n77#1:193,3\n104#1:197,2\n125#1:199,2\n138#1:201,2\n*E\n"})
/* loaded from: classes6.dex */
public final class NioFileSystemWrappingFileSystem extends NioSystemFileSystem {

    @OXOo.OOXIXo
    private final java.nio.file.FileSystem nioFileSystem;

    public NioFileSystemWrappingFileSystem(@OXOo.OOXIXo java.nio.file.FileSystem nioFileSystem) {
        IIX0o.x0xO0oo(nioFileSystem, "nioFileSystem");
        this.nioFileSystem = nioFileSystem;
    }

    private final java.nio.file.Path resolve(Path path) {
        java.nio.file.Path path2;
        path2 = this.nioFileSystem.getPath(path.toString(), new String[0]);
        IIX0o.oO(path2, "getPath(...)");
        return path2;
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    @OXOo.OOXIXo
    public Sink appendingSink(@OXOo.OOXIXo Path file, boolean z) {
        StandardOpenOption standardOpenOption;
        OutputStream newOutputStream;
        StandardOpenOption standardOpenOption2;
        IIX0o.x0xO0oo(file, "file");
        List xxIXOIIO2 = oI0IIXIo.xxIXOIIO();
        standardOpenOption = StandardOpenOption.APPEND;
        xxIXOIIO2.add(standardOpenOption);
        if (!z) {
            standardOpenOption2 = StandardOpenOption.CREATE;
            xxIXOIIO2.add(standardOpenOption2);
        }
        List oIX0oI2 = oI0IIXIo.oIX0oI(xxIXOIIO2);
        java.nio.file.Path resolve = resolve(file);
        StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) oIX0oI2.toArray(new StandardOpenOption[0]);
        OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
        newOutputStream = Files.newOutputStream(resolve, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        IIX0o.oO(newOutputStream, "newOutputStream(this, *options)");
        return Okio.sink(newOutputStream);
    }

    @Override // okio.NioSystemFileSystem, okio.JvmSystemFileSystem, okio.FileSystem
    public void atomicMove(@OXOo.OOXIXo Path source, @OXOo.OOXIXo Path target) {
        String message;
        StandardCopyOption standardCopyOption;
        StandardCopyOption standardCopyOption2;
        java.nio.file.Path move;
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(target, "target");
        try {
            java.nio.file.Path resolve = resolve(source);
            java.nio.file.Path resolve2 = resolve(target);
            standardCopyOption = StandardCopyOption.ATOMIC_MOVE;
            standardCopyOption2 = StandardCopyOption.REPLACE_EXISTING;
            move = Files.move(resolve, resolve2, (CopyOption[]) Arrays.copyOf(new CopyOption[]{standardCopyOption, standardCopyOption2}, 2));
            IIX0o.oO(move, "move(this, target, *options)");
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        } catch (NoSuchFileException e) {
            message = e.getMessage();
            throw new FileNotFoundException(message);
        }
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    @OXOo.OOXIXo
    public Path canonicalize(@OXOo.OOXIXo Path path) {
        java.nio.file.Path realPath;
        IIX0o.x0xO0oo(path, "path");
        try {
            Path.Companion companion = Path.Companion;
            realPath = resolve(path).toRealPath(new LinkOption[0]);
            IIX0o.oO(realPath, "toRealPath(...)");
            return Path.Companion.get$default(companion, realPath, false, 1, (Object) null);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException("no such file: " + path);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0011, code lost:
    
        if (r0.isDirectory() == true) goto L8;
     */
    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void createDirectory(@OXOo.OOXIXo okio.Path r4, boolean r5) {
        /*
            r3 = this;
            java.lang.String r0 = "dir"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
            okio.FileMetadata r0 = r3.metadataOrNull(r4)
            r1 = 0
            if (r0 == 0) goto L14
            boolean r0 = r0.isDirectory()
            r2 = 1
            if (r0 != r2) goto L14
            goto L15
        L14:
            r2 = 0
        L15:
            if (r2 == 0) goto L31
            if (r5 != 0) goto L1a
            goto L31
        L1a:
            java.io.IOException r5 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r4 = " already exists."
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5.<init>(r4)
            throw r5
        L31:
            java.nio.file.Path r5 = r3.resolve(r4)     // Catch: java.io.IOException -> L47
            java.nio.file.attribute.FileAttribute[] r0 = new java.nio.file.attribute.FileAttribute[r1]     // Catch: java.io.IOException -> L47
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)     // Catch: java.io.IOException -> L47
            java.nio.file.attribute.FileAttribute[] r0 = (java.nio.file.attribute.FileAttribute[]) r0     // Catch: java.io.IOException -> L47
            java.nio.file.Path r5 = kotlin.io.path.Xo0.oIX0oI(r5, r0)     // Catch: java.io.IOException -> L47
            java.lang.String r0 = "createDirectory(this, *attributes)"
            kotlin.jvm.internal.IIX0o.oO(r5, r0)     // Catch: java.io.IOException -> L47
            return
        L47:
            r5 = move-exception
            if (r2 == 0) goto L4b
            return
        L4b:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "failed to create directory: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.NioFileSystemWrappingFileSystem.createDirectory(okio.Path, boolean):void");
    }

    @Override // okio.NioSystemFileSystem, okio.JvmSystemFileSystem, okio.FileSystem
    public void createSymlink(@OXOo.OOXIXo Path source, @OXOo.OOXIXo Path target) {
        java.nio.file.Path createSymbolicLink;
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(target, "target");
        createSymbolicLink = Files.createSymbolicLink(resolve(source), resolve(target), (FileAttribute[]) Arrays.copyOf(new FileAttribute[0], 0));
        IIX0o.oO(createSymbolicLink, "createSymbolicLink(this, target, *attributes)");
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public void delete(@OXOo.OOXIXo Path path, boolean z) {
        boolean exists;
        IIX0o.x0xO0oo(path, "path");
        if (!Thread.interrupted()) {
            java.nio.file.Path resolve = resolve(path);
            try {
                Files.delete(resolve);
                return;
            } catch (NoSuchFileException unused) {
                if (!z) {
                    return;
                }
                throw new FileNotFoundException("no such file: " + path);
            } catch (IOException unused2) {
                exists = Files.exists(resolve, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0));
                if (exists) {
                    throw new IOException("failed to delete " + path);
                }
                return;
            }
        }
        throw new InterruptedIOException("interrupted");
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    @OXOo.OOXIXo
    public List<Path> list(@OXOo.OOXIXo Path dir) {
        IIX0o.x0xO0oo(dir, "dir");
        List<Path> list = list(dir, true);
        IIX0o.ooOOo0oXI(list);
        return list;
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    @OXOo.oOoXoXO
    public List<Path> listOrNull(@OXOo.OOXIXo Path dir) {
        IIX0o.x0xO0oo(dir, "dir");
        return list(dir, false);
    }

    @Override // okio.NioSystemFileSystem, okio.JvmSystemFileSystem, okio.FileSystem
    @OXOo.oOoXoXO
    public FileMetadata metadataOrNull(@OXOo.OOXIXo Path path) {
        IIX0o.x0xO0oo(path, "path");
        return metadataOrNull(resolve(path));
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    @OXOo.OOXIXo
    public FileHandle openReadOnly(@OXOo.OOXIXo Path file) {
        StandardOpenOption standardOpenOption;
        FileChannel open;
        IIX0o.x0xO0oo(file, "file");
        try {
            java.nio.file.Path resolve = resolve(file);
            standardOpenOption = StandardOpenOption.READ;
            open = FileChannel.open(resolve, standardOpenOption);
            IIX0o.ooOOo0oXI(open);
            return new NioFileSystemFileHandle(false, open);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException("no such file: " + file);
        }
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    @OXOo.OOXIXo
    public FileHandle openReadWrite(@OXOo.OOXIXo Path file, boolean z, boolean z2) {
        StandardOpenOption standardOpenOption;
        StandardOpenOption standardOpenOption2;
        StandardOpenOption standardOpenOption3;
        FileChannel open;
        StandardOpenOption standardOpenOption4;
        IIX0o.x0xO0oo(file, "file");
        if (z && z2) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
        List xxIXOIIO2 = oI0IIXIo.xxIXOIIO();
        standardOpenOption = StandardOpenOption.READ;
        xxIXOIIO2.add(standardOpenOption);
        standardOpenOption2 = StandardOpenOption.WRITE;
        xxIXOIIO2.add(standardOpenOption2);
        if (z) {
            standardOpenOption4 = StandardOpenOption.CREATE_NEW;
            xxIXOIIO2.add(standardOpenOption4);
        } else if (!z2) {
            standardOpenOption3 = StandardOpenOption.CREATE;
            xxIXOIIO2.add(standardOpenOption3);
        }
        List oIX0oI2 = oI0IIXIo.oIX0oI(xxIXOIIO2);
        try {
            java.nio.file.Path resolve = resolve(file);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) oIX0oI2.toArray(new StandardOpenOption[0]);
            open = FileChannel.open(resolve, (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length));
            IIX0o.ooOOo0oXI(open);
            return new NioFileSystemFileHandle(true, open);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException("no such file: " + file);
        }
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    @OXOo.OOXIXo
    public Sink sink(@OXOo.OOXIXo Path file, boolean z) {
        OutputStream newOutputStream;
        StandardOpenOption standardOpenOption;
        IIX0o.x0xO0oo(file, "file");
        List xxIXOIIO2 = oI0IIXIo.xxIXOIIO();
        if (z) {
            standardOpenOption = StandardOpenOption.CREATE_NEW;
            xxIXOIIO2.add(standardOpenOption);
        }
        List oIX0oI2 = oI0IIXIo.oIX0oI(xxIXOIIO2);
        try {
            java.nio.file.Path resolve = resolve(file);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) oIX0oI2.toArray(new StandardOpenOption[0]);
            OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
            newOutputStream = Files.newOutputStream(resolve, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
            IIX0o.oO(newOutputStream, "newOutputStream(this, *options)");
            return Okio.sink(newOutputStream);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException("no such file: " + file);
        }
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    @OXOo.OOXIXo
    public Source source(@OXOo.OOXIXo Path file) {
        InputStream newInputStream;
        IIX0o.x0xO0oo(file, "file");
        try {
            newInputStream = Files.newInputStream(resolve(file), (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0));
            IIX0o.oO(newInputStream, "newInputStream(this, *options)");
            return Okio.source(newInputStream);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException("no such file: " + file);
        }
    }

    @Override // okio.NioSystemFileSystem, okio.JvmSystemFileSystem
    @OXOo.OOXIXo
    public String toString() {
        String xoXoI2 = IO.oxoX(this.nioFileSystem.getClass()).xoXoI();
        IIX0o.ooOOo0oXI(xoXoI2);
        return xoXoI2;
    }

    private final List<Path> list(Path path, boolean z) {
        boolean exists;
        java.nio.file.Path resolve = resolve(path);
        try {
            List x02 = OOXIxO0.x0(resolve, null, 1, null);
            ArrayList arrayList = new ArrayList();
            Iterator it = x02.iterator();
            while (it.hasNext()) {
                arrayList.add(Path.Companion.get$default(Path.Companion, X00IoxXI.oIX0oI(it.next()), false, 1, (Object) null));
            }
            o00.IoOoo(arrayList);
            return arrayList;
        } catch (Exception unused) {
            if (!z) {
                return null;
            }
            exists = Files.exists(resolve, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0));
            if (exists) {
                throw new IOException("failed to list " + path);
            }
            throw new FileNotFoundException("no such file: " + path);
        }
    }
}
