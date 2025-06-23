package androidx.core.util;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.annotation.IntRange;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

public final class Pools {

    public interface Pool<T> {
        @oOoXoXO
        T acquire();

        boolean release(@OOXIXo T t);
    }

    @XX({"SMAP\nPools.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pools.kt\nandroidx/core/util/Pools$SimplePool\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
    public static class SimplePool<T> implements Pool<T> {
        @OOXIXo
        private final Object[] pool;
        private int poolSize;

        public SimplePool(@IntRange(from = 1) int i) {
            if (i > 0) {
                this.pool = new Object[i];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private final boolean isInPool(T t) {
            int i = this.poolSize;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.pool[i2] == t) {
                    return true;
                }
            }
            return false;
        }

        @oOoXoXO
        public T acquire() {
            int i = this.poolSize;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            T t = this.pool[i2];
            IIX0o.x0XOIxOo(t, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
            this.pool[i2] = null;
            this.poolSize--;
            return t;
        }

        public boolean release(@OOXIXo T t) {
            IIX0o.x0xO0oo(t, "instance");
            if (!isInPool(t)) {
                int i = this.poolSize;
                Object[] objArr = this.pool;
                if (i >= objArr.length) {
                    return false;
                }
                objArr[i] = t;
                this.poolSize = i + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    @XX({"SMAP\nPools.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pools.kt\nandroidx/core/util/Pools$SynchronizedPool\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
    public static class SynchronizedPool<T> extends SimplePool<T> {
        @OOXIXo
        private final Object lock = new Object();

        public SynchronizedPool(int i) {
            super(i);
        }

        @oOoXoXO
        public T acquire() {
            T acquire;
            synchronized (this.lock) {
                acquire = super.acquire();
            }
            return acquire;
        }

        public boolean release(@OOXIXo T t) {
            boolean release;
            IIX0o.x0xO0oo(t, "instance");
            synchronized (this.lock) {
                release = super.release(t);
            }
            return release;
        }
    }

    private Pools() {
    }
}
