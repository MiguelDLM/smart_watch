package com.alimm.tanx.core.view.player.cache.videocache.sourcestorage;

import android.content.Context;

/* loaded from: classes.dex */
public class SourceInfoStorageFactory {
    public static SourceInfoStorage newEmptySourceInfoStorage() {
        return new NoSourceInfoStorage();
    }

    public static SourceInfoStorage newSourceInfoStorage(Context context) {
        return new DatabaseSourceInfoStorage(context);
    }
}
