package kotlinx.serialization.descriptors;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import X0.IIXOooo;
import XXO0.oIX0oI;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.Xo0;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.collections.o0;
import kotlin.collections.xI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlinx.serialization.descriptors.XO;
import kotlinx.serialization.internal.O00XxXI;
import kotlinx.serialization.internal.OOXIxO0;
import kotlinx.serialization.internal.x0XOIxOo;

@XX({"SMAP\nSerialDescriptors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SerialDescriptors.kt\nkotlinx/serialization/descriptors/SerialDescriptorImpl\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Platform.kt\nkotlinx/serialization/internal/PlatformKt\n+ 5 PluginGeneratedSerialDescriptor.kt\nkotlinx/serialization/internal/PluginGeneratedSerialDescriptorKt\n*L\n1#1,348:1\n37#2,2:349\n37#2,2:351\n1549#3:353\n1620#3,3:354\n13#4:357\n13#4:358\n13#4:359\n18#4:360\n111#5,10:361\n*S KotlinDebug\n*F\n+ 1 SerialDescriptors.kt\nkotlinx/serialization/descriptors/SerialDescriptorImpl\n*L\n318#1:349,2\n320#1:351,2\n322#1:353\n322#1:354,3\n326#1:357\n328#1:358\n329#1:359\n330#1:360\n333#1:361,10\n*E\n"})
/* loaded from: classes6.dex */
public final class SerialDescriptorImpl implements XO, x0XOIxOo {

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f30575I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OOXIXo
    public final List<Annotation>[] f30576II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public final II0XooXoX f30577II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OOXIXo
    public final XO[] f30578OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OOXIXo
    public final XO[] f30579Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OOXIXo
    public final Set<String> f30580X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final String[] f30581XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final String f30582oIX0oI;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OOXIXo
    public final X0IIOO f30583oOoXoXO;

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public final List<Annotation> f30584oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    @OOXIXo
    public final Map<String, Integer> f30585xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OOXIXo
    public final boolean[] f30586xxIXOIIO;

    public SerialDescriptorImpl(@OOXIXo String serialName, @OOXIXo II0XooXoX kind, int i, @OOXIXo List<? extends XO> typeParameters, @OOXIXo oIX0oI builder) {
        IIX0o.x0xO0oo(serialName, "serialName");
        IIX0o.x0xO0oo(kind, "kind");
        IIX0o.x0xO0oo(typeParameters, "typeParameters");
        IIX0o.x0xO0oo(builder, "builder");
        this.f30582oIX0oI = serialName;
        this.f30577II0xO0 = kind;
        this.f30575I0Io = i;
        this.f30584oxoX = builder.I0Io();
        this.f30580X0o0xo = CollectionsKt___CollectionsKt.XIo(builder.Oxx0IOOO());
        String[] strArr = (String[]) builder.Oxx0IOOO().toArray(new String[0]);
        this.f30581XO = strArr;
        this.f30579Oxx0IOOO = O00XxXI.X0o0xo(builder.XO());
        this.f30576II0XooXoX = (List[]) builder.X0o0xo().toArray(new List[0]);
        this.f30586xxIXOIIO = CollectionsKt___CollectionsKt.x0OI(builder.II0XooXoX());
        Iterable<xI> X00 = ArraysKt___ArraysKt.X00(strArr);
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(X00, 10));
        for (xI xIVar : X00) {
            arrayList.add(Xo0.oIX0oI(xIVar.XO(), Integer.valueOf(xIVar.X0o0xo())));
        }
        this.f30585xoIox = o0.ooOx(arrayList);
        this.f30578OOXIXo = O00XxXI.X0o0xo(typeParameters);
        this.f30583oOoXoXO = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Integer>() { // from class: kotlinx.serialization.descriptors.SerialDescriptorImpl$_hashCode$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OOXIXo
            public final Integer invoke() {
                XO[] xoArr;
                SerialDescriptorImpl serialDescriptorImpl = SerialDescriptorImpl.this;
                xoArr = serialDescriptorImpl.f30578OOXIXo;
                return Integer.valueOf(OOXIxO0.II0xO0(serialDescriptorImpl, xoArr));
            }
        });
    }

    @Override // kotlinx.serialization.descriptors.XO
    public boolean I0Io() {
        return XO.oIX0oI.Oxx0IOOO(this);
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OOXIXo
    public List<Annotation> II0XooXoX(int i) {
        return this.f30576II0XooXoX[i];
    }

    @Override // kotlinx.serialization.internal.x0XOIxOo
    @OOXIXo
    public Set<String> II0xO0() {
        return this.f30580X0o0xo;
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OOXIXo
    public String Oxx0IOOO(int i) {
        return this.f30581XO[i];
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OOXIXo
    public XO X0o0xo(int i) {
        return this.f30579Oxx0IOOO[i];
    }

    @Override // kotlinx.serialization.descriptors.XO
    public int XO() {
        return this.f30575I0Io;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SerialDescriptorImpl) {
            XO xo2 = (XO) obj;
            if (IIX0o.Oxx0IOOO(xxIXOIIO(), xo2.xxIXOIIO()) && Arrays.equals(this.f30578OOXIXo, ((SerialDescriptorImpl) obj).f30578OOXIXo) && XO() == xo2.XO()) {
                int XO2 = XO();
                for (int i = 0; i < XO2; i++) {
                    if (IIX0o.Oxx0IOOO(X0o0xo(i).xxIXOIIO(), xo2.X0o0xo(i).xxIXOIIO()) && IIX0o.Oxx0IOOO(X0o0xo(i).oIX0oI(), xo2.X0o0xo(i).oIX0oI())) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OOXIXo
    public List<Annotation> getAnnotations() {
        return this.f30584oxoX;
    }

    public int hashCode() {
        return oOoXoXO();
    }

    @Override // kotlinx.serialization.descriptors.XO
    public boolean isInline() {
        return XO.oIX0oI.XO(this);
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OOXIXo
    public II0XooXoX oIX0oI() {
        return this.f30577II0xO0;
    }

    public final int oOoXoXO() {
        return ((Number) this.f30583oOoXoXO.getValue()).intValue();
    }

    @Override // kotlinx.serialization.descriptors.XO
    public int oxoX(@OOXIXo String name) {
        IIX0o.x0xO0oo(name, "name");
        Integer num = this.f30585xoIox.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @OOXIXo
    public String toString() {
        return CollectionsKt___CollectionsKt.OoIXo(IIXOooo.X00xOoXI(0, XO()), ", ", xxIXOIIO() + HexStringBuilder.COMMENT_BEGIN_CHAR, oIX0oI.I0Io.f4095I0Io, 0, null, new Oox.oOoXoXO<Integer, CharSequence>() { // from class: kotlinx.serialization.descriptors.SerialDescriptorImpl$toString$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
                return invoke(num.intValue());
            }

            @OOXIXo
            public final CharSequence invoke(int i) {
                return SerialDescriptorImpl.this.Oxx0IOOO(i) + ": " + SerialDescriptorImpl.this.X0o0xo(i).xxIXOIIO();
            }
        }, 24, null);
    }

    @Override // kotlinx.serialization.descriptors.XO
    public boolean xoIox(int i) {
        return this.f30586xxIXOIIO[i];
    }

    @Override // kotlinx.serialization.descriptors.XO
    @OOXIXo
    public String xxIXOIIO() {
        return this.f30582oIX0oI;
    }
}
