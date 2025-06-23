package xx;

import OXOo.OOXIXo;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.OO0x0xX;
import kotlin.OOXIxO0;
import kotlin.OX00O0xII;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.XI0oooXX;
import kotlin.XX0xXo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.O0xOxO;
import kotlin.jvm.internal.OI0;
import kotlin.jvm.internal.XxX0x0xxx;
import kotlin.jvm.internal.oo0xXOI0I;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.jvm.internal.x0XOIxOo;
import kotlin.jvm.internal.x0xO0oo;
import kotlin.jvm.internal.xoXoI;
import kotlin.oI0IIXIo;
import kotlin.oXIO0o0XI;
import kotlin.time.oxoX;
import kotlin.x0xO;
import kotlin.xX0IIXIx0;
import kotlin.xxIO;
import kotlinx.serialization.Oxx0IOOO;
import kotlinx.serialization.internal.II0XooXoX;
import kotlinx.serialization.internal.IXxxXO;
import kotlinx.serialization.internal.IoXIXo;
import kotlinx.serialization.internal.Ioxxx;
import kotlinx.serialization.internal.Ix00oIoI;
import kotlinx.serialization.internal.IxIX0I;
import kotlinx.serialization.internal.MapEntrySerializer;
import kotlinx.serialization.internal.OIOoIIOIx;
import kotlinx.serialization.internal.Ox0O;
import kotlinx.serialization.internal.Oxx0xo;
import kotlinx.serialization.internal.PairSerializer;
import kotlinx.serialization.internal.TripleSerializer;
import kotlinx.serialization.internal.XI0IXoo;
import kotlinx.serialization.internal.XIXIX;
import kotlinx.serialization.internal.XIo0oOXIx;
import kotlinx.serialization.internal.XIxXXX0x0;
import kotlinx.serialization.internal.XO;
import kotlinx.serialization.internal.XOxIOxOx;
import kotlinx.serialization.internal.Xo0;
import kotlinx.serialization.internal.oI;
import kotlinx.serialization.internal.oOoIIO0;
import kotlinx.serialization.internal.oX;
import kotlinx.serialization.internal.ooXIXxIX;
import kotlinx.serialization.internal.oxXx0IX;
import kotlinx.serialization.internal.x0OIX00oO;
import kotlinx.serialization.internal.xI;
import kotlinx.serialization.internal.xI0oxI00;
import kotlinx.serialization.internal.xXOx;
import kotlinx.serialization.internal.xXoOI00O;
import kotlinx.serialization.internal.xx0X0;
import kotlinx.serialization.internal.xxIXOIIO;
import kotlinx.serialization.internal.xxOXOOoIX;
import kotlinx.serialization.internal.xxX;
import kotlinx.serialization.oxoX;

/* loaded from: classes6.dex */
public final class oOoXoXO {
    @OOXIXo
    public static final Oxx0IOOO<boolean[]> I0Io() {
        return II0XooXoX.f30625I0Io;
    }

    @OOXIXo
    public static final Oxx0IOOO<int[]> II0XooXoX() {
        return XOxIOxOx.f30704I0Io;
    }

    @oxoX
    public static final /* synthetic */ <T, E extends T> Oxx0IOOO<E[]> II0xO0(Oxx0IOOO<E> elementSerializer) {
        IIX0o.x0xO0oo(elementSerializer, "elementSerializer");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        return oIX0oI(IO.oxoX(Object.class), elementSerializer);
    }

    @OOXIXo
    public static final Oxx0IOOO<Float> IIX0o(@OOXIXo O0xOxO o0xOxO) {
        IIX0o.x0xO0oo(o0xOxO, "<this>");
        return xI.f30754oIX0oI;
    }

    @OOXIXo
    public static final <T> Oxx0IOOO<T> IIXOooo(@OOXIXo Oxx0IOOO<T> oxx0IOOO) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        if (!oxx0IOOO.oIX0oI().I0Io()) {
            return new Ioxxx(oxx0IOOO);
        }
        return oxx0IOOO;
    }

    @oxoX
    @OOXIXo
    @oI0IIXIo
    public static final Oxx0IOOO<OO0x0xX> IXxxXO() {
        return OIOoIIOIx.f30650I0Io;
    }

    @OOXIXo
    public static final Oxx0IOOO<kotlin.time.oxoX> IoOoX(@OOXIXo oxoX.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return xxX.f30777oIX0oI;
    }

    @OOXIXo
    public static final Oxx0IOOO<XI0oooXX> O0xOxO(@OOXIXo XI0oooXX.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return Ix00oIoI.f30638oIX0oI;
    }

    @OOXIXo
    public static final <K, V> Oxx0IOOO<Map.Entry<K, V>> OOXIXo(@OOXIXo Oxx0IOOO<K> keySerializer, @OOXIXo Oxx0IOOO<V> valueSerializer) {
        IIX0o.x0xO0oo(keySerializer, "keySerializer");
        IIX0o.x0xO0oo(valueSerializer, "valueSerializer");
        return new MapEntrySerializer(keySerializer, valueSerializer);
    }

    @OOXIXo
    public static final <A, B, C> Oxx0IOOO<Triple<A, B, C>> Oo(@OOXIXo Oxx0IOOO<A> aSerializer, @OOXIXo Oxx0IOOO<B> bSerializer, @OOXIXo Oxx0IOOO<C> cSerializer) {
        IIX0o.x0xO0oo(aSerializer, "aSerializer");
        IIX0o.x0xO0oo(bSerializer, "bSerializer");
        IIX0o.x0xO0oo(cSerializer, "cSerializer");
        return new TripleSerializer(aSerializer, bSerializer, cSerializer);
    }

    @OOXIXo
    public static final Oxx0IOOO<xxIO> OxI(@OOXIXo xxIO.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return oOoIIO0.f30731oIX0oI;
    }

    @OOXIXo
    public static final Oxx0IOOO<float[]> Oxx0IOOO() {
        return ooXIXxIX.f30740I0Io;
    }

    @kotlinx.serialization.oxoX
    @OOXIXo
    @oI0IIXIo
    public static final Oxx0IOOO<XX0xXo> Oxx0xo() {
        return IxIX0I.f30639I0Io;
    }

    @kotlinx.serialization.oxoX
    @OOXIXo
    @oI0IIXIo
    public static final Oxx0IOOO<xX0IIXIx0> OxxIIOOXO() {
        return IoXIXo.f30634I0Io;
    }

    @OOXIXo
    public static final Oxx0IOOO<OX00O0xII> X0IIOO(@OOXIXo OX00O0xII.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return xxOXOOoIX.f30775oIX0oI;
    }

    @OOXIXo
    public static final Oxx0IOOO<char[]> X0o0xo() {
        return IXxxXO.f30633I0Io;
    }

    @OOXIXo
    public static final Oxx0IOOO<oXIO0o0XI> XI0IXoo(@OOXIXo oXIO0o0XI oxio0o0xi) {
        IIX0o.x0xO0oo(oxio0o0xi, "<this>");
        return xXoOI00O.f30764II0xO0;
    }

    @OOXIXo
    public static final Oxx0IOOO<Boolean> XIxXXX0x0(@OOXIXo kotlin.jvm.internal.oOoXoXO oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "<this>");
        return xxIXOIIO.f30773oIX0oI;
    }

    @OOXIXo
    public static final Oxx0IOOO<double[]> XO() {
        return XI0IXoo.f30694I0Io;
    }

    @OOXIXo
    public static final Oxx0IOOO<Character> XxX0x0xxx(@OOXIXo x0xO0oo x0xo0oo) {
        IIX0o.x0xO0oo(x0xo0oo, "<this>");
        return Oxx0xo.f30665oIX0oI;
    }

    @OOXIXo
    public static final Oxx0IOOO<x0xO> o00(@OOXIXo x0xO.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return x0OIX00oO.f30746oIX0oI;
    }

    @kotlinx.serialization.oxoX
    @OOXIXo
    @oI0IIXIo
    public static final Oxx0IOOO<OOXIxO0> oI0IIXIo() {
        return oI.f30727I0Io;
    }

    @kotlinx.serialization.oxoX
    @OOXIXo
    public static final <T, E extends T> Oxx0IOOO<E[]> oIX0oI(@OOXIXo kotlin.reflect.oxoX<T> kClass, @OOXIXo Oxx0IOOO<E> elementSerializer) {
        IIX0o.x0xO0oo(kClass, "kClass");
        IIX0o.x0xO0oo(elementSerializer, "elementSerializer");
        return new XIXIX(kClass, elementSerializer);
    }

    @OOXIXo
    public static final <T> Oxx0IOOO<Set<T>> oO(@OOXIXo Oxx0IOOO<T> elementSerializer) {
        IIX0o.x0xO0oo(elementSerializer, "elementSerializer");
        return new xXOx(elementSerializer);
    }

    @OOXIXo
    public static final <K, V> Oxx0IOOO<Map<K, V>> oOoXoXO(@OOXIXo Oxx0IOOO<K> keySerializer, @OOXIXo Oxx0IOOO<V> valueSerializer) {
        IIX0o.x0xO0oo(keySerializer, "keySerializer");
        IIX0o.x0xO0oo(valueSerializer, "valueSerializer");
        return new oxXx0IX(keySerializer, valueSerializer);
    }

    @OOXIXo
    public static final Oxx0IOOO<String> oo(@OOXIXo oxxXoxO oxxxoxo) {
        IIX0o.x0xO0oo(oxxxoxo, "<this>");
        return xI0oxI00.f30756oIX0oI;
    }

    @OOXIXo
    public static final Oxx0IOOO<Short> oo0xXOI0I(@OOXIXo OI0 oi0) {
        IIX0o.x0xO0oo(oi0, "<this>");
        return xx0X0.f30770oIX0oI;
    }

    @kotlinx.serialization.oxoX
    @OOXIXo
    public static final Oxx0IOOO ooOOo0oXI() {
        return XIo0oOXIx.f30700oIX0oI;
    }

    @OOXIXo
    public static final Oxx0IOOO<Integer> ooXIXxIX(@OOXIXo XxX0x0xxx xxX0x0xxx) {
        IIX0o.x0xO0oo(xxX0x0xxx, "<this>");
        return kotlinx.serialization.internal.OI0.f30649oIX0oI;
    }

    @OOXIXo
    public static final Oxx0IOOO<byte[]> oxoX() {
        return kotlinx.serialization.internal.OOXIXo.f30654I0Io;
    }

    @OOXIXo
    public static final <K, V> Oxx0IOOO<Pair<K, V>> x0XOIxOo(@OOXIXo Oxx0IOOO<K> keySerializer, @OOXIXo Oxx0IOOO<V> valueSerializer) {
        IIX0o.x0xO0oo(keySerializer, "keySerializer");
        IIX0o.x0xO0oo(valueSerializer, "valueSerializer");
        return new PairSerializer(keySerializer, valueSerializer);
    }

    @OOXIXo
    public static final Oxx0IOOO<short[]> x0xO0oo() {
        return Ox0O.f30659I0Io;
    }

    @OOXIXo
    public static final Oxx0IOOO<Long> xI(@OOXIXo oo0xXOI0I oo0xxoi0i) {
        IIX0o.x0xO0oo(oo0xxoi0i, "<this>");
        return Xo0.f30710oIX0oI;
    }

    @OOXIXo
    public static final Oxx0IOOO<Double> xXxxox0I(@OOXIXo xoXoI xoxoi) {
        IIX0o.x0xO0oo(xoxoi, "<this>");
        return XIxXXX0x0.f30702oIX0oI;
    }

    @OOXIXo
    public static final Oxx0IOOO<long[]> xoIox() {
        return oX.f30734I0Io;
    }

    @OOXIXo
    public static final <T> Oxx0IOOO<List<T>> xxIXOIIO(@OOXIXo Oxx0IOOO<T> elementSerializer) {
        IIX0o.x0xO0oo(elementSerializer, "elementSerializer");
        return new XO(elementSerializer);
    }

    @OOXIXo
    public static final Oxx0IOOO<Byte> xxX(@OOXIXo x0XOIxOo x0xoixoo) {
        IIX0o.x0xO0oo(x0xoixoo, "<this>");
        return kotlinx.serialization.internal.oOoXoXO.f30733oIX0oI;
    }

    public static /* synthetic */ void xoXoI(Oxx0IOOO oxx0IOOO) {
    }
}
