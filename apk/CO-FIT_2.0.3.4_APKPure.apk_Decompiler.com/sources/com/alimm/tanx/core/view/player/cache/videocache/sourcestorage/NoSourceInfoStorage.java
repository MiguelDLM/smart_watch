package com.alimm.tanx.core.view.player.cache.videocache.sourcestorage;

import com.alimm.tanx.core.view.player.cache.videocache.SourceInfo;

public class NoSourceInfoStorage implements SourceInfoStorage {
    public SourceInfo get(String str) {
        return null;
    }

    public void put(String str, SourceInfo sourceInfo) {
    }

    public void release() {
    }
}
