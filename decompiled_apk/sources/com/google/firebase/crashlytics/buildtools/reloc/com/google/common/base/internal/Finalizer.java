package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.internal;

import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.NullableDecl;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes10.dex */
public class Finalizer implements Runnable {
    private static final String FINALIZABLE_REFERENCE = "com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.FinalizableReference";

    @NullableDecl
    private static final Constructor<Thread> bigThreadConstructor;

    @NullableDecl
    private static final Field inheritableThreadLocals;
    private static final Logger logger = Logger.getLogger(Finalizer.class.getName());
    private final WeakReference<Class<?>> finalizableReferenceClassReference;
    private final PhantomReference<Object> frqReference;
    private final ReferenceQueue<Object> queue;

    static {
        Field field;
        Constructor<Thread> bigThreadConstructor2 = getBigThreadConstructor();
        bigThreadConstructor = bigThreadConstructor2;
        if (bigThreadConstructor2 == null) {
            field = getInheritableThreadLocalsField();
        } else {
            field = null;
        }
        inheritableThreadLocals = field;
    }

    private Finalizer(Class<?> cls, ReferenceQueue<Object> referenceQueue, PhantomReference<Object> phantomReference) {
        this.queue = referenceQueue;
        this.finalizableReferenceClassReference = new WeakReference<>(cls);
        this.frqReference = phantomReference;
    }

    private boolean cleanUp(Reference<?> reference) {
        Method finalizeReferentMethod = getFinalizeReferentMethod();
        if (finalizeReferentMethod == null) {
            return false;
        }
        do {
            reference.clear();
            if (reference == this.frqReference) {
                return false;
            }
            try {
                finalizeReferentMethod.invoke(reference, null);
            } catch (Throwable th) {
                logger.log(Level.SEVERE, "Error cleaning up after reference.", th);
            }
            reference = this.queue.poll();
        } while (reference != null);
        return true;
    }

    @NullableDecl
    private static Constructor<Thread> getBigThreadConstructor() {
        try {
            return Thread.class.getConstructor(ThreadGroup.class, Runnable.class, String.class, Long.TYPE, Boolean.TYPE);
        } catch (Throwable unused) {
            return null;
        }
    }

    @NullableDecl
    private Method getFinalizeReferentMethod() {
        Class<?> cls = this.finalizableReferenceClassReference.get();
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("finalizeReferent", null);
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    @NullableDecl
    private static Field getInheritableThreadLocalsField() {
        try {
            Field declaredField = Thread.class.getDeclaredField("inheritableThreadLocals");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            logger.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:3|(10:5|6|7|(1:9)|10|11|12|(1:14)|16|17)|24|(0)|10|11|12|(0)|16|17) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
    
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.internal.Finalizer.logger.log(java.util.logging.Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0056 A[Catch: all -> 0x005a, TRY_LEAVE, TryCatch #0 {all -> 0x005a, blocks: (B:12:0x0052, B:14:0x0056), top: B:11:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void startFinalizer(java.lang.Class<?> r5, java.lang.ref.ReferenceQueue<java.lang.Object> r6, java.lang.ref.PhantomReference<java.lang.Object> r7) {
        /*
            r0 = 1
            java.lang.String r1 = r5.getName()
            java.lang.String r2 = "com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.FinalizableReference"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L68
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.internal.Finalizer r1 = new com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.internal.Finalizer
            r1.<init>(r5, r6, r7)
            java.lang.Class<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.internal.Finalizer> r5 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.internal.Finalizer.class
            java.lang.String r5 = r5.getName()
            java.lang.reflect.Constructor<java.lang.Thread> r6 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.internal.Finalizer.bigThreadConstructor
            r7 = 0
            if (r6 == 0) goto L47
            r2 = 0
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> L3d
            r3 = 5
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L3d
            r4 = 0
            r3[r4] = r7     // Catch: java.lang.Throwable -> L3d
            r3[r0] = r1     // Catch: java.lang.Throwable -> L3d
            r4 = 2
            r3[r4] = r5     // Catch: java.lang.Throwable -> L3d
            r4 = 3
            r3[r4] = r2     // Catch: java.lang.Throwable -> L3d
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L3d
            r4 = 4
            r3[r4] = r2     // Catch: java.lang.Throwable -> L3d
            java.lang.Object r6 = r6.newInstance(r3)     // Catch: java.lang.Throwable -> L3d
            java.lang.Thread r6 = (java.lang.Thread) r6     // Catch: java.lang.Throwable -> L3d
            goto L48
        L3d:
            r6 = move-exception
            java.util.logging.Logger r2 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.internal.Finalizer.logger
            java.util.logging.Level r3 = java.util.logging.Level.INFO
            java.lang.String r4 = "Failed to create a thread without inherited thread-local values"
            r2.log(r3, r4, r6)
        L47:
            r6 = r7
        L48:
            if (r6 != 0) goto L4f
            java.lang.Thread r6 = new java.lang.Thread
            r6.<init>(r7, r1, r5)
        L4f:
            r6.setDaemon(r0)
            java.lang.reflect.Field r5 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.internal.Finalizer.inheritableThreadLocals     // Catch: java.lang.Throwable -> L5a
            if (r5 == 0) goto L64
            r5.set(r6, r7)     // Catch: java.lang.Throwable -> L5a
            goto L64
        L5a:
            r5 = move-exception
            java.util.logging.Logger r7 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.internal.Finalizer.logger
            java.util.logging.Level r0 = java.util.logging.Level.INFO
            java.lang.String r1 = "Failed to clear thread local values inherited by reference finalizer thread."
            r7.log(r0, r1, r5)
        L64:
            r6.start()
            return
        L68:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Expected com.google.common.base.FinalizableReference."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.internal.Finalizer.startFinalizer(java.lang.Class, java.lang.ref.ReferenceQueue, java.lang.ref.PhantomReference):void");
    }

    @Override // java.lang.Runnable
    public void run() {
        while (cleanUp(this.queue.remove())) {
        }
    }
}
