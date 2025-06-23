package kotlin.io;

import Oox.x0xO0oo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;

@XX({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\nkotlin/io/FilesKt__UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,473:1\n1#2:474\n1284#3,3:475\n*S KotlinDebug\n*F\n+ 1 Utils.kt\nkotlin/io/FilesKt__UtilsKt\n*L\n347#1:475,3\n*E\n"})
/* loaded from: classes6.dex */
public class FilesKt__UtilsKt extends OOXIXo {
    @OXOo.OOXIXo
    public static final File I0X0x0oIo(@OXOo.OOXIXo File file, @OXOo.OOXIXo File base) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(base, "base");
        return new File(xoIxX(file, base));
    }

    @OXOo.OOXIXo
    public static final File I0oOIX(@OXOo.OOXIXo File file, @OXOo.OOXIXo File relative) {
        File xoIox2;
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(relative, "relative");
        Oxx0IOOO XO2 = xoIox.XO(file);
        if (XO2.II0XooXoX() == 0) {
            xoIox2 = new File("..");
        } else {
            xoIox2 = XO2.xoIox(0, XO2.II0XooXoX() - 1);
        }
        return XoI0Ixx0(XoI0Ixx0(XO2.X0o0xo(), xoIox2), relative);
    }

    public static final boolean I0oOoX(@OXOo.OOXIXo File file, @OXOo.OOXIXo String other) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(other, "other");
        return XX(file, new File(other));
    }

    @OXOo.OOXIXo
    public static final File IO(@OXOo.OOXIXo File file, @OXOo.OOXIXo File target, boolean z, int i) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(target, "target");
        if (file.exists()) {
            if (target.exists()) {
                if (z) {
                    if (!target.delete()) {
                        throw new FileAlreadyExistsException(file, target, "Tried to overwrite the destination, but failed to delete it.");
                    }
                } else {
                    throw new FileAlreadyExistsException(file, target, "The destination file already exists.");
                }
            }
            if (file.isDirectory()) {
                if (!target.mkdirs()) {
                    throw new FileSystemException(file, target, "Failed to create target directory.");
                }
            } else {
                File parentFile = target.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(target);
                    try {
                        oIX0oI.OOXIXo(fileInputStream, fileOutputStream, i);
                        II0xO0.oIX0oI(fileOutputStream, null);
                        II0xO0.oIX0oI(fileInputStream, null);
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        II0xO0.oIX0oI(fileInputStream, th);
                        throw th2;
                    }
                }
            }
            return target;
        }
        throw new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null);
    }

    public static /* synthetic */ File Io(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "tmp";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return OI0(str, str2, file);
    }

    public static final boolean IoOoo(@OXOo.OOXIXo File file, @OXOo.OOXIXo String other) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(other, "other");
        return OO(file, new File(other));
    }

    @OXOo.OOXIXo
    public static final File O0Xx(@OXOo.OOXIXo File file, @OXOo.OOXIXo String relative) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(relative, "relative");
        return XoI0Ixx0(file, new File(relative));
    }

    @kotlin.OOXIXo(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    @OXOo.OOXIXo
    public static final File OI0(@OXOo.OOXIXo String prefix, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO File file) {
        IIX0o.x0xO0oo(prefix, "prefix");
        File createTempFile = File.createTempFile(prefix, str, file);
        IIX0o.oO(createTempFile, "createTempFile(...)");
        return createTempFile;
    }

    public static final boolean OO(@OXOo.OOXIXo File file, @OXOo.OOXIXo File other) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(other, "other");
        Oxx0IOOO XO2 = xoIox.XO(file);
        Oxx0IOOO XO3 = xoIox.XO(other);
        if (!IIX0o.Oxx0IOOO(XO2.X0o0xo(), XO3.X0o0xo()) || XO2.II0XooXoX() < XO3.II0XooXoX()) {
            return false;
        }
        return XO2.Oxx0IOOO().subList(0, XO3.II0XooXoX()).equals(XO3.Oxx0IOOO());
    }

    public static /* synthetic */ boolean X00IoxXI(File file, File file2, boolean z, x0xO0oo x0xo0oo, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            x0xo0oo = new x0xO0oo() { // from class: kotlin.io.FilesKt__UtilsKt$copyRecursively$1
                @Override // Oox.x0xO0oo
                @OXOo.OOXIXo
                public final Void invoke(@OXOo.OOXIXo File file3, @OXOo.OOXIXo IOException exception) {
                    IIX0o.x0xO0oo(file3, "<anonymous parameter 0>");
                    IIX0o.x0xO0oo(exception, "exception");
                    throw exception;
                }
            };
        }
        return Xx000oIo(file, file2, z, x0xo0oo);
    }

    public static /* synthetic */ File XOxIOxOx(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "tmp";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return x0o(str, str2, file);
    }

    public static final boolean XX(@OXOo.OOXIXo File file, @OXOo.OOXIXo File other) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(other, "other");
        Oxx0IOOO XO2 = xoIox.XO(file);
        Oxx0IOOO XO3 = xoIox.XO(other);
        if (XO3.xxIXOIIO()) {
            return IIX0o.Oxx0IOOO(file, other);
        }
        int II0XooXoX2 = XO2.II0XooXoX() - XO3.II0XooXoX();
        if (II0XooXoX2 < 0) {
            return false;
        }
        return XO2.Oxx0IOOO().subList(II0XooXoX2, XO2.II0XooXoX()).equals(XO3.Oxx0IOOO());
    }

    public static final Oxx0IOOO XX0(Oxx0IOOO oxx0IOOO) {
        return new Oxx0IOOO(oxx0IOOO.X0o0xo(), xXOx(oxx0IOOO.Oxx0IOOO()));
    }

    @OXOo.OOXIXo
    public static final File Xo0(@OXOo.OOXIXo File file, @OXOo.OOXIXo File base) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(base, "base");
        String x0xO2 = x0xO(file, base);
        if (x0xO2 != null) {
            return new File(x0xO2);
        }
        return file;
    }

    @OXOo.OOXIXo
    public static final File XoI0Ixx0(@OXOo.OOXIXo File file, @OXOo.OOXIXo File relative) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(relative, "relative");
        if (xoIox.oxoX(relative)) {
            return relative;
        }
        String file2 = file.toString();
        IIX0o.oO(file2, "toString(...)");
        if (file2.length() != 0) {
            char c = File.separatorChar;
            if (!StringsKt__StringsKt.OXooXo(file2, c, false, 2, null)) {
                return new File(file2 + c + relative);
            }
        }
        return new File(file2 + relative);
    }

    @OXOo.OOXIXo
    public static final String XoX(@OXOo.OOXIXo File file) {
        IIX0o.x0xO0oo(file, "<this>");
        char c = File.separatorChar;
        String path = file.getPath();
        IIX0o.oO(path, "getPath(...)");
        if (c != '/') {
            return OxI.oXO0oOx0(path, c, IOUtils.DIR_SEPARATOR_UNIX, false, 4, null);
        }
        return path;
    }

    public static final boolean Xx000oIo(@OXOo.OOXIXo File file, @OXOo.OOXIXo File target, boolean z, @OXOo.OOXIXo final x0xO0oo<? super File, ? super IOException, ? extends OnErrorAction> onError) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(target, "target");
        IIX0o.x0xO0oo(onError, "onError");
        if (!file.exists()) {
            if (onError.invoke(file, new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null)) != OnErrorAction.TERMINATE) {
                return true;
            }
            return false;
        }
        try {
            Iterator<File> it = OOXIXo.oOXoIIIo(file).xoIox(new x0xO0oo<File, IOException, oXIO0o0XI>() { // from class: kotlin.io.FilesKt__UtilsKt$copyRecursively$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // Oox.x0xO0oo
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(File file2, IOException iOException) {
                    invoke2(file2, iOException);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo File f, @OXOo.OOXIXo IOException e) {
                    IIX0o.x0xO0oo(f, "f");
                    IIX0o.x0xO0oo(e, "e");
                    if (onError.invoke(f, e) == OnErrorAction.TERMINATE) {
                        throw new TerminateException(f);
                    }
                }
            }).iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (!next.exists()) {
                    if (onError.invoke(next, new NoSuchFileException(next, null, "The source file doesn't exist.", 2, null)) == OnErrorAction.TERMINATE) {
                        return false;
                    }
                } else {
                    File file2 = new File(target, xoIxX(next, file));
                    if (file2.exists() && (!next.isDirectory() || !file2.isDirectory())) {
                        if (z) {
                            if (file2.isDirectory()) {
                                if (!o0(file2)) {
                                }
                            } else if (!file2.delete()) {
                            }
                        }
                        if (onError.invoke(file2, new FileAlreadyExistsException(next, file2, "The destination file already exists.")) == OnErrorAction.TERMINATE) {
                            return false;
                        }
                    }
                    if (next.isDirectory()) {
                        file2.mkdirs();
                    } else if (xII(next, file2, z, 0, 4, null).length() != next.length() && onError.invoke(next, new IOException("Source file wasn't copied completely, length of destination file differs.")) == OnErrorAction.TERMINATE) {
                        return false;
                    }
                }
            }
            return true;
        } catch (TerminateException unused) {
            return false;
        }
    }

    public static boolean o0(@OXOo.OOXIXo File file) {
        IIX0o.x0xO0oo(file, "<this>");
        while (true) {
            boolean z = true;
            for (File file2 : OOXIXo.IoOoX(file)) {
                if (file2.delete() || !file2.exists()) {
                    if (z) {
                        break;
                    }
                }
                z = false;
            }
            return z;
        }
    }

    @OXOo.oOoXoXO
    public static final File oX(@OXOo.OOXIXo File file, @OXOo.OOXIXo File base) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(base, "base");
        String x0xO2 = x0xO(file, base);
        if (x0xO2 != null) {
            return new File(x0xO2);
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final String oxXx0IX(@OXOo.OOXIXo File file) {
        IIX0o.x0xO0oo(file, "<this>");
        String name = file.getName();
        IIX0o.oO(name, "getName(...)");
        return StringsKt__StringsKt.oOxxXI(name, FileUtils.FILE_EXTENSION_SEPARATOR, null, 2, null);
    }

    @OXOo.OOXIXo
    public static final String oxxXoxO(@OXOo.OOXIXo File file) {
        IIX0o.x0xO0oo(file, "<this>");
        String name = file.getName();
        IIX0o.oO(name, "getName(...)");
        return StringsKt__StringsKt.O0OoXI(name, '.', "");
    }

    @kotlin.OOXIXo(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    @OXOo.OOXIXo
    public static final File x0o(@OXOo.OOXIXo String prefix, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO File file) {
        IIX0o.x0xO0oo(prefix, "prefix");
        File createTempFile = File.createTempFile(prefix, str, file);
        createTempFile.delete();
        if (createTempFile.mkdir()) {
            IIX0o.ooOOo0oXI(createTempFile);
            return createTempFile;
        }
        throw new IOException("Unable to create temporary directory " + createTempFile + '.');
    }

    public static final String x0xO(File file, File file2) {
        Oxx0IOOO XX02 = XX0(xoIox.XO(file));
        Oxx0IOOO XX03 = XX0(xoIox.XO(file2));
        if (!IIX0o.Oxx0IOOO(XX02.X0o0xo(), XX03.X0o0xo())) {
            return null;
        }
        int II0XooXoX2 = XX03.II0XooXoX();
        int II0XooXoX3 = XX02.II0XooXoX();
        int min = Math.min(II0XooXoX3, II0XooXoX2);
        int i = 0;
        while (i < min && IIX0o.Oxx0IOOO(XX02.Oxx0IOOO().get(i), XX03.Oxx0IOOO().get(i))) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = II0XooXoX2 - 1;
        if (i <= i2) {
            while (!IIX0o.Oxx0IOOO(XX03.Oxx0IOOO().get(i2).getName(), "..")) {
                sb.append("..");
                if (i2 != i) {
                    sb.append(File.separatorChar);
                }
                if (i2 != i) {
                    i2--;
                }
            }
            return null;
        }
        if (i < II0XooXoX3) {
            if (i < II0XooXoX2) {
                sb.append(File.separatorChar);
            }
            List xIx0XO2 = CollectionsKt___CollectionsKt.xIx0XO(XX02.Oxx0IOOO(), i);
            String separator = File.separator;
            IIX0o.oO(separator, "separator");
            CollectionsKt___CollectionsKt.oI0(xIx0XO2, sb, separator, null, null, 0, null, null, 124, null);
        }
        return sb.toString();
    }

    public static /* synthetic */ File xII(File file, File file2, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 8192;
        }
        return IO(file, file2, z, i);
    }

    public static final List<File> xXOx(List<? extends File> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (!IIX0o.Oxx0IOOO(name, FileUtils.FILE_EXTENSION_SEPARATOR)) {
                if (IIX0o.Oxx0IOOO(name, "..")) {
                    if (!arrayList.isEmpty() && !IIX0o.Oxx0IOOO(((File) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList)).getName(), "..")) {
                        arrayList.remove(arrayList.size() - 1);
                    } else {
                        arrayList.add(file);
                    }
                } else {
                    arrayList.add(file);
                }
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final File xo0x(@OXOo.OOXIXo File file) {
        IIX0o.x0xO0oo(file, "<this>");
        Oxx0IOOO XO2 = xoIox.XO(file);
        File X0o0xo2 = XO2.X0o0xo();
        List<File> xXOx2 = xXOx(XO2.Oxx0IOOO());
        String separator = File.separator;
        IIX0o.oO(separator, "separator");
        return O0Xx(X0o0xo2, CollectionsKt___CollectionsKt.OoIXo(xXOx2, separator, null, null, 0, null, null, 62, null));
    }

    @OXOo.OOXIXo
    public static final String xoIxX(@OXOo.OOXIXo File file, @OXOo.OOXIXo File base) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(base, "base");
        String x0xO2 = x0xO(file, base);
        if (x0xO2 != null) {
            return x0xO2;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + base + '.');
    }

    @OXOo.OOXIXo
    public static final File xoxXI(@OXOo.OOXIXo File file, @OXOo.OOXIXo String relative) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(relative, "relative");
        return I0oOIX(file, new File(relative));
    }
}
