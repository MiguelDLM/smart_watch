package com.iflytek.sparkchain.core;

import com.iflytek.sparkchain.media.record.PcmRecorder;

/* loaded from: classes10.dex */
public interface AiAbilityApi {
    int end(AiHandle aiHandle);

    int engineInit(String str);

    int engineInit(String str, AiRequest aiRequest);

    int engineUnInit(String str);

    int loadData(String str, AiRequest aiRequest);

    int oneShot(String str, AiRequest aiRequest, AiRequest aiRequest2, Object obj);

    int oneShot(String str, AiRequest aiRequest, Object obj);

    int oneShotAsync(String str, AiRequest aiRequest);

    AiOutput oneShotSync(String str, AiRequest aiRequest, Object obj);

    int preProcess(String str, AiRequest aiRequest);

    int read(String str, AiHandle aiHandle);

    AiOutput readSync(String str, AiHandle aiHandle);

    AiHandle record(String str, AiHandle aiHandle, PcmRecorder.Builder builder, String str2, Object obj);

    int specifyDataSet(String str, String str2, int[] iArr);

    AiHandle start(String str, AiRequest aiRequest, Object obj);

    AiHandle start(String str, Object obj);

    int unLoadData(String str, String str2, int i);

    int write(AiRequest aiRequest, AiHandle aiHandle);
}
