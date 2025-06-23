package com.facebook.appevents.ml;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.szabh.smable3.entity.Languages;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.collections.oI0IIXIo;
import kotlin.collections.oOXoIIIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes8.dex */
public final class ModelManager {

    @OOXIXo
    private static final String ASSET_URI_KEY = "asset_uri";

    @OOXIXo
    private static final String CACHE_KEY_MODELS = "models";

    @OOXIXo
    private static final String CACHE_KEY_REQUEST_TIMESTAMP = "model_request_timestamp";

    @OOXIXo
    private static final String MODEL_ASSERT_STORE = "com.facebook.internal.MODEL_STORE";
    private static final int MODEL_REQUEST_INTERVAL_MILLISECONDS = 259200000;

    @OOXIXo
    private static final String MTML_USE_CASE = "MTML";

    @OOXIXo
    private static final String RULES_URI_KEY = "rules_uri";

    @OOXIXo
    private static final String SDK_MODEL_ASSET = "%s/model_asset";

    @OOXIXo
    private static final String THRESHOLD_KEY = "thresholds";

    @OOXIXo
    private static final String USE_CASE_KEY = "use_case";

    @OOXIXo
    private static final String VERSION_ID_KEY = "version_id";

    @OOXIXo
    public static final ModelManager INSTANCE = new ModelManager();

    @OOXIXo
    private static final Map<String, TaskHandler> taskHandlers = new ConcurrentHashMap();

    @OOXIXo
    private static final List<String> MTML_SUGGESTED_EVENTS_PREDICTION = CollectionsKt__CollectionsKt.X00IoxXI("other", AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, AppEventsConstants.EVENT_NAME_ADDED_TO_CART, AppEventsConstants.EVENT_NAME_PURCHASED, AppEventsConstants.EVENT_NAME_INITIATED_CHECKOUT);

    @OOXIXo
    private static final List<String> MTML_INTEGRITY_DETECT_PREDICTION = CollectionsKt__CollectionsKt.X00IoxXI("none", "address", IntegrityManager.INTEGRITY_TYPE_HEALTH);

    /* loaded from: classes8.dex */
    public enum Task {
        MTML_INTEGRITY_DETECT,
        MTML_APP_EVENT_PREDICTION;

        /* loaded from: classes8.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Task.valuesCustom().length];
                iArr[Task.MTML_INTEGRITY_DETECT.ordinal()] = 1;
                iArr[Task.MTML_APP_EVENT_PREDICTION.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Task[] valuesCustom() {
            Task[] valuesCustom = values();
            return (Task[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }

        @OOXIXo
        public final String toKey() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return "app_event_pred";
                }
                throw new NoWhenBranchMatchedException();
            }
            return "integrity_detect";
        }

        @OOXIXo
        public final String toUseCase() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return "MTML_APP_EVENT_PRED";
                }
                throw new NoWhenBranchMatchedException();
            }
            return "MTML_INTEGRITY_DETECT";
        }
    }

    /* loaded from: classes8.dex */
    public static final class TaskHandler {

        @OOXIXo
        public static final Companion Companion = new Companion(null);

        @OOXIXo
        private String assetUri;

        @oOoXoXO
        private Model model;

        @oOoXoXO
        private Runnable onPostExecute;

        @oOoXoXO
        private File ruleFile;

        @oOoXoXO
        private String ruleUri;

        @oOoXoXO
        private float[] thresholds;

        @OOXIXo
        private String useCase;
        private int versionId;

        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            private final void deleteOldFiles(String str, int i) {
                File[] listFiles;
                Utils utils = Utils.INSTANCE;
                File mlDir = Utils.getMlDir();
                if (mlDir != null && (listFiles = mlDir.listFiles()) != null && listFiles.length != 0) {
                    String str2 = str + '_' + i;
                    int length = listFiles.length;
                    int i2 = 0;
                    while (i2 < length) {
                        File file = listFiles[i2];
                        i2++;
                        String name = file.getName();
                        IIX0o.oO(name, "name");
                        if (OxI.IOOoXo0Ix(name, str, false, 2, null) && !OxI.IOOoXo0Ix(name, str2, false, 2, null)) {
                            file.delete();
                        }
                    }
                }
            }

            private final void download(String str, String str2, FileDownloadTask.Callback callback) {
                Utils utils = Utils.INSTANCE;
                File file = new File(Utils.getMlDir(), str2);
                if (str != null && !file.exists()) {
                    new FileDownloadTask(str, file, callback).execute(new String[0]);
                } else {
                    callback.onComplete(file);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: execute$lambda-1, reason: not valid java name */
            public static final void m170execute$lambda1(List slaves, File file) {
                IIX0o.x0xO0oo(slaves, "$slaves");
                IIX0o.x0xO0oo(file, "file");
                final Model build = Model.Companion.build(file);
                if (build != null) {
                    Iterator it = slaves.iterator();
                    while (it.hasNext()) {
                        final TaskHandler taskHandler = (TaskHandler) it.next();
                        TaskHandler.Companion.download(taskHandler.getRuleUri(), taskHandler.getUseCase() + '_' + taskHandler.getVersionId() + "_rule", new FileDownloadTask.Callback() { // from class: com.facebook.appevents.ml.oxoX
                            @Override // com.facebook.appevents.internal.FileDownloadTask.Callback
                            public final void onComplete(File file2) {
                                ModelManager.TaskHandler.Companion.m171execute$lambda1$lambda0(ModelManager.TaskHandler.this, build, file2);
                            }
                        });
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: execute$lambda-1$lambda-0, reason: not valid java name */
            public static final void m171execute$lambda1$lambda0(TaskHandler slave, Model model, File file) {
                IIX0o.x0xO0oo(slave, "$slave");
                IIX0o.x0xO0oo(file, "file");
                slave.setModel(model);
                slave.setRuleFile(file);
                Runnable runnable = slave.onPostExecute;
                if (runnable != null) {
                    runnable.run();
                }
            }

            @oOoXoXO
            public final TaskHandler build(@oOoXoXO JSONObject jSONObject) {
                String useCase;
                String assetUri;
                String optString;
                int i;
                float[] access$parseJsonArray;
                if (jSONObject != null) {
                    try {
                        useCase = jSONObject.getString(ModelManager.USE_CASE_KEY);
                        assetUri = jSONObject.getString(ModelManager.ASSET_URI_KEY);
                        optString = jSONObject.optString(ModelManager.RULES_URI_KEY, null);
                        i = jSONObject.getInt(ModelManager.VERSION_ID_KEY);
                        access$parseJsonArray = ModelManager.access$parseJsonArray(ModelManager.INSTANCE, jSONObject.getJSONArray(ModelManager.THRESHOLD_KEY));
                        IIX0o.oO(useCase, "useCase");
                        IIX0o.oO(assetUri, "assetUri");
                    } catch (Exception unused) {
                        return null;
                    }
                }
                return new TaskHandler(useCase, assetUri, optString, i, access$parseJsonArray);
            }

            public final void execute(@OOXIXo TaskHandler handler) {
                IIX0o.x0xO0oo(handler, "handler");
                execute(handler, oI0IIXIo.OOXIXo(handler));
            }

            private Companion() {
            }

            public final void execute(@OOXIXo TaskHandler master, @OOXIXo final List<TaskHandler> slaves) {
                IIX0o.x0xO0oo(master, "master");
                IIX0o.x0xO0oo(slaves, "slaves");
                deleteOldFiles(master.getUseCase(), master.getVersionId());
                download(master.getAssetUri(), master.getUseCase() + '_' + master.getVersionId(), new FileDownloadTask.Callback() { // from class: com.facebook.appevents.ml.X0o0xo
                    @Override // com.facebook.appevents.internal.FileDownloadTask.Callback
                    public final void onComplete(File file) {
                        ModelManager.TaskHandler.Companion.m170execute$lambda1(slaves, file);
                    }
                });
            }
        }

        public TaskHandler(@OOXIXo String useCase, @OOXIXo String assetUri, @oOoXoXO String str, int i, @oOoXoXO float[] fArr) {
            IIX0o.x0xO0oo(useCase, "useCase");
            IIX0o.x0xO0oo(assetUri, "assetUri");
            this.useCase = useCase;
            this.assetUri = assetUri;
            this.ruleUri = str;
            this.versionId = i;
            this.thresholds = fArr;
        }

        @OOXIXo
        public final String getAssetUri() {
            return this.assetUri;
        }

        @oOoXoXO
        public final Model getModel() {
            return this.model;
        }

        @oOoXoXO
        public final File getRuleFile() {
            return this.ruleFile;
        }

        @oOoXoXO
        public final String getRuleUri() {
            return this.ruleUri;
        }

        @oOoXoXO
        public final float[] getThresholds() {
            return this.thresholds;
        }

        @OOXIXo
        public final String getUseCase() {
            return this.useCase;
        }

        public final int getVersionId() {
            return this.versionId;
        }

        public final void setAssetUri(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.assetUri = str;
        }

        public final void setModel(@oOoXoXO Model model) {
            this.model = model;
        }

        @OOXIXo
        public final TaskHandler setOnPostExecute(@oOoXoXO Runnable runnable) {
            this.onPostExecute = runnable;
            return this;
        }

        public final void setRuleFile(@oOoXoXO File file) {
            this.ruleFile = file;
        }

        public final void setRuleUri(@oOoXoXO String str) {
            this.ruleUri = str;
        }

        public final void setThresholds(@oOoXoXO float[] fArr) {
            this.thresholds = fArr;
        }

        public final void setUseCase(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.useCase = str;
        }

        public final void setVersionId(int i) {
            this.versionId = i;
        }
    }

    /* loaded from: classes8.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Task.valuesCustom().length];
            iArr[Task.MTML_APP_EVENT_PREDICTION.ordinal()] = 1;
            iArr[Task.MTML_INTEGRITY_DETECT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ModelManager() {
    }

    public static final /* synthetic */ float[] access$parseJsonArray(ModelManager modelManager, JSONArray jSONArray) {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return null;
        }
        try {
            return modelManager.parseJsonArray(jSONArray);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
            return null;
        }
    }

    private final void addModels(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                try {
                    TaskHandler build = TaskHandler.Companion.build(jSONObject.getJSONObject(keys.next()));
                    if (build != null) {
                        taskHandlers.put(build.getUseCase(), build);
                    }
                } catch (JSONException unused) {
                    return;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @x0XOIxOo
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return;
        }
        try {
            Utility utility = Utility.INSTANCE;
            Utility.runOnNonUiThread(new Runnable() { // from class: com.facebook.appevents.ml.I0Io
                @Override // java.lang.Runnable
                public final void run() {
                    ModelManager.m167enable$lambda0();
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005c A[Catch: all -> 0x002e, Exception -> 0x007f, TryCatch #2 {Exception -> 0x007f, all -> 0x002e, blocks: (B:6:0x000d, B:8:0x0021, B:11:0x0028, B:12:0x0035, B:14:0x0045, B:16:0x004b, B:18:0x0073, B:21:0x0053, B:24:0x005c, B:25:0x0030), top: B:5:0x000d }] */
    /* renamed from: enable$lambda-0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m167enable$lambda0() {
        /*
            java.lang.String r0 = "model_request_timestamp"
            java.lang.String r1 = "models"
            java.lang.Class<com.facebook.appevents.ml.ModelManager> r2 = com.facebook.appevents.ml.ModelManager.class
            boolean r3 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r2)
            if (r3 == 0) goto Ld
            return
        Ld:
            com.facebook.FacebookSdk r3 = com.facebook.FacebookSdk.INSTANCE     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            android.content.Context r3 = com.facebook.FacebookSdk.getApplicationContext()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            java.lang.String r4 = "com.facebook.internal.MODEL_STORE"
            r5 = 0
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r5)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            r4 = 0
            java.lang.String r4 = r3.getString(r1, r4)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            if (r4 == 0) goto L30
            int r5 = r4.length()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            if (r5 != 0) goto L28
            goto L30
        L28:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            goto L35
        L2e:
            r0 = move-exception
            goto L7c
        L30:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            r5.<init>()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
        L35:
            r6 = 0
            long r6 = r3.getLong(r0, r6)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            com.facebook.internal.FeatureManager r4 = com.facebook.internal.FeatureManager.INSTANCE     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            com.facebook.internal.FeatureManager$Feature r4 = com.facebook.internal.FeatureManager.Feature.ModelRequest     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            boolean r4 = com.facebook.internal.FeatureManager.isEnabled(r4)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            if (r4 == 0) goto L53
            int r4 = r5.length()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            if (r4 == 0) goto L53
            com.facebook.appevents.ml.ModelManager r4 = com.facebook.appevents.ml.ModelManager.INSTANCE     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            boolean r4 = r4.isValidTimestamp(r6)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            if (r4 != 0) goto L73
        L53:
            com.facebook.appevents.ml.ModelManager r4 = com.facebook.appevents.ml.ModelManager.INSTANCE     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            org.json.JSONObject r5 = r4.fetchModels()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            if (r5 != 0) goto L5c
            return
        L5c:
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            android.content.SharedPreferences$Editor r1 = r3.putString(r1, r4)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            android.content.SharedPreferences$Editor r0 = r1.putLong(r0, r3)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            r0.apply()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
        L73:
            com.facebook.appevents.ml.ModelManager r0 = com.facebook.appevents.ml.ModelManager.INSTANCE     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            r0.addModels(r5)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            r0.enableMTML()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7f
            goto L7f
        L7c:
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r2)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.ml.ModelManager.m167enable$lambda0():void");
    }

    private final void enableMTML() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            String str = null;
            int i = 0;
            for (Map.Entry<String, TaskHandler> entry : taskHandlers.entrySet()) {
                String key = entry.getKey();
                TaskHandler value = entry.getValue();
                if (IIX0o.Oxx0IOOO(key, Task.MTML_APP_EVENT_PREDICTION.toUseCase())) {
                    String assetUri = value.getAssetUri();
                    int max = Math.max(i, value.getVersionId());
                    FeatureManager featureManager = FeatureManager.INSTANCE;
                    if (FeatureManager.isEnabled(FeatureManager.Feature.SuggestedEvents) && isLocaleEnglish()) {
                        arrayList.add(value.setOnPostExecute(new Runnable() { // from class: com.facebook.appevents.ml.oIX0oI
                            @Override // java.lang.Runnable
                            public final void run() {
                                ModelManager.m168enableMTML$lambda1();
                            }
                        }));
                    }
                    str = assetUri;
                    i = max;
                }
                if (IIX0o.Oxx0IOOO(key, Task.MTML_INTEGRITY_DETECT.toUseCase())) {
                    str = value.getAssetUri();
                    i = Math.max(i, value.getVersionId());
                    FeatureManager featureManager2 = FeatureManager.INSTANCE;
                    if (FeatureManager.isEnabled(FeatureManager.Feature.IntelligentIntegrity)) {
                        arrayList.add(value.setOnPostExecute(new Runnable() { // from class: com.facebook.appevents.ml.II0xO0
                            @Override // java.lang.Runnable
                            public final void run() {
                                ModelManager.m169enableMTML$lambda2();
                            }
                        }));
                    }
                }
            }
            if (str != null && i > 0 && !arrayList.isEmpty()) {
                TaskHandler.Companion.execute(new TaskHandler(MTML_USE_CASE, str, null, i, null), arrayList);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: enableMTML$lambda-1, reason: not valid java name */
    public static final void m168enableMTML$lambda1() {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return;
        }
        try {
            SuggestedEventsManager suggestedEventsManager = SuggestedEventsManager.INSTANCE;
            SuggestedEventsManager.enable();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: enableMTML$lambda-2, reason: not valid java name */
    public static final void m169enableMTML$lambda2() {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return;
        }
        try {
            IntegrityManager integrityManager = IntegrityManager.INSTANCE;
            IntegrityManager.enable();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
        }
    }

    private final JSONObject fetchModels() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            String[] strArr = {USE_CASE_KEY, VERSION_ID_KEY, ASSET_URI_KEY, RULES_URI_KEY, THRESHOLD_KEY};
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, TextUtils.join(",", strArr));
            GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(null, "app/model_asset", null);
            newGraphPathRequest.setParameters(bundle);
            JSONObject jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
            if (jSONObject == null) {
                return null;
            }
            return parseRawJsonObject(jSONObject);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @x0XOIxOo
    @oOoXoXO
    public static final File getRuleFile(@OOXIXo Task task) {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(task, "task");
            TaskHandler taskHandler = taskHandlers.get(task.toUseCase());
            if (taskHandler == null) {
                return null;
            }
            return taskHandler.getRuleFile();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
            return null;
        }
    }

    private final boolean isLocaleEnglish() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Utility utility = Utility.INSTANCE;
            Locale resourceLocale = Utility.getResourceLocale();
            if (resourceLocale != null) {
                String language = resourceLocale.getLanguage();
                IIX0o.oO(language, "locale.language");
                if (!StringsKt__StringsKt.o00xOoIO(language, Languages.DEFAULT_LANGUAGE, false, 2, null)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final boolean isValidTimestamp(long j) {
        if (CrashShieldHandler.isObjectCrashing(this) || j == 0) {
            return false;
        }
        try {
            if (System.currentTimeMillis() - j >= 259200000) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final float[] parseJsonArray(JSONArray jSONArray) {
        if (CrashShieldHandler.isObjectCrashing(this) || jSONArray == null) {
            return null;
        }
        try {
            float[] fArr = new float[jSONArray.length()];
            int length = jSONArray.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    try {
                        String string = jSONArray.getString(i);
                        IIX0o.oO(string, "jsonArray.getString(i)");
                        fArr[i] = Float.parseFloat(string);
                    } catch (JSONException unused) {
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            return fArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final JSONObject parseRawJsonObject(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                int length = jSONArray.length();
                if (length > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put(VERSION_ID_KEY, jSONObject3.getString(VERSION_ID_KEY));
                        jSONObject4.put(USE_CASE_KEY, jSONObject3.getString(USE_CASE_KEY));
                        jSONObject4.put(THRESHOLD_KEY, jSONObject3.getJSONArray(THRESHOLD_KEY));
                        jSONObject4.put(ASSET_URI_KEY, jSONObject3.getString(ASSET_URI_KEY));
                        if (jSONObject3.has(RULES_URI_KEY)) {
                            jSONObject4.put(RULES_URI_KEY, jSONObject3.getString(RULES_URI_KEY));
                        }
                        jSONObject2.put(jSONObject3.getString(USE_CASE_KEY), jSONObject4);
                        if (i2 < length) {
                            i = i2;
                        } else {
                            return jSONObject2;
                        }
                    }
                } else {
                    return jSONObject2;
                }
            } catch (JSONException unused) {
                return new JSONObject();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @x0XOIxOo
    @oOoXoXO
    public static final String[] predict(@OOXIXo Task task, @OOXIXo float[][] denses, @OOXIXo String[] texts) {
        Model model;
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(task, "task");
            IIX0o.x0xO0oo(denses, "denses");
            IIX0o.x0xO0oo(texts, "texts");
            TaskHandler taskHandler = taskHandlers.get(task.toUseCase());
            if (taskHandler == null) {
                model = null;
            } else {
                model = taskHandler.getModel();
            }
            if (model == null) {
                return null;
            }
            float[] thresholds = taskHandler.getThresholds();
            int length = texts.length;
            int length2 = denses[0].length;
            MTensor mTensor = new MTensor(new int[]{length, length2});
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    System.arraycopy(denses[i], 0, mTensor.getData(), i * length2, length2);
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            MTensor predictOnMTML = model.predictOnMTML(mTensor, texts, task.toKey());
            if (predictOnMTML != null && thresholds != null && predictOnMTML.getData().length != 0 && thresholds.length != 0) {
                int i3 = WhenMappings.$EnumSwitchMapping$0[task.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        return INSTANCE.processIntegrityDetectionResult(predictOnMTML, thresholds);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return INSTANCE.processSuggestedEventResult(predictOnMTML, thresholds);
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
            return null;
        }
    }

    private final String[] processIntegrityDetectionResult(MTensor mTensor, float[] fArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int shape = mTensor.getShape(0);
            int shape2 = mTensor.getShape(1);
            float[] data = mTensor.getData();
            if (shape2 != fArr.length) {
                return null;
            }
            X0.oOoXoXO X00xOoXI2 = X0.IIXOooo.X00xOoXI(0, shape);
            ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(X00xOoXI2, 10));
            Iterator<Integer> it = X00xOoXI2.iterator();
            while (it.hasNext()) {
                int nextInt = ((oOXoIIIo) it).nextInt();
                String str = "none";
                int length = fArr.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    int i3 = i2 + 1;
                    if (data[(nextInt * shape2) + i2] >= fArr[i]) {
                        str = MTML_INTEGRITY_DETECT_PREDICTION.get(i2);
                    }
                    i++;
                    i2 = i3;
                }
                arrayList.add(str);
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final String[] processSuggestedEventResult(MTensor mTensor, float[] fArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int shape = mTensor.getShape(0);
            int shape2 = mTensor.getShape(1);
            float[] data = mTensor.getData();
            if (shape2 != fArr.length) {
                return null;
            }
            X0.oOoXoXO X00xOoXI2 = X0.IIXOooo.X00xOoXI(0, shape);
            ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(X00xOoXI2, 10));
            Iterator<Integer> it = X00xOoXI2.iterator();
            while (it.hasNext()) {
                int nextInt = ((oOXoIIIo) it).nextInt();
                String str = "other";
                int length = fArr.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    int i3 = i2 + 1;
                    if (data[(nextInt * shape2) + i2] >= fArr[i]) {
                        str = MTML_SUGGESTED_EVENTS_PREDICTION.get(i2);
                    }
                    i++;
                    i2 = i3;
                }
                arrayList.add(str);
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
