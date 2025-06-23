package kotlin.jvm.internal;

import java.util.Collection;
import kotlin.jvm.KotlinReflectionNotSupportedError;

@kotlin.oxxXoxO(version = "1.1")
/* loaded from: classes6.dex */
public final class Xx000oIo implements Oxx0xo {

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final String f29321Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Class<?> f29322XO;

    public Xx000oIo(@OXOo.OOXIXo Class<?> jClass, @OXOo.OOXIXo String moduleName) {
        IIX0o.x0xO0oo(jClass, "jClass");
        IIX0o.x0xO0oo(moduleName, "moduleName");
        this.f29322XO = jClass;
        this.f29321Oo = moduleName;
    }

    @Override // kotlin.reflect.II0XooXoX
    @OXOo.OOXIXo
    public Collection<kotlin.reflect.I0Io<?>> II0xO0() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if ((obj instanceof Xx000oIo) && IIX0o.Oxx0IOOO(oI0IIXIo(), ((Xx000oIo) obj).oI0IIXIo())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return oI0IIXIo().hashCode();
    }

    @Override // kotlin.jvm.internal.Oxx0xo
    @OXOo.OOXIXo
    public Class<?> oI0IIXIo() {
        return this.f29322XO;
    }

    @OXOo.OOXIXo
    public String toString() {
        return oI0IIXIo().toString() + IO.f29280II0xO0;
    }
}
