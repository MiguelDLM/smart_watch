package com.huawei.openalliance.ad.feedback;

import android.view.View;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.utils.ad;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class c {
    private int I;
    private final List<View> V = new ArrayList();
    private int Z = 0;

    public int Code() {
        return this.I;
    }

    public void Code(int i) {
        this.Z = i;
    }

    public void Code(int i, int i2, int i3, int i4, int i5, int i6) {
        if (ad.Code(this.V)) {
            return;
        }
        if (i == -1) {
            int i7 = i3 + (i5 - this.Z) + i2 + i6;
            for (int size = this.V.size() - 1; size >= 0; size--) {
                this.V.get(size).layout(i7, i4, this.V.get(size).getMeasuredWidth() + i7, this.V.get(size).getMeasuredHeight() + i4);
                i7 += this.V.get(size).getMeasuredWidth() + i6;
            }
            return;
        }
        if (i == 0) {
            int size2 = ((((this.V.size() - 1) * i6) + i5) - this.Z) / (this.V.size() + 1);
            for (View view : this.V) {
                int i8 = i3 + size2;
                view.layout(i8, i4, view.getMeasuredWidth() + i8, view.getMeasuredHeight() + i4);
                i3 = i8 + view.getMeasuredWidth();
            }
            return;
        }
        if (i != 1) {
            fb.V("FlowLayoutLine", "lineMode error");
            return;
        }
        for (View view2 : this.V) {
            view2.layout(i3, i4, view2.getMeasuredWidth() + i3, view2.getMeasuredHeight() + i4);
            i3 += view2.getMeasuredWidth() + i6;
        }
    }

    public void Code(View view) {
        this.V.add(view);
        if (this.I < view.getMeasuredHeight()) {
            this.I = view.getMeasuredHeight();
        }
    }
}
