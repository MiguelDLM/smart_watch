package com.bytedance.pangle.log;

import androidx.annotation.Keep;
import org.json.JSONObject;

@Keep
/* loaded from: classes8.dex */
public interface IZeusReporter {
    public static final String ZEUS_STAGE_COMMON = "zeus_stage_common";
    public static final String ZEUS_STAGE_CONTENT_PROVIDER = "zeus_stage_content_provider";
    public static final String ZEUS_STAGE_DEX_OPT = "zeus_stage_dex_opt";
    public static final String ZEUS_STAGE_ERROR = "zeus_stage_error";
    public static final String ZEUS_STAGE_FLIPPED = "zeus_stage_flipped";
    public static final String ZEUS_STAGE_PLUGIN_INSTALL = "zeus_stage_plugin_install";
    public static final String ZEUS_STAGE_SERVER_MANAGER = "zeus_stage_plugin";
    public static final String ZEUS_STAGE_WEB = "zeus_stage_web";

    void report(String str, JSONObject jSONObject);

    void saveRecord(String str, String str2);
}
