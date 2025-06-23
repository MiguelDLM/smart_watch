package androidx.lifecycle;

import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.Xo0;
import kotlinx.coroutines.x0;
import kotlinx.coroutines.xII;

/* loaded from: classes.dex */
public final class ViewModelKt {

    @OXOo.OOXIXo
    private static final String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";

    @OXOo.OOXIXo
    public static final xII getViewModelScope(@OXOo.OOXIXo ViewModel viewModel) {
        IIX0o.x0xO0oo(viewModel, "<this>");
        xII xii = (xII) viewModel.getTag(JOB_KEY);
        if (xii != null) {
            return xii;
        }
        Object tagIfAbsent = viewModel.setTagIfAbsent(JOB_KEY, new CloseableCoroutineScope(x0.I0Io(null, 1, null).plus(Xo0.X0o0xo().o00())));
        IIX0o.oO(tagIfAbsent, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (xII) tagIfAbsent;
    }
}
