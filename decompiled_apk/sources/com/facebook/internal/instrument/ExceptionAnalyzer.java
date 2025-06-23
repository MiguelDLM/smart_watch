package com.facebook.internal.instrument;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class ExceptionAnalyzer {

    @OOXIXo
    public static final ExceptionAnalyzer INSTANCE = new ExceptionAnalyzer();
    private static boolean enabled;

    private ExceptionAnalyzer() {
    }

    @x0XOIxOo
    public static final void enable() {
        enabled = true;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            INSTANCE.sendExceptionAnalysisReports$facebook_core_release();
        }
    }

    @x0XOIxOo
    public static final void execute(@oOoXoXO Throwable th) {
        if (enabled && !isDebug$facebook_core_release() && th != null) {
            HashSet hashSet = new HashSet();
            StackTraceElement[] stackTrace = th.getStackTrace();
            IIX0o.oO(stackTrace, "e.stackTrace");
            for (StackTraceElement stackTraceElement : stackTrace) {
                FeatureManager featureManager = FeatureManager.INSTANCE;
                String className = stackTraceElement.getClassName();
                IIX0o.oO(className, "it.className");
                FeatureManager.Feature feature = FeatureManager.getFeature(className);
                if (feature != FeatureManager.Feature.Unknown) {
                    FeatureManager.disableFeature(feature);
                    hashSet.add(feature.toString());
                }
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.getAutoLogAppEventsEnabled() && !hashSet.isEmpty()) {
                InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
                InstrumentData.Builder.build(new JSONArray((Collection) hashSet)).save();
            }
        }
    }

    @x0XOIxOo
    @VisibleForTesting(otherwise = 2)
    public static final boolean isDebug$facebook_core_release() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendExceptionAnalysisReports$lambda-1, reason: not valid java name */
    public static final void m221sendExceptionAnalysisReports$lambda1(InstrumentData instrumentData, GraphResponse response) {
        Boolean valueOf;
        IIX0o.x0xO0oo(instrumentData, "$instrumentData");
        IIX0o.x0xO0oo(response, "response");
        try {
            if (response.getError() == null) {
                JSONObject jsonObject = response.getJsonObject();
                if (jsonObject == null) {
                    valueOf = null;
                } else {
                    valueOf = Boolean.valueOf(jsonObject.getBoolean("success"));
                }
                if (IIX0o.Oxx0IOOO(valueOf, Boolean.TRUE)) {
                    instrumentData.clear();
                }
            }
        } catch (JSONException unused) {
        }
    }

    @VisibleForTesting(otherwise = 2)
    public final void sendExceptionAnalysisReports$facebook_core_release() {
        Utility utility = Utility.INSTANCE;
        if (Utility.isDataProcessingRestricted()) {
            return;
        }
        InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
        File[] listExceptionAnalysisReportFiles = InstrumentUtility.listExceptionAnalysisReportFiles();
        ArrayList arrayList = new ArrayList();
        int length = listExceptionAnalysisReportFiles.length;
        int i = 0;
        while (i < length) {
            File file = listExceptionAnalysisReportFiles[i];
            i++;
            InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
            final InstrumentData load = InstrumentData.Builder.load(file);
            if (load.isValid()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("crash_shield", load.toString());
                    GraphRequest.Companion companion = GraphRequest.Companion;
                    oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    String format = String.format("%s/instruments", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                    IIX0o.oO(format, "java.lang.String.format(format, *args)");
                    arrayList.add(companion.newPostRequest(null, format, jSONObject, new GraphRequest.Callback() { // from class: XX0.oIX0oI
                        @Override // com.facebook.GraphRequest.Callback
                        public final void onCompleted(GraphResponse graphResponse) {
                            ExceptionAnalyzer.m221sendExceptionAnalysisReports$lambda1(InstrumentData.this, graphResponse);
                        }
                    }));
                } catch (JSONException unused) {
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        new GraphRequestBatch(arrayList).executeAsync();
    }
}
