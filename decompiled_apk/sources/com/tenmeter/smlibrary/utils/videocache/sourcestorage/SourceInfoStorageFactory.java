package com.tenmeter.smlibrary.utils.videocache.sourcestorage;

import android.content.Context;

/* loaded from: classes13.dex */
public class SourceInfoStorageFactory {
    public static SourceInfoStorage newEmptySourceInfoStorage() {
        return new NoSourceInfoStorage();
    }

    public static SourceInfoStorage newSourceInfoStorage(Context context) {
        return new DatabaseSourceInfoStorage(context);
    }
}
