package com.alimm.tanx.ui.image.glide.load.engine;

import com.alimm.tanx.ui.image.glide.load.Key;

/* loaded from: classes.dex */
interface EngineJobListener {
    void onEngineJobCancelled(EngineJob engineJob, Key key);

    void onEngineJobComplete(Key key, EngineResource<?> engineResource);
}
