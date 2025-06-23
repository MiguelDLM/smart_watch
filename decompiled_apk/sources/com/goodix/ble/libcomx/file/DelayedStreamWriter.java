package com.goodix.ble.libcomx.file;

import com.goodix.ble.libcomx.event.Event;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ArrayBlockingQueue;

/* loaded from: classes9.dex */
public class DelayedStreamWriter implements IStreamWriter {
    public static final int EVT_ERROR = 206;
    protected OutputStream outputStream;
    Thread writerThread = new Thread(new Runnable() { // from class: com.goodix.ble.libcomx.file.oIX0oI
        @Override // java.lang.Runnable
        public final void run() {
            DelayedStreamWriter.this.doWrite();
        }
    });
    ArrayBlockingQueue<byte[]> dataList = new ArrayBlockingQueue<>(1024);
    int intervalMillis = 100;
    boolean flushEveryWrite = false;
    boolean startedFlag = false;
    boolean closeFlag = false;
    Event<Throwable> errorEvent = new Event<>(this, 206);

    public DelayedStreamWriter() {
    }

    @Override // com.goodix.ble.libcomx.file.IStreamWriter
    public void close() {
        this.closeFlag = true;
        this.writerThread.interrupt();
    }

    public void doWrite() {
        OutputStream outputStream;
        try {
            onStartThread();
        } catch (Exception e) {
            e.printStackTrace();
            this.errorEvent.postEvent(e);
        }
        while (true) {
            try {
            } catch (IOException e2) {
                e2.printStackTrace();
                this.errorEvent.postEvent(e2);
            } catch (InterruptedException unused) {
            }
            if (this.closeFlag) {
                this.outputStream.close();
                try {
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    this.errorEvent.postEvent(e3);
                    return;
                }
            }
            onWrite(this.flushEveryWrite);
            Thread.sleep(this.intervalMillis);
        }
        onStopThread();
        if (this.closeFlag && (outputStream = this.outputStream) != null) {
            outputStream.close();
        }
    }

    public Event<Throwable> evtError() {
        return this.errorEvent;
    }

    public void onStartThread() throws Exception {
    }

    public void onStopThread() throws Exception {
    }

    public void onWrite(boolean z) throws InterruptedException, IOException {
        byte[] take = this.dataList.take();
        OutputStream outputStream = this.outputStream;
        if (outputStream == null) {
            return;
        }
        do {
            outputStream.write(take);
            take = this.dataList.poll();
        } while (take != null);
        if (z) {
            outputStream.flush();
        }
    }

    public void setImmediatelyFlush(boolean z) {
        this.flushEveryWrite = z;
    }

    @Override // com.goodix.ble.libcomx.file.IStreamWriter
    public boolean write(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (!this.startedFlag) {
            synchronized (this) {
                try {
                    if (!this.startedFlag) {
                        this.startedFlag = true;
                        this.writerThread.start();
                    }
                } finally {
                }
            }
        }
        if (bArr.length == 0) {
            return true;
        }
        try {
            this.dataList.put(bArr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public DelayedStreamWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
