package com.facebook.appevents.codeless;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class CodelessLoggingEventListener {

    @OOXIXo
    public static final CodelessLoggingEventListener INSTANCE = new CodelessLoggingEventListener();

    /* loaded from: classes8.dex */
    public static final class AutoLoggingOnClickListener implements View.OnClickListener {

        @oOoXoXO
        private View.OnClickListener existingOnClickListener;

        @OOXIXo
        private WeakReference<View> hostView;

        @OOXIXo
        private EventBinding mapping;

        @OOXIXo
        private WeakReference<View> rootView;
        private boolean supportCodelessLogging;

        public AutoLoggingOnClickListener(@OOXIXo EventBinding mapping, @OOXIXo View rootView, @OOXIXo View hostView) {
            IIX0o.x0xO0oo(mapping, "mapping");
            IIX0o.x0xO0oo(rootView, "rootView");
            IIX0o.x0xO0oo(hostView, "hostView");
            this.mapping = mapping;
            this.hostView = new WeakReference<>(hostView);
            this.rootView = new WeakReference<>(rootView);
            ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
            this.existingOnClickListener = ViewHierarchy.getExistingOnClickListener(hostView);
            this.supportCodelessLogging = true;
        }

        public final boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@OOXIXo View view) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                IIX0o.x0xO0oo(view, "view");
                View.OnClickListener onClickListener = this.existingOnClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                View view2 = this.rootView.get();
                View view3 = this.hostView.get();
                if (view2 != null && view3 != null) {
                    CodelessLoggingEventListener codelessLoggingEventListener = CodelessLoggingEventListener.INSTANCE;
                    CodelessLoggingEventListener.logEvent$facebook_core_release(this.mapping, view2, view3);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }

        public final void setSupportCodelessLogging(boolean z) {
            this.supportCodelessLogging = z;
        }
    }

    /* loaded from: classes8.dex */
    public static final class AutoLoggingOnItemClickListener implements AdapterView.OnItemClickListener {

        @oOoXoXO
        private AdapterView.OnItemClickListener existingOnItemClickListener;

        @OOXIXo
        private WeakReference<AdapterView<?>> hostView;

        @OOXIXo
        private EventBinding mapping;

        @OOXIXo
        private WeakReference<View> rootView;
        private boolean supportCodelessLogging;

        public AutoLoggingOnItemClickListener(@OOXIXo EventBinding mapping, @OOXIXo View rootView, @OOXIXo AdapterView<?> hostView) {
            IIX0o.x0xO0oo(mapping, "mapping");
            IIX0o.x0xO0oo(rootView, "rootView");
            IIX0o.x0xO0oo(hostView, "hostView");
            this.mapping = mapping;
            this.hostView = new WeakReference<>(hostView);
            this.rootView = new WeakReference<>(rootView);
            this.existingOnItemClickListener = hostView.getOnItemClickListener();
            this.supportCodelessLogging = true;
        }

        public final boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(@oOoXoXO AdapterView<?> adapterView, @OOXIXo View view, int i, long j) {
            IIX0o.x0xO0oo(view, "view");
            AdapterView.OnItemClickListener onItemClickListener = this.existingOnItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i, j);
            }
            View view2 = this.rootView.get();
            AdapterView<?> adapterView2 = this.hostView.get();
            if (view2 != null && adapterView2 != null) {
                CodelessLoggingEventListener codelessLoggingEventListener = CodelessLoggingEventListener.INSTANCE;
                CodelessLoggingEventListener.logEvent$facebook_core_release(this.mapping, view2, adapterView2);
            }
        }

        public final void setSupportCodelessLogging(boolean z) {
            this.supportCodelessLogging = z;
        }
    }

    private CodelessLoggingEventListener() {
    }

    @x0XOIxOo
    @OOXIXo
    public static final AutoLoggingOnClickListener getOnClickListener(@OOXIXo EventBinding mapping, @OOXIXo View rootView, @OOXIXo View hostView) {
        if (CrashShieldHandler.isObjectCrashing(CodelessLoggingEventListener.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(mapping, "mapping");
            IIX0o.x0xO0oo(rootView, "rootView");
            IIX0o.x0xO0oo(hostView, "hostView");
            return new AutoLoggingOnClickListener(mapping, rootView, hostView);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessLoggingEventListener.class);
            return null;
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final AutoLoggingOnItemClickListener getOnItemClickListener(@OOXIXo EventBinding mapping, @OOXIXo View rootView, @OOXIXo AdapterView<?> hostView) {
        if (CrashShieldHandler.isObjectCrashing(CodelessLoggingEventListener.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(mapping, "mapping");
            IIX0o.x0xO0oo(rootView, "rootView");
            IIX0o.x0xO0oo(hostView, "hostView");
            return new AutoLoggingOnItemClickListener(mapping, rootView, hostView);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessLoggingEventListener.class);
            return null;
        }
    }

    @x0XOIxOo
    public static final void logEvent$facebook_core_release(@OOXIXo EventBinding mapping, @OOXIXo View rootView, @OOXIXo View hostView) {
        if (CrashShieldHandler.isObjectCrashing(CodelessLoggingEventListener.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(mapping, "mapping");
            IIX0o.x0xO0oo(rootView, "rootView");
            IIX0o.x0xO0oo(hostView, "hostView");
            final String eventName = mapping.getEventName();
            final Bundle parameters = CodelessMatcher.Companion.getParameters(mapping, rootView, hostView);
            INSTANCE.updateParameters$facebook_core_release(parameters);
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.codeless.oIX0oI
                @Override // java.lang.Runnable
                public final void run() {
                    CodelessLoggingEventListener.m150logEvent$lambda0(eventName, parameters);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessLoggingEventListener.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: logEvent$lambda-0, reason: not valid java name */
    public static final void m150logEvent$lambda0(String eventName, Bundle parameters) {
        if (CrashShieldHandler.isObjectCrashing(CodelessLoggingEventListener.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(eventName, "$eventName");
            IIX0o.x0xO0oo(parameters, "$parameters");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            AppEventsLogger.Companion.newLogger(FacebookSdk.getApplicationContext()).logEvent(eventName, parameters);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessLoggingEventListener.class);
        }
    }

    public final void updateParameters$facebook_core_release(@OOXIXo Bundle parameters) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(parameters, "parameters");
            String string = parameters.getString(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM);
            if (string != null) {
                AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                parameters.putDouble(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, AppEventUtility.normalizePrice(string));
            }
            parameters.putString(Constants.IS_CODELESS_EVENT_KEY, "1");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
