package com.androidnetworking;

import android.content.Context;
import android.graphics.BitmapFactory;
import com.androidnetworking.common.ANConstants;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ConnectionClassManager;
import com.androidnetworking.common.ConnectionQuality;
import com.androidnetworking.core.Core;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.androidnetworking.interfaces.ConnectionQualityChangeListener;
import com.androidnetworking.interfaces.Parser;
import com.androidnetworking.internal.ANImageLoader;
import com.androidnetworking.internal.ANRequestQueue;
import com.androidnetworking.internal.InternalNetworking;
import com.androidnetworking.utils.ParseUtil;
import com.androidnetworking.utils.Utils;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public class AndroidNetworking {
    private AndroidNetworking() {
    }

    public static void cancel(Object obj) {
        ANRequestQueue.getInstance().cancelRequestWithGivenTag(obj, false);
    }

    public static void cancelAll() {
        ANRequestQueue.getInstance().cancelAll(false);
    }

    public static ANRequest.DeleteRequestBuilder delete(String str) {
        return new ANRequest.DeleteRequestBuilder(str);
    }

    public static ANRequest.DownloadBuilder download(String str, String str2, String str3) {
        return new ANRequest.DownloadBuilder(str, str2, str3);
    }

    public static void enableLogging() {
        enableLogging(HttpLoggingInterceptor.Level.BASIC);
    }

    public static void evictAllBitmap() {
        ANImageLoader.ImageCache imageCache = ANImageLoader.getInstance().getImageCache();
        if (imageCache != null) {
            imageCache.evictAllBitmap();
        }
    }

    public static void evictBitmap(String str) {
        ANImageLoader.ImageCache imageCache = ANImageLoader.getInstance().getImageCache();
        if (imageCache != null && str != null) {
            imageCache.evictBitmap(str);
        }
    }

    public static void forceCancel(Object obj) {
        ANRequestQueue.getInstance().cancelRequestWithGivenTag(obj, true);
    }

    public static void forceCancelAll() {
        ANRequestQueue.getInstance().cancelAll(true);
    }

    public static ANRequest.GetRequestBuilder get(String str) {
        return new ANRequest.GetRequestBuilder(str);
    }

    public static int getCurrentBandwidth() {
        return ConnectionClassManager.getInstance().getCurrentBandwidth();
    }

    public static ConnectionQuality getCurrentConnectionQuality() {
        return ConnectionClassManager.getInstance().getCurrentConnectionQuality();
    }

    public static ANRequest.HeadRequestBuilder head(String str) {
        return new ANRequest.HeadRequestBuilder(str);
    }

    public static void initialize(Context context) {
        InternalNetworking.setClientWithCache(context.getApplicationContext());
        ANRequestQueue.initialize();
        ANImageLoader.initialize();
    }

    public static boolean isRequestRunning(Object obj) {
        return ANRequestQueue.getInstance().isRequestRunning(obj);
    }

    public static ANRequest.OptionsRequestBuilder options(String str) {
        return new ANRequest.OptionsRequestBuilder(str);
    }

    public static ANRequest.PatchRequestBuilder patch(String str) {
        return new ANRequest.PatchRequestBuilder(str);
    }

    public static ANRequest.PostRequestBuilder post(String str) {
        return new ANRequest.PostRequestBuilder(str);
    }

    public static ANRequest.PutRequestBuilder put(String str) {
        return new ANRequest.PutRequestBuilder(str);
    }

    public static void removeConnectionQualityChangeListener() {
        ConnectionClassManager.getInstance().removeListener();
    }

    public static ANRequest.DynamicRequestBuilder request(String str, int i) {
        return new ANRequest.DynamicRequestBuilder(str, i);
    }

    public static void setBitmapDecodeOptions(BitmapFactory.Options options) {
        if (options != null) {
            ANImageLoader.getInstance().setBitmapDecodeOptions(options);
        }
    }

    public static void setConnectionQualityChangeListener(ConnectionQualityChangeListener connectionQualityChangeListener) {
        ConnectionClassManager.getInstance().setListener(connectionQualityChangeListener);
    }

    public static void setParserFactory(Parser.Factory factory) {
        ParseUtil.setParserFactory(factory);
    }

    public static void setUserAgent(String str) {
        InternalNetworking.setUserAgent(str);
    }

    public static void shutDown() {
        Core.shutDown();
        evictAllBitmap();
        ConnectionClassManager.getInstance().removeListener();
        ConnectionClassManager.shutDown();
        ParseUtil.shutDown();
    }

    public static ANRequest.MultiPartBuilder upload(String str) {
        return new ANRequest.MultiPartBuilder(str);
    }

    public static void enableLogging(HttpLoggingInterceptor.Level level) {
        InternalNetworking.enableLogging(level);
    }

    public static void initialize(Context context, OkHttpClient okHttpClient) {
        if (okHttpClient != null && okHttpClient.cache() == null) {
            okHttpClient = okHttpClient.newBuilder().cache(Utils.getCache(context.getApplicationContext(), ANConstants.MAX_CACHE_SIZE, ANConstants.CACHE_DIR_NAME)).build();
        }
        InternalNetworking.setClient(okHttpClient);
        ANRequestQueue.initialize();
        ANImageLoader.initialize();
    }
}
