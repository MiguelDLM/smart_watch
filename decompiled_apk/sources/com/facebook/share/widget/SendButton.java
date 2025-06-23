package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.R;

/* loaded from: classes8.dex */
public final class SendButton extends ShareButtonBase {
    public SendButton(final Context context) {
        super(context, null, 0, AnalyticsEvents.EVENT_SEND_BUTTON_CREATE, AnalyticsEvents.EVENT_SEND_BUTTON_DID_TAP);
    }

    @Override // com.facebook.FacebookButtonBase
    public int getDefaultRequestCode() {
        return CallbackManagerImpl.RequestCodeOffset.Message.toRequestCode();
    }

    @Override // com.facebook.FacebookButtonBase
    public int getDefaultStyleResource() {
        return R.style.com_facebook_button_send;
    }

    @Override // com.facebook.share.widget.ShareButtonBase
    public ShareDialog getDialog() {
        MessageDialog messageDialog;
        if (getFragment() != null) {
            messageDialog = new MessageDialog(getFragment(), getRequestCode());
        } else if (getNativeFragment() != null) {
            messageDialog = new MessageDialog(getNativeFragment(), getRequestCode());
        } else {
            messageDialog = new MessageDialog(getActivity(), getRequestCode());
        }
        messageDialog.setCallbackManager(getCallbackManager());
        return messageDialog;
    }

    public SendButton(final Context context, final AttributeSet attrs) {
        super(context, attrs, 0, AnalyticsEvents.EVENT_SEND_BUTTON_CREATE, AnalyticsEvents.EVENT_SEND_BUTTON_DID_TAP);
    }

    public SendButton(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr, AnalyticsEvents.EVENT_SEND_BUTTON_CREATE, AnalyticsEvents.EVENT_SEND_BUTTON_DID_TAP);
    }
}
