package kotlinx.serialization.internal;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlinx.serialization.descriptors.XO;
import kotlinx.serialization.descriptors.xxIXOIIO;

@kotlinx.serialization.oxoX
@kotlin.jvm.internal.XX({"SMAP\nCollectionDescriptors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollectionDescriptors.kt\nkotlinx/serialization/internal/ListLikeDescriptor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,138:1\n1#2:139\n*E\n"})
/* loaded from: classes6.dex */
public abstract class XX0 implements kotlinx.serialization.descriptors.XO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f30705II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO f30706oIX0oI;

    public /* synthetic */ XX0(kotlinx.serialization.descriptors.XO xo2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(xo2);
    }

    @Override // kotlinx.serialization.descriptors.XO
    public boolean I0Io() {
        return XO.oIX0oI.Oxx0IOOO(this);
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public List<Annotation> II0XooXoX(int i) {
        if (i >= 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        throw new IllegalArgumentException(("Illegal index " + i + ", " + xxIXOIIO() + " expects only non-negative indices").toString());
    }

    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO II0xO0() {
        return this.f30706oIX0oI;
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public String Oxx0IOOO(int i) {
        return String.valueOf(i);
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO X0o0xo(int i) {
        if (i >= 0) {
            return this.f30706oIX0oI;
        }
        throw new IllegalArgumentException(("Illegal index " + i + ", " + xxIXOIIO() + " expects only non-negative indices").toString());
    }

    @Override // kotlinx.serialization.descriptors.XO
    public int XO() {
        return this.f30705II0xO0;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XX0)) {
            return false;
        }
        XX0 xx02 = (XX0) obj;
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f30706oIX0oI, xx02.f30706oIX0oI) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(xxIXOIIO(), xx02.xxIXOIIO())) {
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
        return (this.f30706oIX0oI.hashCode() * 31) + xxIXOIIO().hashCode();
    }

    @Override // kotlinx.serialization.descriptors.XO
    public boolean isInline() {
        return XO.oIX0oI.XO(this);
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.II0XooXoX oIX0oI() {
        return xxIXOIIO.II0xO0.f30609oIX0oI;
    }

    @Override // kotlinx.serialization.descriptors.XO
    public int oxoX(@OXOo.OOXIXo String name) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(name, "name");
        Integer XXoOx02 = kotlin.text.o00.XXoOx0(name);
        if (XXoOx02 != null) {
            return XXoOx02.intValue();
        }
        throw new IllegalArgumentException(name + " is not a valid list index");
    }

    @OXOo.OOXIXo
    public String toString() {
        return xxIXOIIO() + HexStringBuilder.COMMENT_BEGIN_CHAR + this.f30706oIX0oI + HexStringBuilder.COMMENT_END_CHAR;
    }

    @Override // kotlinx.serialization.descriptors.XO
    public boolean xoIox(int i) {
        if (i >= 0) {
            return false;
        }
        throw new IllegalArgumentException(("Illegal index " + i + ", " + xxIXOIIO() + " expects only non-negative indices").toString());
    }

    public XX0(kotlinx.serialization.descriptors.XO xo2) {
        this.f30706oIX0oI = xo2;
        this.f30705II0xO0 = 1;
    }
}
