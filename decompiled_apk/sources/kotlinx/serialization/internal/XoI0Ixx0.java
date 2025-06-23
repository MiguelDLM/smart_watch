package kotlinx.serialization.internal;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlinx.serialization.descriptors.XO;
import kotlinx.serialization.descriptors.xxIXOIIO;

@kotlin.jvm.internal.XX({"SMAP\nCollectionDescriptors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollectionDescriptors.kt\nkotlinx/serialization/internal/MapLikeDescriptor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,138:1\n1#2:139\n*E\n"})
/* loaded from: classes6.dex */
public abstract class XoI0Ixx0 implements kotlinx.serialization.descriptors.XO {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO f30711I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO f30712II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final String f30713oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final int f30714oxoX;

    public /* synthetic */ XoI0Ixx0(String str, kotlinx.serialization.descriptors.XO xo2, kotlinx.serialization.descriptors.XO xo3, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(str, xo2, xo3);
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
        return this.f30712II0xO0;
    }

    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO OOXIXo() {
        return this.f30711I0Io;
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
            int i2 = i % 2;
            if (i2 != 0) {
                if (i2 == 1) {
                    return this.f30711I0Io;
                }
                throw new IllegalStateException("Unreached");
            }
            return this.f30712II0xO0;
        }
        throw new IllegalArgumentException(("Illegal index " + i + ", " + xxIXOIIO() + " expects only non-negative indices").toString());
    }

    @Override // kotlinx.serialization.descriptors.XO
    public int XO() {
        return this.f30714oxoX;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XoI0Ixx0)) {
            return false;
        }
        XoI0Ixx0 xoI0Ixx0 = (XoI0Ixx0) obj;
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(xxIXOIIO(), xoI0Ixx0.xxIXOIIO()) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f30712II0xO0, xoI0Ixx0.f30712II0xO0) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f30711I0Io, xoI0Ixx0.f30711I0Io)) {
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
        return (((xxIXOIIO().hashCode() * 31) + this.f30712II0xO0.hashCode()) * 31) + this.f30711I0Io.hashCode();
    }

    @Override // kotlinx.serialization.descriptors.XO
    public boolean isInline() {
        return XO.oIX0oI.XO(this);
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.II0XooXoX oIX0oI() {
        return xxIXOIIO.I0Io.f30608oIX0oI;
    }

    @Override // kotlinx.serialization.descriptors.XO
    public int oxoX(@OXOo.OOXIXo String name) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(name, "name");
        Integer XXoOx02 = kotlin.text.o00.XXoOx0(name);
        if (XXoOx02 != null) {
            return XXoOx02.intValue();
        }
        throw new IllegalArgumentException(name + " is not a valid map index");
    }

    @OXOo.OOXIXo
    public String toString() {
        return xxIXOIIO() + HexStringBuilder.COMMENT_BEGIN_CHAR + this.f30712II0xO0 + ", " + this.f30711I0Io + HexStringBuilder.COMMENT_END_CHAR;
    }

    @Override // kotlinx.serialization.descriptors.XO
    public boolean xoIox(int i) {
        if (i >= 0) {
            return false;
        }
        throw new IllegalArgumentException(("Illegal index " + i + ", " + xxIXOIIO() + " expects only non-negative indices").toString());
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public String xxIXOIIO() {
        return this.f30713oIX0oI;
    }

    public XoI0Ixx0(String str, kotlinx.serialization.descriptors.XO xo2, kotlinx.serialization.descriptors.XO xo3) {
        this.f30713oIX0oI = str;
        this.f30712II0xO0 = xo2;
        this.f30711I0Io = xo3;
        this.f30714oxoX = 2;
    }
}
