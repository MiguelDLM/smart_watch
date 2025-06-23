package com.facebook.login.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.LoginTargetApp;
import com.facebook.login.R;
import com.facebook.login.widget.ToolTipPopup;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* loaded from: classes8.dex */
public class LoginButton extends FacebookButtonBase {
    private static final int MAX_BUTTON_TRANSPARENCY = 255;
    private static final int MIN_BUTTON_TRANSPARENCY = 0;
    private static final String TAG = "com.facebook.login.widget.LoginButton";
    private AccessTokenTracker accessTokenTracker;

    @Nullable
    private ActivityResultLauncher<Collection<? extends String>> androidXLoginCaller;

    @Nullable
    private CallbackManager callbackManager;
    private boolean confirmLogout;
    private Float customButtonRadius;
    private int customButtonTransparency;
    private final String loggerID;
    private String loginLogoutEventName;
    private LoginManager loginManager;
    private String loginText;
    private String logoutText;
    protected LoginButtonProperties properties;
    private boolean toolTipChecked;
    private long toolTipDisplayTime;
    private ToolTipMode toolTipMode;
    private ToolTipPopup toolTipPopup;
    private ToolTipPopup.Style toolTipStyle;

    /* renamed from: com.facebook.login.widget.LoginButton$4, reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode;

        static {
            int[] iArr = new int[ToolTipMode.values().length];
            $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode = iArr;
            try {
                iArr[ToolTipMode.AUTOMATIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode[ToolTipMode.DISPLAY_ALWAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode[ToolTipMode.NEVER_DISPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class LoginButtonProperties {

        @Nullable
        private String messengerPageId;
        private boolean resetMessengerState;
        private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
        private List<String> permissions = Collections.emptyList();
        private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
        private String authType = ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE;
        private LoginTargetApp targetApp = LoginTargetApp.FACEBOOK;
        private boolean shouldSkipAccountDeduplication = false;

        public void clearPermissions() {
            this.permissions = null;
        }

        public String getAuthType() {
            return this.authType;
        }

        public DefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        public LoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        public LoginTargetApp getLoginTargetApp() {
            return this.targetApp;
        }

        @Nullable
        public String getMessengerPageId() {
            return this.messengerPageId;
        }

        public List<String> getPermissions() {
            return this.permissions;
        }

        public boolean getResetMessengerState() {
            return this.resetMessengerState;
        }

        public boolean getShouldSkipAccountDeduplication() {
            return this.shouldSkipAccountDeduplication;
        }

        public void setAuthType(final String authType) {
            this.authType = authType;
        }

        public void setDefaultAudience(DefaultAudience defaultAudience) {
            this.defaultAudience = defaultAudience;
        }

        public void setLoginBehavior(LoginBehavior loginBehavior) {
            this.loginBehavior = loginBehavior;
        }

        public void setLoginTargetApp(LoginTargetApp targetApp) {
            this.targetApp = targetApp;
        }

        public void setMessengerPageId(@Nullable final String pageId) {
            this.messengerPageId = pageId;
        }

        public void setPermissions(List<String> permissions) {
            this.permissions = permissions;
        }

        public void setResetMessengerState(final boolean resetMessengerState) {
            this.resetMessengerState = resetMessengerState;
        }

        public void setShouldSkipAccountDeduplication(boolean shouldSkip) {
            this.shouldSkipAccountDeduplication = shouldSkip;
        }
    }

    /* loaded from: classes8.dex */
    public class LoginClickListener implements View.OnClickListener {
        public LoginClickListener() {
        }

        public LoginManager getLoginManager() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                LoginManager loginManager = LoginManager.getInstance();
                loginManager.setDefaultAudience(LoginButton.this.getDefaultAudience());
                loginManager.setLoginBehavior(LoginButton.this.getLoginBehavior());
                loginManager.setLoginTargetApp(getLoginTargetApp());
                loginManager.setAuthType(LoginButton.this.getAuthType());
                loginManager.setFamilyLogin(isFamilyLogin());
                loginManager.setShouldSkipAccountDeduplication(LoginButton.this.getShouldSkipAccountDeduplication());
                loginManager.setMessengerPageId(LoginButton.this.getMessengerPageId());
                loginManager.setResetMessengerState(LoginButton.this.getResetMessengerState());
                return loginManager;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        public LoginTargetApp getLoginTargetApp() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                return LoginTargetApp.FACEBOOK;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        public boolean isFamilyLogin() {
            CrashShieldHandler.isObjectCrashing(this);
            return false;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    LoginButton.this.callExternalOnClickListener(view);
                    AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                    if (AccessToken.isCurrentAccessTokenActive()) {
                        performLogout(LoginButton.this.getContext());
                    } else {
                        performLogin();
                    }
                    InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(LoginButton.this.getContext());
                    Bundle bundle = new Bundle();
                    int i = 1;
                    if (currentAccessToken != null) {
                        i = 0;
                    }
                    bundle.putInt("logging_in", i);
                    bundle.putInt("access_token_expired", AccessToken.isCurrentAccessTokenActive() ? 1 : 0);
                    internalAppEventsLogger.logEventImplicitly(LoginButton.this.loginLogoutEventName, bundle);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }

        public void performLogin() {
            CallbackManager callbackManagerImpl;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                LoginManager loginManager = getLoginManager();
                if (LoginButton.this.androidXLoginCaller != null) {
                    if (LoginButton.this.callbackManager != null) {
                        callbackManagerImpl = LoginButton.this.callbackManager;
                    } else {
                        callbackManagerImpl = new CallbackManagerImpl();
                    }
                    ((LoginManager.FacebookLoginActivityResultContract) LoginButton.this.androidXLoginCaller.getContract()).setCallbackManager(callbackManagerImpl);
                    LoginButton.this.androidXLoginCaller.launch(LoginButton.this.properties.permissions);
                    return;
                }
                if (LoginButton.this.getFragment() != null) {
                    loginManager.logIn(LoginButton.this.getFragment(), LoginButton.this.properties.permissions, LoginButton.this.getLoggerID());
                } else if (LoginButton.this.getNativeFragment() != null) {
                    loginManager.logIn(LoginButton.this.getNativeFragment(), LoginButton.this.properties.permissions, LoginButton.this.getLoggerID());
                } else {
                    loginManager.logIn(LoginButton.this.getActivity(), LoginButton.this.properties.permissions, LoginButton.this.getLoggerID());
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }

        public void performLogout(Context context) {
            String string;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                final LoginManager loginManager = getLoginManager();
                if (LoginButton.this.confirmLogout) {
                    String string2 = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_log_out_action);
                    String string3 = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_cancel_action);
                    Profile currentProfile = Profile.getCurrentProfile();
                    if (currentProfile != null && currentProfile.getName() != null) {
                        string = String.format(LoginButton.this.getResources().getString(R.string.com_facebook_loginview_logged_in_as), currentProfile.getName());
                    } else {
                        string = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_logged_in_using_facebook);
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage(string).setCancelable(true).setPositiveButton(string2, new DialogInterface.OnClickListener() { // from class: com.facebook.login.widget.LoginButton.LoginClickListener.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            loginManager.logOut();
                        }
                    }).setNegativeButton(string3, (DialogInterface.OnClickListener) null);
                    builder.create().show();
                    return;
                }
                loginManager.logOut();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* loaded from: classes8.dex */
    public enum ToolTipMode {
        AUTOMATIC(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC, 0),
        DISPLAY_ALWAYS("display_always", 1),
        NEVER_DISPLAY("never_display", 2);

        public static ToolTipMode DEFAULT = AUTOMATIC;
        private int intValue;
        private String stringValue;

        ToolTipMode(String stringValue, int value) {
            this.stringValue = stringValue;
            this.intValue = value;
        }

        public static ToolTipMode fromInt(int enumValue) {
            for (ToolTipMode toolTipMode : values()) {
                if (toolTipMode.getValue() == enumValue) {
                    return toolTipMode;
                }
            }
            return null;
        }

        public int getValue() {
            return this.intValue;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.stringValue;
        }
    }

    public LoginButton(Context context) {
        this(context, null, 0, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
    }

    private void checkToolTipSettings() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            int i = AnonymousClass4.$SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode[this.toolTipMode.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    displayToolTip(getResources().getString(R.string.com_facebook_tooltip_default));
                }
            } else {
                final String metadataApplicationId = Utility.getMetadataApplicationId(getContext());
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.login.widget.LoginButton.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CrashShieldHandler.isObjectCrashing(this)) {
                            return;
                        }
                        try {
                            final FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(metadataApplicationId, false);
                            LoginButton.this.getActivity().runOnUiThread(new Runnable() { // from class: com.facebook.login.widget.LoginButton.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (!CrashShieldHandler.isObjectCrashing(this)) {
                                        try {
                                            LoginButton.this.showToolTipPerSettings(queryAppSettings);
                                        } catch (Throwable th) {
                                            CrashShieldHandler.handleThrowable(th, this);
                                        }
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, this);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void displayToolTip(String toolTipString) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            ToolTipPopup toolTipPopup = new ToolTipPopup(toolTipString, this);
            this.toolTipPopup = toolTipPopup;
            toolTipPopup.setStyle(this.toolTipStyle);
            this.toolTipPopup.setNuxDisplayTime(this.toolTipDisplayTime);
            this.toolTipPopup.show();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private int measureButtonWidth(final String text) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return getCompoundPaddingLeft() + getCompoundDrawablePadding() + measureTextWidth(text) + getCompoundPaddingRight();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToolTipPerSettings(FetchedAppSettings settings) {
        if (!CrashShieldHandler.isObjectCrashing(this) && settings != null) {
            try {
                if (settings.getNuxEnabled() && getVisibility() == 0) {
                    displayToolTip(settings.getNuxContent());
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void clearPermissions() {
        this.properties.clearPermissions();
    }

    @Override // com.facebook.FacebookButtonBase
    public void configureButton(final Context context, final AttributeSet attrs, final int defStyleAttr, final int defStyleRes) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            super.configureButton(context, attrs, defStyleAttr, defStyleRes);
            setInternalOnClickListener(getNewLoginClickListener());
            parseLoginButtonAttributes(context, attrs, defStyleAttr, defStyleRes);
            if (isInEditMode()) {
                setBackgroundColor(getResources().getColor(com.facebook.common.R.color.com_facebook_blue));
                this.loginText = "Continue with Facebook";
            } else {
                this.accessTokenTracker = new AccessTokenTracker() { // from class: com.facebook.login.widget.LoginButton.3
                    @Override // com.facebook.AccessTokenTracker
                    public void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                        LoginButton.this.setButtonText();
                        LoginButton.this.setButtonIcon();
                    }
                };
            }
            setButtonText();
            setButtonRadius();
            setButtonTransparency();
            setButtonIcon();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void dismissToolTip() {
        ToolTipPopup toolTipPopup = this.toolTipPopup;
        if (toolTipPopup != null) {
            toolTipPopup.dismiss();
            this.toolTipPopup = null;
        }
    }

    public String getAuthType() {
        return this.properties.getAuthType();
    }

    @Nullable
    public CallbackManager getCallbackManager() {
        return this.callbackManager;
    }

    public DefaultAudience getDefaultAudience() {
        return this.properties.getDefaultAudience();
    }

    @Override // com.facebook.FacebookButtonBase
    public int getDefaultRequestCode() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    @Override // com.facebook.FacebookButtonBase
    public int getDefaultStyleResource() {
        return R.style.com_facebook_loginview_default_style;
    }

    public String getLoggerID() {
        return this.loggerID;
    }

    public LoginBehavior getLoginBehavior() {
        return this.properties.getLoginBehavior();
    }

    @StringRes
    public int getLoginButtonContinueLabel() {
        return R.string.com_facebook_loginview_log_in_button_continue;
    }

    public int getLoginButtonWidth(int widthMeasureSpec) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            Resources resources = getResources();
            String str = this.loginText;
            if (str == null) {
                str = resources.getString(R.string.com_facebook_loginview_log_in_button_continue);
                int measureButtonWidth = measureButtonWidth(str);
                if (View.resolveSize(measureButtonWidth, widthMeasureSpec) < measureButtonWidth) {
                    str = resources.getString(R.string.com_facebook_loginview_log_in_button);
                }
            }
            return measureButtonWidth(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    public LoginManager getLoginManager() {
        if (this.loginManager == null) {
            this.loginManager = LoginManager.getInstance();
        }
        return this.loginManager;
    }

    public LoginTargetApp getLoginTargetApp() {
        return this.properties.getLoginTargetApp();
    }

    @Nullable
    public String getMessengerPageId() {
        return this.properties.getMessengerPageId();
    }

    public LoginClickListener getNewLoginClickListener() {
        return new LoginClickListener();
    }

    public List<String> getPermissions() {
        return this.properties.getPermissions();
    }

    public boolean getResetMessengerState() {
        return this.properties.getResetMessengerState();
    }

    public boolean getShouldSkipAccountDeduplication() {
        return this.properties.getShouldSkipAccountDeduplication();
    }

    public long getToolTipDisplayTime() {
        return this.toolTipDisplayTime;
    }

    public ToolTipMode getToolTipMode() {
        return this.toolTipMode;
    }

    @Override // com.facebook.FacebookButtonBase, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            super.onAttachedToWindow();
            if (getContext() instanceof ActivityResultRegistryOwner) {
                this.androidXLoginCaller = ((ActivityResultRegistryOwner) getContext()).getActivityResultRegistry().register("facebook-login", getLoginManager().createLogInActivityResultContract(this.callbackManager, this.loggerID), new ActivityResultCallback<CallbackManager.ActivityResultParameters>() { // from class: com.facebook.login.widget.LoginButton.1
                    @Override // androidx.activity.result.ActivityResultCallback
                    public void onActivityResult(CallbackManager.ActivityResultParameters result) {
                    }
                });
            }
            AccessTokenTracker accessTokenTracker = this.accessTokenTracker;
            if (accessTokenTracker != null && !accessTokenTracker.isTracking()) {
                this.accessTokenTracker.startTracking();
                setButtonText();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            super.onDetachedFromWindow();
            ActivityResultLauncher<Collection<? extends String>> activityResultLauncher = this.androidXLoginCaller;
            if (activityResultLauncher != null) {
                activityResultLauncher.unregister();
            }
            AccessTokenTracker accessTokenTracker = this.accessTokenTracker;
            if (accessTokenTracker != null) {
                accessTokenTracker.stopTracking();
            }
            dismissToolTip();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // com.facebook.FacebookButtonBase, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            super.onDraw(canvas);
            if (!this.toolTipChecked && !isInEditMode()) {
                this.toolTipChecked = true;
                checkToolTipSettings();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            super.onLayout(changed, left, top, right, bottom);
            setButtonText();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
            int compoundPaddingTop = getCompoundPaddingTop() + ((int) Math.ceil(Math.abs(fontMetrics.top) + Math.abs(fontMetrics.bottom))) + getCompoundPaddingBottom();
            Resources resources = getResources();
            int loginButtonWidth = getLoginButtonWidth(widthMeasureSpec);
            String str = this.logoutText;
            if (str == null) {
                str = resources.getString(R.string.com_facebook_loginview_log_out_button);
            }
            setMeasuredDimension(View.resolveSize(Math.max(loginButtonWidth, measureButtonWidth(str)), widthMeasureSpec), compoundPaddingTop);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            super.onVisibilityChanged(changedView, visibility);
            if (visibility != 0) {
                dismissToolTip();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void parseLoginButtonAttributes(final Context context, final AttributeSet attrs, final int defStyleAttr, final int defStyleRes) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.toolTipMode = ToolTipMode.DEFAULT;
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.com_facebook_login_view, defStyleAttr, defStyleRes);
            try {
                this.confirmLogout = obtainStyledAttributes.getBoolean(R.styleable.com_facebook_login_view_com_facebook_confirm_logout, true);
                this.loginText = obtainStyledAttributes.getString(R.styleable.com_facebook_login_view_com_facebook_login_text);
                this.logoutText = obtainStyledAttributes.getString(R.styleable.com_facebook_login_view_com_facebook_logout_text);
                this.toolTipMode = ToolTipMode.fromInt(obtainStyledAttributes.getInt(R.styleable.com_facebook_login_view_com_facebook_tooltip_mode, ToolTipMode.DEFAULT.getValue()));
                int i = R.styleable.com_facebook_login_view_com_facebook_login_button_radius;
                if (obtainStyledAttributes.hasValue(i)) {
                    this.customButtonRadius = Float.valueOf(obtainStyledAttributes.getDimension(i, 0.0f));
                }
                int integer = obtainStyledAttributes.getInteger(R.styleable.com_facebook_login_view_com_facebook_login_button_transparency, 255);
                this.customButtonTransparency = integer;
                if (integer < 0) {
                    this.customButtonTransparency = 0;
                }
                if (this.customButtonTransparency > 255) {
                    this.customButtonTransparency = 255;
                }
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
        }
    }

    public void registerCallback(final CallbackManager callbackManager, final FacebookCallback<LoginResult> callback) {
        getLoginManager().registerCallback(callbackManager, callback);
        CallbackManager callbackManager2 = this.callbackManager;
        if (callbackManager2 == null) {
            this.callbackManager = callbackManager;
        } else if (callbackManager2 != callbackManager) {
            Log.w(TAG, "You're registering a callback on the one Facebook login button with two different callback managers. It's almost wrong and may cause unexpected results. Only the first callback manager will be used for handling activity result with androidx.");
        }
    }

    public void setAuthType(final String authType) {
        this.properties.setAuthType(authType);
    }

    public void setButtonIcon() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            setCompoundDrawablesWithIntrinsicBounds(AppCompatResources.getDrawable(getContext(), com.facebook.common.R.drawable.com_facebook_button_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:15:0x0022 */
    @android.annotation.TargetApi(29)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setButtonRadius() {
        /*
            r5 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r5)
            if (r0 == 0) goto L7
            return
        L7:
            java.lang.Float r0 = r5.customButtonRadius     // Catch: java.lang.Throwable -> L36
            if (r0 != 0) goto Lc
            return
        Lc:
            android.graphics.drawable.Drawable r0 = r5.getBackground()     // Catch: java.lang.Throwable -> L36
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L36
            r2 = 29
            if (r1 < r2) goto L3b
            boolean r1 = r0 instanceof android.graphics.drawable.StateListDrawable     // Catch: java.lang.Throwable -> L36
            if (r1 == 0) goto L3b
            r1 = r0
            android.graphics.drawable.StateListDrawable r1 = (android.graphics.drawable.StateListDrawable) r1     // Catch: java.lang.Throwable -> L36
            r2 = 0
        L1e:
            int r3 = com.facebook.login.widget.oIX0oI.oIX0oI(r1)     // Catch: java.lang.Throwable -> L36
            if (r2 >= r3) goto L3b
            android.graphics.drawable.Drawable r3 = com.facebook.login.widget.II0xO0.oIX0oI(r1, r2)     // Catch: java.lang.Throwable -> L36
            android.graphics.drawable.GradientDrawable r3 = (android.graphics.drawable.GradientDrawable) r3     // Catch: java.lang.Throwable -> L36
            if (r3 == 0) goto L38
            java.lang.Float r4 = r5.customButtonRadius     // Catch: java.lang.Throwable -> L36
            float r4 = r4.floatValue()     // Catch: java.lang.Throwable -> L36
            r3.setCornerRadius(r4)     // Catch: java.lang.Throwable -> L36
            goto L38
        L36:
            r0 = move-exception
            goto L4b
        L38:
            int r2 = r2 + 1
            goto L1e
        L3b:
            boolean r1 = r0 instanceof android.graphics.drawable.GradientDrawable     // Catch: java.lang.Throwable -> L36
            if (r1 == 0) goto L4a
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0     // Catch: java.lang.Throwable -> L36
            java.lang.Float r1 = r5.customButtonRadius     // Catch: java.lang.Throwable -> L36
            float r1 = r1.floatValue()     // Catch: java.lang.Throwable -> L36
            r0.setCornerRadius(r1)     // Catch: java.lang.Throwable -> L36
        L4a:
            return
        L4b:
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.widget.LoginButton.setButtonRadius():void");
    }

    public void setButtonText() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Resources resources = getResources();
            if (!isInEditMode() && AccessToken.isCurrentAccessTokenActive()) {
                String str = this.logoutText;
                if (str == null) {
                    str = resources.getString(R.string.com_facebook_loginview_log_out_button);
                }
                setText(str);
                return;
            }
            String str2 = this.loginText;
            if (str2 != null) {
                setText(str2);
                return;
            }
            String string = resources.getString(getLoginButtonContinueLabel());
            int width = getWidth();
            if (width != 0 && measureButtonWidth(string) > width) {
                string = resources.getString(R.string.com_facebook_loginview_log_in_button);
            }
            setText(string);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void setButtonTransparency() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            getBackground().setAlpha(this.customButtonTransparency);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void setDefaultAudience(DefaultAudience defaultAudience) {
        this.properties.setDefaultAudience(defaultAudience);
    }

    public void setLoginBehavior(LoginBehavior loginBehavior) {
        this.properties.setLoginBehavior(loginBehavior);
    }

    public void setLoginManager(LoginManager loginManager) {
        this.loginManager = loginManager;
    }

    public void setLoginTargetApp(LoginTargetApp targetApp) {
        this.properties.setLoginTargetApp(targetApp);
    }

    public void setLoginText(String loginText) {
        this.loginText = loginText;
        setButtonText();
    }

    public void setLogoutText(String logoutText) {
        this.logoutText = logoutText;
        setButtonText();
    }

    public void setMessengerPageId(final String messengerPageId) {
        this.properties.setMessengerPageId(messengerPageId);
    }

    public void setPermissions(List<String> permissions) {
        this.properties.setPermissions(permissions);
    }

    public void setProperties(LoginButtonProperties properties) {
        this.properties = properties;
    }

    public void setPublishPermissions(List<String> permissions) {
        this.properties.setPermissions(permissions);
    }

    public void setReadPermissions(List<String> permissions) {
        this.properties.setPermissions(permissions);
    }

    public void setResetMessengerState(final boolean resetMessengerState) {
        this.properties.setResetMessengerState(resetMessengerState);
    }

    public void setToolTipDisplayTime(long displayTime) {
        this.toolTipDisplayTime = displayTime;
    }

    public void setToolTipMode(ToolTipMode toolTipMode) {
        this.toolTipMode = toolTipMode;
    }

    public void setToolTipStyle(ToolTipPopup.Style toolTipStyle) {
        this.toolTipStyle = toolTipStyle;
    }

    public void unregisterCallback(final CallbackManager callbackManager) {
        getLoginManager().unregisterCallback(callbackManager);
    }

    public LoginButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
    }

    public void setPermissions(String... permissions) {
        this.properties.setPermissions(Arrays.asList(permissions));
    }

    public void setPublishPermissions(String... permissions) {
        this.properties.setPermissions(Arrays.asList(permissions));
    }

    public void setReadPermissions(String... permissions) {
        this.properties.setPermissions(Arrays.asList(permissions));
    }

    public LoginButton(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
    }

    public LoginButton(final Context context, final AttributeSet attrs, int defStyleAttr, int defStyleRes, final String analyticsButtonCreatedEventName, final String analyticsButtonTappedEventName) {
        super(context, attrs, defStyleAttr, defStyleRes, analyticsButtonCreatedEventName, analyticsButtonTappedEventName);
        this.properties = new LoginButtonProperties();
        this.loginLogoutEventName = AnalyticsEvents.EVENT_LOGIN_VIEW_USAGE;
        this.toolTipStyle = ToolTipPopup.Style.BLUE;
        this.toolTipDisplayTime = ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;
        this.customButtonTransparency = 255;
        this.loggerID = UUID.randomUUID().toString();
        this.callbackManager = null;
        this.androidXLoginCaller = null;
    }
}
