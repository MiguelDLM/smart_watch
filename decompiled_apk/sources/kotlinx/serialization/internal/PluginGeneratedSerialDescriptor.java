package kotlinx.serialization.internal;

import XXO0.oIX0oI;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlinx.serialization.descriptors.XO;
import kotlinx.serialization.descriptors.xxIXOIIO;

@kotlin.jvm.internal.XX({"SMAP\nPluginGeneratedSerialDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PluginGeneratedSerialDescriptor.kt\nkotlinx/serialization/internal/PluginGeneratedSerialDescriptor\n+ 2 Platform.kt\nkotlinx/serialization/internal/PlatformKt\n+ 3 PluginGeneratedSerialDescriptor.kt\nkotlinx/serialization/internal/PluginGeneratedSerialDescriptorKt\n*L\n1#1,134:1\n13#2:135\n18#2:136\n13#2:137\n13#2:138\n111#3,10:139\n*S KotlinDebug\n*F\n+ 1 PluginGeneratedSerialDescriptor.kt\nkotlinx/serialization/internal/PluginGeneratedSerialDescriptor\n*L\n76#1:135\n79#1:136\n81#1:137\n82#1:138\n93#1:139,10\n*E\n"})
@kotlin.o0
/* loaded from: classes6.dex */
public class PluginGeneratedSerialDescriptor implements kotlinx.serialization.descriptors.XO, x0XOIxOo {

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f30673I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final boolean[] f30674II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final oo0xXOI0I<?> f30675II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlin.X0IIOO f30676OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public List<Annotation> f30677Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final String[] f30678X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final List<Annotation>[] f30679XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final String f30680oIX0oI;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlin.X0IIOO f30681oOoXoXO;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f30682oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlin.X0IIOO f30683xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public Map<String, Integer> f30684xxIXOIIO;

    public PluginGeneratedSerialDescriptor(@OXOo.OOXIXo String serialName, @OXOo.oOoXoXO oo0xXOI0I<?> oo0xxoi0i, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(serialName, "serialName");
        this.f30680oIX0oI = serialName;
        this.f30675II0xO0 = oo0xxoi0i;
        this.f30673I0Io = i;
        this.f30682oxoX = -1;
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            strArr[i2] = "[UNINITIALIZED]";
        }
        this.f30678X0o0xo = strArr;
        int i3 = this.f30673I0Io;
        this.f30679XO = new List[i3];
        this.f30674II0XooXoX = new boolean[i3];
        this.f30684xxIXOIIO = kotlin.collections.o0.O0xOxO();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.f30683xoIox = kotlin.XIxXXX0x0.I0Io(lazyThreadSafetyMode, new Oox.oIX0oI<kotlinx.serialization.Oxx0IOOO<?>[]>() { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$childSerializers$2
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final kotlinx.serialization.Oxx0IOOO<?>[] invoke() {
                oo0xXOI0I oo0xxoi0i2;
                kotlinx.serialization.Oxx0IOOO<?>[] X0o0xo2;
                oo0xxoi0i2 = PluginGeneratedSerialDescriptor.this.f30675II0xO0;
                return (oo0xxoi0i2 == null || (X0o0xo2 = oo0xxoi0i2.X0o0xo()) == null) ? IIxOXoOo0.f30629oIX0oI : X0o0xo2;
            }
        });
        this.f30676OOXIXo = kotlin.XIxXXX0x0.I0Io(lazyThreadSafetyMode, new Oox.oIX0oI<kotlinx.serialization.descriptors.XO[]>() { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$typeParameterDescriptors$2
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final kotlinx.serialization.descriptors.XO[] invoke() {
                oo0xXOI0I oo0xxoi0i2;
                ArrayList arrayList;
                kotlinx.serialization.Oxx0IOOO<?>[] I0Io2;
                oo0xxoi0i2 = PluginGeneratedSerialDescriptor.this.f30675II0xO0;
                if (oo0xxoi0i2 == null || (I0Io2 = oo0xxoi0i2.I0Io()) == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(I0Io2.length);
                    for (kotlinx.serialization.Oxx0IOOO<?> oxx0IOOO : I0Io2) {
                        arrayList.add(oxx0IOOO.oIX0oI());
                    }
                }
                return O00XxXI.X0o0xo(arrayList);
            }
        });
        this.f30681oOoXoXO = kotlin.XIxXXX0x0.I0Io(lazyThreadSafetyMode, new Oox.oIX0oI<Integer>() { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$_hashCode$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Integer invoke() {
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = PluginGeneratedSerialDescriptor.this;
                return Integer.valueOf(OOXIxO0.II0xO0(pluginGeneratedSerialDescriptor, pluginGeneratedSerialDescriptor.x0xO0oo()));
            }
        });
    }

    private final int Oo() {
        return ((Number) this.f30681oOoXoXO.getValue()).intValue();
    }

    public static /* synthetic */ void ooOOo0oXI(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor, String str, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            pluginGeneratedSerialDescriptor.oOoXoXO(str, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addElement");
    }

    @Override // kotlinx.serialization.descriptors.XO
    public boolean I0Io() {
        return XO.oIX0oI.Oxx0IOOO(this);
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public List<Annotation> II0XooXoX(int i) {
        List<Annotation> list = this.f30679XO[i];
        if (list == null) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return list;
    }

    @Override // kotlinx.serialization.internal.x0XOIxOo
    @OXOo.OOXIXo
    public Set<String> II0xO0() {
        return this.f30684xxIXOIIO.keySet();
    }

    public final void IXxxXO(@OXOo.OOXIXo Annotation annotation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(annotation, "annotation");
        List<Annotation> list = this.f30679XO[this.f30682oxoX];
        if (list == null) {
            list = new ArrayList<>(1);
            this.f30679XO[this.f30682oxoX] = list;
        }
        list.add(annotation);
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public String Oxx0IOOO(int i) {
        return this.f30678X0o0xo[i];
    }

    public final void Oxx0xo(@OXOo.OOXIXo Annotation a2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(a2, "a");
        if (this.f30677Oxx0IOOO == null) {
            this.f30677Oxx0IOOO = new ArrayList(1);
        }
        List<Annotation> list = this.f30677Oxx0IOOO;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(list);
        list.add(a2);
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO X0o0xo(int i) {
        return oO()[i].oIX0oI();
    }

    @Override // kotlinx.serialization.descriptors.XO
    public final int XO() {
        return this.f30673I0Io;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PluginGeneratedSerialDescriptor) {
            kotlinx.serialization.descriptors.XO xo2 = (kotlinx.serialization.descriptors.XO) obj;
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(xxIXOIIO(), xo2.xxIXOIIO()) && Arrays.equals(x0xO0oo(), ((PluginGeneratedSerialDescriptor) obj).x0xO0oo()) && XO() == xo2.XO()) {
                int XO2 = XO();
                for (int i = 0; i < XO2; i++) {
                    if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(X0o0xo(i).xxIXOIIO(), xo2.X0o0xo(i).xxIXOIIO()) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(X0o0xo(i).oIX0oI(), xo2.X0o0xo(i).oIX0oI())) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public List<Annotation> getAnnotations() {
        List<Annotation> list = this.f30677Oxx0IOOO;
        if (list == null) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return list;
    }

    public int hashCode() {
        return Oo();
    }

    @Override // kotlinx.serialization.descriptors.XO
    public boolean isInline() {
        return XO.oIX0oI.XO(this);
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.II0XooXoX oIX0oI() {
        return xxIXOIIO.oIX0oI.f30610oIX0oI;
    }

    public final kotlinx.serialization.Oxx0IOOO<?>[] oO() {
        return (kotlinx.serialization.Oxx0IOOO[]) this.f30683xoIox.getValue();
    }

    public final void oOoXoXO(@OXOo.OOXIXo String name, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(name, "name");
        String[] strArr = this.f30678X0o0xo;
        int i = this.f30682oxoX + 1;
        this.f30682oxoX = i;
        strArr[i] = name;
        this.f30674II0XooXoX[i] = z;
        this.f30679XO[i] = null;
        if (i == this.f30673I0Io - 1) {
            this.f30684xxIXOIIO = x0XOIxOo();
        }
    }

    @Override // kotlinx.serialization.descriptors.XO
    public int oxoX(@OXOo.OOXIXo String name) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(name, "name");
        Integer num = this.f30684xxIXOIIO.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @OXOo.OOXIXo
    public String toString() {
        return CollectionsKt___CollectionsKt.OoIXo(X0.IIXOooo.X00xOoXI(0, this.f30673I0Io), ", ", xxIXOIIO() + HexStringBuilder.COMMENT_BEGIN_CHAR, oIX0oI.I0Io.f4095I0Io, 0, null, new Oox.oOoXoXO<Integer, CharSequence>() { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$toString$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
                return invoke(num.intValue());
            }

            @OXOo.OOXIXo
            public final CharSequence invoke(int i) {
                return PluginGeneratedSerialDescriptor.this.Oxx0IOOO(i) + ": " + PluginGeneratedSerialDescriptor.this.X0o0xo(i).xxIXOIIO();
            }
        }, 24, null);
    }

    public final Map<String, Integer> x0XOIxOo() {
        HashMap hashMap = new HashMap();
        int length = this.f30678X0o0xo.length;
        for (int i = 0; i < length; i++) {
            hashMap.put(this.f30678X0o0xo[i], Integer.valueOf(i));
        }
        return hashMap;
    }

    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO[] x0xO0oo() {
        return (kotlinx.serialization.descriptors.XO[]) this.f30676OOXIXo.getValue();
    }

    @Override // kotlinx.serialization.descriptors.XO
    public boolean xoIox(int i) {
        return this.f30674II0XooXoX[i];
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OXOo.OOXIXo
    public String xxIXOIIO() {
        return this.f30680oIX0oI;
    }

    public /* synthetic */ PluginGeneratedSerialDescriptor(String str, oo0xXOI0I oo0xxoi0i, int i, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(str, (i2 & 2) != 0 ? null : oo0xxoi0i, i);
    }
}
