package com.alimm.tanx.ui.image.glide.manager;

/* loaded from: classes.dex */
class ApplicationLifecycle implements Lifecycle {
    @Override // com.alimm.tanx.ui.image.glide.manager.Lifecycle
    public void addListener(LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }
}
