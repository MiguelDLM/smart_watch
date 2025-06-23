package kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

@ooOOo0oXI
/* loaded from: classes6.dex */
public final class oO implements x0XOIxOo {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.x0xO0oo<? super Path, ? super IOException, ? extends FileVisitResult> f29265I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.x0xO0oo<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> f29266II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f29267X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.x0xO0oo<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> f29268oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.x0xO0oo<? super Path, ? super IOException, ? extends FileVisitResult> f29269oxoX;

    @Override // kotlin.io.path.x0XOIxOo
    public void I0Io(@OXOo.OOXIXo Oox.x0xO0oo<? super Path, ? super IOException, ? extends FileVisitResult> function) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(function, "function");
        XO();
        Oxx0IOOO(this.f29265I0Io, "onVisitFileFailed");
        this.f29265I0Io = function;
    }

    @Override // kotlin.io.path.x0XOIxOo
    public void II0xO0(@OXOo.OOXIXo Oox.x0xO0oo<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(function, "function");
        XO();
        Oxx0IOOO(this.f29266II0xO0, "onVisitFile");
        this.f29266II0xO0 = function;
    }

    public final void Oxx0IOOO(Object obj, String str) {
        if (obj == null) {
            return;
        }
        throw new IllegalStateException(str + " was already defined");
    }

    @OXOo.OOXIXo
    public final FileVisitor<Path> X0o0xo() {
        XO();
        this.f29267X0o0xo = true;
        return X0o0xo.oIX0oI(new IXxxXO(this.f29268oIX0oI, this.f29266II0xO0, this.f29265I0Io, this.f29269oxoX));
    }

    public final void XO() {
        if (!this.f29267X0o0xo) {
        } else {
            throw new IllegalStateException("This builder was already built");
        }
    }

    @Override // kotlin.io.path.x0XOIxOo
    public void oIX0oI(@OXOo.OOXIXo Oox.x0xO0oo<? super Path, ? super IOException, ? extends FileVisitResult> function) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(function, "function");
        XO();
        Oxx0IOOO(this.f29269oxoX, "onPostVisitDirectory");
        this.f29269oxoX = function;
    }

    @Override // kotlin.io.path.x0XOIxOo
    public void oxoX(@OXOo.OOXIXo Oox.x0xO0oo<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(function, "function");
        XO();
        Oxx0IOOO(this.f29268oIX0oI, "onPreVisitDirectory");
        this.f29268oIX0oI = function;
    }
}
