package com.baidu.navisdk.comapi.mapcontrol;

import com.baidu.navisdk.util.statistic.userop.b;

/* loaded from: classes7.dex */
public class BNMapOperationStatistic {
    private int mLastMapGestureEvent = -1;
    private int mLastMapGestureCount = 0;

    private void addMapOPInner(int i, int i2, int i3) {
        this.mLastMapGestureEvent = -1;
        this.mLastMapGestureCount = 0;
        if (2 == i && i2 != -1) {
            switch (i2) {
                case 513:
                    b.r().a("1.c", "" + i3, null, null);
                    return;
                case 514:
                    b.r().a("1.d", "" + i3, null, null);
                    return;
                case 515:
                default:
                    return;
                case 516:
                    b.r().a("1.f", "" + i3, null, null);
                    return;
                case 517:
                    b.r().a("1.g", "" + i3, null, null);
                    return;
                case 518:
                case 519:
                    b.r().a("1.7", "" + i3, null, null);
                    return;
                case 520:
                    b.r().a("1.8", "" + i3, null, null);
                    return;
                case 521:
                    b.r().a("1.b", "" + i3, null, null);
                    return;
            }
        }
    }

    private boolean careAboutMapEvent(int i, int i2) {
        if (i != 2) {
            return false;
        }
        switch (i2) {
            case 513:
            case 514:
            case 516:
            case 517:
            case 518:
            case 519:
            case 520:
            case 521:
                return true;
            case 515:
            default:
                return false;
        }
    }

    public void addMapOP(int i, int i2) {
        if (!careAboutMapEvent(i, i2)) {
            return;
        }
        int i3 = this.mLastMapGestureEvent;
        if (520 == i3 && 513 == i2) {
            return;
        }
        if (519 == i2) {
            i2 = 518;
        }
        if (520 == i3 && 518 == i2) {
            return;
        }
        if ((521 != i3 || 518 != i2) && 2 == i) {
            if (i2 == i3) {
                this.mLastMapGestureCount++;
                return;
            }
            addMapOPInner(i, i3, this.mLastMapGestureCount);
            this.mLastMapGestureEvent = i2;
            this.mLastMapGestureCount = 1;
        }
    }
}
