package androidx.core.view;

import OXOo.OOXIXo;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.sequences.ooOOo0oXI;

public final class ViewGroupKt$children$1 implements ooOOo0oXI<View> {
    final /* synthetic */ ViewGroup $this_children;

    public ViewGroupKt$children$1(ViewGroup viewGroup) {
        this.$this_children = viewGroup;
    }

    @OOXIXo
    public Iterator<View> iterator() {
        return ViewGroupKt.iterator(this.$this_children);
    }
}
