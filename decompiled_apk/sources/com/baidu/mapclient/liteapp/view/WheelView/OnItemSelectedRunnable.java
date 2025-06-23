package com.baidu.mapclient.liteapp.view.WheelView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class OnItemSelectedRunnable implements Runnable {
    private WheelView loopView;

    public OnItemSelectedRunnable(WheelView wheelView) {
        this.loopView = wheelView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WheelView wheelView = this.loopView;
        wheelView.onItemSelectedListener.onItemSelected(wheelView.getSelectedItem());
    }
}
