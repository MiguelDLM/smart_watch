package androidx.work.impl.constraints;

import IXIxx0.oxoX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.IXxxXO;
import Oox.oIX0oI;
import androidx.work.impl.constraints.ConstraintsState;
import kotlin.I0oOoX;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.flow.X0o0xo;
import kotlinx.coroutines.flow.XO;
import kotlinx.coroutines.flow.internal.CombineKt;

@XX({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,113:1\n289#2,5:114\n*E\n"})
public final class WorkConstraintsTracker$track$$inlined$combine$1 implements X0o0xo<ConstraintsState> {
    final /* synthetic */ X0o0xo[] $flowArray$inlined;

    @oxoX(c = "androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3", f = "WorkConstraintsTracker.kt", i = {}, l = {292}, m = "invokeSuspend", n = {}, s = {})
    @XX({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$2\n+ 2 WorkConstraintsTracker.kt\nandroidx/work/impl/constraints/WorkConstraintsTracker\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,332:1\n94#2:333\n1282#3,2:334\n*S KotlinDebug\n*F\n+ 1 WorkConstraintsTracker.kt\nandroidx/work/impl/constraints/WorkConstraintsTracker\n*L\n94#1:334,2\n*E\n"})
    /* renamed from: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3  reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements IXxxXO<XO<? super ConstraintsState>, ConstraintsState[], I0Io<? super oXIO0o0XI>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        @oOoXoXO
        public final Object invokeSuspend(@OOXIXo Object obj) {
            ConstraintsState constraintsState;
            Object oOoXoXO2 = II0xO0.oOoXoXO();
            int i = this.label;
            if (i == 0) {
                I0oOoX.x0XOIxOo(obj);
                XO xo2 = (XO) this.L$0;
                ConstraintsState[] constraintsStateArr = (ConstraintsState[]) ((Object[]) this.L$1);
                int length = constraintsStateArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        constraintsState = null;
                        break;
                    }
                    constraintsState = constraintsStateArr[i2];
                    if (!IIX0o.Oxx0IOOO(constraintsState, ConstraintsState.ConstraintsMet.INSTANCE)) {
                        break;
                    }
                    i2++;
                }
                if (constraintsState == null) {
                    constraintsState = ConstraintsState.ConstraintsMet.INSTANCE;
                }
                this.label = 1;
                if (xo2.emit(constraintsState, this) == oOoXoXO2) {
                    return oOoXoXO2;
                }
            } else if (i == 1) {
                I0oOoX.x0XOIxOo(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return oXIO0o0XI.f19155oIX0oI;
        }

        @oOoXoXO
        public final Object invoke(@OOXIXo XO<? super ConstraintsState> xo2, @OOXIXo ConstraintsState[] constraintsStateArr, @oOoXoXO I0Io<? super oXIO0o0XI> i0Io) {
            AnonymousClass3 r0 = new AnonymousClass3(i0Io);
            r0.L$0 = xo2;
            r0.L$1 = constraintsStateArr;
            return r0.invokeSuspend(oXIO0o0XI.f19155oIX0oI);
        }
    }

    public WorkConstraintsTracker$track$$inlined$combine$1(X0o0xo[] x0o0xoArr) {
        this.$flowArray$inlined = x0o0xoArr;
    }

    @oOoXoXO
    public Object collect(@OOXIXo XO xo2, @OOXIXo I0Io i0Io) {
        final X0o0xo[] x0o0xoArr = this.$flowArray$inlined;
        Object oIX0oI2 = CombineKt.oIX0oI(xo2, x0o0xoArr, new oIX0oI<ConstraintsState[]>() {
            @oOoXoXO
            public final ConstraintsState[] invoke() {
                return new ConstraintsState[x0o0xoArr.length];
            }
        }, new AnonymousClass3((I0Io) null), i0Io);
        if (oIX0oI2 == II0xO0.oOoXoXO()) {
            return oIX0oI2;
        }
        return oXIO0o0XI.f19155oIX0oI;
    }
}
