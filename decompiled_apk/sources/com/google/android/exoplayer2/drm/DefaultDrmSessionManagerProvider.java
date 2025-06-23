package com.google.android.exoplayer2.drm;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.util.Map;

/* loaded from: classes9.dex */
public final class DefaultDrmSessionManagerProvider implements DrmSessionManagerProvider {

    @GuardedBy("lock")
    private MediaItem.DrmConfiguration drmConfiguration;

    @Nullable
    private DataSource.Factory drmHttpDataSourceFactory;
    private final Object lock = new Object();

    @GuardedBy("lock")
    private DrmSessionManager manager;

    @Nullable
    private String userAgent;

    @RequiresApi(18)
    private DrmSessionManager createManager(MediaItem.DrmConfiguration drmConfiguration) {
        String uri;
        DataSource.Factory factory = this.drmHttpDataSourceFactory;
        if (factory == null) {
            factory = new DefaultHttpDataSource.Factory().setUserAgent(this.userAgent);
        }
        Uri uri2 = drmConfiguration.licenseUri;
        if (uri2 == null) {
            uri = null;
        } else {
            uri = uri2.toString();
        }
        HttpMediaDrmCallback httpMediaDrmCallback = new HttpMediaDrmCallback(uri, drmConfiguration.forceDefaultLicenseUri, factory);
        UnmodifiableIterator<Map.Entry<String, String>> it = drmConfiguration.licenseRequestHeaders.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            httpMediaDrmCallback.setKeyRequestProperty(next.getKey(), next.getValue());
        }
        DefaultDrmSessionManager build = new DefaultDrmSessionManager.Builder().setUuidAndExoMediaDrmProvider(drmConfiguration.scheme, FrameworkMediaDrm.DEFAULT_PROVIDER).setMultiSession(drmConfiguration.multiSession).setPlayClearSamplesWithoutKeys(drmConfiguration.playClearContentWithoutKey).setUseDrmSessionsForClearContent(Ints.toArray(drmConfiguration.forcedSessionTrackTypes)).build(httpMediaDrmCallback);
        build.setMode(0, drmConfiguration.getKeySetId());
        return build;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManagerProvider
    public DrmSessionManager get(MediaItem mediaItem) {
        DrmSessionManager drmSessionManager;
        Assertions.checkNotNull(mediaItem.localConfiguration);
        MediaItem.DrmConfiguration drmConfiguration = mediaItem.localConfiguration.drmConfiguration;
        if (drmConfiguration != null && Util.SDK_INT >= 18) {
            synchronized (this.lock) {
                try {
                    if (!Util.areEqual(drmConfiguration, this.drmConfiguration)) {
                        this.drmConfiguration = drmConfiguration;
                        this.manager = createManager(drmConfiguration);
                    }
                    drmSessionManager = (DrmSessionManager) Assertions.checkNotNull(this.manager);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return drmSessionManager;
        }
        return DrmSessionManager.DRM_UNSUPPORTED;
    }

    public void setDrmHttpDataSourceFactory(@Nullable DataSource.Factory factory) {
        this.drmHttpDataSourceFactory = factory;
    }

    @Deprecated
    public void setDrmUserAgent(@Nullable String str) {
        this.userAgent = str;
    }
}
