package com.baidu.ar;

import android.content.Context;
import com.baidu.ar.record.EncoderParams;
import com.baidu.ar.record.MovieRecorderCallback;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public interface ho {
    void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j);

    void onVideoFrameAvailable(long j);

    void startRecorder(Context context, EncoderParams encoderParams, MovieRecorderCallback movieRecorderCallback);

    void stopRecorder();
}
