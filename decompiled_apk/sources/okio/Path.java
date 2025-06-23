package okio;

import XO0OX.x0XOIxOo;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nPath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Path.kt\nokio/Path\n+ 2 Path.kt\nokio/internal/-Path\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,132:1\n45#2,3:133\n53#2,28:136\n59#2,22:168\n112#2:190\n117#2:191\n122#2,6:192\n139#2,5:198\n149#2:203\n154#2,25:204\n194#2:229\n199#2,11:230\n204#2,6:241\n199#2,11:247\n204#2,6:258\n228#2,36:264\n268#2:300\n282#2:301\n287#2:302\n292#2:303\n297#2:304\n1549#3:164\n1620#3,3:165\n*S KotlinDebug\n*F\n+ 1 Path.kt\nokio/Path\n*L\n44#1:133,3\n47#1:136,28\n50#1:168,22\n53#1:190\n56#1:191\n60#1:192,6\n64#1:198,5\n68#1:203\n72#1:204,25\n75#1:229\n78#1:230,11\n81#1:241,6\n87#1:247,11\n90#1:258,6\n95#1:264,36\n97#1:300\n104#1:301\n106#1:302\n108#1:303\n110#1:304\n47#1:164\n47#1:165,3\n*E\n"})
/* loaded from: classes6.dex */
public final class Path implements Comparable<Path> {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final String DIRECTORY_SEPARATOR;

    @OXOo.OOXIXo
    private final ByteString bytes;

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ Path get$default(Companion companion, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.get(str, z);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        @XO0OX.xxIXOIIO(name = "get")
        @XO0OX.xoIox
        public final Path get(@OXOo.OOXIXo File file) {
            IIX0o.x0xO0oo(file, "<this>");
            return get$default(this, file, false, 1, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ Path get$default(Companion companion, File file, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.get(file, z);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        @XO0OX.xxIXOIIO(name = "get")
        @XO0OX.xoIox
        public final Path get(@OXOo.OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<this>");
            return get$default(this, str, false, 1, (Object) null);
        }

        public static /* synthetic */ Path get$default(Companion companion, java.nio.file.Path path, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.get(path, z);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        @XO0OX.xxIXOIIO(name = "get")
        @XO0OX.xoIox
        public final Path get(@OXOo.OOXIXo java.nio.file.Path path) {
            IIX0o.x0xO0oo(path, "<this>");
            return get$default(this, path, false, 1, (Object) null);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        @XO0OX.xxIXOIIO(name = "get")
        @XO0OX.xoIox
        public final Path get(@OXOo.OOXIXo String str, boolean z) {
            IIX0o.x0xO0oo(str, "<this>");
            return okio.internal.Path.commonToPath(str, z);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        @XO0OX.xxIXOIIO(name = "get")
        @XO0OX.xoIox
        public final Path get(@OXOo.OOXIXo File file, boolean z) {
            IIX0o.x0xO0oo(file, "<this>");
            String file2 = file.toString();
            IIX0o.oO(file2, "toString(...)");
            return get(file2, z);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        @XO0OX.xxIXOIIO(name = "get")
        @XO0OX.xoIox
        public final Path get(@OXOo.OOXIXo java.nio.file.Path path, boolean z) {
            IIX0o.x0xO0oo(path, "<this>");
            return get(path.toString(), z);
        }
    }

    static {
        String separator = File.separator;
        IIX0o.oO(separator, "separator");
        DIRECTORY_SEPARATOR = separator;
    }

    public Path(@OXOo.OOXIXo ByteString bytes) {
        IIX0o.x0xO0oo(bytes, "bytes");
        this.bytes = bytes;
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "get")
    @XO0OX.xoIox
    public static final Path get(@OXOo.OOXIXo File file) {
        return Companion.get(file);
    }

    public static /* synthetic */ Path resolve$default(Path path, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return path.resolve(str, z);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if ((obj instanceof Path) && IIX0o.Oxx0IOOO(((Path) obj).getBytes$okio(), getBytes$okio())) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public final ByteString getBytes$okio() {
        return this.bytes;
    }

    @OXOo.oOoXoXO
    public final Path getRoot() {
        int access$rootLength = okio.internal.Path.access$rootLength(this);
        if (access$rootLength == -1) {
            return null;
        }
        return new Path(getBytes$okio().substring(0, access$rootLength));
    }

    @OXOo.OOXIXo
    public final List<String> getSegments() {
        ArrayList arrayList = new ArrayList();
        int access$rootLength = okio.internal.Path.access$rootLength(this);
        if (access$rootLength == -1) {
            access$rootLength = 0;
        } else if (access$rootLength < getBytes$okio().size() && getBytes$okio().getByte(access$rootLength) == 92) {
            access$rootLength++;
        }
        int size = getBytes$okio().size();
        int i = access$rootLength;
        while (access$rootLength < size) {
            if (getBytes$okio().getByte(access$rootLength) == 47 || getBytes$okio().getByte(access$rootLength) == 92) {
                arrayList.add(getBytes$okio().substring(i, access$rootLength));
                i = access$rootLength + 1;
            }
            access$rootLength++;
        }
        if (i < getBytes$okio().size()) {
            arrayList.add(getBytes$okio().substring(i, getBytes$okio().size()));
        }
        ArrayList arrayList2 = new ArrayList(OxxIIOOXO.xo0x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ByteString) it.next()).utf8());
        }
        return arrayList2;
    }

    @OXOo.OOXIXo
    public final List<ByteString> getSegmentsBytes() {
        ArrayList arrayList = new ArrayList();
        int access$rootLength = okio.internal.Path.access$rootLength(this);
        if (access$rootLength == -1) {
            access$rootLength = 0;
        } else if (access$rootLength < getBytes$okio().size() && getBytes$okio().getByte(access$rootLength) == 92) {
            access$rootLength++;
        }
        int size = getBytes$okio().size();
        int i = access$rootLength;
        while (access$rootLength < size) {
            if (getBytes$okio().getByte(access$rootLength) == 47 || getBytes$okio().getByte(access$rootLength) == 92) {
                arrayList.add(getBytes$okio().substring(i, access$rootLength));
                i = access$rootLength + 1;
            }
            access$rootLength++;
        }
        if (i < getBytes$okio().size()) {
            arrayList.add(getBytes$okio().substring(i, getBytes$okio().size()));
        }
        return arrayList;
    }

    public int hashCode() {
        return getBytes$okio().hashCode();
    }

    public final boolean isAbsolute() {
        if (okio.internal.Path.access$rootLength(this) != -1) {
            return true;
        }
        return false;
    }

    public final boolean isRelative() {
        if (okio.internal.Path.access$rootLength(this) == -1) {
            return true;
        }
        return false;
    }

    public final boolean isRoot() {
        if (okio.internal.Path.access$rootLength(this) == getBytes$okio().size()) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "name")
    public final String name() {
        return nameBytes().utf8();
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "nameBytes")
    public final ByteString nameBytes() {
        int access$getIndexOfLastSlash = okio.internal.Path.access$getIndexOfLastSlash(this);
        if (access$getIndexOfLastSlash != -1) {
            return ByteString.substring$default(getBytes$okio(), access$getIndexOfLastSlash + 1, 0, 2, null);
        }
        if (volumeLetter() != null && getBytes$okio().size() == 2) {
            return ByteString.EMPTY;
        }
        return getBytes$okio();
    }

    @OXOo.OOXIXo
    public final Path normalized() {
        return Companion.get(toString(), true);
    }

    @XO0OX.xxIXOIIO(name = "parent")
    @OXOo.oOoXoXO
    public final Path parent() {
        Path path;
        if (IIX0o.Oxx0IOOO(getBytes$okio(), okio.internal.Path.access$getDOT$p()) || IIX0o.Oxx0IOOO(getBytes$okio(), okio.internal.Path.access$getSLASH$p()) || IIX0o.Oxx0IOOO(getBytes$okio(), okio.internal.Path.access$getBACKSLASH$p()) || okio.internal.Path.access$lastSegmentIsDotDot(this)) {
            return null;
        }
        int access$getIndexOfLastSlash = okio.internal.Path.access$getIndexOfLastSlash(this);
        if (access$getIndexOfLastSlash == 2 && volumeLetter() != null) {
            if (getBytes$okio().size() == 3) {
                return null;
            }
            path = new Path(ByteString.substring$default(getBytes$okio(), 0, 3, 1, null));
        } else {
            if (access$getIndexOfLastSlash == 1 && getBytes$okio().startsWith(okio.internal.Path.access$getBACKSLASH$p())) {
                return null;
            }
            if (access$getIndexOfLastSlash == -1 && volumeLetter() != null) {
                if (getBytes$okio().size() == 2) {
                    return null;
                }
                path = new Path(ByteString.substring$default(getBytes$okio(), 0, 2, 1, null));
            } else {
                if (access$getIndexOfLastSlash == -1) {
                    return new Path(okio.internal.Path.access$getDOT$p());
                }
                if (access$getIndexOfLastSlash == 0) {
                    path = new Path(ByteString.substring$default(getBytes$okio(), 0, 1, 1, null));
                } else {
                    return new Path(ByteString.substring$default(getBytes$okio(), 0, access$getIndexOfLastSlash, 1, null));
                }
            }
        }
        return path;
    }

    @OXOo.OOXIXo
    public final Path relativeTo(@OXOo.OOXIXo Path other) {
        IIX0o.x0xO0oo(other, "other");
        if (IIX0o.Oxx0IOOO(getRoot(), other.getRoot())) {
            List<ByteString> segmentsBytes = getSegmentsBytes();
            List<ByteString> segmentsBytes2 = other.getSegmentsBytes();
            int min = Math.min(segmentsBytes.size(), segmentsBytes2.size());
            int i = 0;
            while (i < min && IIX0o.Oxx0IOOO(segmentsBytes.get(i), segmentsBytes2.get(i))) {
                i++;
            }
            if (i == min && getBytes$okio().size() == other.getBytes$okio().size()) {
                return Companion.get$default(Companion, FileUtils.FILE_EXTENSION_SEPARATOR, false, 1, (Object) null);
            }
            if (segmentsBytes2.subList(i, segmentsBytes2.size()).indexOf(okio.internal.Path.access$getDOT_DOT$p()) == -1) {
                Buffer buffer = new Buffer();
                ByteString access$getSlash = okio.internal.Path.access$getSlash(other);
                if (access$getSlash == null && (access$getSlash = okio.internal.Path.access$getSlash(this)) == null) {
                    access$getSlash = okio.internal.Path.access$toSlash(DIRECTORY_SEPARATOR);
                }
                int size = segmentsBytes2.size();
                for (int i2 = i; i2 < size; i2++) {
                    buffer.write(okio.internal.Path.access$getDOT_DOT$p());
                    buffer.write(access$getSlash);
                }
                int size2 = segmentsBytes.size();
                while (i < size2) {
                    buffer.write(segmentsBytes.get(i));
                    buffer.write(access$getSlash);
                    i++;
                }
                return okio.internal.Path.toPath(buffer, false);
            }
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + other).toString());
        }
        throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + other).toString());
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "resolve")
    public final Path resolve(@OXOo.OOXIXo Path child) {
        IIX0o.x0xO0oo(child, "child");
        return okio.internal.Path.commonResolve(this, child, false);
    }

    @OXOo.OOXIXo
    public final File toFile() {
        return new File(toString());
    }

    @OXOo.OOXIXo
    public final java.nio.file.Path toNioPath() {
        java.nio.file.Path path;
        path = Paths.get(toString(), new String[0]);
        IIX0o.oO(path, "get(...)");
        return path;
    }

    @OXOo.OOXIXo
    public String toString() {
        return getBytes$okio().utf8();
    }

    @XO0OX.xxIXOIIO(name = "volumeLetter")
    @OXOo.oOoXoXO
    public final Character volumeLetter() {
        if (ByteString.indexOf$default(getBytes$okio(), okio.internal.Path.access$getSLASH$p(), 0, 2, (Object) null) != -1 || getBytes$okio().size() < 2 || getBytes$okio().getByte(1) != 58) {
            return null;
        }
        char c = (char) getBytes$okio().getByte(0);
        if (('a' > c || c >= '{') && ('A' > c || c >= '[')) {
            return null;
        }
        return Character.valueOf(c);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "get")
    @XO0OX.xoIox
    public static final Path get(@OXOo.OOXIXo File file, boolean z) {
        return Companion.get(file, z);
    }

    public static /* synthetic */ Path resolve$default(Path path, ByteString byteString, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return path.resolve(byteString, z);
    }

    @Override // java.lang.Comparable
    public int compareTo(@OXOo.OOXIXo Path other) {
        IIX0o.x0xO0oo(other, "other");
        return getBytes$okio().compareTo(other.getBytes$okio());
    }

    @OXOo.OOXIXo
    public final Path resolve(@OXOo.OOXIXo Path child, boolean z) {
        IIX0o.x0xO0oo(child, "child");
        return okio.internal.Path.commonResolve(this, child, z);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "get")
    @XO0OX.xoIox
    public static final Path get(@OXOo.OOXIXo String str) {
        return Companion.get(str);
    }

    public static /* synthetic */ Path resolve$default(Path path, Path path2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return path.resolve(path2, z);
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "resolve")
    public final Path resolve(@OXOo.OOXIXo String child) {
        IIX0o.x0xO0oo(child, "child");
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(new Buffer().writeUtf8(child), false), false);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "get")
    @XO0OX.xoIox
    public static final Path get(@OXOo.OOXIXo String str, boolean z) {
        return Companion.get(str, z);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "get")
    @XO0OX.xoIox
    public static final Path get(@OXOo.OOXIXo java.nio.file.Path path) {
        return Companion.get(path);
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "resolve")
    public final Path resolve(@OXOo.OOXIXo ByteString child) {
        IIX0o.x0xO0oo(child, "child");
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(new Buffer().write(child), false), false);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "get")
    @XO0OX.xoIox
    public static final Path get(@OXOo.OOXIXo java.nio.file.Path path, boolean z) {
        return Companion.get(path, z);
    }

    @OXOo.OOXIXo
    public final Path resolve(@OXOo.OOXIXo String child, boolean z) {
        IIX0o.x0xO0oo(child, "child");
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(new Buffer().writeUtf8(child), false), z);
    }

    @OXOo.OOXIXo
    public final Path resolve(@OXOo.OOXIXo ByteString child, boolean z) {
        IIX0o.x0xO0oo(child, "child");
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(new Buffer().write(child), false), z);
    }
}
