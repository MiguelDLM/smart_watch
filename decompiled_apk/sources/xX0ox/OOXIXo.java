package xX0ox;

import java.util.Comparator;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class OOXIXo implements Comparator<Comparable<? super Object>> {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final OOXIXo f34623XO = new OOXIXo();

    @Override // java.util.Comparator
    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
    public int compare(@OXOo.OOXIXo Comparable<Object> a2, @OXOo.OOXIXo Comparable<Object> b) {
        IIX0o.x0xO0oo(a2, "a");
        IIX0o.x0xO0oo(b, "b");
        return b.compareTo(a2);
    }

    @Override // java.util.Comparator
    @OXOo.OOXIXo
    public final Comparator<Comparable<? super Object>> reversed() {
        return xoIox.f34647XO;
    }
}
