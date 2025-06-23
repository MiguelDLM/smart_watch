package com.baidu.ar.marker;

import com.baidu.ar.marker.MarkerARAlgoJniClient;
import com.baidu.ar.marker.model.TranslationPrior;

/* loaded from: classes7.dex */
public interface IMarkerTracker {
    void chooseMap(int i);

    boolean getAlgoState();

    int init(TrackerType trackerType);

    void loadAlgoSo(MarkerARAlgoJniClient.a aVar);

    void onTrack(byte[] bArr, int i, int i2, float[] fArr, float[] fArr2);

    void onTrackPause();

    void onTrackRelease();

    void onTrackReset();

    void onTrackResume();

    void setCameraParams(float[] fArr, float[] fArr2, int i, double[] dArr);

    void setDataProvider(IMarkerDataProvider iMarkerDataProvider);

    void transProtoDataJNIFromServer(byte[] bArr);

    void updateTranslationPrior(TranslationPrior translationPrior);
}
