package com.facebook.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import com.facebook.CallbackManager;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.NativeProtocol;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.oXIO0o0XI;

/* loaded from: classes8.dex */
public final class DialogPresenter {

    @OXOo.OOXIXo
    public static final DialogPresenter INSTANCE = new DialogPresenter();

    /* loaded from: classes8.dex */
    public interface ParameterProvider {
        @OXOo.oOoXoXO
        Bundle getLegacyParameters();

        @OXOo.oOoXoXO
        Bundle getParameters();
    }

    private DialogPresenter() {
    }

    @XO0OX.x0XOIxOo
    public static final boolean canPresentNativeDialogWithFeature(@OXOo.OOXIXo DialogFeature feature) {
        IIX0o.x0xO0oo(feature, "feature");
        if (getProtocolVersionForNativeDialog(feature).getProtocolVersion() != -1) {
            return true;
        }
        return false;
    }

    @XO0OX.x0XOIxOo
    public static final boolean canPresentWebFallbackDialogWithFeature(@OXOo.OOXIXo DialogFeature feature) {
        IIX0o.x0xO0oo(feature, "feature");
        if (INSTANCE.getDialogWebFallbackUri(feature) != null) {
            return true;
        }
        return false;
    }

    private final Uri getDialogWebFallbackUri(DialogFeature dialogFeature) {
        String name = dialogFeature.name();
        String action = dialogFeature.getAction();
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        FetchedAppSettings.DialogFeatureConfig dialogFeatureConfig = FetchedAppSettings.Companion.getDialogFeatureConfig(FacebookSdk.getApplicationId(), action, name);
        if (dialogFeatureConfig != null) {
            return dialogFeatureConfig.getFallbackUrl();
        }
        return null;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final NativeProtocol.ProtocolVersionQueryResult getProtocolVersionForNativeDialog(@OXOo.OOXIXo DialogFeature feature) {
        IIX0o.x0xO0oo(feature, "feature");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        String action = feature.getAction();
        int[] versionSpecForFeature = INSTANCE.getVersionSpecForFeature(applicationId, action, feature);
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        return NativeProtocol.getLatestAvailableProtocolVersionForAction(action, versionSpecForFeature);
    }

    private final int[] getVersionSpecForFeature(String str, String str2, DialogFeature dialogFeature) {
        int[] versionSpec;
        FetchedAppSettings.DialogFeatureConfig dialogFeatureConfig = FetchedAppSettings.Companion.getDialogFeatureConfig(str, str2, dialogFeature.name());
        if (dialogFeatureConfig == null) {
            versionSpec = null;
        } else {
            versionSpec = dialogFeatureConfig.getVersionSpec();
        }
        if (versionSpec == null) {
            return new int[]{dialogFeature.getMinVersion()};
        }
        return versionSpec;
    }

    @XO0OX.x0XOIxOo
    public static final void logDialogActivity(@OXOo.OOXIXo Context context, @OXOo.OOXIXo String eventName, @OXOo.OOXIXo String outcome) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(eventName, "eventName");
        IIX0o.x0xO0oo(outcome, "outcome");
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(context);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME, outcome);
        internalAppEventsLogger.logEventImplicitly(eventName, bundle);
    }

    @XO0OX.x0XOIxOo
    public static final void present(@OXOo.OOXIXo AppCall appCall, @OXOo.OOXIXo Activity activity) {
        IIX0o.x0xO0oo(appCall, "appCall");
        IIX0o.x0xO0oo(activity, "activity");
        activity.startActivityForResult(appCall.getRequestIntent(), appCall.getRequestCode());
        appCall.setPending();
    }

    @XO0OX.x0XOIxOo
    public static final void setupAppCallForCannotShowError(@OXOo.OOXIXo AppCall appCall) {
        IIX0o.x0xO0oo(appCall, "appCall");
        setupAppCallForValidationError(appCall, new FacebookException("Unable to show the provided content via the web or the installed version of the Facebook app. Some dialogs are only supported starting API 14."));
    }

    @XO0OX.x0XOIxOo
    public static final void setupAppCallForCustomTabDialog(@OXOo.OOXIXo AppCall appCall, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(appCall, "appCall");
        Validate validate = Validate.INSTANCE;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        CustomTabUtils customTabUtils = CustomTabUtils.INSTANCE;
        Validate.hasCustomTabRedirectActivity(applicationContext, CustomTabUtils.getDefaultRedirectURI());
        Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), (Class<?>) CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.EXTRA_ACTION, str);
        intent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, bundle);
        intent.putExtra(CustomTabMainActivity.EXTRA_CHROME_PACKAGE, CustomTabUtils.getChromePackage());
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        NativeProtocol.setupProtocolRequestIntent(intent, appCall.getCallId().toString(), str, NativeProtocol.getLatestKnownVersion(), null);
        appCall.setRequestIntent(intent);
    }

    @XO0OX.x0XOIxOo
    public static final void setupAppCallForErrorResult(@OXOo.OOXIXo AppCall appCall, @OXOo.oOoXoXO FacebookException facebookException) {
        IIX0o.x0xO0oo(appCall, "appCall");
        if (facebookException == null) {
            return;
        }
        Validate validate = Validate.INSTANCE;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(FacebookActivity.PASS_THROUGH_CANCEL_ACTION);
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        NativeProtocol.setupProtocolRequestIntent(intent, appCall.getCallId().toString(), null, NativeProtocol.getLatestKnownVersion(), NativeProtocol.createBundleForException(facebookException));
        appCall.setRequestIntent(intent);
    }

    @XO0OX.x0XOIxOo
    public static final void setupAppCallForNativeDialog(@OXOo.OOXIXo AppCall appCall, @OXOo.OOXIXo ParameterProvider parameterProvider, @OXOo.OOXIXo DialogFeature feature) {
        Bundle legacyParameters;
        IIX0o.x0xO0oo(appCall, "appCall");
        IIX0o.x0xO0oo(parameterProvider, "parameterProvider");
        IIX0o.x0xO0oo(feature, "feature");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        String action = feature.getAction();
        NativeProtocol.ProtocolVersionQueryResult protocolVersionForNativeDialog = getProtocolVersionForNativeDialog(feature);
        int protocolVersion = protocolVersionForNativeDialog.getProtocolVersion();
        if (protocolVersion != -1) {
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            if (NativeProtocol.isVersionCompatibleWithBucketedIntent(protocolVersion)) {
                legacyParameters = parameterProvider.getParameters();
            } else {
                legacyParameters = parameterProvider.getLegacyParameters();
            }
            if (legacyParameters == null) {
                legacyParameters = new Bundle();
            }
            Intent createPlatformActivityIntent = NativeProtocol.createPlatformActivityIntent(applicationContext, appCall.getCallId().toString(), action, protocolVersionForNativeDialog, legacyParameters);
            if (createPlatformActivityIntent != null) {
                appCall.setRequestIntent(createPlatformActivityIntent);
                return;
            }
            throw new FacebookException("Unable to create Intent; this likely means theFacebook app is not installed.");
        }
        throw new FacebookException("Cannot present this dialog. This likely means that the Facebook app is not installed.");
    }

    @XO0OX.x0XOIxOo
    public static final void setupAppCallForValidationError(@OXOo.OOXIXo AppCall appCall, @OXOo.oOoXoXO FacebookException facebookException) {
        IIX0o.x0xO0oo(appCall, "appCall");
        setupAppCallForErrorResult(appCall, facebookException);
    }

    @XO0OX.x0XOIxOo
    public static final void setupAppCallForWebDialog(@OXOo.OOXIXo AppCall appCall, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(appCall, "appCall");
        Validate validate = Validate.INSTANCE;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
        Bundle bundle2 = new Bundle();
        bundle2.putString("action", str);
        bundle2.putBundle(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
        Intent intent = new Intent();
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        NativeProtocol.setupProtocolRequestIntent(intent, appCall.getCallId().toString(), str, NativeProtocol.getLatestKnownVersion(), bundle2);
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(FacebookDialogFragment.TAG);
        appCall.setRequestIntent(intent);
    }

    @XO0OX.x0XOIxOo
    public static final void setupAppCallForWebFallbackDialog(@OXOo.OOXIXo AppCall appCall, @OXOo.oOoXoXO Bundle bundle, @OXOo.OOXIXo DialogFeature feature) {
        Uri buildUri;
        IIX0o.x0xO0oo(appCall, "appCall");
        IIX0o.x0xO0oo(feature, "feature");
        Validate validate = Validate.INSTANCE;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
        String name = feature.name();
        Uri dialogWebFallbackUri = INSTANCE.getDialogWebFallbackUri(feature);
        if (dialogWebFallbackUri != null) {
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            int latestKnownVersion = NativeProtocol.getLatestKnownVersion();
            ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
            String uuid = appCall.getCallId().toString();
            IIX0o.oO(uuid, "appCall.callId.toString()");
            Bundle queryParamsForPlatformActivityIntentWebFallback = ServerProtocol.getQueryParamsForPlatformActivityIntentWebFallback(uuid, latestKnownVersion, bundle);
            if (queryParamsForPlatformActivityIntentWebFallback != null) {
                if (dialogWebFallbackUri.isRelative()) {
                    Utility utility = Utility.INSTANCE;
                    buildUri = Utility.buildUri(ServerProtocol.getDialogAuthority(), dialogWebFallbackUri.toString(), queryParamsForPlatformActivityIntentWebFallback);
                } else {
                    Utility utility2 = Utility.INSTANCE;
                    buildUri = Utility.buildUri(dialogWebFallbackUri.getAuthority(), dialogWebFallbackUri.getPath(), queryParamsForPlatformActivityIntentWebFallback);
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("url", buildUri.toString());
                bundle2.putBoolean(NativeProtocol.WEB_DIALOG_IS_FALLBACK, true);
                Intent intent = new Intent();
                NativeProtocol.setupProtocolRequestIntent(intent, appCall.getCallId().toString(), feature.getAction(), NativeProtocol.getLatestKnownVersion(), bundle2);
                intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
                intent.setAction(FacebookDialogFragment.TAG);
                appCall.setRequestIntent(intent);
                return;
            }
            throw new FacebookException("Unable to fetch the app's key-hash");
        }
        throw new FacebookException("Unable to fetch the Url for the DialogFeature : '" + name + '\'');
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [T, androidx.activity.result.ActivityResultLauncher] */
    @XO0OX.x0XOIxOo
    public static final void startActivityForResultWithAndroidX(@OXOo.OOXIXo ActivityResultRegistry registry, @OXOo.oOoXoXO final CallbackManager callbackManager, @OXOo.OOXIXo Intent intent, final int i) {
        IIX0o.x0xO0oo(registry, "registry");
        IIX0o.x0xO0oo(intent, "intent");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? register = registry.register(IIX0o.XIxXXX0x0("facebook-dialog-request-", Integer.valueOf(i)), new ActivityResultContract<Intent, Pair<Integer, Intent>>() { // from class: com.facebook.internal.DialogPresenter$startActivityForResultWithAndroidX$1
            @Override // androidx.activity.result.contract.ActivityResultContract
            @OXOo.OOXIXo
            public Intent createIntent(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Intent input) {
                IIX0o.x0xO0oo(context, "context");
                IIX0o.x0xO0oo(input, "input");
                return input;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.activity.result.contract.ActivityResultContract
            @OXOo.OOXIXo
            public Pair<Integer, Intent> parseResult(int i2, @OXOo.oOoXoXO Intent intent2) {
                Pair<Integer, Intent> create = Pair.create(Integer.valueOf(i2), intent2);
                IIX0o.oO(create, "create(resultCode, intent)");
                return create;
            }
        }, new ActivityResultCallback() { // from class: com.facebook.internal.oIX0oI
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                DialogPresenter.m195startActivityForResultWithAndroidX$lambda2(CallbackManager.this, i, objectRef, (Pair) obj);
            }
        });
        objectRef.element = register;
        if (register != 0) {
            register.launch(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: startActivityForResultWithAndroidX$lambda-2, reason: not valid java name */
    public static final void m195startActivityForResultWithAndroidX$lambda2(CallbackManager callbackManager, int i, Ref.ObjectRef launcher, Pair pair) {
        IIX0o.x0xO0oo(launcher, "$launcher");
        if (callbackManager == null) {
            callbackManager = new CallbackManagerImpl();
        }
        Object obj = pair.first;
        IIX0o.oO(obj, "result.first");
        callbackManager.onActivityResult(i, ((Number) obj).intValue(), (Intent) pair.second);
        ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) launcher.element;
        if (activityResultLauncher != null) {
            synchronized (activityResultLauncher) {
                activityResultLauncher.unregister();
                launcher.element = null;
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            }
        }
    }

    @XO0OX.x0XOIxOo
    public static final void present(@OXOo.OOXIXo AppCall appCall, @OXOo.OOXIXo FragmentWrapper fragmentWrapper) {
        IIX0o.x0xO0oo(appCall, "appCall");
        IIX0o.x0xO0oo(fragmentWrapper, "fragmentWrapper");
        fragmentWrapper.startActivityForResult(appCall.getRequestIntent(), appCall.getRequestCode());
        appCall.setPending();
    }

    @XO0OX.x0XOIxOo
    public static final void present(@OXOo.OOXIXo AppCall appCall, @OXOo.OOXIXo ActivityResultRegistry registry, @OXOo.oOoXoXO CallbackManager callbackManager) {
        IIX0o.x0xO0oo(appCall, "appCall");
        IIX0o.x0xO0oo(registry, "registry");
        Intent requestIntent = appCall.getRequestIntent();
        if (requestIntent == null) {
            return;
        }
        startActivityForResultWithAndroidX(registry, callbackManager, requestIntent, appCall.getRequestCode());
        appCall.setPending();
    }
}
