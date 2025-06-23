package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import androidx.annotation.Nullable;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class GameFeaturesLibrary {
    public static void canCreateShortcut(Context context, JSONObject parameters, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, parameters, callback, SDKMessageEnum.CAN_CREATE_SHORTCUT);
    }

    public static void createShortcut(Context context, JSONObject parameters, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, parameters, callback, SDKMessageEnum.CREATE_SHORTCUT);
    }

    public static void createTournamentAsync(Context context, int score, @Nullable String title, @Nullable String image, @Nullable String sortOrder, @Nullable String scoreFormat, @Nullable Integer endTime, @Nullable JSONObject payload, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_INITIAL_SCORE, score).put("title", title).put("image", image).put(SDKConstants.PARAM_SORT_ORDER, sortOrder).put(SDKConstants.PARAM_SCORE_FORMAT, scoreFormat).put("endTime", endTime).put("data", payload), callback, SDKMessageEnum.TOURNAMENT_CREATE_ASYNC);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.TOURNAMENT_CREATE_ASYNC, e);
        }
    }

    public static void getPayload(Context context, JSONObject parameters, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, parameters, callback, SDKMessageEnum.GET_PAYLOAD);
    }

    public static void getTournamentAsync(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.GET_TOURNAMENT_ASYNC);
    }

    public static void getTournamentsAsync(Context context, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.TOURNAMENT_GET_TOURNAMENTS_ASYNC);
    }

    public static void joinTournamentAsync(Context context, String tournamentId, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_TOURNAMENT_ID, tournamentId), callback, SDKMessageEnum.TOURNAMENT_JOIN_ASYNC);
    }

    public static void performHapticFeedback(Context context) {
        DaemonRequest.executeAsync(context, (JSONObject) null, new DaemonRequest.Callback() { // from class: com.facebook.gamingservices.cloudgaming.GameFeaturesLibrary.1
            @Override // com.facebook.gamingservices.cloudgaming.DaemonRequest.Callback
            public void onCompleted(GraphResponse response) {
            }
        }, SDKMessageEnum.PERFORM_HAPTIC_FEEDBACK_ASYNC);
    }

    public static void postSessionScore(Context context, int score, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put("score", score), callback, SDKMessageEnum.POST_SESSION_SCORE);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.POST_SESSION_SCORE, e);
        }
    }

    public static void postSessionScoreAsync(Context context, int score, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put("score", score), callback, SDKMessageEnum.POST_SESSION_SCORE_ASYNC);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.POST_SESSION_SCORE_ASYNC, e);
        }
    }

    public static void postTournamentScoreAsync(Context context, int score, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, new JSONObject().put("score", score), callback, SDKMessageEnum.TOURNAMENT_POST_SCORE_ASYNC);
    }

    public static void shareTournamentAsync(Context context, @Nullable Integer score, @Nullable JSONObject payload, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put("score", score).put("data", payload), callback, SDKMessageEnum.TOURNAMENT_SHARE_ASYNC);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.TOURNAMENT_SHARE_ASYNC, e);
        }
    }
}
