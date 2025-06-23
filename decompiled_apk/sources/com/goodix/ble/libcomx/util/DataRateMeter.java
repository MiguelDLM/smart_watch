package com.goodix.ble.libcomx.util;

import com.goodix.ble.libcomx.event.Event;
import com.goodix.ble.libcomx.event.IEventListener;

/* loaded from: classes9.dex */
public class DataRateMeter implements Runnable, IEventListener<byte[]> {
    public static final int EVT_UPDATED = 247;
    private static final String TAG = "DataRateMeter";
    private int speed;
    private int speedAvg;
    private long startTimestamp;
    private long stopTimestamp;
    private int tempByteCnt;
    private Thread timerThread;
    private long totalByteCnt;
    private long updatePeriod = 1000;
    private int maxIdleCnt = 3;
    private Event<Void> eventUpdated = new Event<>(this, 247);
    private boolean measuring = false;

    public Event<Void> evtUpdated() {
        return this.eventUpdated;
    }

    public long getElapsedTime() {
        long j;
        long j2;
        if (this.measuring) {
            j = System.currentTimeMillis();
            j2 = this.startTimestamp;
        } else {
            j = this.stopTimestamp;
            j2 = this.startTimestamp;
        }
        return j - j2;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getSpeedAvg() {
        return this.speedAvg;
    }

    public long getTotalByteCnt() {
        return this.totalByteCnt;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        long j;
        boolean z;
        Thread thread = this.timerThread;
        int i2 = this.maxIdleCnt;
        int i3 = 0;
        while (thread != null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                Thread.sleep(this.updatePeriod);
                long currentTimeMillis2 = System.currentTimeMillis();
                long j2 = currentTimeMillis2 - currentTimeMillis;
                if (!this.measuring) {
                    synchronized (this) {
                        this.timerThread = null;
                    }
                } else {
                    synchronized (this) {
                        i = this.tempByteCnt;
                        this.tempByteCnt = 0;
                        j = this.totalByteCnt;
                        z = this.measuring;
                    }
                    if (z) {
                        this.speedAvg = (int) ((j * 1000) / (currentTimeMillis2 - this.startTimestamp));
                        if (j2 > 0) {
                            this.speed = (int) ((i * 1000) / j2);
                        } else {
                            this.speed = 0;
                        }
                        this.eventUpdated.postEvent(null);
                    }
                    if (i2 <= 0) {
                        continue;
                    } else {
                        if (this.speed > 0) {
                            i3 = 0;
                        } else {
                            i3++;
                        }
                        if (i3 > i2) {
                            synchronized (this) {
                                this.timerThread = null;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                thread = null;
            } catch (InterruptedException unused) {
                synchronized (this) {
                    this.timerThread = null;
                    return;
                }
            }
        }
    }

    public void setMaxIdleCnt(int i) {
        this.maxIdleCnt = i;
    }

    public void setUpdatePeriod(long j) {
        if (j > 0) {
            this.updatePeriod = j;
        }
    }

    public synchronized void start() {
        this.totalByteCnt = 0L;
        this.tempByteCnt = 0;
        this.speed = 0;
        this.speedAvg = 0;
        long currentTimeMillis = System.currentTimeMillis();
        this.startTimestamp = currentTimeMillis;
        this.stopTimestamp = currentTimeMillis;
        this.measuring = true;
    }

    public synchronized void stop() {
        this.measuring = false;
        long currentTimeMillis = System.currentTimeMillis();
        this.stopTimestamp = currentTimeMillis;
        this.speedAvg = (int) ((this.totalByteCnt * 1000) / (currentTimeMillis - this.startTimestamp));
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, byte[] bArr) {
        if (bArr == null || !this.measuring) {
            return;
        }
        synchronized (this) {
            try {
                if (this.measuring) {
                    this.tempByteCnt += bArr.length;
                    this.totalByteCnt += bArr.length;
                    if (this.timerThread == null) {
                        Thread thread = new Thread(this, TAG);
                        this.timerThread = thread;
                        thread.start();
                    }
                }
            } finally {
            }
        }
    }
}
