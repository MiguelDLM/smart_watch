package xX0ox;

import java.util.Comparator;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class oOoXoXO<T> implements Comparator<T> {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Comparator<T> f34644XO;

    public oOoXoXO(@OXOo.OOXIXo Comparator<T> comparator) {
        IIX0o.x0xO0oo(comparator, "comparator");
        this.f34644XO = comparator;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        return this.f34644XO.compare(t2, t);
    }

    @OXOo.OOXIXo
    public final Comparator<T> oIX0oI() {
        return this.f34644XO;
    }

    @Override // java.util.Comparator
    @OXOo.OOXIXo
    public final Comparator<T> reversed() {
        return this.f34644XO;
    }
}
