package com.facebook.appevents.codeless;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class RCTCodelessLoggingEventListener {

    @OOXIXo
    public static final RCTCodelessLoggingEventListener INSTANCE = new RCTCodelessLoggingEventListener();

    /* loaded from: classes8.dex */
    public static final class AutoLoggingOnTouchListener implements View.OnTouchListener {

        @oOoXoXO
        private final View.OnTouchListener existingOnTouchListener;

        @OOXIXo
        private final WeakReference<View> hostView;

        @OOXIXo
        private final EventBinding mapping;

        @OOXIXo
        private final WeakReference<View> rootView;
        private boolean supportCodelessLogging;

        public AutoLoggingOnTouchListener(@OOXIXo EventBinding mapping, @OOXIXo View rootView, @OOXIXo View hostView) {
            IIX0o.x0xO0oo(mapping, "mapping");
            IIX0o.x0xO0oo(rootView, "rootView");
            IIX0o.x0xO0oo(hostView, "hostView");
            this.mapping = mapping;
            this.hostView = new WeakReference<>(hostView);
            this.rootView = new WeakReference<>(rootView);
            ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
            this.existingOnTouchListener = ViewHierarchy.getExistingOnTouchListener(hostView);
            this.supportCodelessLogging = true;
        }

        public final boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@OOXIXo View view, @OOXIXo MotionEvent motionEvent) {
            IIX0o.x0xO0oo(view, "view");
            IIX0o.x0xO0oo(motionEvent, "motionEvent");
            View view2 = this.rootView.get();
            View view3 = this.hostView.get();
            if (view2 != null && view3 != null && motionEvent.getAction() == 1) {
                CodelessLoggingEventListener codelessLoggingEventListener = CodelessLoggingEventListener.INSTANCE;
                CodelessLoggingEventListener.logEvent$facebook_core_release(this.mapping, view2, view3);
            }
            View.OnTouchListener onTouchListener = this.existingOnTouchListener;
            if (onTouchListener != null && onTouchListener.onTouch(view, motionEvent)) {
                return true;
            }
            return false;
        }

        public final void setSupportCodelessLogging(boolean z) {
            this.supportCodelessLogging = z;
        }
    }

    private RCTCodelessLoggingEventListener() {
    }

    @x0XOIxOo
    @OOXIXo
    public static final AutoLoggingOnTouchListener getOnTouchListener(@OOXIXo EventBinding mapping, @OOXIXo View rootView, @OOXIXo View hostView) {
        if (CrashShieldHandler.isObjectCrashing(RCTCodelessLoggingEventListener.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(mapping, "mapping");
            IIX0o.x0xO0oo(rootView, "rootView");
            IIX0o.x0xO0oo(hostView, "hostView");
            return new AutoLoggingOnTouchListener(mapping, rootView, hostView);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, RCTCodelessLoggingEventListener.class);
            return null;
        }
    }
}
