package com.goodix.ble.libcomx.task.util;

import com.goodix.ble.libcomx.task.Task;

/* loaded from: classes9.dex */
public class DelayTask extends Task {
    private int delay;
    private float timeElapsing;
    private float updateInterval = 0.0f;

    public DelayTask(int i) {
        this.delay = i;
    }

    @Override // com.goodix.ble.libcomx.task.Task, com.goodix.ble.libcomx.task.ITask
    public void abort() {
        stopTimer();
        super.abort();
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        if (this.delay < 1) {
            this.delay = 1;
        }
        if (this.delay > 864000000) {
            finishedWithError("Delay is too long: " + this.delay);
        }
        startTimer(1, this.delay);
        this.timeElapsing = 0.0f;
        int i = this.delay;
        float f = i / 100.0f;
        this.updateInterval = f;
        if (f < 1000.0f) {
            this.updateInterval = 1000.0f;
        }
        float f2 = i;
        float f3 = this.updateInterval;
        if (f2 > f3) {
            startTimer(2, f3, f3);
        }
        return this.delay + 1000;
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onTimeout(int i) {
        if (i == 1) {
            finishedWithDone();
        } else if (i == 2) {
            float f = this.timeElapsing + this.updateInterval;
            this.timeElapsing = f;
            publishProgress((int) ((f * 100.0f) / this.delay));
        }
    }

    public DelayTask setDelay(int i) {
        this.delay = i;
        return this;
    }
}
