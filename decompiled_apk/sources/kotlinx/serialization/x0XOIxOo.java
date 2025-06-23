package kotlinx.serialization;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oOXoIIIo;
import kotlinx.serialization.internal.o0;

/* loaded from: classes6.dex */
public final class x0XOIxOo {
    public static final <T> T I0Io(@OXOo.OOXIXo oIX0oI oix0oi, @OXOo.OOXIXo I0Io<? extends T> deserializer, @OXOo.OOXIXo String hex) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(deserializer, "deserializer");
        IIX0o.x0xO0oo(hex, "hex");
        return (T) oix0oi.oxoX(deserializer, o0.f30722oIX0oI.II0xO0(hex));
    }

    public static final /* synthetic */ <T> String II0XooXoX(xoXoI xoxoi, T t) {
        IIX0o.x0xO0oo(xoxoi, "<this>");
        kotlinx.serialization.modules.X0o0xo serializersModule = xoxoi.getSerializersModule();
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.withModule");
        return xoxoi.II0xO0(OxxIIOOXO.ooOOo0oXI(serializersModule, null), t);
    }

    public static final /* synthetic */ <T> T II0xO0(oIX0oI oix0oi, String hex) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(hex, "hex");
        kotlinx.serialization.modules.X0o0xo serializersModule = oix0oi.getSerializersModule();
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.withModule");
        return (T) I0Io(oix0oi, OxxIIOOXO.ooOOo0oXI(serializersModule, null), hex);
    }

    @OXOo.OOXIXo
    public static final <T> String Oxx0IOOO(@OXOo.OOXIXo oIX0oI oix0oi, @OXOo.OOXIXo Oxx0xo<? super T> serializer, T t) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(serializer, "serializer");
        return o0.f30722oIX0oI.I0Io(oix0oi.oIX0oI(serializer, t), true);
    }

    public static final /* synthetic */ <T> byte[] X0o0xo(oIX0oI oix0oi, T t) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        kotlinx.serialization.modules.X0o0xo serializersModule = oix0oi.getSerializersModule();
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.withModule");
        return oix0oi.oIX0oI(OxxIIOOXO.ooOOo0oXI(serializersModule, null), t);
    }

    public static final /* synthetic */ <T> String XO(oIX0oI oix0oi, T t) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        kotlinx.serialization.modules.X0o0xo serializersModule = oix0oi.getSerializersModule();
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.withModule");
        return Oxx0IOOO(oix0oi, OxxIIOOXO.ooOOo0oXI(serializersModule, null), t);
    }

    public static final /* synthetic */ <T> T oIX0oI(oIX0oI oix0oi, byte[] bytes) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(bytes, "bytes");
        kotlinx.serialization.modules.X0o0xo serializersModule = oix0oi.getSerializersModule();
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.withModule");
        return (T) oix0oi.oxoX(OxxIIOOXO.ooOOo0oXI(serializersModule, null), bytes);
    }

    public static final /* synthetic */ <T> T oxoX(xoXoI xoxoi, String string) {
        IIX0o.x0xO0oo(xoxoi, "<this>");
        IIX0o.x0xO0oo(string, "string");
        kotlinx.serialization.modules.X0o0xo serializersModule = xoxoi.getSerializersModule();
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.withModule");
        return (T) xoxoi.I0Io(OxxIIOOXO.ooOOo0oXI(serializersModule, null), string);
    }
}
