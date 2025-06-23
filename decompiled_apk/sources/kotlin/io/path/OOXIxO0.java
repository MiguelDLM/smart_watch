package kotlin.io.path;

import androidx.exifinterface.media.ExifInterface;
import com.goodix.ble.gr.libdfu.BuildConfig;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.DeprecationLevel;
import kotlin.IIX0;
import kotlin.KotlinNothingValueException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.oXIO0o0XI;
import kotlin.text.StringsKt__StringsKt;

@kotlin.jvm.internal.XX({"SMAP\nPathUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathUtils.kt\nkotlin/io/path/PathsKt__PathUtilsKt\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1174:1\n26#2:1175\n26#2:1179\n1#3:1176\n1855#4,2:1177\n*S KotlinDebug\n*F\n+ 1 PathUtils.kt\nkotlin/io/path/PathsKt__PathUtilsKt\n*L\n221#1:1175\n616#1:1179\n440#1:1177,2\n*E\n"})
/* loaded from: classes6.dex */
public class OOXIxO0 extends PathsKt__PathRecursiveFunctionsKt {
    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final boolean I0(Path path, LinkOption... options) {
        boolean exists;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        exists = Files.exists(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        return exists;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final String I0X0x0oIo(Path path) {
        Path absolutePath;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        absolutePath = path.toAbsolutePath();
        return absolutePath.toString();
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    @xx0o0O.XO
    public static final Path I0oOIX(Path path, FileAttribute<?>... attributes) throws IOException {
        Path createDirectory;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(attributes, "attributes");
        createDirectory = Files.createDirectory(path, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.IIX0o.oO(createDirectory, "createDirectory(...)");
        return createDirectory;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final Path I0xX0(Path path, String attribute, Object obj, LinkOption... options) throws IOException {
        Path attribute2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(attribute, "attribute");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        attribute2 = Files.setAttribute(path, attribute, obj, (LinkOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.IIX0o.oO(attribute2, "setAttribute(...)");
        return attribute2;
    }

    @OXOo.OOXIXo
    public static final String IIX0(@OXOo.OOXIXo Path path) {
        Path fileName;
        String obj;
        String O0OoXI2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        fileName = path.getFileName();
        if (fileName == null || (obj = fileName.toString()) == null || (O0OoXI2 = StringsKt__StringsKt.O0OoXI(obj, '.', "")) == null) {
            return "";
        }
        return O0OoXI2;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final Path IIxOXoOo0(Path path, Path other) {
        Path resolve;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        resolve = path.resolve(other);
        kotlin.jvm.internal.IIX0o.oO(resolve, "resolve(...)");
        return resolve;
    }

    public static /* synthetic */ Path IO0XoXxO(Path path, Path target, boolean z, int i, Object obj) throws IOException {
        CopyOption[] copyOptionArr;
        Path move;
        StandardCopyOption standardCopyOption;
        if ((i & 2) != 0) {
            z = false;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(target, "target");
        if (z) {
            standardCopyOption = StandardCopyOption.REPLACE_EXISTING;
            copyOptionArr = new CopyOption[]{standardCopyOption};
        } else {
            copyOptionArr = new CopyOption[0];
        }
        move = Files.move(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        kotlin.jvm.internal.IIX0o.oO(move, "move(...)");
        return move;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final Path IOoo(Path path) throws IOException {
        Path readSymbolicLink;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        readSymbolicLink = Files.readSymbolicLink(path);
        kotlin.jvm.internal.IIX0o.oO(readSymbolicLink, "readSymbolicLink(...)");
        return readSymbolicLink;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final boolean IXO(Path path) {
        boolean isExecutable;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        isExecutable = Files.isExecutable(path);
        return isExecutable;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final FileTime IoIOOxIIo(Path path, LinkOption... options) throws IOException {
        FileTime lastModifiedTime;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        lastModifiedTime = Files.getLastModifiedTime(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.IIX0o.oO(lastModifiedTime, "getLastModifiedTime(...)");
        return lastModifiedTime;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.9")
    public static final Path IoOoo(@OXOo.OOXIXo Path path, @OXOo.OOXIXo FileAttribute<?>... attributes) throws IOException {
        Path parent;
        boolean isDirectory;
        boolean isDirectory2;
        Path createDirectories;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(attributes, "attributes");
        parent = path.getParent();
        if (parent != null) {
            isDirectory = Files.isDirectory(parent, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0));
            if (!isDirectory) {
                try {
                    FileAttribute[] fileAttributeArr = (FileAttribute[]) Arrays.copyOf(attributes, attributes.length);
                    createDirectories = Files.createDirectories(parent, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
                    kotlin.jvm.internal.IIX0o.oO(createDirectories, "createDirectories(...)");
                } catch (FileAlreadyExistsException e) {
                    isDirectory2 = Files.isDirectory(parent, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0));
                    if (!isDirectory2) {
                        throw e;
                    }
                }
            }
        }
        return path;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final boolean IoXIXo(Path path, Path other) throws IOException {
        boolean isSameFile;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        isSameFile = Files.isSameFile(path, other);
        return isSameFile;
    }

    public static /* synthetic */ Path Ioxxx(Path path, String str, FileAttribute[] fileAttributeArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            str = null;
        }
        return OO0x0xX(path, str, fileAttributeArr);
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final boolean Ix00oIoI(Path path) {
        boolean isReadable;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        isReadable = Files.isReadable(path);
        return isReadable;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    @xx0o0O.XO
    public static final Set<PosixFilePermission> IxIX0I(Path path, LinkOption... options) throws IOException {
        Set<PosixFilePermission> posixFilePermissions;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        posixFilePermissions = Files.getPosixFilePermissions(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.IIX0o.oO(posixFilePermissions, "getPosixFilePermissions(...)");
        return posixFilePermissions;
    }

    @ooOOo0oXI
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @kotlin.XX(expression = "invariantSeparatorsPathString", imports = {}))
    @xx0o0O.XO
    public static /* synthetic */ void O0(Path path) {
    }

    @ooOOo0oXI
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.7")
    public static final kotlin.sequences.ooOOo0oXI<Path> O00(@OXOo.OOXIXo Path path, @OXOo.OOXIXo PathWalkOption... options) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        return new PathTreeWalk(path, options);
    }

    public static /* synthetic */ Path O00XxXI(Path path, String str, String str2, FileAttribute[] fileAttributeArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return XX0xXo(path, str, str2, fileAttributeArr);
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final boolean O0IxXx(Path path, LinkOption... options) {
        boolean isRegularFile;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        isRegularFile = Files.isRegularFile(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        return isRegularFile;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final Object O0X(Path path, String attribute, LinkOption... options) throws IOException {
        Object attribute2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(attribute, "attribute");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        attribute2 = Files.getAttribute(path, attribute, (LinkOption[]) Arrays.copyOf(options, options.length));
        return attribute2;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    @xx0o0O.XO
    public static final Path O0Xx(Path path, FileAttribute<?>... attributes) throws IOException {
        Path createDirectories;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(attributes, "attributes");
        createDirectories = Files.createDirectories(path, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.IIX0o.oO(createDirectories, "createDirectories(...)");
        return createDirectories;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final UserPrincipal OIOoIIOIx(Path path, LinkOption... options) throws IOException {
        UserPrincipal owner;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        owner = Files.getOwner(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        return owner;
    }

    @ooOOo0oXI
    @kotlin.oxxXoxO(version = "1.7")
    public static final void OIx00oxx(@OXOo.OOXIXo Path path, @OXOo.OOXIXo FileVisitor<Path> visitor, int i, boolean z) {
        Set OOXIXo2;
        FileVisitOption fileVisitOption;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(visitor, "visitor");
        if (z) {
            fileVisitOption = FileVisitOption.FOLLOW_LINKS;
            OOXIXo2 = kotlin.collections.oX.XO(fileVisitOption);
        } else {
            OOXIXo2 = kotlin.collections.Xo0.OOXIXo();
        }
        Files.walkFileTree(path, OOXIXo2, i, visitor);
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final Path OO(Path path, Path target) throws IOException {
        Path createLink;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(target, "target");
        createLink = Files.createLink(path, target);
        kotlin.jvm.internal.IIX0o.oO(createLink, "createLink(...)");
        return createLink;
    }

    public static /* synthetic */ Object OO0(Path path, String glob, Oox.oOoXoXO block, int i, Object obj) throws IOException {
        DirectoryStream newDirectoryStream;
        if ((i & 1) != 0) {
            glob = "*";
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(glob, "glob");
        kotlin.jvm.internal.IIX0o.x0xO0oo(block, "block");
        newDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            DirectoryStream oIX0oI2 = Xx000oIo.oIX0oI(newDirectoryStream);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oIX0oI2);
            Object invoke = block.invoke(CollectionsKt___CollectionsKt.OooI(oIX0oI2));
            kotlin.jvm.internal.xxX.oxoX(1);
            if (xx0o0O.ooOOo0oXI.oIX0oI(1, 1, 0)) {
                kotlin.io.II0xO0.oIX0oI(newDirectoryStream, null);
            } else if (newDirectoryStream != null) {
                newDirectoryStream.close();
            }
            kotlin.jvm.internal.xxX.I0Io(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.xxX.oxoX(1);
                if (!xx0o0O.ooOOo0oXI.oIX0oI(1, 1, 0)) {
                    if (newDirectoryStream != null) {
                        try {
                            newDirectoryStream.close();
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    kotlin.io.II0xO0.oIX0oI(newDirectoryStream, th);
                }
                kotlin.jvm.internal.xxX.I0Io(1);
                throw th2;
            }
        }
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.5")
    public static final Path OO0x0xX(@OXOo.oOoXoXO Path path, @OXOo.oOoXoXO String str, @OXOo.OOXIXo FileAttribute<?>... attributes) throws IOException {
        Path createTempDirectory;
        Path createTempDirectory2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(attributes, "attributes");
        if (path != null) {
            createTempDirectory2 = Files.createTempDirectory(path, str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
            kotlin.jvm.internal.IIX0o.oO(createTempDirectory2, "createTempDirectory(...)");
            return createTempDirectory2;
        }
        createTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.IIX0o.oO(createTempDirectory, "createTempDirectory(...)");
        return createTempDirectory;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final Path OOXIxO0(Path path, String other) {
        Path resolve;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        resolve = path.resolve(other);
        kotlin.jvm.internal.IIX0o.oO(resolve, "resolve(...)");
        return resolve;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final Path OX(Path path, UserPrincipal value) throws IOException {
        Path owner;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        owner = Files.setOwner(path, value);
        kotlin.jvm.internal.IIX0o.oO(owner, "setOwner(...)");
        return owner;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final /* synthetic */ <V extends FileAttributeView> V OX00O0xII(Path path, LinkOption... options) {
        FileAttributeView fileAttributeView;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        kotlin.jvm.internal.IIX0o.OxI(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        fileAttributeView = Files.getFileAttributeView(path, Ioxxx.oIX0oI(), (LinkOption[]) Arrays.copyOf(options, options.length));
        return (V) fileAttributeView;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    public static /* synthetic */ void OoO(Path path) {
    }

    @ooOOo0oXI
    @kotlin.oxxXoxO(version = "1.7")
    public static final void OooI(@OXOo.OOXIXo Path path, int i, boolean z, @OXOo.OOXIXo Oox.oOoXoXO<? super x0XOIxOo, oXIO0o0XI> builderAction) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(builderAction, "builderAction");
        OIx00oxx(path, XIXIX(builderAction), i, z);
    }

    public static final String Ox0O(Path path) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        return xx0X0(path);
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final Path Oxx(Path path, FileTime value) throws IOException {
        Path lastModifiedTime;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        lastModifiedTime = Files.setLastModifiedTime(path, value);
        kotlin.jvm.internal.IIX0o.oO(lastModifiedTime, "setLastModifiedTime(...)");
        return lastModifiedTime;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final Path X0xII0I(Path path, Path target, boolean z) throws IOException {
        CopyOption[] copyOptionArr;
        Path move;
        StandardCopyOption standardCopyOption;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(target, "target");
        if (z) {
            standardCopyOption = StandardCopyOption.REPLACE_EXISTING;
            copyOptionArr = new CopyOption[]{standardCopyOption};
        } else {
            copyOptionArr = new CopyOption[0];
        }
        move = Files.move(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        kotlin.jvm.internal.IIX0o.oO(move, "move(...)");
        return move;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final Path X0xxXX0(Path path, Path target, CopyOption... options) throws IOException {
        Path move;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(target, "target");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        move = Files.move(path, target, (CopyOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.IIX0o.oO(move, "move(...)");
        return move;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    @xx0o0O.XO
    public static final Map<String, Object> XI(Path path, String attributes, LinkOption... options) throws IOException {
        Map<String, Object> readAttributes;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(attributes, "attributes");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        readAttributes = Files.readAttributes(path, attributes, (LinkOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.IIX0o.oO(readAttributes, "readAttributes(...)");
        return readAttributes;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final boolean XI0oooXX(Path path) throws IOException {
        boolean deleteIfExists;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        deleteIfExists = Files.deleteIfExists(path);
        return deleteIfExists;
    }

    @ooOOo0oXI
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.7")
    public static final FileVisitor<Path> XIXIX(@OXOo.OOXIXo Oox.oOoXoXO<? super x0XOIxOo, oXIO0o0XI> builderAction) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(builderAction, "builderAction");
        oO oOVar = new oO();
        builderAction.invoke(oOVar);
        return oOVar.X0o0xo();
    }

    @OXOo.OOXIXo
    public static final String XIXIxO(@OXOo.OOXIXo Path path) {
        Path fileName;
        String obj;
        String oOxxXI2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        fileName = path.getFileName();
        if (fileName == null || (obj = fileName.toString()) == null || (oOxxXI2 = StringsKt__StringsKt.oOxxXI(obj, FileUtils.FILE_EXTENSION_SEPARATOR, null, 2, null)) == null) {
            return "";
        }
        return oOxxXI2;
    }

    public static /* synthetic */ Path XIo0oOXIx(String str, FileAttribute[] attributes, int i, Object obj) throws IOException {
        Path createTempDirectory;
        if ((i & 1) != 0) {
            str = null;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(attributes, "attributes");
        createTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.IIX0o.oO(createTempDirectory, "createTempDirectory(...)");
        return createTempDirectory;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    @xx0o0O.XO
    public static final /* synthetic */ <A extends BasicFileAttributes> A XOxxooXI(Path path, LinkOption... options) throws IOException {
        BasicFileAttributes readAttributes;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        kotlin.jvm.internal.IIX0o.OxI(4, "A");
        readAttributes = Files.readAttributes(path, (Class<BasicFileAttributes>) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.I0oOoX.oIX0oI(), (LinkOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.IIX0o.oO(readAttributes, "readAttributes(...)");
        return (A) XX.oIX0oI(readAttributes);
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final Path XX0(Path path) {
        Path absolutePath;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        absolutePath = path.toAbsolutePath();
        kotlin.jvm.internal.IIX0o.oO(absolutePath, "toAbsolutePath(...)");
        return absolutePath;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.5")
    public static final Path XX0xXo(@OXOo.oOoXoXO Path path, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.OOXIXo FileAttribute<?>... attributes) throws IOException {
        Path createTempFile;
        Path createTempFile2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(attributes, "attributes");
        if (path != null) {
            createTempFile2 = Files.createTempFile(path, str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
            kotlin.jvm.internal.IIX0o.oO(createTempFile2, "createTempFile(...)");
            return createTempFile2;
        }
        createTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.IIX0o.oO(createTempFile, "createTempFile(...)");
        return createTempFile;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.5")
    public static final Path XXXI(@OXOo.OOXIXo Path path, @OXOo.OOXIXo Path base) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(base, "base");
        Path oXX0IoI2 = oXX0IoI(path, base);
        if (oXX0IoI2 != null) {
            return oXX0IoI2;
        }
        return path;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static /* synthetic */ void XXoOx0(Path path) {
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final Path Xo0(Path path, Path target, CopyOption... options) throws IOException {
        Path copy;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(target, "target");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        copy = Files.copy(path, target, (CopyOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.IIX0o.oO(copy, "copy(...)");
        return copy;
    }

    public static /* synthetic */ Path XoI0Ixx0(Path path, Path target, boolean z, int i, Object obj) throws IOException {
        CopyOption[] copyOptionArr;
        Path copy;
        StandardCopyOption standardCopyOption;
        if ((i & 2) != 0) {
            z = false;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(target, "target");
        if (z) {
            standardCopyOption = StandardCopyOption.REPLACE_EXISTING;
            copyOptionArr = new CopyOption[]{standardCopyOption};
        } else {
            copyOptionArr = new CopyOption[0];
        }
        copy = Files.copy(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        kotlin.jvm.internal.IIX0o.oO(copy, "copy(...)");
        return copy;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    @xx0o0O.XO
    public static final <T> T XoIxOXIXo(Path path, String glob, Oox.oOoXoXO<? super kotlin.sequences.ooOOo0oXI<? extends Path>, ? extends T> block) throws IOException {
        DirectoryStream newDirectoryStream;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(glob, "glob");
        kotlin.jvm.internal.IIX0o.x0xO0oo(block, "block");
        newDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            DirectoryStream oIX0oI2 = Xx000oIo.oIX0oI(newDirectoryStream);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oIX0oI2);
            T invoke = block.invoke(CollectionsKt___CollectionsKt.OooI(oIX0oI2));
            kotlin.jvm.internal.xxX.oxoX(1);
            if (xx0o0O.ooOOo0oXI.oIX0oI(1, 1, 0)) {
                kotlin.io.II0xO0.oIX0oI(newDirectoryStream, null);
            } else if (newDirectoryStream != null) {
                newDirectoryStream.close();
            }
            kotlin.jvm.internal.xxX.I0Io(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.xxX.oxoX(1);
                if (!xx0o0O.ooOOo0oXI.oIX0oI(1, 1, 0)) {
                    if (newDirectoryStream != null) {
                        try {
                            newDirectoryStream.close();
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    kotlin.io.II0xO0.oIX0oI(newDirectoryStream, th);
                }
                kotlin.jvm.internal.xxX.I0Io(1);
                throw th2;
            }
        }
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final Path o0IXXIx(URI uri) {
        Path path;
        kotlin.jvm.internal.IIX0o.x0xO0oo(uri, "<this>");
        path = Paths.get(uri);
        kotlin.jvm.internal.IIX0o.oO(path, "get(...)");
        return path;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    public static /* synthetic */ void o0oIxOo(Path path) {
    }

    public static /* synthetic */ Path o0xxxXXxX(String str, String str2, FileAttribute[] attributes, int i, Object obj) throws IOException {
        Path createTempFile;
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(attributes, "attributes");
        createTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.IIX0o.oO(createTempFile, "createTempFile(...)");
        return createTempFile;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final boolean oI(Path path) throws IOException {
        boolean isHidden;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        isHidden = Files.isHidden(path);
        return isHidden;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.5")
    public static final Path oIIxXoo(@OXOo.OOXIXo Path path, @OXOo.OOXIXo Path base) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(base, "base");
        try {
            return OxI.f29248oIX0oI.oIX0oI(path, base);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage() + "\nthis path: " + path + "\nbase path: " + base, e);
        }
    }

    public static /* synthetic */ void oOo(Path path, String glob, Oox.oOoXoXO action, int i, Object obj) throws IOException {
        DirectoryStream newDirectoryStream;
        if ((i & 1) != 0) {
            glob = "*";
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(glob, "glob");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        newDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            DirectoryStream oIX0oI2 = Xx000oIo.oIX0oI(newDirectoryStream);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oIX0oI2);
            Iterator it = oIX0oI2.iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            kotlin.jvm.internal.xxX.oxoX(1);
            if (xx0o0O.ooOOo0oXI.oIX0oI(1, 1, 0)) {
                kotlin.io.II0xO0.oIX0oI(newDirectoryStream, null);
            } else if (newDirectoryStream != null) {
                newDirectoryStream.close();
            }
            kotlin.jvm.internal.xxX.I0Io(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.xxX.oxoX(1);
                if (!xx0o0O.ooOOo0oXI.oIX0oI(1, 1, 0)) {
                    if (newDirectoryStream != null) {
                        try {
                            newDirectoryStream.close();
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    kotlin.io.II0xO0.oIX0oI(newDirectoryStream, th);
                }
                kotlin.jvm.internal.xxX.I0Io(1);
                throw th2;
            }
        }
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final boolean oOoIIO0(Path path, LinkOption... options) {
        boolean isDirectory;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        isDirectory = Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        return isDirectory;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final Path oX(Path path, Path target, boolean z) throws IOException {
        CopyOption[] copyOptionArr;
        Path copy;
        StandardCopyOption standardCopyOption;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(target, "target");
        if (z) {
            standardCopyOption = StandardCopyOption.REPLACE_EXISTING;
            copyOptionArr = new CopyOption[]{standardCopyOption};
        } else {
            copyOptionArr = new CopyOption[0];
        }
        copy = Files.copy(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        kotlin.jvm.internal.IIX0o.oO(copy, "copy(...)");
        return copy;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    @xx0o0O.XO
    public static final void oXIO0o0XI(Path path, String glob, Oox.oOoXoXO<? super Path, oXIO0o0XI> action) throws IOException {
        DirectoryStream newDirectoryStream;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(glob, "glob");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        newDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            DirectoryStream oIX0oI2 = Xx000oIo.oIX0oI(newDirectoryStream);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oIX0oI2);
            Iterator it = oIX0oI2.iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            kotlin.jvm.internal.xxX.oxoX(1);
            if (xx0o0O.ooOOo0oXI.oIX0oI(1, 1, 0)) {
                kotlin.io.II0xO0.oIX0oI(newDirectoryStream, null);
            } else if (newDirectoryStream != null) {
                newDirectoryStream.close();
            }
            kotlin.jvm.internal.xxX.I0Io(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.xxX.oxoX(1);
                if (!xx0o0O.ooOOo0oXI.oIX0oI(1, 1, 0)) {
                    if (newDirectoryStream != null) {
                        try {
                            newDirectoryStream.close();
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    kotlin.io.II0xO0.oIX0oI(newDirectoryStream, th);
                }
                kotlin.jvm.internal.xxX.I0Io(1);
                throw th2;
            }
        }
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    @xx0o0O.XO
    public static final Path oXIoO(Path path, Set<? extends PosixFilePermission> value) throws IOException {
        Path posixFilePermissions;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        posixFilePermissions = Files.setPosixFilePermissions(path, value);
        kotlin.jvm.internal.IIX0o.oO(posixFilePermissions, "setPosixFilePermissions(...)");
        return posixFilePermissions;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    @OXOo.oOoXoXO
    public static final Path oXX0IoI(@OXOo.OOXIXo Path path, @OXOo.OOXIXo Path base) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(base, "base");
        try {
            return OxI.f29248oIX0oI.oIX0oI(path, base);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final boolean oXxOI0oIx(Path path, LinkOption... options) {
        boolean notExists;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        notExists = Files.notExists(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        return notExists;
    }

    @OXOo.OOXIXo
    @kotlin.o0
    public static final Void ooOx(@OXOo.OOXIXo Path path, @OXOo.OOXIXo Class<?> attributeViewClass) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "path");
        kotlin.jvm.internal.IIX0o.x0xO0oo(attributeViewClass, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + attributeViewClass + " is not available for the file " + path + '.');
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final void ox(Path path) throws IOException {
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        Files.delete(path);
    }

    @OXOo.OOXIXo
    public static final String oxIIX0o(@OXOo.OOXIXo Path path) {
        Path fileName;
        String str;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        fileName = path.getFileName();
        if (fileName != null) {
            str = fileName.toString();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static /* synthetic */ List x0(Path path, String str, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            str = "*";
        }
        return x0OxxIOxX(path, str);
    }

    public static final String x0OIX00oO(Path path) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        return path.toString();
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.5")
    public static final List<Path> x0OxxIOxX(@OXOo.OOXIXo Path path, @OXOo.OOXIXo String glob) throws IOException {
        DirectoryStream newDirectoryStream;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(glob, "glob");
        newDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            DirectoryStream oIX0oI2 = Xx000oIo.oIX0oI(newDirectoryStream);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oIX0oI2);
            List<Path> oOo0o = CollectionsKt___CollectionsKt.oOo0o(oIX0oI2);
            kotlin.io.II0xO0.oIX0oI(newDirectoryStream, null);
            return oOo0o;
        } finally {
        }
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    @xx0o0O.XO
    public static final Path x0xO(String str, FileAttribute<?>... attributes) throws IOException {
        Path createTempDirectory;
        kotlin.jvm.internal.IIX0o.x0xO0oo(attributes, "attributes");
        createTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.IIX0o.oO(createTempDirectory, "createTempDirectory(...)");
        return createTempDirectory;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    public static /* synthetic */ void xI0oxI00(Path path) {
    }

    public static /* synthetic */ void xIXX(Path path, int i, boolean z, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        OooI(path, i, z, oooxoxo);
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final FileStore xOOOX(Path path) throws IOException {
        FileStore fileStore;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        fileStore = Files.getFileStore(path);
        kotlin.jvm.internal.IIX0o.oO(fileStore, "getFileStore(...)");
        return fileStore;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    public static /* synthetic */ void xOoOIoI(Path path) {
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final long xX0IIXIx0(Path path) throws IOException {
        long size;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        size = Files.size(path);
        return size;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final Path xXOx(String base, String... subpaths) {
        Path path;
        kotlin.jvm.internal.IIX0o.x0xO0oo(base, "base");
        kotlin.jvm.internal.IIX0o.x0xO0oo(subpaths, "subpaths");
        path = Paths.get(base, (String[]) Arrays.copyOf(subpaths, subpaths.length));
        kotlin.jvm.internal.IIX0o.oO(path, "get(...)");
        return path;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final boolean xXoOI00O(Path path) {
        boolean isWritable;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        isWritable = Files.isWritable(path);
        return isWritable;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final Path xo0x(String path) {
        Path path2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "path");
        path2 = Paths.get(path, new String[0]);
        kotlin.jvm.internal.IIX0o.oO(path2, "get(...)");
        return path2;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    @xx0o0O.XO
    public static final Path xoIxX(Path path, Path target, FileAttribute<?>... attributes) throws IOException {
        Path createSymbolicLink;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(target, "target");
        kotlin.jvm.internal.IIX0o.x0xO0oo(attributes, "attributes");
        createSymbolicLink = Files.createSymbolicLink(path, target, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.IIX0o.oO(createSymbolicLink, "createSymbolicLink(...)");
        return createSymbolicLink;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final /* synthetic */ <V extends FileAttributeView> V xoO0xx0(Path path, LinkOption... options) {
        FileAttributeView fileAttributeView;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        kotlin.jvm.internal.IIX0o.OxI(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        fileAttributeView = Files.getFileAttributeView(path, Ioxxx.oIX0oI(), (LinkOption[]) Arrays.copyOf(options, options.length));
        if (fileAttributeView != null) {
            return (V) XX0xXo.oIX0oI(fileAttributeView);
        }
        kotlin.jvm.internal.IIX0o.OxI(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        ooOx(path, Ioxxx.oIX0oI());
        throw new KotlinNothingValueException();
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    @xx0o0O.XO
    public static final Path xoxXI(Path path, FileAttribute<?>... attributes) throws IOException {
        Path createFile;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(attributes, "attributes");
        createFile = Files.createFile(path, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.IIX0o.oO(createFile, "createFile(...)");
        return createFile;
    }

    @OXOo.OOXIXo
    public static final String xx0X0(@OXOo.OOXIXo Path path) {
        FileSystem fileSystem;
        String separator;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        fileSystem = path.getFileSystem();
        separator = fileSystem.getSeparator();
        if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(separator, "/")) {
            String obj = path.toString();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(separator);
            return kotlin.text.OxI.IIOIX(obj, separator, "/", false, 4, null);
        }
        return path.toString();
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    @xx0o0O.XO
    public static final Path xxIO(String str, String str2, FileAttribute<?>... attributes) throws IOException {
        Path createTempFile;
        kotlin.jvm.internal.IIX0o.x0xO0oo(attributes, "attributes");
        createTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.IIX0o.oO(createTempFile, "createTempFile(...)");
        return createTempFile;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final boolean xxOXOOoIX(Path path) {
        boolean isSymbolicLink;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        isSymbolicLink = Files.isSymbolicLink(path);
        return isSymbolicLink;
    }

    public static /* synthetic */ void xxxI(Path path, FileVisitor fileVisitor, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        OIx00oxx(path, fileVisitor, i, z);
    }
}
