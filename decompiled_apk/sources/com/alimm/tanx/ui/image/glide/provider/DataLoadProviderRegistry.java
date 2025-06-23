package com.alimm.tanx.ui.image.glide.provider;

import com.alimm.tanx.ui.image.glide.util.MultiClassKey;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class DataLoadProviderRegistry {
    private static final MultiClassKey GET_KEY = new MultiClassKey();
    private final Map<MultiClassKey, DataLoadProvider<?, ?>> providers = new HashMap();

    public <T, Z> DataLoadProvider<T, Z> get(Class<T> cls, Class<Z> cls2) {
        DataLoadProvider<T, Z> dataLoadProvider;
        MultiClassKey multiClassKey = GET_KEY;
        synchronized (multiClassKey) {
            multiClassKey.set(cls, cls2);
            dataLoadProvider = (DataLoadProvider) this.providers.get(multiClassKey);
        }
        if (dataLoadProvider == null) {
            return EmptyDataLoadProvider.get();
        }
        return dataLoadProvider;
    }

    public <T, Z> void register(Class<T> cls, Class<Z> cls2, DataLoadProvider<T, Z> dataLoadProvider) {
        this.providers.put(new MultiClassKey(cls, cls2), dataLoadProvider);
    }
}
