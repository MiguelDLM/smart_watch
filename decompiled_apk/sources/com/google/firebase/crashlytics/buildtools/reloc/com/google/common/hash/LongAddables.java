package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes10.dex */
final class LongAddables {
    private static final Supplier<LongAddable> SUPPLIER;

    /* loaded from: classes10.dex */
    public static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        private PureJavaLongAddable() {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.LongAddable
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.LongAddable
        public void increment() {
            getAndIncrement();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.LongAddable
        public long sum() {
            return get();
        }
    }

    static {
        Supplier<LongAddable> supplier;
        try {
            new LongAdder();
            supplier = new Supplier<LongAddable>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.LongAddables.1
                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Supplier, java.util.function.Supplier
                public LongAddable get() {
                    return new LongAdder();
                }
            };
        } catch (Throwable unused) {
            supplier = new Supplier<LongAddable>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.LongAddables.2
                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Supplier, java.util.function.Supplier
                public LongAddable get() {
                    return new PureJavaLongAddable();
                }
            };
        }
        SUPPLIER = supplier;
    }

    public static LongAddable create() {
        return SUPPLIER.get();
    }
}
