package kotlinx.coroutines.flow;

import com.jieli.jl_rcsp.constant.Command;
import com.sma.smartv3.view.picker.HeightPicker;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.xII;

@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", i = {}, l = {Command.CMD_GET_EXTERNAL_FLASH_MSG, HeightPicker.f25534xoXoI, 219, 225}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FlowKt__ShareKt$launchSharing$1 extends SuspendLambda implements Oox.x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ T $initialValue;
    final /* synthetic */ xxIXOIIO<T> $shared;
    final /* synthetic */ Oxx0xo $started;
    final /* synthetic */ X0o0xo<T> $upstream;
    int label;

    @IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Oox.x0xO0oo<Integer, kotlin.coroutines.I0Io<? super Boolean>, Object> {
        /* synthetic */ int I$0;
        int label;

        public AnonymousClass1(kotlin.coroutines.I0Io<? super AnonymousClass1> i0Io) {
            super(2, i0Io);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @OXOo.OOXIXo
        public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(i0Io);
            anonymousClass1.I$0 = ((Number) obj).intValue();
            return anonymousClass1;
        }

        @OXOo.oOoXoXO
        public final Object invoke(int i, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super Boolean> i0Io) {
            return ((AnonymousClass1) create(Integer.valueOf(i), i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @OXOo.oOoXoXO
        public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
            boolean z;
            kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
            if (this.label == 0) {
                I0oOoX.x0XOIxOo(obj);
                if (this.I$0 > 0) {
                    z = true;
                } else {
                    z = false;
                }
                return IXIxx0.oIX0oI.oIX0oI(z);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // Oox.x0xO0oo
        public /* bridge */ /* synthetic */ Object invoke(Integer num, kotlin.coroutines.I0Io<? super Boolean> i0Io) {
            return invoke(num.intValue(), i0Io);
        }
    }

    @IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Oox.x0xO0oo<SharingCommand, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
        final /* synthetic */ T $initialValue;
        final /* synthetic */ xxIXOIIO<T> $shared;
        final /* synthetic */ X0o0xo<T> $upstream;
        /* synthetic */ Object L$0;
        int label;

        /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2$oIX0oI */
        /* loaded from: classes6.dex */
        public /* synthetic */ class oIX0oI {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public static final /* synthetic */ int[] f30055oIX0oI;

            static {
                int[] iArr = new int[SharingCommand.values().length];
                try {
                    iArr[SharingCommand.START.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SharingCommand.STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SharingCommand.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f30055oIX0oI = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(X0o0xo<? extends T> x0o0xo, xxIXOIIO<T> xxixoiio, T t, kotlin.coroutines.I0Io<? super AnonymousClass2> i0Io) {
            super(2, i0Io);
            this.$upstream = x0o0xo;
            this.$shared = xxixoiio;
            this.$initialValue = t;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @OXOo.OOXIXo
        public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$upstream, this.$shared, this.$initialValue, i0Io);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @OXOo.oOoXoXO
        public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
            Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    I0oOoX.x0XOIxOo(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                I0oOoX.x0XOIxOo(obj);
                int i2 = oIX0oI.f30055oIX0oI[((SharingCommand) this.L$0).ordinal()];
                if (i2 != 1) {
                    if (i2 == 3) {
                        T t = this.$initialValue;
                        if (t == oO.f30205oIX0oI) {
                            this.$shared.II0xO0();
                        } else {
                            this.$shared.I0Io(t);
                        }
                    }
                } else {
                    X0o0xo<T> x0o0xo = this.$upstream;
                    Object obj2 = this.$shared;
                    this.label = 1;
                    if (x0o0xo.collect(obj2, this) == oOoXoXO2) {
                        return oOoXoXO2;
                    }
                }
            }
            return oXIO0o0XI.f29392oIX0oI;
        }

        @Override // Oox.x0xO0oo
        @OXOo.oOoXoXO
        public final Object invoke(@OXOo.OOXIXo SharingCommand sharingCommand, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
            return ((AnonymousClass2) create(sharingCommand, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ShareKt$launchSharing$1(Oxx0xo oxx0xo, X0o0xo<? extends T> x0o0xo, xxIXOIIO<T> xxixoiio, T t, kotlin.coroutines.I0Io<? super FlowKt__ShareKt$launchSharing$1> i0Io) {
        super(2, i0Io);
        this.$started = oxx0xo;
        this.$upstream = x0o0xo;
        this.$shared = xxixoiio;
        this.$initialValue = t;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return new FlowKt__ShareKt$launchSharing$1(this.$started, this.$upstream, this.$shared, this.$initialValue, i0Io);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0068 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@OXOo.OOXIXo java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r1 = r7.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L25
            if (r1 == r5) goto L21
            if (r1 == r4) goto L1d
            if (r1 == r3) goto L21
            if (r1 != r2) goto L15
            goto L21
        L15:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1d:
            kotlin.I0oOoX.x0XOIxOo(r8)
            goto L5c
        L21:
            kotlin.I0oOoX.x0XOIxOo(r8)
            goto L8d
        L25:
            kotlin.I0oOoX.x0XOIxOo(r8)
            kotlinx.coroutines.flow.Oxx0xo r8 = r7.$started
            kotlinx.coroutines.flow.Oxx0xo$oIX0oI r1 = kotlinx.coroutines.flow.Oxx0xo.f30128oIX0oI
            kotlinx.coroutines.flow.Oxx0xo r6 = r1.I0Io()
            if (r8 != r6) goto L3f
            kotlinx.coroutines.flow.X0o0xo<T> r8 = r7.$upstream
            kotlinx.coroutines.flow.xxIXOIIO<T> r1 = r7.$shared
            r7.label = r5
            java.lang.Object r8 = r8.collect(r1, r7)
            if (r8 != r0) goto L8d
            return r0
        L3f:
            kotlinx.coroutines.flow.Oxx0xo r8 = r7.$started
            kotlinx.coroutines.flow.Oxx0xo r1 = r1.oxoX()
            r5 = 0
            if (r8 != r1) goto L69
            kotlinx.coroutines.flow.xxIXOIIO<T> r8 = r7.$shared
            kotlinx.coroutines.flow.IIXOooo r8 = r8.oxoX()
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1 r1 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1
            r1.<init>(r5)
            r7.label = r4
            java.lang.Object r8 = kotlinx.coroutines.flow.Oxx0IOOO.o0xxxXXxX(r8, r1, r7)
            if (r8 != r0) goto L5c
            return r0
        L5c:
            kotlinx.coroutines.flow.X0o0xo<T> r8 = r7.$upstream
            kotlinx.coroutines.flow.xxIXOIIO<T> r1 = r7.$shared
            r7.label = r3
            java.lang.Object r8 = r8.collect(r1, r7)
            if (r8 != r0) goto L8d
            return r0
        L69:
            kotlinx.coroutines.flow.Oxx0xo r8 = r7.$started
            kotlinx.coroutines.flow.xxIXOIIO<T> r1 = r7.$shared
            kotlinx.coroutines.flow.IIXOooo r1 = r1.oxoX()
            kotlinx.coroutines.flow.X0o0xo r8 = r8.oIX0oI(r1)
            kotlinx.coroutines.flow.X0o0xo r8 = kotlinx.coroutines.flow.Oxx0IOOO.Xo0(r8)
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2 r1 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2
            kotlinx.coroutines.flow.X0o0xo<T> r3 = r7.$upstream
            kotlinx.coroutines.flow.xxIXOIIO<T> r4 = r7.$shared
            T r6 = r7.$initialValue
            r1.<init>(r3, r4, r6, r5)
            r7.label = r2
            java.lang.Object r8 = kotlinx.coroutines.flow.Oxx0IOOO.X0IIOO(r8, r1, r7)
            if (r8 != r0) goto L8d
            return r0
        L8d:
            kotlin.oXIO0o0XI r8 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((FlowKt__ShareKt$launchSharing$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
