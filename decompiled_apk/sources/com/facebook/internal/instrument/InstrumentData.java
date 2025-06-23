package com.facebook.internal.instrument;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.os.Build;
import androidx.annotation.RestrictTo;
import com.facebook.internal.Utility;
import java.io.File;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.OxI;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class InstrumentData {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final String PARAM_APP_VERSION = "app_version";

    @OOXIXo
    private static final String PARAM_CALLSTACK = "callstack";

    @OOXIXo
    private static final String PARAM_DEVICE_MODEL = "device_model";

    @OOXIXo
    private static final String PARAM_DEVICE_OS = "device_os_version";

    @OOXIXo
    private static final String PARAM_FEATURE_NAMES = "feature_names";

    @OOXIXo
    private static final String PARAM_REASON = "reason";

    @OOXIXo
    private static final String PARAM_TIMESTAMP = "timestamp";

    @OOXIXo
    private static final String PARAM_TYPE = "type";

    @OOXIXo
    private static final String UNKNOWN = "Unknown";

    @oOoXoXO
    private String appVersion;

    @oOoXoXO
    private String cause;

    @oOoXoXO
    private JSONArray featureNames;

    @OOXIXo
    private String filename;

    @oOoXoXO
    private String stackTrace;

    @oOoXoXO
    private Long timestamp;

    @oOoXoXO
    private Type type;

    /* loaded from: classes8.dex */
    public static final class Builder {

        @OOXIXo
        public static final Builder INSTANCE = new Builder();

        private Builder() {
        }

        @x0XOIxOo
        @OOXIXo
        public static final InstrumentData build(@oOoXoXO Throwable th, @OOXIXo Type t) {
            IIX0o.x0xO0oo(t, "t");
            return new InstrumentData(th, t, (IIXOooo) null);
        }

        @x0XOIxOo
        @OOXIXo
        public static final InstrumentData load(@OOXIXo File file) {
            IIX0o.x0xO0oo(file, "file");
            return new InstrumentData(file, (IIXOooo) null);
        }

        @x0XOIxOo
        @OOXIXo
        public static final InstrumentData build(@OOXIXo JSONArray features) {
            IIX0o.x0xO0oo(features, "features");
            return new InstrumentData(features, (IIXOooo) null);
        }

        @x0XOIxOo
        @OOXIXo
        public static final InstrumentData build(@oOoXoXO String str, @oOoXoXO String str2) {
            return new InstrumentData(str, str2, (IIXOooo) null);
        }
    }

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Type getType(String str) {
            if (OxI.IOOoXo0Ix(str, InstrumentUtility.CRASH_REPORT_PREFIX, false, 2, null)) {
                return Type.CrashReport;
            }
            if (OxI.IOOoXo0Ix(str, InstrumentUtility.CRASH_SHIELD_PREFIX, false, 2, null)) {
                return Type.CrashShield;
            }
            if (OxI.IOOoXo0Ix(str, InstrumentUtility.THREAD_CHECK_PREFIX, false, 2, null)) {
                return Type.ThreadCheck;
            }
            if (OxI.IOOoXo0Ix(str, InstrumentUtility.ANALYSIS_REPORT_PREFIX, false, 2, null)) {
                return Type.Analysis;
            }
            if (OxI.IOOoXo0Ix(str, InstrumentUtility.ANR_REPORT_PREFIX, false, 2, null)) {
                return Type.AnrReport;
            }
            return Type.Unknown;
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public enum Type {
        Unknown,
        Analysis,
        AnrReport,
        CrashReport,
        CrashShield,
        ThreadCheck;

        /* loaded from: classes8.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Type.valuesCustom().length];
                iArr[Type.Analysis.ordinal()] = 1;
                iArr[Type.AnrReport.ordinal()] = 2;
                iArr[Type.CrashReport.ordinal()] = 3;
                iArr[Type.CrashShield.ordinal()] = 4;
                iArr[Type.ThreadCheck.ordinal()] = 5;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Type[] valuesCustom() {
            Type[] valuesCustom = values();
            return (Type[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }

        @OOXIXo
        public final String getLogPrefix() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return "Unknown";
                            }
                            return InstrumentUtility.THREAD_CHECK_PREFIX;
                        }
                        return InstrumentUtility.CRASH_SHIELD_PREFIX;
                    }
                    return InstrumentUtility.CRASH_REPORT_PREFIX;
                }
                return InstrumentUtility.ANR_REPORT_PREFIX;
            }
            return InstrumentUtility.ANALYSIS_REPORT_PREFIX;
        }

        @Override // java.lang.Enum
        @OOXIXo
        public String toString() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return "Unknown";
                            }
                            return "ThreadCheck";
                        }
                        return "CrashShield";
                    }
                    return "CrashReport";
                }
                return "AnrReport";
            }
            return "Analysis";
        }
    }

    /* loaded from: classes8.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Type.valuesCustom().length];
            iArr[Type.Analysis.ordinal()] = 1;
            iArr[Type.AnrReport.ordinal()] = 2;
            iArr[Type.CrashReport.ordinal()] = 3;
            iArr[Type.CrashShield.ordinal()] = 4;
            iArr[Type.ThreadCheck.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ InstrumentData(File file, IIXOooo iIXOooo) {
        this(file);
    }

    private final JSONObject getAnalysisReportParameters() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = this.featureNames;
            if (jSONArray != null) {
                jSONObject.put(PARAM_FEATURE_NAMES, jSONArray);
            }
            Long l = this.timestamp;
            if (l != null) {
                jSONObject.put("timestamp", l);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private final JSONObject getExceptionReportParameters() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PARAM_DEVICE_OS, Build.VERSION.RELEASE);
            jSONObject.put(PARAM_DEVICE_MODEL, Build.MODEL);
            String str = this.appVersion;
            if (str != null) {
                jSONObject.put("app_version", str);
            }
            Long l = this.timestamp;
            if (l != null) {
                jSONObject.put("timestamp", l);
            }
            String str2 = this.cause;
            if (str2 != null) {
                jSONObject.put("reason", str2);
            }
            String str3 = this.stackTrace;
            if (str3 != null) {
                jSONObject.put(PARAM_CALLSTACK, str3);
            }
            Type type = this.type;
            if (type != null) {
                jSONObject.put("type", type);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private final JSONObject getParameters() {
        int i;
        Type type = this.type;
        if (type == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        }
        if (i != 1) {
            if (i != 2 && i != 3 && i != 4 && i != 5) {
                return null;
            }
            return getExceptionReportParameters();
        }
        return getAnalysisReportParameters();
    }

    public final void clear() {
        InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
        InstrumentUtility.deleteFile(this.filename);
    }

    public final int compareTo(@OOXIXo InstrumentData data) {
        IIX0o.x0xO0oo(data, "data");
        Long l = this.timestamp;
        if (l == null) {
            return -1;
        }
        long longValue = l.longValue();
        Long l2 = data.timestamp;
        if (l2 == null) {
            return 1;
        }
        return IIX0o.OxxIIOOXO(l2.longValue(), longValue);
    }

    public final boolean isValid() {
        int i;
        Type type = this.type;
        if (type == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        }
        if (i != 1) {
            if (i != 2) {
                if ((i != 3 && i != 4 && i != 5) || this.stackTrace == null || this.timestamp == null) {
                    return false;
                }
            } else if (this.stackTrace == null || this.cause == null || this.timestamp == null) {
                return false;
            }
        } else if (this.featureNames == null || this.timestamp == null) {
            return false;
        }
        return true;
    }

    public final void save() {
        if (!isValid()) {
            return;
        }
        InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
        InstrumentUtility.writeFile(this.filename, toString());
    }

    @OOXIXo
    public String toString() {
        JSONObject parameters = getParameters();
        if (parameters == null) {
            String jSONObject = new JSONObject().toString();
            IIX0o.oO(jSONObject, "JSONObject().toString()");
            return jSONObject;
        }
        String jSONObject2 = parameters.toString();
        IIX0o.oO(jSONObject2, "params.toString()");
        return jSONObject2;
    }

    public /* synthetic */ InstrumentData(String str, String str2, IIXOooo iIXOooo) {
        this(str, str2);
    }

    public /* synthetic */ InstrumentData(Throwable th, Type type, IIXOooo iIXOooo) {
        this(th, type);
    }

    public /* synthetic */ InstrumentData(JSONArray jSONArray, IIXOooo iIXOooo) {
        this(jSONArray);
    }

    private InstrumentData(JSONArray jSONArray) {
        this.type = Type.Analysis;
        this.timestamp = Long.valueOf(System.currentTimeMillis() / 1000);
        this.featureNames = jSONArray;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(InstrumentUtility.ANALYSIS_REPORT_PREFIX);
        stringBuffer.append(String.valueOf(this.timestamp));
        stringBuffer.append(".json");
        String stringBuffer2 = stringBuffer.toString();
        IIX0o.oO(stringBuffer2, "StringBuffer()\n            .append(InstrumentUtility.ANALYSIS_REPORT_PREFIX)\n            .append(timestamp.toString())\n            .append(\".json\")\n            .toString()");
        this.filename = stringBuffer2;
    }

    private InstrumentData(Throwable th, Type type) {
        this.type = type;
        Utility utility = Utility.INSTANCE;
        this.appVersion = Utility.getAppVersion();
        InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
        this.cause = InstrumentUtility.getCause(th);
        this.stackTrace = InstrumentUtility.getStackTrace(th);
        this.timestamp = Long.valueOf(System.currentTimeMillis() / 1000);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(type.getLogPrefix());
        stringBuffer.append(String.valueOf(this.timestamp));
        stringBuffer.append(".json");
        String stringBuffer2 = stringBuffer.toString();
        IIX0o.oO(stringBuffer2, "StringBuffer().append(t.logPrefix).append(timestamp.toString()).append(\".json\").toString()");
        this.filename = stringBuffer2;
    }

    private InstrumentData(String str, String str2) {
        this.type = Type.AnrReport;
        Utility utility = Utility.INSTANCE;
        this.appVersion = Utility.getAppVersion();
        this.cause = str;
        this.stackTrace = str2;
        this.timestamp = Long.valueOf(System.currentTimeMillis() / 1000);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(InstrumentUtility.ANR_REPORT_PREFIX);
        stringBuffer.append(String.valueOf(this.timestamp));
        stringBuffer.append(".json");
        String stringBuffer2 = stringBuffer.toString();
        IIX0o.oO(stringBuffer2, "StringBuffer()\n            .append(InstrumentUtility.ANR_REPORT_PREFIX)\n            .append(timestamp.toString())\n            .append(\".json\")\n            .toString()");
        this.filename = stringBuffer2;
    }

    private InstrumentData(File file) {
        String name = file.getName();
        IIX0o.oO(name, "file.name");
        this.filename = name;
        this.type = Companion.getType(name);
        InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
        JSONObject readFile = InstrumentUtility.readFile(this.filename, true);
        if (readFile != null) {
            this.timestamp = Long.valueOf(readFile.optLong("timestamp", 0L));
            this.appVersion = readFile.optString("app_version", null);
            this.cause = readFile.optString("reason", null);
            this.stackTrace = readFile.optString(PARAM_CALLSTACK, null);
            this.featureNames = readFile.optJSONArray(PARAM_FEATURE_NAMES);
        }
    }
}
