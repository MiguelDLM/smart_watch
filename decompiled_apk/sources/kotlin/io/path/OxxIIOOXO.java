package kotlin.io.path;

import java.nio.file.Path;
import java.util.Iterator;

/* loaded from: classes6.dex */
public final class OxxIIOOXO {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final OxxIIOOXO f29252I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Object f29253II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Path f29254oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Iterator<OxxIIOOXO> f29255oxoX;

    public OxxIIOOXO(@OXOo.OOXIXo Path path, @OXOo.oOoXoXO Object obj, @OXOo.oOoXoXO OxxIIOOXO oxxIIOOXO) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "path");
        this.f29254oIX0oI = path;
        this.f29253II0xO0 = obj;
        this.f29252I0Io = oxxIIOOXO;
    }

    @OXOo.oOoXoXO
    public final OxxIIOOXO I0Io() {
        return this.f29252I0Io;
    }

    @OXOo.oOoXoXO
    public final Object II0xO0() {
        return this.f29253II0xO0;
    }

    public final void X0o0xo(@OXOo.oOoXoXO Iterator<OxxIIOOXO> it) {
        this.f29255oxoX = it;
    }

    @OXOo.oOoXoXO
    public final Iterator<OxxIIOOXO> oIX0oI() {
        return this.f29255oxoX;
    }

    @OXOo.OOXIXo
    public final Path oxoX() {
        return this.f29254oIX0oI;
    }
}
