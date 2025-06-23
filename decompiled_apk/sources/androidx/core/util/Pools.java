package androidx.core.util;

import OXOo.oOoXoXO;
import androidx.annotation.IntRange;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

/* loaded from: classes.dex */
public final class Pools {

    /* loaded from: classes.dex */
    public interface Pool<T> {
        @oOoXoXO
        T acquire();

        boolean release(@OXOo.OOXIXo T t);
    }

    @XX({"SMAP\nPools.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pools.kt\nandroidx/core/util/Pools$SimplePool\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
    /* loaded from: classes.dex */
    public static class SimplePool<T> implements Pool<T> {

        @OXOo.OOXIXo
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

        @Override // androidx.core.util.Pools.Pool
        @oOoXoXO
        public T acquire() {
            int i = this.poolSize;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            T t = (T) this.pool[i2];
            IIX0o.x0XOIxOo(t, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
            this.pool[i2] = null;
            this.poolSize--;
            return t;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@OXOo.OOXIXo T instance) {
            IIX0o.x0xO0oo(instance, "instance");
            if (!isInPool(instance)) {
                int i = this.poolSize;
                Object[] objArr = this.pool;
                if (i < objArr.length) {
                    objArr[i] = instance;
                    this.poolSize = i + 1;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    @XX({"SMAP\nPools.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pools.kt\nandroidx/core/util/Pools$SynchronizedPool\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
    /* loaded from: classes.dex */
    public static class SynchronizedPool<T> extends SimplePool<T> {

        @OXOo.OOXIXo
        private final Object lock;

        public SynchronizedPool(int i) {
            super(i);
            this.lock = new Object();
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        @oOoXoXO
        public T acquire() {
            T t;
            synchronized (this.lock) {
                t = (T) super.acquire();
            }
            return t;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public boolean release(@OXOo.OOXIXo T instance) {
            boolean release;
            IIX0o.x0xO0oo(instance, "instance");
            synchronized (this.lock) {
                release = super.release(instance);
            }
            return release;
        }
    }

    private Pools() {
    }
}
