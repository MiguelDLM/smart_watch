package com.facebook.gamingservices.cloudgaming;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;

/* loaded from: classes8.dex */
class MediaUploadCallback implements GraphRequest.Callback {
    private String body;
    GraphRequest.Callback callback;

    @Nullable
    private String payload;
    private int timeInterval;
    private String title;

    public MediaUploadCallback(String title, String body, int timeInterval, @Nullable String payload, GraphRequest.Callback callback) {
        this.title = title;
        this.body = body;
        this.timeInterval = timeInterval;
        this.payload = payload;
        this.callback = callback;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse response) {
        if (response.getError() == null) {
            String optString = response.getJSONObject().optString("id");
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            Bundle bundle = new Bundle();
            bundle.putString("title", this.title);
            bundle.putString("body", this.body);
            bundle.putInt(SDKConstants.PARAM_A2U_TIME_INTERVAL, this.timeInterval);
            String str = this.payload;
            if (str != null) {
                bundle.putString(SDKConstants.PARAM_A2U_PAYLOAD, str);
            }
            bundle.putString(SDKConstants.PARAM_A2U_MEDIA_ID, optString);
            new GraphRequest(currentAccessToken, SDKConstants.PARAM_A2U_GRAPH_PATH, bundle, HttpMethod.POST, this.callback).executeAsync();
            return;
        }
        throw new FacebookException(response.getError().getErrorMessage());
    }
}
