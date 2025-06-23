package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.DownloadManager;
import java.util.Comparator;

/* loaded from: classes9.dex */
public final /* synthetic */ class oOoXoXO implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return DownloadManager.InternalHandler.oIX0oI((Download) obj, (Download) obj2);
    }
}
