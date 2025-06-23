package com.facebook.appevents.suggestedevents;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.RestrictTo;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.suggestedevents.ViewOnClickListener;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.text.OxI;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes8.dex */
public final class ViewOnClickListener implements View.OnClickListener {

    @OOXIXo
    private static final String API_ENDPOINT = "%s/suggested_events";

    @OOXIXo
    public static final String OTHER_EVENT = "other";

    @OOXIXo
    private final String activityName;

    @oOoXoXO
    private final View.OnClickListener baseListener;

    @OOXIXo
    private final WeakReference<View> hostViewWeakReference;

    @OOXIXo
    private final WeakReference<View> rootViewWeakReference;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final Set<Integer> viewsAttachedListener = new HashSet();

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void processPredictedResult(String str, String str2, float[] fArr) {
            SuggestedEventsManager suggestedEventsManager = SuggestedEventsManager.INSTANCE;
            if (SuggestedEventsManager.isProductionEvents$facebook_core_release(str)) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                new InternalAppEventsLogger(FacebookSdk.getApplicationContext()).logEventFromSE(str, str2);
            } else if (SuggestedEventsManager.isEligibleEvents$facebook_core_release(str)) {
                sendPredictedResult(str, str2, fArr);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean queryHistoryAndProcess(String str, final String str2) {
            PredictionHistoryManager predictionHistoryManager = PredictionHistoryManager.INSTANCE;
            final String queryEvent = PredictionHistoryManager.queryEvent(str);
            if (queryEvent == null) {
                return false;
            }
            if (!IIX0o.Oxx0IOOO(queryEvent, "other")) {
                Utility utility = Utility.INSTANCE;
                Utility.runOnNonUiThread(new Runnable() { // from class: oxXx0IX.oxoX
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewOnClickListener.Companion.m177queryHistoryAndProcess$lambda0(queryEvent, str2);
                    }
                });
                return true;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: queryHistoryAndProcess$lambda-0, reason: not valid java name */
        public static final void m177queryHistoryAndProcess$lambda0(String queriedEvent, String buttonText) {
            IIX0o.x0xO0oo(queriedEvent, "$queriedEvent");
            IIX0o.x0xO0oo(buttonText, "$buttonText");
            ViewOnClickListener.Companion.processPredictedResult(queriedEvent, buttonText, new float[0]);
        }

        private final void sendPredictedResult(String str, String str2, float[] fArr) {
            Bundle bundle = new Bundle();
            try {
                bundle.putString("event_name", str);
                JSONObject jSONObject = new JSONObject();
                StringBuilder sb = new StringBuilder();
                int length = fArr.length;
                int i = 0;
                while (i < length) {
                    float f = fArr[i];
                    i++;
                    sb.append(f);
                    sb.append(",");
                }
                jSONObject.put("dense", sb.toString());
                jSONObject.put("button_text", str2);
                bundle.putString(TtmlNode.TAG_METADATA, jSONObject.toString());
                GraphRequest.Companion companion = GraphRequest.Companion;
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                Locale locale = Locale.US;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                String format = String.format(locale, ViewOnClickListener.API_ENDPOINT, Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                IIX0o.oO(format, "java.lang.String.format(locale, format, *args)");
                GraphRequest newPostRequest = companion.newPostRequest(null, format, null, null);
                newPostRequest.setParameters(bundle);
                newPostRequest.executeAndWait();
            } catch (JSONException unused) {
            }
        }

        @x0XOIxOo
        public final void attachListener$facebook_core_release(@OOXIXo View hostView, @OOXIXo View rootView, @OOXIXo String activityName) {
            IIX0o.x0xO0oo(hostView, "hostView");
            IIX0o.x0xO0oo(rootView, "rootView");
            IIX0o.x0xO0oo(activityName, "activityName");
            int hashCode = hostView.hashCode();
            if (!ViewOnClickListener.access$getViewsAttachedListener$cp().contains(Integer.valueOf(hashCode))) {
                ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
                ViewHierarchy.setOnClickListener(hostView, new ViewOnClickListener(hostView, rootView, activityName, null));
                ViewOnClickListener.access$getViewsAttachedListener$cp().add(Integer.valueOf(hashCode));
            }
        }

        private Companion() {
        }
    }

    public /* synthetic */ ViewOnClickListener(View view, View view2, String str, IIXOooo iIXOooo) {
        this(view, view2, str);
    }

    public static final /* synthetic */ Set access$getViewsAttachedListener$cp() {
        if (CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            return null;
        }
        try {
            return viewsAttachedListener;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewOnClickListener.class);
            return null;
        }
    }

    @x0XOIxOo
    public static final void attachListener$facebook_core_release(@OOXIXo View view, @OOXIXo View view2, @OOXIXo String str) {
        if (CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            return;
        }
        try {
            Companion.attachListener$facebook_core_release(view, view2, str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewOnClickListener.class);
        }
    }

    private final void predictAndProcess(final String str, final String str2, final JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Utility utility = Utility.INSTANCE;
            Utility.runOnNonUiThread(new Runnable() { // from class: oxXx0IX.I0Io
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListener.m176predictAndProcess$lambda0(jSONObject, str2, this, str);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: predictAndProcess$lambda-0, reason: not valid java name */
    public static final void m176predictAndProcess$lambda0(JSONObject viewData, String buttonText, ViewOnClickListener this$0, String pathID) {
        if (CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(viewData, "$viewData");
            IIX0o.x0xO0oo(buttonText, "$buttonText");
            IIX0o.x0xO0oo(this$0, "this$0");
            IIX0o.x0xO0oo(pathID, "$pathID");
            try {
                Utility utility = Utility.INSTANCE;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                String appName = Utility.getAppName(FacebookSdk.getApplicationContext());
                if (appName != null) {
                    String lowerCase = appName.toLowerCase();
                    IIX0o.oO(lowerCase, "(this as java.lang.String).toLowerCase()");
                    FeatureExtractor featureExtractor = FeatureExtractor.INSTANCE;
                    float[] denseFeatures = FeatureExtractor.getDenseFeatures(viewData, lowerCase);
                    String textFeature = FeatureExtractor.getTextFeature(buttonText, this$0.activityName, lowerCase);
                    if (denseFeatures == null) {
                        return;
                    }
                    ModelManager modelManager = ModelManager.INSTANCE;
                    String[] predict = ModelManager.predict(ModelManager.Task.MTML_APP_EVENT_PREDICTION, new float[][]{denseFeatures}, new String[]{textFeature});
                    if (predict == null) {
                        return;
                    }
                    String str = predict[0];
                    PredictionHistoryManager predictionHistoryManager = PredictionHistoryManager.INSTANCE;
                    PredictionHistoryManager.addPrediction(pathID, str);
                    if (!IIX0o.Oxx0IOOO(str, "other")) {
                        Companion.processPredictedResult(str, buttonText, denseFeatures);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewOnClickListener.class);
        }
    }

    private final void process() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            View view = this.rootViewWeakReference.get();
            View view2 = this.hostViewWeakReference.get();
            if (view != null && view2 != null) {
                try {
                    SuggestedEventViewHierarchy suggestedEventViewHierarchy = SuggestedEventViewHierarchy.INSTANCE;
                    String textOfViewRecursively = SuggestedEventViewHierarchy.getTextOfViewRecursively(view2);
                    PredictionHistoryManager predictionHistoryManager = PredictionHistoryManager.INSTANCE;
                    String pathID = PredictionHistoryManager.getPathID(view2, textOfViewRecursively);
                    if (pathID == null || Companion.queryHistoryAndProcess(pathID, textOfViewRecursively)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ViewHierarchyConstants.VIEW_KEY, SuggestedEventViewHierarchy.getDictionaryOfView(view, view2));
                    jSONObject.put(ViewHierarchyConstants.SCREEN_NAME_KEY, this.activityName);
                    predictAndProcess(pathID, textOfViewRecursively, jSONObject);
                } catch (Exception unused) {
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@OOXIXo View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(view, "view");
            View.OnClickListener onClickListener = this.baseListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            process();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private ViewOnClickListener(View view, View view2, String str) {
        ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
        this.baseListener = ViewHierarchy.getExistingOnClickListener(view);
        this.rootViewWeakReference = new WeakReference<>(view2);
        this.hostViewWeakReference = new WeakReference<>(view);
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase();
        IIX0o.oO(lowerCase, "(this as java.lang.String).toLowerCase()");
        this.activityName = OxI.IIOIX(lowerCase, TTDownloadField.TT_ACTIVITY, "", false, 4, null);
    }
}
