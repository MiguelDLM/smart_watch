package okio.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oO;
import kotlin.sequences.IXxxXO;
import kotlin.sequences.ooOOo0oXI;
import okio.BufferedSink;
import okio.FileMetadata;
import okio.Okio;
import okio.Path;
import okio.Source;

@xxIXOIIO(name = "-FileSystem")
@XX({"SMAP\nFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileSystem.kt\nokio/internal/-FileSystem\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,155:1\n52#2,5:156\n52#2,21:161\n60#2,10:182\n57#2,2:192\n71#2,2:194\n*S KotlinDebug\n*F\n+ 1 FileSystem.kt\nokio/internal/-FileSystem\n*L\n65#1:156,5\n66#1:161,21\n65#1:182,10\n65#1:192,2\n65#1:194,2\n*E\n"})
/* renamed from: okio.internal.-FileSystem, reason: invalid class name */
/* loaded from: classes6.dex */
public final class FileSystem {
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00e0, code lost:
    
        if (r0 != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e2, code lost:
    
        if (r7 != 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00e4, code lost:
    
        r6.addLast(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00eb, code lost:
    
        r7 = r6;
        r6 = r1;
        r1 = r0;
        r0 = r2;
        r2 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0126, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0127, code lost:
    
        r7 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object collectRecursively(@OXOo.OOXIXo kotlin.sequences.oO<? super okio.Path> r15, @OXOo.OOXIXo okio.FileSystem r16, @OXOo.OOXIXo kotlin.collections.xxIXOIIO<okio.Path> r17, @OXOo.OOXIXo okio.Path r18, boolean r19, boolean r20, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r21) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.FileSystem.collectRecursively(kotlin.sequences.oO, okio.FileSystem, kotlin.collections.xxIXOIIO, okio.Path, boolean, boolean, kotlin.coroutines.I0Io):java.lang.Object");
    }

    public static final void commonCopy(@OOXIXo okio.FileSystem fileSystem, @OOXIXo Path source, @OOXIXo Path target) throws IOException {
        Long l;
        Throwable th;
        Long l2;
        IIX0o.x0xO0oo(fileSystem, "<this>");
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(target, "target");
        Source source2 = fileSystem.source(source);
        Throwable th2 = null;
        try {
            BufferedSink buffer = Okio.buffer(fileSystem.sink(target));
            try {
                l2 = Long.valueOf(buffer.writeAll(source2));
                if (buffer != null) {
                    try {
                        buffer.close();
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                th = null;
            } catch (Throwable th4) {
                if (buffer != null) {
                    try {
                        buffer.close();
                    } catch (Throwable th5) {
                        oO.oIX0oI(th4, th5);
                    }
                }
                th = th4;
                l2 = null;
            }
        } catch (Throwable th6) {
            if (source2 != null) {
                try {
                    source2.close();
                } catch (Throwable th7) {
                    oO.oIX0oI(th6, th7);
                }
            }
            th2 = th6;
            l = null;
        }
        if (th == null) {
            IIX0o.ooOOo0oXI(l2);
            l = Long.valueOf(l2.longValue());
            if (source2 != null) {
                try {
                    source2.close();
                } catch (Throwable th8) {
                    th2 = th8;
                }
            }
            if (th2 == null) {
                IIX0o.ooOOo0oXI(l);
                return;
            }
            throw th2;
        }
        throw th;
    }

    public static final void commonCreateDirectories(@OOXIXo okio.FileSystem fileSystem, @OOXIXo Path dir, boolean z) throws IOException {
        IIX0o.x0xO0oo(fileSystem, "<this>");
        IIX0o.x0xO0oo(dir, "dir");
        kotlin.collections.xxIXOIIO xxixoiio = new kotlin.collections.xxIXOIIO();
        for (Path path = dir; path != null && !fileSystem.exists(path); path = path.parent()) {
            xxixoiio.addFirst(path);
        }
        if (z && xxixoiio.isEmpty()) {
            throw new IOException(dir + " already exists.");
        }
        Iterator<E> it = xxixoiio.iterator();
        while (it.hasNext()) {
            fileSystem.createDirectory((Path) it.next());
        }
    }

    public static final void commonDeleteRecursively(@OOXIXo okio.FileSystem fileSystem, @OOXIXo Path fileOrDirectory, boolean z) throws IOException {
        boolean z2;
        IIX0o.x0xO0oo(fileSystem, "<this>");
        IIX0o.x0xO0oo(fileOrDirectory, "fileOrDirectory");
        Iterator it = IXxxXO.II0xO0(new FileSystem$commonDeleteRecursively$sequence$1(fileSystem, fileOrDirectory, null)).iterator();
        while (it.hasNext()) {
            Path path = (Path) it.next();
            if (z && !it.hasNext()) {
                z2 = true;
            } else {
                z2 = false;
            }
            fileSystem.delete(path, z2);
        }
    }

    public static final boolean commonExists(@OOXIXo okio.FileSystem fileSystem, @OOXIXo Path path) throws IOException {
        IIX0o.x0xO0oo(fileSystem, "<this>");
        IIX0o.x0xO0oo(path, "path");
        if (fileSystem.metadataOrNull(path) != null) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public static final ooOOo0oXI<Path> commonListRecursively(@OOXIXo okio.FileSystem fileSystem, @OOXIXo Path dir, boolean z) throws IOException {
        IIX0o.x0xO0oo(fileSystem, "<this>");
        IIX0o.x0xO0oo(dir, "dir");
        return IXxxXO.II0xO0(new FileSystem$commonListRecursively$1(dir, fileSystem, z, null));
    }

    @OOXIXo
    public static final FileMetadata commonMetadata(@OOXIXo okio.FileSystem fileSystem, @OOXIXo Path path) throws IOException {
        IIX0o.x0xO0oo(fileSystem, "<this>");
        IIX0o.x0xO0oo(path, "path");
        FileMetadata metadataOrNull = fileSystem.metadataOrNull(path);
        if (metadataOrNull != null) {
            return metadataOrNull;
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    @oOoXoXO
    public static final Path symlinkTarget(@OOXIXo okio.FileSystem fileSystem, @OOXIXo Path path) throws IOException {
        IIX0o.x0xO0oo(fileSystem, "<this>");
        IIX0o.x0xO0oo(path, "path");
        Path symlinkTarget = fileSystem.metadata(path).getSymlinkTarget();
        if (symlinkTarget == null) {
            return null;
        }
        Path parent = path.parent();
        IIX0o.ooOOo0oXI(parent);
        return parent.resolve(symlinkTarget);
    }
}
