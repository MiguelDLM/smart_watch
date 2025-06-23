package com.kwad.components.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.utils.aq;

/* loaded from: classes11.dex */
public final class f {
    final RecyclerView QC;
    final RecyclerView.LayoutManager QD;

    private f(RecyclerView recyclerView) {
        this.QC = recyclerView;
        this.QD = recyclerView.getLayoutManager();
    }

    private View a(int i, int i2, boolean z, boolean z2) {
        OrientationHelper createHorizontalHelper;
        int i3;
        if (this.QD.canScrollVertically()) {
            createHorizontalHelper = OrientationHelper.createVerticalHelper(this.QD);
        } else {
            createHorizontalHelper = OrientationHelper.createHorizontalHelper(this.QD);
        }
        int startAfterPadding = createHorizontalHelper.getStartAfterPadding();
        int endAfterPadding = createHorizontalHelper.getEndAfterPadding();
        if (i2 > i) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        while (i != i2) {
            View childAt = this.QD.getChildAt(i);
            int decoratedStart = createHorizontalHelper.getDecoratedStart(childAt);
            int decoratedEnd = createHorizontalHelper.getDecoratedEnd(childAt);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                return childAt;
            }
            i += i3;
        }
        return null;
    }

    public static f b(RecyclerView recyclerView) {
        aq.checkNotNull(recyclerView);
        return new f(recyclerView);
    }

    public final int findFirstVisibleItemPosition() {
        View a2 = a(0, this.QD.getChildCount(), false, true);
        if (a2 == null) {
            return -1;
        }
        return this.QC.getChildAdapterPosition(a2);
    }

    public final int findLastVisibleItemPosition() {
        View a2 = a(this.QD.getChildCount() - 1, -1, false, true);
        if (a2 == null) {
            return -1;
        }
        return this.QC.getChildAdapterPosition(a2);
    }
}
