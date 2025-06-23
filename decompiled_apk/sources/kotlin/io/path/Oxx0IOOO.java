package kotlin.io.path;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

@kotlin.jvm.internal.XX({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/DirectoryEntriesReader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,177:1\n1#2:178\n*E\n"})
/* loaded from: classes6.dex */
public final class Oxx0IOOO extends SimpleFileVisitor<Path> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public kotlin.collections.xxIXOIIO<OxxIIOOXO> f29249I0Io = new kotlin.collections.xxIXOIIO<>();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public OxxIIOOXO f29250II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final boolean f29251oIX0oI;

    public Oxx0IOOO(boolean z) {
        this.f29251oIX0oI = z;
    }

    @OXOo.OOXIXo
    public final List<OxxIIOOXO> I0Io(@OXOo.OOXIXo OxxIIOOXO directoryNode) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(directoryNode, "directoryNode");
        this.f29250II0xO0 = directoryNode;
        Files.walkFileTree(directoryNode.oxoX(), oI0IIXIo.f29263oIX0oI.II0xO0(this.f29251oIX0oI), 1, X0o0xo.oIX0oI(this));
        this.f29249I0Io.removeFirst();
        kotlin.collections.xxIXOIIO<OxxIIOOXO> xxixoiio = this.f29249I0Io;
        this.f29249I0Io = new kotlin.collections.xxIXOIIO<>();
        return xxixoiio;
    }

    @OXOo.OOXIXo
    public FileVisitResult II0xO0(@OXOo.OOXIXo Path dir, @OXOo.OOXIXo BasicFileAttributes attrs) {
        Object fileKey;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dir, "dir");
        kotlin.jvm.internal.IIX0o.x0xO0oo(attrs, "attrs");
        fileKey = attrs.fileKey();
        this.f29249I0Io.add(new OxxIIOOXO(dir, fileKey, this.f29250II0xO0));
        FileVisitResult preVisitDirectory = super.preVisitDirectory(dir, attrs);
        kotlin.jvm.internal.IIX0o.oO(preVisitDirectory, "preVisitDirectory(...)");
        return preVisitDirectory;
    }

    public final boolean oIX0oI() {
        return this.f29251oIX0oI;
    }

    @OXOo.OOXIXo
    public FileVisitResult oxoX(@OXOo.OOXIXo Path file, @OXOo.OOXIXo BasicFileAttributes attrs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(file, "file");
        kotlin.jvm.internal.IIX0o.x0xO0oo(attrs, "attrs");
        this.f29249I0Io.add(new OxxIIOOXO(file, null, this.f29250II0xO0));
        FileVisitResult visitFile = super.visitFile(file, attrs);
        kotlin.jvm.internal.IIX0o.oO(visitFile, "visitFile(...)");
        return visitFile;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult preVisitDirectory(Object obj, BasicFileAttributes basicFileAttributes) {
        return II0xO0(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.X00IoxXI.oIX0oI(obj), basicFileAttributes);
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult visitFile(Object obj, BasicFileAttributes basicFileAttributes) {
        return oxoX(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.X00IoxXI.oIX0oI(obj), basicFileAttributes);
    }
}
