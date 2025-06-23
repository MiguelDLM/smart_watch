package com.alimm.tanx.core.ad.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

/* loaded from: classes.dex */
public class AdInfo extends BaseBean {
    private String decrypt;

    @JSONField(name = "id")
    private String requestId;

    @JSONField(name = "seat")
    private List<SeatInfo> seatList;

    @JSONField(name = "status")
    private int status;

    public int getAdCount() {
        int size;
        List<SeatInfo> list = this.seatList;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        int i = 0;
        for (SeatInfo seatInfo : this.seatList) {
            if (seatInfo.getBidList() == null) {
                size = 0;
            } else {
                size = seatInfo.getBidList().size();
            }
            i += size;
        }
        return i;
    }

    public List<BidInfo> getBidInfoList() {
        List<SeatInfo> list = this.seatList;
        if (list != null && list.size() > 0 && this.seatList.get(0).getBidList() != null) {
            return this.seatList.get(0).getBidList();
        }
        return null;
    }

    public String getDecrypt() {
        return this.decrypt;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public List<SeatInfo> getSeatList() {
        return this.seatList;
    }

    public int getStatus() {
        return this.status;
    }

    public void setDecrypt(String str) {
        this.decrypt = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setSeatList(List<SeatInfo> list) {
        this.seatList = list;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
