package kotlinx.serialization.internal;

import java.lang.Enum;
import java.util.Arrays;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlinx.serialization.SerializationException;

@kotlin.jvm.internal.XX({"SMAP\nEnums.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Enums.kt\nkotlinx/serialization/internal/EnumSerializer\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,151:1\n13309#2,2:152\n*S KotlinDebug\n*F\n+ 1 Enums.kt\nkotlinx/serialization/internal/EnumSerializer\n*L\n123#1:152,2\n*E\n"})
@kotlin.o0
/* loaded from: classes6.dex */
public final class EnumSerializer<T extends Enum<T>> implements kotlinx.serialization.Oxx0IOOO<T> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlin.X0IIOO f30618I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public kotlinx.serialization.descriptors.XO f30619II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final T[] f30620oIX0oI;

    public EnumSerializer(@OXOo.OOXIXo final String serialName, @OXOo.OOXIXo T[] values) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(serialName, "serialName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(values, "values");
        this.f30620oIX0oI = values;
        this.f30618I0Io = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<kotlinx.serialization.descriptors.XO>(this) { // from class: kotlinx.serialization.internal.EnumSerializer$descriptor$2
            final /* synthetic */ EnumSerializer<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final kotlinx.serialization.descriptors.XO invoke() {
                kotlinx.serialization.descriptors.XO xo2;
                kotlinx.serialization.descriptors.XO II0XooXoX2;
                xo2 = this.this$0.f30619II0xO0;
                if (xo2 != null) {
                    return xo2;
                }
                II0XooXoX2 = this.this$0.II0XooXoX(serialName);
                return II0XooXoX2;
            }
        });
    }

    public final kotlinx.serialization.descriptors.XO II0XooXoX(String str) {
        EnumDescriptor enumDescriptor = new EnumDescriptor(str, this.f30620oIX0oI.length);
        for (T t : this.f30620oIX0oI) {
            PluginGeneratedSerialDescriptor.ooOOo0oXI(enumDescriptor, t.name(), false, 2, null);
        }
        return enumDescriptor;
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return (kotlinx.serialization.descriptors.XO) this.f30618I0Io.getValue();
    }

    @OXOo.OOXIXo
    public String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + oIX0oI().xxIXOIIO() + kotlin.text.XIxXXX0x0.f29545XO;
    }

    @Override // kotlinx.serialization.Oxx0xo
    /* renamed from: xoIox, reason: merged with bridge method [inline-methods] */
    public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo T value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        int XxOX = ArraysKt___ArraysKt.XxOX(this.f30620oIX0oI, value);
        if (XxOX != -1) {
            encoder.encodeEnum(oIX0oI(), XxOX);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        sb.append(" is not a valid enum ");
        sb.append(oIX0oI().xxIXOIIO());
        sb.append(", must be one of ");
        String arrays = Arrays.toString(this.f30620oIX0oI);
        kotlin.jvm.internal.IIX0o.oO(arrays, "toString(...)");
        sb.append(arrays);
        throw new SerializationException(sb.toString());
    }

    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    /* renamed from: xxIXOIIO, reason: merged with bridge method [inline-methods] */
    public T oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        int decodeEnum = decoder.decodeEnum(oIX0oI());
        if (decodeEnum >= 0) {
            T[] tArr = this.f30620oIX0oI;
            if (decodeEnum < tArr.length) {
                return tArr[decodeEnum];
            }
        }
        throw new SerializationException(decodeEnum + " is not among valid " + oIX0oI().xxIXOIIO() + " enum values, values size is " + this.f30620oIX0oI.length);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumSerializer(@OXOo.OOXIXo String serialName, @OXOo.OOXIXo T[] values, @OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor) {
        this(serialName, values);
        kotlin.jvm.internal.IIX0o.x0xO0oo(serialName, "serialName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(values, "values");
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        this.f30619II0xO0 = descriptor;
    }
}
