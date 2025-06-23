package com.baidu.tts.tools;

import android.content.Context;
import com.baidu.android.common.util.CommonParam;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;

/* loaded from: classes8.dex */
public class GetCUID {
    public static String getCUID(Context context) {
        String cuid = CommonParam.getCUID(context);
        LoggerProxy.d("Device", "cuid=" + cuid);
        return cuid;
    }
}
