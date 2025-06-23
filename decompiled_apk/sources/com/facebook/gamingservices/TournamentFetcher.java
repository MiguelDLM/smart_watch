package com.facebook.gamingservices;

import OXOo.OOXIXo;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.bolts.TaskCompletionSource;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class TournamentFetcher {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: fetchTournaments$lambda-1, reason: not valid java name */
    public static final void m192fetchTournaments$lambda1(TaskCompletionSource task, GraphResponse response) {
        FacebookException exception;
        IIX0o.x0xO0oo(task, "$task");
        IIX0o.x0xO0oo(response, "response");
        if (response.getError() != null) {
            FacebookRequestError error = response.getError();
            FacebookException facebookException = null;
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
        try {
            JSONObject jSONObject = response.getJSONObject();
            if (jSONObject == null) {
                task.setError(new GraphAPIException("Failed to get response"));
                return;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            if (jSONArray != null && jSONArray.length() >= 1) {
                Gson create = new GsonBuilder().create();
                String jSONArray2 = jSONArray.toString();
                IIX0o.oO(jSONArray2, "data.toString()");
                Object fromJson = create.fromJson(jSONArray2, (Class<Object>) Tournament[].class);
                IIX0o.oO(fromJson, "gson.fromJson(dataString, Array<Tournament>::class.java)");
                task.setResult(ArraysKt___ArraysKt.IoXOX((Object[]) fromJson));
                return;
            }
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format(Locale.ROOT, "No tournament found", Arrays.copyOf(new Object[]{Integer.valueOf(jSONArray.length()), 1}, 2));
            IIX0o.oO(format, "java.lang.String.format(locale, format, *args)");
            task.setError(new GraphAPIException(format));
        } catch (JSONException e) {
            task.setError(e);
        }
    }

    @OOXIXo
    public final TaskCompletionSource<List<Tournament>> fetchTournaments() {
        final TaskCompletionSource<List<Tournament>> taskCompletionSource = new TaskCompletionSource<>();
        Bundle bundle = new Bundle();
        AccessToken.Companion companion = AccessToken.Companion;
        AccessToken currentAccessToken = companion.getCurrentAccessToken();
        if (currentAccessToken != null && !currentAccessToken.isExpired()) {
            if (currentAccessToken.getGraphDomain() != null && IIX0o.Oxx0IOOO(FacebookSdk.GAMING, currentAccessToken.getGraphDomain())) {
                GraphRequest graphRequest = new GraphRequest(companion.getCurrentAccessToken(), "me/tournaments", bundle, HttpMethod.GET, new GraphRequest.Callback() { // from class: com.facebook.gamingservices.XO
                    @Override // com.facebook.GraphRequest.Callback
                    public final void onCompleted(GraphResponse graphResponse) {
                        TournamentFetcher.m192fetchTournaments$lambda1(TaskCompletionSource.this, graphResponse);
                    }
                }, null, 32, null);
                graphRequest.setParameters(bundle);
                graphRequest.executeAsync();
                return taskCompletionSource;
            }
            throw new FacebookException("User is not using gaming login");
        }
        throw new FacebookException("Attempted to fetch tournament with an invalid access token");
    }
}
