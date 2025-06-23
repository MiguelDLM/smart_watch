package androidx.activity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import android.view.View;
import android.view.ViewParent;
import androidx.core.viewtree.ViewTree;
import kotlin.jvm.internal.IIX0o;

@xxIXOIIO(name = "ViewTreeFullyDrawnReporterOwner")
public final class ViewTreeFullyDrawnReporterOwner {
    @oOoXoXO
    @xxIXOIIO(name = "get")
    public static final FullyDrawnReporterOwner get(@OOXIXo View view) {
        FullyDrawnReporterOwner fullyDrawnReporterOwner;
        IIX0o.x0xO0oo(view, "<this>");
        while (view != null) {
            Object tag = view.getTag(R.id.report_drawn);
            if (tag instanceof FullyDrawnReporterOwner) {
                fullyDrawnReporterOwner = (FullyDrawnReporterOwner) tag;
            } else {
                fullyDrawnReporterOwner = null;
            }
            if (fullyDrawnReporterOwner != null) {
                return fullyDrawnReporterOwner;
            }
            ViewParent parentOrViewTreeDisjointParent = ViewTree.getParentOrViewTreeDisjointParent(view);
            if (parentOrViewTreeDisjointParent instanceof View) {
                view = (View) parentOrViewTreeDisjointParent;
            } else {
                view = null;
            }
        }
        return null;
    }

    @xxIXOIIO(name = "set")
    public static final void set(@OOXIXo View view, @OOXIXo FullyDrawnReporterOwner fullyDrawnReporterOwner) {
        IIX0o.x0xO0oo(view, "<this>");
        IIX0o.x0xO0oo(fullyDrawnReporterOwner, "fullyDrawnReporterOwner");
        view.setTag(R.id.report_drawn, fullyDrawnReporterOwner);
    }
}
