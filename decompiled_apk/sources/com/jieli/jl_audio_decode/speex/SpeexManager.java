package com.jieli.jl_audio_decode.speex;

import com.jieli.jl_audio_decode.callback.OnDecodeStreamCallback;
import com.jieli.jl_audio_decode.callback.OnStateCallback;
import com.jieli.jl_audio_decode.callback.OnThreadFinishListener;
import com.jieli.jl_audio_decode.constant.DecodeConstant;
import com.jieli.jl_audio_decode.exceptions.SpeexException;
import com.jieli.jl_audio_decode.tool.AddStreamDataThread;
import com.jieli.jl_audio_decode.tool.BaseManager;
import com.jieli.jl_audio_decode.tool.DecodeFileThread;
import com.jieli.jl_audio_decode.tool.EncodeFileThread;
import java.lang.ref.SoftReference;

/* loaded from: classes10.dex */
public class SpeexManager extends BaseManager {
    private static final String TAG = "SpeexManager";
    private AddStreamDataThread mAddStreamDataThread;
    private volatile SoftReference<OnStateCallback> mDecodeFileCallback;
    private DecodeFileThread mDecodeFileThread;
    private volatile SoftReference<OnDecodeStreamCallback> mDecodeStreamCallback;
    private volatile SoftReference<OnStateCallback> mEncodeFileCallback;
    private EncodeFileThread mEncodeFileThread;
    private volatile long managerAddr = initNativeID();

    static {
        try {
            System.loadLibrary(DecodeConstant.JL_SPEEX_LIB);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SpeexManager() throws SpeexException {
        if (this.managerAddr > 0) {
        } else {
            throw new SpeexException("Can not load jl_speex lib");
        }
    }

    private void addStreamData(byte[] bArr) {
        OnDecodeStreamCallback onDecodeStreamCallback;
        if (bArr != null) {
            if (this.mAddStreamDataThread == null) {
                if (this.mDecodeStreamCallback == null) {
                    onDecodeStreamCallback = null;
                } else {
                    onDecodeStreamCallback = this.mDecodeStreamCallback.get();
                }
                AddStreamDataThread addStreamDataThread = new AddStreamDataThread(this, 1, onDecodeStreamCallback, new OnThreadFinishListener() { // from class: com.jieli.jl_audio_decode.speex.SpeexManager.3
                    @Override // com.jieli.jl_audio_decode.callback.OnThreadFinishListener
                    public void onThreadFinish(long j) {
                        SpeexManager.this.mAddStreamDataThread = null;
                    }
                });
                this.mAddStreamDataThread = addStreamDataThread;
                addStreamDataThread.start();
            }
            this.mAddStreamDataThread.addStreamData(bArr);
        }
    }

    private native int decodeAudioFile(String str, String str2, long j);

    private native void decodeAudioStream(int i, long j);

    private native int encodeAudioFile(String str, String str2, long j);

    private native int getAudioStreamState(long j);

    private native long initNativeID();

    private native int nativeDestroy(long j);

    private native boolean saveAudioStream(byte[] bArr, long j);

    private void startDecodeFileThread(String str, String str2) {
        OnStateCallback onStateCallback;
        if (this.mDecodeFileThread == null) {
            if (this.mDecodeFileCallback == null) {
                onStateCallback = null;
            } else {
                onStateCallback = this.mDecodeFileCallback.get();
            }
            DecodeFileThread decodeFileThread = new DecodeFileThread(this, str, str2, onStateCallback, new OnThreadFinishListener() { // from class: com.jieli.jl_audio_decode.speex.SpeexManager.1
                @Override // com.jieli.jl_audio_decode.callback.OnThreadFinishListener
                public void onThreadFinish(long j) {
                    SpeexManager.this.mDecodeFileCallback = null;
                }
            });
            this.mDecodeFileThread = decodeFileThread;
            decodeFileThread.start();
        }
    }

    private void startEncodeFileThread(String str, String str2) {
        OnStateCallback onStateCallback;
        if (this.mEncodeFileThread == null) {
            if (this.mEncodeFileCallback == null) {
                onStateCallback = null;
            } else {
                onStateCallback = this.mEncodeFileCallback.get();
            }
            EncodeFileThread encodeFileThread = new EncodeFileThread(this, str, str2, onStateCallback, new OnThreadFinishListener() { // from class: com.jieli.jl_audio_decode.speex.SpeexManager.2
                @Override // com.jieli.jl_audio_decode.callback.OnThreadFinishListener
                public void onThreadFinish(long j) {
                    SpeexManager.this.mEncodeFileThread = null;
                }
            });
            this.mEncodeFileThread = encodeFileThread;
            encodeFileThread.start();
        }
    }

    private void stopAddDataThread() {
        AddStreamDataThread addStreamDataThread = this.mAddStreamDataThread;
        if (addStreamDataThread != null) {
            addStreamDataThread.stopThread();
            this.mAddStreamDataThread = null;
        }
    }

    private void stopDecodeFileThread() {
        DecodeFileThread decodeFileThread = this.mDecodeFileThread;
        if (decodeFileThread != null) {
            decodeFileThread.interrupt();
            this.mDecodeFileThread = null;
        }
    }

    private void stopEncodeFileThread() {
        EncodeFileThread encodeFileThread = this.mEncodeFileThread;
        if (encodeFileThread != null) {
            encodeFileThread.interrupt();
            this.mEncodeFileThread = null;
        }
    }

    @Override // com.jieli.jl_audio_decode.tool.BaseManager
    public void decodeFile(String str, String str2, OnStateCallback onStateCallback) {
        if (this.mDecodeFileThread == null) {
            this.mDecodeFileCallback = new SoftReference<>(onStateCallback);
            startDecodeFileThread(str, str2);
        } else if (onStateCallback != null) {
            onStateCallback.onError(-4, "In process, please wait.");
        }
    }

    @Override // com.jieli.jl_audio_decode.tool.BaseManager
    public void encodeFile(String str, String str2, OnStateCallback onStateCallback) {
        if (this.mEncodeFileThread == null) {
            this.mEncodeFileCallback = new SoftReference<>(onStateCallback);
            startEncodeFileThread(str, str2);
        } else if (onStateCallback != null) {
            onStateCallback.onError(-4, "In process, please wait.");
        }
    }

    @Override // com.jieli.jl_audio_decode.tool.BaseManager
    public boolean isDecodeStream() {
        if (getAudioStreamState(this.managerAddr) == 1) {
            return true;
        }
        return false;
    }

    @Override // com.jieli.jl_audio_decode.tool.BaseManager
    public boolean nativeAddAudioStream(int i, byte[] bArr) {
        return saveAudioStream(bArr, this.managerAddr);
    }

    @Override // com.jieli.jl_audio_decode.tool.BaseManager
    public int nativeDecodeFile(String str, String str2) {
        return decodeAudioFile(str, str2, this.managerAddr);
    }

    @Override // com.jieli.jl_audio_decode.tool.BaseManager
    public void nativeDecodeStream(int i) {
        decodeAudioStream(i, this.managerAddr);
    }

    @Override // com.jieli.jl_audio_decode.tool.BaseManager
    public int nativeEncodeFile(String str, String str2) {
        return encodeAudioFile(str, str2, this.managerAddr);
    }

    @Override // com.jieli.jl_audio_decode.tool.BaseManager
    public int nativeGetAudioStreamState() {
        return getAudioStreamState(this.managerAddr);
    }

    public void onDecodeStreamReceive(int i, byte[] bArr) {
        if (this.mDecodeStreamCallback != null && this.mDecodeStreamCallback.get() != null) {
            this.mDecodeStreamCallback.get().onDecodeStream(bArr);
        }
    }

    public void onStateCallback(int i, int i2, int i3, String str) {
        if (i != 1) {
            if (i != 2) {
                if (i == 3 && this.mDecodeStreamCallback != null && this.mDecodeStreamCallback.get() != null) {
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 == 2) {
                                this.mDecodeStreamCallback.get().onError(i3, str);
                                return;
                            }
                            return;
                        }
                        this.mDecodeStreamCallback.get().onStart();
                        return;
                    }
                    this.mDecodeStreamCallback.get().onComplete(str);
                    return;
                }
                return;
            }
            if (this.mEncodeFileCallback != null && this.mEncodeFileCallback.get() != null) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            this.mEncodeFileCallback.get().onError(i3, str);
                            return;
                        }
                        return;
                    }
                    this.mEncodeFileCallback.get().onStart();
                    return;
                }
                this.mEncodeFileCallback.get().onComplete(str);
                return;
            }
            return;
        }
        if (this.mDecodeFileCallback != null && this.mDecodeFileCallback.get() != null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        this.mDecodeFileCallback.get().onError(i3, str);
                        return;
                    }
                    return;
                }
                this.mDecodeFileCallback.get().onStart();
                return;
            }
            this.mDecodeFileCallback.get().onComplete(str);
        }
    }

    public void release() {
        if (isDecodeStream()) {
            stopDecodeStream();
        }
        stopEncodeFileThread();
        stopDecodeFileThread();
        stopAddDataThread();
        if (this.mDecodeFileCallback != null) {
            this.mDecodeFileCallback.clear();
            this.mDecodeFileCallback = null;
        }
        if (this.mEncodeFileCallback != null) {
            this.mDecodeFileCallback.clear();
            this.mEncodeFileCallback = null;
        }
        if (this.mDecodeStreamCallback != null) {
            this.mDecodeStreamCallback.clear();
            this.mDecodeStreamCallback = null;
        }
        if (nativeDestroy(this.managerAddr) == 0) {
            this.managerAddr = 0L;
        }
    }

    @Override // com.jieli.jl_audio_decode.tool.BaseManager
    public void startDecodeStream(OnDecodeStreamCallback onDecodeStreamCallback) {
        if (!isDecodeStream()) {
            this.mDecodeStreamCallback = new SoftReference<>(onDecodeStreamCallback);
            nativeDecodeStream(1);
        } else if (onDecodeStreamCallback != null) {
            onDecodeStreamCallback.onError(-4, "Decoding Stream is working, please don't open again.");
        }
    }

    @Override // com.jieli.jl_audio_decode.tool.BaseManager
    public void stopDecodeStream() {
        if (isDecodeStream()) {
            nativeDecodeStream(0);
        }
    }

    @Override // com.jieli.jl_audio_decode.tool.BaseManager
    public void writeAudioStream(byte[] bArr) {
        if (isDecodeStream()) {
            addStreamData(bArr);
        }
    }
}
