package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

@IXIxx0.oxoX(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", i = {0}, l = {409, 411}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
/* loaded from: classes.dex */
public final class ViewKt$allViews$1 extends RestrictedSuspendLambda implements Oox.x0xO0oo<kotlin.sequences.oO<? super View>, kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI>, Object> {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, kotlin.coroutines.I0Io<? super ViewKt$allViews$1> i0Io) {
        super(2, i0Io);
        this.$this_allViews = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<kotlin.oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, i0Io);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        kotlin.sequences.oO oOVar;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    kotlin.I0oOoX.x0XOIxOo(obj);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            oOVar = (kotlin.sequences.oO) this.L$0;
            kotlin.I0oOoX.x0XOIxOo(obj);
        } else {
            kotlin.I0oOoX.x0XOIxOo(obj);
            oOVar = (kotlin.sequences.oO) this.L$0;
            View view = this.$this_allViews;
            this.L$0 = oOVar;
            this.label = 1;
            if (oOVar.II0xO0(view, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        View view2 = this.$this_allViews;
        if (view2 instanceof ViewGroup) {
            kotlin.sequences.ooOOo0oXI<View> descendants = ViewGroupKt.getDescendants((ViewGroup) view2);
            this.L$0 = null;
            this.label = 2;
            if (oOVar.XO(descendants, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo kotlin.sequences.oO<? super View> oOVar, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> i0Io) {
        return ((ViewKt$allViews$1) create(oOVar, i0Io)).invokeSuspend(kotlin.oXIO0o0XI.f29392oIX0oI);
    }
}
