package com.alimm.tanx.core.utils;

import android.os.Handler;
import android.os.SystemClock;

public abstract class TanxCountDownTimer implements NotConfused {
    private static final int MSG = 1;
    private static final String TAG = "TanxCountDownTimer";
    public static final int TIMER_CANCELLED = 3;
    public static final int TIMER_FINISH = 4;
    public static final int TIMER_INIT = 0;
    public static final int TIMER_PAUSE = 2;
    public static final int TIMER_START = 1;
    /* access modifiers changed from: private */
    public final long mCountdownInterval;
    private final Handler mHandler = new Handler() {
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x006e, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r10) {
            /*
                r9 = this;
                com.alimm.tanx.core.utils.TanxCountDownTimer r10 = com.alimm.tanx.core.utils.TanxCountDownTimer.this
                monitor-enter(r10)
                com.alimm.tanx.core.utils.TanxCountDownTimer r0 = com.alimm.tanx.core.utils.TanxCountDownTimer.this     // Catch:{ all -> 0x000e }
                int r0 = r0.nowType     // Catch:{ all -> 0x000e }
                r1 = 3
                if (r0 != r1) goto L_0x0010
                monitor-exit(r10)     // Catch:{ all -> 0x000e }
                return
            L_0x000e:
                r0 = move-exception
                goto L_0x006f
            L_0x0010:
                com.alimm.tanx.core.utils.TanxCountDownTimer r0 = com.alimm.tanx.core.utils.TanxCountDownTimer.this     // Catch:{ all -> 0x000e }
                int r0 = r0.nowType     // Catch:{ all -> 0x000e }
                r1 = 2
                if (r0 != r1) goto L_0x001b
                monitor-exit(r10)     // Catch:{ all -> 0x000e }
                return
            L_0x001b:
                com.alimm.tanx.core.utils.TanxCountDownTimer r0 = com.alimm.tanx.core.utils.TanxCountDownTimer.this     // Catch:{ all -> 0x000e }
                long r0 = r0.mStopTimeInFuture     // Catch:{ all -> 0x000e }
                long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x000e }
                long r0 = r0 - r2
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 > 0) goto L_0x0032
                com.alimm.tanx.core.utils.TanxCountDownTimer r0 = com.alimm.tanx.core.utils.TanxCountDownTimer.this     // Catch:{ all -> 0x000e }
                r0.setFinish()     // Catch:{ all -> 0x000e }
                goto L_0x006d
            L_0x0032:
                long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x000e }
                com.alimm.tanx.core.utils.TanxCountDownTimer r6 = com.alimm.tanx.core.utils.TanxCountDownTimer.this     // Catch:{ all -> 0x000e }
                r6.onTick(r0)     // Catch:{ all -> 0x000e }
                long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x000e }
                long r6 = r6 - r4
                com.alimm.tanx.core.utils.TanxCountDownTimer r4 = com.alimm.tanx.core.utils.TanxCountDownTimer.this     // Catch:{ all -> 0x000e }
                long r4 = r4.mCountdownInterval     // Catch:{ all -> 0x000e }
                int r8 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r8 >= 0) goto L_0x0052
                long r0 = r0 - r6
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 >= 0) goto L_0x0050
                goto L_0x0065
            L_0x0050:
                r2 = r0
                goto L_0x0065
            L_0x0052:
                com.alimm.tanx.core.utils.TanxCountDownTimer r0 = com.alimm.tanx.core.utils.TanxCountDownTimer.this     // Catch:{ all -> 0x000e }
                long r0 = r0.mCountdownInterval     // Catch:{ all -> 0x000e }
                long r0 = r0 - r6
            L_0x0059:
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 >= 0) goto L_0x0050
                com.alimm.tanx.core.utils.TanxCountDownTimer r4 = com.alimm.tanx.core.utils.TanxCountDownTimer.this     // Catch:{ all -> 0x000e }
                long r4 = r4.mCountdownInterval     // Catch:{ all -> 0x000e }
                long r0 = r0 + r4
                goto L_0x0059
            L_0x0065:
                r0 = 1
                android.os.Message r0 = r9.obtainMessage(r0)     // Catch:{ all -> 0x000e }
                r9.sendMessageDelayed(r0, r2)     // Catch:{ all -> 0x000e }
            L_0x006d:
                monitor-exit(r10)     // Catch:{ all -> 0x000e }
                return
            L_0x006f:
                monitor-exit(r10)     // Catch:{ all -> 0x000e }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.utils.TanxCountDownTimer.AnonymousClass1.handleMessage(android.os.Message):void");
        }
    };
    private final long mMillisInFuture;
    private long mPauseLeftInFuture;
    /* access modifiers changed from: private */
    public long mStopTimeInFuture;
    /* access modifiers changed from: private */
    public volatile int nowType = 0;

    public TanxCountDownTimer(long j, long j2) {
        this.mMillisInFuture = j;
        this.mCountdownInterval = j2;
    }

    /* access modifiers changed from: private */
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

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.alimm.tanx.core.utils.TanxCountDownTimer resume() {
        /*
            r6 = this;
            monitor-enter(r6)
            int r0 = r6.nowType     // Catch:{ all -> 0x0016 }
            r1 = 2
            if (r0 != r1) goto L_0x0042
            r0 = 1
            r6.nowType = r0     // Catch:{ all -> 0x0016 }
            long r1 = r6.mPauseLeftInFuture     // Catch:{ all -> 0x0016 }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0018
            r6.setFinish()     // Catch:{ all -> 0x0016 }
            monitor-exit(r6)
            return r6
        L_0x0016:
            r0 = move-exception
            goto L_0x0044
        L_0x0018:
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0016 }
            long r3 = r6.mPauseLeftInFuture     // Catch:{ all -> 0x0016 }
            long r1 = r1 + r3
            r6.mStopTimeInFuture = r1     // Catch:{ all -> 0x0016 }
            android.os.Handler r1 = r6.mHandler     // Catch:{ all -> 0x0016 }
            android.os.Message r0 = r1.obtainMessage(r0)     // Catch:{ all -> 0x0016 }
            r1.sendMessage(r0)     // Catch:{ all -> 0x0016 }
            java.lang.String r0 = "myTimer resume:"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0016 }
            r1.<init>()     // Catch:{ all -> 0x0016 }
            long r2 = r6.mStopTimeInFuture     // Catch:{ all -> 0x0016 }
            r1.append(r2)     // Catch:{ all -> 0x0016 }
            java.lang.String r2 = ""
            r1.append(r2)     // Catch:{ all -> 0x0016 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0016 }
            com.alimm.tanx.core.utils.LogUtils.d((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0016 }
        L_0x0042:
            monitor-exit(r6)
            return r6
        L_0x0044:
            monitor-exit(r6)     // Catch:{ all -> 0x0016 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.utils.TanxCountDownTimer.resume():com.alimm.tanx.core.utils.TanxCountDownTimer");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.alimm.tanx.core.utils.TanxCountDownTimer start() {
        /*
            r6 = this;
            monitor-enter(r6)
            int r0 = r6.nowType     // Catch:{ all -> 0x0015 }
            if (r0 != 0) goto L_0x0041
            r0 = 1
            r6.nowType = r0     // Catch:{ all -> 0x0015 }
            long r1 = r6.mMillisInFuture     // Catch:{ all -> 0x0015 }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0017
            r6.setFinish()     // Catch:{ all -> 0x0015 }
            monitor-exit(r6)
            return r6
        L_0x0015:
            r0 = move-exception
            goto L_0x0043
        L_0x0017:
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0015 }
            long r3 = r6.mMillisInFuture     // Catch:{ all -> 0x0015 }
            long r1 = r1 + r3
            r6.mStopTimeInFuture = r1     // Catch:{ all -> 0x0015 }
            android.os.Handler r1 = r6.mHandler     // Catch:{ all -> 0x0015 }
            android.os.Message r0 = r1.obtainMessage(r0)     // Catch:{ all -> 0x0015 }
            r1.sendMessage(r0)     // Catch:{ all -> 0x0015 }
            java.lang.String r0 = "myTimer start:"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0015 }
            r1.<init>()     // Catch:{ all -> 0x0015 }
            long r2 = r6.mStopTimeInFuture     // Catch:{ all -> 0x0015 }
            r1.append(r2)     // Catch:{ all -> 0x0015 }
            java.lang.String r2 = ""
            r1.append(r2)     // Catch:{ all -> 0x0015 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0015 }
            com.alimm.tanx.core.utils.LogUtils.d((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0015 }
        L_0x0041:
            monitor-exit(r6)
            return r6
        L_0x0043:
            monitor-exit(r6)     // Catch:{ all -> 0x0015 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.utils.TanxCountDownTimer.start():com.alimm.tanx.core.utils.TanxCountDownTimer");
    }

    public final synchronized TanxCountDownTimer updateTime(long j) {
        this.mPauseLeftInFuture = j;
        this.mStopTimeInFuture = SystemClock.elapsedRealtime() + j;
        return this;
    }
}
