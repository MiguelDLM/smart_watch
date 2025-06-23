package kotlinx.serialization.descriptors;

import OXOo.OOXIXo;
import java.util.Iterator;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

/* loaded from: classes6.dex */
public final class Oxx0IOOO {

    @XX({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 SerialDescriptor.kt\nkotlinx/serialization/descriptors/SerialDescriptorKt\n*L\n1#1,70:1\n293#2:71\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class I0Io implements Iterable<XO>, OI0IXox.oIX0oI {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ XO f30569XO;

        public I0Io(XO xo2) {
            this.f30569XO = xo2;
        }

        @Override // java.lang.Iterable
        @OOXIXo
        public Iterator<XO> iterator() {
            return new oIX0oI(this.f30569XO);
        }
    }

    /* loaded from: classes6.dex */
    public static final class II0xO0 implements Iterator<String>, OI0IXox.oIX0oI {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ XO f30570Oo;

        /* renamed from: XO, reason: collision with root package name */
        public int f30571XO;

        public II0xO0(XO xo2) {
            this.f30570Oo = xo2;
            this.f30571XO = xo2.XO();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f30571XO > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        @OOXIXo
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public String next() {
            XO xo2 = this.f30570Oo;
            int XO2 = xo2.XO();
            int i = this.f30571XO;
            this.f30571XO = i - 1;
            return xo2.Oxx0IOOO(XO2 - i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Iterator<XO>, OI0IXox.oIX0oI {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ XO f30572Oo;

        /* renamed from: XO, reason: collision with root package name */
        public int f30573XO;

        public oIX0oI(XO xo2) {
            this.f30572Oo = xo2;
            this.f30573XO = xo2.XO();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f30573XO > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        @OOXIXo
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public XO next() {
            XO xo2 = this.f30572Oo;
            int XO2 = xo2.XO();
            int i = this.f30573XO;
            this.f30573XO = i - 1;
            return xo2.X0o0xo(XO2 - i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @XX({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 SerialDescriptor.kt\nkotlinx/serialization/descriptors/SerialDescriptorKt\n*L\n1#1,70:1\n309#2:71\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oxoX implements Iterable<String>, OI0IXox.oIX0oI {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ XO f30574XO;

        public oxoX(XO xo2) {
            this.f30574XO = xo2;
        }

        @Override // java.lang.Iterable
        @OOXIXo
        public Iterator<String> iterator() {
            return new II0xO0(this.f30574XO);
        }
    }

    @OOXIXo
    public static final Iterable<String> I0Io(@OOXIXo XO xo2) {
        IIX0o.x0xO0oo(xo2, "<this>");
        return new oxoX(xo2);
    }

    @kotlinx.serialization.oxoX
    public static /* synthetic */ void II0xO0(XO xo2) {
    }

    @OOXIXo
    public static final Iterable<XO> oIX0oI(@OOXIXo XO xo2) {
        IIX0o.x0xO0oo(xo2, "<this>");
        return new I0Io(xo2);
    }

    @kotlinx.serialization.oxoX
    public static /* synthetic */ void oxoX(XO xo2) {
    }
}
