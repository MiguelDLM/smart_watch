package kotlin.random;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes6.dex */
final class KotlinRandom extends java.util.Random {

    @OOXIXo
    private static final oIX0oI Companion = new oIX0oI(null);
    private static final long serialVersionUID = 0;

    @OOXIXo
    private final Random impl;
    private boolean seedInitialized;

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public KotlinRandom(@OOXIXo Random impl) {
        IIX0o.x0xO0oo(impl, "impl");
        this.impl = impl;
    }

    @OOXIXo
    public final Random getImpl() {
        return this.impl;
    }

    @Override // java.util.Random
    public int next(int i) {
        return this.impl.nextBits(i);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return this.impl.nextBoolean();
    }

    @Override // java.util.Random
    public void nextBytes(@OOXIXo byte[] bytes) {
        IIX0o.x0xO0oo(bytes, "bytes");
        this.impl.nextBytes(bytes);
    }

    @Override // java.util.Random
    public double nextDouble() {
        return this.impl.nextDouble();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return this.impl.nextFloat();
    }

    @Override // java.util.Random
    public int nextInt() {
        return this.impl.nextInt();
    }

    @Override // java.util.Random
    public long nextLong() {
        return this.impl.nextLong();
    }

    @Override // java.util.Random
    public void setSeed(long j) {
        if (!this.seedInitialized) {
            this.seedInitialized = true;
            return;
        }
        throw new UnsupportedOperationException("Setting seed is not supported.");
    }

    @Override // java.util.Random
    public int nextInt(int i) {
        return this.impl.nextInt(i);
    }
}
