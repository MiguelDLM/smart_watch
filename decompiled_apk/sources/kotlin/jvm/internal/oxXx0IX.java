package kotlin.jvm.internal;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.util.List;
import kotlin.reflect.KVariance;

@XX({"SMAP\nTypeParameterReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeParameterReference.kt\nkotlin/jvm/internal/TypeParameterReference\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,58:1\n1#2:59\n*E\n"})
@kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
/* loaded from: classes6.dex */
public final class oxXx0IX implements kotlin.reflect.oI0IIXIo {

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f29347OxxIIOOXO = new oIX0oI(null);

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final KVariance f29348IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final String f29349Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public final boolean f29350Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Object f29351XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public volatile List<? extends kotlin.reflect.Oxx0xo> f29352oI0IIXIo;

    /* loaded from: classes6.dex */
    public static final class oIX0oI {

        /* renamed from: kotlin.jvm.internal.oxXx0IX$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public /* synthetic */ class C1109oIX0oI {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public static final /* synthetic */ int[] f29353oIX0oI;

            static {
                int[] iArr = new int[KVariance.values().length];
                try {
                    iArr[KVariance.INVARIANT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[KVariance.IN.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[KVariance.OUT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f29353oIX0oI = iArr;
            }
        }

        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final String oIX0oI(@OXOo.OOXIXo kotlin.reflect.oI0IIXIo typeParameter) {
            IIX0o.x0xO0oo(typeParameter, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int i = C1109oIX0oI.f29353oIX0oI[typeParameter.XO().ordinal()];
            if (i != 2) {
                if (i == 3) {
                    sb.append("out ");
                }
            } else {
                sb.append("in ");
            }
            sb.append(typeParameter.getName());
            String sb2 = sb.toString();
            IIX0o.oO(sb2, "toString(...)");
            return sb2;
        }

        public oIX0oI() {
        }
    }

    public oxXx0IX(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo String name, @OXOo.OOXIXo KVariance variance, boolean z) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(variance, "variance");
        this.f29351XO = obj;
        this.f29349Oo = name;
        this.f29348IXxxXO = variance;
        this.f29350Oxx0xo = z;
    }

    public static /* synthetic */ void oIX0oI() {
    }

    public final void I0Io(@OXOo.OOXIXo List<? extends kotlin.reflect.Oxx0xo> upperBounds) {
        IIX0o.x0xO0oo(upperBounds, "upperBounds");
        if (this.f29352oI0IIXIo == null) {
            this.f29352oI0IIXIo = upperBounds;
            return;
        }
        throw new IllegalStateException(("Upper bounds of type parameter '" + this + "' have already been initialized.").toString());
    }

    @Override // kotlin.reflect.oI0IIXIo
    @OXOo.OOXIXo
    public KVariance XO() {
        return this.f29348IXxxXO;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof oxXx0IX) {
            oxXx0IX oxxx0ix = (oxXx0IX) obj;
            if (IIX0o.Oxx0IOOO(this.f29351XO, oxxx0ix.f29351XO) && IIX0o.Oxx0IOOO(getName(), oxxx0ix.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.oI0IIXIo
    @OXOo.OOXIXo
    public String getName() {
        return this.f29349Oo;
    }

    @Override // kotlin.reflect.oI0IIXIo
    @OXOo.OOXIXo
    public List<kotlin.reflect.Oxx0xo> getUpperBounds() {
        List list = this.f29352oI0IIXIo;
        if (list == null) {
            List<kotlin.reflect.Oxx0xo> OOXIXo2 = kotlin.collections.oI0IIXIo.OOXIXo(IO.x0XOIxOo(Object.class));
            this.f29352oI0IIXIo = OOXIXo2;
            return OOXIXo2;
        }
        return list;
    }

    public int hashCode() {
        int i;
        Object obj = this.f29351XO;
        if (obj != null) {
            i = obj.hashCode();
        } else {
            i = 0;
        }
        return (i * 31) + getName().hashCode();
    }

    @Override // kotlin.reflect.oI0IIXIo
    public boolean oxoX() {
        return this.f29350Oxx0xo;
    }

    @OXOo.OOXIXo
    public String toString() {
        return f29347OxxIIOOXO.oIX0oI(this);
    }
}
