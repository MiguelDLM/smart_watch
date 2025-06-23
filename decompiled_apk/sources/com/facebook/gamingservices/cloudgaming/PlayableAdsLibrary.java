package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import androidx.annotation.Nullable;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class PlayableAdsLibrary {
    public static void markGameLoaded(Context context, @Nullable JSONObject parameters, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, parameters, callback, SDKMessageEnum.MARK_GAME_LOADED);
    }

    public static void openAppStore(Context context, @Nullable JSONObject parameters, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, parameters, callback, SDKMessageEnum.OPEN_APP_STORE);
    }
}
