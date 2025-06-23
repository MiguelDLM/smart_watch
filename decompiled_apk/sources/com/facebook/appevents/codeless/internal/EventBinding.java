package com.facebook.appevents.codeless.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import com.baidu.ar.constants.HttpConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class EventBinding {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private final String activityName;

    @OOXIXo
    private final String appVersion;

    @OOXIXo
    private final String componentId;

    @OOXIXo
    private final String eventName;

    @OOXIXo
    private final MappingMethod method;

    @OOXIXo
    private final List<ParameterComponent> parameters;

    @OOXIXo
    private final List<PathComponent> path;

    @OOXIXo
    private final String pathType;

    @OOXIXo
    private final ActionType type;

    /* loaded from: classes8.dex */
    public enum ActionType {
        CLICK,
        SELECTED,
        TEXT_CHANGED;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static ActionType[] valuesCustom() {
            ActionType[] valuesCustom = values();
            return (ActionType[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OOXIXo
        public final EventBinding getInstanceFromJson(@OOXIXo JSONObject mapping) throws JSONException, IllegalArgumentException {
            int length;
            IIX0o.x0xO0oo(mapping, "mapping");
            String eventName = mapping.getString("event_name");
            String string = mapping.getString("method");
            IIX0o.oO(string, "mapping.getString(\"method\")");
            Locale ENGLISH = Locale.ENGLISH;
            IIX0o.oO(ENGLISH, "ENGLISH");
            String upperCase = string.toUpperCase(ENGLISH);
            IIX0o.oO(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            MappingMethod valueOf = MappingMethod.valueOf(upperCase);
            String string2 = mapping.getString("event_type");
            IIX0o.oO(string2, "mapping.getString(\"event_type\")");
            IIX0o.oO(ENGLISH, "ENGLISH");
            String upperCase2 = string2.toUpperCase(ENGLISH);
            IIX0o.oO(upperCase2, "(this as java.lang.String).toUpperCase(locale)");
            ActionType valueOf2 = ActionType.valueOf(upperCase2);
            String appVersion = mapping.getString(HttpConstants.APP_VERSION);
            JSONArray jSONArray = mapping.getJSONArray("path");
            ArrayList arrayList = new ArrayList();
            int length2 = jSONArray.length();
            int i = 0;
            if (length2 > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    JSONObject jsonPath = jSONArray.getJSONObject(i2);
                    IIX0o.oO(jsonPath, "jsonPath");
                    arrayList.add(new PathComponent(jsonPath));
                    if (i3 >= length2) {
                        break;
                    }
                    i2 = i3;
                }
            }
            String pathType = mapping.optString(Constants.EVENT_MAPPING_PATH_TYPE_KEY, Constants.PATH_TYPE_ABSOLUTE);
            JSONArray optJSONArray = mapping.optJSONArray("parameters");
            ArrayList arrayList2 = new ArrayList();
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                while (true) {
                    int i4 = i + 1;
                    JSONObject jsonParameter = optJSONArray.getJSONObject(i);
                    IIX0o.oO(jsonParameter, "jsonParameter");
                    arrayList2.add(new ParameterComponent(jsonParameter));
                    if (i4 >= length) {
                        break;
                    }
                    i = i4;
                }
            }
            String componentId = mapping.optString("component_id");
            String activityName = mapping.optString("activity_name");
            IIX0o.oO(eventName, "eventName");
            IIX0o.oO(appVersion, "appVersion");
            IIX0o.oO(componentId, "componentId");
            IIX0o.oO(pathType, "pathType");
            IIX0o.oO(activityName, "activityName");
            return new EventBinding(eventName, valueOf, valueOf2, appVersion, arrayList, arrayList2, componentId, pathType, activityName);
        }

        @x0XOIxOo
        @OOXIXo
        public final List<EventBinding> parseArray(@oOoXoXO JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                try {
                    int length = jSONArray.length();
                    if (length > 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i + 1;
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            IIX0o.oO(jSONObject, "array.getJSONObject(i)");
                            arrayList.add(getInstanceFromJson(jSONObject));
                            if (i2 >= length) {
                                break;
                            }
                            i = i2;
                        }
                    }
                } catch (IllegalArgumentException | JSONException unused) {
                }
            }
            return arrayList;
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public enum MappingMethod {
        MANUAL,
        INFERENCE;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static MappingMethod[] valuesCustom() {
            MappingMethod[] valuesCustom = values();
            return (MappingMethod[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    public EventBinding(@OOXIXo String eventName, @OOXIXo MappingMethod method, @OOXIXo ActionType type, @OOXIXo String appVersion, @OOXIXo List<PathComponent> path, @OOXIXo List<ParameterComponent> parameters, @OOXIXo String componentId, @OOXIXo String pathType, @OOXIXo String activityName) {
        IIX0o.x0xO0oo(eventName, "eventName");
        IIX0o.x0xO0oo(method, "method");
        IIX0o.x0xO0oo(type, "type");
        IIX0o.x0xO0oo(appVersion, "appVersion");
        IIX0o.x0xO0oo(path, "path");
        IIX0o.x0xO0oo(parameters, "parameters");
        IIX0o.x0xO0oo(componentId, "componentId");
        IIX0o.x0xO0oo(pathType, "pathType");
        IIX0o.x0xO0oo(activityName, "activityName");
        this.eventName = eventName;
        this.method = method;
        this.type = type;
        this.appVersion = appVersion;
        this.path = path;
        this.parameters = parameters;
        this.componentId = componentId;
        this.pathType = pathType;
        this.activityName = activityName;
    }

    @x0XOIxOo
    @OOXIXo
    public static final EventBinding getInstanceFromJson(@OOXIXo JSONObject jSONObject) throws JSONException, IllegalArgumentException {
        return Companion.getInstanceFromJson(jSONObject);
    }

    @x0XOIxOo
    @OOXIXo
    public static final List<EventBinding> parseArray(@oOoXoXO JSONArray jSONArray) {
        return Companion.parseArray(jSONArray);
    }

    @OOXIXo
    public final String getActivityName() {
        return this.activityName;
    }

    @OOXIXo
    public final String getAppVersion() {
        return this.appVersion;
    }

    @OOXIXo
    public final String getComponentId() {
        return this.componentId;
    }

    @OOXIXo
    public final String getEventName() {
        return this.eventName;
    }

    @OOXIXo
    public final MappingMethod getMethod() {
        return this.method;
    }

    @OOXIXo
    public final String getPathType() {
        return this.pathType;
    }

    @OOXIXo
    public final ActionType getType() {
        return this.type;
    }

    @OOXIXo
    public final List<ParameterComponent> getViewParameters() {
        List<ParameterComponent> unmodifiableList = Collections.unmodifiableList(this.parameters);
        IIX0o.oO(unmodifiableList, "unmodifiableList(parameters)");
        return unmodifiableList;
    }

    @OOXIXo
    public final List<PathComponent> getViewPath() {
        List<PathComponent> unmodifiableList = Collections.unmodifiableList(this.path);
        IIX0o.oO(unmodifiableList, "unmodifiableList(path)");
        return unmodifiableList;
    }
}
