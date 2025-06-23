package kotlinx.serialization.descriptors;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.XIxXXX0x0;

/* loaded from: classes6.dex */
public final class I0Io implements XO {

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public final String f30564I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    @XO0OX.XO
    public final kotlin.reflect.oxoX<?> f30565II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final XO f30566oIX0oI;

    public I0Io(@OOXIXo XO original, @OOXIXo kotlin.reflect.oxoX<?> kClass) {
        IIX0o.x0xO0oo(original, "original");
        IIX0o.x0xO0oo(kClass, "kClass");
        this.f30566oIX0oI = original;
        this.f30565II0xO0 = kClass;
        this.f30564I0Io = original.xxIXOIIO() + XIxXXX0x0.f29542X0o0xo + kClass.xoXoI() + XIxXXX0x0.f29545XO;
    }

    @Override // kotlinx.serialization.descriptors.XO
    public boolean I0Io() {
        return this.f30566oIX0oI.I0Io();
    }

    @Override // kotlinx.serialization.descriptors.XO
    @kotlinx.serialization.oxoX
    @OOXIXo
    public List<Annotation> II0XooXoX(int i) {
        return this.f30566oIX0oI.II0XooXoX(i);
    }

    @Override // kotlinx.serialization.descriptors.XO
    @kotlinx.serialization.oxoX
    @OOXIXo
    public String Oxx0IOOO(int i) {
        return this.f30566oIX0oI.Oxx0IOOO(i);
    }

    @Override // kotlinx.serialization.descriptors.XO
    @kotlinx.serialization.oxoX
    @OOXIXo
    public XO X0o0xo(int i) {
        return this.f30566oIX0oI.X0o0xo(i);
    }

    @Override // kotlinx.serialization.descriptors.XO
    public int XO() {
        return this.f30566oIX0oI.XO();
    }

    public boolean equals(@oOoXoXO Object obj) {
        I0Io i0Io;
        if (obj instanceof I0Io) {
            i0Io = (I0Io) obj;
        } else {
            i0Io = null;
        }
        if (i0Io == null || !IIX0o.Oxx0IOOO(this.f30566oIX0oI, i0Io.f30566oIX0oI) || !IIX0o.Oxx0IOOO(i0Io.f30565II0xO0, this.f30565II0xO0)) {
            return false;
        }
        return true;
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OOXIXo
    public List<Annotation> getAnnotations() {
        return this.f30566oIX0oI.getAnnotations();
    }

    public int hashCode() {
        return (this.f30565II0xO0.hashCode() * 31) + xxIXOIIO().hashCode();
    }

    @Override // kotlinx.serialization.descriptors.XO
    public boolean isInline() {
        return this.f30566oIX0oI.isInline();
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OOXIXo
    public II0XooXoX oIX0oI() {
        return this.f30566oIX0oI.oIX0oI();
    }

    @Override // kotlinx.serialization.descriptors.XO
    @kotlinx.serialization.oxoX
    public int oxoX(@OOXIXo String name) {
        IIX0o.x0xO0oo(name, "name");
        return this.f30566oIX0oI.oxoX(name);
    }

    @OOXIXo
    public String toString() {
        return "ContextDescriptor(kClass: " + this.f30565II0xO0 + ", original: " + this.f30566oIX0oI + HexStringBuilder.COMMENT_END_CHAR;
    }

    @Override // kotlinx.serialization.descriptors.XO
    @kotlinx.serialization.oxoX
    public boolean xoIox(int i) {
        return this.f30566oIX0oI.xoIox(i);
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OOXIXo
    public String xxIXOIIO() {
        return this.f30564I0Io;
    }
}
