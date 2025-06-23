package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.work.Operation;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nOperation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Operation.kt\nandroidx/work/OperationKt\n+ 2 Tracer.kt\nandroidx/work/TracerKt\n*L\n1#1,71:1\n53#2,9:72\n*S KotlinDebug\n*F\n+ 1 Operation.kt\nandroidx/work/OperationKt\n*L\n48#1:72,9\n*E\n"})
/* loaded from: classes.dex */
public final class OperationKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object await(@OXOo.OOXIXo androidx.work.Operation r4, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super androidx.work.Operation.State.SUCCESS> r5) {
        /*
            boolean r0 = r5 instanceof androidx.work.OperationKt$await$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.work.OperationKt$await$1 r0 = (androidx.work.OperationKt$await$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.work.OperationKt$await$1 r0 = new androidx.work.OperationKt$await$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.I0oOoX.x0XOIxOo(r5)
            goto L46
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.I0oOoX.x0XOIxOo(r5)
            com.google.common.util.concurrent.ListenableFuture r4 = r4.getResult()
            java.lang.String r5 = "result"
            kotlin.jvm.internal.IIX0o.oO(r4, r5)
            r0.label = r3
            java.lang.Object r5 = androidx.concurrent.futures.ListenableFutureKt.await(r4, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            java.lang.String r4 = "result.await()"
            kotlin.jvm.internal.IIX0o.oO(r5, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.OperationKt.await(androidx.work.Operation, kotlin.coroutines.I0Io):java.lang.Object");
    }

    private static final Object await$$forInline(Operation operation, kotlin.coroutines.I0Io<? super Operation.State.SUCCESS> i0Io) {
        ListenableFuture<Operation.State.SUCCESS> result = operation.getResult();
        IIX0o.oO(result, "result");
        xxX.X0o0xo(0);
        Object await = androidx.concurrent.futures.ListenableFutureKt.await(result, i0Io);
        xxX.X0o0xo(1);
        IIX0o.oO(await, "result.await()");
        return await;
    }

    @OXOo.OOXIXo
    public static final Operation launchOperation(@OXOo.OOXIXo final Tracer tracer, @OXOo.OOXIXo final String label, @OXOo.OOXIXo final Executor executor, @OXOo.OOXIXo final Oox.oIX0oI<oXIO0o0XI> block) {
        IIX0o.x0xO0oo(tracer, "tracer");
        IIX0o.x0xO0oo(label, "label");
        IIX0o.x0xO0oo(executor, "executor");
        IIX0o.x0xO0oo(block, "block");
        final MutableLiveData mutableLiveData = new MutableLiveData(Operation.IN_PROGRESS);
        ListenableFuture future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.work.II0XooXoX
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                oXIO0o0XI launchOperation$lambda$2;
                launchOperation$lambda$2 = OperationKt.launchOperation$lambda$2(executor, tracer, label, block, mutableLiveData, completer);
                return launchOperation$lambda$2;
            }
        });
        IIX0o.oO(future, "getFuture { completer ->…}\n            }\n        }");
        return new OperationImpl(mutableLiveData, future);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final oXIO0o0XI launchOperation$lambda$2(Executor executor, final Tracer tracer, final String str, final Oox.oIX0oI oix0oi, final MutableLiveData mutableLiveData, final CallbackToFutureAdapter.Completer completer) {
        IIX0o.x0xO0oo(completer, "completer");
        executor.execute(new Runnable() { // from class: androidx.work.xxIXOIIO
            @Override // java.lang.Runnable
            public final void run() {
                OperationKt.launchOperation$lambda$2$lambda$1(Tracer.this, str, oix0oi, mutableLiveData, completer);
            }
        });
        return oXIO0o0XI.f29392oIX0oI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchOperation$lambda$2$lambda$1(Tracer tracer, String str, Oox.oIX0oI oix0oi, MutableLiveData mutableLiveData, CallbackToFutureAdapter.Completer completer) {
        boolean isEnabled = tracer.isEnabled();
        if (isEnabled) {
            try {
                tracer.beginSection(str);
            } finally {
                if (isEnabled) {
                    tracer.endSection();
                }
            }
        }
        try {
            oix0oi.invoke();
            Operation.State.SUCCESS success = Operation.SUCCESS;
            mutableLiveData.postValue(success);
            completer.set(success);
        } catch (Throwable th) {
            mutableLiveData.postValue(new Operation.State.FAILURE(th));
            completer.setException(th);
        }
        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
    }
}
