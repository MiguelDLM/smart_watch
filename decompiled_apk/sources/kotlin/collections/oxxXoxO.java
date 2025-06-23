package kotlin.collections;

import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes6.dex */
public final class oxxXoxO<E> extends II0xO0<E> implements RandomAccess {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f29166IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f29167Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final List<E> f29168XO;

    /* JADX WARN: Multi-variable type inference failed */
    public oxxXoxO(@OXOo.OOXIXo List<? extends E> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        this.f29168XO = list;
    }

    @Override // kotlin.collections.II0xO0, java.util.List
    public E get(int i) {
        II0xO0.Companion.II0xO0(i, this.f29166IXxxXO);
        return this.f29168XO.get(this.f29167Oo + i);
    }

    @Override // kotlin.collections.II0xO0, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f29166IXxxXO;
    }

    public final void oIX0oI(int i, int i2) {
        II0xO0.Companion.oxoX(i, i2, this.f29168XO.size());
        this.f29167Oo = i;
        this.f29166IXxxXO = i2 - i;
    }
}
