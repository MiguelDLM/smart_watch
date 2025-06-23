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

/* loaded from: classes.dex */
public class tanxc_do {
    private static tanxc_do tanxc_do;

    public static tanxc_do tanxc_do() {
        if (tanxc_do == null) {
            synchronized (tanxc_do.class) {
                try {
                    if (tanxc_do == null) {
                        tanxc_do = new tanxc_do();
                    }
                } finally {
                }
            }
        }
        return tanxc_do;
    }

    public void tanxc_do(List<ITanxAd> list) {
        if (list != null) {
            for (ITanxAd iTanxAd : list) {
                if (iTanxAd != null) {
                    try {
                    } catch (Exception e) {
                        e.printStackTrace();
                        LogUtils.e("BiddingUpload", e);
                        TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "BiddingUpload", LogUtils.getStackTraceMessage(e), "");
                    }
                    if (iTanxAd.getBidInfo() != null && !TextUtils.isEmpty(iTanxAd.getBidInfo().getWinNoticeUrl())) {
                        RequestBean build = new RequestBean().setUrl(iTanxAd.getBidInfo().getWinNoticeUrl()).build();
                        build.setOverrideError(true);
                        NetWorkManager.getInstance().sendHttpGet(build, Object.class, false, false, new NetWorkCallBack() { // from class: com.alimm.tanx.core.ad.event.track.tanxc_do.tanxc_do.1
                            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                            public void error(int i, String str, String str2) {
                                LogUtils.d("BiddingUpload", str2);
                            }

                            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                            public void succ(Object obj) {
                                LogUtils.d("BiddingUpload", obj.toString());
                            }
                        });
                    }
                }
                LogUtils.d("BiddingUpload", "uploadBidding iTanxAd.getBidInfo().getWinNoticeUrl() 为空");
                return;
            }
        }
    }
}
