package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io;

import XXO0.oIX0oI;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.Beta;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtIncompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicate;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeTraverser;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.SuccessorsFunction;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Traverser;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.ByteSource;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.NullableDecl;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemException;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;

@Beta
@GwtIncompatible
/* loaded from: classes10.dex */
public final class MoreFiles {
    private static final SuccessorsFunction<Path> FILE_TREE = new SuccessorsFunction<Path>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.MoreFiles.1
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.SuccessorsFunction
        public /* bridge */ /* synthetic */ Iterable<? extends Path> successors(Path path) {
            return successors2(X00IoxXI.oIX0oI(path));
        }

        /* renamed from: successors, reason: avoid collision after fix types in other method */
        public Iterable<Path> successors2(Path path) {
            return MoreFiles.fileTreeChildren(path);
        }
    };

    /* loaded from: classes10.dex */
    public static final class DirectoryTreeTraverser extends TreeTraverser<Path> {
        private static final DirectoryTreeTraverser INSTANCE = new DirectoryTreeTraverser();

        private DirectoryTreeTraverser() {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeTraverser
        public /* bridge */ /* synthetic */ Iterable<Path> children(Path path) {
            return children2(X00IoxXI.oIX0oI(path));
        }

        /* renamed from: children, reason: avoid collision after fix types in other method */
        public Iterable<Path> children2(Path path) {
            return MoreFiles.fileTreeChildren(path);
        }
    }

    /* loaded from: classes10.dex */
    public static final class PathByteSink extends ByteSink {
        private final OpenOption[] options;
        private final Path path;

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.ByteSink
        public OutputStream openStream() throws IOException {
            OutputStream newOutputStream;
            newOutputStream = java.nio.file.Files.newOutputStream(this.path, this.options);
            return newOutputStream;
        }

        public String toString() {
            return "MoreFiles.asByteSink(" + this.path + ", " + Arrays.toString(this.options) + oIX0oI.I0Io.f4095I0Io;
        }

        private PathByteSink(Path path, OpenOption... openOptionArr) {
            this.path = X00IoxXI.oIX0oI(Preconditions.checkNotNull(path));
            this.options = (OpenOption[]) openOptionArr.clone();
        }
    }

    /* loaded from: classes10.dex */
    public static final class PathByteSource extends ByteSource {
        private static final LinkOption[] FOLLOW_LINKS = new LinkOption[0];
        private final boolean followLinks;
        private final OpenOption[] options;
        private final Path path;

        private static boolean followLinks(OpenOption[] openOptionArr) {
            LinkOption linkOption;
            for (OpenOption openOption : openOptionArr) {
                linkOption = LinkOption.NOFOLLOW_LINKS;
                if (openOption == linkOption) {
                    return false;
                }
            }
            return true;
        }

        private BasicFileAttributes readAttributes() throws IOException {
            LinkOption[] linkOptionArr;
            LinkOption linkOption;
            BasicFileAttributes readAttributes;
            Path path = this.path;
            Class oIX0oI2 = I0oOoX.oIX0oI();
            if (!this.followLinks) {
                linkOption = LinkOption.NOFOLLOW_LINKS;
                linkOptionArr = new LinkOption[]{linkOption};
            } else {
                linkOptionArr = FOLLOW_LINKS;
            }
            readAttributes = java.nio.file.Files.readAttributes(path, (Class<BasicFileAttributes>) oIX0oI2, linkOptionArr);
            return readAttributes;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.ByteSource
        public CharSource asCharSource(Charset charset) {
            if (this.options.length == 0) {
                return new ByteSource.AsCharSource(charset) { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.MoreFiles.PathByteSource.1
                    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.CharSource
                    public Stream<String> lines() throws IOException {
                        Stream<String> lines;
                        lines = java.nio.file.Files.lines(PathByteSource.this.path, this.charset);
                        return lines;
                    }
                };
            }
            return super.asCharSource(charset);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            InputStream newInputStream;
            newInputStream = java.nio.file.Files.newInputStream(this.path, this.options);
            return newInputStream;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.ByteSource
        public byte[] read() throws IOException {
            SeekableByteChannel newByteChannel;
            long size;
            newByteChannel = java.nio.file.Files.newByteChannel(this.path, this.options);
            try {
                InputStream newInputStream = Channels.newInputStream(newByteChannel);
                size = newByteChannel.size();
                byte[] readFile = Files.readFile(newInputStream, size);
                if (newByteChannel != null) {
                    newByteChannel.close();
                }
                return readFile;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (newByteChannel != null) {
                        try {
                            newByteChannel.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.ByteSource
        public long size() throws IOException {
            boolean isDirectory;
            boolean isSymbolicLink;
            long size;
            BasicFileAttributes readAttributes = readAttributes();
            isDirectory = readAttributes.isDirectory();
            if (!isDirectory) {
                isSymbolicLink = readAttributes.isSymbolicLink();
                if (!isSymbolicLink) {
                    size = readAttributes.size();
                    return size;
                }
                throw new IOException("can't read: is a symbolic link");
            }
            throw new IOException("can't read: is a directory");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            boolean isDirectory;
            boolean isSymbolicLink;
            long size;
            try {
                BasicFileAttributes readAttributes = readAttributes();
                isDirectory = readAttributes.isDirectory();
                if (!isDirectory) {
                    isSymbolicLink = readAttributes.isSymbolicLink();
                    if (!isSymbolicLink) {
                        size = readAttributes.size();
                        return Optional.of(Long.valueOf(size));
                    }
                }
                return Optional.absent();
            } catch (IOException unused) {
                return Optional.absent();
            }
        }

        public String toString() {
            return "MoreFiles.asByteSource(" + this.path + ", " + Arrays.toString(this.options) + oIX0oI.I0Io.f4095I0Io;
        }

        private PathByteSource(Path path, OpenOption... openOptionArr) {
            this.path = X00IoxXI.oIX0oI(Preconditions.checkNotNull(path));
            OpenOption[] openOptionArr2 = (OpenOption[]) openOptionArr.clone();
            this.options = openOptionArr2;
            this.followLinks = followLinks(openOptionArr2);
        }
    }

    private MoreFiles() {
    }

    private static Collection<IOException> addException(@NullableDecl Collection<IOException> collection, IOException iOException) {
        if (collection == null) {
            collection = new ArrayList<>();
        }
        collection.add(iOException);
        return collection;
    }

    public static ByteSink asByteSink(Path path, OpenOption... openOptionArr) {
        return new PathByteSink(path, openOptionArr);
    }

    public static ByteSource asByteSource(Path path, OpenOption... openOptionArr) {
        return new PathByteSource(path, openOptionArr);
    }

    public static CharSink asCharSink(Path path, Charset charset, OpenOption... openOptionArr) {
        return asByteSink(path, openOptionArr).asCharSink(charset);
    }

    public static CharSource asCharSource(Path path, Charset charset, OpenOption... openOptionArr) {
        return asByteSource(path, openOptionArr).asCharSource(charset);
    }

    private static void checkAllowsInsecure(Path path, RecursiveDeleteOption[] recursiveDeleteOptionArr) throws InsecureRecursiveDeleteException {
        String path2;
        if (!Arrays.asList(recursiveDeleteOptionArr).contains(RecursiveDeleteOption.ALLOW_INSECURE)) {
            path2 = path.toString();
            throw new InsecureRecursiveDeleteException(path2);
        }
    }

    @NullableDecl
    private static Collection<IOException> concat(@NullableDecl Collection<IOException> collection, @NullableDecl Collection<IOException> collection2) {
        if (collection == null) {
            return collection2;
        }
        if (collection2 != null) {
            collection.addAll(collection2);
        }
        return collection;
    }

    public static void createParentDirectories(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Path absolutePath;
        Path normalize;
        Path parent;
        boolean isDirectory;
        boolean isDirectory2;
        absolutePath = path.toAbsolutePath();
        normalize = absolutePath.normalize();
        parent = normalize.getParent();
        if (parent != null) {
            isDirectory = java.nio.file.Files.isDirectory(parent, new LinkOption[0]);
            if (!isDirectory) {
                java.nio.file.Files.createDirectories(parent, fileAttributeArr);
                isDirectory2 = java.nio.file.Files.isDirectory(parent, new LinkOption[0]);
                if (!isDirectory2) {
                    throw new IOException("Unable to create parent directories of " + path);
                }
            }
        }
    }

    public static void deleteDirectoryContents(Path path, RecursiveDeleteOption... recursiveDeleteOptionArr) throws IOException {
        DirectoryStream newDirectoryStream;
        Collection<IOException> deleteDirectoryContentsInsecure;
        Collection<IOException> collection = null;
        try {
            newDirectoryStream = java.nio.file.Files.newDirectoryStream(path);
            try {
                if (OxI.oIX0oI(newDirectoryStream)) {
                    deleteDirectoryContentsInsecure = deleteDirectoryContentsSecure(O0xOxO.oIX0oI(newDirectoryStream));
                } else {
                    checkAllowsInsecure(path, recursiveDeleteOptionArr);
                    deleteDirectoryContentsInsecure = deleteDirectoryContentsInsecure(newDirectoryStream);
                }
                collection = deleteDirectoryContentsInsecure;
                if (newDirectoryStream != null) {
                    newDirectoryStream.close();
                }
            } finally {
            }
        } catch (IOException e) {
            if (0 != 0) {
                collection.add(e);
            } else {
                throw e;
            }
        }
        if (collection != null) {
            throwDeleteFailed(path, collection);
        }
    }

    @NullableDecl
    private static Collection<IOException> deleteDirectoryContentsInsecure(DirectoryStream<Path> directoryStream) {
        IOException cause;
        Iterator it;
        Collection<IOException> collection = null;
        try {
            it = directoryStream.iterator();
            while (it.hasNext()) {
                collection = concat(collection, deleteRecursivelyInsecure(X00IoxXI.oIX0oI(it.next())));
            }
            return collection;
        } catch (DirectoryIteratorException e) {
            cause = e.getCause();
            return addException(collection, cause);
        }
    }

    @NullableDecl
    private static Collection<IOException> deleteDirectoryContentsSecure(SecureDirectoryStream<Path> secureDirectoryStream) {
        IOException cause;
        Iterator it;
        Path fileName;
        Collection<IOException> collection = null;
        try {
            it = secureDirectoryStream.iterator();
            while (it.hasNext()) {
                fileName = X00IoxXI.oIX0oI(it.next()).getFileName();
                collection = concat(collection, deleteRecursivelySecure(secureDirectoryStream, fileName));
            }
            return collection;
        } catch (DirectoryIteratorException e) {
            cause = e.getCause();
            return addException(collection, cause);
        }
    }

    public static void deleteRecursively(Path path, RecursiveDeleteOption... recursiveDeleteOptionArr) throws IOException {
        DirectoryStream newDirectoryStream;
        boolean z;
        Path fileName;
        String path2;
        Path parentPath = getParentPath(path);
        Collection<IOException> collection = null;
        if (parentPath != null) {
            try {
                newDirectoryStream = java.nio.file.Files.newDirectoryStream(parentPath);
                try {
                    if (OxI.oIX0oI(newDirectoryStream)) {
                        SecureDirectoryStream oIX0oI2 = O0xOxO.oIX0oI(newDirectoryStream);
                        fileName = path.getFileName();
                        collection = deleteRecursivelySecure(oIX0oI2, fileName);
                        z = true;
                    } else {
                        z = false;
                    }
                    if (newDirectoryStream != null) {
                        newDirectoryStream.close();
                    }
                    if (!z) {
                        checkAllowsInsecure(path, recursiveDeleteOptionArr);
                        collection = deleteRecursivelyInsecure(path);
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } finally {
                    }
                }
            } catch (IOException e) {
                if (collection != null) {
                    collection.add(e);
                } else {
                    throw e;
                }
            }
            if (collection != null) {
                throwDeleteFailed(path, collection);
                return;
            }
            return;
        }
        ooXIXxIX.oIX0oI();
        path2 = path.toString();
        throw IIX0o.oIX0oI(path2, null, "can't delete recursively");
    }

    @NullableDecl
    private static Collection<IOException> deleteRecursivelyInsecure(Path path) {
        LinkOption linkOption;
        boolean isDirectory;
        DirectoryStream newDirectoryStream;
        Collection<IOException> collection = null;
        try {
            linkOption = LinkOption.NOFOLLOW_LINKS;
            isDirectory = java.nio.file.Files.isDirectory(path, linkOption);
            if (isDirectory) {
                newDirectoryStream = java.nio.file.Files.newDirectoryStream(path);
                try {
                    collection = deleteDirectoryContentsInsecure(newDirectoryStream);
                    if (newDirectoryStream != null) {
                        newDirectoryStream.close();
                    }
                } finally {
                }
            }
            if (collection == null) {
                java.nio.file.Files.delete(path);
            }
            return collection;
        } catch (IOException e) {
            return addException(collection, e);
        }
    }

    @NullableDecl
    private static Collection<IOException> deleteRecursivelySecure(SecureDirectoryStream<Path> secureDirectoryStream, Path path) {
        LinkOption linkOption;
        LinkOption linkOption2;
        SecureDirectoryStream newDirectoryStream;
        Collection<IOException> collection = null;
        try {
            linkOption = LinkOption.NOFOLLOW_LINKS;
            if (isDirectory(secureDirectoryStream, path, linkOption)) {
                linkOption2 = LinkOption.NOFOLLOW_LINKS;
                newDirectoryStream = secureDirectoryStream.newDirectoryStream(path, linkOption2);
                try {
                    collection = deleteDirectoryContentsSecure(newDirectoryStream);
                    if (newDirectoryStream != null) {
                        newDirectoryStream.close();
                    }
                    if (collection == null) {
                        secureDirectoryStream.deleteDirectory(path);
                    }
                } finally {
                }
            } else {
                secureDirectoryStream.deleteFile(path);
            }
            return collection;
        } catch (IOException e) {
            return addException(collection, e);
        }
    }

    @Deprecated
    public static TreeTraverser<Path> directoryTreeTraverser() {
        return DirectoryTreeTraverser.INSTANCE;
    }

    public static boolean equal(Path path, Path path2) throws IOException {
        boolean isSameFile;
        Preconditions.checkNotNull(path);
        Preconditions.checkNotNull(path2);
        isSameFile = java.nio.file.Files.isSameFile(path, path2);
        if (isSameFile) {
            return true;
        }
        ByteSource asByteSource = asByteSource(path, new OpenOption[0]);
        ByteSource asByteSource2 = asByteSource(path2, new OpenOption[0]);
        long longValue = asByteSource.sizeIfKnown().or((Optional<Long>) 0L).longValue();
        long longValue2 = asByteSource2.sizeIfKnown().or((Optional<Long>) 0L).longValue();
        if (longValue != 0 && longValue2 != 0 && longValue != longValue2) {
            return false;
        }
        return asByteSource.contentEquals(asByteSource2);
    }

    public static Traverser<Path> fileTraverser() {
        return Traverser.forTree(FILE_TREE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Iterable<Path> fileTreeChildren(Path path) {
        LinkOption linkOption;
        boolean isDirectory;
        linkOption = LinkOption.NOFOLLOW_LINKS;
        isDirectory = java.nio.file.Files.isDirectory(path, linkOption);
        if (isDirectory) {
            try {
                return listFiles(path);
            } catch (IOException e) {
                throw xI.oIX0oI(e);
            }
        }
        return ImmutableList.of();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0009, code lost:
    
        r3 = r3.toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getFileExtension(java.nio.file.Path r3) {
        /*
            java.nio.file.Path r3 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.XI0IXoo.oIX0oI(r3)
            java.lang.String r0 = ""
            if (r3 != 0) goto L9
            return r0
        L9:
            java.lang.String r3 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.x0xO0oo.oIX0oI(r3)
            r1 = 46
            int r1 = r3.lastIndexOf(r1)
            r2 = -1
            if (r1 != r2) goto L17
            goto L1d
        L17:
            int r1 = r1 + 1
            java.lang.String r0 = r3.substring(r1)
        L1d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.MoreFiles.getFileExtension(java.nio.file.Path):java.lang.String");
    }

    public static String getNameWithoutExtension(Path path) {
        Path fileName;
        String path2;
        fileName = path.getFileName();
        if (fileName != null) {
            path2 = fileName.toString();
            int lastIndexOf = path2.lastIndexOf(46);
            if (lastIndexOf != -1) {
                return path2.substring(0, lastIndexOf);
            }
            return path2;
        }
        return "";
    }

    @NullableDecl
    private static Path getParentPath(Path path) {
        Path parent;
        int nameCount;
        FileSystem fileSystem;
        Path path2;
        parent = path.getParent();
        if (parent == null) {
            nameCount = path.getNameCount();
            if (nameCount != 0) {
                fileSystem = path.getFileSystem();
                path2 = fileSystem.getPath(FileUtils.FILE_EXTENSION_SEPARATOR, new String[0]);
                return path2;
            }
            return null;
        }
        return parent;
    }

    public static Predicate<Path> isDirectory(LinkOption... linkOptionArr) {
        final LinkOption[] linkOptionArr2 = (LinkOption[]) linkOptionArr.clone();
        return new Predicate<Path>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.MoreFiles.2
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicate
            public /* bridge */ /* synthetic */ boolean apply(Path path) {
                return apply2(X00IoxXI.oIX0oI(path));
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicate, java.util.function.Predicate
            public /* synthetic */ boolean test(Object obj) {
                return com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.II0xO0.oIX0oI(this, obj);
            }

            public String toString() {
                return "MoreFiles.isDirectory(" + Arrays.toString(linkOptionArr2) + oIX0oI.I0Io.f4095I0Io;
            }

            /* renamed from: apply, reason: avoid collision after fix types in other method */
            public boolean apply2(Path path) {
                boolean isDirectory;
                isDirectory = java.nio.file.Files.isDirectory(path, linkOptionArr2);
                return isDirectory;
            }
        };
    }

    public static Predicate<Path> isRegularFile(LinkOption... linkOptionArr) {
        final LinkOption[] linkOptionArr2 = (LinkOption[]) linkOptionArr.clone();
        return new Predicate<Path>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.MoreFiles.3
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicate
            public /* bridge */ /* synthetic */ boolean apply(Path path) {
                return apply2(X00IoxXI.oIX0oI(path));
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicate, java.util.function.Predicate
            public /* synthetic */ boolean test(Object obj) {
                return com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.II0xO0.oIX0oI(this, obj);
            }

            public String toString() {
                return "MoreFiles.isRegularFile(" + Arrays.toString(linkOptionArr2) + oIX0oI.I0Io.f4095I0Io;
            }

            /* renamed from: apply, reason: avoid collision after fix types in other method */
            public boolean apply2(Path path) {
                boolean isRegularFile;
                isRegularFile = java.nio.file.Files.isRegularFile(path, linkOptionArr2);
                return isRegularFile;
            }
        };
    }

    public static ImmutableList<Path> listFiles(Path path) throws IOException {
        IOException cause;
        DirectoryStream newDirectoryStream;
        try {
            newDirectoryStream = java.nio.file.Files.newDirectoryStream(path);
            try {
                ImmutableList<Path> copyOf = ImmutableList.copyOf(newDirectoryStream);
                if (newDirectoryStream != null) {
                    newDirectoryStream.close();
                }
                return copyOf;
            } finally {
            }
        } catch (DirectoryIteratorException e) {
            cause = e.getCause();
            throw cause;
        }
    }

    private static void throwDeleteFailed(Path path, Collection<IOException> collection) throws FileSystemException {
        String path2;
        ooXIXxIX.oIX0oI();
        path2 = path.toString();
        FileSystemException oIX0oI2 = IIX0o.oIX0oI(path2, null, "failed to delete one or more files; see suppressed exceptions for details");
        Iterator<IOException> it = collection.iterator();
        while (it.hasNext()) {
            oIX0oI2.addSuppressed(it.next());
        }
        throw oIX0oI2;
    }

    public static void touch(Path path) throws IOException {
        FileTime fromMillis;
        Preconditions.checkNotNull(path);
        try {
            fromMillis = FileTime.fromMillis(System.currentTimeMillis());
            java.nio.file.Files.setLastModifiedTime(path, fromMillis);
        } catch (NoSuchFileException unused) {
            try {
                java.nio.file.Files.createFile(path, new FileAttribute[0]);
            } catch (FileAlreadyExistsException unused2) {
            }
        }
    }

    private static boolean isDirectory(SecureDirectoryStream<Path> secureDirectoryStream, Path path, LinkOption... linkOptionArr) throws IOException {
        FileAttributeView fileAttributeView;
        BasicFileAttributes readAttributes;
        boolean isDirectory;
        fileAttributeView = secureDirectoryStream.getFileAttributeView(path, X0IIOO.oIX0oI(), linkOptionArr);
        readAttributes = xxX.oIX0oI(fileAttributeView).readAttributes();
        isDirectory = readAttributes.isDirectory();
        return isDirectory;
    }
}
