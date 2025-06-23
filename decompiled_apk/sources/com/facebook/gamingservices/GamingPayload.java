package com.facebook.gamingservices;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class GamingPayload {
    private static final String KEY_APPLINK_DATA = "al_applink_data";
    private static final String KEY_CONTEXT_TOKEN_ID = "context_token_id";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_GAME_REQUEST_ID = "game_request_id";
    private static final String KEY_PAYLOAD = "payload";
    private static final String KEY_TOURNAMENT_ID = "tournament_id";
    private static final String TAG = "GamingPayload";
    private static Map<String, String> payloadData;

    private GamingPayload() {
    }

    @Nullable
    public static String getGameRequestID() {
        Map<String, String> map = payloadData;
        if (map == null || !map.containsKey(KEY_GAME_REQUEST_ID)) {
            return null;
        }
        return payloadData.get(KEY_GAME_REQUEST_ID);
    }

    @Nullable
    public static String getPayload() {
        Map<String, String> map = payloadData;
        if (map == null || !map.containsKey("payload")) {
            return null;
        }
        return payloadData.get("payload");
    }

    @Nullable
    public static String getTournamentId() {
        Map<String, String> map = payloadData;
        if (map == null || !map.containsKey("tournament_id")) {
            return null;
        }
        return payloadData.get("tournament_id");
    }

    public static void loadPayloadFromCloudGame(String payloadString) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(payloadString);
            hashMap.put(KEY_GAME_REQUEST_ID, jSONObject.optString(KEY_GAME_REQUEST_ID));
            hashMap.put("payload", jSONObject.optString("payload"));
            hashMap.put("tournament_id", jSONObject.optString("tournament_id"));
            payloadData = hashMap;
        } catch (JSONException e) {
            Log.e(TAG, e.toString(), e);
        }
    }

    public static void loadPayloadFromIntent(Intent intent) {
        Bundle extras;
        Bundle bundle;
        HashMap hashMap = new HashMap();
        if (intent != null && (extras = intent.getExtras()) != null && extras.containsKey("al_applink_data") && (bundle = extras.getBundle("al_applink_data").getBundle("extras")) != null) {
            String string = bundle.getString(KEY_GAME_REQUEST_ID);
            String string2 = bundle.getString("payload");
            String string3 = bundle.getString(KEY_CONTEXT_TOKEN_ID);
            String string4 = bundle.getString("tournament_id");
            if (string3 != null) {
                GamingContext.setCurrentGamingContext(new GamingContext(string3));
            }
            hashMap.put(KEY_GAME_REQUEST_ID, string);
            hashMap.put("payload", string2);
            hashMap.put("tournament_id", string4);
            payloadData = hashMap;
        }
    }
}
