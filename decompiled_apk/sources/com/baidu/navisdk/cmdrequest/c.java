package com.baidu.navisdk.cmdrequest;

import com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralFunc;
import com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpPostDataFunc;
import com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpPostFunc;
import com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc;

/* loaded from: classes7.dex */
public interface c {

    @d(CmdGeneralFunc.class)
    public static final String K_COMMAND_KEY_GENERAL_FUNC = "cmd.general.func";

    @d(CmdGeneralHttpPostDataFunc.class)
    public static final String K_COMMAND_KEY_GENERAL_HTTPPOST_DATA_FUNC = "cmd.general.http.post.data.func";

    @d(CmdGeneralHttpPostFunc.class)
    public static final String K_COMMAND_KEY_GENERAL_HTTPPOST_FUNC = "cmd.general.http.post.func";

    @d(CmdGeneralHttpRequestFunc.class)
    public static final String K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC = "cmd.general.httprequest.func";
}
