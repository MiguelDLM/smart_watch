package com.facebook.internal.instrument.crashreport;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.util.Log;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.oOXoIIIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final int MAX_CRASH_REPORT_NUM = 5;

    @oOoXoXO
    private static CrashHandler instance;

    @oOoXoXO
    private final Thread.UncaughtExceptionHandler previousHandler;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @oOoXoXO
    private static final String TAG = CrashHandler.class.getCanonicalName();

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private final void sendExceptionReports() {
            Utility utility = Utility.INSTANCE;
            if (Utility.isDataProcessingRestricted()) {
                return;
            }
            InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
            File[] listExceptionReportFiles = InstrumentUtility.listExceptionReportFiles();
            ArrayList arrayList = new ArrayList(listExceptionReportFiles.length);
            for (File file : listExceptionReportFiles) {
                InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
                arrayList.add(InstrumentData.Builder.load(file));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((InstrumentData) obj).isValid()) {
                    arrayList2.add(obj);
                }
            }
            final List xxx2 = CollectionsKt___CollectionsKt.xxx(arrayList2, new Comparator() { // from class: oX.I0Io
                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    int m231sendExceptionReports$lambda2;
                    m231sendExceptionReports$lambda2 = CrashHandler.Companion.m231sendExceptionReports$lambda2((InstrumentData) obj2, (InstrumentData) obj3);
                    return m231sendExceptionReports$lambda2;
                }
            });
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = X0.IIXOooo.X00xOoXI(0, Math.min(xxx2.size(), 5)).iterator();
            while (it.hasNext()) {
                jSONArray.put(xxx2.get(((oOXoIIIo) it).nextInt()));
            }
            InstrumentUtility instrumentUtility2 = InstrumentUtility.INSTANCE;
            InstrumentUtility.sendReports("crash_reports", jSONArray, new GraphRequest.Callback() { // from class: oX.oxoX
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    CrashHandler.Companion.m232sendExceptionReports$lambda5(xxx2, graphResponse);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: sendExceptionReports$lambda-2, reason: not valid java name */
        public static final int m231sendExceptionReports$lambda2(InstrumentData instrumentData, InstrumentData o2) {
            IIX0o.oO(o2, "o2");
            return instrumentData.compareTo(o2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: sendExceptionReports$lambda-5, reason: not valid java name */
        public static final void m232sendExceptionReports$lambda5(List validReports, GraphResponse response) {
            Boolean valueOf;
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
        }

        @x0XOIxOo
        public final synchronized void enable() {
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                    sendExceptionReports();
                }
                if (CrashHandler.instance == null) {
                    CrashHandler.instance = new CrashHandler(Thread.getDefaultUncaughtExceptionHandler(), null);
                    Thread.setDefaultUncaughtExceptionHandler(CrashHandler.instance);
                } else {
                    Log.w(CrashHandler.TAG, "Already enabled!");
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        private Companion() {
        }
    }

    public /* synthetic */ CrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, IIXOooo iIXOooo) {
        this(uncaughtExceptionHandler);
    }

    @x0XOIxOo
    public static final synchronized void enable() {
        synchronized (CrashHandler.class) {
            Companion.enable();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@OOXIXo Thread t, @OOXIXo Throwable e) {
        IIX0o.x0xO0oo(t, "t");
        IIX0o.x0xO0oo(e, "e");
        InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
        if (InstrumentUtility.isSDKRelatedException(e)) {
            ExceptionAnalyzer exceptionAnalyzer = ExceptionAnalyzer.INSTANCE;
            ExceptionAnalyzer.execute(e);
            InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
            InstrumentData.Builder.build(e, InstrumentData.Type.CrashReport).save();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.previousHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(t, e);
        }
    }

    private CrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.previousHandler = uncaughtExceptionHandler;
    }
}
