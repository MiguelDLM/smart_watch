package xIXoO0Xx;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public interface oxoX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f34186I0Io = -3;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f34187II0xO0 = -1;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f34188oIX0oI = oIX0oI.f34191oIX0oI;

    /* loaded from: classes6.dex */
    public static final class II0xO0 {
        @kotlinx.serialization.oxoX
        public static boolean I0Io(@OOXIXo oxoX oxox) {
            return false;
        }

        public static /* synthetic */ Object II0xO0(oxoX oxox, kotlinx.serialization.descriptors.XO xo2, int i, kotlinx.serialization.I0Io i0Io, Object obj, int i2, Object obj2) {
            if (obj2 == null) {
                if ((i2 & 8) != 0) {
                    obj = null;
                }
                return oxox.decodeNullableSerializableElement(xo2, i, i0Io, obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeNullableSerializableElement");
        }

        public static int oIX0oI(@OOXIXo oxoX oxox, @OOXIXo kotlinx.serialization.descriptors.XO descriptor) {
            IIX0o.x0xO0oo(descriptor, "descriptor");
            return -1;
        }

        public static /* synthetic */ Object oxoX(oxoX oxox, kotlinx.serialization.descriptors.XO xo2, int i, kotlinx.serialization.I0Io i0Io, Object obj, int i2, Object obj2) {
            if (obj2 == null) {
                if ((i2 & 8) != 0) {
                    obj = null;
                }
                return oxox.decodeSerializableElement(xo2, i, i0Io, obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableElement");
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        public static final int f34189I0Io = -3;

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final int f34190II0xO0 = -1;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ oIX0oI f34191oIX0oI = new oIX0oI();
    }

    boolean decodeBooleanElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i);

    byte decodeByteElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i);

    char decodeCharElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i);

    int decodeCollectionSize(@OOXIXo kotlinx.serialization.descriptors.XO xo2);

    double decodeDoubleElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i);

    int decodeElementIndex(@OOXIXo kotlinx.serialization.descriptors.XO xo2);

    float decodeFloatElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i);

    @OOXIXo
    XO decodeInlineElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i);

    int decodeIntElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i);

    long decodeLongElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i);

    @kotlinx.serialization.oxoX
    @oOoXoXO
    <T> T decodeNullableSerializableElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i, @OOXIXo kotlinx.serialization.I0Io<? extends T> i0Io, @oOoXoXO T t);

    @kotlinx.serialization.oxoX
    boolean decodeSequentially();

    <T> T decodeSerializableElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i, @OOXIXo kotlinx.serialization.I0Io<? extends T> i0Io, @oOoXoXO T t);

    short decodeShortElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i);

    @OOXIXo
    String decodeStringElement(@OOXIXo kotlinx.serialization.descriptors.XO xo2, int i);

    void endStructure(@OOXIXo kotlinx.serialization.descriptors.XO xo2);

    @OOXIXo
    kotlinx.serialization.modules.X0o0xo getSerializersModule();
}
