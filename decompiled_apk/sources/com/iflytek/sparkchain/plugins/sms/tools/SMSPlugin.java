package com.iflytek.sparkchain.plugins.sms.tools;

import com.iflytek.sparkchain.core.Tools;
import com.iflytek.sparkchain.plugins.base.BasePlugin;
import com.iflytek.sparkchain.plugins.base.BaseTool;

/* loaded from: classes10.dex */
public class SMSPlugin extends BasePlugin {
    public static final String SMSTool = "sms_tool";

    public SMSPlugin() {
        this.tools = new Tools(new BaseTool[]{new a()});
    }
}
