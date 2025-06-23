package com.facebook.internal.instrument;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.text.OxI;
import kotlin.text.Regex;
import kotlin.text.oxoX;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class InstrumentUtility {

    @OOXIXo
    public static final String ANALYSIS_REPORT_PREFIX = "analysis_log_";

    @OOXIXo
    public static final String ANR_REPORT_PREFIX = "anr_log_";

    @OOXIXo
    private static final String CODELESS_PREFIX = "com.facebook.appevents.codeless";

    @OOXIXo
    public static final String CRASH_REPORT_PREFIX = "crash_log_";

    @OOXIXo
    public static final String CRASH_SHIELD_PREFIX = "shield_log_";

    @OOXIXo
    public static final String ERROR_REPORT_PREFIX = "error_log_";

    @OOXIXo
    private static final String FBSDK_PREFIX = "com.facebook";

    @OOXIXo
    public static final InstrumentUtility INSTANCE = new InstrumentUtility();

    @OOXIXo
    private static final String INSTRUMENT_DIR = "instrument";

    @OOXIXo
    private static final String SUGGESTED_EVENTS_PREFIX = "com.facebook.appevents.suggestedevents";

    @OOXIXo
    public static final String THREAD_CHECK_PREFIX = "thread_check_log_";

    private InstrumentUtility() {
    }

    @x0XOIxOo
    public static final boolean deleteFile(@oOoXoXO String str) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir != null && str != null) {
            return new File(instrumentReportDir, str).delete();
        }
        return false;
    }

    @x0XOIxOo
    @oOoXoXO
    public static final String getCause(@oOoXoXO Throwable th) {
        if (th == null) {
            return null;
        }
        if (th.getCause() == null) {
            return th.toString();
        }
        return String.valueOf(th.getCause());
    }

    @x0XOIxOo
    @oOoXoXO
    public static final File getInstrumentReportDir() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        File file = new File(FacebookSdk.getApplicationContext().getCacheDir(), INSTRUMENT_DIR);
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        return file;
    }

    @x0XOIxOo
    @oOoXoXO
    public static final String getStackTrace(@oOoXoXO Throwable th) {
        Throwable th2 = null;
        if (th == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        while (th != null && th != th2) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            IIX0o.oO(stackTrace, "t.stackTrace");
            int length = stackTrace.length;
            int i = 0;
            while (i < length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                i++;
                jSONArray.put(stackTraceElement.toString());
            }
            th2 = th;
            th = th.getCause();
        }
        return jSONArray.toString();
    }

    @x0XOIxOo
    public static final boolean isSDKRelatedException(@oOoXoXO Throwable th) {
        if (th == null) {
            return false;
        }
        Throwable th2 = null;
        while (th != null && th != th2) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            IIX0o.oO(stackTrace, "t.stackTrace");
            int length = stackTrace.length;
            int i = 0;
            while (i < length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                i++;
                String className = stackTraceElement.getClassName();
                IIX0o.oO(className, "element.className");
                if (OxI.IOOoXo0Ix(className, "com.facebook", false, 2, null)) {
                    return true;
                }
            }
            th2 = th;
            th = th.getCause();
        }
        return false;
    }

    @x0XOIxOo
    public static final boolean isSDKRelatedThread(@oOoXoXO Thread thread) {
        StackTraceElement[] stackTrace;
        if (thread != null && (stackTrace = thread.getStackTrace()) != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                IIX0o.oO(className, "element.className");
                if (OxI.IOOoXo0Ix(className, "com.facebook", false, 2, null)) {
                    String className2 = stackTraceElement.getClassName();
                    IIX0o.oO(className2, "element.className");
                    if (!OxI.IOOoXo0Ix(className2, CODELESS_PREFIX, false, 2, null)) {
                        String className3 = stackTraceElement.getClassName();
                        IIX0o.oO(className3, "element.className");
                        if (!OxI.IOOoXo0Ix(className3, SUGGESTED_EVENTS_PREFIX, false, 2, null)) {
                            return true;
                        }
                    }
                    String methodName = stackTraceElement.getMethodName();
                    IIX0o.oO(methodName, "element.methodName");
                    if (OxI.IOOoXo0Ix(methodName, "onClick", false, 2, null)) {
                        continue;
                    } else {
                        String methodName2 = stackTraceElement.getMethodName();
                        IIX0o.oO(methodName2, "element.methodName");
                        if (OxI.IOOoXo0Ix(methodName2, "onItemClick", false, 2, null)) {
                            continue;
                        } else {
                            String methodName3 = stackTraceElement.getMethodName();
                            IIX0o.oO(methodName3, "element.methodName");
                            if (!OxI.IOOoXo0Ix(methodName3, "onTouch", false, 2, null)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @x0XOIxOo
    @OOXIXo
    public static final File[] listAnrReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles(new FilenameFilter() { // from class: XX0.XO
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                boolean m225listAnrReportFiles$lambda1;
                m225listAnrReportFiles$lambda1 = InstrumentUtility.m225listAnrReportFiles$lambda1(file, str);
                return m225listAnrReportFiles$lambda1;
            }
        });
        if (listFiles == null) {
            return new File[0];
        }
        return listFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listAnrReportFiles$lambda-1, reason: not valid java name */
    public static final boolean m225listAnrReportFiles$lambda1(File file, String name) {
        IIX0o.oO(name, "name");
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{ANR_REPORT_PREFIX}, 1));
        IIX0o.oO(format, "java.lang.String.format(format, *args)");
        return new Regex(format).matches(name);
    }

    @x0XOIxOo
    @OOXIXo
    public static final File[] listExceptionAnalysisReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles(new FilenameFilter() { // from class: XX0.Oxx0IOOO
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                boolean m226listExceptionAnalysisReportFiles$lambda2;
                m226listExceptionAnalysisReportFiles$lambda2 = InstrumentUtility.m226listExceptionAnalysisReportFiles$lambda2(file, str);
                return m226listExceptionAnalysisReportFiles$lambda2;
            }
        });
        if (listFiles == null) {
            return new File[0];
        }
        return listFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listExceptionAnalysisReportFiles$lambda-2, reason: not valid java name */
    public static final boolean m226listExceptionAnalysisReportFiles$lambda2(File file, String name) {
        IIX0o.oO(name, "name");
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{ANALYSIS_REPORT_PREFIX}, 1));
        IIX0o.oO(format, "java.lang.String.format(format, *args)");
        return new Regex(format).matches(name);
    }

    @x0XOIxOo
    @OOXIXo
    public static final File[] listExceptionReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles(new FilenameFilter() { // from class: XX0.X0o0xo
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                boolean m227listExceptionReportFiles$lambda3;
                m227listExceptionReportFiles$lambda3 = InstrumentUtility.m227listExceptionReportFiles$lambda3(file, str);
                return m227listExceptionReportFiles$lambda3;
            }
        });
        if (listFiles == null) {
            return new File[0];
        }
        return listFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listExceptionReportFiles$lambda-3, reason: not valid java name */
    public static final boolean m227listExceptionReportFiles$lambda3(File file, String name) {
        IIX0o.oO(name, "name");
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("^(%s|%s|%s)[0-9]+.json$", Arrays.copyOf(new Object[]{CRASH_REPORT_PREFIX, CRASH_SHIELD_PREFIX, THREAD_CHECK_PREFIX}, 3));
        IIX0o.oO(format, "java.lang.String.format(format, *args)");
        return new Regex(format).matches(name);
    }

    @x0XOIxOo
    @oOoXoXO
    public static final JSONObject readFile(@oOoXoXO String str, boolean z) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir != null && str != null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(new File(instrumentReportDir, str));
                Utility utility = Utility.INSTANCE;
                return new JSONObject(Utility.readStreamToString(fileInputStream));
            } catch (Exception unused) {
                if (z) {
                    deleteFile(str);
                }
            }
        }
        return null;
    }

    @x0XOIxOo
    public static final void sendReports(@oOoXoXO String str, @OOXIXo JSONArray reports, @oOoXoXO GraphRequest.Callback callback) {
        IIX0o.x0xO0oo(reports, "reports");
        if (reports.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, reports.toString());
            Utility utility = Utility.INSTANCE;
            JSONObject dataProcessingOptions = Utility.getDataProcessingOptions();
            if (dataProcessingOptions != null) {
                Iterator<String> keys = dataProcessingOptions.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, dataProcessingOptions.get(next));
                }
            }
            GraphRequest.Companion companion = GraphRequest.Companion;
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            String format = String.format("%s/instruments", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
            IIX0o.oO(format, "java.lang.String.format(format, *args)");
            companion.newPostRequest(null, format, jSONObject, callback).executeAsync();
        } catch (JSONException unused) {
        }
    }

    @x0XOIxOo
    public static final void writeFile(@oOoXoXO String str, @oOoXoXO String str2) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir != null && str != null && str2 != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(instrumentReportDir, str));
                byte[] bytes = str2.getBytes(oxoX.f29581II0xO0);
                IIX0o.oO(bytes, "(this as java.lang.String).getBytes(charset)");
                fileOutputStream.write(bytes);
                fileOutputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    @x0XOIxOo
    @oOoXoXO
    public static final String getStackTrace(@OOXIXo Thread thread) {
        IIX0o.x0xO0oo(thread, "thread");
        StackTraceElement[] stackTrace = thread.getStackTrace();
        JSONArray jSONArray = new JSONArray();
        IIX0o.oO(stackTrace, "stackTrace");
        int length = stackTrace.length;
        int i = 0;
        while (i < length) {
            StackTraceElement stackTraceElement = stackTrace[i];
            i++;
            jSONArray.put(stackTraceElement.toString());
        }
        return jSONArray.toString();
    }
}
