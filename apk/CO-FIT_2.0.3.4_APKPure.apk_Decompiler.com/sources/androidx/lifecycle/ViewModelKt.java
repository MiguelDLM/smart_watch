package androidx.lifecycle;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.Xo0;
import kotlinx.coroutines.oXIO0o0XI;
import kotlinx.coroutines.x0;
import kotlinx.coroutines.xII;

public final class ViewModelKt {
    @OOXIXo
    private static final String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";

    @OOXIXo
    public static final xII getViewModelScope(@OOXIXo ViewModel viewModel) {
        IIX0o.x0xO0oo(viewModel, "<this>");
        xII xii = (xII) viewModel.getTag(JOB_KEY);
        if (xii != null) {
            return xii;
        }
        Object tagIfAbsent = viewModel.setTagIfAbsent(JOB_KEY, new CloseableCoroutineScope(x0.I0Io((oXIO0o0XI) null, 1, (Object) null).plus(Xo0.X0o0xo().IIXOooo())));
        IIX0o.oO(tagIfAbsent, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (xII) tagIfAbsent;
    }
}
