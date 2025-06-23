package com.alimm.tanx.core.ad.event.track.expose;

import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.utils.LogUtils;

public class tanxc_do implements IExposer {
    public void onExpose(String str, final String str2, final ExposeCallback exposeCallback) {
        try {
            RequestBean build = new RequestBean().setUrl(str2).build();
            build.setOverrideError(true);
            exposeCallback.send(str2);
            NetWorkManager.getInstance().sendHttpGet(build, Object.class, false, false, new NetWorkCallBack() {
                public void error(int i, String str, String str2) {
                    LogUtils.d("DefaultExposer", str2);
                    LogUtils.d("DefaultExposer", str2);
                    ExposeCallback exposeCallback = exposeCallback;
                    if (exposeCallback != null) {
                        exposeCallback.onFail(i, str2, str2);
                    }
                }

                public void succ(Object obj) {
                    LogUtils.d("DefaultExposer", JSON.toJSONString(obj));
                    ExposeCallback exposeCallback = exposeCallback;
                    if (exposeCallback != null) {
                        exposeCallback.onSucceed(200, str2);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.d("DefaultExposer", str2);
            if (exposeCallback != null) {
                exposeCallback.onFail(UtErrorCode.CRASH_ERROR.getIntCode(), LogUtils.getStackTraceMessage(e), str2);
            }
        }
    }
}
