package com.jieli.jl_audio_decode.opus;

import android.util.Log;
import com.jieli.jl_audio_decode.callback.OnDecodeStreamCallback;
import com.jieli.jl_audio_decode.callback.OnEncodeStreamCallback;
import com.jieli.jl_audio_decode.callback.OnStateCallback;
import com.jieli.jl_audio_decode.callback.OnThreadFinishListener;
import com.jieli.jl_audio_decode.constant.DecodeConstant;
import com.jieli.jl_audio_decode.exceptions.OpusException;
import com.jieli.jl_audio_decode.tool.AddStreamDataThread;
import com.jieli.jl_audio_decode.tool.BaseManager;
import com.jieli.jl_audio_decode.tool.DecodeFileThread;
import com.jieli.jl_audio_decode.tool.EncodeFileThread;

/* loaded from: classes10.dex */
public class OpusManager extends BaseManager {
    private static final String TAG = "OpusManager";
    private AddStreamDataThread mAddStreamDataThread;
    private DecodeFileThread mDecodeFileThread;
    private volatile OnStateCallback mDecodeStateCb;
    private volatile OnDecodeStreamCallback mDecodeStreamCb;
    private EncodeFileThread mEncodeFileThread;
    private volatile OnStateCallback mEncodeStateCb;
    private volatile OnEncodeStreamCallback mEncodeStreamCb;
    private AddStreamDataThread mEncodeStreamDataThread;
    private volatile long managerAddr = initNativeID();

    static {
        try {
            System.loadLibrary(DecodeConstant.JL_OPUS_LIB);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public OpusManager() throws OpusException {
        if (this.managerAddr != 0) {
        } else {
            throw new OpusException("Can not load jl_opus lib");
        }
    }

    private void addEncodeStreamData(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            if (this.mEncodeStreamDataThread == null) {
                AddStreamDataThread addStreamDataThread = new AddStreamDataThread(this, 0, this.mEncodeStreamCb, new OnThreadFinishListener() { // from class: com.jieli.jl_audio_decode.opus.OpusManager.4
                    @Override // com.jieli.jl_audio_decode.callback.OnThreadFinishListener
                    public void onThreadFinish(long j) {
                        if (OpusManager.this.mEncodeStreamDataThread != null && OpusManager.this.mEncodeStreamDataThread.getId() == j) {
                            OpusManager.this.mEncodeStreamDataThread = null;
                            OpusManager.this.setEncodeStreamCb(null);
                        }
                    }
                });
                this.mEncodeStreamDataThread = addStreamDataThread;
                addStreamDataThread.start();
            }
            this.mEncodeStreamDataThread.addStreamData(bArr);
        }
    }

    private void addStreamData(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            if (this.mAddStreamDataThread == null) {
                AddStreamDataThread addStreamDataThread = new AddStreamDataThread(this, 2, this.mDecodeStreamCb, new OnThreadFinishListener() { // from class: com.jieli.jl_audio_decode.opus.OpusManager.3
                    @Override // com.jieli.jl_audio_decode.callback.OnThreadFinishListener
                    public void onThreadFinish(long j) {
                        if (OpusManager.this.mAddStreamDataThread != null && OpusManager.this.mAddStreamDataThread.getId() == j) {
                            OpusManager.this.mAddStreamDataThread = null;
                            OpusManager.this.setDecodeStreamCb(null);
                        }
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

    private native int encodeOpusFile(String str, String str2, long j);

    private native void encodeOpusStream(int i, long j);

    private native int getAudioStreamState(long j);

    private native int getEncodeStreamState(long j);

    private native long initNativeID();

    private native int nativeDestroy(long j);

    private native boolean saveAudioStream(byte[] bArr, long j);

    private native boolean savePcmStream(byte[] bArr, long j);

    /* JADX INFO: Access modifiers changed from: private */
    public void setDecodeStateCb(OnStateCallback onStateCallback) {
        this.mDecodeStateCb = onStateCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDecodeStreamCb(OnDecodeStreamCallback onDecodeStreamCallback) {
        this.mDecodeStreamCb = onDecodeStreamCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEncodeStateCb(OnStateCallback onStateCallback) {
        this.mEncodeStateCb = onStateCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEncodeStreamCb(OnEncodeStreamCallback onEncodeStreamCallback) {
        this.mEncodeStreamCb = onEncodeStreamCallback;
    }

    private void startDecodeFileThread(String str, String str2) {
        if (this.mDecodeFileThread == null) {
            DecodeFileThread decodeFileThread = new DecodeFileThread(this, str, str2, this.mDecodeStateCb, new OnThreadFinishListener() { // from class: com.jieli.jl_audio_decode.opus.OpusManager.1
                @Override // com.jieli.jl_audio_decode.callback.OnThreadFinishListener
                public void onThreadFinish(long j) {
                    if (OpusManager.this.mDecodeFileThread != null && OpusManager.this.mDecodeFileThread.getId() == j) {
                        OpusManager.this.mDecodeFileThread = null;
                        OpusManager.this.setDecodeStateCb(null);
                    }
                }
            });
            this.mDecodeFileThread = decodeFileThread;
            decodeFileThread.start();
        }
    }

    private void startEncodeFileThread(String str, String str2) {
        if (this.mEncodeFileThread == null) {
            EncodeFileThread encodeFileThread = new EncodeFileThread(this, str, str2, this.mEncodeStateCb, new OnThreadFinishListener() { // from class: com.jieli.jl_audio_decode.opus.OpusManager.2
                @Override // com.jieli.jl_audio_decode.callback.OnThreadFinishListener
                public void onThreadFinish(long j) {
                    if (OpusManager.this.mEncodeFileThread != null && OpusManager.this.mEncodeFileThread.getId() == j) {
                        OpusManager.this.mEncodeFileThread = null;
                        OpusManager.this.setEncodeStateCb(null);
                    }
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
        }
    }

    private void stopAddEncodeDataThread() {
        AddStreamDataThread addStreamDataThread = this.mEncodeStreamDataThread;
        if (addStreamDataThread != null) {
            addStreamDataThread.stopThread();
        }
    }

    private void stopDecodeFileThread() {
        DecodeFileThread decodeFileThread = this.mDecodeFileThread;
        if (decodeFileThread != null) {
            decodeFileThread.interrupt();
        }
    }

    private void stopEncodeFileThread() {
        EncodeFileThread encodeFileThread = this.mEncodeFileThread;
        if (encodeFileThread != null) {
            encodeFileThread.interrupt();
        }
    }

    @Override // com.jieli.jl_audio_decode.tool.BaseManager
    public void decodeFile(String str, String str2, OnStateCallback onStateCallback) {
        if (this.mDecodeFileThread == null) {
            setDecodeStateCb(onStateCallback);
            startDecodeFileThread(str, str2);
        } else if (onStateCallback != null) {
            onStateCallback.onError(-4, "In process, please wait.");
        }
    }

    @Override // com.jieli.jl_audio_decode.tool.BaseManager
    public void encodeFile(String str, String str2, OnStateCallback onStateCallback) {
        if (this.mEncodeFileThread == null) {
            setEncodeStateCb(onStateCallback);
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

    public boolean isEncodeStream() {
        if (getEncodeStreamState(this.managerAddr) == 1) {
            return true;
        }
        return false;
    }

    @Override // com.jieli.jl_audio_decode.tool.BaseManager
    public boolean nativeAddAudioStream(int i, byte[] bArr) {
        if (i == 0) {
            return savePcmStream(bArr, this.managerAddr);
        }
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
        return encodeOpusFile(str, str2, this.managerAddr);
    }

    @Override // com.jieli.jl_audio_decode.tool.BaseManager
    public int nativeGetAudioStreamState() {
        return getAudioStreamState(this.managerAddr);
    }

    public void onDecodeStreamReceive(int i, byte[] bArr) {
        if (this.mDecodeStreamCb != null) {
            this.mDecodeStreamCb.onDecodeStream(bArr);
        }
    }

    public void onEncodeStreamReceive(int i, byte[] bArr) {
        if (this.mEncodeStreamCb == null) {
            return;
        }
        this.mEncodeStreamCb.onEncodeStream(bArr);
    }

    public void onStateCallback(int i, int i2, int i3, String str) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4 || this.mEncodeStreamCb == null) {
                        return;
                    }
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 == 2) {
                                this.mEncodeStreamCb.onError(i3, str);
                                return;
                            }
                            return;
                        }
                        this.mEncodeStreamCb.onStart();
                        return;
                    }
                    this.mEncodeStreamCb.onComplete(str);
                    return;
                }
                Log.e("zzc", "mDecodeStreamCb = " + this.mDecodeStreamCb);
                if (this.mDecodeStreamCb == null) {
                    return;
                }
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            this.mDecodeStreamCb.onError(i3, str);
                            return;
                        }
                        return;
                    }
                    this.mDecodeStreamCb.onStart();
                    return;
                }
                this.mDecodeStreamCb.onComplete(str);
                return;
            }
            if (this.mEncodeStateCb == null) {
                return;
            }
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        this.mEncodeStateCb.onError(i3, str);
                        return;
                    }
                    return;
                }
                this.mEncodeStateCb.onStart();
                return;
            }
            this.mEncodeStateCb.onComplete(str);
            return;
        }
        if (this.mDecodeStateCb == null) {
            return;
        }
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    this.mDecodeStateCb.onError(i3, str);
                    return;
                }
                return;
            }
            this.mDecodeStateCb.onStart();
            return;
        }
        this.mDecodeStateCb.onComplete(str);
    }

    public void release() {
        if (isDecodeStream()) {
            stopDecodeStream();
        }
        if (isEncodeStream()) {
            stopEncodeStream();
        }
        stopDecodeFileThread();
        stopEncodeFileThread();
        stopAddDataThread();
        stopAddEncodeDataThread();
        this.mDecodeStateCb = null;
        this.mEncodeStateCb = null;
        this.mDecodeStreamCb = null;
        this.mEncodeStreamCb = null;
        if (nativeDestroy(this.managerAddr) == 0) {
            this.managerAddr = 0L;
        }
    }

    @Override // com.jieli.jl_audio_decode.tool.BaseManager
    public void startDecodeStream(OnDecodeStreamCallback onDecodeStreamCallback) {
        if (!isDecodeStream()) {
            setDecodeStreamCb(onDecodeStreamCallback);
            nativeDecodeStream(1);
        } else if (onDecodeStreamCallback != null) {
            onDecodeStreamCallback.onError(-4, "Decoding Stream is working, please don't open again.");
        }
    }

    public void startEncodeStream(OnEncodeStreamCallback onEncodeStreamCallback) {
        if (!isEncodeStream()) {
            setEncodeStreamCb(onEncodeStreamCallback);
            encodeOpusStream(1, this.managerAddr);
        } else if (onEncodeStreamCallback != null) {
            onEncodeStreamCallback.onError(-4, "Decoding Stream is working, please don't open again.");
        }
    }

    @Override // com.jieli.jl_audio_decode.tool.BaseManager
    public void stopDecodeStream() {
        if (isDecodeStream()) {
            nativeDecodeStream(0);
        }
    }

    public void stopEncodeStream() {
        if (isEncodeStream()) {
            encodeOpusStream(0, this.managerAddr);
        }
    }

    @Override // com.jieli.jl_audio_decode.tool.BaseManager
    public void writeAudioStream(byte[] bArr) {
        if (isDecodeStream()) {
            addStreamData(bArr);
        }
    }

    public void writeEncodeStream(byte[] bArr) {
        if (isEncodeStream()) {
            addEncodeStreamData(bArr);
        }
    }
}
