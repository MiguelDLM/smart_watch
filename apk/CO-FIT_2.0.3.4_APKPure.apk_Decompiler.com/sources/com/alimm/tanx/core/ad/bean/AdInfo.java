package com.alimm.tanx.core.ad.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

public class AdInfo extends BaseBean {
    private String decrypt;
    @JSONField(name = "id")
    private String requestId;
    @JSONField(name = "seat")
    private List<SeatInfo> seatList;
    @JSONField(name = "status")
    private int status;

    public int getAdCount() {
        int i;
        List<SeatInfo> list = this.seatList;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        int i2 = 0;
        for (SeatInfo next : this.seatList) {
            if (next.getBidList() == null) {
                i = 0;
            } else {
                i = next.getBidList().size();
            }
            i2 += i;
        }
        return i2;
    }

    public List<BidInfo> getBidInfoList() {
        List<SeatInfo> list = this.seatList;
        if (list == null || list.size() <= 0 || this.seatList.get(0).getBidList() == null) {
            return null;
        }
        return this.seatList.get(0).getBidList();
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
