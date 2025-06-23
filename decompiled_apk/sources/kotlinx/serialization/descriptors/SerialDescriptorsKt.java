package kotlinx.serialization.descriptors;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import androidx.exifinterface.media.ExifInterface;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oOXoIIIo;
import kotlin.oXIO0o0XI;
import kotlin.reflect.Oxx0xo;
import kotlin.text.OxI;
import kotlinx.serialization.OxxIIOOXO;
import kotlinx.serialization.descriptors.xxIXOIIO;
import kotlinx.serialization.internal.IoOoX;
import kotlinx.serialization.internal.Xx000oIo;
import kotlinx.serialization.internal.xOOOX;

@XX({"SMAP\nSerialDescriptors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SerialDescriptors.kt\nkotlinx/serialization/descriptors/SerialDescriptorsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,348:1\n1#2:349\n*E\n"})
/* loaded from: classes6.dex */
public final class SerialDescriptorsKt {
    @OOXIXo
    public static final XO I0Io(@OOXIXo String serialName, @OOXIXo XO[] typeParameters, @OOXIXo oOoXoXO<? super oIX0oI, oXIO0o0XI> builderAction) {
        IIX0o.x0xO0oo(serialName, "serialName");
        IIX0o.x0xO0oo(typeParameters, "typeParameters");
        IIX0o.x0xO0oo(builderAction, "builderAction");
        if (!OxI.X0O0I0(serialName)) {
            oIX0oI oix0oi = new oIX0oI(serialName);
            builderAction.invoke(oix0oi);
            return new SerialDescriptorImpl(serialName, xxIXOIIO.oIX0oI.f30610oIX0oI, oix0oi.Oxx0IOOO().size(), ArraysKt___ArraysKt.IoXOX(typeParameters), oix0oi);
        }
        throw new IllegalArgumentException("Blank serial names are prohibited");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void II0XooXoX(oIX0oI oix0oi, String elementName, List annotations, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            annotations = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        if ((i & 4) != 0) {
            z = false;
        }
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(elementName, "elementName");
        IIX0o.x0xO0oo(annotations, "annotations");
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
        oix0oi.oIX0oI(elementName, OxxIIOOXO.xxIXOIIO(null).oIX0oI(), annotations, z);
    }

    @kotlinx.serialization.oxoX
    @OOXIXo
    public static final XO II0xO0(@OOXIXo String serialName, @OOXIXo XO original) {
        IIX0o.x0xO0oo(serialName, "serialName");
        IIX0o.x0xO0oo(original, "original");
        if (!OxI.X0O0I0(serialName)) {
            if (!(original.oIX0oI() instanceof X0o0xo)) {
                if (!IIX0o.Oxx0IOOO(serialName, original.xxIXOIIO())) {
                    return new xoIox(serialName, original);
                }
                throw new IllegalArgumentException(("The name of the wrapped descriptor (" + serialName + ") cannot be the same as the name of the original descriptor (" + original.xxIXOIIO() + HexStringBuilder.COMMENT_END_CHAR).toString());
            }
            throw new IllegalArgumentException("For primitive descriptors please use 'PrimitiveSerialDescriptor' instead");
        }
        throw new IllegalArgumentException("Blank serial names are prohibited");
    }

    @kotlinx.serialization.oxoX
    @OOXIXo
    public static final XO IXxxXO(@OOXIXo XO elementDescriptor) {
        IIX0o.x0xO0oo(elementDescriptor, "elementDescriptor");
        return new Xx000oIo(elementDescriptor);
    }

    @kotlinx.serialization.oxoX
    public static final /* synthetic */ <T> XO OOXIXo() {
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
        return oOoXoXO(OxxIIOOXO.xxIXOIIO(null).oIX0oI());
    }

    @kotlinx.serialization.oxoX
    public static final /* synthetic */ <T> XO Oo() {
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
        return IXxxXO(OxxIIOOXO.xxIXOIIO(null).oIX0oI());
    }

    public static final /* synthetic */ <T> void Oxx0IOOO(oIX0oI oix0oi, String elementName, List<? extends Annotation> annotations, boolean z) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(elementName, "elementName");
        IIX0o.x0xO0oo(annotations, "annotations");
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
        oix0oi.oIX0oI(elementName, OxxIIOOXO.xxIXOIIO(null).oIX0oI(), annotations, z);
    }

    @OOXIXo
    @kotlinx.serialization.XO
    public static final XO X0o0xo(@OOXIXo String serialName, @OOXIXo II0XooXoX kind, @OOXIXo XO[] typeParameters, @OOXIXo oOoXoXO<? super oIX0oI, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(serialName, "serialName");
        IIX0o.x0xO0oo(kind, "kind");
        IIX0o.x0xO0oo(typeParameters, "typeParameters");
        IIX0o.x0xO0oo(builder, "builder");
        if (!OxI.X0O0I0(serialName)) {
            if (!IIX0o.Oxx0IOOO(kind, xxIXOIIO.oIX0oI.f30610oIX0oI)) {
                oIX0oI oix0oi = new oIX0oI(serialName);
                builder.invoke(oix0oi);
                return new SerialDescriptorImpl(serialName, kind, oix0oi.Oxx0IOOO().size(), ArraysKt___ArraysKt.IoXOX(typeParameters), oix0oi);
            }
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        throw new IllegalArgumentException("Blank serial names are prohibited");
    }

    public static /* synthetic */ XO XO(String str, II0XooXoX iI0XooXoX, XO[] xoArr, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 8) != 0) {
            oooxoxo = new oOoXoXO<oIX0oI, oXIO0o0XI>() { // from class: kotlinx.serialization.descriptors.SerialDescriptorsKt$buildSerialDescriptor$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo oIX0oI oix0oi) {
                    IIX0o.x0xO0oo(oix0oi, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(oIX0oI oix0oi) {
                    invoke2(oix0oi);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        return X0o0xo(str, iI0XooXoX, xoArr, oooxoxo);
    }

    @OOXIXo
    public static final XO oIX0oI(@OOXIXo String serialName, @OOXIXo X0o0xo kind) {
        IIX0o.x0xO0oo(serialName, "serialName");
        IIX0o.x0xO0oo(kind, "kind");
        if (!OxI.X0O0I0(serialName)) {
            return xOOOX.oIX0oI(serialName, kind);
        }
        throw new IllegalArgumentException("Blank serial names are prohibited");
    }

    public static final /* synthetic */ <T> XO oO() {
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
        return OxxIIOOXO.xxIXOIIO(null).oIX0oI();
    }

    @kotlinx.serialization.oxoX
    @OOXIXo
    public static final XO oOoXoXO(@OOXIXo XO elementDescriptor) {
        IIX0o.x0xO0oo(elementDescriptor, "elementDescriptor");
        return new kotlinx.serialization.internal.X0o0xo(elementDescriptor);
    }

    @kotlinx.serialization.oxoX
    public static final /* synthetic */ <K, V> XO ooOOo0oXI() {
        IIX0o.OxI(6, "K");
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
        XO oIX0oI2 = OxxIIOOXO.xxIXOIIO(null).oIX0oI();
        IIX0o.OxI(6, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
        return x0XOIxOo(oIX0oI2, OxxIIOOXO.xxIXOIIO(null).oIX0oI());
    }

    public static /* synthetic */ XO oxoX(String str, XO[] xoArr, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 4) != 0) {
            oooxoxo = new oOoXoXO<oIX0oI, oXIO0o0XI>() { // from class: kotlinx.serialization.descriptors.SerialDescriptorsKt$buildClassSerialDescriptor$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo oIX0oI oix0oi) {
                    IIX0o.x0xO0oo(oix0oi, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(oIX0oI oix0oi) {
                    invoke2(oix0oi);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        return I0Io(str, xoArr, oooxoxo);
    }

    @kotlinx.serialization.oxoX
    @OOXIXo
    public static final XO x0XOIxOo(@OOXIXo XO keyDescriptor, @OOXIXo XO valueDescriptor) {
        IIX0o.x0xO0oo(keyDescriptor, "keyDescriptor");
        IIX0o.x0xO0oo(valueDescriptor, "valueDescriptor");
        return new IoOoX(keyDescriptor, valueDescriptor);
    }

    @OOXIXo
    public static final XO x0xO0oo(@OOXIXo Oxx0xo type) {
        IIX0o.x0xO0oo(type, "type");
        return OxxIIOOXO.xxIXOIIO(type).oIX0oI();
    }

    public static /* synthetic */ void xoIox(XO xo2) {
    }

    @OOXIXo
    public static final XO xxIXOIIO(@OOXIXo XO xo2) {
        IIX0o.x0xO0oo(xo2, "<this>");
        if (xo2.I0Io()) {
            return xo2;
        }
        return new kotlinx.serialization.internal.oXIO0o0XI(xo2);
    }
}
