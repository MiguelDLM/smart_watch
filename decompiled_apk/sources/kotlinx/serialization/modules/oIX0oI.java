package kotlinx.serialization.modules;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes6.dex */
public abstract class oIX0oI {

    /* loaded from: classes6.dex */
    public static final class II0xO0 extends oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        @OOXIXo
        public final oOoXoXO<List<? extends kotlinx.serialization.Oxx0IOOO<?>>, kotlinx.serialization.Oxx0IOOO<?>> f30790oIX0oI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public II0xO0(@OOXIXo oOoXoXO<? super List<? extends kotlinx.serialization.Oxx0IOOO<?>>, ? extends kotlinx.serialization.Oxx0IOOO<?>> provider) {
            super(null);
            IIX0o.x0xO0oo(provider, "provider");
            this.f30790oIX0oI = provider;
        }

        @OOXIXo
        public final oOoXoXO<List<? extends kotlinx.serialization.Oxx0IOOO<?>>, kotlinx.serialization.Oxx0IOOO<?>> II0xO0() {
            return this.f30790oIX0oI;
        }

        @Override // kotlinx.serialization.modules.oIX0oI
        @OOXIXo
        public kotlinx.serialization.Oxx0IOOO<?> oIX0oI(@OOXIXo List<? extends kotlinx.serialization.Oxx0IOOO<?>> typeArgumentsSerializers) {
            IIX0o.x0xO0oo(typeArgumentsSerializers, "typeArgumentsSerializers");
            return this.f30790oIX0oI.invoke(typeArgumentsSerializers);
        }
    }

    /* renamed from: kotlinx.serialization.modules.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1117oIX0oI extends oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        @OOXIXo
        public final kotlinx.serialization.Oxx0IOOO<?> f30791oIX0oI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1117oIX0oI(@OOXIXo kotlinx.serialization.Oxx0IOOO<?> serializer) {
            super(null);
            IIX0o.x0xO0oo(serializer, "serializer");
            this.f30791oIX0oI = serializer;
        }

        @OOXIXo
        public final kotlinx.serialization.Oxx0IOOO<?> II0xO0() {
            return this.f30791oIX0oI;
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if ((obj instanceof C1117oIX0oI) && IIX0o.Oxx0IOOO(((C1117oIX0oI) obj).f30791oIX0oI, this.f30791oIX0oI)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f30791oIX0oI.hashCode();
        }

        @Override // kotlinx.serialization.modules.oIX0oI
        @OOXIXo
        public kotlinx.serialization.Oxx0IOOO<?> oIX0oI(@OOXIXo List<? extends kotlinx.serialization.Oxx0IOOO<?>> typeArgumentsSerializers) {
            IIX0o.x0xO0oo(typeArgumentsSerializers, "typeArgumentsSerializers");
            return this.f30791oIX0oI;
        }
    }

    public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
        this();
    }

    @OOXIXo
    public abstract kotlinx.serialization.Oxx0IOOO<?> oIX0oI(@OOXIXo List<? extends kotlinx.serialization.Oxx0IOOO<?>> list);

    public oIX0oI() {
    }
}
