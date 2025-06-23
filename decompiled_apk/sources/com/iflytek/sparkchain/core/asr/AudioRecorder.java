package com.iflytek.sparkchain.core.asr;

import android.media.AudioRecord;
import android.os.Process;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes10.dex */
public class AudioRecorder {
    private static AudioRecorder mInstance;
    private final String TAG;
    private int audioFormat;
    private int bufferSize;
    private AudioDataCallback callback;
    private int channels;
    private AtomicBoolean isStart;
    private AudioRecord mRecorder;
    private String path;
    Runnable recordRunnable;
    private Thread recordThread;
    private int sampleRateInHz;

    /* loaded from: classes10.dex */
    public interface AudioDataCallback {
        void onAudioData(byte[] bArr, int i);
    }

    public AudioRecorder() {
        this(16000, 2, 16);
    }

    public static AudioRecorder getInstance() {
        if (mInstance == null) {
            synchronized (AudioRecorder.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new AudioRecorder();
                    }
                } finally {
                }
            }
        }
        return mInstance;
    }

    private void startThread() {
        destroyThread();
        this.isStart.set(true);
        StringBuilder sb = new StringBuilder();
        sb.append("recordThread：");
        sb.append(this.recordThread == null);
        Log.i("AudioRecorder", sb.toString());
        if (this.recordThread == null) {
            Thread thread = new Thread(this.recordRunnable);
            this.recordThread = thread;
            thread.start();
        }
    }

    public void destroyThread() {
        synchronized (this) {
            try {
                try {
                    try {
                        this.isStart.set(false);
                        Thread thread = this.recordThread;
                        if (thread != null) {
                            try {
                                if (thread.isAlive()) {
                                    try {
                                        this.recordThread.interrupt();
                                        this.recordThread.join();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    this.recordThread = null;
                                }
                            } finally {
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
            }
        }
    }

    public void registerCallBack(AudioDataCallback audioDataCallback) {
        this.callback = audioDataCallback;
    }

    public void startRecord() {
        try {
            startThread();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopRecord() {
        destroyThread();
        synchronized (this) {
            try {
                try {
                    try {
                        if (this.callback != null) {
                            this.callback = null;
                        }
                        AudioRecord audioRecord = this.mRecorder;
                        if (audioRecord != null) {
                            if (audioRecord.getState() == 1) {
                                this.mRecorder.stop();
                            }
                            AudioRecord audioRecord2 = this.mRecorder;
                            if (audioRecord2 != null) {
                                audioRecord2.release();
                            }
                            this.mRecorder = null;
                        }
                        if (mInstance != null) {
                            mInstance = null;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    mInstance = null;
                } catch (Throwable th) {
                    mInstance = null;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void writeDataToFile(String str, byte[] bArr, boolean z) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileChannel channel = new FileOutputStream(str, z).getChannel();
            channel.write(ByteBuffer.wrap(bArr));
            channel.force(true);
            channel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            Log.e("AudioRecorder", "writeFile:" + e2.toString());
        }
    }

    public AudioRecorder(int i, int i2, int i3) {
        this.TAG = "AudioRecorder";
        this.sampleRateInHz = 16000;
        this.audioFormat = 2;
        this.channels = 16;
        this.isStart = new AtomicBoolean();
        this.path = "/sdcard/iflytek/audio.wav";
        this.recordRunnable = new Runnable() { // from class: com.iflytek.sparkchain.core.asr.AudioRecorder.1
            @Override // java.lang.Runnable
            public void run() {
                int read;
                try {
                    try {
                        if (AudioRecorder.this.mRecorder != null) {
                            Process.setThreadPriority(-19);
                            byte[] bArr = new byte[AudioRecorder.this.bufferSize];
                            if (AudioRecorder.this.mRecorder.getState() != 1) {
                                AudioRecorder.this.stopRecord();
                                if (AudioRecorder.this.mRecorder != null) {
                                    AudioRecorder.this.mRecorder.stop();
                                    AudioRecorder.this.mRecorder.release();
                                    AudioRecorder.this.mRecorder = null;
                                    return;
                                }
                                return;
                            }
                            AudioRecorder.this.mRecorder.startRecording();
                            while (AudioRecorder.this.isStart.get()) {
                                synchronized (this) {
                                    try {
                                        if (AudioRecorder.this.mRecorder != null && (read = AudioRecorder.this.mRecorder.read(bArr, 0, AudioRecorder.this.bufferSize)) != -3 && read != -2) {
                                            if (read != 0 && read != -1 && AudioRecorder.this.isStart.get()) {
                                                AudioRecorder.this.callback.onAudioData(bArr, read);
                                            }
                                        }
                                    } finally {
                                    }
                                }
                            }
                        }
                        if (AudioRecorder.this.mRecorder == null) {
                            return;
                        }
                    } catch (Exception e) {
                        Log.w("AudioRecorder", "录音异常:" + e.toString());
                        e.printStackTrace();
                        if (AudioRecorder.this.mRecorder == null) {
                            return;
                        }
                    }
                    AudioRecorder.this.mRecorder.stop();
                    AudioRecorder.this.mRecorder.release();
                    AudioRecorder.this.mRecorder = null;
                } catch (Throwable th) {
                    if (AudioRecorder.this.mRecorder != null) {
                        AudioRecorder.this.mRecorder.stop();
                        AudioRecorder.this.mRecorder.release();
                        AudioRecorder.this.mRecorder = null;
                    }
                    throw th;
                }
            }
        };
        this.sampleRateInHz = i;
        this.audioFormat = i2;
        this.channels = i3;
        this.bufferSize = AudioRecord.getMinBufferSize(i, i3, i2);
        this.mRecorder = new AudioRecord(1, i, i3, i2, this.bufferSize);
    }
}
