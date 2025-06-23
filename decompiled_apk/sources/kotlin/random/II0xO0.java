package kotlin.random;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class II0xO0 extends kotlin.random.oIX0oI {

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final oIX0oI f29394XO = new oIX0oI();

    /* loaded from: classes6.dex */
    public static final class oIX0oI extends ThreadLocal<java.util.Random> {
        @Override // java.lang.ThreadLocal
        @OOXIXo
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public java.util.Random initialValue() {
            return new java.util.Random();
        }
    }

    @Override // kotlin.random.oIX0oI
    @OOXIXo
    public java.util.Random getImpl() {
        java.util.Random random = this.f29394XO.get();
        IIX0o.oO(random, "get(...)");
        return random;
    }
}
