package X0OXX;

import II0OOXOx.OX00O0xII;
import II0OOXOx.XOxIOxOx;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;
import java.util.function.Supplier;

/* loaded from: classes6.dex */
public class I0Io {

    /* renamed from: X0OXX.I0Io$I0Io, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0052I0Io<O> extends oIX0oI<O, StampedLock> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0052I0Io(O o, final StampedLock stampedLock) {
            super(o, stampedLock, new Supplier() { // from class: X0OXX.II0XooXoX
                @Override // java.util.function.Supplier
                public final Object get() {
                    Lock asReadLock;
                    asReadLock = stampedLock.asReadLock();
                    return asReadLock;
                }
            }, new Supplier() { // from class: X0OXX.xxIXOIIO
                @Override // java.util.function.Supplier
                public final Object get() {
                    Lock asWriteLock;
                    asWriteLock = stampedLock.asWriteLock();
                    return asWriteLock;
                }
            });
            stampedLock.getClass();
        }
    }

    /* loaded from: classes6.dex */
    public static class II0xO0<O> extends oIX0oI<O, ReadWriteLock> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public II0xO0(O o, final ReadWriteLock readWriteLock) {
            super(o, readWriteLock, new Supplier() { // from class: X0OXX.oxoX
                @Override // java.util.function.Supplier
                public final Object get() {
                    return readWriteLock.readLock();
                }
            }, new Supplier() { // from class: X0OXX.X0o0xo
                @Override // java.util.function.Supplier
                public final Object get() {
                    return readWriteLock.writeLock();
                }
            });
            readWriteLock.getClass();
        }
    }

    /* loaded from: classes6.dex */
    public static class oIX0oI<O, L> {

        /* renamed from: I0Io, reason: collision with root package name */
        public final Supplier<Lock> f3251I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final O f3252II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final L f3253oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public final Supplier<Lock> f3254oxoX;

        public oIX0oI(O o, L l, Supplier<Lock> supplier, Supplier<Lock> supplier2) {
            Objects.requireNonNull(o, "object");
            this.f3252II0xO0 = o;
            Objects.requireNonNull(l, "lock");
            this.f3253oIX0oI = l;
            Objects.requireNonNull(supplier, "readLockSupplier");
            this.f3251I0Io = X0OXX.II0xO0.oIX0oI(supplier);
            Objects.requireNonNull(supplier2, "writeLockSupplier");
            this.f3254oxoX = X0OXX.II0xO0.oIX0oI(supplier2);
        }

        public <T> T I0Io(OX00O0xII<O, T, ?> oX00O0xII) {
            return (T) II0XooXoX(this.f3251I0Io, oX00O0xII);
        }

        public <T> T II0XooXoX(Supplier<Lock> supplier, OX00O0xII<O, T, ?> oX00O0xII) {
            Object obj;
            obj = supplier.get();
            ((Lock) obj).lock();
            try {
                return oX00O0xII.apply(this.f3252II0xO0);
            } finally {
            }
        }

        public void II0xO0(XOxIOxOx<O, ?> xOxIOxOx) {
            Oxx0IOOO(this.f3254oxoX, xOxIOxOx);
        }

        public void Oxx0IOOO(Supplier<Lock> supplier, XOxIOxOx<O, ?> xOxIOxOx) {
            Object obj;
            obj = supplier.get();
            ((Lock) obj).lock();
            try {
                xOxIOxOx.accept(this.f3252II0xO0);
            } finally {
            }
        }

        public L X0o0xo() {
            return this.f3253oIX0oI;
        }

        public O XO() {
            return this.f3252II0xO0;
        }

        public void oIX0oI(XOxIOxOx<O, ?> xOxIOxOx) {
            Oxx0IOOO(this.f3251I0Io, xOxIOxOx);
        }

        public <T> T oxoX(OX00O0xII<O, T, ?> oX00O0xII) {
            return (T) II0XooXoX(this.f3254oxoX, oX00O0xII);
        }
    }

    public static <O> C0052I0Io<O> II0xO0(O o) {
        return new C0052I0Io<>(o, X0OXX.oIX0oI.oIX0oI());
    }

    public static <O> II0xO0<O> oIX0oI(O o) {
        return new II0xO0<>(o, new ReentrantReadWriteLock());
    }
}
