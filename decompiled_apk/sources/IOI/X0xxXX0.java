package IOI;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Set;
import kotlinx.datetime.IllegalTimeZoneException;

@kotlinx.serialization.IXxxXO(with = kotlinx.datetime.serializers.xoIox.class)
/* loaded from: classes6.dex */
public class X0xxXX0 {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Oxx0xo f480II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ZoneId f481oIX0oI;

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final Oxx0xo I0Io() {
            return X0xxXX0.f480II0xO0;
        }

        @OXOo.OOXIXo
        public final Set<String> II0xO0() {
            Set<String> availableZoneIds;
            availableZoneIds = ZoneId.getAvailableZoneIds();
            kotlin.jvm.internal.IIX0o.oO(availableZoneIds, "getAvailableZoneIds(...)");
            return availableZoneIds;
        }

        @OXOo.OOXIXo
        public final X0xxXX0 X0o0xo(@OXOo.OOXIXo ZoneId zoneId) {
            ZoneId normalized;
            kotlin.jvm.internal.IIX0o.x0xO0oo(zoneId, "zoneId");
            if (x0OxxIOxX.oIX0oI(zoneId)) {
                return new Oxx0xo(new o0IXXIx(x0.oIX0oI(zoneId)));
            }
            if (oXX0IoI.oIX0oI(zoneId)) {
                normalized = zoneId.normalized();
                kotlin.jvm.internal.IIX0o.x0XOIxOo(normalized, "null cannot be cast to non-null type java.time.ZoneOffset");
                return new Oxx0xo(new o0IXXIx(x0.oIX0oI(normalized)), zoneId);
            }
            return new X0xxXX0(zoneId);
        }

        @OXOo.OOXIXo
        public final X0xxXX0 oIX0oI() {
            ZoneId systemDefault;
            systemDefault = ZoneId.systemDefault();
            kotlin.jvm.internal.IIX0o.oO(systemDefault, "systemDefault(...)");
            return X0o0xo(systemDefault);
        }

        @OXOo.OOXIXo
        public final X0xxXX0 oxoX(@OXOo.OOXIXo String zoneId) {
            ZoneId of;
            kotlin.jvm.internal.IIX0o.x0xO0oo(zoneId, "zoneId");
            try {
                of = ZoneId.of(zoneId);
                kotlin.jvm.internal.IIX0o.oO(of, "of(...)");
                return X0o0xo(of);
            } catch (Exception e) {
                if (X0IIOO.oIX0oI(e)) {
                    throw new IllegalTimeZoneException(e);
                }
                throw e;
            }
        }

        @OXOo.OOXIXo
        public final kotlinx.serialization.Oxx0IOOO<X0xxXX0> serializer() {
            return kotlinx.datetime.serializers.xoIox.f30544oIX0oI;
        }

        public oIX0oI() {
        }
    }

    static {
        ZoneOffset UTC;
        UTC = ZoneOffset.UTC;
        kotlin.jvm.internal.IIX0o.oO(UTC, "UTC");
        f480II0xO0 = OIx00oxx.II0xO0(new o0IXXIx(UTC));
    }

    public X0xxXX0(@OXOo.OOXIXo ZoneId zoneId) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zoneId, "zoneId");
        this.f481oIX0oI = zoneId;
    }

    @OXOo.OOXIXo
    public final ZoneId I0Io() {
        return this.f481oIX0oI;
    }

    @OXOo.OOXIXo
    public final String II0xO0() {
        String id;
        id = this.f481oIX0oI.getId();
        kotlin.jvm.internal.IIX0o.oO(id, "getId(...)");
        return id;
    }

    @OXOo.OOXIXo
    public final xOOOX X0o0xo(@OXOo.OOXIXo IIX0o iIX0o) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        return IO0XoXxO.XO(iIX0o, this);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this != obj && (!(obj instanceof X0xxXX0) || !kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f481oIX0oI, ((X0xxXX0) obj).f481oIX0oI))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        hashCode = this.f481oIX0oI.hashCode();
        return hashCode;
    }

    @OXOo.OOXIXo
    public final IIX0o oxoX(@OXOo.OOXIXo xOOOX xooox) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xooox, "<this>");
        return IO0XoXxO.oxoX(xooox, this);
    }

    @OXOo.OOXIXo
    public String toString() {
        String zoneId;
        zoneId = this.f481oIX0oI.toString();
        kotlin.jvm.internal.IIX0o.oO(zoneId, "toString(...)");
        return zoneId;
    }
}
