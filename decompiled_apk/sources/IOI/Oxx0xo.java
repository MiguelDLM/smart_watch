package IOI;

import java.time.ZoneId;

@kotlinx.serialization.IXxxXO(with = kotlinx.datetime.serializers.oxoX.class)
/* loaded from: classes6.dex */
public final class Oxx0xo extends X0xxXX0 {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final o0IXXIx f479I0Io;

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final kotlinx.serialization.Oxx0IOOO<Oxx0xo> serializer() {
            return kotlinx.datetime.serializers.oxoX.f30542oIX0oI;
        }

        public oIX0oI() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Oxx0xo(@OXOo.OOXIXo o0IXXIx offset, @OXOo.OOXIXo ZoneId zoneId) {
        super(zoneId);
        kotlin.jvm.internal.IIX0o.x0xO0oo(offset, "offset");
        kotlin.jvm.internal.IIX0o.x0xO0oo(zoneId, "zoneId");
        this.f479I0Io = offset;
    }

    public final int Oxx0IOOO() {
        return this.f479I0Io.II0xO0();
    }

    @OXOo.OOXIXo
    public final o0IXXIx XO() {
        return this.f479I0Io;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Oxx0xo(@OXOo.OOXIXo o0IXXIx offset) {
        this(offset, IXxxXO.oIX0oI(offset.I0Io()));
        kotlin.jvm.internal.IIX0o.x0xO0oo(offset, "offset");
    }

    @kotlin.OOXIXo(message = "Use offset.totalSeconds", replaceWith = @kotlin.XX(expression = "offset.totalSeconds", imports = {}))
    public static /* synthetic */ void II0XooXoX() {
    }
}
