package com.facebook.appevents.codeless.internal;

import OXOo.OOXIXo;

/* loaded from: classes8.dex */
public final class Constants {

    @OOXIXo
    public static final String APP_INDEXING = "app_indexing";

    @OOXIXo
    public static final String APP_INDEXING_ENABLED = "is_app_indexing_enabled";
    public static final int APP_INDEXING_SCHEDULE_INTERVAL_MS = 1000;

    @OOXIXo
    public static final String BUTTON_SAMPLING = "button_sampling";

    @OOXIXo
    public static final String DEVICE_SESSION_ID = "device_session_id";

    @OOXIXo
    public static final String EVENT_MAPPING_PATH_TYPE_KEY = "path_type";

    @OOXIXo
    public static final String EXTINFO = "extinfo";

    @OOXIXo
    public static final Constants INSTANCE = new Constants();

    @OOXIXo
    public static final String IS_CODELESS_EVENT_KEY = "_is_fb_codeless";
    public static final int MAX_TREE_DEPTH = 25;

    @OOXIXo
    public static final String PATH_TYPE_ABSOLUTE = "absolute";

    @OOXIXo
    public static final String PATH_TYPE_RELATIVE = "relative";

    @OOXIXo
    public static final String PLATFORM = "android";

    private Constants() {
    }
}
