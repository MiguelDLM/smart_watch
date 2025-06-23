package kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/* loaded from: classes6.dex */
public final class IXxxXO extends SimpleFileVisitor<Path> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Oox.x0xO0oo<Path, IOException, FileVisitResult> f29242I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Oox.x0xO0oo<Path, BasicFileAttributes, FileVisitResult> f29243II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Oox.x0xO0oo<Path, BasicFileAttributes, FileVisitResult> f29244oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Oox.x0xO0oo<Path, IOException, FileVisitResult> f29245oxoX;

    /* JADX WARN: Multi-variable type inference failed */
    public IXxxXO(@OXOo.oOoXoXO Oox.x0xO0oo<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> x0xo0oo, @OXOo.oOoXoXO Oox.x0xO0oo<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> x0xo0oo2, @OXOo.oOoXoXO Oox.x0xO0oo<? super Path, ? super IOException, ? extends FileVisitResult> x0xo0oo3, @OXOo.oOoXoXO Oox.x0xO0oo<? super Path, ? super IOException, ? extends FileVisitResult> x0xo0oo4) {
        this.f29244oIX0oI = x0xo0oo;
        this.f29243II0xO0 = x0xo0oo2;
        this.f29242I0Io = x0xo0oo3;
        this.f29245oxoX = x0xo0oo4;
    }

    @OXOo.OOXIXo
    public FileVisitResult I0Io(@OXOo.OOXIXo Path file, @OXOo.OOXIXo BasicFileAttributes attrs) {
        FileVisitResult oIX0oI2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(file, "file");
        kotlin.jvm.internal.IIX0o.x0xO0oo(attrs, "attrs");
        Oox.x0xO0oo<Path, BasicFileAttributes, FileVisitResult> x0xo0oo = this.f29243II0xO0;
        if (x0xo0oo == null || (oIX0oI2 = x0xO0oo.oIX0oI(x0xo0oo.invoke(file, attrs))) == null) {
            FileVisitResult visitFile = super.visitFile(file, attrs);
            kotlin.jvm.internal.IIX0o.oO(visitFile, "visitFile(...)");
            return visitFile;
        }
        return oIX0oI2;
    }

    @OXOo.OOXIXo
    public FileVisitResult II0xO0(@OXOo.OOXIXo Path dir, @OXOo.OOXIXo BasicFileAttributes attrs) {
        FileVisitResult oIX0oI2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dir, "dir");
        kotlin.jvm.internal.IIX0o.x0xO0oo(attrs, "attrs");
        Oox.x0xO0oo<Path, BasicFileAttributes, FileVisitResult> x0xo0oo = this.f29244oIX0oI;
        if (x0xo0oo == null || (oIX0oI2 = x0xO0oo.oIX0oI(x0xo0oo.invoke(dir, attrs))) == null) {
            FileVisitResult preVisitDirectory = super.preVisitDirectory(dir, attrs);
            kotlin.jvm.internal.IIX0o.oO(preVisitDirectory, "preVisitDirectory(...)");
            return preVisitDirectory;
        }
        return oIX0oI2;
    }

    @OXOo.OOXIXo
    public FileVisitResult oIX0oI(@OXOo.OOXIXo Path dir, @OXOo.oOoXoXO IOException iOException) {
        FileVisitResult oIX0oI2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dir, "dir");
        Oox.x0xO0oo<Path, IOException, FileVisitResult> x0xo0oo = this.f29245oxoX;
        if (x0xo0oo == null || (oIX0oI2 = x0xO0oo.oIX0oI(x0xo0oo.invoke(dir, iOException))) == null) {
            FileVisitResult postVisitDirectory = super.postVisitDirectory(dir, iOException);
            kotlin.jvm.internal.IIX0o.oO(postVisitDirectory, "postVisitDirectory(...)");
            return postVisitDirectory;
        }
        return oIX0oI2;
    }

    @OXOo.OOXIXo
    public FileVisitResult oxoX(@OXOo.OOXIXo Path file, @OXOo.OOXIXo IOException exc) {
        FileVisitResult oIX0oI2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(file, "file");
        kotlin.jvm.internal.IIX0o.x0xO0oo(exc, "exc");
        Oox.x0xO0oo<Path, IOException, FileVisitResult> x0xo0oo = this.f29242I0Io;
        if (x0xo0oo == null || (oIX0oI2 = x0xO0oo.oIX0oI(x0xo0oo.invoke(file, exc))) == null) {
            FileVisitResult visitFileFailed = super.visitFileFailed(file, exc);
            kotlin.jvm.internal.IIX0o.oO(visitFileFailed, "visitFileFailed(...)");
            return visitFileFailed;
        }
        return oIX0oI2;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult postVisitDirectory(Object obj, IOException iOException) {
        return oIX0oI(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.X00IoxXI.oIX0oI(obj), iOException);
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult preVisitDirectory(Object obj, BasicFileAttributes basicFileAttributes) {
        return II0xO0(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.X00IoxXI.oIX0oI(obj), basicFileAttributes);
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult visitFile(Object obj, BasicFileAttributes basicFileAttributes) {
        return I0Io(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.X00IoxXI.oIX0oI(obj), basicFileAttributes);
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult visitFileFailed(Object obj, IOException iOException) {
        return oxoX(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.X00IoxXI.oIX0oI(obj), iOException);
    }
}
