package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.Sharer;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.ShareContent;

/* loaded from: classes8.dex */
public abstract class ShareButtonBase extends FacebookButtonBase {
    private CallbackManager callbackManager;
    private boolean enabledExplicitlySet;
    private int requestCode;
    private ShareContent shareContent;

    public ShareButtonBase(final Context context, final AttributeSet attrs, final int defStyleAttr, final String analyticsButtonCreatedEventName, final String analyticsButtonTappedEventName) {
        super(context, attrs, defStyleAttr, 0, analyticsButtonCreatedEventName, analyticsButtonTappedEventName);
        int defaultRequestCode;
        this.requestCode = 0;
        this.enabledExplicitlySet = false;
        if (isInEditMode()) {
            defaultRequestCode = 0;
        } else {
            defaultRequestCode = getDefaultRequestCode();
        }
        this.requestCode = defaultRequestCode;
        internalSetEnabled(false);
    }

    private void internalSetEnabled(boolean enabled) {
        setEnabled(enabled);
        this.enabledExplicitlySet = false;
    }

    private void memorizeCallbackManager(CallbackManager callbackManager) {
        CallbackManager callbackManager2 = this.callbackManager;
        if (callbackManager2 == null) {
            this.callbackManager = callbackManager;
        } else if (callbackManager2 != callbackManager) {
            Log.w(ShareButtonBase.class.toString(), "You're registering a callback on a Facebook Share Button with two different callback managers. It's almost wrong and may cause unexpected results. Only the first callback manager will be used for handling activity result with androidx.");
        }
    }

    public boolean canShare() {
        return getDialog().canShow((ShareDialog) getShareContent());
    }

    @Override // com.facebook.FacebookButtonBase
    public void configureButton(final Context context, final AttributeSet attrs, final int defStyleAttr, final int defStyleRes) {
        super.configureButton(context, attrs, defStyleAttr, defStyleRes);
        setInternalOnClickListener(getShareOnClickListener());
    }

    public CallbackManager getCallbackManager() {
        return this.callbackManager;
    }

    public abstract ShareDialog getDialog();

    @Override // com.facebook.FacebookButtonBase
    public int getRequestCode() {
        return this.requestCode;
    }

    public ShareContent getShareContent() {
        return this.shareContent;
    }

    public View.OnClickListener getShareOnClickListener() {
        return new View.OnClickListener() { // from class: com.facebook.share.widget.ShareButtonBase.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    try {
                        ShareButtonBase.this.callExternalOnClickListener(v);
                        ShareButtonBase.this.getDialog().show(ShareButtonBase.this.getShareContent());
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            }
        };
    }

    public void registerCallback(final CallbackManager callbackManager, final FacebookCallback<Sharer.Result> callback) {
        memorizeCallbackManager(callbackManager);
        ShareInternalUtility.registerSharerCallback(getRequestCode(), callbackManager, callback);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.enabledExplicitlySet = true;
    }

    public void setRequestCode(final int requestCode) {
        if (!FacebookSdk.isFacebookRequestCode(requestCode)) {
            this.requestCode = requestCode;
            return;
        }
        throw new IllegalArgumentException("Request code " + requestCode + " cannot be within the range reserved by the Facebook SDK.");
    }

    public void setShareContent(final ShareContent shareContent) {
        this.shareContent = shareContent;
        if (!this.enabledExplicitlySet) {
            internalSetEnabled(canShare());
        }
    }

    public void registerCallback(final CallbackManager callbackManager, final FacebookCallback<Sharer.Result> callback, final int requestCode) {
        setRequestCode(requestCode);
        registerCallback(callbackManager, callback);
    }
}
