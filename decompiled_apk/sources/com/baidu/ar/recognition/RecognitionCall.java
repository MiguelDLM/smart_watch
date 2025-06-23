package com.baidu.ar.recognition;

import android.util.Log;

/* loaded from: classes7.dex */
public class RecognitionCall {
    static RecognitionAssembleCallback callback;

    public static void setCallback(RecognitionAssembleCallback recognitionAssembleCallback) {
        callback = recognitionAssembleCallback;
    }

    public static int setProtobufBufStrs(byte[] bArr) {
        RecognitionAssembleCallback recognitionAssembleCallback = callback;
        if (recognitionAssembleCallback == null) {
            return 1;
        }
        recognitionAssembleCallback.onAssembleResult(bArr);
        return 1;
    }

    public static void transParseResult(int i, String str, String str2, String str3) {
        Log.e("art", "arkey = " + str2 + "arType = " + str3);
        RecognitionAssembleCallback recognitionAssembleCallback = callback;
        if (recognitionAssembleCallback != null) {
            recognitionAssembleCallback.onProtobufParseResult(i, str, str2, str3);
        }
    }
}
