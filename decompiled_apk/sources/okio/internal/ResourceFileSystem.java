package okio.internal;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import Oox.oOoXoXO;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.Xo0;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;
import okio.internal.ResourceFileSystem;

@XX({"SMAP\nResourceFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResourceFileSystem.kt\nokio/internal/ResourceFileSystem\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,210:1\n766#2:211\n857#2,2:212\n1549#2:214\n1620#2,3:215\n766#2:218\n857#2,2:219\n1549#2:221\n1620#2,3:222\n1603#2,9:225\n1855#2:234\n1856#2:236\n1612#2:237\n1603#2,9:238\n1855#2:247\n1856#2:249\n1612#2:250\n1#3:235\n1#3:248\n*S KotlinDebug\n*F\n+ 1 ResourceFileSystem.kt\nokio/internal/ResourceFileSystem\n*L\n74#1:211\n74#1:212,2\n75#1:214\n75#1:215,3\n90#1:218\n90#1:219,2\n91#1:221\n91#1:222,3\n173#1:225,9\n173#1:234\n173#1:236\n173#1:237\n174#1:238,9\n174#1:247\n174#1:249\n174#1:250\n173#1:235\n174#1:248\n*E\n"})
/* loaded from: classes6.dex */
public final class ResourceFileSystem extends FileSystem {

    @OOXIXo
    private static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final Path ROOT = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);

    @OOXIXo
    private final ClassLoader classLoader;

    @OOXIXo
    private final X0IIOO roots$delegate;

    @OOXIXo
    private final FileSystem systemFileSystem;

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean keepPath(Path path) {
            return !OxI.IxX00(path.name(), ".class", true);
        }

        @OOXIXo
        public final Path getROOT() {
            return ResourceFileSystem.ROOT;
        }

        @OOXIXo
        public final Path removeBase(@OOXIXo Path path, @OOXIXo Path base) {
            IIX0o.x0xO0oo(path, "<this>");
            IIX0o.x0xO0oo(base, "base");
            return getROOT().resolve(OxI.oXO0oOx0(StringsKt__StringsKt.OoI0OO(path.toString(), base.toString()), '\\', IOUtils.DIR_SEPARATOR_UNIX, false, 4, null));
        }

        private Companion() {
        }
    }

    public /* synthetic */ ResourceFileSystem(ClassLoader classLoader, boolean z, FileSystem fileSystem, int i, IIXOooo iIXOooo) {
        this(classLoader, z, (i & 4) != 0 ? FileSystem.SYSTEM : fileSystem);
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    private final List<Pair<FileSystem, Path>> getRoots() {
        return (List) this.roots$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Pair<FileSystem, Path>> toClasspathRoots(ClassLoader classLoader) {
        Enumeration<URL> resources = classLoader.getResources("");
        IIX0o.oO(resources, "getResources(...)");
        ArrayList<URL> list = Collections.list(resources);
        IIX0o.oO(list, "list(this)");
        ArrayList arrayList = new ArrayList();
        for (URL url : list) {
            IIX0o.ooOOo0oXI(url);
            Pair<FileSystem, Path> fileRoot = toFileRoot(url);
            if (fileRoot != null) {
                arrayList.add(fileRoot);
            }
        }
        Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
        IIX0o.oO(resources2, "getResources(...)");
        ArrayList<URL> list2 = Collections.list(resources2);
        IIX0o.oO(list2, "list(this)");
        ArrayList arrayList2 = new ArrayList();
        for (URL url2 : list2) {
            IIX0o.ooOOo0oXI(url2);
            Pair<FileSystem, Path> jarRoot = toJarRoot(url2);
            if (jarRoot != null) {
                arrayList2.add(jarRoot);
            }
        }
        return CollectionsKt___CollectionsKt.o0xIIX0(arrayList, arrayList2);
    }

    private final Pair<FileSystem, Path> toFileRoot(URL url) {
        if (!IIX0o.Oxx0IOOO(url.getProtocol(), "file")) {
            return null;
        }
        return Xo0.oIX0oI(this.systemFileSystem, Path.Companion.get$default(Path.Companion, new File(url.toURI()), false, 1, (Object) null));
    }

    private final Pair<FileSystem, Path> toJarRoot(URL url) {
        int xxxoo0XI2;
        String url2 = url.toString();
        IIX0o.oO(url2, "toString(...)");
        if (!OxI.IOOoXo0Ix(url2, "jar:file:", false, 2, null) || (xxxoo0XI2 = StringsKt__StringsKt.xxxoo0XI(url2, "!", 0, false, 6, null)) == -1) {
            return null;
        }
        Path.Companion companion = Path.Companion;
        String substring = url2.substring(4, xxxoo0XI2);
        IIX0o.oO(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return Xo0.oIX0oI(ZipFilesKt.openZip(Path.Companion.get$default(companion, new File(URI.create(substring)), false, 1, (Object) null), this.systemFileSystem, new oOoXoXO<ZipEntry, Boolean>() { // from class: okio.internal.ResourceFileSystem$toJarRoot$zip$1
            @Override // Oox.oOoXoXO
            @OOXIXo
            public final Boolean invoke(@OOXIXo ZipEntry entry) {
                ResourceFileSystem.Companion companion2;
                IIX0o.x0xO0oo(entry, "entry");
                companion2 = ResourceFileSystem.Companion;
                return Boolean.valueOf(companion2.keepPath(entry.getCanonicalPath()));
            }
        }), ROOT);
    }

    private final String toRelativePath(Path path) {
        return canonicalizeInternal(path).relativeTo(ROOT).toString();
    }

    @Override // okio.FileSystem
    @OOXIXo
    public Sink appendingSink(@OOXIXo Path file, boolean z) {
        IIX0o.x0xO0oo(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void atomicMove(@OOXIXo Path source, @OOXIXo Path target) {
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(target, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    @OOXIXo
    public Path canonicalize(@OOXIXo Path path) {
        IIX0o.x0xO0oo(path, "path");
        return canonicalizeInternal(path);
    }

    @Override // okio.FileSystem
    public void createDirectory(@OOXIXo Path dir, boolean z) {
        IIX0o.x0xO0oo(dir, "dir");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void createSymlink(@OOXIXo Path source, @OOXIXo Path target) {
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(target, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void delete(@OOXIXo Path path, boolean z) {
        IIX0o.x0xO0oo(path, "path");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    @OOXIXo
    public List<Path> list(@OOXIXo Path dir) {
        IIX0o.x0xO0oo(dir, "dir");
        String relativePath = toRelativePath(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z = false;
        for (Pair<FileSystem, Path> pair : getRoots()) {
            FileSystem component1 = pair.component1();
            Path component2 = pair.component2();
            try {
                List<Path> list = component1.list(component2.resolve(relativePath));
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (Companion.keepPath((Path) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(OxxIIOOXO.xo0x(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Companion.removeBase((Path) it.next(), component2));
                }
                kotlin.collections.OxI.XIo0oOXIx(linkedHashSet, arrayList2);
                z = true;
            } catch (IOException unused) {
            }
        }
        if (z) {
            return CollectionsKt___CollectionsKt.oOo0o(linkedHashSet);
        }
        throw new FileNotFoundException("file not found: " + dir);
    }

    @Override // okio.FileSystem
    @OXOo.oOoXoXO
    public List<Path> listOrNull(@OOXIXo Path dir) {
        IIX0o.x0xO0oo(dir, "dir");
        String relativePath = toRelativePath(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Pair<FileSystem, Path>> it = getRoots().iterator();
        boolean z = false;
        while (true) {
            ArrayList arrayList = null;
            if (!it.hasNext()) {
                break;
            }
            Pair<FileSystem, Path> next = it.next();
            FileSystem component1 = next.component1();
            Path component2 = next.component2();
            List<Path> listOrNull = component1.listOrNull(component2.resolve(relativePath));
            if (listOrNull != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listOrNull) {
                    if (Companion.keepPath((Path) obj)) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = new ArrayList(OxxIIOOXO.xo0x(arrayList2, 10));
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(Companion.removeBase((Path) it2.next(), component2));
                }
                arrayList = arrayList3;
            }
            if (arrayList != null) {
                kotlin.collections.OxI.XIo0oOXIx(linkedHashSet, arrayList);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return CollectionsKt___CollectionsKt.oOo0o(linkedHashSet);
    }

    @Override // okio.FileSystem
    @OXOo.oOoXoXO
    public FileMetadata metadataOrNull(@OOXIXo Path path) {
        IIX0o.x0xO0oo(path, "path");
        if (!Companion.keepPath(path)) {
            return null;
        }
        String relativePath = toRelativePath(path);
        for (Pair<FileSystem, Path> pair : getRoots()) {
            FileMetadata metadataOrNull = pair.component1().metadataOrNull(pair.component2().resolve(relativePath));
            if (metadataOrNull != null) {
                return metadataOrNull;
            }
        }
        return null;
    }

    @Override // okio.FileSystem
    @OOXIXo
    public FileHandle openReadOnly(@OOXIXo Path file) {
        IIX0o.x0xO0oo(file, "file");
        if (Companion.keepPath(file)) {
            String relativePath = toRelativePath(file);
            for (Pair<FileSystem, Path> pair : getRoots()) {
                try {
                    return pair.component1().openReadOnly(pair.component2().resolve(relativePath));
                } catch (FileNotFoundException unused) {
                }
            }
            throw new FileNotFoundException("file not found: " + file);
        }
        throw new FileNotFoundException("file not found: " + file);
    }

    @Override // okio.FileSystem
    @OOXIXo
    public FileHandle openReadWrite(@OOXIXo Path file, boolean z, boolean z2) {
        IIX0o.x0xO0oo(file, "file");
        throw new IOException("resources are not writable");
    }

    @Override // okio.FileSystem
    @OOXIXo
    public Sink sink(@OOXIXo Path file, boolean z) {
        IIX0o.x0xO0oo(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    @OOXIXo
    public Source source(@OOXIXo Path file) {
        Source source;
        IIX0o.x0xO0oo(file, "file");
        if (Companion.keepPath(file)) {
            Path path = ROOT;
            InputStream resourceAsStream = this.classLoader.getResourceAsStream(Path.resolve$default(path, file, false, 2, (Object) null).relativeTo(path).toString());
            if (resourceAsStream != null && (source = Okio.source(resourceAsStream)) != null) {
                return source;
            }
            throw new FileNotFoundException("file not found: " + file);
        }
        throw new FileNotFoundException("file not found: " + file);
    }

    public ResourceFileSystem(@OOXIXo ClassLoader classLoader, boolean z, @OOXIXo FileSystem systemFileSystem) {
        IIX0o.x0xO0oo(classLoader, "classLoader");
        IIX0o.x0xO0oo(systemFileSystem, "systemFileSystem");
        this.classLoader = classLoader;
        this.systemFileSystem = systemFileSystem;
        this.roots$delegate = XIxXXX0x0.oIX0oI(new oIX0oI<List<? extends Pair<? extends FileSystem, ? extends Path>>>() { // from class: okio.internal.ResourceFileSystem$roots$2
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OOXIXo
            public final List<? extends Pair<? extends FileSystem, ? extends Path>> invoke() {
                ClassLoader classLoader2;
                List<? extends Pair<? extends FileSystem, ? extends Path>> classpathRoots;
                ResourceFileSystem resourceFileSystem = ResourceFileSystem.this;
                classLoader2 = resourceFileSystem.classLoader;
                classpathRoots = resourceFileSystem.toClasspathRoots(classLoader2);
                return classpathRoots;
            }
        });
        if (z) {
            getRoots().size();
        }
    }
}
