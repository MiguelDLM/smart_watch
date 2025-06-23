package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlinx.serialization.descriptors.XO;
import kotlinx.serialization.descriptors.xxIXOIIO;

/* loaded from: classes6.dex */
public final class OO0x0xX implements kotlinx.serialization.descriptors.XO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final OO0x0xX f30653oIX0oI = new OO0x0xX();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.serialization.descriptors.II0XooXoX f30652II0xO0 = xxIXOIIO.oxoX.f30611oIX0oI;

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f30651I0Io = "kotlin.Nothing";

    @Override // kotlinx.serialization.descriptors.XO
    public boolean I0Io() {
        return XO.oIX0oI.Oxx0IOOO(this);
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public List<Annotation> II0XooXoX(int i) {
        II0xO0();
        throw new KotlinNothingValueException();
    }

    public final Void II0xO0() {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public String Oxx0IOOO(int i) {
        II0xO0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO X0o0xo(int i) {
        II0xO0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.XO
    public int XO() {
        return 0;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        return this == obj;
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public List<Annotation> getAnnotations() {
        return XO.oIX0oI.oIX0oI(this);
    }

    public int hashCode() {
        return xxIXOIIO().hashCode() + (oIX0oI().hashCode() * 31);
    }

    @Override // kotlinx.serialization.descriptors.XO
    public boolean isInline() {
        return XO.oIX0oI.XO(this);
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.II0XooXoX oIX0oI() {
        return f30652II0xO0;
    }

    @Override // kotlinx.serialization.descriptors.XO
    public int oxoX(@OXOo.OOXIXo String name) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(name, "name");
        II0xO0();
        throw new KotlinNothingValueException();
    }

    @OXOo.OOXIXo
    public String toString() {
        return "NothingSerialDescriptor";
    }

    @Override // kotlinx.serialization.descriptors.XO
    public boolean xoIox(int i) {
        II0xO0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public String xxIXOIIO() {
        return f30651I0Io;
    }
}
