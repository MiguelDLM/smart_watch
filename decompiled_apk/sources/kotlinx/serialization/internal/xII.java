package kotlinx.serialization.internal;

import kotlinx.serialization.internal.oo0xXOI0I;

/* loaded from: classes6.dex */
public final class xII {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> implements oo0xXOI0I<T> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ kotlinx.serialization.Oxx0IOOO<T> f30757oIX0oI;

        public oIX0oI(kotlinx.serialization.Oxx0IOOO<T> oxx0IOOO) {
            this.f30757oIX0oI = oxx0IOOO;
        }

        @Override // kotlinx.serialization.internal.oo0xXOI0I
        @OXOo.OOXIXo
        public kotlinx.serialization.Oxx0IOOO<?>[] I0Io() {
            return oo0xXOI0I.oIX0oI.oIX0oI(this);
        }

        @Override // kotlinx.serialization.Oxx0xo
        public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, T t) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
            throw new IllegalStateException("unsupported");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.serialization.internal.oo0xXOI0I
        @OXOo.OOXIXo
        public kotlinx.serialization.Oxx0IOOO<?>[] X0o0xo() {
            return new kotlinx.serialization.Oxx0IOOO[]{this.f30757oIX0oI};
        }

        @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
        @OXOo.OOXIXo
        public kotlinx.serialization.descriptors.XO oIX0oI() {
            throw new IllegalStateException("unsupported");
        }

        @Override // kotlinx.serialization.I0Io
        public T oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
            throw new IllegalStateException("unsupported");
        }
    }

    @OXOo.OOXIXo
    @kotlinx.serialization.XO
    public static final <T> kotlinx.serialization.descriptors.XO oIX0oI(@OXOo.OOXIXo String name, @OXOo.OOXIXo kotlinx.serialization.Oxx0IOOO<T> primitiveSerializer) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(name, "name");
        kotlin.jvm.internal.IIX0o.x0xO0oo(primitiveSerializer, "primitiveSerializer");
        return new IO(name, new oIX0oI(primitiveSerializer));
    }
}
