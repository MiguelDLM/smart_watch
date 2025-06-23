package com.kwad.components.offline.api.core.adlive.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class KSAdLivePushEndInfo implements Serializable {
    public static final String KET_CONFIG_DISPLAY_LIKE_USER_COUNT = "displayLikeUserCount";
    public static final String KET_CONFIG_DISPLAY_WATCHING_USER_COUNT = "displayWatchingUserCount";
    public static final String KET_CONFIG_LIKE_USER_COUNT = "likeUserCount";
    public static final String KET_CONFIG_LIVE_DURATION = "liveDuration";
    public static final String KET_CONFIG_TOTAL_WATCHING_DURATION = "totalWatchingDuration";
    public static final String KET_CONFIG_WATCHING_USER_COUNT = "watchingUserCount";
    private static final long serialVersionUID = 7611577990274486211L;
    public int mLikeUserCount;
    public long mLiveDuration;
    public long mTotalWatchingDuration;
    public int mWatchingUserCount;
    public String mDisplayWatchingUserCount = "0";
    public String mDisplayLikeUserCount = "0";

    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mTotalWatchingDuration = jSONObject.optLong("totalWatchingDuration");
        this.mWatchingUserCount = jSONObject.optInt("watchingUserCount");
        this.mDisplayWatchingUserCount = jSONObject.optString("displayWatchingUserCount", "0");
        this.mLiveDuration = jSONObject.optLong("liveDuration");
        this.mLikeUserCount = jSONObject.optInt("likeUserCount");
        this.mDisplayLikeUserCount = jSONObject.optString("displayLikeUserCount", "0");
    }

    public JSONObject toJson(JSONObject jSONObject) {
        t.putValue(jSONObject, "totalWatchingDuration", this.mTotalWatchingDuration);
        t.putValue(jSONObject, "watchingUserCount", this.mWatchingUserCount);
        t.putValue(jSONObject, "displayWatchingUserCount", this.mDisplayWatchingUserCount);
        t.putValue(jSONObject, "liveDuration", this.mLiveDuration);
        t.putValue(jSONObject, "likeUserCount", this.mLikeUserCount);
        t.putValue(jSONObject, "displayLikeUserCount", this.mDisplayLikeUserCount);
        return jSONObject;
    }
}
