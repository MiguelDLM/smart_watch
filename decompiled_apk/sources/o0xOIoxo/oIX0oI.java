package o0xOIoxo;

import OXOo.OOXIXo;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class oIX0oI extends kotlin.random.oIX0oI {
    @Override // kotlin.random.oIX0oI
    @OOXIXo
    public Random getImpl() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        IIX0o.oO(current, "current(...)");
        return current;
    }

    @Override // kotlin.random.Random
    public double nextDouble(double d) {
        return ThreadLocalRandom.current().nextDouble(d);
    }

    @Override // kotlin.random.Random
    public int nextInt(int i, int i2) {
        return ThreadLocalRandom.current().nextInt(i, i2);
    }

    @Override // kotlin.random.Random
    public long nextLong(long j) {
        return ThreadLocalRandom.current().nextLong(j);
    }

    @Override // kotlin.random.Random
    public long nextLong(long j, long j2) {
        return ThreadLocalRandom.current().nextLong(j, j2);
    }
}
