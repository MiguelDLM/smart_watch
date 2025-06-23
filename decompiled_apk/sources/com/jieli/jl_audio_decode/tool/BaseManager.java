package com.jieli.jl_audio_decode.tool;

import com.jieli.jl_audio_decode.callback.OnDecodeStreamCallback;
import com.jieli.jl_audio_decode.callback.OnStateCallback;

/* loaded from: classes10.dex */
public abstract class BaseManager {
    public abstract void decodeFile(String str, String str2, OnStateCallback onStateCallback);

    public abstract void encodeFile(String str, String str2, OnStateCallback onStateCallback);

    public abstract boolean isDecodeStream();

    public abstract boolean nativeAddAudioStream(int i, byte[] bArr);

    public abstract int nativeDecodeFile(String str, String str2);

    public abstract void nativeDecodeStream(int i);

    public abstract int nativeEncodeFile(String str, String str2);

    public abstract int nativeGetAudioStreamState();

    public abstract void startDecodeStream(OnDecodeStreamCallback onDecodeStreamCallback);

    public abstract void stopDecodeStream();

    public abstract void writeAudioStream(byte[] bArr);
}
