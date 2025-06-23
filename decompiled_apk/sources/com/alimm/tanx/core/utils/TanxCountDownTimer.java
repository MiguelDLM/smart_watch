package com.alimm.tanx.core.utils;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: classes.dex */
public abstract class TanxCountDownTimer implements NotConfused {
    private static final int MSG = 1;
    private static final String TAG = "TanxCountDownTimer";
    public static final int TIMER_CANCELLED = 3;
    public static final int TIMER_FINISH = 4;
    public static final int TIMER_INIT = 0;
    public static final int TIMER_PAUSE = 2;
    public static final int TIMER_START = 1;
    private final long mCountdownInterval;
    private final long mMillisInFuture;
    private long mPauseLeftInFuture;
    private long mStopTimeInFuture;
    private volatile int nowType = 0;
    private final Handler mHandler = new Handler() { // from class: com.alimm.tanx.core.utils.TanxCountDownTimer.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long j;
            synchronized (TanxCountDownTimer.this) {
                try {
                    if (TanxCountDownTimer.this.nowType == 3) {
                        return;
                    }
                    if (TanxCountDownTimer.this.nowType == 2) {
                        return;
                    }
                    long elapsedRealtime = TanxCountDownTimer.this.mStopTimeInFuture - SystemClock.elapsedRealtime();
                    long j2 = 0;
                    if (elapsedRealtime <= 0) {
                        TanxCountDownTimer.this.setFinish();
                    } else {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        TanxCountDownTimer.this.onTick(elapsedRealtime);
                        long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                        if (elapsedRealtime < TanxCountDownTimer.this.mCountdownInterval) {
                            j = elapsedRealtime - elapsedRealtime3;
                            if (j < 0) {
                                sendMessageDelayed(obtainMessage(1), j2);
                            }
                        } else {
                            j = TanxCountDownTimer.this.mCountdownInterval - elapsedRealtime3;
                            while (j < 0) {
                                j += TanxCountDownTimer.this.mCountdownInterval;
                            }
                        }
                        j2 = j;
                        sendMessageDelayed(obtainMessage(1), j2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };

    public TanxCountDownTimer(long j, long j2) {
        this.mMillisInFuture = j;
        this.mCountdownInterval = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFinish() {
        this.nowType = 4;
        onFinish();
    }

    public final synchronized void cancel() {
        this.nowType = 3;
        this.mHandler.removeMessages(1);
        LogUtils.d("myTimer cancel:", this.mPauseLeftInFuture + "");
    }

    public void finishReStart() {
        this.nowType = 0;
        start();
    }

    public int getNowType() {
        return this.nowType;
    }

    public boolean isCancelled() {
        if (this.nowType == 3) {
            return true;
        }
        return false;
    }

    public boolean isPaused() {
        if (this.nowType == 2) {
            return true;
        }
        return false;
    }

    public boolean isStart() {
        if (this.nowType == 1) {
            return true;
        }
        return false;
    }

    public abstract void onFinish();

    public abstract void onTick(long j);

    public final synchronized void pause() {
        if (this.nowType == 1) {
            this.nowType = 2;
            this.mPauseLeftInFuture = this.mStopTimeInFuture - SystemClock.elapsedRealtime();
            this.mHandler.removeMessages(1);
            LogUtils.d(TAG, "myTimer pause:" + this.mPauseLeftInFuture);
        }
    }

    public final synchronized TanxCountDownTimer resume() {
        if (this.nowType == 2) {
            this.nowType = 1;
            if (this.mPauseLeftInFuture <= 0) {
                setFinish();
                return this;
            }
            this.mStopTimeInFuture = SystemClock.elapsedRealtime() + this.mPauseLeftInFuture;
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(1));
            LogUtils.d("myTimer resume:", this.mStopTimeInFuture + "");
        }
        return this;
    }

    public final synchronized TanxCountDownTimer start() {
        if (this.nowType == 0) {
            this.nowType = 1;
            if (this.mMillisInFuture <= 0) {
                setFinish();
                return this;
            }
            this.mStopTimeInFuture = SystemClock.elapsedRealtime() + this.mMillisInFuture;
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(1));
            LogUtils.d("myTimer start:", this.mStopTimeInFuture + "");
        }
        return this;
    }

    public final synchronized TanxCountDownTimer updateTime(long j) {
        this.mPauseLeftInFuture = j;
        this.mStopTimeInFuture = SystemClock.elapsedRealtime() + j;
        return this;
    }
}
