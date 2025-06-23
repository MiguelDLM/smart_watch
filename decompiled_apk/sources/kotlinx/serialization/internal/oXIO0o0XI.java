package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;

/* loaded from: classes6.dex */
public final class oXIO0o0XI implements kotlinx.serialization.descriptors.XO, x0XOIxOo {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Set<String> f30735I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final String f30736II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO f30737oIX0oI;

    public oXIO0o0XI(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO original) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(original, "original");
        this.f30737oIX0oI = original;
        this.f30736II0xO0 = original.xxIXOIIO() + '?';
        this.f30735I0Io = O00XxXI.oIX0oI(original);
    }

    @Override // kotlinx.serialization.descriptors.XO
    public boolean I0Io() {
        return true;
    }

    @Override // kotlinx.serialization.descriptors.XO
    @kotlinx.serialization.oxoX
    @OXOo.OOXIXo
    public List<Annotation> II0XooXoX(int i) {
        return this.f30737oIX0oI.II0XooXoX(i);
    }

    @Override // kotlinx.serialization.internal.x0XOIxOo
    @OXOo.OOXIXo
    public Set<String> II0xO0() {
        return this.f30735I0Io;
    }

    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO OOXIXo() {
        return this.f30737oIX0oI;
    }

    @Override // kotlinx.serialization.descriptors.XO
    @kotlinx.serialization.oxoX
    @OXOo.OOXIXo
    public String Oxx0IOOO(int i) {
        return this.f30737oIX0oI.Oxx0IOOO(i);
    }

    @Override // kotlinx.serialization.descriptors.XO
    @kotlinx.serialization.oxoX
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO X0o0xo(int i) {
        return this.f30737oIX0oI.X0o0xo(i);
    }

    @Override // kotlinx.serialization.descriptors.XO
    public int XO() {
        return this.f30737oIX0oI.XO();
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof oXIO0o0XI) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f30737oIX0oI, ((oXIO0o0XI) obj).f30737oIX0oI)) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public List<Annotation> getAnnotations() {
        return this.f30737oIX0oI.getAnnotations();
    }

    public int hashCode() {
        return this.f30737oIX0oI.hashCode() * 31;
    }

    @Override // kotlinx.serialization.descriptors.XO
    public boolean isInline() {
        return this.f30737oIX0oI.isInline();
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.II0XooXoX oIX0oI() {
        return this.f30737oIX0oI.oIX0oI();
    }

    @Override // kotlinx.serialization.descriptors.XO
    @kotlinx.serialization.oxoX
    public int oxoX(@OXOo.OOXIXo String name) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(name, "name");
        return this.f30737oIX0oI.oxoX(name);
    }

    @OXOo.OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f30737oIX0oI);
        sb.append('?');
        return sb.toString();
    }

    @Override // kotlinx.serialization.descriptors.XO
    @kotlinx.serialization.oxoX
    public boolean xoIox(int i) {
        return this.f30737oIX0oI.xoIox(i);
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public String xxIXOIIO() {
        return this.f30736II0xO0;
    }
}
