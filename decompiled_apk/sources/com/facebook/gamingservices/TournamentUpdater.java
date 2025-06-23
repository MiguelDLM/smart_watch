package com.facebook.gamingservices;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.bolts.TaskCompletionSource;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class TournamentUpdater {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: update$lambda-0, reason: not valid java name */
    public static final void m194update$lambda0(TaskCompletionSource task, GraphResponse response) {
        FacebookException exception;
        IIX0o.x0xO0oo(task, "$task");
        IIX0o.x0xO0oo(response, "response");
        String str = null;
        FacebookException facebookException = null;
        if (response.getError() != null) {
            FacebookRequestError error = response.getError();
            if (error == null) {
                exception = null;
            } else {
                exception = error.getException();
            }
            if (exception != null) {
                FacebookRequestError error2 = response.getError();
                if (error2 != null) {
                    facebookException = error2.getException();
                }
                task.setError(facebookException);
                return;
            }
            task.setError(new GraphAPIException("Graph API Error"));
            return;
        }
        JSONObject jSONObject = response.getJSONObject();
        if (jSONObject != null) {
            str = jSONObject.optString("success");
        }
        if (str != null && str.length() != 0) {
            task.setResult(Boolean.valueOf(str.equals("true")));
        } else {
            task.setError(new GraphAPIException("Graph API Error"));
        }
    }

    @oOoXoXO
    public final TaskCompletionSource<Boolean> update(@OOXIXo Tournament tournament, @OOXIXo Number score) {
        IIX0o.x0xO0oo(tournament, "tournament");
        IIX0o.x0xO0oo(score, "score");
        return update(tournament.identifier, score);
    }

    @oOoXoXO
    public final TaskCompletionSource<Boolean> update(@OOXIXo String identifier, @OOXIXo Number score) {
        IIX0o.x0xO0oo(identifier, "identifier");
        IIX0o.x0xO0oo(score, "score");
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        if (currentAccessToken != null && !currentAccessToken.isExpired()) {
            if (currentAccessToken.getGraphDomain() != null && IIX0o.Oxx0IOOO(FacebookSdk.GAMING, currentAccessToken.getGraphDomain())) {
                final TaskCompletionSource<Boolean> taskCompletionSource = new TaskCompletionSource<>();
                String XIxXXX0x02 = IIX0o.XIxXXX0x0(identifier, "/update_score");
                Bundle bundle = new Bundle();
                bundle.putInt("score", score.intValue());
                new GraphRequest(currentAccessToken, XIxXXX0x02, bundle, HttpMethod.POST, new GraphRequest.Callback() { // from class: com.facebook.gamingservices.II0XooXoX
                    @Override // com.facebook.GraphRequest.Callback
                    public final void onCompleted(GraphResponse graphResponse) {
                        TournamentUpdater.m194update$lambda0(TaskCompletionSource.this, graphResponse);
                    }
                }, null, 32, null).executeAsync();
                return taskCompletionSource;
            }
            throw new FacebookException("User is not using gaming login");
        }
        throw new FacebookException("Attempted to fetch tournament with an invalid access token");
    }
}
