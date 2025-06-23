package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.facebook.FacebookRequestError;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class DaemonRequest {
    private Callback mCallback;
    private Context mContext;
    private SDKLogger mLogger;
    private JSONObject mParameters;
    private ConcurrentHashMap<String, CompletableFuture<GraphResponse>> mRequestStore;

    /* loaded from: classes8.dex */
    public interface Callback {
        void onCompleted(GraphResponse response);
    }

    public DaemonRequest(Context context, JSONObject parameters, Callback callback) {
        this.mContext = context;
        this.mParameters = parameters;
        this.mCallback = callback;
        this.mRequestStore = DaemonReceiver.getInstance(context).getRequestStore();
        this.mLogger = SDKLogger.getInstance(context);
    }

    private CompletableFuture<GraphResponse> createRequest() {
        CompletableFuture<GraphResponse> supplyAsync;
        supplyAsync = CompletableFuture.supplyAsync(new Supplier<GraphResponse>() { // from class: com.facebook.gamingservices.cloudgaming.DaemonRequest.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.function.Supplier
            public GraphResponse get() {
                Object obj;
                String uuid = UUID.randomUUID().toString();
                try {
                    DaemonRequest.this.mParameters.put(SDKConstants.REQUEST_ID, uuid);
                    Intent intent = new Intent();
                    String string = DaemonRequest.this.mParameters.getString("type");
                    DaemonRequest.this.mLogger.logPreparingRequest(string, uuid, DaemonRequest.this.mParameters);
                    if (!string.equals(SDKMessageEnum.GET_ACCESS_TOKEN.toString()) && !string.equals(SDKMessageEnum.IS_ENV_READY.toString())) {
                        String string2 = DaemonRequest.this.mContext.getSharedPreferences(SDKConstants.PREF_DAEMON_PACKAGE_NAME, 0).getString(SDKConstants.PARAM_DAEMON_PACKAGE_NAME, null);
                        if (string2 == null) {
                            return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request with a secure connection"), uuid);
                        }
                        intent.setPackage(string2);
                    }
                    intent.setAction(SDKConstants.REQUEST_ACTION);
                    Iterator<String> keys = DaemonRequest.this.mParameters.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        intent.putExtra(next, DaemonRequest.this.mParameters.getString(next));
                    }
                    II0XooXoX.oIX0oI();
                    CompletableFuture oIX0oI2 = Oxx0IOOO.oIX0oI();
                    DaemonRequest.this.mRequestStore.put(uuid, oIX0oI2);
                    DaemonRequest.this.mContext.sendBroadcast(intent);
                    DaemonRequest.this.mLogger.logSentRequest(string, uuid, DaemonRequest.this.mParameters);
                    obj = oIX0oI2.get();
                    return (GraphResponse) obj;
                } catch (InterruptedException | ExecutionException | JSONException unused) {
                    return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), uuid);
                }
            }
        });
        return supplyAsync;
    }

    private GraphResponse executeAndWait() throws ExecutionException, InterruptedException {
        Object obj;
        obj = createRequest().get();
        return (GraphResponse) obj;
    }

    private void executeAsync() throws ExecutionException, InterruptedException {
        createRequest().thenAccept((Consumer<? super GraphResponse>) new Consumer<GraphResponse>() { // from class: com.facebook.gamingservices.cloudgaming.DaemonRequest.1
            @Override // java.util.function.Consumer
            public void accept(GraphResponse response) {
                if (DaemonRequest.this.mCallback != null) {
                    DaemonRequest.this.mCallback.onCompleted(response);
                }
            }
        });
    }

    private GraphResponse executeAndWait(int timeout) throws ExecutionException, InterruptedException, TimeoutException {
        Object obj;
        obj = createRequest().get(timeout, TimeUnit.SECONDS);
        return (GraphResponse) obj;
    }

    public static GraphResponse executeAndWait(Context context, @Nullable JSONObject parameters, SDKMessageEnum type) {
        try {
            return new DaemonRequest(context, parameters == null ? new JSONObject().put("type", type.toString()) : parameters.put("type", type.toString()), null).executeAndWait();
        } catch (InterruptedException | ExecutionException | JSONException unused) {
            return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), (String) null);
        }
    }

    public static void executeAsync(Context context, @Nullable JSONObject parameters, Callback callback, SDKMessageEnum type) {
        try {
            new DaemonRequest(context, parameters == null ? new JSONObject().put("type", type.toString()) : parameters.put("type", type.toString()), callback).executeAsync();
        } catch (InterruptedException | ExecutionException | JSONException unused) {
            if (callback != null) {
                callback.onCompleted(DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), (String) null));
            }
        }
    }

    public static GraphResponse executeAndWait(Context context, @Nullable JSONObject parameters, SDKMessageEnum type, int timeout) {
        try {
            return new DaemonRequest(context, parameters == null ? new JSONObject().put("type", type.toString()) : parameters.put("type", type.toString()), null).executeAndWait(timeout);
        } catch (InterruptedException | ExecutionException | TimeoutException | JSONException unused) {
            return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), (String) null);
        }
    }

    public static void executeAsync(Context context, @Nullable JSONObject parameters, Callback callback, String type) {
        JSONObject put;
        try {
            if (parameters == null) {
                put = new JSONObject().put("type", type);
            } else {
                put = parameters.put("type", type);
            }
            new DaemonRequest(context, put, callback).executeAsync();
        } catch (InterruptedException | ExecutionException | JSONException unused) {
            if (callback != null) {
                callback.onCompleted(DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), (String) null));
            }
        }
    }
}
