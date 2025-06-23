package com.tenmeter.smlibrary.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.view.TextureView;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.google.android.exoplayer2.util.Util;
import com.tenmeter.smlibrary.utils.videocache.HttpProxyCacheServer;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes13.dex */
public class SMPlayerManager {
    private static final String DISK_CACHE_DIR_NAME = "Video";
    private static SMPlayerManager mSMPlayerManager;
    private final LinkedHashMap<String, ExoPlayer> mPlayers = new LinkedHashMap<>();
    private volatile HttpProxyCacheServer mProxyCacheServer;

    private SMPlayerManager(Context context) {
        this.mProxyCacheServer = null;
        this.mProxyCacheServer = createProxyCacheServer(context);
    }

    private MediaSource buildDataSource(Context context, String str) {
        return new ProgressiveMediaSource.Factory(new DefaultDataSource.Factory(context)).createMediaSource(MediaItem.fromUri(Uri.parse(getProxyUrl(str))));
    }

    private HttpProxyCacheServer createProxyCacheServer(Context context) {
        return new HttpProxyCacheServer.Builder(context).cacheDirectory(getDiskCacheDirectory(context)).maxCacheSize(1073741824L).build();
    }

    @SuppressLint({"SdCardPath"})
    private File getDiskCacheDirectory(Context context) {
        File file;
        if ("mounted".equals(getExternalStorageState())) {
            file = getExternalCacheDir(context);
        } else {
            file = null;
        }
        if (file == null) {
            file = context.getCacheDir();
        }
        if (file == null) {
            file = new File("/data/data/" + context.getPackageName() + "/cache/");
        }
        return new File(file, DISK_CACHE_DIR_NAME);
    }

    private File getExternalCacheDir(Context context) {
        File externalFilesDir = context.getExternalFilesDir("Cache");
        if (!externalFilesDir.exists() && !externalFilesDir.mkdirs()) {
            return null;
        }
        return externalFilesDir;
    }

    private String getExternalStorageState() {
        try {
            return Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            return "";
        }
    }

    public static SMPlayerManager getInstance(Context context) {
        return new SMPlayerManager(context.getApplicationContext());
    }

    private String getProxyUrl(String str) {
        return this.mProxyCacheServer.getProxyUrl(str);
    }

    private boolean isCached(String str) {
        return this.mProxyCacheServer.isCached(str);
    }

    public ExoPlayer getPlayer(String str) {
        ExoPlayer exoPlayer = this.mPlayers.get(str);
        if (exoPlayer != null) {
            return exoPlayer;
        }
        ExoPlayer build = new ExoPlayer.Builder(SMGameClient.getContext()).build();
        build.setVideoTextureView(new TextureView(SMGameClient.getContext()));
        build.setPlayWhenReady(false);
        build.setRepeatMode(0);
        if (Util.inferContentType(Uri.parse(str)) == 4) {
            build.setMediaSource(buildDataSource(SMGameClient.getContext(), str));
            build.prepare();
        }
        this.mPlayers.put(str, build);
        return build;
    }

    public synchronized void pauseAll() {
        if (!this.mPlayers.isEmpty()) {
            Iterator<Map.Entry<String, ExoPlayer>> it = this.mPlayers.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().pause();
            }
        }
    }

    public synchronized void release(String str) {
        ExoPlayer exoPlayer = this.mPlayers.get(str);
        if (exoPlayer != null) {
            exoPlayer.release();
        }
    }

    public synchronized void releaseAll() {
        try {
            if (!this.mPlayers.isEmpty()) {
                Iterator<String> it = this.mPlayers.keySet().iterator();
                while (it.hasNext()) {
                    release(it.next());
                }
                this.mPlayers.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void removePlay(String str) {
        if (this.mPlayers.containsKey(str)) {
            this.mPlayers.remove(str);
        }
    }

    public ExoPlayer getPlayer(String str, boolean z) {
        ExoPlayer exoPlayer = this.mPlayers.get(str);
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(z);
            exoPlayer.setRepeatMode(0);
            if (Util.inferContentType(Uri.parse(str)) == 4) {
                exoPlayer.setMediaSource(buildDataSource(SMGameClient.getContext(), str), exoPlayer.getCurrentPosition());
                exoPlayer.prepare();
            }
            return exoPlayer;
        }
        ExoPlayer build = new ExoPlayer.Builder(SMGameClient.getContext()).build();
        build.setVideoTextureView(new TextureView(SMGameClient.getContext()));
        build.setPlayWhenReady(z);
        build.setRepeatMode(0);
        if (Util.inferContentType(Uri.parse(str)) == 4) {
            build.setMediaSource(buildDataSource(SMGameClient.getContext(), str));
            build.prepare();
        }
        this.mPlayers.put(str, build);
        return build;
    }
}
