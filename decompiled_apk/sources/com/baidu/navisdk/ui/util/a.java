package com.baidu.navisdk.ui.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public abstract class a {
    private static final int MSG = 1;
    private static final String TAG = "BNCountDownTimer";
    private boolean isFinished;
    private boolean isStarted;
    private boolean isTick;
    private boolean mCancelled;
    private final long mCountdownInterval;
    private Handler mHandler;
    private final long mMillisInFuture;
    private long mMillisLeft;
    private boolean mPaused;
    private long mStopTimeInFuture;

    /* renamed from: com.baidu.navisdk.ui.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC0490a extends Handler {
        public HandlerC0490a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long j;
            synchronized (a.this) {
                try {
                    if (!a.this.isTicking()) {
                        return;
                    }
                    long elapsedRealtime = a.this.mStopTimeInFuture - SystemClock.elapsedRealtime();
                    long j2 = 0;
                    if (elapsedRealtime <= 0) {
                        a.this.isFinished = true;
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e(a.TAG, "start --> is already finished!!! mMillisLeft = " + a.this.mMillisLeft);
                        }
                        a.this.onFinish();
                    } else {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        if (a.this.isTick) {
                            a.this.onTick(elapsedRealtime);
                        } else if (LogUtil.LOGGABLE) {
                            a.this.onTick(elapsedRealtime);
                        }
                        long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                        if (elapsedRealtime < a.this.mCountdownInterval) {
                            j = elapsedRealtime - elapsedRealtime3;
                            if (j < 0) {
                                a aVar = a.this;
                                aVar.mMillisLeft = aVar.mStopTimeInFuture - SystemClock.elapsedRealtime();
                                sendMessageDelayed(obtainMessage(1), j2);
                            }
                        } else {
                            j = a.this.mCountdownInterval - elapsedRealtime3;
                            while (j < 0) {
                                j += a.this.mCountdownInterval;
                            }
                        }
                        j2 = j;
                        a aVar2 = a.this;
                        aVar2.mMillisLeft = aVar2.mStopTimeInFuture - SystemClock.elapsedRealtime();
                        sendMessageDelayed(obtainMessage(1), j2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public a(long j) {
        this.mCancelled = false;
        this.mPaused = false;
        this.isStarted = false;
        this.isFinished = false;
        this.mHandler = new HandlerC0490a(Looper.getMainLooper());
        this.mMillisInFuture = j;
        this.mCountdownInterval = 1000L;
        this.mMillisLeft = j;
        this.isTick = false;
    }

    public final synchronized void cancel() {
        try {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "cancel!!!");
            }
            this.mCancelled = true;
            this.mPaused = false;
            this.isFinished = false;
            this.isStarted = false;
            this.mHandler.removeMessages(1);
            this.mMillisLeft = this.mMillisInFuture;
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean isTicking() {
        if (this.isStarted && !this.isFinished && !this.mCancelled && !this.mPaused) {
            return true;
        }
        return false;
    }

    public abstract void onFinish();

    public void onPause() {
    }

    public void onTick(long j) {
    }

    public final synchronized a pause() {
        try {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "onPause!!!");
            }
            if (!isTicking()) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(TAG, "onPause --> is not ticking!!!");
                }
                return this;
            }
            this.mPaused = true;
            this.isStarted = false;
            this.mHandler.removeMessages(1);
            this.mMillisLeft = this.mStopTimeInFuture - SystemClock.elapsedRealtime();
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "onPause --> mMillisLeft = " + this.mMillisLeft);
            }
            onPause();
            return this;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized a start() {
        try {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "start --> mMillisInFuture = " + this.mMillisInFuture + ", mCountdownInterval = " + this.mCountdownInterval + ", mMillisLeft = " + this.mMillisLeft);
            }
            if (isTicking()) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(TAG, "start --> is already start!!!");
                }
                return this;
            }
            this.mCancelled = false;
            this.mPaused = false;
            this.isStarted = true;
            this.isFinished = false;
            if (this.mMillisLeft <= 0) {
                this.isStarted = false;
                this.isFinished = true;
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(TAG, "start --> is already finished!!! mMillisLeft = " + this.mMillisLeft);
                }
                onFinish();
                return this;
            }
            this.mStopTimeInFuture = SystemClock.elapsedRealtime() + this.mMillisLeft;
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "start --> mMillisLeft = " + this.mMillisLeft + ", mStopTimeInFuture = " + this.mStopTimeInFuture);
            }
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(1));
            return this;
        } catch (Throwable th) {
            throw th;
        }
    }

    public a(long j, long j2) {
        this.mCancelled = false;
        this.mPaused = false;
        this.isStarted = false;
        this.isFinished = false;
        this.mHandler = new HandlerC0490a(Looper.getMainLooper());
        this.mMillisInFuture = j;
        this.mCountdownInterval = j2;
        this.mMillisLeft = j;
        this.isTick = true;
    }
}
