package com.alimm.tanx.ui.image.glide.load.data;

import com.alimm.tanx.ui.image.glide.Priority;

/* loaded from: classes.dex */
public interface DataFetcher<T> {
    void cancel();

    void cleanup();

    String getId();

    T loadData(Priority priority) throws Exception;
}
