package kotlinx.serialization;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.o0;
import kotlin.oXIO0o0XI;
import kotlinx.serialization.descriptors.II0XooXoX;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.oxoX;

/* loaded from: classes6.dex */
public final class PolymorphicSerializer<T> extends kotlinx.serialization.internal.II0xO0<T> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final X0IIOO f30551I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public List<? extends Annotation> f30552II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlin.reflect.oxoX<T> f30553oIX0oI;

    public PolymorphicSerializer(@OXOo.OOXIXo kotlin.reflect.oxoX<T> baseClass) {
        IIX0o.x0xO0oo(baseClass, "baseClass");
        this.f30553oIX0oI = baseClass;
        this.f30552II0xO0 = CollectionsKt__CollectionsKt.ooXIXxIX();
        this.f30551I0Io = XIxXXX0x0.I0Io(LazyThreadSafetyMode.PUBLICATION, new Oox.oIX0oI<kotlinx.serialization.descriptors.XO>(this) { // from class: kotlinx.serialization.PolymorphicSerializer$descriptor$2
            final /* synthetic */ PolymorphicSerializer<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final kotlinx.serialization.descriptors.XO invoke() {
                final PolymorphicSerializer<T> polymorphicSerializer = this.this$0;
                return kotlinx.serialization.descriptors.II0xO0.X0o0xo(SerialDescriptorsKt.X0o0xo("kotlinx.serialization.Polymorphic", oxoX.oIX0oI.f30605oIX0oI, new kotlinx.serialization.descriptors.XO[0], new Oox.oOoXoXO<kotlinx.serialization.descriptors.oIX0oI, oXIO0o0XI>() { // from class: kotlinx.serialization.PolymorphicSerializer$descriptor$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(kotlinx.serialization.descriptors.oIX0oI oix0oi) {
                        invoke2(oix0oi);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OXOo.OOXIXo kotlinx.serialization.descriptors.oIX0oI buildSerialDescriptor) {
                        List<? extends Annotation> list;
                        IIX0o.x0xO0oo(buildSerialDescriptor, "$this$buildSerialDescriptor");
                        kotlinx.serialization.descriptors.oIX0oI.II0xO0(buildSerialDescriptor, "type", xx.oOoXoXO.oo(oxxXoxO.f29356oIX0oI).oIX0oI(), null, false, 12, null);
                        kotlinx.serialization.descriptors.oIX0oI.II0xO0(buildSerialDescriptor, "value", SerialDescriptorsKt.XO("kotlinx.serialization.Polymorphic<" + polymorphicSerializer.xoIox().xoXoI() + kotlin.text.XIxXXX0x0.f29545XO, II0XooXoX.oIX0oI.f30568oIX0oI, new kotlinx.serialization.descriptors.XO[0], null, 8, null), null, false, 12, null);
                        list = polymorphicSerializer.f30552II0xO0;
                        buildSerialDescriptor.oOoXoXO(list);
                    }
                }), this.this$0.xoIox());
            }
        });
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return (kotlinx.serialization.descriptors.XO) this.f30551I0Io.getValue();
    }

    @OXOo.OOXIXo
    public String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + xoIox() + HexStringBuilder.COMMENT_END_CHAR;
    }

    @Override // kotlinx.serialization.internal.II0xO0
    @OXOo.OOXIXo
    public kotlin.reflect.oxoX<T> xoIox() {
        return this.f30553oIX0oI;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @o0
    public PolymorphicSerializer(@OXOo.OOXIXo kotlin.reflect.oxoX<T> baseClass, @OXOo.OOXIXo Annotation[] classAnnotations) {
        this(baseClass);
        IIX0o.x0xO0oo(baseClass, "baseClass");
        IIX0o.x0xO0oo(classAnnotations, "classAnnotations");
        this.f30552II0xO0 = kotlin.collections.ooOOo0oXI.oI0IIXIo(classAnnotations);
    }
}
