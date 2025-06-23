package kotlinx.coroutines.flow;

import kotlin.DeprecationLevel;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.xII;

@XX({"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/flow/FlowKt__ChannelsKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,176:1\n107#2:177\n*S KotlinDebug\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/flow/FlowKt__ChannelsKt\n*L\n153#1:177\n*E\n"})
/* loaded from: classes6.dex */
public final /* synthetic */ class FlowKt__ChannelsKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @XX({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Channels.kt\nkotlinx/coroutines/flow/FlowKt__ChannelsKt\n*L\n1#1,113:1\n154#2,2:114\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> implements X0o0xo<T> {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.channels.oxoX f29976XO;

        public oIX0oI(kotlinx.coroutines.channels.oxoX oxox) {
            this.f29976XO = oxox;
        }

        @Override // kotlinx.coroutines.flow.X0o0xo
        @OXOo.oOoXoXO
        public Object collect(@OXOo.OOXIXo XO<? super T> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
            Object OO2 = Oxx0IOOO.OO(xo2, this.f29976XO.ooOOo0oXI(), i0Io);
            if (OO2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                return OO2;
            }
            return oXIO0o0XI.f29392oIX0oI;
        }
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> I0Io(@OXOo.OOXIXo ReceiveChannel<? extends T> receiveChannel) {
        return new II0xO0(receiveChannel, true, null, 0, null, 28, null);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> II0xO0(@OXOo.OOXIXo kotlinx.coroutines.channels.oxoX<T> oxox) {
        return new oIX0oI(oxox);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> Oxx0IOOO(@OXOo.OOXIXo ReceiveChannel<? extends T> receiveChannel) {
        return new II0xO0(receiveChannel, false, null, 0, null, 28, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #0 {all -> 0x003c, blocks: (B:12:0x0036, B:14:0x0062, B:19:0x0077, B:21:0x007f, B:32:0x0054, B:34:0x005e), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, kotlinx.coroutines.flow.XO] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0091 -> B:13:0x0039). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object X0o0xo(kotlinx.coroutines.flow.XO<? super T> r6, kotlinx.coroutines.channels.ReceiveChannel<? extends T> r7, boolean r8, kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L58
            if (r2 == r4) goto L46
            if (r2 != r3) goto L3e
            boolean r8 = r0.Z$0
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.XO r2 = (kotlinx.coroutines.flow.XO) r2
            kotlin.I0oOoX.x0XOIxOo(r9)     // Catch: java.lang.Throwable -> L3c
        L39:
            r9 = r6
            r6 = r2
            goto L62
        L3c:
            r6 = move-exception
            goto L9d
        L3e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L46:
            boolean r8 = r0.Z$0
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.XO r2 = (kotlinx.coroutines.flow.XO) r2
            kotlin.I0oOoX.x0XOIxOo(r9)     // Catch: java.lang.Throwable -> L3c
            goto L77
        L58:
            kotlin.I0oOoX.x0XOIxOo(r9)
            kotlinx.coroutines.flow.Oxx0IOOO.x0xO(r6)
            kotlinx.coroutines.channels.ChannelIterator r9 = r7.iterator()     // Catch: java.lang.Throwable -> L3c
        L62:
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L3c
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L3c
            r0.L$2 = r9     // Catch: java.lang.Throwable -> L3c
            r0.Z$0 = r8     // Catch: java.lang.Throwable -> L3c
            r0.label = r4     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r2 = r9.I0Io(r0)     // Catch: java.lang.Throwable -> L3c
            if (r2 != r1) goto L73
            return r1
        L73:
            r5 = r2
            r2 = r6
            r6 = r9
            r9 = r5
        L77:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L3c
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L3c
            if (r9 == 0) goto L94
            java.lang.Object r9 = r6.next()     // Catch: java.lang.Throwable -> L3c
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L3c
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L3c
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L3c
            r0.Z$0 = r8     // Catch: java.lang.Throwable -> L3c
            r0.label = r3     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r9 = r2.emit(r9, r0)     // Catch: java.lang.Throwable -> L3c
            if (r9 != r1) goto L39
            return r1
        L94:
            if (r8 == 0) goto L9a
            r6 = 0
            kotlinx.coroutines.channels.oOoXoXO.II0xO0(r7, r6)
        L9a:
            kotlin.oXIO0o0XI r6 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r6
        L9d:
            throw r6     // Catch: java.lang.Throwable -> L9e
        L9e:
            r9 = move-exception
            if (r8 == 0) goto La4
            kotlinx.coroutines.channels.oOoXoXO.II0xO0(r7, r6)
        La4:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ChannelsKt.X0o0xo(kotlinx.coroutines.flow.XO, kotlinx.coroutines.channels.ReceiveChannel, boolean, kotlin.coroutines.I0Io):java.lang.Object");
    }

    @OXOo.OOXIXo
    public static final <T> ReceiveChannel<T> XO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo xII xii) {
        return kotlinx.coroutines.flow.internal.oxoX.II0xO0(x0o0xo).ooOOo0oXI(xii);
    }

    @OXOo.oOoXoXO
    public static final <T> Object oxoX(@OXOo.OOXIXo XO<? super T> xo2, @OXOo.OOXIXo ReceiveChannel<? extends T> receiveChannel, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object X0o0xo2 = X0o0xo(xo2, receiveChannel, true, i0Io);
        if (X0o0xo2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return X0o0xo2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }
}
