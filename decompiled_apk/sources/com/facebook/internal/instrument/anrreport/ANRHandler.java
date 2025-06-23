package com.facebook.internal.instrument.anrreport;

import OXOo.OOXIXo;
import X0.IIXOooo;
import XO0OX.x0XOIxOo;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.anrreport.ANRHandler;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.oOXoIIIo;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class ANRHandler {
    private static final int MAX_ANR_REPORT_NUM = 5;

    @OOXIXo
    public static final ANRHandler INSTANCE = new ANRHandler();

    @OOXIXo
    private static final AtomicBoolean enabled = new AtomicBoolean(false);

    private ANRHandler() {
    }

    @x0XOIxOo
    public static final synchronized void enable() {
        synchronized (ANRHandler.class) {
            if (CrashShieldHandler.isObjectCrashing(ANRHandler.class)) {
                return;
            }
            try {
                if (enabled.getAndSet(true)) {
                    return;
                }
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                    sendANRReports();
                }
                ANRDetector aNRDetector = ANRDetector.INSTANCE;
                ANRDetector.start();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ANRHandler.class);
            }
        }
    }

    @x0XOIxOo
    @VisibleForTesting
    public static final void sendANRReports() {
        if (CrashShieldHandler.isObjectCrashing(ANRHandler.class)) {
            return;
        }
        try {
            Utility utility = Utility.INSTANCE;
            if (Utility.isDataProcessingRestricted()) {
                return;
            }
            InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
            File[] listAnrReportFiles = InstrumentUtility.listAnrReportFiles();
            ArrayList arrayList = new ArrayList(listAnrReportFiles.length);
            for (File file : listAnrReportFiles) {
                InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
                arrayList.add(InstrumentData.Builder.load(file));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((InstrumentData) obj).isValid()) {
                    arrayList2.add(obj);
                }
            }
            final List xxx2 = CollectionsKt___CollectionsKt.xxx(arrayList2, new Comparator() { // from class: I0X0x0oIo.II0xO0
                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    int m229sendANRReports$lambda2;
                    m229sendANRReports$lambda2 = ANRHandler.m229sendANRReports$lambda2((InstrumentData) obj2, (InstrumentData) obj3);
                    return m229sendANRReports$lambda2;
                }
            });
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = IIXOooo.X00xOoXI(0, Math.min(xxx2.size(), 5)).iterator();
            while (it.hasNext()) {
                jSONArray.put(xxx2.get(((oOXoIIIo) it).nextInt()));
            }
            InstrumentUtility instrumentUtility2 = InstrumentUtility.INSTANCE;
            InstrumentUtility.sendReports("anr_reports", jSONArray, new GraphRequest.Callback() { // from class: I0X0x0oIo.I0Io
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    ANRHandler.m230sendANRReports$lambda5(xxx2, graphResponse);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ANRHandler.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendANRReports$lambda-2, reason: not valid java name */
    public static final int m229sendANRReports$lambda2(InstrumentData instrumentData, InstrumentData o2) {
        if (CrashShieldHandler.isObjectCrashing(ANRHandler.class)) {
            return 0;
        }
        try {
            IIX0o.oO(o2, "o2");
            return instrumentData.compareTo(o2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ANRHandler.class);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendANRReports$lambda-5, reason: not valid java name */
    public static final void m230sendANRReports$lambda5(List validReports, GraphResponse response) {
        Boolean valueOf;
        if (CrashShieldHandler.isObjectCrashing(ANRHandler.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(validReports, "$validReports");
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
                        Iterator it = validReports.iterator();
                        while (it.hasNext()) {
                            ((InstrumentData) it.next()).clear();
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ANRHandler.class);
        }
    }
}
