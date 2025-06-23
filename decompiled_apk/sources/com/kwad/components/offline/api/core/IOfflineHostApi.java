package com.kwad.components.offline.api.core;

import android.content.Context;
import com.kwad.components.offline.api.core.adlive.ILive;
import com.kwad.components.offline.api.core.api.IAsync;
import com.kwad.components.offline.api.core.api.IBundleService;
import com.kwad.components.offline.api.core.api.ICache;
import com.kwad.components.offline.api.core.api.ICrash;
import com.kwad.components.offline.api.core.api.IDownloader;
import com.kwad.components.offline.api.core.api.IEncrypt;
import com.kwad.components.offline.api.core.api.IEnvironment;
import com.kwad.components.offline.api.core.api.IFlowUuid;
import com.kwad.components.offline.api.core.api.IImageLoader;
import com.kwad.components.offline.api.core.api.ILifeCycle;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.components.offline.api.core.api.IOfflineCompoLogcat;
import com.kwad.components.offline.api.core.api.ISystemProperties;
import com.kwad.components.offline.api.core.api.IVibratorUtil;
import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.components.offline.api.core.imageplayer.IImagePlayer;
import com.kwad.components.offline.api.core.network.IIdc;
import com.kwad.components.offline.api.core.network.INetworkManager;
import com.kwad.components.offline.api.core.video.IVideo;
import com.kwad.components.offline.api.core.webview.IWebView;
import java.util.List;

/* loaded from: classes11.dex */
public interface IOfflineHostApi {
    IAsync async();

    IBundleService bundleService();

    ICache cache();

    ICrash crash();

    IDownloader downloader();

    IEncrypt encrypt();

    IEnvironment env();

    IFlowUuid flowUuid();

    int getAppIconId(Context context);

    int getDrawableId(Context context, String str);

    int getId(Context context, String str);

    long getSystemTimeInMs(Context context, boolean z);

    int getTKErrorDetailCount();

    List<String> getTKPreloadMemCacheTemplates();

    IIdc idc();

    IImageLoader imageLoader();

    IImagePlayer imagePlayer();

    boolean isOrientationPortrait();

    ILifeCycle lifeCycle();

    ILive live();

    IOfflineCompoLogcat log();

    ILoggerReporter loggerReporter();

    INet net();

    INetworkManager networkManager();

    void saveTKTemplateCache(String str, int i, String str2);

    ISystemProperties systemProperty();

    IVibratorUtil vibratorUtil();

    IVideo video();

    IWebView webview();

    IZipper zipper();
}
