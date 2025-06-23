package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/* loaded from: classes11.dex */
public final class bq {
    private View aSi;
    public Point aSh = new Point();
    public Rect aSf = new Rect();
    public Rect aSg = new Rect();

    public bq(View view) {
        this.aSi = view;
    }

    public final boolean Od() {
        boolean globalVisibleRect = this.aSi.getGlobalVisibleRect(this.aSf, this.aSh);
        Point point = this.aSh;
        if (point.x == 0 && point.y == 0 && this.aSf.height() == this.aSi.getHeight() && this.aSg.height() != 0 && Math.abs(this.aSf.top - this.aSg.top) > this.aSi.getHeight() / 2) {
            this.aSf.set(this.aSg);
        }
        this.aSg.set(this.aSf);
        return globalVisibleRect;
    }
}
