package com.alimm.tanx.core.ad.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Collections;
import java.util.List;

public class SeatInfo extends BaseBean {
    @JSONField(serialize = false)
    private List<BidInfo> bidList;
    @JSONField(name = "id")
    private int id;
    @JSONField(name = "ad")
    private List<String> rawBidList;

    public List<BidInfo> getBidList() {
        return Collections.synchronizedList(this.bidList);
    }

    public int getId() {
        return this.id;
    }

    public List<String> getRawBidList() {
        return this.rawBidList;
    }

    public SeatInfo setBidList(List<BidInfo> list) {
        this.bidList = list;
        return this;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setRawBidList(List<String> list) {
        this.rawBidList = list;
    }
}
