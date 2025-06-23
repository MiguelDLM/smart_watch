package com.facebook.appevents.codeless.internal;

import OXOo.OOXIXo;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class ParameterComponent {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final String PARAMETER_NAME_KEY = "name";

    @OOXIXo
    private static final String PARAMETER_PATH_KEY = "path";

    @OOXIXo
    private static final String PARAMETER_VALUE_KEY = "value";

    @OOXIXo
    private final String name;

    @OOXIXo
    private final List<PathComponent> path;

    @OOXIXo
    private final String pathType;

    @OOXIXo
    private final String value;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public ParameterComponent(@OOXIXo JSONObject component) {
        int length;
        IIX0o.x0xO0oo(component, "component");
        String string = component.getString("name");
        IIX0o.oO(string, "component.getString(PARAMETER_NAME_KEY)");
        this.name = string;
        String optString = component.optString("value");
        IIX0o.oO(optString, "component.optString(PARAMETER_VALUE_KEY)");
        this.value = optString;
        String optString2 = component.optString(Constants.EVENT_MAPPING_PATH_TYPE_KEY, Constants.PATH_TYPE_ABSOLUTE);
        IIX0o.oO(optString2, "component.optString(Constants.EVENT_MAPPING_PATH_TYPE_KEY, Constants.PATH_TYPE_ABSOLUTE)");
        this.pathType = optString2;
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = component.optJSONArray("path");
        if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                JSONObject jSONObject = optJSONArray.getJSONObject(i);
                IIX0o.oO(jSONObject, "jsonPathArray.getJSONObject(i)");
                arrayList.add(new PathComponent(jSONObject));
                if (i2 >= length) {
                    break;
                } else {
                    i = i2;
                }
            }
        }
        this.path = arrayList;
    }

    @OOXIXo
    public final String getName() {
        return this.name;
    }

    @OOXIXo
    public final List<PathComponent> getPath() {
        return this.path;
    }

    @OOXIXo
    public final String getPathType() {
        return this.pathType;
    }

    @OOXIXo
    public final String getValue() {
        return this.value;
    }
}
