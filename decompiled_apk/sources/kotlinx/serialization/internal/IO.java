package kotlinx.serialization.internal;

import java.util.Arrays;

@kotlin.jvm.internal.XX({"SMAP\nInlineClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InlineClassDescriptor.kt\nkotlinx/serialization/internal/InlineClassDescriptor\n+ 2 PluginGeneratedSerialDescriptor.kt\nkotlinx/serialization/internal/PluginGeneratedSerialDescriptorKt\n*L\n1#1,44:1\n111#2,10:45\n*S KotlinDebug\n*F\n+ 1 InlineClassDescriptor.kt\nkotlinx/serialization/internal/InlineClassDescriptor\n*L\n22#1:45,10\n*E\n"})
@kotlin.o0
/* loaded from: classes6.dex */
public final class IO extends PluginGeneratedSerialDescriptor {

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public final boolean f30630ooOOo0oXI;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IO(@OXOo.OOXIXo String name, @OXOo.OOXIXo oo0xXOI0I<?> generatedSerializer) {
        super(name, generatedSerializer, 1);
        kotlin.jvm.internal.IIX0o.x0xO0oo(name, "name");
        kotlin.jvm.internal.IIX0o.x0xO0oo(generatedSerializer, "generatedSerializer");
        this.f30630ooOOo0oXI = true;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IO) {
            kotlinx.serialization.descriptors.XO xo2 = (kotlinx.serialization.descriptors.XO) obj;
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(xxIXOIIO(), xo2.xxIXOIIO())) {
                IO io2 = (IO) obj;
                if (io2.isInline() && Arrays.equals(x0xO0oo(), io2.x0xO0oo()) && XO() == xo2.XO()) {
                    int XO2 = XO();
                    for (int i = 0; i < XO2; i++) {
                        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(X0o0xo(i).xxIXOIIO(), xo2.X0o0xo(i).xxIXOIIO()) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(X0o0xo(i).oIX0oI(), xo2.X0o0xo(i).oIX0oI())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public int hashCode() {
        return super.hashCode() * 31;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.XO
    public boolean isInline() {
        return this.f30630ooOOo0oXI;
    }
}
