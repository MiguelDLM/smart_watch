package IOI;

import java.time.DateTimeException;
import java.time.ZoneOffset;
import kotlinx.datetime.DateTimeFormatException;

@kotlinx.serialization.IXxxXO(with = kotlinx.datetime.serializers.OOXIXo.class)
/* loaded from: classes6.dex */
public final class o0IXXIx {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final o0IXXIx f486II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ZoneOffset f487oIX0oI;

    @kotlin.jvm.internal.XX({"SMAP\nUtcOffsetJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UtcOffsetJvm.kt\nkotlinx/datetime/UtcOffset$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,48:1\n1#2:49\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final o0IXXIx II0xO0(@OXOo.OOXIXo String offsetString) {
            ZoneOffset of;
            kotlin.jvm.internal.IIX0o.x0xO0oo(offsetString, "offsetString");
            try {
                of = ZoneOffset.of(offsetString);
                return new o0IXXIx(of);
            } catch (DateTimeException e) {
                throw new DateTimeFormatException(e);
            }
        }

        @OXOo.OOXIXo
        public final o0IXXIx oIX0oI() {
            return o0IXXIx.f486II0xO0;
        }

        @OXOo.OOXIXo
        public final kotlinx.serialization.Oxx0IOOO<o0IXXIx> serializer() {
            return kotlinx.datetime.serializers.OOXIXo.f30530oIX0oI;
        }

        public oIX0oI() {
        }
    }

    static {
        ZoneOffset UTC;
        UTC = ZoneOffset.UTC;
        kotlin.jvm.internal.IIX0o.oO(UTC, "UTC");
        f486II0xO0 = new o0IXXIx(UTC);
    }

    public o0IXXIx(@OXOo.OOXIXo ZoneOffset zoneOffset) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zoneOffset, "zoneOffset");
        this.f487oIX0oI = zoneOffset;
    }

    @OXOo.OOXIXo
    public final ZoneOffset I0Io() {
        return this.f487oIX0oI;
    }

    public final int II0xO0() {
        int totalSeconds;
        totalSeconds = this.f487oIX0oI.getTotalSeconds();
        return totalSeconds;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if ((obj instanceof o0IXXIx) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f487oIX0oI, ((o0IXXIx) obj).f487oIX0oI)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        hashCode = this.f487oIX0oI.hashCode();
        return hashCode;
    }

    @OXOo.OOXIXo
    public String toString() {
        String zoneOffset;
        zoneOffset = this.f487oIX0oI.toString();
        kotlin.jvm.internal.IIX0o.oO(zoneOffset, "toString(...)");
        return zoneOffset;
    }
}
