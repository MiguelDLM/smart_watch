package com.facebook.appevents.codeless.internal;

import OXOo.OOXIXo;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class PathComponent {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final String PATH_CLASS_NAME_KEY = "class_name";

    @OOXIXo
    private static final String PATH_DESCRIPTION_KEY = "description";

    @OOXIXo
    private static final String PATH_HINT_KEY = "hint";

    @OOXIXo
    private static final String PATH_ID_KEY = "id";

    @OOXIXo
    private static final String PATH_INDEX_KEY = "index";

    @OOXIXo
    private static final String PATH_MATCH_BITMASK_KEY = "match_bitmask";

    @OOXIXo
    private static final String PATH_TAG_KEY = "tag";

    @OOXIXo
    private static final String PATH_TEXT_KEY = "text";

    @OOXIXo
    private final String className;

    @OOXIXo
    private final String description;

    @OOXIXo
    private final String hint;
    private final int id;
    private final int index;
    private final int matchBitmask;

    @OOXIXo
    private final String tag;

    @OOXIXo
    private final String text;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public enum MatchBitmaskType {
        ID(1),
        TEXT(2),
        TAG(4),
        DESCRIPTION(8),
        HINT(16);

        private final int value;

        MatchBitmaskType(int i) {
            this.value = i;
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static MatchBitmaskType[] valuesCustom() {
            MatchBitmaskType[] valuesCustom = values();
            return (MatchBitmaskType[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }

        public final int getValue() {
            return this.value;
        }
    }

    public PathComponent(@OOXIXo JSONObject component) {
        IIX0o.x0xO0oo(component, "component");
        String string = component.getString(PATH_CLASS_NAME_KEY);
        IIX0o.oO(string, "component.getString(PATH_CLASS_NAME_KEY)");
        this.className = string;
        this.index = component.optInt("index", -1);
        this.id = component.optInt("id");
        String optString = component.optString("text");
        IIX0o.oO(optString, "component.optString(PATH_TEXT_KEY)");
        this.text = optString;
        String optString2 = component.optString("tag");
        IIX0o.oO(optString2, "component.optString(PATH_TAG_KEY)");
        this.tag = optString2;
        String optString3 = component.optString("description");
        IIX0o.oO(optString3, "component.optString(PATH_DESCRIPTION_KEY)");
        this.description = optString3;
        String optString4 = component.optString("hint");
        IIX0o.oO(optString4, "component.optString(PATH_HINT_KEY)");
        this.hint = optString4;
        this.matchBitmask = component.optInt(PATH_MATCH_BITMASK_KEY);
    }

    @OOXIXo
    public final String getClassName() {
        return this.className;
    }

    @OOXIXo
    public final String getDescription() {
        return this.description;
    }

    @OOXIXo
    public final String getHint() {
        return this.hint;
    }

    public final int getId() {
        return this.id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getMatchBitmask() {
        return this.matchBitmask;
    }

    @OOXIXo
    public final String getTag() {
        return this.tag;
    }

    @OOXIXo
    public final String getText() {
        return this.text;
    }
}
