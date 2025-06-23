package com.alimm.tanx.core.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alimm.tanx.core.ad.bean.AdInfo;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class tanxc_do {
    public static AdInfo tanxc_do(AdInfo adInfo) {
        if (adInfo != null) {
            try {
                if (adInfo.getStatus() != 0) {
                    if (adInfo.getStatus() == 1) {
                    }
                }
                if (adInfo.getSeatList() != null && adInfo.getSeatList().size() > 0) {
                    for (int i = 0; i < adInfo.getSeatList().size(); i++) {
                        List<String> rawBidList = adInfo.getSeatList().get(i).getRawBidList();
                        ArrayList arrayList = new ArrayList();
                        if (rawBidList != null && rawBidList.size() > 0) {
                            for (int i2 = 0; i2 < rawBidList.size(); i2++) {
                                BidInfo bidInfo = (BidInfo) JSON.parseObject(rawBidList.get(i2), BidInfo.class);
                                bidInfo.setRawJsonStr(tanxc_do(rawBidList.get(i2)));
                                arrayList.add(bidInfo);
                            }
                        }
                        adInfo.getSeatList().get(i).setBidList(arrayList);
                    }
                }
            } catch (Exception e) {
                LogUtils.e(e);
            }
        }
        return adInfo;
    }

    private static String tanxc_do(String str) {
        try {
            JSONObject parseObject = JSON.parseObject(str);
            parseObject.remove("impression_tracking_url");
            parseObject.remove("click_tracking_url");
            parseObject.remove("winnotice_url");
            return JSON.toJSONString(parseObject);
        } catch (Exception e) {
            LogUtils.e(e);
            return str;
        }
    }
}
