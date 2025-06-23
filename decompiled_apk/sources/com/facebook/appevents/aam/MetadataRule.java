package com.facebook.appevents.aam;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import androidx.annotation.RestrictTo;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class MetadataRule {

    @OOXIXo
    private static final String FIELD_K = "k";

    @OOXIXo
    private static final String FIELD_K_DELIMITER = ",";

    @OOXIXo
    private static final String FIELD_V = "v";

    @OOXIXo
    private final List<String> keyRules;

    @OOXIXo
    private final String name;

    @OOXIXo
    private final String valRule;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final Set<MetadataRule> rules = new CopyOnWriteArraySet();

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private final void constructRules(JSONObject jSONObject) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(key);
                if (optJSONObject != null) {
                    String k = optJSONObject.optString("k");
                    String v = optJSONObject.optString("v");
                    IIX0o.oO(k, "k");
                    if (k.length() != 0) {
                        Set access$getRules$cp = MetadataRule.access$getRules$cp();
                        IIX0o.oO(key, "key");
                        List XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(k, new String[]{","}, false, 0, 6, null);
                        IIX0o.oO(v, "v");
                        access$getRules$cp.add(new MetadataRule(key, XXoO0oX2, v, null));
                    }
                }
            }
        }

        @x0XOIxOo
        @OOXIXo
        public final Set<String> getEnabledRuleNames() {
            HashSet hashSet = new HashSet();
            Iterator it = MetadataRule.access$getRules$cp().iterator();
            while (it.hasNext()) {
                hashSet.add(((MetadataRule) it.next()).getName());
            }
            return hashSet;
        }

        @x0XOIxOo
        @OOXIXo
        public final Set<MetadataRule> getRules() {
            return new HashSet(MetadataRule.access$getRules$cp());
        }

        @x0XOIxOo
        public final void updateRules(@OOXIXo String rulesFromServer) {
            IIX0o.x0xO0oo(rulesFromServer, "rulesFromServer");
            try {
                MetadataRule.access$getRules$cp().clear();
                constructRules(new JSONObject(rulesFromServer));
            } catch (JSONException unused) {
            }
        }

        private Companion() {
        }
    }

    public /* synthetic */ MetadataRule(String str, List list, String str2, IIXOooo iIXOooo) {
        this(str, list, str2);
    }

    public static final /* synthetic */ Set access$getRules$cp() {
        if (CrashShieldHandler.isObjectCrashing(MetadataRule.class)) {
            return null;
        }
        try {
            return rules;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataRule.class);
            return null;
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final Set<String> getEnabledRuleNames() {
        if (CrashShieldHandler.isObjectCrashing(MetadataRule.class)) {
            return null;
        }
        try {
            return Companion.getEnabledRuleNames();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataRule.class);
            return null;
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final Set<MetadataRule> getRules() {
        if (CrashShieldHandler.isObjectCrashing(MetadataRule.class)) {
            return null;
        }
        try {
            return Companion.getRules();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataRule.class);
            return null;
        }
    }

    @x0XOIxOo
    public static final void updateRules(@OOXIXo String str) {
        if (CrashShieldHandler.isObjectCrashing(MetadataRule.class)) {
            return;
        }
        try {
            Companion.updateRules(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataRule.class);
        }
    }

    @OOXIXo
    public final List<String> getKeyRules() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return new ArrayList(this.keyRules);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @OOXIXo
    public final String getName() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.name;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @OOXIXo
    public final String getValRule() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.valRule;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private MetadataRule(String str, List<String> list, String str2) {
        this.name = str;
        this.valRule = str2;
        this.keyRules = list;
    }
}
