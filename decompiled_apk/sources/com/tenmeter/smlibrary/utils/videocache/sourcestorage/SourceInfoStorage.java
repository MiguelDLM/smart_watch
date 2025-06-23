package com.tenmeter.smlibrary.utils.videocache.sourcestorage;

import com.tenmeter.smlibrary.utils.videocache.SourceInfo;

/* loaded from: classes13.dex */
public interface SourceInfoStorage {
    SourceInfo get(String str);

    void put(String str, SourceInfo sourceInfo);

    void release();
}
