package androidx.core.view;

import IXIxx0.oxoX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import android.view.View;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.oXIO0o0XI;
import kotlin.sequences.oO;

@oxoX(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", i = {0}, l = {409, 411}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
public final class ViewKt$allViews$1 extends RestrictedSuspendLambda implements x0xO0oo<oO<? super View>, I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, I0Io<? super ViewKt$allViews$1> i0Io) {
        super(2, i0Io);
        this.$this_allViews = view;
    }

    @OOXIXo
    public final I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo I0Io<?> i0Io) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, i0Io);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlin.sequences.oO} */
    /* JADX WARNING: Multi-variable type inference failed */
    @OXOo.oOoXoXO
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@OXOo.OOXIXo java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.I0oOoX.x0XOIxOo(r5)
            goto L_0x004f
        L_0x0012:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001a:
            java.lang.Object r1 = r4.L$0
            kotlin.sequences.oO r1 = (kotlin.sequences.oO) r1
            kotlin.I0oOoX.x0XOIxOo(r5)
            goto L_0x0037
        L_0x0022:
            kotlin.I0oOoX.x0XOIxOo(r5)
            java.lang.Object r5 = r4.L$0
            r1 = r5
            kotlin.sequences.oO r1 = (kotlin.sequences.oO) r1
            android.view.View r5 = r4.$this_allViews
            r4.L$0 = r1
            r4.label = r3
            java.lang.Object r5 = r1.II0xO0(r5, r4)
            if (r5 != r0) goto L_0x0037
            return r0
        L_0x0037:
            android.view.View r5 = r4.$this_allViews
            boolean r3 = r5 instanceof android.view.ViewGroup
            if (r3 == 0) goto L_0x004f
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            kotlin.sequences.ooOOo0oXI r5 = androidx.core.view.ViewGroupKt.getDescendants(r5)
            r3 = 0
            r4.L$0 = r3
            r4.label = r2
            java.lang.Object r5 = r1.XO(r5, r4)
            if (r5 != r0) goto L_0x004f
            return r0
        L_0x004f:
            kotlin.oXIO0o0XI r5 = kotlin.oXIO0o0XI.f19155oIX0oI
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.ViewKt$allViews$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @oOoXoXO
    public final Object invoke(@OOXIXo oO<? super View> oOVar, @oOoXoXO I0Io<? super oXIO0o0XI> i0Io) {
        return ((ViewKt$allViews$1) create(oOVar, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
    }
}
