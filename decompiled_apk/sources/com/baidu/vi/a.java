package com.baidu.vi;

import android.os.Handler;
import android.os.Message;
import com.baidu.vi.AudioRecorder;

/* loaded from: classes8.dex */
final class a extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        AudioRecorder audioRecorder = ((AudioRecorder.a) message.obj).f10212a;
        int i = message.what;
        if (i == 1) {
            z = audioRecorder.h;
            if (z) {
                Object obj = message.obj;
                audioRecorder.onReadData(((AudioRecorder.a) obj).b, ((AudioRecorder.a) obj).c);
                return;
            }
            return;
        }
        if (i == 2) {
            z2 = audioRecorder.h;
            if (z2) {
                audioRecorder.onReadError();
            }
        }
    }
}
