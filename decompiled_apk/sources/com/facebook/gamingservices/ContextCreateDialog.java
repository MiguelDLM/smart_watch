package com.facebook.gamingservices;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import com.facebook.gamingservices.model.ContextCreateContent;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import com.huawei.openalliance.ad.constant.bn;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class ContextCreateDialog extends FacebookDialogBase<ContextCreateContent, Result> {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.GamingContextCreate.toRequestCode();

    @Nullable
    private FacebookCallback mCallback;

    /* loaded from: classes8.dex */
    public class FacebookAppHandler extends FacebookDialogBase<ContextCreateContent, Result>.ModeHandler {
        private FacebookAppHandler() {
            super(ContextCreateDialog.this);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(final ContextCreateContent content, boolean isBestEffort) {
            PackageManager packageManager = ContextCreateDialog.this.getActivityContext().getPackageManager();
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType("text/plain");
            boolean z = intent.resolveActivity(packageManager) != null;
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            return z && (currentAccessToken != null && currentAccessToken.getGraphDomain() != null && FacebookSdk.GAMING.equals(currentAccessToken.getGraphDomain()));
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(final ContextCreateContent content) {
            AppCall createBaseAppCall = ContextCreateDialog.this.createBaseAppCall();
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType("text/plain");
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            Bundle bundle = new Bundle();
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, "CONTEXT_CREATE");
            if (currentAccessToken != null) {
                bundle.putString("game_id", currentAccessToken.getApplicationId());
            } else {
                bundle.putString("game_id", FacebookSdk.getApplicationId());
            }
            if (content.getSuggestedPlayerID() != null) {
                bundle.putString("player_id", content.getSuggestedPlayerID());
            }
            NativeProtocol.setupProtocolRequestIntent(intent, createBaseAppCall.getCallId().toString(), "", NativeProtocol.getLatestKnownVersion(), bundle);
            createBaseAppCall.setRequestIntent(intent);
            return createBaseAppCall;
        }
    }

    /* loaded from: classes8.dex */
    public class WebHandler extends FacebookDialogBase<ContextCreateContent, Result>.ModeHandler {
        private WebHandler() {
            super(ContextCreateDialog.this);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(final ContextCreateContent content, boolean isBestEffort) {
            return true;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(final ContextCreateContent content) {
            AppCall createBaseAppCall = ContextCreateDialog.this.createBaseAppCall();
            Bundle bundle = new Bundle();
            bundle.putString("player_id", content.getSuggestedPlayerID());
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            if (currentAccessToken != null) {
                bundle.putString("dialog_access_token", currentAccessToken.getToken());
            }
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, bn.f.o, bundle);
            return createBaseAppCall;
        }
    }

    public ContextCreateDialog(final Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    private void showForCloud(final ContextCreateContent content, final Object mode) {
        Activity activityContext = getActivityContext();
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken != null && !currentAccessToken.isExpired()) {
            DaemonRequest.Callback callback = new DaemonRequest.Callback() { // from class: com.facebook.gamingservices.ContextCreateDialog.1
                @Override // com.facebook.gamingservices.cloudgaming.DaemonRequest.Callback
                public void onCompleted(GraphResponse response) {
                    if (ContextCreateDialog.this.mCallback != null) {
                        if (response.getError() != null) {
                            ContextCreateDialog.this.mCallback.onError(new FacebookException(response.getError().getErrorMessage()));
                        } else {
                            ContextCreateDialog.this.mCallback.onSuccess(new Result(response));
                        }
                    }
                }
            };
            JSONObject jSONObject = new JSONObject();
            try {
                if (content.getSuggestedPlayerID() != null) {
                    jSONObject.put("id", content.getSuggestedPlayerID());
                }
                DaemonRequest.executeAsync(activityContext, jSONObject, callback, SDKMessageEnum.CONTEXT_CREATE);
                return;
            } catch (JSONException unused) {
                FacebookCallback facebookCallback = this.mCallback;
                if (facebookCallback != null) {
                    facebookCallback.onError(new FacebookException("Couldn't prepare Context Create Dialog"));
                    return;
                }
                return;
            }
        }
        throw new FacebookException("Attempted to open ContextCreateContent with an invalid access token");
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public List<FacebookDialogBase<ContextCreateContent, Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FacebookAppHandler());
        arrayList.add(new WebHandler());
        return arrayList;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public void registerCallbackImpl(final CallbackManagerImpl callbackManager, final FacebookCallback<Result> callback) {
        final ResultProcessor resultProcessor;
        this.mCallback = callback;
        if (callback == null) {
            resultProcessor = null;
        } else {
            resultProcessor = new ResultProcessor(callback) { // from class: com.facebook.gamingservices.ContextCreateDialog.2
                @Override // com.facebook.share.internal.ResultProcessor
                public void onSuccess(AppCall appCall, Bundle results) {
                    if (results != null) {
                        if (results.getString("error_message") != null) {
                            callback.onError(new FacebookException(results.getString("error_message")));
                            return;
                        }
                        if (results.getString("id") != null) {
                            GamingContext.setCurrentGamingContext(new GamingContext(results.getString("id")));
                            callback.onSuccess(new Result(results.getString("id")));
                        } else if (results.getString(SDKConstants.PARAM_CONTEXT_CONTEXT_ID) != null) {
                            GamingContext.setCurrentGamingContext(new GamingContext(results.getString(SDKConstants.PARAM_CONTEXT_CONTEXT_ID)));
                            callback.onSuccess(new Result(results.getString(SDKConstants.PARAM_CONTEXT_CONTEXT_ID)));
                        }
                        callback.onError(new FacebookException(results.getString("Invalid response received from server.")));
                        return;
                    }
                    onCancel(appCall);
                }
            };
        }
        callbackManager.registerCallback(getRequestCode(), new CallbackManagerImpl.Callback() { // from class: com.facebook.gamingservices.ContextCreateDialog.3
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public boolean onActivityResult(int resultCode, Intent data) {
                return ShareInternalUtility.handleActivityResult(ContextCreateDialog.this.getRequestCode(), resultCode, data, resultProcessor);
            }
        });
    }

    /* loaded from: classes8.dex */
    public static final class Result {

        @Nullable
        String contextID;

        @Nullable
        public String getContextID() {
            return this.contextID;
        }

        private Result(String contextID) {
            this.contextID = contextID;
        }

        private Result(GraphResponse response) {
            try {
                JSONObject jSONObject = response.getJSONObject();
                if (jSONObject == null) {
                    this.contextID = null;
                } else {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    this.contextID = optJSONObject != null ? optJSONObject.getString("id") : null;
                }
            } catch (JSONException unused) {
                this.contextID = null;
            }
        }
    }

    public ContextCreateDialog(final Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    @Override // com.facebook.internal.FacebookDialogBase, com.facebook.FacebookDialog
    public boolean canShow(ContextCreateContent content) {
        if (CloudGameLoginHandler.isRunningInCloud()) {
            return true;
        }
        return new FacebookAppHandler().canShow(content, true) || new WebHandler().canShow(content, true);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public void showImpl(final ContextCreateContent content, final Object mode) {
        if (CloudGameLoginHandler.isRunningInCloud()) {
            showForCloud(content, mode);
        } else {
            super.showImpl((ContextCreateDialog) content, mode);
        }
    }

    public ContextCreateDialog(final android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    private ContextCreateDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
    }
}
