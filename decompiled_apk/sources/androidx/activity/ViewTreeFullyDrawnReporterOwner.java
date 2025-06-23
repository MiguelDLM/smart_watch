package androidx.activity;

import android.view.View;
import androidx.core.viewtree.ViewTree;
import kotlin.jvm.internal.IIX0o;

@XO0OX.xxIXOIIO(name = "ViewTreeFullyDrawnReporterOwner")
/* loaded from: classes.dex */
public final class ViewTreeFullyDrawnReporterOwner {
    @XO0OX.xxIXOIIO(name = "get")
    @OXOo.oOoXoXO
    public static final FullyDrawnReporterOwner get(@OXOo.OOXIXo View view) {
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
            Object parentOrViewTreeDisjointParent = ViewTree.getParentOrViewTreeDisjointParent(view);
            if (parentOrViewTreeDisjointParent instanceof View) {
                view = (View) parentOrViewTreeDisjointParent;
            } else {
                view = null;
            }
        }
        return null;
    }

    @XO0OX.xxIXOIIO(name = "set")
    public static final void set(@OXOo.OOXIXo View view, @OXOo.OOXIXo FullyDrawnReporterOwner fullyDrawnReporterOwner) {
        IIX0o.x0xO0oo(view, "<this>");
        IIX0o.x0xO0oo(fullyDrawnReporterOwner, "fullyDrawnReporterOwner");
        view.setTag(R.id.report_drawn, fullyDrawnReporterOwner);
    }
}
