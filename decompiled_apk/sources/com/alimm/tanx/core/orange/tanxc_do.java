package com.alimm.tanx.core.orange;

import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.orange.bean.OrangeBean;
import com.alimm.tanx.core.request.C;
import java.util.HashMap;

/* loaded from: classes.dex */
public class tanxc_do {
    public void tanxc_do(NetWorkCallBack netWorkCallBack) {
        RequestBean build = new RequestBean().setUrl(C.getOrangeUrl()).build();
        build.setOverrideError(true);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        build.setHeads(hashMap);
        NetWorkManager.getInstance().sendHttpGet(build, OrangeBean.class, netWorkCallBack);
    }
}
