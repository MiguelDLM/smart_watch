package com.baidu.navisdk.comapi;

import com.baidu.navisdk.framework.b;
import com.baidu.navisdk.util.common.LogUtil;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {
    public static void a(com.baidu.navisdk.framework.interfaces.opendatasturct.a aVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNEventDispatchControl", "sendLocMatchResultForVDR result:" + aVar.toString());
        }
        b.a(aVar);
    }

    public static void a(com.baidu.navisdk.framework.interfaces.opendatasturct.b bVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNEventDispatchControl", "sendVmsrResult result:" + bVar.f6816a);
        }
        b.a(bVar);
    }

    public static void a(JSONObject jSONObject) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNEventDispatchControl", "sendNaviExtraInfoToLocSDK: " + jSONObject);
        }
        b.a(jSONObject);
    }
}
