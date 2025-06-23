package kotlinx.coroutines.internal;

import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@kotlin.jvm.internal.XX({"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/WeakMapCtorCache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,116:1\n1#2:117\n*E\n"})
/* loaded from: classes6.dex */
public final class I0X0x0oIo extends OOXIXo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final I0X0x0oIo f30221oIX0oI = new I0X0x0oIo();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final ReentrantReadWriteLock f30220II0xO0 = new ReentrantReadWriteLock();

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final WeakHashMap<Class<? extends Throwable>, Oox.oOoXoXO<Throwable, Throwable>> f30219I0Io = new WeakHashMap<>();

    @Override // kotlinx.coroutines.internal.OOXIXo
    @OXOo.OOXIXo
    public Oox.oOoXoXO<Throwable, Throwable> oIX0oI(@OXOo.OOXIXo Class<? extends Throwable> cls) {
        int i;
        Oox.oOoXoXO<Throwable, Throwable> II0xO02;
        ReentrantReadWriteLock reentrantReadWriteLock = f30220II0xO0;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        readLock.lock();
        try {
            Oox.oOoXoXO<Throwable, Throwable> oooxoxo = f30219I0Io.get(cls);
            if (oooxoxo != null) {
                return oooxoxo;
            }
            ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
            int i2 = 0;
            if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
                i = reentrantReadWriteLock.getReadHoldCount();
            } else {
                i = 0;
            }
            for (int i3 = 0; i3 < i; i3++) {
                readLock2.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                WeakHashMap<Class<? extends Throwable>, Oox.oOoXoXO<Throwable, Throwable>> weakHashMap = f30219I0Io;
                Oox.oOoXoXO<Throwable, Throwable> oooxoxo2 = weakHashMap.get(cls);
                if (oooxoxo2 == null) {
                    II0xO02 = ExceptionsConstructorKt.II0xO0(cls);
                    weakHashMap.put(cls, II0xO02);
                    while (i2 < i) {
                        readLock2.lock();
                        i2++;
                    }
                    writeLock.unlock();
                    return II0xO02;
                }
                return oooxoxo2;
            } finally {
                while (i2 < i) {
                    readLock2.lock();
                    i2++;
                }
                writeLock.unlock();
            }
        } finally {
            readLock.unlock();
        }
    }
}
