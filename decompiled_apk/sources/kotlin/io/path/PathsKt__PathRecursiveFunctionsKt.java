package kotlin.io.path;

import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystemException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttributeView;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nPathRecursiveFunctions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathRecursiveFunctions.kt\nkotlin/io/path/PathsKt__PathRecursiveFunctionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,430:1\n346#1,2:434\n354#1:436\n354#1:437\n348#1,4:438\n346#1,2:442\n354#1:444\n348#1,4:445\n354#1:449\n346#1,6:450\n346#1,2:456\n354#1:458\n348#1,4:459\n1#2:431\n1855#3,2:432\n*S KotlinDebug\n*F\n+ 1 PathRecursiveFunctions.kt\nkotlin/io/path/PathsKt__PathRecursiveFunctionsKt\n*L\n362#1:434,2\n371#1:436\n374#1:437\n362#1:438,4\n382#1:442,2\n383#1:444\n382#1:445,4\n394#1:449\n402#1:450,6\n420#1:456,2\n421#1:458\n420#1:459,4\n284#1:432,2\n*E\n"})
/* loaded from: classes6.dex */
public class PathsKt__PathRecursiveFunctionsKt extends IoOoX {

    /* loaded from: classes6.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final /* synthetic */ int[] f29258II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f29259oIX0oI;

        static {
            int[] iArr = new int[CopyActionResult.values().length];
            try {
                iArr[CopyActionResult.CONTINUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CopyActionResult.TERMINATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CopyActionResult.SKIP_SUBTREE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f29259oIX0oI = iArr;
            int[] iArr2 = new int[OnErrorResult.values().length];
            try {
                iArr2[OnErrorResult.TERMINATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[OnErrorResult.SKIP_SUBTREE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            f29258II0xO0 = iArr2;
        }
    }

    public static final boolean I0oOoX(SecureDirectoryStream<Path> secureDirectoryStream, Path path, LinkOption... linkOptionArr) {
        Boolean bool;
        FileAttributeView fileAttributeView;
        BasicFileAttributes readAttributes;
        boolean isDirectory;
        try {
            fileAttributeView = secureDirectoryStream.getFileAttributeView(path, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.X0IIOO.oIX0oI(), (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
            readAttributes = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.xxX.oIX0oI(fileAttributeView).readAttributes();
            isDirectory = readAttributes.isDirectory();
            bool = Boolean.valueOf(isDirectory);
        } catch (NoSuchFileException unused) {
            bool = null;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final Path IO(Path path, Path path2, Path path3) {
        Path resolve;
        resolve = path2.resolve(OOXIxO0.oIIxXoo(path3, path).toString());
        kotlin.jvm.internal.IIX0o.oO(resolve, "resolve(...)");
        return resolve;
    }

    public static final void Io(SecureDirectoryStream<Path> secureDirectoryStream, Path path, oOoXoXO oooxoxo) {
        LinkOption linkOption;
        oooxoxo.II0xO0(path);
        try {
            linkOption = LinkOption.NOFOLLOW_LINKS;
        } catch (Exception e) {
            oooxoxo.oIX0oI(e);
        }
        if (!I0oOoX(secureDirectoryStream, path, linkOption)) {
            secureDirectoryStream.deleteFile(path);
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        } else {
            int XO2 = oooxoxo.XO();
            OI0(secureDirectoryStream, path, oooxoxo);
            if (XO2 == oooxoxo.XO()) {
                secureDirectoryStream.deleteDirectory(path);
                oXIO0o0XI oxio0o0xi2 = oXIO0o0XI.f29392oIX0oI;
            }
            oooxoxo.I0Io(path);
        }
        oooxoxo.I0Io(path);
    }

    @ooOOo0oXI
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.8")
    public static final Path IoOoX(@OXOo.OOXIXo Path path, @OXOo.OOXIXo Path target, @OXOo.OOXIXo Oox.IXxxXO<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> onError, final boolean z, boolean z2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(target, "target");
        kotlin.jvm.internal.IIX0o.x0xO0oo(onError, "onError");
        if (z2) {
            return oo(path, target, onError, z, new Oox.IXxxXO<kotlin.io.path.oIX0oI, Path, Path, CopyActionResult>() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // Oox.IXxxXO
                public /* bridge */ /* synthetic */ CopyActionResult invoke(oIX0oI oix0oi, Path path2, Path path3) {
                    return invoke2(oix0oi, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.X00IoxXI.oIX0oI(path2), com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.X00IoxXI.oIX0oI(path3));
                }

                @OXOo.OOXIXo
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final CopyActionResult invoke2(@OXOo.OOXIXo oIX0oI copyToRecursively, @OXOo.OOXIXo Path src, @OXOo.OOXIXo Path dst) {
                    LinkOption linkOption;
                    boolean isDirectory;
                    boolean isDirectory2;
                    StandardCopyOption standardCopyOption;
                    Path copy;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(copyToRecursively, "$this$copyToRecursively");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(src, "src");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(dst, "dst");
                    LinkOption[] oIX0oI2 = oI0IIXIo.f29263oIX0oI.oIX0oI(z);
                    linkOption = LinkOption.NOFOLLOW_LINKS;
                    isDirectory = Files.isDirectory(dst, (LinkOption[]) Arrays.copyOf(new LinkOption[]{linkOption}, 1));
                    LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(oIX0oI2, oIX0oI2.length);
                    isDirectory2 = Files.isDirectory(src, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
                    if (!isDirectory2 || !isDirectory) {
                        if (isDirectory) {
                            PathsKt__PathRecursiveFunctionsKt.x0o(dst);
                        }
                        kotlin.jvm.internal.I0oOoX i0oOoX = new kotlin.jvm.internal.I0oOoX(2);
                        i0oOoX.II0xO0(oIX0oI2);
                        standardCopyOption = StandardCopyOption.REPLACE_EXISTING;
                        i0oOoX.oIX0oI(standardCopyOption);
                        CopyOption[] copyOptionArr = (CopyOption[]) i0oOoX.oxoX(new CopyOption[i0oOoX.I0Io()]);
                        copy = Files.copy(src, dst, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
                        kotlin.jvm.internal.IIX0o.oO(copy, "copy(...)");
                    }
                    return CopyActionResult.CONTINUE;
                }
            });
        }
        return Xx000oIo(path, target, onError, z, null, 8, null);
    }

    public static final void OI0(SecureDirectoryStream<Path> secureDirectoryStream, Path path, oOoXoXO oooxoxo) {
        SecureDirectoryStream secureDirectoryStream2;
        Iterator it;
        Path fileName;
        LinkOption linkOption;
        try {
            try {
                linkOption = LinkOption.NOFOLLOW_LINKS;
                secureDirectoryStream2 = secureDirectoryStream.newDirectoryStream(path, linkOption);
            } catch (Exception e) {
                oooxoxo.oIX0oI(e);
                return;
            }
        } catch (NoSuchFileException unused) {
            secureDirectoryStream2 = null;
        }
        if (secureDirectoryStream2 != null) {
            try {
                SecureDirectoryStream oIX0oI2 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.O0xOxO.oIX0oI(secureDirectoryStream2);
                it = oIX0oI2.iterator();
                while (it.hasNext()) {
                    fileName = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.X00IoxXI.oIX0oI(it.next()).getFileName();
                    kotlin.jvm.internal.IIX0o.oO(fileName, "getFileName(...)");
                    Io(oIX0oI2, fileName, oooxoxo);
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                kotlin.io.II0xO0.oIX0oI(secureDirectoryStream2, null);
            } finally {
            }
        }
    }

    public static /* synthetic */ Path X00IoxXI(Path path, Path path2, Oox.IXxxXO iXxxXO, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            iXxxXO = new Oox.IXxxXO() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$1
                @Override // Oox.IXxxXO
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                    return invoke(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.X00IoxXI.oIX0oI(obj2), com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.X00IoxXI.oIX0oI(obj3), (Exception) obj4);
                }

                @OXOo.OOXIXo
                public final Void invoke(@OXOo.OOXIXo Path path3, @OXOo.OOXIXo Path path4, @OXOo.OOXIXo Exception exception) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(path3, "<anonymous parameter 0>");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(path4, "<anonymous parameter 1>");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(exception, "exception");
                    throw exception;
                }
            };
        }
        return IoOoX(path, path2, iXxxXO, z, z2);
    }

    public static final List<Exception> XOxIOxOx(Path path) {
        Path parent;
        DirectoryStream directoryStream;
        Path fileName;
        boolean z = false;
        boolean z2 = true;
        oOoXoXO oooxoxo = new oOoXoXO(0, 1, null);
        parent = path.getParent();
        if (parent != null) {
            try {
                directoryStream = Files.newDirectoryStream(parent);
            } catch (Throwable unused) {
                directoryStream = null;
            }
            if (directoryStream != null) {
                try {
                    DirectoryStream oIX0oI2 = Xx000oIo.oIX0oI(directoryStream);
                    if (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.OxI.oIX0oI(oIX0oI2)) {
                        oooxoxo.Oxx0IOOO(parent);
                        SecureDirectoryStream oIX0oI3 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.O0xOxO.oIX0oI(oIX0oI2);
                        fileName = path.getFileName();
                        kotlin.jvm.internal.IIX0o.oO(fileName, "getFileName(...)");
                        Io(oIX0oI3, fileName, oooxoxo);
                    } else {
                        z = true;
                    }
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    kotlin.io.II0xO0.oIX0oI(directoryStream, null);
                    z2 = z;
                } finally {
                }
            }
        }
        if (z2) {
            XX(path, oooxoxo);
        }
        return oooxoxo.oxoX();
    }

    public static final void XX(Path path, oOoXoXO oooxoxo) {
        LinkOption linkOption;
        boolean isDirectory;
        try {
            linkOption = LinkOption.NOFOLLOW_LINKS;
            isDirectory = Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{linkOption}, 1));
            if (!isDirectory) {
                Files.deleteIfExists(path);
            } else {
                int XO2 = oooxoxo.XO();
                o0(path, oooxoxo);
                if (XO2 == oooxoxo.XO()) {
                    Files.deleteIfExists(path);
                }
            }
        } catch (Exception e) {
            oooxoxo.oIX0oI(e);
        }
    }

    @ooOOo0oXI
    public static final FileVisitResult XoX(OnErrorResult onErrorResult) {
        FileVisitResult fileVisitResult;
        FileVisitResult fileVisitResult2;
        int i = oIX0oI.f29258II0xO0[onErrorResult.ordinal()];
        if (i == 1) {
            fileVisitResult = FileVisitResult.TERMINATE;
            return fileVisitResult;
        }
        if (i == 2) {
            fileVisitResult2 = FileVisitResult.SKIP_SUBTREE;
            return fileVisitResult2;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ Path Xx000oIo(Path path, Path path2, Oox.IXxxXO iXxxXO, final boolean z, Oox.IXxxXO iXxxXO2, int i, Object obj) {
        if ((i & 2) != 0) {
            iXxxXO = new Oox.IXxxXO() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$3
                @Override // Oox.IXxxXO
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                    return invoke(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.X00IoxXI.oIX0oI(obj2), com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.X00IoxXI.oIX0oI(obj3), (Exception) obj4);
                }

                @OXOo.OOXIXo
                public final Void invoke(@OXOo.OOXIXo Path path3, @OXOo.OOXIXo Path path4, @OXOo.OOXIXo Exception exception) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(path3, "<anonymous parameter 0>");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(path4, "<anonymous parameter 1>");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(exception, "exception");
                    throw exception;
                }
            };
        }
        if ((i & 8) != 0) {
            iXxxXO2 = new Oox.IXxxXO<kotlin.io.path.oIX0oI, Path, Path, CopyActionResult>() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // Oox.IXxxXO
                public /* bridge */ /* synthetic */ CopyActionResult invoke(oIX0oI oix0oi, Path path3, Path path4) {
                    return invoke2(oix0oi, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.X00IoxXI.oIX0oI(path3), com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.X00IoxXI.oIX0oI(path4));
                }

                @OXOo.OOXIXo
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final CopyActionResult invoke2(@OXOo.OOXIXo oIX0oI oix0oi, @OXOo.OOXIXo Path src, @OXOo.OOXIXo Path dst) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(oix0oi, "$this$null");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(src, "src");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(dst, "dst");
                    return oix0oi.oIX0oI(src, dst, z);
                }
            };
        }
        return oo(path, path2, iXxxXO, z, iXxxXO2);
    }

    public static final void o0(Path path, oOoXoXO oooxoxo) {
        DirectoryStream directoryStream;
        Iterator it;
        try {
            try {
                directoryStream = Files.newDirectoryStream(path);
            } catch (Exception e) {
                oooxoxo.oIX0oI(e);
                return;
            }
        } catch (NoSuchFileException unused) {
            directoryStream = null;
        }
        if (directoryStream != null) {
            try {
                it = Xx000oIo.oIX0oI(directoryStream).iterator();
                while (it.hasNext()) {
                    Path oIX0oI2 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.X00IoxXI.oIX0oI(it.next());
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(oIX0oI2);
                    XX(oIX0oI2, oooxoxo);
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                kotlin.io.II0xO0.oIX0oI(directoryStream, null);
            } finally {
            }
        }
    }

    public static final FileVisitResult oOXoIIIo(Oox.IXxxXO<? super kotlin.io.path.oIX0oI, ? super Path, ? super Path, ? extends CopyActionResult> iXxxXO, Path path, Path path2, Oox.IXxxXO<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> iXxxXO2, Path path3, BasicFileAttributes basicFileAttributes) {
        try {
            return oxxXoxO(iXxxXO.invoke(I0Io.f29241oIX0oI, path3, IO(path, path2, path3)));
        } catch (Exception e) {
            return xII(iXxxXO2, path, path2, path3, e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0063, code lost:
    
        if (r3 == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0043, code lost:
    
        if (r1 == false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b1  */
    @kotlin.io.path.ooOOo0oXI
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.8")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.nio.file.Path oo(@OXOo.OOXIXo final java.nio.file.Path r6, @OXOo.OOXIXo final java.nio.file.Path r7, @OXOo.OOXIXo final Oox.IXxxXO<? super java.nio.file.Path, ? super java.nio.file.Path, ? super java.lang.Exception, ? extends kotlin.io.path.OnErrorResult> r8, boolean r9, @OXOo.OOXIXo final Oox.IXxxXO<? super kotlin.io.path.oIX0oI, ? super java.nio.file.Path, ? super java.nio.file.Path, ? extends kotlin.io.path.CopyActionResult> r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r6, r0)
            java.lang.String r0 = "target"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r0)
            java.lang.String r0 = "onError"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r8, r0)
            java.lang.String r0 = "copyAction"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r10, r0)
            kotlin.io.path.oI0IIXIo r0 = kotlin.io.path.oI0IIXIo.f29263oIX0oI
            java.nio.file.LinkOption[] r0 = r0.oIX0oI(r9)
            int r1 = r0.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)
            java.nio.file.LinkOption[] r0 = (java.nio.file.LinkOption[]) r0
            int r1 = r0.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)
            java.nio.file.LinkOption[] r0 = (java.nio.file.LinkOption[]) r0
            boolean r0 = kotlin.io.path.O0xOxO.oIX0oI(r6, r0)
            if (r0 == 0) goto Ld1
            r0 = 0
            java.nio.file.LinkOption[] r1 = new java.nio.file.LinkOption[r0]
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r0)
            java.nio.file.LinkOption[] r1 = (java.nio.file.LinkOption[]) r1
            boolean r1 = kotlin.io.path.O0xOxO.oIX0oI(r6, r1)
            if (r1 == 0) goto Lc3
            if (r9 != 0) goto L45
            boolean r1 = com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.oIX0oI.oIX0oI(r6)
            if (r1 != 0) goto Lc3
        L45:
            java.nio.file.LinkOption[] r1 = new java.nio.file.LinkOption[r0]
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r0)
            java.nio.file.LinkOption[] r1 = (java.nio.file.LinkOption[]) r1
            boolean r1 = kotlin.io.path.O0xOxO.oIX0oI(r7, r1)
            r2 = 1
            if (r1 == 0) goto L5c
            boolean r1 = com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.oIX0oI.oIX0oI(r7)
            if (r1 != 0) goto L5c
            r1 = 1
            goto L5d
        L5c:
            r1 = 0
        L5d:
            if (r1 == 0) goto L65
            boolean r3 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.X0o0xo.oIX0oI(r6, r7)
            if (r3 != 0) goto Lc3
        L65:
            java.nio.file.FileSystem r3 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.oI0IIXIo.oIX0oI(r6)
            java.nio.file.FileSystem r4 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.oI0IIXIo.oIX0oI(r7)
            boolean r3 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r3, r4)
            if (r3 != 0) goto L74
            goto Lae
        L74:
            if (r1 == 0) goto L87
            java.nio.file.LinkOption[] r1 = new java.nio.file.LinkOption[r0]
            java.nio.file.Path r1 = kotlin.io.path.IO.oIX0oI(r7, r1)
            java.nio.file.LinkOption[] r0 = new java.nio.file.LinkOption[r0]
            java.nio.file.Path r0 = kotlin.io.path.IO.oIX0oI(r6, r0)
            boolean r0 = kotlin.io.path.X00IoxXI.oIX0oI(r1, r0)
            goto Lae
        L87:
            java.nio.file.Path r1 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.IXxxXO.oIX0oI(r7)
            if (r1 == 0) goto Lae
            java.nio.file.LinkOption[] r3 = new java.nio.file.LinkOption[r0]
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r0)
            java.nio.file.LinkOption[] r3 = (java.nio.file.LinkOption[]) r3
            boolean r3 = kotlin.io.path.O0xOxO.oIX0oI(r1, r3)
            if (r3 == 0) goto Lae
            java.nio.file.LinkOption[] r3 = new java.nio.file.LinkOption[r0]
            java.nio.file.Path r1 = kotlin.io.path.IO.oIX0oI(r1, r3)
            java.nio.file.LinkOption[] r3 = new java.nio.file.LinkOption[r0]
            java.nio.file.Path r3 = kotlin.io.path.IO.oIX0oI(r6, r3)
            boolean r1 = kotlin.io.path.X00IoxXI.oIX0oI(r1, r3)
            if (r1 == 0) goto Lae
            r0 = 1
        Lae:
            if (r0 != 0) goto Lb1
            goto Lc3
        Lb1:
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.ooXIXxIX.oIX0oI()
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "Recursively copying a directory into its subdirectory is prohibited."
            java.nio.file.FileSystemException r6 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.IIX0o.oIX0oI(r6, r7, r8)
            throw r6
        Lc3:
            kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5 r3 = new kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5
            r3.<init>()
            r4 = 1
            r5 = 0
            r1 = 0
            r0 = r6
            r2 = r9
            kotlin.io.path.OOXIxO0.xIXX(r0, r1, r2, r3, r4, r5)
            return r7
        Ld1:
            kotlin.io.path.o0.oIX0oI()
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "The source file doesn't exist."
            java.nio.file.NoSuchFileException r6 = kotlin.io.path.OI0.oIX0oI(r6, r7, r8)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt.oo(java.nio.file.Path, java.nio.file.Path, Oox.IXxxXO, boolean, Oox.IXxxXO):java.nio.file.Path");
    }

    public static final void oo0xXOI0I(oOoXoXO oooxoxo, Oox.oIX0oI<oXIO0o0XI> oix0oi) {
        try {
            oix0oi.invoke();
        } catch (Exception e) {
            oooxoxo.oIX0oI(e);
        }
    }

    public static final <R> R oxXx0IX(Oox.oIX0oI<? extends R> oix0oi) {
        try {
            return oix0oi.invoke();
        } catch (NoSuchFileException unused) {
            return null;
        }
    }

    @ooOOo0oXI
    public static final FileVisitResult oxxXoxO(CopyActionResult copyActionResult) {
        FileVisitResult fileVisitResult;
        FileVisitResult fileVisitResult2;
        FileVisitResult fileVisitResult3;
        int i = oIX0oI.f29259oIX0oI[copyActionResult.ordinal()];
        if (i == 1) {
            fileVisitResult = FileVisitResult.CONTINUE;
            return fileVisitResult;
        }
        if (i == 2) {
            fileVisitResult2 = FileVisitResult.TERMINATE;
            return fileVisitResult2;
        }
        if (i == 3) {
            fileVisitResult3 = FileVisitResult.SKIP_SUBTREE;
            return fileVisitResult3;
        }
        throw new NoWhenBranchMatchedException();
    }

    @ooOOo0oXI
    @kotlin.oxxXoxO(version = "1.8")
    public static final void x0o(@OXOo.OOXIXo Path path) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        List<Exception> XOxIOxOx2 = XOxIOxOx(path);
        if (!XOxIOxOx2.isEmpty()) {
            FileSystemException oIX0oI2 = OOXIXo.oIX0oI("Failed to delete one or more files. See suppressed exceptions for details.");
            Iterator<T> it = XOxIOxOx2.iterator();
            while (it.hasNext()) {
                kotlin.oO.oIX0oI(oIX0oI2, (Exception) it.next());
            }
            throw oIX0oI2;
        }
    }

    public static final FileVisitResult xII(Oox.IXxxXO<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> iXxxXO, Path path, Path path2, Path path3, Exception exc) {
        return XoX(iXxxXO.invoke(path3, IO(path, path2, path3), exc));
    }
}
