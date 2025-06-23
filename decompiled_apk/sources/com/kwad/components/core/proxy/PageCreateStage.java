package com.kwad.components.core.proxy;

/* loaded from: classes11.dex */
public enum PageCreateStage {
    START_LAUNCH("start_launch"),
    END_LAUNCH("end_launch"),
    START_ON_PRE_CREATE("start_on_pre_create"),
    END_ON_PRE_CREATE("end_on_pre_create"),
    END_CHILD_ON_PRE_CREATE("end_child_on_pre_create"),
    START_ON_CREATE("start_on_create"),
    END_ON_CREATE("end_on_create"),
    START_CHECK_INTENT("start_check_intent"),
    START_SET_CONTENT_VIEW("start_set_content_view"),
    START_INIT_DATA("start_init_data"),
    START_INIT_VIEW("start_init_view"),
    ERROR_START_ACTIVITY("error_start_activity"),
    END_INIT_VIEW("end_init_view"),
    ERROR_SDK_NOT_INIT("error_not_init"),
    ERROR_CHECK_INTENT("error_check_data"),
    ERROR_CAUGHT_EXCEPTION("error_caught_exception");

    private final String stage;

    PageCreateStage(String str) {
        this.stage = str;
    }

    public final String getStage() {
        return this.stage;
    }
}
