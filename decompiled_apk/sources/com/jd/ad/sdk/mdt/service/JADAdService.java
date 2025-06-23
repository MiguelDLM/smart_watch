package com.jd.ad.sdk.mdt.service;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.bl.adload.JADAdLoadListener;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.model.IJADExtra;
import com.jd.ad.sdk.dl.model.JADSlot;
import java.util.List;

/* loaded from: classes10.dex */
public interface JADAdService {
    boolean enablePreloadAd(@NonNull String str, @NonNull JADSlot jADSlot);

    IJADExtra getJADExtra(@NonNull String str);

    List<JADMaterialData> getJADMaterialDataList(@NonNull String str);

    void loadAd(@NonNull String str, @NonNull JADSlot jADSlot, @NonNull JADAdLoadListener jADAdLoadListener);

    void loadAdFromCache(@NonNull String str, @NonNull JADSlot jADSlot, @NonNull JADAdLoadListener jADAdLoadListener);

    void printRequestData(@NonNull JADSlot jADSlot);

    void registerAd(String str);

    void registerAdPreloader(@NonNull String str, @NonNull JADSlot jADSlot);

    void removeData(@NonNull String str);

    void unregisterAd(@NonNull String str);

    void unregisterAdPreloader(@NonNull String str, @NonNull JADSlot jADSlot);
}
