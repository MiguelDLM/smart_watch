package kotlinx.coroutines.flow;

import kotlin.I0oOoX;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;
import kotlin.oXIO0o0XI;

@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class StartedLazily$command$1 extends SuspendLambda implements Oox.x0xO0oo<XO<? super SharingCommand>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ IIXOooo<Integer> $subscriptionCount;
    private /* synthetic */ Object L$0;
    int label;

    /* renamed from: kotlinx.coroutines.flow.StartedLazily$command$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1<T> implements XO {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ XO<SharingCommand> f30145Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f30146XO;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Ref.BooleanRef booleanRef, XO<? super SharingCommand> xo2) {
            this.f30146XO = booleanRef;
            this.f30145Oo = xo2;
        }

        @Override // kotlinx.coroutines.flow.XO
        public /* bridge */ /* synthetic */ Object emit(Object obj, kotlin.coroutines.I0Io i0Io) {
            return oIX0oI(((Number) obj).intValue(), i0Io);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @OXOo.oOoXoXO
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object oIX0oI(int r5, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r6
                kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1 r0 = (kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1 r0 = new kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.I0oOoX.x0XOIxOo(r6)
                goto L4b
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                kotlin.I0oOoX.x0XOIxOo(r6)
                if (r5 <= 0) goto L4e
                kotlin.jvm.internal.Ref$BooleanRef r5 = r4.f30146XO
                boolean r6 = r5.element
                if (r6 != 0) goto L4e
                r5.element = r3
                kotlinx.coroutines.flow.XO<kotlinx.coroutines.flow.SharingCommand> r5 = r4.f30145Oo
                kotlinx.coroutines.flow.SharingCommand r6 = kotlinx.coroutines.flow.SharingCommand.START
                r0.label = r3
                java.lang.Object r5 = r5.emit(r6, r0)
                if (r5 != r1) goto L4b
                return r1
            L4b:
                kotlin.oXIO0o0XI r5 = kotlin.oXIO0o0XI.f29392oIX0oI
                return r5
            L4e:
                kotlin.oXIO0o0XI r5 = kotlin.oXIO0o0XI.f29392oIX0oI
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedLazily$command$1.AnonymousClass1.oIX0oI(int, kotlin.coroutines.I0Io):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedLazily$command$1(IIXOooo<Integer> iIXOooo, kotlin.coroutines.I0Io<? super StartedLazily$command$1> i0Io) {
        super(2, i0Io);
        this.$subscriptionCount = iIXOooo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        StartedLazily$command$1 startedLazily$command$1 = new StartedLazily$command$1(this.$subscriptionCount, i0Io);
        startedLazily$command$1.L$0 = obj;
        return startedLazily$command$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            I0oOoX.x0XOIxOo(obj);
        } else {
            I0oOoX.x0XOIxOo(obj);
            XO xo2 = (XO) this.L$0;
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            IIXOooo<Integer> iIXOooo = this.$subscriptionCount;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(booleanRef, xo2);
            this.label = 1;
            if (iIXOooo.collect(anonymousClass1, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        throw new KotlinNothingValueException();
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo XO<? super SharingCommand> xo2, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((StartedLazily$command$1) create(xo2, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
