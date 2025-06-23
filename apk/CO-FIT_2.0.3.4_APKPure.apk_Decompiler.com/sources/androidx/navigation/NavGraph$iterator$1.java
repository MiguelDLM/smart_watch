package androidx.navigation;

import OI0IXox.oxoX;
import androidx.collection.SparseArrayCompat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nNavGraph.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavGraph.kt\nandroidx/navigation/NavGraph$iterator$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,677:1\n1#2:678\n*E\n"})
public final class NavGraph$iterator$1 implements Iterator<NavDestination>, oxoX {
    private int index = -1;
    final /* synthetic */ NavGraph this$0;
    private boolean wentToNext;

    public NavGraph$iterator$1(NavGraph navGraph) {
        this.this$0 = navGraph;
    }

    public boolean hasNext() {
        if (this.index + 1 < this.this$0.getNodes().size()) {
            return true;
        }
        return false;
    }

    public void remove() {
        if (this.wentToNext) {
            SparseArrayCompat<NavDestination> nodes = this.this$0.getNodes();
            nodes.valueAt(this.index).setParent((NavGraph) null);
            nodes.removeAt(this.index);
            this.index--;
            this.wentToNext = false;
            return;
        }
        throw new IllegalStateException("You must call next() before you can remove an element");
    }

    public NavDestination next() {
        if (hasNext()) {
            this.wentToNext = true;
            SparseArrayCompat<NavDestination> nodes = this.this$0.getNodes();
            int i = this.index + 1;
            this.index = i;
            return nodes.valueAt(i);
        }
        throw new NoSuchElementException();
    }
}
