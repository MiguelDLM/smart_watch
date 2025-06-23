package com.kwad.sdk.api.proxy;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

@KsAdSdkDynamicApi
@Keep
/* loaded from: classes11.dex */
public interface IServiceProxy extends IComponentProxy {
    @KsAdSdkDynamicApi
    @Keep
    IBinder onBind(@NonNull Service service, Intent intent);

    @KsAdSdkDynamicApi
    @Keep
    void onCreate(@NonNull Service service);

    @KsAdSdkDynamicApi
    @Keep
    void onDestroy(@NonNull Service service);

    @KsAdSdkDynamicApi
    @Keep
    void onRebind(@NonNull Service service, Intent intent);

    @KsAdSdkDynamicApi
    @Keep
    int onStartCommand(@NonNull Service service, Intent intent, int i, int i2);

    boolean onUnbind(Service service, Intent intent);
}
