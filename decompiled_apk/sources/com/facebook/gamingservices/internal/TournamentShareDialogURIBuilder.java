package com.facebook.gamingservices.internal;

import OXOo.OOXIXo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.facebook.gamingservices.TournamentConfig;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.time.Instant;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class TournamentShareDialogURIBuilder {

    @OOXIXo
    public static final TournamentShareDialogURIBuilder INSTANCE = new TournamentShareDialogURIBuilder();

    @OOXIXo
    public static final String authority = "fb.gg";

    /* renamed from: me, reason: collision with root package name */
    @OOXIXo
    public static final String f10996me = "me";

    @OOXIXo
    public static final String scheme = "https";

    @OOXIXo
    public static final String tournament = "instant_tournament";

    private TournamentShareDialogURIBuilder() {
    }

    @OOXIXo
    public final Bundle bundleForCreating$facebook_gamingservices_release(@OOXIXo TournamentConfig config, @OOXIXo Number score, @OOXIXo String appID) {
        Instant endTime;
        long epochSecond;
        IIX0o.x0xO0oo(config, "config");
        IIX0o.x0xO0oo(score, "score");
        IIX0o.x0xO0oo(appID, "appID");
        Bundle bundle = new Bundle();
        bundle.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, SDKConstants.PARAM_TOURNAMENTS);
        bundle.putString("app_id", appID);
        bundle.putString("score", score.toString());
        TournamentSortOrder sortOrder = config.getSortOrder();
        if (sortOrder != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_SORT_ORDER, sortOrder.toString());
        }
        TournamentScoreType scoreType = config.getScoreType();
        if (scoreType != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_SCORE_FORMAT, scoreType.toString());
        }
        String title = config.getTitle();
        if (title != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_TITLE, title.toString());
        }
        String payload = config.getPayload();
        if (payload != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_PAYLOAD, payload.toString());
        }
        if (Build.VERSION.SDK_INT >= 26 && (endTime = config.getEndTime()) != null) {
            epochSecond = endTime.getEpochSecond();
            bundle.putString("end_time", String.valueOf((int) epochSecond));
        }
        return bundle;
    }

    @OOXIXo
    public final Bundle bundleForUpdating$facebook_gamingservices_release(@OOXIXo String tournamentID, @OOXIXo Number score, @OOXIXo String appID) {
        IIX0o.x0xO0oo(tournamentID, "tournamentID");
        IIX0o.x0xO0oo(score, "score");
        IIX0o.x0xO0oo(appID, "appID");
        Bundle bundle = new Bundle();
        bundle.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, SDKConstants.PARAM_TOURNAMENTS);
        bundle.putString("app_id", appID);
        bundle.putString("score", score.toString());
        bundle.putString(SDKConstants.PARAM_TOURNAMENTS_ID, tournamentID);
        return bundle;
    }

    @OOXIXo
    public final Uri uriForCreating$facebook_gamingservices_release(@OOXIXo TournamentConfig config, @OOXIXo Number score, @OOXIXo String appID) {
        String instant;
        IIX0o.x0xO0oo(config, "config");
        IIX0o.x0xO0oo(score, "score");
        IIX0o.x0xO0oo(appID, "appID");
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").authority("fb.gg").appendPath(f10996me).appendPath(tournament).appendPath(appID).appendQueryParameter("score", score.toString());
        Instant endTime = config.getEndTime();
        if (endTime != null) {
            instant = endTime.toString();
            appendQueryParameter.appendQueryParameter("end_time", instant);
        }
        TournamentSortOrder sortOrder = config.getSortOrder();
        if (sortOrder != null) {
            appendQueryParameter.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_SORT_ORDER, sortOrder.toString());
        }
        TournamentScoreType scoreType = config.getScoreType();
        if (scoreType != null) {
            appendQueryParameter.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_SCORE_FORMAT, scoreType.toString());
        }
        String title = config.getTitle();
        if (title != null) {
            appendQueryParameter.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_TITLE, title);
        }
        String payload = config.getPayload();
        if (payload != null) {
            appendQueryParameter.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_PAYLOAD, payload);
        }
        Uri build = appendQueryParameter.build();
        IIX0o.oO(build, "builder.build()");
        return build;
    }

    @OOXIXo
    public final Uri uriForUpdating$facebook_gamingservices_release(@OOXIXo String tournamentID, @OOXIXo Number score, @OOXIXo String appID) {
        IIX0o.x0xO0oo(tournamentID, "tournamentID");
        IIX0o.x0xO0oo(score, "score");
        IIX0o.x0xO0oo(appID, "appID");
        Uri build = new Uri.Builder().scheme("https").authority("fb.gg").appendPath(f10996me).appendPath(tournament).appendPath(appID).appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_ID, tournamentID).appendQueryParameter("score", score.toString()).build();
        IIX0o.oO(build, "Builder()\n        .scheme(scheme)\n        .authority(authority)\n        .appendPath(me)\n        .appendPath(tournament)\n        .appendPath(appID)\n        .appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_ID, tournamentID)\n        .appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_SCORE, score.toString())\n        .build()");
        return build;
    }
}
