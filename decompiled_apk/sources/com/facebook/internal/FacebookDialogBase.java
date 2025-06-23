package com.facebook.internal;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.VisibleForTesting;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookDialog;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public abstract class FacebookDialogBase<CONTENT, RESULT> implements FacebookDialog<CONTENT, RESULT> {

    @OXOo.OOXIXo
    private static final String TAG = "FacebookDialog";

    @OXOo.oOoXoXO
    private final Activity activity;

    @OXOo.oOoXoXO
    private CallbackManager callbackManager;

    @OXOo.oOoXoXO
    private final FragmentWrapper fragmentWrapper;

    @OXOo.oOoXoXO
    private List<? extends FacebookDialogBase<CONTENT, RESULT>.ModeHandler> modeHandlers;
    private int requestCodeField;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final Object BASE_AUTOMATIC_MODE = new Object();

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public abstract class ModeHandler {

        @OXOo.OOXIXo
        private Object mode;
        final /* synthetic */ FacebookDialogBase<CONTENT, RESULT> this$0;

        public ModeHandler(FacebookDialogBase this$0) {
            IIX0o.x0xO0oo(this$0, "this$0");
            this.this$0 = this$0;
            this.mode = FacebookDialogBase.BASE_AUTOMATIC_MODE;
        }

        public abstract boolean canShow(CONTENT content, boolean z);

        @OXOo.oOoXoXO
        public abstract AppCall createAppCall(CONTENT content);

        @OXOo.OOXIXo
        public Object getMode() {
            return this.mode;
        }

        public void setMode(@OXOo.OOXIXo Object obj) {
            IIX0o.x0xO0oo(obj, "<set-?>");
            this.mode = obj;
        }
    }

    public FacebookDialogBase(@OXOo.OOXIXo Activity activity, int i) {
        IIX0o.x0xO0oo(activity, "activity");
        this.activity = activity;
        this.fragmentWrapper = null;
        this.requestCodeField = i;
        this.callbackManager = null;
    }

    private final List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> cachedModeHandlers() {
        if (this.modeHandlers == null) {
            this.modeHandlers = getOrderedModeHandlers();
        }
        List<? extends FacebookDialogBase<CONTENT, RESULT>.ModeHandler> list = this.modeHandlers;
        if (list != null) {
            return list;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.facebook.internal.FacebookDialogBase.ModeHandler<CONTENT of com.facebook.internal.FacebookDialogBase, RESULT of com.facebook.internal.FacebookDialogBase>>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppCall createAppCallForMode(CONTENT content, Object obj) {
        boolean z;
        AppCall appCall;
        if (obj == BASE_AUTOMATIC_MODE) {
            z = true;
        } else {
            z = false;
        }
        Iterator<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> it = cachedModeHandlers().iterator();
        while (true) {
            if (it.hasNext()) {
                FacebookDialogBase<CONTENT, RESULT>.ModeHandler next = it.next();
                if (!z) {
                    Utility utility = Utility.INSTANCE;
                    if (!Utility.areObjectsEqual(next.getMode(), obj)) {
                        continue;
                    }
                }
                if (next.canShow(content, true)) {
                    try {
                        appCall = next.createAppCall(content);
                        break;
                    } catch (FacebookException e) {
                        AppCall createBaseAppCall = createBaseAppCall();
                        DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
                        DialogPresenter.setupAppCallForValidationError(createBaseAppCall, e);
                        appCall = createBaseAppCall;
                    }
                }
            } else {
                appCall = null;
                break;
            }
        }
        if (appCall == null) {
            AppCall createBaseAppCall2 = createBaseAppCall();
            DialogPresenter dialogPresenter2 = DialogPresenter.INSTANCE;
            DialogPresenter.setupAppCallForCannotShowError(createBaseAppCall2);
            return createBaseAppCall2;
        }
        return appCall;
    }

    private final void memorizeCallbackManager(CallbackManager callbackManager) {
        CallbackManager callbackManager2 = this.callbackManager;
        if (callbackManager2 == null) {
            this.callbackManager = callbackManager;
        } else if (callbackManager2 != callbackManager) {
            Log.w(TAG, "You're registering a callback on a Facebook dialog with two different callback managers. It's almost wrong and may cause unexpected results. Only the first callback manager will be used for handling activity result with androidx.");
        }
    }

    @Override // com.facebook.FacebookDialog
    public boolean canShow(CONTENT content) {
        return canShowImpl(content, BASE_AUTOMATIC_MODE);
    }

    public boolean canShowImpl(CONTENT content, @OXOo.OOXIXo Object mode) {
        boolean z;
        IIX0o.x0xO0oo(mode, "mode");
        if (mode == BASE_AUTOMATIC_MODE) {
            z = true;
        } else {
            z = false;
        }
        for (FacebookDialogBase<CONTENT, RESULT>.ModeHandler modeHandler : cachedModeHandlers()) {
            if (!z) {
                Utility utility = Utility.INSTANCE;
                if (!Utility.areObjectsEqual(modeHandler.getMode(), mode)) {
                    continue;
                }
            }
            if (modeHandler.canShow(content, false)) {
                return true;
            }
        }
        return false;
    }

    @OXOo.OOXIXo
    public final ActivityResultContract<CONTENT, CallbackManager.ActivityResultParameters> createActivityResultContractForShowingDialog(@OXOo.oOoXoXO final CallbackManager callbackManager, @OXOo.OOXIXo final Object mode) {
        IIX0o.x0xO0oo(mode, "mode");
        return new ActivityResultContract<CONTENT, CallbackManager.ActivityResultParameters>(this) { // from class: com.facebook.internal.FacebookDialogBase$createActivityResultContractForShowingDialog$1
            final /* synthetic */ FacebookDialogBase<CONTENT, RESULT> this$0;

            {
                this.this$0 = this;
            }

            @Override // androidx.activity.result.contract.ActivityResultContract
            @OXOo.OOXIXo
            public Intent createIntent(@OXOo.OOXIXo Context context, CONTENT content) {
                AppCall createAppCallForMode;
                Intent requestIntent;
                IIX0o.x0xO0oo(context, "context");
                createAppCallForMode = this.this$0.createAppCallForMode(content, mode);
                if (createAppCallForMode == null) {
                    requestIntent = null;
                } else {
                    requestIntent = createAppCallForMode.getRequestIntent();
                }
                if (requestIntent != null) {
                    createAppCallForMode.setPending();
                    return requestIntent;
                }
                throw new FacebookException("Content " + content + " is not supported");
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.activity.result.contract.ActivityResultContract
            @OXOo.OOXIXo
            public CallbackManager.ActivityResultParameters parseResult(int i, @OXOo.oOoXoXO Intent intent) {
                CallbackManager callbackManager2 = callbackManager;
                if (callbackManager2 != null) {
                    callbackManager2.onActivityResult(this.this$0.getRequestCode(), i, intent);
                }
                return new CallbackManager.ActivityResultParameters(this.this$0.getRequestCode(), i, intent);
            }
        };
    }

    @OXOo.OOXIXo
    public abstract AppCall createBaseAppCall();

    @OXOo.oOoXoXO
    public final Activity getActivityContext() {
        Activity activity = this.activity;
        if (activity == null) {
            FragmentWrapper fragmentWrapper = this.fragmentWrapper;
            if (fragmentWrapper == null) {
                return null;
            }
            return fragmentWrapper.getActivity();
        }
        return activity;
    }

    @OXOo.oOoXoXO
    @VisibleForTesting(otherwise = 2)
    public final CallbackManager getCallbackManager$facebook_common_release() {
        return this.callbackManager;
    }

    @OXOo.OOXIXo
    public abstract List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> getOrderedModeHandlers();

    public final int getRequestCode() {
        return this.requestCodeField;
    }

    @Override // com.facebook.FacebookDialog
    public void registerCallback(@OXOo.OOXIXo CallbackManager callbackManager, @OXOo.OOXIXo FacebookCallback<RESULT> callback) {
        IIX0o.x0xO0oo(callbackManager, "callbackManager");
        IIX0o.x0xO0oo(callback, "callback");
        if (callbackManager instanceof CallbackManagerImpl) {
            memorizeCallbackManager(callbackManager);
            registerCallbackImpl((CallbackManagerImpl) callbackManager, callback);
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public abstract void registerCallbackImpl(@OXOo.OOXIXo CallbackManagerImpl callbackManagerImpl, @OXOo.OOXIXo FacebookCallback<RESULT> facebookCallback);

    public final void setCallbackManager(@OXOo.oOoXoXO CallbackManager callbackManager) {
        this.callbackManager = callbackManager;
    }

    public final void setCallbackManager$facebook_common_release(@OXOo.oOoXoXO CallbackManager callbackManager) {
        this.callbackManager = callbackManager;
    }

    public final void setRequestCode(int i) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (!FacebookSdk.isFacebookRequestCode(i)) {
            this.requestCodeField = i;
            return;
        }
        throw new IllegalArgumentException(("Request code " + i + " cannot be within the range reserved by the Facebook SDK.").toString());
    }

    @Override // com.facebook.FacebookDialog
    public void show(CONTENT content) {
        showImpl(content, BASE_AUTOMATIC_MODE);
    }

    public void showImpl(CONTENT content, @OXOo.OOXIXo Object mode) {
        IIX0o.x0xO0oo(mode, "mode");
        AppCall createAppCallForMode = createAppCallForMode(content, mode);
        if (createAppCallForMode != null) {
            if (getActivityContext() instanceof ActivityResultRegistryOwner) {
                ComponentCallbacks2 activityContext = getActivityContext();
                if (activityContext != null) {
                    DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
                    ActivityResultRegistry activityResultRegistry = ((ActivityResultRegistryOwner) activityContext).getActivityResultRegistry();
                    IIX0o.oO(activityResultRegistry, "registryOwner.activityResultRegistry");
                    DialogPresenter.present(createAppCallForMode, activityResultRegistry, this.callbackManager);
                    createAppCallForMode.setPending();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.activity.result.ActivityResultRegistryOwner");
            }
            FragmentWrapper fragmentWrapper = this.fragmentWrapper;
            if (fragmentWrapper != null) {
                DialogPresenter dialogPresenter2 = DialogPresenter.INSTANCE;
                DialogPresenter.present(createAppCallForMode, fragmentWrapper);
                return;
            }
            Activity activity = this.activity;
            if (activity != null) {
                DialogPresenter dialogPresenter3 = DialogPresenter.INSTANCE;
                DialogPresenter.present(createAppCallForMode, activity);
                return;
            }
            return;
        }
        Log.e(TAG, "No code path should ever result in a null appCall");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (!FacebookSdk.isDebugEnabled()) {
        } else {
            throw new IllegalStateException("No code path should ever result in a null appCall");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void startActivityForResult(@OXOo.OOXIXo android.content.Intent r4, int r5) {
        /*
            r3 = this;
            java.lang.String r0 = "intent"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
            android.app.Activity r0 = r3.getActivityContext()
            boolean r1 = r0 instanceof androidx.activity.result.ActivityResultRegistryOwner
            if (r1 == 0) goto L20
            com.facebook.internal.DialogPresenter r1 = com.facebook.internal.DialogPresenter.INSTANCE
            androidx.activity.result.ActivityResultRegistryOwner r0 = (androidx.activity.result.ActivityResultRegistryOwner) r0
            androidx.activity.result.ActivityResultRegistry r0 = r0.getActivityResultRegistry()
            java.lang.String r1 = "activity as ActivityResultRegistryOwner).activityResultRegistry"
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            com.facebook.CallbackManager r1 = r3.callbackManager
            com.facebook.internal.DialogPresenter.startActivityForResultWithAndroidX(r0, r1, r4, r5)
            goto L2d
        L20:
            if (r0 == 0) goto L26
            r0.startActivityForResult(r4, r5)
            goto L2d
        L26:
            com.facebook.internal.FragmentWrapper r0 = r3.fragmentWrapper
            if (r0 == 0) goto L2f
            r0.startActivityForResult(r4, r5)
        L2d:
            r4 = 0
            goto L31
        L2f:
            java.lang.String r4 = "Failed to find Activity or Fragment to startActivityForResult "
        L31:
            if (r4 == 0) goto L48
            com.facebook.internal.Logger$Companion r5 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r0 = com.facebook.LoggingBehavior.DEVELOPER_ERRORS
            java.lang.Class r1 = r3.getClass()
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "this.javaClass.name"
            kotlin.jvm.internal.IIX0o.oO(r1, r2)
            r2 = 6
            r5.log(r0, r2, r1, r4)
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FacebookDialogBase.startActivityForResult(android.content.Intent, int):void");
    }

    @Override // com.facebook.FacebookDialog
    @OXOo.OOXIXo
    public ActivityResultContract<CONTENT, CallbackManager.ActivityResultParameters> createActivityResultContractForShowingDialog(@OXOo.oOoXoXO CallbackManager callbackManager) {
        return createActivityResultContractForShowingDialog(callbackManager, BASE_AUTOMATIC_MODE);
    }

    @Override // com.facebook.FacebookDialog
    public void registerCallback(@OXOo.OOXIXo CallbackManager callbackManager, @OXOo.OOXIXo FacebookCallback<RESULT> callback, int i) {
        IIX0o.x0xO0oo(callbackManager, "callbackManager");
        IIX0o.x0xO0oo(callback, "callback");
        memorizeCallbackManager(callbackManager);
        setRequestCode(i);
        registerCallback(callbackManager, callback);
    }

    public FacebookDialogBase(@OXOo.OOXIXo FragmentWrapper fragmentWrapper, int i) {
        IIX0o.x0xO0oo(fragmentWrapper, "fragmentWrapper");
        this.fragmentWrapper = fragmentWrapper;
        this.activity = null;
        this.requestCodeField = i;
        if (fragmentWrapper.getActivity() == null) {
            throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity");
        }
    }

    public FacebookDialogBase(int i) {
        this.requestCodeField = i;
        this.activity = null;
        this.fragmentWrapper = null;
    }
}
