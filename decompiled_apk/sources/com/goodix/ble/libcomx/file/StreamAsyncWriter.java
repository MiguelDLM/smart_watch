package com.goodix.ble.libcomx.file;

import com.goodix.ble.libcomx.event.Event;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes9.dex */
public abstract class StreamAsyncWriter implements IStreamWriter {
    public static final int EVT_ERROR = 206;
    private static final int STATE_IDLE = 0;
    private static final int STATE_RUNNING = 2;
    private static final int STATE_STARTING = 1;
    private static final int STATE_STOPPING = 3;
    private final String threadName = getClass().getName() + "-WriterThread";
    private Thread currentThread = null;
    private int threadState = 0;
    private ArrayBlockingQueue<byte[]> dataList = new ArrayBlockingQueue<>(1024);
    private int intervalMillis = 10;
    private int ttlMillis = 1000;
    private boolean flushEveryWrite = false;
    private boolean disposeFlag = false;
    Event<Throwable> errorEvent = new Event<>(this, 206);

    @Override // com.goodix.ble.libcomx.file.IStreamWriter
    public void close() {
        this.disposeFlag = true;
        Thread thread = this.currentThread;
        if (thread != null && thread.isAlive()) {
            thread.interrupt();
        }
    }

    public void doWrite() {
        OutputStream outputStream;
        try {
            outputStream = onPrepareOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
            this.errorEvent.postEvent(e);
            outputStream = null;
        }
        synchronized (this) {
            try {
                if (outputStream == null) {
                    this.threadState = 0;
                    return;
                }
                this.threadState = 2;
                this.currentThread = Thread.currentThread();
                int i = 0;
                while (!this.disposeFlag) {
                    try {
                        if (onWriteAll(outputStream, this.flushEveryWrite)) {
                            i = 0;
                        }
                        if (i <= this.ttlMillis) {
                            Thread.sleep(this.intervalMillis);
                            i += this.intervalMillis;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        this.errorEvent.postEvent(e2);
                        this.dataList.clear();
                    }
                }
                synchronized (this) {
                    this.threadState = 3;
                }
                try {
                    onCloseOutputStream(outputStream);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    this.errorEvent.postEvent(e3);
                }
                try {
                    outputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                    this.errorEvent.postEvent(e4);
                }
                if (!this.dataList.isEmpty()) {
                    write(null);
                }
            } finally {
            }
        }
    }

    public Event<Throwable> evtError() {
        return this.errorEvent;
    }

    public abstract void onCloseOutputStream(OutputStream outputStream) throws Exception;

    public abstract OutputStream onPrepareOutputStream() throws Exception;

    public boolean onWriteAll(OutputStream outputStream, boolean z) throws IOException {
        boolean z2 = false;
        if (outputStream != null) {
            ArrayBlockingQueue<byte[]> arrayBlockingQueue = this.dataList;
            while (true) {
                byte[] poll = arrayBlockingQueue.poll();
                if (poll == null) {
                    break;
                }
                outputStream.write(poll);
                z2 = true;
            }
            if (z) {
                outputStream.flush();
            }
        }
        return z2;
    }

    public void setImmediatelyFlush(boolean z) {
        this.flushEveryWrite = z;
    }

    public void setTTL(int i) {
        this.ttlMillis = i;
    }

    @Override // com.goodix.ble.libcomx.file.IStreamWriter
    public boolean write(byte[] bArr) {
        synchronized (this) {
            try {
                if (this.disposeFlag) {
                    return false;
                }
                int i = this.threadState;
                if (i == 3 || i == 0) {
                    this.threadState = 1;
                    new Thread(new Runnable() { // from class: com.goodix.ble.libcomx.file.II0xO0
                        @Override // java.lang.Runnable
                        public final void run() {
                            StreamAsyncWriter.this.doWrite();
                        }
                    }, this.threadName).start();
                }
                if (bArr != null && bArr.length != 0) {
                    try {
                        this.dataList.offer(bArr, this.ttlMillis | (this.intervalMillis << 1), TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        this.errorEvent.postEvent(e);
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
