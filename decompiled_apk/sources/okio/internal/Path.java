package okio.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxI;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import okio.Buffer;
import okio.ByteString;
import okio.Path;

@xxIXOIIO(name = "-Path")
@XX({"SMAP\nPath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Path.kt\nokio/internal/-Path\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,406:1\n59#1,22:407\n209#1:433\n209#1:434\n1549#2:429\n1620#2,3:430\n*S KotlinDebug\n*F\n+ 1 Path.kt\nokio/internal/-Path\n*L\n53#1:407,22\n199#1:433\n204#1:434\n53#1:429\n53#1:430,3\n*E\n"})
/* renamed from: okio.internal.-Path */
/* loaded from: classes6.dex */
public final class Path {

    @OOXIXo
    private static final ByteString ANY_SLASH;

    @OOXIXo
    private static final ByteString BACKSLASH;

    @OOXIXo
    private static final ByteString DOT;

    @OOXIXo
    private static final ByteString DOT_DOT;

    @OOXIXo
    private static final ByteString SLASH;

    static {
        ByteString.Companion companion = ByteString.Companion;
        SLASH = companion.encodeUtf8("/");
        BACKSLASH = companion.encodeUtf8("\\");
        ANY_SLASH = companion.encodeUtf8("/\\");
        DOT = companion.encodeUtf8(FileUtils.FILE_EXTENSION_SEPARATOR);
        DOT_DOT = companion.encodeUtf8("..");
    }

    public static final int commonCompareTo(@OOXIXo okio.Path path, @OOXIXo okio.Path other) {
        IIX0o.x0xO0oo(path, "<this>");
        IIX0o.x0xO0oo(other, "other");
        return path.getBytes$okio().compareTo(other.getBytes$okio());
    }

    public static final boolean commonEquals(@OOXIXo okio.Path path, @oOoXoXO Object obj) {
        IIX0o.x0xO0oo(path, "<this>");
        if ((obj instanceof okio.Path) && IIX0o.Oxx0IOOO(((okio.Path) obj).getBytes$okio(), path.getBytes$okio())) {
            return true;
        }
        return false;
    }

    public static final int commonHashCode(@OOXIXo okio.Path path) {
        IIX0o.x0xO0oo(path, "<this>");
        return path.getBytes$okio().hashCode();
    }

    public static final boolean commonIsAbsolute(@OOXIXo okio.Path path) {
        IIX0o.x0xO0oo(path, "<this>");
        if (rootLength(path) != -1) {
            return true;
        }
        return false;
    }

    public static final boolean commonIsRelative(@OOXIXo okio.Path path) {
        IIX0o.x0xO0oo(path, "<this>");
        if (rootLength(path) == -1) {
            return true;
        }
        return false;
    }

    public static final boolean commonIsRoot(@OOXIXo okio.Path path) {
        IIX0o.x0xO0oo(path, "<this>");
        if (rootLength(path) == path.getBytes$okio().size()) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public static final String commonName(@OOXIXo okio.Path path) {
        IIX0o.x0xO0oo(path, "<this>");
        return path.nameBytes().utf8();
    }

    @OOXIXo
    public static final ByteString commonNameBytes(@OOXIXo okio.Path path) {
        IIX0o.x0xO0oo(path, "<this>");
        int indexOfLastSlash = getIndexOfLastSlash(path);
        if (indexOfLastSlash != -1) {
            return ByteString.substring$default(path.getBytes$okio(), indexOfLastSlash + 1, 0, 2, null);
        }
        if (path.volumeLetter() != null && path.getBytes$okio().size() == 2) {
            return ByteString.EMPTY;
        }
        return path.getBytes$okio();
    }

    @OOXIXo
    public static final okio.Path commonNormalized(@OOXIXo okio.Path path) {
        IIX0o.x0xO0oo(path, "<this>");
        return okio.Path.Companion.get(path.toString(), true);
    }

    @oOoXoXO
    public static final okio.Path commonParent(@OOXIXo okio.Path path) {
        IIX0o.x0xO0oo(path, "<this>");
        if (!IIX0o.Oxx0IOOO(path.getBytes$okio(), DOT) && !IIX0o.Oxx0IOOO(path.getBytes$okio(), SLASH) && !IIX0o.Oxx0IOOO(path.getBytes$okio(), BACKSLASH) && !lastSegmentIsDotDot(path)) {
            int indexOfLastSlash = getIndexOfLastSlash(path);
            if (indexOfLastSlash == 2 && path.volumeLetter() != null) {
                if (path.getBytes$okio().size() == 3) {
                    return null;
                }
                return new okio.Path(ByteString.substring$default(path.getBytes$okio(), 0, 3, 1, null));
            }
            if (indexOfLastSlash == 1 && path.getBytes$okio().startsWith(BACKSLASH)) {
                return null;
            }
            if (indexOfLastSlash == -1 && path.volumeLetter() != null) {
                if (path.getBytes$okio().size() == 2) {
                    return null;
                }
                return new okio.Path(ByteString.substring$default(path.getBytes$okio(), 0, 2, 1, null));
            }
            if (indexOfLastSlash == -1) {
                return new okio.Path(DOT);
            }
            if (indexOfLastSlash == 0) {
                return new okio.Path(ByteString.substring$default(path.getBytes$okio(), 0, 1, 1, null));
            }
            return new okio.Path(ByteString.substring$default(path.getBytes$okio(), 0, indexOfLastSlash, 1, null));
        }
        return null;
    }

    @OOXIXo
    public static final okio.Path commonRelativeTo(@OOXIXo okio.Path path, @OOXIXo okio.Path other) {
        IIX0o.x0xO0oo(path, "<this>");
        IIX0o.x0xO0oo(other, "other");
        if (IIX0o.Oxx0IOOO(path.getRoot(), other.getRoot())) {
            List<ByteString> segmentsBytes = path.getSegmentsBytes();
            List<ByteString> segmentsBytes2 = other.getSegmentsBytes();
            int min = Math.min(segmentsBytes.size(), segmentsBytes2.size());
            int i = 0;
            while (i < min && IIX0o.Oxx0IOOO(segmentsBytes.get(i), segmentsBytes2.get(i))) {
                i++;
            }
            if (i == min && path.getBytes$okio().size() == other.getBytes$okio().size()) {
                return Path.Companion.get$default(okio.Path.Companion, FileUtils.FILE_EXTENSION_SEPARATOR, false, 1, (Object) null);
            }
            if (segmentsBytes2.subList(i, segmentsBytes2.size()).indexOf(DOT_DOT) == -1) {
                Buffer buffer = new Buffer();
                ByteString slash = getSlash(other);
                if (slash == null && (slash = getSlash(path)) == null) {
                    slash = toSlash(okio.Path.DIRECTORY_SEPARATOR);
                }
                int size = segmentsBytes2.size();
                for (int i2 = i; i2 < size; i2++) {
                    buffer.write(DOT_DOT);
                    buffer.write(slash);
                }
                int size2 = segmentsBytes.size();
                while (i < size2) {
                    buffer.write(segmentsBytes.get(i));
                    buffer.write(slash);
                    i++;
                }
                return toPath(buffer, false);
            }
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + path + " and " + other).toString());
        }
        throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + path + " and " + other).toString());
    }

    @OOXIXo
    public static final okio.Path commonResolve(@OOXIXo okio.Path path, @OOXIXo String child, boolean z) {
        IIX0o.x0xO0oo(path, "<this>");
        IIX0o.x0xO0oo(child, "child");
        return commonResolve(path, toPath(new Buffer().writeUtf8(child), false), z);
    }

    @oOoXoXO
    public static final okio.Path commonRoot(@OOXIXo okio.Path path) {
        IIX0o.x0xO0oo(path, "<this>");
        int rootLength = rootLength(path);
        if (rootLength == -1) {
            return null;
        }
        return new okio.Path(path.getBytes$okio().substring(0, rootLength));
    }

    @OOXIXo
    public static final List<String> commonSegments(@OOXIXo okio.Path path) {
        IIX0o.x0xO0oo(path, "<this>");
        ArrayList arrayList = new ArrayList();
        int rootLength = rootLength(path);
        if (rootLength == -1) {
            rootLength = 0;
        } else if (rootLength < path.getBytes$okio().size() && path.getBytes$okio().getByte(rootLength) == 92) {
            rootLength++;
        }
        int size = path.getBytes$okio().size();
        int i = rootLength;
        while (rootLength < size) {
            if (path.getBytes$okio().getByte(rootLength) == 47 || path.getBytes$okio().getByte(rootLength) == 92) {
                arrayList.add(path.getBytes$okio().substring(i, rootLength));
                i = rootLength + 1;
            }
            rootLength++;
        }
        if (i < path.getBytes$okio().size()) {
            arrayList.add(path.getBytes$okio().substring(i, path.getBytes$okio().size()));
        }
        ArrayList arrayList2 = new ArrayList(OxxIIOOXO.xo0x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ByteString) it.next()).utf8());
        }
        return arrayList2;
    }

    @OOXIXo
    public static final List<ByteString> commonSegmentsBytes(@OOXIXo okio.Path path) {
        IIX0o.x0xO0oo(path, "<this>");
        ArrayList arrayList = new ArrayList();
        int rootLength = rootLength(path);
        if (rootLength == -1) {
            rootLength = 0;
        } else if (rootLength < path.getBytes$okio().size() && path.getBytes$okio().getByte(rootLength) == 92) {
            rootLength++;
        }
        int size = path.getBytes$okio().size();
        int i = rootLength;
        while (rootLength < size) {
            if (path.getBytes$okio().getByte(rootLength) == 47 || path.getBytes$okio().getByte(rootLength) == 92) {
                arrayList.add(path.getBytes$okio().substring(i, rootLength));
                i = rootLength + 1;
            }
            rootLength++;
        }
        if (i < path.getBytes$okio().size()) {
            arrayList.add(path.getBytes$okio().substring(i, path.getBytes$okio().size()));
        }
        return arrayList;
    }

    @OOXIXo
    public static final okio.Path commonToPath(@OOXIXo String str, boolean z) {
        IIX0o.x0xO0oo(str, "<this>");
        return toPath(new Buffer().writeUtf8(str), z);
    }

    @OOXIXo
    public static final String commonToString(@OOXIXo okio.Path path) {
        IIX0o.x0xO0oo(path, "<this>");
        return path.getBytes$okio().utf8();
    }

    @oOoXoXO
    public static final Character commonVolumeLetter(@OOXIXo okio.Path path) {
        IIX0o.x0xO0oo(path, "<this>");
        if (ByteString.indexOf$default(path.getBytes$okio(), SLASH, 0, 2, (Object) null) != -1 || path.getBytes$okio().size() < 2 || path.getBytes$okio().getByte(1) != 58) {
            return null;
        }
        char c = (char) path.getBytes$okio().getByte(0);
        if (('a' > c || c >= '{') && ('A' > c || c >= '[')) {
            return null;
        }
        return Character.valueOf(c);
    }

    private static /* synthetic */ void getANY_SLASH$annotations() {
    }

    private static /* synthetic */ void getBACKSLASH$annotations() {
    }

    private static /* synthetic */ void getDOT$annotations() {
    }

    private static /* synthetic */ void getDOT_DOT$annotations() {
    }

    public static final int getIndexOfLastSlash(okio.Path path) {
        int lastIndexOf$default = ByteString.lastIndexOf$default(path.getBytes$okio(), SLASH, 0, 2, (Object) null);
        if (lastIndexOf$default != -1) {
            return lastIndexOf$default;
        }
        return ByteString.lastIndexOf$default(path.getBytes$okio(), BACKSLASH, 0, 2, (Object) null);
    }

    private static /* synthetic */ void getSLASH$annotations() {
    }

    public static final ByteString getSlash(okio.Path path) {
        ByteString bytes$okio = path.getBytes$okio();
        ByteString byteString = SLASH;
        if (ByteString.indexOf$default(bytes$okio, byteString, 0, 2, (Object) null) == -1) {
            ByteString bytes$okio2 = path.getBytes$okio();
            ByteString byteString2 = BACKSLASH;
            if (ByteString.indexOf$default(bytes$okio2, byteString2, 0, 2, (Object) null) == -1) {
                return null;
            }
            return byteString2;
        }
        return byteString;
    }

    public static final boolean lastSegmentIsDotDot(okio.Path path) {
        if (!path.getBytes$okio().endsWith(DOT_DOT) || (path.getBytes$okio().size() != 2 && !path.getBytes$okio().rangeEquals(path.getBytes$okio().size() - 3, SLASH, 0, 1) && !path.getBytes$okio().rangeEquals(path.getBytes$okio().size() - 3, BACKSLASH, 0, 1))) {
            return false;
        }
        return true;
    }

    public static final int rootLength(okio.Path path) {
        if (path.getBytes$okio().size() == 0) {
            return -1;
        }
        if (path.getBytes$okio().getByte(0) == 47) {
            return 1;
        }
        if (path.getBytes$okio().getByte(0) == 92) {
            if (path.getBytes$okio().size() <= 2 || path.getBytes$okio().getByte(1) != 92) {
                return 1;
            }
            int indexOf = path.getBytes$okio().indexOf(BACKSLASH, 2);
            if (indexOf == -1) {
                return path.getBytes$okio().size();
            }
            return indexOf;
        }
        if (path.getBytes$okio().size() > 2 && path.getBytes$okio().getByte(1) == 58 && path.getBytes$okio().getByte(2) == 92) {
            char c = (char) path.getBytes$okio().getByte(0);
            if ('a' > c || c >= '{') {
                if ('A' <= c && c < '[') {
                    return 3;
                }
            } else {
                return 3;
            }
        }
        return -1;
    }

    private static final boolean startsWithVolumeLetterAndColon(Buffer buffer, ByteString byteString) {
        if (!IIX0o.Oxx0IOOO(byteString, BACKSLASH) || buffer.size() < 2 || buffer.getByte(1L) != 58) {
            return false;
        }
        char c = (char) buffer.getByte(0L);
        if (('a' > c || c >= '{') && ('A' > c || c >= '[')) {
            return false;
        }
        return true;
    }

    @OOXIXo
    public static final okio.Path toPath(@OOXIXo Buffer buffer, boolean z) {
        ByteString byteString;
        boolean z2;
        boolean z3;
        ByteString readByteString;
        IIX0o.x0xO0oo(buffer, "<this>");
        Buffer buffer2 = new Buffer();
        ByteString byteString2 = null;
        int i = 0;
        while (true) {
            if (!buffer.rangeEquals(0L, SLASH)) {
                byteString = BACKSLASH;
                if (!buffer.rangeEquals(0L, byteString)) {
                    break;
                }
            }
            byte readByte = buffer.readByte();
            if (byteString2 == null) {
                byteString2 = toSlash(readByte);
            }
            i++;
        }
        if (i >= 2 && IIX0o.Oxx0IOOO(byteString2, byteString)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            IIX0o.ooOOo0oXI(byteString2);
            buffer2.write(byteString2);
            buffer2.write(byteString2);
        } else if (i > 0) {
            IIX0o.ooOOo0oXI(byteString2);
            buffer2.write(byteString2);
        } else {
            long indexOfElement = buffer.indexOfElement(ANY_SLASH);
            if (byteString2 == null) {
                if (indexOfElement == -1) {
                    byteString2 = toSlash(okio.Path.DIRECTORY_SEPARATOR);
                } else {
                    byteString2 = toSlash(buffer.getByte(indexOfElement));
                }
            }
            if (startsWithVolumeLetterAndColon(buffer, byteString2)) {
                if (indexOfElement == 2) {
                    buffer2.write(buffer, 3L);
                } else {
                    buffer2.write(buffer, 2L);
                }
            }
        }
        if (buffer2.size() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        ArrayList arrayList = new ArrayList();
        while (!buffer.exhausted()) {
            long indexOfElement2 = buffer.indexOfElement(ANY_SLASH);
            if (indexOfElement2 == -1) {
                readByteString = buffer.readByteString();
            } else {
                readByteString = buffer.readByteString(indexOfElement2);
                buffer.readByte();
            }
            ByteString byteString3 = DOT_DOT;
            if (IIX0o.Oxx0IOOO(readByteString, byteString3)) {
                if (!z3 || !arrayList.isEmpty()) {
                    if (z && (z3 || (!arrayList.isEmpty() && !IIX0o.Oxx0IOOO(CollectionsKt___CollectionsKt.O0O0Io00X(arrayList), byteString3)))) {
                        if (!z2 || arrayList.size() != 1) {
                            OxI.xI0oxI00(arrayList);
                        }
                    } else {
                        arrayList.add(readByteString);
                    }
                }
            } else if (!IIX0o.Oxx0IOOO(readByteString, DOT) && !IIX0o.Oxx0IOOO(readByteString, ByteString.EMPTY)) {
                arrayList.add(readByteString);
            }
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                buffer2.write(byteString2);
            }
            buffer2.write((ByteString) arrayList.get(i2));
        }
        if (buffer2.size() == 0) {
            buffer2.write(DOT);
        }
        return new okio.Path(buffer2.readByteString());
    }

    public static final ByteString toSlash(String str) {
        if (IIX0o.Oxx0IOOO(str, "/")) {
            return SLASH;
        }
        if (IIX0o.Oxx0IOOO(str, "\\")) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException("not a directory separator: " + str);
    }

    @OOXIXo
    public static final okio.Path commonResolve(@OOXIXo okio.Path path, @OOXIXo ByteString child, boolean z) {
        IIX0o.x0xO0oo(path, "<this>");
        IIX0o.x0xO0oo(child, "child");
        return commonResolve(path, toPath(new Buffer().write(child), false), z);
    }

    private static final ByteString toSlash(byte b) {
        if (b == 47) {
            return SLASH;
        }
        if (b == 92) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException("not a directory separator: " + ((int) b));
    }

    @OOXIXo
    public static final okio.Path commonResolve(@OOXIXo okio.Path path, @OOXIXo Buffer child, boolean z) {
        IIX0o.x0xO0oo(path, "<this>");
        IIX0o.x0xO0oo(child, "child");
        return commonResolve(path, toPath(child, false), z);
    }

    @OOXIXo
    public static final okio.Path commonResolve(@OOXIXo okio.Path path, @OOXIXo okio.Path child, boolean z) {
        IIX0o.x0xO0oo(path, "<this>");
        IIX0o.x0xO0oo(child, "child");
        if (child.isAbsolute() || child.volumeLetter() != null) {
            return child;
        }
        ByteString slash = getSlash(path);
        if (slash == null && (slash = getSlash(child)) == null) {
            slash = toSlash(okio.Path.DIRECTORY_SEPARATOR);
        }
        Buffer buffer = new Buffer();
        buffer.write(path.getBytes$okio());
        if (buffer.size() > 0) {
            buffer.write(slash);
        }
        buffer.write(child.getBytes$okio());
        return toPath(buffer, z);
    }
}
