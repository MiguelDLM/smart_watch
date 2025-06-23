package kotlinx.serialization.internal;

import XXO0.oIX0oI;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlinx.serialization.descriptors.II0XooXoX;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.xxIXOIIO;

@kotlin.jvm.internal.XX({"SMAP\nEnums.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Enums.kt\nkotlinx/serialization/internal/EnumDescriptor\n+ 2 Platform.kt\nkotlinx/serialization/internal/PlatformKt\n+ 3 Platform.common.kt\nkotlinx/serialization/internal/Platform_commonKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,151:1\n13#2:152\n159#3:153\n1789#4,3:154\n*S KotlinDebug\n*F\n+ 1 Enums.kt\nkotlinx/serialization/internal/EnumDescriptor\n*L\n28#1:152\n46#1:153\n46#1:154,3\n*E\n"})
@kotlin.o0
/* loaded from: classes6.dex */
public final class EnumDescriptor extends PluginGeneratedSerialDescriptor {

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.II0XooXoX f30616ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlin.X0IIOO f30617x0XOIxOo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnumDescriptor(@OXOo.OOXIXo final String name, final int i) {
        super(name, null, i, 2, null);
        kotlin.jvm.internal.IIX0o.x0xO0oo(name, "name");
        this.f30616ooOOo0oXI = II0XooXoX.II0xO0.f30567oIX0oI;
        this.f30617x0XOIxOo = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<kotlinx.serialization.descriptors.XO[]>() { // from class: kotlinx.serialization.internal.EnumDescriptor$elementDescriptors$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final kotlinx.serialization.descriptors.XO[] invoke() {
                int i2 = i;
                kotlinx.serialization.descriptors.XO[] xoArr = new kotlinx.serialization.descriptors.XO[i2];
                for (int i3 = 0; i3 < i2; i3++) {
                    xoArr[i3] = SerialDescriptorsKt.XO(name + '.' + this.Oxx0IOOO(i3), xxIXOIIO.oxoX.f30611oIX0oI, new kotlinx.serialization.descriptors.XO[0], null, 8, null);
                }
                return xoArr;
            }
        });
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO X0o0xo(int i) {
        return oI0IIXIo()[i];
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof kotlinx.serialization.descriptors.XO)) {
            return false;
        }
        kotlinx.serialization.descriptors.XO xo2 = (kotlinx.serialization.descriptors.XO) obj;
        if (xo2.oIX0oI() == II0XooXoX.II0xO0.f30567oIX0oI && kotlin.jvm.internal.IIX0o.Oxx0IOOO(xxIXOIIO(), xo2.xxIXOIIO()) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(O00XxXI.oIX0oI(this), O00XxXI.oIX0oI(xo2))) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public int hashCode() {
        int i;
        int hashCode = xxIXOIIO().hashCode();
        int i2 = 1;
        for (String str : kotlinx.serialization.descriptors.Oxx0IOOO.I0Io(this)) {
            int i3 = i2 * 31;
            if (str != null) {
                i = str.hashCode();
            } else {
                i = 0;
            }
            i2 = i3 + i;
        }
        return (hashCode * 31) + i2;
    }

    public final kotlinx.serialization.descriptors.XO[] oI0IIXIo() {
        return (kotlinx.serialization.descriptors.XO[]) this.f30617x0XOIxOo.getValue();
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.II0XooXoX oIX0oI() {
        return this.f30616ooOOo0oXI;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    @OXOo.OOXIXo
    public String toString() {
        return CollectionsKt___CollectionsKt.OoIXo(kotlinx.serialization.descriptors.Oxx0IOOO.I0Io(this), ", ", xxIXOIIO() + HexStringBuilder.COMMENT_BEGIN_CHAR, oIX0oI.I0Io.f4095I0Io, 0, null, null, 56, null);
    }
}
