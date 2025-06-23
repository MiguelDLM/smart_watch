package kotlinx.coroutines.flow;

import com.goodix.ble.libcomx.task.ITask;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.IIX0;
import kotlinx.coroutines.xII;

@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", i = {}, l = {ITask.EVT_START}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements Oox.x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ kotlinx.coroutines.OxI<IIXOooo<T>> $result;
    final /* synthetic */ X0o0xo<T> $upstream;
    private /* synthetic */ Object L$0;
    int label;

    @XX({"SMAP\nShare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/FlowKt__ShareKt$launchSharingDeferred$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,426:1\n1#2:427\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> implements XO {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.OxI<IIXOooo<T>> f30056IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ xII f30057Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<xoIox<T>> f30058XO;

        public oIX0oI(Ref.ObjectRef<xoIox<T>> objectRef, xII xii, kotlinx.coroutines.OxI<IIXOooo<T>> oxI) {
            this.f30058XO = objectRef;
            this.f30057Oo = xii;
            this.f30056IXxxXO = oxI;
        }

        /* JADX WARN: Type inference failed for: r4v2, types: [kotlinx.coroutines.flow.IIXOooo, T, kotlinx.coroutines.flow.xoIox] */
        @Override // kotlinx.coroutines.flow.XO
        @OXOo.oOoXoXO
        public final Object emit(T t, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
            oXIO0o0XI oxio0o0xi;
            xoIox<T> xoiox = this.f30058XO.element;
            if (xoiox != null) {
                xoiox.setValue(t);
                oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            } else {
                oxio0o0xi = null;
            }
            if (oxio0o0xi == null) {
                xII xii = this.f30057Oo;
                Ref.ObjectRef<xoIox<T>> objectRef = this.f30058XO;
                kotlinx.coroutines.OxI<IIXOooo<T>> oxI = this.f30056IXxxXO;
                ?? r4 = (T) xoXoI.oIX0oI(t);
                oxI.oO(new oOoXoXO(r4, IIX0.XI0IXoo(xii.getCoroutineContext())));
                objectRef.element = r4;
            }
            return oXIO0o0XI.f29392oIX0oI;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ShareKt$launchSharingDeferred$1(X0o0xo<? extends T> x0o0xo, kotlinx.coroutines.OxI<IIXOooo<T>> oxI, kotlin.coroutines.I0Io<? super FlowKt__ShareKt$launchSharingDeferred$1> i0Io) {
        super(2, i0Io);
        this.$upstream = x0o0xo;
        this.$result = oxI;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        FlowKt__ShareKt$launchSharingDeferred$1 flowKt__ShareKt$launchSharingDeferred$1 = new FlowKt__ShareKt$launchSharingDeferred$1(this.$upstream, this.$result, i0Io);
        flowKt__ShareKt$launchSharingDeferred$1.L$0 = obj;
        return flowKt__ShareKt$launchSharingDeferred$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    I0oOoX.x0XOIxOo(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                I0oOoX.x0XOIxOo(obj);
                xII xii = (xII) this.L$0;
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                X0o0xo<T> x0o0xo = this.$upstream;
                oIX0oI oix0oi = new oIX0oI(objectRef, xii, this.$result);
                this.label = 1;
                if (x0o0xo.collect(oix0oi, this) == oOoXoXO2) {
                    return oOoXoXO2;
                }
            }
            return oXIO0o0XI.f29392oIX0oI;
        } catch (Throwable th) {
            this.$result.I0Io(th);
            throw th;
        }
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((FlowKt__ShareKt$launchSharingDeferred$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
