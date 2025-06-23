package com.alimm.tanx.core.ad.event.track.tanxc_do;

import android.text.TextUtils;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.List;

public class tanxc_do {
    private static tanxc_do tanxc_do;

    public static tanxc_do tanxc_do() {
        if (tanxc_do == null) {
            synchronized (tanxc_do.class) {
                try {
                    if (tanxc_do == null) {
                        tanxc_do = new tanxc_do();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return tanxc_do;
    }

    public void tanxc_do(List<ITanxAd> list) {
        if (list != null) {
            for (ITanxAd next : list) {
                if (next != null) {
                    try {
                        if (next.getBidInfo() != null) {
                            if (!TextUtils.isEmpty(next.getBidInfo().getWinNoticeUrl())) {
                                RequestBean build = new RequestBean().setUrl(next.getBidInfo().getWinNoticeUrl()).build();
                                build.setOverrideError(true);
                                NetWorkManager.getInstance().sendHttpGet(build, Object.class, false, false, new NetWorkCallBack() {
                                    public void error(int i, String str, String str2) {
                                        LogUtils.d("BiddingUpload", str2);
                                    }

                                    public void succ(Object obj) {
                                        LogUtils.d("BiddingUpload", obj.toString());
                                    }
                                });
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        LogUtils.e("BiddingUpload", e);
                        TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "BiddingUpload", LogUtils.getStackTraceMessage(e), "");
                    }
                }
                LogUtils.d("BiddingUpload", "uploadBidding iTanxAd.getBidInfo().getWinNoticeUrl() 为空");
                return;
            }
        }
    }
}
