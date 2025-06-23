package kotlin.io.path;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public final class oOoXoXO {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final List<Exception> f29270I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f29271II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f29272oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Path f29273oxoX;

    public oOoXoXO() {
        this(0, 1, null);
    }

    public final void I0Io(@OXOo.OOXIXo Path name) {
        Path path;
        kotlin.jvm.internal.IIX0o.x0xO0oo(name, "name");
        Path path2 = this.f29273oxoX;
        Path path3 = null;
        if (path2 != null) {
            path = path2.getFileName();
        } else {
            path = null;
        }
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(name, path)) {
            Path path4 = this.f29273oxoX;
            if (path4 != null) {
                path3 = path4.getParent();
            }
            this.f29273oxoX = path3;
            return;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public final void II0xO0(@OXOo.OOXIXo Path name) {
        Path path;
        kotlin.jvm.internal.IIX0o.x0xO0oo(name, "name");
        Path path2 = this.f29273oxoX;
        if (path2 != null) {
            path = path2.resolve(name);
        } else {
            path = null;
        }
        this.f29273oxoX = path;
    }

    public final void Oxx0IOOO(@OXOo.oOoXoXO Path path) {
        this.f29273oxoX = path;
    }

    @OXOo.oOoXoXO
    public final Path X0o0xo() {
        return this.f29273oxoX;
    }

    public final int XO() {
        return this.f29271II0xO0;
    }

    public final void oIX0oI(@OXOo.OOXIXo Exception exception) {
        Throwable initCause;
        kotlin.jvm.internal.IIX0o.x0xO0oo(exception, "exception");
        this.f29271II0xO0++;
        if (this.f29270I0Io.size() < this.f29272oIX0oI) {
            if (this.f29273oxoX != null) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.ooXIXxIX.oIX0oI();
                initCause = OOXIXo.oIX0oI(String.valueOf(this.f29273oxoX)).initCause(exception);
                kotlin.jvm.internal.IIX0o.x0XOIxOo(initCause, "null cannot be cast to non-null type java.nio.file.FileSystemException");
                exception = xoIox.oIX0oI(initCause);
            }
            this.f29270I0Io.add(exception);
        }
    }

    @OXOo.OOXIXo
    public final List<Exception> oxoX() {
        return this.f29270I0Io;
    }

    public oOoXoXO(int i) {
        this.f29272oIX0oI = i;
        this.f29270I0Io = new ArrayList();
    }

    public /* synthetic */ oOoXoXO(int i, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 64 : i);
    }
}
