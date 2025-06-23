package org.apache.log4j.lf5.viewer;

import java.awt.Adjustable;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/* loaded from: classes6.dex */
public class oxxXoxO implements AdjustmentListener {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f33433oIX0oI = -1;

    public void oIX0oI(AdjustmentEvent adjustmentEvent) {
        Adjustable adjustable = adjustmentEvent.getAdjustable();
        int maximum = adjustable.getMaximum();
        if (adjustable.getMaximum() == this.f33433oIX0oI) {
            return;
        }
        if (adjustable.getValue() + adjustable.getVisibleAmount() + adjustable.getUnitIncrement() >= this.f33433oIX0oI) {
            adjustable.setValue(adjustable.getMaximum());
        }
        this.f33433oIX0oI = maximum;
    }
}
