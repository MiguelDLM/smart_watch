package com.tenmeter.smlibrary.utils.videocache.sourcestorage;

import com.tenmeter.smlibrary.utils.videocache.SourceInfo;

/* loaded from: classes13.dex */
public class NoSourceInfoStorage implements SourceInfoStorage {
    @Override // com.tenmeter.smlibrary.utils.videocache.sourcestorage.SourceInfoStorage
    public SourceInfo get(String str) {
        return null;
    }

    @Override // com.tenmeter.smlibrary.utils.videocache.sourcestorage.SourceInfoStorage
    public void put(String str, SourceInfo sourceInfo) {
    }

    @Override // com.tenmeter.smlibrary.utils.videocache.sourcestorage.SourceInfoStorage
    public void release() {
    }
}
