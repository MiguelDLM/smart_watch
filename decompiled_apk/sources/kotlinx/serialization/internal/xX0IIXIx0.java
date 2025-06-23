package kotlinx.serialization.internal;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlinx.serialization.descriptors.XO;

/* loaded from: classes6.dex */
public final class xX0IIXIx0 implements kotlinx.serialization.descriptors.XO {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.X0o0xo f30761II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final String f30762oIX0oI;

    public xX0IIXIx0(@OXOo.OOXIXo String serialName, @OXOo.OOXIXo kotlinx.serialization.descriptors.X0o0xo kind) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(serialName, "serialName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(kind, "kind");
        this.f30762oIX0oI = serialName;
        this.f30761II0xO0 = kind;
    }

    private final Void II0xO0() {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

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

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    /* renamed from: OOXIXo, reason: merged with bridge method [inline-methods] */
    public kotlinx.serialization.descriptors.X0o0xo oIX0oI() {
        return this.f30761II0xO0;
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
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xX0IIXIx0)) {
            return false;
        }
        xX0IIXIx0 xx0iixix0 = (xX0IIXIx0) obj;
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(xxIXOIIO(), xx0iixix0.xxIXOIIO()) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(oIX0oI(), xx0iixix0.oIX0oI())) {
            return true;
        }
        return false;
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
    public int oxoX(@OXOo.OOXIXo String name) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(name, "name");
        II0xO0();
        throw new KotlinNothingValueException();
    }

    @OXOo.OOXIXo
    public String toString() {
        return "PrimitiveDescriptor(" + xxIXOIIO() + HexStringBuilder.COMMENT_END_CHAR;
    }

    @Override // kotlinx.serialization.descriptors.XO
    public boolean xoIox(int i) {
        II0xO0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public String xxIXOIIO() {
        return this.f30762oIX0oI;
    }
}
