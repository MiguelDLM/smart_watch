package com.baidu.mapclient.liteapp.view.WheelView;

import java.util.TimerTask;

/* loaded from: classes7.dex */
final class InertiaTimerTask extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    private float f6071a = 2.1474836E9f;
    private WheelView loopView;
    private float velocityY;

    public InertiaTimerTask(WheelView wheelView, float f) {
        this.loopView = wheelView;
        this.velocityY = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f6071a == 2.1474836E9f) {
            if (Math.abs(this.velocityY) > 2000.0f) {
                if (this.velocityY > 0.0f) {
                    this.f6071a = 2000.0f;
                } else {
                    this.f6071a = -2000.0f;
                }
            } else {
                this.f6071a = this.velocityY;
            }
        }
        if (Math.abs(this.f6071a) >= 0.0f && Math.abs(this.f6071a) <= 20.0f) {
            this.loopView.cancelFuture();
            this.loopView.handler.sendEmptyMessage(2000);
            return;
        }
        int i = (int) ((this.f6071a * 10.0f) / 1000.0f);
        WheelView wheelView = this.loopView;
        int i2 = wheelView.totalScrollY - i;
        wheelView.totalScrollY = i2;
        if (!wheelView.isLoop) {
            float f = wheelView.lineSpacingMultiplier * wheelView.maxTextHeight;
            int i3 = wheelView.initPosition;
            if (i2 <= ((int) ((-i3) * f))) {
                this.f6071a = 40.0f;
                wheelView.totalScrollY = (int) ((-i3) * f);
            } else {
                int size = wheelView.items.size() - 1;
                WheelView wheelView2 = this.loopView;
                if (i2 >= ((int) ((size - wheelView2.initPosition) * f))) {
                    wheelView2.totalScrollY = (int) (((wheelView2.items.size() - 1) - this.loopView.initPosition) * f);
                    this.f6071a = -40.0f;
                }
            }
        }
        float f2 = this.f6071a;
        if (f2 < 0.0f) {
            this.f6071a = f2 + 20.0f;
        } else {
            this.f6071a = f2 - 20.0f;
        }
        this.loopView.handler.sendEmptyMessage(1000);
    }
}
