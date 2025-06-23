package com.baidu.ai.speech.realtime.android;

import android.media.AudioRecord;
import android.util.Log;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class MyMicrophoneInputStream extends InputStream {
    private static final String TAG = "MyMicrophoneInputStream";
    private static AudioRecord audioRecord;
    private static MyMicrophoneInputStream is;
    private volatile boolean isClosed;
    private volatile boolean isStarted = false;

    private MyMicrophoneInputStream() {
    }

    public static MyMicrophoneInputStream getInstance() {
        if (is == null) {
            synchronized (MyMicrophoneInputStream.class) {
                try {
                    if (is == null) {
                        is = new MyMicrophoneInputStream();
                    }
                } finally {
                }
            }
        }
        is.isClosed = false;
        return is;
    }

    private void start() {
        Log.i(TAG, " MyMicrophoneInputStream start recoding!");
        if (audioRecord == null) {
            audioRecord = new AudioRecord(1, 16000, 16, 2, AudioRecord.getMinBufferSize(16000, 16, 2) * 16);
        }
        AudioRecord audioRecord2 = audioRecord;
        boolean z = true;
        if (audioRecord2 != null && audioRecord2.getState() == 1) {
            audioRecord.startRecording();
            this.isStarted = true;
            Log.i(TAG, " MyMicrophoneInputStream start recoding finished");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("startRecording() called on an uninitialized AudioRecord.");
            if (audioRecord != null) {
                z = false;
            }
            sb.append(z);
            throw new IllegalStateException(sb.toString());
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Log.i(TAG, " MyMicrophoneInputStream close");
        AudioRecord audioRecord2 = audioRecord;
        if (audioRecord2 != null) {
            audioRecord2.stop();
            audioRecord.release();
            this.isStarted = false;
            this.isClosed = true;
            audioRecord = null;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) {
        if (!this.isStarted && !this.isClosed) {
            start();
            this.isStarted = true;
        }
        try {
            return audioRecord.read(b, off, len);
        } catch (Exception e) {
            Log.e(TAG, e.getClass().getSimpleName(), e);
            throw e;
        }
    }
}
