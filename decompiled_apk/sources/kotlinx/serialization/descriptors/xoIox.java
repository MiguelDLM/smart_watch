package kotlinx.serialization.descriptors;

import OXOo.OOXIXo;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class xoIox implements XO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final /* synthetic */ XO f30606II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final String f30607oIX0oI;

    public xoIox(@OOXIXo String serialName, @OOXIXo XO original) {
        IIX0o.x0xO0oo(serialName, "serialName");
        IIX0o.x0xO0oo(original, "original");
        this.f30607oIX0oI = serialName;
        this.f30606II0xO0 = original;
    }

    @Override // kotlinx.serialization.descriptors.XO
    public boolean I0Io() {
        return this.f30606II0xO0.I0Io();
    }

    @Override // kotlinx.serialization.descriptors.XO
    @kotlinx.serialization.oxoX
    @OOXIXo
    public List<Annotation> II0XooXoX(int i) {
        return this.f30606II0xO0.II0XooXoX(i);
    }

    @Override // kotlinx.serialization.descriptors.XO
    @kotlinx.serialization.oxoX
    @OOXIXo
    public String Oxx0IOOO(int i) {
        return this.f30606II0xO0.Oxx0IOOO(i);
    }

    @Override // kotlinx.serialization.descriptors.XO
    @kotlinx.serialization.oxoX
    @OOXIXo
    public XO X0o0xo(int i) {
        return this.f30606II0xO0.X0o0xo(i);
    }

    @Override // kotlinx.serialization.descriptors.XO
    public int XO() {
        return this.f30606II0xO0.XO();
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OOXIXo
    public List<Annotation> getAnnotations() {
        return this.f30606II0xO0.getAnnotations();
    }

    @Override // kotlinx.serialization.descriptors.XO
    public boolean isInline() {
        return this.f30606II0xO0.isInline();
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OOXIXo
    public II0XooXoX oIX0oI() {
        return this.f30606II0xO0.oIX0oI();
    }

    @Override // kotlinx.serialization.descriptors.XO
    @kotlinx.serialization.oxoX
    public int oxoX(@OOXIXo String name) {
        IIX0o.x0xO0oo(name, "name");
        return this.f30606II0xO0.oxoX(name);
    }

    @Override // kotlinx.serialization.descriptors.XO
    @kotlinx.serialization.oxoX
    public boolean xoIox(int i) {
        return this.f30606II0xO0.xoIox(i);
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OOXIXo
    public String xxIXOIIO() {
        return this.f30607oIX0oI;
    }
}
