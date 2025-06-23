package com.facebook.gamingservices;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.gamingservices.TournamentShareDialog;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@AutoHandleExceptions
/* loaded from: classes8.dex */
public final class TournamentShareDialog extends FacebookDialogBase<TournamentConfig, Result> {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final int defaultRequestCode = CallbackManagerImpl.RequestCodeOffset.TournamentShareDialog.toRequestCode();

    @oOoXoXO
    private Number score;

    @oOoXoXO
    private Tournament tournament;

    /* loaded from: classes8.dex */
    public final class AppSwitchHandler extends FacebookDialogBase<TournamentConfig, Result>.ModeHandler {
        final /* synthetic */ TournamentShareDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppSwitchHandler(TournamentShareDialog this$0) {
            super(this$0);
            IIX0o.x0xO0oo(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(@oOoXoXO TournamentConfig tournamentConfig, boolean z) {
            return true;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        @OOXIXo
        public AppCall createAppCall(@oOoXoXO TournamentConfig tournamentConfig) {
            Uri uriForUpdating$facebook_gamingservices_release;
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
            if (currentAccessToken != null && !currentAccessToken.isExpired()) {
                if (currentAccessToken.getGraphDomain() != null && !IIX0o.Oxx0IOOO(FacebookSdk.GAMING, currentAccessToken.getGraphDomain())) {
                    throw new FacebookException("Attempted to share tournament without without gaming login");
                }
                Number score = this.this$0.getScore();
                if (score != null) {
                    if (tournamentConfig != null) {
                        uriForUpdating$facebook_gamingservices_release = TournamentShareDialogURIBuilder.INSTANCE.uriForCreating$facebook_gamingservices_release(tournamentConfig, score, currentAccessToken.getApplicationId());
                    } else {
                        Tournament tournament = this.this$0.getTournament();
                        uriForUpdating$facebook_gamingservices_release = tournament == null ? null : TournamentShareDialogURIBuilder.INSTANCE.uriForUpdating$facebook_gamingservices_release(tournament.identifier, score, currentAccessToken.getApplicationId());
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", uriForUpdating$facebook_gamingservices_release);
                    TournamentShareDialog tournamentShareDialog = this.this$0;
                    tournamentShareDialog.startActivityForResult(intent, tournamentShareDialog.getRequestCode());
                    return createBaseAppCall;
                }
                throw new FacebookException("Attempted to share tournament without a score");
            }
            throw new FacebookException("Attempted to share tournament with an invalid access token");
        }
    }

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public final class FacebookAppHandler extends FacebookDialogBase<TournamentConfig, Result>.ModeHandler {
        final /* synthetic */ TournamentShareDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FacebookAppHandler(TournamentShareDialog this$0) {
            super(this$0);
            IIX0o.x0xO0oo(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(@oOoXoXO TournamentConfig tournamentConfig, boolean z) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            PackageManager packageManager = FacebookSdk.getApplicationContext().getPackageManager();
            IIX0o.oO(packageManager, "getApplicationContext().packageManager");
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType("text/plain");
            return intent.resolveActivity(packageManager) != null;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        @OOXIXo
        public AppCall createAppCall(@oOoXoXO TournamentConfig tournamentConfig) {
            Bundle bundleForUpdating$facebook_gamingservices_release;
            AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType("text/plain");
            if (currentAccessToken != null && !currentAccessToken.isExpired()) {
                if (currentAccessToken.getGraphDomain() != null && !IIX0o.Oxx0IOOO(FacebookSdk.GAMING, currentAccessToken.getGraphDomain())) {
                    throw new FacebookException("Attempted to share tournament while user is not gaming logged in");
                }
                String applicationId = currentAccessToken.getApplicationId();
                Number score = this.this$0.getScore();
                if (score != null) {
                    if (tournamentConfig != null) {
                        bundleForUpdating$facebook_gamingservices_release = TournamentShareDialogURIBuilder.INSTANCE.bundleForCreating$facebook_gamingservices_release(tournamentConfig, score, applicationId);
                    } else {
                        Tournament tournament = this.this$0.getTournament();
                        bundleForUpdating$facebook_gamingservices_release = tournament == null ? null : TournamentShareDialogURIBuilder.INSTANCE.bundleForUpdating$facebook_gamingservices_release(tournament.identifier, score, applicationId);
                    }
                    NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
                    NativeProtocol.setupProtocolRequestIntent(intent, createBaseAppCall.getCallId().toString(), "", NativeProtocol.PROTOCOL_VERSION_20210906, bundleForUpdating$facebook_gamingservices_release);
                    createBaseAppCall.setRequestIntent(intent);
                    return createBaseAppCall;
                }
                throw new FacebookException("Attempted to share tournament without a score");
            }
            throw new FacebookException("Attempted to share tournament with an invalid access token");
        }
    }

    /* loaded from: classes8.dex */
    public static final class Result {

        @oOoXoXO
        private String requestID;

        @oOoXoXO
        private String tournamentID;

        public Result(@OOXIXo Bundle results) {
            IIX0o.x0xO0oo(results, "results");
            if (results.getString("request") != null) {
                this.requestID = results.getString("request");
            }
            this.tournamentID = results.getString(SDKConstants.PARAM_TOURNAMENTS_ID);
        }

        @oOoXoXO
        public final String getRequestID() {
            return this.requestID;
        }

        @oOoXoXO
        public final String getTournamentID() {
            return this.tournamentID;
        }

        public final void setRequestID(@oOoXoXO String str) {
            this.requestID = str;
        }

        public final void setTournamentID(@oOoXoXO String str) {
            this.tournamentID = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TournamentShareDialog(@OOXIXo Activity activity) {
        super(activity, defaultRequestCode);
        IIX0o.x0xO0oo(activity, "activity");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registerCallbackImpl$lambda-0, reason: not valid java name */
    public static final boolean m193registerCallbackImpl$lambda0(TournamentShareDialog this$0, ResultProcessor resultProcessor, int i, Intent intent) {
        IIX0o.x0xO0oo(this$0, "this$0");
        ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
        return ShareInternalUtility.handleActivityResult(this$0.getRequestCode(), i, intent, resultProcessor);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    @OOXIXo
    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode(), null, 2, null);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    @OOXIXo
    public List<FacebookDialogBase<TournamentConfig, Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FacebookAppHandler(this));
        arrayList.add(new AppSwitchHandler(this));
        return arrayList;
    }

    @oOoXoXO
    public final Number getScore() {
        return this.score;
    }

    @oOoXoXO
    public final Tournament getTournament() {
        return this.tournament;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public void registerCallbackImpl(@OOXIXo CallbackManagerImpl callbackManager, @OOXIXo final FacebookCallback<Result> callback) {
        IIX0o.x0xO0oo(callbackManager, "callbackManager");
        IIX0o.x0xO0oo(callback, "callback");
        final ResultProcessor resultProcessor = new ResultProcessor(callback) { // from class: com.facebook.gamingservices.TournamentShareDialog$registerCallbackImpl$resultProcessor$1
            final /* synthetic */ FacebookCallback<TournamentShareDialog.Result> $callback;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(callback);
                this.$callback = callback;
            }

            @Override // com.facebook.share.internal.ResultProcessor
            public void onSuccess(@OOXIXo AppCall appCall, @oOoXoXO Bundle bundle) {
                IIX0o.x0xO0oo(appCall, "appCall");
                if (bundle != null) {
                    if (bundle.getString("error_message") != null) {
                        this.$callback.onError(new FacebookException(bundle.getString("error_message")));
                        return;
                    } else if (bundle.getString(SDKConstants.PARAM_TOURNAMENTS_ID) != null) {
                        this.$callback.onSuccess(new TournamentShareDialog.Result(bundle));
                        return;
                    }
                }
                onCancel(appCall);
            }
        };
        callbackManager.registerCallback(getRequestCode(), new CallbackManagerImpl.Callback() { // from class: com.facebook.gamingservices.Oxx0IOOO
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public final boolean onActivityResult(int i, Intent intent) {
                boolean m193registerCallbackImpl$lambda0;
                m193registerCallbackImpl$lambda0 = TournamentShareDialog.m193registerCallbackImpl$lambda0(TournamentShareDialog.this, resultProcessor, i, intent);
                return m193registerCallbackImpl$lambda0;
            }
        });
    }

    public final void setScore(@oOoXoXO Number number) {
        this.score = number;
    }

    public final void setTournament(@oOoXoXO Tournament tournament) {
        this.tournament = tournament;
    }

    public final void show(@OOXIXo Number score, @OOXIXo TournamentConfig newTournamentConfig) {
        IIX0o.x0xO0oo(score, "score");
        IIX0o.x0xO0oo(newTournamentConfig, "newTournamentConfig");
        this.score = score;
        showImpl(newTournamentConfig, FacebookDialogBase.BASE_AUTOMATIC_MODE);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TournamentShareDialog(@OOXIXo Fragment fragment) {
        this(new FragmentWrapper(fragment));
        IIX0o.x0xO0oo(fragment, "fragment");
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public void showImpl(@oOoXoXO TournamentConfig tournamentConfig, @OOXIXo Object mode) {
        IIX0o.x0xO0oo(mode, "mode");
        if (CloudGameLoginHandler.isRunningInCloud()) {
            return;
        }
        super.showImpl((TournamentShareDialog) tournamentConfig, mode);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TournamentShareDialog(@OOXIXo android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
        IIX0o.x0xO0oo(fragment, "fragment");
    }

    public final void show(@OOXIXo Number score, @OOXIXo Tournament tournament) {
        IIX0o.x0xO0oo(score, "score");
        IIX0o.x0xO0oo(tournament, "tournament");
        this.score = score;
        this.tournament = tournament;
        showImpl((TournamentConfig) null, FacebookDialogBase.BASE_AUTOMATIC_MODE);
    }

    private TournamentShareDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, defaultRequestCode);
    }
}
