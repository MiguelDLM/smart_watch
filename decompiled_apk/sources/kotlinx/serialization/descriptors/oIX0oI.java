package kotlinx.serialization.descriptors;

import OXOo.OOXIXo;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSerialDescriptors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SerialDescriptors.kt\nkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,348:1\n1#2:349\n*E\n"})
/* loaded from: classes6.dex */
public final class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public List<? extends Annotation> f30596I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OOXIXo
    public final List<Boolean> f30597II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f30598II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OOXIXo
    public final List<List<Annotation>> f30599Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OOXIXo
    public final Set<String> f30600X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final List<XO> f30601XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final String f30602oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public final List<String> f30603oxoX;

    public oIX0oI(@OOXIXo String serialName) {
        IIX0o.x0xO0oo(serialName, "serialName");
        this.f30602oIX0oI = serialName;
        this.f30596I0Io = CollectionsKt__CollectionsKt.ooXIXxIX();
        this.f30603oxoX = new ArrayList();
        this.f30600X0o0xo = new HashSet();
        this.f30601XO = new ArrayList();
        this.f30599Oxx0IOOO = new ArrayList();
        this.f30597II0XooXoX = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void II0xO0(oIX0oI oix0oi, String str, XO xo2, List list, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            list = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        if ((i & 8) != 0) {
            z = false;
        }
        oix0oi.oIX0oI(str, xo2, list, z);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "isNullable inside buildSerialDescriptor is deprecated. Please use SerialDescriptor.nullable extension on a builder result.")
    @kotlinx.serialization.oxoX
    public static /* synthetic */ void OOXIXo() {
    }

    @kotlinx.serialization.oxoX
    public static /* synthetic */ void oxoX() {
    }

    @OOXIXo
    public final List<Annotation> I0Io() {
        return this.f30596I0Io;
    }

    @OOXIXo
    public final List<Boolean> II0XooXoX() {
        return this.f30597II0XooXoX;
    }

    @OOXIXo
    public final List<String> Oxx0IOOO() {
        return this.f30603oxoX;
    }

    @OOXIXo
    public final List<List<Annotation>> X0o0xo() {
        return this.f30599Oxx0IOOO;
    }

    @OOXIXo
    public final List<XO> XO() {
        return this.f30601XO;
    }

    public final void oIX0oI(@OOXIXo String elementName, @OOXIXo XO descriptor, @OOXIXo List<? extends Annotation> annotations, boolean z) {
        IIX0o.x0xO0oo(elementName, "elementName");
        IIX0o.x0xO0oo(descriptor, "descriptor");
        IIX0o.x0xO0oo(annotations, "annotations");
        if (this.f30600X0o0xo.add(elementName)) {
            this.f30603oxoX.add(elementName);
            this.f30601XO.add(descriptor);
            this.f30599Oxx0IOOO.add(annotations);
            this.f30597II0XooXoX.add(Boolean.valueOf(z));
            return;
        }
        throw new IllegalArgumentException(("Element with name '" + elementName + "' is already registered in " + this.f30602oIX0oI).toString());
    }

    public final void oOoXoXO(@OOXIXo List<? extends Annotation> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.f30596I0Io = list;
    }

    public final void ooOOo0oXI(boolean z) {
        this.f30598II0xO0 = z;
    }

    public final boolean xoIox() {
        return this.f30598II0xO0;
    }

    @OOXIXo
    public final String xxIXOIIO() {
        return this.f30602oIX0oI;
    }
}
