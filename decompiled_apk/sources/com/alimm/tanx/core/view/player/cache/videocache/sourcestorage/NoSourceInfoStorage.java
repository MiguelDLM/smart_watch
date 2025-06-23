package com.alimm.tanx.core.view.player.cache.videocache.sourcestorage;

import com.alimm.tanx.core.view.player.cache.videocache.SourceInfo;

/* loaded from: classes.dex */
public class NoSourceInfoStorage implements SourceInfoStorage {
    @Override // com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage
    public SourceInfo get(String str) {
        return null;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage
    public void put(String str, SourceInfo sourceInfo) {
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage
    public void release() {
    }
}
