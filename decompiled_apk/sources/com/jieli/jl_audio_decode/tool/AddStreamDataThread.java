package com.jieli.jl_audio_decode.tool;

import com.jieli.jl_audio_decode.callback.OnStateCallback;
import com.jieli.jl_audio_decode.callback.OnThreadFinishListener;
import com.jieli.jl_audio_decode.constant.ErrorCode;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes10.dex */
public class AddStreamDataThread extends Thread {
    private final int dataType;
    private volatile boolean isRunning;
    private volatile boolean isWaiting;
    private final OnStateCallback mCallback;
    private final OnThreadFinishListener mListener;
    private final BaseManager mManager;
    private final LinkedBlockingQueue<byte[]> mQueue;

    public AddStreamDataThread(BaseManager baseManager, int i, OnStateCallback onStateCallback, OnThreadFinishListener onThreadFinishListener) {
        super("AddStreamDataThread");
        this.mQueue = new LinkedBlockingQueue<>();
        this.mManager = baseManager;
        this.dataType = i;
        this.mCallback = onStateCallback;
        this.mListener = onThreadFinishListener;
    }

    private void notifyThread() {
        if (this.isWaiting) {
            synchronized (this.mQueue) {
                this.mQueue.notify();
            }
        }
    }

    public void addStreamData(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        try {
            this.mQueue.put(bArr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyThread();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.mManager != null) {
            synchronized (this.mQueue) {
                while (this.isRunning) {
                    if (this.mQueue.isEmpty()) {
                        this.isWaiting = true;
                        try {
                            this.mQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        this.isWaiting = false;
                        byte[] poll = this.mQueue.poll();
                        if (poll != null) {
                            try {
                                this.mManager.nativeAddAudioStream(this.dataType, poll);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                OnStateCallback onStateCallback = this.mCallback;
                                if (onStateCallback != null) {
                                    onStateCallback.onError(ErrorCode.ERR_UNKNOWN_EXCEPTION, "Error occurred: " + e2.getMessage());
                                }
                                this.isRunning = false;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        OnStateCallback onStateCallback2 = this.mCallback;
        if (onStateCallback2 != null) {
            onStateCallback2.onError(-1, "Invalid parameter");
        }
        OnThreadFinishListener onThreadFinishListener = this.mListener;
        if (onThreadFinishListener != null) {
            onThreadFinishListener.onThreadFinish(getId());
        }
        this.isRunning = false;
        this.isWaiting = false;
        this.mQueue.clear();
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        this.isRunning = true;
        super.start();
    }

    public synchronized void stopThread() {
        this.isRunning = false;
        notifyThread();
    }
}
