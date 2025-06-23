package com.facebook.gamingservices.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class CustomUpdateLocalizedText {

    /* renamed from: default, reason: not valid java name */
    @OOXIXo
    private final String f3default;

    @oOoXoXO
    private final HashMap<String, String> localizations;

    public CustomUpdateLocalizedText(@OOXIXo String str, @oOoXoXO HashMap<String, String> hashMap) {
        IIX0o.x0xO0oo(str, "default");
        this.f3default = str;
        this.localizations = hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomUpdateLocalizedText copy$default(CustomUpdateLocalizedText customUpdateLocalizedText, String str, HashMap hashMap, int i, Object obj) {
        if ((i & 1) != 0) {
            str = customUpdateLocalizedText.f3default;
        }
        if ((i & 2) != 0) {
            hashMap = customUpdateLocalizedText.localizations;
        }
        return customUpdateLocalizedText.copy(str, hashMap);
    }

    @OOXIXo
    public final String component1() {
        return this.f3default;
    }

    @oOoXoXO
    public final HashMap<String, String> component2() {
        return this.localizations;
    }

    @OOXIXo
    public final CustomUpdateLocalizedText copy(@OOXIXo String str, @oOoXoXO HashMap<String, String> hashMap) {
        IIX0o.x0xO0oo(str, "default");
        return new CustomUpdateLocalizedText(str, hashMap);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomUpdateLocalizedText)) {
            return false;
        }
        CustomUpdateLocalizedText customUpdateLocalizedText = (CustomUpdateLocalizedText) obj;
        return IIX0o.Oxx0IOOO(this.f3default, customUpdateLocalizedText.f3default) && IIX0o.Oxx0IOOO(this.localizations, customUpdateLocalizedText.localizations);
    }

    @OOXIXo
    public final String getDefault() {
        return this.f3default;
    }

    @oOoXoXO
    public final HashMap<String, String> getLocalizations() {
        return this.localizations;
    }

    public int hashCode() {
        int hashCode = this.f3default.hashCode() * 31;
        HashMap<String, String> hashMap = this.localizations;
        return hashCode + (hashMap == null ? 0 : hashMap.hashCode());
    }

    @OOXIXo
    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("default", this.f3default);
        HashMap<String, String> hashMap = this.localizations;
        if (hashMap != null) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("localizations", jSONObject2);
        }
        return jSONObject;
    }

    @OOXIXo
    public String toString() {
        return "CustomUpdateLocalizedText(default=" + this.f3default + ", localizations=" + this.localizations + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ CustomUpdateLocalizedText(String str, HashMap hashMap, int i, IIXOooo iIXOooo) {
        this(str, (i & 2) != 0 ? null : hashMap);
    }
}
