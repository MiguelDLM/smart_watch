package com.baidu.ai.speech.realtime.full.connection;

import android.content.Context;
import com.baidu.ai.speech.realtime.full.download.SimpleDownloader;
import com.baidu.ai.speech.realtime.full.upload.AbstractUploader;
import com.baidu.ai.speech.realtime.full.upload.RealTimeAudioFeeder;
import com.baidu.ai.speech.realtime.full.upload.RealTimeUploader;
import com.baidu.ai.speech.realtime.full.upload.SimpleUploader;
import com.baidu.ai.speech.realtime.full.util.Stat;
import com.google.android.exoplayer2.ExoPlayer;
import com.tenmeter.smlibrary.provider.BaseProvider;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* loaded from: classes7.dex */
public class Runner {
    public static final int MODE_FILE_STREAM = 1;
    public static final int MODE_REAL_TIME_STREAM = 2;
    public static final int MODE_SIMULATE_REAL_TIME_STREAM = 3;
    private static Logger logger = Logger.getLogger("Runner");
    private InputStream inputStream;
    private MyWebSocketListener listener;
    private int mode;
    private final OkHttpClient client = new OkHttpClient.Builder().cache(createCache(BaseProvider.mContext, 2097152000L)).connectTimeout(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS).build();
    private Stat stat = new Stat();

    public Runner(InputStream inputStream, int mode) {
        this.inputStream = inputStream;
        this.mode = mode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$run$0(RealTimeAudioFeeder realTimeAudioFeeder) {
        try {
            realTimeAudioFeeder.startFeed();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "sleep error", (Throwable) e);
            throw new RuntimeException(e);
        }
    }

    public Cache createCache(Context context, Long cacheSizeInBytes) {
        return new Cache(new File(context.getCacheDir(), "http-cache"), cacheSizeInBytes.longValue());
    }

    public boolean isClosed() {
        return this.listener.isClosed();
    }

    public void run() throws IOException {
        run(new SimpleDownloader());
    }

    public void run(SimpleDownloader downloader) throws IOException {
        AbstractUploader simpleUploader;
        String str = "ws://vop.baidu.com/realtime_asr?sn=" + UUID.randomUUID().toString();
        logger.info("runner begin: " + str);
        Request build = new Request.Builder().url(str).build();
        int i = this.mode;
        if (i == 1) {
            simpleUploader = new SimpleUploader(this.inputStream, this.stat);
        } else if (i == 2) {
            simpleUploader = new RealTimeUploader(this.inputStream, this.stat);
        } else if (i == 3) {
            final RealTimeAudioFeeder realTimeAudioFeeder = new RealTimeAudioFeeder(this.inputStream);
            simpleUploader = new RealTimeUploader(realTimeAudioFeeder.getRealTimeInputStream(), this.stat);
            new Thread(new Runnable() { // from class: com.baidu.ai.speech.realtime.full.connection.II0xO0
                @Override // java.lang.Runnable
                public final void run() {
                    Runner.lambda$run$0(RealTimeAudioFeeder.this);
                }
            }).start();
        } else {
            throw new RuntimeException("mode not implemented " + this.mode);
        }
        MyWebSocketListener myWebSocketListener = new MyWebSocketListener(simpleUploader, downloader);
        this.listener = myWebSocketListener;
        this.client.newWebSocket(build, myWebSocketListener);
        this.client.dispatcher().executorService().shutdown();
    }
}
